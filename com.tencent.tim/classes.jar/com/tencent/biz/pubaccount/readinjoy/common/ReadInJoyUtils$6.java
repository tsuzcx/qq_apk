package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import anpc;
import java.util.HashMap;

public final class ReadInJoyUtils$6
  implements Runnable
{
  public ReadInJoyUtils$6(Context paramContext, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    anpc.a(this.val$context).collectPerformance(this.val$uin, "actKandianVideoH265GetURL", true, -1L, 0L, this.val$data, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.6
 * JD-Core Version:    0.7.0.1
 */