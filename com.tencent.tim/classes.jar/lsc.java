import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class lsc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  lsc(lsb paramlsb) {}
  
  public void onGlobalLayout()
  {
    if ((lsb.a(this.b).isShown()) && (!lsb.a(this.b)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.b.resumeAnimation();
      lsb.a(this.b, true);
    }
    if ((!lsb.a(this.b).isShown()) && (lsb.a(this.b)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.b.pauseAnimation();
      lsb.a(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsc
 * JD-Core Version:    0.7.0.1
 */