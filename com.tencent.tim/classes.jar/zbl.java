import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;

public class zbl
{
  public static boolean P(View paramView)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramView instanceof HeaderScrollView)) {
      if (!((HeaderScrollView)paramView).UT()) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        View localView;
        do
        {
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
          if (!(paramView instanceof ViewGroup)) {
            break;
          }
          localView = ((ViewGroup)paramView).getChildAt(1);
          if ((localView == null) || (!(localView instanceof HeaderScrollView))) {
            break label116;
          }
          bool1 = bool2;
        } while (!((HeaderScrollView)localView).UT());
        return false;
        if (!(paramView instanceof AbsListView)) {
          break label116;
        }
        paramView = (AbsListView)paramView;
        if (paramView.getChildCount() <= 0) {
          break;
        }
        bool1 = bool2;
      } while (paramView.getFirstVisiblePosition() > 0);
      bool1 = bool2;
    } while (paramView.getChildAt(0).getTop() < paramView.getPaddingTop());
    return false;
    label116:
    return ViewCompat.canScrollVertically(paramView, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbl
 * JD-Core Version:    0.7.0.1
 */