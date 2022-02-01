public abstract class awwo
{
  public static awwo a(int paramInt)
  {
    if (paramInt > 0) {
      return new awwo.a();
    }
    return new awwo.b();
  }
  
  public abstract int lA(int paramInt);
  
  public abstract boolean nZ(int paramInt);
  
  public static class a
    extends awwo
  {
    public int lA(int paramInt)
    {
      return paramInt;
    }
    
    public boolean nZ(int paramInt)
    {
      return paramInt > 0;
    }
  }
  
  public static class b
    extends awwo
  {
    public int lA(int paramInt)
    {
      return paramInt * -1;
    }
    
    public boolean nZ(int paramInt)
    {
      return paramInt < 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwo
 * JD-Core Version:    0.7.0.1
 */