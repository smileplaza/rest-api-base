package kr.co.learche.rest_api_base.common.model.response

class SingleResult<T> (
    success: Boolean,
    code: Int,
    message:String,
    var data: T

): CommonResult(success, code, message)
