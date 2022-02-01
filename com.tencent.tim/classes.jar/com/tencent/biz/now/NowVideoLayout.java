package com.tencent.biz.now;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anry;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.util.DisplayUtil;

public class NowVideoLayout
  extends RelativeLayout
{
  public NowVideoLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = new TextView(getContext());
    paramContext.setText("当前不支持的消息类型(type=18)");
    paramContext.setTextColor(Color.parseColor("#777777"));
    paramContext.setTextSize(DisplayUtil.sp2px(getContext(), 12.0F));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    addView(paramContext, localLayoutParams);
  }
  
  public void a(QQAppInterface paramQQAppInterface, anry paramanry, MessageRecord paramMessageRecord) {}
  
  public void azn() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoLayout
 * JD-Core Version:    0.7.0.1
 */