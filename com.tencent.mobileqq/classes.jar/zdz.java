public class zdz
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
      zdl.a("unLikeRecommendFeed failed, because recommendId=" + paramLong, new Object[0]);
      return;
    }
    zea localzea = new zea();
    localzea.jdField_b_of_type_JavaLangString = paramString;
    localzea.c = paramInt;
    localzea.jdField_b_of_type_Long = paramLong;
    localzea.d = 1;
    wfi.a().a(localzea, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdz
 * JD-Core Version:    0.7.0.1
 */