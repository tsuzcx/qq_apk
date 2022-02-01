import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class apmu
{
  private static final Map<Integer, Integer> nK = new HashMap(32);
  
  static
  {
    put(5, 6);
    put(12, 13);
    put(13, 14);
    put(17, 17);
    put(10, 11);
    put(18, 18);
    put(19, 19);
    put(21, 21);
    put(22, 22);
    put(24, 23);
    put(25, 24);
    put(27, 26);
    put(4, 5);
    put(3, 4);
    put(2, 3);
    put(9, 10);
    put(6, 7);
    put(20, 20);
    put(16, 100);
    put(31, 102);
    put(11, 102);
    put(23, 101);
  }
  
  public static int jJ(int paramInt)
  {
    Iterator localIterator = nK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return ((Integer)localEntry.getKey()).intValue();
      }
    }
    return 0;
  }
  
  public static int jK(int paramInt)
  {
    Integer localInteger = (Integer)nK.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return -1;
  }
  
  private static void put(int paramInt1, int paramInt2)
  {
    if ((nK.containsKey(Integer.valueOf(paramInt1))) && (QLog.isColorLevel())) {
      QLog.d("Navigate.Constants", 2, "NavConstants.put the repeat key!, key = " + paramInt1 + ", val = " + paramInt2);
    }
    nK.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmu
 * JD-Core Version:    0.7.0.1
 */