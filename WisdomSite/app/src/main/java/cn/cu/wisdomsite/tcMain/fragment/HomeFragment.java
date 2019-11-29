package cn.cu.wisdomsite.tcMain.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.cu.wisdomsite.tcMain.AttendanceActivity;
import cn.cu.wisdomsite.tcMain.LoadometerActivity;
import cn.cu.wisdomsite.tcMain.ProgressActivity;
import cn.cu.wisdomsite.R;
import cn.cu.wisdomsite.tcMain.VideoActivity;


/**
 *主页Fragment
 */
public class HomeFragment extends Fragment {

    private ImageView videoImage;
    private ImageView attendanceImage;
    private ImageView loadometerImage;
    private ImageView progressImage;

    private List<ImageView> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        initView(view);
//        ImageView video_image = view.findViewById(R.id.img_video);
//        video_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        //获取图片实例
//        ImageView videoImg = view.findViewById(R.id.videoImg);
//        //设置点击事件，跳转到对应的fragment标签
//        videoImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity= (MainActivity) getActivity();
//                mainActivity.setTab(4);
//            }
//        });
//        ImageView attenImg = view.findViewById(R.id.attenImg);
//        attenImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity= (MainActivity) getActivity();
//                mainActivity.setTab(1);
//            }
//        });
//        ImageView loadImg = view.findViewById(R.id.loadImg);
//        loadImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity= (MainActivity) getActivity();
//                mainActivity.setTab(2);
//            }
//        });
//        ImageView progressImg = view.findViewById(R.id.progressImg);
//        progressImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity= (MainActivity) getActivity();
//                mainActivity.setTab(3);
//            }
//        });
//        ImageView mineImg = view.findViewById(R.id.mineImg);
//        mineImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity= (MainActivity) getActivity();
//                mainActivity.setTab(5);
//            }
//        });
//        ImageView addlistImg = view.findViewById(R.id.addListImg);
//        addlistImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity= (MainActivity) getActivity();
//                mainActivity.setTab(5);
//            }
//        });
        return view;
    }

    private class ImageListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_video:
                    Intent intent_video = new Intent(getActivity(), VideoActivity.class);
                    startActivity(intent_video);
                    break;
                case R.id.img_attendance:
                    Intent intent_atten = new Intent(getActivity(), AttendanceActivity.class);
                    startActivity(intent_atten);
                    break;
                case R.id.img_loadometer:
                    Intent intent_load = new Intent(getActivity(), LoadometerActivity.class);
                    startActivity(intent_load);
                    break;
                case R.id.img_progress:
                    Intent intent_pro = new Intent(getActivity(), ProgressActivity.class);
                    startActivity(intent_pro);
                    break;
                    default:
                        Toast.makeText(getContext(),"you click wrong",Toast.LENGTH_SHORT).show();
                        break;
            }
        }
    }

    private void initView(View view){
        videoImage = (ImageView)view.findViewById(R.id.img_video);
        attendanceImage = (ImageView)view.findViewById(R.id.img_attendance);
        loadometerImage = (ImageView)view.findViewById(R.id.img_loadometer);
        progressImage = (ImageView)view.findViewById(R.id.img_progress);


        mList.add(videoImage);
        mList.add(attendanceImage);
        mList.add(loadometerImage);
        mList.add(progressImage);

        for (ImageView img : mList){

            img.setOnClickListener(new ImageListener());
        }

    }

}
