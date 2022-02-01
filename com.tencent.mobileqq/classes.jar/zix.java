import android.os.Process;
import android.support.annotation.NonNull;
import java.io.File;

public class zix
{
  private static int a;
  
  public static String a(int paramInt)
  {
    String str;
    if (paramInt == 1)
    {
      bhmi.c(win.e + ".nomedia");
      str = win.e + b(paramInt) + "/";
    }
    for (;;)
    {
      a(str);
      return str;
      str = antf.br + "edit_video/business_" + paramInt + "/" + b(paramInt) + "/";
      bhmi.c(str + ".nomedia");
    }
  }
  
  @NonNull
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("folderPath should not be null");
    }
    String str = paramString1;
    if (!paramString1.endsWith("/")) {
      str = paramString1 + "/";
    }
    return str + System.currentTimeMillis() + "_" + b(paramInt) + paramString2;
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      yuk.d("Q.qqstory.publish.edit.PublishFileManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      yuk.d("Q.qqstory.publish.edit.PublishFileManager", "create folder : " + bool);
    }
  }
  
  private static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("T").append(System.currentTimeMillis()).append("B").append(paramInt).append("P").append(Process.myPid()).append("T").append(Process.myTid()).append("I");
    paramInt = a;
    a = paramInt + 1;
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zix
 * JD-Core Version:    0.7.0.1
 */