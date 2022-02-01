package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;
import jqc;
import nng;

public class FastWebShareUtils$4
  implements Runnable
{
  public FastWebShareUtils$4(nng paramnng, String paramString, boolean paramBoolean, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    label149:
    try
    {
      localObject = jqc.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.akc), "GET", null, null);
      if (localObject == null) {
        break label127;
      }
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label127;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if ((i * j <= 8000) || (this.atA)) {
        break label149;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label127;
    }
    catch (IOException localIOException)
    {
      label127:
      for (;;) {}
    }
    this.eI.put("image", localObject);
    this.val$appInterface.runOnUiThread(this.cY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.4
 * JD-Core Version:    0.7.0.1
 */