package com.hridoy.androidblog.lazyColumnScrollbar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hridoy.androidblog.lazyColumnScrollbar.compose.LazyColumnScrollbar
import com.hridoy.androidblog.lazyColumnScrollbar.compose.ScrollbarSelectionMode
import com.hridoy.androidblog.ui.theme.AndroidBlogTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnView() {
    val listData = (0..1000).toList()
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
        LazyColumnScrollbar(
            listState,
            selectionMode = ScrollbarSelectionMode.Thumb,
            alwaysShowScrollBar = false,
        ) {
            LazyColumn(
                state = listState,
                reverseLayout = false
            ) {
                    stickyHeader {
                        Surface {
                            Text(
                                text = "HEADER",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }


                items(listData) {
                    Text(
                        text = "Item $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnViewPreview() {
    AndroidBlogTheme {
        LazyColumnView()
    }

}