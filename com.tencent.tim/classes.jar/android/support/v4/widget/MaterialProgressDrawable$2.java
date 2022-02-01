package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MaterialProgressDrawable$2
  implements Animation.AnimationListener
{
  MaterialProgressDrawable$2(MaterialProgressDrawable paramMaterialProgressDrawable, MaterialProgressDrawable.Ring paramRing) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.val$ring.storeOriginals();
    this.val$ring.goToNextColor();
    this.val$ring.setStartTrim(this.val$ring.getEndTrim());
    if (this.this$0.mFinishing)
    {
      this.this$0.mFinishing = false;
      paramAnimation.setDuration(1332L);
      this.val$ring.setShowArrow(false);
      return;
    }
    MaterialProgressDrawable.access$402(this.this$0, (MaterialProgressDrawable.access$400(this.this$0) + 1.0F) % 5.0F);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    MaterialProgressDrawable.access$402(this.this$0, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.2
 * JD-Core Version:    0.7.0.1
 */