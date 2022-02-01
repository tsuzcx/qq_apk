import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.av.utils.QQFrameByFrameAnimation.1;

public class jks
{
  public int aAE = 0;
  public jkr b = null;
  public int[] cU;
  public int mDuration = 300;
  public int mFrames = 0;
  public Handler mHandler = new Handler();
  public int mRepeatCount = 0;
  Runnable mRunnable = new QQFrameByFrameAnimation.1(this);
  View mView = null;
  
  public void a(jkr paramjkr)
  {
    this.b = paramjkr;
  }
  
  public void axv()
  {
    this.mFrames += 1;
    int i;
    if ((this.mView != null) && (this.cU != null) && (this.cU.length > 0))
    {
      i = this.cU[(this.mFrames % this.cU.length)];
      if (!(this.mView instanceof ImageButton)) {
        break label67;
      }
      this.mView.setBackgroundResource(i);
    }
    label67:
    while (!(this.mView instanceof Button)) {
      return;
    }
    Drawable localDrawable = this.mView.getResources().getDrawable(i);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    ((Button)this.mView).setCompoundDrawables(null, localDrawable, null, null);
  }
  
  public void h(int[] paramArrayOfInt)
  {
    this.cU = paramArrayOfInt;
  }
  
  public void nL(int paramInt)
  {
    this.aAE = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setView(View paramView)
  {
    this.mView = paramView;
  }
  
  public void start()
  {
    if ((this.mView != null) && (this.cU != null) && (this.cU.length > 0))
    {
      this.mFrames = 0;
      if ((this.mView instanceof ImageButton)) {
        this.mView.setBackgroundResource(this.cU[0]);
      }
      if ((this.mView instanceof Button))
      {
        Drawable localDrawable = this.mView.getResources().getDrawable(this.cU[0]);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        ((Button)this.mView).setCompoundDrawables(null, localDrawable, null, null);
      }
      this.mHandler.postDelayed(this.mRunnable, this.mDuration);
      if (this.b != null) {
        this.b.onAnimationStart();
      }
    }
  }
  
  public void stop()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    if (this.b != null) {
      this.b.onAnimationEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jks
 * JD-Core Version:    0.7.0.1
 */