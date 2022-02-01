public class vym
{
  public static double a(int[] paramArrayOfInt)
  {
    int j = 0;
    double d2 = 0.0D;
    int k = paramArrayOfInt.length;
    double d1 = 0.0D;
    int i = 0;
    while (i < k)
    {
      d1 += paramArrayOfInt[i];
      i += 1;
    }
    double d3 = d1 / k;
    i = j;
    d1 = d2;
    while (i < k)
    {
      d1 += (paramArrayOfInt[i] - d3) * (paramArrayOfInt[i] - d3);
      i += 1;
    }
    return d1 / k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vym
 * JD-Core Version:    0.7.0.1
 */