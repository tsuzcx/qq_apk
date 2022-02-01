import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import cooperation.qzone.api.FeedListView.a;

public class afuh
  implements FeedListView.a
{
  private long XQ;
  private boolean caV = true;
  
  public afuh(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  private boolean ako()
  {
    long l = System.nanoTime();
    if (l - this.XQ < 400000000L) {
      return true;
    }
    this.XQ = l;
    return false;
  }
  
  public void hide()
  {
    if ((!this.caV) || (ako())) {
      return;
    }
    ExtendFriendCampusFragment.a(this.this$0).In();
    this.caV = false;
    this.XQ = System.nanoTime();
  }
  
  public void show()
  {
    if ((this.caV) || (ako())) {
      return;
    }
    ExtendFriendCampusFragment.a(this.this$0).Im();
    this.caV = true;
    this.XQ = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuh
 * JD-Core Version:    0.7.0.1
 */