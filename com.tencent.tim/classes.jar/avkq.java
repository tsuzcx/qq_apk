import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FadeIconImageView;

public class avkq
  extends ReportDialog
{
  SlideDetectListView c = null;
  Animatable mAnimatedDrawale = null;
  TextView mCenterView = null;
  Context mContext = null;
  
  public avkq(Context paramContext)
  {
    super(paramContext, 2131756470);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131560991, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
    localObject = (TextView)paramContext.findViewById(2131369579);
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(2131691039);
    }
    this.mCenterView = ((TextView)paramContext.findViewById(2131369627));
    try
    {
      if (this.mCenterView != null)
      {
        this.mCenterView.setVisibility(0);
        this.mCenterView.setText(2131693453);
      }
      label140:
      paramContext = (FadeIconImageView)paramContext.findViewById(2131369594);
      if (paramContext != null)
      {
        paramContext.setVisibility(0);
        paramContext.setImageResource(2130840650);
      }
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "enter into QfavLoadingDialog");
      }
      return;
    }
    catch (Exception localException)
    {
      break label140;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.mAnimatedDrawale != null) {
      this.mAnimatedDrawale.stop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.mAnimatedDrawale = ((Animatable)this.mContext.getResources().getDrawable(2130839655));
    if ((this.mAnimatedDrawale != null) && (this.mCenterView != null))
    {
      this.mCenterView.setCompoundDrawablePadding(10);
      this.mCenterView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.mAnimatedDrawale, null, null, null);
      this.mAnimatedDrawale.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avkq
 * JD-Core Version:    0.7.0.1
 */