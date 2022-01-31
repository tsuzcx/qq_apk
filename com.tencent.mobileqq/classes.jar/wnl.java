import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class wnl
  extends SearchProtocol.SearchObserver
{
  public wnl(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchActivity", 2, "hot words size: " + paramList.size());
      }
      this.a.b = paramList;
      ClassificationSearchActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnl
 * JD-Core Version:    0.7.0.1
 */