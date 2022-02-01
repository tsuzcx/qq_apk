public class rgj
{
  public rgh a;
  public int bre;
  public int brf;
  
  private rgj(rgj.a parama)
  {
    this.a = rgj.a.a(parama);
    this.bre = rgj.a.a(parama);
    this.brf = rgj.a.b(parama);
  }
  
  public String toString()
  {
    return "DoodleConfig{doodleStrategy=" + this.a + ", maxBitmapWidth=" + this.bre + ", maxBitmapHeight=" + this.brf + '}';
  }
  
  public static class a
  {
    private rgh b = new rgg();
    private int bre;
    private int brf;
    
    public a a(int paramInt)
    {
      if (paramInt > 0) {
        this.bre = paramInt;
      }
      return this;
    }
    
    public a a(rgh paramrgh)
    {
      if (paramrgh != null) {
        this.b = paramrgh;
      }
      return this;
    }
    
    public rgj a()
    {
      return new rgj(this, null);
    }
    
    public a b(int paramInt)
    {
      if (paramInt > 0) {
        this.brf = paramInt;
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgj
 * JD-Core Version:    0.7.0.1
 */