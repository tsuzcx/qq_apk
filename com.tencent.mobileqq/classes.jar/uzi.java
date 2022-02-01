import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uzi
  implements View.OnClickListener
{
  uzi(uzg paramuzg) {}
  
  public void onClick(View paramView)
  {
    if (zvo.a("vertical_video_top_homepage_click")) {
      uya.a("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vdq.e(uzg.a(this.a).a(), uzg.a(this.a).b(), uzg.a(this.a));
      ukw.a(uzg.a(this.a).getActivity(), "from_qq_chat", 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzi
 * JD-Core Version:    0.7.0.1
 */