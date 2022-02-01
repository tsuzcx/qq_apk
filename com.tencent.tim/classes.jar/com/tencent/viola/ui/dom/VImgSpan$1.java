package com.tencent.viola.ui.dom;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import com.tencent.viola.commons.ImageAdapterHolder.ImgSpanListener;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import java.lang.reflect.Field;

class VImgSpan$1
  implements ImageAdapterHolder.ImgSpanListener
{
  VImgSpan$1(VImgSpan paramVImgSpan) {}
  
  public void onSpanFInish(String paramString, Drawable paramDrawable, boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) || (paramDrawable == null)) {
      return;
    }
    try
    {
      paramString = ImageSpan.class.getDeclaredField("mDrawable");
      paramString.setAccessible(true);
      paramString.set(this.this$0, paramDrawable);
      paramString = DynamicDrawableSpan.class.getDeclaredField("mDrawableRef");
      paramString.setAccessible(true);
      paramString.set(this.this$0, null);
      if ((!VImgSpan.access$000(this.this$0)) && (VImgSpan.access$100(this.this$0) != null)) {
        ViolaSDKManager.getInstance().getRenderManager().postOnUiThread(new VImgSpan.1.1(this));
      }
      VImgSpan.access$002(this.this$0, true);
      return;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (NoSuchFieldException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VImgSpan.1
 * JD-Core Version:    0.7.0.1
 */