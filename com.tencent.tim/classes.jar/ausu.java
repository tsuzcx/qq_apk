import android.database.DataSetObserver;
import com.tencent.widget.AdapterViewPagerAdapter;

public class ausu
  extends DataSetObserver
{
  public ausu(AdapterViewPagerAdapter paramAdapterViewPagerAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ausu
 * JD-Core Version:    0.7.0.1
 */