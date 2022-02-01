import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.a;

public class afwb
  implements ExtendFriendSearchBarView.a
{
  public afwb(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void dcn()
  {
    PublicFragmentActivity.startForResult(this.this$0.mActivity, ExtendFriendSearchFragment.class, 3);
    this.this$0.mActivity.overridePendingTransition(0, 2130772403);
    anot.a(this.this$0.mApp, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
  }
  
  public void ez(String paramString, int paramInt)
  {
    if (!paramString.equals(this.this$0.mSearchKey))
    {
      this.this$0.mSearchKey = paramString;
      if (!afsi.DEFAULT_TAG.equals(this.this$0.mSearchKey)) {
        break label186;
      }
      ExtendFriendSquareFragment.a(this.this$0, false);
    }
    label186:
    for (boolean bool1 = ExtendFriendSquareFragment.c(this.this$0);; bool1 = false)
    {
      boolean bool2 = ExtendFriendSquareFragment.a(this.this$0, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.a(this.this$0));
      if ((!bool2) || (l > 60000L) || (bool1))
      {
        ExtendFriendSquareFragment.b(this.this$0, false);
        this.this$0.a.clear();
        this.this$0.a.notifyDataSetChanged();
        this.this$0.a.ID(false);
        ExtendFriendSquareFragment.c(this.this$0);
        ExtendFriendSquareFragment.a(this.this$0).removeMessages(11);
        ExtendFriendSquareFragment.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
        return;
      }
      ExtendFriendSquareFragment.b(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwb
 * JD-Core Version:    0.7.0.1
 */