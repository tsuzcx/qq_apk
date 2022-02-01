package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import taf;
import tak;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(tak paramtak, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    taf localtaf = new taf();
    localtaf.name = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localtaf.address = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localtaf.reported = false;
    taf.a(this.bV, localtaf);
    if ((localtaf.pN != null) && (localtaf.pN.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localtaf.name + " pid:" + localtaf.pid + " address:" + localtaf.address + " ; blePeerInfo.ble_id = " + localtaf.bAs);
      }
      if ((localtaf.pid == 0) || (localtaf.bT == null) || (!this.jdField_a_of_type_Tak.this$0.oz.contains(new Long(localtaf.pid)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Tak.this$0);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Tak.this$0, localtaf);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Tak.this$0, localtaf, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localtaf.bAs + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Tak.this$0, localtaf.pid, localtaf.nY());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Tak.this$0.m.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Tak.this$0.bAJ);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Tak.this$0, localtaf, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */