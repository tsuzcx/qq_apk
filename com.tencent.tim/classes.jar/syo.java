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
public class syo
{
  private static syo jdField_a_of_type_Syo;
  static int bAh = 1000;
  private BluetoothLeService jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
  tai jdField_a_of_type_Tai;
  private boolean aOf;
  private Set<tai> aV = new HashSet();
  private BroadcastReceiver aq = new syr(this);
  MqqHandler b = new syp(this, Looper.getMainLooper());
  private Context mContext = BaseApplicationImpl.getContext();
  private ServiceConnection mServiceConnection = new syq(this);
  private List<tai> pI = new ArrayList();
  private List<tai> pJ = new ArrayList();
  private List<tai> pK = new ArrayList();
  
  public syo()
  {
    Object localObject = new Intent(this.mContext, BluetoothLeService.class);
    this.mContext.bindService((Intent)localObject, this.mServiceConnection, 1);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_CONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_DISCONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_NOT_QQ");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_AVAILABLE");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_WRITE_RST");
    ((IntentFilter)localObject).addAction("onDeviceVerifyRsp");
    this.mContext.registerReceiver(this.aq, (IntentFilter)localObject);
    this.aOf = true;
  }
  
  public static syo a()
  {
    if ((jdField_a_of_type_Syo == null) && (BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {
      jdField_a_of_type_Syo = new syo();
    }
    return jdField_a_of_type_Syo;
  }
  
  public static void destroy()
  {
    if (jdField_a_of_type_Syo != null) {
      jdField_a_of_type_Syo.close();
    }
  }
  
  private void za(int paramInt)
  {
    Intent localIntent = new Intent("QFIND_BLE_CONNECT_ERROR");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public tai a(int paramInt)
  {
    if ((this.jdField_a_of_type_Tai != null) && (this.jdField_a_of_type_Tai.bAA == paramInt)) {
      return this.jdField_a_of_type_Tai;
    }
    Iterator localIterator = this.pI.iterator();
    tai localtai;
    while (localIterator.hasNext())
    {
      localtai = (tai)localIterator.next();
      if (localtai.bAA == paramInt) {
        return localtai;
      }
    }
    localIterator = this.aV.iterator();
    while (localIterator.hasNext())
    {
      localtai = (tai)localIterator.next();
      if (localtai.bAA == paramInt) {
        return localtai;
      }
    }
    return null;
  }
  
  public tai a(String paramString)
  {
    if ((this.jdField_a_of_type_Tai != null) && (this.jdField_a_of_type_Tai.nY().equals(paramString))) {
      return this.jdField_a_of_type_Tai;
    }
    Iterator localIterator = this.pI.iterator();
    tai localtai;
    while (localIterator.hasNext())
    {
      localtai = (tai)localIterator.next();
      if (localtai.nY().equals(paramString)) {
        return localtai;
      }
    }
    localIterator = this.aV.iterator();
    while (localIterator.hasNext())
    {
      localtai = (tai)localIterator.next();
      if (localtai.nY().equals(paramString)) {
        return localtai;
      }
    }
    localIterator = this.pK.iterator();
    while (localIterator.hasNext())
    {
      localtai = (tai)localIterator.next();
      if (localtai.nY().equals(paramString)) {
        return localtai;
      }
    }
    return null;
  }
  
  public void a(tai paramtai)
  {
    QLog.i("DeviceBLE2", 2, "disConnectPeer " + paramtai.nY());
    if (this.pI.contains(paramtai))
    {
      this.aV.add(paramtai);
      this.pI.remove(paramtai);
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.zf(paramtai.bAA);
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.removeMessages(100);
      }
      return;
      if (paramtai == this.jdField_a_of_type_Tai)
      {
        this.jdField_a_of_type_Tai = null;
        this.aV.add(paramtai);
        this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.zf(paramtai.bAA);
      }
      else if (this.pK.contains(paramtai))
      {
        this.pK.remove(paramtai);
      }
    }
  }
  
  public boolean a(tai paramtai)
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_Tai != null) && (this.jdField_a_of_type_Tai.address.equals(paramtai.address))) || (this.pI.contains(paramtai))) {
      bool = true;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (this.jdField_a_of_type_Tai == null) {
            break;
          }
        } while (this.pK.contains(paramtai));
        this.pK.add(paramtai);
        return false;
        if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService == null) {
          break;
        }
      } while (!this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.h(paramtai.bAA, paramtai.address));
      this.jdField_a_of_type_Tai = paramtai;
      return true;
    } while (this.pK.contains(paramtai));
    this.pK.add(paramtai);
    return false;
  }
  
  public void close()
  {
    if ((BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) && (this.aOf))
    {
      this.mContext.unregisterReceiver(this.aq);
      this.mContext.unbindService(this.mServiceConnection);
    }
    this.aOf = false;
    this.mServiceConnection = null;
    this.aq = null;
    this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService = null;
  }
  
  public void i(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService != null) {
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.c(paramInt, paramArrayOfByte);
    }
    paramArrayOfByte = a(paramInt);
    if ((this.b != null) && (paramArrayOfByte != null))
    {
      Message localMessage = this.b.obtainMessage(100);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramArrayOfByte.nY();
      this.b.sendMessageDelayed(localMessage, 100000L);
    }
  }
  
  public void tZ(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     syo
 * JD-Core Version:    0.7.0.1
 */