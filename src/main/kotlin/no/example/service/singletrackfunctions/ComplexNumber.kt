package no.example.service.singletrackfunctions


/**
 * {@link ComplexNumber} is a simple implementation of complex numbers that doesn't include division and assumes
 * that real and imaginary parts are always integers.
 */
class ComplexNumber(private val real: Int, private val imagine: Int) {

    fun add(number: ComplexNumber): ComplexNumber {
        return ComplexNumber(
            this.real + number.real,
            this.imagine + number.imagine
        )
    }

    fun multiply(number: ComplexNumber): ComplexNumber {
        return ComplexNumber(
            this.real * number.real + this.imagine * number.imagine,
            this.real * number.imagine + this.imagine * number.real
        )
    }

    fun subtract(number: ComplexNumber): ComplexNumber {
        return this.add(number.negate())
    }

    fun negate(): ComplexNumber {
        return ComplexNumber(-this.real, -this.imagine)
    }
}