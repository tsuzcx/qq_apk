import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.worldcup.ARWorldCupGameTouchView;

public class zzq
  implements Runnable
{
  public zzq(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    ARWorldCupGlobalSceneRenderable.a(this.a).c();
    ARWorldCupGlobalSceneRenderable.a(this.a).setClickable(false);
    ARWorldCupGlobalSceneRenderable.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzq
 * JD-Core Version:    0.7.0.1
 */