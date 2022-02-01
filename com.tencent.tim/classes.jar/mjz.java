import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import java.util.List;

public class mjz
  extends lce
{
  public mjz(ReadInJoyTopicSelectionFragment paramReadInJoyTopicSelectionFragment) {}
  
  public void l(List<String> paramList, List<TopicInfo> paramList1)
  {
    if (paramList.size() == 0)
    {
      ReadInJoyTopicSelectionFragment.a(this.a).clear();
      ReadInJoyTopicSelectionFragment.a(this.a).addAll(paramList1);
      this.a.jh.clear();
      this.a.jh.addAll(ReadInJoyTopicSelectionFragment.Y(paramList1));
      ReadInJoyTopicSelectionFragment.a(this.a).notifyDataSetChanged();
      kxm.a(ReadInJoyTopicSelectionFragment.a(this.a), ReadInJoyTopicSelectionFragment.a(this.a), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjz
 * JD-Core Version:    0.7.0.1
 */