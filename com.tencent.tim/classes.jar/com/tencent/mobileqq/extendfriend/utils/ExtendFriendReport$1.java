package com.tencent.mobileqq.extendfriend.utils;

import afxv;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ExtendFriendReport$1
  implements Runnable
{
  public ExtendFriendReport$1(afxv paramafxv, String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3) {}
  
  public void run()
  {
    try
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(this.val$uin, this.val$tagName, this.val$success, this.val$duration, this.val$size, this.aK, this.bFV);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport.1
 * JD-Core Version:    0.7.0.1
 */