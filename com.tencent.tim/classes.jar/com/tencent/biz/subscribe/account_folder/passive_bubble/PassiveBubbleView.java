package com.tencent.biz.subscribe.account_folder.passive_bubble;

import acfp;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import rzd;

public class PassiveBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView mMessageView;
  
  public PassiveBubbleView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public PassiveBubbleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public PassiveBubbleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(null, "dc00898", "", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  protected void bxy()
  {
    rzd.sW("https://h5.qzone.qq.com/subscription/messagelist?_proxy=1&_wv=1&_wwv=4");
    setVisibility(8);
  }
  
  protected void initView(Context paramContext)
  {
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(2130839166);
    inflate(paramContext, 2131558847, this);
    this.mMessageView = ((TextView)findViewById(2131371313));
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    bxy();
    f("auth_page", "msg_clk", "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void yh(int paramInt)
  {
    if (this.mMessageView != null)
    {
      String str = paramInt + acfp.m(2131709402);
      this.mMessageView.setText(str);
      f("auth_page", "msg_exp", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView
 * JD-Core Version:    0.7.0.1
 */