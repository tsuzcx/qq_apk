package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import aqwl;

public class LiangHaoDialogView
  extends LinearLayout
{
  private LiangHaoView a;
  public aqwl c;
  
  public LiangHaoDialogView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LiangHaoDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LiangHaoDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131562124, this, true);
    this.a = ((LiangHaoView)findViewById(2131370409));
  }
  
  public void c(aqwl paramaqwl)
  {
    this.c = paramaqwl;
    this.a.setUin(paramaqwl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialogView
 * JD-Core Version:    0.7.0.1
 */