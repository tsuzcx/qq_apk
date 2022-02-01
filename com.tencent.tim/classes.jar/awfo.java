import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class awfo
  extends BroadcastReceiver
{
  awfo(awfn paramawfn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneDynamicAlbumPlugin", 2, paramContext);
    }
    paramIntent = paramIntent.getStringExtra("runningProcessName");
    if ((("com.tencent.process.stopping".equals(paramContext)) && (!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq:tool"))) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      awfn.a(this.this$0, true);
      this.this$0.eDs();
    }
    while (((!"com.tencent.process.starting".equals(paramContext)) || (TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("com.tencent.mobileqq:tool")) || (!awfn.a(this.this$0))) && (!"tencent.av.v2q.StopVideoChat".equals(paramContext))) {
      return;
    }
    awfn.a(this.this$0, false);
    this.this$0.eDt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfo
 * JD-Core Version:    0.7.0.1
 */