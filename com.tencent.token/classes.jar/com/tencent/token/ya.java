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

public final class ya
  extends BaseAdapter
{
  private Context a;
  private ArrayList<sk> b;
  private int c = 0;
  
  public ya(Context paramContext, ArrayList<sk> paramArrayList)
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
    Object localObject = (sk)this.b.get(paramInt);
    if ((localObject != null) && (((sk)localObject).e))
    {
      if (!TextUtils.isEmpty(((sk)localObject).c)) {
        paramView.a.setText(((sk)localObject).c);
      }
      paramView.d.setOnClickListener(((sk)localObject).a);
      if (((sk)localObject).b > 0) {
        paramView.b.setImageResource(((sk)localObject).b);
      } else {
        new zt(paramView.b).execute(new String[] { ((sk)localObject).f });
      }
      if (((sk)localObject).d)
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
 * Qualified Name:     com.tencent.token.ya
 * JD-Core Version:    0.7.0.1
 */