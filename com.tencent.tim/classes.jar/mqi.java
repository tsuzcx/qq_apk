import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment;
import java.util.ArrayList;

public class mqi
  extends FragmentPagerAdapter
{
  public mqi(SelectVideoTabFragment paramSelectVideoTabFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SelectVideoTabFragment.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)SelectVideoTabFragment.a(this.a).get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return SelectVideoTabFragment.a(this.a).getString(SelectVideoTabFragment.access$100()[paramInt]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqi
 * JD-Core Version:    0.7.0.1
 */