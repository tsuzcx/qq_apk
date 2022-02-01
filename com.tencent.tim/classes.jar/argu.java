import android.animation.ValueAnimator;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

public class argu
  extends PopupWindow
{
  protected Context context;
  private View maskView;
  private WindowManager windowManager;
  
  public argu(Context paramContext)
  {
    super(paramContext, null, 2131756568);
    this.context = paramContext;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  private void c(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    this.maskView = new View(this.context);
    this.maskView.setBackgroundColor(855638016);
    this.maskView.setFitsSystemWindows(false);
    this.maskView.setOnKeyListener(new argv(this));
    this.windowManager.addView(this.maskView, localLayoutParams);
    paramIBinder = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramIBinder.setDuration(400L);
    paramIBinder.addUpdateListener(new argw(this));
    paramIBinder.start();
  }
  
  private void eio()
  {
    if (this.maskView != null)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new argx(this));
      localValueAnimator.addListener(new argy(this));
      localValueAnimator.start();
    }
  }
  
  public void dismiss()
  {
    eio();
    super.dismiss();
  }
  
  public void showAsDropDown(View paramView)
  {
    c(paramView.getWindowToken());
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    c(paramView.getWindowToken());
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramView.getWindowToken());
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argu
 * JD-Core Version:    0.7.0.1
 */