package com.tencent.mobileqq.minigame.jsapi.manager;

import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton;
import java.util.Map;

class CustomButtonManager$1
  implements Runnable
{
  CustomButtonManager$1(CustomButtonManager paramCustomButtonManager, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    CustomButton localCustomButton = (CustomButton)CustomButtonManager.access$000(this.this$0).get(Long.valueOf(this.val$componentId));
    if (localCustomButton != null) {
      localCustomButton.setVisible(this.val$visible);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.CustomButtonManager.1
 * JD-Core Version:    0.7.0.1
 */