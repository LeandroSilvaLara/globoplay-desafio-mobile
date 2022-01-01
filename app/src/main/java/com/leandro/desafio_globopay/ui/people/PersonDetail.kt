package com.leandro.desafio_globopay.ui.people

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.leandro.desafio_globopay.network.Api
import com.leandro.desafio_globopay.network.compose.NetworkImage
import com.leandro.desafio_globopay.ui.custom.AppBarWithArrow
import com.leandro.desafio_globopay.ui.theme.background
import com.leandro.desafio_globopay.ui.theme.background800
import com.leandro.desafio_globopay.ui.theme.purple200
import com.skydoves.whatif.whatIfNotNullOrEmpty


@Composable
fun PersonDetailScreen(
    personId: Long,
    viewModel: PersonDetailViewModel,
    pressOnBack: () -> Unit
) {
    val person by viewModel.personFlow.collectAsState(initial = null)

    LaunchedEffect(key1 = personId) {
        viewModel.fetchPersonDetailsById(personId)
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(background)
    ) {

        AppBarWithArrow(person?.name, pressOnBack)

        Profile(viewModel)

        KnownAs(viewModel)

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun Profile(
    viewModel: PersonDetailViewModel
) {
    val person by viewModel.personFlow.collectAsState(initial = null)
    val personDetail by viewModel.personDetailFlow.collectAsState(initial = null)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = background800,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Column {

            Spacer(modifier = Modifier.height(20.dp))

            NetworkImage(
                networkUrl = Api.getPosterPath(person?.profile_path),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .size(110.dp)
            )

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = person?.name ?: "",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = personDetail?.biography ?: "",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun KnownAs(
    viewModel: PersonDetailViewModel
) {
    val personDetail by viewModel.personDetailFlow.collectAsState(initial = null)

    personDetail?.also_known_as?.whatIfNotNullOrEmpty {

        Spacer(modifier = Modifier.height(15.dp))

        FlowRow {

            it.forEach {

                Keyword(it)
            }
        }
    }
}

@Composable
private fun Keyword(keyword: String) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        elevation = 8.dp,
        color = purple200,
        modifier = Modifier.padding(8.dp)
    ) {

        Text(
            text = keyword,
            style = MaterialTheme.typography.body1,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}
