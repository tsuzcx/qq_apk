import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class aucp
{
  protected View CS;
  protected View CT;
  protected TextView SD;
  protected TextView SF;
  protected ProgressBar ac;
  protected RelativeLayout kp;
  protected Activity mContext;
  protected ViewGroup mRootView;
  
  public aucp(Activity paramActivity)
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
    for (int i = 0;; i = 4)
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
  
  public void OJ(int paramInt)
  {
    if (this.kp != null) {
      this.ac.setProgress(paramInt);
    }
  }
  
  public View ca()
  {
    return this.CS;
  }
  
  public abstract void dkq();
  
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucp
 * JD-Core Version:    0.7.0.1
 */