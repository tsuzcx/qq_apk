import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amuh
  implements View.OnClickListener
{
  amuh(amug paramamug) {}
  
  public void onClick(View paramView)
  {
    ArkViewModel localArkViewModel = null;
    if (amug.a(this.a) != null) {
      localArkViewModel = amug.a(this.a).mViewImpl.getViewModel();
    }
    if (localArkViewModel == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArkViewModel.reinitArkContainer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuh
 * JD-Core Version:    0.7.0.1
 */