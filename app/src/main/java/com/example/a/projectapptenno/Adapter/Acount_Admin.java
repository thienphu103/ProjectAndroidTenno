package com.example.a.projectapptenno.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.projectapptenno.R;
import com.example.a.projectapptenno.Setter_Getter.Favorite_Food_Setter_Getter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Acount_Admin extends BaseAdapter {
    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    Context context;
    LayoutInflater inflater;
    public Acount_Admin(ArrayList<Favorite_Food_Setter_Getter> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_custom_acount, null);
            viewHolder.txt_dong1 = (TextView) convertView.findViewById(R.id.txt_dong1);
            viewHolder.txt_dong2 = (TextView) convertView.findViewById(R.id.txt_dong2);
            viewHolder.txt_dong3 = (TextView) convertView.findViewById(R.id.txt_dong3);
            viewHolder.img_acount = (ImageView) convertView.findViewById(R.id.img_acount);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_dong1.setText(arrayList.get(position).getDong1_acount());
        viewHolder.txt_dong2.setText(arrayList.get(position).getDong2_acount());
        viewHolder.txt_dong3.setText(arrayList.get(position).getDong3_acount());
        String url = "";
//        if (!(arrayList.get(position).getImg_monan().isEmpty())) {
//            url = "" + arrayList.get(position).getImg_monan();
//        } else {
//            url = String.valueOf(R.drawable.ic_image_black_24dp);//null
//        }
//        Picasso.get()
//                .load(url)
//                .error(R.drawable.ic_image_black_24dp)//load url error
//                .placeholder(R.drawable.ic_image_black_24dp)//load url error
//                .resize(900, 506)
//                .into(viewHolder.img_acount);
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
    public class ViewHolder{
        TextView txt_dong1,txt_dong2,txt_dong3;
        ImageView img_acount;
    }
}
