package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public final class ym
  extends BaseAdapter
{
  private Context a;
  private ArrayList<sr> b;
  private int c = 0;
  
  public ym(Context paramContext, ArrayList<sr> paramArrayList)
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
    int i = 0;
    if (paramView == null)
    {
      paramView = new a();
      localObject = LayoutInflater.from(this.a).inflate(2131296360, paramViewGroup, false);
      paramView.d = ((View)localObject).findViewById(2131165615);
      paramView.a = ((TextView)((View)localObject).findViewById(2131166168));
      paramView.b = ((ImageView)((View)localObject).findViewById(2131165613));
      paramView.c = ((ImageView)((View)localObject).findViewById(2131165614));
      paramView.e = ((RelativeLayout)((View)localObject).findViewById(2131165739));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    else
    {
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject = (sr)this.b.get(paramInt);
    if ((localObject != null) && (((sr)localObject).f))
    {
      if (!TextUtils.isEmpty(((sr)localObject).c)) {
        paramViewGroup.a.setText(((sr)localObject).c);
      }
      paramViewGroup.d.setOnClickListener(((sr)localObject).a);
      if (((sr)localObject).b > 0) {
        paramViewGroup.b.setImageResource(((sr)localObject).b);
      } else {
        new aae(paramViewGroup.b).execute(new String[] { ((sr)localObject).g });
      }
      if (((sr)localObject).d)
      {
        paramViewGroup.c.setVisibility(0);
        return paramView;
      }
      paramViewGroup.c.setVisibility(4);
      paramViewGroup = paramViewGroup.e;
      if (((sr)localObject).e) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      paramViewGroup.setVisibility(paramInt);
    }
    return paramView;
  }
  
  final class a
  {
    TextView a;
    ImageView b;
    ImageView c;
    View d;
    RelativeLayout e;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ym
 * JD-Core Version:    0.7.0.1
 */