import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class jhq
  extends iya
{
  public void a(iya.d paramd)
  {
    jht localjht = this.a.a();
    if (localjht == null) {}
    while ((!localjht.wI()) || (localjht.xs())) {
      return;
    }
    jij.awG();
    iwu.b(this.a.mApp, 1045, 2131698029);
    paramd.Wa = true;
    paramd.Rj = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      jia localjia = paramString.jdField_a_of_type_Jia;
      if (localjia != null) {
        localjia.D(-4, 10000L);
      }
      paramString.kS(paramBoolean.booleanValue());
    }
  }
  
  public void bg(String paramString1, String paramString2)
  {
    jht localjht = this.a.a();
    if (localjht == null) {}
    do
    {
      do
      {
        return;
      } while ((!localjht.wI()) || (localjht.jdField_a_of_type_Jhz == null) || (localjht.jdField_a_of_type_Jhz.b == null));
      QLog.w(this.a.TAG, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localjht.jdField_a_of_type_Jhz.b.Zx);
    ((AVRedPacketManager)this.a.mApp.a(6)).bb(paramString1, paramString2);
  }
  
  protected void c(String paramString, Boolean paramBoolean)
  {
    jht localjht = this.a.a();
    if (localjht != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.TAG, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localjht.wI() + "], isGameStarter[" + localjht.xs() + "]");
      }
      if (localjht.wI()) {
        ((AVRedPacketManager)this.a.mApp.a(6)).iN(false);
      }
      localjht.aww();
      if ((!paramBoolean.booleanValue()) && (localjht.wI()) && (!localjht.xs())) {
        jij.awI();
      }
    }
  }
  
  protected void jV(String paramString)
  {
    paramString = this.a.a();
    if ((paramString != null) && (paramString.wI())) {
      ((AVRedPacketManager)this.a.mApp.a(6)).iN(true);
    }
  }
  
  protected void jW(String paramString)
  {
    if (this.a.mApp == null) {
      return;
    }
    this.a.mApp.getHandler().post(new AVRedBag.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhq
 * JD-Core Version:    0.7.0.1
 */