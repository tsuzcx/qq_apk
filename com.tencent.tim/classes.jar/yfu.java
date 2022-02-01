import android.graphics.RectF;

public class yfu
{
  public int Lv = 0;
  public yfu.a a;
  public yfu.b a;
  public RectF rect = new RectF();
  
  public yfu()
  {
    this.jdField_a_of_type_Yfu$b = new yfu.b(0.0D, 0.0D);
    this.jdField_a_of_type_Yfu$a = new yfu.a(0.0D, 0.0D);
  }
  
  public String toString()
  {
    return "ItemStatus{rect=" + this.rect + ", velocity=" + this.jdField_a_of_type_Yfu$b + ", acceleration=" + this.jdField_a_of_type_Yfu$a + '}';
  }
  
  public static class a
  {
    public double ax;
    public double ay;
    
    public a(double paramDouble1, double paramDouble2)
    {
      this.ax = paramDouble1;
      this.ay = paramDouble2;
    }
    
    public a(a parama)
    {
      a(parama);
    }
    
    public void a(a parama)
    {
      this.ax = parama.ax;
      this.ay = parama.ay;
    }
    
    public String toString()
    {
      return "Acceleration{ax=" + this.ax + ", ay=" + this.ay + '}';
    }
  }
  
  public static class b
  {
    public double I;
    public double J;
    
    public b(double paramDouble1, double paramDouble2)
    {
      this.I = paramDouble1;
      this.J = paramDouble2;
    }
    
    public b(b paramb)
    {
      a(paramb);
    }
    
    public void a(b paramb)
    {
      this.I = paramb.I;
      this.J = paramb.J;
    }
    
    public String toString()
    {
      return "Velocity{vx=" + this.I + ", vy=" + this.J + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfu
 * JD-Core Version:    0.7.0.1
 */