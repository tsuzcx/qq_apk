package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Message;
import android.util.Base64;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends w
  implements aj.a, Runnable
{
  private volatile boolean c = false;
  private List<String> d = new ArrayList();
  private p e = new p((byte)0);
  private volatile r f;
  private File g;
  private String h = "wf4_bf";
  private String i = "wf4";
  private StringBuilder j = new StringBuilder(100);
  
  public f(File paramFile)
  {
    this.g = paramFile;
    if (ai.a()) {
      ai.a(3, "WifiInfoPro", "data dir:" + this.g.getAbsolutePath(), null);
    }
  }
  
  private String a(ScanResult paramScanResult)
  {
    this.j.setLength(0);
    try
    {
      this.j.append(paramScanResult.BSSID).append(',');
      this.j.append(Base64.encodeToString(paramScanResult.SSID.getBytes("UTF-8"), 2)).append(',');
      this.j.append(paramScanResult.frequency).append(',');
      this.j.append(Base64.encodeToString(paramScanResult.capabilities.getBytes("UTF-8"), 2));
      return this.j.toString();
    }
    catch (Throwable paramScanResult)
    {
      for (;;)
      {
        this.j.setLength(0);
      }
    }
  }
  
  private void a(List<String> paramList)
    throws IOException
  {
    int k = 0;
    if ((!this.c) && (!ai.a(paramList)))
    {
      if (this.f == null) {
        k = 1;
      }
      if (k == 0) {}
    }
    else
    {
      return;
    }
    long l = this.f.b().length();
    if (ai.a()) {
      ai.a(3, "WifiInfoPro", "wf file len:".concat(String.valueOf(l)), null);
    }
    Object localObject2;
    String str;
    if (l <= 51200L)
    {
      ??? = new StringBuilder(500);
      ((StringBuilder)???).append("1|").append(paramList.size());
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        ((StringBuilder)???).append('|').append(str);
      }
      localObject2 = this.f;
      str = ((StringBuilder)???).toString();
    }
    synchronized (((r)localObject2).a)
    {
      if (((r)localObject2).b != null)
      {
        ((r)localObject2).b.append(str);
        if (((r)localObject2).b.length() >= ((r)localObject2).c)
        {
          ((r)localObject2).a(((r)localObject2).b.toString().getBytes("UTF-8"));
          ((r)localObject2).b.setLength(0);
        }
      }
      paramList.clear();
      return;
    }
  }
  
  public final int a()
  {
    a(100, 0L);
    return 0;
  }
  
  public final void a(Message paramMessage)
    throws Exception
  {
    if (this.g == null) {}
    do
    {
      return;
      byte[] arrayOfByte;
      p localp;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        this.f = new r(new File(this.g, this.i));
        this.f.a(this);
        arrayOfByte = ai.a(new File(this.g, this.h));
        l1 = ((Long)am.b("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(0L))).longValue();
        l2 = System.currentTimeMillis();
        if ((l2 - l1 < 2592000000L) && (!ai.b(arrayOfByte)))
        {
          localp = this.e;
          paramMessage = localp.a;
          if (arrayOfByte == null) {
            break;
          }
        }
      case 104: 
        for (;;)
        {
          try
          {
            int k = Math.min(arrayOfByte.length, localp.b.length);
            System.arraycopy(arrayOfByte, 0, localp.b, 0, k);
            ai.a(3, "WifiInfoPro", "bf init.", null);
            a(103, 300000L);
            ai.a(new File(this.g, this.h), this.e.a(), false);
            a(104, 300000L);
            return;
          }
          finally {}
          am.a("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(l2));
          ai.a(3, "WifiInfoPro", "bf reset.", null);
        }
      case 102: 
        paramMessage = ((List)paramMessage.obj).iterator();
        while (paramMessage.hasNext())
        {
          Object localObject2 = (ScanResult)paramMessage.next();
          if (!this.e.b(((ScanResult)localObject2).BSSID))
          {
            this.e.a(((ScanResult)localObject2).BSSID);
            localObject2 = a((ScanResult)localObject2);
            this.d.add(localObject2);
          }
        }
        if (ai.a()) {
          ai.a(3, "WifiInfoPro", "wf list size:" + this.d.size(), null);
        }
        break;
      }
    } while (this.d.size() < 30);
    a(this.d);
    return;
    a(this.d);
    ai.a(new File(this.g, this.h), this.e.a(), false);
    if (this.f != null)
    {
      this.f.a();
      this.f = null;
    }
    if (f()) {
      a(103, 1800000L);
    }
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)am.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(0L))).longValue();
    ad.a();
    paramMessage = ak.a();
    if ((paramMessage == ak.a.c) || ((paramMessage == ak.a.b) && ((h.f) || (h.g)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (ai.a()) {
        ai.a(3, "WifiInfoPro", "lastUpT:" + l2 + ",deltaT:" + (l1 - l2) + ",network status:" + paramMessage + ",isUpload:" + bool, null);
      }
      if (!bool) {
        break;
      }
      if ((l2 != 0L) && (l1 - l2 >= 86400000L)) {
        break label672;
      }
      if (l2 != 0L) {
        break;
      }
      am.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
      return;
    }
    label672:
    ah.a("th_loc_task_t_consume", this);
    am.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = af.a(ai.a(paramArrayOfByte), af.a("fc_wf_up"));
    if (!ai.b(paramArrayOfByte))
    {
      paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
      if (!ai.b(paramArrayOfByte))
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        paramArrayOfByte = paramArrayOfByte + '$';
        try
        {
          paramArrayOfByte = paramArrayOfByte.getBytes("UTF-8");
          return paramArrayOfByte;
        }
        catch (Throwable paramArrayOfByte) {}
      }
    }
    return new byte[0];
  }
  
  public final void b()
  {
    a(101, 0L);
  }
  
  public final String c()
  {
    return "WifiInfoPro";
  }
  
  public final void run()
  {
    try
    {
      this.c = true;
      if (this.f != null)
      {
        this.f.a();
        this.f = null;
      }
      File localFile = new File(this.g, this.i);
      if (ai.a()) {
        ai.a(3, "WifiInfoPro", "upload:" + localFile.getName() + "," + localFile.length(), null);
      }
      byte[] arrayOfByte = ai.a(ai.a(localFile));
      boolean bool = h.h;
      String str = "https://analytics.map.qq.com/?wf4";
      if (!h.e) {
        str = "https://analytics.map.qq.com/?wf4".replace("https:", "http:");
      }
      h.k.a(str, arrayOfByte, new f.1(this, localFile));
      if (f())
      {
        this.f = new r(new File(this.g, this.i));
        this.f.a(this);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ai.a("WifiInfoPro", "upload error.", localThrowable);
      return;
    }
    finally
    {
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.f
 * JD-Core Version:    0.7.0.1
 */