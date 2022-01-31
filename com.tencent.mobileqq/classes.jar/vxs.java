import android.support.annotation.NonNull;
import android.text.TextUtils;

public class vxs
{
  public static <T> T a(T paramT)
  {
    if (paramT == null) {
      veg.e("Q.qqstory.AssertUtils", "checkNotNull failed:" + a(2));
    }
    return paramT;
  }
  
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
          break label87;
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
        localStringBuilder.append("\n" + localObject[paramInt].toString());
        paramInt += 1;
      }
      else
      {
        localObject = localStringBuilder.toString();
        return localObject;
        label87:
        paramInt = 2;
      }
    }
  }
  
  public static void a() {}
  
  public static <T> void a(T paramT)
  {
    if (paramT == null)
    {
      paramT = vzj.a("StoryAssertUtils Exception!");
      axps.a(paramT, "StoryAssertUtils assertNotNull_DEBUG()");
      veg.c("Q.qqstory.AssertUtils", "assertNotNull_DEBUG failed: ", paramT);
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return;
    }
    veg.e("Q.qqstory.AssertUtils", "checkNotEmpty failed :" + a(2));
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      veg.e("Q.qqstory.AssertUtils", paramString);
      return;
      paramString = String.format(paramString, paramVarArgs);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      veg.e("Q.qqstory.AssertUtils", "assertTrue failed:" + a(4));
    }
  }
  
  public static void a(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    veg.e("Q.qqstory.AssertUtils", paramString);
  }
  
  public static void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxs
 * JD-Core Version:    0.7.0.1
 */