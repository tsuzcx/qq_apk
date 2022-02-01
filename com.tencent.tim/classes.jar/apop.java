import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

public class apop
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static boolean cRQ;
  public static int dVc;
  private View II;
  private apop.a a;
  private int dVd;
  private Activity mActivity;
  private int mStatus = 1;
  
  public apop(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public static void co(Activity paramActivity)
  {
    dVc = u(paramActivity.getWindow().getDecorView());
    cRQ = u(paramActivity);
  }
  
  public static int t(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    int i = paramActivity.getHeight();
    if (u(paramActivity) > i * 3 / 4) {
      return 2;
    }
    return 1;
  }
  
  public static int u(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public static boolean u(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (QLog.isColorLevel()) {
      QLog.d("AtPanelStatus", 2, "onGlobalLayout, top=" + localRect.top + " bottom=" + localRect.bottom);
    }
    return localRect.top == 0;
  }
  
  public void a(apop.a parama)
  {
    if (parama != null) {
      this.mActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    this.mStatus = 1;
    this.a = parama;
    this.dVd = 0;
  }
  
  public void il(View paramView)
  {
    this.II = paramView;
  }
  
  public void onGlobalLayout()
  {
    View localView = this.mActivity.getWindow().getDecorView();
    if (localView == null) {}
    int i;
    int j;
    int k;
    do
    {
      return;
      i = localView.getHeight();
      j = u(localView);
      k = i - j;
      if (this.II != null)
      {
        int m = this.II.getHeight();
        if ((m != this.dVd) && (this.a != null)) {
          this.a.bg(this.mStatus, j, this.dVd);
        }
        this.dVd = m;
      }
    } while (j == this.dVd);
    if (k > i / 4)
    {
      this.mStatus = 1;
      if (this.a != null) {
        this.a.bf(this.mStatus, j, k);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AtPanelStatus", 2, "onGlobalLayout, screenHeight=" + i + " visibleHeight=" + j + " differHeight=" + k + " mode=" + this.mStatus);
      }
      this.dVd = j;
      return;
      if (k < i * 3 / 4)
      {
        this.mStatus = 2;
        if (this.a != null) {
          this.a.bf(this.mStatus, j, k);
        }
      }
    }
  }
  
  @RequiresApi(api=16)
  public void removeListener()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.mActivity.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      this.mStatus = 1;
      this.a = null;
      this.dVd = 0;
      return;
      this.mActivity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bf(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void bg(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apop
 * JD-Core Version:    0.7.0.1
 */