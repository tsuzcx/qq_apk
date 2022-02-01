package cooperation.qqreader.host.toast;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class QQToastWrapper
  implements Toast
{
  private QQToast a;
  private android.widget.Toast h;
  
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramContext = new QQToastWrapper();
    paramContext.a = QQToast.a(BaseApplicationImpl.getApplication(), paramInt2, paramCharSequence, paramInt1);
    return paramContext;
  }
  
  public void cancel()
  {
    if (this.h != null) {
      this.h.cancel();
    }
  }
  
  public void setDuration(int paramInt)
  {
    if (this.a == null) {
      this.a = new QQToast(BaseApplicationImpl.getApplication());
    }
    this.a.setDuration(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.a == null) {
      this.a = new QQToast(BaseApplicationImpl.getApplication());
    }
    this.a.setToastMsg(paramCharSequence);
  }
  
  public void show()
  {
    if (this.a == null) {
      return;
    }
    this.h = this.a.show();
  }
  
  public void show(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.show(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.toast.QQToastWrapper
 * JD-Core Version:    0.7.0.1
 */