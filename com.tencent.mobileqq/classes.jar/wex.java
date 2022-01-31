import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class wex
  extends ReadInJoyObserver
{
  public wex(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void d(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.c.clear();
        this.a.c.addAll(paramList);
      }
      ClassificationSearchActivity.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wex
 * JD-Core Version:    0.7.0.1
 */