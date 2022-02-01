package com.tencent.qqmini.miniapp.widget.media.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;

class TXLivePusherJSAdapter$2
  implements TXLivePushListenerReflect.ITXSnapshotListener
{
  TXLivePusherJSAdapter$2(TXLivePusherJSAdapter paramTXLivePusherJSAdapter, TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener, boolean paramBoolean) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    if (this.val$listener != null)
    {
      if (!this.val$needCompress) {
        break label90;
      }
      if (paramBitmap != null)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Object localObject = new Matrix();
        ((Matrix)localObject).setScale(0.5F, 0.5F);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
        this.val$listener.onSnapshot((Bitmap)localObject);
        TXLivePusherJSAdapter.access$300(this.this$0, paramBitmap);
      }
    }
    else
    {
      return;
    }
    this.val$listener.onSnapshot(paramBitmap);
    return;
    label90:
    this.val$listener.onSnapshot(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.2
 * JD-Core Version:    0.7.0.1
 */