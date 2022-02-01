import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tim.filemanager.settings.FMSettings.5;
import com.tencent.tim.filemanager.settings.FMSettings.5.1.1.1;
import com.tencent.tim.filemanager.settings.FMSettings.5.1.1.2;
import com.tencent.tim.filemanager.settings.FMSettings.5.1.1.3;

public class audq
  implements audm.a
{
  audq(audp paramaudp) {}
  
  public void NW(int paramInt)
  {
    this.a.a.val$activity.runOnUiThread(new FMSettings.5.1.1.2(this));
    audn.a(this.a.a.this$0);
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.this$0.pq = false;
      return;
    }
  }
  
  public void at(long paramLong1, long paramLong2)
  {
    this.a.a.val$activity.runOnUiThread(new FMSettings.5.1.1.1(this, paramLong1, paramLong2));
  }
  
  public void dhx()
  {
    this.a.a.val$activity.runOnUiThread(new FMSettings.5.1.1.3(this));
    audn.a(this.a.a.this$0);
    audw.JH("0X8005BE2");
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.this$0.pq = false;
      return;
    }
  }
  
  public void fG(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audq
 * JD-Core Version:    0.7.0.1
 */