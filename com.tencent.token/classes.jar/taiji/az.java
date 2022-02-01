package taiji;

public class az
{
  private final float a;
  private final float b;
  
  public az()
  {
    this(1.0F, 1.0F);
  }
  
  public az(float paramFloat1, float paramFloat2)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("x");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.az
 * JD-Core Version:    0.7.0.1
 */