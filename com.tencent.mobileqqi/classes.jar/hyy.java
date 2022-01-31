import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import com.tencent.sharp.jni.TraeAudioSessionHost;
import com.tencent.sharp.jni.TraeMediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;

public class hyy
  extends Thread
{
  public static final int a = 32768;
  public static final int b = 32772;
  public static final int c = 32773;
  public static final int d = 32774;
  public static final int e = 32775;
  public static final int f = 32776;
  public static final int g = 32777;
  public static final int h = 32778;
  public static final int i = 32779;
  public static final int j = 32780;
  public static final int k = 32781;
  public static final int l = 32782;
  public static final int m = 32783;
  public static final int n = 32784;
  public static final int o = 32785;
  public static final int p = 32786;
  public static final int q = 32787;
  public static final int r = 32788;
  long jdField_a_of_type_Long = -1L;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
  TraeMediaPlayer jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  final boolean[] jdField_a_of_type_ArrayOfBoolean = { false };
  long jdField_b_of_type_Long = -1L;
  String jdField_b_of_type_JavaLangString = "";
  String c = "";
  String d = "";
  int s = 0;
  int t = 0;
  int u = 0;
  
  public hyy(TraeAudioManager arg1, TraeAudioManager paramTraeAudioManager2)
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager = paramTraeAudioManager2;
    long l1 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "TraeAudioManagerLooper start...");
    }
    start();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i1 = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i1 != 0) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait();
      label152:
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  start used:" + (SystemClock.elapsedRealtime() - l1) + "ms");
      }
      return;
      paramTraeAudioManager2 = finally;
      throw paramTraeAudioManager2;
    }
    catch (InterruptedException paramTraeAudioManager2)
    {
      break label152;
    }
  }
  
  int a()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
    return -1;
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w = 0;
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.x != -1) {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.x);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("PARAM_OPERATION", this.d);
    Intent localIntent = new Intent();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, localHashMap, 6);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int a(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
    localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" fail mMsgHandler==null _enabled:");
      if (this.jdField_a_of_type_Boolean) {}
      for (paramHashMap = "Y";; paramHashMap = "N")
      {
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w + " msg:" + paramInt);
        return -1;
      }
    }
    paramHashMap = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramHashMap);
    if (this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramHashMap)) {}
    for (paramInt = 0;; paramInt = -1) {
      return paramInt;
    }
  }
  
  int a(HashMap paramHashMap)
  {
    Intent localIntent = new Intent();
    Object localObject = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a());
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
    localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsHandler.getLooper().quit();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i1 = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i1 != 1) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait(10000L);
      label58:
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l1) + "ms");
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
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
  void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener != null);
        this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new hzb(this);
      } while (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null);
      int i1 = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, paramInt, 1);
      if ((i1 != 1) && (QLog.isColorLevel())) {
        QLog.e("TRAE", 2, "request audio focus fail. " + i1 + " mode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode());
      }
      this.u = paramInt;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "-------requestAudioFocus _focusSteamType:" + this.u);
  }
  
  void a(HashMap paramHashMap)
  {
    String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
    StringBuilder localStringBuilder = new StringBuilder().append(" _enabled:");
    if (this.jdField_a_of_type_Boolean)
    {
      paramHashMap = "Y";
      AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w + " cfg:" + str);
      if ((str != null) && (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)) {
        break label92;
      }
    }
    label92:
    while ((str.length() <= 0) || ((this.jdField_a_of_type_Boolean) && (this.c.equals(str))) || (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w != 0))
    {
      return;
      paramHashMap = "N";
      break;
    }
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    d();
    paramHashMap = (AudioManager)this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str);
    this.c = str;
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.s = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = new TraeMediaPlayer(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, new hyz(this));
    }
    a(this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.b();
    AudioDeviceInterface.LogTraceExit();
  }
  
  int b()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w + " _preRingMode:" + this.t);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " interruptRing am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
    return -1;
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.t);
    g();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("PARAM_OPERATION", this.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, localHashMap, 4);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int b(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w);
    if (paramHashMap == null) {
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 1)
    {
      localObject = new Intent();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a((Intent)localObject, paramHashMap, 2);
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 2)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
      ((HashMap)localObject).put("PARAM_OPERATION", this.jdField_a_of_type_JavaLangString);
      e((HashMap)localObject);
    }
    this.jdField_b_of_type_Long = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this.d = ((String)paramHashMap.get("PARAM_OPERATION"));
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w = 1;
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.x = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.z = -1;
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  _modePolicy:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.z);
      }
      localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
      if (localObject != null) {
        break label377;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
      }
    }
    label377:
    for (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.y = 0;; this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.y = ((Integer)localObject).intValue())
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(TraeAudioManager.c(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.z));
      a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.y);
      localObject = new Intent();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a((Intent)localObject, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.z = ((Integer)localObject).intValue();
      break;
    }
  }
  
  void b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" _enabled:");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "Y";; str = "N")
    {
      AudioDeviceInterface.LogTraceEntry(str + " activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w);
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 1) {
      a();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hzg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "_switchThread:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hzg.a());
        }
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hzg.f();
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hzg = null;
      }
      if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Boolean);
      if ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)) {}
      try
      {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.s);
        label213:
        e();
        AudioDeviceInterface.LogTraceExit();
        return;
        if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w != 2) {
          continue;
        }
        b();
      }
      catch (Exception localException)
      {
        break label213;
      }
    }
  }
  
  int c(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
      }
      localIntent = new Intent();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 3);
      return -1;
    }
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w = 0;
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.x != -1) {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.x);
    }
    g();
    Intent localIntent = new Intent();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void c()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioSessionHost = new TraeAudioSessionHost();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = new TraeAudioManager.DeviceConfigManager(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager);
      TraeAudioManager.A = Process.myPid();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "======7");
        }
      }
    }
  }
  
  int d(HashMap paramHashMap)
  {
    boolean bool1 = true;
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStartRing am==null!!");
      }
      return -1;
    }
    int i1;
    int i2;
    Object localObject;
    String str;
    boolean bool2;
    int i3;
    boolean bool3;
    try
    {
      i1 = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "  dataSource:" + i1);
      }
      i2 = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
      localObject = (Uri)paramHashMap.get("PARAM_RING_URI");
      str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
      bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
      i3 = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
      bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
      if ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 1) && (bool3 == true))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " ACTIVE_VOICECALL can't play ring!!");
        }
        localObject = new Intent();
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a((Intent)localObject, paramHashMap, 2);
        return -1;
      }
    }
    catch (Exception paramHashMap)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " startRing err params");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 2) {
      b();
    }
    this.jdField_a_of_type_Long = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this.jdField_a_of_type_JavaLangString = ((String)paramHashMap.get("PARAM_OPERATION"));
    this.jdField_b_of_type_JavaLangString = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w != 1) {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w = 2;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
    this.t = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    paramHashMap = this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer;
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 1) {}
    for (;;)
    {
      paramHashMap.a(i1, i2, (Uri)localObject, str, bool2, i3, bool3, bool1, this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.y);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " _ringUserdata:" + this.jdField_b_of_type_JavaLangString + " DurationMS:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.b());
      }
      if (!this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a()) {
        a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a());
      }
      a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a());
      AudioDeviceInterface.LogTraceExit();
      return 0;
      bool1 = false;
    }
  }
  
  void d()
  {
    try
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx == null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager);
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  int e(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w + " _preRingMode:" + this.t);
    if ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();
    if ((!this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a()) && (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w != 1))
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.t);
      g();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void e()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx != null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx.a();
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx = null;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)
      {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  int f(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w + " _preRingMode:" + this.t);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.w == 2) {}
    for (int i1 = this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();; i1 = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.y)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i1);
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
  }
  
  void f()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      b();
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx != null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx.a();
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Hyx = null;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)
      {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext = null;
      }
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager != null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = null;
      label97:
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  @TargetApi(8)
  void g()
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    while ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "-------abandonAudioFocus _focusSteamType:" + this.u);
    }
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  }
  
  void h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, localHashMap, 0);
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry("");
    Looper.prepare();
    this.jdField_a_of_type_AndroidOsHandler = new hza(this);
    c();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      Looper.loop();
      f();
    }
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyy
 * JD-Core Version:    0.7.0.1
 */