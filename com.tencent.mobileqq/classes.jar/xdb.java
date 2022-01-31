import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;

public class xdb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public xdb(CommonHbFragment paramCommonHbFragment, View paramView, ImageView paramImageView, URLDrawable paramURLDrawable) {}
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int k = this.jdField_a_of_type_AndroidViewView.getHeight();
    int j = (int)(k * 3.076923076923077D + 0.5D);
    int i = j;
    if (j > CommonHbFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment)) {
      i = CommonHbFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment);
    }
    if ((i > 0) && (k > 0))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, k);
      localLayoutParams.gravity = 5;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdb
 * JD-Core Version:    0.7.0.1
 */