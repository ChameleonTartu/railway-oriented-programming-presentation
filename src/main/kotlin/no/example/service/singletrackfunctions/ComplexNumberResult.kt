package no.example.service.singletrackfunctions

/**
 * {@link ComplexNumberResult} is adapter-like class that represents the same interface by ComplexNumber class composition.
 * The difference between current and original class is that here all methods will be of Result<ComplexNumber> type.
 *
 * Side note: In simple scenario like this may seem like an overkill but it how Railway Oriented programming looks on fingers.
 * This technique is adjusted in more complex examples.
 */
class ComplexNumberResult {

    private lateinit var complexNumber: ComplexNumber

    constructor(real: Int, imagine: Int) {
        complexNumber = ComplexNumber(real, imagine)
    }

    fun add(number: ComplexNumber): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.add(number)))
    }

    fun subtract(number: ComplexNumber): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.subtract(number)))
    }

    fun multiply(number: ComplexNumber): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.multiply(number)))
    }

    fun negate(): List<Result<ComplexNumber>> {
        return listOf(Result.success(complexNumber.negate()))
    }
}