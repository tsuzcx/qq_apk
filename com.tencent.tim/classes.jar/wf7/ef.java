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
    if (paramString != null) {}
    for (String str = paramString;; str = "")
    {
      this.lV = str;
      this.lU = true;
      this.lT.cT().p(this.lh);
      this.lT.cT().w(paramString);
      this.lT.cT().x(paramString);
      this.lT.cT().a(paramdl);
      return;
    }
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
    if (localdl == null) {
      throw new RuntimeException("onGetRealInfoOfGuid() return null");
    }
    if (localdl.d == null) {
      localdl.d = "";
    }
    return localdl;
  }
  
  private boolean f(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString2));
      bool1 = bool2;
    } while (!paramString1.equals(paramString2));
    return false;
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
    boolean bool = false;
    long l2;
    if (this.lW <= 0L)
    {
      this.lW = l1;
      l2 = this.lT.cT().cj();
      if (l2 > 0L) {
        break label99;
      }
      this.lT.cT().d(l1);
      paramBoolean = bool;
    }
    for (;;)
    {
      return paramBoolean;
      paramBoolean = bool;
      if (ff.a(l1, this.lW, 60))
      {
        this.lW = l1;
        break;
        label99:
        paramBoolean = bool;
        if (ff.a(l1, l2, 720))
        {
          this.lT.cT().d(l1);
          paramBoolean = true;
        }
      }
    }
  }
  
  private dl v(boolean paramBoolean)
  {
    int j = 0;
    if (cA()) {}
    dl localdl;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    boolean bool8;
    boolean bool9;
    boolean bool10;
    boolean bool11;
    boolean bool12;
    boolean bool13;
    boolean bool14;
    boolean bool15;
    boolean bool16;
    boolean bool17;
    boolean bool18;
    boolean bool19;
    boolean bool20;
    boolean bool21;
    boolean bool22;
    boolean bool23;
    boolean bool24;
    boolean bool25;
    boolean bool26;
    boolean bool27;
    boolean bool28;
    boolean bool29;
    boolean bool30;
    boolean bool31;
    boolean bool32;
    boolean bool33;
    boolean bool34;
    boolean bool35;
    boolean bool36;
    boolean bool37;
    boolean bool38;
    boolean bool39;
    boolean bool40;
    boolean bool41;
    boolean bool42;
    boolean bool43;
    boolean bool44;
    boolean bool45;
    boolean bool46;
    boolean bool47;
    boolean bool48;
    boolean bool49;
    boolean bool50;
    boolean bool51;
    boolean bool52;
    boolean bool53;
    boolean bool54;
    int i;
    do
    {
      do
      {
        do
        {
          return null;
        } while (!u(paramBoolean));
        localdl = cD();
        localObject = this.lT.cT().cg();
      } while ((localdl == null) || (localObject == null));
      paramBoolean = f(localdl.d, ((dl)localObject).d);
      bool1 = f(localdl.df, ((dl)localObject).df);
      bool2 = f(localdl.kL, ((dl)localObject).kL);
      bool3 = f(localdl.kl, ((dl)localObject).kl);
      bool4 = f(localdl.cY, ((dl)localObject).cY);
      bool5 = f(localdl.cZ, ((dl)localObject).cZ);
      bool6 = x(localdl.cA, ((dl)localObject).cA);
      bool7 = f(localdl.db, ((dl)localObject).db);
      bool8 = x(localdl.ba, ((dl)localObject).ba);
      bool9 = f(localdl.h, ((dl)localObject).h);
      bool10 = x(localdl.km, ((dl)localObject).km);
      bool11 = x(localdl.cH, ((dl)localObject).cH);
      bool12 = a(localdl.kn, ((dl)localObject).kn);
      bool13 = f(localdl.ko, ((dl)localObject).ko);
      bool14 = f(localdl.dc, ((dl)localObject).dc);
      bool15 = x(localdl.kp, ((dl)localObject).kp);
      bool16 = f(localdl.kq, ((dl)localObject).kq);
      bool17 = x(localdl.dj, ((dl)localObject).dj);
      bool18 = x(localdl.kr, ((dl)localObject).kr);
      bool19 = f(localdl.ks, ((dl)localObject).ks);
      bool20 = f(localdl.kU, ((dl)localObject).kU);
      bool21 = f(localdl.kt, ((dl)localObject).kt);
      bool22 = x(localdl.ku, ((dl)localObject).ku);
      bool23 = f(localdl.kv, ((dl)localObject).kv);
      bool24 = a(localdl.kw, ((dl)localObject).kw);
      bool25 = a(localdl.kx, ((dl)localObject).kx);
      bool26 = a(localdl.ky, ((dl)localObject).ky);
      bool27 = a(localdl.kZ, ((dl)localObject).kZ);
      bool28 = f(localdl.kz, ((dl)localObject).kz);
      bool29 = f(localdl.kA, ((dl)localObject).kA);
      bool30 = f(localdl.kB, ((dl)localObject).kB);
      bool31 = f(localdl.version, ((dl)localObject).version);
      bool32 = x(localdl.kP, ((dl)localObject).kP);
      bool33 = f(localdl.kQ, ((dl)localObject).kQ);
      bool34 = f(localdl.kE, ((dl)localObject).kE);
      bool35 = x(localdl.kH, ((dl)localObject).kH);
      bool36 = x(localdl.kI, ((dl)localObject).kI);
      bool37 = f(localdl.kR, ((dl)localObject).kR);
      bool38 = f(localdl.kS, ((dl)localObject).kS);
      bool39 = f(localdl.kT, ((dl)localObject).kT);
      bool40 = f(localdl.kV, ((dl)localObject).kV);
      bool41 = f(localdl.kW, ((dl)localObject).kW);
      bool42 = f(localdl.kX, ((dl)localObject).kX);
      bool43 = f(localdl.kY, ((dl)localObject).kY);
      bool44 = f(localdl.kF, ((dl)localObject).kF);
      bool45 = f(localdl.la, ((dl)localObject).la);
      bool46 = f(localdl.kG, ((dl)localObject).kG);
      bool47 = f(localdl.kC, ((dl)localObject).kC);
      bool48 = f(localdl.kD, ((dl)localObject).kD);
      bool49 = f(localdl.lb, ((dl)localObject).lb);
      bool50 = a(localdl.kJ, ((dl)localObject).kJ);
      bool51 = x(localdl.lc, ((dl)localObject).lc);
      bool52 = f(localdl.ld, ((dl)localObject).ld);
      bool53 = f(localdl.le, ((dl)localObject).le);
      bool54 = f(localdl.lf, ((dl)localObject).lf);
      Object localObject = this.lT.cT().ca();
      String str = cC();
      i = j;
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
    } while ((i | bool54 | paramBoolean | false | bool1 | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29 | bool30 | bool31 | bool32 | bool33 | bool34 | bool35 | bool36 | bool37 | bool38 | bool39 | bool40 | bool41 | bool42 | bool43 | bool44 | bool45 | bool46 | bool47 | bool48 | bool49 | bool50 | bool51 | bool52 | bool53) == 0);
    return localdl;
  }
  
  private boolean x(int paramInt1, int paramInt2)
  {
    return paramInt1 != paramInt2;
  }
  
  public void a(a parama)
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
      return;
    }
    this.lU = true;
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
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ef
 * JD-Core Version:    0.7.0.1
 */