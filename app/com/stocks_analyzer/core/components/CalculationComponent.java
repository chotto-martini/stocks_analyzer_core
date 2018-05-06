package com.stocks_analyzer.core.components;

import com.stocks_analyzer.commons.math.DPMatching;
import com.stocks_analyzer.commons.math.interpolation.LinearInterpolation;
import com.stocks_analyzer.commons.math.model.MatchingArray;

/**
 * 計算に関するユーティリティクラス。
 *
 * @author chotto-martini
 * @since 1.0.0
 */
public class CalculationComponent {

	/**
	 * 基準となる配列 {@code templateArray} と、抽出対象 {@code targetArray} との乖離をスコアとして取得する。
	 * <p>乖離が大きいほど返却される値は大きくなる。
	 *
	 * @param templateArray スコア抽出の基準となる配列
	 * @param targetArray スコア抽出対象となる配列
	 * @return スコア抽出の基準となる配列と対象配列のスコアを取得する。（※値が大きいほど乖離している。）
	 *
	 * @author chotto-martini
	 * @since 1.0.0
	 */
	public static double getMatchingScore(Double[] templateArray, Double[] targetArray) {
		// 桁あわせ後の値保持に使用。
		Double[] d = new Double[templateArray.length];

		for (int i = 0; i < templateArray.length; i++) {
			// 起点の値でテンプレートに対して桁合わせをする。
			d[i] = templateArray[i] / (templateArray[0] / targetArray[0]);
		}

		// マッチング処理
		MatchingArray ma = new MatchingArray(d, targetArray);
		DPMatching m = new DPMatching(ma, new LinearInterpolation());
		return m.matching();
	}
}