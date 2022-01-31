package taiji;

public class bs
{
  private final float a;
  private final float b;
  
  public bs()
  {
    this(1.0F, 1.0F);
  }
  
  public bs(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public float a()
  {
    return this.a;
  }
  
  public float b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return a() + "x" + b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bs
 * JD-Core Version:    0.7.0.1
 */