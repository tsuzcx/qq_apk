import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ift
{
  static final char[] g = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String F(String paramString1, String paramString2)
  {
    return paramString1 + "{@}" + paramString2;
  }
  
  public static String MD5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = byteArrayToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError();
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError();
    }
    catch (Throwable paramString)
    {
      throw new AssertionError();
    }
  }
  
  static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = g[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = g[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String d(String paramString1, String paramString2, long paramLong)
  {
    return paramString1 + "[@]" + paramString2 + "[id:]" + paramLong;
  }
  
  @TargetApi(8)
  public static File getExternalCacheDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      return paramContext.getExternalCacheDir();
    }
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  @TargetApi(9)
  public static boolean isExternalStorageRemovable()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ift
 * JD-Core Version:    0.7.0.1
 */