import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class taf
{
  private static int bAt = 1000000000;
  public long DN;
  public long DO;
  public String address;
  public int bAs;
  public int bAu;
  public int bAv;
  public int bAw;
  public byte[] bT;
  public boolean connected;
  public SosoInterface.SosoLbsInfo d;
  public String name;
  public List<String> pN;
  public int pid;
  public boolean reported;
  public int seq;
  public byte[] sig;
  
  public taf()
  {
    bAt += 1;
    this.bAs = bAt;
  }
  
  public static void a(byte[] paramArrayOfByte, taf paramtaf)
  {
    try
    {
      paramtaf.pN = new ArrayList();
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      int j;
      int i;
      if (paramArrayOfByte.remaining() > 2)
      {
        j = paramArrayOfByte.get();
        if (j == 0) {
          return;
        }
        i = j;
        switch (paramArrayOfByte.get())
        {
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
          break;
          while (i >= 2)
          {
            paramtaf.pN.add(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) }));
            i = (byte)(i - 2);
          }
          if (j > 10)
          {
            if (j > 11) {
              paramArrayOfByte.get(new byte[j - 1 - 10]);
            }
            paramtaf.pid = paramArrayOfByte.getInt();
            paramtaf.bT = new byte[6];
            paramArrayOfByte.get(paramtaf.bT);
            break;
          }
          paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
          break;
          if (j <= 2) {
            break label254;
          }
          try
          {
            if (paramArrayOfByte.getShort() != 513) {
              break;
            }
            paramtaf.bAw = paramArrayOfByte.getShort();
            paramtaf.bAv = paramArrayOfByte.getShort();
          }
          catch (Exception localException) {}
        }
        break;
        label254:
        paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
        break;
        return;
      }
      return;
    }
    catch (Throwable paramArrayOfByte) {}
  }
  
  public String nY()
  {
    return this.address.replaceAll(":", "") + "0000";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     taf
 * JD-Core Version:    0.7.0.1
 */