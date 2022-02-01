import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axqv
  implements View.OnClickListener
{
  axqv(axqs paramaxqs) {}
  
  public void onClick(View paramView)
  {
    if (axqs.a(this.a)) {
      this.a.b.eEZ();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131714176), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqv
 * JD-Core Version:    0.7.0.1
 */