# Railway Oriented Programming in Kotlin

## What is that?

TODO: Finish this section

Railway Oriented Programming (ROP) is a functional programming technique that allows sequential execution of functions, not necessarily synchronous. The key concept is that each function can only accept and return `Container` of either `Success` or `Failure`. `Failure` wraps [Throwable](https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html) type and `Success` can be of any type.

Visual representation of ROP [![ROP](https://miro.medium.com/max/1400/1*pxXvepfiDZlsO2X-KSwFqQ.png)](https://fsharpforfunandprofit.com/rop/)

Therefore, in the simple scenario each function can go from `Success` to either `Success` or  `Failure` scenario and `Failure` can go to `Failure` scenario.

In the real world, you may want to transform `Failure` to `Success`, not only to `Failure`. This procedure is called `rescue` or `recover`; the name may wary from language to language.

Visual representation of extended ROP is  [![ROP extended]()]()

## How to use in practice?

This concept is present but not promoted in Kotlin. The matter of fact in [Kotlin KEEP](https://github.com/Kotlin/KEEP/blob/master/proposals/stdlib/result.md#limitations) it states that feature may change in the future. At the time of writing this blog post, `Result<T>` is `Container`-like type in Kotlin which can be used inside generic containers such as `Collection<T>`. 

> `fun capitalize(cities: List<String>): List<Result<String>>`

In the meantime, `Result<T>` can be parameter of functions.

> `fun map(Result<String>): List<String>` 

[todo add stackoveflow image]
- [Why can't 'kotlin.Result' be used as a return type?](https://stackoverflow.com/questions/52631827/why-cant-kotlin-result-be-used-as-a-return-type)
- [How to allow Result\<T\> to be return type in Kotlin?
](https://stackoverflow.com/questions/61223609/how-to-allow-resultt-to-be-return-type-in-kotlin)

Railway Oriented Programming. Examples in Kotlin 1.3 with [`Result<T>`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/) data-type


## How to apply to existing code?

TODO: Finish this section.


Example of functions that can have this paradigm and how to write adapters to those functions:

[todo add examples of Video listed]

There are several functions which can adopt this technique [todo add example of functions that can adopt it]


## How are inspires?

This repo was inspired by:

[![Railway oriented programming: Error handling in functional languages by Scott Wlaschin](https://res.cloudinary.com/marcomontalbano/image/upload/v1587388762/video_to_markdown/images/vimeo--113707214-c05b58ac6eb4c4700831b2b3070cd403.jpg)](https://vimeo.com/113707214 "Railway oriented programming: Error handling in functional languages by Scott Wlaschin")


[![returns](https://raw.githubusercontent.com/dry-python/brand/master/logo/returns.png)](https://github.com/dry-python/returns)

## Acknowledgements

[todo add links to the resources]