package com.tencent.mobileqq.app.automator.step;

import allp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetQZonePhotoGuideCheck
  extends AsyncStep
{
  public static boolean bJM;
  
  public int od()
  {
    bJM = true;
    allp localallp = (allp)this.a.app.getManager(104);
    if (localallp != null) {
      localallp.dGC();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck
 * JD-Core Version:    0.7.0.1
 */