import android.database.DataSetObserver;
import com.tencent.widget.PagerBaseAdapterWrapper;

public class fkz
  extends DataSetObserver
{
  public fkz(PagerBaseAdapterWrapper paramPagerBaseAdapterWrapper) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fkz
 * JD-Core Version:    0.7.0.1
 */