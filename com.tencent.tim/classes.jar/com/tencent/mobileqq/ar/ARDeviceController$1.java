package com.tencent.mobileqq.ar;

import adaq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anpc;
import aqmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public class ARDeviceController$1
  implements Runnable
{
  public ARDeviceController$1(adaq paramadaq, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.cBv));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "AREnable", this.val$enable, 0L, 0L, (HashMap)localObject, null);
    localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("ar_incompatible_reason", this.cBv);
    aqmj.b((SharedPreferences.Editor)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARDeviceController.1
 * JD-Core Version:    0.7.0.1
 */