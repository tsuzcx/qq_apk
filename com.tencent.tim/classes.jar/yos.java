import android.app.Activity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.a;
import com.tencent.mobileqq.app.QQAppInterface;

public class yos
  implements GroupSearchRecommendView.a
{
  public yos(SearchContactsFragment paramSearchContactsFragment) {}
  
  public Activity getActivity()
  {
    return this.a.d();
  }
  
  public QQAppInterface getApp()
  {
    return this.a.app;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yos
 * JD-Core Version:    0.7.0.1
 */