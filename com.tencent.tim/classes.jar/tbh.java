import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.b;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.a;
import java.util.Map;

public class tbh
  implements GameCenterVideoViewController.a
{
  public tbh(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void al(boolean paramBoolean, int paramInt)
  {
    GameCenterAPIJavaScript.b localb = (GameCenterAPIJavaScript.b)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.isFullScreen = paramBoolean;
      this.a.callJs(localb.aIH + "(" + localb.oc() + ");");
    }
  }
  
  public void am(boolean paramBoolean, int paramInt)
  {
    GameCenterAPIJavaScript.b localb = (GameCenterAPIJavaScript.b)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.aOC = paramBoolean;
      this.a.callJs(localb.aII + "(" + localb.oc() + ");");
    }
  }
  
  public void eM(int paramInt1, int paramInt2)
  {
    GameCenterAPIJavaScript.b localb;
    if (paramInt1 == 3)
    {
      localb = (GameCenterAPIJavaScript.b)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localb != null) {
        this.a.callJs(localb.aIK + "(" + localb.oc() + ");");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 != 5) {
              break;
            }
            localb = (GameCenterAPIJavaScript.b)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localb == null);
          this.a.callJs(localb.aIJ + "(" + localb.oc() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localb = (GameCenterAPIJavaScript.b)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localb == null);
        this.a.callJs(localb.aIL + "(" + localb.oc() + ");");
        return;
      } while (paramInt1 != 0);
      localb = (GameCenterAPIJavaScript.b)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localb == null);
    this.a.callJs(localb.aIM + "(" + localb.oc() + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbh
 * JD-Core Version:    0.7.0.1
 */