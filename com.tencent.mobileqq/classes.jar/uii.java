import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.List;

class uii
  implements blsw
{
  uii(uih paramuih) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((uih.a(this.a) == null) || (uih.a(this.a).a() == null) || (paramInt >= uih.a(this.a).a().size())) {}
    do
    {
      return;
      paramView = (uho)uih.a(this.a).a().get(paramInt);
    } while (paramView == null);
    WSVerticalPageFragment.a(uih.a(this.a), "friend_feed", "friend", null, paramView.b() + 1);
    uns.a(paramInt + 1, 1000001, (stSimpleMetaFeed)((ArrayList)paramView.a()).get(0), paramView.a(), paramView.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uii
 * JD-Core Version:    0.7.0.1
 */