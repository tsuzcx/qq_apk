import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.LayoutParams;
import java.util.Comparator;

public class xjj
  implements Comparator<View>
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (XViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (XViewPager.LayoutParams)paramView2.getLayoutParams();
    if (paramView1.a != paramView2.a)
    {
      if (paramView1.a) {
        return 1;
      }
      return -1;
    }
    return paramView1.b - paramView2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjj
 * JD-Core Version:    0.7.0.1
 */