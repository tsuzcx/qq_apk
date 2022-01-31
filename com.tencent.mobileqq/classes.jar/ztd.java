import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.device.msg.activities.DeviceTipActivity;

public class ztd
  implements View.OnTouchListener
{
  public ztd(DeviceTipActivity paramDeviceTipActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.a.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawX());
      DeviceTipActivity.c(this.a);
      continue;
      int i = (int)paramMotionEvent.getRawX() - this.a.jdField_b_of_type_Int;
      if (i > 2)
      {
        this.a.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(4);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      paramView = this.a.jdField_a_of_type_AndroidGraphicsRect;
      paramView.left += i;
      paramView = this.a.jdField_a_of_type_AndroidGraphicsRect;
      paramView.right = (i + paramView.right);
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right >= this.a.d)
      {
        this.a.jdField_a_of_type_AndroidGraphicsRect.right = this.a.d;
        this.a.jdField_a_of_type_AndroidGraphicsRect.left = (this.a.jdField_a_of_type_AndroidGraphicsRect.right - this.a.jdField_a_of_type_AndroidWidgetImageView.getWidth());
      }
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.left <= this.a.e)
      {
        this.a.jdField_a_of_type_AndroidGraphicsRect.left = this.a.e;
        this.a.jdField_a_of_type_AndroidGraphicsRect.right = (this.a.jdField_a_of_type_AndroidGraphicsRect.left + this.a.jdField_a_of_type_AndroidWidgetImageView.getWidth());
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.layout(this.a.jdField_a_of_type_AndroidGraphicsRect.left, this.a.jdField_b_of_type_AndroidGraphicsRect.top, this.a.jdField_a_of_type_AndroidGraphicsRect.right, this.a.jdField_b_of_type_AndroidGraphicsRect.bottom);
      this.a.jdField_c_of_type_AndroidWidgetImageView.layout(this.a.jdField_a_of_type_AndroidGraphicsRect.left - this.a.e, this.a.jdField_c_of_type_AndroidGraphicsRect.top, this.a.jdField_c_of_type_AndroidGraphicsRect.right, this.a.jdField_c_of_type_AndroidGraphicsRect.bottom);
      this.a.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawX());
      continue;
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right == this.a.d)
      {
        this.a.b();
      }
      else if (this.a.jdField_a_of_type_AndroidGraphicsRect.right < this.a.d)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.layout(this.a.jdField_b_of_type_AndroidGraphicsRect.left, this.a.jdField_b_of_type_AndroidGraphicsRect.top, this.a.jdField_b_of_type_AndroidGraphicsRect.right, this.a.jdField_b_of_type_AndroidGraphicsRect.bottom);
        this.a.jdField_c_of_type_AndroidWidgetImageView.layout(this.a.jdField_c_of_type_AndroidGraphicsRect.left, this.a.jdField_c_of_type_AndroidGraphicsRect.top, this.a.jdField_c_of_type_AndroidGraphicsRect.right, this.a.jdField_c_of_type_AndroidGraphicsRect.bottom);
        this.a.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ztd
 * JD-Core Version:    0.7.0.1
 */