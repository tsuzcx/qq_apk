import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

public class ahjj
  extends ahjf
{
  private AnimationTextView d;
  private ViewGroup ef;
  private int mMinHeight;
  
  public ahjj(aqju paramaqju)
  {
    super(paramaqju);
  }
  
  protected int EZ()
  {
    if (this.mMinHeight == 0) {
      this.mMinHeight = ((int)((this.mDialog.getRootViewHeight() - this.mContext.getResources().getDimensionPixelSize(2131297368)) / aqnm.mDensity));
    }
    return this.mMinHeight;
  }
  
  public void gc(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewTextController", 2, " bindData ");
    }
    if (paramString1 != null) {
      dQ(paramString1);
    }
    if ((paramString2 != null) && (this.d != null)) {
      this.d.setText(new aofk(paramString2, 5, 20));
    }
  }
  
  protected View getContentView()
  {
    this.ef = ((ViewGroup)LayoutInflater.from(this.mContext).inflate(2131559133, null));
    this.d = ((AnimationTextView)this.ef.findViewById(2131379419));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.ef.setLayoutParams(localLayoutParams);
    this.ef.getViewTreeObserver().addOnGlobalLayoutListener(new ahjk(this));
    return this.ef;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjj
 * JD-Core Version:    0.7.0.1
 */