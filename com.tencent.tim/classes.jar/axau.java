import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class axau
  implements LogicDataManager.OnGetQQNumberEventListener
{
  axau(axat paramaxat) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - axat.a(this.b) > 60000L)
    {
      axat.a(this.b, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - axat.b(this.b) <= 1000L) {
        break label168;
      }
      axat.b(this.b, l);
    }
    for (;;)
    {
      synchronized (axat.a(this.b))
      {
        if (axat.a(this.b) != 0) {
          axat.a(this.b, axat.a(this.b) - 1000 + new Random().nextInt(2000));
        }
        return axat.a(this.b);
        if (l - axat.a(this.b) >= 0L) {
          break;
        }
        axat.a(this.b, l);
      }
      label168:
      if (l - axat.b(this.b) < 0L) {
        axat.b(this.b, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axau
 * JD-Core Version:    0.7.0.1
 */