import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

public class jnn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private jnn.a a;
  private final int aCn;
  private boolean aaO;
  private View mRootView;
  
  public jnn(View paramView, jnn.a parama)
  {
    this(paramView, parama, rpq.dip2px(paramView.getContext(), 160.0F));
  }
  
  public jnn(View paramView, jnn.a parama, int paramInt)
  {
    this.mRootView = paramView;
    this.a = parama;
    this.aCn = paramInt;
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void destroy()
  {
    this.a = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onGlobalLayout()
  {
    boolean bool = true;
    Rect localRect = new Rect();
    for (;;)
    {
      try
      {
        this.mRootView.getWindowVisibleDisplayFrame(localRect);
        int i = this.mRootView.getRootView().getHeight();
        int j = localRect.bottom;
        int k = localRect.top;
        if (this.a != null)
        {
          if (i - (j - k) < this.aCn) {
            break label113;
          }
          if (bool != this.aaO)
          {
            this.aaO = bool;
            this.a.e(bool, localRect.right, localRect.bottom);
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("SoftKeyboardObserver", 1, "getWindowVisibleDisplayFrame error", localNullPointerException);
        return;
      }
      label113:
      bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnn
 * JD-Core Version:    0.7.0.1
 */