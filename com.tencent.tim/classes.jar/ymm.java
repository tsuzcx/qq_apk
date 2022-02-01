import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ymm
  extends BaseAdapter
{
  public String[] cO;
  public QQAppInterface mApp;
  public Handler mHandler;
  
  public int getCount()
  {
    if (this.cO == null) {
      return 0;
    }
    return this.cO.length;
  }
  
  public String getItem(int paramInt)
  {
    return this.cO[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = getItem(paramInt);
    View localView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559539, paramViewGroup, false);
    }
    ymm.a locala;
    for (paramView = new ymm.a(localView);; paramView = locala)
    {
      paramView.text.setText(str);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      locala = (ymm.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  static class a
  {
    public TextView text;
    
    public a(View paramView)
    {
      this.text = ((TextView)paramView.findViewById(2131379401));
      paramView.setTag(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymm
 * JD-Core Version:    0.7.0.1
 */