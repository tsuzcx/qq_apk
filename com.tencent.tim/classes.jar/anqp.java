import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class anqp
{
  private List<anqn> GJ = new ArrayList();
  boolean Lh = false;
  private short as = 1;
  private int dLV;
  public final int dLW;
  private int iMsgId;
  private long lKey;
  public long msgSeq;
  private String path;
  public long random;
  private short shFlowLayer;
  private short shPackNum;
  
  public anqp(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    this.path = paramString;
    this.dLV = paramInt2;
    this.dLW = alil.a(paramQQAppInterface, paramInt1, aomi.a().getNetType());
    alid.nY(paramString);
  }
  
  public int Km()
  {
    return this.dLV;
  }
  
  public int Kn()
  {
    return this.iMsgId;
  }
  
  public void Qs(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      alid.nZ(this.path);
      return;
    }
    alid.Of(this.path);
  }
  
  public void Vq(int paramInt)
  {
    this.iMsgId = paramInt;
  }
  
  public void dTt()
  {
    this.shFlowLayer = 0;
  }
  
  public File getFile()
  {
    return new File(this.path);
  }
  
  public List<anqn> go()
  {
    return this.GJ;
  }
  
  public short h()
  {
    return this.shPackNum;
  }
  
  public void h(short paramShort)
  {
    this.shPackNum = paramShort;
  }
  
  public short i()
  {
    return this.as;
  }
  
  public void i(short paramShort)
  {
    this.as = paramShort;
  }
  
  public short j()
  {
    return this.shFlowLayer;
  }
  
  public void j(short paramShort)
  {
    this.shFlowLayer = paramShort;
  }
  
  public void lA(long paramLong)
  {
    this.lKey = paramLong;
  }
  
  public void r(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    alid.a(this.path, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqp
 * JD-Core Version:    0.7.0.1
 */