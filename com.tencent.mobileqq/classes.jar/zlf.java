import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class zlf
  implements View.OnTouchListener
{
  private zlf(QRDisplayActivity paramQRDisplayActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_c_of_type_Int == 1) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if ((2131374802 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.a.setAlpha(0.5F);
      }
      else if ((2131374817 == paramView.getId()) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        this.a.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        continue;
        if ((2131374802 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
        {
          this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          this.a.a.setAlpha(1.0F);
        }
        else if ((2131374817 == paramView.getId()) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView != null))
        {
          this.a.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          continue;
          if (this.a.jdField_c_of_type_Int == 2) {
            switch (paramMotionEvent.getAction())
            {
            case 2: 
            default: 
              break;
            case 0: 
              if ((2131374825 == paramView.getId()) && (this.a.d != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null))
              {
                this.a.d.setAlpha(0.5F);
                this.a.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
              }
              else if ((2131374805 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
              {
                this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.5F);
                this.a.a.setAlpha(0.5F);
              }
              break;
            case 1: 
            case 3: 
              if ((2131374825 == paramView.getId()) && (this.a.d != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null))
              {
                this.a.d.setAlpha(1.0F);
                this.a.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
              }
              else if ((2131374805 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
              {
                this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
                this.a.a.setAlpha(1.0F);
              }
              break;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlf
 * JD-Core Version:    0.7.0.1
 */