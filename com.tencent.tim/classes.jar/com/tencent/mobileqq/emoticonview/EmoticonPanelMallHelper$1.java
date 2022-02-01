package com.tencent.mobileqq.emoticonview;

import afnh;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class EmoticonPanelMallHelper$1
  implements Runnable
{
  public EmoticonPanelMallHelper$1(afnh paramafnh, boolean paramBoolean, EmoticonPanelController.b paramb) {}
  
  public void run()
  {
    this.this$0.a.HX(this.bZG);
    if (this.a != null) {
      ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1
 * JD-Core Version:    0.7.0.1
 */