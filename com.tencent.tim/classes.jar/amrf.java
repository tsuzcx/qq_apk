public class amrf
{
  public static final int[] ne = { 1, 2, 3, 4 };
  public static final int[] nf = { 6 };
  public static final int[] ng = { 7 };
  
  public static int jh(int paramInt)
  {
    int k = 0;
    int[] arrayOfInt = ne;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
      {
        i = 1;
        return i;
      }
      i += 1;
    }
    arrayOfInt = nf;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return 2;
      }
      i += 1;
    }
    arrayOfInt = ng;
    int m = arrayOfInt.length;
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (arrayOfInt[j] == paramInt) {
        return 3;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrf
 * JD-Core Version:    0.7.0.1
 */