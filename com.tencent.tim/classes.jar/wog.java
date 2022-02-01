import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.os.MqqHandler;

public class wog
  extends wol
  implements Animator.AnimatorListener
{
  private wpc a;
  private String aTK;
  private String aTL;
  private LottieDrawable c;
  private boolean mDestroyed;
  private boolean mPaused;
  private String mResPath = "";
  private ImageView sp;
  
  public wog(Context paramContext)
  {
    super(paramContext);
    this.a = new wpc(paramContext);
    this.a.setOnCloseClickListener(new woh(this));
  }
  
  private void a(LottieComposition paramLottieComposition)
  {
    QLog.i("LottieAnimDirector", 1, "decode json success");
    if ((this.c != null) && (paramLottieComposition != null))
    {
      this.c.setComposition(paramLottieComposition);
      this.c.loop(false);
      this.c.addAnimatorListener(this);
      if (this.sp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimDirector", 2, "refresh Lottie.d");
        }
        this.sp.setImageDrawable(null);
        this.sp.setImageDrawable(this.c);
      }
    }
  }
  
  private void aT(QQAppInterface paramQQAppInterface)
  {
    this.mResPath = ajnt.a(paramQQAppInterface).bm(this.aTK, this.aTL);
    if (QLog.isColorLevel()) {
      QLog.i("LottieAnimDirector", 1, "onResourceReady lottieUrl:" + this.aTK + "  lottieMd5:" + this.aTL + " mResPath:" + this.mResPath);
    }
    if (this.c == null)
    {
      this.c = new LottieDrawable();
      this.c.setImageAssetDelegate(new woj(this));
    }
    try
    {
      paramQQAppInterface = new FileInputStream(this.mResPath + "data.json");
      QLog.i("LottieAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(m(), paramQQAppInterface, new wok(this));
      return;
    }
    catch (IOException paramQQAppInterface)
    {
      QLog.e("LottieAnimDirector", 1, "Decode anim json error");
    }
  }
  
  private QQAppInterface getApp()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (m() != null)
    {
      localObject1 = localObject2;
      if ((m() instanceof BaseActivity)) {
        localObject1 = ((BaseActivity)m()).app;
      }
    }
    return localObject1;
  }
  
  public void a(wop.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "prepare");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      parama.yH(false);
      return;
    }
    if (ajnt.a(localQQAppInterface).bi(this.aTK, this.aTL))
    {
      aT(localQQAppInterface);
      parama.yH(true);
      return;
    }
    ajnt.a(localQQAppInterface).a(this.aTK, this.aTL, new woi(this, parama));
  }
  
  public void cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "cancel");
    }
    if (this.c != null)
    {
      this.c.cancelAnimation();
      this.c.recycleBitmaps();
    }
    if (this.a != null)
    {
      this.a.cancelAnimation();
      this.a.recycleBitmaps();
    }
    setVisibility(8);
    super.cancel();
  }
  
  public void dA(String paramString1, String paramString2)
  {
    this.aTK = paramString1;
    this.aTL = paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "setLottieResources url:" + paramString1 + " md5:" + paramString2);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnDestroy");
    }
    if (this.c != null)
    {
      this.c.cancelAnimation();
      this.c.recycleBitmaps();
    }
    if (this.a != null)
    {
      this.a.cancelAnimation();
      this.a.recycleBitmaps();
    }
    this.c = null;
    this.sp = null;
    this.mDestroyed = true;
    this.mPaused = true;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnPause");
    }
    if ((this.c != null) && (this.c.isAnimating())) {
      this.c.pauseAnimation();
    }
    if ((this.a != null) && (this.a.isAnimating())) {
      this.a.pauseAnimation();
    }
    this.mPaused = false;
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnResume");
    }
    if (this.c != null) {
      this.c.resumeAnimation();
    }
    if ((this.a != null) && (this.a.isAnimating())) {
      this.a.resumeAnimation();
    }
    this.mPaused = true;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    cancel();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void play()
  {
    super.play();
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "play");
    }
    ThreadManager.getUIHandler().postDelayed(new LottieAnimDirector.5(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wog
 * JD-Core Version:    0.7.0.1
 */