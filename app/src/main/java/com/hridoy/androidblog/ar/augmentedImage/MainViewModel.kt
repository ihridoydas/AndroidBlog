package com.hridoy.androidblog.ar.augmentedImage

import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.viewModelScope
import com.google.android.filament.MaterialInstance
import com.google.ar.core.AugmentedImage
import com.google.ar.sceneform.rendering.ExternalTexture
import com.hridoy.androidblog.R
import io.github.sceneview.ar.arcore.isTracking
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.material.MaterialLoader
import io.github.sceneview.material.destroy
import io.github.sceneview.material.setExternalTexture
import io.github.sceneview.math.Rotation
import io.github.sceneview.math.Scale
import io.github.sceneview.model.GLTFLoader
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.model.destroy
import io.github.sceneview.model.model
import io.github.sceneview.node.ModelNode
import io.github.sceneview.renderable.Renderable
import io.github.sceneview.utils.getResourceUri
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val _node = MutableStateFlow<ArNode?>(null)
    val node = _node.asStateFlow()

    lateinit var avMaterialInstance: MaterialInstance
    lateinit var avModelInstance: ModelInstance
    lateinit var externalTexture: ExternalTexture
    lateinit var mediaPlayer: MediaPlayer
   // private lateinit var newUrl: String
    var newRaw by Delegates.notNull<Int>()

    init {
        viewModelScope.launch {
            avModelInstance = GLTFLoader.loadModel(
                context = application,
                gltfFileLocation = application.getResourceUri(R.raw.av_model),
            )!!.instance
            avMaterialInstance = MaterialLoader.loadMaterial(
                context = application,
                lifecycle = dummyLifecycle,
                filamatFileLocation = application.getResourceUri(R.raw.av_material)
            )!!

            externalTexture = ExternalTexture(null)
            avMaterialInstance.setExternalTexture("videoTexture", externalTexture.filamentTexture)

            //From Local
            //If Get From app resourse like (matrix.mp4)
//            mediaPlayer = MediaPlayer.create(getApplication(), R.raw.matrix).apply {
//                setSurface(externalTexture.surface)
//                isLooping = true
//            }

//            //From Url
//            val url = "https://github.com/ihridoydas/ARSceneViewComposeSample/blob/feature/compose_AR_ImageWithDatabase/app/src/main/res/raw/sakura.mp4?raw=true" // your URL here
//            mediaPlayer = MediaPlayer.create(getApplication(), Uri.parse(url)).apply {
//                setSurface(externalTexture.surface)
//                isLooping = true
//            }
        }
    }

    fun renderVideo(augmentedImages: List<AugmentedImage>) {
        if (_node.value != null) return

       // newUrl = " " // your URL here
        newRaw = R.raw.fuji // your URL here

        val trackedAugmentedImage = augmentedImages
            .firstOrNull { it.isTracking } ?: return

        Toast.makeText(getApplication(),"${trackedAugmentedImage.name}",Toast.LENGTH_LONG).show()

        when (trackedAugmentedImage.name) {
            "cute.jpeg" -> {
                newRaw = R.raw.fuji
                // newUrl = "https://github.com/ihridoydas/ARSceneViewComposeSample/blob/feature/compose_AR_ImageWithDatabase/app/src/main/res/raw/sakura.mp4?raw=true" // your URL here
            }
            "cute1.jpeg" -> {
                newRaw = R.raw.sakura
                // newUrl = "https://github.com/ihridoydas/ARSceneViewComposeSample/blob/feature/"
            }
            "cute2.jpeg" -> {
                newRaw = R.raw.matrix
                // newUrl = "https://github.com/ihridoydas/ARSceneViewComposeSample/blob/feature/"
            }
        }

        //From Url
//        val url = "https://github.com/ihridoydas/ARSceneViewComposeSample/blob/feature/compose_AR_ImageWithDatabase/app/src/main/res/raw/sakura.mp4?raw=true" // your URL here
//        mediaPlayer = MediaPlayer.create(getApplication(), Uri.parse(newUrl)).apply {
//            setSurface(externalTexture.surface)
//            isLooping = true
//        }

        //From Local
        //If Get From app resourse like (matrix.mp4)
        mediaPlayer = MediaPlayer.create(getApplication(), newRaw).apply {
            setSurface(externalTexture.surface)
            isLooping = true
        }

        _node.update {
            ArNode().apply {
                applyPoseRotation = true
                anchor = trackedAugmentedImage.let {
                    it.createAnchor(it.centerPose)
                }

                modelScale = Scale(
                    x = trackedAugmentedImage.extentX,
                    z = trackedAugmentedImage.extentZ
                )
                modelRotation = Rotation(x = 180f)

                addChild(ModelNode().apply {
                    setModelInstance(avModelInstance)
                    setMaterial(avMaterialInstance)
                    setReceiveShadows(false)
                    setCastShadows(false)
                    mediaPlayer.start()
                })
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        avMaterialInstance.destroy()
        avModelInstance.destroy()
        _node.value?.destroy()
        mediaPlayer.release()
        externalTexture.destroy()
    }

}

private val dummyLifecycle = object : Lifecycle() {
    override val currentState: State = State.INITIALIZED
    override fun addObserver(observer: LifecycleObserver) = Unit
    override fun removeObserver(observer: LifecycleObserver) = Unit
}
