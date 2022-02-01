import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ayes
  implements Handler.Callback
{
  ayes(ayep paramayep) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (ayep.a(this.b)) {
        return false;
      }
      ayep.a(this.b, new axsc());
      paramMessage = Message.obtain();
      paramMessage.what = 111;
      ayep.b(this.b).sendMessageDelayed(paramMessage, 1000L);
      continue;
      paramMessage = this.b.T();
      if ((paramMessage != null) && (paramMessage.exists()))
      {
        ayep.a(this.b).E(paramMessage);
        ayep.a(this.b).bw(this.b.cf());
        ayep.a(this.b).ctT();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: Failed to get audioFile. audioFile = " + paramMessage);
        }
        arxa.a().showToast(2131700423);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayes
 * JD-Core Version:    0.7.0.1
 */