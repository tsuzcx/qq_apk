package com.tencent.tim.timfiletab;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import java.util.ArrayList;
import java.util.List;

class TimFileFrame$1
  implements Runnable
{
  TimFileFrame$1(TimFileFrame paramTimFileFrame) {}
  
  public void run()
  {
    Object localObject = (WebProcessManager)this.this$0.app.getManager(13);
    localObject = new ArrayList();
    ((List)localObject).add("https://docs.qq.com/doc/");
    ((List)localObject).add("https://docs.qq.com/sheet/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timfiletab.TimFileFrame.1
 * JD-Core Version:    0.7.0.1
 */