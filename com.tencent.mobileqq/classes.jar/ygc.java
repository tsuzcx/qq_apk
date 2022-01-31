import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class ygc
  extends BluetoothGattCallback
{
  public ygc(BluetoothLeService paramBluetoothLeService) {}
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onCharacteristicChanged uuid=" + paramBluetoothGattCharacteristic.getUuid());
    }
    ygh localygh = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if ((localygh != null) && (paramBluetoothGattCharacteristic == localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic))
    {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_AVAILABLE", 0, paramBluetoothGatt, localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic, false);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "btvalue=" + bbdm.a(paramBluetoothGattCharacteristic.getValue()));
      }
    }
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onCharacteristicWrite status=" + paramInt + ",uuid=" + paramBluetoothGattCharacteristic.getUuid());
    }
    ygh localygh = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (paramInt == 0)
    {
      if ((localygh != null) && (paramBluetoothGattCharacteristic == localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic))
      {
        if (localygh.jdField_a_of_type_ArrayOfByte != null) {
          BluetoothLeService.a(this.a, localygh);
        }
      }
      else {
        return;
      }
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, true);
      return;
    }
    BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    ygh localygh = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (localygh == null) {
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
        paramInt2 = localygh.jdField_a_of_type_Int;
        this.a.b(localygh.jdField_a_of_type_Int);
        BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_DISCONNECTED", paramInt1, paramInt2);
        return;
      }
      if (paramInt2 != 2) {
        continue;
      }
      localygh.jdField_b_of_type_Int = 2;
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_CONNECTED", paramInt1, paramBluetoothGatt, null, false);
      try
      {
        Thread.sleep(200L);
        label186:
        boolean bool = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGatt.discoverServices();
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
    BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (paramInt == 0)
    {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED", paramInt, paramBluetoothGatt, null, false);
      return;
    }
    BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    ygh localygh;
    if (paramInt == 0)
    {
      localygh = BluetoothLeService.a(this.a, paramBluetoothGatt);
      if (localygh == null) {
        if (QLog.isColorLevel()) {
          QLog.w("DeviceBLE_EX", 2, "onServicesDiscovered gattInfo is null");
        }
      }
    }
    for (;;)
    {
      return;
      localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGatt.getService(UUID.fromString(BluetoothLeService.a));
      if (localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService != null)
      {
        localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.e));
        if (localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) {
          localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.b));
        }
        localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.f));
        if (localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) {
          localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.c));
        }
        localygh.c = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.g));
        if (localygh.c == null) {
          localygh.c = localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.d));
        }
        if ((localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) || ((localygh.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.getProperties() & 0x8) == 0) || (localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) || ((localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic.getProperties() & 0x20) == 0) || (localygh.c == null) || ((localygh.c.getProperties() & 0x2) == 0))
        {
          BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
          return;
        }
      }
      try
      {
        Thread.sleep(1000L);
        label258:
        this.a.a(paramBluetoothGatt, localygh.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic, true);
        return;
        BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygc
 * JD-Core Version:    0.7.0.1
 */