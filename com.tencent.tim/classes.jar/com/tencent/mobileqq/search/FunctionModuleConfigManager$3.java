package com.tencent.mobileqq.search;

import amjm;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import jqc;

public class FunctionModuleConfigManager$3
  implements Runnable
{
  public FunctionModuleConfigManager$3(amjm paramamjm, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = jqc.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.bSY), "GET", null, null);
      if (localObject != null)
      {
        localObject = amjm.a(this.this$0, (byte[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.PH((String)localObject);
          this.this$0.PJ(this.bSY);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.uniteSearch.FunctionModuleConfigManager", 2, localIOException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager.3
 * JD-Core Version:    0.7.0.1
 */