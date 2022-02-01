package com.tencent.mobileqq.utils;

import acld;
import aqgx;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DBUtils$1
  implements Runnable
{
  public DBUtils$1(aqgx paramaqgx, ArrayList paramArrayList, acld paramacld) {}
  
  public void run()
  {
    QLog.e("DBUtils", 2, "getTroopMsgFilter, saveSettingList.size():" + this.CK.size());
    Iterator localIterator = this.CK.iterator();
    while (localIterator.hasNext())
    {
      RoamSetting localRoamSetting = (RoamSetting)localIterator.next();
      this.a.a(localRoamSetting);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DBUtils.1
 * JD-Core Version:    0.7.0.1
 */