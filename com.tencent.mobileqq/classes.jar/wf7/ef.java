package wf7;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class ef
{
  private em lT;
  private volatile boolean lU = false;
  private volatile String lV = "";
  private volatile long lW = 0L;
  private boolean lh = false;
  private Context mContext;
  
  public ef(Context paramContext, em paramem, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.lT = paramem;
    this.lh = paramBoolean;
    paramContext = this.lT.cT().bZ();
    paramBoolean = this.lT.cT().cf();
    if ((this.lh != paramBoolean) && (!TextUtils.isEmpty(paramContext)))
    {
      this.lT.cT().w("");
      this.lT.cT().x("");
    }
    cB();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString) {}
  
  private void a(String paramString, dl paramdl, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str;
    if (paramString != null) {
      str = paramString;
    } else {
      str = "";
    }
    this.lV = str;
    this.lU = true;
    this.lT.cT().p(this.lh);
    this.lT.cT().w(paramString);
    this.lT.cT().x(paramString);
    this.lT.cT().a(paramdl);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 != paramLong2;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 != paramBoolean2;
  }
  
  private void b(dl paramdl)
  {
    int i = ew.dg().di();
    Object localObject = c(paramdl);
    x localx = new x();
    localx.bZ = i;
    localx.bH = 2;
    localx.data = ee.a(this.mContext, (JceStruct)localObject, 2, localx);
    if (localx.data == null) {
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(localx);
    el.cP().a(localx.bZ, -1L, null);
    this.lT.a(0, 0L, false, (ArrayList)localObject, new ef.2(this, i, paramdl));
  }
  
  private u c(dl paramdl)
  {
    u localu = new u();
    localu.bS = paramdl;
    localu.bT = cC();
    localu.bU = this.lT.cT().ca();
    return localu;
  }
  
  private dl cD()
  {
    dl localdl = this.lT.cT().ch();
    if (localdl != null)
    {
      if (localdl.d == null) {
        localdl.d = "";
      }
      return localdl;
    }
    throw new RuntimeException("onGetRealInfoOfGuid() return null");
  }
  
  private boolean f(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return true;
    }
    return paramString1.equals(paramString2) ^ true;
  }
  
  private boolean u(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      this.lW = l1;
      this.lT.cT().d(l1);
      return true;
    }
    paramBoolean = false;
    if (this.lW <= 0L)
    {
      this.lW = l1;
    }
    else
    {
      if (!ff.a(l1, this.lW, 60)) {
        return false;
      }
      this.lW = l1;
    }
    long l2 = this.lT.cT().cj();
    if (l2 <= 0L)
    {
      this.lT.cT().d(l1);
      return false;
    }
    if (ff.a(l1, l2, 720))
    {
      this.lT.cT().d(l1);
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private dl v(boolean paramBoolean)
  {
    if (cA()) {
      return null;
    }
    if (!u(paramBoolean)) {
      return null;
    }
    dl localdl = cD();
    Object localObject = this.lT.cT().cg();
    if (localdl != null)
    {
      if (localObject == null) {
        return null;
      }
      paramBoolean = f(localdl.d, ((dl)localObject).d);
      int j = 0;
      boolean bool1 = f(localdl.df, ((dl)localObject).df);
      boolean bool2 = f(localdl.kL, ((dl)localObject).kL);
      boolean bool3 = f(localdl.kl, ((dl)localObject).kl);
      boolean bool4 = f(localdl.cY, ((dl)localObject).cY);
      boolean bool5 = f(localdl.cZ, ((dl)localObject).cZ);
      boolean bool6 = x(localdl.cA, ((dl)localObject).cA);
      boolean bool7 = f(localdl.db, ((dl)localObject).db);
      boolean bool8 = x(localdl.ba, ((dl)localObject).ba);
      boolean bool9 = f(localdl.h, ((dl)localObject).h);
      boolean bool10 = x(localdl.km, ((dl)localObject).km);
      boolean bool11 = x(localdl.cH, ((dl)localObject).cH);
      boolean bool12 = a(localdl.kn, ((dl)localObject).kn);
      boolean bool13 = f(localdl.ko, ((dl)localObject).ko);
      boolean bool14 = f(localdl.dc, ((dl)localObject).dc);
      boolean bool15 = x(localdl.kp, ((dl)localObject).kp);
      boolean bool16 = f(localdl.kq, ((dl)localObject).kq);
      boolean bool17 = x(localdl.dj, ((dl)localObject).dj);
      boolean bool18 = x(localdl.kr, ((dl)localObject).kr);
      boolean bool19 = f(localdl.ks, ((dl)localObject).ks);
      boolean bool20 = f(localdl.kU, ((dl)localObject).kU);
      boolean bool21 = f(localdl.kt, ((dl)localObject).kt);
      boolean bool22 = x(localdl.ku, ((dl)localObject).ku);
      boolean bool23 = f(localdl.kv, ((dl)localObject).kv);
      boolean bool24 = a(localdl.kw, ((dl)localObject).kw);
      boolean bool25 = a(localdl.kx, ((dl)localObject).kx);
      boolean bool26 = a(localdl.ky, ((dl)localObject).ky);
      boolean bool27 = a(localdl.kZ, ((dl)localObject).kZ);
      boolean bool28 = f(localdl.kz, ((dl)localObject).kz);
      boolean bool29 = f(localdl.kA, ((dl)localObject).kA);
      boolean bool30 = f(localdl.kB, ((dl)localObject).kB);
      boolean bool31 = f(localdl.version, ((dl)localObject).version);
      boolean bool32 = x(localdl.kP, ((dl)localObject).kP);
      boolean bool33 = f(localdl.kQ, ((dl)localObject).kQ);
      boolean bool34 = f(localdl.kE, ((dl)localObject).kE);
      boolean bool35 = x(localdl.kH, ((dl)localObject).kH);
      boolean bool36 = x(localdl.kI, ((dl)localObject).kI);
      boolean bool37 = f(localdl.kR, ((dl)localObject).kR);
      boolean bool38 = f(localdl.kS, ((dl)localObject).kS);
      boolean bool39 = f(localdl.kT, ((dl)localObject).kT);
      boolean bool40 = f(localdl.kV, ((dl)localObject).kV);
      boolean bool41 = f(localdl.kW, ((dl)localObject).kW);
      boolean bool42 = f(localdl.kX, ((dl)localObject).kX);
      boolean bool43 = f(localdl.kY, ((dl)localObject).kY);
      boolean bool44 = f(localdl.kF, ((dl)localObject).kF);
      boolean bool45 = f(localdl.la, ((dl)localObject).la);
      boolean bool46 = f(localdl.kG, ((dl)localObject).kG);
      boolean bool47 = f(localdl.kC, ((dl)localObject).kC);
      boolean bool48 = f(localdl.kD, ((dl)localObject).kD);
      boolean bool49 = f(localdl.lb, ((dl)localObject).lb);
      boolean bool50 = a(localdl.kJ, ((dl)localObject).kJ);
      boolean bool51 = x(localdl.lc, ((dl)localObject).lc);
      boolean bool52 = f(localdl.ld, ((dl)localObject).ld);
      boolean bool53 = f(localdl.le, ((dl)localObject).le);
      boolean bool54 = f(localdl.lf, ((dl)localObject).lf);
      localObject = this.lT.cT().ca();
      String str = cC();
      int i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          i = j;
          if (!((String)localObject).equals(str)) {
            i = 1;
          }
        }
      }
      if (!(bool54 | paramBoolean | false | bool1 | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29 | bool30 | bool31 | bool32 | bool33 | bool34 | bool35 | bool36 | bool37 | bool38 | bool39 | bool40 | bool41 | bool42 | bool43 | bool44 | bool45 | bool46 | bool47 | bool48 | bool49 | bool50 | bool51 | bool52 | bool53 | i)) {
        return null;
      }
      return localdl;
    }
    return null;
  }
  
  private boolean x(int paramInt1, int paramInt2)
  {
    return paramInt1 != paramInt2;
  }
  
  public void a(ef.a parama)
  {
    if (!cA()) {
      return;
    }
    dl localdl = cD();
    x localx = new x();
    int i = ew.dg().di();
    localx.bZ = i;
    localx.bH = 1;
    localx.data = ee.a(this.mContext, localdl, 1, localx);
    if (localx.data == null)
    {
      parama.a(i, 1, -20001500, null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localx);
    el.cP().a(localx.bZ, -1L, null);
    this.lT.b(localArrayList, new ef.1(this, parama, i, localdl));
  }
  
  public boolean cA()
  {
    return (TextUtils.isEmpty(cC())) || (!this.lU);
  }
  
  public void cB()
  {
    this.lV = this.lT.cT().bZ();
    if (TextUtils.isEmpty(this.lV))
    {
      this.lU = false;
      this.lV = this.lT.cT().ca();
      if (this.lV == null) {
        this.lV = "";
      }
    }
    else
    {
      this.lU = true;
    }
  }
  
  public String cC()
  {
    if (this.lV != null) {
      return this.lV;
    }
    return "";
  }
  
  public void t(boolean paramBoolean)
  {
    dl localdl = v(paramBoolean);
    if (localdl == null) {
      return;
    }
    b(localdl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ef
 * JD-Core Version:    0.7.0.1
 */