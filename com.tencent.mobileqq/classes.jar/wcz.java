import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBarData;

public class wcz
  implements Runnable
{
  public wcz(LightalkBlueTipsBar paramLightalkBlueTipsBar) {}
  
  public void run()
  {
    LightalkBlueTipsBarData localLightalkBlueTipsBarData = LightalkBlueTipsBarData.a();
    if (localLightalkBlueTipsBarData != null)
    {
      this.a.a = localLightalkBlueTipsBarData.d;
      this.a.b = localLightalkBlueTipsBarData.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcz
 * JD-Core Version:    0.7.0.1
 */