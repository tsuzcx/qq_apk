import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;
import java.util.List;

public class uei
  extends FragmentPagerAdapter
{
  public uei(QCirclePersonalBottomView paramQCirclePersonalBottomView, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return QCirclePersonalBottomView.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < QCirclePersonalBottomView.a(this.a).size()) {
      return (Fragment)QCirclePersonalBottomView.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uei
 * JD-Core Version:    0.7.0.1
 */