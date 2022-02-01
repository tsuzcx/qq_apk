import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment;
import com.tencent.widget.ExpandableListView.d;

public class mol
  implements ExpandableListView.d
{
  public mol(FriendListFragment paramFriendListFragment) {}
  
  public void onGroupCollapse(int paramInt)
  {
    if (FriendListFragment.a(this.a) != null) {
      FriendListFragment.a(this.a).onClick(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mol
 * JD-Core Version:    0.7.0.1
 */