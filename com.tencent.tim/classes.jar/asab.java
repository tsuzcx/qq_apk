import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.open.downloadnew.common.NoticeParam;
import java.util.concurrent.ConcurrentHashMap;

public class asab
{
  protected static asab a;
  protected asab.b a;
  protected QQNotificationManager f = QQNotificationManager.getInstance();
  protected final ConcurrentHashMap<String, asab.a> jq = new ConcurrentHashMap();
  
  public static asab a()
  {
    if (jdField_a_of_type_Asab == null) {
      jdField_a_of_type_Asab = new asab();
    }
    return jdField_a_of_type_Asab;
  }
  
  private int fF(String paramString)
  {
    arwt.i("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    arwt.i("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    arwt.i("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public ConcurrentHashMap<String, asab.a> F()
  {
    return this.jq;
  }
  
  public void Xt(String paramString)
  {
    arwt.v("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.f != null) && (this.jq.containsKey(paramString)) && (this.jq.get(paramString) != null))
    {
      asab.a locala = (asab.a)this.jq.get(paramString);
      if (locala != null) {
        this.f.cancel("AppNotificationManager_cancelBySendTime", locala.id);
      }
      this.jq.remove(paramString);
    }
  }
  
  public void Xu(String paramString)
  {
    arwt.v("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.f != null) && (this.jq.containsKey(paramString))) {
      this.f.cancel("AppNotificationManager_cancelNotRemoveId", ((asab.a)this.jq.get(paramString)).id);
    }
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      arwt.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    arwt.i("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jq.containsKey(str))
    {
      paramString1 = new asab.a();
      paramString1.key = str;
      paramString1.id = fF(str);
      paramString1.type = paramInt;
      paramString1.appid = paramString2;
      paramString1.when = (System.currentTimeMillis() + paramString1.id);
      this.jq.put(str, paramString1);
    }
    return ((asab.a)this.jq.get(str)).id;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    arwt.i("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jq.containsKey(paramString1))
    {
      asab.a locala = new asab.a();
      locala.key = paramString1;
      locala.id = fF(paramString1);
      locala.type = paramInt;
      locala.appid = paramString2;
      locala.when = (System.currentTimeMillis() + locala.id);
      this.jq.put(paramString1, locala);
    }
    return ((asab.a)this.jq.get(paramString1)).when;
  }
  
  public void a(NoticeParam paramNoticeParam)
  {
    if (this.f != null)
    {
      Notification localNotification = b(paramNoticeParam);
      if (localNotification != null)
      {
        auqw.setMIUI6Badge(aroi.a().getContext(), 0, localNotification);
        this.f.notify("AppNotificationManagernotify1", a(paramNoticeParam.nKey, paramNoticeParam.noticeType, paramNoticeParam.appId), localNotification);
      }
    }
  }
  
  public Notification b(NoticeParam paramNoticeParam)
  {
    if ((aroi.a().getContext() == null) || (paramNoticeParam == null))
    {
      arwt.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.title;
    localNotification.when = paramNoticeParam.time;
    RemoteViews localRemoteViews = new RemoteViews(aroi.a().getContext().getPackageName(), 2131559856);
    Object localObject = asad.a(1, paramNoticeParam);
    b(localRemoteViews);
    localRemoteViews.setInt(2131372538, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131372540, "setTextColor", -16777216);
    localRemoteViews.setInt(2131372534, "setTextColor", -12303292);
    localRemoteViews.setInt(2131372528, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131372540, arwx.d(paramNoticeParam.title, 18, true, true));
    if (paramNoticeParam.noticeType == 1)
    {
      localNotification.icon = 2130845243;
      localRemoteViews.setImageViewResource(2131372529, 2130845239);
      localRemoteViews.setViewVisibility(2131372528, 8);
      localRemoteViews.setViewVisibility(2131372523, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131372538, (PendingIntent)localObject);
      }
    }
    for (;;)
    {
      localNotification.contentView = localRemoteViews;
      QQNotificationManager.addChannelIfNeed(localNotification, "CHANNEL_ID_HIDE_BADGE");
      return localNotification;
      localNotification.contentIntent = ((PendingIntent)localObject);
      continue;
      if ((paramNoticeParam.noticeType == 0) || (paramNoticeParam.noticeType == 2) || (paramNoticeParam.noticeType == 3))
      {
        localNotification.icon = 2130845243;
        if (paramNoticeParam.noticeType == 0)
        {
          localRemoteViews.setTextViewText(2131372528, aroi.a().getContext().getString(2131696427));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131372529, 2130845239);
        }
        if (paramNoticeParam.noticeType == 2)
        {
          localRemoteViews.setTextViewText(2131372528, aroi.a().getContext().getString(2131696430));
          localObject = arxn.S(paramNoticeParam.packName);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131372529, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = asad.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.noticeType == 3)
        {
          localRemoteViews.setTextViewText(2131372528, aroi.a().getContext().getString(2131696427));
          localObject = asad.a(4, paramNoticeParam);
          Bitmap localBitmap = arwr.R(paramNoticeParam.appId);
          if (localBitmap == null) {
            break label489;
          }
          localRemoteViews.setImageViewBitmap(2131372529, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.noticeType == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131372538, (PendingIntent)localObject);
              break;
              label489:
              arwt.i("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131372529, 2130845239);
              continue;
            }
            localNotification.contentIntent = ((PendingIntent)localObject);
            break;
          }
        }
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
      else if (paramNoticeParam.noticeType == 4)
      {
        localNotification.icon = 2130845243;
        localRemoteViews.setImageViewResource(2131372529, 2130845239);
        localRemoteViews.setTextViewText(2131372528, aroi.a().getContext().getString(2131696426));
        localRemoteViews.setViewVisibility(2131372528, 0);
        localRemoteViews.setViewVisibility(2131372523, 8);
        paramNoticeParam = asad.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130842718;
        localRemoteViews.setImageViewResource(2131372529, 2130842719);
        localRemoteViews.setTextViewText(2131372528, paramNoticeParam.content);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public void b(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Asab$b == null) || (this.jdField_a_of_type_Asab$b.i() == null)) {
      this.jdField_a_of_type_Asab$b = new asab.b(aroi.a().getContext());
    }
    arwt.i("notificationtest", "title color:" + this.jdField_a_of_type_Asab$b.h());
    if (this.jdField_a_of_type_Asab$b.h() != null) {
      paramRemoteViews.setTextColor(2131372540, this.jdField_a_of_type_Asab$b.h().intValue());
    }
    arwt.i("notificationtest", "text color:" + this.jdField_a_of_type_Asab$b.i());
    if (this.jdField_a_of_type_Asab$b.i() != null) {
      paramRemoteViews.setTextColor(2131372528, this.jdField_a_of_type_Asab$b.i().intValue());
    }
    if (this.jdField_a_of_type_Asab$b.i() != null) {
      paramRemoteViews.setTextColor(2131372534, this.jdField_a_of_type_Asab$b.i().intValue());
    }
    arwt.i("notificationtest", "text size:" + this.jdField_a_of_type_Asab$b.getTextSize());
    if (this.jdField_a_of_type_Asab$b.getTextSize() > 0.0F) {
      paramRemoteViews.setFloat(2131372528, "setTextSize", this.jdField_a_of_type_Asab$b.getTextSize());
    }
    if (this.jdField_a_of_type_Asab$b.getTextSize() > 0.0F) {
      paramRemoteViews.setFloat(2131372534, "setTextSize", this.jdField_a_of_type_Asab$b.getTextSize());
    }
    if (this.jdField_a_of_type_Asab$b.ae() > 0.0F) {
      paramRemoteViews.setFloat(2131372540, "setTextSize", this.jdField_a_of_type_Asab$b.ae());
    }
    ApplicationInfo localApplicationInfo = aroi.a().getContext().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Asab$b.h().intValue();
      paramRemoteViews.setInt(2131372538, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  public void notify(int paramInt, Notification paramNotification)
  {
    if (this.f != null) {}
    try
    {
      auqw.setMIUI6Badge(aroi.a().getContext(), 0, paramNotification);
      this.f.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      arwt.e("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public class a
  {
    public String appid = "";
    public int id;
    public String key = "";
    public int type;
    public long when;
    
    public a() {}
    
    public String toString()
    {
      return this.id + "," + this.appid + "," + this.type + "," + this.key;
    }
  }
  
  public class b
  {
    protected final String SC = "SearchForText";
    protected final String SD = "SearchForTitle";
    protected float ib = 14.0F;
    protected float ic = 16.0F;
    protected DisplayMetrics metrics = new DisplayMetrics();
    protected Integer u;
    protected Integer w;
    
    b(Context paramContext)
    {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.metrics);
      fS(paramContext);
    }
    
    public float ae()
    {
      return this.ic;
    }
    
    protected boolean c(ViewGroup paramViewGroup)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((paramViewGroup.getChildAt(i) instanceof TextView))
        {
          TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
          if ("SearchForTitle".equals(localTextView.getText().toString()))
          {
            this.w = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
            this.ic = localTextView.getTextSize();
            this.ic /= this.metrics.scaledDensity;
            return true;
          }
        }
        else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (c((ViewGroup)paramViewGroup.getChildAt(i))))
        {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    protected boolean d(ViewGroup paramViewGroup)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((paramViewGroup.getChildAt(i) instanceof TextView))
        {
          TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
          if ("SearchForText".equals(localTextView.getText().toString()))
          {
            this.u = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
            this.ib = localTextView.getTextSize();
            this.ib /= this.metrics.scaledDensity;
            return true;
          }
        }
        else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (d((ViewGroup)paramViewGroup.getChildAt(i))))
        {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    protected void fS(Context paramContext)
    {
      if ((this.u != null) && (this.w != null)) {
        return;
      }
      try
      {
        Notification localNotification = new Notification();
        localNotification.setLatestEventInfo(paramContext, "SearchForTitle", "SearchForText", null);
        paramContext = (ViewGroup)localNotification.contentView.apply(paramContext, null);
        c(paramContext);
        d(paramContext);
        return;
      }
      catch (Exception paramContext) {}
    }
    
    public float getTextSize()
    {
      return this.ib;
    }
    
    public Integer h()
    {
      return this.w;
    }
    
    public Integer i()
    {
      return this.u;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asab
 * JD-Core Version:    0.7.0.1
 */