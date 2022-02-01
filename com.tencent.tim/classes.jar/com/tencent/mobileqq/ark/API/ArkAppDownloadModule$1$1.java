package com.tencent.mobileqq.ark.API;

import adnc;
import adnd;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;

public class ArkAppDownloadModule$1$1
  implements Runnable
{
  public ArkAppDownloadModule$1$1(adnd paramadnd, ArrayList paramArrayList) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper1 = this.a.this$0.a(this.a.Vc);
    if (localVariantWrapper1 == null)
    {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryPackageState Callback is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    JSONArray localJSONArray = adnc.a(this.a.this$0, this.uD, "QueryPackageState");
    String str = "";
    if (localJSONArray != null) {
      str = localJSONArray.toString();
    }
    localVariantWrapper2.SetTableAsJsonString(str);
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
    localVariantWrapper3.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
    QLog.i("ark.download.module", 1, "ark.dctrl.onQueryPackageState result:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.1.1
 * JD-Core Version:    0.7.0.1
 */