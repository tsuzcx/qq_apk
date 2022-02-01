public class tww
{
  private int n;
  private float sum;
  
  public void add(float paramFloat)
  {
    this.sum += paramFloat;
    this.n += 1;
    if (this.n == 2147483647)
    {
      this.sum /= 2.0F;
      this.n /= 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tww
 * JD-Core Version:    0.7.0.1
 */