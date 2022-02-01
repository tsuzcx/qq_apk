package com.tencent.gdtad.aditem;

import java.lang.ref.WeakReference;
import tgc;
import tgc.a;

public class GdtAdLoader$2
  implements Runnable
{
  public GdtAdLoader$2(tgc paramtgc) {}
  
  public void run()
  {
    if ((tgc.a(this.this$0) != null) && (tgc.a(this.this$0).get() != null)) {
      ((tgc.a)tgc.a(this.this$0).get()).onResponse(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.2
 * JD-Core Version:    0.7.0.1
 */