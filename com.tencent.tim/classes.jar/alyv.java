public class alyv
{
  public static int g(long paramLong1, long paramLong2)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      return -1;
    }
    long l = Math.max(paramLong1, paramLong2);
    if ((l > 500L) && (l <= 960L)) {
      return 3;
    }
    if ((l > 200L) && (l <= 500L)) {
      return 2;
    }
    if (l <= 200L) {
      return 1;
    }
    if (isLongPhoto(paramLong1, paramLong2)) {
      return 0;
    }
    return 4;
  }
  
  public static boolean isLongPhoto(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 3L * paramLong2) || (paramLong2 >= 3L * paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyv
 * JD-Core Version:    0.7.0.1
 */