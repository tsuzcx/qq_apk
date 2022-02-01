import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.lebasearch.SearchProtocol.a;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yny
  extends SearchProtocol.a
{
  public yny(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void i(int paramInt, List<SearchProtocol.WordItem> paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchActivity", 2, "hot words size: " + paramList.size());
      }
      this.this$0.sP = paramList;
      ClassificationSearchActivity.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yny
 * JD-Core Version:    0.7.0.1
 */