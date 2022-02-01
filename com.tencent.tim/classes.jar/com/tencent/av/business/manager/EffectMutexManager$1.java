package com.tencent.av.business.manager;

import android.util.SparseArray;
import ijt;
import ijt.a;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(ijt paramijt, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < ijt.a(this.this$0).size())
    {
      ijt.a locala = (ijt.a)ijt.a(this.this$0).valueAt(i);
      if ((locala != null) && (ijt.a(this.this$0).keyAt(i) != this.anM)) {
        locala.Y(this.anM, this.val$data);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */