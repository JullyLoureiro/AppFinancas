package com.example.financas.utils


fun String.limitaEmAte(caracteres: Int) : String {
    return if(this.length > caracteres) "${this.substring(0, 14)}..."
    else this
}