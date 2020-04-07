package com.example.financas.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.financas.R
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
            Transacao(BigDecimal(50),"Compras", Calendar.getInstance()),
            Transacao(BigDecimal(80),"Vendas", Calendar.getInstance())
        )
        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, transacoes)
        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes, this))
    }
}