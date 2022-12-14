package com.kursor.chroniclesofww2.features

sealed class Routes(
    val node: String,
    val parent: Routes? = null
) {

    fun absolutePath(baseUrl: String) = "$baseUrl$relativePath"

    val relativePath: String = (parent?.relativePath ?: "") + "/$node"

    object Battles : Routes("battles") {
        object GET_ALL            : Routes(node = "list",     parent = Battles)
        class  GET_BY_ID(id: Int) : Routes(node = "list/$id", parent = Battles)
        object MY                 : Routes(node = "my",       parent = Battles)
        object SAVE               : Routes(node = "save",     parent = Battles)
        object UPDATE             : Routes(node = "update",   parent = Battles)
        object DELETE             : Routes(node = "delete",   parent = Battles)
    }

    object Users : Routes("users") {
        object GET_ALL                     : Routes(node = "list",             parent = Users)
        class  GET_BY_LOGIN(login: String) : Routes(node = "list/${login}",    parent = Users)
        object REGISTER                    : Routes(node = "register",         parent = Users)
        object LOGIN                       : Routes(node = "login",            parent = Users)
        object LEADERBOARD                 : Routes(node = "leaderboard",      parent = Users)
    }

    object Account : Routes("account") {
        object CHANGE_PASSWORD             : Routes(node = "change_password)", parent = Account)
        object UPDATE_USER_INFO            : Routes(node = "update_userinfo",  parent = Account)
        object AUTH                        : Routes(node = "auth",             parent = Account)
        object DELETE                      : Routes(node = "delete",           parent = Account)
        object GET_ACCOUNT_INFO            : Routes(node = "account_info",     parent = Account)
    }

    object Game : Routes("game") {
        object SESSION      : Routes(node = "session", parent = Game)
        object CREATE       : Routes(node = "create", parent = Game)
        object JOIN         : Routes(node = "join", parent = Game)
        object MATCH        : Routes(node = "match", parent = Game)
    }


}