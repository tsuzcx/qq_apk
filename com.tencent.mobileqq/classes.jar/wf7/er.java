package wf7;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;

public class er
{
  private em lT;
  private String pg = "";
  private boolean ph = false;
  
  public er(Context paramContext, em paramem, boolean paramBoolean)
  {
    this.lT = paramem;
    this.pg = this.lT.cT().cd();
  }
  
  private ed<Long, Integer, JceStruct> a(long paramLong, int paramInt, z paramz)
  {
    if (paramz == null) {
      return null;
    }
    if (paramz.cn == 0)
    {
      d(1, true);
      return null;
    }
    if (paramz.cn == 1) {
      d(1, false);
    }
    return null;
  }
  
  private boolean cA()
  {
    if (!ea.bX()) {
      return false;
    }
    return TextUtils.isEmpty(this.pg);
  }
  
  private t de()
  {
    t localt = new t();
    String str = this.lT.cT().ce();
    if (str == null) {
      str = "";
    }
    localt.bR = str;
    return localt;
  }
  
  private v e(int paramInt, boolean paramBoolean)
  {
    String str1 = this.lT.cT().cd();
    String str2 = this.lT.cT().ce();
    if (str1 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    Object localObject2 = null;
    if (paramBoolean)
    {
      localObject1 = new v();
      ((v)localObject1).bW = paramInt;
      ((v)localObject1).bX = str1;
      ((v)localObject1).bR = str2;
      return localObject1;
    }
    if (cA()) {
      return null;
    }
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str1))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = localObject2;
        if (!str1.equals(str2))
        {
          localObject1 = new v();
          ((v)localObject1).bW = paramInt;
          ((v)localObject1).bX = str1;
          ((v)localObject1).bR = str2;
        }
      }
    }
    return localObject1;
  }
  
  public void b(em.c paramc)
  {
    er.3 local3 = new er.3(this);
    paramc.a(0L, 15020, new z(), 0, local3, false);
  }
  
  public void d(int paramInt, boolean paramBoolean)
  {
    if (!this.lT.cT().cb()) {
      return;
    }
    v localv = e(paramInt, paramBoolean);
    if (localv == null) {
      return;
    }
    ea.cw().a(5007, localv, new ac(), 0, new er.2(this), 30000L);
  }
  
  public void dd()
  {
    if (!this.lT.cT().cb()) {
      return;
    }
    if (this.ph) {
      return;
    }
    if (!cA()) {
      return;
    }
    this.lT.cT().cc();
    this.ph = true;
    ea.cw().a(5006, de(), new ab(), 0, new er.1(this), 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.er
 * JD-Core Version:    0.7.0.1
 */