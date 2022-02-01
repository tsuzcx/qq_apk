package uilib.doraemon;

import java.util.Map;

public class d
{
  private final Map<String, String> a;
  private boolean b;
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public final String b(String paramString)
  {
    Object localObject;
    if ((this.b) && (this.a.containsKey(paramString))) {
      localObject = (String)this.a.get(paramString);
    }
    String str;
    do
    {
      return localObject;
      str = a(paramString);
      localObject = str;
    } while (!this.b);
    this.a.put(paramString, str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.d
 * JD-Core Version:    0.7.0.1
 */