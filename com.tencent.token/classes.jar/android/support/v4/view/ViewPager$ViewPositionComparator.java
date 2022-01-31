package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class ViewPager$ViewPositionComparator
  implements Comparator
{
  public int compare(View paramView1, View paramView2)
  {
    paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
    if (paramView1.isDecor != paramView2.isDecor)
    {
      if (paramView1.isDecor) {
        return 1;
      }
      return -1;
    }
    return paramView1.position - paramView2.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager.ViewPositionComparator
 * JD-Core Version:    0.7.0.1
 */