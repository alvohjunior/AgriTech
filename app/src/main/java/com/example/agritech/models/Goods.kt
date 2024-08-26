package com.example.agritech.models

class Goods {
    var imageUrl: String = ""
    var name: String = ""
    var description: String = ""
    var quantity: String = ""
    var price: String = ""
    var id: String=""
    constructor(
        imageUri: String,
        name: String,
        description: String,
        quantity: String,
        price: String,
        id: String,){
        this.imageUrl= imageUrl
        this.name=name
        this.description=description
        this.quantity=quantity
        this.price=price
        this.id=id
    }
    constructor()
}