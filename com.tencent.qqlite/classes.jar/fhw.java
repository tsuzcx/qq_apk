import android.database.DataSetObserver;
import com.tencent.widget.AdapterViewPagerAdapter;

public class fhw
  extends DataSetObserver
{
  public fhw(AdapterViewPagerAdapter paramAdapterViewPagerAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhw
 * JD-Core Version:    0.7.0.1
 */