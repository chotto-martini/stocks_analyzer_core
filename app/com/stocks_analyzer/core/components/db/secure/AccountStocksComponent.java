package com.stocks_analyzer.core.components.db.secure;

import java.util.List;

import com.stocks_analyzer.core.components.db.secure.dao.AccountStocksDao;
import com.stocks_analyzer.core.models.secure.AccountStocks;

/**
 * 口座銘柄（account_stocks）モデルの操作を行うコンポーネントクラス。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class AccountStocksComponent extends AccountStocksDao {

	/**
	 * 口座銘柄（account_stocks）モデルのバルクインサートを行う。
	 *
	 * @param list バルクインサート対象リスト
	 * @return INSERT結果件数を返す。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 * @see AccountStocksDao#executeBulkInsert(List)
	 */
	public static int executeBulkInsert(List<AccountStocks> list) {
		return AccountStocksDao.executeBulkInsert(list);
	}
}
