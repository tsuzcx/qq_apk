import android.content.Context;
import android.widget.GridView;
import com.tencent.biz.troopgift.GridListViewPager;

public class yvd
  extends GridView
{
  public yvd(GridListViewPager paramGridListViewPager, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvd
 * JD-Core Version:    0.7.0.1
 */