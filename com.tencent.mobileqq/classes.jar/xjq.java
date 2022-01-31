import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class xjq
  extends Handler
{
  WeakReference a;
  
  public xjq(QzoneHbFragment paramQzoneHbFragment)
  {
    this.a = new WeakReference(paramQzoneHbFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QzoneHbFragment localQzoneHbFragment = (QzoneHbFragment)this.a.get();
    if (localQzoneHbFragment == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 102: 
          default: 
            return;
          case 100: 
            if (QLog.isColorLevel()) {
              QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----1");
            }
            break;
          }
        } while ((QzoneHbFragment.a(localQzoneHbFragment) == null) || (TextUtils.isEmpty(QzoneHbFragment.a(localQzoneHbFragment))));
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----in mModifyAmountBtn.setEnabled(false)");
          }
          double d = Double.parseDouble(QzoneHbFragment.a(localQzoneHbFragment));
          QzoneHbFragment.a(localQzoneHbFragment).reset(d);
          QzoneHbFragment.a(localQzoneHbFragment).setVisibility(0);
          QzoneHbFragment.a(localQzoneHbFragment).setVisibility(8);
          QzoneHbFragment.a(localQzoneHbFragment).roll();
          QzoneHbFragment.b(localQzoneHbFragment).setEnabled(false);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
      } while (TextUtils.isEmpty(QzoneHbFragment.a(localQzoneHbFragment)));
      QzoneHbFragment.a(localQzoneHbFragment).setText(QzoneHbFragment.a(localQzoneHbFragment));
      QzoneHbFragment.a(localQzoneHbFragment).setVisibility(8);
      QzoneHbFragment.a(localQzoneHbFragment).setVisibility(0);
      QzoneHbFragment.b(localQzoneHbFragment).setEnabled(true);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneHbFragment", 2, "MSG_ROLL_STOP AmountBtn.setEnabled(true)---");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjq
 * JD-Core Version:    0.7.0.1
 */