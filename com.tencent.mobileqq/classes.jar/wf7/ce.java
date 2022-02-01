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
    return ce.a.gY;
  }
  
  public cd H(int paramInt)
  {
    cc localcc = gX;
    if (localcc != null) {
      return localcc.H(paramInt);
    }
    return new cd(paramInt, null);
  }
  
  public boolean a(int paramInt, cf paramcf)
  {
    cc localcc = gX;
    if (localcc != null) {
      return localcc.a(paramInt, paramcf);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ce
 * JD-Core Version:    0.7.0.1
 */