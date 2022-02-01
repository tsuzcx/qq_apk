package com.tencent.mobileqq.mini.widget.input;

import android.animation.ObjectAnimator;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;

class WebInputHandler$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WebInputHandler$5(WebInputHandler paramWebInputHandler, WebEditText paramWebEditText) {}
  
  public void onGlobalLayout()
  {
    if ((this.val$webEditText.isFocused()) && (WebInputHandler.access$300(this.this$0)))
    {
      localObject = new int[2];
      this.val$webEditText.getLocationOnScreen((int[])localObject);
      i = localObject[1];
      i = DisplayUtil.getRealHeight(this.val$webEditText.getContext()) - (i + this.val$webEditText.getHeight()) - this.val$webEditText.getMarginBottom();
      if ((WebInputHandler.access$400(this.this$0) > i) && (this.val$webEditText.isAdjustPosition()) && (WebInputHandler.access$300(this.this$0)) && (WebInputHandler.access$000(this.this$0) != null) && (WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer() != null))
      {
        localObject = ObjectAnimator.ofFloat(WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer(), "translationY", new float[] { 0.0F, -(WebInputHandler.access$400(this.this$0) - i) });
        ((ObjectAnimator)localObject).setDuration(200L);
        ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ObjectAnimator)localObject).start();
      }
    }
    while ((WebInputHandler.access$300(this.this$0)) || (WebInputHandler.access$000(this.this$0) == null) || (WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer() == null))
    {
      int i;
      return;
    }
    Object localObject = ObjectAnimator.ofFloat(WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer(), "translationY", new float[] { WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().getTranslationY(), 0.0F });
    ((ObjectAnimator)localObject).setDuration(200L);
    ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((ObjectAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler.5
 * JD-Core Version:    0.7.0.1
 */