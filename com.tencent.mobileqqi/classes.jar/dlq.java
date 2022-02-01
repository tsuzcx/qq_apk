import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class dlq
  implements Runnable
{
  public dlq(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void run()
  {
    if (SubAccountMessageActivity.a(this.a) != null) {
      SubAccountMessageActivity.a(this.a).B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlq
 * JD-Core Version:    0.7.0.1
 */