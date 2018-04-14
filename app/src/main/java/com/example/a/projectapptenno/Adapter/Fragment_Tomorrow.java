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
import com.example.a.projectapptenno.Setter_Getter.Fragment_Setter_Getter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASUS on 3/26/2018.
 */

public class Fragment_Tomorrow extends BaseAdapter {
    ArrayList<Fragment_Setter_Getter> arrayList;
    Context context;
    LayoutInflater inflater;

    public Fragment_Tomorrow(ArrayList<Fragment_Setter_Getter> arrayList, Context context) {
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
            convertView = inflater.inflate(R.layout.listview_custom_fagment, null);
            viewHolder.txt_diemtam = (TextView) convertView.findViewById(R.id.txt_diemtam_fragment);
            viewHolder.txt_monan = (TextView) convertView.findViewById(R.id.txt_monanyeuthich_fagment);
            viewHolder.img_monan = (ImageView) convertView.findViewById(R.id.img_lst_fagment);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_diemtam.setText(arrayList.get(position).getTxt_diemtam());
        viewHolder.txt_monan.setText(arrayList.get(position).getTxt_monan());
//        viewHolder.img_monan.setImageResource(arrayList.get(position).getImg_monan());

        String url = "";
        if (!(arrayList.get(position).getImg_monan().isEmpty())) {
            url = "" + arrayList.get(position).getImg_monan();
        } else {
            url = String.valueOf(R.drawable.ic_image_black_24dp);//null
        }
      Picasso.get()
                .load(url)
                .error(R.drawable.ic_image_black_24dp)//load url error
                .placeholder(R.drawable.ic_image_black_24dp)//load url error
                .resize(900, 506)

                .into(viewHolder.img_monan);
        return convertView;
    }
    public class ViewHolder{
        TextView txt_diemtam,txt_monan;
        ImageView img_monan;
    }
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
