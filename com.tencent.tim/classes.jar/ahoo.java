import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;

public class ahoo
  extends Handler
{
  public ahoo(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return;
        if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()))
        {
          this.a.v.setMessage(this.a.getString(2131691514));
          this.a.v.setTipImageView(2130850674);
          this.a.v.showProgerss(false);
        }
        this.a.handler.sendEmptyMessageDelayed(1, 1000L);
        return;
      } while ((this.a.v == null) || (!this.a.v.isShowing()));
      this.a.v.cancel();
      this.a.v.setMessage(this.a.getString(2131691516));
      this.a.v.setBackAndSearchFilter(true);
      this.a.v.showTipImageView(false);
      this.a.v.showProgerss(true);
      return;
    }
    QQSettingChatOperationFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoo
 * JD-Core Version:    0.7.0.1
 */