package com.example.black1223.cadi_6;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StuAdapter extends BaseAdapter {
    private ArrayList<Student> StuList;
    private Context context;
    private ListView sList;
    private Button btn1;
    private TextView text1;
    private TextView text2;
    int position;

    public StuAdapter(ArrayList<Student> stuList, Context context) {
        this.StuList = stuList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return StuList.size();
    }

    @Override
    public Object getItem(int position) {
        return StuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    // 버튼을 누르면 토스트 메세지가 출력되는 메소드
    // 버튼을 눌렀을때 해당 아이템의 이름과 학번을 가져오는 메소드
    private void selectButton(Button btn1, int position) {
       btn1.setOnClickListener(new btnListener(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.stu_items, parent, false);
        sList = (ListView) itemView.findViewById(R.id.StudentView);
        btn1 = (Button) itemView.findViewById(R.id.btn1);
        text1 = (TextView) itemView.findViewById(R.id.edName);
        text2 = (TextView) itemView.findViewById(R.id.edAge);
        this.position = position;
        fillViews(sList, position);
        return itemView;
    }
    // 리스트 뷰에 아이템 목록을 띄우는 메소드
    private void fillViews(ListView sList, int position) {
        text1.setText(StuList.get(position).getStudentname());
        text2.setText(StuList.get(position).getStudentage());

        selectButton(btn1, position);
    }


    private class btnListener implements View.OnClickListener {
        int position;
        public btnListener(int position) {
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(context, StuList.get(position).getStudentname() + " / " + StuList.get(position).getStudentage() , Toast.LENGTH_LONG).show();
         //   whatTheMoviesAre(position);
        }
        /*private void whatTheMoviesAre(int position) {
            final AlertDialog.Builder dlg = new AlertDialog.Builder(context);
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View itemtView2 = inflater.inflate(R.layout.stu_items, null, false);
            ImageView mImgs[] = new ImageView[StuList.size()];
            for (int i = 0; i < position; i++) {
                mImgs[i] = (ImageView) itemtView2.findViewById(R.id.movieImg);
                Glide.with(context)
                      .load(StuList.get(position).getStudent())
                      .fitCenter().skipMemoryCache(true)
                      .into(mImgs[i]);
            }
            dlg.setTitle("영화소개");
            dlg.setView(itemtView2);
            dlg.setPositiveButton("확인", null);
            dlg.show();
        }*/
    }
}
