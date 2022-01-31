import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardResourceInfo;
import com.tencent.mobileqq.arcard.ARcardSound;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.qphone.base.util.QLog;

public class zwi
  implements Runnable
{
  public zwi(GreetingCardRender paramGreetingCardRender) {}
  
  public void run()
  {
    if (GreetingCardRender.d(this.a) == 6)
    {
      if (GreetingCardRender.a(this.a) != null) {
        GreetingCardRender.a(this.a).a(0, 1);
      }
      if (GreetingCardRender.a(this.a) == null) {
        GreetingCardRender.a(this.a, new ARcardSound());
      }
      if (GreetingCardRender.a(this.a) != null) {
        GreetingCardRender.a(this.a).a(GreetingCardRender.a(this.a).c + "bgmusic.mp3");
      }
      if ((GreetingCardRender.a(this.a) != null) && (GreetingCardRender.a(this.a).b == 1)) {
        QLog.d("GreetingCardRender", 2, String.format("setNativeState start sensor result=%s", new Object[] { Boolean.valueOf(GreetingCardRender.a(this.a).a(GreetingCardRender.a(this.a))) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zwi
 * JD-Core Version:    0.7.0.1
 */