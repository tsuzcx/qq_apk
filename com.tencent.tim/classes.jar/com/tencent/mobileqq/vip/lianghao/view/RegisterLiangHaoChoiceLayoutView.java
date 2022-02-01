package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqwf;
import aqwj;
import aqwl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class RegisterLiangHaoChoiceLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View Jf;
  private View Jg;
  private LiangHaoView[] a = new LiangHaoView[4];
  private aqwf c;
  private TextView content;
  
  public RegisterLiangHaoChoiceLayoutView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RegisterLiangHaoChoiceLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RegisterLiangHaoChoiceLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void XZ(int paramInt)
  {
    LiangHaoView localLiangHaoView = this.a[paramInt];
    if ((localLiangHaoView != null) && (localLiangHaoView.c != null) && (this.c != null)) {
      this.c.a(localLiangHaoView.c);
    }
  }
  
  public void c(aqwj paramaqwj)
  {
    if ((paramaqwj == null) || (paramaqwj.iD == null) || (paramaqwj.iD.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < this.a.length)
    {
      if (paramaqwj.iD.size() <= i) {
        ((ViewGroup)this.a[i].getParent()).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        aqwl localaqwl = (aqwl)paramaqwj.iD.get(i);
        this.a[i].setUin(localaqwl);
        ((ViewGroup)this.a[i].getParent()).setVisibility(0);
      }
    }
    this.content.setText(paramaqwj.content);
  }
  
  public void enable(boolean paramBoolean)
  {
    Object localObject1 = this.a;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localObject2.setEnabled(paramBoolean);
      ((ViewGroup)localObject2.getParent()).setEnabled(paramBoolean);
      i += 1;
    }
    this.Jf.setEnabled(paramBoolean);
    this.Jg.setEnabled(paramBoolean);
    localObject1 = this.Jg;
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      ((View)localObject1).setAlpha(f);
      return;
    }
  }
  
  public void init()
  {
    int i = 0;
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131562123, this, true);
    this.Jf = findViewById(2131370407);
    this.content = ((TextView)findViewById(2131370406));
    this.Jg = findViewById(2131370405);
    this.a[0] = ((LiangHaoView)findViewById(2131370410));
    this.a[1] = ((LiangHaoView)findViewById(2131370411));
    this.a[2] = ((LiangHaoView)findViewById(2131370412));
    this.a[3] = ((LiangHaoView)findViewById(2131370413));
    this.Jf.setOnClickListener(this);
    this.content.setOnClickListener(this);
    this.Jg.setOnClickListener(this);
    LiangHaoView[] arrayOfLiangHaoView = this.a;
    int j = arrayOfLiangHaoView.length;
    while (i < j)
    {
      ((ViewGroup)arrayOfLiangHaoView[i].getParent()).setOnClickListener(this);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    aqwf localaqwf = this.c;
    if (localaqwf == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131370406: 
      case 2131370408: 
      case 2131370409: 
      case 2131370410: 
      case 2131370411: 
      case 2131370412: 
      case 2131370413: 
      default: 
        break;
      case 2131370405: 
        localaqwf.efY();
        break;
      case 2131370407: 
        localaqwf.efW();
        break;
      case 2131370414: 
        XZ(0);
        break;
      case 2131370415: 
        XZ(1);
        break;
      case 2131370416: 
        XZ(2);
        break;
      case 2131370417: 
        XZ(3);
      }
    }
  }
  
  public void setLiangHaoHelper(aqwf paramaqwf)
  {
    this.c = paramaqwf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView
 * JD-Core Version:    0.7.0.1
 */