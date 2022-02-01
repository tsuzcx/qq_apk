import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.a;

class anjq
  implements CustomFrameAnimationDrawable.a
{
  anjq(anjo paramanjo, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable) {}
  
  public void onEnd()
  {
    if (this.this$0.i > 0) {
      return;
    }
    this.e.cdJ();
    this.e.cdG();
    this.e.start();
    anjo localanjo = this.this$0;
    localanjo.i += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjq
 * JD-Core Version:    0.7.0.1
 */