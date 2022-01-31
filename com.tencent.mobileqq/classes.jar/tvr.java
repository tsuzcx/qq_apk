import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import java.util.List;

public class tvr
  extends BaseAdapter
{
  private tvr(VideoCoverListBar paramVideoCoverListBar) {}
  
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131561329, null);
      paramViewGroup = new tvs(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (tvs)paramView.getTag();
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvr
 * JD-Core Version:    0.7.0.1
 */