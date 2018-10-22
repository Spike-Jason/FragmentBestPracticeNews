package com.example.fuxiaole.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public static void  actionStart(Context context, String newsTitle, String newsContent){

        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("new_titile", newsTitle);
        intent.putExtra("new_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        //通过Intent 传入新闻标题和新闻内容
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        //调用findFragmentById 方法获取NewsContentFragment实例
        NewsContentFragment newsContentFragment =
                (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent);
    }
}
