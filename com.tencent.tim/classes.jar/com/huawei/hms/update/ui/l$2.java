package com.huawei.hms.update.ui;

import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.a.a.b;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

class l$2
  implements CheckUpdateCallBack
{
  l$2(l paraml, b paramb) {}
  
  public void onMarketInstallInfo(Intent paramIntent) {}
  
  public void onMarketStoreError(int paramInt)
  {
    HMSLog.e("UpdateWizard", "onMarketStoreError responseCode: " + paramInt);
  }
  
  public void onUpdateInfo(Intent paramIntent)
  {
    if (paramIntent != null) {
      l.a(this.b, paramIntent, this.a);
    }
  }
  
  public void onUpdateStoreError(int paramInt)
  {
    HMSLog.e("UpdateWizard", "onUpdateStoreError responseCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.l.2
 * JD-Core Version:    0.7.0.1
 */