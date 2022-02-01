import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment.a;
import java.util.List;

public class aabb
  extends FragmentPagerAdapter
{
  public aabb(SendHbMainFragment paramSendHbMainFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SendHbMainFragment.a(this.this$0).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return ((SendHbMainFragment.a)SendHbMainFragment.a(this.this$0).get(paramInt)).a;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return ((SendHbMainFragment.a)SendHbMainFragment.a(this.this$0).get(paramInt)).title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabb
 * JD-Core Version:    0.7.0.1
 */