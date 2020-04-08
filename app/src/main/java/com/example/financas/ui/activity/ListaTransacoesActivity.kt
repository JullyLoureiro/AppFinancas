package com.example.financas.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.financas.R
import com.example.financas.model.TipoTransacao
import com.example.financas.model.Transacao
import com.example.financas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes = listOf(
            Transacao(valor = BigDecimal(50), tipo = TipoTransacao.DESPESA),
            Transacao(valor = BigDecimal(80), tipo = TipoTransacao.RECEITA),
            Transacao(valor = BigDecimal(30), tipo = TipoTransacao.RECEITA)
        )
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }
}