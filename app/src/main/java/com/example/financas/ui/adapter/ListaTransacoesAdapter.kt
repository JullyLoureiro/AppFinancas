package com.example.financas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.financas.R
import com.example.financas.model.TipoTransacao
import com.example.financas.model.Transacao
import com.example.financas.utils.formataDataBrasileiro
import com.example.financas.utils.formataMoedaBrasileira
import com.example.financas.utils.limitaEmAte
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesAdapter(private val transacoes: List<Transacao>,
                             private val context: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        setaReceitaDespesa(transacao, viewCreated)
        setaValor(viewCreated, transacao)
        setaCategoria(viewCreated, transacao)
        setaData(viewCreated, transacao)

        return viewCreated
    }

    private fun setaData(viewCreated: View, transacao: Transacao) {
        viewCreated.transacao_data.text = transacao.data.formataDataBrasileiro()
    }

    private fun setaCategoria(viewCreated: View, transacao: Transacao) {
        viewCreated.transacao_categoria.text = transacao.categoria.limitaEmAte(14)
    }

    private fun setaValor(viewCreated: View, transacao: Transacao) {
        viewCreated.transacao_valor.text = transacao.valor.formataMoedaBrasileira()
    }

    private fun setaReceitaDespesa(transacao: Transacao, viewCreated: View) {
        var cor = 0
        var imagem = 0
        if (transacao.tipo == TipoTransacao.RECEITA) {
            cor = ContextCompat.getColor(context, R.color.receita)
            imagem = R.drawable.icone_transacao_item_receita
        } else {
            cor = ContextCompat.getColor(context, R.color.despesa)
            imagem = R.drawable.icone_transacao_item_despesa
        }
        viewCreated.transacao_valor.setTextColor(cor)
        viewCreated.transacao_icone.setBackgroundResource(imagem)
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