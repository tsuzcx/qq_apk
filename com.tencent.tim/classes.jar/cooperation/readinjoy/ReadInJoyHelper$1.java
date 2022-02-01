package cooperation.readinjoy;

import awiu;
import com.tencent.ark.open.ArkAppMgr;

public final class ReadInJoyHelper$1
  implements Runnable
{
  public ReadInJoyHelper$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().getAppPathByName(this.val$appName, "", this.FV, new Object(), new awiu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.1
 * JD-Core Version:    0.7.0.1
 */