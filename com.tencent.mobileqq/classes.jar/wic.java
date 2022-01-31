import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class wic
  extends ReadInJoyObserver
{
  public wic(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void e(boolean paramBoolean, List paramList)
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
 * Qualified Name:     wic
 * JD-Core Version:    0.7.0.1
 */