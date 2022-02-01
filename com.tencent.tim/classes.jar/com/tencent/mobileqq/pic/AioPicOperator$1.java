package com.tencent.mobileqq.pic;

import akws;
import com.tencent.image.URLDrawable;

public class AioPicOperator$1
  implements Runnable
{
  public AioPicOperator$1(akws paramakws, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (this.s.getStatus() == 2) {
      this.s.restartDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioPicOperator.1
 * JD-Core Version:    0.7.0.1
 */