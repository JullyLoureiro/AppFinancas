package com.example.financas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.financas.R
import com.example.financas.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.SimpleDateFormat

class ListaTransacoesAdapter(transacoes: List<Transacao>,
                             context: Context) : BaseAdapter() {
    private val transacoes = transacoes
    private val context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]
        viewCreated.transacao_valor.text = transacao.valor.toString()
        viewCreated.transacao_categoria.text = transacao.categoria

        val formatoBrasileiro = "dd/MM/yyyy"
        val formato = SimpleDateFormat(formatoBrasileiro)
        val dataFormatada = formato.format(transacao.data.time)
        viewCreated.transacao_data.text = dataFormatada

        return viewCreated
    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}