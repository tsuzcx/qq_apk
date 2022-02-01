package com.tencent.gdtad.aditem;

import android.content.Context;
import arlc;
import java.lang.ref.WeakReference;

final class GdtHandler$1
  implements Runnable
{
  GdtHandler$1(GdtHandler.Params paramParams) {}
  
  public void run()
  {
    if ((this.b != null) && (this.b.activity != null) && (this.b.activity.get() != null)) {
      arlc.sendWindowClosedBroadcast((Context)this.b.activity.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.1
 * JD-Core Version:    0.7.0.1
 */