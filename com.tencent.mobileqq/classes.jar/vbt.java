import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSPicMonitorEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class vbt
  implements SimpleEventReceiver<WSPicMonitorEvent>
{
  private static vbt jdField_a_of_type_Vbt;
  private static boolean jdField_c_of_type_Boolean;
  private volatile int jdField_a_of_type_Int;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vbu jdField_a_of_type_Vbu;
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
    localWSDownloadParams.mTestId = vkf.b();
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
  
  public static vbt a()
  {
    if (jdField_a_of_type_Vbt == null) {}
    try
    {
      if (jdField_a_of_type_Vbt == null) {
        jdField_a_of_type_Vbt = new vbt();
      }
      return jdField_a_of_type_Vbt;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    if (jdField_c_of_type_Boolean)
    {
      vmp.b("WSFallKeyPicMonitor", "sendStartEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, 1, ""));
    }
  }
  
  public static <T> void a(int paramInt, T paramT)
  {
    if (jdField_c_of_type_Boolean)
    {
      vmp.b("WSFallKeyPicMonitor", "sendStartEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, 1, paramT));
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    if (paramstSimpleMetaFeed != null)
    {
      vmp.b("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi");
      vjx.a(1, 115, 0, paramstSimpleMetaFeed, vbq.a(1, paramInt1, paramInt2));
      return;
    }
    vmp.b("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi failure : feed == null");
  }
  
  public static void a(SimpleEventReceiver paramSimpleEventReceiver)
  {
    vmp.b("WSFallKeyPicMonitor", "registerReceiver");
    SimpleEventBus.getInstance().registerReceiver(paramSimpleEventReceiver);
  }
  
  public static void b(int paramInt)
  {
    if (jdField_c_of_type_Boolean)
    {
      vmp.b("WSFallKeyPicMonitor", "sendFinishEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, -1, ""));
    }
  }
  
  public static <T> void b(int paramInt, T paramT)
  {
    if (jdField_c_of_type_Boolean)
    {
      vmp.b("WSFallKeyPicMonitor", "sendFinishEvent");
      SimpleEventBus.getInstance().dispatchEvent(new WSPicMonitorEvent(paramInt, -1, paramT));
    }
  }
  
  public static void b(SimpleEventReceiver paramSimpleEventReceiver)
  {
    vmp.b("WSFallKeyPicMonitor", "unRegisterReceiver");
    SimpleEventBus.getInstance().unRegisterReceiver(paramSimpleEventReceiver);
  }
  
  private void c()
  {
    if (jdField_c_of_type_Boolean)
    {
      jdField_c_of_type_Boolean = false;
      vmp.b("WSFallKeyPicMonitor", "release");
      if (this.jdField_a_of_type_Vbu != null) {
        this.jdField_a_of_type_Vbu.removeMessages(1);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      b(this);
    }
  }
  
  private void d()
  {
    vmp.b("WSFallKeyPicMonitor", "startPreDownLoadWeiShi");
    WSDownloadParams localWSDownloadParams = a();
    vbq.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localWSDownloadParams);
  }
  
  private void e()
  {
    vmp.b("WSFallKeyPicMonitor", "performSilentDownload");
    WSDownloadParams localWSDownloadParams = a();
    vbq.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localWSDownloadParams, true, 2);
    vkf.a(115, Integer.valueOf(4));
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_c_of_type_Int, this.d);
  }
  
  public void a()
  {
    vmp.b("WSFallKeyPicMonitor", "immediatelyPreload");
    if (this.jdField_a_of_type_Vbu != null)
    {
      this.jdField_a_of_type_Vbu.removeMessages(1);
      this.jdField_a_of_type_Vbu.sendEmptyMessage(1);
    }
  }
  
  public void a(Activity paramActivity, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (zfn.a(paramActivity)) {
      return;
    }
    vmp.b("WSFallKeyPicMonitor", "init , linkType = " + paramInt + "; feed = " + paramstSimpleMetaFeed);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramstSimpleMetaFeed);
    if (paramInt == 4) {}
    for (paramInt = 300;; paramInt = 99)
    {
      this.d = paramInt;
      if (this.jdField_a_of_type_Vbu != null) {
        break;
      }
      this.jdField_a_of_type_Vbu = new vbu(this, this);
      this.jdField_a_of_type_Vbu.sendEmptyMessageDelayed(1, 3000L);
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    if (zfn.a(paramContext)) {
      vmp.d("WSFallKeyPicMonitor", "本地已经安装微视app");
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
    jdField_a_of_type_Vbt = null;
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
    vmp.b("WSFallKeyPicMonitor", "onReceiveEvent");
    int i;
    if ((paramSimpleBaseEvent instanceof WSPicMonitorEvent))
    {
      paramSimpleBaseEvent = (WSPicMonitorEvent)paramSimpleBaseEvent;
      switch (paramSimpleBaseEvent.getType())
      {
      default: 
        vmp.b("WSFallKeyPicMonitor", "type = " + paramSimpleBaseEvent.getType() + "; OperateType = " + paramSimpleBaseEvent.getOperateType() + ", content = " + paramSimpleBaseEvent.getContent());
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
            vmp.b("WSFallKeyPicMonitor", "非超时触发下载");
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
 * Qualified Name:     vbt
 * JD-Core Version:    0.7.0.1
 */