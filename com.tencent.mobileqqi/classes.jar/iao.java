import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

public class iao
  extends Filter
{
  iap a;
  
  public iao(iap paramiap)
  {
    this.a = paramiap;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return this.a.a((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.a.a(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      localFilterResults.count = paramCharSequence.getCount();
      localFilterResults.values = paramCharSequence;
      return localFilterResults;
    }
    localFilterResults.count = 0;
    localFilterResults.values = null;
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = this.a.a();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.a.a((Cursor)paramFilterResults.values);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iao
 * JD-Core Version:    0.7.0.1
 */