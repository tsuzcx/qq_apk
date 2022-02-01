import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class whr
  extends ReportDialog
{
  Animatable mAnimatedDrawale = null;
  Context mContext = null;
  
  public whr(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.mAnimatedDrawale != null) {
      this.mAnimatedDrawale.stop();
    }
  }
  
  protected void init(Context paramContext)
  {
    super.requestWindowFeature(1);
    this.mContext = paramContext;
    setContentView(LayoutInflater.from(paramContext).inflate(2131561175, null));
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.setLayout(-1, -1);
      paramContext.setBackgroundDrawable(new ColorDrawable(0));
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramContext.addFlags(67108864);
      }
    }
    setCanceledOnTouchOutside(false);
    paramContext = (ImageView)super.findViewById(2131374323);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -1.0F, 2, 1.0F, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setDuration(800L);
    localTranslateAnimation.setRepeatCount(-1);
    paramContext.startAnimation(localTranslateAnimation);
    super.setCancelable(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        dismiss();
        if ((this.mContext instanceof Activity)) {
          ((Activity)this.mContext).finish();
        }
        return false;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramKeyEvent.printStackTrace();
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.mContext != null)
    {
      this.mAnimatedDrawale = ((Animatable)this.mContext.getResources().getDrawable(2130839657));
      if (this.mAnimatedDrawale != null) {
        this.mAnimatedDrawale.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whr
 * JD-Core Version:    0.7.0.1
 */