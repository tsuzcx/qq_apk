package com.tencent.mobileqq.vas;

import ajdq;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, PobingDecoder.a parama) {}
  
  public void run()
  {
    ajdq localajdq = (ajdq)this.this$0.callbackRef.get();
    if (localajdq != null) {
      localajdq.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */