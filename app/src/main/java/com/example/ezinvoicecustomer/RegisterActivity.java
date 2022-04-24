package com.example.ezinvoicecustomer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputFirstName, inputLastName, inputEmail, inputPassword;
    private String fullName;
    private Button btnSignIn, btnSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        inputFirstName = findViewById(R.id.firstName);
        inputLastName = findViewById(R.id.lastName);
        btnSignUp = findViewById(R.id.sign_up_button);
        btnSignIn = findViewById(R.id.sign_in_button);
        progressBar = findViewById(R.id.progressBar);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String firstname = inputFirstName.getText().toString().trim();
                String lastname = inputLastName.getText().toString().trim();
                fullName = firstname + " " + lastname;

                if (TextUtils.isEmpty(firstname)) {
                    Toast.makeText(getApplicationContext(), "Enter your first name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(lastname)) {
                    Toast.makeText(getApplicationContext(), "Enter your last name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter 8+ characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this, "Account created, logging in", Toast.LENGTH_SHORT).show();

                                FirebaseUser user = auth.getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(fullName)
                                        .build();
                                user.updateProfile(profileUpdates);

                                Log.d("Cloud Firestore", "beginning write attempt");
                                Map<String, Object> newUser = new HashMap<>();
//                                newuser.put();
                                newUser.put("customerName", fullName);
                                newUser.put("customerEmail", user.getEmail());
//                                String data = user.getDisplayName() + ", " + user.getEmail();
                                FirebaseFirestore db = FirebaseFirestore.getInstance();
                                db.collection("customers").document(user.getUid()).set(newUser)
//                                db.collection("users").add(newUser)
//                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                        @Override
//                                        public void onSuccess(DocumentReference documentReference) {
//                                            Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
//                                        }
//                                    })
                                        .addOnSuccessListener(new OnSuccessListener() {
                                            @Override
                                            public void onSuccess(Object o) {
                                                Log.d("TAG", "DocumentSnapshot added with ID: " + user.getUid());
                                            }

//                                            @Override
//                                            public void onSuccess(DocumentReference documentReference) {
//                                                Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
//                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w("TAG", "Error adding document", e);
                                            }
                                        });

                                Log.d("New user data", String.valueOf(newUser));
                                Log.d("Database", String.valueOf(db));
                                Log.d("Cloud Firestore", "finished write attempt");

                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        progressBar.setVisibility(View.GONE);
//    }
}