package com.tencent.mobileqq.magicface.view;

import aiyr;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceViewController$3
  implements Runnable
{
  public MagicfaceViewController$3(aiyr paramaiyr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func run, magicValue:" + this.this$0.f.magicValue);
    }
    this.this$0.b(this.this$0.f, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.3
 * JD-Core Version:    0.7.0.1
 */