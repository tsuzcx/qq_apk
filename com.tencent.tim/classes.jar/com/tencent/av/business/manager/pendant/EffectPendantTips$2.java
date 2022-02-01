package com.tencent.av.business.manager.pendant;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import ikk;
import iwu;

public class EffectPendantTips$2
  implements Runnable
{
  public EffectPendantTips$2(ikk paramikk, String paramString, Drawable paramDrawable) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.Nx)) {
        iwu.a(ikk.a(this.this$0), 1016, this.Nx, this.bV, -1, null);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTips.2
 * JD-Core Version:    0.7.0.1
 */