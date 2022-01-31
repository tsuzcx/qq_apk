import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class dyh
  extends BaseAdapter
{
  private View a;
  
  public dyh(View paramView)
  {
    this.a = paramView;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyh
 * JD-Core Version:    0.7.0.1
 */