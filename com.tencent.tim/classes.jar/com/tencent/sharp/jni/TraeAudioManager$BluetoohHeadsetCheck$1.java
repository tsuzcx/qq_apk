package com.tencent.sharp.jni;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TraeAudioManager$BluetoohHeadsetCheck$1
  implements Runnable
{
  TraeAudioManager$BluetoohHeadsetCheck$1(TraeAudioManager.a parama) {}
  
  public void run()
  {
    if (this.a._profile != null) {}
    for (;;)
    {
      try
      {
        List localList = this.a._profile.getConnectedDevices();
        if (localList == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + localList.size() + " _profile:" + this.a._profile);
        }
        int i = 0;
        if (i >= localList.size()) {
          break;
        }
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)localList.get(i);
        int j = this.a._profile.getConnectionState(localBluetoothDevice);
        if (j == 2) {
          this.a.b.setBluetoothName(localBluetoothDevice.getName());
        }
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + j);
        }
        i += 1;
        continue;
        str = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BluetoohHeadsetCheck", 2, "onServiceConnected.run e = " + localException);
        }
      }
    }
    if (this.a.b != null) {
      if (this.a.this$0.a == null) {
        break label346;
      }
    }
    label346:
    for (String str = this.a.this$0.a.getBluetoothName();; str = null)
    {
      if (TextUtils.isEmpty(str))
      {
        this.a.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        return;
      }
      if (this.a.isConnected())
      {
        this.a.b.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        this.a.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
      this.a.b.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.BluetoohHeadsetCheck.1
 * JD-Core Version:    0.7.0.1
 */