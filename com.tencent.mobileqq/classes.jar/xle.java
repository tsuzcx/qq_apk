import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xle
  implements View.OnClickListener
{
  xle(xla paramxla) {}
  
  public void onClick(View paramView)
  {
    Context localContext = xla.a(this.a).a();
    if (!bhnv.g(localContext)) {
      QQToast.a(localContext, 1, 2131693963, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { xla.a(this.a) });
      xla.a(this.a).setVisibility(0);
      xla.a(this.a).removeCallbacks(xla.a(this.a));
      xla.a(this.a).postDelayed(xla.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xle
 * JD-Core Version:    0.7.0.1
 */