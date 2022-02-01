public class ayki
{
  public aykf a;
  public int bre;
  public int brf;
  
  private ayki(ayki.a parama)
  {
    this.a = ayki.a.a(parama);
    this.bre = ayki.a.a(parama);
    this.brf = ayki.a.b(parama);
  }
  
  public String toString()
  {
    return "DoodleConfig{doodleStrategy=" + this.a + ", maxBitmapWidth=" + this.bre + ", maxBitmapHeight=" + this.brf + '}';
  }
  
  public static class a
  {
    private aykf b = new ayke();
    private int bre;
    private int brf;
    
    public a a(int paramInt)
    {
      if (paramInt > 0) {
        this.bre = paramInt;
      }
      return this;
    }
    
    public a a(aykf paramaykf)
    {
      if (paramaykf != null) {
        this.b = paramaykf;
      }
      return this;
    }
    
    public ayki a()
    {
      return new ayki(this, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayki
 * JD-Core Version:    0.7.0.1
 */