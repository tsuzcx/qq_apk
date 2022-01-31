import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoder.VideoEncoderCallback;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class zvm
  extends Handler
{
  private WeakReference a;
  
  public zvm(Looper paramLooper, VideoEncoderCore paramVideoEncoderCore)
  {
    super(paramLooper);
    this.a = new WeakReference(paramVideoEncoderCore);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a != null) {}
    for (VideoEncoderCore localVideoEncoderCore = (VideoEncoderCore)this.a.get();; localVideoEncoderCore = null)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (localVideoEncoderCore == null);
        paramMessage = (Object[])paramMessage.obj;
        try
        {
          VideoEncoderCore.a(localVideoEncoderCore, (byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.e("VideoEncoderCore", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        }
      } while (VideoEncoderCore.a(localVideoEncoderCore) == null);
      VideoEncoderCore.a(localVideoEncoderCore).a(3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zvm
 * JD-Core Version:    0.7.0.1
 */