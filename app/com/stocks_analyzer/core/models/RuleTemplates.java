package com.stocks_analyzer.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 株価推移ルールテンプレート（rule_templates）モデル。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
@SuppressWarnings("serial")
@Entity
public class RuleTemplates extends AppModel {

	/** タイトル */
	@Column(name = "title")
	public String title;

	/** 種別（-1：下降、0：停滞、1：上昇） */
	@Column(name = "type")
	public Integer type;

	/** 株価テンプレート（json配列の株価推移を表すテンプレート：{"stock_prices":[1.1,1.2,1.3,1.4]}） */
	@Column(name = "price_template")
	public String priceTemplate;

	/**
	 * 株価テンプレートの株価推移配列を返す。
	 * @return 株価推移配列を返す。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public Double[] getStockPricesArray() {
		return null;
	}
}
