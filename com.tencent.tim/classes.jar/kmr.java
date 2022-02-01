import java.util.HashMap;

public class kmr
{
  private static HashMap<Integer, Integer> dn = new HashMap();
  
  static
  {
    dn.put(Integer.valueOf(1105), Integer.valueOf(4));
    dn.put(Integer.valueOf(1106), Integer.valueOf(3));
    dn.put(Integer.valueOf(1107), Integer.valueOf(4));
    dn.put(Integer.valueOf(1103), Integer.valueOf(101));
    dn.put(Integer.valueOf(1104), Integer.valueOf(102));
    dn.put(Integer.valueOf(1108), Integer.valueOf(103));
    dn.put(Integer.valueOf(1109), Integer.valueOf(104));
  }
  
  public static int cW(int paramInt)
  {
    if (dn.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)dn.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmr
 * JD-Core Version:    0.7.0.1
 */