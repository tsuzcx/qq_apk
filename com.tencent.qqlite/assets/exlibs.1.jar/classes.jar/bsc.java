import android.view.View;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class bsc
  implements TabBarView.OnTabChangeListener
{
  public bsc(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView = this.a.a.getChildAt(0);
    if (paramInt2 == 0)
    {
      str = "已选中" + this.a.getString(2131363547);
      localView.setContentDescription(str);
      localView = this.a.a.getChildAt(1);
      if (paramInt2 != 1) {
        break label125;
      }
    }
    label125:
    for (String str = "已选中" + this.a.getString(2131363548);; str = this.a.getString(2131363548))
    {
      localView.setContentDescription(str);
      this.a.a(paramInt2);
      return;
      str = this.a.getString(2131363547);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bsc
 * JD-Core Version:    0.7.0.1
 */