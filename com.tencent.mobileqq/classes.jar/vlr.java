import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

public class vlr
  extends Handler
{
  public vlr(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "EncodeHandler.handleMessage, msg.what = " + paramMessage.what + ", ret is " + paramMessage.arg1);
    }
    switch (paramMessage.what)
    {
    }
    String str;
    do
    {
      int i;
      do
      {
        return;
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoRealItemBuilder", 2, "ret is " + i);
      QLog.i("ShortVideoRealItemBuilder", 2, "data is " + paramMessage);
      return;
      str = paramMessage.getData().getString("maxvideo.file.mp4");
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoRealItemBuilder", 2, "EncodeHandler.handleMessage MaxVideoConst.MSG_ENDret is " + paramMessage.arg1 + ",targetFile is " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlr
 * JD-Core Version:    0.7.0.1
 */