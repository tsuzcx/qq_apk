import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class agme
{
  public static String TAG = "UniformDownloadNfn<FileAssistant>";
  private static agme jdField_a_of_type_Agme;
  private static QQNotificationManager c;
  private long Ze;
  private agme.b jdField_a_of_type_Agme$b;
  private int cXN = 278;
  
  private agme()
  {
    try
    {
      c = QQNotificationManager.getInstance();
      this.jdField_a_of_type_Agme$b = new agme.b(BaseApplicationImpl.getContext());
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
    try
    {
      int i = this.cXN;
      QLog.e(TAG, 1, "genNID : notificationId[" + i + "]");
      this.cXN += 1;
      if (this.cXN > 377)
      {
        this.cXN = 278;
        QLog.e(TAG, 1, "genNID : notificationId is reach to the max Id.");
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
  
  public static agme a()
  {
    if (jdField_a_of_type_Agme == null) {
      jdField_a_of_type_Agme = new agme();
    }
    return jdField_a_of_type_Agme;
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
      aglz.a().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getString("_notify_param_ContentTitle", ""), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
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
    if (c != null) {
      c.cancel(TAG, paramInt);
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
      paramahcj.a(new agme.a(ThreadManager.getSubThreadHandler().getLooper(), paramInt, paramBundle, paramLong), false);
      return paramInt;
      QLog.w(TAG, 1, "[UniformDL][" + paramLong + "]. attachDownloader.here will using notificationid,maybe is not uinform id");
    }
    QLog.e(TAG, 1, "[UniformDL][" + paramLong + "]. attachDownloader.dler = null. notificationId = " + paramInt);
    return paramInt;
  }
  
  public Notification a(Bundle paramBundle)
  {
    Object localObject1 = new NotificationCompat.Builder(BaseApplication.getContext());
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      ((NotificationCompat.Builder)localObject1).setChannelId("CHANNEL_ID_OTHER");
    }
    localObject1 = ((NotificationCompat.Builder)localObject1).build();
    if (paramBundle != null)
    {
      Object localObject2 = paramBundle.getString("_notify_param_ContentTitle");
      ((Notification)localObject1).icon = 2130845243;
      paramBundle = new RemoteViews(BaseApplication.getContext().getPackageName(), 2131561058);
      paramBundle.setImageViewResource(2131372529, 2130845239);
      paramBundle.setTextViewText(2131372540, (CharSequence)localObject2);
      paramBundle.setProgressBar(2131372522, 100, 0, false);
      paramBundle.setViewVisibility(2131372528, 8);
      paramBundle.setViewVisibility(2131372523, 8);
      paramBundle.setTextColor(2131372540, -7829368);
      paramBundle.setTextColor(2131372528, -7829368);
      paramBundle.setTextColor(2131372524, -7829368);
      float f1 = this.jdField_a_of_type_Agme$b.getTextSize();
      if (this.jdField_a_of_type_Agme$b.getTextSize() <= 0.0F)
      {
        QLog.w(TAG, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
        f1 = 14.0F;
      }
      paramBundle.setFloat(2131372528, "setTextSize", f1);
      paramBundle.setFloat(2131372524, "setTextSize", f1);
      float f2 = this.jdField_a_of_type_Agme$b.ae();
      f1 = f2;
      if (f2 <= 0.0F)
      {
        QLog.w(TAG, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
        f1 = 16.0F;
      }
      paramBundle.setFloat(2131372540, "setTextSize", f1);
      localObject2 = BaseApplication.getContext().getApplicationInfo();
      if ((localObject2 != null) && (((ApplicationInfo)localObject2).targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
      try
      {
        int i = this.jdField_a_of_type_Agme$b.h().intValue();
        paramBundle.setInt(2131372530, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
        ((Notification)localObject1).contentView = paramBundle;
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    QLog.e(TAG, 1, "[UniformDL]. getNfn param error, NF");
    return null;
  }
  
  protected void a(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(TAG, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    label300:
    label312:
    label324:
    for (;;)
    {
      return;
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131721521) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setImageViewResource(2131372529, 2130845239);
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
        paramBundle2.putExtra("param_notifyid", paramInt);
        paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
        if (1 != i) {
          break label300;
        }
        paramNotification.when = F(2);
        label247:
        if (Build.VERSION.SDK_INT >= 11) {
          break label312;
        }
        paramNotification.contentIntent = paramBundle1;
      }
      for (;;)
      {
        if (c == null) {
          break label324;
        }
        try
        {
          c.notify(TAG, paramInt, paramNotification);
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
        break label247;
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
      paramNotification.contentView.setImageViewResource(2131372529, 2130845239);
      paramNotification.contentView.setViewVisibility(2131372528, 8);
      paramNotification.contentView.setViewVisibility(2131372523, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131372522, 100, i, false);
      paramNotification.contentView.setTextViewText(2131372524, "" + i + "%");
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramNotification.when = F(3);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (c != null)
      {
        try
        {
          c.notify(TAG, paramInt, paramNotification);
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
    if (c != null) {
      c.cancel(TAG, paramInt);
    }
    paramNotification.tickerText = null;
    int i = paramBundle2.getInt("_FILE_PROGRESS_");
    paramNotification.contentView.setImageViewResource(2131372529, 2130845242);
    paramNotification.contentView.setViewVisibility(2131372528, 0);
    paramNotification.contentView.setViewVisibility(2131372523, 8);
    paramNotification.contentView.setTextViewText(2131372528, BaseApplication.getContext().getString(2131721520));
    paramNotification.contentView.setProgressBar(2131372522, 100, i, false);
    paramNotification.contentView.setTextViewText(2131372524, "" + i + "%");
    paramNotification.flags = 16;
    paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
    paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
    paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
    paramBundle2.putExtra("param_notifyid", paramInt);
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
      if (c == null) {
        break;
      }
      try
      {
        c.notify(TAG, paramInt, paramNotification);
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
    if (c != null) {
      c.cancel(TAG, paramInt);
    }
    Notification localNotification = a(paramBundle1);
    String str1 = paramBundle2.getString("_FILE_PATH_");
    paramBundle2.getLong("_FILE_SIZE_");
    int i = paramBundle2.getInt("_NEW_N_ID_");
    String str2 = paramBundle2.getString("_PKG_NAME_");
    localNotification.tickerText = (BaseApplication.getContext().getString(2131721515) + " " + paramBundle1.getString("_notify_param_Filename"));
    Object localObject = paramBundle1.getBundle("_notify_param_userdata");
    paramBundle2 = "";
    if (localObject != null) {
      paramBundle2 = ((Bundle)localObject).getString("big_brother_source_key", "");
    }
    Bitmap localBitmap = null;
    localObject = BaseApplication.getContext().getString(2131721517);
    if (ahch.lh(str1) != null)
    {
      localBitmap = ahch.C(str1);
      localObject = BaseApplication.getContext().getString(2131721516);
    }
    if (localBitmap == null)
    {
      int j = ahav.r(str1);
      if (j != 0)
      {
        localNotification.contentView.setImageViewResource(2131372529, j);
        label233:
        localNotification.contentView.setImageViewResource(2131372529, 2130845241);
      }
    }
    for (;;)
    {
      localNotification.contentView.setViewVisibility(2131372528, 0);
      localNotification.contentView.setViewVisibility(2131372523, 8);
      localNotification.contentView.setTextViewText(2131372528, (CharSequence)localObject);
      localNotification.flags = 16;
      localObject = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("_PARAM_FILEPATH", str1);
      ((Intent)localObject).putExtra("_PARAM_DL_SUC_NEW_NID", i);
      ((Intent)localObject).putExtra("param_notifyid", paramInt);
      if (!TextUtils.isEmpty(paramBundle2)) {
        ((Intent)localObject).putExtra("big_brother_source_key", paramBundle2);
      }
      if (str2 != null) {
        ((Intent)localObject).putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), (Intent)localObject, 134217728);
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", i);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      localNotification.when = F(0);
      if (c == null) {
        break;
      }
      QLog.i(TAG, 1, "[UniformDL]. NF_SUC, NF. newNId = " + i + " url:" + paramBundle1.getString("_notify_param_Url"));
      try
      {
        c.notify(TAG, i, localNotification);
        return;
      }
      catch (Exception paramBundle1)
      {
        paramBundle1.printStackTrace();
        return;
      }
      localNotification.contentView.setImageViewResource(2131372529, 2130845241);
      break label233;
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
    if (c != null) {
      c.cancel(TAG, paramInt);
    }
    paramNotification.contentView.setViewVisibility(2131372523, 8);
    int i = paramBundle2.getInt("_FILE_ERR_CODE_");
    if (2 == i)
    {
      paramNotification.tickerText = BaseApplication.getContext().getString(2131721519);
      paramNotification.contentView.setTextViewText(2131372528, BaseApplication.getContext().getString(2131721519));
      label117:
      paramNotification.contentView.setImageViewResource(2131372529, 2130845240);
      paramNotification.contentView.setViewVisibility(2131372528, 0);
      paramNotification.contentView.setTextViewText(2131372524, " ");
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramNotification.when = F(1);
      if (Build.VERSION.SDK_INT >= 11) {
        break label402;
      }
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      if (c == null) {
        break;
      }
      try
      {
        c.notify(TAG, paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131721518) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setTextViewText(2131372528, ahcj.em(i) + acfp.m(2131716228));
      break label117;
      label402:
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
      if (c != null) {
        c.cancel(TAG, paramInt);
      }
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131372529, 2130845239);
      paramNotification.contentView.setViewVisibility(2131372528, 8);
      paramNotification.contentView.setViewVisibility(2131372523, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131372522, 100, i, false);
      paramNotification.contentView.setTextViewText(2131372524, BaseApplication.getContext().getString(2131721522));
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), Er(), paramBundle2, 134217728);
      paramNotification.when = F(2);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (c != null)
      {
        try
        {
          c.notify(TAG, paramInt, paramNotification);
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
        this.mNotification = agme.this.a(paramBundle);
        return;
      }
      QLog.e(agme.TAG, 1, "[UniformDL][" + paramLong + "]. notify runable, param is null");
    }
    
    public void a(String paramString, long paramLong, Bundle paramBundle)
    {
      int i = agme.a(agme.this);
      String str = ahch.lh(paramString);
      if (str != null)
      {
        localObject = new aglz.c(str, i);
        paramBundle = paramBundle.getBundle("_CB_USERDATA");
        if (paramBundle != null)
        {
          ((aglz.c)localObject).bIe = paramBundle.getString("_open_with_qq_browser_", "");
          paramBundle = paramBundle.getString("params_open_with_yyb", "");
          if (!TextUtils.isEmpty(paramBundle)) {
            ((aglz.c)localObject).aW.putString("params_open_with_yyb", paramBundle);
          }
        }
        aglz.a().a((aglz.c)localObject);
      }
      QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadSucess, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 4;
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("_FILE_PATH_", paramString);
      ((Bundle)localObject).putLong("_FILE_SIZE_", paramLong);
      ((Bundle)localObject).putInt("_NEW_N_ID_", i);
      if (str != null) {
        ((Bundle)localObject).putString("_PKG_NAME_", str);
      }
      paramBundle.setData((Bundle)localObject);
      if (!sendMessage(paramBundle)) {
        QLog.e(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadSucess, sendMessage failed, NF");
      }
    }
    
    public void b(int paramInt, String paramString, Bundle paramBundle)
    {
      QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadFailed, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 5;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_ERR_CODE_", paramInt);
      localBundle.putString("_FILE_ERR_STRING_", paramString);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadFailed, sendMessage failed, NF");
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
        QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_START, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        agme.this.a(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        int i = ((Bundle)localObject).getInt("_START_WAITING_");
        localObject = aglz.a();
        String str1 = this.aX.getString("_notify_param_Url");
        String str2 = this.aX.getString("_notify_param_Filename");
        String str3 = this.aX.getString("_notify_param_ContentTitle", "");
        long l = this.aX.getLong("_notify_param_Filesize");
        Bundle localBundle = this.aX.getBundle("_notify_param_userdata");
        int j = this.mId;
        if (i == 1) {
          bool = true;
        }
        ((aglz)localObject).a(str1, str2, str3, l, localBundle, j, bool);
        this.cXP = 1;
        continue;
        agme.this.b(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        if (2 != this.cXP) {
          aglz.a().a(this.aX.getString("_notify_param_Url"), this.aX.getString("_notify_param_Filename"), this.aX.getString("_notify_param_ContentTitle", ""), this.aX.getLong("_notify_param_Filesize"), this.aX.getBundle("_notify_param_userdata"), this.mId, false);
        }
        this.cXP = 2;
        continue;
        QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_PAUSE, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        agme.this.c(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
        this.cXP = 3;
        continue;
        QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_SUC, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        agme.this.c(this.mId, this.aX, (Bundle)localObject);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
        this.cXP = 4;
        continue;
        agme.this.d(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
        this.cXP = 5;
        continue;
        QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_RESUME, NF. NId = " + this.mId + " url:" + this.aX.getString("_notify_param_Url"));
        agme.this.e(this.mId, this.mNotification, this.aX, (Bundle)localObject);
        aglz.a().a(this.aX.getString("_notify_param_Url"), this.aX.getString("_notify_param_Filename"), this.aX.getString("_notify_param_ContentTitle", ""), this.aX.getLong("_notify_param_Filesize"), this.aX.getBundle("_notify_param_userdata"), this.mId, true);
        this.cXP = 7;
        continue;
        QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. NF_CLR, NF. NId = " + this.mId);
        agme.this.Of(this.mId);
        aglz.a().IX(this.aX.getString("_notify_param_Url"));
      }
    }
    
    public void p(int paramInt, Bundle paramBundle)
    {
      QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadStart, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 1;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      localBundle.putInt("_START_WAITING_", 0);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadStart, sendMessage failed, NF");
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
        QLog.e(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadProgress, sendMessage failed, NF");
      }
    }
    
    public void r(int paramInt, Bundle paramBundle)
    {
      QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadPause, NF");
      paramBundle = Message.obtain();
      paramBundle.what = 3;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadPause, sendMessage failed, NF");
      }
    }
    
    public void s(int paramInt, Bundle paramBundle)
    {
      QLog.i(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadResume progress=" + paramInt + ", NF ");
      paramBundle = Message.obtain();
      paramBundle.what = 7;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_FILE_PROGRESS_", paramInt);
      paramBundle.setData(localBundle);
      if (!sendMessage(paramBundle)) {
        QLog.e(agme.TAG, 1, "[UniformDL][" + this.Zd + "]. onDownloadResume, sendMessage failed, NF");
      }
    }
  }
  
  class b
  {
    final String SC = "SearchForText";
    final String SD = "SearchForTitle";
    int cXQ = 0;
    float ib = 14.0F;
    float ic = 16.0F;
    DisplayMetrics metrics = new DisplayMetrics();
    Integer u = null;
    Integer w = null;
    
    b(Context paramContext)
    {
      if (paramContext != null) {
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.metrics);
      }
    }
    
    public float ae()
    {
      return this.ic;
    }
    
    public float getTextSize()
    {
      return this.ib;
    }
    
    public Integer h()
    {
      return this.w;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agme
 * JD-Core Version:    0.7.0.1
 */