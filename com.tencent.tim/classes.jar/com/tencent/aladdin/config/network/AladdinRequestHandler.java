package com.tencent.aladdin.config.network;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.utils.DeviceInfoUtils;
import com.tencent.aladdin.config.utils.SpUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AladdinRequestHandler
{
  private static final String KEY_CACHE = "key_cache";
  public static final String KEY_CONFIG_COUNT = "key_config_count";
  public static final String KEY_FAILED_COUNT = "key_failed_count";
  public static final String KEY_REQUEST_TIMESTAMP = "key_request_timestamp";
  public static final String KEY_RESPONSE_TIMESTAMP = "key_response_timestamp";
  public static final String KEY_RET_CODE = "key_ret_code";
  public static final String KEY_RSP_TYPE = "key_rsp_type";
  private static final int REQ_TYPE_ACK = 1;
  private static final int REQ_TYPE_NORMAL = 0;
  private static final int RSP_TYPE_ACK = 1;
  private static final int RSP_TYPE_NORMAL = 0;
  private static final String TAG = "AladdinRequestHandler";
  private final AladdinResponseHandler responseHandler = new AladdinRequestHandler.1(this);
  
  private void ackConfigResults(String paramString, ArrayList<ConfigResult> paramArrayList)
  {
    paramString = makeAckBody(paramString, paramArrayList).toByteArray();
    paramArrayList = new Bundle();
    paramArrayList.putLong("key_request_timestamp", System.currentTimeMillis());
    onSend(paramString, paramArrayList, this.responseHandler);
  }
  
  private static void handleAckRsp(oidb_cmd0xbf8.RspBodyType2 paramRspBodyType2)
  {
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion()) {
      android.util.Log.d("AladdinRequestHandler", "handleAckRsp: " + com.tencent.aladdin.config.utils.Log.pbToString(paramRspBodyType2));
    }
    paramRspBodyType2 = paramRspBodyType2.msg.get();
    com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", "handleAckRsp: msg=" + paramRspBodyType2);
  }
  
  private ArrayList<ConfigResult> handleRspBody(oidb_cmd0xbf8.RspBodyType1 paramRspBodyType1)
  {
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion()) {
      com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", "handleRspBody: " + com.tencent.aladdin.config.utils.Log.pbToString(paramRspBodyType1));
    }
    Object localObject = paramRspBodyType1.rpt_config_list.get();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i;
    if (((Iterator)localObject).hasNext())
    {
      oidb_cmd0xbf8.Config localConfig = (oidb_cmd0xbf8.Config)((Iterator)localObject).next();
      int j = localConfig.id.get();
      int k = localConfig.version.get();
      String str = localConfig.content.get();
      for (i = localConfig.wipe_flag.get();; i = 1)
      {
        try
        {
          boolean bool = handleSingleConfigRsp(j, k, str, i);
          if (!bool) {
            continue;
          }
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.aladdin.config.utils.Log.e("AladdinRequestHandler", "handleRspBody: ", localException);
            i = 1;
          }
        }
        localArrayList.add(new ConfigResult(j, k, i));
        break;
      }
    }
    if (!Aladdin.getVersionManager().flush()) {
      com.tencent.aladdin.config.utils.Log.e("AladdinRequestHandler", "handleRspBody: failed to flush version info");
    }
    ackConfigResults(paramRspBodyType1.cookie.get(), localArrayList);
    if ((paramRspBodyType1.cache.has()) && (paramRspBodyType1.cache.get() != null))
    {
      paramRspBodyType1 = paramRspBodyType1.cache.get().toStringUtf8();
      com.tencent.aladdin.config.utils.Log.i("AladdinRequestHandler", "[handleRspBody], cache = " + paramRspBodyType1);
      SpUtils.updateSpValue("key_cache", paramRspBodyType1, true);
    }
    return localArrayList;
  }
  
  private boolean handleSingleConfigRsp(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", "[handleSingleConfigRsp] id = " + paramInt1 + ", version = " + paramInt2 + ", content = " + paramString + ", wipeFlag = " + paramInt3);
    AladdinConfigVersionManager localAladdinConfigVersionManager = Aladdin.getVersionManager();
    int i = localAladdinConfigVersionManager.getConfigVersionById(paramInt1);
    boolean bool = true;
    if (paramInt2 > i) {
      try
      {
        AladdinConfigHandler localAladdinConfigHandler = Aladdin.getConfigHandlerById(paramInt1);
        if (paramInt3 != 0)
        {
          localAladdinConfigHandler.onWipeConfig(paramInt3);
          localAladdinConfigVersionManager.setConfigVersionById(paramInt1, 0);
          return true;
        }
        bool = localAladdinConfigHandler.onReceiveConfig(paramInt1, paramInt2, paramString);
        localAladdinConfigVersionManager.setConfigVersionById(paramInt1, paramInt2);
        return bool;
      }
      catch (Exception paramString)
      {
        com.tencent.aladdin.config.utils.Log.e("AladdinRequestHandler", "handleSingleConfigRsp: ", paramString);
        bool = false;
      }
    }
    return bool;
  }
  
  private static oidb_cmd0xbf8.ReqBody makeAckBody(String paramString, List<ConfigResult> paramList)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    localReqBody.appId.set(Aladdin.getAppId().intValue());
    localReqBody.uin.set(Aladdin.getCurrentUserId());
    oidb_cmd0xbf8.ReqBodyType2 localReqBodyType2 = new oidb_cmd0xbf8.ReqBodyType2();
    localReqBodyType2.cookie.set(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ConfigResult)paramString.next();
      oidb_cmd0xbf8.ConfigResult localConfigResult = new oidb_cmd0xbf8.ConfigResult();
      localConfigResult.id.set(paramList.getId());
      localConfigResult.ret_code.set(paramList.getRetCode());
      localConfigResult.version.set(paramList.getVersion());
      localReqBodyType2.rpt_ret_list.add(localConfigResult);
    }
    localReqBody.req_type.set(1);
    localReqBody.body_type_2.set(localReqBodyType2);
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion()) {
      com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", "makeAckBody: " + com.tencent.aladdin.config.utils.Log.pbToString(localReqBody));
    }
    return localReqBody;
  }
  
  private static oidb_cmd0xbf8.DeviceInfo makeDeviceInfo()
  {
    oidb_cmd0xbf8.DeviceInfo localDeviceInfo = new oidb_cmd0xbf8.DeviceInfo();
    localDeviceInfo.os.set(new oidb_cmd0xbf8.OS());
    localDeviceInfo.os.type.set(2);
    localDeviceInfo.os.version.set(DeviceInfoUtils.getDeviceOSVersion());
    localDeviceInfo.os.sdk.set(String.valueOf(DeviceInfoUtils.getOsVersion()));
    localDeviceInfo.os.kernel.set(System.getProperty("os.version"));
    localDeviceInfo.cpu.set(new oidb_cmd0xbf8.CPU());
    localDeviceInfo.cpu.model.set(DeviceInfoUtils.getCpuType());
    localDeviceInfo.cpu.cores.set(DeviceInfoUtils.getCpuNumber());
    localDeviceInfo.cpu.frequency.set((int)DeviceInfoUtils.getCpuFrequency());
    localDeviceInfo.memory.set(new oidb_cmd0xbf8.Memory());
    localDeviceInfo.memory.total.set(DeviceInfoUtils.getSystemTotalMemory());
    localDeviceInfo.storage.set(new oidb_cmd0xbf8.Storage());
    localDeviceInfo.storage.builtin.set(DeviceInfoUtils.getRomMemroy()[0]);
    localDeviceInfo.storage.external.set(DeviceInfoUtils.getSDCardMemory()[0]);
    localDeviceInfo.screen.set(new oidb_cmd0xbf8.Screen());
    localDeviceInfo.screen.dpi.set(DeviceInfoUtils.getDispalyDpi());
    localDeviceInfo.screen.width.set((int)DeviceInfoUtils.getScreenWidth());
    localDeviceInfo.screen.height.set((int)DeviceInfoUtils.getScreenHeight());
    localDeviceInfo.camera.set(new oidb_cmd0xbf8.Camera());
    localDeviceInfo.brand.set(new oidb_cmd0xbf8.BrandInfo());
    localDeviceInfo.brand.brand.set(DeviceInfoUtils.getDeviceBrand());
    localDeviceInfo.brand.model.set(DeviceInfoUtils.getDeviceModel());
    localDeviceInfo.brand.manufacturer.set(DeviceInfoUtils.getDeviceManufacturer());
    return localDeviceInfo;
  }
  
  private static oidb_cmd0xbf8.ReqBody makeReqBody(@NonNull int[] paramArrayOfInt)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    localReqBody.appId.set(Aladdin.getAppId().intValue());
    localReqBody.uin.set(Aladdin.getCurrentUserId());
    oidb_cmd0xbf8.ReqBodyType1 localReqBodyType1 = new oidb_cmd0xbf8.ReqBodyType1();
    localReqBodyType1.app_version.set(Aladdin.getAppVersion());
    localReqBodyType1.device_info.set(makeDeviceInfo());
    localReqBodyType1.app_id.set(Aladdin.getAppFlavorId());
    AladdinConfigVersionManager localAladdinConfigVersionManager = Aladdin.getVersionManager();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      oidb_cmd0xbf8.ConfigSeq localConfigSeq = new oidb_cmd0xbf8.ConfigSeq();
      localConfigSeq.id.set(k);
      localConfigSeq.version.set(localAladdinConfigVersionManager.getConfigVersionById(k));
      localReqBodyType1.rpt_config_list.add(localConfigSeq);
      i += 1;
    }
    paramArrayOfInt = (String)SpUtils.getSpValue("key_cache", "", true);
    com.tencent.aladdin.config.utils.Log.i("AladdinRequestHandler", "[makeReqBody] cache = " + paramArrayOfInt);
    if (!TextUtils.isEmpty(paramArrayOfInt)) {
      localReqBodyType1.cache.set(ByteStringMicro.copyFromUtf8(paramArrayOfInt));
    }
    localReqBody.req_type.set(0);
    localReqBody.body_type_1.set(localReqBodyType1);
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion()) {
      com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", "makeReqBody: " + com.tencent.aladdin.config.utils.Log.pbToString(localReqBody));
    }
    return localReqBody;
  }
  
  protected abstract void onSend(byte[] paramArrayOfByte, Bundle paramBundle, AladdinResponseHandler paramAladdinResponseHandler);
  
  public void requestForUpdate(@NonNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = makeReqBody(paramArrayOfInt).toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_request_timestamp", System.currentTimeMillis());
    onSend(paramArrayOfInt, localBundle, this.responseHandler);
  }
  
  static class ConfigResult
    implements Parcelable
  {
    public static final Parcelable.Creator<ConfigResult> CREATOR = new AladdinRequestHandler.ConfigResult.1();
    private final int id;
    private final int retCode;
    private final int version;
    
    ConfigResult(int paramInt1, int paramInt2, int paramInt3)
    {
      this.id = paramInt1;
      this.version = paramInt2;
      this.retCode = paramInt3;
    }
    
    ConfigResult(Parcel paramParcel)
    {
      this.id = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.retCode = paramParcel.readInt();
    }
    
    private int getId()
    {
      return this.id;
    }
    
    private int getRetCode()
    {
      return this.retCode;
    }
    
    private int getVersion()
    {
      return this.version;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    @NonNull
    public String toString()
    {
      return "ConfigResult{id=" + this.id + ", version=" + this.version + ", retCode=" + this.retCode + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.id);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.retCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.AladdinRequestHandler
 * JD-Core Version:    0.7.0.1
 */