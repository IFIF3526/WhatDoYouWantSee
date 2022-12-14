package com.luvris2.publicperfomancedisplayapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luvris2.publicperfomancedisplayapp.R;
import com.luvris2.publicperfomancedisplayapp.adapter.PostingAdapter;
import com.luvris2.publicperfomancedisplayapp.api.NetworkClient;
import com.luvris2.publicperfomancedisplayapp.api.PostingApi;
import com.luvris2.publicperfomancedisplayapp.model.Posting;
import com.luvris2.publicperfomancedisplayapp.model.PostingList;
import com.luvris2.publicperfomancedisplayapp.ui.PartyMainActivity;
import com.luvris2.publicperfomancedisplayapp.ui.PostingActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommunityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

// 커뮤니티 프래그먼트
// 최지훈
public class CommunityFragment extends Fragment {

    TextView txtMorePosting;
    ImageView imgMorePosting;
    RecyclerView recyclerView;
    TextView txtMoreReview;
    ImageView imgMoreReview;
    ImageView imgBack;
    Button btnParty;

    PostingAdapter adapter;
    ArrayList<Posting> postingList = new ArrayList<>();

    // 페이징 처리를 위한 멤버변수
    int offset = 0;
    int limit = 25;

    // 정렬과 관련된 멤버변수
    String order = "recommend";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CommunityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CommunityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CommunityFragment newInstance(String param1, String param2) {
        CommunityFragment fragment = new CommunityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_community, container, false);

        btnParty = rootView.findViewById(R.id.btnParty);
        txtMorePosting = rootView.findViewById(R.id.txtMorePosting);
        imgMorePosting = rootView.findViewById(R.id.imgMorePosting);
        txtMoreReview = rootView.findViewById(R.id.txtMoreReview);
        imgMoreReview = rootView.findViewById(R.id.imgBack);
        imgBack = rootView.findViewById(R.id.imgBack);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        btnParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), PartyMainActivity.class));
            }
        });

        txtMorePosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), PostingActivity.class));
            }
        });

        imgMorePosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), PostingActivity.class));
            }
        });

        txtMoreReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), PostingActivity.class));
            }
        });

        imgMoreReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), PostingActivity.class));
            }
        });

        getNetworkData();

        return rootView;
    }

    private void getNetworkData() {
        postingList.clear();
        limit = 5;
        offset = 0;

        Retrofit retrofit = NetworkClient.getRetrofitClient(getContext());
        PostingApi api = retrofit.create(PostingApi.class);

        Call<PostingList> call = api.getPostingSort(order, offset, limit);

        call.enqueue(new Callback<PostingList>() {
            @Override
            public void onResponse(Call<PostingList> call, Response<PostingList> response) {

                if(response.isSuccessful()){


                    postingList.addAll(response.body().getResultList());

                    adapter = new PostingAdapter(getActivity(), postingList);

                    recyclerView.setAdapter(adapter);

                }else{

                }
            }

            @Override
            public void onFailure(Call<PostingList> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//        getNetworkData();
//
//        adapter = new PostingAdapter(getActivity(), postingList);
//
//        recyclerView.setAdapter(adapter);
//
//    }
}