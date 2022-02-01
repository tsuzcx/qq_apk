import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ahlp
  extends BroadcastReceiver
{
  ahlp(ahlj paramahlj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((ahlj.a(this.this$0) == null) || (ahlj.a(this.this$0).isFinishing())) {}
    do
    {
      return;
      paramContext = ahic.ln(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      ahlj.a(this.this$0, ahlj.a(this.this$0).getIntent().getExtras());
      return;
    }
    ahlj.a(this.this$0, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlp
 * JD-Core Version:    0.7.0.1
 */