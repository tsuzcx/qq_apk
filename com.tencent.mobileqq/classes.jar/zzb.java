import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;

public class zzb
  extends SimpleSensorChangeListener
{
  public zzb(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    ARWorldCupGlobalSceneRenderable.a(this.a).a(new zzc(this, paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzb
 * JD-Core Version:    0.7.0.1
 */