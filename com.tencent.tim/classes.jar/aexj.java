import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aexj
{
  private static final String TAG = aexj.class.getSimpleName();
  private static aexg jdField_a_of_type_Aexg;
  private static aexv jdField_a_of_type_Aexv;
  private static aexx b;
  private aexm jdField_a_of_type_Aexm;
  private aexn jdField_a_of_type_Aexn;
  private aexp jdField_a_of_type_Aexp;
  private aexq jdField_a_of_type_Aexq;
  private aexr jdField_a_of_type_Aexr;
  private aexs jdField_a_of_type_Aexs;
  private aexu jdField_a_of_type_Aexu;
  private aeyb jdField_a_of_type_Aeyb = new aeyb();
  private final aeyl<Drawable> jdField_a_of_type_Aeyl;
  private int cPE;
  private final SparseArray<aext> cv = new SparseArray();
  private boolean mDebug;
  private boolean mIsLive;
  private List<aexy> zi;
  
  private aexj(aexj.a parama)
  {
    this.mIsLive = aexj.a.a(parama);
    this.jdField_a_of_type_Aexs = aexj.a.a(parama);
    this.jdField_a_of_type_Aexq = aexj.a.a(parama);
    this.jdField_a_of_type_Aexp = aexj.a.a(parama);
    jdField_a_of_type_Aexv = aexj.a.a(parama);
    this.jdField_a_of_type_Aexu = aexj.a.a(parama);
    this.jdField_a_of_type_Aexr = parama.jdField_a_of_type_Aexr;
    this.jdField_a_of_type_Aexn = parama.jdField_a_of_type_Aexn;
    this.jdField_a_of_type_Aexm = aexj.a.a(parama);
    this.cPE = aexj.a.a(parama);
    this.mDebug = aexj.a.b(parama);
    this.jdField_a_of_type_Aeyl = new aeyl();
    a(parama);
    checkParams();
  }
  
  public static aexg a()
  {
    if (jdField_a_of_type_Aexg == null) {}
    try
    {
      if (jdField_a_of_type_Aexg == null) {
        jdField_a_of_type_Aexg = new aexg();
      }
      return jdField_a_of_type_Aexg;
    }
    finally {}
  }
  
  public static aexj.a a()
  {
    return new aexj.a(null);
  }
  
  public static aexx a()
  {
    if (b == null) {}
    try
    {
      if ((b == null) && (jdField_a_of_type_Aexv != null)) {
        b = jdField_a_of_type_Aexv.b();
      }
      if (b == null) {
        b = new aexx();
      }
      return b;
    }
    finally {}
  }
  
  private void a(aexj.a parama)
  {
    this.zi = new ArrayList();
    this.zi.addAll(aexj.a.a(parama));
  }
  
  private void checkParams()
  {
    if ((!this.mIsLive) && (this.jdField_a_of_type_Aexs == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int CM()
  {
    if (this.jdField_a_of_type_Aexr != null) {
      return this.jdField_a_of_type_Aexr.CM();
    }
    return (int)Math.ceil(aeyv.a(a()));
  }
  
  public int CN()
  {
    return this.cPE;
  }
  
  public aexe a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new aexi(this);
    }
    aexe localaexe;
    do
    {
      return localObject;
      localaexe = null;
      if (this.jdField_a_of_type_Aexn != null) {
        localaexe = this.jdField_a_of_type_Aexn.a(this, paramInt);
      }
      localObject = localaexe;
    } while (localaexe != null);
    return new aexf(this);
  }
  
  public aext a(int paramInt)
  {
    Object localObject3 = (aext)this.cv.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (aext)this.cv.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Aexu != null)
        {
          localObject1 = this.jdField_a_of_type_Aexu.b(paramInt);
          this.cv.put(paramInt, localObject1);
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = a();
      }
      return localObject3;
    }
    finally {}
  }
  
  public aexy a(aexe paramaexe)
  {
    Iterator localIterator = ew().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (aexy)localIterator.next();
    } while (!((aexy)localObject).b(paramaexe));
    for (paramaexe = (aexe)localObject;; paramaexe = null)
    {
      localObject = paramaexe;
      if (paramaexe == null) {
        localObject = this.jdField_a_of_type_Aeyb;
      }
      return localObject;
    }
  }
  
  public void cXY()
  {
    if (this.jdField_a_of_type_Aexm != null) {
      this.jdField_a_of_type_Aexm.cXZ();
    }
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Aeyl.trimToSize(0);
  }
  
  public List<aexy> ew()
  {
    return this.zi;
  }
  
  public long getPlayTime()
  {
    if (this.jdField_a_of_type_Aexs == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Aexs.getPlayTime();
  }
  
  public boolean isDebug()
  {
    return this.mDebug;
  }
  
  public boolean isLive()
  {
    return (this.mIsLive) || (getPlayTime() < 0L);
  }
  
  public void k(aexe paramaexe)
  {
    if (this.jdField_a_of_type_Aexq != null) {
      this.jdField_a_of_type_Aexq.k(paramaexe);
    }
  }
  
  public static final class a
  {
    private aexm jdField_a_of_type_Aexm;
    public aexn a;
    private aexp jdField_a_of_type_Aexp;
    private aexq jdField_a_of_type_Aexq;
    public aexr a;
    private aexs jdField_a_of_type_Aexs;
    private aexu jdField_a_of_type_Aexu;
    private aexv b;
    private int cPE;
    private boolean mDebug;
    private boolean mIsLive;
    private List<aexy> zi = new ArrayList();
    
    public a a(int paramInt)
    {
      this.cPE = paramInt;
      return this;
    }
    
    public a a(aexs paramaexs)
    {
      this.jdField_a_of_type_Aexs = paramaexs;
      return this;
    }
    
    public a a(aexy paramaexy)
    {
      this.zi.add(paramaexy);
      return this;
    }
    
    public aexj a()
    {
      return new aexj(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexj
 * JD-Core Version:    0.7.0.1
 */