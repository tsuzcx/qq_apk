public class xmv
{
  public static String a(int paramInt)
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
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    if (paramLong <= 0L)
    {
      xmh.a("unLikeRecommendFeed failed, because recommendId=" + paramLong, new Object[0]);
      return;
    }
    xmw localxmw = new xmw();
    localxmw.jdField_b_of_type_JavaLangString = paramString;
    localxmw.c = paramInt;
    localxmw.jdField_b_of_type_Long = paramLong;
    localxmw.d = 1;
    ung.a().a(localxmw, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xmv
 * JD-Core Version:    0.7.0.1
 */