import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class atuv
{
  public static String TAG = "UniformDownloadNfn<FileAssistant>";
  private static NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  private static atuv jdField_a_of_type_Atuv;
  private long Ze;
  private jkd b;
  
  private atuv()
  {
    try
    {
      jdField_a_of_type_AndroidAppNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
      this.b = new jkd(BaseApplicationImpl.getContext());
      this.Ze = 123456L;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private int Eq()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  private int Er()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  private long F(int paramInt)
  {
    if (paramInt == 0) {
      return this.Ze - 30L;
    }
    if (1 == paramInt) {
      return this.Ze - 20L;
    }
    if (2 == paramInt) {
      return this.Ze - 10L;
    }
    if (3 == paramInt) {
      return this.Ze;
    }
    return System.currentTimeMillis();
  }
  
  public static atuv a()
  {
    if (jdField_a_of_type_Atuv == null) {
      jdField_a_of_type_Atuv = new atuv();
    }
    return jdField_a_of_type_Atuv;
  }
  
  public void D(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(TAG, 1, "[UniformDL]. sendPauseNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(TAG, 1, "[UniformDL]. sendPauseNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramBundle.getInt("_notify_param_Progress"));
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      c(paramInt, localNotification, paramBundle, localBundle);
      aglz.a().IX(paramBundle.getString("_notify_param_Url"));
      return;
    }
    QLog.e(TAG, 1, "[UniformDL]. sendPauseNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void E(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(TAG, 1, "[UniformDL]. sendStartAndWatingNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(TAG, 1, "[UniformDL]. sendStartAndWatingNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", 0);
    localBundle.putInt("_START_WAITING_", 1);
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      a(paramInt, localNotification, paramBundle, localBundle);
      atur.a().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
      return;
    }
    QLog.e(TAG, 1, "[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:" + paramInt);
  }
  
  public void F(int paramInt, Bundle paramBundle)
  {
    QLog.i(TAG, 1, "[UniformDL]. sendCancelNotification, NF id:" + paramInt);
    Of(paramInt);
    if (paramBundle != null) {
      aglz.a().IX(paramBundle.getString("_notify_param_Url"));
    }
  }
  
  protected void Of(int paramInt)
  {
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
  }
  
  public int a(ahcj paramahcj, Bundle paramBundle, long paramLong, int paramInt)
  {
    if (-1 == paramInt)
    {
      paramInt = Eq();
      QLog.i(TAG, 1, "[UniformDL][" + paramLong + "]. attachDownloader.notificationId = " + paramInt);
    }
    while (paramahcj != null)
    {
      paramahcj.a(new atuv.a(ThreadManager.getSubThreadHandler().getLooper(), paramInt, paramBundle, paramLong), false);
      return paramInt;
      QLog.w(TAG, 1, "[UniformDL][" + paramLong + "]. attachDownloader.here will using notificationid,maybe is not uinform id");
    }
    QLog.e(TAG, 1, "[UniformDL][" + paramLong + "]. attachDownloader.dler = null. notificationId = " + paramInt);
    return paramInt;
  }
  
  public Notification a(Bundle paramBundle)
  {
    Notification localNotification = new Notification();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("_notify_param_ContentTitle");
      localNotification.icon = 2130842251;
      localNotification.iconLevel = 1;
      RemoteViews localRemoteViews = new RemoteViews(BaseApplication.getContext().getPackageName(), 2131561058);
      localRemoteViews.setImageViewResource(2131372529, 2130840732);
      localRemoteViews.setTextViewText(2131372540, paramBundle);
      localRemoteViews.setProgressBar(2131372522, 100, 0, false);
      localRemoteViews.setViewVisibility(2131372528, 8);
      localRemoteViews.setViewVisibility(2131372523, 8);
      float f1 = this.b.getTextSize();
      if (this.b.getTextSize() <= 0.0F)
      {
        QLog.w(TAG, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
        f1 = 14.0F;
      }
      localRemoteViews.setFloat(2131372528, "setTextSize", f1);
      localRemoteViews.setFloat(2131372524, "setTextSize", f1);
      float f2 = this.b.ae();
      f1 = f2;
      if (f2 <= 0.0F)
      {
        QLog.w(TAG, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
        f1 = 16.0F;
      }
      localRemoteViews.setFloat(2131372540, "setTextSize", f1);
      localNotification.contentView = localRemoteViews;
      return localNotification;
    }
    QLog.e(TAG, 1, "[UniformDL]. getNfn param error, NF");
    return null;
  }
  
  protected void a(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(TAG, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    label312:
    label324:
    label336:
    for (;;)
    {
      return;
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131721521) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setImageViewResource(2131372529, 2130840732);
      int i = paramBundle2.getInt("_START_WAITING_");
      if (1 == i)
      {
        paramNotification.contentView.setTextViewText(2131372524, BaseApplication.getContext().getString(2131721522));
        paramNotification.contentView.setViewVisibility(2131372523, 0);
        paramNotification.contentView.setViewVisibility(2131372528, 8);
        paramNotification.contentView.setProgressBar(2131372522, 100, 0, false);
        paramNotification.flags = 34;
        paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
        paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
        paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
        paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
        if (1 != i) {
          break label312;
        }
        paramNotification.when = F(2);
        label235:
        if (Build.VERSION.SDK_INT >= 11) {
          break label324;
        }
        paramNotification.contentIntent = paramBundle1;
      }
      for (;;)
      {
        if (jdField_a_of_type_AndroidAppNotificationManager == null) {
          break label336;
        }
        try
        {
          QLog.i(TAG, 1, "nfnStart nid=" + paramInt);
          jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setTextViewText(2131372524, "0%");
        break;
        paramNotification.when = F(3);
        break label235;
        paramNotification.contentView.setOnClickPendingIntent(2131372530, paramBundle1);
      }
    }
  }
  
  protected void b(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(TAG, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131372529, 2130840732);
      paramNotification.contentView.setViewVisibility(2131372528, 8);
      paramNotification.contentView.setViewVisibility(2131372523, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131372522, 100, i, false);
      paramNotification.contentView.setTextViewText(2131372524, "" + i + "%");
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramNotification.when = F(3);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_AndroidAppNotificationManager != null)
      {
        try
        {
          QLog.i(TAG, 1, "nfnUpdate nid=" + paramInt);
          jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131372530, paramBundle1);
      }
    }
  }
  
  protected void c(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(TAG, 1, "[UniformDL]. nfnPUASE, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
    paramNotification.tickerText = null;
    int i = paramBundle2.getInt("_FILE_PROGRESS_");
    paramNotification.contentView.setImageViewResource(2131372529, 2130840732);
    paramNotification.contentView.setViewVisibility(2131372528, 0);
    paramNotification.contentView.setViewVisibility(2131372523, 8);
    paramNotification.contentView.setTextViewText(2131372528, BaseApplication.getContext().getString(2131721520));
    paramNotification.contentView.setProgressBar(2131372522, 100, i, false);
    paramNotification.contentView.setTextViewText(2131372524, "" + i + "%");
    paramNotification.flags = 16;
    paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
    paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
    paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
    paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
    paramNotification.when = F(1);
    if (Build.VERSION.SDK_INT < 11) {
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      if (jdField_a_of_type_AndroidAppNotificationManager == null) {
        break;
      }
      try
      {
        QLog.i(TAG, 1, "nfnPause nid=" + paramInt);
        jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.contentView.setOnClickPendingIntent(2131372530, paramBundle2);
    }
  }
  
  protected void c(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(TAG, 1, "[UniformDL]. nfnSUCESS, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
    Notification localNotification = a(paramBundle1);
    String str1 = paramBundle2.getString("_FILE_PATH_");
    paramBundle2.getLong("_FILE_SIZE_");
    paramInt = paramBundle2.getInt("_NEW_N_ID_");
    String str2 = paramBundle2.getString("_PKG_NAME_");
    localNotification.tickerText = (BaseApplication.getContext().getString(2131721515) + " " + paramBundle1.getString("_notify_param_Filename"));
    Bitmap localBitmap = null;
    paramBundle2 = BaseApplication.getContext().getString(2131721517);
    if (ahch.lh(str1) != null)
    {
      localBitmap = ahch.C(str1);
      paramBundle2 = BaseApplication.getContext().getString(2131721516);
    }
    if (localBitmap == null)
    {
      int i = audx.r(str1);
      if (i != 0) {
        localNotification.contentView.setImageViewResource(2131372529, i);
      }
    }
    for (;;)
    {
      localNotification.contentView.setViewVisibility(2131372528, 0);
      localNotification.contentView.setViewVisibility(2131372523, 8);
      localNotification.contentView.setTextViewText(2131372528, paramBundle2);
      localNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_FILEPATH", str1);
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", paramInt);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", paramInt);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      localNotification.when = F(0);
      if (jdField_a_of_type_AndroidAppNotificationManager == null) {
        break;
      }
      QLog.i(TAG, 1, "[UniformDL]. NF_SUC, NF. newNId = " + paramInt + " url:" + paramBundle1.getString("_notify_param_Url"));
      try
      {
        QLog.i(TAG, 1, "nfnSuccess nid=" + paramInt);
        jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, localNotification);
        return;
      }
      catch (Exception paramBundle1)
      {
        paramBundle1.printStackTrace();
        return;
      }
      localNotification.contentView.setImageViewResource(2131372529, 2130840732);
      continue;
      localNotification.contentView.setImageViewBitmap(2131372529, localBitmap);
    }
  }
  
  protected void d(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(TAG, 1, "[UniformDL]. nfnFAILED, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
    paramNotification.contentView.setViewVisibility(2131372523, 8);
    int i = paramBundle2.getInt("_FILE_ERR_CODE_");
    if (2 == i)
    {
      paramNotification.tickerText = BaseApplication.getContext().getString(2131721519);
      paramNotification.contentView.setTextViewText(2131372528, BaseApplication.getContext().getString(2131721519));
      label114:
      paramNotification.contentView.setImageViewResource(2131372529, 2130840732);
      paramNotification.contentView.setViewVisibility(2131372528, 0);
      paramNotification.contentView.setTextViewText(2131372524, " ");
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramNotification.when = F(1);
      if (Build.VERSION.SDK_INT >= 11) {
        break label408;
      }
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      if (jdField_a_of_type_AndroidAppNotificationManager == null) {
        break;
      }
      try
      {
        QLog.i(TAG, 1, "nfnFailed nid=" + paramInt);
        jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131721518) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setTextViewText(2131372528, ahcj.em(i) + "，点击重试");
      break label114;
      label408:
      paramNotification.contentView.setOnClickPendingIntent(2131372530, paramBundle2);
    }
  }
  
  protected void e(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(TAG, 1, "[UniformDL]. nfnRESUME, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      if (jdField_a_of_type_AndroidAppNotificationManager != null) {
        jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
      }
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131372529, 2130840732);
      paramNotification.contentView.setViewVisibility(2131372528, 8);
      paramNotification.contentView.setViewVisibility(2131372523, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131372522, 100, i, false);
      paramNotification.contentView.setTextViewText(2131372524, BaseApplication.getContext().getString(2131721522));
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramNotification.when = F(2);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_AndroidAppNotificationManager != null)
      {
        try
        {
          QLog.i(TAG, 1, "nfnResume nid=" + paramInt);
          jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131372530, paramBundle1);
      }
    }
  }
  
  class a
    extends Handler
    implements ahcj.b
  {
    final long Zd;
    final Bundle aX;
    int cXO = 0;
    int cXP = 0;
    final int mId;
    Notification mNotification;
    
    public a(Looper paramLooper, int paramInt, Bundle paramBundle, long paramLong)
    {
      super();
      this.mId = paramInt;
      this.aX = ((Bundle)paramBundle.clone());
      this.Zd = paramLong;
      this.aX.putInt("_notify_param_Id", this.mId);
      if (this.aX != null)
      {
        this.mNotification = atuv.this.a(paramBundle);
        return;
      }
      QLog.e(atuv.TAG, 1, "[UniformDL][" + paramLong + "]. notify runable, param is null");
    }
    
    public void a(String paramString, long paramLong, Bundle paramBundle)
    {
      int i = atuv.a(atuv.this);
      paramBundle = ahch.lh(paramString);
      if (paramBundle != null) {
        atur.a().a(new atur.c(paramBundle, i));
      }
      QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadSucess, NF");
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      Bundle localBundle = new Bundle();
      localBundle.putString("_FILE_PATH_", paramString);
      localBundle.putLong("_FILE_SIZE_", paramLong);
      localBundle.putInt("_NEW_N_ID_", i);
      if (paramBundle != null) {
        localBundle.putString("_PKG_NAME_", paramBundle);
      }
      localMessage.setData(localBundle);
      if (!sendMessage(localMessage)) {
        QLog.e(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadSucess, sendMessage failed, NF");
      }
    }
    
    public void b(int paramInt, String paramString, Bundle paramBundle)
    {
      QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadFailed, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 5;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_ERR_CODE_", paramInt);
      localBundle.putString("_FILE_ERR_STRING_", paramString);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadFailed, sendMessage failed, NF");
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = false;
      super.handleMessage(paramMessage);
      Object localObject = paramMessage.getData();
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        this.cXO = paramMessage.what;
        return;
        QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_START, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        atuv.this.a(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        int i = ((Bundle)localObject).getInt("_START_WAITING_");
        localObject = atur.a();
        String str1 = this.aX.getString("_notify_param_Url");
        String str2 = this.aX.getString("_notify_param_Filename");
        long l = this.aX.getLong("_notify_param_Filesize");
        Bundle localBundle = this.aX.getBundle("_notify_param_userdata");
        int j = this.mId;
        if (i == 1) {
          bool = true;
        }
        ((atur)localObject).a(str1, str2, l, localBundle, j, bool);
        this.cXP = 1;
        continue;
        atuv.this.b(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        if (2 != this.cXP) {
          atur.a().a(this.aX.getString("_notify_param_Url"), this.aX.getString("_notify_param_Filename"), this.aX.getLong("_notify_param_Filesize"), this.aX.getBundle("_notify_param_userdata"), this.mId, false);
        }
        this.cXP = 2;
        continue;
        QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_PAUSE, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        atuv.this.c(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
        this.cXP = 3;
        continue;
        QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_SUC, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        atuv.this.c(this.mId, this.aX, (Bundle)localObject);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
        this.cXP = 4;
        continue;
        atuv.this.d(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
        this.cXP = 5;
        continue;
        QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_RESUME, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        atuv.this.e(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        atur.a().a(this.aX.getString("_notify_param_Url"), this.aX.getString("_notify_param_Filename"), this.aX.getLong("_notify_param_Filesize"), this.aX.getBundle("_notify_param_userdata"), this.mId, true);
        this.cXP = 7;
        continue;
        QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_CLR, NF. NId = " + this.mId);
        atuv.this.Of(this.mId);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
      }
    }
    
    public void p(int paramInt, Bundle paramBundle)
    {
      QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadStart, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 1;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      localBundle.putInt("_START_WAITING_", 0);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadStart, sendMessage failed, NF");
      }
    }
    
    public void q(int paramInt, Bundle paramBundle)
    {
      paramBundle = Message.obtain();
      paramBundle.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadProgress, sendMessage failed, NF");
      }
    }
    
    public void r(int paramInt, Bundle paramBundle)
    {
      QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadPause, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 3;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadPause, sendMessage failed, NF");
      }
    }
    
    public void s(int paramInt, Bundle paramBundle)
    {
      QLog.i(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadResume progress=" + paramInt + ", NF ");
      paramBundle = Message.obtain();
      paramBundle.what = 7;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(atuv.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadResume, sendMessage failed, NF");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuv
 * JD-Core Version:    0.7.0.1
 */