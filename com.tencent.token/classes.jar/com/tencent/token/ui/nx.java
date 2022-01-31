package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.o;

final class nx
  extends BaseAdapter
{
  private LayoutInflater a;
  private int b;
  private String[] c;
  private LoginMsgReportLocationActivity d;
  private int e = -1;
  
  public nx(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity)
  {
    this.d = paramLoginMsgReportLocationActivity;
    this.a = LayoutInflater.from(paramLoginMsgReportLocationActivity);
    this.b = o.a().d.length;
    this.c = o.a().c;
    this.d.checkMenuBtnEnable(this.e);
  }
  
  public final int a()
  {
    return this.e;
  }
  
  public final int getCount()
  {
    return this.b;
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
      paramView = this.a.inflate(2130903131, null);
      paramViewGroup = new nz(this);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131296802));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131296804));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131296803));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131296543));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= this.c.length)
    {
      return paramView;
      paramViewGroup = (nz)paramView.getTag();
    }
    paramViewGroup.b.setText(this.c[paramInt]);
    paramViewGroup.a.setVisibility(8);
    String[] arrayOfString = o.a().f;
    int[] arrayOfInt = o.a().g;
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
        paramViewGroup.c.setOnClickListener(new ny(this, paramInt));
        if (this.e != paramInt) {
          break;
        }
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.c.setBackgroundColor(this.d.getResources().getColor(2131165255));
        return paramView;
      }
      i += 1;
    }
    paramViewGroup.d.setVisibility(8);
    paramViewGroup.c.setBackgroundColor(this.d.getResources().getColor(2131165254));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nx
 * JD-Core Version:    0.7.0.1
 */