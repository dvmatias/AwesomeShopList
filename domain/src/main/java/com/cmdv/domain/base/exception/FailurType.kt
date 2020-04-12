package com.cmdv.domain.base.exception

sealed class FailureType {

	open class LocalErrorType(val errorCode: Int = 327) : FailureType()

}