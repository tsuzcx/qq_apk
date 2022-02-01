import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class aexy<D extends aexe>
{
  private ArrayList<aeyd> vS;
  
  private void c(Canvas paramCanvas, D paramD, aexj paramaexj, float paramFloat1, float paramFloat2)
  {
    if (this.vS != null)
    {
      Iterator localIterator = this.vS.iterator();
      while (localIterator.hasNext()) {
        ((aeyd)localIterator.next()).d(paramCanvas, paramD, paramaexj, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract aeys a(D paramD);
  
  public final void a(Canvas paramCanvas, D paramD, aexj paramaexj, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramaexj, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramaexj, paramFloat1, paramFloat2);
  }
  
  public abstract void b(Canvas paramCanvas, D paramD, aexj paramaexj, float paramFloat1, float paramFloat2);
  
  public abstract boolean b(aexe paramaexe);
  
  public void destroy() {}
  
  public void l(D paramD) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexy
 * JD-Core Version:    0.7.0.1
 */