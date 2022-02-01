import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class iyr
{
  boolean Wn;
  public boolean Wo;
  public PopupWindow b;
  private Runnable bQ;
  private Runnable bR;
  RelativeLayout dZ;
  public View hS;
  VideoAppInterface mApp;
  WeakReference<AVActivity> mContext;
  
  private boolean J(boolean paramBoolean)
  {
    if (AudioHelper.jY(0) == 1) {}
    do
    {
      return true;
      if (paramBoolean)
      {
        if (this.mApp == null) {
          return false;
        }
        if (this.mApp.b().b().Rg) {
          return false;
        }
        if (!jll.o(this.mApp)) {
          return false;
        }
      }
      if (this.hS.getVisibility() != 0) {
        return false;
      }
      if (!this.hS.isEnabled()) {
        return false;
      }
    } while (iow.uZ());
    return false;
  }
  
  private void asE()
  {
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
    if (this.dZ != null)
    {
      TextView localTextView = (TextView)this.dZ.findViewById(2131381437);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        localTextView.setOnClickListener(null);
      }
    }
    this.hS.removeCallbacks(this.bQ);
  }
  
  private void asF()
  {
    if (!J(true)) {}
    TextView localTextView;
    do
    {
      do
      {
        return;
        localObject = (AVActivity)this.mContext.get();
      } while (localObject == null);
      localTextView = null;
      if (this.dZ != null) {
        localTextView = (TextView)this.dZ.findViewById(2131381437);
      }
    } while (localTextView == null);
    int i = ((AVActivity)localObject).getWindow().getDecorView().getWidth();
    int j = ((AVActivity)localObject).getWindow().getDecorView().getHeight();
    localTextView.measure(0, 0);
    int k = localTextView.getMeasuredWidth();
    localTextView.getMeasuredHeight();
    Object localObject = new int[2];
    this.hS.getLocationInWindow((int[])localObject);
    int m = localObject[0];
    int n = localObject[1];
    localObject = (RelativeLayout)localTextView.getParent();
    int[] arrayOfInt = new int[2];
    ((RelativeLayout)localObject).getLocationInWindow(arrayOfInt);
    int i1 = i - arrayOfInt[0] - ((RelativeLayout)localObject).getWidth();
    int i2 = j - arrayOfInt[1] - ((RelativeLayout)localObject).getHeight();
    float f1 = i - m - this.hS.getWidth() / 2 - k / 2 - i1 + wja.dp2px(0.0F, this.hS.getResources());
    float f2 = j - n - i2 - wja.dp2px(11.0F, this.hS.getResources());
    localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, (int)f1, (int)f2);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    QLog.e("qav_face_guide", 1, "qav_face_guide, location_Host[" + m + n + "], hostTop[" + n + "], hostRight[" + n + "], hostBottom[" + n + "], offsetDP_right[" + 0.0F + "], offsetDP_bottom[" + 11.0F + "], pos_right[" + f1 + "], pos_bottom[" + f2 + "], hostID[" + this.hS.getId() + "], Width[" + this.hS.getWidth() + "], Height[" + this.hS.getHeight() + "], textViewWidth[" + k + "], parentRight[" + i1 + "], parentBottom[" + i2 + "]");
    localTextView.getViewTreeObserver().addOnPreDrawListener(new iys(this, localTextView));
    asE();
    if (this.dZ == null) {
      j(localTextView);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new iyt(this));
      return;
      i(localTextView);
    }
  }
  
  private void dg(long paramLong)
  {
    EffectSettingUi.a(this.mApp, paramLong);
    this.hS.postDelayed(this.bR, 3000L);
  }
  
  private void i(TextView paramTextView)
  {
    if (this.dZ.findViewById(2131381437) != null)
    {
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.measure(0, 0);
    int i = paramTextView.getMeasuredWidth();
    int j = paramTextView.getMeasuredHeight();
    Object localObject = new int[2];
    this.hS.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt1 = new int[2];
    this.dZ.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt2 = new int[2];
    localObject[0] -= arrayOfInt1[0];
    localObject[1] -= arrayOfInt1[1];
    float f1 = (arrayOfInt2[0] * 2 + this.hS.getWidth() - i) / 2;
    int k = arrayOfInt2[1];
    float f2 = wja.dp2px(0, this.hS.getResources()) + (k - j);
    QLog.d("qav_face_guide", 1, String.format("host(%s, %s), Parent(%s, %s), cur(%s, %s), dest(%s, %s), textview(%s, %s)", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(arrayOfInt1[0]), Integer.valueOf(arrayOfInt1[1]), Integer.valueOf(arrayOfInt2[0]), Integer.valueOf(arrayOfInt2[1]), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) }));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(5);
    ((RelativeLayout.LayoutParams)localObject).addRule(6);
    ((RelativeLayout.LayoutParams)localObject).setMargins((int)f1, (int)f2, 0, 0);
    this.dZ.addView(paramTextView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void j(TextView paramTextView)
  {
    this.b = new PopupWindow(this.hS.getContext());
    this.b.setBackgroundDrawable(null);
    this.b.setContentView(paramTextView);
    this.b.setWidth(-2);
    this.b.setHeight(-2);
    this.b.setOutsideTouchable(this.Wn);
    this.b.setAnimationStyle(2131756459);
    paramTextView.measure(0, 0);
    int j = paramTextView.getMeasuredWidth();
    int i = paramTextView.getMeasuredHeight();
    paramTextView = new int[2];
    this.hS.getLocationOnScreen(paramTextView);
    j = (paramTextView[0] * 2 + this.hS.getWidth() - j) / 2;
    int k = paramTextView[1];
    int m = wja.dp2px(0, this.hS.getResources());
    this.b.showAtLocation(this.hS, 0, j, k - i + m);
    QLog.d("qav_face_guide", 1, "showUserGuide_PopupWindow");
  }
  
  public void asC()
  {
    this.mApp.b().b().Rg = true;
    jll.u(this.mApp);
    asE();
  }
  
  public void asD()
  {
    asE();
  }
  
  public void onDestroy()
  {
    asE();
    this.mContext = null;
    this.mApp = null;
    this.hS.removeCallbacks(this.bR);
    this.hS = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyr
 * JD-Core Version:    0.7.0.1
 */