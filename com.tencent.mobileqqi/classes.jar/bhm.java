import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bhm
  extends Handler
{
  public bhm(GAudioNotifyCenter paramGAudioNotifyCenter) {}
  
  public bhm(GAudioNotifyCenter paramGAudioNotifyCenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.c()) {
      return;
    }
    Intent localIntent;
    switch (paramMessage.what)
    {
    case 10006: 
    case 10007: 
    case 10008: 
    case 10009: 
    default: 
      return;
    case 10002: 
      this.a.a();
      return;
    case 10003: 
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 26);
      localIntent.putExtra("discussId", ((Long)paramMessage.obj).longValue());
      localIntent.putExtra("memberUin", this.a.a.a());
      this.a.a.a().sendBroadcast(localIntent);
      return;
    case 10004: 
      paramMessage = (Object[])paramMessage.obj;
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 24);
      localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
      localIntent.putExtra("cmdUin", (String)paramMessage[1]);
      localIntent.putExtra("uins", (String[])paramMessage[2]);
      this.a.a.a().sendBroadcast(localIntent);
      return;
    case 10005: 
      paramMessage = (Object[])paramMessage.obj;
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 31);
      localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
      localIntent.putExtra("cmdUin", (String)paramMessage[1]);
      localIntent.putExtra("uins", (String[])paramMessage[2]);
      this.a.a.a().sendBroadcast(localIntent);
      return;
    }
    boolean bool = ((Boolean)paramMessage.obj).booleanValue();
    this.a.c(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhm
 * JD-Core Version:    0.7.0.1
 */