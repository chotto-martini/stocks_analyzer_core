package com.stocks_analyzer.core.components.db;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.stocks_analyzer.core.models.RuleTemplates;

/**
 * 株価ステータス（price_statuses）モデルの操作を行うコンポーネントクラス。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class RuleTemplatesComponent {

	/**
	 * 未削除の株価ステータス（price_statuses）情報一覧を返す。
	 *
	 * @return 未削除の株価ステータス（price_statuses）情報一覧
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public static List<RuleTemplates> getRuleTemplates() {
		List<RuleTemplates> retList =
				Ebean.find(RuleTemplates.class)
					.where()
					.eq("delete_flg", false)
					.orderBy("id ASC")
					.findList();

		return retList;
	}
}
