package no.example.service.singletrackfunctions

/**
 * {@link ComplexNumberResult} is adapter-like class that represents the same interface by ComplexNumber class composition.
 * The difference between current and original class is that here all methods will be of Result<ComplexNumber> type.
 *
 * Side note: In simple scenario like this may seem like an overkill but it how Railway Oriented programming looks on fingers.
 * This technique is adjusted in more complex examples.
 */
data class ComplexNumberResult(private val complexNumber: ComplexNumber) {

    constructor(real: Int, imagine: Int): this(ComplexNumber(real, imagine))

    fun add(number: ComplexNumberResult): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.add(number.complexNumber)))
    }

    fun subtract(number: ComplexNumberResult): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.subtract(number.complexNumber)))
    }

    fun multiply(number: ComplexNumberResult): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.multiply(number.complexNumber)))
    }

    fun negate(): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.negate()))
    }
}