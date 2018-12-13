fun renderProductTable(): String {
    return html {
        table {
            tr (color = getTitleColor()) {
                td (color = getCellColor(0, 0)) {
                    text("Product")
                }
                td (color = getCellColor(0, 0)) {
                    text("Price")
                }
                td (color = getCellColor(0, 0)) {
                    text("Popularity")
                }
            }
            val products = getProducts()
            products.forEachIndexed { index, product ->
                tr {
                    td (color = getCellColor(index, 0)) {
                        text(product.description)
                    }
                    td (color = getCellColor(index, 1)) {
                        text(product.price)
                    }
                    td (color = getCellColor(index, 2)) {
                        text(product.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) %2 == 0) "#dce4ff" else "#eff2ff"