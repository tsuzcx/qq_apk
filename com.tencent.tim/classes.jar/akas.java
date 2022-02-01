import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;

class akas
  extends AnimatorListenerAdapter
{
  akas(ajzv paramajzv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.crg = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.crg = false;
    this.this$0.Fc.findViewById(2131367404).setVisibility(8);
    this.this$0.Fc.findViewById(2131367378).setTranslationY(0.0F);
    this.this$0.Fc.findViewById(2131367403).setTranslationY(0.0F);
    this.this$0.Fc.findViewById(2131367413).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.this$0.crg = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.crg = true;
    int i = this.this$0.dlX;
    this.this$0.Fc.findViewById(2131367402).setBackgroundResource(2130846336);
    this.this$0.Fc.findViewById(2131367402).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.this$0.Fc.findViewById(2131367401).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akas
 * JD-Core Version:    0.7.0.1
 */