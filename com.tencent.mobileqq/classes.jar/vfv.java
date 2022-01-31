import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;

public class vfv
  implements Animation.AnimationListener
{
  public vfv(TextTranslationItemBuilder paramTextTranslationItemBuilder, TextTranslationItemBuilder.Holder paramHolder, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.e.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.e.startAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.a.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.g = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.e.startAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfv
 * JD-Core Version:    0.7.0.1
 */