import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSPicMonitorEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class uhc
  implements aaam<WSPicMonitorEvent>
{
  private static uhc jdField_a_of_type_Uhc;
  private static boolean jdField_c_of_type_Boolean;
  private volatile int jdField_a_of_type_Int;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uhd jdField_a_of_type_Uhd;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private int d = 99;
  
  @NonNull
  private WSDownloadParams a()
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = this.jdField_c_of_type_Int;
    localWSDownloadParams.mEventId = this.d;
    localWSDownloadParams.mTestId = unx.b();
    localWSDownloadParams.mScheme = this.jdField_a_of_type_JavaLangString;
    return localWSDownloadParams;
  }
  
  private String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      String str = "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id;
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed.weishi_jump_url)) {
        str = paramstSimpleMetaFeed.weishi_jump_url;
      }
      return str;
    }
    return null;
  }
  
  public static uhc a()
  {
    if (jdField_a_of_type_Uhc == null) {}
    try
    {
      if (jdField_a_of_type_Uhc == null) {
        jdField_a_of_type_Uhc = new uhc();
      }
      return jdField_a_of_type_Uhc;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    if (jdField_c_of_type_Boolean)
    {
      uqf.b("WSFallKeyPicMonitor", "sendStartEvent");
      aaak.a().a(new WSPicMonitorEvent(paramInt, 1, ""));
    }
  }
  
  public static <T> void a(int paramInt, T paramT)
  {
    if (jdField_c_of_type_Boolean)
    {
      uqf.b("WSFallKeyPicMonitor", "sendStartEvent");
      aaak.a().a(new WSPicMonitorEvent(paramInt, 1, paramT));
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    if (paramstSimpleMetaFeed != null)
    {
      uqf.b("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi");
      uno.a(1, 115, 0, paramstSimpleMetaFeed, ugz.a(1, paramInt1, paramInt2));
      return;
    }
    uqf.b("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi failure : feed == null");
  }
  
  public static void a(aaam paramaaam)
  {
    uqf.b("WSFallKeyPicMonitor", "registerReceiver");
    aaak.a().a(paramaaam);
  }
  
  public static void b(int paramInt)
  {
    if (jdField_c_of_type_Boolean)
    {
      uqf.b("WSFallKeyPicMonitor", "sendFinishEvent");
      aaak.a().a(new WSPicMonitorEvent(paramInt, -1, ""));
    }
  }
  
  public static <T> void b(int paramInt, T paramT)
  {
    if (jdField_c_of_type_Boolean)
    {
      uqf.b("WSFallKeyPicMonitor", "sendFinishEvent");
      aaak.a().a(new WSPicMonitorEvent(paramInt, -1, paramT));
    }
  }
  
  public static void b(aaam paramaaam)
  {
    uqf.b("WSFallKeyPicMonitor", "unRegisterReceiver");
    aaak.a().b(paramaaam);
  }
  
  private void c()
  {
    if (jdField_c_of_type_Boolean)
    {
      jdField_c_of_type_Boolean = false;
      uqf.b("WSFallKeyPicMonitor", "release");
      if (this.jdField_a_of_type_Uhd != null) {
        this.jdField_a_of_type_Uhd.removeMessages(1);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      b(this);
    }
  }
  
  private void d()
  {
    uqf.b("WSFallKeyPicMonitor", "startPreDownLoadWeiShi");
    WSDownloadParams localWSDownloadParams = a();
    ugz.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localWSDownloadParams);
  }
  
  private void e()
  {
    uqf.b("WSFallKeyPicMonitor", "performSilentDownload");
    WSDownloadParams localWSDownloadParams = a();
    ugz.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localWSDownloadParams, true, 2);
    unx.a(115, Integer.valueOf(4));
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_c_of_type_Int, this.d);
  }
  
  public void a()
  {
    uqf.b("WSFallKeyPicMonitor", "immediatelyPreload");
    if (this.jdField_a_of_type_Uhd != null)
    {
      this.jdField_a_of_type_Uhd.removeMessages(1);
      this.jdField_a_of_type_Uhd.sendEmptyMessage(1);
    }
  }
  
  public void a(Activity paramActivity, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (zqd.a(paramActivity)) {
      return;
    }
    uqf.b("WSFallKeyPicMonitor", "init , linkType = " + paramInt + "; feed = " + paramstSimpleMetaFeed);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramstSimpleMetaFeed);
    if (paramInt == 4) {}
    for (paramInt = 300;; paramInt = 99)
    {
      this.d = paramInt;
      if (this.jdField_a_of_type_Uhd != null) {
        break;
      }
      this.jdField_a_of_type_Uhd = new uhd(this, this);
      this.jdField_a_of_type_Uhd.sendEmptyMessageDelayed(1, 3000L);
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    if (zqd.a(paramContext)) {
      uqf.d("WSFallKeyPicMonitor", "本地已经安装微视app");
    }
    while (jdField_c_of_type_Boolean) {
      return;
    }
    jdField_c_of_type_Boolean = true;
    a(this);
  }
  
  public void b()
  {
    if (jdField_c_of_type_Boolean) {
      c();
    }
    jdField_a_of_type_Uhc = null;
  }
  
  public ArrayList<Class<WSPicMonitorEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSPicMonitorEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int j = 1;
    uqf.b("WSFallKeyPicMonitor", "onReceiveEvent");
    int i;
    if ((paramSimpleBaseEvent instanceof WSPicMonitorEvent))
    {
      paramSimpleBaseEvent = (WSPicMonitorEvent)paramSimpleBaseEvent;
      switch (paramSimpleBaseEvent.getType())
      {
      default: 
        uqf.b("WSFallKeyPicMonitor", "type = " + paramSimpleBaseEvent.getType() + "; OperateType = " + paramSimpleBaseEvent.getOperateType() + ", content = " + paramSimpleBaseEvent.getContent());
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 0))
        {
          i = 1;
          if ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Int > 0)) {
            break label329;
          }
        }
        break;
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          if ((i != 0) && (j != 0) && (this.jdField_a_of_type_Int <= 0))
          {
            jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_Boolean = false;
            this.jdField_b_of_type_Boolean = false;
            a();
            uqf.b("WSFallKeyPicMonitor", "非超时触发下载");
          }
          return;
          do
          {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              if (paramSimpleBaseEvent.getOperateType() == 1)
              {
                this.jdField_a_of_type_Boolean = true;
                this.jdField_a_of_type_JavaUtilList.add(paramSimpleBaseEvent.getContent());
              }
            }
          } while (this.jdField_a_of_type_JavaUtilList.remove(paramSimpleBaseEvent.getContent()));
          return;
          this.jdField_b_of_type_Boolean = true;
          synchronized (this.jdField_b_of_type_JavaLangObject)
          {
            this.jdField_b_of_type_Int += paramSimpleBaseEvent.getOperateType();
          }
        }
        synchronized (this.jdField_c_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_Int += paramSimpleBaseEvent.getOperateType();
        }
      }
      i = 0;
      break;
      label329:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhc
 * JD-Core Version:    0.7.0.1
 */