import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class utb
  implements Runnable
{
  public utb(XBubbleAnimation paramXBubbleAnimation, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimXBubbleAnimation.b(this.jdField_a_of_type_ArrayOfJavaLangObject);
    ThreadManager.getUIHandler().postDelayed(new utc(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utb
 * JD-Core Version:    0.7.0.1
 */