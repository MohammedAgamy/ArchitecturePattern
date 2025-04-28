package com.example.presentation.ui.main

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.data.model.NoteModel
import com.example.presentation.viewmodel.ModelMVVM
import com.example.trystate.R
import com.example.presentation.ui.Custoum.CustomTextField


@Composable
fun MainUi(modelMVVM: ModelMVVM) {
    val context = LocalContext.current
    val addNoteState by modelMVVM.addNoteState.collectAsState()


    addNoteState.let { not ->
        Text(text = "تم إضافة الملاحظة: ")

    }


    val labelTitle = "Enter Your Title"
    var title by rememberSaveable { mutableStateOf("") }
    var titleError by rememberSaveable { mutableStateOf<String?>(null) }

    Column {
        Spacer(modifier = Modifier.height(60.dp))
        CustomTextField(
            title,
            {
                title = it
                titleError = if (it.length < 3) "Name must be at least 3 characters" else null
            },
            labelTitle,
            titleError,
            R.drawable.ic_launcher_foreground

        )
        Spacer(modifier = Modifier.height(30.dp))

        val labelNote = "Enter Your Note"
        var note by rememberSaveable { mutableStateOf("") }
        var noteError by rememberSaveable { mutableStateOf<String?>(null) }
        CustomTextField(
            note,
            {
                note = it
                noteError = if (it.length < 3) "Name must be at least 3 characters" else null
            },
            labelNote,
            noteError,
            R.drawable.ic_launcher_foreground

        )

        Button(onClick = {
            if (titleError == null && noteError == null && title.isNotEmpty() && note.isNotEmpty()) {
                modelMVVM.addNote(NoteModel(title = title, noteTD = note, id = 3))
                Toast.makeText(context, "تمت إضافة النوت بنجاح ✅", Toast.LENGTH_SHORT).show()
            }


        }) {
            Text("Add Note ")
        }
        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn {
            items(addNoteState) { note ->
                Text(text = "${note.id} - ${note.title}: ${note.noteTD}")
            }
        }
    }
}