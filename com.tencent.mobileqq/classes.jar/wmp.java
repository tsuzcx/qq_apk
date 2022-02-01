import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wmp
  implements View.OnClickListener
{
  wmp(wml paramwml) {}
  
  public void onClick(View paramView)
  {
    Context localContext = wml.a(this.a).a();
    if (!NetworkUtil.isNetworkAvailable(localContext)) {
      QQToast.a(localContext, 1, 2131694062, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { wml.a(this.a) });
      wml.a(this.a).setVisibility(0);
      wml.a(this.a).removeCallbacks(wml.a(this.a));
      wml.a(this.a).postDelayed(wml.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */