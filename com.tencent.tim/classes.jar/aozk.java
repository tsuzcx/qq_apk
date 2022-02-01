import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aozk
  extends BaseAdapter
{
  protected aozp.a b;
  protected int dSk = -1;
  protected Context mContext;
  protected ArrayList<aozp.a> mDataList = new ArrayList();
  protected LayoutInflater mInflater;
  protected View.OnClickListener mOnClickListener;
  
  public aozk(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void b(aozp.a parama)
  {
    this.b = parama;
    this.mDataList = parama.list;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mDataList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aozp.a locala = (aozp.a)this.mDataList.get(paramInt);
    Object localObject1 = new aozk.a();
    Object localObject2;
    if (paramView != null)
    {
      localObject2 = (aozk.a)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    for (;;)
    {
      paramView.textView.setText(locala.name);
      paramView.textView.setTag(locala);
      if (this.mOnClickListener != null) {
        paramView.textView.setOnClickListener(this.mOnClickListener);
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = this.mInflater.inflate(2131560783, null);
      ((aozk.a)localObject1).textView = ((TextView)((View)localObject2).findViewById(2131379401));
      ((View)localObject2).setTag(localObject1);
      paramView = (View)localObject1;
      localObject1 = localObject2;
    }
  }
  
  static class a
  {
    TextView textView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozk
 * JD-Core Version:    0.7.0.1
 */