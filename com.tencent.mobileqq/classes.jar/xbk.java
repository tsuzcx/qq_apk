import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xbk
  implements View.OnClickListener
{
  xbk(xbg paramxbg) {}
  
  public void onClick(View paramView)
  {
    Context localContext = xbg.a(this.a).a();
    if (!NetworkUtil.isNetworkAvailable(localContext)) {
      QQToast.a(localContext, 1, 2131694253, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { xbg.a(this.a) });
      xbg.a(this.a).setVisibility(0);
      xbg.a(this.a).removeCallbacks(xbg.a(this.a));
      xbg.a(this.a).postDelayed(xbg.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbk
 * JD-Core Version:    0.7.0.1
 */