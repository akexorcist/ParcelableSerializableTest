package com.akexorcist.experiment

import android.os.Bundle
import android.os.Parcel
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val KEY_POST = "Post"
        private const val totalCount = 10000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonParcelable.setOnClickListener { startParcelableTest() }
        buttonSerializable.setOnClickListener { startSerializableTest() }
    }

    private fun startParcelableTest() {
        var totalTimeUsage: Long = 0
        repeat(totalCount) {
            val startTime = System.nanoTime()
            val bundle = Bundle()
            bundle.putParcelable(KEY_POST, createPostParcelable())
            bundle.writeToParcel(Parcel.obtain(), 0)
            val post = bundle.getParcelable(KEY_POST) as PostParcelable?
            val endTime = System.nanoTime()
            totalTimeUsage += endTime - startTime
        }
        Log.i("Parcelable", "Average Time Usage : ${totalTimeUsage / totalCount}")
    }

    private fun startSerializableTest() {
        var totalTimeUsage: Long = 0
        repeat(totalCount) {
            val startTime = System.nanoTime()
            val bundle = Bundle()
            bundle.putSerializable(KEY_POST, createPostSerializable())
            bundle.writeToParcel(Parcel.obtain(), 0)
            val post = bundle.getSerializable(KEY_POST) as PostSerializable?
            val endTime = System.nanoTime()
            totalTimeUsage += endTime - startTime
        }
        Log.i("Serializable", "Average Time Usage : ${totalTimeUsage / totalCount}")
    }

    private fun createPostParcelable() = PostParcelable(
        title = "Title",
        content = "Content",
        id = "75681203",
        date = "01/01/2017",
        url = "Url",
        author = "Author",
        readCount = 7510,
        isDraft = false,
        tags = listOf("Tag 1", "Tag 2", "Tag 3"),
        comments = listOf(
            createCommentParcelable("User 1", "Text 1", "01/01/2017"),
            createCommentParcelable("User 2", "Text 2", "02/01/2017"),
            createCommentParcelable("User 3", "Text 3", "03/01/2017")
        )
    )

    private fun createCommentParcelable(user: String, text: String, date: String) = PostParcelable.Comment(user, text, date)

    private fun createPostSerializable() = PostSerializable(
        title = "Title",
        content = "Content",
        id = "75681203",
        date = "01/01/2017",
        url = "Url",
        author = "Author",
        readCount = 7510,
        isDraft = false,
        tags = listOf("Tag 1", "Tag 2", "Tag 3"),
        comments = listOf(
            createCommentSerializable("User 1", "Text 1", "01/01/2017"),
            createCommentSerializable("User 2", "Text 2", "02/01/2017"),
            createCommentSerializable("User 3", "Text 3", "03/01/2017")
        )
    )

    private fun createCommentSerializable(user: String, text: String, date: String) = PostSerializable.Comment(user, text, date)
}