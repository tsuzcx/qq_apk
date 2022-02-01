import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.view.TDCircleProgressView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class akoy
  extends ReportDialog
{
  private TextView Wu;
  private TDCircleProgressView a;
  private Context mContext;
  private View mDivider;
  private LayoutInflater mInflater;
  private View mRootView;
  private TextView tf;
  
  public akoy(Context paramContext)
  {
    super(paramContext, 2131756467);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mRootView = this.mInflater.inflate(2131559725, null);
    setCancelable(false);
    this.a = ((TDCircleProgressView)this.mRootView.findViewById(2131364619));
    this.a.setCurrent(0);
    this.tf = ((TextView)this.mRootView.findViewById(2131380630));
    this.mDivider = this.mRootView.findViewById(2131381451);
    this.Wu = ((TextView)this.mRootView.findViewById(2131380588));
  }
  
  public void K(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.Wu.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void MY(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.Wu.setVisibility(i);
      this.mDivider.setVisibility(i);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.mRootView);
    int i;
    WindowManager.LayoutParams localLayoutParams;
    float f;
    if (this.Wu.getVisibility() == 0)
    {
      i = 1;
      localLayoutParams = paramBundle.getAttributes();
      f = this.mContext.getResources().getDisplayMetrics().density;
      localLayoutParams.width = ((int)(320.0F * f + 0.5F));
      if (i != 0) {
        break label97;
      }
    }
    label97:
    for (localLayoutParams.height = ((int)(145.0F * f + 0.5F));; localLayoutParams.height = ((int)(200.0F * f + 0.5F)))
    {
      paramBundle.setAttributes(localLayoutParams);
      setCanceledOnTouchOutside(false);
      return;
      i = 0;
      break;
    }
  }
  
  public void p(CharSequence paramCharSequence)
  {
    this.tf.setText(paramCharSequence);
  }
  
  public void setProgress(int paramInt)
  {
    this.a.setCurrent(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akoy
 * JD-Core Version:    0.7.0.1
 */