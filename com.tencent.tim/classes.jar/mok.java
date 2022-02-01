import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment;
import com.tencent.widget.ExpandableListView.e;

public class mok
  implements ExpandableListView.e
{
  public mok(FriendListFragment paramFriendListFragment) {}
  
  public void onGroupExpand(int paramInt)
  {
    if (FriendListFragment.a(this.a) != null) {
      FriendListFragment.a(this.a).onClick(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mok
 * JD-Core Version:    0.7.0.1
 */