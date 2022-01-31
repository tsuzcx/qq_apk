import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class vmx
  implements Runnable
{
  vmx(vmu paramvmu, PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vmu.c != null)
    {
      this.jdField_a_of_type_Vmu.c.clearAnimation();
      this.jdField_a_of_type_Vmu.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Vmu.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vmx
 * JD-Core Version:    0.7.0.1
 */