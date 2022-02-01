package wf7;

import android.content.Intent;
import android.text.TextUtils;

class fs$3
  implements as.a
{
  fs$3(fs paramfs) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramInt != 1013)
    {
      if (paramInt != 1034) {
        return;
      }
      String str = paramIntent.getAction();
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if (("android.net.wifi.WIFI_STATE_CHANGED".equals(str)) && (paramIntent.getIntExtra("wifi_state", -1) == 3)) {
        this.rx.d(true, false);
      }
    }
    else
    {
      this.rx.d(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fs.3
 * JD-Core Version:    0.7.0.1
 */