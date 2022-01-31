import com.tencent.biz.videostory.capture.watermark.WaterMarkOnlineUserManager.1.1;
import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import java.util.Random;

public class wvl
  implements LogicDataManager.OnGetQQNumberEventListener
{
  wvl(wvk paramwvk) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - wvk.a(this.a) > 60000L)
    {
      wvk.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - wvk.b(this.a) <= 1000L) {
        break label168;
      }
      wvk.b(this.a, l);
    }
    for (;;)
    {
      synchronized (wvk.a(this.a))
      {
        if (wvk.a(this.a) != 0) {
          wvk.a(this.a, wvk.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return wvk.a(this.a);
        if (l - wvk.a(this.a) >= 0L) {
          break;
        }
        wvk.a(this.a, l);
      }
      label168:
      if (l - wvk.b(this.a) < 0L) {
        wvk.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */