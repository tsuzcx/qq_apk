import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uvc
  implements View.OnClickListener
{
  uvc(uvb paramuvb) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(uvb.a(this.a))) {
      bhzt.a().a(2131719692);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      uvb.a(this.a);
      uvm.b(uvb.a(this.a) + 1, 1004001, uvb.a(this.a), uvb.a(this.a).a(), uvb.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvc
 * JD-Core Version:    0.7.0.1
 */