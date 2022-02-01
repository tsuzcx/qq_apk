import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class arib
  implements DialogInterface.OnCancelListener, Handler.Callback
{
  public arhz D;
  protected final ArrayList<DialogInterface.OnCancelListener> Do;
  protected final Handler handler;
  int mLayoutId;
  protected final WeakReference<Activity> mRef;
  
  public arib(Activity paramActivity)
  {
    this(paramActivity, -1);
  }
  
  public arib(Activity paramActivity, int paramInt)
  {
    this.mRef = new WeakReference(paramActivity);
    this.mLayoutId = paramInt;
    this.Do = new ArrayList();
    this.handler = new auru(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Activity localActivity = (Activity)this.mRef.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    if (paramOnCancelListener != null) {
      this.Do.add(paramOnCancelListener);
    }
    this.handler.removeMessages(1);
    this.handler.removeMessages(2);
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramOnCancelListener = Message.obtain();
      paramOnCancelListener.what = 1;
      paramOnCancelListener.arg1 = paramInt1;
      paramOnCancelListener.arg2 = 0;
      paramOnCancelListener.obj = paramString;
      this.handler.sendMessageDelayed(paramOnCancelListener, paramInt2);
      return;
    }
    if (this.D == null)
    {
      if (this.mLayoutId > 0) {
        this.D = new arhz(localActivity, 0, this.mLayoutId, 17);
      }
    }
    else
    {
      label147:
      if (!this.Do.isEmpty()) {
        break label290;
      }
      this.D.setOnCancelListener(null);
      label165:
      if (paramInt1 != 0) {
        break label320;
      }
      if ((paramString != null) && (!"".equals(paramString.trim()))) {
        break label301;
      }
      this.D.setMessage(localActivity.getString(2131719519));
    }
    for (;;)
    {
      this.D.showTipImageView(false);
      this.D.showProgerss(true);
      if (!localActivity.isFinishing()) {
        break label312;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQProgressNotifier", 4, "[" + localActivity.isFinishing() + "]");
      return;
      this.D = new arhz(localActivity, localActivity.getResources().getDimensionPixelSize(2131299627));
      break label147;
      label290:
      this.D.setOnCancelListener(this);
      break label165;
      label301:
      this.D.setMessage(paramString);
    }
    label312:
    this.D.show();
    return;
    label320:
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 6))
    {
      this.D.setMessage(paramString);
      this.D.setTipImageView(2130840095);
      this.D.showTipImageView(true);
      this.D.showProgerss(false);
      if (!this.D.isShowing())
      {
        if (!localActivity.isFinishing()) {
          break label485;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQProgressNotifier", 4, "[" + localActivity.isFinishing() + "]");
        }
      }
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      paramOnCancelListener = this.handler;
      if (paramInt2 <= 0) {
        break label495;
      }
    }
    label427:
    label485:
    label495:
    for (long l = paramInt2;; l = 1000L)
    {
      paramOnCancelListener.sendMessageDelayed(paramString, l);
      return;
      this.D.setMessage(paramString);
      this.D.setTipImageView(2130840113);
      break;
      this.D.show();
      break label427;
    }
  }
  
  public void aa(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, null);
  }
  
  public void aq(int paramInt1, int paramInt2, int paramInt3)
  {
    Activity localActivity = (Activity)this.mRef.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    aa(paramInt1, localActivity.getString(paramInt2), paramInt3);
  }
  
  public void dismiss()
  {
    this.handler.removeMessages(1);
    this.handler.removeMessages(2);
    try
    {
      if ((this.D != null) && (this.D.isShowing())) {
        this.D.dismiss();
      }
      this.Do.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      aa(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.what != 2);
        dismiss();
      } while ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 4) && (paramMessage.arg1 != 6) && (paramMessage.arg1 != 5));
      Activity localActivity = (Activity)this.mRef.get();
      if (localActivity != null)
      {
        if ((paramMessage.arg1 == 6) || (paramMessage.arg1 == 5))
        {
          paramMessage = new Intent();
          paramMessage.putExtra("isNeedFinish", true);
          localActivity.setResult(-1, paramMessage);
        }
        for (;;)
        {
          localActivity.finish();
          return true;
          localActivity.setResult(-1);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQProgressNotifier", 2, "handleMessage baseActivity is null");
    return true;
  }
  
  public boolean isShowing()
  {
    return (this.D != null) && (this.D.isShowing());
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProgressNotifier", 4, "onCancel");
    }
    if (this.Do.size() > 0)
    {
      paramDialogInterface = this.Do.iterator();
      while (paramDialogInterface.hasNext())
      {
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)paramDialogInterface.next();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(this.D);
        }
      }
    }
    this.Do.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arib
 * JD-Core Version:    0.7.0.1
 */