import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;

public class ahoq
  extends Handler
{
  public ahoq(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = this.a.getActivity();
      if ((paramMessage != null) && (!paramMessage.isFinishing()))
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoq
 * JD-Core Version:    0.7.0.1
 */