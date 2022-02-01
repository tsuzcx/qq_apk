import com.tencent.qapmsdk.QAPM;

public class tys
  extends txq
  implements txl
{
  protected void bER() {}
  
  public String oF()
  {
    return "resource";
  }
  
  public void uF(String paramString)
  {
    if (isStarted()) {
      QAPM.beginScene(paramString, QAPM.ModeResource);
    }
  }
  
  public void uG(String paramString)
  {
    if (isStarted()) {
      QAPM.endScene(paramString, QAPM.ModeResource);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tys
 * JD-Core Version:    0.7.0.1
 */