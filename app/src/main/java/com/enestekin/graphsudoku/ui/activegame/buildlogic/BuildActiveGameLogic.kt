package com.enestekin.graphsudoku.ui.activegame.buildlogic

import android.content.Context
import com.enestekin.graphsudoku.common.ProductionDispatcherProvider
import com.enestekin.graphsudoku.persistence.*
import com.enestekin.graphsudoku.persistence.settingsDataStore
import com.enestekin.graphsudoku.ui.activegame.ActiveGameContainer
import com.enestekin.graphsudoku.ui.activegame.ActiveGameLogic
import com.enestekin.graphsudoku.ui.activegame.ActiveGameViewModel


internal fun buildActiveGameLogic(
    container: ActiveGameContainer,
    viewModel: ActiveGameViewModel,
    context: Context
): ActiveGameLogic {
    return ActiveGameLogic(
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