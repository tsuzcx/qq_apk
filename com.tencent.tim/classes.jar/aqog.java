import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqog
{
  public static String cuy = "param_reason";
  public long apv;
  public long aqa;
  public long atu;
  public long atv;
  public long atw;
  private final aqoi b;
  public int busiType = -1;
  public boolean cMH;
  public boolean cMK;
  public boolean cML;
  public boolean cMM;
  public boolean cMV = true;
  public boolean cMY;
  public final boolean cUY;
  private boolean cUZ;
  private boolean cVa = true;
  public boolean cVb;
  public boolean cVc;
  public boolean cVd;
  public long cost;
  private String cut;
  private String cuu;
  public String cuv;
  public String cuw;
  public String cux;
  public aona.d.a d;
  public int eaI;
  public AtomicBoolean ek = new AtomicBoolean(false);
  public AtomicBoolean el = new AtomicBoolean(false);
  public AtomicBoolean em;
  public int errCode;
  public String errString;
  public HttpURLConnection f;
  public int fileType = -1;
  public int flow;
  public Object fv;
  private byte[] gG;
  public String[] hX;
  public boolean mIsHttps;
  public String msgId;
  public int netType;
  public HashMap<String, String> oY = new HashMap();
  public HashMap<String, String> oZ = new HashMap();
  public int rL = 201;
  private String requestMethod = "GET";
  public int responseCode = -1;
  private byte[] sendData;
  private int serial;
  public long startTime;
  public long totalLen;
  
  public aqog(String paramString, byte[] paramArrayOfByte, aqoi paramaqoi)
  {
    this(paramString, paramArrayOfByte, paramaqoi, false);
  }
  
  public aqog(String paramString, byte[] paramArrayOfByte, aqoi paramaqoi, boolean paramBoolean)
  {
    this.cut = paramString;
    if (paramString != null)
    {
      this.cuu = paramString.substring(0, paramString.length());
      this.b = paramaqoi;
      if (paramArrayOfByte != null) {
        break label139;
      }
      this.sendData = null;
    }
    for (;;)
    {
      this.cUY = paramBoolean;
      return;
      this.cuu = null;
      break;
      label139:
      this.sendData = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.sendData, 0, this.sendData.length);
    }
  }
  
  public String Co()
  {
    String str2 = getUrl();
    String str1 = str2;
    if (!this.cMV) {
      str1 = aonc.ow(str2);
    }
    return str1;
  }
  
  public int Mk()
  {
    return this.serial;
  }
  
  public void P(int paramInt1, int paramInt2, String paramString)
  {
    this.errCode = paramInt1;
    this.responseCode = paramInt2;
    this.errString = paramString;
    if ((this.b instanceof aojn)) {
      ((aojn)this.b).b(paramInt1, paramInt2, 0L, paramString);
    }
  }
  
  public void SP(boolean paramBoolean)
  {
    this.cUZ = paramBoolean;
  }
  
  public void XH(int paramInt)
  {
    this.serial = paramInt;
  }
  
  public aqoi a()
  {
    return this.b;
  }
  
  public byte[] aB()
  {
    return this.gG;
  }
  
  public byte[] aC()
  {
    return this.sendData;
  }
  
  public boolean aFn()
  {
    return this.cUZ;
  }
  
  public boolean aFo()
  {
    return this.cVa;
  }
  
  public boolean aFp()
  {
    if ((this.errCode == -9527) && (this.responseCode == 404))
    {
      String str = (String)this.oZ.get(cuy);
      if (("H_404_-6101".equals(str)) || ("H_404_-5062".equals(str))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean aFq()
  {
    if ((this.oZ.containsKey("X-RtFlag")) && ("0".equals(this.oZ.get("X-RtFlag"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpMsg", 2, "permitRetry : X-RtFlag = 0");
      }
      return false;
    }
    if ((this.errCode == -9527) && (this.responseCode == 404))
    {
      String str = (String)this.oZ.get(cuy);
      return (!"H_404_-6101".equals(str)) && (!"H_404_-5062".equals(str));
    }
    return (this.errCode != 9048) && (this.errCode != 9057) && (this.errCode != 9020) && (this.errCode != 9022) && (this.errCode != 9366) && (this.errCode != 9058);
  }
  
  public HashMap<String, String> ac()
  {
    return this.oY;
  }
  
  public void bD(byte[] paramArrayOfByte)
  {
    this.gG = paramArrayOfByte;
  }
  
  public void eeG()
  {
    this.ek.set(false);
    this.el.set(false);
    if (this.em != null) {
      this.em.set(false);
    }
    this.f = null;
  }
  
  public String getErrorString()
  {
    return this.errString;
  }
  
  public int getPriority()
  {
    return this.rL;
  }
  
  public String getRealUrl()
  {
    return this.cuu;
  }
  
  public String getRequestMethod()
  {
    return this.requestMethod;
  }
  
  public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getUrl()
  {
    return this.cut;
  }
  
  public long hR()
  {
    return this.totalLen;
  }
  
  public void ip(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.oZ.put(paramString1, paramString2);
  }
  
  public String pK(String paramString)
  {
    return (String)this.oZ.get(paramString);
  }
  
  public void refresh()
  {
    eeG();
    this.errCode = 0;
    this.responseCode = 0;
    this.errString = null;
    this.gG = null;
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.cVa = paramBoolean;
  }
  
  public void setPriority(int paramInt)
  {
    if (paramInt == 5)
    {
      this.rL = 201;
      return;
    }
    if (paramInt == 1)
    {
      this.rL = 202;
      return;
    }
    if (paramInt == 10)
    {
      this.rL = 200;
      return;
    }
    this.rL = paramInt;
  }
  
  public void setRequestMethod(String paramString)
  {
    this.requestMethod = paramString;
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.oY.put(paramString1, paramString2);
  }
  
  public void setResponseCode(int paramInt)
  {
    this.responseCode = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.cut = paramString;
    this.cuu = this.cut.substring(0, this.cut.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqog
 * JD-Core Version:    0.7.0.1
 */