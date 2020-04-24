# Railway Oriented Programming in Kotlin

## What is that?

Railway Oriented Programming (ROP) is a functional programming technique that allows sequential execution of functions, not necessarily synchronous. The key concept is that each function can only accept and return `Container` of either `Success` or `Failure`. `Failure` wraps [Throwable](https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html) type and `Success` can be of any type.

Visual representation of ROP 

![ROP simple](https://user-images.githubusercontent.com/13621271/80095842-e5664800-8568-11ea-8b32-4d50d8885209.png)

Therefore, in the simple scenario each function can go from `Success` to either `Success` or  `Failure` scenario and `Failure` can go to `Failure` scenario.

In the real world, you may want to transform `Failure` to `Success`, not only to `Failure`. This procedure is called `rescue` or `recovery`; the name may wary from language to language.

Visual representation of ROP detailed is 

![ROP simple explained](https://user-images.githubusercontent.com/13621271/80095947-18104080-8569-11ea-8bb2-e98249d379e9.png)

It is important that you can transform from each state to each other state.

## How to use in practice?

This concept is present but not promoted in Kotlin since Kotlin 1.3. The matter of fact [Kotlin KEEP](https://github.com/Kotlin/KEEP/blob/master/proposals/stdlib/result.md#limitations) states that feature may change in the future. At the time of writing this blog post, `Result<T>` is a `Container`-like type which can be used inside generic containers such as `Collection<T>`. 

> `fun capitalize(cities: List<String>): List<Result<String>>`

In the meantime, `Result<T>` can be parameter of functions.

> `fun map(Result<String>): List<String>` 

![so-icon 30x30](https://user-images.githubusercontent.com/13621271/80209059-a223dc00-8631-11ea-9708-c0f0cd4bdbe2.png)

- [Why can't 'kotlin.Result' be used as a return type?](https://stackoverflow.com/questions/52631827/why-cant-kotlin-result-be-used-as-a-return-type)
- [How to allow Result\<T\> to be return type in Kotlin?
](https://stackoverflow.com/questions/61223609/how-to-allow-resultt-to-be-return-type-in-kotlin)

`Result<T>` data-type has [docs]((https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/)) .

## How to apply to existing code?

Example of functions that can have this paradigm and how to write adapters to those functions:

- Single track functions. Functions with no errors and no possible exceptions. See [ComplexNumber]() and [ComplexNumberResult]() examples.

- Dead-end functions. Functions which throw errors. Such as [OutOfMemoryError](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/memleaks002.html) or [StackOverflowError](https://docs.oracle.com/javase/7/docs/api/java/lang/StackOverflowError.html). See [HtmlParser]() and [HtmlParserResult]() examples.


TODO: Add examples of HashMap of HashMaps traversal. Realistic Java example.
https://stackoverflow.com/questions/61409790/how-can-i-model-a-scenario-when-traversal-of-hashmap-of-hashmaps-will-throw-an-s

TODO: Finish examples in here

- Functions that throw exceptions. This is especially useful with IO operations. See [DownloadPage]() examples.

- Supervisory functions. Functions which logs and supervise existing code, not necessarily return the result. See [SentryLogin]() and [SentryLoginResult]() examples.

## How to test ROP code?

TODO: Add examplesx


## What are other languages/frameworks who implement/use ROP?

TODO: Add list and links to existing articles

## How are inspires?

This repo was inspired by:

[![Railway oriented programming: Error handling in functional languages by Scott Wlaschin](https://res.cloudinary.com/marcomontalbano/image/upload/v1587388762/video_to_markdown/images/vimeo--113707214-c05b58ac6eb4c4700831b2b3070cd403.jpg)](https://vimeo.com/113707214 "Railway oriented programming: Error handling in functional languages by Scott Wlaschin")


[![returns](https://raw.githubusercontent.com/dry-python/brand/master/logo/returns.png)](https://github.com/dry-python/returns)

## Acknowledgements

Thank you for all inspires of this blog post. To my colleagues, especially to Thomas Borgen how showed my this technique in Python. Also, thank you Thorsten Heller who supported me and inspired to put in text. Also, to my first and patient listeners Cloudwheel team! 