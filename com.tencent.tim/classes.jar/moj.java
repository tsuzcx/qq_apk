import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment.a;
import java.util.List;

public class moj
  extends lce
{
  public moj(FollowingListFragment paramFollowingListFragment) {}
  
  public void b(boolean paramBoolean1, List<mhg> paramList, long paramLong, boolean paramBoolean2)
  {
    FollowingListFragment.a(this.a, paramList);
    if (FollowingListFragment.a(this.a) != null) {
      FollowingListFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moj
 * JD-Core Version:    0.7.0.1
 */