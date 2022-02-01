public class rol
{
  public static String toString(int[] paramArrayOfInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rol
 * JD-Core Version:    0.7.0.1
 */