package com.tencent.qqmini.sdk.plugins;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class BluetoothJsPlugin
  extends BaseJsPlugin
{
  private static final String BASE_UUID_SUFFIX = "-0000-1000-8000-00805F9B34FB";
  private static final int DATA_TYPE_FLAGS = 1;
  private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
  private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
  private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
  private static final int DATA_TYPE_SERVICE_DATA = 22;
  private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
  private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
  private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
  private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
  private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
  private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
  private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
  private static final String ERR_CODE = "errCode";
  private static final int ERR_CODE_CONN_FAIL = 10003;
  private static final int ERR_CODE_NOT_AVAILABLE = 10001;
  private static final int ERR_CODE_NOT_CONN = 10006;
  private static final int ERR_CODE_NOT_INIT = 10000;
  private static final int ERR_CODE_NO_CHARACTERISTIC = 10005;
  private static final int ERR_CODE_NO_DEVICE = 10002;
  private static final int ERR_CODE_NO_SERVICE = 10004;
  private static final int ERR_CODE_PROPERTY_NOT_SUPPORT = 10007;
  private static final int ERR_CODE_SUCC = 0;
  private static final int ERR_CODE_SYSTEM_ERROR = 10008;
  private static final int ERR_CODE_SYSTEM_NOT_SUPPORT = 10009;
  private static final String EVENT_CREATE_BLE_CONNECTION = "createBLEConnection";
  private static final String EVENT_GET_BLE_DEVICE_SERVICES = "getBLEDeviceServices";
  private static final long FOUND_DEVICES_DEFAULT_INTERVAL = 500L;
  private static final long SCAN_MAX_TIME = 15000L;
  public static final String TAG = "BluetoothJsPlugin";
  private static final int UUID_BYTES_128_BIT = 128;
  private static final int UUID_BYTES_16_BIT = 16;
  private static final int UUID_BYTES_32_BIT = 32;
  private static final int WHAT_SCAN_CALLBACK = 2;
  private static final int WHAT_SCAN_TIMEOUT = 1;
  private HashMap<String, BluetoothDeviceExtend> allFoundDevices = new HashMap();
  private BLEScan bleScan = new BLEScan();
  private boolean isSettingBlueTooth;
  private boolean isSupportBlueTooth;
  private Activity mActivity;
  private BluetoothAdapter mBluetoothAdapter;
  BroadcastReceiver mBluetoothStateReceiver = new BluetoothJsPlugin.1(this);
  private boolean sIsReceiverRegister;
  private Handler subHandler;
  
  private void closeAdapter()
    throws Exception
  {
    QMLog.d("BluetoothJsPlugin", "closeAdapter......");
    this.bleScan.stopDiscovery("closeAdapter");
    synchronized (this.allFoundDevices)
    {
      Iterator localIterator = this.allFoundDevices.values().iterator();
      if (localIterator.hasNext()) {
        ((BluetoothDeviceExtend)localIterator.next()).destory();
      }
    }
    this.allFoundDevices.clear();
    if ((this.mBluetoothAdapter != null) && (this.mBluetoothAdapter.disable())) {
      throw new RuntimeException("closeAdapter fail, mBluetoothAdapter.disable fail");
    }
    unregisterBluetoothStateReceiver();
    this.mBluetoothStateReceiver = null;
    this.mBluetoothAdapter = null;
    this.isSettingBlueTooth = false;
  }
  
  @JsEvent({"closeBLEConnection"})
  @TargetApi(18)
  private void closeBLEConnection(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).getString("deviceId");
      if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(str))) {
        throw new Exception("closeBLEConnection fail, mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str);
      }
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
      return;
    }
    BluetoothDeviceExtend localBluetoothDeviceExtend = findBluetoothDeviceExtend(localException);
    boolean bool = false;
    if (localBluetoothDeviceExtend != null)
    {
      bool = localBluetoothDeviceExtend.disconnectGatt();
      if (bool) {}
    }
    else
    {
      throw new Exception("closeBLEConnection fail! deviceExtend=" + localBluetoothDeviceExtend + ",disconnect=" + bool);
    }
    paramRequestEvent.ok();
  }
  
  @JsEvent({"closeBluetoothAdapter"})
  @TargetApi(18)
  private void closeBluetoothAdapter(RequestEvent paramRequestEvent)
  {
    QMLog.d("BluetoothJsPlugin", "closeBluetoothAdapter callbackId=" + paramRequestEvent.callbackId);
    try
    {
      closeAdapter();
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"createBLEConnection"})
  @TargetApi(18)
  private void createBLEConnection(RequestEvent paramRequestEvent)
  {
    QMLog.d("BluetoothJsPlugin", "createBLEConnection jsonParams=" + paramRequestEvent.jsonParams + ",callbackId=" + paramRequestEvent.callbackId);
    long l;
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject1).getString("deviceId");
      l = ((JSONObject)localObject1).optLong("timeout", 0L);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.mBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = findBluetoothDeviceExtend(str);
          if (localObject1 != null) {
            break label173;
          }
        }
      }
      throw new Exception("createBLEConnection fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + localObject1);
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
      return;
    }
    label173:
    localException.connectGatt(this.mActivity, false, l, paramRequestEvent.callbackId);
  }
  
  private static byte[] extractBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  private BluetoothDeviceExtend findBluetoothDeviceExtend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (BluetoothDeviceExtend)this.allFoundDevices.get(paramString);
  }
  
  @JsEvent({"getBLEDeviceCharacteristics"})
  @TargetApi(18)
  private void getBLEDeviceCharacteristics(RequestEvent paramRequestEvent)
  {
    Object localObject4;
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      localObject3 = ((JSONObject)localObject1).getString("deviceId");
      localObject4 = ((JSONObject)localObject1).getString("serviceId");
      localObject2 = null;
      localObject1 = localObject2;
      if (this.mBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = findBluetoothDeviceExtend((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            if (((BluetoothDeviceExtend)localObject2).services != null) {
              break label148;
            }
            localObject1 = localObject2;
          }
        }
      }
      throw new Exception("getBLEDeviceCharacteristics fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject3 + ",deviceExtend=" + localObject1);
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
      return;
    }
    label148:
    JSONArray localJSONArray = new JSONArray();
    Object localObject3 = new JSONObject();
    Object localObject2 = ((BluetoothDeviceExtend)localObject2).services.iterator();
    Object localObject5;
    JSONObject localJSONObject;
    while (((Iterator)localObject2).hasNext())
    {
      localObject5 = (BluetoothGattService)((Iterator)localObject2).next();
      if (((String)localObject4).equalsIgnoreCase(((BluetoothGattService)localObject5).getUuid().toString()))
      {
        localObject2 = ((BluetoothGattService)localObject5).getCharacteristics().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (BluetoothGattCharacteristic)((Iterator)localObject2).next();
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("uuid", ((BluetoothGattCharacteristic)localObject4).getUuid().toString());
          localJSONObject = new JSONObject();
          int i = ((BluetoothGattCharacteristic)localObject4).getProperties();
          if ((i & 0x2) <= 0) {
            break label436;
          }
          bool = true;
          label299:
          localJSONObject.put("read", bool);
          if ((i & 0x8) <= 0) {
            break label441;
          }
          bool = true;
          label318:
          localJSONObject.put("write", bool);
          if ((i & 0x10) <= 0) {
            break label446;
          }
          bool = true;
          label337:
          localJSONObject.put("notify", bool);
          if ((i & 0x20) <= 0) {
            break label451;
          }
        }
      }
    }
    label436:
    label441:
    label446:
    label451:
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("indicate", bool);
      ((JSONObject)localObject5).put("properties", localJSONObject);
      localJSONArray.put(localObject5);
      break;
      QMLog.d("BluetoothJsPlugin", "getBLEDeviceCharacteristics characteristics=" + localJSONArray.toString());
      ((JSONObject)localObject3).put("characteristics", localJSONArray);
      paramRequestEvent.ok((JSONObject)localObject3);
      return;
      bool = false;
      break label299;
      bool = false;
      break label318;
      bool = false;
      break label337;
    }
  }
  
  @JsEvent({"getBLEDeviceServices"})
  @TargetApi(18)
  private void getBLEDeviceServices(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).getString("deviceId");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.mBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = findBluetoothDeviceExtend(str);
          if (localObject1 != null) {
            break label109;
          }
        }
      }
      throw new Exception("getBLEDeviceServices fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + localObject1);
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
      return;
    }
    label109:
    localException.getServices(paramRequestEvent);
  }
  
  @JsEvent({"getBluetoothAdapterState"})
  private void getBluetoothAdapterState(RequestEvent paramRequestEvent)
  {
    QMLog.d("BluetoothJsPlugin", "getBluetoothAdapterState callbackId=" + paramRequestEvent.callbackId);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.mBluetoothAdapter == null) {
        throw new RuntimeException("getBluetoothAdapterState fail, mBluetoothAdapter is null");
      }
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
      return;
    }
    localException.put("available", this.mBluetoothAdapter.isEnabled());
    localException.put("discovering", this.bleScan.isDiscovering);
    paramRequestEvent.ok();
  }
  
  @JsEvent({"getBluetoothDevices"})
  private void getBluetoothDevices(RequestEvent paramRequestEvent)
  {
    QMLog.d("BluetoothJsPlugin", "getBluetoothDevices callbackId=" + paramRequestEvent.callbackId);
    JSONArray localJSONArray;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      synchronized (this.allFoundDevices)
      {
        Iterator localIterator = this.allFoundDevices.values().iterator();
        if (localIterator.hasNext()) {
          localJSONArray.put(((BluetoothDeviceExtend)localIterator.next()).toJson());
        }
      }
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail();
      return;
    }
    localJSONObject2.put("devices", localJSONArray);
    paramRequestEvent.ok(localJSONObject2);
  }
  
  @JsEvent({"getConnectedBluetoothDevices"})
  @TargetApi(18)
  private void getConnectedBluetoothDevices(RequestEvent paramRequestEvent)
  {
    int j = 0;
    QMLog.d("BluetoothJsPlugin", "getConnectedBluetoothDevices jsonParams=" + paramRequestEvent.jsonParams + ",callbackId=" + paramRequestEvent.callbackId);
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("services");
        JSONArray localJSONArray = new JSONArray();
        if (localObject2 != null)
        {
          i = ((JSONArray)localObject2).length();
          if (i >= 1) {
            break;
          }
          throw new RuntimeException("params services is empty!");
        }
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        return;
      }
      i = 0;
    }
    Object localObject1 = new ArrayList();
    for (;;)
    {
      Object localObject3;
      if (j < i)
      {
        localObject3 = parseUuidFromStr(((JSONArray)localObject2).getString(j));
        if (localObject3 != null) {
          ((List)localObject1).add(localObject3);
        }
      }
      else
      {
        localObject2 = this.allFoundDevices.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BluetoothDeviceExtend)((Iterator)localObject2).next();
          if ((((BluetoothDeviceExtend)localObject3).state == 2) && (((BluetoothDeviceExtend)localObject3).containsUUID((List)localObject1)))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.putOpt("name", ((BluetoothDeviceExtend)localObject3).getDeviceName());
            localJSONObject.put("deviceId", ((BluetoothDeviceExtend)localObject3).mDevicesId);
            localException.put(localJSONObject);
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("devices", localException);
        paramRequestEvent.ok((JSONObject)localObject1);
        return;
      }
      j += 1;
    }
  }
  
  @JsEvent({"notifyBLECharacteristicValueChange"})
  @TargetApi(18)
  private void notifyBLECharacteristicValueChange(RequestEvent paramRequestEvent)
  {
    label205:
    label338:
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      String str;
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject3 = ((JSONObject)localObject1).getString("deviceId");
        localObject2 = ((JSONObject)localObject1).getString("serviceId");
        str = ((JSONObject)localObject1).getString("characteristicId");
        bool = ((JSONObject)localObject1).getBoolean("state");
        localIterator = null;
        localObject1 = localIterator;
        if (this.mBluetoothAdapter != null)
        {
          localObject1 = localIterator;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = localIterator;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localIterator;
              if (!TextUtils.isEmpty(str))
              {
                localObject1 = localIterator;
                if (!TextUtils.isEmpty(str))
                {
                  localObject1 = findBluetoothDeviceExtend((String)localObject3);
                  if (localObject1 == null) {
                    break label338;
                  }
                  if (((BluetoothDeviceExtend)localObject1).services != null) {
                    break label205;
                  }
                  break label338;
                }
              }
            }
          }
        }
        throw new Exception("notifyBLECharacteristicValueChange fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject3 + ",serviceId=" + (String)localObject2 + ",characteristicId=" + str + ",deviceExtend=" + localObject1);
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        return;
      }
      Iterator localIterator = localException.services.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (BluetoothGattService)localIterator.next();
        if (((String)localObject2).equalsIgnoreCase(((BluetoothGattService)localObject3).getUuid().toString()))
        {
          localIterator = ((BluetoothGattService)localObject3).getCharacteristics().iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (BluetoothGattCharacteristic)localIterator.next();
          } while (!str.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString()));
        }
      }
      for (boolean bool = localException.notifyBLECharacteristicValueChange((BluetoothGattCharacteristic)localObject2, bool);; bool = false)
      {
        if (bool)
        {
          paramRequestEvent.ok();
          return;
        }
        throw new RuntimeException("notifyBLECharacteristicValueChange fail!");
      }
    }
  }
  
  private void notifyBluetoothStateChange()
  {
    QMLog.d("BluetoothJsPlugin", "notifyBluetoothStateChange");
    if (this.mBluetoothStateReceiver != null) {
      this.mBluetoothStateReceiver.onReceive(this.mActivity, new Intent("android.bluetooth.adapter.action.STATE_CHANGED"));
    }
  }
  
  private BluetoothDeviceExtend parseFromBytes(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramBluetoothDevice = new BluetoothDeviceExtend(paramBluetoothDevice, paramInt, paramArrayOfByte);
    paramInt = 0;
    try
    {
      if (paramInt >= paramArrayOfByte.length) {
        break label231;
      }
      j = paramInt + 1;
      paramInt = paramArrayOfByte[paramInt] & 0xFF;
      if (paramInt != 0) {
        break label233;
      }
    }
    catch (Exception paramBluetoothDevice)
    {
      QMLog.e("BluetoothJsPlugin", "unable to parse scan record:", paramBluetoothDevice);
      return null;
    }
    parseServiceUuid(paramArrayOfByte, i, paramInt, 16, paramBluetoothDevice.mServiceUuids);
    break label356;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 32, paramBluetoothDevice.mServiceUuids);
    break label356;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 128, paramBluetoothDevice.mServiceUuids);
    break label356;
    paramBluetoothDevice.localName = new String(extractBytes(paramArrayOfByte, i, paramInt));
    break label356;
    Object localObject = parseUuidFromByte(extractBytes(paramArrayOfByte, i, 16));
    byte[] arrayOfByte = extractBytes(paramArrayOfByte, i + 16, paramInt - 16);
    paramBluetoothDevice.serviceData.put(localObject, arrayOfByte);
    break label356;
    int j = paramArrayOfByte[(i + 1)];
    int k = paramArrayOfByte[i];
    localObject = extractBytes(paramArrayOfByte, i + 2, paramInt - 2);
    paramBluetoothDevice.manufacturerData.put(((j & 0xFF) << 8) + (k & 0xFF), localObject);
    break label356;
    label231:
    return paramBluetoothDevice;
    label233:
    paramInt -= 1;
    int i = j + 1;
    switch (paramArrayOfByte[j] & 0xFF)
    {
    }
    for (;;)
    {
      label356:
      paramInt += i;
      break;
      j = paramArrayOfByte[i];
      continue;
      j = paramArrayOfByte[i];
    }
  }
  
  private static int parseServiceUuid(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    while (paramInt2 > 0)
    {
      paramList.add(parseUuidFromByte(extractBytes(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    return paramInt1;
  }
  
  private static ParcelUuid parseUuidFromByte(byte[] paramArrayOfByte)
  {
    return new ParcelUuid(UUID.nameUUIDFromBytes(paramArrayOfByte));
  }
  
  private static ParcelUuid parseUuidFromStr(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramString.length())
        {
        case 4: 
          return ParcelUuid.fromString(paramString);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
      return ParcelUuid.fromString("0000" + paramString + "-0000-1000-8000-00805F9B34FB");
      paramString = ParcelUuid.fromString(paramString + "-0000-1000-8000-00805F9B34FB");
      return paramString;
    }
  }
  
  @JsEvent({"readBLECharacteristicValue"})
  @TargetApi(18)
  private void readBLECharacteristicValue(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      localObject1 = ((JSONObject)localObject2).getString("deviceId");
      String str = ((JSONObject)localObject2).getString("serviceId");
      localObject2 = ((JSONObject)localObject2).getString("characteristicId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break label146;
      }
      throw new Exception("readBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject1 + ",characteristicId=" + (String)localObject2 + ",deviceExtend=" + null);
    }
    catch (Exception localException)
    {
      i = 10008;
    }
    if (i == 0)
    {
      paramRequestEvent.ok(localJSONObject);
      return;
      label146:
      if (!this.isSupportBlueTooth) {
        i = 10009;
      }
    }
    for (;;)
    {
      localJSONObject.put("errCode", i);
      break;
      if (this.mBluetoothAdapter == null)
      {
        i = 10000;
      }
      else if (!this.mBluetoothAdapter.isEnabled())
      {
        i = 10001;
      }
      else
      {
        localObject1 = findBluetoothDeviceExtend((String)localObject1);
        if (localObject1 == null)
        {
          i = 10002;
        }
        else if (((BluetoothDeviceExtend)localObject1).services == null)
        {
          i = 10004;
        }
        else
        {
          Iterator localIterator = ((BluetoothDeviceExtend)localObject1).services.iterator();
          BluetoothGattCharacteristic localBluetoothGattCharacteristic;
          while (localIterator.hasNext())
          {
            BluetoothGattService localBluetoothGattService = (BluetoothGattService)localIterator.next();
            if (localException.equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
            {
              localIterator = localBluetoothGattService.getCharacteristics().iterator();
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)localIterator.next();
              } while (!((String)localObject2).equalsIgnoreCase(localBluetoothGattCharacteristic.getUuid().toString()));
            }
          }
          while (localBluetoothGattCharacteristic != null)
          {
            i = ((BluetoothDeviceExtend)localObject1).readCharacteristic(localBluetoothGattCharacteristic);
            break;
            paramRequestEvent.fail(localJSONObject, null);
            return;
            localBluetoothGattCharacteristic = null;
          }
          i = 10005;
        }
      }
    }
  }
  
  private void registerBluetoothStateReceiver()
  {
    QMLog.d("BluetoothJsPlugin", "registerBluetoothStateReceiver sIsReceiverRegister=" + this.sIsReceiverRegister);
    if (!this.sIsReceiverRegister)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      this.mActivity.registerReceiver(this.mBluetoothStateReceiver, localIntentFilter);
      this.sIsReceiverRegister = true;
    }
  }
  
  @JsEvent({"startBluetoothDevicesDiscovery"})
  private void startBluetoothDevicesDiscovery(RequestEvent paramRequestEvent)
  {
    long l1 = 500L;
    int i = 0;
    QMLog.d("BluetoothJsPlugin", "startBluetoothDevicesDiscovery jsonParams=" + paramRequestEvent.jsonParams + ",callbackId=" + paramRequestEvent.callbackId);
    if ((this.mBluetoothAdapter == null) || (this.bleScan.isDiscovering))
    {
      paramRequestEvent.fail();
      return;
    }
    for (;;)
    {
      long l2;
      try
      {
        Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("services");
        boolean bool = ((JSONObject)localObject2).optBoolean("allowDuplicatesKey", false);
        l2 = ((JSONObject)localObject2).optLong("interval", 0L);
        if (l2 >= 500L) {
          break label277;
        }
        localObject2 = new ArrayList();
        if ((localObject1 != null) && (i < ((JSONArray)localObject1).length()))
        {
          ParcelUuid localParcelUuid = parseUuidFromStr(((JSONArray)localObject1).optString(i));
          if (localParcelUuid == null) {
            break label283;
          }
          ((ArrayList)localObject2).add(localParcelUuid.getUuid());
          break label283;
        }
        if (this.bleScan.startDiscovery(this.mBluetoothAdapter, (UUID[])((ArrayList)localObject2).toArray(new UUID[0]), bool, l1))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("available", this.mBluetoothAdapter.isEnabled());
            ((JSONObject)localObject1).put("discovering", this.bleScan.isDiscovering);
            paramRequestEvent.ok((JSONObject)localObject1);
            return;
          }
          catch (JSONException localJSONException)
          {
            paramRequestEvent.fail();
            return;
          }
        }
        paramRequestEvent.fail();
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        return;
      }
      return;
      label277:
      l1 = l2;
      continue;
      label283:
      i += 1;
    }
  }
  
  @JsEvent({"stopBluetoothDevicesDiscovery"})
  private void stopBluetoothDevicesDiscovery(RequestEvent paramRequestEvent)
  {
    QMLog.d("BluetoothJsPlugin", "stopBluetoothDevicesDiscovery callbackId=" + paramRequestEvent.callbackId);
    if (this.mBluetoothAdapter == null)
    {
      paramRequestEvent.fail();
      return;
    }
    this.bleScan.stopDiscovery("stopBluetoothDevicesDiscovery");
    paramRequestEvent.ok();
  }
  
  private void unregisterBluetoothStateReceiver()
  {
    QMLog.d("BluetoothJsPlugin", "unregisterBluetoothStateReceiver");
    if ((this.sIsReceiverRegister) && (this.mBluetoothStateReceiver != null))
    {
      this.mActivity.unregisterReceiver(this.mBluetoothStateReceiver);
      this.sIsReceiverRegister = false;
    }
  }
  
  @JsEvent({"writeBLECharacteristicValue"})
  @TargetApi(18)
  private void writeBLECharacteristicValue(RequestEvent paramRequestEvent)
  {
    label206:
    label350:
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      String str1;
      String str2;
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject3 = ((JSONObject)localObject1).getString("deviceId");
        localObject2 = ((JSONObject)localObject1).getString("serviceId");
        str1 = ((JSONObject)localObject1).getString("characteristicId");
        str2 = ((JSONObject)localObject1).getString("value");
        localIterator = null;
        localObject1 = localIterator;
        if (this.mBluetoothAdapter != null)
        {
          localObject1 = localIterator;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = localIterator;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localIterator;
              if (!TextUtils.isEmpty(str1))
              {
                localObject1 = localIterator;
                if (!TextUtils.isEmpty(str1))
                {
                  localObject1 = findBluetoothDeviceExtend((String)localObject3);
                  if (localObject1 == null) {
                    break label350;
                  }
                  if (((BluetoothDeviceExtend)localObject1).services != null) {
                    break label206;
                  }
                  break label350;
                }
              }
            }
          }
        }
        throw new Exception("writeBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject3 + ",serviceId=" + (String)localObject2 + ",characteristicId=" + str1 + ",deviceExtend=" + localObject1);
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        return;
      }
      Iterator localIterator = localException.services.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (BluetoothGattService)localIterator.next();
        if (((String)localObject2).equalsIgnoreCase(((BluetoothGattService)localObject3).getUuid().toString()))
        {
          localIterator = ((BluetoothGattService)localObject3).getCharacteristics().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (BluetoothGattCharacteristic)localIterator.next();
            if (str1.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString())) {
              ((BluetoothGattCharacteristic)localObject2).setValue(Base64.decode(str2, 2));
            }
          }
        }
      }
      for (boolean bool = localException.writeCharacteristic((BluetoothGattCharacteristic)localObject2);; bool = false)
      {
        if (bool)
        {
          paramRequestEvent.ok();
          return;
        }
        throw new RuntimeException("writeBLECharacteristicValue fail!");
      }
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mActivity = paramIMiniAppContext.getAttachedActivity();
  }
  
  public void onDestroy()
  {
    try
    {
      closeAdapter();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @JsEvent({"openBluetoothAdapter"})
  public void openBluetoothAdapter(RequestEvent paramRequestEvent)
  {
    if (this.mActivity == null)
    {
      QMLog.d("BluetoothJsPlugin", "Failed to openBluetoothAdapter. Activity is null. callbackId=" + paramRequestEvent.callbackId);
      return;
    }
    QMLog.d("BluetoothJsPlugin", "openBluetoothAdapter callbackId=" + paramRequestEvent.callbackId);
    this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((!this.mActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) || (this.mBluetoothAdapter == null) || (this.isSettingBlueTooth))
    {
      paramRequestEvent.fail();
      return;
    }
    registerBluetoothStateReceiver();
    if (this.mBluetoothAdapter.isEnabled())
    {
      paramRequestEvent.ok();
      return;
    }
    this.isSettingBlueTooth = true;
    ActivityResultManager.g().addActivityResultListener(new BluetoothJsPlugin.2(this, paramRequestEvent));
    paramRequestEvent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
    this.mActivity.startActivityForResult(paramRequestEvent, 6);
  }
  
  @TargetApi(18)
  class BLEScan
    implements BluetoothAdapter.LeScanCallback
  {
    private List<BluetoothJsPlugin.BluetoothDeviceExtend> foundDevices = new LinkedList();
    private boolean hasNewDevice;
    private boolean isDiscovering;
    private boolean mAllowDuplicatesKey;
    private long mInterval;
    
    BLEScan() {}
    
    public void onBluetoothDeviceFound()
    {
      QMLog.d("BluetoothJsPlugin", "BLEScan.onBluetoothDeviceFound foundDevices size =" + this.foundDevices.size());
      JSONArray localJSONArray;
      if (this.hasNewDevice)
      {
        this.hasNewDevice = false;
        try
        {
          if (this.foundDevices.size() > 0)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONArray = new JSONArray();
            synchronized (this.foundDevices)
            {
              Iterator localIterator = this.foundDevices.iterator();
              if (!localIterator.hasNext()) {
                break label128;
              }
              localJSONArray.put(((BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next()).toJson());
            }
          }
          return;
        }
        catch (JSONException localJSONException) {}
      }
      label128:
      localObject.put("devices", localJSONArray);
      String str = localObject.toString();
      QMLog.d("BluetoothJsPlugin", "BLEScan.onBluetoothDeviceFound callback data =" + str);
      BluetoothJsPlugin.this.sendSubscribeEvent("onBluetoothDeviceFound", str);
    }
    
    public void onLeScan(BluetoothDevice arg1, int paramInt, byte[] paramArrayOfByte)
    {
      QMLog.d("BluetoothJsPlugin", "BLEScan.onLeScan device =" + ??? + ",rssi=" + paramInt + ",scanRecord=" + paramArrayOfByte);
      if ((??? == null) || (paramArrayOfByte == null) || (!this.isDiscovering)) {}
      for (;;)
      {
        return;
        paramArrayOfByte = BluetoothJsPlugin.this.parseFromBytes(???, paramInt, paramArrayOfByte);
        if (paramArrayOfByte == null) {
          continue;
        }
        synchronized (this.foundDevices)
        {
          if (!this.foundDevices.contains(paramArrayOfByte))
          {
            this.foundDevices.add(paramArrayOfByte);
            this.hasNewDevice = true;
          }
          while (!this.mAllowDuplicatesKey)
          {
            if (!this.hasNewDevice) {
              break;
            }
            synchronized (BluetoothJsPlugin.this.allFoundDevices)
            {
              if (!BluetoothJsPlugin.this.allFoundDevices.containsKey(paramArrayOfByte.mDevicesId)) {
                BluetoothJsPlugin.this.allFoundDevices.put(paramArrayOfByte.mDevicesId, paramArrayOfByte);
              }
              return;
            }
          }
          Iterator localIterator = this.foundDevices.iterator();
          while (localIterator.hasNext())
          {
            BluetoothJsPlugin.BluetoothDeviceExtend localBluetoothDeviceExtend = (BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next();
            if (localBluetoothDeviceExtend.mDevicesId.equalsIgnoreCase(???.getAddress())) {
              localBluetoothDeviceExtend.mRssi = paramInt;
            }
          }
          this.hasNewDevice = true;
        }
      }
    }
    
    public boolean startDiscovery(BluetoothAdapter paramBluetoothAdapter, UUID[] paramArrayOfUUID, boolean paramBoolean, long paramLong)
    {
      QMLog.d("BluetoothJsPlugin", "BLEScan.startDiscovery serviceUUID=" + paramArrayOfUUID + ",allowDuplicatesKey=" + paramBoolean + ",timeout=" + paramLong);
      boolean bool;
      if ((this.isDiscovering) || (paramBluetoothAdapter == null))
      {
        bool = false;
        return bool;
      }
      BluetoothJsPlugin.this.subHandler.removeMessages(2);
      BluetoothJsPlugin.this.subHandler.removeMessages(1);
      for (;;)
      {
        synchronized (this.foundDevices)
        {
          this.foundDevices.clear();
          this.mAllowDuplicatesKey = paramBoolean;
          this.mInterval = paramLong;
          if ((paramArrayOfUUID != null) && (paramArrayOfUUID.length > 0))
          {
            paramBoolean = paramBluetoothAdapter.startLeScan(paramArrayOfUUID, this);
            bool = paramBoolean;
            if (!paramBoolean) {
              break;
            }
            this.isDiscovering = true;
            BluetoothJsPlugin.this.notifyBluetoothStateChange();
            BluetoothJsPlugin.this.subHandler.sendEmptyMessageDelayed(1, 15000L);
            BluetoothJsPlugin.this.subHandler.sendEmptyMessageDelayed(2, this.mInterval);
            return paramBoolean;
          }
        }
        paramBoolean = paramBluetoothAdapter.startLeScan(this);
      }
    }
    
    public void stopDiscovery(String arg1)
    {
      QMLog.d("BluetoothJsPlugin", "BLEScan.stopDiscovery......from=" + ???);
      BluetoothJsPlugin.this.subHandler.removeMessages(1);
      BluetoothJsPlugin.this.subHandler.removeMessages(2);
      if (BluetoothJsPlugin.this.mBluetoothAdapter != null) {
        BluetoothJsPlugin.this.mBluetoothAdapter.stopLeScan(this);
      }
      synchronized (this.foundDevices)
      {
        this.foundDevices.clear();
        this.isDiscovering = false;
        BluetoothJsPlugin.this.notifyBluetoothStateChange();
        return;
      }
    }
  }
  
  @TargetApi(18)
  class BluetoothDeviceExtend
    extends BluetoothGattCallback
  {
    List<Integer> blueToothConnListeners = new ArrayList();
    Map<Integer, RequestEvent> blueToothServiceListeners = new HashMap();
    Runnable connTimeoutJob;
    BluetoothGatt gatt;
    long lastConnectionTime;
    String localName = "";
    BluetoothDevice mBluetoothDevice;
    String mDevicesId;
    int mRssi;
    byte[] mScanRecord;
    List<ParcelUuid> mServiceUuids = new ArrayList();
    SparseArray<byte[]> manufacturerData = new SparseArray();
    String name;
    Map<ParcelUuid, byte[]> serviceData = new HashMap();
    List<BluetoothGattService> services = null;
    int state = 0;
    
    BluetoothDeviceExtend(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
    {
      this.mBluetoothDevice = paramBluetoothDevice;
      this.mRssi = paramInt;
      this.mScanRecord = paramArrayOfByte;
      this.mDevicesId = this.mBluetoothDevice.getAddress();
      if (this.mDevicesId == null) {
        this.mDevicesId = "";
      }
      this.name = this.mBluetoothDevice.getName();
      this.connTimeoutJob = new BluetoothJsPlugin.BluetoothDeviceExtend.1(this, BluetoothJsPlugin.this);
    }
    
    public void connectGatt(Context paramContext, boolean paramBoolean, long paramLong, int paramInt)
      throws Exception
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.connectGatt autoConnect=" + paramBoolean + ",timeout=" + paramLong + ",callbackId=" + paramInt);
      if (!this.blueToothConnListeners.contains(Integer.valueOf(paramInt))) {
        this.blueToothConnListeners.add(Integer.valueOf(paramInt));
      }
      if ((this.state == 2) && (this.gatt != null)) {
        onConnectionStateChange(this.gatt, 0, this.state);
      }
      do
      {
        return;
        if (this.gatt != null) {
          this.gatt.close();
        }
        this.gatt = this.mBluetoothDevice.connectGatt(paramContext, paramBoolean, this);
        if (this.gatt == null) {
          throw new RuntimeException("connectGatt is null");
        }
        BluetoothJsPlugin.this.subHandler.removeCallbacks(this.connTimeoutJob);
      } while (paramLong <= 0L);
      BluetoothJsPlugin.this.subHandler.postDelayed(this.connTimeoutJob, paramLong);
    }
    
    public boolean containsUUID(List<ParcelUuid> paramList)
    {
      if ((this.mServiceUuids == null) || (this.mServiceUuids.size() < 1) || (paramList == null) || (paramList.size() < 1)) {
        return false;
      }
      return this.mServiceUuids.containsAll(paramList);
    }
    
    public void destory()
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.destory,,,,,,");
      disconnectGatt();
      synchronized (this.blueToothServiceListeners)
      {
        this.blueToothServiceListeners.clear();
        return;
      }
    }
    
    public boolean disconnectGatt()
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.disconnectGatt,,,,,,");
      this.state = 0;
      BluetoothJsPlugin.this.subHandler.removeCallbacks(this.connTimeoutJob);
      if (this.gatt == null) {
        return false;
      }
      this.gatt.disconnect();
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof BluetoothDeviceExtend))
      {
        paramObject = (BluetoothDeviceExtend)paramObject;
        if ((paramObject.mDevicesId != null) && (paramObject.mDevicesId.equals(this.mDevicesId))) {
          return true;
        }
      }
      return false;
    }
    
    public String getDeviceName()
    {
      if (!TextUtils.isEmpty(this.name)) {
        return this.name;
      }
      if (!TextUtils.isEmpty(this.localName)) {
        return this.localName;
      }
      return "";
    }
    
    public void getServices(RequestEvent paramRequestEvent)
      throws Exception
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.getServices callbackId=" + paramRequestEvent.callbackId);
      if (this.gatt == null) {
        throw new RuntimeException("getService exception, state=" + this.state + ",gatt=" + this.gatt);
      }
      if (!this.blueToothServiceListeners.containsKey(Integer.valueOf(paramRequestEvent.callbackId))) {
        this.blueToothServiceListeners.put(Integer.valueOf(paramRequestEvent.callbackId), paramRequestEvent);
      }
      if (this.services != null) {
        onServicesDiscovered(this.gatt, 0);
      }
      do
      {
        return;
        if (this.lastConnectionTime + 600L > System.currentTimeMillis())
        {
          BluetoothJsPlugin.this.subHandler.postDelayed(new BluetoothJsPlugin.BluetoothDeviceExtend.2(this, paramRequestEvent), 600L);
          return;
        }
      } while (this.gatt.discoverServices());
      paramRequestEvent.fail();
    }
    
    public boolean notifyBLECharacteristicValueChange(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
    {
      int j = 1;
      boolean bool2 = false;
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.notifyBLECharacteristicValueChange c=" + paramBluetoothGattCharacteristic + ",state=" + paramBoolean);
      boolean bool1 = bool2;
      if (this.gatt != null)
      {
        if (paramBluetoothGattCharacteristic == null) {
          bool1 = bool2;
        }
      }
      else {
        return bool1;
      }
      int k = paramBluetoothGattCharacteristic.getProperties();
      int i;
      if ((k & 0x10) > 0)
      {
        i = 1;
        label79:
        if ((k & 0x20) <= 0) {
          break label169;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          bool1 = bool2;
          if (j == 0) {
            break;
          }
        }
        paramBoolean = this.gatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(UUID.fromString("2902"));
        bool1 = paramBoolean;
        if (paramBluetoothGattCharacteristic == null) {
          break;
        }
        if (i != 0) {
          paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        }
        if (j != 0) {
          paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        }
        this.gatt.writeDescriptor(paramBluetoothGattCharacteristic);
        return paramBoolean;
        i = 0;
        break label79;
        label169:
        j = 0;
      }
    }
    
    public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
    {
      try
      {
        paramBluetoothGatt = paramBluetoothGattCharacteristic.getService();
        if (paramBluetoothGatt == null) {
          return;
        }
        paramBluetoothGatt = paramBluetoothGatt.getUuid().toString();
        String str = paramBluetoothGattCharacteristic.getUuid().toString();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("deviceId", this.mDevicesId);
        localJSONObject.put("serviceId", paramBluetoothGatt);
        localJSONObject.put("characteristicId", str);
        localJSONObject.put("value", Base64.encodeToString(paramBluetoothGattCharacteristic.getValue(), 2));
        BluetoothJsPlugin.this.sendSubscribeEvent("onBLECharacteristicValueChange", localJSONObject.toString());
        return;
      }
      catch (JSONException paramBluetoothGatt) {}
    }
    
    public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.onCharacteristicRead gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
    }
    
    public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.onCharacteristicWrite gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
    }
    
    /* Error */
    public void onConnectionStateChange(BluetoothGatt arg1, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: ldc 111
      //   2: new 113	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 114	java/lang/StringBuilder:<init>	()V
      //   9: ldc_w 383
      //   12: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: aload_0
      //   16: getfield 159	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
      //   19: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   22: ldc_w 378
      //   25: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: iload_2
      //   29: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   32: ldc_w 385
      //   35: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   38: iload_3
      //   39: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   42: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: invokestatic 142	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   48: aload_0
      //   49: getfield 48	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;
      //   52: invokestatic 182	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin:access$500	(Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;)Landroid/os/Handler;
      //   55: aload_0
      //   56: getfield 104	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:connTimeoutJob	Ljava/lang/Runnable;
      //   59: invokevirtual 188	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
      //   62: aload_0
      //   63: iload_3
      //   64: putfield 53	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
      //   67: aload_0
      //   68: getfield 53	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
      //   71: iconst_2
      //   72: if_icmpne +184 -> 256
      //   75: aload_0
      //   76: invokestatic 271	java/lang/System:currentTimeMillis	()J
      //   79: putfield 263	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:lastConnectionTime	J
      //   82: aload_0
      //   83: getfield 48	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;
      //   86: invokestatic 389	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
      //   89: astore_1
      //   90: aload_1
      //   91: monitorenter
      //   92: aload_0
      //   93: getfield 48	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;
      //   96: invokestatic 389	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
      //   99: aload_0
      //   100: getfield 92	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
      //   103: invokevirtual 390	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
      //   106: ifne +19 -> 125
      //   109: aload_0
      //   110: getfield 48	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;
      //   113: invokestatic 389	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
      //   116: aload_0
      //   117: getfield 92	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
      //   120: aload_0
      //   121: invokevirtual 391	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   124: pop
      //   125: aload_1
      //   126: monitorexit
      //   127: iconst_1
      //   128: istore 4
      //   130: aload_0
      //   131: getfield 76	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
      //   134: astore_1
      //   135: aload_1
      //   136: monitorenter
      //   137: aload_0
      //   138: getfield 76	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
      //   141: invokeinterface 395 1 0
      //   146: astore 5
      //   148: aload 5
      //   150: invokeinterface 400 1 0
      //   155: ifeq +134 -> 289
      //   158: aload 5
      //   160: invokeinterface 404 1 0
      //   165: checkcast 144	java/lang/Integer
      //   168: invokevirtual 407	java/lang/Integer:intValue	()I
      //   171: istore_2
      //   172: ldc 111
      //   174: new 113	java/lang/StringBuilder
      //   177: dup
      //   178: invokespecial 114	java/lang/StringBuilder:<init>	()V
      //   181: ldc_w 409
      //   184: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: iload 4
      //   189: invokevirtual 123	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   192: ldc_w 411
      //   195: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: iload_2
      //   199: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   202: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   205: invokestatic 142	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   208: aload_0
      //   209: getfield 78	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothServiceListeners	Ljava/util/Map;
      //   212: iload_2
      //   213: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   216: invokeinterface 415 2 0
      //   221: checkcast 240	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent
      //   224: astore 6
      //   226: iload 4
      //   228: ifeq +52 -> 280
      //   231: aload 6
      //   233: invokevirtual 418	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
      //   236: pop
      //   237: goto -89 -> 148
      //   240: astore 5
      //   242: aload_1
      //   243: monitorexit
      //   244: aload 5
      //   246: athrow
      //   247: astore_1
      //   248: return
      //   249: astore 5
      //   251: aload_1
      //   252: monitorexit
      //   253: aload 5
      //   255: athrow
      //   256: iload_3
      //   257: ifne +17 -> 274
      //   260: aload_0
      //   261: getfield 159	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
      //   264: ifnull +10 -> 274
      //   267: aload_0
      //   268: getfield 159	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
      //   271: invokevirtual 168	android/bluetooth/BluetoothGatt:close	()V
      //   274: iconst_0
      //   275: istore 4
      //   277: goto -147 -> 130
      //   280: aload 6
      //   282: invokevirtual 282	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
      //   285: pop
      //   286: goto -138 -> 148
      //   289: aload_0
      //   290: getfield 76	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
      //   293: invokeinterface 419 1 0
      //   298: aload_1
      //   299: monitorexit
      //   300: new 342	org/json/JSONObject
      //   303: dup
      //   304: invokespecial 343	org/json/JSONObject:<init>	()V
      //   307: astore_1
      //   308: aload_1
      //   309: ldc_w 345
      //   312: aload_0
      //   313: getfield 92	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
      //   316: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   319: pop
      //   320: aload_1
      //   321: ldc_w 421
      //   324: iload 4
      //   326: invokevirtual 424	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
      //   329: pop
      //   330: aload_0
      //   331: getfield 48	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;
      //   334: ldc_w 426
      //   337: aload_1
      //   338: invokevirtual 366	org/json/JSONObject:toString	()Ljava/lang/String;
      //   341: invokestatic 429	com/tencent/qqmini/sdk/plugins/BluetoothJsPlugin:access$1000	(Lcom/tencent/qqmini/sdk/plugins/BluetoothJsPlugin;Ljava/lang/String;Ljava/lang/String;)V
      //   344: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	345	0	this	BluetoothDeviceExtend
      //   0	345	2	paramInt1	int
      //   0	345	3	paramInt2	int
      //   128	197	4	bool	boolean
      //   146	13	5	localIterator	Iterator
      //   240	5	5	localObject1	Object
      //   249	5	5	localObject2	Object
      //   224	57	6	localRequestEvent	RequestEvent
      // Exception table:
      //   from	to	target	type
      //   137	148	240	finally
      //   148	226	240	finally
      //   231	237	240	finally
      //   242	244	240	finally
      //   280	286	240	finally
      //   289	300	240	finally
      //   48	92	247	org/json/JSONException
      //   130	137	247	org/json/JSONException
      //   244	247	247	org/json/JSONException
      //   253	256	247	org/json/JSONException
      //   260	274	247	org/json/JSONException
      //   300	344	247	org/json/JSONException
      //   92	125	249	finally
      //   125	127	249	finally
      //   251	253	249	finally
    }
    
    public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.onServicesDiscovered gatt=" + paramBluetoothGatt + ",status=" + paramInt);
      Object localObject1 = null;
      Object localObject2;
      boolean bool;
      if (paramInt == 0)
      {
        this.services = paramBluetoothGatt.getServices();
        try
        {
          localObject1 = new JSONArray();
          if (this.services.size() > 0)
          {
            paramBluetoothGatt = this.services.iterator();
            for (;;)
            {
              if (paramBluetoothGatt.hasNext())
              {
                localObject2 = (BluetoothGattService)paramBluetoothGatt.next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("uuid", ((BluetoothGattService)localObject2).getUuid().toString());
                if (((BluetoothGattService)localObject2).getType() == 0)
                {
                  bool = true;
                  localJSONObject.put("isPrimary", bool);
                  ((JSONArray)localObject1).put(localJSONObject);
                  continue;
                  localObject1 = paramBluetoothGatt;
                }
              }
            }
          }
        }
        catch (JSONException paramBluetoothGatt)
        {
          paramBluetoothGatt = null;
        }
      }
      for (;;)
      {
        paramBluetoothGatt = this.blueToothServiceListeners.keySet().iterator();
        for (;;)
        {
          for (;;)
          {
            if (!paramBluetoothGatt.hasNext()) {
              break label273;
            }
            paramInt = ((Integer)paramBluetoothGatt.next()).intValue();
            localObject2 = (RequestEvent)this.blueToothServiceListeners.get(Integer.valueOf(paramInt));
            if (localObject1 != null)
            {
              ((RequestEvent)localObject2).ok((JSONObject)localObject1);
              continue;
              bool = false;
              break;
              paramBluetoothGatt = new JSONObject();
            }
            try
            {
              paramBluetoothGatt.put("services", localObject1);
              localObject1 = paramBluetoothGatt;
            }
            catch (JSONException localJSONException) {}
          }
          ((RequestEvent)localObject2).fail();
        }
        label273:
        return;
      }
    }
    
    public int readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
      throws Exception
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.readCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
      if (paramBluetoothGattCharacteristic == null) {
        throw new RuntimeException("readCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
      }
      if ((this.gatt == null) || (this.state != 2)) {
        return 10006;
      }
      if ((paramBluetoothGattCharacteristic.getProperties() & 0x2) < 1) {
        return 10007;
      }
      if (this.gatt.readCharacteristic(paramBluetoothGattCharacteristic)) {
        return 0;
      }
      return 10008;
    }
    
    public JSONObject toJson()
    {
      Object localObject3;
      Object localObject4;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("name", getDeviceName());
        localJSONObject.putOpt("localName", getDeviceName());
        localJSONObject.put("deviceId", this.mDevicesId);
        localJSONObject.put("RSSI", this.mRssi);
        ??? = new StringBuilder();
        if ((this.manufacturerData != null) && (this.manufacturerData.size() > 0))
        {
          int i = 0;
          while (i < this.manufacturerData.size())
          {
            ((StringBuilder)???).append(Base64.encodeToString((byte[])this.manufacturerData.valueAt(i), 2));
            i += 1;
          }
        }
        localJSONObject.put("advertisData", ???);
        localObject3 = new JSONArray();
        if ((this.mServiceUuids != null) && (this.mServiceUuids.size() > 0)) {
          synchronized (this.mServiceUuids)
          {
            localObject4 = this.mServiceUuids.iterator();
            if (((Iterator)localObject4).hasNext()) {
              ((JSONArray)localObject3).put(((ParcelUuid)((Iterator)localObject4).next()).toString().toUpperCase());
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        return null;
      }
      localJSONException.put("advertisServiceUUIDs", localObject3);
      ??? = new JSONObject();
      if ((this.serviceData != null) && (this.serviceData.size() > 0))
      {
        localObject3 = this.serviceData.entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          ((JSONObject)???).put(((ParcelUuid)((Map.Entry)localObject4).getKey()).getUuid().toString().toUpperCase(), Base64.encodeToString((byte[])((Map.Entry)localObject4).getValue(), 2));
        }
      }
      localJSONException.put("serviceData", ???);
      return localJSONException;
    }
    
    public boolean writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
      throws Exception
    {
      QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.writeCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
      if ((this.gatt == null) || (paramBluetoothGattCharacteristic == null)) {
        throw new RuntimeException("writeCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
      }
      if ((paramBluetoothGattCharacteristic.getProperties() & 0x8) > 0) {
        return this.gatt.writeCharacteristic(paramBluetoothGattCharacteristic);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BluetoothJsPlugin
 * JD-Core Version:    0.7.0.1
 */