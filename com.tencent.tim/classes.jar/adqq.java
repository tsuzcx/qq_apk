import java.util.HashMap;

public class adqq
{
  private static HashMap<String, adqq.a> jE = new HashMap();
  
  public static void GC(String paramString)
  {
    if (paramString != null) {
      jE.remove(paramString);
    }
  }
  
  public static Object a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    paramString = (adqq.a)jE.get(paramString);
    if (paramString != null) {
      paramObject2 = paramString.c(paramInt, paramObject1);
    }
    return paramObject2;
  }
  
  public static void a(String paramString, adqq.a parama)
  {
    if (paramString != null) {
      jE.put(paramString, parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract Object c(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqq
 * JD-Core Version:    0.7.0.1
 */