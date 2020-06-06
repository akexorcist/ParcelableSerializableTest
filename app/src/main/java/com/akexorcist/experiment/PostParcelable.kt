package com.akexorcist.experiment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostParcelable(
    var title: String?,
    var content: String?,
    var id: String?,
    var date: String?,
    var author: String?,
    var url: String?,
    var readCount: Int,
    var isDraft: Boolean,
    var tags: List<String>?,
    var comments: List<Comment>?
) : Parcelable {
    @Parcelize
    data class Comment(
        var comment: String?,
        var user: String?,
        var date: String?
    ) : Parcelable
}