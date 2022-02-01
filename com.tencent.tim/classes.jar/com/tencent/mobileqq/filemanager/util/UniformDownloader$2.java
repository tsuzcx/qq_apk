package com.tencent.mobileqq.filemanager.util;

import ahcj;
import ahcj.b;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

public class UniformDownloader$2
  implements Runnable
{
  public UniformDownloader$2(ahcj paramahcj, Bundle paramBundle, int paramInt, String paramString) {}
  
  public void run()
  {
    if (ahcj.a(this.this$0, false, ahcj.b(this.this$0))) {
      this.this$0.start();
    }
    for (;;)
    {
      return;
      if (this.bd != null) {
        this.bd.putBundle("_CB_USERDATA", ahcj.a(this.this$0));
      }
      Iterator localIterator = ahcj.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ahcj.b localb = (ahcj.b)localIterator.next();
        if (localb != null) {
          localb.b(this.val$errCode, this.bJV, this.bd);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloader.2
 * JD-Core Version:    0.7.0.1
 */