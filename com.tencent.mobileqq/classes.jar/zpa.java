import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr.2;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr.3;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xac7.BinderSig;
import tencent.im.oidb.cmd0xac7.DeviceInfo;
import tencent.im.oidb.cmd0xac7.ReceiveMessageDevices;
import tencent.im.oidb.cmd0xac7.ReqBody;
import tencent.im.oidb.cmd0xac7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.DpNotifyMsgBdoy;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.Head;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.NotifyItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.OccupyMicrophoneNotifyMsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.PushBody;

public class zpa
  extends alko
{
  private static int f;
  public int a;
  private long jdField_a_of_type_Long;
  private batw jdField_a_of_type_Batw;
  private baua jdField_a_of_type_Baua;
  private bjyd jdField_a_of_type_Bjyd;
  private QFindBLEScanMgr jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Integer, ProductInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  zpd jdField_a_of_type_Zpd = null;
  private boolean jdField_a_of_type_Boolean;
  DeviceInfo[] jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
  public int b;
  ArrayList<Long> b;
  int c;
  int d = 0;
  private int e = 0;
  
  public zpa(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    try
    {
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new zpb(this));
      label95:
      this.jdField_a_of_type_Baua = new zpc(this, ThreadManager.getSubThreadLooper());
      b("SmartDeviceProxyMgr create");
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.e = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), paramQQAppInterface.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", 0);
        this.jdField_a_of_type_Zpd = new zpd(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("SmartDevice_devListChang");
        localIntentFilter.addAction("onDeviceDisconnected");
        localIntentFilter.addAction("onDeviceLogined");
        localIntentFilter.addAction("SmartDevice_login");
        localIntentFilter.addAction("SmartDevice_clickOnDeviceList");
        localIntentFilter.addAction("onQFindLostDeviceList");
        localIntentFilter.addAction("SmartDevice_devListChangeUI");
        localIntentFilter.addAction("SmartDevice_DeviceBindRst");
        localIntentFilter.addAction("mqq.intent.action.LOGOUT");
        localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
        localIntentFilter.addAction("SmartDevice_receiveDPMsg");
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Zpd, localIntentFilter);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1002, 300000L);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1001, 30000L);
        this.jdField_a_of_type_Baua.addFilter(new Class[] { bamp.class });
        this.jdField_a_of_type_Batw = paramQQAppInterface.a();
        this.jdField_a_of_type_Batw.a(this.jdField_a_of_type_Baua);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label95;
    }
  }
  
  private zvc a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getFilesDir() + "/qfindconfig";
    try
    {
      localObject = bdcs.a(new File((String)localObject));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = zvd.a((String)localObject);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    a(null);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "login");
    localBundle.putInt("iAppID", paramInt);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("a2", paramArrayOfByte);
    localBundle.putBoolean("forceStart", true);
    if (paramString1 != null) {
      localBundle.putString("strOpenId", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("strAccessToken", paramString2);
    }
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  private void a(String paramString1, String paramString2, Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.app.getApplication().getApplicationContext(), ChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("bFromLightApp", paramBoolean);
    localIntent.putExtra("uintype", 9501);
    localIntent.putExtra("operType", paramInt1);
    localIntent.putExtra("jumpTab", paramInt2);
    this.app.getApplication().getApplicationContext().startActivity(localIntent);
  }
  
  private void a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = paramArrayOfDeviceInfo;
      return;
    }
    finally
    {
      paramArrayOfDeviceInfo = finally;
      throw paramArrayOfDeviceInfo;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SmartDeviceProxyMgr", 2, paramString);
    }
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 180	zpa:jdField_a_of_type_Bjyd	Lbjyd;
    //   8: ifnonnull +80 -> 88
    //   11: aload_0
    //   12: ldc_w 354
    //   15: invokespecial 89	zpa:b	(Ljava/lang/String;)V
    //   18: invokestatic 360	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 362	zpa:jdField_a_of_type_Boolean	Z
    //   27: aload_0
    //   28: new 276	bjyd
    //   31: dup
    //   32: aload_0
    //   33: getfield 286	zpa:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokespecial 363	bjyd:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   39: putfield 180	zpa:jdField_a_of_type_Bjyd	Lbjyd;
    //   42: aload_0
    //   43: getfield 286	zpa:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: bipush 49
    //   48: invokevirtual 366	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   51: pop
    //   52: invokestatic 360	java/lang/System:currentTimeMillis	()J
    //   55: lstore 4
    //   57: aload_0
    //   58: new 184	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 368
    //   68: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: lload 4
    //   73: lload_2
    //   74: lsub
    //   75: invokevirtual 371	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 89	zpa:b	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: iload_1
    //   87: ireturn
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -6 -> 84
    //   93: astore 6
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 6
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	zpa
    //   1	89	1	bool	boolean
    //   21	53	2	l1	long
    //   55	17	4	l2	long
    //   93	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	84	93	finally
  }
  
  private DeviceInfo[] b()
  {
    try
    {
      DeviceInfo[] arrayOfDeviceInfo = this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo;
      return arrayOfDeviceInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(int paramInt)
  {
    this.e = paramInt;
    MqqHandler localMqqHandler;
    if (paramInt == 0)
    {
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**setAutoLoadDevicePlugin DEVICE_UNBINED");
      localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1134060));
      }
      f += 1;
    }
    if (f == 0)
    {
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**setAutoLoadDevicePlugin DEVICE_BINED");
      localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1134060));
      }
      c();
      f += 1;
    }
  }
  
  public int a(long paramLong)
  {
    int j = 8;
    int k = 0;
    Object localObject = a(paramLong);
    int i = k;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      i = k;
      if (localObject != null) {
        if (!((ProductInfo)localObject).isSupportMainMsgType(8)) {
          break label104;
        }
      }
    }
    for (;;)
    {
      i = j;
      if (((ProductInfo)localObject).isSupportMainMsgType(2)) {
        i = j | 0x1;
      }
      j = i;
      if (((ProductInfo)localObject).isSupportFuncMsgType(1)) {
        j = i | 0x4;
      }
      if (((ProductInfo)localObject).isSupportFuncMsgType(2))
      {
        i = j | 0x2;
        return i;
      }
      return j;
      label104:
      j = 0;
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::sendAudioMsg");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "sendAudioMsg");
        localBundle.putString("filepath", paramString);
        localBundle.putInt("duration", paramInt);
        localBundle.putLong("din", paramLong);
      } while (this.jdField_a_of_type_Bjyd == null);
      paramString = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while (paramString == null);
    return paramString.getInt("cookie");
  }
  
  public int a(long paramLong1, String paramString1, long paramLong2, int paramInt, String paramString2)
  {
    b("SmartDeviceProxyMgr::sendVideoMsg");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "sendVideoMsg");
        localBundle.putString("filepath", paramString1);
        localBundle.putString("thumbPath", paramString2);
        localBundle.putLong("din", paramLong1);
        localBundle.putLong("filesize", paramLong2);
        localBundle.putInt("duration", paramInt);
      } while (this.jdField_a_of_type_Bjyd == null);
      paramString1 = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while (paramString1 == null);
    return paramString1.getInt("cookie");
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    b("SmartDeviceProxyMgr::sendImageMsg");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "sendImageMsg");
        localBundle.putString("filepath", paramString1);
        localBundle.putString("thumbPath", paramString2);
        localBundle.putLong("din", paramLong);
      } while (this.jdField_a_of_type_Bjyd == null);
      paramString1 = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while (paramString1 == null);
    return paramString1.getInt("cookie");
  }
  
  public long a()
  {
    b("SmartDeviceProxyMgr::getSelfUin");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getselfuin");
    localBundle = this.jdField_a_of_type_Bjyd.a(localBundle);
    if (localBundle != null) {}
    for (long l = localBundle.getLong("selfuin", 0L);; l = 0L)
    {
      if (l != 0L) {
        this.jdField_a_of_type_Long = l;
      }
      return this.jdField_a_of_type_Long;
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::uploadMiniFile");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0L;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "uploadMiniFile");
        localBundle.putString("filepath", paramString);
        localBundle.putInt("filetype", paramInt);
      } while (this.jdField_a_of_type_Bjyd == null);
      paramString = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while (paramString == null);
    return paramString.getLong("cookie");
  }
  
  public long a(String paramString1, String paramString2, int paramInt)
  {
    b("SmartDeviceProxyMgr::downloadMiniFile");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return 0L;
        localBundle = new Bundle();
        localBundle.putString("notify_cmd", "downloadMiniFile");
        localBundle.putString("filekey", paramString1);
        localBundle.putInt("filetype", paramInt);
        localBundle.putString("fileKey2", paramString2);
      } while (this.jdField_a_of_type_Bjyd == null);
      paramString1 = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while (paramString1 == null);
    return paramString1.getLong("cookie");
  }
  
  public DeviceInfo a(long paramLong)
  {
    int i = 0;
    b("SmartDeviceProxyMgr::getDeviceInfoByDin");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return new DeviceInfo();
    }
    Object localObject = b();
    if (localObject != null) {
      while (i < localObject.length)
      {
        if (paramLong == localObject[i].din) {
          return localObject[i];
        }
        i += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getinfobydin");
    ((Bundle)localObject).putLong("din", paramLong);
    localObject = this.jdField_a_of_type_Bjyd.a((Bundle)localObject);
    if (localObject == null) {
      return new DeviceInfo();
    }
    return (DeviceInfo)((Bundle)localObject).getParcelable("deviceinfo");
  }
  
  public DeviceInfo a(String paramString, int paramInt)
  {
    int i = 0;
    b("SmartDeviceProxyMgr::getDeviceInfoBySerialNum");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return null;
    }
    Object localObject = b();
    if (localObject != null) {
      while (i < localObject.length)
      {
        if ((paramString.compareToIgnoreCase(localObject[i].serialNum) == 0) && (paramInt == localObject[i].productId)) {
          return localObject[i];
        }
        i += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getDeviceInfoBySerialNum");
    ((Bundle)localObject).putString("serialNum", paramString);
    ((Bundle)localObject).putInt("pid", paramInt);
    paramString = this.jdField_a_of_type_Bjyd.a((Bundle)localObject);
    if (paramString == null) {
      return null;
    }
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  public ProductInfo a(int paramInt)
  {
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (ProductInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "getProductInfo");
      ((Bundle)localObject).putInt("productId", paramInt);
      localObject = this.jdField_a_of_type_Bjyd.a((Bundle)localObject);
    } while (localObject == null);
    Object localObject = (ProductInfo)((Bundle)localObject).getParcelable("productInfo");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public Boolean a(long paramLong)
  {
    b("SmartDeviceProxyMgr::isVasFlagEnable");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return Boolean.valueOf(false);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "isVasFlagEnable");
    localBundle.putInt("bitIndex", 0);
    localBundle.putLong("din", paramLong);
    if (this.jdField_a_of_type_Bjyd != null)
    {
      localBundle = this.jdField_a_of_type_Bjyd.a(localBundle);
      if (localBundle != null) {
        return Boolean.valueOf(localBundle.getBoolean("isVasFlagEnable"));
      }
    }
    return Boolean.valueOf(false);
  }
  
  public String a()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(this.app.getCurrentAccountUin());
    }
    return "";
  }
  
  public ArrayList<LightAppSettingInfo> a()
  {
    b("SmartDeviceProxyMgr::getLiteAppSettingList");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    Bundle localBundle;
    do
    {
      return null;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "getLiteAppSettingList");
      localBundle = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while (localBundle == null);
    return localBundle.getParcelableArrayList("settinglist");
  }
  
  @TargetApi(18)
  void a()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18) {
      localObject = BaseApplication.getContext();
    }
    try
    {
      bool1 = ((Context)localObject).getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      if (bool1)
      {
        String str = this.app.getCurrentAccountUin();
        if ((str != null) && (!"".equals(str))) {}
      }
      else
      {
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      SharedPreferences localSharedPreferences;
      do
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
          bool1 = false;
        }
        localSharedPreferences = ((Context)localObject).getSharedPreferences("mobileQQ", 4);
      } while ((!localSharedPreferences.getBoolean("qfind_report_gps_bt_stat" + localThrowable2, false)) || (localSharedPreferences.getBoolean("qfind_ble_gps_reported" + localThrowable2, false)));
      localSharedPreferences.edit().putBoolean("qfind_ble_gps_reported" + localThrowable2, true).commit();
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localBluetoothAdapter = ((BluetoothManager)((Context)localObject).getSystemService("bluetooth")).getAdapter();
          if (localBluetoothAdapter != null) {
            continue;
          }
          i = 0;
          aabm.a(null, "QFind_BleState", i, 0, 0);
          if (QLog.isColorLevel()) {
            QLog.i("QFind", 2, "QFind_BleState bleResult=" + i);
          }
        }
        catch (Throwable localThrowable3)
        {
          BluetoothAdapter localBluetoothAdapter;
          boolean bool2;
          localThrowable3.printStackTrace();
          continue;
          if (!bool1) {
            continue;
          }
          int i = 2;
          continue;
          if (!bool2) {
            continue;
          }
          i = 3;
          continue;
          i = 0;
          continue;
        }
        try
        {
          localObject = (LocationManager)((Context)localObject).getSystemService("location");
          bool1 = ((LocationManager)localObject).isProviderEnabled("gps");
          bool2 = ((LocationManager)localObject).isProviderEnabled("network");
          if ((!bool1) || (!bool2)) {
            continue;
          }
          i = 1;
          aabm.a(null, "QFind_GPSState", i, 0, 0);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("QFind", 2, "QFind_GPSState gps=" + bool1 + ", 2g network=" + bool2 + ", gpsResult=" + i);
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          return;
        }
      }
      bool1 = localBluetoothAdapter.isEnabled();
      if (!bool1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public void a(int paramInt)
  {
    f = 0;
    c(paramInt);
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.app.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", this.e);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(false);
    if (paramInt == 39) {}
    label11:
    int i;
    long l;
    do
    {
      do
      {
        do
        {
          break label11;
          do
          {
            return;
          } while (paramInt != 111);
          paramInt = paramBundle.getInt("msgtype", 0);
          i = paramBundle.getInt("devtime", 0);
          l = paramBundle.getLong("din", 0L);
          if (QLog.isColorLevel()) {
            QLog.d("QFind", 2, "PushLostDevFound msgtype[" + paramInt + "], devtime=[" + i + "], din[" + l + "].");
          }
          a(false);
          paramBundle = new Bundle();
          paramBundle.putString("notify_cmd", "updateLostStatus");
          if (this.jdField_a_of_type_Bjyd != null) {
            this.jdField_a_of_type_Bjyd.a(paramBundle);
          }
        } while (paramInt == 2);
        if (paramInt == 6)
        {
          a(l, i, alpo.a(2131714587));
          return;
        }
      } while (paramInt == 7);
      if (paramInt == 8)
      {
        a(l, i, alpo.a(2131714586));
        return;
      }
    } while (paramInt != 9);
    a(l, i, alpo.a(2131714592));
  }
  
  public void a(int paramInt, String paramString)
  {
    b("SmartDeviceProxyMgr::queryIsDeviceHasBeenBinded");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "queryIsDeviceHasBeenBinded");
    localBundle.putInt("productId", paramInt);
    localBundle.putString("serialNum", paramString);
    this.jdField_a_of_type_Bjyd.a(localBundle);
  }
  
  public void a(long paramLong)
  {
    QLog.d("SmartDeviceProxyMgr", 2, "sendUinSkeyMsg begin");
    if (!a()) {}
    do
    {
      return;
      localObject1 = new cmd0xac7.ReqBody();
      ((cmd0xac7.ReqBody)localObject1).uint32_cmd.set(443);
      ((cmd0xac7.ReqBody)localObject1).uint64_din.set(paramLong);
      localObject3 = this.app.getAccount();
    } while (localObject3 == null);
    Object localObject2 = new cmd0xac7.BinderSig();
    ((cmd0xac7.BinderSig)localObject2).uint32_type.set(1);
    ((cmd0xac7.BinderSig)localObject2).uint64_uin.set(Long.valueOf((String)localObject3).longValue());
    Object localObject3 = (TicketManager)this.app.getManager(2);
    ((cmd0xac7.BinderSig)localObject2).bytes_sig.set(ByteStringMicro.copyFromUtf8(((TicketManager)localObject3).getSkey(this.app.getAccount())));
    ((cmd0xac7.ReqBody)localObject1).msg_binder_sig.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2759);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xac7.ReqBody)localObject1).toByteArray()));
    Object localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc_device.0xac7");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    b("SmartDeviceProxyMgr::sendToDealTipCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendDealTipCmd");
    localBundle.putString("uin", this.app.getCurrentAccountUin());
    localBundle.putLong("din", paramLong);
    localBundle.putInt("productId", paramInt);
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    b("SmartDeviceProxyMgr::setDeviceVasFlag");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "setDeviceVasFlag");
      localBundle.putInt("bitCount", paramInt2);
      localBundle.putInt("beginIndex", paramInt1);
      localBundle.putInt("bitValue", paramInt3);
      localBundle.putLong("din", paramLong);
    } while (this.jdField_a_of_type_Bjyd == null);
    this.jdField_a_of_type_Bjyd.a(localBundle);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    b("onReceive Push Msg : " + paramString);
    b();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "notifyCmdReceivePush");
    localBundle.putLong("fromUin", paramLong1);
    localBundle.putLong("toUin", paramLong2);
    localBundle.putInt("msgSeq", paramInt1);
    localBundle.putLong("msgUid", paramLong3);
    localBundle.putInt("msgType", paramInt2);
    localBundle.putBoolean("forceStart", true);
    if (paramString != null) {
      localBundle.putString("sServiceCmd", paramString);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("buffer", paramArrayOfByte);
    }
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    b("SmartDeviceProxyMgr::sendStructingShareMsg");
    a(false);
    DataPoint localDataPoint;
    AbsShareMsg localAbsShareMsg;
    if ((paramAbsStructMsg != null) && ((paramAbsStructMsg instanceof AbsShareMsg)))
    {
      localDataPoint = new DataPoint();
      localAbsShareMsg = (AbsShareMsg)paramAbsStructMsg;
      if (paramAbsStructMsg.mMsgServiceID != 2) {
        break label417;
      }
      localDataPoint.mProperityId = 11003;
    }
    for (;;)
    {
      localDataPoint.mApiName = "set_data_point";
      localDataPoint.mDin = paramLong;
      try
      {
        localDataPoint.mValue = new JSONObject().put("msg_time", (int)ayvc.a()).put("senderDin", paramLong).put("msgUrl", localAbsShareMsg.mMsgUrl).put("contentSrc", localAbsShareMsg.mContentSrc).put("contentCover", localAbsShareMsg.mContentCover).put("contentTitle", localAbsShareMsg.mContentTitle).put("contentSummary", localAbsShareMsg.mContentSummary).put("msgAction", localAbsShareMsg.mMsgAction).put("msgActionData", localAbsShareMsg.mMsgActionData).put("msg_A_ActionData", localAbsShareMsg.mMsg_A_ActionData).put("msg_I_ActionData", localAbsShareMsg.mMsg_I_ActionData).put("sourceAppid", localAbsShareMsg.mSourceAppid).put("sourceUrl", localAbsShareMsg.mSourceUrl).put("sourceAction", localAbsShareMsg.mSourceAction).put("sourceActionData", localAbsShareMsg.mSourceActionData).put("source_A_ActionData", localAbsShareMsg.mSource_A_ActionData).put("source_I_ActionData", localAbsShareMsg.mSource_I_ActionData).put("sourceIcon", localAbsShareMsg.mSourceIcon).put("sourceName", localAbsShareMsg.mSourceName).put("msgBrief", localAbsShareMsg.mMsgBrief).put("fileName", localAbsShareMsg.mFileName).put("fileSize", localAbsShareMsg.mFileSize).put("compatibleText", localAbsShareMsg.mCompatibleText).toString();
        localDataPoint.mValueType = "string";
        paramAbsStructMsg = new Bundle();
        paramAbsStructMsg.putParcelable("datapoint", localDataPoint);
        paramAbsStructMsg.putLong("din", paramLong);
        paramAbsStructMsg.putString("notify_cmd", "sendStructMsg");
        b("SmartDeviceProxyMgr::sendStructingShareMsg dataPoint.mValue = " + localDataPoint.mValue);
        if (this.jdField_a_of_type_Bjyd != null) {
          this.jdField_a_of_type_Bjyd.a(paramAbsStructMsg);
        }
        return;
        label417:
        if (paramAbsStructMsg.mMsgServiceID == 32)
        {
          localDataPoint.mProperityId = 32;
          continue;
        }
        if (paramAbsStructMsg.mMsgServiceID != 1) {
          continue;
        }
        localDataPoint.mProperityId = 11005;
      }
      catch (JSONException paramAbsStructMsg)
      {
        for (;;)
        {
          paramAbsStructMsg.printStackTrace();
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle)
  {
    b("SmartDeviceProxyMgr::sendCloudPrintCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCloudPrintCmd");
    localBundle.putLong("din", paramLong);
    localBundle.putString("fileIndex", paramString1);
    localBundle.putString("jobId", paramString2);
    localBundle.putString("fileName", paramString3);
    localBundle.putInt("fileType", paramInt);
    localBundle.putBundle("otherParams", paramBundle);
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo, boolean paramBoolean)
  {
    a(paramActivity, paramDeviceInfo, paramBoolean, null);
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPerf", 2, "liteAppEntry:" + System.currentTimeMillis());
    }
    a(false);
    if (paramDeviceInfo == null)
    {
      bfhq.a().a(alpo.a(2131714595));
      return;
    }
    paramDeviceInfo.displayName = aabn.a(paramDeviceInfo);
    new aabb(paramActivity).a(paramDeviceInfo, paramBundle, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    b("SmartDeviceProxyMgr::InvokeOpenChatMsgActivity");
    if ((this.app == null) || (paramBundle == null))
    {
      b("in SmartDeviceProxyMgr InvokeOpenChatMsgActivity app is null or params is null");
      return;
    }
    String str1 = paramBundle.getString("din");
    String str2 = paramBundle.getString("devName");
    Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("bFromLightApp", false));
    int i = paramBundle.getInt("operType");
    int j = paramBundle.getInt("jumpTab");
    paramBundle = Looper.getMainLooper();
    if (Thread.currentThread() != paramBundle.getThread())
    {
      new Handler(paramBundle).post(new SmartDeviceProxyMgr.3(this, str1, str2, localBoolean, i, j));
      return;
    }
    a(str1, str2, localBoolean, i, j);
  }
  
  public void a(DataPoint paramDataPoint, int paramInt1, long paramLong, int paramInt2)
  {
    b("SmartDeviceProxyMgr::sendCCDataPointMsg");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCCDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt1);
    localBundle.putLong("din", paramLong);
    localBundle.putInt("lifetime", paramInt2);
    this.jdField_a_of_type_Bjyd.a(localBundle);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new SmartDeviceProxyMgr.2(this, paramConfig));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    b("SmartDeviceProxyMgr::sendTextMsg");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendTextMsg");
    localBundle.putLong("din", paramLong1);
    localBundle.putString("text", paramString);
    localBundle.putLong("msg_time", paramLong2);
    localBundle.putLong("msgSeq", paramLong3);
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    String str = BaseApplicationImpl.getApplication().getFilesDir() + "/qfindpidlist";
    if (paramBoolean) {
      bdcs.d(str);
    }
    try
    {
      for (;;)
      {
        paramString = bdcs.a(new File(str));
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = new JSONObject(paramString).getJSONArray("pidlist");
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i = 0;
        while (i < paramString.length())
        {
          long l = paramString.getLong(i);
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l));
          i += 1;
        }
        if (paramString != null) {
          bdcs.a(str, paramString);
        }
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label262;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        break label262;
      }
    }
    paramString = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    str = this.app.getCurrentAccountUin();
    if ((str == null) || ("".equals(str))) {}
    for (;;)
    {
      return;
      paramString = paramString.getString("qfind_assist" + str, "0");
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        this.d = Integer.parseInt(paramString);
        label262:
        if (((this.d + this.jdField_c_of_type_Int > 1) && (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null) && (a() != null)) && ((this.jdField_b_of_type_JavaUtilArrayList == null) || (!QLog.isColorLevel()))) {
          continue;
        }
        QLog.w("QFind", 2, "qfind pid count=" + this.jdField_b_of_type_JavaUtilArrayList.size());
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          this.d = 0;
        }
      }
    }
  }
  
  public void a(ArrayList<LightAppSettingInfo> paramArrayList)
  {
    b("SmartDeviceProxyMgr::transferAppSettingList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "transferLiteAppSettingList");
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localBundle.putParcelableArrayList("settinglist", paramArrayList);
    }
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b("startPlugin flag:" + this.e + " ipc:" + this.jdField_a_of_type_Bjyd);
    if (this.e != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("SmartDeviceProxyMgr::startPlugin, forceRefresh: ");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      b(str);
      if (!b()) {
        break;
      }
      b(paramBoolean);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SubMsgType0x90.MsgBody();
    try
    {
      ((SubMsgType0x90.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      switch (((SubMsgType0x90.MsgBody)localObject).msg_head.uint32_cmd.get())
      {
      default: 
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      b("onRecvPush0x210_0x90, parse error");
      return;
    }
    paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_dp_notify_body;
    localObject = new Intent();
    ((Intent)localObject).setAction("On_DpNotify_Push");
    ((Intent)localObject).putExtra("productid", paramArrayOfByte.uint32_pid.get());
    ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
    ((Intent)localObject).putExtra("extras", paramArrayOfByte.string_extend_info.get());
    int[] arrayOfInt = new int[paramArrayOfByte.rpt_msg_notify_info.size()];
    int i = 0;
    while (i < paramArrayOfByte.rpt_msg_notify_info.size())
    {
      arrayOfInt[i] = ((SubMsgType0x90.NotifyItem)paramArrayOfByte.rpt_msg_notify_info.get(i)).uint32_propertyid.get();
      i += 1;
    }
    ((Intent)localObject).putExtra("pids", arrayOfInt);
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
    return;
    paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_occupy_microphone_body;
    localObject = new Intent();
    ((Intent)localObject).setAction("On_OccupyMicrophoneNotify_Push");
    ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
    ((Intent)localObject).putExtra("uin", bbmx.a(paramArrayOfByte.uint32_uin.get()));
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public boolean a()
  {
    return this.e == 1;
  }
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    b("SmartDeviceProxyMgr::datalineSendCSMsg");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCSMsg");
    localBundle.putInt("subType", paramInt1);
    localBundle.putInt("cookie", paramInt2);
    localBundle.putByteArray("data", paramArrayOfByte);
    this.jdField_a_of_type_Bjyd.a(localBundle);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = a(paramLong);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ProductInfo)localObject).deviceType == paramInt) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    b("SmartDeviceProxyMgr::datalineSendCCMsg");
    a(false);
    if (this.jdField_a_of_type_Bjyd == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCCMsg");
    localBundle.putLong("din", paramLong);
    localBundle.putInt("sendCookie", paramInt);
    localBundle.putByteArray("bodyContent", paramArrayOfByte);
    this.jdField_a_of_type_Bjyd.a(localBundle);
    return true;
  }
  
  public boolean a(String paramString)
  {
    return b(Long.parseLong(paramString));
  }
  
  public byte[] a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      b("device login,a2 len is:" + str.length());
      return bdcv.a(a());
    }
    return bdcv.a("");
  }
  
  public DeviceInfo[] a()
  {
    a(false);
    Object localObject;
    if (this.jdField_a_of_type_Bjyd == null) {
      localObject = null;
    }
    DeviceInfo[] arrayOfDeviceInfo;
    do
    {
      do
      {
        return localObject;
        arrayOfDeviceInfo = b();
        localObject = arrayOfDeviceInfo;
      } while (arrayOfDeviceInfo != null);
      localObject = arrayOfDeviceInfo;
    } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1003);
    return arrayOfDeviceInfo;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    b("startPlugin force flag:" + this.e + " ipc:" + this.jdField_a_of_type_Bjyd);
    if (b()) {
      b(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.app.getCurrentAccountUin(), null, "qqsetting_antilost_key", this.jdField_c_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.w("QFind", 2, "qfind mQfindAssist=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("LocalPath");
    String str2 = paramBundle.getString("PeerUin");
    long l = paramBundle.getLong("Uniseq");
    paramBundle = new baub();
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.jdField_c_of_type_Int = 7;
    paramBundle.i = str1;
    paramBundle.jdField_c_of_type_JavaLangString = str2;
    paramBundle.jdField_a_of_type_Long = l;
    paramBundle.jdField_b_of_type_Int = 24;
    paramBundle.jdField_a_of_type_JavaLangString = "facePicUploadProcess";
    this.jdField_a_of_type_Batw.a(paramBundle);
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 184	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1406
    //   12: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: astore 4
    //   17: iload_1
    //   18: ifeq +41 -> 59
    //   21: ldc_w 1226
    //   24: astore_3
    //   25: aload_0
    //   26: aload 4
    //   28: aload_3
    //   29: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 89	zpa:b	(Ljava/lang/String;)V
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield 53	zpa:jdField_a_of_type_Int	I
    //   43: if_icmpeq +13 -> 56
    //   46: aload_0
    //   47: getfield 55	zpa:jdField_b_of_type_Int	I
    //   50: istore_2
    //   51: iconst_1
    //   52: iload_2
    //   53: if_icmpne +13 -> 66
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc_w 1232
    //   62: astore_3
    //   63: goto -38 -> 25
    //   66: iload_1
    //   67: ifeq +13 -> 80
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 53	zpa:jdField_a_of_type_Int	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 55	zpa:jdField_b_of_type_Int	I
    //   80: aload_0
    //   81: getfield 53	zpa:jdField_a_of_type_Int	I
    //   84: ifeq +11 -> 95
    //   87: iconst_3
    //   88: aload_0
    //   89: getfield 53	zpa:jdField_a_of_type_Int	I
    //   92: if_icmpne -36 -> 56
    //   95: aload_0
    //   96: getfield 286	zpa:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: ifnull -43 -> 56
    //   102: aload_0
    //   103: getfield 286	zpa:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: invokevirtual 101	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   109: ifnull -53 -> 56
    //   112: aload_0
    //   113: ldc_w 1407
    //   116: aload_0
    //   117: getfield 286	zpa:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   120: invokevirtual 101	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   123: invokestatic 1360	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   126: aload_0
    //   127: invokevirtual 1409	zpa:a	()[B
    //   130: ldc_w 568
    //   133: ldc_w 568
    //   136: invokespecial 1411	zpa:a	(IJ[BLjava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 53	zpa:jdField_a_of_type_Int	I
    //   144: goto -88 -> 56
    //   147: astore_3
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_3
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	zpa
    //   0	152	1	paramBoolean	boolean
    //   50	4	2	i	int
    //   24	39	3	str	String
    //   147	4	3	localObject	Object
    //   15	12	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	17	147	finally
    //   25	51	147	finally
    //   70	80	147	finally
    //   80	95	147	finally
    //   95	144	147	finally
  }
  
  public boolean b(long paramLong)
  {
    if (a(paramLong).booleanValue()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return true;
          localObject = a(paramLong);
          if (localObject == null) {
            return false;
          }
        } while (((DeviceInfo)localObject).SSOBid_Platform == 1027);
        if (((DeviceInfo)localObject).SSOBid_Version == null) {
          return false;
        }
      } while ((((DeviceInfo)localObject).SSOBid_Platform == 0) && (((DeviceInfo)localObject).SSOBid_Version.equals("")));
      localObject = ((DeviceInfo)localObject).SSOBid_Version.split("\\.");
      if ((localObject == null) || (localObject.length < 2)) {
        return false;
      }
      if (Integer.parseInt(localObject[0]) < 1) {
        return false;
      }
    } while ((Integer.parseInt(localObject[0]) != 1) || (Integer.parseInt(localObject[1]) >= 1));
    return false;
  }
  
  public void c()
  {
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy");
    if (!a()) {}
    do
    {
      return;
      localObject1 = new cmd0xac7.ReqBody();
      ((cmd0xac7.ReqBody)localObject1).uint32_cmd.set(442);
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy ...");
      localObject2 = this.app.getCurrentAccountUin();
    } while (localObject2 == null);
    ((cmd0xac7.ReqBody)localObject1).uint64_din.set(Long.valueOf((String)localObject2).longValue());
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy din:" + Long.valueOf((String)localObject2).longValue());
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2759);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xac7.ReqBody)localObject1).toByteArray()));
    Object localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc_device.0xac7");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public boolean c(long paramLong)
  {
    Object localObject = a(paramLong);
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      return (localObject != null) && (((ProductInfo)localObject).uConnectType == 1);
    }
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (2 == this.jdField_a_of_type_Int))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "logout");
      if (this.jdField_a_of_type_Bjyd != null) {
        this.jdField_a_of_type_Bjyd.a((Bundle)localObject);
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**logout");
    Object localObject = this.app.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134060));
    }
  }
  
  public boolean d(long paramLong)
  {
    b("SmartDeviceProxyMgr::isDeviceHasUpdate");
    if (this.jdField_a_of_type_Bjyd == null) {}
    Bundle localBundle;
    do
    {
      return false;
      localBundle = new Bundle();
      localBundle.putString("notify_cmd", "isDeviceHasUpdate");
      localBundle.putLong("din", paramLong);
      localBundle = this.jdField_a_of_type_Bjyd.a(localBundle);
    } while ((localBundle == null) || (!localBundle.getBoolean("hasUpdate", false)));
    return true;
  }
  
  public void e()
  {
    b("SmartDeviceProxyMgr::updateDeviceStatus");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateDeviceStatus");
    if (this.jdField_a_of_type_Bjyd != null) {
      this.jdField_a_of_type_Bjyd.a(localBundle);
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return zoz.class;
  }
  
  public void onDestroy()
  {
    b("SmartDeviceProxyMgr onDestroy");
    super.onDestroy();
    if ((BaseApplicationImpl.getContext() != null) && (this.jdField_a_of_type_Zpd != null)) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Zpd);
      this.jdField_a_of_type_Zpd = null;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_MqqOsMqqHandler = null;
      }
      if (this.jdField_a_of_type_Batw != null)
      {
        this.jdField_a_of_type_Baua.getFilter().clear();
        this.jdField_a_of_type_Baua.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_Batw.b(this.jdField_a_of_type_Baua);
        this.jdField_a_of_type_Baua = null;
        this.jdField_a_of_type_Batw.c();
        this.jdField_a_of_type_Batw = null;
      }
      if (this.jdField_a_of_type_Bjyd != null)
      {
        this.jdField_a_of_type_Bjyd.a();
        this.jdField_a_of_type_Bjyd = null;
      }
      if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null)
      {
        this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.b();
        this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr = null;
      }
      if (this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo != null) {
        this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if ("QFindSvc.ReqReportDevs".equals(paramToServiceMsg.getServiceCmd()))
      {
        if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null) {
          this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        return;
      }
      if ("OidbSvc_device.0xac7".equals(paramToServiceMsg.getServiceCmd()))
      {
        QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**onReceive sendMsgProxy");
        if (!paramFromServiceMsg.isSuccess()) {}
      }
    }
    for (;;)
    {
      try
      {
        QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**onReceive sendMsgProxy...");
        localObject1 = new cmd0xac7.RspBody();
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg.getWupBuffer());
        ((cmd0xac7.RspBody)localObject1).mergeFrom(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray());
        localObject2 = new cmd0xac7.ReceiveMessageDevices();
        ((cmd0xac7.ReceiveMessageDevices)localObject2).mergeFrom(((cmd0xac7.RspBody)localObject1).bytes_extd.get().toByteArray());
        if (((cmd0xac7.ReceiveMessageDevices)localObject2).rpt_devices.size() <= 0) {
          continue;
        }
        localObject2 = (cmd0xac7.DeviceInfo)((cmd0xac7.ReceiveMessageDevices)localObject2).rpt_devices.get(0);
        if (localObject2 != null)
        {
          localObject1 = ((cmd0xac7.DeviceInfo)localObject2).bytes_name.get().toStringUtf8();
          long l = ((cmd0xac7.DeviceInfo)localObject2).uint64_din.get();
          localObject2 = this.app.getHandler(Conversation.class);
          if (localObject2 != null)
          {
            Message localMessage = ((MqqHandler)localObject2).obtainMessage(1134059);
            localMessage.obj = new Pair(Long.valueOf(l), localObject1);
            ((MqqHandler)localObject2).sendMessage(localMessage);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        localThrowable.printStackTrace();
        MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
        if (localMqqHandler == null) {
          continue;
        }
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1134060));
        continue;
      }
      b("onReceive Ack Msg");
      b();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("notify_cmd", "notifyCmdReceiveData");
      if (paramToServiceMsg != null) {
        ((Bundle)localObject1).putParcelable("req", paramToServiceMsg);
      }
      if (paramFromServiceMsg != null) {
        ((Bundle)localObject1).putParcelable("res", paramFromServiceMsg);
      }
      if (paramObject != null) {
        ((Bundle)localObject1).putByteArray("data", (byte[])paramObject);
      }
      ((Bundle)localObject1).putBoolean("forceStart", true);
      if (this.jdField_a_of_type_Bjyd == null) {
        break;
      }
      this.jdField_a_of_type_Bjyd.a((Bundle)localObject1);
      return;
      localObject1 = this.app.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1134060));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zpa
 * JD-Core Version:    0.7.0.1
 */