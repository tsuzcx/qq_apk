package com.tencent.mobileqq.minigame.jsapi.manager;

import android.view.ViewGroup;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton;
import java.util.Map;

class CustomButtonManager$2
  implements Runnable
{
  CustomButtonManager$2(CustomButtonManager paramCustomButtonManager, long paramLong) {}
  
  public void run()
  {
    CustomButton localCustomButton = (CustomButton)CustomButtonManager.access$000(this.this$0).get(Long.valueOf(this.val$componentId));
    CustomButtonManager.access$000(this.this$0).remove(Long.valueOf(this.val$componentId));
    if (localCustomButton != null)
    {
      CustomButtonManager.access$100(this.this$0).getGameParent().removeView(localCustomButton.getButton());
      localCustomButton.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.CustomButtonManager.2
 * JD-Core Version:    0.7.0.1
 */