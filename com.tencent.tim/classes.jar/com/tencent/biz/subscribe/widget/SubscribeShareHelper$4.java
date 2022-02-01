package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.util.Map;
import jqc;
import san;
import siu;

public class SubscribeShareHelper$4
  implements Runnable
{
  public SubscribeShareHelper$4(siu paramsiu, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      if (siu.a(this.this$0) == null) {
        return;
      }
      localObject = jqc.a(BaseApplicationImpl.getContext(), siu.a(this.this$0).ns(), "GET", null, null);
      if (localObject == null) {
        break label132;
      }
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label132;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j <= 8000) {
        break label167;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label132;
    }
    catch (IOException localIOException)
    {
      label132:
      label167:
      for (;;) {}
    }
    this.eI.put("image", localObject);
    if (this.this$0.s != null)
    {
      this.this$0.s.runOnUiThread(this.cY);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */