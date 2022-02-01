package com.tencent.mobileqq.text;

import aofd;
import java.io.File;

public final class EmotcationConstants$1
  implements Runnable
{
  public EmotcationConstants$1(File paramFile1, File paramFile2, File paramFile3) {}
  
  public void run()
  {
    if (this.aP.exists()) {
      this.aP.delete();
    }
    if (this.aQ.exists()) {
      this.aQ.delete();
    }
    aofd.F(this.aR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.text.EmotcationConstants.1
 * JD-Core Version:    0.7.0.1
 */