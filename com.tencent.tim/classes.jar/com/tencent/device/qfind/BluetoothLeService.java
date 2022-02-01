package com.tencent.device.qfind;

import android.annotation.TargetApi;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import tag;
import tah;

@TargetApi(18)
public class BluetoothLeService
  extends Service
{
  public static final UUID a;
  public static String aIq = "0000feba-0000-1000-8000-00805f9b34fb";
  public static String aIr = "0000fec7-0000-1000-8000-00805f9b34fb";
  public static String aIs = "0000fec8-0000-1000-8000-00805f9b34fb";
  public static String aIt = "0000fec9-0000-1000-8000-00805f9b34fb";
  public static String aIu = "0000fec7-feba-f1f1-99c0-7e0ce07d0c03";
  public static String aIv = "0000fec8-feba-f1f1-99c0-7e0ce07d0c03";
  public static String aIw = "0000fec9-feba-f1f1-99c0-7e0ce07d0c03";
  private final BluetoothGattCallback jdField_a_of_type_AndroidBluetoothBluetoothGattCallback = new tag(this);
  private BluetoothManager jdField_a_of_type_AndroidBluetoothBluetoothManager;
  a jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService$a = new a();
  private BluetoothAdapter mBluetoothAdapter;
  private List<tah> pO = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilUUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  }
  
  private void C(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new Intent(paramString);
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramInt2);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt1);
    super.sendBroadcast(paramString);
  }
  
  private tah a(int paramInt)
  {
    Iterator localIterator = this.pO.iterator();
    while (localIterator.hasNext())
    {
      tah localtah = (tah)localIterator.next();
      if (localtah.bAx == paramInt) {
        return localtah;
      }
    }
    return null;
  }
  
  private tah a(BluetoothGatt paramBluetoothGatt)
  {
    Iterator localIterator = this.pO.iterator();
    while (localIterator.hasNext())
    {
      tah localtah = (tah)localIterator.next();
      if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt == paramBluetoothGatt) {
        return localtah;
      }
    }
    return null;
  }
  
  private void a(String paramString, int paramInt, BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    paramString = new Intent(paramString);
    paramBluetoothGatt = a(paramBluetoothGatt);
    if (paramBluetoothGatt == null) {
      return;
    }
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramBluetoothGatt.bAx);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt);
    paramString.putExtra("com.tencent.device.ble.EXRTA_RESULT", paramBoolean);
    if ((paramBluetoothGattCharacteristic != null) && (paramBluetoothGattCharacteristic == paramBluetoothGatt.b)) {
      paramString.putExtra("com.tencent.device.ble.EXTRA_DATA", paramBluetoothGatt.b.getValue());
    }
    super.sendBroadcast(paramString);
  }
  
  private void a(tah paramtah)
  {
    int i = 20;
    int j = paramtah.bU.length - paramtah.bAz;
    if (j > 0) {
      if (j <= 20) {
        break label173;
      }
    }
    for (;;)
    {
      paramtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setWriteType(2);
      byte[] arrayOfByte = Arrays.copyOfRange(paramtah.bU, paramtah.bAz, paramtah.bAz + i);
      paramtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setValue(arrayOfByte);
      boolean bool = paramtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.writeCharacteristic(paramtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "writeCharacteristic result=" + bool + ", len=" + i + ",sent=" + paramtah.bAz + ", toSend=" + paramtah.bU.length);
      }
      paramtah.bAz = (i + paramtah.bAz);
      if (paramtah.bAz >= paramtah.bU.length)
      {
        paramtah.bU = null;
        paramtah.bAz = 0;
      }
      return;
      label173:
      i = j;
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    if ((this.mBluetoothAdapter == null) || (paramBluetoothGatt == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
      }
    }
    do
    {
      return;
      paramBoolean = paramBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "setCharacteristicNotification result=" + paramBoolean);
      }
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(jdField_a_of_type_JavaUtilUUID);
    } while ((paramBluetoothGattCharacteristic == null) || (!paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) || (paramBluetoothGatt.writeDescriptor(paramBluetoothGattCharacteristic)));
    a("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", 0, paramBluetoothGatt, null, false);
  }
  
  public boolean c(int paramInt, byte[] paramArrayOfByte)
  {
    tah localtah = a(paramInt);
    if (localtah != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "blewrite(" + localtah.aIx + ")=" + paramArrayOfByte);
      }
      if (localtah.bU == null) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "ble cannot send until the last one finish!");
      }
    }
    return false;
    label79:
    localtah.bU = paramArrayOfByte;
    a(localtah);
    return true;
  }
  
  public void close(int paramInt)
  {
    tah localtah = a(paramInt);
    if (localtah != null)
    {
      if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
      this.pO.remove(localtah);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceBLE_EX", 2, "close gattInfo failed bleId:" + paramInt);
  }
  
  public boolean h(int paramInt, String paramString)
  {
    boolean bool = true;
    if ((this.mBluetoothAdapter == null) || (paramString == null) || (!this.mBluetoothAdapter.isEnabled()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized or unspecified address.");
      }
      bool = false;
    }
    do
    {
      return bool;
      tah localtah = a(paramInt);
      if ((localtah != null) && (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "Trying to use an existing mBluetoothGatt for connection.");
        }
        if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.connect())
        {
          localtah.bAy = 1;
          return true;
        }
        return false;
      }
      localtah = new tah();
      localtah.bAx = paramInt;
      localtah.aIx = paramString;
      paramString = this.mBluetoothAdapter.getRemoteDevice(paramString);
      localtah.bAy = 1;
      this.pO.add(localtah);
      localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt = paramString.connectGatt(this, false, this.jdField_a_of_type_AndroidBluetoothBluetoothGattCallback);
      if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt == null)
      {
        this.pO.remove(localtah);
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "connectGatt failed");
        }
        return false;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceBLE_EX", 2, "Trying to create a new connection.");
    return true;
  }
  
  public boolean initialize()
  {
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothManager == null)
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothManager = ((BluetoothManager)super.getSystemService("bluetooth"));
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceBLE_EX", 2, "Unable to initialize BluetoothManager.");
        }
        return false;
      }
    }
    this.mBluetoothAdapter = this.jdField_a_of_type_AndroidBluetoothBluetoothManager.getAdapter();
    if (this.mBluetoothAdapter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "Unable to obtain a BluetoothAdapter.");
      }
      return false;
    }
    return true;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService$a;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Iterator localIterator = this.pO.iterator();
    while (localIterator.hasNext())
    {
      tah localtah = (tah)localIterator.next();
      if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
    }
    this.pO.clear();
    return super.onUnbind(paramIntent);
  }
  
  public void zf(int paramInt)
  {
    tah localtah = a(paramInt);
    if (localtah == null) {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "gattInfo is null for bleid=" + paramInt);
      }
    }
    do
    {
      return;
      if ((this.mBluetoothAdapter != null) && (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("DeviceBLE_EX", 2, "disconnect " + localtah.aIx + ", bleId=" + paramInt);
    }
    localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.disconnect();
  }
  
  public class a
    extends Binder
  {
    public a() {}
    
    public BluetoothLeService a()
    {
      return BluetoothLeService.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.BluetoothLeService
 * JD-Core Version:    0.7.0.1
 */