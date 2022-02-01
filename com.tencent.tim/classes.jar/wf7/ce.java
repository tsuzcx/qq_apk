package wf7;

public class ce
  implements cc
{
  private static cc gX;
  
  public static void a(cc paramcc)
  {
    gX = paramcc;
  }
  
  public static final ce aK()
  {
    return a.gY;
  }
  
  public cd H(int paramInt)
  {
    if (gX != null) {
      return gX.H(paramInt);
    }
    return new cd(paramInt, null);
  }
  
  public boolean a(int paramInt, cf paramcf)
  {
    if (gX != null) {
      return gX.a(paramInt, paramcf);
    }
    return false;
  }
  
  static abstract interface a
  {
    public static final ce gY = new ce(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ce
 * JD-Core Version:    0.7.0.1
 */