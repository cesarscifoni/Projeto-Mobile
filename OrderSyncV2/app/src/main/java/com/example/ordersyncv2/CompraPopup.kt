package com.example.ordersyncv2



import android.content.Context
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ordersyncv2.R

class CompraPopup(private val context: Context) {

    // Método para mostrar o popup
    fun showPopup() {
        // Infla o layout do popup
        val inflater = (context as AppCompatActivity).layoutInflater
        val dialogView = inflater.inflate(R.layout.popup_compra, null)

        // Cria o AlertDialog com o layout customizado
        val builder = AlertDialog.Builder(context)
        builder.setView(dialogView)

        // Referências aos elementos do layout customizado
        val decreaseQtyBtn = dialogView.findViewById<Button>(R.id.decreaseQty)
        val increaseQtyBtn = dialogView.findViewById<Button>(R.id.increaseQty)
        val quantityText = dialogView.findViewById<TextView>(R.id.quantityText)
        val totalPriceText = dialogView.findViewById<TextView>(R.id.totalPriceText)
        val cancelButton = dialogView.findViewById<Button>(R.id.cancelButton)
        val confirmButton = dialogView.findViewById<Button>(R.id.confirmButton)

        // Variáveis de controle
        var quantity = 1
        val unitPrice = 100.00

        // Atualiza o preço total
        fun updateTotalPrice() {
            val totalPrice = quantity * unitPrice
            totalPriceText.text = "Total: R$ %.2f".format(totalPrice)
        }

        // Ações dos botões para alterar a quantidade
        increaseQtyBtn.setOnClickListener {
            quantity++
            quantityText.text = quantity.toString()
            updateTotalPrice()
        }

        decreaseQtyBtn.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityText.text = quantity.toString()
                updateTotalPrice()
            }
        }

        // Cria e exibe o AlertDialog
        val dialog = builder.create()
        dialog.show()

        // Ação do botão "Cancelar"
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        // Ação do botão "Confirmar Compra"
        confirmButton.setOnClickListener {
            // Aqui você pode implementar a lógica para finalizar a compra
            dialog.dismiss()
        }
    }
}
