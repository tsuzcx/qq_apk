import java.util.Map;

public class tsk
{
  private boolean cacheText;
  private final Map<String, String> stringMap;
  
  public String getText(String paramString)
  {
    return paramString;
  }
  
  public final String getTextInternal(String paramString)
  {
    Object localObject;
    if ((this.cacheText) && (this.stringMap.containsKey(paramString))) {
      localObject = (String)this.stringMap.get(paramString);
    }
    String str;
    do
    {
      return localObject;
      str = getText(paramString);
      localObject = str;
    } while (!this.cacheText);
    this.stringMap.put(paramString, str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsk
 * JD-Core Version:    0.7.0.1
 */