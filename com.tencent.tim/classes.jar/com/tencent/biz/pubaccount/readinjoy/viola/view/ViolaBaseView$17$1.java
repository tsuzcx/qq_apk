package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import arwv;
import com.tencent.qphone.base.util.QLog;
import nxg;

public class ViolaBaseView$17$1
  implements Runnable
{
  public ViolaBaseView$17$1(nxg paramnxg, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.access$700();
    StringBuilder localStringBuilder = new StringBuilder().append("loadJSSource process from downJsFromOfflineForNext url: ").append(this.a.this$0.anN).append(" , js source Md5 :");
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.a.this$0))) {}
    for (String str1 = ViolaBaseView.b(this.a.this$0);; str1 = "")
    {
      QLog.d(str2, 2, arwv.toMD5(str1) + " js down source MD5 " + arwv.toMD5(this.val$result));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.17.1
 * JD-Core Version:    0.7.0.1
 */