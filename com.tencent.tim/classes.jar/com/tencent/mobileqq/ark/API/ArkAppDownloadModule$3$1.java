package com.tencent.mobileqq.ark.API;

import adnc;
import adnh;
import android.text.TextUtils;
import ascc;
import awok;
import awol;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import org.json.JSONObject;

public class ArkAppDownloadModule$3$1
  implements Runnable
{
  public ArkAppDownloadModule$3$1(adnh paramadnh, WadlResult paramWadlResult) {}
  
  public void run()
  {
    int i;
    ark.VariantWrapper localVariantWrapper1;
    if ((adnc.a(this.jdField_a_of_type_Adnh.this$0) != null) && (adnc.a(this.jdField_a_of_type_Adnh.this$0).size() > 0))
    {
      i = 0;
      if (i < adnc.a(this.jdField_a_of_type_Adnh.this$0).size())
      {
        localVariantWrapper1 = this.jdField_a_of_type_Adnh.this$0.b(((Long)adnc.a(this.jdField_a_of_type_Adnh.this$0).get(i)).longValue());
        if ((localVariantWrapper1 != null) && (this.jdField_a_of_type_CooperationWadlIpcWadlResult != null)) {
          break label101;
        }
        QLog.d("ark.download.module", 1, "ark.dctrl.onDownloadState Callback is null");
      }
    }
    return;
    label101:
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    int j = ascc.kR(this.jdField_a_of_type_CooperationWadlIpcWadlResult.bBa);
    String str;
    if (-2 == j)
    {
      j = ascc.kS(this.jdField_a_of_type_CooperationWadlIpcWadlResult.errCode);
      str = adnc.a(this.jdField_a_of_type_Adnh.this$0, j);
      if (!TextUtils.isEmpty(str)) {
        adnc.a(this.jdField_a_of_type_Adnh.this$0, str);
      }
      QLog.e("ark.download.module", 1, new Object[] { "ark.dctrl.download error code:", Integer.valueOf(j) });
      switch (j)
      {
      }
    }
    for (;;)
    {
      JSONObject localJSONObject = adnc.a(this.jdField_a_of_type_Adnh.this$0, this.jdField_a_of_type_CooperationWadlIpcWadlResult, "DownloadInit");
      str = "";
      if (localJSONObject != null) {
        str = localJSONObject.toString();
      }
      localVariantWrapper2.SetTableAsJsonString(str);
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      QLog.i("ark.download.module", 1, "ark.dctrl.onDownloadState callback : " + str);
      i += 1;
      break;
      if (this.jdField_a_of_type_CooperationWadlIpcWadlResult.a != null)
      {
        awok.a().cC(this.jdField_a_of_type_CooperationWadlIpcWadlResult.a.from, this.jdField_a_of_type_CooperationWadlIpcWadlResult.a.appId);
        continue;
        if (2 == j) {
          adnc.a(this.jdField_a_of_type_Adnh.this$0, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.3.1
 * JD-Core Version:    0.7.0.1
 */