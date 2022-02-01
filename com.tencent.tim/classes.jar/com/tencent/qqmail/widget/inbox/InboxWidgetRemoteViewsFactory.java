package com.tencent.qqmail.widget.inbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.MailTag;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;
import com.tencent.qqmail.widget.QMWidgetDataManager.WidgetState;
import java.util.ArrayList;

public class InboxWidgetRemoteViewsFactory
  implements RemoteViewsService.RemoteViewsFactory
{
  public static final String TAG = "InboxWidgetRemoteViewsFactory";
  private boolean fingerprintLock = false;
  private InboxWidgetManager inboxWidgetManager;
  private int mAppWidgetId;
  private Context mContext;
  private QMAvatar qmAvatar = new QMAvatar();
  private int widgetSize = 4;
  private QMWidgetDataManager.WidgetState widgetState;
  
  public InboxWidgetRemoteViewsFactory(Context paramContext, Intent paramIntent)
  {
    this.mContext = paramContext;
    this.mAppWidgetId = paramIntent.getIntExtra("appWidgetId", 0);
  }
  
  public int getCount()
  {
    if ((!this.inboxWidgetManager.isNull()) && (this.inboxWidgetManager.getCount() > 0) && (this.widgetState == QMWidgetDataManager.WidgetState.AVAILABLE))
    {
      if (this.inboxWidgetManager.canLoadMore()) {
        return this.inboxWidgetManager.getCount() + 1;
      }
      return this.inboxWidgetManager.getCount();
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public RemoteViews getLoadingView()
  {
    return null;
  }
  
  public RemoteViews getMailItemView(int paramInt)
  {
    RemoteViews localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563357);
    Mail localMail = this.inboxWidgetManager.getItem(paramInt);
    localRemoteViews.setTextViewText(2131371073, localMail.getInformation().getSubject());
    long l;
    Object localObject;
    if ((localMail.getStatus().isAdConv()) || (localMail.getStatus().isSubscribeConv())) {
      if (localMail.getStatus().isAdConv())
      {
        localRemoteViews.setImageViewBitmap(2131363175, BitmapFactory.decodeResource(this.mContext.getResources(), 2130838762));
        l = Mail.addAttrs(new Long[] { Long.valueOf(0L), Long.valueOf(2048L) });
        localRemoteViews.setTextViewText(2131371070, localMail.getInformation().getFrom().getName());
        localRemoteViews.setTextViewText(2131371071, localMail.getInformation().getAbstractContent());
        localRemoteViews.setTextViewText(2131371072, DateExtension.shortDateNameWithExactTime(localMail.getInformation().getDate()));
        localObject = localMail.getInformation().getTagList();
        if (!localMail.getStatus().isUnread()) {
          break label758;
        }
        paramInt = 0;
        label193:
        localRemoteViews.setViewVisibility(2131381285, paramInt);
        if (!localMail.getStatus().hasAttach()) {
          break label764;
        }
        paramInt = 0;
        label214:
        localRemoteViews.setViewVisibility(2131363051, paramInt);
        if (!localMail.getStatus().isStarred()) {
          break label770;
        }
        paramInt = 0;
        label235:
        localRemoteViews.setViewVisibility(2131378693, paramInt);
        if (this.widgetSize > 2) {
          break label776;
        }
        localRemoteViews.setViewVisibility(2131363175, 8);
        localRemoteViews.setViewVisibility(2131362352, 8);
        localRemoteViews.setViewVisibility(2131379179, 8);
        localRemoteViews.setViewVisibility(2131379180, 8);
        localRemoteViews.setViewVisibility(2131371068, 8);
        label296:
        if (localMail.getStatus().isConversation()) {
          localRemoteViews.setTextViewText(2131362352, localMail.getInformation().getConvCount() + "");
        }
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localRemoteViews.setTextViewText(2131379179, StringExtention.clipStringWithEllipse(((MailTag)((ArrayList)localObject).get(0)).getName(), 6));
          localRemoteViews.setTextColor(2131379179, QMUIHelper.getMailTagColorByColorId(this.mContext, ((MailTag)((ArrayList)localObject).get(0)).getColor()));
          if (((ArrayList)localObject).size() >= 2)
          {
            localRemoteViews.setTextViewText(2131379180, StringExtention.clipStringWithEllipse(((MailTag)((ArrayList)localObject).get(1)).getName(), 6));
            localRemoteViews.setTextColor(2131379180, QMUIHelper.getMailTagColorByColorId(this.mContext, ((MailTag)((ArrayList)localObject).get(1)).getColor()));
          }
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("EVENT_TYPE", 2);
        ((Intent)localObject).putExtra("MAIL_ID", localMail.getInformation().getId());
        ((Intent)localObject).putExtra("FOLDER_ID", localMail.getInformation().getFolderId());
        ((Intent)localObject).putExtra("SUBJECT", localMail.getInformation().getSubject());
        ((Intent)localObject).putExtra("RENDERNICK", localMail.getInformation().getFrom().getNick());
        ((Intent)localObject).putExtra("SENDEREMAIL", localMail.getInformation().getFrom().getAddress());
        ((Intent)localObject).putExtra("ACCOUNTID", localMail.getInformation().getAccountId());
        ((Intent)localObject).putExtra("ITEMSID", this.inboxWidgetManager.getDataSource().getItemIds());
        ((Intent)localObject).putExtra("AGGRTYPE", l);
        if (!localMail.getStatus().isConversation()) {
          break label946;
        }
        ((Intent)localObject).putExtra("MAIL_TYPE", 1);
      }
    }
    for (;;)
    {
      localRemoteViews.setOnClickFillInIntent(2131369126, (Intent)localObject);
      return localRemoteViews;
      if (localMail.getStatus().isSubscribeConv())
      {
        localRemoteViews.setImageViewBitmap(2131363175, BitmapFactory.decodeResource(this.mContext.getResources(), 2130838766));
        l = Mail.addAttrs(new Long[] { Long.valueOf(0L), Long.valueOf(8192L) });
        break;
        localObject = QMPrivateProtocolManager.getPhotoBitmapByEmail(localMail.getInformation().getFrom().getAddress(), 3);
        localRemoteViews.setImageViewBitmap(2131363175, this.qmAvatar.setAvatar((Bitmap)localObject, localMail.getInformation().getFrom().getName()));
      }
      l = 0L;
      break;
      label758:
      paramInt = 8;
      break label193;
      label764:
      paramInt = 8;
      break label214;
      label770:
      paramInt = 8;
      break label235;
      label776:
      localRemoteViews.setViewVisibility(2131363175, 0);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramInt = 0;
        label799:
        localRemoteViews.setViewVisibility(2131379179, paramInt);
        if ((localObject == null) || (((ArrayList)localObject).size() < 2)) {
          break label890;
        }
        paramInt = 0;
        label823:
        localRemoteViews.setViewVisibility(2131379180, paramInt);
        if (!localMail.getStatus().isConversation()) {
          break label896;
        }
      }
      label896:
      for (paramInt = 0;; paramInt = 8)
      {
        localRemoteViews.setViewVisibility(2131362352, paramInt);
        if (!localMail.getStatus().isForward()) {
          break label902;
        }
        localRemoteViews.setViewVisibility(2131371068, 0);
        localRemoteViews.setImageViewResource(2131371068, 2130841066);
        break;
        paramInt = 8;
        break label799;
        label890:
        paramInt = 8;
        break label823;
      }
      label902:
      if (localMail.getStatus().isReply())
      {
        localRemoteViews.setViewVisibility(2131371068, 0);
        localRemoteViews.setImageViewResource(2131371068, 2130841067);
        break label296;
      }
      localRemoteViews.setViewVisibility(2131371068, 8);
      break label296;
      label946:
      if (localMail.getStatus().isAdConv()) {
        ((Intent)localObject).putExtra("MAIL_TYPE", 3);
      } else if (localMail.getStatus().isSubscribeConv()) {
        ((Intent)localObject).putExtra("MAIL_TYPE", 4);
      } else {
        ((Intent)localObject).putExtra("MAIL_TYPE", 2);
      }
    }
  }
  
  public RemoteViews getViewAt(int paramInt)
  {
    RemoteViews localRemoteViews;
    Intent localIntent;
    switch (InboxWidgetRemoteViewsFactory.1.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[this.widgetState.ordinal()])
    {
    default: 
      if (this.inboxWidgetManager.isNull())
      {
        localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721887));
        return localRemoteViews;
      }
      break;
    case 1: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      if (this.fingerprintLock) {
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721883));
      }
      for (;;)
      {
        localIntent = new Intent();
        localIntent.putExtra("EVENT_TYPE", 1);
        localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
        return localRemoteViews;
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721881));
      }
    case 2: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721888));
      localIntent = new Intent();
      localIntent.putExtra("EVENT_TYPE", 4);
      localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
      return localRemoteViews;
    }
    if (this.inboxWidgetManager.getCount() == 0)
    {
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721884));
      return localRemoteViews;
    }
    if ((getCount() - 1 == paramInt) && (this.inboxWidgetManager.canLoadMore()))
    {
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      if (this.inboxWidgetManager.getLoadingState() == InboxWidgetManager.LoadingState.LODING)
      {
        localRemoteViews.setViewVisibility(2131370787, 0);
        localRemoteViews.setViewVisibility(2131381280, 8);
        return localRemoteViews;
      }
      localRemoteViews.setViewVisibility(2131370787, 8);
      localRemoteViews.setViewVisibility(2131381280, 0);
      if (this.inboxWidgetManager.getLoadingState() == InboxWidgetManager.LoadingState.ERROR) {
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721885));
      }
      for (;;)
      {
        localIntent = new Intent();
        localIntent.putExtra("EVENT_TYPE", 6);
        localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
        return localRemoteViews;
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721886));
      }
    }
    return getMailItemView(paramInt);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void onCreate()
  {
    this.inboxWidgetManager = InboxWidgetManager.getInstance();
    this.widgetState = this.inboxWidgetManager.getWidgetState();
    this.fingerprintLock = FingerprintFactory.createInstance().isAvailable();
    Log.i("InboxWidgetRemoteViewsFactory", "onCreate widgetState = " + this.widgetState);
  }
  
  public void onDataSetChanged()
  {
    this.widgetState = InboxWidgetManager.getInstance().getWidgetState();
    this.widgetSize = InboxWidgetManager.getInstance().getSizeWithID(this.mAppWidgetId);
    QMLog.log(4, "InboxWidgetRemoteViewsFactory", "onDataSetChanged widgetState = " + this.widgetState);
  }
  
  public void onDestroy()
  {
    Log.i("InboxWidgetRemoteViewsFactory", "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetRemoteViewsFactory
 * JD-Core Version:    0.7.0.1
 */