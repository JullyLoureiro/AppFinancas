package com.example.financas.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formataMoedaBrasileira() : String{
    val formatoBrasileiro = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatoBrasileiro.format(this).replace("R$", "R$ ")
}