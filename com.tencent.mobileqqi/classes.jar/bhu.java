import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class bhu
  implements View.OnTouchListener
{
  public bhu(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.a.jdField_c_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.a.h();
      continue;
      int i = (int)paramMotionEvent.getRawX() - this.a.jdField_c_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d(GaInviteLockActivity.jdField_b_of_type_JavaLangString, 2, "dx = " + i);
      }
      this.a.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(4);
      this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView = this.a.jdField_a_of_type_AndroidGraphicsRect;
      paramView.left += i;
      paramView = this.a.jdField_a_of_type_AndroidGraphicsRect;
      paramView.right = (i + paramView.right);
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right >= this.a.jdField_d_of_type_Int)
      {
        this.a.jdField_a_of_type_AndroidGraphicsRect.right = this.a.jdField_d_of_type_Int;
        this.a.jdField_a_of_type_AndroidGraphicsRect.left = (this.a.jdField_a_of_type_AndroidGraphicsRect.right - this.a.jdField_b_of_type_AndroidWidgetImageView.getWidth());
      }
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.left <= this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() + this.a.e)
      {
        this.a.jdField_a_of_type_AndroidGraphicsRect.left = (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() + this.a.e);
        this.a.jdField_a_of_type_AndroidGraphicsRect.right = (this.a.jdField_a_of_type_AndroidGraphicsRect.left + this.a.jdField_b_of_type_AndroidWidgetImageView.getWidth());
      }
      this.a.jdField_b_of_type_AndroidWidgetImageView.layout(this.a.jdField_a_of_type_AndroidGraphicsRect.left, this.a.jdField_b_of_type_AndroidGraphicsRect.top, this.a.jdField_a_of_type_AndroidGraphicsRect.right, this.a.jdField_b_of_type_AndroidGraphicsRect.bottom);
      this.a.jdField_d_of_type_AndroidWidgetImageView.layout(this.a.jdField_a_of_type_AndroidGraphicsRect.left - this.a.e, this.a.jdField_c_of_type_AndroidGraphicsRect.top, this.a.jdField_c_of_type_AndroidGraphicsRect.right, this.a.jdField_c_of_type_AndroidGraphicsRect.bottom);
      this.a.jdField_c_of_type_Int = ((int)paramMotionEvent.getRawX());
      continue;
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right == this.a.jdField_d_of_type_Int)
      {
        this.a.b();
        ReportController.b(null, "CliOper", "", "", "0X800420E", "0X800420E", 0, 0, "", "", "", "");
      }
      else if (this.a.jdField_a_of_type_AndroidGraphicsRect.right < this.a.jdField_d_of_type_Int)
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.layout(this.a.jdField_b_of_type_AndroidGraphicsRect.left, this.a.jdField_b_of_type_AndroidGraphicsRect.top, this.a.jdField_b_of_type_AndroidGraphicsRect.right, this.a.jdField_b_of_type_AndroidGraphicsRect.bottom);
        this.a.jdField_d_of_type_AndroidWidgetImageView.layout(this.a.jdField_c_of_type_AndroidGraphicsRect.left, this.a.jdField_c_of_type_AndroidGraphicsRect.top, this.a.jdField_c_of_type_AndroidGraphicsRect.right, this.a.jdField_c_of_type_AndroidGraphicsRect.bottom);
        this.a.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhu
 * JD-Core Version:    0.7.0.1
 */