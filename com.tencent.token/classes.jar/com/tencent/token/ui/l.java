package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.bt;

class l
  extends BaseAdapter
{
  private LayoutInflater a;
  private int b;
  private String[] c;
  private LoginMsgReportLocationActivity d;
  private int e = -1;
  
  public l(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity)
  {
    this.d = paramLoginMsgReportLocationActivity;
    this.a = LayoutInflater.from(paramLoginMsgReportLocationActivity);
    this.b = bt.a().d.length;
    this.c = bt.a().c;
    this.d.checkMenuBtnEnable(this.e);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int getCount()
  {
    return this.b;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.inflate(2130968688, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131559007));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131559009));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131559008));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131558830));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= this.c.length)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.b.setText(this.c[paramInt]);
    paramViewGroup.a.setVisibility(8);
    String[] arrayOfString = bt.a().f;
    int[] arrayOfInt = bt.a().g;
    int i = 0;
    for (;;)
    {
      if (i < arrayOfInt.length)
      {
        if (paramInt == arrayOfInt[i])
        {
          paramViewGroup.a.setVisibility(0);
          paramViewGroup.a.setText(arrayOfString[i]);
        }
      }
      else
      {
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            l.a(l.this, paramInt);
            l.b(l.this).checkMenuBtnEnable(l.a(l.this));
            l.this.notifyDataSetChanged();
          }
        });
        if (this.e != paramInt) {
          break;
        }
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.c.setBackgroundColor(this.d.getResources().getColor(2131492959));
        return paramView;
      }
      i += 1;
    }
    paramViewGroup.d.setVisibility(8);
    paramViewGroup.c.setBackgroundColor(this.d.getResources().getColor(2131492954));
    return paramView;
  }
  
  private class a
  {
    TextView a;
    TextView b;
    RelativeLayout c;
    ImageView d;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.l
 * JD-Core Version:    0.7.0.1
 */