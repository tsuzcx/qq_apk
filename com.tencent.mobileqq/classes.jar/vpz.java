import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class vpz
  implements Runnable
{
  vpz(vpw paramvpw, PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vpw.c != null)
    {
      this.jdField_a_of_type_Vpw.c.clearAnimation();
      this.jdField_a_of_type_Vpw.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Vpw.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpz
 * JD-Core Version:    0.7.0.1
 */