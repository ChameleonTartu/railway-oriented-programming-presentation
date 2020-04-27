package no.example.singletrackfunctions

import no.example.service.singletrackfunctions.ComplexNumber
import no.example.service.singletrackfunctions.ComplexNumberResult
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ComplexNumberTest {

    private val complexNumber = ComplexNumber(1, 1)
    private val complexNumberResult = ComplexNumberResult(1, 1)

    @Test
    fun `Add complex numbers`() {
        val number = complexNumber.add(complexNumber)
        assertEquals(number, ComplexNumber(2, 2))
    }

    @Test
    fun `Add complex numbers (ROP style)`() {
        val number = complexNumberResult.add(complexNumberResult)
        assertEquals(number.first().getOrNull()!!, ComplexNumber(2, 2))
    }

    @Test
    fun `Subtract complex numbers`() {
        val number = complexNumber.subtract(ComplexNumber.ZERO)
        assertEquals(number, complexNumber)
    }

    @Test
    fun `Subtract complex numbers (ROP style)`() {
        val number = complexNumberResult.subtract(ComplexNumberResult(ComplexNumber.ZERO))
        assertEquals(number.first().getOrNull()!!, complexNumber)
    }

    @Test
    fun `Multiply complex numbers`() {
        val number = complexNumber.multiply(ComplexNumber.ONE)
        assertEquals(number, complexNumber)
    }

    @Test
    fun `Multiply complex numbers (ROP style)`() {
        val number = complexNumberResult.multiply(ComplexNumberResult(ComplexNumber.ONE))
        assertEquals(number.first().getOrNull()!!, complexNumber)
    }

    @Test
    fun `Negate complex number`() {
        assertEquals(complexNumber.negate(), ComplexNumber(-1, -1))
    }

    @Test
    fun `Negate complex number (ROP style)`() {
        assertEquals(complexNumberResult.negate().first().getOrNull()!!, ComplexNumber(-1, -1))
    }
}