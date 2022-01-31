import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class zzs
  implements Runnable
{
  public zzs(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    ARWorldCupGlobalSceneRenderable.a(this.a, new zzt(this));
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "post mRepeatCheckRunnable ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzs
 * JD-Core Version:    0.7.0.1
 */