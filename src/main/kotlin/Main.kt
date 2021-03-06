import java.util.*

var UNIQUE_ID: Int = 1
val id = 0
val comment = Comments(1, canPost = true, groupsCanPost = true, canClose = false, canOpen = false)
val copyright = Copyright(1, "www.wiki.ru", "Википедия", "сайт")
val repost = Reposts(2, true)
val view = Views(1)

fun main() {

    val post = Post(
        id,
        ownerId = 2,
        fromId = 3,
        createdBy = 4,
        date = 20220503,
        text = "Всем привет",
        replyOwnerId = 5,
        replyPostId = 6,
        friendsOnly = true,
        comments = comment,
        copyright = copyright,
        reposts = repost,
        views = view,
        postType = "post",
        signerId = 11,
        likes = 20,
        canPin = true,
        markedAsAds = false,
        isPinned = true,
        canDelete = false,
        canEdit = true,
        donut = 1,
        isFavorite = true,
        postponedId = 55
    )
    val post1 = Post(
        id,
        ownerId = 22,
        fromId = 32,
        createdBy = 43,
        date = 20220504,
        text = "Всем привет",
        replyOwnerId = 51,
        replyPostId = 61,
        friendsOnly = true,
        comments = comment,
        copyright = copyright,
        reposts = repost,
        views = view,
        postType = "post",
        signerId = 11,
        likes = 20,
        canPin = true,
        markedAsAds = false,
        isPinned = true,
        canDelete = false,
        canEdit = true,
        donut = 1,
        isFavorite = true,
        postponedId = 55
    )
    val post2 = Post(
        id,
        ownerId = 22,
        fromId = 32,
        createdBy = 43,
        date = 20220504,
        text = "Всем привет",
        replyOwnerId = 51,
        replyPostId = 61,
        friendsOnly = true,
        comments = comment,
        copyright = copyright,
        reposts = repost,
        views = view,
        postType = "post",
        signerId = 11,
        likes = 20,
        canPin = true,
        markedAsAds = false,
        isPinned = true,
        canDelete = false,
        canEdit = true,
        donut = 1,
        isFavorite = true,
        postponedId = 55
    )
    WallService.add(post)
    WallService.add(post1)
    WallService.add(post2)
    WallService.update(post2)
    WallService.update(Post(id = 0,
        ownerId = 30,
        fromId = 32,
        createdBy = 43,
        date = 20220504,
        text = "Всем привет",
        replyOwnerId = 51,
        replyPostId = 61,
        friendsOnly = true,
        comments = comment,
        copyright = copyright,
        reposts = repost,
        views = view,
        postType = "post",
        signerId = 11,
        likes = 20,
        canPin = true,
        markedAsAds = false,
        isPinned = true,
        canDelete = false,
        canEdit = true,
        donut = 1,
        isFavorite = true,
        postponedId = 55))

    for (post in WallService.posts) {
        println(post)
    }

    println(WallService.update(Post(id = 0,
        ownerId = 40,
        fromId = 32,
        createdBy = 43,
        date = 20220506,
        text = "Всем привет",
        replyOwnerId = 51,
        replyPostId = 61,
        friendsOnly = true,
        comments = comment,
        copyright = copyright,
        reposts = repost,
        views = view,
        postType = "post",
        signerId = 11,
        likes = 20,
        canPin = true,
        markedAsAds = false,
        isPinned = true,
        canDelete = false,
        canEdit = true,
        donut = 1,
        isFavorite = true,
        postponedId = 55)))

    for (post in WallService.posts) {
        println(post)
    }
}

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Int,
    val reposts: Reposts,
    val views: Views,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Any,
    val postponedId: Int,
)

object WallService {
    var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post.copy(id = UNIQUE_ID++)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post.copy(ownerId = item.ownerId, date = item.date)
                return true
            }
        }
        return false
    }
}

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean,
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String,
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean,
)

data class Views(
    val count: Int,
)




