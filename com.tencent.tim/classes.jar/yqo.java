import android.app.Activity;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.a;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.b;

public class yqo
  implements jny.a
{
  public yqo(GroupSearchRecommendView paramGroupSearchRecommendView) {}
  
  public void ayD()
  {
    if ((this.b.a == null) || (this.b.a.getActivity() == null) || (this.b.a.getActivity().isFinishing())) {
      return;
    }
    GroupSearchRecommendView.a(this.b).sendEmptyMessage(2);
  }
  
  public void ayE()
  {
    if ((this.b.a == null) || (this.b.a.getActivity() == null) || (this.b.a.getActivity().isFinishing())) {
      return;
    }
    GroupSearchRecommendView.a(this.b).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqo
 * JD-Core Version:    0.7.0.1
 */