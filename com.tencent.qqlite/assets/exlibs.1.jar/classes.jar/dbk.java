import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.utils.StartupTracker;

public class dbk
  implements Runnable
{
  public dbk(BubbleManager paramBubbleManager, int paramInt) {}
  
  public void run()
  {
    StartupTracker.a(null, "AIO_bubble_craete_bubble_info");
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_a_of_type_Int, true);
    StartupTracker.a("AIO_bubble_craete_bubble_info", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbk
 * JD-Core Version:    0.7.0.1
 */