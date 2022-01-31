import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class uoc
  implements Runnable
{
  public uoc(XBubbleAnimation paramXBubbleAnimation, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.b(this.jdField_a_of_type_ArrayOfJavaLangObject);
    ThreadManager.getUIHandler().postDelayed(new uod(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uoc
 * JD-Core Version:    0.7.0.1
 */