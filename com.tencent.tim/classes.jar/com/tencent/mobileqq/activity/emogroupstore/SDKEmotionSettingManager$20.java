package com.tencent.mobileqq.activity.emogroupstore;

import java.util.List;
import zdf;
import zdy;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(zdf paramzdf, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (zdf.a(this.this$0) != null) {
      zdf.a(this.this$0).dismiss();
    }
    zdf.a(this.this$0, false);
    if (this.cdb == this.cdd) {
      zdf.a(this.this$0, zdf.a(this.this$0), Long.valueOf(zdf.a(this.this$0)).longValue(), true);
    }
    while (this.cdb == 1)
    {
      int j = -1;
      int i = j;
      if (zdf.c(this.this$0) != null)
      {
        i = j;
        if (zdf.c(this.this$0).size() > 0) {
          i = ((Integer)zdf.c(this.this$0).get(0)).intValue();
        }
      }
      zdf.a(this.this$0, i, null);
      return;
      zdf.a(this.this$0, zdf.a(this.this$0), Long.valueOf(zdf.a(this.this$0)).longValue(), true, null);
    }
    zdf.a(this.this$0, this.cdd, this.cde, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */