package kr.co.learche.rest_api_base.common.model.response

open class CommonResult(
    var success: Boolean = true,

    var code: Int = 0,

    var message: String = "success!"
)
