import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;

class vjv
  implements bkzq
{
  vjv(vju paramvju) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(vju.a(this.a)))
    {
      bjkv.a().a(2131720145);
      return;
    }
    vju.a(this.a).b(vju.a(this.a).id, 2);
    vju.a(this.a).followStatus = 2;
    vju.a(this.a).setVisibility(0);
    vju.b(this.a).setVisibility(8);
    vka.a("follow", vju.a(this.a) + 1, vju.a(this.a).id, vkh.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjv
 * JD-Core Version:    0.7.0.1
 */