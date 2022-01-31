import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class yok
  implements aqso
{
  public yok(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    yol localyol;
    if (paramInt1 == 3)
    {
      localyol = (yol)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localyol != null) {
        this.a.callJs(localyol.g + "(" + localyol.a() + ");");
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
            localyol = (yol)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localyol == null);
          this.a.callJs(localyol.f + "(" + localyol.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localyol = (yol)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localyol == null);
        this.a.callJs(localyol.h + "(" + localyol.a() + ");");
        return;
      } while (paramInt1 != 0);
      localyol = (yol)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localyol == null);
    this.a.callJs(localyol.i + "(" + localyol.a() + ");");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    yol localyol = (yol)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localyol != null)
    {
      localyol.c = paramBoolean;
      this.a.callJs(localyol.d + "(" + localyol.a() + ");");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    yol localyol = (yol)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localyol != null)
    {
      localyol.a = paramBoolean;
      this.a.callJs(localyol.e + "(" + localyol.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yok
 * JD-Core Version:    0.7.0.1
 */