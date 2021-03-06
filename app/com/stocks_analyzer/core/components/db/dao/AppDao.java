package com.stocks_analyzer.core.components.db.dao;

import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import com.stocks_analyzer.commons.util.FieldUtils;
import com.stocks_analyzer.core.components.ModelUtilityComponent;
import com.stocks_analyzer.core.models.AppModel;

/**
 * Daoの基底クラス。
 * <p>各Daoはこのクラスを継承する。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class AppDao {

	/**
	 * モデルのバルクインサートを行う。
	 * @param dataList バルクインサート対象リスト
	 * @param modelClass モデルクラス
	 * @param tableName テーブル名
	 * @param excludeColumnNameList 除外カラム名のリスト
	 * @return INSERT結果件数を返す。
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	protected static int executeBulkInsert(
			List<? extends AppModel> dataList, Class<? extends AppModel> modelClass, String tableName, List<String> excludeColumnNameList) {

		Map<String, String> colMap = ModelUtilityComponent.getColumnMap(modelClass, excludeColumnNameList);
		// SQLテンプレート作成
		StringBuilder sqlStringBuilder =
				new StringBuilder("INSERT INTO " + tableName + " ( ");

		StringBuilder colBuilder = new StringBuilder();
		for (Map.Entry<String, String> entry : colMap.entrySet()) {
			String columnName = entry.getKey();
			colBuilder.append(", " + columnName);
		}
		// 先頭のカンマを除去
		colBuilder.deleteCharAt(0);
		sqlStringBuilder.append(colBuilder + " ) VALUES ");

		// バインド変数作成
		for (int i = 0; i < dataList.size(); i++) {
			if (0 == i) {
				sqlStringBuilder.append(" ( ");
			} else {
				sqlStringBuilder.append(", ( ");
			}

			colBuilder = new StringBuilder();
			for (Map.Entry<String, String> entry : colMap.entrySet()) {
				String columnName = entry.getKey();
				colBuilder.append(", :" + columnName + "_" + i);
			}
			// 先頭のカンマを除去
			colBuilder.deleteCharAt(0);
			sqlStringBuilder.append(colBuilder).append(" ) ");
		}

		// バルクインサート用SQL作成
		SqlUpdate sqlUpdate = Ebean.createSqlUpdate(sqlStringBuilder.toString());
		int j = 0;
		for (Object items : dataList) {
			// フィールド情報を取得する。
			Map<String, Object> fieldMap = FieldUtils.toMapField(items);

			for (Map.Entry<String, String> entry : colMap.entrySet()) {
				String columnName = entry.getKey();
				String paramName  = entry.getValue();
				sqlUpdate.setParameter(columnName + "_" + j, fieldMap.get(paramName));
			}
			j++;
		}

		// インサート実行
		return Ebean.execute(sqlUpdate);
	}
}
