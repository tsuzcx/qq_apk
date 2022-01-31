import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;

public class egh
  implements Animation.AnimationListener
{
  public egh(TextTranslationItemBuilder paramTextTranslationItemBuilder, TextTranslationItemBuilder.Holder paramHolder, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.jdField_a_of_type_AndroidWidgetTextView.startAnimation(TextTranslationItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.jdField_a_of_type_AndroidViewViewGroup.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.d = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.d = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.jdField_a_of_type_AndroidWidgetTextView.startAnimation(TextTranslationItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     egh
 * JD-Core Version:    0.7.0.1
 */