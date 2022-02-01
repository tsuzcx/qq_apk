import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class urn
  implements View.OnClickListener
{
  urn(url paramurl) {}
  
  public void onClick(View paramView)
  {
    if (aazb.a("vertical_video_top_homepage_click")) {
      uqf.a("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      uvv.e(url.a(this.a).a(), url.a(this.a).b(), url.a(this.a));
      ueg.a(url.a(this.a).getActivity(), "from_qq_chat", 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urn
 * JD-Core Version:    0.7.0.1
 */