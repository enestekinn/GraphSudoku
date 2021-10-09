package com.enestekin.graphsudoku.ui.activegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.enestekin.graphsudoku.R
import com.enestekin.graphsudoku.common.makeToast
import com.enestekin.graphsudoku.ui.GraphSudokuTheme
import com.enestekin.graphsudoku.ui.activegame.buildlogic.buildActiveGameLogic
import com.enestekin.graphsudoku.ui.newgame.NewGameActivity

class ActiveGameActivity : AppCompatActivity() , ActiveGameContainer{

     private lateinit var   logic: ActiveGameLogic


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ActiveGameViewModel()

        setContent {
            GraphSudokuTheme {
                ActiveGameScreen(
                    onEventHandler = logic::onEvent,
                    viewModel
                )

            }
        }
        logic = buildActiveGameLogic(this,viewModel,application)
    }

    override fun onStart() {
        super.onStart()
        logic.onEvent(ActiveGameEvent.OnStart)
    }

    override fun onStop() {
        super.onStop()
        logic.onEvent(ActiveGameEvent.OnStop)
    }

    override fun showError()  = makeToast(getString(R.string.generic_error))

    override fun onNewGameClick() {
        startActivity(
            Intent(
                this,
                NewGameActivity::class.java
            )
        )
    }
}