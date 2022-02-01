package com.tencent.mobileqq.filemanager.activity;

import acde;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aviq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MPFileFailedView
  extends RelativeLayout
  implements View.OnClickListener
{
  private LinearLayout D;
  Button N;
  TextView Sj;
  TextView Sk;
  private a a;
  TextView aX;
  private QQAppInterface app;
  private long bL;
  private Activity mContext;
  ImageView zF;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = ((Activity)paramContext);
    this.app = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, a parama, int paramInt1, int paramInt2)
  {
    int k = 2131696038;
    int m = 2130845259;
    this.a = parama;
    this.Sk.setVisibility(8);
    int i = 2131696041;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131696024;
      if (paramInt2 == 1)
      {
        i = 2131696025;
        paramInt2 = 0;
        n = 2131696052;
        j = i;
        i = paramInt2;
        paramInt2 = n;
      }
      break;
    case 2001: 
    case 2003: 
    case 2002: 
    case 2004: 
    case 2107: 
    case 2109: 
      for (;;)
      {
        this.D.setVisibility(0);
        this.zF.setImageResource(m);
        this.aX.setText(k);
        this.aX.setVisibility(0);
        this.Sj.setText(j);
        this.Sj.setVisibility(i);
        this.Sk.setVisibility(8);
        this.N.setText(paramInt2);
        if (7 == paramInt1) {
          this.N.setVisibility(8);
        }
        return this.D;
        k = 2131696039;
        paramInt2 = 2131696051;
        m = 2130845264;
        j = 2131696039;
        i = 8;
        continue;
        k = 2131696040;
        paramInt2 = 2131696051;
        m = 2130845264;
        j = 2131696041;
        i = 0;
        continue;
        k = 2131696053;
        m = 2130845262;
        i = 8;
        paramInt2 = 2131696052;
        j = 2131696041;
        continue;
        k = 2131696024;
        if (paramInt2 == 1) {
          i = 2131696025;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131696052;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131696026;
          }
        }
        k = 2131696053;
        m = 2130845262;
        i = 8;
        paramInt2 = 2131696052;
        j = 2131696041;
        continue;
        i = 8;
        m = 2130845263;
        paramInt2 = 2131696052;
        j = 2131696038;
      }
    case 2110: 
      label157:
      m = 2130845264;
      if (paramInt2 == 1)
      {
        j = 2131696040;
        i = 2131696041;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131696051;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131696039;
        i = 2131696034;
        paramInt2 = 8;
        continue;
        k = 2131696348;
        i = 8;
        j = 2131696348;
        paramInt2 = 2131696052;
        break label157;
        k = 2131696049;
        i = 8;
        j = 2131696049;
        paramInt2 = 2131696052;
        break label157;
        i = 8;
        m = 2130845263;
        paramInt2 = 2131696052;
        j = 2131696038;
        break label157;
        k = 2131692409;
        i = 8;
        m = 0;
        paramInt2 = 2131696052;
        j = 2131696041;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131696026;
        break;
      }
      j = 2131696028;
      i = 2131696041;
      paramInt2 = 8;
    }
  }
  
  public void finish()
  {
    this.a = null;
  }
  
  public void ga()
  {
    this.D = ((LinearLayout)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131561072, null).findViewById(2131361805));
    this.zF = ((ImageView)this.D.findViewById(2131368847));
    this.aX = ((TextView)this.D.findViewById(2131379420));
    this.Sj = ((TextView)this.D.findViewById(2131379421));
    this.Sk = ((TextView)this.D.findViewById(2131379432));
    this.N = ((Button)this.D.findViewById(2131364085));
    this.N.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.D.setVisibility(8);
    acde localacde = (acde)this.app.getBusinessHandler(8);
    if (paramView == this.N)
    {
      if (!this.N.getText().toString().equalsIgnoreCase(getResources().getString(2131696051))) {
        break label97;
      }
      this.bL = localacde.a().f(0);
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.m(this.bL);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label97:
      if (localacde.a().aT()) {
        this.bL = localacde.a().f(1);
      } else {
        this.bL = localacde.a().f(2);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void m(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */