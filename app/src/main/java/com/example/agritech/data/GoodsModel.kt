//package com.example.agritech.data
//
//
//
//
//import android.app.ProgressDialog
//import android.content.Context
//import android.net.Uri
//import android.widget.Toast
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.snapshots.SnapshotStateList
//import androidx.navigation.NavController
//import com.example.agritech.data.AuthViewModel
//import com.example.agritech.models.Goods
//import com.example.agritech.navigation.ROUTE_LOGIN
//import com.example.agritech.navigation.ROUTE_VIEW_GOODS
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener
//import com.google.firebase.storage.FirebaseStorage
//import java.util.UUID
//
//class GoodsViewModel(
//    private val navController: NavController,
//    private val context: Context
//) {
//    private val authRepository: AuthViewModel = AuthViewModel(navController, context)
//
//    init {
//        if (!authRepository.isloggedin()) {
//            navController.navigate(ROUTE_LOGIN)
//        }
//    }
//
//    fun saveGoods(
//        filePath: Uri,
//        name: String,
//        description: String,
//        price: Double
//    ) {
//        val id = System.currentTimeMillis().toString()
//        val storageReference = FirebaseStorage.getInstance().getReference().child("GoodsImages/$id")
//
//        storageReference.putFile(filePath).addOnCompleteListener {
//            if (it.isSuccessful) {
//                storageReference.downloadUrl.addOnSuccessListener { uri ->
//                    val imageUrl = uri.toString()
//                    val goodsData = Goods(imageUrl, name, description, price.toString(), id)
//                    val dbRef = FirebaseDatabase.getInstance().getReference().child("Goods/$id")
//                    dbRef.setValue(goodsData)
//                    Toast.makeText(context, "Goods added successfully", Toast.LENGTH_LONG).show()
//                }
//            } else {
//                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//
//    fun viewGoods(goods: MutableState<Goods>, goodsList: SnapshotStateList<Goods>): SnapshotStateList<Goods> {
//        val ref = FirebaseDatabase.getInstance().getReference().child("Goods")
//
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                goodsList.clear()
//                for (snap in snapshot.children) {
//                    val value = snap.getValue(Goods::class.java)
//                    goods.value = value!!
//                    goodsList.add(value)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//        return goodsList
//    }
//
//    fun updateGoods(
//        filePath: Uri?,
//        name: String,
//        description: String,
//        price: Double,
//        id: String,
//        currentImageUrl: String
//    ) {
//        val databaseReference = FirebaseDatabase.getInstance().getReference("Goods/$id")
//
//        if (filePath != null && filePath != Uri.EMPTY) {
//            val storageReference = FirebaseStorage.getInstance().reference
//            val imageRef = storageReference.child("GoodsImages/${UUID.randomUUID()}.jpg")
//
//            imageRef.putFile(filePath)
//                .addOnSuccessListener {
//                    imageRef.downloadUrl.addOnSuccessListener { uri ->
//                        val imageUrl = uri.toString()
//                        val updatedGoods = Goods(imageUrl, name, description, price.toString(), id)
//
//                        databaseReference.setValue(updatedGoods)
//                            .addOnCompleteListener { task ->
//                                if (task.isSuccessful) {
//                                    Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
//                                    navController.navigate(ROUTE_VIEW_GOODS)
//                                } else {
//                                    Toast.makeText(context, "Update failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
//                                }
//                            }
//                    }
//                }
//                .addOnFailureListener { exception ->
//                    Toast.makeText(context, "Image upload failed: ${exception.message}", Toast.LENGTH_SHORT).show()
//                }
//        } else {
//            val updatedGoods = Goods(currentImageUrl, name, description, price.toString(), id)
//            databaseReference.setValue(updatedGoods)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
//                        navController.navigate(ROUTE_VIEW_GOODS)
//                    } else {
//                        Toast.makeText(context, "Update failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }
//    }
//
//    fun deleteGoods(id: String) {
//        val progressDialog = ProgressDialog(context).apply {
//            setMessage("Deleting goods...")
//            setCancelable(false)
//            show()
//        }
//
//        val delRef = FirebaseDatabase.getInstance().getReference("Goods/$id")
//
//        delRef.removeValue().addOnCompleteListener { task ->
//            progressDialog.dismiss()
//
//            if (task.isSuccessful) {
//                Toast.makeText(context, "Goods deleted successfully", Toast.LENGTH_SHORT).show()
//                navController.navigate(ROUTE_VIEW_GOODS)
//            } else {
//                Toast.makeText(context, task.exception?.message ?: "Deletion failed", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
//
