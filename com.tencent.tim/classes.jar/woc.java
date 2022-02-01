import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.os.MqqHandler;

public class woc
  extends wol
  implements Animator.AnimatorListener
{
  private static final String[] cB = { "images/img_0.png", "images/img_1.png", "images/img_2.png", "images/img_3.png", "images/img_4.png", "images/img_5.png", "images/img_6.png", "images/img_7.png", "images/img_8.png", "images/img_9.png", "images/img_10.png", "images/img_11.png", "images/img_12.png", "images/img_13.png", "images/img_14.png", "images/img_15.png", "data.json", "icon_close.png" };
  private wpa a;
  private LottieDrawable c;
  private String mResPath = "";
  private ImageView sp;
  
  public woc(Context paramContext)
  {
    super(paramContext);
    this.a = new wpa(paramContext);
    this.a.setOnCloseClickListener(new wod(this));
  }
  
  private void a(LottieComposition paramLottieComposition)
  {
    QLog.i("FriendShipAnimDirector", 1, "decode json success");
    if ((this.c != null) && (paramLottieComposition != null))
    {
      this.c.setComposition(paramLottieComposition);
      this.c.loop(false);
      this.c.addAnimatorListener(this);
      if (this.sp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendShipAnimDirector", 2, "refresh Lottie.d");
        }
        this.sp.setImageDrawable(null);
        this.sp.setImageDrawable(this.c);
      }
    }
  }
  
  private static boolean hD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "begin checkRes");
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String[] arrayOfString = cB;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      str = paramString + str;
      if (QLog.isColorLevel()) {
        QLog.d("FriendShipAnimDirector", 2, "checkRes: " + str);
      }
      if (!aqhq.fileExists(str))
      {
        QLog.e("FriendShipAnimDirector", 1, "checkRes failed, " + str + " is not exist");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void a(wop.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "prepare");
    }
    this.mResPath = ajol.xw();
    boolean bool = hD(this.mResPath);
    if (!bool) {
      QLog.e("FriendShipAnimDirector", 1, "cannot find anim resource, animation will not show");
    }
    if ((bool) && (this.c == null))
    {
      this.c = new LottieDrawable();
      this.c.setImageAssetDelegate(new woe(this));
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.mResPath + "data.json");
      QLog.i("FriendShipAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(m(), localFileInputStream, new wof(this));
      super.a(parama);
      parama.yH(bool);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FriendShipAnimDirector", 1, "Decode anim json error");
      }
    }
  }
  
  public void cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "cancel");
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
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnDestroy");
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
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnPause");
    }
    if ((this.c != null) && (this.c.isAnimating())) {
      this.c.pauseAnimation();
    }
    if ((this.a != null) && (this.a.isAnimating())) {
      this.a.pauseAnimation();
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnResume");
    }
    if (this.c != null) {
      this.c.resumeAnimation();
    }
    if ((this.a != null) && (this.a.isAnimating())) {
      this.a.resumeAnimation();
    }
  }
  
  public int getType()
  {
    return 2;
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
      QLog.d("FriendShipAnimDirector", 2, "play");
    }
    ThreadManager.getUIHandler().postDelayed(new FriendShipAnimDirector.4(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     woc
 * JD-Core Version:    0.7.0.1
 */