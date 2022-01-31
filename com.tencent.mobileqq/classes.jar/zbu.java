import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1.1;

public class zbu
  implements zbj
{
  public zbu(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void a(View paramView)
  {
    if (GdtVideoImaxFragment.a(this.a).getVideoSplicePageStyle() == 1)
    {
      GdtVideoImaxFragment.a(this.a);
      GdtVideoImaxFragment.b(this.a);
    }
    while (GdtVideoImaxFragment.a(this.a).getVideoSplicePageStyle() != 0) {
      return;
    }
    GdtVideoImaxFragment.a(this.a).g();
    paramView = yzb.a(this.a.getActivity());
    GdtVideoImaxFragment.a(this.a, paramView[1], GdtVideoImaxFragment.a(this.a).getLayoutParams().height, paramView[1]);
  }
  
  public void a(GdtVideoCommonView paramGdtVideoCommonView)
  {
    yxp.a("GdtVideoImaxFragment", "onPrepared() called with: v = [" + paramGdtVideoCommonView + "]");
  }
  
  public void b(GdtVideoCommonView paramGdtVideoCommonView)
  {
    yxp.a("GdtVideoImaxFragment", "onStart() called with: ");
    if (GdtVideoImaxFragment.a(this.a))
    {
      GdtVideoImaxFragment.a(this.a).removeCallbacks(GdtVideoImaxFragment.a(this.a));
      GdtVideoImaxFragment.a(this.a).postDelayed(new GdtVideoImaxFragment.1.1(this), 75L);
      GdtVideoImaxFragment.a(this.a, false);
    }
  }
  
  public void c(GdtVideoCommonView paramGdtVideoCommonView)
  {
    yxp.a("GdtVideoImaxFragment", "onStop() called with: v = [" + paramGdtVideoCommonView + "]");
  }
  
  public void d(GdtVideoCommonView paramGdtVideoCommonView)
  {
    yxp.a("GdtVideoImaxFragment", "onComplete() called with: v = [" + paramGdtVideoCommonView + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbu
 * JD-Core Version:    0.7.0.1
 */