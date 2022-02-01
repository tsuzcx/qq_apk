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
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

public class asag
  extends Handler
{
  protected NoticeParam a = new NoticeParam();
  protected Notification notification;
  
  public asag() {}
  
  public asag(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  protected void b(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131372538, paramPendingIntent);
        return;
      }
      paramNotification.contentIntent = paramPendingIntent;
      return;
    }
    paramNotification.contentIntent = paramPendingIntent;
  }
  
  protected String getString(int paramInt)
  {
    return aroi.a().getContext().getString(paramInt);
  }
  
  protected String getString(int paramInt, Object... paramVarArgs)
  {
    return aroi.a().getContext().getString(paramInt, paramVarArgs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = paramMessage.getData();
    Object localObject2 = ((Bundle)localObject1).getString(aryv.PARAM_SNG_APPID);
    arwt.v("NoticeUpdateHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = aryy.a().c((String)localObject2);
    if (localObject2 != null)
    {
      if (((DownloadInfo)localObject2).ell == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        arwt.d("NoticeUpdateHandler", "notification isShowNotification=" + ((DownloadInfo)localObject2).ell);
      }
    }
    else {
      return;
    }
    this.a.appId = ((DownloadInfo)localObject2).appId;
    this.a.title = ((DownloadInfo)localObject2).pushTitle;
    this.a.packName = ((DownloadInfo)localObject2).packageName;
    this.a.typeId = 1;
    this.a.nKey = ((DownloadInfo)localObject2).sendTime;
    this.a.noticeType = 1;
    this.a.as = ((DownloadInfo)localObject2).noticeIntent;
    this.a.time = ((DownloadInfo)localObject2).time;
    this.a.via = ((DownloadInfo)localObject2).via;
    this.a.cDW = ((DownloadInfo)localObject2).urlStr;
    for (;;)
    {
      try
      {
        if (this.notification == null)
        {
          this.notification = asab.a().b(this.a);
          if (this.notification == null) {
            break;
          }
        }
        switch (paramMessage.what)
        {
        default: 
          int i = asab.a().a(this.a.nKey, this.a.noticeType, this.a.appId);
          long l = asab.a().a(this.a.nKey, this.a.noticeType, this.a.appId);
          this.notification.when = l;
          asab.a().notify(i, this.notification);
          arwt.d("NoticeUpdateHandler", "notify key=" + this.a.nKey + " type=" + this.a.noticeType + "appid=" + this.a.appId);
          return;
          localObject1 = new RemoteViews(aroi.a().getContext().getPackageName(), 2131559856);
          asab.a().b((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131372538, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131372540, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131372534, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131372528, "setTextColor", -12303292);
          this.notification.contentView = ((RemoteViews)localObject1);
          continue;
        }
      }
      catch (Exception localException)
      {
        arwt.e("NoticeUpdateHandler", "init Notification>>>", localException);
        continue;
        arwt.i("NoticeUpdateHandler", ">>downloading:" + this.a.appId);
        arwt.d("NoticeUpdateHandler", "size = " + ((DownloadInfo)localObject2).progress + " content = ");
        this.notification.tickerText = getString(2131696481, new Object[] { ((DownloadInfo)localObject2).pushTitle });
        this.notification.contentView.setViewVisibility(2131372528, 8);
        this.notification.contentView.setViewVisibility(2131372523, 0);
        this.notification.contentView.setViewVisibility(2131372534, 0);
        this.notification.contentView.setProgressBar(2131372522, 100, ((DownloadInfo)localObject2).progress, false);
        this.notification.contentView.setTextViewText(2131372534, ((DownloadInfo)localObject2).progress * 100 / 100 + "%");
        this.notification.contentView.setImageViewResource(2131372529, 2130845239);
        this.notification.contentView.setTextViewText(2131372540, arwx.h(getString(2131696484, new Object[] { ((DownloadInfo)localObject2).pushTitle }), 18, true));
        b(this.notification, asad.a(2, this.a), true);
        if (!TextUtils.isEmpty(""))
        {
          this.notification.contentView.setViewVisibility(2131372528, 0);
          this.notification.contentView.setTextViewText(2131372528, Html.fromHtml(""));
          this.notification.flags = 32;
          paramMessage = this.notification;
          paramMessage.flags |= 0x2;
          continue;
        }
        this.notification.contentView.setViewVisibility(2131372528, 8);
        continue;
        this.notification.tickerText = getString(2131696481, new Object[] { ((DownloadInfo)localObject2).pushTitle });
        this.notification.contentView.setViewVisibility(2131372528, 0);
        this.notification.contentView.setViewVisibility(2131372523, 8);
        this.notification.contentView.setViewVisibility(2131372534, 8);
        this.notification.contentView.setTextViewText(2131372540, arwx.h(getString(2131696484, new Object[] { ((DownloadInfo)localObject2).pushTitle }), 18, true));
        this.notification.contentView.setTextViewText(2131372528, getString(2131692972));
        this.notification.contentView.setImageViewResource(2131372529, 2130845239);
        b(this.notification, asad.a(2, this.a), true);
        this.notification.flags = 32;
        paramMessage = this.notification;
        paramMessage.flags |= 0x2;
        asab.a().Xu(this.a.nKey);
        continue;
        arwt.i("NoticeUpdateHandler", ">>complete:" + this.a.appId);
        this.a.noticeType = 3;
        this.notification = asab.a().b(this.a);
      }
      if (this.notification == null) {
        break;
      }
      this.notification.tickerText = getString(2131696479);
      this.notification.contentView.setViewVisibility(2131372528, 0);
      this.notification.contentView.setViewVisibility(2131372523, 8);
      this.notification.contentView.setViewVisibility(2131372534, 8);
      this.notification.contentView.setTextViewText(2131372528, getString(2131696427));
      this.notification.contentView.setTextViewText(2131372540, arwx.h(((DownloadInfo)localObject2).pushTitle, 18, true));
      b(this.notification, asad.a(4, this.a), false);
      paramMessage = arwr.R(this.a.appId);
      if (paramMessage != null) {
        this.notification.contentView.setImageViewBitmap(2131372529, paramMessage);
      }
      for (;;)
      {
        this.notification.flags = 16;
        paramMessage = this.notification;
        paramMessage.flags &= 0xFFFFFFFD;
        asab.a().Xu(this.a.nKey);
        break;
        arwt.i("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
        this.notification.contentView.setImageViewResource(2131372529, 2130845239);
      }
      arwt.i("NoticeUpdateHandler", ">>pause:" + this.a.appId);
      this.notification.tickerText = getString(2131696429);
      this.notification.contentView.setViewVisibility(2131372528, 0);
      this.notification.contentView.setViewVisibility(2131372523, 8);
      this.notification.contentView.setViewVisibility(2131372534, 8);
      this.notification.contentView.setImageViewResource(2131372529, 2130845242);
      this.notification.contentView.setTextViewText(2131372540, arwx.h(((DownloadInfo)localObject2).pushTitle, 18, true));
      this.notification.contentView.setTextViewText(2131372528, getString(2131696429));
      b(this.notification, asad.a(1, this.a), true);
      this.notification.flags = 16;
      paramMessage = this.notification;
      paramMessage.flags &= 0xFFFFFFFD;
      asab.a().Xu(this.a.nKey);
      continue;
      arwt.i("NoticeUpdateHandler", ">>error:" + this.a.appId);
      this.notification.contentView.setViewVisibility(2131372528, 0);
      this.notification.contentView.setViewVisibility(2131372523, 8);
      this.notification.contentView.setViewVisibility(2131372534, 8);
      this.notification.contentView.setImageViewResource(2131372529, 2130845240);
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = getString(2131692937);
      }
      this.notification.tickerText = getString(2131696480, new Object[] { paramMessage });
      this.notification.contentView.setTextViewText(2131372528, getString(2131696428, new Object[] { paramMessage }));
      this.notification.contentView.setTextViewText(2131372540, arwx.h(((DownloadInfo)localObject2).pushTitle, 18, true));
      b(this.notification, asad.a(1, this.a), true);
      this.notification.flags = 16;
      paramMessage = this.notification;
      paramMessage.flags &= 0xFFFFFFFD;
      asab.a().Xu(this.a.nKey);
    }
    asab.a().Xt(this.a.nKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asag
 * JD-Core Version:    0.7.0.1
 */