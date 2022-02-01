package com.tencent.mobileqq.app.automator.step;

import alsb;
import avyh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.startup.step.InstallPlugins;

public class GetQZoneFeeds
  extends AsyncStep
{
  public static boolean bJM;
  
  public int od()
  {
    bJM = true;
    ((alsb)this.a.app.getManager(91)).updateQzoneFeeds();
    ((avyh)this.a.app.getManager(175)).ezM();
    InstallPlugins.report(1);
    InstallPlugins.dRQ();
    return super.od();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeeds
 * JD-Core Version:    0.7.0.1
 */