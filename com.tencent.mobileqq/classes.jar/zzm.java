import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo;
import com.tencent.mobileqq.arcard.ARcardSound;

class zzm
  implements Runnable
{
  zzm(zzl paramzzl) {}
  
  public void run()
  {
    if (ARWorldCupGlobalSceneRenderable.a(this.a.a) != null) {
      ARWorldCupGlobalSceneRenderable.a(this.a.a).a(ARWorldCupGlobalSceneRenderable.a(this.a.a).a() + "/res/worldcup/football.mp3", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzm
 * JD-Core Version:    0.7.0.1
 */