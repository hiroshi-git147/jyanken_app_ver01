package jyanken;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int com = getComNum();
		int user = getYourNum();

		boolean judge = isJudgeAnswer(com, user);

		if (judge)  {
			System.out.println("あなたの勝ち");
		}
	}

	// コンピュータの答えを返すメソッド
	public static int getComNum() {
		Random rnd = new Random();
		// 作成した乱数を返す
		return rnd.nextInt(3);
	}

	// あなたの予想を返すメソッド
	public static int getYourNum() {
		System.out.print("[グー：0, チョキ：1, パー：2]　数字を選んでください");
		System.out.println("0～2の数字を入力してください");

		Scanner sc = new Scanner(System.in);

		// 変数を定義
		int u;

		while(true) {
			try {
				// キーボードから入力
				u = sc.nextInt();
				break;
			// エラー(Exceptionクラスの例外)が発生した場合の処理
			} catch(NumberFormatException e) {
				System.out.println("数字が入力されていません。");
			} catch(Exception e) {
				System.out.println("0～2の数字を入力してください");
				sc.next();
			}
		}
		return u;
	}

	// 判定するメソッド
	public static boolean isJudgeAnswer(int com, int user) {
		String[] jyanken = {"グー", "チョキ", "パー"};
		// jyanken配列の中の配列番号を取得してgetIndexに代入
		int getIndex = Arrays.asList(jyanken).indexOf(jyanken[com]);

		while (!(((user - getIndex + 3) % 3) == 2)) {

			if (user == getIndex) {
				System.out.println("もう一回");
			} else {
				System.out.println("負け");
			}
			user = getYourNum();

		}
		System.out.println
		("相手：" + jyanken[getIndex] + "　あなた：" + jyanken[user]);
		return true;

	}

}
