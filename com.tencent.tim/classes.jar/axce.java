import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.d;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.download.AEResManager.1;
import dov.com.qq.im.ae.download.AEResManager.10;
import dov.com.qq.im.ae.download.AEResManager.2;
import dov.com.qq.im.ae.download.AEResManager.3;
import dov.com.qq.im.ae.download.AEResManager.5;
import dov.com.qq.im.ae.download.AEResManager.6;
import dov.com.qq.im.ae.download.AEResManager.7;
import dov.com.qq.im.ae.download.AEResManager.8;
import dov.com.qq.im.ae.download.AEResManager.9;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class axce
  implements angp.b, ShortVideoResourceManager.d
{
  private static final String[] ji = { "DOWNLOAD_STATUS_IDLE", "DOWNLOAD_STATUS_WAIT", "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT", "DOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_READY" };
  private List<ShortVideoResourceManager.SVConfigItem> Mr = new LinkedList();
  private List<axce.a> Ms = new CopyOnWriteArrayList();
  private Queue<axcd> S = new ArrayDeque();
  private aomj c;
  private volatile boolean dua;
  private Handler mHandler;
  private HandlerThread mHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private Map<axcd, Integer> qC = new ConcurrentHashMap();
  private Map<axcd, Long> qD = new ConcurrentHashMap();
  
  private axce()
  {
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
  }
  
  public static axce a()
  {
    return axce.b.a;
  }
  
  @NonNull
  public static String a(@NonNull axcd paramaxcd)
  {
    if (!paramaxcd.aMh) {
      return "";
    }
    if (("new_qq_android_native_short_filter_".equals(paramaxcd.bvV)) || ("new_qq_android_native_ptu_res_".equals(paramaxcd.bvV))) {
      return ankq.aL(BaseApplicationImpl.getContext());
    }
    return "";
  }
  
  private void a(@Nullable axce.a parama)
  {
    if (parama == null) {}
    while ((this.Ms == null) || (this.Ms.contains(parama))) {
      return;
    }
    this.Ms.add(parama);
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull axcd paramaxcd)
  {
    axiy.i("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + paramaxcd);
    paramQQAppInterface = (aopo)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(paramaxcd.bvV)) {
        axiy.i("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((paramQQAppInterface.isEnable()) && (paramList != null))
      {
        if ((!angz.awV()) || (!paramList.check64BitReady())) {
          break label172;
        }
        paramQQAppInterface.a(paramList.arm64v8a_url);
      }
      for (;;)
      {
        axiy.i("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.isEnable());
        axiy.i("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + paramaxcd);
        return;
        label172:
        paramQQAppInterface.a(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.c paramc, @NonNull QQAppInterface paramQQAppInterface, @NonNull axcd paramaxcd)
  {
    axiy.i("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + paramaxcd);
    aopo localaopo = (aopo)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(paramaxcd.bvV)) {
        axiy.i("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if (localaopo.isEnable())
      {
        paramc = new axcf(this, paramQQAppInterface, "ae_camera_res", new AEResManager.3(this, paramaxcd, paramQQAppInterface, paramList, paramc), 4000L);
        if (localSVConfigItem != null)
        {
          if ((angz.awV()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localaopo.a(10091, null, localSVConfigItem.name, 0, paramList, ShortVideoResourceManager.ba(localSVConfigItem.name), 4, 0, true, paramc);
            axiy.i("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            axiy.i("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramaxcd);
            return bool;
          }
        }
        axiy.i("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        axiy.i("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramaxcd);
        return false;
      }
      axiy.i("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      axiy.i("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramaxcd);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void an(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    axiy.i("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    int i;
    Object localObject2;
    int k;
    int j;
    if ((paramInt == 0) || (paramInt == 1))
    {
      i = 0;
      localObject2 = axcd.jdField_b_of_type_ArrayOfAxcd;
      k = localObject2.length;
      j = 0;
    }
    for (;;)
    {
      if (j < k)
      {
        paramString1 = localObject2[j];
        if (((String)localObject1).startsWith(paramString1.bvV))
        {
          axiy.i("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.qC.put(paramString1, Integer.valueOf(4));
            this.S.remove(paramString1);
            localObject2 = new Intent();
            ((Intent)localObject2).setAction(paramString1.bvV);
            ((Intent)localObject2).setPackage(BaseApplicationImpl.getContext().getPackageName());
            ((Intent)localObject2).putExtra("ae_camera_res_downloadfinish_path", paramString2);
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.bvV.length())).intValue();
            lu(paramString1.index, j);
            label243:
            localObject1 = this.Ms.iterator();
            label254:
            if (!((Iterator)localObject1).hasNext()) {
              break label341;
            }
            localObject2 = (axce.a)((Iterator)localObject1).next();
            if (i != 0) {
              break label335;
            }
          }
          label335:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((axce.a)localObject2).a(paramString1, paramString2, bool1, i);
            break label254;
            i = paramInt;
            break;
            this.qC.put(paramString1, Integer.valueOf(0));
            this.S.remove(paramString1);
            break label243;
          }
          label341:
          if (paramInt != 1)
          {
            long l = -1L;
            if (this.qD.get(paramString1) != null) {
              l = System.currentTimeMillis() - ((Long)this.qD.get(paramString1)).longValue();
            }
            paramString2 = axim.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.index, "", "", paramInt, l);
          }
          axiy.i("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          e(new LinkedList(this.Mr), paramString1);
        }
      }
      else
      {
        axiy.i("AEResManager", "[onDownloadFinishInternal] - END -");
        return;
      }
      j += 1;
    }
  }
  
  private void ao(String paramString1, int paramInt, String paramString2)
  {
    axiy.i("AEResManager", "[onDownloadFinishWithoutLoginInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    int i;
    if (paramInt != 0)
    {
      i = paramInt;
      if (paramInt != 1) {}
    }
    else
    {
      i = 0;
    }
    Object localObject2 = axcd.jdField_b_of_type_ArrayOfAxcd;
    int j = localObject2.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < j)
      {
        paramString1 = localObject2[paramInt];
        if (((String)localObject1).startsWith(paramString1.bvV))
        {
          axiy.i("AEResManager", "[onDownloadFinishWithoutLoginInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.qC.put(paramString1, Integer.valueOf(4));
            this.S.remove(paramString1);
            localObject2 = new Intent();
            ((Intent)localObject2).setAction(paramString1.bvV);
            ((Intent)localObject2).setPackage(BaseApplicationImpl.getContext().getPackageName());
            ((Intent)localObject2).putExtra("ae_camera_res_downloadfinish_path", paramString2);
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2);
            paramInt = Integer.valueOf(((String)localObject1).substring(paramString1.bvV.length())).intValue();
            lu(paramString1.index, paramInt);
            localObject1 = this.Ms.iterator();
            label249:
            if (!((Iterator)localObject1).hasNext()) {
              break label330;
            }
            localObject2 = (axce.a)((Iterator)localObject1).next();
            if (i != 0) {
              break label324;
            }
          }
          label324:
          for (boolean bool = true;; bool = false)
          {
            ((axce.a)localObject2).a(paramString1, paramString2, bool, i);
            break label249;
            this.qC.put(paramString1, Integer.valueOf(0));
            this.S.remove(paramString1);
            break;
          }
          label330:
          axiy.i("AEResManager", "[onDownloadFinishWithoutLoginInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          f(new LinkedList(this.Mr), paramString1);
        }
      }
      else
      {
        axiy.i("AEResManager", "[onDownloadFinishWithoutLoginInternal] - END -");
        return;
      }
      paramInt += 1;
    }
  }
  
  private void b(@NonNull axcd paramaxcd, @Nullable axce.a parama)
  {
    axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + paramaxcd.index);
    if (!this.qC.containsKey(paramaxcd)) {
      this.qC.put(paramaxcd, Integer.valueOf(0));
    }
    int i = ((Integer)this.qC.get(paramaxcd)).intValue();
    axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal], status=" + ji[i]);
    if (i == 4)
    {
      i = lE(paramaxcd.index);
      if (i == 0) {
        break label582;
      }
    }
    label582:
    for (String str = ShortVideoResourceManager.zE() + paramaxcd.bvV + i;; str = null)
    {
      if (parama != null) {
        parama.a(paramaxcd, str, true, 0);
      }
      axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramaxcd.index + ", downloadStatus=DOWNLOAD_STATUS_READY");
      axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramaxcd.index);
      return;
      if (i == 3)
      {
        a(parama);
        axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramaxcd.index + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramaxcd.index);
        return;
      }
      if (!aqiw.isNetworkAvailable(null))
      {
        if (parama != null) {
          parama.a(paramaxcd, null, false, -6);
        }
        axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramaxcd.index + ", networkStatus=UNUSABLE");
        axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramaxcd.index);
        return;
      }
      axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramaxcd.index + ", networkStatus=USABLE");
      a(parama);
      if (!this.S.contains(paramaxcd))
      {
        this.S.add(paramaxcd);
        this.qC.put(paramaxcd, Integer.valueOf(1));
      }
      if (!this.qC.containsKey(axcd.jdField_b_of_type_Axcd))
      {
        this.qC.put(axcd.jdField_b_of_type_Axcd, Integer.valueOf(3));
        angj.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        axiy.i("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramaxcd.index);
        return;
        if ((this.qC.get(axcd.jdField_b_of_type_Axcd) != null) && (((Integer)this.qC.get(axcd.jdField_b_of_type_Axcd)).intValue() == 4)) {
          jy(1, 0);
        }
      }
    }
  }
  
  private void b(@NonNull axcd paramaxcd, @Nullable axce.a parama, boolean paramBoolean)
  {
    axiy.i("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + paramaxcd.index);
    if (!this.qC.containsKey(paramaxcd)) {
      this.qC.put(paramaxcd, Integer.valueOf(0));
    }
    int i = ((Integer)this.qC.get(paramaxcd)).intValue();
    axiy.i("AEResManager", "[requestDownloadInternal], status=" + ji[i]);
    if (i == 4)
    {
      i = lE(paramaxcd.index);
      if (i == 0) {
        break label716;
      }
    }
    label716:
    for (String str = ShortVideoResourceManager.zE() + paramaxcd.bvV + i;; str = null)
    {
      if (parama != null) {
        parama.a(paramaxcd, str, true, 0);
      }
      parama = new Intent();
      parama.setAction(paramaxcd.bvV);
      parama.setPackage(BaseApplicationImpl.getContext().getPackageName());
      parama.putExtra("ae_camera_res_downloadfinish_path", str);
      BaseApplicationImpl.getContext().sendBroadcast(parama);
      axiy.i("AEResManager", "[requestDownloadInternal], packageIndex=" + paramaxcd.index + ", downloadStatus=DOWNLOAD_STATUS_READY");
      axiy.i("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramaxcd.index);
      return;
      if (i == 3)
      {
        a(parama);
        axiy.i("AEResManager", "[requestDownloadInternal], packageIndex=" + paramaxcd.index + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        axiy.i("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramaxcd.index);
        return;
      }
      if ((aqiw.isNetworkAvailable(null)) && ((!paramBoolean) || (aqiw.isWifiConnected(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (parama != null) {
          parama.a(paramaxcd, null, false, -6);
        }
        axiy.e("AEResManager", "[requestDownloadInternal], packageIndex=" + paramaxcd.index + ", networkStatus=UNUSABLE");
        axiy.i("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramaxcd.index);
        return;
      }
      axiy.i("AEResManager", "[requestDownloadInternal], packageIndex=" + paramaxcd.index + ", networkStatus=USABLE");
      a(parama);
      if (!this.S.contains(paramaxcd))
      {
        this.S.add(paramaxcd);
        this.qC.put(paramaxcd, Integer.valueOf(1));
      }
      if (!this.qC.containsKey(axcd.jdField_b_of_type_Axcd))
      {
        axiy.i("AEResManager", "[requestDownloadInternal] 强制拉取配置列表" + paramaxcd.index);
        this.qC.put(axcd.jdField_b_of_type_Axcd, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        axiy.i("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramaxcd.index);
        return;
        if ((this.qC.get(axcd.jdField_b_of_type_Axcd) != null) && (((Integer)this.qC.get(axcd.jdField_b_of_type_Axcd)).intValue() == 4))
        {
          axiy.i("AEResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + paramaxcd.index);
          cu(1, 0);
        }
      }
    }
  }
  
  private void e(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface)
  {
    axiy.i("AEResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.S))
    {
      axiy.e("AEResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      axiy.i("AEResManager", "[startDownLoad] - END -");
      return;
    }
    axcd localaxcd = (axcd)this.S.peek();
    if (localaxcd == null)
    {
      axiy.e("AEResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      axiy.i("AEResManager", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.qC.containsKey(localaxcd))
    {
      i = ((Integer)this.qC.get(localaxcd)).intValue();
      axiy.d("AEResManager", "[startDownLoad], resNeedDownload=" + localaxcd);
      axiy.d("AEResManager", "[startDownLoad], status=" + ji[i]);
      if (!aOs()) {
        break label270;
      }
      axiy.i("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.qC.put(localaxcd, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localaxcd);
        }
        this.qD.put(localaxcd, Long.valueOf(System.currentTimeMillis()));
        axiy.i("AEResManager", "[startDownLoad], ShortVideoResourceManager.doUserDownloadResource()");
        ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, localaxcd.bvV);
      }
    }
    for (;;)
    {
      axiy.i("AEResManager", "[startDownLoad] + END");
      return;
      axiy.e("AEResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      axiy.i("AEResManager", "[startDownLoad] + END");
      return;
      label270:
      axiy.i("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localaxcd))
      {
        a(paramList, paramQQAppInterface, localaxcd);
        this.qD.put(localaxcd, Long.valueOf(System.currentTimeMillis()));
        axiy.i("AEResManager", "[startDownLoad], ShortVideoResourceManager.doUserDownloadResource()");
        ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, localaxcd.bvV);
        this.qC.put(localaxcd, Integer.valueOf(3));
      }
      else
      {
        this.qC.put(localaxcd, Integer.valueOf(2));
      }
    }
  }
  
  private void eIP()
  {
    axiy.i("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    Object localObject1;
    if (this.Mr.size() < 1)
    {
      axiy.i("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.Mr);
      axiy.i("AEResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      axiy.i("AEResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.Mr.size());
      localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (i != 0) {
        break label243;
      }
      this.qC.put(axcd.jdField_b_of_type_Axcd, Integer.valueOf(4));
      axiy.i("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
      e(new LinkedList(this.Mr), (QQAppInterface)localObject1);
    }
    for (;;)
    {
      axiy.i("AEResManager", "[onConfigResultInternal] ++++++ END");
      return;
      axiy.i("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
      localObject1 = new LinkedList();
      i = ShortVideoResourceManager.a(null, (List)localObject1);
      axiy.i("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
      if ((i == 0) && (((List)localObject1).size() > 0))
      {
        this.Mr.clear();
        this.Mr.addAll((Collection)localObject1);
      }
      break;
      label243:
      axiy.i("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
      Object localObject2 = new LinkedList();
      i = ShortVideoResourceManager.a("[\n    {\n        \"name\": \"new_qq_android_native_short_filter_83606\",\n        \"arm_url\": \"https://downv6.qq.com/timCamera/new_qq_android_native_short_filter_83606.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/timCamera/new_qq_android_native_short_filter_83606.zip\",\n        \"x86_url\": \"https://downv6.qq.com/timCamera/new_qq_android_native_short_filter_83606.zip\",\n        \"arm_md5\": \"8ed1bf9ef5688b0089ae336e694fa7f3\",\n        \"armv7a_md5\": \"8ed1bf9ef5688b0089ae336e694fa7f3\",\n        \"x86_md5\": \"8ed1bf9ef5688b0089ae336e694fa7f3\",\n        \"versionCode\": \"83606\",\n        \"predownload\": false\n    },\n    {\n        \"name\": \"new_qq_android_native_ptu_res_83604\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604_64bit.zip\",\n        \"arm_md5\": \"81f79730150243bbcb7c908fcb6668cd\",\n        \"armv7a_md5\": \"81f79730150243bbcb7c908fcb6668cd\",\n        \"x86_md5\": \"81f79730150243bbcb7c908fcb6668cd\",\n        \"arm64v8a_md5\": \"e858ab446b33d1620c2b17297ee9c44b\",\n        \"versionCode\": \"83604\",\n        \"predownload\": false\n    }\n]", (List)localObject2);
      if ((i == 0) && (((List)localObject2).size() > 0))
      {
        this.Mr.clear();
        this.Mr.addAll((Collection)localObject2);
      }
      if (i == 0)
      {
        this.qC.put(axcd.jdField_b_of_type_Axcd, Integer.valueOf(4));
        axiy.i("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
        e(new LinkedList(this.Mr), (QQAppInterface)localObject1);
      }
      else
      {
        this.qC.remove(axcd.jdField_b_of_type_Axcd);
        axiy.i("AEResManager", "[onConfigResultInternal] 构造内置列表失败，返回信息");
        if ((this.Ms != null) && (this.Ms.size() > 0))
        {
          i = 0;
          while (i < axcd.jdField_b_of_type_ArrayOfAxcd.length)
          {
            localObject1 = axcd.a[i];
            localObject2 = this.Ms.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((axce.a)((Iterator)localObject2).next()).a((axcd)localObject1, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void eIQ()
  {
    axiy.i("AEResManager", "[onConfigResultWithoutLoginInternal] - BEGIN -");
    int i;
    Object localObject1;
    if (this.Mr.size() < 1)
    {
      i = ShortVideoResourceManager.a(null, this.Mr);
      axiy.i("AEResManager", "[onConfigResultWithoutLoginInternal] mConfigList.size=" + this.Mr.size());
      localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (i != 0) {
        break label177;
      }
      this.qC.put(axcd.jdField_b_of_type_Axcd, Integer.valueOf(4));
      axiy.i("AEResManager", "[onConfigResultWithoutLoginInternal], download config succeeded");
      f(new LinkedList(this.Mr), (QQAppInterface)localObject1);
    }
    for (;;)
    {
      axiy.i("AEResManager", "[onConfigResultWithoutLoginInternal] - END -");
      return;
      localObject1 = new LinkedList();
      i = ShortVideoResourceManager.a(null, (List)localObject1);
      if ((i == 0) && (((List)localObject1).size() > 0))
      {
        this.Mr.clear();
        this.Mr.addAll((Collection)localObject1);
      }
      break;
      label177:
      Object localObject2 = new LinkedList();
      i = ShortVideoResourceManager.a("[\n    {\n        \"name\": \"new_qq_android_native_short_filter_83606\",\n        \"arm_url\": \"https://downv6.qq.com/timCamera/new_qq_android_native_short_filter_83606.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/timCamera/new_qq_android_native_short_filter_83606.zip\",\n        \"x86_url\": \"https://downv6.qq.com/timCamera/new_qq_android_native_short_filter_83606.zip\",\n        \"arm_md5\": \"8ed1bf9ef5688b0089ae336e694fa7f3\",\n        \"armv7a_md5\": \"8ed1bf9ef5688b0089ae336e694fa7f3\",\n        \"x86_md5\": \"8ed1bf9ef5688b0089ae336e694fa7f3\",\n        \"versionCode\": \"83606\",\n        \"predownload\": false\n    },\n    {\n        \"name\": \"new_qq_android_native_ptu_res_83604\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_83604_64bit.zip\",\n        \"arm_md5\": \"81f79730150243bbcb7c908fcb6668cd\",\n        \"armv7a_md5\": \"81f79730150243bbcb7c908fcb6668cd\",\n        \"x86_md5\": \"81f79730150243bbcb7c908fcb6668cd\",\n        \"arm64v8a_md5\": \"e858ab446b33d1620c2b17297ee9c44b\",\n        \"versionCode\": \"83604\",\n        \"predownload\": false\n    }\n]", (List)localObject2);
      if ((i == 0) && (((List)localObject2).size() > 0))
      {
        this.Mr.clear();
        this.Mr.addAll((Collection)localObject2);
      }
      if (i == 0)
      {
        this.qC.put(axcd.jdField_b_of_type_Axcd, Integer.valueOf(4));
        axiy.i("AEResManager", "[onConfigResultWithoutLoginInternal], use local config to download package");
        f(new LinkedList(this.Mr), (QQAppInterface)localObject1);
      }
      else
      {
        this.qC.remove(axcd.jdField_b_of_type_Axcd);
        axiy.e("AEResManager", "[onConfigResultWithoutLoginInternal], local config invalid");
        if ((this.Ms != null) && (this.Ms.size() > 0))
        {
          i = 0;
          while (i < axcd.jdField_b_of_type_ArrayOfAxcd.length)
          {
            localObject1 = axcd.a[i];
            localObject2 = this.Ms.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((axce.a)((Iterator)localObject2).next()).a((axcd)localObject1, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void f(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface)
  {
    axiy.i("AEResManager", "[startDownLoadWithoutLogin] - BEGIN -");
    if (CollectionUtils.isEmpty(this.S))
    {
      axiy.e("AEResManager", "[startDownLoadWithoutLogin], mDownLoadTaskQueue is empty");
      axiy.i("AEResManager", "[startDownLoadWithoutLogin] - END -");
      return;
    }
    axcd localaxcd = (axcd)this.S.peek();
    if (localaxcd == null)
    {
      axiy.e("AEResManager", "[startDownLoadWithoutLogin], mDownLoadTaskQueue top element is null");
      axiy.i("AEResManager", "[startDownLoadWithoutLogin] - END -");
      return;
    }
    if (this.qC.containsKey(localaxcd))
    {
      int i = ((Integer)this.qC.get(localaxcd)).intValue();
      axiy.d("AEResManager", "[startDownLoadWithoutLogin], resNeedDownload=" + localaxcd);
      axiy.d("AEResManager", "[startDownLoadWithoutLogin], status=" + ji[i]);
      if (i == 3) {
        break label245;
      }
      axiy.i("AEResManager", "[startDownLoadWithoutLogin], start real download, packageIndex=" + localaxcd.index);
      this.qC.put(localaxcd, Integer.valueOf(3));
      ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, localaxcd.bvV);
    }
    for (;;)
    {
      axiy.i("AEResManager", "[startDownLoadWithoutLogin] - END -");
      return;
      axiy.e("AEResManager", "[startDownLoadWithoutLogin], cannot find resNeedDownload in mStatusMap");
      axiy.i("AEResManager", "[startDownLoadWithoutLogin] - END -");
      return;
      label245:
      axiy.i("AEResManager", "[startDownLoadWithoutLogin], downloading, packageIndex=" + localaxcd.index);
    }
  }
  
  public static int lE(int paramInt)
  {
    return axis.a().l("key_ae_res_" + paramInt, 0, 4);
  }
  
  private static void lu(int paramInt1, int paramInt2)
  {
    axis.a().aY("key_ae_res_" + paramInt1, paramInt2, 4);
  }
  
  private void x(String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = axcd.jdField_b_of_type_ArrayOfAxcd;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (str.startsWith(localObject.bvV))
      {
        this.qC.put(localObject, Integer.valueOf(3));
        Iterator localIterator = this.Ms.iterator();
        while (localIterator.hasNext()) {
          ((axce.a)localIterator.next()).a(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  private void y(String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = axcd.jdField_b_of_type_ArrayOfAxcd;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (str.startsWith(localObject.bvV))
      {
        this.qC.put(localObject, Integer.valueOf(3));
        Iterator localIterator = this.Ms.iterator();
        while (localIterator.hasNext()) {
          ((axce.a)localIterator.next()).a(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  public void Ya(boolean paramBoolean)
  {
    this.dua = paramBoolean;
  }
  
  public void Z(String paramString1, int paramInt, String paramString2)
  {
    axiy.i("AEResManager", "[onDownloadFinishWithoutLogin] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.mHandler.post(new AEResManager.9(this, paramString1, paramInt, paramString2));
    axiy.i("AEResManager", "[onDownloadFinishWithoutLogin] - END -");
  }
  
  @Deprecated
  public int a(@NonNull axcd paramaxcd)
  {
    if (this.qC != null)
    {
      paramaxcd = (Integer)this.qC.get(paramaxcd);
      if (paramaxcd != null) {
        return paramaxcd.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public aomj a(@NonNull QQAppInterface paramQQAppInterface)
  {
    axiy.i("AEResManager", "[prepareHttpEngine] - BEGIN -");
    if (this.c == null)
    {
      paramQQAppInterface = new HttpCommunicator(paramQQAppInterface, 4);
      paramQQAppInterface.start();
      this.c = new aomj(paramQQAppInterface, false);
    }
    axiy.i("AEResManager", "[prepareHttpEngine] - END -");
    return this.c;
  }
  
  public void a(@NonNull axcd paramaxcd, @Nullable axce.a parama)
  {
    axiy.i("AEResManager", "[requestDownloadWithoutLogin] - BEGIN -, aeResInfo=" + paramaxcd);
    this.mHandler.post(new AEResManager.2(this, paramaxcd, parama));
    axiy.i("AEResManager", "[requestDownloadWithoutLogin] - END -, aeResInfo=" + paramaxcd);
  }
  
  public void a(@NonNull axcd paramaxcd, @Nullable axce.a parama, boolean paramBoolean)
  {
    axiy.i("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramaxcd);
    this.mHandler.post(new AEResManager.1(this, paramaxcd, parama, paramBoolean));
    axiy.i("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramaxcd);
  }
  
  public void aFW()
  {
    axiy.e("AEResManager", acfp.m(2131702166));
    anfv.jw(3, -1500);
  }
  
  public boolean aOs()
  {
    return this.dua;
  }
  
  public void b(@Nullable axce.a parama)
  {
    if (parama == null) {}
    while (this.Ms == null) {
      return;
    }
    this.Ms.remove(parama);
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    axiy.i("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.mHandler.post(new AEResManager.5(this));
    axiy.i("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void eIO()
  {
    axiy.i("AEResManager", "[destroyHttpEngine] - BEGIN -");
    if (this.c != null)
    {
      this.c.destroy();
      this.c = null;
    }
    axiy.i("AEResManager", "[destroyHttpEngine] - END -");
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    this.mHandler.post(new AEResManager.7(this, paramString, paramLong1, paramLong2));
  }
  
  public void jy(int paramInt1, int paramInt2)
  {
    axiy.i("AEResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.mHandler.post(new AEResManager.8(this));
    axiy.i("AEResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    axiy.i("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.mHandler.post(new AEResManager.6(this, paramString1, paramInt, paramString2));
    axiy.i("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void s(String paramString, long paramLong1, long paramLong2)
  {
    this.mHandler.post(new AEResManager.10(this, paramString, paramLong1, paramLong2));
  }
  
  public static abstract interface a
  {
    public abstract void a(axcd paramaxcd, long paramLong1, long paramLong2);
    
    public abstract void a(axcd paramaxcd, String paramString, boolean paramBoolean, int paramInt);
  }
  
  static class b
  {
    static final axce a = new axce(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axce
 * JD-Core Version:    0.7.0.1
 */