public class vyd
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
      vxp.a("unLikeRecommendFeed failed, because recommendId=" + paramLong, new Object[0]);
      return;
    }
    vye localvye = new vye();
    localvye.jdField_b_of_type_JavaLangString = paramString;
    localvye.c = paramInt;
    localvye.jdField_b_of_type_Long = paramLong;
    localvye.d = 1;
    syo.a().a(localvye, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyd
 * JD-Core Version:    0.7.0.1
 */