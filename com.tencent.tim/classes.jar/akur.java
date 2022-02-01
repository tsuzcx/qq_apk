import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;

public class akur
{
  private Cryptor a;
  public long aeu;
  public long aev;
  public String appid;
  public String bUl;
  private byte[] dC;
  private int dpk;
  private int dpl;
  public int dpm;
  private int dpn;
  private int dpo;
  private byte[] fc;
  public String packageName;
  
  public akur(akuq.a parama)
  {
    this.appid = parama.appid;
    this.packageName = parama.pkgName;
    this.dpm = parama.dpj;
    this.dpk = parama.dpk;
    this.dpl = parama.dpl;
    if (parama.cuE)
    {
      this.aeu = parama.aet;
      this.dC = g(parama.aes);
      this.aev = parama.aer;
      this.fc = g(parama.aeq);
      return;
    }
    this.aeu = parama.aer;
    this.dC = g(parama.aeq);
  }
  
  private byte[] g(long paramLong)
  {
    for (Object localObject = this.appid; ((String)localObject).length() < 16; localObject = (String)localObject + (String)localObject) {}
    byte[] arrayOfByte1 = ((String)localObject).getBytes();
    byte[] arrayOfByte2 = String.valueOf(paramLong).getBytes();
    if (arrayOfByte1.length > arrayOfByte2.length) {}
    for (localObject = arrayOfByte1;; localObject = arrayOfByte2)
    {
      int i = 0;
      while (i < Math.min(arrayOfByte1.length, arrayOfByte2.length))
      {
        localObject[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[i]));
        i += 1;
      }
    }
    if (this.a == null)
    {
      this.a = new Cryptor();
      this.a.enableResultRandom(false);
    }
    return localObject;
  }
  
  public int Hf()
  {
    return this.dpn;
  }
  
  public int Hg()
  {
    return this.dpo;
  }
  
  public boolean bc(int paramInt1, int paramInt2)
  {
    return ((this.dpl & paramInt1) > 0) && ((this.dpk & paramInt2) > 0);
  }
  
  public boolean bd(int paramInt1, int paramInt2)
  {
    return ((this.dpo & paramInt1) > 0) && ((this.dpn & paramInt2) > 0);
  }
  
  public String decrypt(String paramString)
  {
    try
    {
      paramString = aqhs.hexStr2Bytes(paramString);
      paramString = new String(this.a.decrypt(paramString, this.dC));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decrypt", paramString);
      }
    }
    return null;
  }
  
  public String encrypt(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = aqhs.bytes2HexStr(this.a.encrypt(paramString.getBytes(), this.dC));
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("OpenApi.App", 2, "encrypt", localException);
    }
    return null;
  }
  
  public void iY(int paramInt1, int paramInt2)
  {
    this.dpn = (this.dpk & paramInt1);
    this.dpo = (this.dpl & paramInt2);
  }
  
  public boolean kL(int paramInt)
  {
    return (this.dpm & paramInt) > 0;
  }
  
  public boolean kM(int paramInt)
  {
    return ((this.dpo & paramInt) > 0) && ((this.dpn & 0x40000000) > 0);
  }
  
  public boolean kN(int paramInt)
  {
    return (this.dpl & paramInt) > 0;
  }
  
  public String mF(String paramString)
  {
    try
    {
      paramString = aqhs.hexStr2Bytes(paramString);
      paramString = new String(this.a.decrypt(paramString, this.fc));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decryptLastData", paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akur
 * JD-Core Version:    0.7.0.1
 */