package com.stocks_analyzer.core.models.secure;

import javax.persistence.MappedSuperclass;

import com.stocks_analyzer.core.models.AppModel;

/**
 * Secureモデルの基底クラス。
 * <p>各Secureモデルはこのクラスを継承する。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class AppSecureModel extends AppModel {

	/** DB接続情報：Secure関連用DB接続子 */
	public static final String EBEAN_SERVER_DB_SECURE = "secure";

	/**
	 * 保存。
	 * @see play.db.ebean.Model#save()
	 * @since 1.0.0
	 */
	@Override
	public void save() {
		super.save();
	}

	/**
	 * 更新。
	 * @see play.db.ebean.Model#update()
	 * @since 1.0.0
	 */
	@Override
	public void update() {
		super.update(EBEAN_SERVER_DB_SECURE);
	}

	/**
	 * 削除フラグを立てて更新。
	 * @see play.db.ebean.Model#delete()
	 * @since 1.0.0
	 */
	public void delete() {
		this.deleteFlg = true;
		super.update(EBEAN_SERVER_DB_SECURE);
	}
}