import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class qdu
{
  private static Long K = Long.valueOf(0L);
  public arhz a;
  private qdt a;
  public boolean aCU = true;
  public WeakReference<Activity> mContextWeakReference;
  public boolean mShowTitle = true;
  public String mTitle;
  public List<int[]> nK;
  
  public qdu(Activity paramActivity)
  {
    this.mContextWeakReference = new WeakReference(paramActivity);
  }
  
  public static boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - K.longValue();
    if ((l2 > 0L) && (l2 < 800L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isFastDoubleClick", 2, "time:" + l1 + ", mLastClickTIme:" + K + ", timeDiff:" + l2);
      }
      return true;
    }
    K = Long.valueOf(l1);
    return false;
  }
  
  public void a(qdt paramqdt)
  {
    this.jdField_a_of_type_Qdt = paramqdt;
  }
  
  public abstract int dR(int paramInt);
  
  public void dismissProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public Activity m()
  {
    return (Activity)this.mContextWeakReference.get();
  }
  
  protected void onCancel()
  {
    if (this.jdField_a_of_type_Qdt != null) {
      this.jdField_a_of_type_Qdt.onCancel();
    }
  }
  
  protected void onDismiss()
  {
    if (this.jdField_a_of_type_Qdt != null) {
      this.jdField_a_of_type_Qdt.onDismiss();
    }
  }
  
  protected abstract void onShow();
  
  public void show()
  {
    onShow();
    if (this.jdField_a_of_type_Qdt != null) {
      this.jdField_a_of_type_Qdt.onShow();
    }
  }
  
  public void showProgressDialog()
  {
    if (!this.aCU) {}
    do
    {
      Activity localActivity;
      do
      {
        return;
        if (this.jdField_a_of_type_Arhz != null) {
          break;
        }
        localActivity = m();
      } while (localActivity == null);
      int i = localActivity.getResources().getDimensionPixelSize(2131299627);
      this.jdField_a_of_type_Arhz = new arhz(localActivity);
      this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131714425));
      this.jdField_a_of_type_Arhz.setOffsetY(i);
    } while (this.jdField_a_of_type_Arhz.isShowing());
    this.jdField_a_of_type_Arhz.show();
  }
  
  protected void vU(int paramInt)
  {
    if (isFastDoubleClick()) {
      return;
    }
    showProgressDialog();
    this.jdField_a_of_type_Qdt.onClick(dR(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdu
 * JD-Core Version:    0.7.0.1
 */