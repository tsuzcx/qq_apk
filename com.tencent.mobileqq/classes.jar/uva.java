import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class uva
  implements View.OnClickListener
{
  public uva(ArkAppView paramArkAppView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mViewImpl.getViewModel();
    if (paramView != null) {
      paramView.reinitArkContainer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uva
 * JD-Core Version:    0.7.0.1
 */