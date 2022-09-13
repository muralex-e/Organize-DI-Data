package com.raywenderlich.organize

import com.raywenderlich.organize.data.DatabaseHelper
import com.raywenderlich.organize.data.RemindersRepository
import com.raywenderlich.organize.presentation.AboutViewModel
import com.raywenderlich.organize.presentation.RemindersViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module


expect val platformModule: Module

object Modules {
  val core = module {
    factory { Platform() }
    factory { DatabaseHelper(get()) }
  }

  val repositories = module {
    factory { RemindersRepository(get()) }
  }

  val viewModels = module {
    factory { RemindersViewModel(get()) }
    factory { AboutViewModel(get(), get()) }
  }
}

fun initKoin(
  appModule: Module = module { },
  coreModule: Module = Modules.core,
  repositoriesModule: Module = Modules.repositories,
  viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
  modules(
    appModule,
    coreModule,
    repositoriesModule,
    viewModelsModule,
    platformModule,
  )
}