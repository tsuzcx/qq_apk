import java.util.HashMap;
import java.util.Map;

public class amxj
{
  private static String ccs = "";
  private static int dDU;
  private static Map<Integer, Integer> nb = new HashMap();
  
  public static void UD(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      try
      {
        dDU += 1;
        ccs = ccs + paramInt + "|";
        nb.put(Integer.valueOf(paramInt), Integer.valueOf(dDU));
      }
      finally {}
    }
  }
  
  public static void dOC()
  {
    try
    {
      ccs = "";
      dDU = 0;
      nb.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int jj(int paramInt)
  {
    Integer localInteger = (Integer)nb.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static String zq()
  {
    return ccs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxj
 * JD-Core Version:    0.7.0.1
 */