package wf7;

import android.content.Intent;
import android.text.TextUtils;

class fs$3
  implements as.a
{
  fs$3(fs paramfs) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 1013: 
        this.rx.d(false, false);
        return;
      }
      str = paramIntent.getAction();
    } while ((TextUtils.isEmpty(str)) || (!"android.net.wifi.WIFI_STATE_CHANGED".equals(str)) || (paramIntent.getIntExtra("wifi_state", -1) != 3));
    this.rx.d(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fs.3
 * JD-Core Version:    0.7.0.1
 */