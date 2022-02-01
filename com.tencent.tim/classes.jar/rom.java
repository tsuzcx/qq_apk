import android.support.annotation.NonNull;
import android.text.TextUtils;

public class rom
{
  public static <T> void ap(T paramT)
  {
    if (paramT == null)
    {
      paramT = rpl.a.a("StoryAssertUtils Exception!");
      annt.e(paramT, "StoryAssertUtils assertNotNull_DEBUG()");
      ram.e("Q.qqstory.AssertUtils", "assertNotNull_DEBUG failed: ", paramT);
    }
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      ram.e("Q.qqstory.AssertUtils", "assertTrue failed:" + getStackTrace(4));
    }
  }
  
  public static void assertTrue(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    ram.e("Q.qqstory.AssertUtils", paramString);
  }
  
  public static void bvK() {}
  
  public static void bvL() {}
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      ram.e("Q.qqstory.AssertUtils", "checkNotNull failed:" + getStackTrace(2));
    }
    return paramT;
  }
  
  public static void fail(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      ram.e("Q.qqstory.AssertUtils", paramString);
      return;
      paramString = String.format(paramString, paramVarArgs);
    }
  }
  
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
  
  public static void sF(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return;
    }
    ram.e("Q.qqstory.AssertUtils", "checkNotEmpty failed :" + getStackTrace(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rom
 * JD-Core Version:    0.7.0.1
 */