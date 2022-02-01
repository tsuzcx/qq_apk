import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class ufu
  extends Handler
{
  public ufu(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.this$0.isFinishing())
      {
        this.this$0.v.setMessage(this.this$0.getString(2131691514));
        this.this$0.v.setTipImageView(2130850674);
        this.this$0.v.showProgerss(false);
      }
      this.this$0.handler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.this$0.v == null) || (!this.this$0.v.isShowing()));
    this.this$0.v.cancel();
    this.this$0.v.setMessage(this.this$0.getString(2131691516));
    this.this$0.v.setBackAndSearchFilter(true);
    this.this$0.v.showTipImageView(false);
    this.this$0.v.showProgerss(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufu
 * JD-Core Version:    0.7.0.1
 */