package food.neusoft.com.food.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import food.neusoft.com.food.R;
import food.neusoft.com.food.domian.WestFoodInfo;
import food.neusoft.com.food.utils.TimeChose;

/**
 * Created by 张宇翔 on 2016/11/23 19:22.
 * Email：1124751755@qq.com
 * 功能：西餐的Adapter
 */

public class WestAdapter extends BaseAdapter {

    private Context context;

    private List<WestFoodInfo> westFoodInfos;

    public WestAdapter(Context context,List<WestFoodInfo> westFoodInfos) {
        this.westFoodInfos = westFoodInfos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return westFoodInfos.size();
    }

    @Override
    public WestFoodInfo getItem(int i) {
        return westFoodInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.item_west,null);
            holder=new ViewHolder();
            holder.iv_west= (ImageView) view.findViewById(R.id.iv_west);
            holder.tv_storename= (TextView) view.findViewById(R.id.tv_storename);
            holder.iv_phototype= (ImageView) view.findViewById(R.id.iv_phototype);
            holder.tv_type= (TextView) view.findViewById(R.id.tv_type);
            holder.tv_distance= (TextView) view.findViewById(R.id.tv_distance);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        WestFoodInfo info=getItem(i);
        holder.iv_west.setImageResource(info.getImageid());
        holder.tv_storename.setText(info.getStorename());
        holder.iv_phototype.setImageResource(info.getPhototype());
        holder.tv_type.setText(info.getFoodtype());
        holder.tv_distance.setText(info.getDistance());
        Onclick(holder,i);
        return view;
    }

    private void Onclick(final ViewHolder holder, final int postion){

        holder.iv_west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//给大图设置点击事件
                Toast.makeText(context,westFoodInfos.get(postion).getStorename(),Toast.LENGTH_SHORT).show();
            }

        });
        holder.iv_phototype.setOnClickListener(new View.OnClickListener() {//给小图设置点击事件
            @Override
            public void onClick(View view) {
                Toast.makeText(context,westFoodInfos.get(postion).getDistance(),Toast.LENGTH_SHORT).show();
                TimeChose timeChose=new TimeChose(context, (Activity) context);
                timeChose.DiaLog();
            }
        });

    }




    static class ViewHolder{
        public ImageView iv_west;
        public TextView tv_storename;
        public ImageView iv_phototype;
        public TextView tv_type;
        public TextView tv_distance;
    }







}
