import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class adbp
{
  private TextView QB;
  private FrameLayout bu;
  private volatile boolean mAttached;
  private Context mContext;
  
  public adbp(Context paramContext)
  {
    this.mContext = paramContext;
    initView();
  }
  
  private void initView()
  {
    this.bu = ((FrameLayout)LayoutInflater.from(this.mContext).inflate(2131561213, null));
    this.QB = ((TextView)this.bu.findViewById(2131382319));
  }
  
  public void setShowTips(String paramString)
  {
    this.QB.setVisibility(0);
    this.QB.setText(paramString);
  }
  
  public void x(RelativeLayout paramRelativeLayout)
  {
    QLog.d("ARTransferPromotionUIContainer", 2, "attachToRootViewGroup");
    if (this.mAttached) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = wja.dp2px(57.0F, this.mContext.getResources());
    paramRelativeLayout.addView(this.bu, localLayoutParams);
    this.mAttached = true;
  }
  
  public void y(RelativeLayout paramRelativeLayout)
  {
    QLog.d("ARTransferPromotionUIContainer", 2, "disattachFromRootViewGroup");
    if (!this.mAttached) {}
    while (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    paramRelativeLayout.removeView(this.bu);
    this.mAttached = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbp
 * JD-Core Version:    0.7.0.1
 */