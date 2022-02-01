package com.tencent.mobileqq.activity.emogroupstore;

import java.util.List;
import zdf;
import zdy;

public class SDKEmotionSettingManager$21
  implements Runnable
{
  public SDKEmotionSettingManager$21(zdf paramzdf, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
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
      zdf.a(this.this$0, ((Integer)this.ub.get(0)).intValue(), this.aZX);
      return;
      zdf.a(this.this$0, zdf.a(this.this$0), Long.valueOf(zdf.a(this.this$0)).longValue(), true, this.aZX);
    }
    zdf.a(this.this$0, this.cdd, this.cde, this.aZX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
 * JD-Core Version:    0.7.0.1
 */