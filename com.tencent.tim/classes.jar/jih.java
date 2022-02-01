import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.OtherBtnController.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jih
  extends jit
{
  int aAb = 2130842842;
  public iya b = null;
  WeakReference<AVActivity> bQ = null;
  Runnable cl = null;
  
  jih(jht paramjht)
  {
    super(paramjht);
  }
  
  void awD()
  {
    if (this.mApp == null) {
      return;
    }
    if (this.cl == null) {
      this.cl = new OtherBtnController.2(this);
    }
    this.mApp.getHandler().post(this.cl);
  }
  
  void hook()
  {
    if (this.mApp == null) {}
    boolean bool;
    do
    {
      return;
      if (this.b == null) {
        this.b = new jii(this);
      }
      if (this.cl != null)
      {
        this.mApp.getHandler().removeCallbacks(this.cl);
        this.cl = null;
      }
      bool = xu();
      QLog.w(this.TAG, 1, "hook, mHook[" + bool + "]");
      if (!bool) {
        this.aAb = 2130842842;
      }
      kT(false);
    } while (bool);
    this.bQ = new WeakReference(getAVActivity());
    this.mApp.addObserver(this.b);
  }
  
  public void kT(boolean paramBoolean)
  {
    AVActivity localAVActivity = getAVActivity();
    QLog.w(this.TAG, 1, "setBtnsStyle, lightStyle[" + paramBoolean + "], avActivity[" + localAVActivity + "]");
    if (localAVActivity == null) {}
  }
  
  public void reset()
  {
    this.bQ = null;
  }
  
  public boolean xu()
  {
    if (this.bQ != null) {}
    for (AVActivity localAVActivity = (AVActivity)this.bQ.get(); localAVActivity == null; localAVActivity = null) {
      return false;
    }
    if (localAVActivity == getAVActivity()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jih
 * JD-Core Version:    0.7.0.1
 */