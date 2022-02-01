package com.tencent.mobileqq.emosm;

import afgn;
import afhv;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;

public class FavRoamingStrategy$7
  implements Runnable
{
  public FavRoamingStrategy$7(afgn paramafgn) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (!aqiw.isNetSupport(this.this$0.app.getApp()))) {
      return;
    }
    ((afhv)this.this$0.app.getManager(103)).cYZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */