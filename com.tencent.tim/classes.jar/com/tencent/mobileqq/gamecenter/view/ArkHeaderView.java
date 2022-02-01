package com.tencent.mobileqq.gamecenter.view;

import adqr;
import ahuh;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import wja;
import wyw;
import wyw.c;

public class ArkHeaderView
  extends ArkAppView
  implements ahuh
{
  private wyw c;
  private String mAppid;
  
  public ArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    paramMessageRecord = (MessageForArkApp)paramMessageRecord;
    this.c = new wyw();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = "2747277822";
    this.c.a(paramMessageRecord.ark_app_message.appName, paramMessageRecord.ark_app_message.appView, paramMessageRecord.ark_app_message.appMinVersion, paramMessageRecord.ark_app_message.metaList, paramActivity.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    int i = wja.dp2px(350.0F, paramActivity.getResources());
    int j = adqr.cJg;
    this.c.setMaxSize(j, i);
    setClipRadius(5.0F);
    a(this.c, null);
    setVisibility(0);
    try
    {
      this.mAppid = paramMessageRecord.ark_app_message.mSourceName;
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("ArkHeaderView", 1, "parse meta error =" + paramMessageRecord.toString());
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    this.c = new wyw();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = "2747277822";
    this.c.a(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramActivity.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    paramInt = wja.dp2px(350.0F, paramActivity.getResources());
    int i = adqr.cJg;
    this.c.setMaxSize(i, paramInt);
    this.c.setFixSize(i, paramInt);
    setClipRadius(5.0F);
    a(this.c, null);
    setVisibility(0);
    try
    {
      this.mAppid = paramQQGameMsgInfo.gameAppId;
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      QLog.e("ArkHeaderView", 1, "parse meta error =" + paramQQGameMsgInfo.toString());
    }
  }
  
  public void destroy()
  {
    if (this.c != null) {
      this.c.doOnEvent(2);
    }
  }
  
  public void onPause()
  {
    if (this.c != null) {
      this.c.doOnEvent(0);
    }
  }
  
  public void onResume()
  {
    if (this.c != null) {
      this.c.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ArkHeaderView
 * JD-Core Version:    0.7.0.1
 */