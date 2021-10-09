package com.enestekin.graphsudoku.ui.newgame.buildlogic

import android.content.Context
import com.enestekin.graphsudoku.common.ProductionDispatcherProvider
import com.enestekin.graphsudoku.persistence.*
import com.enestekin.graphsudoku.ui.newgame.NewGameContainer
import com.enestekin.graphsudoku.ui.newgame.NewGameLogic
import com.enestekin.graphsudoku.ui.newgame.NewGameViewModel

internal fun buildNewGameLogic(
    container: NewGameContainer,
    viewModel: NewGameViewModel,
    context: Context
): NewGameLogic {
    return NewGameLogic(
        container,
        viewModel,
        GameRepositoryImpl(
            LocalGameStorageImpl(context.filesDir.path),
            LocalSettingsStorageImpl(context.settingsDataStore)
        ),
        LocalStatisticsStorageImpl(
            context.statsDataStore
        ),
        ProductionDispatcherProvider
    )
}