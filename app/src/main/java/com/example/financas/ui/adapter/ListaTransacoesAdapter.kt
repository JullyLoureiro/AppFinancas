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

class ListaTransacoesAdapter(transacoes: List<Transacao>,
                             context: Context) : BaseAdapter() {
    private val transacoes = transacoes
    private val context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        if(transacao.tipo == TipoTransacao.RECEITA){
             viewCreated.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
             viewCreated.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
        } else {
            viewCreated.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
            viewCreated.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }

        viewCreated.transacao_valor.text = transacao.valor.formataMoedaBrasileira()
        viewCreated.transacao_categoria.text =  transacao.categoria.limitaEmAte(14)
        viewCreated.transacao_data.text = transacao.data.formataDataBrasileiro()

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