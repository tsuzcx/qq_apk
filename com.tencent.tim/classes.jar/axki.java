import java.util.HashMap;

public class axki
{
  private HashMap<String, axkn> rh = new HashMap();
  
  public axkn a(String paramString)
  {
    return (axkn)this.rh.get(paramString);
  }
  
  public void a(String paramString, axkn paramaxkn)
  {
    this.rh.put(paramString, paramaxkn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axki
 * JD-Core Version:    0.7.0.1
 */