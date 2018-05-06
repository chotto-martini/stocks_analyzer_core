package com.stocks_analyzer.core.components.google;

/**
 * Google API操作に関する例外クラス。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class GoogleApiException extends Exception {

	/**
	 * Google API操作例外クラスコンストラクタ。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public GoogleApiException() {
		super();
	}

	/**
	 * Google API操作例外クラスコンストラクタ。
	 * @param message エラーメッセージ
	 * @param cause 例外
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public GoogleApiException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Google API操作例外クラスコンストラクタ。
	 * @param message エラーメッセージ
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public GoogleApiException(String message) {
		super(message);
	}

	/**
	 * Google API操作例外クラスコンストラクタ。
	 * @param cause 例外
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public GoogleApiException(Throwable cause) {
		super(cause);
	}

}
