import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class voa
  implements View.OnClickListener
{
  voa(vny paramvny) {}
  
  public void onClick(View paramView)
  {
    if (aala.a("vertical_video_top_homepage_click")) {
      vmp.a("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vsj.e(vny.a(this.a).a(), vny.a(this.a).b(), vny.a(this.a));
      uyt.a(vny.a(this.a).getActivity(), "from_qq_chat", 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */