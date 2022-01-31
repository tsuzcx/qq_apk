import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo;
import com.tencent.mobileqq.arcard.ARcardSound;

public class zzf
  implements Runnable
{
  public zzf(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    if ((ARWorldCupGlobalSceneRenderable.a(this.a) != null) && (ARWorldCupGlobalSceneRenderable.a(this.a) == 6)) {
      ARWorldCupGlobalSceneRenderable.a(this.a).a(ARWorldCupGlobalSceneRenderable.a(this.a).a() + "/res/worldcup/doorOpen.mp3", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzf
 * JD-Core Version:    0.7.0.1
 */