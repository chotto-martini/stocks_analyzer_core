package com.stocks_analyzer.core.models.ext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.stocks_analyzer.core.models.CompanySchedules;
import com.stocks_analyzer.core.models.Stocks;

/**
 * 企業スケジュール（company_schedules）モデル拡張。
 * 銘柄情報を保持する。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
@SuppressWarnings("serial")
@Entity @Table(name="company_schedules")
public class CompanySchedulesWithStocks extends CompanySchedules {

	/** 銘柄（stocks）モデル */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stock_code", referencedColumnName="stock_code")
	public Stocks stocks;
}
