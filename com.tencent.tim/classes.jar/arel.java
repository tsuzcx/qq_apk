import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.AntiphingToast.3;
import java.util.Timer;

public class arel
{
  private String cAi = "AntiPhing";
  private boolean cZr = true;
  private FrameLayout cj;
  private View contentView;
  public Handler handler = new arem(this, Looper.getMainLooper());
  private int mDuration;
  private LayoutInflater mInflater;
  private Resources mResources;
  private CharSequence message;
  
  public void a(int paramInt1, int paramInt2, FrameLayout paramFrameLayout)
  {
    f(paramFrameLayout);
    setToastMsg(paramInt1);
    setDuration(paramInt2);
  }
  
  public void e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setStartOffset(20L);
    if (paramBoolean == true) {
      localTranslateAnimation.setAnimationListener(new aren(this));
    }
    this.cj.startAnimation(localTranslateAnimation);
  }
  
  public void f(FrameLayout paramFrameLayout)
  {
    this.cj = paramFrameLayout;
    this.mResources = paramFrameLayout.getContext().getResources();
  }
  
  public boolean sc(String paramString)
  {
    if ((!this.cZr) || (this.cj == null)) {
      return false;
    }
    this.cZr = false;
    this.cj.removeAllViewsInLayout();
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(this.cj.getContext());
    }
    if (this.contentView == null)
    {
      this.contentView = this.mInflater.inflate(2131562065, null);
      if (this.contentView != null)
      {
        TextView localTextView = (TextView)this.contentView.findViewById(2131362741);
        if ((localTextView != null) && (paramString != null)) {
          localTextView.setText(paramString);
        }
      }
    }
    this.cj.addView(this.contentView);
    this.cj.setFocusable(false);
    this.cj.bringToFront();
    e(-80.0F, 0.0F, false);
    new Timer().schedule(new AntiphingToast.3(this), this.mDuration + 700);
    return true;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setToastMsg(int paramInt)
  {
    setToastMsg(this.mResources.getString(paramInt));
  }
  
  public void setToastMsg(CharSequence paramCharSequence)
  {
    this.message = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arel
 * JD-Core Version:    0.7.0.1
 */