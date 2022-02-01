package wf7;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;

class cq$2
  implements as.a
{
  cq$2(cq paramcq) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(str))
    {
      paramInt = paramIntent.getIntExtra("wifi_state", -1);
      bz.av().ax().post(new cq.2.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cq.2
 * JD-Core Version:    0.7.0.1
 */