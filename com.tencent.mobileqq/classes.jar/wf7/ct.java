package wf7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ct
  extends bn.a<bl>
{
  private static String TAG = "ExtraWifiCloudInfo";
  private final Object ii = new Object();
  private ArrayList<byte[]> ij = null;
  public long ik = 0L;
  private String il = "";
  private int im = 0;
  
  public ct(bn parambn)
  {
    super(parambn);
    this.gb = new bl();
  }
  
  private String be()
  {
    synchronized (this.ii)
    {
      if (this.ij == null) {
        return "";
      }
      String str = this.ij.toString();
      return str;
    }
  }
  
  protected int L()
  {
    if (((bl)getData()).R() != null) {
      return ((bl)getData()).R().v;
    }
    return 0;
  }
  
  public d R()
  {
    return ((bl)getData()).R();
  }
  
  public void U(int paramInt)
  {
    this.im = paramInt;
  }
  
  public void a(c paramc)
  {
    ((bl)getData()).a(paramc);
  }
  
  public void a(d paramd)
  {
    ((bl)getData()).a(paramd);
    if (paramd != null)
    {
      ((bl)getData()).v(paramd.v);
      ((bl)getData()).w(paramd.S);
      ((bl)getData()).d(paramd.B);
    }
  }
  
  public boolean a(h paramh)
  {
    if (paramh != null) {
      return cb.a(af().Z(), paramh.ssid, af().ab(), cb.E(paramh.C));
    }
    return false;
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    synchronized (this.ii)
    {
      if ((this.ij != null) && (this.ij.size() > 0))
      {
        Iterator localIterator = this.ij.iterator();
        while (localIterator.hasNext()) {
          if (Arrays.equals((byte[])localIterator.next(), paramArrayOfByte)) {
            return true;
          }
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public boolean bc()
  {
    return (((bl)getData()).R() != null) && (((bl)getData()).R().isBestWiFi);
  }
  
  public boolean bd()
  {
    d locald = ((bl)getData()).R();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locald != null)
    {
      bool1 = bool2;
      if (((bl)getData()).R().v != 0)
      {
        if ((((bl)getData()).x(11)) || (((bl)getData()).x(12))) {
          ((bl)getData()).R().B = "";
        }
        ((bl)getData()).R().v = 0;
        ((bl)getData()).R().y = "";
        ((bl)getData()).R().A = null;
        ((bl)getData()).R().w = null;
        ((bl)getData()).R().E = "";
        ((bl)getData()).R().isBestWiFi = false;
        ((bl)getData()).R().X = "";
        this.il = "";
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean c(long paramLong)
  {
    return (this.ik > 0L) && (System.currentTimeMillis() - this.ik >= paramLong);
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (!b(paramArrayOfByte)) {
      synchronized (this.ii)
      {
        if (this.ij == null) {
          this.ij = new ArrayList();
        }
        this.ij.add(paramArrayOfByte);
        return;
      }
    }
  }
  
  public void o(String paramString)
  {
    this.il = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtraWifiCloudInfo{, ap='");
    localStringBuilder.append(af().toString());
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBssidList=");
    localStringBuilder.append(be());
    localStringBuilder.append(", mCacheTime=");
    localStringBuilder.append(this.ik);
    localStringBuilder.append(", mWifiUid='");
    localStringBuilder.append(this.il);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCloudInfoState=");
    localStringBuilder.append(this.im);
    localStringBuilder.append(", data='");
    localStringBuilder.append(((bl)getData()).toString());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ct
 * JD-Core Version:    0.7.0.1
 */