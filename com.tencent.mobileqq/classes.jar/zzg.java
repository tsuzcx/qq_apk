import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.arcard.ARcardSound;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.qphone.base.util.QLog;

public class zzg
  implements Runnable
{
  public zzg(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    if (ARWorldCupGlobalSceneRenderable.a(this.a) == 6)
    {
      if (ARWorldCupGlobalSceneRenderable.a(this.a) != null) {
        ARWorldCupGlobalSceneRenderable.a(this.a).a(0, 1);
      }
      if (ARWorldCupGlobalSceneRenderable.a(this.a) == null) {
        ARWorldCupGlobalSceneRenderable.a(this.a, new ARcardSound());
      }
      if (ARWorldCupGlobalSceneRenderable.a(this.a) != null) {
        QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("setNativeState start sensor result=%s", new Object[] { Boolean.valueOf(ARWorldCupGlobalSceneRenderable.a(this.a).a(ARWorldCupGlobalSceneRenderable.a(this.a))) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzg
 * JD-Core Version:    0.7.0.1
 */