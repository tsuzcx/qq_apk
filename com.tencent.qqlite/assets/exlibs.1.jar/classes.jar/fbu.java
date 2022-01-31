import com.tencent.mobileqq.widget.SlideTabWidget;
import com.tencent.mobileqq.widget.SlideTabWidget.OnTabSlideCompleteListener;

public class fbu
  implements Runnable
{
  public fbu(SlideTabWidget paramSlideTabWidget) {}
  
  public void run()
  {
    if (SlideTabWidget.a(this.a) != null) {
      SlideTabWidget.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbu
 * JD-Core Version:    0.7.0.1
 */