package com.huawei.hms.adapter;

import android.content.Intent;
import com.huawei.hms.adapter.a.c;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AvailableAdapter$1
  implements c
{
  AvailableAdapter$1(AvailableAdapter paramAvailableAdapter) {}
  
  public boolean a(int paramInt)
  {
    AvailableAdapter.AvailableCallBack localAvailableCallBack = AvailableAdapter.a(this.a);
    if (localAvailableCallBack == null)
    {
      HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
      return true;
    }
    localAvailableCallBack.onComplete(paramInt);
    AvailableAdapter.a(paramInt);
    HMSLog.i("AvailableAdapter", "user response " + AvailableAdapter.a());
    AvailableAdapter.b().set(false);
    return true;
  }
  
  public boolean a(Intent paramIntent, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.AvailableAdapter.1
 * JD-Core Version:    0.7.0.1
 */