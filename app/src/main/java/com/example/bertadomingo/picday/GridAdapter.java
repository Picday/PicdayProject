package com.example.bertadomingo.picday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class GridAdapter extends BaseAdapter{
    private Context context;

    public GridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() { return this.mThumbIds.length;  }

    @Override
    public Object getItem(int position) { return this.mThumbIds[position];  }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

   /* @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grid, viewGroup, false);
        }

        ImageView imagen = (ImageView) view.findViewById(R.id.imagen);

        final Foto item = (Foto) getItem(position);
        imagen.setImageResource(item.getIdDrawable());

        return view;
    }*/

   //d'aqui fins al final es una prova
   public View getView(int position, View convertView, ViewGroup parent) {
       ImageView imageView;
       if (convertView == null) {
           // if it's not recycled, initialize some attributes
           imageView = new ImageView(context);
           imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
           imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
           imageView.setPadding(20, 20, 20, 20);
       } else {
           imageView = (ImageView) convertView;
       }

       imageView.setImageResource(mThumbIds[position]);
       return imageView;
   }


    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };
}
