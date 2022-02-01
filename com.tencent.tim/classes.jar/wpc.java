import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.qphone.base.util.QLog;

public class wpc
{
  private ValueAnimator Y;
  private View.OnClickListener dJ;
  private Bitmap dR;
  private View mBackgroundView;
  private ImageView mCloseBtn;
  private Context mContext;
  
  public wpc(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void a(FriendShipLayout paramFriendShipLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setRootContainer");
    }
    if (paramFriendShipLayout != null)
    {
      this.mCloseBtn = new ImageView(this.mContext);
      this.mCloseBtn.setScaleType(ImageView.ScaleType.FIT_CENTER);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = ankt.dip2px(30.0F);
      localLayoutParams.rightMargin = ankt.dip2px(30.0F);
      paramFriendShipLayout.addView(this.mCloseBtn, localLayoutParams);
      if (this.dJ != null) {
        this.mCloseBtn.setOnClickListener(this.dJ);
      }
    }
  }
  
  public void cancelAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "cancelAnimation");
    }
    if (this.Y != null)
    {
      if (this.mCloseBtn != null) {
        this.mCloseBtn.setImageDrawable(null);
      }
      this.Y.cancel();
    }
  }
  
  public void eV(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setBackgroundView");
    }
    this.mBackgroundView = paramView;
    this.Y = ValueAnimator.ofObject(new wpc.a(null), new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.Y.setDuration(3350L);
    this.Y.addUpdateListener(new wpd(this));
  }
  
  public boolean isAnimating()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "isAnimating");
    }
    if (this.Y != null) {
      this.Y.isRunning();
    }
    return false;
  }
  
  public void pauseAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "pauseAnimation");
    }
    if ((this.Y != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.Y.pause();
    }
  }
  
  public void playAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "playAnimation");
    }
    if (this.Y != null)
    {
      if (this.mCloseBtn != null) {
        this.mCloseBtn.setImageBitmap(this.dR);
      }
      this.Y.start();
    }
  }
  
  public void recycleBitmaps()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "recycleBitmaps");
    }
    if ((this.dR != null) && (!this.dR.isRecycled()))
    {
      if (this.mCloseBtn != null) {
        this.mCloseBtn.setImageDrawable(null);
      }
      this.dR.recycle();
    }
  }
  
  public void resumeAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "resumeAnimation");
    }
    if ((this.Y != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.Y.resume();
    }
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setOnCloseClickListener");
    }
    this.dJ = paramOnClickListener;
    if ((this.dJ != null) && (this.mCloseBtn != null)) {
      this.mCloseBtn.setOnClickListener(this.dJ);
    }
  }
  
  public void xz(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setCloseBtnBitmapPath: " + paramString);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = 320;
    try
    {
      if ((this.dR != null) && (!this.dR.isRecycled()))
      {
        if (this.mCloseBtn != null) {
          this.mCloseBtn.setImageDrawable(null);
        }
        this.dR.recycle();
      }
      this.dR = aqhu.d(paramString, localOptions);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("LottieAnimController", 1, "Decode bitmap error");
      this.dR = null;
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("LottieAnimController", 1, "Decode bitmap OOM");
      this.dR = null;
    }
  }
  
  static class a
    implements TypeEvaluator
  {
    public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimController", 2, "AlphaEvaluator value: " + paramFloat);
      }
      if ((paramFloat >= 0.0F) && (paramFloat <= 0.02985074626865672D)) {
        return Double.valueOf(paramFloat * 0.5D / 0.02985074626865672D);
      }
      if ((paramFloat > 0.02985074626865672D) && (paramFloat <= 0.9253731343283582D)) {
        return Double.valueOf(0.5D);
      }
      if ((paramFloat > 0.9253731343283582D) && (paramFloat <= 1.0F)) {
        return Double.valueOf((1.0F - paramFloat) * 0.5D / 0.07462686567164178D);
      }
      return Double.valueOf(0.0D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpc
 * JD-Core Version:    0.7.0.1
 */