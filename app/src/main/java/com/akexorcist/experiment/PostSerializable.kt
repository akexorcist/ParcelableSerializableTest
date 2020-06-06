package com.akexorcist.experiment

import java.io.Serializable

data class PostSerializable(
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
) : Serializable {
    data class Comment(
        var comment: String?,
        var user: String?,
        var date: String?
    ) : Serializable
}