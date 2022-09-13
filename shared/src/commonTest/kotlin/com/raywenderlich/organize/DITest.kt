package com.raywenderlich.organize

import org.koin.core.context.stopKoin
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules
import kotlin.test.AfterTest
import kotlin.test.Test

class DITest {
  @Test
  fun testAllModules() {
    koinApplication {
      modules(
        Modules.core,
        Modules.repositories,
        Modules.viewModels,
      )
    }.checkModules()
  }

  @AfterTest
  fun tearDown() {
    stopKoin()
  }
}
