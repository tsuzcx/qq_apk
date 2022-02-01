import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

public class oie
{
  public SparseIntArray D = new SparseIntArray();
  private ole a;
  public int akP;
  public String aqe = "";
  public String attachInfo = "";
  public List<stSimpleMetaFeed> la = new ArrayList();
  public List<stFeed> lb = new ArrayList();
  
  public static oie a()
  {
    return oie.a.b();
  }
  
  private oko a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, oie.b paramb)
  {
    return new oif(this, paramBoolean1, paramBoolean2, paramb, paramInt);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, oie.b paramb)
  {
    if (paramBoolean1)
    {
      this.lb.clear();
      this.la.clear();
      this.D.clear();
    }
    List localList = ad(paramList);
    this.lb.addAll(paramList);
    if (paramb == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramb.a(false, this.lb, paramBoolean2);
          return;
        }
        paramb.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramb.a(true, localList, paramBoolean2);
  }
  
  private List<stSimpleMetaFeed> ad(List<stFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (oor.v(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      stFeed localstFeed = (stFeed)paramList.get(i);
      if ((localstFeed.feed_type == 2) && (localstFeed.feed != null))
      {
        this.D.put(this.lb.size() + i, this.la.size() + localArrayList.size());
        localArrayList.add(localstFeed.feed);
      }
      i += 1;
    }
    this.la.addAll(localArrayList);
    ooz.d("WSVideoDataManager", "position map: " + this.D.toString());
    return localArrayList;
  }
  
  public ola a(ojm paramojm)
  {
    ola localola = paramojm.jdField_a_of_type_Ola;
    Object localObject = localola;
    if (localola == null) {
      localObject = new ols();
    }
    ((ols)localObject).e(paramojm);
    return localObject;
  }
  
  public ole a()
  {
    return this.a;
  }
  
  public ole a(ojm paramojm, long paramLong, int paramInt)
  {
    ole localole2 = paramojm.b;
    ole localole1 = localole2;
    if (localole2 == null) {
      localole1 = new ole();
    }
    localole1.jdField_a_of_type_Oli = paramojm.jdField_a_of_type_Oli;
    localole1.ci = paramojm.p();
    localole1.b = paramojm.jdField_a_of_type_Ola;
    localole1.bfl = 2;
    localole1.mStartPosition = paramLong;
    localole1.aqt = false;
    localole1.bfm = paramInt;
    localole1.aqb = "follow_tab";
    return localole1;
  }
  
  public void a(ole paramole)
  {
    this.a = paramole;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, oie.b<T> paramb)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.attachInfo;; str = "")
    {
      paramString = new okz(new onp(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramb), 3001);
      oks.a().b(paramString);
      return;
    }
  }
  
  public void d(ojm paramojm)
  {
    paramojm = paramojm.b;
    if ((paramojm != null) && ((paramojm.axG) || ((paramojm.c != null) && (paramojm.c.qe() != 0)))) {
      paramojm.axG = false;
    }
  }
  
  public void init(List<stFeed> paramList)
  {
    this.lb = paramList;
    this.akP = 15;
    ad(paramList);
  }
  
  public void release()
  {
    this.attachInfo = "";
    this.aqe = "";
    if (this.a != null) {
      this.a = null;
    }
    if (this.lb != null) {
      this.lb.clear();
    }
    if (this.la != null) {
      this.la.clear();
    }
    if (this.D != null) {
      this.D.clear();
    }
  }
  
  static final class a
  {
    private static final oie b = new oie(null);
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(boolean paramBoolean1, List<T> paramList, boolean paramBoolean2);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oie
 * JD-Core Version:    0.7.0.1
 */