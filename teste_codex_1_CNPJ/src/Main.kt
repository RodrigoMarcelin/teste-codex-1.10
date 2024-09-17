//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print("Digite o CNPJ: ")
    val cnpjEntry = readLine()
    var cnpj = CNPJ(cnpjEntry.toString())
    println(cnpj)
}