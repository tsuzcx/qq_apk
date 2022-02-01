import android.support.annotation.IdRes;
import java.util.HashMap;
import java.util.Map;

public class aaha
{
  private static final Map<String, Integer> iB;
  public static int[] jf = { 2130838448, 2130838439, 2130838441, 2130838449, 2130838609, 2130842135, 2130838450, 2130838438, 2130838443, 2130838440, 2130838437, 2130838444, 2130838445, 2130838446, 2130838447 };
  
  static
  {
    iB = new HashMap();
    iB.put("m.ke.qq.com", Integer.valueOf(7));
    iB.put("ke.qq.com", Integer.valueOf(7));
    iB.put("fudao.qq.com", Integer.valueOf(9));
    iB.put("buluo.qq.com", Integer.valueOf(10));
    iB.put("m.gamecenter.qq.com", Integer.valueOf(2));
    iB.put("imgcache.qq.com", Integer.valueOf(2));
  }
  
  public static int bU(String paramString)
  {
    Integer localInteger2 = (Integer)iB.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (!ocp.eA(paramString)) {
        break label37;
      }
    }
    label37:
    for (localInteger1 = Integer.valueOf(8);; localInteger1 = Integer.valueOf(6)) {
      return localInteger1.intValue();
    }
  }
  
  @IdRes
  public static int fA(int paramInt)
  {
    return jf[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaha
 * JD-Core Version:    0.7.0.1
 */