package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import thj;
import thk;
import thl;
import tkw;

public class GdtArkPreDownloadTask$6$1
  implements Runnable
{
  public GdtArkPreDownloadTask$6$1(thk paramthk, ArkAppMgr.AppPathInfo paramAppPathInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1 = null;
    try
    {
      Object localObject1 = AdJSON.fromObject(this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo);
      i = this.val$retCode;
      String str2 = this.val$msg;
      if (localObject1 != null) {
        str1 = localObject1.toString();
      }
      tkw.i("GdtArkPreDownloadTask", String.format("onGetAppPathByName retCode:%d msg:%s appPathInfo:%s", new Object[] { Integer.valueOf(i), str2, str1 }));
      if (this.val$retCode == -6) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        tkw.i("GdtArkPreDownloadTask", "onGetAppPathByName", localThrowable);
        Object localObject2 = null;
      }
      int k = thl.ew(this.val$retCode);
      if ((k == 0) && (this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo.path)) && (!TextUtils.isEmpty(thj.a(this.jdField_a_of_type_Thk.this$0)))) {}
      int j;
      for (int i = 1;; i = 0)
      {
        j = k;
        if (i == 0)
        {
          j = k;
          if (k == 0) {
            j = 1;
          }
        }
        if (i == 0) {
          break;
        }
        thj.a(this.jdField_a_of_type_Thk.this$0, 3);
        thj.b(this.jdField_a_of_type_Thk.this$0);
        return;
      }
      thj.a(this.jdField_a_of_type_Thk.this$0, 4);
      thj.a(this.jdField_a_of_type_Thk.this$0, j, this.val$retCode, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1
 * JD-Core Version:    0.7.0.1
 */