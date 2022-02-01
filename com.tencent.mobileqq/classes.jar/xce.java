import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class xce
  extends BaseAdapter
{
  private xce(VideoCoverListBar paramVideoCoverListBar) {}
  
  public String a(int paramInt)
  {
    return (String)VideoCoverListBar.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return VideoCoverListBar.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131561759, null);
      paramView = new xcf(this, localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a(paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      xcf localxcf = (xcf)paramView.getTag();
      localView = paramView;
      paramView = localxcf;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xce
 * JD-Core Version:    0.7.0.1
 */