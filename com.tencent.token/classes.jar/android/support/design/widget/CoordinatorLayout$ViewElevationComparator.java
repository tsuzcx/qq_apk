package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.Comparator;

class CoordinatorLayout$ViewElevationComparator
  implements Comparator
{
  public int compare(View paramView1, View paramView2)
  {
    float f1 = ViewCompat.getZ(paramView1);
    float f2 = ViewCompat.getZ(paramView2);
    if (f1 > f2) {
      return -1;
    }
    if (f1 < f2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.ViewElevationComparator
 * JD-Core Version:    0.7.0.1
 */