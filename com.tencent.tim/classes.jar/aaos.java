import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.a;
import java.util.List;

public class aaos
  extends Filter
{
  public aaos(TimLoginQQView.a parama) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.values = this.a.this$0.qh;
    paramCharSequence.count = this.a.this$0.qh.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaos
 * JD-Core Version:    0.7.0.1
 */