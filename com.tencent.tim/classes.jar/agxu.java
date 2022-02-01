import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class agxu
{
  public View CS;
  protected View CT;
  protected TextView SD;
  protected TextView SE;
  protected TextView SF;
  protected agxu.a a;
  protected ProgressBar ac;
  protected Bundle ba;
  protected RelativeLayout kp;
  public Activity mContext;
  protected ViewGroup mRootView;
  
  public agxu(Activity paramActivity)
  {
    this.mContext = paramActivity;
  }
  
  public void D(View.OnClickListener paramOnClickListener)
  {
    if ((this.CS != null) && (this.kp == null))
    {
      this.kp = ((RelativeLayout)this.CS.findViewById(2131380162));
      this.ac = ((ProgressBar)this.CS.findViewById(2131380127));
      this.SD = ((TextView)this.CS.findViewById(2131380137));
      this.SE = ((TextView)this.CS.findViewById(2131366568));
      this.CT = this.CS.findViewById(2131380125);
    }
    this.CT.setOnClickListener(paramOnClickListener);
  }
  
  public void JJ(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.SF != null)
    {
      localTextView = this.SF;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void JK(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.kp != null)
    {
      localRelativeLayout = this.kp;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void Jn(String paramString)
  {
    if (this.kp != null) {
      this.SD.setText(paramString);
    }
  }
  
  public void Jo(String paramString)
  {
    if (this.kp != null) {
      this.SE.setText(paramString);
    }
  }
  
  public void OJ(int paramInt)
  {
    if (this.kp != null) {
      this.ac.setProgress(paramInt);
    }
  }
  
  public void OK(int paramInt)
  {
    if (this.SE != null) {
      this.SE.setVisibility(paramInt);
    }
  }
  
  public void a(agxu.a parama)
  {
    this.a = parama;
  }
  
  public void cB(Bundle paramBundle)
  {
    this.ba = paramBundle;
  }
  
  public View ca()
  {
    return this.CS;
  }
  
  public abstract void dkq();
  
  public void dkr()
  {
    if (this.CT != null) {
      this.CT.setVisibility(8);
    }
  }
  
  public void f(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.SF == null) {
      this.SF = ((TextView)this.CS.findViewById(2131372657));
    }
    if (this.SF != null)
    {
      this.SF.setText(paramString);
      this.SF.setOnClickListener(paramOnClickListener);
      this.SF.setVisibility(0);
      JJ(true);
    }
  }
  
  public Rect u()
  {
    if (this.ba != null) {
      return (Rect)this.ba.getParcelable("file_browser_params_thumb_bound");
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void djZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxu
 * JD-Core Version:    0.7.0.1
 */