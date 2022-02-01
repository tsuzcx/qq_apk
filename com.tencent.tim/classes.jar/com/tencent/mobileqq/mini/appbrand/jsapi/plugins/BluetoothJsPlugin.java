package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

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
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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

public class BluetoothJsPlugin
  extends BaseJsPlugin
  implements Handler.Callback
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
  private static final String EVENT_CLOSE_BLE_CONNECTION = "closeBLEConnection";
  private static final String EVENT_CLOSE_BLUETOOTH_ADAPTER = "closeBluetoothAdapter";
  private static final String EVENT_CREATE_BLE_CONNECTION = "createBLEConnection";
  private static final String EVENT_GET_BLE_DEVICE_CHARACTERISTICS = "getBLEDeviceCharacteristics";
  private static final String EVENT_GET_BLE_DEVICE_SERVICES = "getBLEDeviceServices";
  private static final String EVENT_GET_BLUETOOTH_ADAPTER_STATE = "getBluetoothAdapterState";
  private static final String EVENT_GET_BLUETOOTH_DEVICES = "getBluetoothDevices";
  private static final String EVENT_GET_CONNECCTED_BLUETOOTH_DEVICES = "getConnectedBluetoothDevices";
  private static final String EVENT_NOTIFY_BLE_CHARACTERISTICS_VALUE_CHANGE = "notifyBLECharacteristicValueChange";
  private static final String EVENT_OPEN_BLUETOOTH_ADAPTER = "openBluetoothAdapter";
  private static final String EVENT_READ_BLE_CHARACTERISTICS_VALUE = "readBLECharacteristicValue";
  private static final String EVENT_START_BLUETOOTH_DEVICES_DISCOVERY = "startBluetoothDevicesDiscovery";
  private static final String EVENT_STOP_BLUETOOTH_DEVICES_DISCOVERY = "stopBluetoothDevicesDiscovery";
  private static final String EVENT_WRITE_BLE_CHARACTERISTICS_VALUE = "writeBLECharacteristicValue";
  private static final long FOUND_DEVICES_DEFAULT_INTERVAL = 500L;
  private static final long SCAN_MAX_TIME = 15000L;
  public static final String TAG = "[mini] BluetoothJsPlugin";
  private static final int UUID_BYTES_128_BIT = 128;
  private static final int UUID_BYTES_16_BIT = 16;
  private static final int UUID_BYTES_32_BIT = 32;
  private static final int WHAT_SCAN_CALLBACK = 2;
  private static final int WHAT_SCAN_TIMEOUT = 1;
  private HashMap<String, BluetoothDeviceExtend> allFoundDevices = new HashMap();
  private BLEScan bleScan = new BLEScan();
  private final Set<String> eventMap = new HashSet();
  private boolean isSettingBlueTooth;
  private boolean isSupportBlueTooth;
  private Activity mActivity;
  private BluetoothAdapter mBluetoothAdapter;
  BroadcastReceiver mBluetoothStateReceiver = new BluetoothJsPlugin.2(this);
  private boolean sIsReceiverRegister;
  private Handler subHandler;
  
  public BluetoothJsPlugin()
  {
    this.eventMap.add("openBluetoothAdapter");
    this.eventMap.add("closeBluetoothAdapter");
    this.eventMap.add("getBluetoothAdapterState");
    this.eventMap.add("startBluetoothDevicesDiscovery");
    this.eventMap.add("stopBluetoothDevicesDiscovery");
    this.eventMap.add("getBluetoothDevices");
    this.eventMap.add("getConnectedBluetoothDevices");
    this.eventMap.add("createBLEConnection");
    this.eventMap.add("closeBLEConnection");
    this.eventMap.add("getBLEDeviceServices");
    this.eventMap.add("getBLEDeviceCharacteristics");
    this.eventMap.add("readBLECharacteristicValue");
    this.eventMap.add("writeBLECharacteristicValue");
    this.eventMap.add("notifyBLECharacteristicValueChange");
    HandlerThread localHandlerThread = new HandlerThread("HandlerThread");
    localHandlerThread.start();
    this.subHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private void closeAdapter()
    throws Exception
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "closeAdapter......");
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
      throw new MiniAppException("closeAdapter fail, mBluetoothAdapter.disable fail");
    }
    unregisterBluetoothStateReceiver();
    this.mBluetoothStateReceiver = null;
    this.mBluetoothAdapter = null;
    this.isSettingBlueTooth = false;
  }
  
  @TargetApi(18)
  private void closeBLEConnection(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString2 = new JSONObject(paramString2).getString("deviceId");
      if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(paramString2))) {
        throw new Exception("closeBLEConnection fail, mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + paramString2);
      }
    }
    catch (Exception paramString2)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      return;
    }
    paramString2 = findBluetoothDeviceExtend(paramString2);
    boolean bool = false;
    if (paramString2 != null)
    {
      bool = paramString2.disconnectGatt();
      if (bool) {}
    }
    else
    {
      throw new Exception("closeBLEConnection fail! deviceExtend=" + paramString2 + ",disconnect=" + bool);
    }
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
  }
  
  @TargetApi(18)
  private void closeBluetoothAdapter(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "closeBluetoothAdapter callbackId=" + paramInt);
    try
    {
      closeAdapter();
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
    }
  }
  
  @TargetApi(18)
  private void createBLEConnection(String paramString1, String paramString2, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "createBLEConnection jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    for (;;)
    {
      long l;
      try
      {
        paramString2 = new JSONObject(paramString2);
        String str = paramString2.getString("deviceId");
        l = paramString2.optLong("timeout", 0L);
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(str))) {
          break label174;
        }
        paramString2 = findBluetoothDeviceExtend(str);
        if (paramString2 == null) {
          throw new Exception("createBLEConnection fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + paramString2);
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      paramString2.connectGatt(this.mActivity, false, l, paramInt);
      return;
      label174:
      paramString2 = null;
    }
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
  
  @TargetApi(18)
  private void getBLEDeviceCharacteristics(String paramString1, String paramString2, int paramInt)
  {
    Object localObject3;
    try
    {
      paramString2 = new JSONObject(paramString2);
      localObject2 = paramString2.getString("deviceId");
      localObject3 = paramString2.getString("serviceId");
      if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label449;
      }
      localObject1 = findBluetoothDeviceExtend((String)localObject2);
      paramString2 = (String)localObject1;
      if (localObject1 != null)
      {
        if (((BluetoothDeviceExtend)localObject1).services == null) {
          paramString2 = (String)localObject1;
        }
      }
      else {
        throw new Exception("getBLEDeviceCharacteristics fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject2 + ",deviceExtend=" + paramString2);
      }
    }
    catch (Exception paramString2)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      return;
    }
    paramString2 = new JSONArray();
    Object localObject2 = new JSONObject();
    Object localObject1 = ((BluetoothDeviceExtend)localObject1).services.iterator();
    Object localObject4;
    label219:
    JSONObject localJSONObject;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (BluetoothGattService)((Iterator)localObject1).next();
      if (((String)localObject3).equalsIgnoreCase(((BluetoothGattService)localObject4).getUuid().toString()))
      {
        localObject1 = ((BluetoothGattService)localObject4).getCharacteristics().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (BluetoothGattCharacteristic)((Iterator)localObject1).next();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("uuid", ((BluetoothGattCharacteristic)localObject3).getUuid().toString());
          localJSONObject = new JSONObject();
          int i = ((BluetoothGattCharacteristic)localObject3).getProperties();
          if ((i & 0x2) <= 0) {
            break label454;
          }
          bool = true;
          label293:
          localJSONObject.put("read", bool);
          if ((i & 0x8) <= 0) {
            break label460;
          }
          bool = true;
          label315:
          localJSONObject.put("write", bool);
          if ((i & 0x10) <= 0) {
            break label466;
          }
          bool = true;
          label337:
          localJSONObject.put("notify", bool);
          if ((i & 0x20) <= 0) {
            break label472;
          }
        }
      }
    }
    label449:
    label454:
    label460:
    label466:
    label472:
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("indicate", bool);
      ((JSONObject)localObject4).put("properties", localJSONObject);
      paramString2.put(localObject4);
      break label219;
      QLog.d("[mini] BluetoothJsPlugin", 2, "getBLEDeviceCharacteristics characteristics=" + paramString2.toString());
      ((JSONObject)localObject2).put("characteristics", paramString2);
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, (JSONObject)localObject2, paramInt);
      return;
      paramString2 = null;
      break;
      bool = false;
      break label293;
      bool = false;
      break label315;
      bool = false;
      break label337;
    }
  }
  
  @TargetApi(18)
  private void getBLEDeviceServices(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString2).getString("deviceId");
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(str))) {
          break label119;
        }
        paramString2 = findBluetoothDeviceExtend(str);
        if (paramString2 == null) {
          throw new Exception("getBLEDeviceServices fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + paramString2);
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      paramString2.getServices(paramInt);
      return;
      label119:
      paramString2 = null;
    }
  }
  
  private void getBluetoothAdapterState(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "getBluetoothAdapterState callbackId=" + paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.mBluetoothAdapter == null) {
        throw new MiniAppException("getBluetoothAdapterState fail, mBluetoothAdapter is null");
      }
    }
    catch (Exception localException)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    localException.put("available", this.mBluetoothAdapter.isEnabled());
    localException.put("discovering", this.bleScan.isDiscovering);
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, localException, paramInt);
  }
  
  private void getBluetoothDevices(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "getBluetoothDevices callbackId=" + paramInt);
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
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    localJSONObject2.put("devices", localJSONArray);
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, localJSONObject2, paramInt);
  }
  
  @TargetApi(18)
  private void getConnectedBluetoothDevices(String paramString1, String paramString2, int paramInt)
  {
    int j = 0;
    QLog.d("[mini] BluetoothJsPlugin", 2, "getConnectedBluetoothDevices jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString2).optJSONArray("services");
        paramString2 = new JSONArray();
        if (localObject2 != null)
        {
          i = ((JSONArray)localObject2).length();
          if (i >= 1) {
            break;
          }
          throw new MiniAppException("params services is empty!");
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
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
            paramString2.put(localJSONObject);
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("devices", paramString2);
        this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, (JSONObject)localObject1, paramInt);
        return;
      }
      j += 1;
    }
  }
  
  @TargetApi(18)
  private void notifyBLECharacteristicValueChange(String paramString1, String paramString2, int paramInt)
  {
    label198:
    label347:
    label352:
    for (;;)
    {
      Object localObject1;
      String str;
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject2 = paramString2.getString("deviceId");
        localObject1 = paramString2.getString("serviceId");
        str = paramString2.getString("characteristicId");
        bool = paramString2.getBoolean("state");
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str))) {
          break label347;
        }
        paramString2 = findBluetoothDeviceExtend((String)localObject2);
        if (paramString2 == null) {
          break label352;
        }
        if (paramString2.services != null) {
          break label198;
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      throw new Exception("notifyBLECharacteristicValueChange fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject2 + ",serviceId=" + (String)localObject1 + ",characteristicId=" + str + ",deviceExtend=" + paramString2);
      Object localObject2 = paramString2.services.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        if (((String)localObject1).equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
        {
          localObject1 = localBluetoothGattService.getCharacteristics().iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (BluetoothGattCharacteristic)((Iterator)localObject1).next();
          } while (!str.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString()));
        }
      }
      for (boolean bool = paramString2.notifyBLECharacteristicValueChange((BluetoothGattCharacteristic)localObject2, bool);; bool = false)
      {
        if (bool)
        {
          this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
          return;
        }
        throw new MiniAppException("notifyBLECharacteristicValueChange fail!");
      }
      paramString2 = null;
    }
  }
  
  private void notifyBluetoothStateChange()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "notifyBluetoothStateChange");
    if (this.mBluetoothStateReceiver != null) {
      this.mBluetoothStateReceiver.onReceive(this.mActivity, new Intent("android.bluetooth.adapter.action.STATE_CHANGED"));
    }
  }
  
  private void openBluetoothAdapter(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "openBluetoothAdapter callbackId=" + paramInt);
    this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((!this.mActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) || (this.mBluetoothAdapter == null) || (this.isSettingBlueTooth))
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    registerBluetoothStateReceiver();
    if (this.mBluetoothAdapter.isEnabled())
    {
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    this.isSettingBlueTooth = true;
    MiniAppController.getInstance().setActivityResultListener(new BluetoothJsPlugin.1(this, paramString, paramInt));
    paramString = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
    this.mActivity.startActivityForResult(paramString, 6);
  }
  
  private BluetoothDeviceExtend parseFromBytes(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramBluetoothDevice = new BluetoothDeviceExtend(paramBluetoothDevice, paramInt, paramArrayOfByte);
      paramInt = 0;
      try
      {
        if (paramInt >= paramArrayOfByte.length) {
          break;
        }
        j = paramInt + 1;
        paramInt = paramArrayOfByte[paramInt] & 0xFF;
        if (paramInt != 0) {
          break label240;
        }
      }
      catch (Exception paramBluetoothDevice) {}
      parseServiceUuid(paramArrayOfByte, i, paramInt, 16, paramBluetoothDevice.mServiceUuids);
      break label364;
    } while (!QLog.isColorLevel());
    QLog.e("[mini] BluetoothJsPlugin", 4, "unable to parse scan record:", paramBluetoothDevice);
    return null;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 32, paramBluetoothDevice.mServiceUuids);
    break label364;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 128, paramBluetoothDevice.mServiceUuids);
    break label364;
    paramBluetoothDevice.localName = new String(extractBytes(paramArrayOfByte, i, paramInt));
    break label364;
    Object localObject = parseUuidFromByte(extractBytes(paramArrayOfByte, i, 16));
    byte[] arrayOfByte = extractBytes(paramArrayOfByte, i + 16, paramInt - 16);
    paramBluetoothDevice.serviceData.put(localObject, arrayOfByte);
    break label364;
    int j = paramArrayOfByte[(i + 1)];
    int k = paramArrayOfByte[i];
    localObject = extractBytes(paramArrayOfByte, i + 2, paramInt - 2);
    paramBluetoothDevice.manufacturerData.put(((j & 0xFF) << 8) + (k & 0xFF), localObject);
    break label364;
    return paramBluetoothDevice;
    label240:
    paramInt -= 1;
    int i = j + 1;
    switch (paramArrayOfByte[j] & 0xFF)
    {
    }
    for (;;)
    {
      label364:
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
  
  @TargetApi(18)
  private void readBLECharacteristicValue(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new JSONObject(paramString2);
      localObject1 = ((JSONObject)localObject2).getString("deviceId");
      paramString2 = ((JSONObject)localObject2).getString("serviceId");
      localObject2 = ((JSONObject)localObject2).getString("characteristicId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break label157;
      }
      throw new Exception("readBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject1 + ",characteristicId=" + (String)localObject2 + ",deviceExtend=" + null);
    }
    catch (Exception paramString2)
    {
      i = 10008;
    }
    if (i == 0)
    {
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, localJSONObject, paramInt);
      return;
      label157:
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
          while (localIterator.hasNext())
          {
            BluetoothGattService localBluetoothGattService = (BluetoothGattService)localIterator.next();
            if (paramString2.equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
            {
              localIterator = localBluetoothGattService.getCharacteristics().iterator();
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                paramString2 = (BluetoothGattCharacteristic)localIterator.next();
              } while (!((String)localObject2).equalsIgnoreCase(paramString2.getUuid().toString()));
            }
          }
          while (paramString2 != null)
          {
            i = ((BluetoothDeviceExtend)localObject1).readCharacteristic(paramString2);
            break;
            this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, localJSONObject, paramInt);
            return;
            paramString2 = null;
          }
          i = 10005;
        }
      }
    }
  }
  
  private void registerBluetoothStateReceiver()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "registerBluetoothStateReceiver sIsReceiverRegister=" + this.sIsReceiverRegister);
    if (!this.sIsReceiverRegister)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      this.mActivity.registerReceiver(this.mBluetoothStateReceiver, localIntentFilter);
      this.sIsReceiverRegister = true;
    }
  }
  
  private void startBluetoothDevicesDiscovery(String paramString1, String paramString2, int paramInt)
  {
    long l1 = 500L;
    int i = 0;
    QLog.d("[mini] BluetoothJsPlugin", 2, "startBluetoothDevicesDiscovery jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    if ((this.mBluetoothAdapter == null) || (this.bleScan.isDiscovering))
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      return;
    }
    for (;;)
    {
      long l2;
      try
      {
        Object localObject = new JSONObject(paramString2);
        paramString2 = ((JSONObject)localObject).optJSONArray("services");
        boolean bool = ((JSONObject)localObject).optBoolean("allowDuplicatesKey", false);
        l2 = ((JSONObject)localObject).optLong("interval", 0L);
        if (l2 >= 500L) {
          break label323;
        }
        localObject = new ArrayList();
        if ((paramString2 != null) && (i < paramString2.length()))
        {
          ParcelUuid localParcelUuid = parseUuidFromStr(paramString2.optString(i));
          if (localParcelUuid == null) {
            break label330;
          }
          ((ArrayList)localObject).add(localParcelUuid.getUuid());
          break label330;
        }
        if (this.bleScan.startDiscovery(this.mBluetoothAdapter, (UUID[])((ArrayList)localObject).toArray(new UUID[0]), bool, l1))
        {
          paramString2 = new JSONObject();
          try
          {
            paramString2.put("available", this.mBluetoothAdapter.isEnabled());
            paramString2.put("discovering", this.bleScan.isDiscovering);
            this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, paramString2, paramInt);
            return;
          }
          catch (JSONException paramString2)
          {
            this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
            return;
          }
        }
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      return;
      label323:
      l1 = l2;
      continue;
      label330:
      i += 1;
    }
  }
  
  private void stopBluetoothDevicesDiscovery(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "stopBluetoothDevicesDiscovery callbackId=" + paramInt);
    if (this.mBluetoothAdapter == null)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    this.bleScan.stopDiscovery("stopBluetoothDevicesDiscovery");
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
  }
  
  private void unregisterBluetoothStateReceiver()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "unregisterBluetoothStateReceiver");
    if ((this.sIsReceiverRegister) && (this.mBluetoothStateReceiver != null))
    {
      this.mActivity.unregisterReceiver(this.mBluetoothStateReceiver);
      this.sIsReceiverRegister = false;
    }
  }
  
  @TargetApi(18)
  private void writeBLECharacteristicValue(String paramString1, String paramString2, int paramInt)
  {
    label198:
    label357:
    label362:
    for (;;)
    {
      Object localObject1;
      String str1;
      String str2;
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject2 = paramString2.getString("deviceId");
        localObject1 = paramString2.getString("serviceId");
        str1 = paramString2.getString("characteristicId");
        str2 = paramString2.getString("value");
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str1))) {
          break label357;
        }
        paramString2 = findBluetoothDeviceExtend((String)localObject2);
        if (paramString2 == null) {
          break label362;
        }
        if (paramString2.services != null) {
          break label198;
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      throw new Exception("writeBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject2 + ",serviceId=" + (String)localObject1 + ",characteristicId=" + str1 + ",deviceExtend=" + paramString2);
      Object localObject2 = paramString2.services.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        if (((String)localObject1).equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
        {
          localObject1 = localBluetoothGattService.getCharacteristics().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (BluetoothGattCharacteristic)((Iterator)localObject1).next();
            if (str1.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString())) {
              ((BluetoothGattCharacteristic)localObject2).setValue(Base64.decode(str2, 2));
            }
          }
        }
      }
      for (boolean bool = paramString2.writeCharacteristic((BluetoothGattCharacteristic)localObject2);; bool = false)
      {
        if (bool)
        {
          this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
          return;
        }
        throw new MiniAppException("writeBLECharacteristicValue fail!");
      }
      paramString2 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.bleScan.stopDiscovery("timeout");
      continue;
      this.bleScan.onBluetoothDeviceFound();
      if ((this.bleScan.isDiscovering) && (this.bleScan.mInterval > 0L)) {
        this.subHandler.sendEmptyMessageDelayed(2, this.bleScan.mInterval);
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "handleNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("openBluetoothAdapter".equals(paramString1)) {
      openBluetoothAdapter(paramString1, paramInt);
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("closeBluetoothAdapter".equals(paramString1)) {
        closeBluetoothAdapter(paramString1, paramInt);
      } else if ("getBluetoothAdapterState".equals(paramString1)) {
        getBluetoothAdapterState(paramString1, paramInt);
      } else if ("startBluetoothDevicesDiscovery".equals(paramString1)) {
        startBluetoothDevicesDiscovery(paramString1, paramString2, paramInt);
      } else if ("stopBluetoothDevicesDiscovery".equals(paramString1)) {
        stopBluetoothDevicesDiscovery(paramString1, paramInt);
      } else if ("getBluetoothDevices".equals(paramString1)) {
        getBluetoothDevices(paramString1, paramInt);
      } else if ("getConnectedBluetoothDevices".equals(paramString1)) {
        getConnectedBluetoothDevices(paramString1, paramString2, paramInt);
      } else if ("createBLEConnection".equals(paramString1)) {
        createBLEConnection(paramString1, paramString2, paramInt);
      } else if ("closeBLEConnection".equals(paramString1)) {
        closeBLEConnection(paramString1, paramString2, paramInt);
      } else if ("getBLEDeviceServices".equals(paramString1)) {
        getBLEDeviceServices(paramString1, paramString2, paramInt);
      } else if ("getBLEDeviceCharacteristics".equals(paramString1)) {
        getBLEDeviceCharacteristics(paramString1, paramString2, paramInt);
      } else if ("readBLECharacteristicValue".equals(paramString1)) {
        readBLECharacteristicValue(paramString1, paramString2, paramInt);
      } else if ("writeBLECharacteristicValue".equals(paramString1)) {
        writeBLECharacteristicValue(paramString1, paramString2, paramInt);
      } else if ("notifyBLECharacteristicValueChange".equals(paramString1)) {
        notifyBLECharacteristicValueChange(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mActivity = paramBaseJsPluginEngine.appBrandRuntime.activity;
    this.isSupportBlueTooth = this.mActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
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
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
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
      QLog.d("[mini] BluetoothJsPlugin", 2, "BLEScan.onBluetoothDeviceFound foundDevices size =" + this.foundDevices.size());
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
                break label129;
              }
              localJSONArray.put(((BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next()).toJson());
            }
          }
          return;
        }
        catch (JSONException localJSONException) {}
      }
      label129:
      localObject.put("devices", localJSONArray);
      String str = localObject.toString();
      QLog.d("[mini] BluetoothJsPlugin", 2, "BLEScan.onBluetoothDeviceFound callback data =" + str);
      BluetoothJsPlugin.this.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS("onBluetoothDeviceFound", str);
    }
    
    public void onLeScan(BluetoothDevice arg1, int paramInt, byte[] paramArrayOfByte)
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BLEScan.onLeScan device =" + ??? + ",rssi=" + paramInt + ",scanRecord=" + paramArrayOfByte);
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
      if (QLog.isColorLevel()) {
        QLog.d("[mini] BluetoothJsPlugin", 2, "BLEScan.startDiscovery serviceUUID=" + paramArrayOfUUID + ",allowDuplicatesKey=" + paramBoolean + ",timeout=" + paramLong);
      }
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
      QLog.d("[mini] BluetoothJsPlugin", 2, "BLEScan.stopDiscovery......from=" + ???);
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
    List<Integer> blueToothServiceListeners = new ArrayList();
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
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.connectGatt autoConnect=" + paramBoolean + ",timeout=" + paramLong + ",callbackId=" + paramInt);
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
          throw new MiniAppException("connectGatt is null");
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
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.destory,,,,,,");
      disconnectGatt();
      synchronized (this.blueToothServiceListeners)
      {
        this.blueToothServiceListeners.clear();
        return;
      }
    }
    
    public boolean disconnectGatt()
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.disconnectGatt,,,,,,");
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
    
    public void getServices(int paramInt)
      throws Exception
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.getServices callbackId=" + paramInt);
      if (this.gatt == null) {
        throw new MiniAppException("getService exception, state=" + this.state + ",gatt=" + this.gatt);
      }
      if (!this.blueToothServiceListeners.contains(Integer.valueOf(paramInt))) {
        this.blueToothServiceListeners.add(Integer.valueOf(paramInt));
      }
      if (this.services != null) {
        onServicesDiscovered(this.gatt, 0);
      }
      do
      {
        return;
        if (this.lastConnectionTime + 600L > System.currentTimeMillis())
        {
          BluetoothJsPlugin.this.subHandler.postDelayed(new BluetoothJsPlugin.BluetoothDeviceExtend.2(this, paramInt), 600L);
          return;
        }
      } while (this.gatt.discoverServices());
      BluetoothJsPlugin.this.jsPluginEngine.callbackJsEventFail(BluetoothJsPlugin.this.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", null, paramInt);
    }
    
    public boolean notifyBLECharacteristicValueChange(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
    {
      int j = 1;
      boolean bool2 = false;
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.notifyBLECharacteristicValueChange c=" + paramBluetoothGattCharacteristic + ",state=" + paramBoolean);
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
        label80:
        if ((k & 0x20) <= 0) {
          break label170;
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
        break label80;
        label170:
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
        BluetoothJsPlugin.this.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onBLECharacteristicValueChange", localJSONObject.toString(), 0);
        return;
      }
      catch (JSONException paramBluetoothGatt) {}
    }
    
    public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.onCharacteristicRead gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
    }
    
    public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.onCharacteristicWrite gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
    }
    
    /* Error */
    public void onConnectionStateChange(BluetoothGatt arg1, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: ldc 110
      //   2: iconst_2
      //   3: new 112	java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   10: ldc_w 384
      //   13: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: aload_0
      //   17: getfield 158	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
      //   20: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   23: ldc_w 379
      //   26: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   29: iload_2
      //   30: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   33: ldc_w 386
      //   36: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   39: iload_3
      //   40: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   43: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   46: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   49: aload_0
      //   50: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   53: invokestatic 181	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$500	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Landroid/os/Handler;
      //   56: aload_0
      //   57: getfield 103	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:connTimeoutJob	Ljava/lang/Runnable;
      //   60: invokevirtual 187	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
      //   63: aload_0
      //   64: iload_3
      //   65: putfield 52	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
      //   68: aload_0
      //   69: getfield 52	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
      //   72: iconst_2
      //   73: if_icmpne +186 -> 259
      //   76: aload_0
      //   77: invokestatic 256	java/lang/System:currentTimeMillis	()J
      //   80: putfield 248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:lastConnectionTime	J
      //   83: aload_0
      //   84: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   87: invokestatic 390	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$800	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
      //   90: astore_1
      //   91: aload_1
      //   92: monitorenter
      //   93: aload_0
      //   94: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   97: invokestatic 390	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$800	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
      //   100: aload_0
      //   101: getfield 91	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
      //   104: invokevirtual 393	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
      //   107: ifne +19 -> 126
      //   110: aload_0
      //   111: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   114: invokestatic 390	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$800	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
      //   117: aload_0
      //   118: getfield 91	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
      //   121: aload_0
      //   122: invokevirtual 396	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   125: pop
      //   126: aload_1
      //   127: monitorexit
      //   128: iconst_1
      //   129: istore 4
      //   131: aload_0
      //   132: getfield 75	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
      //   135: astore_1
      //   136: aload_1
      //   137: monitorenter
      //   138: aload_0
      //   139: getfield 75	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
      //   142: invokeinterface 400 1 0
      //   147: astore 5
      //   149: aload 5
      //   151: invokeinterface 405 1 0
      //   156: ifeq +155 -> 311
      //   159: aload 5
      //   161: invokeinterface 409 1 0
      //   166: checkcast 143	java/lang/Integer
      //   169: invokevirtual 412	java/lang/Integer:intValue	()I
      //   172: istore_2
      //   173: ldc 110
      //   175: iconst_2
      //   176: new 112	java/lang/StringBuilder
      //   179: dup
      //   180: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   183: ldc_w 414
      //   186: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: iload 4
      //   191: invokevirtual 122	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   194: ldc_w 416
      //   197: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: iload_2
      //   201: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   204: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   207: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   210: iload 4
      //   212: ifeq +71 -> 283
      //   215: aload_0
      //   216: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   219: getfield 268	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
      //   222: aload_0
      //   223: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   226: getfield 268	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
      //   229: invokevirtual 274	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getServiceRuntime	()Lcom/tencent/mobileqq/mini/webview/JsRuntime;
      //   232: ldc_w 418
      //   235: aconst_null
      //   236: iload_2
      //   237: invokevirtual 421	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
      //   240: goto -91 -> 149
      //   243: astore 5
      //   245: aload_1
      //   246: monitorexit
      //   247: aload 5
      //   249: athrow
      //   250: astore_1
      //   251: return
      //   252: astore 5
      //   254: aload_1
      //   255: monitorexit
      //   256: aload 5
      //   258: athrow
      //   259: iload_3
      //   260: ifne +17 -> 277
      //   263: aload_0
      //   264: getfield 158	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
      //   267: ifnull +10 -> 277
      //   270: aload_0
      //   271: getfield 158	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
      //   274: invokevirtual 167	android/bluetooth/BluetoothGatt:close	()V
      //   277: iconst_0
      //   278: istore 4
      //   280: goto -149 -> 131
      //   283: aload_0
      //   284: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   287: getfield 268	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
      //   290: aload_0
      //   291: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   294: getfield 268	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
      //   297: invokevirtual 274	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getServiceRuntime	()Lcom/tencent/mobileqq/mini/webview/JsRuntime;
      //   300: ldc_w 418
      //   303: aconst_null
      //   304: iload_2
      //   305: invokevirtual 280	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
      //   308: goto -159 -> 149
      //   311: aload_0
      //   312: getfield 75	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
      //   315: invokeinterface 214 1 0
      //   320: aload_1
      //   321: monitorexit
      //   322: new 340	org/json/JSONObject
      //   325: dup
      //   326: invokespecial 341	org/json/JSONObject:<init>	()V
      //   329: astore_1
      //   330: aload_1
      //   331: ldc_w 343
      //   334: aload_0
      //   335: getfield 91	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
      //   338: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   341: pop
      //   342: aload_1
      //   343: ldc_w 423
      //   346: iload 4
      //   348: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
      //   351: pop
      //   352: aload_0
      //   353: getfield 47	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
      //   356: getfield 268	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
      //   359: invokevirtual 274	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getServiceRuntime	()Lcom/tencent/mobileqq/mini/webview/JsRuntime;
      //   362: ldc_w 428
      //   365: aload_1
      //   366: invokevirtual 365	org/json/JSONObject:toString	()Ljava/lang/String;
      //   369: iconst_0
      //   370: invokeinterface 371 4 0
      //   375: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	376	0	this	BluetoothDeviceExtend
      //   0	376	2	paramInt1	int
      //   0	376	3	paramInt2	int
      //   129	218	4	bool	boolean
      //   147	13	5	localIterator	Iterator
      //   243	5	5	localObject1	Object
      //   252	5	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   138	149	243	finally
      //   149	210	243	finally
      //   215	240	243	finally
      //   245	247	243	finally
      //   283	308	243	finally
      //   311	322	243	finally
      //   49	93	250	org/json/JSONException
      //   131	138	250	org/json/JSONException
      //   247	250	250	org/json/JSONException
      //   256	259	250	org/json/JSONException
      //   263	277	250	org/json/JSONException
      //   322	375	250	org/json/JSONException
      //   93	126	252	finally
      //   126	128	252	finally
      //   254	256	252	finally
    }
    
    public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.onServicesDiscovered gatt=" + paramBluetoothGatt + ",status=" + paramInt);
      Object localObject;
      boolean bool;
      if (paramInt == 0)
      {
        this.services = paramBluetoothGatt.getServices();
        try
        {
          localObject = new JSONArray();
          if (this.services.size() > 0)
          {
            paramBluetoothGatt = this.services.iterator();
            for (;;)
            {
              if (paramBluetoothGatt.hasNext())
              {
                BluetoothGattService localBluetoothGattService = (BluetoothGattService)paramBluetoothGatt.next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("uuid", localBluetoothGattService.getUuid().toString());
                if (localBluetoothGattService.getType() == 0)
                {
                  bool = true;
                  localJSONObject.put("isPrimary", bool);
                  ((JSONArray)localObject).put(localJSONObject);
                  continue;
                  localObject = this.blueToothServiceListeners.iterator();
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
        if (((Iterator)localObject).hasNext())
        {
          paramInt = ((Integer)((Iterator)localObject).next()).intValue();
          if (paramBluetoothGatt != null)
          {
            BluetoothJsPlugin.this.jsPluginEngine.callbackJsEventOK(BluetoothJsPlugin.this.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", paramBluetoothGatt, paramInt);
            continue;
            bool = false;
            break;
            paramBluetoothGatt = new JSONObject();
          }
        }
        try
        {
          paramBluetoothGatt.put("services", localObject);
        }
        catch (JSONException localJSONException) {}
        BluetoothJsPlugin.this.jsPluginEngine.callbackJsEventFail(BluetoothJsPlugin.this.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", null, paramInt);
        continue;
        return;
        continue;
        paramBluetoothGatt = null;
      }
    }
    
    public int readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
      throws Exception
    {
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.readCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
      if (paramBluetoothGattCharacteristic == null) {
        throw new MiniAppException("readCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
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
      QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.writeCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
      if ((this.gatt == null) || (paramBluetoothGattCharacteristic == null)) {
        throw new MiniAppException("writeCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
      }
      if ((paramBluetoothGattCharacteristic.getProperties() & 0x8) > 0) {
        return this.gatt.writeCharacteristic(paramBluetoothGattCharacteristic);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin
 * JD-Core Version:    0.7.0.1
 */