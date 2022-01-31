import android.content.res.Resources;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;

public class bua
  implements View.OnTouchListener
{
  public bua(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838491);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131362033));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bua
 * JD-Core Version:    0.7.0.1
 */