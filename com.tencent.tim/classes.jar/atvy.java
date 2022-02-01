import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atvy
  extends BaseAdapter
{
  private argf a;
  private Object dG;
  private View.OnClickListener eQ;
  private Context mContext;
  
  public atvy(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.mContext = paramContext;
    this.eQ = paramOnClickListener;
  }
  
  public void a(argf paramargf)
  {
    this.a = paramargf;
  }
  
  public void bk(Object paramObject)
  {
    this.dG = paramObject;
  }
  
  public int getCount()
  {
    return 0;
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
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvy
 * JD-Core Version:    0.7.0.1
 */