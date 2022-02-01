import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;

public class rre
  extends DataSetObserver
{
  public rre(EmptySupportViewPager paramEmptySupportViewPager) {}
  
  public void onChanged()
  {
    PagerAdapter localPagerAdapter = this.a.getAdapter();
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      this.a.xR(8);
      EmptySupportViewPager.a(this.a, 0);
      return;
    }
    this.a.xR(0);
    EmptySupportViewPager.b(this.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rre
 * JD-Core Version:    0.7.0.1
 */