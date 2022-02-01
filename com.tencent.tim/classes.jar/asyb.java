import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class asyb
  implements asyq, IRuntimeInterface
{
  private static volatile asyb a;
  
  private asyb()
  {
    QSecFramework.a(4L, new asyc(this));
  }
  
  public static asyb a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new asyb();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, asyq.a parama)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parama != null)
      {
        jnm.a(localQQAppInterface, new asyb.a(paramArrayOfByte, parama), paramArrayOfByte, paramString);
        return;
      }
      jnm.a(localQQAppInterface, new asyd(this), paramArrayOfByte, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getInterfaceName()
  {
    return "CSP";
  }
  
  static class a
    extends jnm.d
  {
    protected byte[] X;
    protected asyq.a a;
    
    public a(byte[] paramArrayOfByte, asyq.a parama)
    {
      this.X = paramArrayOfByte;
      this.a = parama;
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (this.a != null) {
        this.a.a(paramInt, this.X, paramArrayOfByte);
      }
    }
  }
  
  class b
    implements asyq.a
  {
    protected long ark;
    
    public b(long paramLong)
    {
      this.ark = paramLong;
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      if (this.ark != 0L) {
        QSecFramework.b(7L, this.ark, paramInt, 0L, paramArrayOfByte1, paramArrayOfByte2, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyb
 * JD-Core Version:    0.7.0.1
 */