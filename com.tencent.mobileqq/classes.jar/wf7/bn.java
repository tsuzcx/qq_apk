package wf7;

import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.qqpimsecure.wificore.api.connect.b;
import com.tencent.qqpimsecure.wificore.api.connect.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bn
{
  private String ey;
  private int ez;
  private String fZ;
  private final Map<Class, bn.a> ga;
  
  public bn()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = new ArrayMap();
    } else {
      localObject = new HashMap();
    }
    this.ga = Collections.synchronizedMap((Map)localObject);
  }
  
  public void A(int paramInt)
  {
    this.ez = paramInt;
  }
  
  public int Y()
  {
    return cb.d(this.ey, this.ez);
  }
  
  public String Z()
  {
    return this.ey;
  }
  
  public void a(Class paramClass, bn.a parama)
  {
    this.ga.put(paramClass, parama);
  }
  
  public String aa()
  {
    return this.fZ;
  }
  
  public int ab()
  {
    return this.ez;
  }
  
  public bs ac()
  {
    bs localbs2 = ((bq)ao.c().i(1)).h(this);
    bs localbs1 = localbs2;
    if (localbs2 == null) {
      localbs1 = new bs();
    }
    return localbs1;
  }
  
  public bl ad()
  {
    bl localbl2 = ((bk)ao.c().i(2)).c(this);
    bl localbl1 = localbl2;
    if (localbl2 == null) {
      localbl1 = new bl();
    }
    return localbl1;
  }
  
  public b ae()
  {
    b localb2 = ((d)ao.c().i(4)).a(this);
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new b();
    }
    return localb1;
  }
  
  public bn.a b(Class paramClass)
  {
    return (bn.a)this.ga.get(paramClass);
  }
  
  public boolean e(bn parambn)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambn != null)
    {
      bool1 = bool2;
      if (parambn.Z().compareTo(Z()) == 0)
      {
        bool1 = bool2;
        if (parambn.ab() == ab()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void f(String paramString)
  {
    this.ey = paramString;
  }
  
  public void g(String paramString)
  {
    this.fZ = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AccessPoint{mSsid='");
    localStringBuilder.append(this.ey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBssid='");
    localStringBuilder.append(this.fZ);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSecurity=");
    localStringBuilder.append(this.ez);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.bn
 * JD-Core Version:    0.7.0.1
 */