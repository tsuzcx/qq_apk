package com.tencent.mobileqq.shortvideo;

import aasq;
import acbn;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import angr;
import angr.a;
import anhm;
import anii;
import aniq;
import ankq;
import aqhq;
import aqul;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import imm;
import java.io.File;
import java.util.ArrayList;

public class VideoEnvironment
{
  public static b a;
  public static boolean cFQ;
  public static boolean cFR;
  private static boolean cFS;
  private static final String cdM;
  public static int dFD;
  public static String debugDecodeFilePath;
  private static Object eN;
  private static Object eO;
  private static Object eP;
  public static final String[] gE;
  public static final String[] gF = { "1000", "2000", "4000", "8000" };
  public static final String[] gI = { "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=1920*1080#2000#3000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55;3000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=1280*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=640*480#450#750;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1" };
  private static final String[] gz;
  public static final int[] nj;
  private static int[] nk = new int[16];
  public static Handler sMainHandler;
  private static ArrayList<c> ui = new ArrayList(2);
  
  static
  {
    sMainHandler = new Handler(Looper.getMainLooper());
    debugDecodeFilePath = aqul.getSDKPrivatePath(acbn.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    File localFile = new File(ShortVideoSoLoad.getShortVideoSoPath(getContext()));
    if (!localFile.exists())
    {
      localFile.mkdirs();
      m("VideoEnvironment:[static]loadPathFile not exist...", null);
    }
    gz = new String[] { "backup", "trim_process_pic", "trim_process_pie" };
    eN = new Object();
    eO = new Object();
    cdM = "backup" + File.separatorChar;
    dFD = -1;
    a = new b();
    eP = new Object();
    gE = new String[] { "1920*1080", "1280*720", "960*720", "640*480" };
    nj = new int[] { 1920, 1280, 960, 640 };
  }
  
  private static int Jo()
  {
    String str = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    String[] arrayOfString = new String[1];
    int i = b(arrayOfString);
    if (i == 255)
    {
      str = str + arrayOfString[0];
      m("Before LoadPath so. loadSoPath=" + str + "  soNameValue[0]=" + arrayOfString[0], null);
      i = ShortVideoSoLoad.LoadExtractedShortVideo(str);
      m("After LoadPath so. errCode=" + i, null);
      return i;
    }
    Qv("realDoLoadSo[errcode=" + i + "]");
    return i;
  }
  
  private static int Jp()
  {
    int j = ShortVideoSoLoad.getShortVideoSoLoadStatus();
    Object localObject1 = eN;
    int i = j;
    if (j != 0) {}
    try
    {
      m("loadAVCodecPreDownload[realDoLoadSo begin] loadcode=" + j, null);
      i = Jo();
      m("loadAVCodecPreDownload[realDoLoadSo end]loadcode=" + i, null);
      m("loadAVCodecPreDownload[After realDoLoadSo]...", null);
      Qv("loadAVCodecPreDownload[loadcode=" + i + "]");
      m("loadAVCodecPreDownload[End all] loadcode=" + i, null);
      return i;
    }
    finally {}
  }
  
  public static int Jq()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus();
  }
  
  public static int Jr()
  {
    try
    {
      if (!cFS)
      {
        getAVCodecLibMetadata(nk);
        cFS = true;
      }
      i = nk[0];
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "getAVCodecVersion: AVCodec_version=" + i);
    }
    return i;
  }
  
  private static void Qv(String paramString)
  {
    m("PrintPreDownloadInfo:[" + paramString + "]-------------***-------------", null);
  }
  
  public static void UO(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment|progress=" + paramInt);
    }
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = ui.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        c localc = (c)localObject[i];
        sMainHandler.post(new VideoEnvironment.2(localc, paramInt));
        i += 1;
      }
    }
  }
  
  public static void UP(int paramInt)
  {
    if (dFD != -1) {
      synchronized (eP)
      {
        a locala = (a)a.dr.get(paramInt);
        if (locala != null)
        {
          aniq.dFK = locala.dFE;
          aniq.dFL = locala.dFF;
          aniq.dFM = locala.dFG;
          aniq.dFI = a.dFI;
          aniq.dFJ = a.dFJ;
          aniq.dFN = a.dFN;
          aniq.dFO = a.dFO;
          dFD |= 0x2;
          return;
        }
        aniq.dFK = a.dFK;
        aniq.dFL = a.dFL;
        aniq.dFM = a.dFM;
      }
    }
  }
  
  public static void UQ(int paramInt)
  {
    if (dFD != -1) {
      synchronized (eP)
      {
        a locala = (a)a.dr.get(paramInt);
        if (locala != null)
        {
          aniq.dGY = locala.time;
          dFD |= 0x4;
          return;
        }
        if (a.dFH > 600) {
          a.dFH = 8;
        }
        aniq.dGY = a.dFH * 1000;
      }
    }
  }
  
  public static void UR(int paramInt)
  {
    Object localObject1;
    if (dFD != -1)
    {
      localObject1 = eP;
      if (paramInt > 0) {}
      for (;;)
      {
        try
        {
          aniq.dGY = paramInt * 1000;
          a.dFH = paramInt;
          dFD |= 0x4;
          return;
        }
        finally {}
        a.dFH = 8;
        aniq.dGY = a.dFH * 1000;
      }
    }
  }
  
  public static int a(String paramString, Context paramContext, boolean paramBoolean)
  {
    return d(paramString, paramContext);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramAppInterface == null) && (QLog.isColorLevel())) {
      QLog.d("VideoEnvironment", 2, "initConfig()[use default index]: app is null");
    }
    long l1 = System.currentTimeMillis();
    paramAppInterface = paramString;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig()[use user passed config]: config is null");
      }
      paramAppInterface = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "initConfig(): DPConfig = " + paramAppInterface);
    }
    paramString = paramAppInterface;
    if (paramAppInterface == null) {
      paramString = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "initConfig(): config=" + paramString);
    }
    b localb = new b();
    try
    {
      paramAppInterface = paramString.split(",");
      if ((paramAppInterface == null) || (paramAppInterface.length == 0))
      {
        if (!QLog.isColorLevel()) {
          break label1715;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): configs is null or its length is 0");
        return;
      }
      boolean bool = paramBoolean;
      if (!paramBoolean) {
        bool = DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): isInDPCWhiteList=" + bool);
      }
      paramString = paramAppInterface[0].split("\\|");
      if ((paramString == null) || (paramString.length < 13))
      {
        if (!QLog.isColorLevel()) {
          break label1715;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): configs is null or length less than 13");
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoEnvironment", 2, "initConfig(): " + paramAppInterface.getMessage());
      }
    }
    label611:
    Object localObject2;
    label831:
    label1011:
    label1141:
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): time cost " + (l2 - l1) + "ms");
      }
      a(localb);
      return;
      paramAppInterface = paramString[3].split("\\*");
      if ((paramAppInterface == null) || (paramAppInterface.length != 2))
      {
        if (!QLog.isColorLevel()) {
          break label1715;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): resolution is null or length is not 2");
        return;
      }
      localb.mIndex = 0;
      localb.mWidth = Integer.valueOf(paramAppInterface[0]).intValue();
      localb.mHeight = Integer.valueOf(paramAppInterface[1]).intValue();
      localb.mFps = Integer.valueOf(paramString[0]).intValue();
      localb.dFH = Integer.valueOf(paramString[1]).intValue();
      localb.dFO = Integer.valueOf(paramString[2]).intValue();
      localb.dFI = Integer.valueOf(paramString[4]).intValue();
      localb.dFJ = Integer.valueOf(paramString[5]).intValue();
      localb.dFL = Integer.valueOf(paramString[6]).intValue();
      localb.dFK = Integer.valueOf(paramString[7]).intValue();
      localb.dFM = Integer.valueOf(paramString[8]).intValue();
      localb.dFN = Integer.valueOf(paramString[9]).intValue();
      localb.ctp = Integer.valueOf(paramString[10]).intValue();
      localb.ctq = Integer.valueOf(paramString[11]).intValue();
      localb.dFP = Integer.valueOf(paramString[12]).intValue();
      if (paramString.length < 17)
      {
        i = 1;
        paramAppInterface = null;
        if (i == 0) {
          break label1011;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEnvironment", 2, "initConfig(): (resolutions == null) || (resolutions.length == 0) || (indexs.length != 3)");
        }
        localb.nl = new int[] { localb.mWidth };
        localb.nm = new int[] { localb.mHeight };
        localb.dFQ = 0;
        localb.dFR = 0;
      }
      for (localb.mGroupIndex = 0;; localb.mGroupIndex = i)
      {
        if (paramString.length <= 25) {
          break label1141;
        }
        paramAppInterface = getValue(paramString[17], "").split(";");
        localb.np = new int[paramAppInterface.length];
        i = 0;
        while (i < paramAppInterface.length)
        {
          localObject1 = paramAppInterface[i];
          localb.np[i] = Integer.valueOf((String)localObject1).intValue();
          i += 1;
        }
        paramAppInterface = getValue(paramString[13], "");
        if (TextUtils.isEmpty(paramAppInterface))
        {
          i = 1;
          paramAppInterface = null;
          break;
        }
        paramAppInterface = paramAppInterface.split(";");
        if ((paramAppInterface == null) || (paramAppInterface.length == 0)) {
          break label1716;
        }
        localb.nl = new int[paramAppInterface.length];
        localb.nm = new int[paramAppInterface.length];
        localb.nn = new int[paramAppInterface.length];
        localb.no = new int[paramAppInterface.length];
        i = 0;
        if (i >= paramAppInterface.length) {
          break label1710;
        }
        localObject1 = paramAppInterface[i].split("#");
        if ((localObject1 == null) || (localObject1.length < 3)) {
          break label1721;
        }
        localObject2 = localObject1[0].split("\\*");
        if ((localObject2 == null) || (localObject2.length != 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoEnvironment", 2, "initConfig(): res is null or length is not 2");
          }
          localb.nl[i] = localb.mWidth;
          localb.nm[i] = localb.mHeight;
        }
        while ((localObject1[1] != null) && (localObject1[2] != null))
        {
          localb.nn[i] = Integer.valueOf(localObject1[1]).intValue();
          localb.no[i] = Integer.valueOf(localObject1[2]).intValue();
          break;
          localb.nl[i] = Integer.valueOf(localObject2[0]).intValue();
          localb.nm[i] = Integer.valueOf(localObject2[1]).intValue();
        }
        localb.dFQ = Integer.valueOf(getValue(paramString[14], "0")).intValue();
        localb.dFR = Integer.valueOf(getValue(paramString[15], "0")).intValue();
        localb.mGroupIndex = Integer.valueOf(getValue(paramString[16], "0")).intValue();
        if (localb.dFQ >= paramAppInterface.length) {
          break label1728;
        }
        i = localb.dFQ;
        localb.dFQ = i;
        if (localb.dFR >= paramAppInterface.length) {
          break label1733;
        }
        i = localb.dFR;
        localb.dFR = i;
        if (localb.mGroupIndex >= paramAppInterface.length) {
          break label1738;
        }
        i = localb.mGroupIndex;
      }
    }
    label1090:
    label1112:
    label1134:
    paramAppInterface = getValue(paramString[18], "").split(";");
    localb.nq = new int[paramAppInterface.length];
    int i = 0;
    while (i < paramAppInterface.length)
    {
      localObject1 = paramAppInterface[i];
      localb.nq[i] = Integer.valueOf((String)localObject1).intValue();
      i += 1;
    }
    Object localObject1 = getValue(paramString[19], "").split(";");
    localb.nr = new int[paramAppInterface.length];
    i = 0;
    while (i < localObject1.length)
    {
      paramAppInterface = localObject1[i];
      localb.nr[i] = Integer.valueOf(paramAppInterface).intValue();
      i += 1;
    }
    paramAppInterface = getValue(paramString[20], "").split(";");
    if ((paramAppInterface != null) && (paramAppInterface.length == 2))
    {
      localb.dFS = Integer.valueOf(paramAppInterface[0]).intValue();
      localb.dFT = Integer.valueOf(paramAppInterface[1]).intValue();
    }
    localb.cFU = getValue(paramString[21], "").toLowerCase().contains(Build.MODEL.toLowerCase());
    if (!anii.isFoundProduct(anii.KEY_PREVIEW_DATA_LENGTH_ERR_MODEL)) {
      if (!anii.isFoundProductFeatureRom(anii.KEY_DISABLE_CHANGE_BACK_CAMERA)) {
        break label1755;
      }
    }
    for (;;)
    {
      label1369:
      localb.cFV = paramBoolean;
      if (!localb.cFV) {
        localb.cFV = pg(getValue(paramString[22], ""));
      }
      localb.cFT = getValue(paramString[23], "").equals("1");
      paramAppInterface = getValue(paramString[24], "").split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length == 2))
      {
        localb.dFU = Integer.valueOf(paramAppInterface[0]).intValue();
        localb.dFV = Integer.valueOf(paramAppInterface[1]).intValue();
      }
      paramAppInterface = paramString[25].split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length > 0)) {
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          if (i < paramAppInterface.length)
          {
            localObject1 = paramAppInterface[i].split("#");
            if ((localObject1 == null) || (localObject1.length != 5)) {
              break label1748;
            }
            int j = Integer.valueOf(localObject1[0]).intValue();
            localObject2 = new a();
            ((a)localObject2).time = Integer.valueOf(localObject1[1]).intValue();
            ((a)localObject2).dFF = Integer.valueOf(localObject1[2]).intValue();
            ((a)localObject2).dFG = Integer.valueOf(localObject1[3]).intValue();
            ((a)localObject2).dFE = Integer.valueOf(localObject1[4]).intValue();
            localb.dr.put(j, localObject2);
            break label1748;
          }
          i = paramString.length;
          if (i > 26) {}
          try
          {
            localb.zH = Float.parseFloat(paramString[26]);
            if ((localb.zH < 0.0F) || (localb.zH > 1.0F)) {
              localb.zH = 1.0F;
            }
            if (paramString.length <= 27) {
              break;
            }
            localb.nk = getValue(paramString[27], "0").equals("1");
          }
          catch (NumberFormatException paramAppInterface)
          {
            for (;;)
            {
              paramAppInterface.printStackTrace();
            }
          }
        }
        label1710:
        i = 0;
        break label611;
        label1715:
        return;
        label1716:
        i = 1;
        break label611;
        label1721:
        i += 1;
        break label831;
        label1728:
        i = 0;
        break label1090;
        label1733:
        i = 0;
        break label1112;
        label1738:
        i = 0;
        break label1134;
        paramBoolean = true;
        break label1369;
        label1748:
        i += 1;
      }
      label1755:
      paramBoolean = false;
    }
  }
  
  public static void a(b paramb)
  {
    synchronized (eP)
    {
      a = paramb;
      dFD = 0;
      return;
    }
  }
  
  public static void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment[success=" + paramBoolean + "][Video so download success...]");
    }
    if ((paramBoolean) && (p(paramAppInterface))) {
      Jp();
    }
    for (;;)
    {
      try
      {
        cFQ = true;
        paramAppInterface = ui.toArray();
        if (paramBoolean) {
          ui.clear();
        }
        if ((paramAppInterface == null) || (paramAppInterface.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < paramAppInterface.length)
      {
        c localc = (c)paramAppInterface[i];
        sMainHandler.post(new VideoEnvironment.3(localc, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static int[] a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i = -1;
    int k = -1;
    int m = k;
    int j = i;
    int[] arrayOfInt;
    if (dFD != -1) {
      arrayOfInt = new int[4];
    }
    for (;;)
    {
      synchronized (eP)
      {
        if ((a.nl == null) || (a.nm == null) || (a.nn == null) || (a.no == null)) {
          return null;
        }
        if (a.cFT)
        {
          arrayOfInt[0] = a.mWidth;
          arrayOfInt[1] = a.mHeight;
          arrayOfInt[2] = a.nn[1];
          arrayOfInt[3] = a.no[1];
          i = a.mWidth;
          paramInt = a.mHeight;
          localObject1 = arrayOfInt;
          j = i;
          m = paramInt;
          aarz.bdX = j + "*" + m;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label672;
          }
          QLog.d("DynamicAdjustment", 2, "预览分辨率 : " + localObject1[0] + " * " + localObject1[1]);
          return localObject1;
        }
        if ((a.nl != null) && (a.nm != null))
        {
          if (!a.cFU) {
            break label675;
          }
          if (paramBoolean)
          {
            break label675;
            label274:
            i = a.nl[paramInt];
            j = a.nm[paramInt];
            if (a.nk)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoEnvironment", 2, "dynamic adjust is enable");
              }
              k = paramInt;
            }
          }
        }
      }
      for (;;)
      {
        aasq localaasq;
        try
        {
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).getString("SVDNAdjustment_quality_resolution", null);
          k = paramInt;
          localaasq = aasq.a((String)localObject1);
          k = paramInt;
          paramInt = 0;
          if (localaasq == null) {
            break label717;
          }
        }
        catch (NumberFormatException localNumberFormatException1) {}
        try
        {
          if (paramInt >= a.nl.length) {
            break label717;
          }
          m = k;
          if (a.nl[paramInt] == localaasq.mWidth)
          {
            int n = a.nm[paramInt];
            int i1 = localaasq.mHeight;
            m = k;
            if (n == i1)
            {
              k = paramInt;
              QLog.d("DynamicAdjustment", 2, "应用动态调整分辨率" + (String)localObject1);
              m = paramInt;
            }
          }
          paramInt += 1;
          k = m;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label559;
          k = j;
          j = paramInt;
          paramInt = k;
        }
      }
      paramInt = a.dFR;
      continue;
      paramInt = a.mGroupIndex;
      continue;
      paramInt = a.dFQ;
    }
    for (;;)
    {
      arrayOfInt[0] = a.nl[j];
      arrayOfInt[1] = a.nm[j];
      arrayOfInt[2] = a.nn[j];
      arrayOfInt[3] = a.no[j];
      localObject1 = arrayOfInt;
      break;
      localObject2 = finally;
      throw localObject2;
      label559:
      if (QLog.isColorLevel())
      {
        QLog.e("VideoEnvironment", 2, "parseSize(): " + localNumberFormatException1.getMessage());
        break label725;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoEnvironment", 2, "dynamic adjust is disable");
          k = j;
          j = paramInt;
          paramInt = k;
          continue;
          i = a.nl[0];
          paramInt = a.nm[0];
          j = 0;
          continue;
          Object localObject3 = null;
          paramInt = k;
          break;
        }
        return localNumberFormatException2;
        switch (paramInt)
        {
        }
        paramInt = 1;
        break label274;
        label717:
        paramInt = j;
        j = k;
        continue;
      }
      label672:
      label675:
      label725:
      paramInt = j;
      j = k;
    }
  }
  
  public static boolean auL()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (imm.getCpuArchitecture() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoEnvironment", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  private static boolean awQ()
  {
    return anii.isFoundProductFeature(anii.KEY_ENCODE_ERROR_NOT_SUPPORT_PTV);
  }
  
  public static boolean awR()
  {
    if (auL()) {}
    while (!bk(6, 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean awS()
  {
    int i = Jr();
    boolean bool = lw(2);
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "supportSubmitCallback: soVersion =" + i + ", result = " + bool);
    }
    return bool;
  }
  
  public static boolean awT()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0;
  }
  
  public static boolean awU()
  {
    return jo(1) > 0;
  }
  
  private static int b(String[] paramArrayOfString)
  {
    String str = angr.zG();
    m("LoadPathso: currentSoName=" + str, null);
    if (str.equals("d000_1")) {
      return -11;
    }
    Object localObject = angr.a(str);
    int i = ((angr.a)localObject).Jm();
    m("LoadPathso: CfgParser err=" + i, null);
    if (i == 0)
    {
      localObject = ((angr.a)localObject).getVersion();
      m("LoadPathso: currentVersion=" + (String)localObject + " dymAVCodecVersion=" + 65, null);
      if (Integer.parseInt((String)localObject) >= 65)
      {
        paramArrayOfString[0] = str;
        return 255;
      }
      return -13;
    }
    return -12;
  }
  
  private static boolean bC(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = angr.pa(paramString2);
    m(paramString1 + " saveSuccess=" + bool3, null);
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool3 = angr.pa(paramString2);
      m(paramString1 + " saveSuccessTwo=" + bool3, null);
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = true;
        bool2 = angr.pa("d000_1");
        k("VideoEnvironment", paramString1 + "clearMemoryOK=" + bool2 + ",signature=" + paramString2, null);
      }
    }
    return bool1;
  }
  
  public static void bT(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      aniq.dFI = paramInt * 1000;
    }
    for (aniq.dFI += 100000;; aniq.dFI += 350000)
    {
      aniq.dFJ *= 4;
      return;
    }
  }
  
  public static boolean bk(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt2 < 0) || (paramInt2 >= 32)) {
      bool = false;
    }
    while ((jo(paramInt1) & 0xFFFFFFFF & 1 << paramInt2) != 0) {
      return bool;
    }
    return false;
  }
  
  /* Error */
  public static int d(String arg0, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 213	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoLoadStatus	()I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +32 -> 40
    //   11: new 65	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 763
    //   21: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: aconst_null
    //   32: invokestatic 118	com/tencent/mobileqq/shortvideo/VideoEnvironment:m	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   35: ldc 2
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: getstatic 131	com/tencent/mobileqq/shortvideo/VideoEnvironment:eN	Ljava/lang/Object;
    //   43: astore_0
    //   44: aload_0
    //   45: monitorenter
    //   46: invokestatic 217	com/tencent/mobileqq/shortvideo/VideoEnvironment:Jo	()I
    //   49: istore_2
    //   50: new 65	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 765
    //   60: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload_2
    //   64: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aconst_null
    //   71: invokestatic 118	com/tencent/mobileqq/shortvideo/VideoEnvironment:m	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: monitorexit
    //   76: goto -41 -> 35
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	1	paramContext	Context
    //   6	58	2	i	int
    // Exception table:
    //   from	to	target	type
    //   46	76	79	finally
    //   80	82	79	finally
    //   3	7	84	finally
    //   11	35	84	finally
    //   40	46	84	finally
    //   82	84	84	finally
  }
  
  public static void dPA()
  {
    ShortVideoSoLoad.setShortVideoSoLoadStatus(-4);
  }
  
  private static void dPw()
  {
    ThreadManager.post(new VideoEnvironment.1(), 5, null, false);
  }
  
  private static void dPx()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
    Object localObject2 = (String)localObject1 + cdM;
    File localFile1 = new File((String)localObject2 + "trim_process_pie");
    File localFile2 = new File((String)localObject1 + "trim_process_pie");
    boolean bool = localFile1.exists();
    m("copyPieAndPicFile:[VIDEO_TRIM_PIE]unzipExists=" + bool, null);
    if (bool) {
      f(localFile1, localFile2);
    }
    localObject2 = new File((String)localObject2 + "trim_process_pic");
    localObject1 = new File((String)localObject1 + "trim_process_pic");
    bool = ((File)localObject2).exists();
    m("copyPieAndPicFile:[VIDEO_TRIM_PIC]unzipExists=" + bool, null);
    if (bool) {
      f((File)localObject2, (File)localObject1);
    }
  }
  
  public static void dPy()
  {
    if ((dFD & 0x1) == 0) {
      synchronized (eP)
      {
        aniq.dHc = a.mFps;
        aniq.dHd = a.dFU;
        aniq.dHe = a.dFV;
        dFD |= 0x1;
        return;
      }
    }
  }
  
  public static void dPz()
  {
    aniq.dFI = 450000;
    aniq.dFJ = 100000;
    aniq.dFK = 38;
    aniq.dFL = 3;
    aniq.dFM = 5;
  }
  
  private static boolean f(File paramFile1, File paramFile2)
  {
    if (!paramFile1.exists()) {
      m("copySoToFilesDir: filesource not exist", null);
    }
    long l1;
    long l2;
    do
    {
      return false;
      String str3 = paramFile1.getAbsolutePath();
      String str1 = paramFile2.getAbsolutePath();
      boolean bool = paramFile2.exists();
      m("copySoToFilesDir: srcPath=" + str3 + " dstPath=" + str1 + " dstExists=" + bool, null);
      if (bool)
      {
        String str2 = angr.no(str3);
        m("copySoToFilesDir:[destFile exists] srcMd5=" + str2 + " srcPath=" + str3, null);
        str3 = angr.no(str1);
        m("copySoToFilesDir:[destFile exists] dstMd5=" + str3 + " dstPath=" + str1, null);
        if ((str2 != null) && (!"".equals(str2)) && (str2.equalsIgnoreCase(str3))) {
          return true;
        }
        paramFile2.delete();
      }
      l1 = paramFile1.length();
      aqhq.renameFile(paramFile1, paramFile2);
      l2 = paramFile2.length();
      m("copySoToFilesDir: soSize=" + l1 + " deSize=" + l2, null);
    } while (l1 != l2);
    return true;
  }
  
  private static native void getAVCodecLibMetadata(int[] paramArrayOfInt);
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  private static String getValue(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("=");
    if (i == -1) {
      return paramString2;
    }
    return paramString1.substring(i + 1);
  }
  
  public static boolean isBeautySupported()
  {
    if (auL()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = imm.isBeautySupported();
      bool2 = awU();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "isX86Platform: isBeautySupported=" + bool1 + " isSoSupportBeauty=" + bool2);
      }
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  private static int jo(int paramInt)
  {
    if ((paramInt <= 0) && (paramInt >= 16)) {
      return 0;
    }
    try
    {
      if (!cFS)
      {
        getAVCodecLibMetadata(nk);
        cFS = true;
      }
      paramInt = nk[paramInt];
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0;
  }
  
  public static void jz(int paramInt1, int paramInt2)
  {
    Object localObject = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    localObject = new File((String)localObject + cdM);
    boolean bool = ((File)localObject).exists();
    m("initBuiltInDoCopyEnvStep:[begin] backupDirExists=" + bool, null);
    if (!bool) {
      ((File)localObject).mkdirs();
    }
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_clear_sp", 4);
    if (((SharedPreferences)localObject).getInt("flow_filter_clear_key", -1) < 1) {
      ((SharedPreferences)localObject).edit().putInt("flow_filter_clear_key", 1).commit();
    }
    m("initBuiltInDoCopyEnvStep:clear earlyDownload cache data...", null);
    ankq.dRh();
    m("initBuiltInDoCopyEnvStep:[end]...", null);
  }
  
  public static void k(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i(paramString1, 2, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i(paramString1, 2, paramString2);
  }
  
  public static boolean lv(int paramInt)
  {
    if (paramInt > 65) {}
    while (paramInt == 65) {
      return true;
    }
    return false;
  }
  
  public static boolean lw(int paramInt)
  {
    return jo(paramInt) > 0;
  }
  
  public static void m(String paramString, Throwable paramThrowable)
  {
    k("VideoEnvironment", paramString, paramThrowable);
  }
  
  public static boolean n(AppInterface paramAppInterface)
  {
    return (VersionUtils.isIceScreamSandwich()) && (p(paramAppInterface)) && (!awQ());
  }
  
  private static String nt(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static boolean o(AppInterface paramAppInterface)
  {
    return (VersionUtils.isIceScreamSandwich()) && (p(paramAppInterface));
  }
  
  private static boolean oU(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < gz.length)
      {
        if (paramString.equals(gz[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static boolean p(AppInterface arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: getstatic 916	com/tencent/mobileqq/shortvideo/ShortVideoUtils:cFF	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 916	com/tencent/mobileqq/shortvideo/ShortVideoUtils:cFF	Z
    //   15: istore 4
    //   17: iload 4
    //   19: ireturn
    //   20: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +43 -> 66
    //   26: ldc 242
    //   28: iconst_2
    //   29: new 65	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 918
    //   39: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: getstatic 923	android/os/Build$VERSION:SDK_INT	I
    //   45: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 925
    //   51: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: getstatic 520	android/os/Build:MODEL	Ljava/lang/String;
    //   57: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 6
    //   68: istore 4
    //   70: getstatic 923	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 10
    //   75: if_icmplt -58 -> 17
    //   78: getstatic 144	com/tencent/mobileqq/shortvideo/VideoEnvironment:dFD	I
    //   81: iconst_m1
    //   82: if_icmpne +86 -> 168
    //   85: aload_0
    //   86: aconst_null
    //   87: iconst_0
    //   88: invokestatic 927	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)V
    //   91: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +74 -> 168
    //   97: ldc 242
    //   99: iconst_2
    //   100: ldc_w 929
    //   103: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: ldc 242
    //   108: iconst_2
    //   109: new 65	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 931
    //   119: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 147	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$b;
    //   125: getfield 449	com/tencent/mobileqq/shortvideo/VideoEnvironment$b:ctp	I
    //   128: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: ldc 242
    //   139: iconst_2
    //   140: new 65	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 933
    //   150: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 147	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$b;
    //   156: getfield 452	com/tencent/mobileqq/shortvideo/VideoEnvironment$b:ctq	I
    //   159: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: getstatic 149	com/tencent/mobileqq/shortvideo/VideoEnvironment:eP	Ljava/lang/Object;
    //   171: astore_0
    //   172: aload_0
    //   173: monitorenter
    //   174: getstatic 147	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$b;
    //   177: getfield 455	com/tencent/mobileqq/shortvideo/VideoEnvironment$b:dFP	I
    //   180: istore_1
    //   181: getstatic 147	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$b;
    //   184: getfield 449	com/tencent/mobileqq/shortvideo/VideoEnvironment$b:ctp	I
    //   187: istore_2
    //   188: getstatic 147	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$b;
    //   191: getfield 452	com/tencent/mobileqq/shortvideo/VideoEnvironment$b:ctq	I
    //   194: istore_3
    //   195: getstatic 147	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$b;
    //   198: getfield 543	com/tencent/mobileqq/shortvideo/VideoEnvironment$b:cFV	Z
    //   201: istore 7
    //   203: aload_0
    //   204: monitorexit
    //   205: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +92 -> 300
    //   211: ldc 242
    //   213: iconst_2
    //   214: new 65	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 935
    //   224: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload_1
    //   228: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: ldc 242
    //   239: iconst_2
    //   240: new 65	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 937
    //   250: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload_2
    //   254: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: ldc 242
    //   265: iconst_2
    //   266: new 65	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 939
    //   276: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload_3
    //   280: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc_w 941
    //   286: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 7
    //   291: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   294: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload 7
    //   302: ifeq +68 -> 370
    //   305: iload 6
    //   307: istore 4
    //   309: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq -295 -> 17
    //   315: ldc 242
    //   317: iconst_2
    //   318: new 65	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 943
    //   328: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload 7
    //   333: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   336: ldc_w 925
    //   339: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 520	android/os/Build:MODEL	Ljava/lang/String;
    //   345: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: ireturn
    //   356: astore_0
    //   357: aload_0
    //   358: invokevirtual 944	java/lang/Throwable:printStackTrace	()V
    //   361: iconst_0
    //   362: ireturn
    //   363: astore 8
    //   365: aload_0
    //   366: monitorexit
    //   367: aload 8
    //   369: athrow
    //   370: getstatic 661	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   373: astore_0
    //   374: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +29 -> 406
    //   380: ldc 242
    //   382: iconst_2
    //   383: new 65	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 946
    //   393: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: invokestatic 690	com/tencent/mobileqq/shortvideo/VideoEnvironment:auL	()Z
    //   409: ifeq +48 -> 457
    //   412: getstatic 948	com/tencent/mobileqq/shortvideo/VideoEnvironment:cFR	Z
    //   415: istore 5
    //   417: iload 5
    //   419: istore 4
    //   421: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -407 -> 17
    //   427: ldc 242
    //   429: iconst_2
    //   430: new 65	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 950
    //   440: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: iload 5
    //   445: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   448: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iload 5
    //   456: ireturn
    //   457: iload_1
    //   458: iconst_1
    //   459: if_icmpne +77 -> 536
    //   462: aload_0
    //   463: ifnull +116 -> 579
    //   466: ldc_w 474
    //   469: aload_0
    //   470: invokevirtual 552	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifne +106 -> 579
    //   476: ldc_w 952
    //   479: aload_0
    //   480: invokevirtual 673	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   483: ifeq +96 -> 579
    //   486: iload 5
    //   488: istore 4
    //   490: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +40 -> 533
    //   496: ldc 242
    //   498: iconst_2
    //   499: new 65	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 954
    //   509: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_0
    //   513: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 956
    //   519: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 4
    //   524: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: iload 4
    //   535: ireturn
    //   536: iload 5
    //   538: istore 4
    //   540: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq -53 -> 490
    //   546: ldc 242
    //   548: iconst_2
    //   549: new 65	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 958
    //   559: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iconst_1
    //   563: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: iload 5
    //   574: istore 4
    //   576: goto -86 -> 490
    //   579: iconst_0
    //   580: istore 4
    //   582: goto -92 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   180	280	1	i	int
    //   187	67	2	j	int
    //   194	86	3	k	int
    //   15	566	4	bool1	boolean
    //   1	572	5	bool2	boolean
    //   4	302	6	bool3	boolean
    //   201	131	7	bool4	boolean
    //   363	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   85	91	356	java/lang/Throwable
    //   174	205	363	finally
    //   365	367	363	finally
  }
  
  private static boolean pg(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String str = Build.MODEL.toLowerCase();
      paramString = paramString.split("\\;");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString[i].equalsIgnoreCase(str)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean q(AppInterface paramAppInterface)
  {
    return p(paramAppInterface);
  }
  
  public static int[] q(int paramInt)
  {
    localObject4 = eP;
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        localObject1 = anhm.nv;
        localObject3 = localObject1;
        if (localObject1.length != anhm.nv.length) {
          localObject3 = anhm.nv;
        }
        return localObject3;
      }
      finally {}
      Object localObject3 = a.nq;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = anhm.nx;
        continue;
        localObject3 = a.nr;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = anhm.nw;
          continue;
          localObject3 = a.np;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = anhm.nv;
          }
        }
      }
    }
  }
  
  public static boolean r(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.awI()) {}
    do
    {
      return true;
      ShortVideoUtils.B(paramAppInterface);
    } while (ShortVideoUtils.awI());
    return false;
  }
  
  private static boolean r(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramString = new File(paramString + "config_version");
    if (!paramString.exists()) {}
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            return false;
            paramString = angr.q(paramString);
          } while (TextUtils.isEmpty(paramString));
          paramString = paramString.trim();
          str = zQ();
        } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString)));
        paramString = angr.a(str);
      } while (paramString.Jm() != 0);
      paramString = paramString.getVersion().trim();
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase("" + paramInt)));
    return r(paramQQAppInterface);
  }
  
  public static boolean s(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    Object localObject2 = str1 + cdM;
    m("VideoEnvironment:[uncompressZipSo]destDir=" + (String)localObject2, null);
    File localFile;
    boolean bool1;
    for (;;)
    {
      try
      {
        synchronized (eO)
        {
          localFile = new File((String)localObject2);
          if (!localFile.exists())
          {
            localFile.mkdirs();
            paramQQAppInterface = (String)localObject2 + nt("AVCodec");
            localFile = new File(paramQQAppInterface);
            if (localFile.exists())
            {
              m("VideoEnvironment:[uncompressZipSo][has back file] path=" + paramQQAppInterface, null);
              localFile.delete();
            }
            aqhq.W(paramString, (String)localObject2, false);
            bool1 = localFile.exists();
            m("VideoEnvironment:[end uncompressZipSo] existsFile=" + bool1, null);
            if (bool1) {
              break;
            }
            throw new RuntimeException("After uncompressZip,AVCodec file not exist...");
          }
        }
        bool1 = r(paramQQAppInterface, (String)localObject2, paramInt);
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        m("VideoEnvironment:exp=", paramQQAppInterface);
        return true;
      }
      m("VideoEnvironment:[checkUncompressedResourceIsOK] checkOK=" + bool1, null);
      if (bool1) {
        return false;
      }
    }
    paramString = new File((String)localObject2 + "config_version");
    if (!paramString.exists()) {
      throw new RuntimeException("After uncompressZip,config_version file not exist...");
    }
    localObject2 = angr.a(angr.q(paramString));
    paramInt = ((angr.a)localObject2).Jm();
    if (paramInt != 0)
    {
      m("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=" + paramInt, null);
      throw new RuntimeException("createParser err=" + paramInt);
    }
    Object localObject3 = angr.no(paramQQAppInterface);
    paramString = ((angr.a)localObject2).getMd5();
    m("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3, null);
    if (!paramString.equalsIgnoreCase((String)localObject3)) {
      throw new RuntimeException("[Md5 error] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3);
    }
    long l1 = localFile.length();
    localObject3 = ((angr.a)localObject2).getVersion().trim();
    localObject2 = angr.bv(paramString, (String)localObject3);
    m("VideoEnvironment:[uncompressZipSo][trim] versionvalid=" + (String)localObject3 + " soNewName=" + (String)localObject2, null);
    str1 = str1 + (String)localObject2;
    localObject3 = new File(str1);
    paramInt = 0;
    long l2;
    String str2;
    if (((File)localObject3).exists())
    {
      l2 = ((File)localObject3).length();
      str2 = angr.no(str1);
      if (!paramString.equalsIgnoreCase(str2))
      {
        bool1 = true;
        m("VideoEnvironment:[uncompressZipSo] md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2, null);
        if (bool1)
        {
          ((File)localObject3).delete();
          paramInt = 1;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        if (!localFile.renameTo((File)localObject3))
        {
          throw new RuntimeException("[renameTo error] destFilePath=" + paramQQAppInterface + "  loadFilePath=" + str1);
          m("VideoEnvironment:[uncompressZipSo] Restore SP md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2 + ",md5Cfg=" + paramString, null);
          bool1 = bC("VideoEnvironment:[uncompressZipSo Restore SP ]storeSoNewVersion", (String)localObject2);
          break label916;
        }
        l2 = ((File)localObject3).length();
        if (l1 == l2)
        {
          m("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion loadLength=" + l2 + "  soNewName=" + (String)localObject2, null);
          bool1 = bC("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion", (String)localObject2);
        }
      }
      else
      {
        dPx();
        dPw();
        return bool1;
      }
      throw new RuntimeException("[length error] destLength=" + l1 + " loadLength=" + l2);
      label916:
      continue;
      bool1 = false;
      break;
      bool1 = false;
      paramInt = 1;
    }
  }
  
  private static String zO()
  {
    return angr.bv("HookTestAVCodec001", "65");
  }
  
  private static String zP()
  {
    return angr.bv("HookTestAVCodecSdcard002", "65");
  }
  
  public static String zQ()
  {
    String[] arrayOfString = new String[1];
    int i = b(arrayOfString);
    m("getShortVideoSoLibName: errcode=" + i + " soNameValue=" + arrayOfString[0], null);
    if (i == 255) {
      return arrayOfString[0];
    }
    Qv("getShortVideoSoLibName[err=" + i + "]");
    m("getShortVideoSoLibName[get End],errcode=" + i, null);
    return null;
  }
  
  public static class a
  {
    int dFE;
    int dFF;
    int dFG;
    int time;
  }
  
  public static class b
  {
    public boolean cFT;
    public boolean cFU;
    public boolean cFV;
    public int ctp;
    public int ctq;
    public int dFH = 8;
    public int dFI = 550000;
    public int dFJ = 100000;
    public int dFK = 35;
    public int dFL = 3;
    public int dFM = 3;
    public int dFN = 1;
    public int dFO = 1;
    public int dFP;
    public int dFQ;
    public int dFR;
    public int dFS = -1;
    public int dFT = -1;
    public int dFU = 2;
    public int dFV = 3;
    public SparseArray<VideoEnvironment.a> dr = new SparseArray();
    public int mFps = 30;
    public int mGroupIndex;
    public int mHeight = 480;
    public int mIndex = -1;
    public int mWidth = 640;
    public boolean nk;
    public int[] nl;
    public int[] nm;
    public int[] nn;
    public int[] no;
    public int[] np;
    public int[] nq;
    public int[] nr;
    public float zH = 1.0F;
  }
  
  public static abstract interface c
  {
    public abstract void PI(boolean paramBoolean);
    
    public abstract void US(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment
 * JD-Core Version:    0.7.0.1
 */