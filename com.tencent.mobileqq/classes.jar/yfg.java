import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class yfg
  implements apym
{
  public yfg(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    yfh localyfh;
    if (paramInt1 == 3)
    {
      localyfh = (yfh)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localyfh != null) {
        this.a.callJs(localyfh.g + "(" + localyfh.a() + ");");
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
            localyfh = (yfh)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localyfh == null);
          this.a.callJs(localyfh.f + "(" + localyfh.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localyfh = (yfh)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localyfh == null);
        this.a.callJs(localyfh.h + "(" + localyfh.a() + ");");
        return;
      } while (paramInt1 != 0);
      localyfh = (yfh)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localyfh == null);
    this.a.callJs(localyfh.i + "(" + localyfh.a() + ");");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    yfh localyfh = (yfh)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localyfh != null)
    {
      localyfh.c = paramBoolean;
      this.a.callJs(localyfh.d + "(" + localyfh.a() + ");");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    yfh localyfh = (yfh)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localyfh != null)
    {
      localyfh.a = paramBoolean;
      this.a.callJs(localyfh.e + "(" + localyfh.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfg
 * JD-Core Version:    0.7.0.1
 */