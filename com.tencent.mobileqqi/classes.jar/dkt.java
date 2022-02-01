import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class dkt
  implements View.OnClickListener
{
  public dkt(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (this.a.a == null)
    {
      this.a.a = ((ActionSheet)ActionSheetHelper.a(paramView, null));
      this.a.a.a(2131562553);
      this.a.a.a(2131561964, 3);
      this.a.a.d(2131561746);
      this.a.a.a(paramView);
    }
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dkt
 * JD-Core Version:    0.7.0.1
 */