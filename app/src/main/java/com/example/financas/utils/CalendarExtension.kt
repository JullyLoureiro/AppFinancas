package com.example.financas.utils

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.formataDataBrasileiro() : String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val formato = SimpleDateFormat(formatoBrasileiro)
    return formato.format(this.time)
}