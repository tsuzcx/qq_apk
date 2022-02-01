package com.tencent.ttpic.openapi.offlineset;

import android.os.AsyncTask;
import android.os.Build;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.AEKitDownSetting;
import com.tencent.ttpic.offlineset.beans.AEKitDownSetting.DownResInfo;
import com.tencent.ttpic.offlineset.beans.FilterSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.FilterSettingJsonBean.GassResizeSet;
import com.tencent.ttpic.offlineset.beans.FilterSettingJsonBean.GaussSetting;
import com.tencent.ttpic.offlineset.beans.MediaSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.MediaSettingJsonBean.HardDecodeDevice;
import com.tencent.ttpic.offlineset.beans.MediaSettingJsonBean.HardEncodeDevice;
import com.tencent.ttpic.offlineset.beans.PagCutoutSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.PagCutoutSettingJsonBean.PagCutoutSetting;
import com.tencent.ttpic.offlineset.beans.PagSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.PagSettingJsonBean.PagDeviceSetting;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import com.tencent.ttpic.offlineset.utils.OfflineSettingUtils;
import com.tencent.ttpic.offlineset.utils.OfflineSettingUtils.IDownloadedListener;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class OfflineFileUpdater
{
  private static final String FILTER_SETTING_FILE = "filtersetting.json";
  private static final String MEDIA_SETTING_FILE = "mediasetting.json";
  private static final String PAG_CUTOUT_FILE = "pag_cutout_setting.json";
  private static final String PAG_SETTING_FILE = "pagsetting.json";
  private static final String PTU_SDK_3548 = "3548";
  private static final String TAG = "OfflineFileUpdater";
  private static final int UPDATE_GAP_MIN = 600000;
  private static final String VALUE_WILDCARD = "*";
  private static OfflineSettingUtils.IDownloadedListener sDownloadListener = new OfflineFileUpdater.1();
  private static long sLastUpdateTime = 0L;
  
  public static void checkOfflineFile()
  {
    LogUtils.i("OfflineConfig", "will updateAllFile.");
    if (Math.abs(System.currentTimeMillis() - sLastUpdateTime) < 600000L)
    {
      LogUtils.e("OfflineFileUpdater", "十分钟内不会进行二次离线配置数据导入。请稍后再进行更新。");
      return;
    }
    sLastUpdateTime = System.currentTimeMillis();
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new OfflineFileUpdater.2());
  }
  
  public static String getAEKitSettingByResID(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    for (;;)
    {
      return null;
      paramString1 = VideoPrefsUtil.getStringParam(paramString1);
      paramString1 = PtuOfflineParser.getInstance().parseDownResInfo(paramString1);
      if (paramString1 != null) {
        try
        {
          if (Integer.parseInt(paramString2) < Integer.parseInt(paramString1.ver))
          {
            paramString1 = paramString1.getResInfo(paramString3, paramString4, paramString5, paramString6);
            return paramString1;
          }
        }
        catch (Throwable paramString1)
        {
          LogUtils.e("OfflineFileUpdater", paramString1);
        }
      }
    }
    return null;
  }
  
  private static String getStringFromFile(String paramString)
  {
    return FileOfflineUtil.readJsonStringFromFile(FileOfflineUtil.getOfflineDirPath() + File.separator + "3548" + File.separator + paramString);
  }
  
  private static boolean isCurentPhone(String paramString1, String paramString2)
  {
    return (Build.BRAND.equals(paramString1)) && ((Build.MODEL.equals(paramString2)) || ("*".equals(paramString2)));
  }
  
  public static void setHttpClient(IHttpClient paramIHttpClient)
  {
    OfflineSettingUtils.setHttpClient(paramIHttpClient);
    OfflineSettingUtils.addDownloadLister(sDownloadListener);
  }
  
  public static void updateAEKitDownSetting(AEKitDownSetting paramAEKitDownSetting, String paramString)
  {
    if (paramString == null) {
      return;
    }
    Iterator localIterator = paramAEKitDownSetting.AEKitSDKSetting.iterator();
    label15:
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (AEKitDownSetting.DownResInfo)localIterator.next();
      paramAEKitDownSetting = ((AEKitDownSetting.DownResInfo)localObject).getDownResInfoString(paramString);
      localObject = ((AEKitDownSetting.DownResInfo)localObject).res_id;
      if (paramAEKitDownSetting == null) {
        break label57;
      }
    }
    for (;;)
    {
      VideoPrefsUtil.setStringParam((String)localObject, paramAEKitDownSetting);
      break label15;
      break;
      label57:
      paramAEKitDownSetting = null;
    }
  }
  
  protected static void updateAllFile()
  {
    LogUtils.i("OfflineConfig", "updateAllFile running.");
    updateMediaSetting();
    updateFilterSetting();
    updatePagSetting();
    updatePagCutoutSetting();
  }
  
  protected static void updateFilterSetting()
  {
    Object localObject1 = FileOfflineUtil.readJsonStringFromFile(FileOfflineUtil.getOfflineDirPath() + File.separator + "3548" + File.separator + "filtersetting.json");
    if (localObject1 == null) {}
    label241:
    for (;;)
    {
      return;
      Object localObject2 = (FilterSettingJsonBean)GsonUtils.json2Obj((String)localObject1, new OfflineFileUpdater.4().getType());
      if ((localObject2 != null) && (((FilterSettingJsonBean)localObject2).gaussSetting != null))
      {
        OfflineConfig.sGauSuperPhoneYear = ((FilterSettingJsonBean)localObject2).gaussSetting.gaussSuperPhone;
        OfflineConfig.sGauMidderPhoneYear = ((FilterSettingJsonBean)localObject2).gaussSetting.gaussMidderPhone;
        OfflineConfig.sGauSuperMaxSzie = ((FilterSettingJsonBean)localObject2).gaussSetting.superMaxSize;
        OfflineConfig.sGauMidMaxSize = ((FilterSettingJsonBean)localObject2).gaussSetting.midMaxSize;
        OfflineConfig.sGauLowMaxSize = ((FilterSettingJsonBean)localObject2).gaussSetting.lowMaxSize;
        if (OfflineConfig.sGauSuperMaxSzie > 10.0F)
        {
          localObject1 = ScaleMode.USE_MAX_SIZE;
          OfflineConfig.sGauScaleMode = (ScaleMode)localObject1;
          OfflineConfig.sUpdateGaussSetting = true;
          localObject1 = ((FilterSettingJsonBean)localObject2).gaussSetting.phoneGassSet;
          if (localObject1 != null) {
            localObject1 = ((List)localObject1).iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label241;
            }
            localObject2 = (FilterSettingJsonBean.GassResizeSet)((Iterator)localObject1).next();
            if (Build.BRAND.equals(((FilterSettingJsonBean.GassResizeSet)localObject2).brand))
            {
              if (Build.MODEL.equals(((FilterSettingJsonBean.GassResizeSet)localObject2).model))
              {
                updateGausSetting((FilterSettingJsonBean.GassResizeSet)localObject2);
                return;
                localObject1 = ScaleMode.USE_SCALE_VALE;
                break;
              }
              if ("*".equals(((FilterSettingJsonBean.GassResizeSet)localObject2).model)) {
                updateGausSetting((FilterSettingJsonBean.GassResizeSet)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  private static void updateGausSetting(FilterSettingJsonBean.GassResizeSet paramGassResizeSet)
  {
    OfflineConfig.sIsGaussResize = paramGassResizeSet.needResize;
    OfflineConfig.sGaussMaxSize = paramGassResizeSet.maxSize;
    OfflineConfig.sGaussScale = paramGassResizeSet.scale;
    if (paramGassResizeSet.maxSize > 10) {
      OfflineConfig.sGauScaleMode = ScaleMode.USE_MAX_SIZE;
    }
    if ((paramGassResizeSet.scale > 0.0F) && (paramGassResizeSet.scale < 1.0F)) {
      OfflineConfig.sGauScaleMode = ScaleMode.USE_SCALE_VALE;
    }
  }
  
  protected static void updateMediaSetting()
  {
    boolean bool2 = true;
    Object localObject1 = FileOfflineUtil.readJsonStringFromFile(FileOfflineUtil.getOfflineDirPath() + File.separator + "3548" + File.separator + "mediasetting.json");
    if (localObject1 == null) {}
    Object localObject2;
    MediaSettingJsonBean.HardEncodeDevice localHardEncodeDevice;
    label146:
    do
    {
      do
      {
        return;
        localObject1 = (MediaSettingJsonBean)GsonUtils.json2Obj((String)localObject1, new OfflineFileUpdater.3().getType());
      } while (localObject1 == null);
      if (((MediaSettingJsonBean)localObject1).hardEncode != null)
      {
        localObject2 = ((MediaSettingJsonBean)localObject1).hardEncode.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localHardEncodeDevice = (MediaSettingJsonBean.HardEncodeDevice)((Iterator)localObject2).next();
          if (Build.BRAND.equals(localHardEncodeDevice.brand))
          {
            if (!Build.MODEL.equals(localHardEncodeDevice.model)) {
              break label231;
            }
            if (localHardEncodeDevice.encodetype != 0) {
              break label226;
            }
            bool1 = true;
            OfflineConfig.setHardEncodeEnable(bool1);
          }
        }
      }
    } while (((MediaSettingJsonBean)localObject1).hardDecode == null);
    localObject1 = ((MediaSettingJsonBean)localObject1).hardDecode.iterator();
    for (;;)
    {
      label167:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MediaSettingJsonBean.HardDecodeDevice)((Iterator)localObject1).next();
        if (Build.BRAND.equals(((MediaSettingJsonBean.HardDecodeDevice)localObject2).brand))
        {
          if (Build.MODEL.equals(((MediaSettingJsonBean.HardDecodeDevice)localObject2).model))
          {
            if (((MediaSettingJsonBean.HardDecodeDevice)localObject2).decodetype == 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              OfflineConfig.setHardDecodeEnable(bool1);
              return;
              label226:
              bool1 = false;
              break label146;
              label231:
              if (!"*".equals(localHardEncodeDevice.model)) {
                break;
              }
              if (localHardEncodeDevice.encodetype == 0) {}
              for (bool1 = true;; bool1 = false)
              {
                OfflineConfig.setHardEncodeEnable(bool1);
                break;
              }
            }
          }
          if ("*".equals(((MediaSettingJsonBean.HardDecodeDevice)localObject2).model)) {
            if (((MediaSettingJsonBean.HardDecodeDevice)localObject2).decodetype != 0) {
              break label299;
            }
          }
        }
      }
    }
    label299:
    for (boolean bool1 = true;; bool1 = false)
    {
      OfflineConfig.setHardDecodeEnable(bool1);
      break label167;
      break;
    }
  }
  
  private static void updatePagCutoutSetting()
  {
    Object localObject = getStringFromFile("pag_cutout_setting.json");
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = (PagCutoutSettingJsonBean)GsonUtils.json2Obj((String)localObject, new OfflineFileUpdater.6().getType());
      if (localObject != null)
      {
        localObject = ((PagCutoutSettingJsonBean)localObject).phoneSetting;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PagCutoutSettingJsonBean.PagCutoutSetting localPagCutoutSetting = (PagCutoutSettingJsonBean.PagCutoutSetting)((Iterator)localObject).next();
            if (DeviceInstance.getInstance().getDeviceName().equals(localPagCutoutSetting.deviceName)) {
              OfflineConfig.useCutoutVersion = localPagCutoutSetting.useVersion;
            }
          }
        }
      }
    }
  }
  
  private static void updatePagDeviceSetting(PagSettingJsonBean.PagDeviceSetting paramPagDeviceSetting)
  {
    OfflineConfig.sPagNeedScaleStatus = paramPagDeviceSetting.needLowScale;
    OfflineConfig.sPagScaleVaue = paramPagDeviceSetting.scale;
    OfflineConfig.sNotSupportRealTimePag = paramPagDeviceSetting.notRealTime;
    OfflineConfig.sIsPagEncodeBgStaus = paramPagDeviceSetting.encodeBackgroud;
    OfflineConfig.sNeedSoftDecoder = paramPagDeviceSetting.needSoftDecode;
  }
  
  protected static void updatePagSetting()
  {
    Object localObject = getStringFromFile("pagsetting.json");
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = (PagSettingJsonBean)GsonUtils.json2Obj((String)localObject, new OfflineFileUpdater.5().getType());
      if (localObject != null)
      {
        OfflineConfig.sLowDevYearPag = ((PagSettingJsonBean)localObject).lowDeviceYear;
        OfflineConfig.sPagScaleVaue = ((PagSettingJsonBean)localObject).lowScale;
        localObject = ((PagSettingJsonBean)localObject).phoneSetting;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PagSettingJsonBean.PagDeviceSetting localPagDeviceSetting = (PagSettingJsonBean.PagDeviceSetting)((Iterator)localObject).next();
            if (Build.BRAND.equals(localPagDeviceSetting.brand))
            {
              if (Build.MODEL.equals(localPagDeviceSetting.model))
              {
                updatePagDeviceSetting(localPagDeviceSetting);
                return;
              }
              if ("*".equals(localPagDeviceSetting.model)) {
                updatePagDeviceSetting(localPagDeviceSetting);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater
 * JD-Core Version:    0.7.0.1
 */