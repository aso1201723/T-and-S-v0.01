package com.example.listviewexpandable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TwoLineListItem;

public class MainActivity extends ActionBarActivity implements ExpandableListView.OnChildClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 親項目（g_title）、子項目（c_title）を準備
		String[] g_title = {"金管楽器","木管楽器","弦楽器"};
		String[][][] c_title = {
				{{"トランペット","高音域の出る金管楽器"},{"トロンボーン","長いＵ字型の管をつなぎ合わせた金管楽器"},{"チューバ","大型で低音域の出る金管楽器"}}
				,{{"クラリネット","音域の広い木管楽器"},{"ファゴット","低音域の木管楽器"},{"オーボエ","2枚リードで高音域の木管楽器"}}
				,{{"バイオリン","高音域の弦楽器"},{"ビオラ","中音域の弦楽器"},{"チェロ","大型の低音域の弦楽器"}},
		};

		ExpandableListView elv = (ExpandableListView)findViewById(R.id.elv);

		//ArrayList<E>すためのリストを準備
		ArrayList<Map<String, String>> g_list = new ArrayList<Map<String,String>>();
		ArrayList<List<Map<String, String>>> c_list = new ArrayList<List<Map<String,String>>>();

		// 配列g_titleをHachMapに詰め替え（キーはgroup_title）
		for (int i = 0; i < g_title.length; i++) {
			HashMap<String, String> group = new HashMap<String, String>();
			group.put("group_title", g_title[i]);

			//リストg_listに追加
			g_list.add(group);
			ArrayList<Map<String, String>> childs = new ArrayList<Map<String, String>>();

			// 配列c_titleの内容をHashMap（child）に詰め替え＆リストchildに追加
			for (int j = 0; j < c_title.length; j++) {
				HashMap<String, String> child = new HashMap<String, String>();
				child.put("child_title", c_title[i][j][0]);
				child.put("child_text", c_title[i][j][1]);
				childs.add(child);
			}

			// リストc_titleに追加
			c_list.add(childs);
		}

		SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
				this,
				g_list,
				android.R.layout.simple_expandable_list_item_1,
				new String []{ "group_title" },
				new int [] { android.R.id.text1 },
				c_list,
				android.R.layout.simple_expandable_list_item_2,
				new String [] { "child_title", "child_text" },
				new int [] { android.R.id.text1, android.R.id.text2 }
		);
		elv.setAdapter(adapter);


		//子項目をクリックしたときのイベントリスナーを定義
		elv.setOnChildClickListener(this);

		/*
		//子項目をクリックしたときのイベントリスナーを定義
		elv.setOnChildClickListener(
				new OnChildClickListener() {
					public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
						//クリックされた子項目を取得＆トースト表示
						TextView txt = (TextView)((TwoLineListItem)v).findViewById(android.R.id.text1);
						Toast.makeText(getApplicationContext(), txt.getText(), Toast.LENGTH_SHORT).show();



						//inte.putExtra("pTitle", txt.getText());
						//startActivity(inte);
						return false;
					}
				});
				*/

	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		// TODO 自動生成されたメソッド・スタブ
		TextView txt = (TextView)((TwoLineListItem)v).findViewById(android.R.id.text1);
		Toast.makeText(getApplicationContext(), txt.getText(), Toast.LENGTH_SHORT).show();

		Intent inte = new Intent(this,Shosai.class);
		inte.putExtra("pTitle", txt.getText());
		startActivity(inte);


		return false;
	}
}
