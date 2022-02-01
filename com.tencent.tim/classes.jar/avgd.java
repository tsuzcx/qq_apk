import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class avgd
  implements Handler.Callback, aolm.a, aolm.b, aopn.a
{
  private aopo a;
  private Handler bG;
  private HashMap<String, avgd.a> ki;
  private HashMap<String, aopn> kj;
  private final Lock lock = new ReentrantLock();
  private QQAppInterface mAppInterface;
  private Context mContext;
  private HashMap<String, Long> qx = new HashMap();
  
  public avgd(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mAppInterface = paramQQAppInterface;
    this.bG = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.ki = new HashMap();
    this.kj = new HashMap();
    this.a = ((aopo)paramQQAppInterface.getManager(193));
  }
  
  private void ZL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doCancelInstall: " + paramString);
    }
    this.lock.lock();
    for (;;)
    {
      aopn localaopn;
      try
      {
        localObject = (avgd.a)this.ki.remove(paramString);
        localaopn = (aopn)this.kj.remove(paramString);
        this.lock.unlock();
        if ((localObject != null) || (localaopn != null))
        {
          if (localObject != null)
          {
            if (avgd.a.a((avgd.a)localObject) != null) {
              this.a.a(avgd.a.a((avgd.a)localObject).bZ);
            }
          }
          else
          {
            if (localObject != null) {
              this.a.a(avgd.a.a((avgd.a)localObject).bZ);
            }
            if (localObject == null) {
              break label184;
            }
            localObject = avgd.a.a((avgd.a)localObject);
            if (localObject != null) {
              ((avgd.b)localObject).dc(paramString);
            }
            ZM(paramString);
          }
        }
        else {
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      this.mAppInterface.getNetEngine(0).b(avgd.a.a((avgd.a)localObject));
      continue;
      label184:
      Object localObject = (avgd.b)localaopn.userData;
    }
  }
  
  private void ZM(String paramString)
  {
    paramString = (Long)this.qx.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", "0");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.mAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  private void a(aomg paramaomg, int paramInt1, int paramInt2)
  {
    String str = (String)paramaomg.U();
    if (paramInt2 > 0)
    {
      paramaomg = (avgd.a)this.ki.get(str);
      if (paramaomg == null) {
        break label95;
      }
    }
    label95:
    for (paramaomg = avgd.a.a(paramaomg);; paramaomg = null)
    {
      if (paramaomg != null) {
        paramaomg.C(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(aomh paramaomh)
  {
    String str = (String)paramaomh.b.U();
    if (paramaomh.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (aopo)this.mAppInterface.getManager(193);
      avgd.a locala = (avgd.a)this.ki.remove(str);
      if (locala != null)
      {
        if (avgd.a.a(locala) != null) {
          ((aopo)localObject).be(avgd.a.a(locala).bZ, paramaomh.apU);
        }
        localObject = avgd.a.a(locala);
        a(str, paramaomh);
        a(m(this.mContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramaomh.mResult + "," + str + ", " + paramaomh.apU);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramaomh.mErrCode + ", " + paramaomh.clO);
          }
        }
        if (localObject != null) {
          ((avgd.b)localObject).bd(bool, str);
        }
      }
      return;
    }
  }
  
  private void a(File paramFile, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + paramString);
    }
    if ((paramFile != null) && (paramFile.exists()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramFile[i];
          String str = localObject.getPath();
          if ((str == null) || (!str.startsWith(paramString))) {}
          for (;;)
          {
            i += 1;
            break;
            if (!str.endsWith(".cfg")) {
              if (str.equals(paramString))
              {
                if (paramBoolean)
                {
                  localObject.delete();
                  if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                  }
                }
              }
              else
              {
                localObject.delete();
                if (QLog.isColorLevel()) {
                  QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, aoll paramaoll, avgd.b paramb, aopm paramaopm)
  {
    if (paramb != null) {
      paramb.ZO(paramString);
    }
    this.qx.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.lock.lock();
    try
    {
      Object localObject = (aopn)this.kj.remove(paramString);
      if (localObject != null) {
        this.a.a(((aopn)localObject).f.bZ);
      }
      localObject = new avgd.a(null);
      avgd.a.a((avgd.a)localObject, paramaoll);
      avgd.a.a((avgd.a)localObject, paramb);
      avgd.a.a((avgd.a)localObject, paramaopm);
      this.ki.put(paramString, localObject);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void a(String paramString, aomh paramaomh)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.qx.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramaomh.mResult));
      localHashMap.put("param_FailCode", String.valueOf(paramaomh.mErrCode));
      localHashMap.put("mErrDesc", paramaomh.clO);
      Object localObject = paramaomh.b;
      if ((paramaomh.mResult != 0) && (localObject != null) && ((localObject instanceof aoll))) {
        localHashMap.put("Url", ((aoll)localObject).bZ);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramaomh.nR.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramaomh.nR.get("param_reqHeader"));
      localObject = anpc.a(BaseApplication.getContext());
      String str = this.mAppInterface.getCurrentAccountUin();
      if (paramaomh.mResult == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((anpc)localObject).collectPerformance(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
        return;
      }
    }
  }
  
  private int fT(String paramString)
  {
    if ("qqreaderplugin.apk".equals(paramString)) {
      return 10010;
    }
    if ("comic_plugin.apk".equals(paramString)) {
      return 10011;
    }
    if ("qqdataline.apk".equals(paramString)) {
      return 10013;
    }
    if ("qqsmartdevice.apk".equals(paramString)) {
      return 10014;
    }
    if ("qlink_plugin.apk".equals(paramString)) {
      return 10060;
    }
    return 10058;
  }
  
  public static final File m(Context paramContext)
  {
    paramContext = new File(new File(new File(paramContext.getFilesDir(), "pddata"), "prd"), "plugin_download");
    paramContext.mkdirs();
    return paramContext;
  }
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    while (!(paramaomg instanceof aoll)) {
      return;
    }
    paramaomg = (aoll)paramaomg;
    paramaomg.apS += paramaomh.apW;
    paramaomh.apW = 0L;
    paramaomh = "bytes=" + paramaomg.apS + "-";
    paramaomg.u.put("Range", paramaomh);
  }
  
  public void a(aopn paramaopn)
  {
    this.kj.remove(paramaopn.f.U());
    a((String)paramaopn.f.U(), paramaopn.f, (avgd.b)paramaopn.userData, paramaopn);
  }
  
  public void a(PluginInfo paramPluginInfo, avgd.b paramb, boolean paramBoolean)
  {
    QLog.d("plugin_tag", 1, "doDownloadPlugin." + paramPluginInfo.mID + ", isPreDownload " + paramBoolean);
    this.lock.lock();
    Object localObject2;
    try
    {
      if (this.ki.containsKey(paramPluginInfo.mID)) {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "downloading already");
        }
      }
      do
      {
        return;
        if (this.kj.containsKey(paramPluginInfo.mID))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "pending downloading already exist");
          }
          if (paramBoolean) {
            break;
          }
          localObject1 = (aopn)this.kj.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.a.a(((aopn)localObject1).f.bZ);
          }
        }
        this.lock.unlock();
        localObject2 = this.mAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= aqhq.getAvailableInnernalMemorySize()) {
          break label235;
        }
      } while (paramb == null);
      paramb.ZN(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    label235:
    Object localObject1 = new aoll();
    ((aoll)localObject1).f = this;
    ((aoll)localObject1).a = this;
    ((aoll)localObject1).bZ = paramPluginInfo.mURL;
    ((aoll)localObject1).mHttpMethod = 0;
    ((aoll)localObject1).cMG = true;
    ((aoll)localObject1).cMW = true;
    ((aoll)localObject1).cMX = true;
    ((aoll)localObject1).bw(paramPluginInfo.mID);
    String str = new File(m(this.mContext), paramPluginInfo.mID).getPath();
    ((aoll)localObject1).atY = str;
    if ((paramBoolean) && (this.a.isEnable())) {
      this.lock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new aopn(this.mAppInterface, paramPluginInfo.mID, this, (aoll)localObject1);
        ((aopn)localObject2).userData = paramb;
        this.a.a(fT(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (aopm)localObject2);
        this.kj.put(paramPluginInfo.mID, localObject2);
        this.lock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((aoll)localObject1).bZ);
        return;
      }
      finally
      {
        this.lock.unlock();
      }
      a(paramPluginInfo.mID, (aoll)localObject1, paramb, null);
      ((aolm)localObject2).a((aomg)localObject1);
    }
  }
  
  public void cancelDownload(String paramString)
  {
    this.bG.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((aomh)paramMessage.obj);
      continue;
      a((aomg)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      ZL((String)paramMessage.obj);
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    this.bG.obtainMessage(65792, paramaomh).sendToTarget();
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.bG.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramaomg).sendToTarget();
  }
  
  static class a
  {
    private aopm jdField_a_of_type_Aopm;
    private avgd.b jdField_a_of_type_Avgd$b;
    private aoll h;
  }
  
  public static abstract interface b
    extends avgh.b
  {
    public abstract void C(int paramInt1, int paramInt2, String paramString);
    
    public abstract void ZN(String paramString);
    
    public abstract void ZO(String paramString);
    
    public abstract void bd(boolean paramBoolean, String paramString);
    
    public abstract void dc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgd
 * JD-Core Version:    0.7.0.1
 */