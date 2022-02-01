package com.tencent.mobileqq.applets;

import adak;
import android.text.TextUtils;
import awmt;
import awmu;

public final class PublicAccountEventReport$4
  implements Runnable
{
  public PublicAccountEventReport$4(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = adak.jI(this.brx);
    int j;
    String str;
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      j = (int)(System.currentTimeMillis() / 1000L);
      str = this.val$uin + "_" + j;
      k = this.val$actionId;
      if (!this.bKI) {
        break label117;
      }
    }
    label117:
    for (int i = 6;; i = 1)
    {
      localObject = new awmu(str, 1, k, i, "vab_push", "vab_push", (String)localObject, "vab_push", j);
      ((awmu)localObject).cRJ = this.brx;
      ((awmu)localObject).cNQ = "vab_push";
      awmt.a().a((awmu)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.4
 * JD-Core Version:    0.7.0.1
 */