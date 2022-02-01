import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class sor
{
  protected Drawable mBackground;
  protected Context mContext;
  protected View mRootView;
  protected PopupWindow mWindow;
  protected WindowManager mWindowManager;
  
  public sor(Context paramContext)
  {
    this.mContext = paramContext;
    this.mWindow = new PopupWindow(paramContext);
    this.mWindow.setTouchInterceptor(new sos(this));
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public void dismiss()
  {
    this.mWindow.dismiss();
  }
  
  protected void preShow()
  {
    if (this.mRootView == null) {
      throw new IllegalStateException("setContentView was not called with a view to display.");
    }
    if (this.mBackground == null) {
      this.mWindow.setBackgroundDrawable(new BitmapDrawable());
    }
    for (;;)
    {
      this.mWindow.setWidth(-2);
      this.mWindow.setHeight(-2);
      this.mWindow.setTouchable(true);
      this.mWindow.setFocusable(false);
      this.mWindow.setOutsideTouchable(true);
      this.mWindow.setContentView(this.mRootView);
      return;
      this.mWindow.setBackgroundDrawable(this.mBackground);
    }
  }
  
  public void setContentView(View paramView)
  {
    this.mRootView = paramView;
    this.mWindow.setContentView(paramView);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mWindow.setOnDismissListener(paramOnDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sor
 * JD-Core Version:    0.7.0.1
 */