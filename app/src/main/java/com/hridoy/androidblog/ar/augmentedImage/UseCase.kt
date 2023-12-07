package com.hridoy.androidblog.ar.augmentedImage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hridoy.androidblog.ui.theme.AndroidBlogTheme
import io.github.sceneview.ar.ARScene
import io.github.sceneview.material.destroy
import io.github.sceneview.model.destroy


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AugmentedImageARScreen(onBackPress:()->Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Augmented Image" , style = TextStyle(color = Color.Black)) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBackPress()
                        },
                        modifier = Modifier
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black )
                    }
                },
            )
        },
        content = {
           Box(modifier = Modifier.padding(it)){
               AvApp()
           }
        }
    )
}


@Composable
fun AvApp(
    mainViewModel: MainViewModel = viewModel(),
) {
    val node by mainViewModel.node.collectAsState()

    Box(modifier = Modifier){
        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = node?.let { listOf(it) } ?: emptyList(),
            planeRenderer = true,
            onCreate = {
                it.setupAvConfigurations()
            },
            onFrame = {
                   mainViewModel.renderVideo(it.updatedAugmentedImages)
            }
        )

        Button(onClick = {

//            mainViewModel.avMaterialInstance.destroy()
//            mainViewModel.avModelInstance.destroy()
//            mainViewModel._node.value?.destroy()
//            mainViewModel.mediaPlayer.release()
//            mainViewModel.externalTexture.destroy()

        }) {
            Text(text = "Refresh")
        }
    }


}

@Preview
@Composable
fun AvAppPreview() {
    AndroidBlogTheme() {
        AvApp()
    }
}
