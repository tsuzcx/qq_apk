package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import artw;
import com.tencent.qphone.base.util.QLog;

class BindGroupConfirmActivity$3
  implements Runnable
{
  BindGroupConfirmActivity$3(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if (this.this$0.j == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.this$0.j, 2130843452);
        if (localBitmap == null) {
          continue;
        }
        localBitmap = artw.a(this.this$0, localBitmap, 50, 50);
        if (localBitmap == null) {
          continue;
        }
        this.this$0.runOnUiThread(new BindGroupConfirmActivity.3.1(this, localBitmap));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("BindGroupConfirmActivity", 2, "initUI decodeResource has OutOfMemoryError!");
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.3
 * JD-Core Version:    0.7.0.1
 */