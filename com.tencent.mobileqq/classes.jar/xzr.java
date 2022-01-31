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
public class xzr
{
  static int jdField_a_of_type_Int = 1000;
  private static xzr jdField_a_of_type_Xzr;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new xzu(this);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new xzt(this);
  private BluetoothLeService jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
  private List<ygf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<ygf> jdField_a_of_type_JavaUtilSet = new HashSet();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new xzs(this, Looper.getMainLooper());
  ygf jdField_a_of_type_Ygf;
  private boolean jdField_a_of_type_Boolean;
  private List<ygf> b = new ArrayList();
  private List<ygf> c = new ArrayList();
  
  public xzr()
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
  
  public static xzr a()
  {
    if ((jdField_a_of_type_Xzr == null) && (BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {
      jdField_a_of_type_Xzr = new xzr();
    }
    return jdField_a_of_type_Xzr;
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
    if (jdField_a_of_type_Xzr != null) {
      jdField_a_of_type_Xzr.a();
    }
  }
  
  public ygf a(int paramInt)
  {
    if ((this.jdField_a_of_type_Ygf != null) && (this.jdField_a_of_type_Ygf.jdField_a_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_Ygf;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    ygf localygf;
    while (localIterator.hasNext())
    {
      localygf = (ygf)localIterator.next();
      if (localygf.jdField_a_of_type_Int == paramInt) {
        return localygf;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      localygf = (ygf)localIterator.next();
      if (localygf.jdField_a_of_type_Int == paramInt) {
        return localygf;
      }
    }
    return null;
  }
  
  public ygf a(String paramString)
  {
    if ((this.jdField_a_of_type_Ygf != null) && (this.jdField_a_of_type_Ygf.a().equals(paramString))) {
      return this.jdField_a_of_type_Ygf;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    ygf localygf;
    while (localIterator.hasNext())
    {
      localygf = (ygf)localIterator.next();
      if (localygf.a().equals(paramString)) {
        return localygf;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      localygf = (ygf)localIterator.next();
      if (localygf.a().equals(paramString)) {
        return localygf;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localygf = (ygf)localIterator.next();
      if (localygf.a().equals(paramString)) {
        return localygf;
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
  
  public void a(ygf paramygf)
  {
    QLog.i("DeviceBLE2", 2, "disConnectPeer " + paramygf.a());
    if (this.jdField_a_of_type_JavaUtilList.contains(paramygf))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramygf);
      this.jdField_a_of_type_JavaUtilList.remove(paramygf);
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramygf.jdField_a_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      }
      return;
      if (paramygf == this.jdField_a_of_type_Ygf)
      {
        this.jdField_a_of_type_Ygf = null;
        this.jdField_a_of_type_JavaUtilSet.add(paramygf);
        this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramygf.jdField_a_of_type_Int);
      }
      else if (this.c.contains(paramygf))
      {
        this.c.remove(paramygf);
      }
    }
  }
  
  public boolean a(ygf paramygf)
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_Ygf != null) && (this.jdField_a_of_type_Ygf.b.equals(paramygf.b))) || (this.jdField_a_of_type_JavaUtilList.contains(paramygf))) {
      bool = true;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (this.jdField_a_of_type_Ygf == null) {
            break;
          }
        } while (this.c.contains(paramygf));
        this.c.add(paramygf);
        return false;
        if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService == null) {
          break;
        }
      } while (!this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramygf.jdField_a_of_type_Int, paramygf.b));
      this.jdField_a_of_type_Ygf = paramygf;
      return true;
    } while (this.c.contains(paramygf));
    this.c.add(paramygf);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xzr
 * JD-Core Version:    0.7.0.1
 */