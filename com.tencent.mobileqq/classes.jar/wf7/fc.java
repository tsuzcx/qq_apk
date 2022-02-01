package wf7;

import android.content.Context;
import android.util.SparseArray;
import java.util.List;

public class fc
  extends dt
{
  private static fc pK = null;
  private fb pJ = null;
  private boolean pc = true;
  
  public static fc dC()
  {
    if (pK == null) {}
    try
    {
      if (pK == null) {
        pK = new fc();
      }
      return pK;
    }
    finally {}
  }
  
  public void a(String paramString, long paramLong, List<String> paramList)
  {
    this.pJ.b(paramString, paramLong, paramList);
  }
  
  public void a(dl paramdl)
  {
    this.pJ.d(paramdl);
  }
  
  public void a(dx paramdx)
  {
    if (paramdx == null) {
      return;
    }
    this.pJ.b(paramdx);
  }
  
  public int bW()
  {
    return fd.dF().dp();
  }
  
  public boolean bX()
  {
    return this.pc;
  }
  
  public dx bY()
  {
    return this.pJ.cO();
  }
  
  public String bZ()
  {
    return this.pJ.du();
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    this.pJ.C(paramString);
  }
  
  public String ca()
  {
    return this.pJ.dv();
  }
  
  public boolean cb()
  {
    return true;
  }
  
  public void cc() {}
  
  public String cd()
  {
    return this.pJ.dw();
  }
  
  public String ce()
  {
    return this.pJ.dx();
  }
  
  public boolean cf()
  {
    return this.pJ.dA();
  }
  
  public dl cg()
  {
    return this.pJ.dz();
  }
  
  public dl ch()
  {
    Context localContext = fd.dE();
    String[] arrayOfString = gj.s(localContext);
    int m = fd.dF().dq();
    long l1 = gr.fh();
    Object localObject = new gr.a();
    gr.b((gr.a)localObject);
    long l2 = ((gr.a)localObject).sx;
    localObject = new gr.a();
    gr.a((gr.a)localObject);
    long l3 = ((gr.a)localObject).sx;
    localObject = gr.B(localContext);
    String str1 = fd.dF().ds();
    String str2 = fd.dF().dt();
    int i = gr.D(localContext);
    int j = gr.E(localContext);
    int k;
    if (i < j)
    {
      k = j;
      j = i;
    }
    for (;;)
    {
      dl localdl = new dl();
      localdl.d = gr.A(localContext);
      localdl.df = str1;
      localdl.kL = str2;
      if (localObject != null) {}
      for (;;)
      {
        localdl.kl = ((String)localObject);
        localdl.cY = "0";
        localdl.cZ = "0";
        localdl.cA = fd.dF().getProductId();
        localdl.db = gz.V(fd.dF().dn());
        localdl.ba = fd.dF().dp();
        localdl.h = gz.V(fd.dF().dm());
        localdl.km = 2;
        localdl.cH = 201;
        localdl.kn = gj.t(localContext);
        try
        {
          localdl.ko = ("wfsdk" + localContext.getPackageName());
          label286:
          localdl.dc = gz.V(gr.eZ());
          localdl.kp = dk.bJ();
          localdl.kq = gz.V(gr.C(localContext));
          localdl.dj = 2052;
          localdl.kr = m;
          localdl.ks = arrayOfString[2];
          localdl.kU = gr.U("ro.product.cpu.abi2");
          localdl.kt = gj.eS();
          localdl.ku = gj.eT();
          localdl.kv = (k + "*" + j);
          localdl.kw = l1;
          localdl.kx = gj.eU();
          localdl.ky = l2;
          localdl.kZ = l3;
          localdl.kz = gz.V(gr.fc());
          localdl.kA = gz.V(gr.fa());
          localdl.kB = gz.V(gr.fb());
          localdl.kP = 1;
          localdl.version = gz.V(fd.dF().jdMethod_do());
          localdl.kQ = gz.V(fd.dE().getPackageName());
          localdl.kE = gr.ff();
          localdl.kH = 0;
          localdl.kI = 0;
          localdl.kR = gr.fd();
          localdl.kS = gr.fe();
          localdl.kT = gr.U("ro.build.product");
          localdl.kV = gr.U("ro.build.fingerprint");
          localdl.kW = gr.U("ro.product.locale.language");
          localdl.kX = gr.U("ro.product.locale.region");
          localdl.kY = gr.getRadioVersion();
          localdl.kF = gr.U("ro.board.platform");
          localdl.la = gr.U("ro.mediatek.platform");
          localdl.kG = gr.U("ro.sf.lcd_density");
          localdl.kC = gr.U("ro.product.name");
          localdl.kD = gr.U("ro.build.version.release");
          localdl.lb = gr.K(false);
          localdl.kJ = fd.dF().dr();
          localdl.lc = 2;
          localdl.ld = gr.fg();
          localdl.le = gr.L(true);
          localdl.lf = gr.L(false);
          return localdl;
          localObject = "";
        }
        catch (Throwable localThrowable)
        {
          break label286;
        }
      }
      k = i;
    }
  }
  
  public long cj()
  {
    return this.pJ.dy();
  }
  
  public int cm()
  {
    return 0;
  }
  
  public int co()
  {
    return 0;
  }
  
  public SparseArray<String> cp()
  {
    return new SparseArray();
  }
  
  public void d(long paramLong)
  {
    this.pJ.e(paramLong);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    this.pJ.D(paramString);
  }
  
  public void init(boolean paramBoolean)
  {
    this.pc = paramBoolean;
  }
  
  public void p(boolean paramBoolean)
  {
    this.pJ.w(paramBoolean);
  }
  
  public void t(int paramInt1, int paramInt2)
  {
    paramInt1 = dm.ac(paramInt2);
    if ((paramInt1 != -220000) || ((paramInt1 != -160000) || (((paramInt1 == -450000) || (paramInt1 != -540000)) || (((paramInt1 == -70000) || (paramInt1 == -370000) || (paramInt1 != -380000)) || ((paramInt1 != -350000) && (paramInt1 != -360000) && (paramInt1 == -430000)))))) {}
  }
  
  public void u(int paramInt1, int paramInt2) {}
  
  public dn.a v(String paramString)
  {
    return this.pJ.E(paramString);
  }
  
  public void v(int paramInt1, int paramInt2) {}
  
  public void w(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.pJ.A(paramString);
  }
  
  public void x(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.pJ.B(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.fc
 * JD-Core Version:    0.7.0.1
 */