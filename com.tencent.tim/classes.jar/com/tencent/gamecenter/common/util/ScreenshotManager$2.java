package com.tencent.gamecenter.common.util;

import tbb;
import tbl;
import tbl.b;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(tbl paramtbl, String paramString, tbl.b paramb) {}
  
  public void run()
  {
    if (this.this$0.e(tbl.a(this.this$0), this.val$key))
    {
      this.a.onResponse(0, "succ");
      tbb.V("gamecenter_shot_key", this.val$key);
      return;
    }
    this.a.onResponse(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */