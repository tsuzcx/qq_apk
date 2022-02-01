import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;

public class jlp
{
  String SW = null;
  WifiManager.WifiLock a = null;
  int aBn = 0;
  Context context = null;
  
  public jlp(Context paramContext, int paramInt, String paramString)
  {
    this.context = paramContext;
    this.aBn = paramInt;
    this.SW = paramString;
  }
  
  public boolean isLocked()
  {
    return (this.a != null) && (this.a.isHeld());
  }
  
  public void unlock()
  {
    if (isLocked())
    {
      this.a.release();
      this.a = null;
    }
  }
  
  public boolean xS()
  {
    if (this.a == null) {
      this.a = ((WifiManager)this.context.getSystemService("wifi")).createWifiLock(this.aBn, this.SW);
    }
    if (this.a != null)
    {
      if (!this.a.isHeld()) {
        this.a.acquire();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlp
 * JD-Core Version:    0.7.0.1
 */