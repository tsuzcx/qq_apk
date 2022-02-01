import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class abud
{
  public long Ow;
  public long Ox;
  public boolean bFC;
  public String bhD;
  public String bhK;
  public String bhL;
  public String bhM;
  public int csg = -1;
  public int csh;
  public final HashMap<Integer, abud.b> iA = new HashMap();
  public String mCurrentUin;
  public List<abud.a> mItems;
  public final List<abud.b> wx = new ArrayList();
  public List<abud.a> wy;
  public long zl;
  
  public static String dj(int paramInt)
  {
    if (paramInt > 999999) {
      return String.valueOf(999999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String dk(int paramInt)
  {
    if (paramInt > 99999) {
      return String.valueOf(99999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String dl(int paramInt)
  {
    if (paramInt > 9999) {
      return String.valueOf(9999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public void cFs()
  {
    if ((TextUtils.isEmpty(this.mCurrentUin)) || (this.mItems == null) || (this.mItems.isEmpty())) {
      return;
    }
    Iterator localIterator = this.mItems.iterator();
    label40:
    abud.a locala;
    abud.b localb;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        locala = (abud.a)localIterator.next();
        if ((!TextUtils.isEmpty(this.mCurrentUin)) && (this.mCurrentUin.equals(String.valueOf(locala.Oy))))
        {
          if (locala.O > 4) {
            break label165;
          }
          localb = (abud.b)this.iA.get(Integer.valueOf(3));
          if (localb != null)
          {
            localb.csh += 1;
            this.csh += 1;
          }
        }
      }
    }
    for (;;)
    {
      if (this.wy == null) {
        this.wy = new ArrayList();
      }
      this.wy.add(locala);
      break label40;
      break;
      label165:
      localb = (abud.b)this.iA.get(Short.valueOf(locala.O));
      if (localb != null)
      {
        localb.csh += locala.csl;
        this.csh += locala.csl;
      }
    }
  }
  
  public static class a
    implements Comparable<a>
  {
    public short O;
    public long OA;
    public long Ou;
    public long Ov;
    public long Oy;
    public long Oz;
    public short P;
    public String aGC;
    public String aGE;
    public boolean bFD;
    public boolean bFE;
    public String bhN;
    public String bhO;
    public String bhP;
    public int csi;
    public int csj;
    public int csk = -1;
    public int csl;
    public int csm = 0;
    public int csn;
    public String mDesc;
    public int mId;
    public String mName;
    public int mVipLevel;
    
    public int a(a parama)
    {
      if (parama == null) {}
      do
      {
        return -1;
        if (this.bFD == parama.bFD) {
          return -(int)(this.OA - parama.OA);
        }
      } while (this.bFD);
      return 0;
    }
    
    public boolean jB(String paramString)
    {
      return (this.Oy == this.Oz) || ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.Oy))));
    }
  }
  
  public static class b
  {
    public String bhQ;
    public int csh;
    public int cso;
    public int csp;
    public String mIconUrl;
    public boolean mIsShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abud
 * JD-Core Version:    0.7.0.1
 */