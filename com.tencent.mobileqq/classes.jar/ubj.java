public class ubj
{
  public static String a(int paramInt)
  {
    int i = paramInt / 1000 / 60;
    paramInt = paramInt / 1000 % 60;
    if (i < 10) {}
    for (String str = "0" + i; paramInt < 10; str = String.valueOf(i)) {
      return String.format("%s:0%s", new Object[] { str, Integer.valueOf(paramInt) });
    }
    return String.format("%s:%s", new Object[] { str, Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubj
 * JD-Core Version:    0.7.0.1
 */