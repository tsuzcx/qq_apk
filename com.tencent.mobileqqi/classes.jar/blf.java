import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.statistics.ReportController;

public class blf
  implements View.OnTouchListener
{
  public blf(VideoInviteLock paramVideoInviteLock) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.a.j = ((int)paramMotionEvent.getRawX());
      this.a.i();
      continue;
      int i = (int)paramMotionEvent.getRawX() - this.a.j;
      if (i > 2)
      {
        this.a.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(4);
        this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      paramView = this.a.jdField_a_of_type_AndroidGraphicsRect;
      paramView.left += i;
      paramView = this.a.jdField_a_of_type_AndroidGraphicsRect;
      paramView.right = (i + paramView.right);
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right >= this.a.l)
      {
        this.a.jdField_a_of_type_AndroidGraphicsRect.right = this.a.l;
        this.a.jdField_a_of_type_AndroidGraphicsRect.left = (this.a.jdField_a_of_type_AndroidGraphicsRect.right - this.a.jdField_b_of_type_AndroidWidgetImageView.getWidth());
      }
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.left <= this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() + this.a.m)
      {
        this.a.jdField_a_of_type_AndroidGraphicsRect.left = (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() + this.a.m);
        this.a.jdField_a_of_type_AndroidGraphicsRect.right = (this.a.jdField_a_of_type_AndroidGraphicsRect.left + this.a.jdField_b_of_type_AndroidWidgetImageView.getWidth());
      }
      this.a.jdField_b_of_type_AndroidWidgetImageView.layout(this.a.jdField_a_of_type_AndroidGraphicsRect.left, this.a.jdField_b_of_type_AndroidGraphicsRect.top, this.a.jdField_a_of_type_AndroidGraphicsRect.right, this.a.jdField_b_of_type_AndroidGraphicsRect.bottom);
      this.a.jdField_d_of_type_AndroidWidgetImageView.layout(this.a.jdField_a_of_type_AndroidGraphicsRect.left - this.a.m, this.a.jdField_c_of_type_AndroidGraphicsRect.top, this.a.jdField_c_of_type_AndroidGraphicsRect.right, this.a.jdField_c_of_type_AndroidGraphicsRect.bottom);
      this.a.j = ((int)paramMotionEvent.getRawX());
      continue;
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right == this.a.l)
      {
        if (this.a.jdField_b_of_type_Boolean) {
          ReportController.b(null, "CliOper", "", "", "0X8004201", "0X8004201", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.f), "", "");
        }
        for (;;)
        {
          this.a.c();
          break;
          ReportController.b(null, "CliOper", "", "", "0X8004205", "0X8004205", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.f), "", "");
        }
      }
      if (this.a.jdField_a_of_type_AndroidGraphicsRect.right < this.a.l)
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.layout(this.a.jdField_b_of_type_AndroidGraphicsRect.left, this.a.jdField_b_of_type_AndroidGraphicsRect.top, this.a.jdField_b_of_type_AndroidGraphicsRect.right, this.a.jdField_b_of_type_AndroidGraphicsRect.bottom);
        this.a.jdField_d_of_type_AndroidWidgetImageView.layout(this.a.jdField_c_of_type_AndroidGraphicsRect.left, this.a.jdField_c_of_type_AndroidGraphicsRect.top, this.a.jdField_c_of_type_AndroidGraphicsRect.right, this.a.jdField_c_of_type_AndroidGraphicsRect.bottom);
        this.a.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.a.jdField_b_of_type_Boolean) {
          ReportController.b(null, "CliOper", "", "", "0X800439E", "0X800439E", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.f), "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80043FD", "0X80043FD", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.f), "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blf
 * JD-Core Version:    0.7.0.1
 */