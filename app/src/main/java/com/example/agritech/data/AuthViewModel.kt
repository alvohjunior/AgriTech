package com.example.agritech.data

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.agritech.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthViewModel(var navController: NavController,
                    var context: Context) {
    var mAuth: FirebaseAuth
    init {
        mAuth= FirebaseAuth.getInstance()
    }
    @SuppressLint("RestrictedApi")
    fun signup(
        firstName: String, lastName: String,
        emailAddress: String, password: String, selectedRole: String
    ){
        if (firstName.isBlank() || lastName.isBlank()
            || emailAddress.isBlank() || password.isBlank()){
            Toast.makeText(context,"Please fill all the fields",
                Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(emailAddress,password)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        val userdata= com.example.agritech.models.User(
                            firstName, lastName,
                            emailAddress, password, mAuth.currentUser!!.uid
                        )
                        val regRef = FirebaseDatabase.getInstance().getReference()
                            .child("Users/"+mAuth.currentUser!!.uid)
                        regRef.setValue(userdata).addOnCompleteListener{
                            if (it.isSuccessful){
                                Toast.makeText(context,"Successfully Registered",
                                    Toast.LENGTH_LONG).show()



                            }else{
                                Toast.makeText(context,"${it.exception!!.message}",
                                    Toast.LENGTH_LONG).show()
                            }
                        }

                    }else
                    {
                        navController.navigate(ROUTE_LOGIN)
                    }
                }
        }
    }
    fun login (emailAddress: String, password: String, function: () -> Unit){
        mAuth.signInWithEmailAndPassword(emailAddress,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"Successfully logged in",
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"${it.exception!!.message}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }
}