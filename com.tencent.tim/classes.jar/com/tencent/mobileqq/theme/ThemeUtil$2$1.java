package com.tencent.mobileqq.theme;

import acmi;
import aohe;
import com.tencent.mobileqq.app.QQAppInterface;

public class ThemeUtil$2$1
  implements Runnable
{
  public ThemeUtil$2$1(aohe paramaohe) {}
  
  public void run()
  {
    ThemeUtil.isNowThemeIsAnimate();
    acmi localacmi = (acmi)this.this$0.val$app.getBusinessHandler(14);
    if (localacmi != null) {
      localacmi.cMC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.2.1
 * JD-Core Version:    0.7.0.1
 */