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

import java.util.ArrayList;

public class Add_Admin extends BaseAdapter {
    ArrayList<Favorite_Food_Setter_Getter> arrayList;
    Context context;
    LayoutInflater inflater;
    View.OnClickListener click;
    View.OnClickListener click2;
    public Add_Admin(ArrayList<Favorite_Food_Setter_Getter> arrayList, Context context,View.OnClickListener click, View.OnClickListener click2) {
        this.arrayList = arrayList;
        this.context = context;
        this.click = click;
        this.click2 = click2;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_custom_add, null);
            viewHolder.txt_diemtam = (TextView) convertView.findViewById(R.id.txt_diemtam_add);
            viewHolder.txt_monan = (TextView) convertView.findViewById(R.id.txt_monanyeuthich_add);
            viewHolder.img_cancel=(ImageView) convertView.findViewById(R.id.img_cancel_add);
            viewHolder.img_update=(ImageView) convertView.findViewById(R.id.img_edit_add);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_diemtam.setText(arrayList.get(position).getTxt_diemtam());
        viewHolder.txt_monan.setText(arrayList.get(position).getTxt_monan());
        viewHolder.img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(new Integer(position));
                click.onClick(v);
            }
        });
        viewHolder.img_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(new Integer(position));
                click2.onClick(v);
            }
        });

        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
    public class ViewHolder{
        TextView txt_diemtam,txt_monan;
        ImageView img_monan,img_cancel,img_update;
    }
}
