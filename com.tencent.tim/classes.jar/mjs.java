import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1.1.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.a;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class mjs
  implements ReadInJoyDraftboxFragment.a
{
  public mjs(ReadInJoyDraftboxFragment.1 param1) {}
  
  public void notify(List<ReadInJoyDraftboxItem> paramList)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxFragment.1.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjs
 * JD-Core Version:    0.7.0.1
 */