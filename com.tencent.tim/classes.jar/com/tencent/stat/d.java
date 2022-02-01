package com.tencent.stat;

import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.util.TimerTask;

class d
  extends TimerTask
{
  d(c paramc) {}
  
  public void run()
  {
    if (StatConfig.isDebugEnable()) {
      StatCommonHelper.getLogger().i("TimerTask run");
    }
    StatServiceImpl.d(c.a(this.a));
    cancel();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.d
 * JD-Core Version:    0.7.0.1
 */