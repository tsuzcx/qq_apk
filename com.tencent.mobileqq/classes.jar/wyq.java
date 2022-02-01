import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class wyq
{
  public static <K, V, T extends V> T a(@NonNull Map<K, V> paramMap, K paramK, T paramT)
  {
    Object localObject = paramMap.get(paramK);
    if ((localObject != null) || (paramMap.containsKey(paramK))) {
      paramT = localObject;
    }
    return paramT;
  }
  
  public static String a(String paramString)
  {
    return AppConstants.SDCARD_FILE_SAVE_TMP_PATH + AbsDownloader.getFileName(paramString);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = null;
    int i = 1;
    String[] arrayOfString = paramString.split("&");
    int k = arrayOfString.length;
    int j = 0;
    paramString = str1;
    if (j < k)
    {
      str1 = arrayOfString[j];
      String str2 = str1.split("=")[0];
      if ((str2.equals("src_type")) || (str2.equals("version")) || (str2.equals("type")) || (str2.equals("actionnamekey")) || (str2.equals("storysharefrom")) || ((paramBoolean) && (str2.equals("videoId"))) || ((paramBoolean) && (str2.equals("videoOwnerUin"))) || ((paramBoolean) && (str2.equals("unionid"))))
      {
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append(str1);
          j += 1;
          break;
          localStringBuilder.append('&');
        }
      }
      str1 = paramString;
      if (QLog.isColorLevel())
      {
        if (paramString != null) {
          break label216;
        }
        paramString = new StringBuilder();
      }
      for (;;)
      {
        paramString.append(str2);
        str1 = paramString;
        paramString = str1;
        break;
        label216:
        paramString.append('|');
      }
    }
    if ((paramString != null) && (QLog.isColorLevel())) {
      QLog.d("ShareUtil", 2, "remove params:" + paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      arrayOfString = paramString.split("\\?");
    } while (arrayOfString.length != 2);
    paramString = arrayOfString[0];
    String[] arrayOfString = arrayOfString[1].split("&");
    StringBuilder localStringBuilder = new StringBuilder("?");
    int i = 0;
    if (i < arrayOfString.length)
    {
      Object localObject = arrayOfString[i].split("=");
      if (localObject.length != 2) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = localObject[0];
        if ("s".equals(localObject)) {
          arrayOfString[i] = ((String)localObject + "=" + "140");
        }
        localStringBuilder.append(arrayOfString[i]);
        if (i + 1 < arrayOfString.length) {
          localStringBuilder.append("&");
        }
      }
    }
    return paramString + localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyq
 * JD-Core Version:    0.7.0.1
 */