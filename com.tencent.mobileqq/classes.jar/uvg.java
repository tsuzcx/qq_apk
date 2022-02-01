import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;

class uvg
  implements bjoe
{
  uvg(uvf paramuvf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(uvf.a(this.a)))
    {
      bhzt.a().a(2131719692);
      return;
    }
    uvf.a(this.a).b(uvf.a(this.a).id, 2);
    uvf.a(this.a).followStatus = 2;
    uvf.a(this.a).setVisibility(0);
    uvf.b(this.a).setVisibility(8);
    uvm.a("follow", uvf.a(this.a) + 1, uvf.a(this.a).id, uvt.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvg
 * JD-Core Version:    0.7.0.1
 */