import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class jdq
  extends jdl
{
  protected jdq(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(izm paramizm1, izm paramizm2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = jdm.cC(paramInt);
    paramizm1.setPaddings(0, 0, 0, 0);
    paramizm1.layout(i, 0, paramInt, j);
    paramizm1.setBackgroundColor(-15197410);
    paramizm2.setPaddings(0, 0, 0, 0);
    paramizm2.layout(0, 0, i, j);
    paramizm2.setBackgroundColor(-15197410);
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.mApp.getCurrentAccountUin().equals(paramArrayOfizm[1].getTag(0)))
    {
      bool = true;
      igd.aJ("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
      if (!bool) {
        break label112;
      }
      if (paramBoolean) {
        break label94;
      }
      paramBoolean = true;
    }
    label94:
    label112:
    for (;;)
    {
      if (paramBoolean)
      {
        a(paramArrayOfizm[0], paramArrayOfizm[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfizm[1], paramArrayOfizm[0], paramInt1);
      return;
    }
  }
  
  public int getStyle()
  {
    return 2;
  }
  
  public boolean wD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdq
 * JD-Core Version:    0.7.0.1
 */