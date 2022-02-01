import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class wqq
  extends aook
{
  wqq(wqp paramwqp) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 327696) || (localaoko.commandId != 68)) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + wqp.a(this.this$0).get() + " pos=" + localaoko.dPs);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + wqp.a(this.this$0).get() + "  isSttFinish=" + wqp.a(this.this$0).get() + " pos=" + localaoko.dPs);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest finish text =" + localaoko.clC + " pos=" + localaoko.dPs);
        }
        if (localaoko.clC != null)
        {
          this.this$0.a(new wqc.a(localaoko.clC, true), localaoko.dPs);
          wqp.a(this.this$0).caF();
        }
        wqp.a(this.this$0).set(wqp.a(this.this$0).get() - 1);
      } while (wqp.a(this.this$0).get() != 0);
      wqp.a(this.this$0).clear();
      wqp.a(this.this$0).setSttNetFinish();
      wqp.a(this.this$0).b(wqp.a(this.this$0));
      wqp.a(this.this$0, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localaoko.errorCode);
      }
      wqp.a(this.this$0).Cx(localaoko.errorCode);
      wqp.a(this.this$0, 0, localaoko.errorCode);
      this.this$0.cancelAllRequest();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localaoko.clC + " pos=" + localaoko.dPs);
      }
    } while ((aqmr.isEmpty(localaoko.clC)) || (wqp.a(this.this$0).get() <= 0));
    this.this$0.a(new wqc.a(localaoko.clC, false), localaoko.dPs);
    wqp.a(this.this$0).caF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqq
 * JD-Core Version:    0.7.0.1
 */