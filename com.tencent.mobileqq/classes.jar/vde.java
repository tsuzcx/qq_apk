import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.List;

class vde
  implements blih
{
  vde(vdd paramvdd) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((vdd.a(this.a) == null) || (vdd.a(this.a).b() == null) || (paramInt >= vdd.a(this.a).b().size())) {}
    do
    {
      return;
      paramView = (vcf)vdd.a(this.a).b().get(paramInt);
    } while (paramView == null);
    WSVerticalPageFragment.a(vdd.a(this.a), "friend_feed", "friend", null, paramView.b() + 1);
    vka.a(paramInt + 1, 1000001, (stSimpleMetaFeed)((ArrayList)paramView.a()).get(0), paramView.a(), paramView.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */