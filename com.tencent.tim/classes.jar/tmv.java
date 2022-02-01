import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.e;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1.1;

public class tmv
  implements GdtVideoCommonView.e
{
  public tmv(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void eq(View paramView)
  {
    if (GdtVideoImaxFragment.a(this.this$0).getVideoSplicePageStyle() == 1)
    {
      GdtVideoImaxFragment.a(this.this$0);
      GdtVideoImaxFragment.b(this.this$0);
    }
    while (GdtVideoImaxFragment.a(this.this$0).getVideoSplicePageStyle() != 0) {
      return;
    }
    GdtVideoImaxFragment.a(this.this$0).bDP();
    paramView = tls.d(this.this$0.getActivity());
    GdtVideoImaxFragment.a(this.this$0, paramView[1], GdtVideoImaxFragment.a(this.this$0).getLayoutParams().height, paramView[1]);
  }
  
  public void f(GdtVideoCommonView paramGdtVideoCommonView)
  {
    tkw.d("GdtVideoImaxFragment", "onPrepared() called with: v = [" + paramGdtVideoCommonView + "]");
  }
  
  public void g(GdtVideoCommonView paramGdtVideoCommonView)
  {
    tkw.d("GdtVideoImaxFragment", "onStart() called with: ");
    if (GdtVideoImaxFragment.a(this.this$0))
    {
      GdtVideoImaxFragment.a(this.this$0).removeCallbacks(GdtVideoImaxFragment.a(this.this$0));
      GdtVideoImaxFragment.a(this.this$0).postDelayed(new GdtVideoImaxFragment.1.1(this), 75L);
      GdtVideoImaxFragment.a(this.this$0, false);
    }
  }
  
  public void h(GdtVideoCommonView paramGdtVideoCommonView)
  {
    tkw.d("GdtVideoImaxFragment", "onStop() called with: v = [" + paramGdtVideoCommonView + "]");
  }
  
  public void i(GdtVideoCommonView paramGdtVideoCommonView)
  {
    tkw.d("GdtVideoImaxFragment", "onComplete() called with: v = [" + paramGdtVideoCommonView + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmv
 * JD-Core Version:    0.7.0.1
 */