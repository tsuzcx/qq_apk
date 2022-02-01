package com.tencent.token;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.ui.LoginMsgReportLocationActivity;

public final class ya
  extends BaseAdapter
{
  public int a = -1;
  private LayoutInflater b;
  private int c;
  private String[] d;
  private LoginMsgReportLocationActivity e;
  
  public ya(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity)
  {
    this.e = paramLoginMsgReportLocationActivity;
    this.b = LayoutInflater.from(paramLoginMsgReportLocationActivity);
    this.c = rs.a().d.length;
    this.d = rs.a().c;
    this.e.checkMenuBtnEnable(this.a);
  }
  
  public final int getCount()
  {
    return this.c;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = this.b.inflate(2131296370, null);
      paramView = new a((byte)0);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131165276));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131165767));
      paramView.c = ((RelativeLayout)paramViewGroup.findViewById(2131165768));
      paramView.d = ((ImageView)paramViewGroup.findViewById(2131165972));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    if (paramInt >= this.d.length) {
      return paramViewGroup;
    }
    paramView.b.setText(this.d[paramInt]);
    paramView.a.setVisibility(8);
    Object localObject = rs.a().f;
    int[] arrayOfInt = rs.a().g;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (paramInt == arrayOfInt[i])
      {
        paramView.a.setVisibility(0);
        paramView.a.setText(localObject[i]);
        break;
      }
      i += 1;
    }
    paramView.c.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        ya.a(ya.this, paramInt);
        ya.b(ya.this).checkMenuBtnEnable(ya.a(ya.this));
        ya.this.notifyDataSetChanged();
      }
    });
    if (this.a == paramInt)
    {
      paramView.d.setVisibility(0);
      paramView.c.setBackgroundColor(this.e.getResources().getColor(2130968691));
      return paramViewGroup;
    }
    paramView.d.setVisibility(8);
    paramView.c.setBackgroundColor(this.e.getResources().getColor(2130968686));
    return paramViewGroup;
  }
  
  final class a
  {
    TextView a;
    TextView b;
    RelativeLayout c;
    ImageView d;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ya
 * JD-Core Version:    0.7.0.1
 */