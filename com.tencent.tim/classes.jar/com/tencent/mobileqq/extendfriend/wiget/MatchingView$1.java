package com.tencent.mobileqq.extendfriend.wiget;

import afwv;
import afzb;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class MatchingView$1
  implements Runnable
{
  MatchingView$1(MatchingView paramMatchingView) {}
  
  public void run()
  {
    Object localObject = afwv.kJ("expend_match_ellipisis.json");
    try
    {
      localObject = new BufferedInputStream(new FileInputStream((String)localObject));
      LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new afzb(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MatchingView", 1, "loadEllipsisAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.MatchingView.1
 * JD-Core Version:    0.7.0.1
 */