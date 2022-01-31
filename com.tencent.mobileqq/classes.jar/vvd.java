import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class vvd
  implements Runnable
{
  vvd(vva paramvva, PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vva.c != null)
    {
      this.jdField_a_of_type_Vva.c.clearAnimation();
      this.jdField_a_of_type_Vva.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Vva.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvd
 * JD-Core Version:    0.7.0.1
 */