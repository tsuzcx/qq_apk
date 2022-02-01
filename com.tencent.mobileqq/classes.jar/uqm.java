import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uqm
  implements View.OnClickListener
{
  uqm(uqk paramuqk) {}
  
  public void onClick(View paramView)
  {
    if (aauy.a("vertical_video_top_homepage_click")) {
      upe.a("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      uut.e(uqk.a(this.a).a(), uqk.a(this.a).b(), uqk.a(this.a));
      uee.a(uqk.a(this.a).getActivity(), "from_qq_chat", 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqm
 * JD-Core Version:    0.7.0.1
 */