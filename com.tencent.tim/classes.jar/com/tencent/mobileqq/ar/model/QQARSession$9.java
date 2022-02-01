package com.tencent.mobileqq.ar.model;

import adhr;
import adku;

public class QQARSession$9
  implements Runnable
{
  public QQARSession$9(adku paramadku, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    if (adku.c(this.this$0)) {
      if (adku.a(this.this$0) != null) {
        adku.b(this.this$0, false);
      }
    }
    int i;
    do
    {
      return;
      i = j;
      if (adku.a(this.this$0) != null)
      {
        i = j;
        if (adku.a(this.this$0).a != null)
        {
          i = j;
          if (adku.b(this.this$0))
          {
            i = j;
            if (this.this$0.cHX == 2) {
              i = 1;
            }
          }
        }
      }
      if ((this.val$success) && (i != 0))
      {
        adku.a(this.this$0, adku.a(this.this$0).a);
        return;
      }
    } while (i == 0);
    if (adku.a(this.this$0) != null) {
      adku.b(this.this$0, true);
    }
    this.this$0.cSr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.9
 * JD-Core Version:    0.7.0.1
 */