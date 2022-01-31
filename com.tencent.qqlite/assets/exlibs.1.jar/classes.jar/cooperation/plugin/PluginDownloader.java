package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fkj;
import fkk;
import java.io.File;
import java.util.HashMap;

public class PluginDownloader
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener
{
  private static final String jdField_a_of_type_JavaLangString = "plugin_download";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap b;
  
  public PluginDownloader(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.b = new HashMap();
  }
  
  public static final File a(Context paramContext)
  {
    return paramContext.getDir("plugin_download", 0);
  }
  
  private void a(NetReq paramNetReq, int paramInt1, int paramInt2)
  {
    String str = (String)paramNetReq.a();
    if (paramInt2 > 0)
    {
      paramNetReq = (fkk)this.b.get(str);
      if (paramNetReq == null) {
        break label95;
      }
    }
    label95:
    for (paramNetReq = fkk.a(paramNetReq);; paramNetReq = null)
    {
      if (paramNetReq != null) {
        paramNetReq.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
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
  
  private void a(String paramString, NetResp paramNetResp)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramNetResp.d));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.e));
      localHashMap.put("mErrDesc", paramNetResp.jdField_a_of_type_JavaLangString);
      localHashMap.put("mRespProperties[KeyReason]", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramNetResp.d == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localStatisticCollector.a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
        return;
      }
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.d == 0) {}
    for (boolean bool = true;; bool = false)
    {
      PluginDownloader.OnPluginDownLoadListener localOnPluginDownLoadListener = fkk.a((fkk)this.b.remove(str));
      if (localOnPluginDownLoadListener != null) {
        localOnPluginDownLoadListener.a(bool, str);
      }
      a(str, paramNetResp);
      a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnResp. result,pluginid: " + paramNetResp.d + "," + str);
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doCancelInstall: " + paramString);
    }
    Object localObject = (fkk)this.b.remove(paramString);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(fkk.a((fkk)localObject));
      localObject = fkk.a((fkk)localObject);
      if (localObject != null) {
        ((PluginDownloader.OnPluginDownLoadListener)localObject).d(paramString);
      }
      c(paramString);
    }
  }
  
  private void c(String paramString)
  {
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", "0");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramNetResp).sendToTarget();
  }
  
  public void a(PluginInfo paramPluginInfo, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDownloadPlugin." + paramPluginInfo.mID);
    }
    if (this.b.containsKey(paramPluginInfo.mID)) {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "downloading already");
      }
    }
    HttpNetReq localHttpNetReq;
    do
    {
      INetEngine localINetEngine;
      do
      {
        return;
        localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= FileUtils.a()) {
          break;
        }
      } while (paramOnPluginDownLoadListener == null);
      paramOnPluginDownLoadListener.b(paramPluginInfo.mID);
      return;
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramPluginInfo.mID);
      }
      localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
      localHttpNetReq.c = 0;
      localHttpNetReq.a(paramPluginInfo.mID);
      localHttpNetReq.b = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
      fkk localfkk = new fkk(null);
      fkk.a(localfkk, localHttpNetReq);
      fkk.a(localfkk, paramOnPluginDownLoadListener);
      this.b.put(paramPluginInfo.mID, localfkk);
      localINetEngine.a(localHttpNetReq);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramPluginInfo.mID, Long.valueOf(SystemClock.uptimeMillis()));
    } while (!QLog.isColorLevel());
    QLog.d("plugin_tag", 2, "downloadPlugin: " + localHttpNetReq.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public boolean a(String paramString)
  {
    paramString = a(this.jdField_a_of_type_AndroidContentContext).listFiles(new fkj(this, paramString));
    return (paramString != null) && (paramString.length > 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */