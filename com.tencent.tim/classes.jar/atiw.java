import android.view.View;

public class atiw
{
  private atiw.a a;
  private int dOe;
  private int dOf;
  private int dOg;
  private int dOh;
  private boolean isVisible = true;
  
  public atiw(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dOe = paramInt1;
    this.dOf = paramInt2;
    this.dOg = paramInt3;
    this.dOh = paramInt4;
  }
  
  public int KA()
  {
    return this.dOe;
  }
  
  public int KB()
  {
    return this.dOg;
  }
  
  public int KC()
  {
    return this.dOh;
  }
  
  public atiw.a a()
  {
    return this.a;
  }
  
  public void a(atiw.a parama)
  {
    this.a = parama;
  }
  
  public int hF()
  {
    return this.dOf;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, Object paramObject, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atiw
 * JD-Core Version:    0.7.0.1
 */