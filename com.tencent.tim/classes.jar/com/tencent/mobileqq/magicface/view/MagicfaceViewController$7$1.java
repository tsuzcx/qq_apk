package com.tencent.mobileqq.magicface.view;

import aixt;
import aiyr;
import aiyu;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;

public class MagicfaceViewController$7$1
  implements Runnable
{
  public MagicfaceViewController$7$1(aiyu paramaiyu, aixt paramaixt) {}
  
  public void run()
  {
    
    if (this.a.val$type == 0) {
      this.a.this$0.dvz();
    }
    for (;;)
    {
      this.a.this$0.Ux.setText("");
      this.a.this$0.Uy.setText("");
      if ((this.b != null) && ("gravity".equalsIgnoreCase(this.b.bPV))) {
        this.a.this$0.c.turnOffShake();
      }
      return;
      ((View)this.a.this$0.b).setBackgroundColor(this.b.dgh);
      this.a.this$0.dvA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.1
 * JD-Core Version:    0.7.0.1
 */