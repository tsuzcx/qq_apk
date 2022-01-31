package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;

public class UpdateBubbleZip
  extends Step
{
  public static final String b = "bubble_info";
  
  protected boolean a()
  {
    TroopNotificationUtils.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateBubbleZip
 * JD-Core Version:    0.7.0.1
 */