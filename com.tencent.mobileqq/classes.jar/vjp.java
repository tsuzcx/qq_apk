import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vjp
  implements View.OnClickListener
{
  vjp(vjo paramvjo) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(vjo.a(this.a))) {
      bjkv.a().a(2131720145);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vjo.a(this.a);
      vka.b(vjo.a(this.a) + 1, 1004001, vjo.a(this.a), vjo.a(this.a).a(), vjo.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjp
 * JD-Core Version:    0.7.0.1
 */