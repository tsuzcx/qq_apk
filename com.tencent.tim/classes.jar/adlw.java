import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class adlw
{
  private adlw.a a;
  private int cIK = 1;
  private SparseArray<adlt> co = new SparseArray();
  private Animator.AnimatorListener e = new adlx(this);
  
  private void Ln(int paramInt)
  {
    if (this.co.get(paramInt) != null) {
      ((adlt)this.co.get(paramInt)).stop();
    }
  }
  
  private void hA(int paramInt1, int paramInt2)
  {
    adlt localadlt1 = (adlt)this.co.get(paramInt1);
    adlt localadlt2 = (adlt)this.co.get(paramInt2);
    localadlt1.b(false, null);
    localadlt2.b(true, this.e);
  }
  
  public void a(int paramInt, adlt paramadlt)
  {
    this.co.put(paramInt, paramadlt);
  }
  
  public void a(int paramInt, adlw.a parama)
  {
    if (this.cIK == paramInt) {
      return;
    }
    this.a = parama;
    hA(this.cIK, paramInt);
    this.cIK = paramInt;
  }
  
  public void doDestroy()
  {
    stopAnimation();
    this.co.clear();
    this.a = null;
  }
  
  public void stopAnimation()
  {
    int i = 1;
    while (i <= 3)
    {
      Ln(i);
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlw
 * JD-Core Version:    0.7.0.1
 */