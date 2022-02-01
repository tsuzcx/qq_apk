import android.os.Process;
import android.support.annotation.NonNull;
import java.io.File;

public class rlc
{
  private static int bsW;
  
  public static String ce(int paramInt)
  {
    String str;
    if (paramInt == 1)
    {
      aqhq.UD(plr.atc + ".nomedia");
      str = plr.atc + cf(paramInt) + "/";
    }
    for (;;)
    {
      rp(str);
      return str;
      str = acbn.bmi + "edit_video/business_" + paramInt + "/" + cf(paramInt) + "/";
      aqhq.UD(str + ".nomedia");
    }
  }
  
  private static String cf(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("T").append(System.currentTimeMillis()).append("B").append(paramInt).append("P").append(Process.myPid()).append("T").append(Process.myTid()).append("I");
    paramInt = bsW;
    bsW = paramInt + 1;
    return paramInt;
  }
  
  @NonNull
  public static String f(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("folderPath should not be null");
    }
    String str = paramString1;
    if (!paramString1.endsWith("/")) {
      str = paramString1 + "/";
    }
    return str + System.currentTimeMillis() + "_" + cf(paramInt) + paramString2;
  }
  
  private static void rp(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      ram.w("Q.qqstory.publish.edit.PublishFileManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      ram.w("Q.qqstory.publish.edit.PublishFileManager", "create folder : " + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlc
 * JD-Core Version:    0.7.0.1
 */