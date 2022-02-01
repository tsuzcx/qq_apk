package com.tencent.mobileqq.ark.API;

import adon;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;

public class ArkAppYYBDownloadModule$5
  implements Runnable
{
  public ArkAppYYBDownloadModule$5(adon paramadon, long paramLong, String paramString) {}
  
  public void run()
  {
    try
    {
      ark.VariantWrapper localVariantWrapper1 = this.this$0.a(this.Vw);
      if (localVariantWrapper1 == null)
      {
        QLog.d("ArkApp.downloadyyb.module", 1, "onQueryPackageState Callback is null");
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      localVariantWrapper2.SetNull();
      ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
      localVariantWrapper2.SetTableAsJsonString(this.aWc);
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      if (QLog.isColorLevel())
      {
        QLog.i("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB : " + this.aWc);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "QUERRY_PACKAGE_EXIST  : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.5
 * JD-Core Version:    0.7.0.1
 */