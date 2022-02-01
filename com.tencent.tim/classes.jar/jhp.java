import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class jhp
  extends iiz
{
  protected void V(String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = this.a.mApp.b().b().amI;
      } while ((i != 2) && (i != 1));
      if (paramBoolean)
      {
        if (paramString.a != null) {
          paramString.a.kC("onPeerSwitchTerminal");
        }
        paramString.kz("onPeerSwitchTerminal");
        return;
      }
      paramString.ky("onPeerSwitchTerminal");
    } while (paramString.a == null);
    paramString.kQ(paramString.a.Zv);
  }
  
  protected void amT()
  {
    jht localjht = this.a.a();
    if (localjht != null) {
      localjht.kz("onPauseVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.kS(paramBoolean);
    }
    jij.awL();
  }
  
  protected void bQ(long paramLong)
  {
    int i = this.a.mApp.b().b().amI;
    if ((i == 2) || (i == 1))
    {
      jij.ec(this.a.mApp.b().bv());
      jij.awK();
      nz(3);
      return;
    }
    jij.ec(0L);
  }
  
  protected void bR(long paramLong)
  {
    jht localjht = this.a.a();
    if (localjht != null) {
      localjht.kz("onResumeVideo");
    }
  }
  
  public void nz(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    jht localjht = this.a.a();
    if (localjht != null)
    {
      localjht.ky("onConnected:" + paramInt);
      if (localjht.a != null) {
        localjht.kQ(localjht.a.Zv);
      }
    }
    this.a.mApp.getHandler().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhp
 * JD-Core Version:    0.7.0.1
 */