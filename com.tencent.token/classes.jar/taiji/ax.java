package taiji;

public class ax
{
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  double f;
  public int g;
  public int h;
  public int i;
  public boolean j;
  
  public int hashCode()
  {
    int k = this.a.hashCode();
    int m = this.b.hashCode();
    int n = this.c;
    int i1 = this.d;
    int i2 = this.e;
    long l = Double.doubleToLongBits(this.f);
    return (((((k * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + (int)(l ^ l >>> 32)) * 31 + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ax
 * JD-Core Version:    0.7.0.1
 */