package com.stocks_analyzer.core.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 株価ステータス（price_statuses）モデル。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
@SuppressWarnings("serial")
@Entity
public class PriceStatuses extends AppModel {

	/** 取得日 */
	@Column(name = "date")
	public Date date;

	/** 銘柄コード */
	@Column(name = "stock_code")
	public Integer stockCode;

	/** 株価推移ルールテンプレートID */
	@Column(name = "rule_templates_id")
	public Long ruleTemplatesId;

}
