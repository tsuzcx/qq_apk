import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xhj
  implements View.OnClickListener
{
  xhj(xhf paramxhf) {}
  
  public void onClick(View paramView)
  {
    Context localContext = xhf.a(this.a).a();
    if (!bgnt.g(localContext)) {
      QQToast.a(localContext, 1, 2131693946, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { xhf.a(this.a) });
      xhf.a(this.a).setVisibility(0);
      xhf.a(this.a).removeCallbacks(xhf.a(this.a));
      xhf.a(this.a).postDelayed(xhf.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhj
 * JD-Core Version:    0.7.0.1
 */