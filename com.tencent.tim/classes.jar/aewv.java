import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class aewv
{
  protected int ZZ;
  protected aeww a;
  protected aexj a;
  protected final aexz a;
  protected aeyk a;
  protected aeyp a;
  protected final TreeSet<aexe> c;
  private ArrayList<aeyc> vR;
  protected final List<aexe> zg;
  
  protected aewv(aexj paramaexj, aeww paramaeww, Comparator<aexe> paramComparator, aeyp paramaeyp, aeyk paramaeyk)
  {
    this.jdField_a_of_type_Aexj = paramaexj;
    this.jdField_a_of_type_Aeww = paramaeww;
    this.jdField_a_of_type_Aeyp = paramaeyp;
    this.jdField_a_of_type_Aeyk = paramaeyk;
    this.jdField_a_of_type_Aexz = new aexz(paramaeww);
    this.c = new TreeSet(paramComparator);
    this.zg = new LinkedList();
    Bi();
  }
  
  public static aewv a(aexj paramaexj, aeww paramaeww, Comparator<aexe> paramComparator, aeyp paramaeyp, aeyk paramaeyk)
  {
    return new aexd(paramaexj, paramaeww, paramComparator, paramaeyp, paramaeyk);
  }
  
  private void a(Canvas paramCanvas, aexj paramaexj, long paramLong)
  {
    if ((this.vR != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.vR.iterator();
      while (localIterator.hasNext()) {
        ((aeyc)localIterator.next()).a(paramCanvas, paramaexj, paramLong);
      }
    }
  }
  
  public void Bi() {}
  
  public int CE()
  {
    return this.ZZ;
  }
  
  public abstract aexe a(aeyr paramaeyr);
  
  public void a(aexe paramaexe)
  {
    this.c.add(paramaexe);
  }
  
  protected void a(Canvas paramCanvas, aexe paramaexe)
  {
    aexy localaexy = this.jdField_a_of_type_Aexj.a(paramaexe);
    this.jdField_a_of_type_Aexz.a(paramCanvas, paramaexe, this.jdField_a_of_type_Aexj, localaexy);
    paramaexe.cXV();
  }
  
  public abstract void acg();
  
  public void ach()
  {
    this.zg.clear();
  }
  
  public void b(aexe paramaexe)
  {
    paramaexe.setDrawCacheDirty(true);
    paramaexe.Hz(true);
    float f = paramaexe.getPaintWidth();
    aexc.a(this.jdField_a_of_type_Aexj, paramaexe);
    paramaexe.aE((paramaexe.getPaintWidth() + paramaexe.getScreenWidth()) / (f + paramaexe.getScreenWidth()));
  }
  
  public abstract void c(aexe paramaexe);
  
  public final void c(Canvas paramCanvas, long paramLong)
  {
    d(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Aexj, paramLong);
  }
  
  public abstract void d(aexe paramaexe);
  
  public abstract void d(Canvas paramCanvas, long paramLong);
  
  public List<aexe> ev()
  {
    return this.zg;
  }
  
  public abstract void layout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewv
 * JD-Core Version:    0.7.0.1
 */