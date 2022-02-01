import android.content.Context;
import android.view.View;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.ui.guide.GuideHelper.a.a;
import com.tencent.av.ui.guide.GuideHelper.b;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class jhl
  implements GuideHelper.a.a
{
  public jhl(GuideHelper paramGuideHelper, long paramLong, Context paramContext, int paramInt) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    this.this$0.a.lottieDrawable = paramLottieDrawable;
    if ((paramLottieDrawable != null) && (this.this$0.a.iv != null))
    {
      this.this$0.a.iv.setBackgroundDrawable(paramLottieDrawable);
      GuideHelper.a(this.this$0, this.kQ, this.val$context, this.Iy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhl
 * JD-Core Version:    0.7.0.1
 */