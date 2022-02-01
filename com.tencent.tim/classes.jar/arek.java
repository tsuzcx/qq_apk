import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView.a;

public class arek
  implements WorkSpaceView.a
{
  public arek(ADView paramADView, LinearLayout paramLinearLayout) {}
  
  public void cJ(int paramInt)
  {
    int j = this.li.getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = this.li.getChildAt(i);
      if (localView != null) {
        localView.setEnabled(false);
      }
      i += 1;
    }
    if (this.a.cZp) {
      if (paramInt == -1) {
        i = j - 1;
      }
    }
    for (;;)
    {
      if ((i > -1) && (i < j))
      {
        localView = this.li.getChildAt(i);
        if (localView != null) {
          localView.setEnabled(true);
        }
      }
      return;
      i = paramInt;
      if (paramInt == j)
      {
        i = 0;
        continue;
        if (paramInt == -1)
        {
          i = 0;
        }
        else
        {
          i = paramInt;
          if (paramInt == j) {
            i = j - 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arek
 * JD-Core Version:    0.7.0.1
 */