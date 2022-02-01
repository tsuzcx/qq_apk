package com.tencent.mobileqq.mini.widget;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CanvasView$1$1
  implements Runnable
{
  CanvasView$1$1(CanvasView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$currBitmap == null)
    {
      this.this$1.this$0.callbackJsEventFail(this.this$1.val$event, null, this.this$1.val$callBackId);
      return;
    }
    int i3 = this.this$1.this$0.mpx2pxInt(this.this$1.val$paramObj.optInt("x"));
    int i6 = this.this$1.this$0.mpx2pxInt(this.this$1.val$paramObj.optInt("y"));
    int i4 = this.this$1.val$paramObj.optInt("width");
    int i5 = this.this$1.val$paramObj.optInt("height");
    int i1 = this.this$1.this$0.mpx2pxInt(i4);
    int i2 = this.this$1.this$0.mpx2pxInt(i5);
    int n = i1;
    if (i1 > this.val$currBitmap.getWidth()) {
      n = this.val$currBitmap.getWidth();
    }
    i1 = i2;
    if (i2 > this.val$currBitmap.getHeight()) {
      i1 = this.val$currBitmap.getHeight();
    }
    label540:
    label560:
    for (;;)
    {
      try
      {
        Object localObject2 = new int[n * i1];
        this.val$currBitmap.getPixels((int[])localObject2, 0, n, i3, i6, n, i1);
        byte[] arrayOfByte = new byte[n * i1 * 4];
        i2 = 0;
        break label540;
        if (i3 < n)
        {
          int i7 = n * i2 + i3;
          i6 = i7 * 4;
          i7 = localObject2[i7];
          int i = (byte)Color.alpha(i7);
          int j = (byte)Color.red(i7);
          int k = (byte)Color.green(i7);
          int m = (byte)Color.blue(i7);
          arrayOfByte[i6] = j;
          arrayOfByte[(i6 + 1)] = k;
          arrayOfByte[(i6 + 2)] = m;
          arrayOfByte[(i6 + 3)] = i;
          i3 += 1;
          continue;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("width", i4);
          ((JSONObject)localObject2).put("height", i5);
          NativeBuffer.packNativeBuffer(arrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "data", (JSONObject)localObject2, null);
          this.this$1.this$0.callbackJsEventOK(this.this$1.val$event, (JSONObject)localObject2, this.this$1.val$callBackId);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(CanvasView.access$100(), 2, "getImageData failed: " + Log.getStackTraceString(localThrowable));
        this.this$1.this$0.callbackJsEventFail(this.this$1.val$event, null, this.this$1.val$callBackId);
        return;
      }
      finally
      {
        if ((this.val$currBitmap != null) && (!this.val$currBitmap.isRecycled())) {
          this.val$currBitmap.recycle();
        }
      }
      for (;;)
      {
        if (i2 >= i1) {
          break label560;
        }
        i3 = 0;
        break;
        i2 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */