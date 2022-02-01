import android.database.DataSetObserver;
import android.widget.TextView;
import com.tencent.tim.activity.TimLebaListMgrActivity;

public class atav
  extends DataSetObserver
{
  public atav(TimLebaListMgrActivity paramTimLebaListMgrActivity) {}
  
  public void onChanged()
  {
    TextView localTextView = TimLebaListMgrActivity.a(this.this$0);
    if (TimLebaListMgrActivity.a(this.this$0).getCount() > 0) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atav
 * JD-Core Version:    0.7.0.1
 */