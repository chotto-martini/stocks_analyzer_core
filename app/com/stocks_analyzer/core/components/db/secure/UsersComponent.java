package com.stocks_analyzer.core.components.db.secure;

import com.stocks_analyzer.core.components.db.secure.dao.UsersDao;
import com.stocks_analyzer.core.models.secure.Users;

/**
 * ユーザー（users）モデルの操作を行うコンポーネントクラス。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class UsersComponent extends UsersDao {

	/**
	 * ユーザー（users）作成する。
	 * @param accountId アカウントID
	 * @param password パスワード
	 * @param nickname ニックネーム
	 * @return 作成したユーザーモデルを返す。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public static Users create(String accountId, String password, String nickname) {
		return UsersDao.create(accountId, password, nickname);
	}

	/**
	 * アクセストークンを指定し、ユーザー情報を取得する。
	 * @param accessToken アクセストークン
	 * @return 取得したユーザー情報を返す。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public static Users getUsersByAccessToken(String accessToken) {
		Users users = Users.find.where()
				.eq("delete_flg", false)
				.eq("access_token", accessToken)
				.findUnique();

		return users;
	}
}
