import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyService;
import cooperation.wadl.ipc.WadlProxyServiceManager.1;
import cooperation.wadl.ipc.WadlProxyServiceManager.ClientMessageHandler.1;
import cooperation.wadl.ipc.WadlProxyServiceManager.ClientMessageHandler.2;
import cooperation.wadl.ipc.WadlProxyServiceMonitor;
import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class awof
{
  private List<Bundle> LV = new Vector();
  private awoa jdField_a_of_type_Awoa;
  private awob jdField_a_of_type_Awob;
  private awof.a jdField_a_of_type_Awof$a;
  private awof.b jdField_a_of_type_Awof$b = new awof.b(this);
  private HandlerThread aj = new HandlerThread("WadlClientMessage.Thread", 10);
  private HandlerThread ak;
  private CopyOnWriteArrayList<awoe> ay;
  private IBinder.DeathRecipient b = new awog(this);
  public boolean dnf = false;
  public Handler ef;
  private volatile boolean mDestroy;
  private ServiceConnection mServiceConnection = new awoh(this);
  
  public awof()
  {
    this.aj.start();
    this.jdField_a_of_type_Awof$a = new awof.a(this.aj.getLooper());
    this.ak = new HandlerThread("WadlClientJob.Thread", 10);
    this.ak.start();
    this.ef = new Handler(this.ak.getLooper());
    this.ay = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Awoa = new WadlProxyServiceMonitor(this);
  }
  
  private void eEC()
  {
    Message localMessage = this.jdField_a_of_type_Awof$a.obtainMessage();
    localMessage.what = 2;
    this.jdField_a_of_type_Awof$a.sendMessage(localMessage);
  }
  
  private void eq(Bundle paramBundle)
  {
    if (this.LV.size() > 100)
    {
      asbt.e("WadlProxyServiceManager", "##@there must be an error too many unproceed message!");
      this.LV.clear();
    }
    this.LV.add(paramBundle);
  }
  
  private void er(Bundle paramBundle)
  {
    if (this.ay != null)
    {
      paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
      asbt.i("WadlProxyServiceManager", "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.ay.size());
      if (paramBundle != null)
      {
        Iterator localIterator = this.ay.iterator();
        while (localIterator.hasNext()) {
          ((awoe)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
        }
      }
    }
    else
    {
      asbt.e("WadlProxyServiceManager", "callBackList is null");
    }
  }
  
  private void es(Bundle paramBundle)
  {
    if (this.ay != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      asbt.i("WadlProxyServiceManager", "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.ay.size());
      paramBundle = this.ay.iterator();
      while (paramBundle.hasNext()) {
        ((awoe)paramBundle.next()).onQueryCallback(localArrayList);
      }
    }
    asbt.e("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void et(Bundle paramBundle)
  {
    if (this.ay != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      asbt.i("WadlProxyServiceManager", "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.ay.size());
      paramBundle = this.ay.iterator();
      while (paramBundle.hasNext()) {
        ((awoe)paramBundle.next()).onQueryCallbackVia(localArrayList);
      }
    }
    asbt.e("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void eu(Bundle paramBundle)
  {
    if (this.ay != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      asbt.i("WadlProxyServiceManager", "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.ay.size());
      paramBundle = this.ay.iterator();
      while (paramBundle.hasNext()) {
        ((awoe)paramBundle.next()).onQueryCallback(localArrayList);
      }
    }
    asbt.e("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void ev(Bundle paramBundle)
  {
    String str = paramBundle.getString("report_oper_id");
    Object localObject = paramBundle.getString("report_sso_event");
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramBundle != null)) {}
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set((String)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getContext(), ailu.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "DownloaderReport.DownloaderMsg");
      ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("extra_timeout", 5000L);
      ((NewIntent)localObject).setObserver(new awoi(this, str));
      paramBundle.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      asbt.e("WadlProxyServiceManager", "onReportDownloadEvent exception:" + paramBundle.toString());
    }
  }
  
  public void a(awoe paramawoe)
  {
    if ((paramawoe != null) && (!this.ay.contains(paramawoe))) {
      this.ay.add(paramawoe);
    }
  }
  
  public boolean aNl()
  {
    return (this.jdField_a_of_type_Awob != null) && (!this.dnf);
  }
  
  public void b(awoe paramawoe)
  {
    if (paramawoe != null) {
      this.ay.remove(paramawoe);
    }
  }
  
  /* Error */
  void destroy()
  {
    // Byte code:
    //   0: ldc 139
    //   2: new 167	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 377
    //   12: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 190	asbt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 115	awof:mDestroy	Z
    //   30: aload_0
    //   31: getfield 99	awof:jdField_a_of_type_Awoa	Lawoa;
    //   34: ifnull +12 -> 46
    //   37: aload_0
    //   38: getfield 99	awof:jdField_a_of_type_Awoa	Lawoa;
    //   41: invokeinterface 382 1 0
    //   46: aload_0
    //   47: getfield 66	awof:aj	Landroid/os/HandlerThread;
    //   50: ifnull +11 -> 61
    //   53: aload_0
    //   54: getfield 66	awof:aj	Landroid/os/HandlerThread;
    //   57: invokevirtual 385	android/os/HandlerThread:quit	()Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 82	awof:ak	Landroid/os/HandlerThread;
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: getfield 82	awof:ak	Landroid/os/HandlerThread;
    //   72: invokevirtual 385	android/os/HandlerThread:quit	()Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 106	awof:jdField_a_of_type_Awob	Lawob;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +46 -> 128
    //   85: aload_1
    //   86: aload_0
    //   87: getfield 57	awof:jdField_a_of_type_Awof$b	Lawof$b;
    //   90: invokeinterface 390 2 0
    //   95: ldc 139
    //   97: ldc_w 392
    //   100: invokestatic 190	asbt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokeinterface 396 1 0
    //   109: aload_0
    //   110: getfield 49	awof:b	Landroid/os/IBinder$DeathRecipient;
    //   113: iconst_0
    //   114: invokeinterface 402 3 0
    //   119: pop
    //   120: ldc 139
    //   122: ldc_w 404
    //   125: invokestatic 190	asbt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: invokestatic 252	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   131: aload_0
    //   132: getfield 54	awof:mServiceConnection	Landroid/content/ServiceConnection;
    //   135: invokevirtual 408	com/tencent/common/app/BaseApplicationImpl:unbindService	(Landroid/content/ServiceConnection;)V
    //   138: ldc 139
    //   140: ldc_w 410
    //   143: invokestatic 190	asbt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: return
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 413	java/lang/Exception:printStackTrace	()V
    //   152: goto -76 -> 76
    //   155: astore_2
    //   156: aload_2
    //   157: invokevirtual 414	android/os/RemoteException:printStackTrace	()V
    //   160: goto -57 -> 103
    //   163: astore_1
    //   164: return
    //   165: astore_1
    //   166: goto -38 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	awof
    //   80	24	1	localawob	awob
    //   147	2	1	localException1	Exception
    //   163	1	1	localException2	Exception
    //   165	1	1	localException3	Exception
    //   155	2	2	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   30	46	147	java/lang/Exception
    //   46	61	147	java/lang/Exception
    //   61	76	147	java/lang/Exception
    //   85	103	155	android/os/RemoteException
    //   128	146	163	java/lang/Exception
    //   103	128	165	java/lang/Exception
  }
  
  public void eEA()
  {
    Message localMessage = this.jdField_a_of_type_Awof$a.obtainMessage();
    localMessage.what = 1;
    this.jdField_a_of_type_Awof$a.sendMessage(localMessage);
  }
  
  public void eEB()
  {
    asbt.i("WadlProxyServiceManager", "innerStartService start");
    if (this.jdField_a_of_type_Awob != null)
    {
      if (QLog.isColorLevel()) {
        asbt.i("WadlProxyServiceManager", "innerStartService:mWadlService is working");
      }
      return;
    }
    if (this.dnf)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("##@innerStartService:mWadlService is connecting >> [mServiceConnecting:").append(this.dnf).append(",mWadlService:");
      if (this.jdField_a_of_type_Awob == null) {}
      for (String str = "invaliad";; str = "valid")
      {
        asbt.i("WadlProxyServiceManager", str + "]");
        return;
      }
    }
    this.dnf = true;
    try
    {
      asbt.i("WadlProxyServiceManager", "##@innerStartService:bindWadlService");
      WadlProxyService.b(this.mServiceConnection);
      this.ef.postDelayed(new WadlProxyServiceManager.1(this), 5000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        asbt.i("WadlProxyServiceManager", "##@failed to lauch servie", localException);
        this.dnf = false;
      }
    }
  }
  
  public void eED()
  {
    if (QLog.isColorLevel()) {
      asbt.i("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage mWadlService=" + this.jdField_a_of_type_Awob + ",mServiceConnecting=" + this.dnf + ",mCacheMsg size=" + this.LV.size());
    }
    if (aNl())
    {
      if (!this.LV.isEmpty()) {
        break label93;
      }
      asbt.i("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage END");
    }
    label92:
    label93:
    Bundle localBundle;
    do
    {
      break label93;
      break label93;
      return;
      for (;;)
      {
        if (this.LV.isEmpty()) {
          break label92;
        }
        localBundle = (Bundle)this.LV.remove(0);
        if (localBundle == null) {
          break;
        }
        String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
        if (QLog.isColorLevel()) {
          asbt.i("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage strNotifyCmd=" + str);
        }
        try
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          if (this.jdField_a_of_type_Awob != null)
          {
            asbt.ai("WadlProxyServiceManager", 5, "send action to service cmd=" + str);
            this.jdField_a_of_type_Awob.b("WADL.REMOTE_ACTION_CMD", localBundle);
          }
        }
        catch (Exception localException) {}
      }
    } while (!(localException instanceof DeadObjectException));
    eq(localBundle);
    asbt.i("WadlProxyServiceManager", "remote service is dead", localException);
  }
  
  public void eo(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    asbt.ai("WadlProxyServiceManager", 4, "send action msg cmd=" + str);
    if (!aNl())
    {
      asbt.e("WadlProxyServiceManager", "postRemoteNotify start but service is not launched and start service");
      eEB();
    }
    eq(paramBundle);
    eEC();
  }
  
  public void ep(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Awoa != null) {
      this.jdField_a_of_type_Awoa.ep(paramBundle);
    }
  }
  
  public List<awoe> hD()
  {
    return this.ay;
  }
  
  public Bundle v(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      asbt.i("WadlProxyServiceManager", "onRemoteReverseInvoke begin cmd=" + str);
    }
    if (str == null) {
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_StartWadlService"))
    {
      eEA();
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_onWadlTaskStatusChanged"))
    {
      er(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyResult"))
    {
      es(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyResultVia"))
    {
      et(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_Report_Event"))
    {
      ev(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyAllTask"))
    {
      eu(paramBundle);
      return paramBundle;
    }
    asbt.e("WadlProxyServiceManager", "onRemoteReverseInvoke unknow invokeCmd");
    return paramBundle;
  }
  
  public final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        awof.this.eEB();
        continue;
        awof.this.eED();
        continue;
        Bundle localBundle = paramMessage.getData();
        awof.this.ef.post(new WadlProxyServiceManager.ClientMessageHandler.1(this, localBundle));
        continue;
        localBundle = paramMessage.getData();
        awof.this.ef.post(new WadlProxyServiceManager.ClientMessageHandler.2(this, localBundle));
        continue;
        if (awof.a(awof.this) != null)
        {
          awof.a(awof.this).eEy();
          continue;
          if ((!awof.a(awof.this)) && (awof.a(awof.this) != null)) {
            awof.a(awof.this).eEz();
          }
        }
      }
    }
  }
  
  static class b
    extends awoc.a
  {
    private WeakReference<awof> dy;
    
    b(awof paramawof)
    {
      this.dy = new WeakReference(paramawof);
    }
    
    public void b(String paramString, Bundle paramBundle)
      throws RemoteException
    {
      awof localawof = (awof)this.dy.get();
      if (localawof == null) {
        asbt.i("WadlProxyServiceManager", "##@transferAsync, manager gc: " + paramString);
      }
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            asbt.i("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
          }
          paramBundle.setClassLoader(getClass().getClassLoader());
        } while (paramString == null);
        if (paramString.equals("WADL.REVERSE_HEART_CMD"))
        {
          paramString = awof.a(localawof).obtainMessage();
          paramString.what = 4;
          paramString.setData(paramBundle);
          awof.a(localawof).sendMessage(paramString);
          return;
        }
        if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
        {
          paramString = awof.a(localawof).obtainMessage();
          paramString.what = 3;
          paramString.setData(paramBundle);
          awof.a(localawof).sendMessage(paramString);
          return;
        }
        if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
        {
          paramString = awof.a(localawof).obtainMessage();
          paramString.what = 5;
          paramString.setData(paramBundle);
          awof.a(localawof).sendMessage(paramString);
          return;
        }
      } while (!paramString.equals("WADL.REVERSE_START_MONITOR_CMD"));
      paramString = awof.a(localawof).obtainMessage();
      paramString.what = 6;
      paramString.setData(paramBundle);
      awof.a(localawof).sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awof
 * JD-Core Version:    0.7.0.1
 */