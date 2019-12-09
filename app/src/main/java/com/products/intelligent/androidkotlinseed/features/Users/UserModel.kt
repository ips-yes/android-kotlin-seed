package com.products.intelligent.androidkotlinseed.features.Users

import java.sql.Timestamp

class UserModel : LoginModel() {
    var first_name: String? = null
    var last_name: String? = null
    var phone_number: String? = null
    override var password: String = ""
        set(value: String) {
            super.password = value
        }
    private val created_at: Timestamp? = null
    private val updated_at: Timestamp? = null
    var _id: Int = 0
    private val created_by: Int = 0
    private val edited_by: Int = 0
    private val deleted: Boolean = false
}
