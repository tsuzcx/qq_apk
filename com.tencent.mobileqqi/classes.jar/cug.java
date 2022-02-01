import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mobileqq.activity.LoginActivity;
import java.util.List;

class cug
  extends Filter
{
  cug(cuf paramcuf) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.values = this.a.a.a;
    paramCharSequence.count = this.a.a.a.size();
    return paramCharSequence;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.count > 0)
    {
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cug
 * JD-Core Version:    0.7.0.1
 */