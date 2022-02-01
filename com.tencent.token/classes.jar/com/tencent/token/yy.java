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

public final class yy
  extends BaseAdapter
{
  private Context a;
  private ArrayList<td> b;
  private int c = 0;
  
  public yy(Context paramContext, ArrayList<td> paramArrayList)
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
      localObject = LayoutInflater.from(this.a).inflate(2131296368, paramViewGroup, false);
      paramView.d = ((View)localObject).findViewById(2131165632);
      paramView.a = ((TextView)((View)localObject).findViewById(2131166208));
      paramView.b = ((ImageView)((View)localObject).findViewById(2131165630));
      paramView.c = ((ImageView)((View)localObject).findViewById(2131165631));
      paramView.e = ((RelativeLayout)((View)localObject).findViewById(2131165756));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    else
    {
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject = (td)this.b.get(paramInt);
    if ((localObject != null) && (((td)localObject).f))
    {
      if (!TextUtils.isEmpty(((td)localObject).c)) {
        paramViewGroup.a.setText(((td)localObject).c);
      }
      paramViewGroup.d.setOnClickListener(((td)localObject).a);
      if (((td)localObject).b > 0) {
        paramViewGroup.b.setImageResource(((td)localObject).b);
      } else {
        new aao(paramViewGroup.b).execute(new String[] { ((td)localObject).h });
      }
      if (((td)localObject).d)
      {
        paramViewGroup.c.setVisibility(0);
        return paramView;
      }
      paramViewGroup.c.setVisibility(4);
      paramViewGroup = paramViewGroup.e;
      if (((td)localObject).e) {
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
 * Qualified Name:     com.tencent.token.yy
 * JD-Core Version:    0.7.0.1
 */