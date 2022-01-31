public class xqp
{
  public static String a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfInt[0]);
    int i = 1;
    while (i < paramArrayOfInt.length)
    {
      localStringBuilder.append(",");
      localStringBuilder.append(paramArrayOfInt[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqp
 * JD-Core Version:    0.7.0.1
 */