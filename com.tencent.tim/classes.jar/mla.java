import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class mla
  extends FragmentPagerAdapter
{
  public mla(CoverSelectTabFragment paramCoverSelectTabFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return CoverSelectTabFragment.a(this.a).size();
  }
  
  @NotNull
  public Fragment getItem(int paramInt)
  {
    return (Fragment)CoverSelectTabFragment.a(this.a).get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return CoverSelectTabFragment.j()[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mla
 * JD-Core Version:    0.7.0.1
 */