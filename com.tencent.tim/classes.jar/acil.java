import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acil
  extends BroadcastReceiver
{
  public acil(PeakAppInterface paramPeakAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("tencent.peak.q2v.AudioTransPush".equals(paramIntent.getAction())))
    {
      int i = paramIntent.getIntExtra("rsptype", 0);
      paramContext = paramIntent.getByteArrayExtra("rspbody");
      QLog.d("PeakAppInterface", 2, "ACTION_AUDIO_TRANS_PUSH rsptype=" + i + "|" + paramContext.length);
      ((amby)this.this$0.getBusinessHandler(0)).d(i, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acil
 * JD-Core Version:    0.7.0.1
 */