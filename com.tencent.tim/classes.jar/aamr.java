import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.2;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class aamr
  implements OnCompositionLoadedListener
{
  public aamr(LoginAnimBtnView.2 param2) {}
  
  public void onCompositionLoaded(LottieComposition arg1)
  {
    if ((??? == null) || (LoginAnimBtnView.a(this.a.this$0)))
    {
      QLog.e("LoginAnimBtnView", 1, "onCompositionLoaded lottieComposition is null or mIsDestroyed:" + LoginAnimBtnView.a(this.a.this$0));
      return;
    }
    int i = wja.dp2px(70.0F, this.a.this$0.getResources());
    int j = wja.dp2px(70.0F, this.a.this$0.getResources());
    Object localObject1 = ???.getBounds();
    float f1 = i / ((Rect)localObject1).width();
    float f2 = j / ((Rect)localObject1).height();
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onCompositionLoaded iw:" + i + ", ih:" + j + ": : rw:" + ((Rect)localObject1).width() + ", rh:" + ((Rect)localObject1).height());
    }
    localObject1 = new LottieDrawable();
    ((LottieDrawable)localObject1).setImageAssetDelegate(new aams(this.a.this$0.getContext().getApplicationContext()));
    ((LottieDrawable)localObject1).setComposition(???);
    ((LottieDrawable)localObject1).setScale(f1, f2);
    ((LottieDrawable)localObject1).loop(true);
    ??? = ((LottieDrawable)localObject1).getBounds();
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onCompositionLoaded rw:" + ???.width() + ", rh:" + ???.height() + " mIsDestroyed:" + LoginAnimBtnView.a(this.a.this$0));
    }
    LoginAnimBtnView.a(this.a.this$0, (LottieDrawable)localObject1);
    if (LoginAnimBtnView.a(this.a.this$0))
    {
      ((LottieDrawable)localObject1).cancelAnimation();
      ((LottieDrawable)localObject1).recycleBitmaps();
      ((LottieDrawable)localObject1).clearComposition();
      ((LottieDrawable)localObject1).setImageAssetDelegate(null);
      LoginAnimBtnView.a(this.a.this$0, null);
    }
    for (;;)
    {
      synchronized (LoginAnimBtnView.a(this.a.this$0))
      {
        LoginAnimBtnView.a(this.a.this$0, null);
        LoginAnimBtnView.a(this.a.this$0, null);
        return;
      }
      if (this.a.this$0.isEnabled())
      {
        this.a.this$0.removeCallbacks(LoginAnimBtnView.a(this.a.this$0));
        this.a.this$0.post(LoginAnimBtnView.a(this.a.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamr
 * JD-Core Version:    0.7.0.1
 */