package btmsdkobf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class et
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = c(paramContext, paramString1);
    paramContext = localObject;
    int j;
    int i;
    if (paramString1 != null)
    {
      j = paramString1.length;
      i = 0;
    }
    for (;;)
    {
      paramContext = localObject;
      if (i < j)
      {
        paramContext = paramString1[i];
        if ("SHA1".equals(paramString2)) {
          paramContext = a(paramContext, "SHA1");
        }
      }
      else
      {
        return paramContext;
      }
      i += 1;
    }
  }
  
  public static String a(Signature paramSignature, String paramString)
  {
    paramSignature = paramSignature.toByteArray();
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      if (paramString == null) {
        return null;
      }
      paramSignature = paramString.digest(paramSignature);
      paramString = new StringBuilder();
      int j = paramSignature.length;
      int i = 0;
      while (i < j)
      {
        paramString.append(Integer.toHexString(paramSignature[i] & 0xFF | 0x100).substring(1, 3));
        i += 1;
      }
      paramSignature = paramString.toString();
      return paramSignature;
    }
    catch (NoSuchAlgorithmException paramSignature)
    {
      paramSignature.printStackTrace();
    }
    return null;
  }
  
  public static Signature[] c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.et
 * JD-Core Version:    0.7.0.1
 */