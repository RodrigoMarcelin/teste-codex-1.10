class CNPJ(value: String) {
    private val value: String = value
    private var validate : Boolean = false
    init {
        if (isValidCNPJ(value)) {
            validate = true
        }
    }

    companion object {

        fun isValidCNPJ(cnpj: String): Boolean {
            val cleanedCNPJ = cnpj.replace("[^\\d]".toRegex(), "")
            if (cleanedCNPJ.length != 14) {
                return false
            }
            return checksumDigit(cleanedCNPJ)
        }

        private fun checksumDigit(cnpj: String): Boolean {
            val arrayValidateFirstDigit = intArrayOf(6 ,7 ,8 ,9 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9)
            val arrayValidateSecondDigit = intArrayOf(5 ,6 ,7 ,8 ,9 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9)

            val firstCheckDigit = calculateDigit(cnpj.substring(0, 12), arrayValidateFirstDigit)
            val secondCheckDigit = calculateDigit(cnpj.substring(0, 13), arrayValidateSecondDigit)

            if (cnpj[12].digitToInt() == firstCheckDigit && cnpj[13].digitToInt() == secondCheckDigit){
                return true
            } else {
                return false
            }
        }

        private fun calculateDigit(cnpj: String, arrayValidator: IntArray): Int {
            var sumTotal = 0
            for (indice in cnpj.indices) {
                sumTotal += (cnpj[indice].toString().toInt() * arrayValidator[indice])
            }
            var checkDigit = sumTotal % 11
            if (checkDigit == 10) {
                checkDigit = 0
            }

            return checkDigit
        }

        fun formatCNPJ(cnpj: String): String {
            val cleanedCNPJ = cnpj.replace("[^\\d]".toRegex(), "")
            return "${cleanedCNPJ.substring(0, 2)}.${cleanedCNPJ.substring(2, 5)}.${cleanedCNPJ.substring(5, 8)}/${cleanedCNPJ.substring(8, 12)}-${cleanedCNPJ.substring(12)}"
        }
    }

    override fun toString(): String {
        if (validate) {
            return "O CNPJ ${formatCNPJ(value)} é valido"
        } else {
            return "CNPJ inválido"
        }
    }
}