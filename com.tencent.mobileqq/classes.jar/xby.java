import android.content.Context;
import android.widget.GridView;
import com.tencent.biz.troopgift.GridListViewPager;

public class xby
  extends GridView
{
  public xby(GridListViewPager paramGridListViewPager, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xby
 * JD-Core Version:    0.7.0.1
 */