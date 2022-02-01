package com.tencent.qqmail.widget.notelist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;
import com.tencent.qqmail.widget.QMWidgetDataManager.WidgetState;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class NoteWidgetRemoteViewsFactory
  implements RemoteViewsService.RemoteViewsFactory
{
  private static final String TAG = NoteWidgetRemoteViewsFactory.class.getName();
  private boolean fingerprintLock = false;
  private int mAppWidgetId;
  private Context mContext;
  private NoteUI mNoteUI;
  public String mTimeCaption = "0";
  private boolean noteUIEmpty = false;
  private NoteWidgetManager noteWidgetManager;
  private int widgetSize = 4;
  private QMWidgetDataManager.WidgetState widgetState;
  
  public NoteWidgetRemoteViewsFactory(Context paramContext, Intent paramIntent)
  {
    this.mContext = paramContext;
    this.mAppWidgetId = paramIntent.getIntExtra("appWidgetId", 0);
  }
  
  private Intent createIntent(int paramInt, NoteUI paramNoteUI)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("position", paramInt);
    if (paramNoteUI != null)
    {
      paramNoteUI = paramNoteUI.getNoteId();
      if (paramNoteUI != null) {
        localIntent.putExtra("noteId", paramNoteUI);
      }
    }
    if (this.mNoteUI != null) {
      localIntent.putExtra("noteList", this.mNoteUI.toNoteIds());
    }
    paramNoteUI = QMApplicationContext.sharedInstance().getString(2131690287);
    if (paramNoteUI != null) {
      localIntent.putExtra("catalogName", paramNoteUI);
    }
    return localIntent;
  }
  
  private void readTimeCaption()
  {
    this.mTimeCaption = NoteStorage.readSortType();
  }
  
  public int getCount()
  {
    if ((this.mNoteUI != null) && (!this.noteUIEmpty) && (this.widgetState == QMWidgetDataManager.WidgetState.AVAILABLE)) {
      return this.mNoteUI.size();
    }
    return 1;
  }
  
  public NoteUI getItem(int paramInt)
  {
    if (this.mNoteUI == null) {
      return null;
    }
    this.mNoteUI.moveToPosition(paramInt);
    return this.mNoteUI;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public RemoteViews getLoadingView()
  {
    return null;
  }
  
  public RemoteViews getNoteItemView(int paramInt)
  {
    NoteUI localNoteUI = getItem(paramInt);
    RemoteViews localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563366);
    if (localNoteUI == null)
    {
      localRemoteViews.setViewVisibility(2131369468, 8);
      return localRemoteViews;
    }
    Object localObject1;
    label70:
    label106:
    int i;
    label148:
    label285:
    Object localObject2;
    boolean bool;
    if (localNoteUI.getStarred())
    {
      localRemoteViews.setViewVisibility(2131372510, 0);
      if (localNoteUI.getAbstract() != null) {
        break label468;
      }
      localObject1 = "";
      if (((String)localObject1).length() <= 0) {
        break label496;
      }
      localRemoteViews.setTextViewText(2131372508, (String)localObject1 + QMUIKit.ELLIPSIZE_FIXED);
      if (localNoteUI.getSubject().length() <= 0) {
        break label515;
      }
      localRemoteViews.setTextViewText(2131372511, localNoteUI.getSubject() + QMUIKit.ELLIPSIZE_FIXED);
      double d = localNoteUI.getUpdatetime();
      if (StringUtils.equals(this.mTimeCaption, "1")) {
        d = localNoteUI.getCreateTime();
      }
      localRemoteViews.setTextViewText(2131372509, DateExtension.shortDateName(new Date(d * 1000L)));
      if ((localNoteUI.getThumbUrl() == null) || ("".equals(localNoteUI.getThumbUrl()))) {
        break label601;
      }
      localObject1 = localNoteUI.getThumbUrl().replaceAll("^\\s*file://localhost", "file://").replaceAll("&amp;", "&");
      QMLog.log(4, "alger thumbnail", (String)localObject1);
      localRemoteViews.setViewVisibility(2131379636, 8);
      localRemoteViews.setViewVisibility(2131379637, 0);
      localRemoteViews.setImageViewResource(2131379637, 2130841019);
      if (ImageDownloadManager.shareInstance().isThumbBitmapExistLocal((String)localObject1) == 0) {
        break label534;
      }
      i = 1;
      if (i == 0) {
        break label546;
      }
      localObject2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject1);
      if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled()))
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("bitmap recycled ");
        if (localObject2 != null) {
          break label540;
        }
        bool = true;
        label341:
        QMLog.log(6, str, bool + " exit status " + ImageDownloadManager.shareInstance().isThumbBitmapExistLocal((String)localObject1));
      }
      if (localObject2 != null)
      {
        localRemoteViews.setImageViewBitmap(2131379637, (Bitmap)localObject2);
        Log.v(TAG, "set Exist thumbImg");
      }
    }
    for (;;)
    {
      if (this.widgetSize <= 2)
      {
        localRemoteViews.setViewVisibility(2131379636, 8);
        localRemoteViews.setViewVisibility(2131379637, 8);
      }
      localObject1 = createIntent(paramInt, localNoteUI);
      ((Intent)localObject1).putExtra("EVENT_TYPE", 2);
      localRemoteViews.setOnClickFillInIntent(2131369468, (Intent)localObject1);
      return localRemoteViews;
      localRemoteViews.setViewVisibility(2131372510, 8);
      break;
      label468:
      localObject1 = localNoteUI.getAbstract().replaceAll("<br\\s*/?>", "\n").replaceAll("&nb(sp;|sp|s)?$", " ");
      break label70;
      label496:
      localRemoteViews.setTextViewText(2131372508, QMApplicationContext.sharedInstance().getString(2131696411));
      break label106;
      label515:
      localRemoteViews.setTextViewText(2131372511, QMApplicationContext.sharedInstance().getString(2131696420));
      break label148;
      label534:
      i = 0;
      break label285;
      label540:
      bool = false;
      break label341;
      label546:
      localObject2 = new DownloadInfo();
      ((DownloadInfo)localObject2).setAccountId(NoteManager.sharedInstance().mCurAccountId);
      ((DownloadInfo)localObject2).setUrl((String)localObject1);
      ((DownloadInfo)localObject2).setImageDownloadListener(new NoteWidgetRemoteViewsFactory.1(this, paramInt, localRemoteViews));
      ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject2);
      continue;
      label601:
      if (!localNoteUI.getAudio().equals("0"))
      {
        localRemoteViews.setViewVisibility(2131379636, 0);
        localRemoteViews.setViewVisibility(2131379637, 8);
        localRemoteViews.setImageViewResource(2131379636, 2130841020);
      }
      else
      {
        localRemoteViews.setViewVisibility(2131379637, 8);
        localRemoteViews.setViewVisibility(2131379636, 8);
      }
    }
  }
  
  public RemoteViews getViewAt(int paramInt)
  {
    RemoteViews localRemoteViews;
    Intent localIntent;
    switch (NoteWidgetRemoteViewsFactory.2.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[this.widgetState.ordinal()])
    {
    default: 
      if (this.noteUIEmpty)
      {
        localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563367);
        localIntent = new Intent();
        localIntent.putExtra("EVENT_TYPE", 3);
        localRemoteViews.setOnClickFillInIntent(2131362203, localIntent);
        return localRemoteViews;
      }
      break;
    case 1: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721889));
      localIntent = new Intent();
      localIntent.putExtra("EVENT_TYPE", 4);
      localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
      return localRemoteViews;
    case 2: 
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
    case 3: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721890));
      localIntent = new Intent();
      localIntent.putExtra("EVENT_TYPE", 5);
      localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
      return localRemoteViews;
    case 4: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721882));
      localIntent = new Intent();
      localIntent.putExtra("EVENT_TYPE", 1);
      localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
      return localRemoteViews;
    }
    return getNoteItemView(paramInt);
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onCreate()
  {
    this.noteWidgetManager = NoteWidgetManager.getInstance();
    this.widgetState = this.noteWidgetManager.getWidgetState();
    this.fingerprintLock = FingerprintFactory.createInstance().isAvailable();
  }
  
  /* Error */
  public void onDataSetChanged()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 379	com/tencent/qqmail/widget/notelist/NoteWidgetManager:getInstance	()Lcom/tencent/qqmail/widget/notelist/NoteWidgetManager;
    //   4: invokevirtual 385	com/tencent/qqmail/widget/notelist/NoteWidgetManager:getWidgetState	()Lcom/tencent/qqmail/widget/QMWidgetDataManager$WidgetState;
    //   7: putfield 114	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:widgetState	Lcom/tencent/qqmail/widget/QMWidgetDataManager$WidgetState;
    //   10: aload_0
    //   11: invokestatic 379	com/tencent/qqmail/widget/notelist/NoteWidgetManager:getInstance	()Lcom/tencent/qqmail/widget/notelist/NoteWidgetManager;
    //   14: aload_0
    //   15: getfield 60	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:mAppWidgetId	I
    //   18: invokevirtual 403	com/tencent/qqmail/widget/notelist/NoteWidgetManager:getSizeWithID	(I)I
    //   21: putfield 46	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:widgetSize	I
    //   24: iconst_4
    //   25: getstatic 33	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:TAG	Ljava/lang/String;
    //   28: new 170	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 405
    //   38: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 114	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:widgetState	Lcom/tencent/qqmail/widget/QMWidgetDataManager$WidgetState;
    //   45: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 246	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   54: invokestatic 414	android/os/Binder:clearCallingIdentity	()J
    //   57: lstore_1
    //   58: aload_0
    //   59: invokespecial 416	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:readTimeCaption	()V
    //   62: aload_0
    //   63: invokestatic 319	com/tencent/qqmail/model/NoteManager:sharedInstance	()Lcom/tencent/qqmail/model/NoteManager;
    //   66: ldc_w 418
    //   69: invokevirtual 422	com/tencent/qqmail/model/NoteManager:readNoteUIByCategoryId	(Ljava/lang/String;)Lcom/tencent/qqmail/model/uidomain/NoteUI;
    //   72: putfield 82	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:mNoteUI	Lcom/tencent/qqmail/model/uidomain/NoteUI;
    //   75: getstatic 33	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:TAG	Ljava/lang/String;
    //   78: new 170	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 424
    //   88: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 82	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:mNoteUI	Lcom/tencent/qqmail/model/uidomain/NoteUI;
    //   95: invokevirtual 122	com/tencent/qqmail/model/uidomain/NoteUI:size	()I
    //   98: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 427	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   107: pop
    //   108: aload_0
    //   109: getfield 82	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:mNoteUI	Lcom/tencent/qqmail/model/uidomain/NoteUI;
    //   112: invokevirtual 122	com/tencent/qqmail/model/uidomain/NoteUI:size	()I
    //   115: ifne +15 -> 130
    //   118: iconst_1
    //   119: istore_3
    //   120: aload_0
    //   121: iload_3
    //   122: putfield 40	com/tencent/qqmail/widget/notelist/NoteWidgetRemoteViewsFactory:noteUIEmpty	Z
    //   125: lload_1
    //   126: invokestatic 430	android/os/Binder:restoreCallingIdentity	(J)V
    //   129: return
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -12 -> 120
    //   135: astore 4
    //   137: aload 4
    //   139: invokevirtual 433	java/lang/Exception:printStackTrace	()V
    //   142: lload_1
    //   143: invokestatic 430	android/os/Binder:restoreCallingIdentity	(J)V
    //   146: return
    //   147: astore 4
    //   149: lload_1
    //   150: invokestatic 430	android/os/Binder:restoreCallingIdentity	(J)V
    //   153: aload 4
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	NoteWidgetRemoteViewsFactory
    //   57	93	1	l	long
    //   119	13	3	bool	boolean
    //   135	3	4	localException	java.lang.Exception
    //   147	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   58	118	135	java/lang/Exception
    //   120	125	135	java/lang/Exception
    //   58	118	147	finally
    //   120	125	147	finally
    //   137	142	147	finally
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.notelist.NoteWidgetRemoteViewsFactory
 * JD-Core Version:    0.7.0.1
 */