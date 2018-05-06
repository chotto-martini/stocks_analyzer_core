package com.stocks_analyzer.core.components.db.secure.dao;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.stocks_analyzer.core.components.db.secure.UsersComponent;
import com.stocks_analyzer.core.models.secure.AppSecureModel;
import com.stocks_analyzer.core.models.secure.Users;

/**
 * ユーザー（users）モデルのネイティブクエリによる操作クラス。
 * <p>アプリケーションとは祖結合としたい為、直接の参照は行わない。
 * <br>利用する場合、{@link UsersComponent}を経由しアクセスする。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class UsersDao {

	/**
	 * ユーザー（userss）作成する。
	 * @param accountId アカウントID
	 * @param password パスワード
	 * @param nickname ニックネーム
	 * @return 作成したユーザーモデルを返す。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	protected static Users create(String accountId, String password, String nickname) {
		String sql = "INSERT INTO users (account_id, password, nickname, access_token, use_datetime, created, modified) "
				+ "VALUES (:account_id, PASSWORD(:password), :nickname, :access_token, :use_datetime, :created, :modified)";

		Date now = new Date();
		String accessToken = RandomStringUtils.randomAlphanumeric(128);

		SqlUpdate sqlUpdate = Ebean.getServer(AppSecureModel.EBEAN_SERVER_DB_SECURE).createSqlUpdate(sql);
		sqlUpdate.setParameter("account_id",   accountId);
		sqlUpdate.setParameter("password",     password);
		sqlUpdate.setParameter("nickname",     nickname);
		sqlUpdate.setParameter("access_token", accessToken);
		sqlUpdate.setParameter("use_datetime", now);
		sqlUpdate.setParameter("created",      now);
		sqlUpdate.setParameter("modified",     now);
		sqlUpdate.execute();

		return Users.find.where().eq("access_token", accessToken).findUnique();
	}
}
