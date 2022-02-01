import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqmn
{
  private static int dZY;
  private aqmn.a b;
  private boolean isFirst = true;
  private int lastHeight;
  private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
  private View rootView;
  private int screenHeight;
  
  public aqmn(View paramView, int paramInt, aqmn.a parama)
  {
    this.screenHeight = paramInt;
    this.rootView = paramView;
    this.b = parama;
    ees();
  }
  
  private static int Mh()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (auwa.hasNavBar(localBaseApplication)) {
      i = auwa.getNavigationBarHeight(localBaseApplication);
    }
    for (int i = (int)((localBaseApplication.getResources().getDisplayMetrics().heightPixels + i) * 0.4D);; i = (int)(localBaseApplication.getResources().getDisplayMetrics().heightPixels * 0.4D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SoftKeyboardHeight", 2, new Object[] { "getMaxEmotionPanelHeight, max keyboard height:", Integer.valueOf(i) });
      }
      return i;
    }
  }
  
  private void ees()
  {
    this.layoutListener = new aqmo(this);
  }
  
  public static int ki(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = wja.dp2px(210.0F, BaseApplicationImpl.getContext().getResources());
    }
    do
    {
      return i;
      if (dZY == 0) {
        dZY = Mh();
      }
      i = paramInt;
    } while (paramInt <= dZY);
    return dZY;
  }
  
  public int Mg()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
    int i;
    if (localSharedPreferences.contains("key_height"))
    {
      i = localSharedPreferences.getInt("key_height", 0);
      this.b.aX(i, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SoftKeyboardHeight", 2, new Object[] { "getSoftKeyboardHeight, keyboard height:", Integer.valueOf(i) });
      }
      this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(this.layoutListener);
      return i;
      i = 0;
    }
  }
  
  public void destroy()
  {
    if (this.layoutListener != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this.layoutListener);
      }
    }
    else {
      return;
    }
    this.rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
  }
  
  public static abstract interface a
  {
    public abstract void aX(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmn
 * JD-Core Version:    0.7.0.1
 */