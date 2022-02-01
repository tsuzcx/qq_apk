package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import ataj;
import atak;
import atal;
import atam;
import atan;
import com.tencent.av.VideoController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import jlc;

public class TraeAudioManager
  extends BroadcastReceiver
{
  static int _gHostProcessId = -1;
  static ReentrantLock _glock;
  static TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager;
  static final String[] forceName = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  private static long pW = 5000L;
  public int _activeMode = 0;
  public AudioManager _am = null;
  Context _context = null;
  int _modePolicy = -1;
  int _prevMode = 0;
  int _streamType = 0;
  atam jdField_a_of_type_Atam = null;
  TraeAudioManagerLooper jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper = null;
  d jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d = null;
  e jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e = null;
  switchThread jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = null;
  String cGx = "DEVICE_NONE";
  boolean dgT = true;
  private int eoy = 4;
  String sessionConnectedDev = "DEVICE_NONE";
  
  static
  {
    _glock = new ReentrantLock();
  }
  
  TraeAudioManager(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" context:" + paramContext);
    if (paramContext == null) {
      return;
    }
    this._context = paramContext;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper = new TraeAudioManagerLooper(this);
    AudioDeviceInterface.LogTraceExit();
  }
  
  static boolean IsEabiLowVersion()
  {
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
      }
      if ((IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return IsEabiLowVersionByAbi(str2);
    }
    return false;
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return true;
        if (paramString.contains("x86")) {
          return false;
        }
        if (paramString.contains("mips")) {
          return false;
        }
      } while (paramString.equalsIgnoreCase("armeabi"));
      if (paramString.equalsIgnoreCase("armeabi-v7a")) {
        return false;
      }
    } while (!paramString.equalsIgnoreCase("arm64-v8a"));
    return false;
  }
  
  static int a(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    jlc.a(localHashMap, paramLong1);
    return sendMessage(32778, localHashMap);
  }
  
  static int a(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString2);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString3);
    jlc.a(localHashMap, paramLong1);
    return sendMessage(32782, localHashMap);
  }
  
  static int a(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    jlc.a(localHashMap, paramLong1);
    return sendMessage(32775, localHashMap);
  }
  
  static int a(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString3);
    jlc.a(localHashMap, paramLong1);
    return sendMessage(32772, localHashMap);
  }
  
  public static int a(boolean paramBoolean, long paramLong, Context paramContext)
  {
    int j = -1;
    _glock.lock();
    int i = j;
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null)
    {
      i = j;
      if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Atam != null)
      {
        if (!paramBoolean) {
          break label59;
        }
        jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Atam.g(paramLong, paramContext);
      }
    }
    for (;;)
    {
      i = 0;
      _glock.unlock();
      return i;
      label59:
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Atam.remove(paramLong);
    }
  }
  
  private boolean aIV()
  {
    try
    {
      boolean bool = this._am.isSpeakerphoneOn();
      return bool;
    }
    catch (Exception localException)
    {
      igd.aL("TraeAudioManager", localException.getMessage());
    }
    return false;
  }
  
  static int ao(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "setBluetoothConnectingTime,time: " + paramLong);
    }
    pW = paramLong;
    return 0;
  }
  
  public static int b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    jlc.a(localHashMap, paramLong1);
    return sendMessage(32783, localHashMap);
  }
  
  public static boolean checkDevName(String paramString)
  {
    if (paramString == null) {}
    while ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32789, localHashMap);
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    return sendMessage(32776, localHashMap);
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    if (Build.MANUFACTURER.equals("Google")) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Google phone nothing to do");
      }
    }
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 28) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Android P system nothing to do, version: " + Build.VERSION.SDK_INT);
      return;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Class[] arrayOfClass = new Class[arrayOfObject.length];
      arrayOfClass[0] = Integer.TYPE;
      paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", arrayOfObject, arrayOfClass);
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
  }
  
  static int getAudioSource(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (IsEabiLowVersion())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TraeAudioManager", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:" + 0);
        j = i;
      }
    }
    do
    {
      return j;
      int k = Build.VERSION.SDK_INT;
      if (paramInt >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
        }
        return paramInt;
      }
      i = j;
      if (k >= 11) {
        i = 7;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
    return i;
  }
  
  static int getAudioStreamType(int paramInt)
  {
    int i = 3;
    if (IsEabiLowVersion())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TraeAudioManager", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + 3);
        j = i;
      }
      return j;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("TraeAudioManager", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  static int getCallAudioMode(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (IsEabiLowVersion())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TraeAudioManager", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:" + 0);
        j = i;
      }
    }
    do
    {
      return j;
      int k = Build.VERSION.SDK_INT;
      if (paramInt >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
        }
        return paramInt;
      }
      i = j;
      if (k >= 11) {
        i = 3;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
    return i;
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32779, localHashMap);
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32774, localHashMap);
  }
  
  static String getForceConfigName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < forceName.length)) {
      return forceName[paramInt];
    }
    return "unknow";
  }
  
  static int getForceUse(int paramInt)
  {
    Object localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", (Object[])localObject, arrayOfClass);
    if (localObject != null) {}
    for (localObject = (Integer)localObject;; localObject = Integer.valueOf(0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + getForceConfigName(((Integer)localObject).intValue()));
      }
      return ((Integer)localObject).intValue();
    }
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32784, localHashMap);
  }
  
  public static int init(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
    _glock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager == null) {
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      try
      {
        paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
        return paramObject;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "invokeMethod Exception:" + paramObject.getMessage());
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "ClassNotFound:" + paramString1);
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "NoSuchMethod:" + paramString2);
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "IllegalArgument:" + paramString2);
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "IllegalAccess:" + paramString2);
      return null;
    }
    catch (InvocationTargetException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "InvocationTarget:" + paramString2);
      return null;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "invokeStaticMethod Exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return false;
        if (!Build.MANUFACTURER.equals("Xiaomi")) {
          break;
        }
        if (Build.MODEL.equals("MI 2")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2A")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2S")) {
          return true;
        }
      } while (!Build.MODEL.equals("MI 2SC"));
      return true;
    } while ((!Build.MANUFACTURER.equals("samsung")) || (!Build.MODEL.equals("SCH-I959")));
    return true;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32777, localHashMap);
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    _glock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null) {
      i = jdField_a_of_type_ComTencentSharpJniTraeAudioManager.internalSendMessage(paramInt, paramHashMap);
    }
    _glock.unlock();
    return i;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    Object localObject = new Object[2];
    localObject[0] = Integer.valueOf(paramInt1);
    localObject[1] = Integer.valueOf(paramInt2);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "setForceUse", (Object[])localObject, arrayOfClass);
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + getForceConfigName(paramInt2) + " res:" + localObject);
    }
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32773, localHashMap);
  }
  
  public static void uninit()
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
    _glock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null)
    {
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.release();
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32788, localHashMap);
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32781, localHashMap);
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32780, localHashMap);
  }
  
  boolean InternalIsDeviceChangeable()
  {
    String str = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectingDevice();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    if (this._context == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
    localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", InternalIsDeviceChangeable());
    try
    {
      this._context.sendBroadcast(localIntent);
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyDeviceChangableUpdate e = " + localException);
        }
      }
    }
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null) {
      return -1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getSnapParams();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getBluetoothName());
    try
    {
      this._context.sendBroadcast(localIntent);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyDeviceListUpdate e = " + localException);
        }
      }
    }
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectingDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "SetMode entry:" + paramInt);
    }
    if (this._am == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "setMode:" + paramInt + " fail am=null");
      }
    }
    do
    {
      return;
      this._am.setMode(paramInt);
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("setMode:").append(paramInt);
    if (this._am.getMode() != paramInt) {}
    for (String str = "fail";; str = "success")
    {
      QLog.w("TraeAudioManager", 2, str);
      return;
    }
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    j = 0;
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
    }
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
    }
    for (;;)
    {
      try
      {
        boolean bool = paramAudioManager.isSpeakerphoneOn();
        if (bool != paramBoolean) {
          continue;
        }
        i = j;
      }
      catch (Exception localException)
      {
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TraeAudioManager", 1, "InternalSetSpeakerSpe fail", localException);
        i = j;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      return i;
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
      continue;
      i = -1;
    }
  }
  
  void _updateEarphoneVisable()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_WIREDHEADSET"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " detected headset plugin,so disable earphone");
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setVisible("DEVICE_EARPHONE", false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " detected headset plugout,so enable earphone");
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setVisible("DEVICE_EARPHONE", true);
  }
  
  int a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    int i = -1;
    int j;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no context");
      }
      j = -1;
    }
    do
    {
      return j;
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no audio manager");
        }
        return -1;
      }
      boolean bool = isCloseSystemAPM(this._modePolicy);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, isSpeakerphoneOn[" + paramContext.isSpeakerphoneOn() + "], speakerOn[" + paramBoolean + "], isCloseSystemAPM[" + bool + "], _activeMode[" + this._activeMode + "], seq[" + paramLong + "]");
      }
      if ((bool) && (this._activeMode != 2)) {
        return InternalSetSpeakerSpe(paramContext, paramBoolean);
      }
      try
      {
        if (paramContext.isSpeakerphoneOn() != paramBoolean) {
          paramContext.setSpeakerphoneOn(paramBoolean);
        }
        bool = paramContext.isSpeakerphoneOn();
        if (bool == paramBoolean) {
          i = 0;
        }
        j = i;
      }
      catch (Exception paramContext)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, res[" + i + "], mode[" + paramContext.getMode() + "], seq[" + paramLong + "]");
          }
          return i;
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        i = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, seq[" + paramLong + "]", paramContext);
    return i;
  }
  
  int a(long paramLong, String paramString, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "InternalConnectDevice, devName[" + paramString + "], seq[" + paramLong + "]");
    }
    if (paramString == null) {}
    do
    {
      do
      {
        return -1;
        if ((!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice().equals("DEVICE_NONE")) && (paramString.equals(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice()))) {
          return 0;
        }
        if ((checkDevName(paramString) == true) && (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible(paramString) == true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, " checkDevName fail");
      return -1;
      if (InternalIsDeviceChangeable() == true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TraeAudioManager", 2, " InternalIsDeviceChangeable fail");
    return -1;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setConnecting(paramString);
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "InternalConnectDevice, quit, _switchThread[" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread.getDeviceName() + "], running_stat[" + this.dgT + "], seq[" + paramLong + "]");
      }
      this.dgT = false;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread.nl(paramLong);
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = new earphoneSwitchThread(paramLong);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread != null)
      {
        this.dgT = true;
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread.setDeviceConnectParam(paramHashMap);
        paramHashMap = new Intent();
        paramHashMap.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        paramHashMap.putExtra("PARAM_OPERATION", "NOTIFY_BEGIN_CONNECTED_DEVICE");
        paramHashMap.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
        jlc.a(paramHashMap, paramLong);
      }
      try
      {
        this._context.sendBroadcast(paramHashMap);
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread.start(paramLong);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "InternalConnectDevice.end, devName[" + paramString + "], seq[" + paramLong + "]");
        }
        return 0;
        if (paramString.equals("DEVICE_SPEAKERPHONE"))
        {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = new speakerSwitchThread(paramLong);
          continue;
        }
        if (paramString.equals("DEVICE_WIREDHEADSET"))
        {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = new headsetSwitchThread(paramLong);
          continue;
        }
        if (!paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
          continue;
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = new bluetoothHeadsetSwitchThread(paramLong);
      }
      catch (Exception paramHashMap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "InternalConnectDevice notify error, e = " + paramHashMap);
          }
        }
      }
    }
  }
  
  int a(long paramLong, HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this._context == null)) {
      return -1;
    }
    Object localObject1 = (String)paramHashMap.get("PARAM_DEVICE");
    boolean bool = InternalIsDeviceChangeable();
    int i;
    if (checkDevName((String)localObject1) != true) {
      i = 7;
    }
    for (;;)
    {
      this.cGx = ((String)localObject1);
      Object localObject2 = paramHashMap.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "InternalSessionConnectDevice, sessonID[" + localObject2 + "], devName[" + (String)localObject1 + "], bChangabled[" + bool + "], err[" + i + "], seq[" + paramLong + "]");
      }
      if (i != 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject1, paramHashMap, i);
        return -1;
        if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible((String)localObject1))
        {
          i = 8;
          continue;
        }
        if (!bool)
        {
          i = 9;
          this.sessionConnectedDev = ((String)localObject1);
        }
      }
      else
      {
        if (((String)localObject1).equals(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, " --has connected!");
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
          sendResBroadcast((Intent)localObject1, paramHashMap, i);
          return 0;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, " --connecting...");
        }
        a(paramLong, (String)localObject1, paramHashMap);
        AudioDeviceInterface.LogTraceExit();
        return 0;
      }
      i = 0;
    }
  }
  
  public d a(Context paramContext, e parame)
  {
    Object localObject1;
    Object localObject2;
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT != 18))
    {
      localObject1 = new a();
      localObject2 = localObject1;
      if (!((d)localObject1).a(paramContext, parame)) {
        localObject2 = new b();
      }
      if (QLog.isColorLevel())
      {
        parame = new StringBuilder().append("CreateBluetoothCheck:").append(((d)localObject2).interfaceDesc()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label142;
        }
      }
    }
    label142:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TraeAudioManager", 2, paramContext);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new c();
        break;
      }
      localObject1 = new b();
      break;
    }
  }
  
  void a(long paramLong, String paramString, Intent paramIntent, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE.gvideo", 2, "   OPERATION:" + paramString);
    }
    if ("OPERATION_REGISTERAUDIOSESSION".equals(paramString)) {
      a(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
    }
    do
    {
      return;
      if ("OPERATION_STARTSERVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
        return;
      }
      if ("OPERATION_STOPSERVICE".equals(paramString))
      {
        stopService(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETDEVICELIST".equals(paramString))
      {
        getDeviceList(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(paramString))
      {
        getStreamType(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_CONNECTDEVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
        return;
      }
      if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(paramString))
      {
        connectHighestPriorityDevice(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_EARACTION".equals(paramString))
      {
        earAction(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
        return;
      }
      if ("OPERATION_ISDEVICECHANGABLED".equals(paramString))
      {
        isDeviceChangabled(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETCONNECTEDDEVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(paramString))
      {
        getConnectingDevice(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      int i;
      int j;
      if ("OPERATION_VOICECALL_PREPROCESS".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
        j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
        voicecallPreprocess(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
        return;
      }
      if ("OPERATION_VOICECALL_POSTROCESS".equals(paramString))
      {
        voicecallPostprocess(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
        j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
        voiceCallAudioParamChanged(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
        return;
      }
      if ("OPERATION_STARTRING".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
        j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
        paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
        String str1 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
        boolean bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
        String str2 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
        boolean bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str1, bool1, k, str2, bool2);
        return;
      }
    } while (!"OPERATION_STOPRING".equals(paramString));
    b(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
  }
  
  void aY(long paramLong, String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getDeviceNumber();
    Object localObject;
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateDeviceStatus, connectDeviceNameWhenServiceOn[").append(paramString).append("], getDeviceNumber[").append(j).append("], _bluetoothCheck[");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d != null)
      {
        bool = true;
        QLog.w("TraeAudioManager", 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      i = 0;
      label96:
      if (i >= j) {
        break label317;
      }
      localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getDeviceName(i);
      if (localObject == null) {
        break label311;
      }
      if (!((String)localObject).equals("DEVICE_BLUETOOTHHEADSET")) {
        break label257;
      }
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d != null) {
        break label236;
      }
      bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setVisible((String)localObject, false);
    }
    for (;;)
    {
      if ((bool) && (QLog.isColorLevel())) {
        QLog.w("TraeAudioManager", 1, "updateDeviceStatus, devName[" + (String)localObject + "], Visible[" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible((String)localObject) + "], seq[" + paramLong + "]");
      }
      i += 1;
      break label96;
      bool = false;
      break;
      label236:
      bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setVisible((String)localObject, this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d.isConnected());
      continue;
      label257:
      if (((String)localObject).equals("DEVICE_WIREDHEADSET"))
      {
        bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setVisible((String)localObject, this._am.isWiredHeadsetOn());
      }
      else
      {
        if (((String)localObject).equals("DEVICE_SPEAKERPHONE")) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.setVisible((String)localObject, true);
        }
        label311:
        bool = false;
      }
    }
    label317:
    aZ(paramLong, paramString);
  }
  
  void aZ(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisiableUpdateFlag() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "checkAutoDeviceListUpdate, connectDeviceNameWhenServiceOn[" + paramString + "], seq[" + paramLong + "]");
      }
      _updateEarphoneVisable();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.resetVisiableUpdateFlag();
      HashMap localHashMap = new HashMap();
      localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString);
      jlc.a(localHashMap, paramLong);
      internalSendMessage(32785, localHashMap);
    }
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisiableUpdateFlag() == true) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label117;
        }
      }
    }
    label117:
    for (Object localObject = " piugin";; localObject = " plugout")
    {
      QLog.w("TraeAudioManager", 2, (String)localObject + " connectedDev:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice());
      _updateEarphoneVisable();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.resetVisiableUpdateFlag();
      if (!paramBoolean) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32786, (HashMap)localObject);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice();
    if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32787, (HashMap)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
    }
    internalSendMessage(32793, new HashMap());
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper != null) {
      i = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper.sendMessage(paramInt, paramHashMap);
    }
    return i;
  }
  
  void ng(long paramLong)
  {
    aZ(paramLong, null);
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unkonw";
    }
    localObject = "" + " [" + paramContext + "] ";
    int i = paramIntent.getIntExtra("state", -1);
    paramContext = (Context)localObject;
    if (i != -1)
    {
      localObject = new StringBuilder().append((String)localObject);
      if (i == 0)
      {
        paramContext = "unplugged";
        paramContext = paramContext;
      }
    }
    else
    {
      localObject = paramContext + " mic:";
      int j = paramIntent.getIntExtra("microphone", -1);
      paramContext = (Context)localObject;
      if (j != -1)
      {
        paramIntent = new StringBuilder().append((String)localObject);
        if (j != 1) {
          break label255;
        }
        paramContext = "Y";
        label168:
        paramContext = paramContext;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "onHeadsetPlug:: " + paramContext);
      }
      paramContext = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e;
      if (1 != i) {
        break label262;
      }
    }
    label262:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setVisible("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "onHeadsetPlug exit");
      }
      return;
      paramContext = "plugged";
      break;
      label255:
      paramContext = "unkown";
      break label168;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TraeAudioManager", 2, "onReceive intent or context is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.getStringExtra("PARAM_OPERATION");
        long l = jlc.a(paramIntent);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "onReceive, strAction[" + str2 + "], strOption[" + str1 + "], seq[" + l + "]");
        }
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TraeAudioManager", 2, "_deviceConfigManager null!");
          }
        }
        else
        {
          boolean bool1 = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_WIREDHEADSET");
          boolean bool2 = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_BLUETOOTHHEADSET");
          if ("android.intent.action.HEADSET_PLUG".equals(str2))
          {
            onHeadsetPlug(paramContext, paramIntent);
            if ((!bool1) && (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_WIREDHEADSET") == true)) {
              checkDevicePlug("DEVICE_WIREDHEADSET", true);
            }
            if ((bool1 == true) && (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_WIREDHEADSET"))) {
              checkDevicePlug("DEVICE_WIREDHEADSET", false);
            }
          }
          else if (!"android.media.AUDIO_BECOMING_NOISY".equals(str2))
          {
            if ("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE.qav", 2, "   OPERATION:" + str1);
              }
              if ("OPERATION_REGISTERAUDIOSESSION".equals(str1))
              {
                a(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
                return;
              }
              if ("OPERATION_STARTSERVICE".equals(str1))
              {
                a(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
                return;
              }
              if ("OPERATION_STOPSERVICE".equals(str1))
              {
                stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETDEVICELIST".equals(str1))
              {
                getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETSTREAMTYPE".equals(str1))
              {
                getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_CONNECTDEVICE".equals(str1))
              {
                a(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
                return;
              }
              if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
              {
                connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_EARACTION".equals(str1))
              {
                earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
                return;
              }
              if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
              {
                isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
              {
                a(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
              {
                getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              int i;
              int j;
              if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
              {
                voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_STARTRING".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
                j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
                paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
                str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
                bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
                String str3 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
                int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
                bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
                a(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, str3, bool2);
                return;
              }
              if ("OPERATION_STOPRING".equals(str1)) {
                b(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              }
            }
            else
            {
              if (("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2)) && (BaseApplicationImpl.processName != null) && (BaseApplicationImpl.processName.endsWith("groupvideo")))
              {
                a(l, str1, paramIntent, paramContext);
                return;
              }
              if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e != null)
              {
                if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d != null) {
                  this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d.a(paramContext, paramIntent, this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e);
                }
                if ((!bool2) && (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_BLUETOOTHHEADSET") == true)) {
                  checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
                }
                if ((bool2 == true) && (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible("DEVICE_BLUETOOTHHEADSET")))
                {
                  checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramContext) {}
    }
  }
  
  void printDevices()
  {
    int j = 0;
    AudioDeviceInterface.LogTraceEntry("");
    int k = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getDeviceNumber();
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   ConnectedDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   ConnectingDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectingDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   prevConnectedDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getPrevConnectedDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   AHPDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailabledHighestPriorityDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   deviceNamber:" + k);
    }
    int i = 0;
    while (i < k)
    {
      localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getDeviceName(i);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "      " + i + " devName:" + (String)localObject + " Visible:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible((String)localObject) + " Priority:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getPriority((String)localObject));
      }
      i += 1;
    }
    Object localObject = (String[])this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailableDeviceList().toArray(new String[0]);
    i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TraeAudioManager", 2, "   AvailableNamber:" + localObject.length);
      i = j;
    }
    while (i < localObject.length)
    {
      String str = localObject[i];
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "      " + i + " devName:" + str + " Visible:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible(str) + " Priority:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getPriority(str));
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper.quit();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  int sendResBroadcast(Intent paramIntent, HashMap<String, Object> paramHashMap, int paramInt)
  {
    if ((this._context == null) || (paramHashMap == null)) {
      return -1;
    }
    Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    String str = (String)paramHashMap.get("PARAM_OPERATION");
    long l = jlc.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "sendResBroadcast, operation[" + str + "], sessionID[" + localLong + "], seq[" + l + "]");
    }
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      InternalNotifyDeviceListUpdate();
      return -1;
    }
    paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    paramIntent.putExtra("PARAM_SESSIONID", localLong);
    paramIntent.putExtra("PARAM_OPERATION", str);
    paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
    jlc.a(paramHashMap, l);
    try
    {
      this._context.sendBroadcast(paramIntent);
      return 0;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "sendResBroadcast Exception, operation[" + str + "], seq[" + l + "]", paramIntent);
        }
      }
    }
  }
  
  public class TraeAudioManagerLooper
    extends Thread
  {
    boolean _enabled;
    public int _focusSteamType;
    String _lastCfg;
    public int _preRingMode;
    int _preServiceMode;
    String _ringOperation;
    long _ringSessionID;
    String _ringUserdata;
    final boolean[] _started;
    String _voiceCallOperation;
    long _voiceCallSessionID;
    atan jdField_b_of_type_Atan;
    TraeAudioManager jdField_b_of_type_ComTencentSharpJniTraeAudioManager;
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    Handler mMsgHandler;
    
    /* Error */
    public TraeAudioManagerLooper(TraeAudioManager paramTraeAudioManager)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 37	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:this$0	Lcom/tencent/sharp/jni/TraeAudioManager;
      //   5: aload_0
      //   6: invokespecial 40	java/lang/Thread:<init>	()V
      //   9: aload_0
      //   10: aconst_null
      //   11: putfield 42	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:mMsgHandler	Landroid/os/Handler;
      //   14: aload_0
      //   15: aconst_null
      //   16: putfield 44	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:jdField_b_of_type_Atan	Latan;
      //   19: aload_0
      //   20: ldc2_w 45
      //   23: putfield 48	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringSessionID	J
      //   26: aload_0
      //   27: ldc 50
      //   29: putfield 52	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringOperation	Ljava/lang/String;
      //   32: aload_0
      //   33: ldc 50
      //   35: putfield 54	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringUserdata	Ljava/lang/String;
      //   38: aload_0
      //   39: iconst_1
      //   40: newarray boolean
      //   42: dup
      //   43: iconst_0
      //   44: iconst_0
      //   45: bastore
      //   46: putfield 56	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   49: aload_0
      //   50: iconst_0
      //   51: putfield 58	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_enabled	Z
      //   54: aload_0
      //   55: aconst_null
      //   56: putfield 60	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:jdField_b_of_type_ComTencentSharpJniTraeAudioManager	Lcom/tencent/sharp/jni/TraeAudioManager;
      //   59: aload_0
      //   60: ldc 50
      //   62: putfield 62	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_lastCfg	Ljava/lang/String;
      //   65: aload_0
      //   66: iconst_0
      //   67: putfield 64	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_preServiceMode	I
      //   70: aload_0
      //   71: iconst_0
      //   72: putfield 66	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_preRingMode	I
      //   75: aload_0
      //   76: ldc2_w 45
      //   79: putfield 68	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_voiceCallSessionID	J
      //   82: aload_0
      //   83: ldc 50
      //   85: putfield 70	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_voiceCallOperation	Ljava/lang/String;
      //   88: aload_0
      //   89: aconst_null
      //   90: putfield 72	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:mAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
      //   93: aload_0
      //   94: iconst_0
      //   95: putfield 74	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_focusSteamType	I
      //   98: aload_0
      //   99: aload_2
      //   100: putfield 60	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:jdField_b_of_type_ComTencentSharpJniTraeAudioManager	Lcom/tencent/sharp/jni/TraeAudioManager;
      //   103: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
      //   106: lstore_3
      //   107: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   110: ifeq +11 -> 121
      //   113: ldc 88
      //   115: iconst_2
      //   116: ldc 90
      //   118: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   121: aload_0
      //   122: invokevirtual 97	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:start	()V
      //   125: aload_0
      //   126: getfield 56	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   129: astore_1
      //   130: aload_1
      //   131: monitorenter
      //   132: aload_0
      //   133: getfield 56	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   136: iconst_0
      //   137: baload
      //   138: istore 5
      //   140: iload 5
      //   142: ifne +10 -> 152
      //   145: aload_0
      //   146: getfield 56	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   149: invokevirtual 102	java/lang/Object:wait	()V
      //   152: aload_1
      //   153: monitorexit
      //   154: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   157: ifeq +37 -> 194
      //   160: ldc 88
      //   162: iconst_2
      //   163: new 104	java/lang/StringBuilder
      //   166: dup
      //   167: invokespecial 105	java/lang/StringBuilder:<init>	()V
      //   170: ldc 107
      //   172: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
      //   178: lload_3
      //   179: lsub
      //   180: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   183: ldc 116
      //   185: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   188: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   191: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   194: return
      //   195: astore_2
      //   196: aload_1
      //   197: monitorexit
      //   198: aload_2
      //   199: athrow
      //   200: astore_2
      //   201: goto -49 -> 152
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	204	0	this	TraeAudioManagerLooper
      //   0	204	1	this$1	TraeAudioManager
      //   0	204	2	paramTraeAudioManager	TraeAudioManager
      //   106	73	3	l	long
      //   138	3	5	i	int
      // Exception table:
      //   from	to	target	type
      //   132	140	195	finally
      //   145	152	195	finally
      //   152	154	195	finally
      //   196	198	195	finally
      //   145	152	200	java/lang/InterruptedException
    }
    
    int InternalGetStreamType(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalStopRing am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {}
      for (int i = this.jdField_b_of_type_Atan.getStreamType();; i = TraeAudioManager.this._streamType)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i);
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
      }
    }
    
    int InternalNotifyStreamTypeUpdate(int paramInt)
    {
      if (TraeAudioManager.this._context == null) {
        return -1;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
      try
      {
        TraeAudioManager.this._context.sendBroadcast(localIntent);
        return 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "InternalNotifyStreamTypeUpdate e = " + localException);
          }
        }
      }
    }
    
    int InternalSessionGetDeviceList(HashMap<String, Object> paramHashMap)
    {
      Intent localIntent = new Intent();
      Object localObject = TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getSnapParams();
      ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
      String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
      localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
      localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
      localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
      localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
      localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getBluetoothName());
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      return 0;
    }
    
    int InternalStartRing(HashMap<String, Object> paramHashMap)
    {
      long l = jlc.a(paramHashMap);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("InternalStartRing begin, _activeMode[").append(TraeAudioManager.this._activeMode).append("], _am[");
        if (TraeAudioManager.this._am == null) {
          break label99;
        }
      }
      label99:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.w("TraeAudioManager", 1, bool1 + "], seq[" + l + "]");
        if (TraeAudioManager.this._am != null) {
          break;
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {
        ap(l);
      }
      for (;;)
      {
        try
        {
          this._ringSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
          this._ringOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
          this._ringUserdata = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
          int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
          int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
          localObject = (Uri)paramHashMap.get("PARAM_RING_URI");
          String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
          boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
          int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
          boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
          if (TraeAudioManager.this._activeMode != 1) {
            TraeAudioManager.this._activeMode = 2;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
          TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
          this._preRingMode = TraeAudioManager.this._am.getMode();
          paramHashMap = this.jdField_b_of_type_Atan;
          if (TraeAudioManager.this._activeMode == 1)
          {
            bool1 = true;
            bool1 = paramHashMap.a(l, i, j, (Uri)localObject, str, bool2, k, bool3, bool1, TraeAudioManager.this._streamType);
            if (!this.jdField_b_of_type_Atan.hasCall()) {
              requestAudioFocus(this.jdField_b_of_type_Atan.getStreamType());
            }
            InternalNotifyStreamTypeUpdate(this.jdField_b_of_type_Atan.getStreamType());
            if (QLog.isColorLevel()) {
              QLog.w("TraeAudioManager", 1, "InternalStartRing end, Userdata[" + this._ringUserdata + "], dataSource[" + i + "], DurationMS[" + this.jdField_b_of_type_Atan.getDuration() + "], ret[" + bool1 + "], seq[" + l + "]");
            }
            return 0;
          }
        }
        catch (Exception paramHashMap)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "InternalStartRing Exception, seq[" + l + "]", paramHashMap);
          }
          return -1;
        }
        bool1 = false;
      }
    }
    
    int InternalStopRing(HashMap<String, Object> paramHashMap)
    {
      int i = 0;
      long l = jlc.a(paramHashMap);
      QLog.w("TraeAudioManager", 1, "InternalStopRing begin, _activeMode[" + TraeAudioManager.this._activeMode + "], _preRingMode[" + this._preRingMode + "], seq[" + l + "]");
      if ((TraeAudioManager.this._am == null) || (this.jdField_b_of_type_Atan == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalStopRing am==null!!");
        }
        i = -1;
      }
      do
      {
        return i;
        this.jdField_b_of_type_Atan.dN(l);
        if ((!this.jdField_b_of_type_Atan.hasCall()) && (TraeAudioManager.this._activeMode == 2))
        {
          abandonAudioFocus();
          TraeAudioManager.this._activeMode = 0;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 1, "InternalStopRing end, _activeMode[" + TraeAudioManager.this._activeMode + "], _preRingMode[" + this._preRingMode + "], seq[" + l + "]");
      return 0;
    }
    
    int InternalVoicecallPostprocess(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalVoicecallPostprocess am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " not ACTIVE_VOICECALL!!");
        }
        localIntent = new Intent();
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 3);
        return -1;
      }
      TraeAudioManager.this._activeMode = 0;
      abandonAudioFocus();
      Intent localIntent = new Intent();
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    int InternalVoicecallPreprocess(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (paramHashMap == null) {
        return -1;
      }
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalVoicecallPreprocess am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 1)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 2);
        return -1;
      }
      this._voiceCallSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
      this._voiceCallOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
      TraeAudioManager.this._activeMode = 1;
      TraeAudioManager.this.sessionConnectedDev = "DEVICE_NONE";
      TraeAudioManager.this._prevMode = TraeAudioManager.this._am.getMode();
      Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " params.get(PARAM_MODEPOLICY)==null!!");
        }
        TraeAudioManager.this._modePolicy = -1;
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
        }
        localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
        if (localObject != null) {
          break label376;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " params.get(PARAM_STREAMTYPE)==null!!");
        }
        TraeAudioManager.this._streamType = 0;
        label272:
        if ((!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy)) || (TraeAudioManager.this._activeMode == 2) || (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e == null)) {
          break label406;
        }
        if (!TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice().equals("DEVICE_SPEAKERPHONE")) {
          break label390;
        }
        TraeAudioManager.this.InternalSetMode(0);
        requestAudioFocus(3);
      }
      for (;;)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
        TraeAudioManager.this._modePolicy = ((Integer)localObject).intValue();
        break;
        label376:
        TraeAudioManager.this._streamType = ((Integer)localObject).intValue();
        break label272;
        label390:
        TraeAudioManager.this.InternalSetMode(3);
        requestAudioFocus(0);
        continue;
        label406:
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.getCallAudioMode(TraeAudioManager.this._modePolicy));
        requestAudioFocus(TraeAudioManager.this._streamType);
      }
    }
    
    void _init()
    {
      AudioDeviceInterface.LogTraceEntry("");
      try
      {
        TraeAudioManager.this.jdField_a_of_type_Atam = new atam();
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e = new TraeAudioManager.e(TraeAudioManager.this);
        TraeAudioManager._gHostProcessId = Process.myPid();
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d = TraeAudioManager.this.a(TraeAudioManager.this._context, TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
        AudioDeviceInterface.LogTraceExit();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, "======7");
          }
        }
      }
    }
    
    void _post_stopService()
    {
      try
      {
        if (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d != null) {
          TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d.release();
        }
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
          localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
          TraeAudioManager.this._context.registerReceiver(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    void _prev_startService()
    {
      try
      {
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        if (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d == null) {
          TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d = TraeAudioManager.this.a(TraeAudioManager.this._context, TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e);
        }
        TraeAudioManager.this._context.unregisterReceiver(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void aU(Message paramMessage)
    {
      long l;
      do
      {
        try
        {
          HashMap localHashMap = (HashMap)paramMessage.obj;
          l = jlc.a(localHashMap);
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "doHandleMessage, msg[" + paramMessage.what + "], _enabled[" + this._enabled + "], seq[" + l + "]");
          }
          if (paramMessage.what == 32772)
          {
            startService(localHashMap);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject = null;
          }
          if (!this._enabled)
          {
            paramMessage = new Intent();
            TraeAudioManager.this.sendResBroadcast(paramMessage, (HashMap)localObject, 1);
            return;
          }
          switch (paramMessage.what)
          {
          default: 
            return;
          }
        }
        nh(l);
        return;
        InternalSessionGetDeviceList((HashMap)localObject);
        return;
        TraeAudioManager.this.InternalSessionIsDeviceChangabled((HashMap)localObject);
        return;
        TraeAudioManager.this.InternalSessionGetConnectedDevice((HashMap)localObject);
        return;
        TraeAudioManager.this.InternalSessionGetConnectingDevice((HashMap)localObject);
        return;
        InternalVoicecallPreprocess((HashMap)localObject);
        return;
        InternalVoicecallPostprocess((HashMap)localObject);
        return;
        paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
        if (paramMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
      return;
      TraeAudioManager.this._streamType = paramMessage.intValue();
      InternalNotifyStreamTypeUpdate(paramMessage.intValue());
      return;
      InternalStartRing((HashMap)localObject);
      return;
      InternalStopRing((HashMap)localObject);
      return;
      abandonAudioFocus();
      return;
      requestAudioFocus(TraeAudioManager.this._streamType);
      return;
      InternalGetStreamType((HashMap)localObject);
      return;
      TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      return;
      TraeAudioManager.this.a(l, (HashMap)localObject);
      return;
      TraeAudioManager.this.InternalSessionEarAction((HashMap)localObject);
      return;
      paramMessage = TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailabledHighestPriorityDevice();
      String str = TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getConnectedDevice();
      Object localObject = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "doHandleMessage, connectedDev[" + str + "], highestDev[" + paramMessage + "], connectDeviceNameWhenServiceOn[" + (String)localObject + "], seq[" + l + "]");
      }
      if ((localObject != null) && (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getVisible((String)localObject)))
      {
        paramMessage = (Message)localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TraeAudioManager", 1, "doHandleMessage, reset, highestDev[" + (String)localObject + "], seq[" + l + "]");
          paramMessage = (Message)localObject;
        }
      }
      for (;;)
      {
        if (!paramMessage.equals(str))
        {
          TraeAudioManager.this.a(l, paramMessage, null);
          return;
        }
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
        return;
        paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
        if (TraeAudioManager.this.a(l, paramMessage, null) == 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE, connected fail, plugDev[" + paramMessage + "], sessionConnectedDev[" + TraeAudioManager.this.sessionConnectedDev + "], seq[" + l + "]");
        }
        TraeAudioManager.this.a(l, TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailabledHighestPriorityDevice(), null);
        return;
        if (TraeAudioManager.this.a(l, TraeAudioManager.this.sessionConnectedDev, null) == 0) {
          break;
        }
        paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE, connected fail, plugDev[" + paramMessage + "], sessionConnectedDev[" + TraeAudioManager.this.sessionConnectedDev + "], seq[" + l + "]");
        }
        TraeAudioManager.this.a(l, TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailabledHighestPriorityDevice(), null);
        return;
        paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
        if (TraeAudioManager.this.cGx.equals("DEVICE_BLUETOOTHHEADSET"))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_BLUETOOTH_SCO_DISCONNECTED, plugDev[" + paramMessage + "], BTDisConnectSessionConnectedDev[" + TraeAudioManager.this.cGx + "], seq[" + l + "]");
          }
          TraeAudioManager.this.a(l, TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null);
          return;
        }
        if (TraeAudioManager.this.a(l, TraeAudioManager.this.cGx, null) == 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_BLUETOOTH_SCO_DISCONNECTED, connected fail, plugDev[" + paramMessage + "], BTDisConnectSessionConnectedDev[" + TraeAudioManager.this.cGx + "], seq[" + l + "]");
        }
        TraeAudioManager.this.a(l, TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null);
        return;
      }
    }
    
    @TargetApi(8)
    void abandonAudioFocus()
    {
      if (Build.VERSION.SDK_INT <= 8) {}
      while ((TraeAudioManager.this._am == null) || (this.mAudioFocusChangeListener == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "-------abandonAudioFocus _focusSteamType:" + this._focusSteamType);
      }
      TraeAudioManager.this._am.abandonAudioFocus(this.mAudioFocusChangeListener);
      this.mAudioFocusChangeListener = null;
    }
    
    int ap(long paramLong)
    {
      int i = 0;
      Object localObject;
      boolean bool;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("interruptRing begin, _activeMode[").append(TraeAudioManager.this._activeMode).append("], _preRingMode[").append(this._preRingMode).append("], _am[");
        if (TraeAudioManager.this._am != null)
        {
          bool = true;
          QLog.w("TraeAudioManager", 1, bool + "], seq[" + paramLong + "]");
        }
      }
      else
      {
        if (TraeAudioManager.this._am != null) {
          break label116;
        }
        i = -1;
      }
      label116:
      do
      {
        return i;
        bool = false;
        break;
        if (TraeAudioManager.this._activeMode != 2) {
          return -1;
        }
        this.jdField_b_of_type_Atan.dN(paramLong);
        abandonAudioFocus();
        TraeAudioManager.this._activeMode = 0;
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
        ((HashMap)localObject).put("PARAM_OPERATION", this._ringOperation);
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
        jlc.a((HashMap)localObject, paramLong);
        TraeAudioManager.this.sendResBroadcast(localIntent, (HashMap)localObject, 4);
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 1, "interruptRing end, _activeMode[" + TraeAudioManager.this._activeMode + "], seq[" + paramLong + "]");
      return 0;
    }
    
    int interruptVoicecallPostprocess()
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null) {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " am==null!!");
        }
      }
      do
      {
        return -1;
        if (TraeAudioManager.this._activeMode == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, " not ACTIVE_RING!!");
      return -1;
      TraeAudioManager.this._activeMode = 0;
      if (TraeAudioManager.this._prevMode != -1) {
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.this._prevMode);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._voiceCallSessionID));
      localHashMap.put("PARAM_OPERATION", this._voiceCallOperation);
      Intent localIntent = new Intent();
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 6);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    void nh(long paramLong)
    {
      if (AudioHelper.aCz()) {
        QLog.w("TraeAudioManager", 1, "stopService, _enabled[" + this._enabled + "], _activeMode[" + TraeAudioManager.this._activeMode + "], _switchThread[" + TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread + "], seq[" + paramLong + "]");
      }
      if (!this._enabled) {
        return;
      }
      if (TraeAudioManager.this._activeMode == 1) {
        interruptVoicecallPostprocess();
      }
      for (;;)
      {
        if (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread != null)
        {
          TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread.nl(paramLong);
          TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = null;
        }
        if (this.jdField_b_of_type_Atan != null) {
          this.jdField_b_of_type_Atan.dN(paramLong);
        }
        this.jdField_b_of_type_Atan = null;
        this._enabled = false;
        notifyServiceState(this._enabled);
        if ((TraeAudioManager.this._am != null) && (TraeAudioManager.this._context != null)) {}
        try
        {
          TraeAudioManager.this.InternalSetMode(0);
          QLog.w("TraeAudioManager", 2, "NeedForceVolumeType: -1");
          TraeAudioManager.forceVolumeControlStream(TraeAudioManager.this._am, -1);
          label218:
          _post_stopService();
          AudioDeviceInterface.LogTraceExit();
          return;
          if (TraeAudioManager.this._activeMode != 2) {
            continue;
          }
          ap(paramLong);
        }
        catch (Exception localException)
        {
          break label218;
        }
      }
    }
    
    void ni(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "_uninit begin, seq[" + paramLong + "]");
      }
      try
      {
        nh(paramLong);
        if (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d != null) {
          TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d.release();
        }
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$d = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager);
          TraeAudioManager.this._context = null;
        }
        if (TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e != null) {
          TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.clearConfig();
        }
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e = null;
      }
      catch (Exception localException)
      {
        label131:
        break label131;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "_uninit end, seq[" + paramLong + "]");
      }
    }
    
    public void nj(long paramLong)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
      localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
      jlc.a(localHashMap, paramLong);
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 0);
    }
    
    int notifyServiceState(boolean paramBoolean)
    {
      if (TraeAudioManager.this._context == null) {
        return -1;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
      localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
      TraeAudioManager.this._context.sendBroadcast(localIntent);
      return 0;
    }
    
    public void quit()
    {
      AudioDeviceInterface.LogTraceEntry("");
      if (this.mMsgHandler == null) {
        return;
      }
      long l = SystemClock.elapsedRealtime();
      this.mMsgHandler.getLooper().quit();
      synchronized (this._started)
      {
        int i = this._started[0];
        if (i != 1) {}
      }
      try
      {
        this._started.wait(10000L);
        label58:
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l) + "ms");
        }
        this.mMsgHandler = null;
        AudioDeviceInterface.LogTraceExit();
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label58;
      }
    }
    
    @TargetApi(8)
    void requestAudioFocus(int paramInt)
    {
      if (Build.VERSION.SDK_INT <= 8) {}
      do
      {
        do
        {
          do
          {
            return;
          } while (this.mAudioFocusChangeListener != null);
          this.mAudioFocusChangeListener = new atal(this);
        } while (TraeAudioManager.this._am == null);
        int i = TraeAudioManager.this._am.requestAudioFocus(this.mAudioFocusChangeListener, paramInt, 2);
        if ((i != 1) && (QLog.isColorLevel())) {
          QLog.e("TraeAudioManager", 2, "request audio focus fail. " + i + " mode:" + TraeAudioManager.this._am.getMode());
        }
        this._focusSteamType = paramInt;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "-------requestAudioFocus _focusSteamType:" + this._focusSteamType);
    }
    
    public void run()
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "TraeAudioManagerLooper.run begin, seq[" + l + "]");
      }
      Looper.prepare();
      this.mMsgHandler = new atak(this);
      _init();
      synchronized (this._started)
      {
        this._started[0] = true;
        this._started.notify();
        Looper.loop();
        ni(l);
      }
      synchronized (this._started)
      {
        this._started[0] = false;
        this._started.notify();
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "TraeAudioManagerLooper.run end, seq[" + l + "]");
        }
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
    
    public int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
    {
      if (this.mMsgHandler == null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(" fail mMsgHandler==null _enabled:");
        if (this._enabled) {}
        for (paramHashMap = "Y";; paramHashMap = "N")
        {
          AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + TraeAudioManager.this._activeMode + " msg:" + paramInt);
          return -1;
        }
      }
      paramHashMap = Message.obtain(this.mMsgHandler, paramInt, paramHashMap);
      if (this.mMsgHandler.sendMessage(paramHashMap)) {}
      for (paramInt = 0;; paramInt = -1) {
        return paramInt;
      }
    }
    
    void startService(HashMap<String, Object> paramHashMap)
    {
      long l = jlc.a(paramHashMap);
      String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "startService begin, _enabled[" + this._enabled + "], _activeMode[" + TraeAudioManager.this._activeMode + "], seq[" + l + "], cfg[" + str + "]");
      }
      if ((str == null) || (TraeAudioManager.this._context == null)) {}
      do
      {
        do
        {
          return;
        } while ((str.length() <= 0) || ((this._enabled) && (this._lastCfg.equals(str))) || (TraeAudioManager.this._activeMode != 0));
        if (this._enabled) {
          nh(l);
        }
        _prev_startService();
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.clearConfig();
        TraeAudioManager.this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$e.init(str);
        this._lastCfg = str;
        if (TraeAudioManager.this._am != null) {
          this._preServiceMode = TraeAudioManager.this._am.getMode();
        }
        this._enabled = true;
        if (this.jdField_b_of_type_Atan == null) {
          this.jdField_b_of_type_Atan = new atan(TraeAudioManager.this._context, new ataj(this));
        }
        paramHashMap = (String)paramHashMap.get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
        TraeAudioManager.this.aY(l, paramHashMap);
        notifyServiceState(this._enabled);
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 1, "startService end, _enabled[" + this._enabled + "], _activeMode[" + TraeAudioManager.this._activeMode + "], seq[" + l + "]");
    }
  }
  
  class a
    extends TraeAudioManager.d
    implements BluetoothProfile.ServiceListener
  {
    final String TAG = "BluetoohHeadsetCheck";
    BluetoothAdapter _adapter = null;
    Context _ctx = null;
    BluetoothProfile _profile = null;
    TraeAudioManager.e b = null;
    
    a()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BluetoohHeadsetCheck", 2, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
      paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
      paramIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      long l = jlc.a(paramIntent);
      int i;
      if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 1, "_onReceive.ACTION_AUDIO_STATE_CHANGED, state[" + i + "], bluetoothState[" + TraeAudioManager.a(TraeAudioManager.this) + "], seq[" + l + "]");
        }
        if (i == 12) {
          if (TraeAudioManager.a(TraeAudioManager.this) == 6) {
            QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is now connected, SCO_CONNECTED");
          }
        }
      }
      label124:
      int j;
      label460:
      do
      {
        do
        {
          do
          {
            do
            {
              TraeAudioManager.a(TraeAudioManager.this, 7);
              break label124;
              break label124;
              do
              {
                do
                {
                  return;
                } while ((i == 11) || (i != 10));
                QLog.w("TRAE", 2, "ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is STATE_AUDIO_DISCONNECTED");
                return;
                if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
                  break;
                }
                switch (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1))
                {
                case 1: 
                default: 
                  return;
                case 0: 
                  TraeAudioManager.a(TraeAudioManager.this, 3);
                  this.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
                }
              } while (!QLog.isColorLevel());
              QLog.w("TRAE", 2, "jeringtest BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_DISCONNECTED");
              return;
              TraeAudioManager.a(TraeAudioManager.this, 4);
              this.b.setVisible("DEVICE_BLUETOOTHHEADSET", true);
            } while (!QLog.isColorLevel());
            QLog.w("TRAE", 2, "jeringtest  BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_CONNECTED");
            return;
            if (!"android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
              break;
            }
            i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
            paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (QLog.isColorLevel()) {
              QLog.w("BluetoohHeadsetCheck", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(i));
            }
            if (QLog.isColorLevel()) {
              QLog.w("BluetoohHeadsetCheck", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(j));
            }
            Object localObject;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
              if (paramIntent != null)
              {
                paramContext = paramIntent.getName();
                QLog.w("BluetoohHeadsetCheck", 2, paramContext);
              }
            }
            else
            {
              if (i != 2) {
                continue;
              }
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder().append("   dev:");
                if (paramIntent == null) {
                  break label519;
                }
                paramContext = paramIntent.getName();
                QLog.w("BluetoohHeadsetCheck", 2, paramContext + " connected,start sco...");
              }
              this.b.setVisible("DEVICE_BLUETOOTHHEADSET", true);
              localObject = this.b;
              if (paramIntent == null) {
                break label525;
              }
            }
            for (paramContext = paramIntent.getName();; paramContext = "unkown")
            {
              ((TraeAudioManager.e)localObject).setBluetoothName(paramContext);
              return;
              paramContext = " ";
              break;
              paramContext = "null";
              break label460;
            }
          } while (i != 0);
          this.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          return;
        } while (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()));
        i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
        paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
        }
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(i) + "  Bluetooth visible:" + this.b.getVisible("DEVICE_BLUETOOTHHEADSET"));
        }
      } while (!QLog.isColorLevel());
      label519:
      label525:
      QLog.w("BluetoohHeadsetCheck", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(j));
    }
    
    public boolean a(Context paramContext, TraeAudioManager.e parame)
    {
      AudioDeviceInterface.LogTraceEntry("");
      if ((paramContext == null) || (parame == null)) {
        if (QLog.isColorLevel()) {
          QLog.e("BluetoohHeadsetCheck", 2, " err ctx==null||_devCfg==null");
        }
      }
      do
      {
        do
        {
          return false;
          this._ctx = paramContext;
          this.b = parame;
          this._adapter = BluetoothAdapter.getDefaultAdapter();
          if (this._adapter != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("BluetoohHeadsetCheck", 2, " err getDefaultAdapter fail!");
        return false;
        if ((!this._adapter.isEnabled()) || (this._profile != null) || (this._adapter.getProfileProxy(this._ctx, this, 1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("BluetoohHeadsetCheck", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
      return false;
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheck";
    }
    
    public boolean isConnected()
    {
      if (this._profile != null) {
        try
        {
          List localList = this._profile.getConnectedDevices();
          if (localList == null) {
            return false;
          }
          int i = localList.size();
          if (i > 0) {
            return true;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BluetoohHeadsetCheck", 2, " isConnected e = " + localException);
          }
        }
      }
      return false;
    }
    
    public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
    {
      if (paramInt == 1)
      {
        if ((this._profile != null) && (this._profile != paramBluetoothProfile))
        {
          if (QLog.isColorLevel()) {
            QLog.w("BluetoohHeadsetCheck", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this._profile);
          }
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profile = paramBluetoothProfile;
        ThreadManager.post(new TraeAudioManager.BluetoohHeadsetCheck.1(this), 5, null, false);
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void onServiceDisconnected(int paramInt)
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt);
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
        }
        if (isConnected()) {
          TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
        }
        if (this._profile != null)
        {
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void release()
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
      try
      {
        if (this._adapter != null)
        {
          if (this._profile != null) {
            this._adapter.closeProfileProxy(1, this._profile);
          }
          this._profile = null;
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("BluetoohHeadsetCheck", 2, " closeProfileProxy:e:" + localException.getMessage());
          }
        }
      }
    }
  }
  
  class b
    extends TraeAudioManager.d
  {
    b()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter) {}
    
    void _onReceive(Context paramContext, Intent paramIntent) {}
    
    public boolean a(Context paramContext, TraeAudioManager.e parame)
    {
      return true;
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFake";
    }
    
    public boolean isConnected()
    {
      return false;
    }
    
    public void release() {}
  }
  
  class bluetoothHeadsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    bluetoothHeadsetSwitchThread(long paramLong)
    {
      super(paramLong);
    }
    
    public void _quit()
    {
      if (TraeAudioManager.this._am == null) {
        return;
      }
      _stopBluetoothSco();
    }
    
    public void _run()
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, "bluetoothHeadsetSwitchThread start connect 1000.,sBluetoothDelayTime: " + TraeAudioManager.pW);
        }
        Thread.sleep(1000L);
      }
      catch (InterruptedException localInterruptedException4)
      {
        for (;;)
        {
          int i;
          int n;
          label371:
          continue;
          label437:
          label444:
          int j = n;
          continue;
          int m = 0;
          continue;
          int k = 0;
        }
      }
      if (TraeAudioManager.a(TraeAudioManager.this) == 7)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread, WIREDHEADSET plugout, bluetoothState == Bluetooth_State.SCO_CONNECTED force to HEADSET_AVAILABLE, reconnect");
        }
        TraeAudioManager.a(TraeAudioManager.this, 4);
      }
      i = 0;
      while (TraeAudioManager.a(TraeAudioManager.this) != 4)
      {
        j = i + 1;
        if (i >= 10) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread waiting Bluetooth_State HEADSET_AVAILABLE, " + TraeAudioManager.a(TraeAudioManager.this));
        }
        try
        {
          Thread.sleep(1000L);
          i = j;
        }
        catch (InterruptedException localInterruptedException1)
        {
          i = j;
        }
      }
      if (TraeAudioManager.a(TraeAudioManager.this) != 4)
      {
        k = 1;
        if ((k == 0) && (this._running == true))
        {
          TraeAudioManager.a(TraeAudioManager.this, 6);
          _startBluetoothSco();
          QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread _startBluetoothSco");
          m = 1;
          i = 0;
          j = 0;
          for (;;)
          {
            String str;
            if (this._running == true)
            {
              n = j + 1;
              if ((j < 5) && (k == 0))
              {
                if (QLog.isColorLevel())
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("bluetoothHeadsetSwitchThread ");
                  localStringBuilder.append("i:");
                  localStringBuilder.append(n);
                  localStringBuilder.append(" sco:");
                  if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                    break label437;
                  }
                  str = "Y";
                  localStringBuilder.append(str);
                  localStringBuilder.append(" :");
                  localStringBuilder.append(TraeAudioManager.this.a.getBluetoothName());
                  localStringBuilder.append("\n");
                  QLog.w(this.TAG, 2, localStringBuilder.toString());
                }
                if (TraeAudioManager.a(TraeAudioManager.this) != 7) {
                  break label444;
                }
                QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread bluetoothState ==  Bluetooth_State.SCO_CONNECTED 1");
                updateStatus();
              }
            }
            do
            {
              for (;;)
              {
                if (TraeAudioManager.a(TraeAudioManager.this) != 7)
                {
                  if ((QLog.isColorLevel()) && (k == 0)) {
                    QLog.e(this.TAG, 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
                  }
                  TraeAudioManager.this.a.setVisible(getDeviceName(), false);
                  processDeviceConnectRes(10);
                  TraeAudioManager.this.ng(this.mSeq);
                }
                return;
                str = "N";
                break;
                try
                {
                  Thread.sleep(3000L);
                  if (TraeAudioManager.a(TraeAudioManager.this) == 7)
                  {
                    QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread bluetoothState ==  Bluetooth_State.SCO_CONNECTED 2");
                    updateStatus();
                  }
                }
                catch (InterruptedException localInterruptedException2)
                {
                  for (;;)
                  {
                    QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread InterruptedException 1");
                    i = 1;
                  }
                }
              }
            } while (i != 0);
            if (m == 1)
            {
              _stopBluetoothSco();
              try
              {
                Thread.sleep(1000L);
                if (i != 0) {
                  break label371;
                }
                _startBluetoothSco();
                QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread retry start sco");
                j = n;
              }
              catch (InterruptedException localInterruptedException3)
              {
                for (;;)
                {
                  QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread InterruptedException 2");
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    
    void _startBluetoothSco()
    {
      try
      {
        TraeAudioManager.this._am.setBluetoothScoOn(true);
        if (Build.VERSION.SDK_INT > 8) {
          TraeAudioManager.this._am.startBluetoothSco();
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    void _stopBluetoothSco()
    {
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.stopBluetoothSco();
      }
      TraeAudioManager.this._am.setBluetoothScoOn(false);
    }
    
    public String getDeviceName()
    {
      return "DEVICE_BLUETOOTHHEADSET";
    }
  }
  
  class c
    extends TraeAudioManager.d
  {
    Class<?> BluetoothHeadsetClass = null;
    Object BluetoothHeadsetObj = null;
    Class<?> ListenerClass = null;
    Context _ctx = null;
    TraeAudioManager.e b = null;
    Method getCurrentHeadsetMethod = null;
    
    c()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      int k;
      if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "++ AUDIO_STATE_CHANGED|  STATE " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       PREVIOUS_STATE " + j);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       AUDIO_STATE " + k);
        }
        if (k != 2) {}
      }
      do
      {
        do
        {
          this.b.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          do
          {
            return;
          } while (k != 0);
          this.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          return;
        } while (!"android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()));
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "++ STATE_CHANGED|  STATE " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       PREVIOUS_STATE " + j);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       AUDIO_STATE " + k);
        }
        if (k == 2)
        {
          this.b.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          return;
        }
      } while (k != 0);
      this.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
    }
    
    public boolean a(Context paramContext, TraeAudioManager.e parame)
    {
      AudioDeviceInterface.LogTraceEntry("");
      this._ctx = paramContext;
      this.b = parame;
      if ((this._ctx == null) || (this.b == null)) {}
      for (;;)
      {
        return false;
        try
        {
          this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
          if (this.BluetoothHeadsetClass == null) {
            continue;
          }
        }
        catch (Exception parame)
        {
          try
          {
            this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
          }
          catch (Exception parame)
          {
            try
            {
              this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
              if (this.getCurrentHeadsetMethod == null) {
                continue;
              }
            }
            catch (NoSuchMethodException parame)
            {
              try
              {
                do
                {
                  for (;;)
                  {
                    this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
                    if (this.BluetoothHeadsetObj == null) {
                      break;
                    }
                    this.b.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
                    if (!isConnected()) {
                      break label337;
                    }
                    this.b.setVisible("DEVICE_BLUETOOTHHEADSET", true);
                    TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
                    AudioDeviceInterface.LogTraceExit();
                    return true;
                    parame = parame;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset class not found");
                      continue;
                      parame = parame;
                      if (QLog.isColorLevel()) {
                        QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + parame);
                      }
                    }
                  }
                  parame = parame;
                } while (!QLog.isColorLevel());
                QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
              }
              catch (IllegalArgumentException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                  }
                }
              }
              catch (InstantiationException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                  }
                }
              }
              catch (IllegalAccessException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                  }
                }
              }
              catch (InvocationTargetException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                  }
                }
              }
              catch (NoSuchMethodException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                    continue;
                    label337:
                    this.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFor2x";
    }
    
    public boolean isConnected()
    {
      String str4 = null;
      if ((this.getCurrentHeadsetMethod == null) || (this.getCurrentHeadsetMethod == null)) {
        return false;
      }
      try
      {
        Object localObject = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
          if (localObject != null)
          {
            str4 = " Y";
            QLog.w("TraeAudioManager", 2, str4);
          }
        }
        else
        {
          if (localObject == null) {
            break label152;
          }
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          String str1 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
            str1 = str4;
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          String str2 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
            str2 = str4;
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          String str3 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
            str3 = str4;
            continue;
            str4 = "N";
          }
        }
      }
      label152:
      return false;
    }
    
    public void release()
    {
      AudioDeviceInterface.LogTraceEntry("");
      if (this.BluetoothHeadsetObj == null) {}
      for (;;)
      {
        return;
        try
        {
          localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
          if (localMethod == null) {
            continue;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            Method localMethod;
            localMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
            label44:
            this.BluetoothHeadsetClass = null;
            this.ListenerClass = null;
            this.BluetoothHeadsetObj = null;
            this.getCurrentHeadsetMethod = null;
            AudioDeviceInterface.LogTraceExit();
            return;
            localNoSuchMethodException = localNoSuchMethodException;
            if (QLog.isColorLevel()) {
              QLog.e("TraeAudioManager", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
            }
            Object localObject = null;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            break label44;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            break label44;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            break label44;
          }
        }
      }
    }
  }
  
  abstract class d
  {
    d() {}
    
    abstract void _addAction(IntentFilter paramIntentFilter);
    
    abstract void _onReceive(Context paramContext, Intent paramIntent);
    
    public void a(Context paramContext, Intent paramIntent, TraeAudioManager.e parame)
    {
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + getBTActionStateChangedExtraString(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + getBTActionStateChangedExtraString(j));
        }
        if (i == 10)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, "    BT off");
          }
          parame.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        }
        while ((i != 12) || (!QLog.isColorLevel())) {
          return;
        }
        QLog.w("TraeAudioManager", 2, "BT OFF-->ON,Visiable it...");
        return;
      }
      _onReceive(paramContext, paramIntent);
    }
    
    public abstract boolean a(Context paramContext, TraeAudioManager.e parame);
    
    public void addAction(IntentFilter paramIntentFilter)
    {
      paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
      _addAction(paramIntentFilter);
    }
    
    String getBTActionStateChangedExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_OFF";
        continue;
        str = "STATE_TURNING_ON";
        continue;
        str = "STATE_ON";
        continue;
        str = "STATE_TURNING_OFF";
      }
    }
    
    String getBTAdapterConnectionState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_DISCONNECTED";
        continue;
        str = "STATE_CONNECTING";
        continue;
        str = "STATE_CONNECTED";
        continue;
        str = "STATE_DISCONNECTING";
      }
    }
    
    String getSCOAudioStateExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "SCO_AUDIO_STATE_DISCONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTING";
        continue;
        str = "SCO_AUDIO_STATE_ERROR";
      }
    }
    
    public abstract String interfaceDesc();
    
    public abstract boolean isConnected();
    
    public abstract void release();
  }
  
  class e
  {
    String _bluetoothDevName = "unknow";
    String connectedDevice = "DEVICE_NONE";
    String connectingDevice = "DEVICE_NONE";
    HashMap<String, a> deviceConfigs = new HashMap();
    ReentrantLock mLock = new ReentrantLock();
    String prevConnectedDevice = "DEVICE_NONE";
    boolean visiableUpdate = false;
    
    public e() {}
    
    boolean _addConfig(String paramString, int paramInt)
    {
      AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
      a locala = new a();
      if (locala.init(paramString, paramInt)) {
        if (this.deviceConfigs.containsKey(paramString)) {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "err dev exist!");
          }
        }
      }
      while (!QLog.isColorLevel())
      {
        return false;
        this.deviceConfigs.put(paramString, locala);
        this.visiableUpdate = true;
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, " n" + getDeviceNumber() + " 0:" + getDeviceName(0));
        }
        AudioDeviceInterface.LogTraceExit();
        return true;
      }
      QLog.e("TraeAudioManager", 2, " err dev init!");
      return false;
    }
    
    ArrayList<String> _getAvailableDeviceList()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator.next()).getValue();
        if ((locala != null) && (locala.getVisible()) && (locala.aIW())) {
          localArrayList.add(locala.getDeviceName());
        }
      }
      return localArrayList;
    }
    
    String _getConnectedDevice()
    {
      a locala = (a)this.deviceConfigs.get(this.connectedDevice);
      if ((locala != null) && (locala.getVisible())) {
        return this.connectedDevice;
      }
      return "DEVICE_NONE";
    }
    
    String _getPrevConnectedDevice()
    {
      a locala = (a)this.deviceConfigs.get(this.prevConnectedDevice);
      if ((locala != null) && (locala.getVisible())) {
        return this.prevConnectedDevice;
      }
      return "DEVICE_NONE";
    }
    
    public void clearConfig()
    {
      this.mLock.lock();
      this.deviceConfigs.clear();
      this.prevConnectedDevice = "DEVICE_NONE";
      this.connectedDevice = "DEVICE_NONE";
      this.connectingDevice = "DEVICE_NONE";
      this.mLock.unlock();
    }
    
    public ArrayList<String> getAvailableDeviceList()
    {
      new ArrayList();
      this.mLock.lock();
      ArrayList localArrayList = _getAvailableDeviceList();
      this.mLock.unlock();
      return localArrayList;
    }
    
    public String getAvailabledHighestPriorityDevice()
    {
      Object localObject1 = null;
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        a locala = (a)((Map.Entry)localObject2).getValue();
        if ((locala != null) && (locala.getVisible()) && (locala.aIW()))
        {
          if (localObject1 == null) {
            localObject2 = locala;
          }
          for (;;)
          {
            localObject1 = localObject2;
            break;
            localObject2 = locala;
            if (locala.getPriority() < localObject1.getPriority()) {
              localObject2 = localObject1;
            }
          }
        }
      }
      this.mLock.unlock();
      if (localObject1 != null) {
        return localObject1.getDeviceName();
      }
      return "DEVICE_SPEAKERPHONE";
    }
    
    public String getAvailabledHighestPriorityDevice(String paramString)
    {
      Object localObject1 = null;
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        a locala = (a)((Map.Entry)localObject2).getValue();
        if ((locala != null) && (locala.getVisible()) && (!locala.getDeviceName().equals(paramString)))
        {
          if (localObject1 == null) {
            localObject2 = locala;
          }
          for (;;)
          {
            localObject1 = localObject2;
            break;
            localObject2 = locala;
            if (locala.getPriority() < localObject1.getPriority()) {
              localObject2 = localObject1;
            }
          }
        }
      }
      this.mLock.unlock();
      if (localObject1 != null) {
        return localObject1.getDeviceName();
      }
      return "DEVICE_SPEAKERPHONE";
    }
    
    public String getBluetoothName()
    {
      return this._bluetoothDevName;
    }
    
    public String getConnectedDevice()
    {
      this.mLock.lock();
      String str = _getConnectedDevice();
      this.mLock.unlock();
      return str;
    }
    
    public String getConnectingDevice()
    {
      this.mLock.lock();
      Object localObject = (a)this.deviceConfigs.get(this.connectingDevice);
      if ((localObject != null) && (((a)localObject).getVisible())) {}
      for (localObject = this.connectingDevice;; localObject = null)
      {
        this.mLock.unlock();
        return localObject;
      }
    }
    
    public String getDeviceName(int paramInt)
    {
      this.mLock.lock();
      Object localObject = this.deviceConfigs.entrySet().iterator();
      int i = 0;
      Map.Entry localEntry;
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        if (i != paramInt) {}
      }
      for (localObject = (a)localEntry.getValue();; localObject = null)
      {
        if (localObject != null) {}
        for (localObject = ((a)localObject).getDeviceName();; localObject = "DEVICE_NONE")
        {
          this.mLock.unlock();
          return localObject;
          i += 1;
          break;
        }
      }
    }
    
    public int getDeviceNumber()
    {
      this.mLock.lock();
      int i = this.deviceConfigs.size();
      this.mLock.unlock();
      return i;
    }
    
    public String getPrevConnectedDevice()
    {
      this.mLock.lock();
      String str = _getPrevConnectedDevice();
      this.mLock.unlock();
      return str;
    }
    
    public int getPriority(String paramString)
    {
      this.mLock.lock();
      paramString = (a)this.deviceConfigs.get(paramString);
      if (paramString != null) {}
      for (int i = paramString.getPriority();; i = -1)
      {
        this.mLock.unlock();
        return i;
      }
    }
    
    public HashMap<String, Object> getSnapParams()
    {
      HashMap localHashMap = new HashMap();
      this.mLock.lock();
      localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", _getAvailableDeviceList());
      localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", _getConnectedDevice());
      localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", _getPrevConnectedDevice());
      this.mLock.unlock();
      return localHashMap;
    }
    
    public boolean getVisiableUpdateFlag()
    {
      this.mLock.lock();
      boolean bool = this.visiableUpdate;
      this.mLock.unlock();
      return bool;
    }
    
    public boolean getVisible(String paramString)
    {
      this.mLock.lock();
      paramString = (a)this.deviceConfigs.get(paramString);
      if (paramString != null) {}
      for (boolean bool = paramString.getVisible();; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public boolean init(String paramString)
    {
      AudioDeviceInterface.LogTraceEntry(" strConfigs:" + paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {}
      do
      {
        String str;
        do
        {
          return false;
          str = paramString.replace("\n", "").replace("\r", "");
        } while ((str == null) || (str.length() <= 0));
        paramString = str;
        if (str.indexOf(";") < 0) {
          paramString = str + ";";
        }
        paramString = paramString.split(";");
      } while ((paramString == null) || (1 > paramString.length));
      this.mLock.lock();
      int i = 0;
      while (i < paramString.length)
      {
        _addConfig(paramString[i], i);
        i += 1;
      }
      this.mLock.unlock();
      TraeAudioManager.this.printDevices();
      return true;
    }
    
    public void resetVisiableUpdateFlag()
    {
      this.mLock.lock();
      this.visiableUpdate = false;
      this.mLock.unlock();
    }
    
    public void setBluetoothName(String paramString)
    {
      if (paramString == null)
      {
        this._bluetoothDevName = "unknow";
        return;
      }
      if (paramString.isEmpty())
      {
        this._bluetoothDevName = "unknow";
        return;
      }
      this._bluetoothDevName = paramString;
    }
    
    public boolean setConnected(String paramString)
    {
      this.mLock.lock();
      a locala = (a)this.deviceConfigs.get(paramString);
      if ((locala != null) && (locala.getVisible()))
      {
        if ((this.connectedDevice != null) && (!this.connectedDevice.equals(paramString))) {
          this.prevConnectedDevice = this.connectedDevice;
        }
        this.connectedDevice = paramString;
        this.connectingDevice = "";
      }
      for (boolean bool = true;; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public boolean setConnecting(String paramString)
    {
      this.mLock.lock();
      a locala = (a)this.deviceConfigs.get(paramString);
      if ((locala != null) && (locala.getVisible())) {
        this.connectingDevice = paramString;
      }
      for (boolean bool = true;; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public boolean setVisible(String paramString, boolean paramBoolean)
    {
      this.mLock.lock();
      Object localObject = (a)this.deviceConfigs.get(paramString);
      if ((localObject != null) && (((a)localObject).getVisible() != paramBoolean))
      {
        ((a)localObject).setVisible(paramBoolean);
        ((a)localObject).Vk(paramBoolean);
        this.visiableUpdate = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" ++setVisible:").append(paramString);
          if (!paramBoolean) {
            break label103;
          }
          paramString = " Y";
          QLog.w("TraeAudioManager", 2, paramString);
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.mLock.unlock();
        return paramBoolean;
        label103:
        paramString = " N";
        break;
      }
    }
    
    public class a
    {
      String deviceName = "DEVICE_NONE";
      boolean dgU = false;
      int priority = 0;
      boolean visible = false;
      
      public a() {}
      
      public void Vk(boolean paramBoolean)
      {
        this.dgU = paramBoolean;
      }
      
      public boolean aIW()
      {
        return this.dgU;
      }
      
      public String getDeviceName()
      {
        return this.deviceName;
      }
      
      public int getPriority()
      {
        return this.priority;
      }
      
      public boolean getVisible()
      {
        return this.visible;
      }
      
      public boolean init(String paramString, int paramInt)
      {
        if ((paramString == null) || (paramString.length() <= 0)) {}
        while (TraeAudioManager.checkDevName(paramString) != true) {
          return false;
        }
        this.deviceName = paramString;
        this.priority = paramInt;
        return true;
      }
      
      public void setVisible(boolean paramBoolean)
      {
        this.visible = paramBoolean;
      }
    }
  }
  
  class earphoneSwitchThread
    extends TraeAudioManager.switchThread
  {
    earphoneSwitchThread(long paramLong)
    {
      super(paramLong);
    }
    
    public void _quit() {}
    
    public void _run()
    {
      TraeAudioManager.this.a(this.mSeq, TraeAudioManager.this._context, false);
      updateStatus();
      int i = 0;
      for (;;)
      {
        if (this._running == true)
        {
          if (TraeAudioManager.a(TraeAudioManager.this)) {
            TraeAudioManager.this.a(this.mSeq, TraeAudioManager.this._context, false);
          }
          long l;
          if (i < 5) {
            l = 1000L;
          }
          try
          {
            for (;;)
            {
              Thread.sleep(l);
              label77:
              i += 1;
              break;
              l = 4000L;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            break label77;
          }
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_EARPHONE";
    }
  }
  
  class headsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    headsetSwitchThread(long paramLong)
    {
      super(paramLong);
    }
    
    public void _quit() {}
    
    public void _run()
    {
      TraeAudioManager.this.a(this.mSeq, TraeAudioManager.this._context, false);
      TraeAudioManager.this._am.setWiredHeadsetOn(true);
      updateStatus();
      int i = 0;
      for (;;)
      {
        if (this._running == true)
        {
          if (TraeAudioManager.a(TraeAudioManager.this)) {
            TraeAudioManager.this.a(this.mSeq, TraeAudioManager.this._context, false);
          }
          long l;
          if (i < 5) {
            l = 1000L;
          }
          try
          {
            for (;;)
            {
              Thread.sleep(l);
              i += 1;
              break;
              l = 4000L;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              igd.aL(this.TAG, localInterruptedException.getMessage());
            }
          }
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_WIREDHEADSET";
    }
  }
  
  class speakerSwitchThread
    extends TraeAudioManager.switchThread
  {
    speakerSwitchThread(long paramLong)
    {
      super(paramLong);
    }
    
    public void _quit() {}
    
    public void _run()
    {
      int i = 0;
      TraeAudioManager.this.a(this.mSeq, TraeAudioManager.this._context, true);
      updateStatus();
      for (;;)
      {
        if (this._running)
        {
          if (TraeAudioManager.a(TraeAudioManager.this) == true) {
            break label126;
          }
          if ((this.dgV) && (i > 4))
          {
            iiv localiiv = VideoController.a().b();
            if (!localiiv.QB) {
              QLog.w(this.TAG, 1, "_run, 不需要打开扬声器, sessionInfo[" + localiiv + "]");
            }
          }
        }
        else
        {
          return;
        }
        TraeAudioManager.this.a(this.mSeq, TraeAudioManager.this._context, true);
        label126:
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label139:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label139;
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_SPEAKERPHONE";
    }
  }
  
  abstract class switchThread
    extends Thread
  {
    final String TAG;
    boolean[] _exited = { false };
    HashMap<String, Object> _params = null;
    boolean _running = true;
    boolean dgV = false;
    final long mSeq;
    
    switchThread(long paramLong)
    {
      this.TAG = (getClass().getSimpleName() + "_" + paramLong);
      this.mSeq = paramLong;
      this.dgV = BaseApplicationImpl.processName.endsWith(":video");
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "switchThread.init");
      }
    }
    
    public abstract void _quit();
    
    public abstract void _run();
    
    public abstract String getDeviceName();
    
    public void nl(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "quit.begin, _running[" + this._running + "], cur_seq[" + this.mSeq + "], new_seq[" + paramLong + "]");
      }
      this._running = false;
      interrupt();
      _quit();
      synchronized (this._exited)
      {
        int i = this._exited[0];
        if (i != 0) {}
      }
      try
      {
        this._exited.wait();
        label102:
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 1, "quit.end, cur_seq[" + this.mSeq + "], new_seq[" + paramLong + "]");
        }
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label102;
      }
    }
    
    void processDeviceConnectRes(int paramInt)
    {
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      AudioDeviceInterface.LogTraceEntry(getDeviceName() + " err:" + paramInt + " ConnectedDevice: " + TraeAudioManager.this.a.getConnectedDevice());
      if (this._params == null) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      do
      {
        return;
        TraeAudioManager.this.sessionConnectedDev = TraeAudioManager.this.a.getConnectedDevice();
        localObject = (Long)this._params.get("PARAM_SESSIONID");
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, " sessonID:" + localObject + "sessionConnectedDev: " + TraeAudioManager.this.sessionConnectedDev);
        }
        if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
          break;
        }
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      } while (!QLog.isColorLevel());
      QLog.w(this.TAG, 2, "processDeviceConnectRes sid null,don't send res");
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this._params.get("PARAM_DEVICE"));
      if (TraeAudioManager.this.sendResBroadcast((Intent)localObject, this._params, paramInt) == 0) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "run begin, seq[" + this.mSeq + "], _running[" + this._running + "]");
      }
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      _run();
      synchronized (this._exited)
      {
        this._exited[0] = true;
        this._exited.notify();
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 1, "run end, seq[" + this.mSeq + "]");
        }
        return;
      }
    }
    
    public void setDeviceConnectParam(HashMap<String, Object> paramHashMap)
    {
      this._params = paramHashMap;
    }
    
    public void start(long paramLong)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(this.TAG, 1, "switchThread start, [" + getClass().getSimpleName() + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        }
        super.start();
        return;
      }
      finally {}
    }
    
    public String toString()
    {
      return this.TAG;
    }
    
    void updateStatus()
    {
      TraeAudioManager.this.a.setConnected(getDeviceName());
      processDeviceConnectRes(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */