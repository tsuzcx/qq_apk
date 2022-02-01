package com.tencent.mobileqq.gamecenter.view;

import acfp;
import ahuh;
import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import wja;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements ahuh
{
  public MoreMsgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    paramMessageRecord = new TextView(getContext());
    paramMessageRecord.setText(acfp.m(2131708451));
    paramMessageRecord.setTextColor(-16777216);
    paramMessageRecord.setAlpha(0.5F);
    paramMessageRecord.setEms(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = wja.dp2px(50.0F, paramActivity.getResources());
    addView(paramMessageRecord, localLayoutParams);
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    paramQQGameMsgInfo = new TextView(getContext());
    paramQQGameMsgInfo.setText(acfp.m(2131708451));
    paramQQGameMsgInfo.setTextColor(-16777216);
    paramQQGameMsgInfo.setAlpha(0.5F);
    paramQQGameMsgInfo.setEms(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = wja.dp2px(50.0F, paramActivity.getResources());
    addView(paramQQGameMsgInfo, localLayoutParams);
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */