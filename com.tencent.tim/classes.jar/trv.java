import com.tencent.lottieNew.LottieAnimationView;
import com.tencent.lottieNew.LottieAnimationView.CacheStrategy;
import java.lang.ref.WeakReference;
import java.util.Map;

public class trv
  implements tsg
{
  public trv(LottieAnimationView paramLottieAnimationView, LottieAnimationView.CacheStrategy paramCacheStrategy, String paramString) {}
  
  public void a(trx paramtrx)
  {
    if (this.b == LottieAnimationView.CacheStrategy.Strong) {
      LottieAnimationView.access$100().put(this.aJS, paramtrx);
    }
    for (;;)
    {
      this.a.setComposition(paramtrx);
      return;
      if (this.b == LottieAnimationView.CacheStrategy.Weak) {
        LottieAnimationView.access$200().put(this.aJS, new WeakReference(paramtrx));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trv
 * JD-Core Version:    0.7.0.1
 */