import java.util.Hashtable;

public class arbs
  extends araz.a
{
  Hashtable<String, Boolean> z = new Hashtable();
  
  public boolean J(String paramString, boolean paramBoolean)
  {
    paramString = (Boolean)this.z.get(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return paramString.booleanValue();
  }
  
  public void dp(String paramString, boolean paramBoolean)
  {
    this.z.put(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbs
 * JD-Core Version:    0.7.0.1
 */