import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.1;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.3;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.4;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.6;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.7;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.8;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.9;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class jxo
  implements Manager
{
  private static final String UT = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/";
  private static final Long q = Long.valueOf(86400000L);
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private jxo.a jdField_a_of_type_Jxo$a;
  private final Object aE = new Object();
  private int aEm = 0;
  private int aEn;
  private boolean acN;
  private ArrayList<PAAdPreloadTask> jA = new ArrayList();
  private ArrayList<PAAdPreloadTask> jB = new ArrayList();
  private ArrayList<PAAdPreloadTask> jz = new ArrayList();
  private Context mApplicationContext;
  private WeakReference<QQAppInterface> n;
  
  public jxo(QQAppInterface paramQQAppInterface)
  {
    this.n = new WeakReference(paramQQAppInterface);
    this.mApplicationContext = paramQQAppInterface.getApplication().getApplicationContext();
  }
  
  public static void Log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementVideoPreloadManager", 2, paramString);
    }
  }
  
  private kew a()
  {
    if ((this.n != null) && (this.n.get() != null)) {
      return (kew)((QQAppInterface)this.n.get()).getManager(237);
    }
    return null;
  }
  
  private void aAY()
  {
    Log("initCacheManager");
    this.jdField_a_of_type_Jxo$a = new jxo.a(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mApplicationContext, this.jdField_a_of_type_Jxo$a);
    ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.1(this));
    this.acN = true;
  }
  
  private void aAZ()
  {
    Log("resetDownload");
    this.aEm = 0;
    synchronized (this.aE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
      this.aEn = 0;
      return;
    }
  }
  
  private static int aG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      File localFile = new File(dZ(paramString));
      if ((localFile.exists()) && (localFile.length() > 0L)) {
        return 1;
      }
      paramString = new File(ea(paramString));
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return 2;
  }
  
  public static String dZ(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(UT);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str2;
      if (localFile.exists())
      {
        str1 = str2;
        if (localFile.isDirectory()) {
          str1 = UT + String.valueOf(20170807) + "_" + paramString;
        }
      }
    }
    return str1;
  }
  
  public static boolean dp(String paramString)
  {
    return aG(paramString) == 1;
  }
  
  public static String ea(String paramString)
  {
    String str = dZ(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str)) {
      paramString = str + ".tmp";
    }
    return paramString;
  }
  
  private String getCurrentUin()
  {
    if ((this.n != null) && (this.n.get() != null)) {
      return ((QQAppInterface)this.n.get()).getCurrentUin();
    }
    return "";
  }
  
  public static void ly(String paramString)
  {
    Log("clearCacheVideo vid:" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(ea(paramString));
      if (localFile.exists()) {
        localFile.delete();
      }
      paramString = new File(dZ(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void onNetworkChange()
  {
    if (this.aEm == 0)
    {
      Log("onNetworkChange, no queue is working");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
    {
      Log("onNetworkChange, no valid task");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
    {
      Log("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", valid network, going on");
      return;
    }
    Log("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", invalid network, skip to next task");
    os(this.aEm);
  }
  
  private void os(int paramInt)
  {
    Log("continueDownload queueType:" + paramInt);
    this.aEm = 0;
    synchronized (this.aE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
      ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.9(this, paramInt));
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    ArrayList localArrayList;
    Iterator localIterator;
    synchronized (this.aE)
    {
      int i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
      j = paramConfig.version.get();
      Log("handlePreloadTaskFromConfig localVer:" + i + ", serverVer:" + j);
      if (i != j) {
        if (paramConfig.msg_content_list.size() > 0)
        {
          localArrayList = new ArrayList();
          localIterator = paramConfig.msg_content_list.get().iterator();
          if (localIterator.hasNext())
          {
            paramConfig = (ConfigurationService.Content)localIterator.next();
            if ((paramConfig != null) && (paramConfig.content.has())) {
              if (paramConfig.compress.get() == 1)
              {
                paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
                if (paramConfig == null) {
                  break label481;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break;
        }
        localArrayList.addAll(PAAdPreloadTask.parserConfigTask(paramQQAppInterface.getCurrentAccountUin(), paramConfig));
        break;
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
      catch (Exception paramConfig)
      {
        QLog.e("AdvertisementVideoPreloadManager", 1, "handlePreloadTaskFromConfig|uncompress failed " + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      Log("handlePreloadTaskFromConfig empty content");
      break;
      if (this.aEm == 1) {
        aAZ();
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      paramConfig = new ArrayList();
      localIterator = this.jz.iterator();
      while (localIterator.hasNext())
      {
        PAAdPreloadTask localPAAdPreloadTask = (PAAdPreloadTask)localIterator.next();
        if ((localPAAdPreloadTask.mExpireTime <= l) || (!localArrayList.contains(localPAAdPreloadTask))) {
          paramConfig.add(localPAAdPreloadTask);
        }
      }
      ThreadManager.executeOnFileThread(new AdvertisementVideoPreloadManager.2(this, paramConfig));
      this.jz.clear();
      this.jz.addAll(localArrayList);
      Log("handlePreloadTaskFromConfig new taskSize:" + localArrayList.size());
      ThreadManager.executeOnSubThread(new AdvertisementVideoPreloadManager.3(this));
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("public_account_ad_preload_task", j);
      paramQQAppInterface.apply();
      ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.4(this));
      for (;;)
      {
        return;
        Log("handlePreloadTaskFromConfig empty config");
        continue;
        Log("handlePreloadTaskFromConfig same version, no need to update");
      }
      label481:
      paramConfig = null;
    }
  }
  
  public void a(jxc paramjxc, int paramInt)
  {
    Object localObject = this.aE;
    if (paramjxc != null) {}
    for (;;)
    {
      String str;
      try
      {
        if ((paramjxc.a == null) || (paramjxc.jw == null) || (paramjxc.jw.size() <= paramInt))
        {
          Log("handlePreloadTaskFromPlay invalid item");
          return;
        }
        str = ((jxd)paramjxc.jw.get(paramInt)).UC;
        Log("handlePreloadTaskFromPlay msgid:" + paramjxc.Ux + ", index:" + paramInt + ", vid:" + str);
        if (!TextUtils.isEmpty(str))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = getCurrentUin();
          localPAAdPreloadTask.mVideoVid = str;
          if (this.jB.contains(localPAAdPreloadTask)) {
            break label317;
          }
          localPAAdPreloadTask.mMsgId = paramjxc.Ux;
          localPAAdPreloadTask.mSource = 3;
          if (paramjxc.pushTime > 0L)
          {
            l = paramjxc.pushTime;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + q.longValue());
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = paramjxc.a.downloadType;
            this.jB.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.7(this));
            Log("handlePreloadTaskFromPlay msgid:" + paramjxc.Ux + ", index:" + paramInt + ", vid:" + str + ", add to queue");
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      long l = NetConnInfoCenter.getServerTimeMillis();
      continue;
      label317:
      Log("handlePreloadTaskFromPlay msgid:" + paramjxc.Ux + ", index:" + paramInt + ", vid:" + str + ", exist in queue, ignore");
    }
  }
  
  public void aAX()
  {
    aAY();
  }
  
  public void c(jxc paramjxc)
  {
    Object localObject = this.aE;
    if (paramjxc != null) {}
    for (;;)
    {
      jxd localjxd;
      try
      {
        if ((paramjxc.a == null) || (paramjxc.jw == null) || (paramjxc.jw.size() <= 0))
        {
          Log("handlePreloadTaskFromMessage invalid item");
          return;
        }
        jxe localjxe = paramjxc.a;
        localjxd = (jxd)paramjxc.jw.get(0);
        Log("handlePreloadTaskFromMessage msgid:" + paramjxc.Ux + ", vid:" + localjxd.UC);
        if (!TextUtils.isEmpty(localjxd.UC))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = getCurrentUin();
          localPAAdPreloadTask.mVideoVid = localjxd.UC;
          if (this.jA.contains(localPAAdPreloadTask)) {
            break label309;
          }
          localPAAdPreloadTask.mMsgId = paramjxc.Ux;
          localPAAdPreloadTask.mSource = 2;
          if (paramjxc.pushTime > 0L)
          {
            l = paramjxc.pushTime;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + q.longValue());
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = localjxe.downloadType;
            this.jA.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.6(this));
            Log("handlePreloadTaskFromMessage msgid:" + paramjxc.Ux + ", vid:" + localjxd.UC + ", add to queue");
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      long l = NetConnInfoCenter.getServerTimeMillis();
      continue;
      label309:
      Log("handlePreloadTaskFromMessage msgid:" + paramjxc.Ux + ", vid:" + localjxd.UC + ", exist in queue, ignore");
    }
  }
  
  public void lx(String paramString)
  {
    ThreadManager.executeOnSubThread(new AdvertisementVideoPreloadManager.5(this, paramString));
  }
  
  public void onDestroy()
  {
    this.jz.clear();
    this.jA.clear();
    this.jB.clear();
    if (this.jdField_a_of_type_Jxo$a != null)
    {
      this.jdField_a_of_type_Jxo$a.onDestroy();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Jxo$a);
      this.jdField_a_of_type_Jxo$a = null;
    }
    this.acN = false;
  }
  
  public void or(int paramInt)
  {
    if (!this.acN) {
      aAX();
    }
    for (;;)
    {
      synchronized (this.aE)
      {
        Log("startVideoDownload queueType:" + paramInt);
        if (paramInt <= this.aEm)
        {
          Log("startVideoDownload queue(" + this.aEm + ") already run!");
          return;
        }
        if (this.aEm == 0) {
          break label638;
        }
        Log("startVideoDownload break current queue(" + this.aEm + ")!");
        aAZ();
        break label638;
        if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask != null) {
          break label263;
        }
        Log("startVideoDownload no task to download");
        aAZ();
        return;
      }
      if (this.aEn < this.jz.size())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jz.get(this.aEn));
        this.aEn += 1;
        continue;
        if (this.jA.size() > 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jA.remove(0));
          continue;
          if (this.jB.size() > 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jB.remove(0));
            continue;
            label263:
            this.aEm = paramInt;
            String str = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid;
            int i;
            File localFile;
            if (!TextUtils.isEmpty(str)) {
              if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime > NetConnInfoCenter.getServerTimeMillis())
              {
                i = aG(str);
                Log("startVideoDownload vid:" + str + ", cacheState:" + i);
                if (i != 1) {
                  if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
                  {
                    localFile = new File(ea(str));
                    boolean bool = localFile.exists();
                    if (bool) {}
                  }
                }
              }
            }
            for (;;)
            {
              try
              {
                localFile.createNewFile();
                Log("startVideoDownload vid:" + str);
                return;
              }
              catch (IOException localIOException)
              {
                Log("startVideoDownload create tmp file failed for vid:" + str);
                continue;
              }
              i = aqiw.getSystemNetwork(BaseApplication.getContext());
              Log("startVideoDownload vid:" + str + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", curNetType:" + i + ", no valid network, skip to next task");
              os(paramInt);
              continue;
              Log("startVideoDownload vid:" + str + ", full cached, skip to next task");
              os(paramInt);
              continue;
              Log("startVideoDownload vid:" + str + ", expireTime:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime + ", task expired, clean cache and skip to next task");
              os(paramInt);
              if (aG(str) != 0)
              {
                ThreadManager.executeOnFileThread(new AdvertisementVideoPreloadManager.8(this, str));
                continue;
                Log("startVideoDownload empty vid, skip to next task");
                os(paramInt);
              }
            }
            label638:
            switch (paramInt)
            {
            }
          }
        }
      }
    }
  }
  
  class a
    implements INetInfoHandler
  {
    jxo a;
    
    public a(jxo paramjxo)
    {
      this.a = paramjxo;
    }
    
    public void onDestroy()
    {
      this.a = null;
    }
    
    public void onNetMobile2None()
    {
      jxo.Log("onNetMobile2None");
      if (this.a != null) {
        jxo.a(this.a);
      }
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      jxo.Log("onNetMobile2Wifi");
      if (this.a != null) {
        jxo.a(this.a);
      }
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      jxo.Log("onNetNone2Mobile");
      if (this.a != null) {
        jxo.a(this.a);
      }
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      jxo.Log("onNetNone2Wifi");
      if (this.a != null) {
        jxo.a(this.a);
      }
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      jxo.Log("onNetWifi2Mobile");
      if (this.a != null) {
        jxo.a(this.a);
      }
    }
    
    public void onNetWifi2None()
    {
      jxo.Log("onNetWifi2None");
      if (this.a != null) {
        jxo.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxo
 * JD-Core Version:    0.7.0.1
 */