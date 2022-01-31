package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

public class NoticeUpdateHandler
  extends Handler
{
  protected static final int a = 100;
  protected static final String a = "NoticeUpdateHandler";
  protected Notification a;
  protected NoticeParam a;
  
  public NoticeUpdateHandler()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  public NoticeUpdateHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  protected String a(int paramInt)
  {
    return CommonDataAdapter.a().a().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return CommonDataAdapter.a().a().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131297450, paramPendingIntent);
        return;
      }
      paramNotification.contentIntent = paramPendingIntent;
      return;
    }
    paramNotification.contentIntent = paramPendingIntent;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = paramMessage.getData();
    Object localObject2 = ((Bundle)localObject1).getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    LogUtility.a("NoticeUpdateHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = DownloadManager.a().a((String)localObject2);
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString = ((DownloadInfo)localObject2).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_JavaLangString = ((DownloadInfo)localObject2).e;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d = ((DownloadInfo)localObject2).d;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f = ((DownloadInfo)localObject2).f;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_AndroidContentIntent = ((DownloadInfo)localObject2).jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Long = ((DownloadInfo)localObject2).jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.g = ((DownloadInfo)localObject2).g;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e = ((DownloadInfo)localObject2).c;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
        this.jdField_a_of_type_AndroidAppNotification = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
      }
      while (this.jdField_a_of_type_AndroidAppNotification == null)
      {
        return;
        localObject1 = new RemoteViews(CommonDataAdapter.a().a().getPackageName(), 2130903277);
        AppNotificationManager.a().a((RemoteViews)localObject1);
        this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("NoticeUpdateHandler", "init Notification>>>", localException);
      }
      switch (paramMessage.what)
      {
      default: 
      case 2: 
      case 20: 
      case 4: 
      case 3: 
      case -2: 
        for (;;)
        {
          int i = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          long l = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.when = l;
          AppNotificationManager.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
          LogUtility.c("NoticeUpdateHandler", "notify key=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f + " type=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int + "appid=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          return;
          LogUtility.b("NoticeUpdateHandler", ">>downloading:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          LogUtility.c("NoticeUpdateHandler", "size = " + ((DownloadInfo)localObject2).k + " content = ");
          this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131362109, new Object[] { ((DownloadInfo)localObject2).e });
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297456, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297454, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131297457, 100, ((DownloadInfo)localObject2).k, false);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297454, ((DownloadInfo)localObject2).k * 100 / 100 + "%");
          this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131297451, 2130838575);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297453, StringAddition.a(a(2131362112, new Object[] { ((DownloadInfo)localObject2).e }), 18, true));
          a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
          if (!TextUtils.isEmpty(""))
          {
            this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 0);
            this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297455, Html.fromHtml(""));
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidAppNotification.flags = 32;
            paramMessage = this.jdField_a_of_type_AndroidAppNotification;
            paramMessage.flags |= 0x2;
            break;
            this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 8);
          }
          this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131362109, new Object[] { ((DownloadInfo)localObject2).e });
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297456, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297454, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297453, StringAddition.a(a(2131362112, new Object[] { ((DownloadInfo)localObject2).e }), 18, true));
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297455, a(2131362117));
          this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131297451, 2130838575);
          a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
          this.jdField_a_of_type_AndroidAppNotification.flags = 32;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags |= 0x2;
          AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
          continue;
          LogUtility.b("NoticeUpdateHandler", ">>complete:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
          this.jdField_a_of_type_AndroidAppNotification = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
          if (this.jdField_a_of_type_AndroidAppNotification == null) {
            break;
          }
          this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131362110);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297456, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297454, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297455, a(2131362116));
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297453, StringAddition.a(((DownloadInfo)localObject2).e, 18, true));
          a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
          paramMessage = ImageUtil.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          if (paramMessage != null) {
            this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131297451, paramMessage);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidAppNotification.flags = 16;
            paramMessage = this.jdField_a_of_type_AndroidAppNotification;
            paramMessage.flags &= 0xFFFFFFFD;
            AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
            break;
            LogUtility.b("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
            this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131297451, 2130838575);
          }
          LogUtility.b("NoticeUpdateHandler", ">>pause:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131362114);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297456, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297454, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131297451, 2130838578);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297453, StringAddition.a(((DownloadInfo)localObject2).e, 18, true));
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297455, a(2131362114));
          a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
          this.jdField_a_of_type_AndroidAppNotification.flags = 16;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags &= 0xFFFFFFFD;
          AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
          continue;
          LogUtility.b("NoticeUpdateHandler", ">>error:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297455, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297456, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131297454, 8);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131297451, 2130838576);
          String str = (String)paramMessage.obj;
          paramMessage = str;
          if (TextUtils.isEmpty(str)) {
            paramMessage = a(2131362118);
          }
          this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131362111, new Object[] { paramMessage });
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297455, a(2131362115, new Object[] { paramMessage }));
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131297453, StringAddition.a(((DownloadInfo)localObject2).e, 18, true));
          a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
          this.jdField_a_of_type_AndroidAppNotification.flags = 16;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags &= 0xFFFFFFFD;
          AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
        }
      }
      AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeUpdateHandler
 * JD-Core Version:    0.7.0.1
 */