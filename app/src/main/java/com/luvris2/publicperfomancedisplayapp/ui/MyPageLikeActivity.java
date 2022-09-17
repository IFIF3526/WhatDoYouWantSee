package com.luvris2.publicperfomancedisplayapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.luvris2.publicperfomancedisplayapp.R;
import com.luvris2.publicperfomancedisplayapp.adapter.MyPageLikeAdapter;
import com.luvris2.publicperfomancedisplayapp.api.NetworkClient;
import com.luvris2.publicperfomancedisplayapp.api.PerformanceApi;
import com.luvris2.publicperfomancedisplayapp.config.Config;
import com.luvris2.publicperfomancedisplayapp.model.Like;


import java.util.ArrayList;

import retrofit2.Retrofit;

// 좋아요를 누른 행사 목록 (좋아요 액티비티) : 좋아요 누른 행사 확인하는 기능
public class MyPageLikeActivity extends AppCompatActivity {

    ImageView imgBack; // 이전 버튼 이동
    RecyclerView recyclerView; // 리사이클러뷰


    // 어댑터, 어레이리스트
    MyPageLikeAdapter adapter;
//    List<Like> likeList
    ArrayList<Like> likeList = new ArrayList<>();

    // 페이징에 필요한 멤버변수
    int offset = 0;
    int limit = 25;

    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_like);

        imgBack = findViewById(R.id.imgBack);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyPageLikeActivity.this));


        // 이전 화면 이동 클릭시
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // 네트워크 데이터를 받아온다.
        getNetworkData();


    }

    private void getNetworkData() {
        likeList.clear();
        offset = 0;
        limit = 25;

//        Retrofit retrofit = NetworkClient.getRetrofitClient(MyPageLikeActivity.this);
//        PerformanceApi api = retrofit.create(PerformanceApi.class);
//
//        // 쉐어드프리퍼런스에 억세스토큰 가져오기
//        SharedPreferences sp = getApplication().getSharedPreferences(Config.PREFERENCES_NAME, MODE_PRIVATE);
//        String token = sp.getString("accessToken", "");
//
//        Call<LikeRes> call = api.getLikeDetail("Bearer "+ token);
//
//        call.enqueue(new Callback<LikeRes>() {
//            @Override
//            public void onResponse(Call<LikeRes> call, Response<LikeRes> response) {
//
//                if(response.isSuccessful()){
//
//                    likeList.addAll( response.body().getResultList() );
//
//                    adapter = new MyPageLikeAdapter(MyPageLikeActivity.this, likeList);
//
//                    adapter.notifyDataSetChanged();
//
//                    recyclerView.setAdapter(adapter);
//
//                }else{
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LikeRes> call, Throwable t) {
//            }
//        });

    }

}