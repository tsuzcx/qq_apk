import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.a;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.12.1;

public class anjr
  implements CustomFrameAnimationDrawable.a
{
  anjr(anjo paramanjo) {}
  
  public void onEnd()
  {
    if (anjo.a(this.this$0) == null) {
      anjo.a(this.this$0, new Handler());
    }
    anjo.a(this.this$0).postDelayed(new RedBagVideoManager.12.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjr
 * JD-Core Version:    0.7.0.1
 */