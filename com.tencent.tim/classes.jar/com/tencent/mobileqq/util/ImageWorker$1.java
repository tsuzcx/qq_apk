package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import aqeb;
import aqeb.b;

public class ImageWorker$1
  implements Runnable
{
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Aqeb$b.a(new Object[] { this.css, this.jdField_a_of_type_Aqdz, Boolean.valueOf(true) });
    aqeb.a(this.this$0).post(new ImageWorker.1.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.1
 * JD-Core Version:    0.7.0.1
 */