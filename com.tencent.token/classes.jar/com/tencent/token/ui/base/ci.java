package com.tencent.token.ui.base;

import com.tencent.token.global.h;

class ci
  implements Runnable
{
  ci(RecommendView paramRecommendView) {}
  
  public void run()
  {
    h.c("stopBlink");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ci
 * JD-Core Version:    0.7.0.1
 */