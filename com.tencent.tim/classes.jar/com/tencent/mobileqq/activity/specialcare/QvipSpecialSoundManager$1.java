package com.tencent.mobileqq.activity.specialcare;

import abbg.a;
import android.content.Context;
import java.io.File;

class QvipSpecialSoundManager$1
  implements Runnable
{
  QvipSpecialSoundManager$1(QvipSpecialSoundManager paramQvipSpecialSoundManager, abbg.a parama) {}
  
  public void run()
  {
    if (this.this$0.jc(this.a.ace))
    {
      File localFile = new File(QvipSpecialSoundManager.a(this.this$0).getFilesDir(), this.a.ace);
      if (localFile.exists()) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.this$0.gK(l);
        return;
      }
    }
    this.this$0.cK("updateSpecialSound down fial, id=" + this.a.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.1
 * JD-Core Version:    0.7.0.1
 */