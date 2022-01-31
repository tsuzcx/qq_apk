import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.widget.XListView;

class tvz
  implements Runnable
{
  tvz(tvy paramtvy) {}
  
  public void run()
  {
    if ((this.a.a.a.getAdapter() instanceof BaseAdapter)) {
      ((BaseAdapter)this.a.a.a.getAdapter()).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvz
 * JD-Core Version:    0.7.0.1
 */