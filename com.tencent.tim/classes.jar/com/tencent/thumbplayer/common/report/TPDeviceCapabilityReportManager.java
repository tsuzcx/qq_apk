package com.tencent.thumbplayer.common.report;

import com.tencent.thumbplayer.api.TPNativeException;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPProperties;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;

public class TPDeviceCapabilityReportManager
{
  private static final String COMMON_DEVICE_CAP_EVENT = "tp_common_device_cap";
  private static final String TAG = "TPDeviceCapabilityReportManager";
  
  private void CommonCapabilityReport()
  {
    TPDeviceCapabilityReportParameters localTPDeviceCapabilityReportParameters = new TPDeviceCapabilityReportParameters();
    TPProperties localTPProperties = new TPProperties();
    commonParamsCollect(localTPDeviceCapabilityReportParameters.getCommonParams(), localTPProperties);
    av1DecoderCapabilityCollect(localTPDeviceCapabilityReportParameters.getAV1DecoderParams(), localTPProperties);
    TPLogUtil.i("TPDeviceCapabilityReportManager", "device capability report:" + localTPProperties.toString());
    TPBeaconReportWrapper.trackCustomKVEvent("tp_common_device_cap", localTPProperties);
  }
  
  private void av1DecoderCapabilityCollect(TPDeviceCapabilityReportParameters.AV1DecoderParams paramAV1DecoderParams, ITPReportProperties paramITPReportProperties)
  {
    TPVCodecCapabilityForGet localTPVCodecCapabilityForGet = getAV1MaxCapability();
    if (localTPVCodecCapabilityForGet != null)
    {
      paramAV1DecoderParams.av1HWDecoderProfile = localTPVCodecCapabilityForGet.getMaxProfile();
      paramAV1DecoderParams.av1HWDecoderLevel = localTPVCodecCapabilityForGet.getMaxLevel();
    }
    paramAV1DecoderParams.paramsToProperties(paramITPReportProperties);
  }
  
  private void commonParamsCollect(TPDeviceCapabilityReportParameters.CommonParams paramCommonParams, ITPReportProperties paramITPReportProperties)
  {
    paramCommonParams.apiLevel = TPSystemInfo.SDK_INT;
    paramCommonParams.flowId = (UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform());
    paramCommonParams.platform = TPPlayerConfig.getPlatform();
    paramCommonParams.osVer = String.format("Android %s", new Object[] { TPSystemInfo.getOsVersion() });
    paramCommonParams.model = String.format("%s_%s", new Object[] { TPSystemInfo.getDeviceManufacturer(), TPSystemInfo.getDeviceName() });
    paramCommonParams.serialNo = TPSystemInfo.getDeviceID(TPPlayerMgr.getAppContext());
    paramCommonParams.cpuName = TPSystemInfo.getCpuHarewareName();
    paramCommonParams.paramsToProperties(paramITPReportProperties);
  }
  
  private static TPVCodecCapabilityForGet getAV1MaxCapability()
  {
    try
    {
      TPVCodecCapabilityForGet localTPVCodecCapabilityForGet1 = TPCapability.getThumbPlayerVCodecTypeMaxCapability(1029, 102);
      if (localTPVCodecCapabilityForGet1 == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
        return null;
      }
    }
    catch (TPNativeException localTPNativeException)
    {
      TPVCodecCapabilityForGet localTPVCodecCapabilityForGet2;
      for (;;)
      {
        TPLogUtil.e("TPDeviceCapabilityReportManager", localTPNativeException);
        localTPVCodecCapabilityForGet2 = null;
      }
      return localTPVCodecCapabilityForGet2;
    }
  }
  
  public void reportAsync()
  {
    TPThreadUtil.getScheduledExecutorServiceInstance().execute(new TPDeviceCapabilityReportManager.1(this));
  }
  
  public void reportSync()
  {
    CommonCapabilityReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.common.report.TPDeviceCapabilityReportManager
 * JD-Core Version:    0.7.0.1
 */