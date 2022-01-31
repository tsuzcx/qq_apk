import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.app.FrameActivity.TabInfo;
import java.util.List;

public class ctw
  implements Runnable
{
  public ctw(FrameActivity paramFrameActivity) {}
  
  public void run()
  {
    int i = 0;
    while (i < FrameActivity.a(this.a).size())
    {
      ((FrameActivity.TabInfo)FrameActivity.a(this.a).get(i)).a.k();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ctw
 * JD-Core Version:    0.7.0.1
 */