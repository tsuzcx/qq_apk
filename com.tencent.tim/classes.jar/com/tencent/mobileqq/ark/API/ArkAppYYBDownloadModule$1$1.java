package com.tencent.mobileqq.ark.API;

import adon;
import adoo;
import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ArkAppYYBDownloadModule$1$1
  implements Runnable
{
  public ArkAppYYBDownloadModule$1$1(adoo paramadoo, String paramString) {}
  
  public void run()
  {
    int i;
    if ((adon.a(this.a.this$0) != null) && (adon.a(this.a.this$0).size() > 0)) {
      i = 0;
    }
    for (;;)
    {
      ark.VariantWrapper localVariantWrapper1;
      if (i < adon.a(this.a.this$0).size())
      {
        localVariantWrapper1 = this.a.this$0.b(((Long)adon.a(this.a.this$0).get(i)).longValue());
        if ((localVariantWrapper1 == null) || (TextUtils.isEmpty(this.buR))) {
          QLog.d("ArkApp.downloadyyb.module", 1, "onDownloadState Callback is null");
        }
      }
      else
      {
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      localVariantWrapper2.SetNull();
      ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
      localVariantWrapper2.SetTableAsJsonString(this.buR);
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.downloadyyb.module", 1, "onDownloadState callback : " + this.buR);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.1.1
 * JD-Core Version:    0.7.0.1
 */