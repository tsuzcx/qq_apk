import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class tag
  extends BluetoothGattCallback
{
  public tag(BluetoothLeService paramBluetoothLeService) {}
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onCharacteristicChanged uuid=" + paramBluetoothGattCharacteristic.getUuid());
    }
    tah localtah = BluetoothLeService.a(this.b, paramBluetoothGatt);
    if ((localtah != null) && (paramBluetoothGattCharacteristic == localtah.b))
    {
      BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_DATA_AVAILABLE", 0, paramBluetoothGatt, localtah.b, false);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "btvalue=" + aqhs.bytes2HexStr(paramBluetoothGattCharacteristic.getValue()));
      }
    }
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onCharacteristicWrite status=" + paramInt + ",uuid=" + paramBluetoothGattCharacteristic.getUuid());
    }
    tah localtah = BluetoothLeService.a(this.b, paramBluetoothGatt);
    if (paramInt == 0)
    {
      if ((localtah != null) && (paramBluetoothGattCharacteristic == localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic))
      {
        if (localtah.bU != null) {
          BluetoothLeService.a(this.b, localtah);
        }
      }
      else {
        return;
      }
      BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, true);
      return;
    }
    BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    tah localtah = BluetoothLeService.a(this.b, paramBluetoothGatt);
    if (localtah == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "onConnectionStateChange but no gattInfo newState=" + paramInt2);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "onConnectionStateChange status=" + paramInt1 + " newState=" + paramInt2);
      }
      if ((paramInt1 != 0) || (paramInt2 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DeviceBLE_EX", 2, "Disconnected from GATT server. status:" + paramInt1);
        }
        paramInt2 = localtah.bAx;
        this.b.close(localtah.bAx);
        BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_GATT_DISCONNECTED", paramInt1, paramInt2);
        return;
      }
      if (paramInt2 != 2) {
        continue;
      }
      localtah.bAy = 2;
      BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_GATT_CONNECTED", paramInt1, paramBluetoothGatt, null, false);
      try
      {
        Thread.sleep(200L);
        label186:
        boolean bool = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.discoverServices();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DeviceBLE_EX", 2, "Connected to GATT server.");
        QLog.i("DeviceBLE_EX", 2, "Attempting to start service discovery:" + bool);
        return;
      }
      catch (Throwable paramBluetoothGatt)
      {
        break label186;
      }
    }
  }
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onDescriptorWrite uuid=" + paramBluetoothGattDescriptor.getUuid() + ",status=" + paramInt + ",value=" + paramBluetoothGattDescriptor.getValue());
    }
    BluetoothLeService.a(this.b, paramBluetoothGatt);
    if (paramInt == 0)
    {
      BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED", paramInt, paramBluetoothGatt, null, false);
      return;
    }
    BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    tah localtah;
    if (paramInt == 0)
    {
      localtah = BluetoothLeService.a(this.b, paramBluetoothGatt);
      if (localtah == null) {
        if (QLog.isColorLevel()) {
          QLog.w("DeviceBLE_EX", 2, "onServicesDiscovered gattInfo is null");
        }
      }
    }
    for (;;)
    {
      return;
      localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGatt.getService(UUID.fromString(BluetoothLeService.aIq));
      if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService != null)
      {
        localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.aIu));
        if (localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) {
          localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.aIr));
        }
        localtah.b = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.aIv));
        if (localtah.b == null) {
          localtah.b = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.aIs));
        }
        localtah.c = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.aIw));
        if (localtah.c == null) {
          localtah.c = localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.aIt));
        }
        if ((localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) || ((localtah.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.getProperties() & 0x8) == 0) || (localtah.b == null) || ((localtah.b.getProperties() & 0x20) == 0) || (localtah.c == null) || ((localtah.c.getProperties() & 0x2) == 0))
        {
          BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
          return;
        }
      }
      try
      {
        Thread.sleep(1000L);
        label258:
        this.b.a(paramBluetoothGatt, localtah.b, true);
        return;
        BluetoothLeService.a(this.b, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("DeviceBLE_EX", 2, "onServicesDiscovered received: " + paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label258;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tag
 * JD-Core Version:    0.7.0.1
 */