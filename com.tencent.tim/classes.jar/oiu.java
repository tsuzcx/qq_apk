import UserGrowth.stSimpleMetaFeed;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSPicMonitorEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class oiu
  implements rwx<WSPicMonitorEvent>
{
  private static oiu jdField_a_of_type_Oiu;
  private static boolean axs;
  private oiu.a jdField_a_of_type_Oiu$a;
  private final Object aY = new Object();
  private final Object aZ = new Object();
  private String aqg;
  private boolean axq;
  private boolean axr;
  private final Object ba = new Object();
  private volatile int bfd;
  private volatile int bfe;
  private int bff;
  private stSimpleMetaFeed c;
  private WeakReference<Activity> cH;
  private List<Object> lc = new ArrayList();
  private int mEventId = 99;
  
  @NonNull
  private WSDownloadParams a()
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = this.bff;
    localWSDownloadParams.mEventId = this.mEventId;
    localWSDownloadParams.mTestId = ong.lD();
    localWSDownloadParams.mScheme = this.aqg;
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
  
  public static oiu a()
  {
    if (jdField_a_of_type_Oiu == null) {}
    try
    {
      if (jdField_a_of_type_Oiu == null) {
        jdField_a_of_type_Oiu = new oiu();
      }
      return jdField_a_of_type_Oiu;
    }
    finally {}
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    if (paramstSimpleMetaFeed != null)
    {
      ooz.d("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi");
      ond.a(1, 115, 0, paramstSimpleMetaFeed, oir.e(1, paramInt1, paramInt2));
      return;
    }
    ooz.d("WSFallKeyPicMonitor", "recommendReportForDlOpenWeiShi failure : feed == null");
  }
  
  public static void a(rwx paramrwx)
  {
    ooz.d("WSFallKeyPicMonitor", "registerReceiver");
    rwv.a().a(paramrwx);
  }
  
  public static void b(rwx paramrwx)
  {
    ooz.d("WSFallKeyPicMonitor", "unRegisterReceiver");
    rwv.a().b(paramrwx);
  }
  
  private void bfa()
  {
    ooz.d("WSFallKeyPicMonitor", "startPreDownLoadWeiShi");
    WSDownloadParams localWSDownloadParams = a();
    oir.b((Activity)this.cH.get(), localWSDownloadParams);
  }
  
  private void bfb()
  {
    ooz.d("WSFallKeyPicMonitor", "performSilentDownload");
    WSDownloadParams localWSDownloadParams = a();
    oir.a((Activity)this.cH.get(), localWSDownloadParams, true, 2);
    ong.n(115, Integer.valueOf(4));
    a(this.c, this.bff, this.mEventId);
  }
  
  public static <T> void l(int paramInt, T paramT)
  {
    if (axs)
    {
      ooz.d("WSFallKeyPicMonitor", "sendStartEvent");
      rwv.a().a(new WSPicMonitorEvent(paramInt, 1, paramT));
    }
  }
  
  public static <T> void m(int paramInt, T paramT)
  {
    if (axs)
    {
      ooz.d("WSFallKeyPicMonitor", "sendFinishEvent");
      rwv.a().a(new WSPicMonitorEvent(paramInt, -1, paramT));
    }
  }
  
  private void stop()
  {
    if (axs)
    {
      axs = false;
      ooz.d("WSFallKeyPicMonitor", "release");
      if (this.jdField_a_of_type_Oiu$a != null) {
        this.jdField_a_of_type_Oiu$a.removeMessages(1);
      }
      this.lc.clear();
      b(this);
    }
  }
  
  public static void uH(int paramInt)
  {
    if (axs)
    {
      ooz.d("WSFallKeyPicMonitor", "sendStartEvent");
      rwv.a().a(new WSPicMonitorEvent(paramInt, 1, ""));
    }
  }
  
  public static void uI(int paramInt)
  {
    if (axs)
    {
      ooz.d("WSFallKeyPicMonitor", "sendFinishEvent");
      rwv.a().a(new WSPicMonitorEvent(paramInt, -1, ""));
    }
  }
  
  public void a(Activity paramActivity, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (rpw.isWeishiInstalled(paramActivity)) {
      return;
    }
    ooz.d("WSFallKeyPicMonitor", "init , linkType = " + paramInt + "; feed = " + paramstSimpleMetaFeed);
    this.cH = new WeakReference(paramActivity);
    this.c = paramstSimpleMetaFeed;
    this.bff = paramInt;
    this.aqg = a(paramstSimpleMetaFeed);
    if (paramInt == 4) {}
    for (paramInt = 300;; paramInt = 99)
    {
      this.mEventId = paramInt;
      if (this.jdField_a_of_type_Oiu$a != null) {
        break;
      }
      this.jdField_a_of_type_Oiu$a = new oiu.a(this);
      this.jdField_a_of_type_Oiu$a.sendEmptyMessageDelayed(1, 3000L);
      return;
    }
  }
  
  public void beZ()
  {
    ooz.d("WSFallKeyPicMonitor", "immediatelyPreload");
    if (this.jdField_a_of_type_Oiu$a != null)
    {
      this.jdField_a_of_type_Oiu$a.removeMessages(1);
      this.jdField_a_of_type_Oiu$a.sendEmptyMessage(1);
    }
  }
  
  public ArrayList<Class<WSPicMonitorEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSPicMonitorEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ooz.d("WSFallKeyPicMonitor", "onReceiveEvent");
    int i;
    if ((paramSimpleBaseEvent instanceof WSPicMonitorEvent))
    {
      paramSimpleBaseEvent = (WSPicMonitorEvent)paramSimpleBaseEvent;
      switch (paramSimpleBaseEvent.getType())
      {
      default: 
        ooz.d("WSFallKeyPicMonitor", "type = " + paramSimpleBaseEvent.getType() + "; OperateType = " + paramSimpleBaseEvent.getOperateType() + ", content = " + paramSimpleBaseEvent.getContent());
        if ((this.axq) && (this.lc.size() == 0))
        {
          i = 1;
          if ((!this.axr) || (this.bfe > 0)) {
            break label344;
          }
        }
        break;
      }
    }
    label344:
    for (int j = 1;; j = 0)
    {
      for (;;)
      {
        for (;;)
        {
          if ((i != 0) && (j != 0) && (this.bfd <= 0))
          {
            axs = false;
            this.axq = false;
            this.axr = false;
            this.jdField_a_of_type_Oiu$a.removeMessages(1);
            this.jdField_a_of_type_Oiu$a.sendEmptyMessage(1);
            ooz.d("WSFallKeyPicMonitor", "非超时触发下载");
          }
          return;
          do
          {
            synchronized (this.aY)
            {
              if (paramSimpleBaseEvent.getOperateType() == 1)
              {
                this.axq = true;
                this.lc.add(paramSimpleBaseEvent.getContent());
              }
            }
          } while (this.lc.remove(paramSimpleBaseEvent.getContent()));
          return;
          this.axr = true;
          synchronized (this.aZ)
          {
            this.bfe += paramSimpleBaseEvent.getOperateType();
          }
        }
        synchronized (this.ba)
        {
          this.bfd += paramSimpleBaseEvent.getOperateType();
        }
      }
      i = 0;
      break;
    }
  }
  
  public void release()
  {
    if (axs) {
      stop();
    }
    jdField_a_of_type_Oiu = null;
  }
  
  public void start(Context paramContext)
  {
    if (rpw.isWeishiInstalled(paramContext)) {
      ooz.e("WSFallKeyPicMonitor", "本地已经安装微视app");
    }
    while (axs) {
      return;
    }
    axs = true;
    a(this);
  }
  
  @SuppressLint({"HandlerLeak"})
  class a
    extends Handler
  {
    WeakReference<oiu> cI;
    
    a(oiu paramoiu)
    {
      ooz.d("WSFallKeyPicMonitor", "init DownloadHandler");
      this.cI = new WeakReference(paramoiu);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      ooz.d("WSFallKeyPicMonitor", "handleMessage to download");
      if (paramMessage.what == 1)
      {
        if (oiu.a(oiu.this) != 4) {
          break label46;
        }
        oiu.a(oiu.this);
      }
      for (;;)
      {
        oiu.this.release();
        return;
        label46:
        oiu.b(oiu.this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oiu
 * JD-Core Version:    0.7.0.1
 */