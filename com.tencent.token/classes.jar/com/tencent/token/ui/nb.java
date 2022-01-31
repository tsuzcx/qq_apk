package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.cg;

class nb
  extends BaseAdapter
{
  private LayoutInflater a;
  private int b;
  private String[] c;
  private LoginMsgReportLocationActivity d;
  private int e = -1;
  
  public nb(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity)
  {
    this.d = paramLoginMsgReportLocationActivity;
    this.a = LayoutInflater.from(paramLoginMsgReportLocationActivity);
    this.b = cg.a().d.length;
    this.c = cg.a().c;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.inflate(2130968688, null);
      paramViewGroup = new nd(this, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131559006));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131559008));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131559007));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131558829));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= this.c.length)
    {
      return paramView;
      paramViewGroup = (nd)paramView.getTag();
    }
    paramViewGroup.b.setText(this.c[paramInt]);
    paramViewGroup.a.setVisibility(8);
    String[] arrayOfString = cg.a().f;
    int[] arrayOfInt = cg.a().g;
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
        paramViewGroup.c.setOnClickListener(new nc(this, paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nb
 * JD-Core Version:    0.7.0.1
 */