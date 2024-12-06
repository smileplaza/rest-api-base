package kr.co.learche.rest_api_base.common.service.response

import kr.co.learche.rest_api_base.common.model.response.CommonResult
import kr.co.learche.rest_api_base.common.model.response.MutableListResult
import kr.co.learche.rest_api_base.common.model.response.SingleResult
import org.springframework.stereotype.Service

@Service
class ResponseService {

    fun successResult(): CommonResult {
        return CommonResult()
    }

    fun failResult(code: Int, message: String): CommonResult {
        return CommonResult(false, code, message)
    }

    fun <T> singleResult(data: T): SingleResult<T> {
        val common = successResult()
        return SingleResult(
            success = common.success,
            code = common.code,
            message = common.message,
            data = data
        )
    }

    fun <T> mutableListResult(results: MutableList<T>): MutableListResult<T> {
        val common = successResult()
        return MutableListResult(
            common.success,
            common.code,
            common.message,
            results
        )
    }
}
