import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

@TargetApi(18)
public class zsz
{
  static int jdField_a_of_type_Int = 1000;
  private static zsz jdField_a_of_type_Zsz;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ztc(this);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new ztb(this);
  private BluetoothLeService jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
  private List<zzn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<zzn> jdField_a_of_type_JavaUtilSet = new HashSet();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new zta(this, Looper.getMainLooper());
  zzn jdField_a_of_type_Zzn;
  private boolean jdField_a_of_type_Boolean;
  private List<zzn> b = new ArrayList();
  private List<zzn> c = new ArrayList();
  
  public zsz()
  {
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, BluetoothLeService.class);
    this.jdField_a_of_type_AndroidContentContext.bindService((Intent)localObject, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_CONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_DISCONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_NOT_QQ");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_AVAILABLE");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_WRITE_RST");
    ((IntentFilter)localObject).addAction("onDeviceVerifyRsp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static zsz a()
  {
    if ((jdField_a_of_type_Zsz == null) && (BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {
      jdField_a_of_type_Zsz = new zsz();
    }
    return jdField_a_of_type_Zsz;
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent("QFIND_BLE_CONNECT_ERROR");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Zsz != null) {
      jdField_a_of_type_Zsz.a();
    }
  }
  
  public zzn a(int paramInt)
  {
    if ((this.jdField_a_of_type_Zzn != null) && (this.jdField_a_of_type_Zzn.jdField_a_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_Zzn;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zzn localzzn;
    while (localIterator.hasNext())
    {
      localzzn = (zzn)localIterator.next();
      if (localzzn.jdField_a_of_type_Int == paramInt) {
        return localzzn;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      localzzn = (zzn)localIterator.next();
      if (localzzn.jdField_a_of_type_Int == paramInt) {
        return localzzn;
      }
    }
    return null;
  }
  
  public zzn a(String paramString)
  {
    if ((this.jdField_a_of_type_Zzn != null) && (this.jdField_a_of_type_Zzn.a().equals(paramString))) {
      return this.jdField_a_of_type_Zzn;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zzn localzzn;
    while (localIterator.hasNext())
    {
      localzzn = (zzn)localIterator.next();
      if (localzzn.a().equals(paramString)) {
        return localzzn;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      localzzn = (zzn)localIterator.next();
      if (localzzn.a().equals(paramString)) {
        return localzzn;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localzzn = (zzn)localIterator.next();
      if (localzzn.a().equals(paramString)) {
        return localzzn;
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentServiceConnection = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService = null;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService != null) {
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramInt, paramArrayOfByte);
    }
    paramArrayOfByte = a(paramInt);
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (paramArrayOfByte != null))
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(100);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramArrayOfByte.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100000L);
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      a(paramString);
    }
  }
  
  public void a(zzn paramzzn)
  {
    QLog.i("DeviceBLE2", 2, "disConnectPeer " + paramzzn.a());
    if (this.jdField_a_of_type_JavaUtilList.contains(paramzzn))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramzzn);
      this.jdField_a_of_type_JavaUtilList.remove(paramzzn);
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramzzn.jdField_a_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      }
      return;
      if (paramzzn == this.jdField_a_of_type_Zzn)
      {
        this.jdField_a_of_type_Zzn = null;
        this.jdField_a_of_type_JavaUtilSet.add(paramzzn);
        this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramzzn.jdField_a_of_type_Int);
      }
      else if (this.c.contains(paramzzn))
      {
        this.c.remove(paramzzn);
      }
    }
  }
  
  public boolean a(zzn paramzzn)
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_Zzn != null) && (this.jdField_a_of_type_Zzn.b.equals(paramzzn.b))) || (this.jdField_a_of_type_JavaUtilList.contains(paramzzn))) {
      bool = true;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (this.jdField_a_of_type_Zzn == null) {
            break;
          }
        } while (this.c.contains(paramzzn));
        this.c.add(paramzzn);
        return false;
        if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService == null) {
          break;
        }
      } while (!this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramzzn.jdField_a_of_type_Int, paramzzn.b));
      this.jdField_a_of_type_Zzn = paramzzn;
      return true;
    } while (this.c.contains(paramzzn));
    this.c.add(paramzzn);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zsz
 * JD-Core Version:    0.7.0.1
 */