package com.tencent.gamecenter.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import tbl;
import tbl.b;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(tbl paramtbl, String paramString, tbl.b paramb) {}
  
  public void run()
  {
    tbl localtbl;
    if (!TextUtils.isEmpty(this.val$key))
    {
      localtbl = this.this$0;
      if (tbl.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(tbl.aIZ + this.val$key);; localBitmap = tbl.a(this.this$0))
    {
      tbl.a(localtbl, localBitmap);
      if (this.a != null) {
        this.a.onResponse(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */