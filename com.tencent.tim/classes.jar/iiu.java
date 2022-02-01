import java.util.HashMap;

public class iiu
{
  public int amG;
  protected HashMap<String, Integer> cB;
  
  public static int a(iiu paramiiu, String paramString)
  {
    if (paramiiu == null) {}
    while ((paramiiu.cB == null) || (!paramiiu.cB.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramiiu.cB.get(paramString)).intValue();
  }
  
  public static void a(iiu paramiiu, String paramString, int paramInt)
  {
    if (paramiiu == null) {
      return;
    }
    if (paramiiu.cB == null) {
      paramiiu.cB = new HashMap();
    }
    paramiiu.cB.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iiu
 * JD-Core Version:    0.7.0.1
 */