//// 11.1 (Вариант 1)
//class Money(val nominal: Int, val count: Int) {
//
//    fun getInfo(): String {
//        return "Купюры номиналом: $nominal руб., Количество: $count шт."
//    }
//
//    fun calculateTotal(): Int {
//        return nominal * count
//    }
//}
//
//// Основная программа (эмуляция ввода из Edit и вывода в Memo)
//fun main() {
//    println("--- Эмуляция ввода из компонентов Edit ---")
//
//    print("Введите номинал купюры (Поле 1): ")
//    val inputNominal = readln().toIntOrNull() ?: 0
//
//    print("Введите количество купюр (Поле 2): ")
//    val inputCount = readln().toIntOrNull() ?: 0
//
//    val moneyObject = Money(inputNominal, inputCount)
//
//    println("\n--- Эмуляция вывода в компонент Memo ---")
//    println(moneyObject.getInfo())
//    println("Результат обработки (Сумма купюр): ${moneyObject.calculateTotal()} руб.")
//}
//

//Задание 11.2 (Вариант 1)
//open class Money(val nominal: Int, val count: Int) {
//
//    fun getInfo(): String {
//        return "Купюры номиналом: $nominal, Количество: $count шт."
//    }
//
//    fun calculateTotal(): Int {
//        return nominal * count
//    }
//}
//
//// Класс-потомок (Наследует Money и добавляет поле курса евро к гривне)
//class MoneyInEuro(
//    nominal: Int,
//    count: Int,
//    val euroRate: Double
//) : Money(nominal, count) {
//
//    fun calculateInEuro(): Double {
//        val totalAmount = calculateTotal()
//        return if (euroRate > 0) totalAmount / euroRate else 0.0
//    }
//}
//
//// Демонстрация работы (ввод и вывод информации)
//fun main() {
//    println("=== РАБОТА С КЛАССОМ-РОДИТЕЛЕМ ===")
//    print("Введите номинал купюры: ")
//    val nominal = readln().toIntOrNull() ?: 0
//    print("Введите количество купюр: ")
//    val count = readln().toIntOrNull() ?: 0
//
//    val baseMoney = Money(nominal, count)
//    println("\nИнформация о родителе: ${baseMoney.getInfo()}")
//    println("Общая сумма в базовой валюте: ${baseMoney.calculateTotal()}")
//
//    println("\n=== РАБОТА С КЛАССОМ-ПОТОМКОМ ===")
//    print("Введите текущий курс евро (стоимость 1 € в гривне, например 46.5): ")
//    val rate = readln().toDoubleOrNull() ?: 1.0
//
//    val euroMoney = MoneyInEuro(nominal, count, rate)
//
//    println("\nИнформация из потомка (родительский метод): ${euroMoney.getInfo()}")
//    println("Дополнительное поле потомка (курс евро): $rate")
//    println("Результат обработки потомка (сумма в Евро): ${String.format("%.2Fi", euroMoney.calculateInEuro())} €")
//}

//Задание 11.3 (Вариант 1)
open class Computer(val name: String, val frequency: Double, val ram: Int) {

    open fun getQuality(): Double {
        return 0.1 * frequency + ram
    }

    open fun printInfo() {
        println("ПК '$name' -> Качество Q = ${getQuality()}")
    }
}

class AdvancedComputer(name: String, frequency: Double, ram: Int, val hdd: Int)
    : Computer(name, frequency, ram) {

    // Переопределение качества Qp = Q + 0.5 * P
    override fun getQuality(): Double {
        return super.getQuality() + 0.5 * hdd
    }

    override fun printInfo() {
        println("ПК '$name' с HDD $hdd Гб -> Качество Qp = ${getQuality()}")
    }
}

fun main() {

    val comp1 = Computer("Intel i3", 2400.0, 4096)
    comp1.printInfo()

    val comp2 = AdvancedComputer("Intel i5", 3200.0, 8192, 500)
    comp2.printInfo()
}
