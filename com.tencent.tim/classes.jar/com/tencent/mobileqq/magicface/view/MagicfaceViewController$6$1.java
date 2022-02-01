package com.tencent.mobileqq.magicface.view;

import aiyr;
import aiyt;
import android.widget.ImageView;
import android.widget.TextView;

public class MagicfaceViewController$6$1
  implements Runnable
{
  public MagicfaceViewController$6$1(aiyt paramaiyt, String paramString) {}
  
  public void run()
  {
    if (this.a.val$type == 1)
    {
      if (this.val$text != null) {
        break label48;
      }
      this.a.this$0.Ba.setVisibility(8);
    }
    for (;;)
    {
      this.a.UB.setText(this.val$text);
      return;
      label48:
      this.a.this$0.Ba.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.6.1
 * JD-Core Version:    0.7.0.1
 */