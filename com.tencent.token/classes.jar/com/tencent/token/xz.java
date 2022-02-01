package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public final class xz
  extends BaseAdapter
{
  private Context a;
  private ArrayList<sj> b;
  private int c = 0;
  
  public xz(Context paramContext, ArrayList<sj> paramArrayList)
  {
    this.a = paramContext;
    this.b = paramArrayList;
  }
  
  public final int getCount()
  {
    return this.b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new a();
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131296360, paramViewGroup, false);
      paramView.d = paramViewGroup.findViewById(2131165615);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131166166));
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131165613));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131165614));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (sj)this.b.get(paramInt);
    if ((localObject != null) && (((sj)localObject).e))
    {
      if (!TextUtils.isEmpty(((sj)localObject).c)) {
        paramView.a.setText(((sj)localObject).c);
      }
      paramView.d.setOnClickListener(((sj)localObject).a);
      if (((sj)localObject).b > 0) {
        paramView.b.setImageResource(((sj)localObject).b);
      } else {
        new zs(paramView.b).execute(new String[] { ((sj)localObject).f });
      }
      if (((sj)localObject).d)
      {
        paramView.c.setVisibility(0);
        return paramViewGroup;
      }
      paramView.c.setVisibility(4);
    }
    return paramViewGroup;
  }
  
  final class a
  {
    TextView a;
    ImageView b;
    ImageView c;
    View d;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xz
 * JD-Core Version:    0.7.0.1
 */