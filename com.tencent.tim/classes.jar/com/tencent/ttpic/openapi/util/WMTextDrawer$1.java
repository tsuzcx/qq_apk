package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;

class WMTextDrawer$1
  extends WMTextDrawer.AsyncDrawRunnable
{
  WMTextDrawer$1(WMTextDrawer paramWMTextDrawer, TextWMElement paramTextWMElement, String paramString, boolean paramBoolean)
  {
    super(paramWMTextDrawer);
  }
  
  public void run()
  {
    Object localObject = this.val$element.getIdleBitmap();
    if ((!BitmapUtils.isLegal((Bitmap)localObject)) || (this.val$text == null)) {
      WMTextDrawer.access$002(this.this$0, true);
    }
    String str;
    do
    {
      return;
      if (this.val$updateShaderBmp) {}
      for (str = this.this$0.lastDrawText;; str = this.val$text)
      {
        if (BitmapUtils.isLegal((Bitmap)localObject)) {
          ((Bitmap)localObject).eraseColor(0);
        }
        if (str.length() != 0) {
          break;
        }
        WMTextDrawer.access$002(this.this$0, true);
        return;
      }
    } while (!BitmapUtils.isLegal((Bitmap)localObject));
    localObject = new Canvas((Bitmap)localObject);
    if (this.val$element.vertical == 0) {
      WMTextDrawer.access$100(this.this$0, this.val$element, (Canvas)localObject, ((Canvas)localObject).getWidth(), ((Canvas)localObject).getHeight(), str);
    }
    for (;;)
    {
      this.val$element.swapActiveBitmap();
      this.val$element.setContentChanged(true);
      if (this.isTaskCanceled) {
        this.val$element.setContentChanged(false);
      }
      WMTextDrawer.access$002(this.this$0, true);
      return;
      WMTextDrawer.access$200(this.this$0, this.val$element, (Canvas)localObject, ((Canvas)localObject).getWidth(), ((Canvas)localObject).getHeight(), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.WMTextDrawer.1
 * JD-Core Version:    0.7.0.1
 */