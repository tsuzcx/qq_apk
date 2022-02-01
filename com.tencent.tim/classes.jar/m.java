import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.e;

class m
  implements ValueAnimator.AnimatorUpdateListener
{
  m(l paraml) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.M[0])
    {
      this.a.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.a.frameIndex = 0;
      this.a.mFont.mShouldDisplayAnimation = false;
      this.a.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isFounderAnimating = false;
      this.a.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
      if (this.a.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mAnimationListener != null) {
        this.a.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mAnimationListener.a(this.a.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMessage, this.a.mFont.mFontId);
      }
    }
    while (i <= this.a.frameIndex) {
      return;
    }
    this.a.frameIndex = i;
    this.a.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */