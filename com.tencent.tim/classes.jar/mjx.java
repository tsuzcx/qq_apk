import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mjx
  extends lce
{
  public mjx(ReadInJoyPrivacyListFragment paramReadInJoyPrivacyListFragment) {}
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetPrivacyList | retcode ").append(paramInt1).append(" | feedsId ").append(paramLong).append("| totalCnt ").append(paramInt3).append(" | nextPageStartIndex ").append(paramInt2).append(" | hasNextPage ").append(paramBoolean).append("| uinList size ");
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      QLog.d("ReadInJoyPrivacyListFragment", 1, i);
      if (paramInt1 != 0) {
        break label180;
      }
      ReadInJoyPrivacyListFragment.a(this.a, paramInt2);
      ReadInJoyPrivacyListFragment.b(this.a, paramInt3);
      ReadInJoyPrivacyListFragment.a(this.a, paramBoolean);
      if (paramList != null) {
        ReadInJoyPrivacyListFragment.a(this.a).addAll(paramList);
      }
      if (ReadInJoyPrivacyListFragment.a(this.a) != null) {
        ReadInJoyPrivacyListFragment.a(this.a).nR(ReadInJoyPrivacyListFragment.a(this.a));
      }
    }
    label180:
    while (ReadInJoyPrivacyListFragment.a(this.a) == null)
    {
      return;
      i = 0;
      break;
    }
    ReadInJoyPrivacyListFragment.a(this.a).aPB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjx
 * JD-Core Version:    0.7.0.1
 */