package com.tencent.gdtad.views.videoceiling;

import acfp;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import tkw;
import tmp;
import tmq;
import wja;

public class GdtVideoCeilingTitleBar
  extends RelativeLayout
{
  private TextView Bw;
  private a a;
  private String mAppName;
  private int mStyle;
  private TextView titleView;
  
  public GdtVideoCeilingTitleBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void aC()
  {
    this.titleView = ((TextView)findViewById(2131379769));
    this.Bw = ((TextView)findViewById(2131372655));
    this.Bw.setOnClickListener(new tmp(this));
    View localView = findViewById(2131363222);
    int i = wja.dp2px(5.0F, getResources());
    wja.i(localView, i, i, 0, i);
    localView.setOnClickListener(new tmq(this));
  }
  
  public void bDY()
  {
    tkw.i("GdtVideoCeilingView", "updateBar Style " + this.mStyle);
    if (this.mStyle != 1)
    {
      this.titleView.setVisibility(8);
      this.Bw.setVisibility(0);
      String str = acfp.m(2131706923) + this.mAppName;
      int i = "在APP中打开".length();
      if ((!TextUtils.isEmpty(this.mAppName)) && (str.length() <= i))
      {
        this.Bw.setText(str);
        return;
      }
      this.Bw.setText("在APP中打开");
      return;
    }
    this.titleView.setVisibility(0);
    this.Bw.setVisibility(8);
  }
  
  public void setAppName(String paramString)
  {
    this.mAppName = paramString;
  }
  
  public void setOnBtnClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void setStyle(int paramInt)
  {
    this.mStyle = paramInt;
  }
  
  public void setWebBarTitle(String paramString)
  {
    if ((this.titleView != null) && (!TextUtils.isEmpty(paramString))) {
      this.titleView.setText(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void er(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar
 * JD-Core Version:    0.7.0.1
 */