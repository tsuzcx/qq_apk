import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class ynz
  extends lce
{
  public ynz(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void k(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.this$0.sQ.clear();
        this.this$0.sQ.addAll(paramList);
      }
      ClassificationSearchActivity.b(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynz
 * JD-Core Version:    0.7.0.1
 */