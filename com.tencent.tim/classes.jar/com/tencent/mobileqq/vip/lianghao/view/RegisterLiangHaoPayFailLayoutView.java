package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import aqwf;
import aqwl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class RegisterLiangHaoPayFailLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View Jh;
  private LiangHaoView a;
  private aqwf c;
  
  public RegisterLiangHaoPayFailLayoutView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RegisterLiangHaoPayFailLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RegisterLiangHaoPayFailLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(1);
    int i = wja.dp2px(27.5F, getResources());
    setPadding(i, 0, i, 0);
    LayoutInflater.from(getContext()).inflate(2131562126, this, true);
    this.a = ((LiangHaoView)findViewById(2131370409));
    this.Jh = findViewById(2131370408);
    this.Jh.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.c.b(this.a.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setLiangHaoHelper(aqwf paramaqwf)
  {
    this.c = paramaqwf;
  }
  
  public void setUin(aqwl paramaqwl)
  {
    this.a.setUin(paramaqwl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView
 * JD-Core Version:    0.7.0.1
 */