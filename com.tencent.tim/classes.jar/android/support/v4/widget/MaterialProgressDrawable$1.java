package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

class MaterialProgressDrawable$1
  extends Animation
{
  MaterialProgressDrawable$1(MaterialProgressDrawable paramMaterialProgressDrawable, MaterialProgressDrawable.Ring paramRing) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.this$0.mFinishing)
    {
      MaterialProgressDrawable.access$000(this.this$0, paramFloat, this.val$ring);
      return;
    }
    float f1 = MaterialProgressDrawable.access$100(this.this$0, this.val$ring);
    float f2 = this.val$ring.getStartingEndTrim();
    float f4 = this.val$ring.getStartingStartTrim();
    float f3 = this.val$ring.getStartingRotation();
    MaterialProgressDrawable.access$200(this.this$0, paramFloat, this.val$ring);
    if (paramFloat <= 0.5F)
    {
      float f5 = paramFloat / 0.5F;
      f5 = MaterialProgressDrawable.access$300().getInterpolation(f5);
      this.val$ring.setStartTrim(f4 + f5 * (0.8F - f1));
    }
    if (paramFloat > 0.5F)
    {
      f4 = (paramFloat - 0.5F) / 0.5F;
      f4 = MaterialProgressDrawable.access$300().getInterpolation(f4);
      this.val$ring.setEndTrim((0.8F - f1) * f4 + f2);
    }
    this.val$ring.setRotation(0.25F * paramFloat + f3);
    f1 = MaterialProgressDrawable.access$400(this.this$0) / 5.0F;
    this.this$0.setRotation(216.0F * paramFloat + 1080.0F * f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.1
 * JD-Core Version:    0.7.0.1
 */