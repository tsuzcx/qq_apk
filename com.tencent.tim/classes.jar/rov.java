public class rov
{
  public static String getStackTrace(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject = new RuntimeException("getStackTrace").getStackTrace();
        localStringBuilder = new StringBuilder();
        i = paramInt;
        if (localObject.length > paramInt) {
          break label69;
        }
        i = localObject.length;
      }
      catch (Exception localException)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        int i;
        return "";
      }
      if (paramInt < i)
      {
        localStringBuilder.append(localObject[paramInt].toString());
        paramInt += 1;
      }
      else
      {
        localObject = localStringBuilder.toString();
        return localObject;
        label69:
        paramInt = 2;
      }
    }
  }
  
  public static void i(String paramString, int paramInt, long paramLong)
  {
    if (paramLong <= 0L)
    {
      rom.fail("unLikeRecommendFeed failed, because recommendId=" + paramLong, new Object[0]);
      return;
    }
    row localrow = new row();
    localrow.unionId = paramString;
    localrow.nodeType = paramInt;
    localrow.recommendId = paramLong;
    localrow.operation = 1;
    ppv.a().a(localrow, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rov
 * JD-Core Version:    0.7.0.1
 */