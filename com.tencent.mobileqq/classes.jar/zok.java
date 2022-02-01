public class zok
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
      znw.a("unLikeRecommendFeed failed, because recommendId=" + paramLong, new Object[0]);
      return;
    }
    zol localzol = new zol();
    localzol.jdField_b_of_type_JavaLangString = paramString;
    localzol.c = paramInt;
    localzol.jdField_b_of_type_Long = paramLong;
    localzol.d = 1;
    wow.a().a(localzol, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zok
 * JD-Core Version:    0.7.0.1
 */