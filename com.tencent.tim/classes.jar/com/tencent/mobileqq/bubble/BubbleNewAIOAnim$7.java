package com.tencent.mobileqq.bubble;

import adxk;
import adxx;
import adyc;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class BubbleNewAIOAnim$7
  implements Runnable
{
  public BubbleNewAIOAnim$7(adxx paramadxx) {}
  
  public void run()
  {
    if ((this.this$0.vb != null) && (this.this$0.vb.size() > 0))
    {
      Iterator localIterator = this.this$0.vb.iterator();
      if (localIterator.hasNext())
      {
        adyc localadyc = (adyc)localIterator.next();
        File localFile = new File(this.this$0.b.a(this.this$0.bLf, false), this.this$0.h.zipName);
        int i = 0;
        label93:
        Object localObject1;
        String str;
        if (i < localadyc.cLb)
        {
          localObject1 = localFile.getAbsolutePath() + File.separatorChar + localadyc.bwg + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
          str = localadyc.key + (String)localObject1;
          if (this.this$0.eQ.containsKey(str)) {
            break label310;
          }
          Object localObject3 = BaseApplicationImpl.sImageCache.get(str);
          if ((localObject3 == null) || (!(localObject3 instanceof Bitmap))) {
            break label259;
          }
          localObject1 = (Bitmap)localObject3;
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            BaseApplicationImpl.sImageCache.put(str, localObject1);
            this.this$0.eQ.put(str, localObject1);
          }
          i += 1;
          break label93;
          break;
          try
          {
            label259:
            localObject1 = BubbleManager.decodeFile((String)localObject1, null);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("BubbleNewAIOAnim", 4, "decode error!", localException);
            }
            Object localObject2 = null;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.e("BubbleNewAIOAnim", 4, "decode error!", localOutOfMemoryError);
            }
            localBitmap = null;
          }
          continue;
          label310:
          Bitmap localBitmap = (Bitmap)this.this$0.eQ.get(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.7
 * JD-Core Version:    0.7.0.1
 */