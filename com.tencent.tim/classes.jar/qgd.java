import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qgd
  implements View.OnClickListener
{
  qgd(qfz paramqfz) {}
  
  public void onClick(View paramView)
  {
    Context localContext = qfz.a(this.this$0).getContext();
    if (!aqiw.isNetworkAvailable(localContext)) {
      QQToast.a(localContext, 1, 2131696270, 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ram.w("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { qfz.a(this.this$0) });
      qfz.a(this.this$0).setVisibility(0);
      qfz.a(this.this$0).removeCallbacks(qfz.a(this.this$0));
      qfz.a(this.this$0).postDelayed(qfz.a(this.this$0), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgd
 * JD-Core Version:    0.7.0.1
 */