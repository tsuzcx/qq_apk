import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@TargetApi(14)
public class wgw
{
  protected static wew<String, wgx> a = new wew(200);
  
  public static File a(String paramString, int paramInt)
  {
    Object localObject2 = null;
    QQStoryContext.a();
    paramString = zjb.a(QQStoryContext.a(), paramString);
    if ((paramString instanceof MessageForShortVideo)) {}
    for (paramString = (MessageForShortVideo)paramString;; paramString = null)
    {
      Object localObject1 = localObject2;
      if (paramString != null)
      {
        if (paramInt != 0) {
          break label74;
        }
        paramString = ShortVideoUtils.a(paramString, "mp4");
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new File(paramString);
          localObject1 = localObject2;
          if (paramString.exists()) {
            localObject1 = paramString;
          }
        }
        return localObject1;
        label74:
        if (paramInt == 2) {
          paramString = ShortVideoUtils.a(paramString.thumbMD5, "jpg");
        } else {
          paramString = null;
        }
      }
    }
  }
  
  public static File a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StoryVideoItem localStoryVideoItem = ((wpj)wpm.a(5)).a(paramString);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine())) {}
    for (Object localObject = a(paramString, localStoryVideoItem.mCreateTime, paramInt, false, paramBoolean2);; localObject = a(paramString, paramInt, false, paramBoolean2))
    {
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        break;
      }
      if (localStoryVideoItem != null) {
        a(localStoryVideoItem, (String)localObject, paramInt);
      }
      return localFile;
    }
    if (localStoryVideoItem != null) {
      switch (paramInt)
      {
      }
    }
    while ((zjb.a(paramString)) && (a(paramString, paramInt) != null))
    {
      return a(paramString, paramInt);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath))
      {
        localObject = new File(localStoryVideoItem.mLocalVideoPath);
        if (((File)localObject).exists())
        {
          return localObject;
          if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath))
          {
            localObject = new File(localStoryVideoItem.mVideoLocalThumbnailPath);
            if (((File)localObject).exists())
            {
              return localObject;
              if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath))
              {
                localObject = new File(localStoryVideoItem.mLocalMaskPath);
                if (((File)localObject).exists()) {
                  return localObject;
                }
              }
            }
          }
        }
      }
    }
    if (paramBoolean1)
    {
      if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine())) {}
      for (paramString = a(paramString, localStoryVideoItem.mCreateTime, paramInt, true, paramBoolean2);; paramString = a(paramString, paramInt, true, paramBoolean2)) {
        return new File(paramString);
      }
    }
    return null;
  }
  
  protected static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return ".file";
    case 0: 
      return ".mp4";
    case 3: 
      return ".png";
    case 2: 
      return "thumb.jpeg";
    case 1: 
      return "mask.png";
    }
    return "at.png";
  }
  
  public static String a(File paramFile)
  {
    if (paramFile.exists())
    {
      String str3 = paramFile.getParentFile().getAbsolutePath();
      String str2 = paramFile.getName();
      String str1;
      if (str2.endsWith(".tmp")) {
        str1 = str2.substring(0, str2.length() - ".tmp".length());
      }
      for (;;)
      {
        str1 = str3 + "/" + str1;
        paramFile.renameTo(new File(str1));
        return str1;
        str1 = str2;
        if (str2.endsWith(".stmp")) {
          str1 = str2.substring(0, str2.length() - ".stmp".length());
        }
      }
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return wes.h + a(paramString, false, 0L) + "/" + b(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public static String a(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (zjb.a(paramString)) {}
    for (String str = wes.h;; str = wes.i) {
      return str + a(paramString, true, paramLong) + "/" + b(paramString, paramLong, paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public static String a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (zjb.a(paramString)) {
      localObject = StoryVideoItem.getCacheKey(paramString);
    }
    String str;
    do
    {
      return localObject;
      if (paramBoolean) {
        return String.valueOf(paramLong);
      }
      str = b(paramString);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    Object localObject = a(paramString);
    a(paramString, (String)localObject);
    return localObject;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    a(paramStoryVideoItem, paramString, paramInt, "");
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, String paramString1, int paramInt, String paramString2)
  {
    wpj localwpj = (wpj)wpm.a(5);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.equals(paramStoryVideoItem.mLocalVideoPath, paramString1));
        paramStoryVideoItem.mLocalVideoPath = paramString1;
        if (!TextUtils.isEmpty(paramString2)) {
          paramStoryVideoItem.mDownloadNetType = paramString2;
        }
        localwpj.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
        return;
      } while (TextUtils.equals(paramStoryVideoItem.mVideoLocalThumbnailPath, paramString1));
      paramStoryVideoItem.mVideoLocalThumbnailPath = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramStoryVideoItem.mDownloadNetType = paramString2;
      }
      localwpj.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
      return;
    } while (TextUtils.equals(paramStoryVideoItem.mLocalMaskPath, paramString1));
    paramStoryVideoItem.mLocalMaskPath = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      paramStoryVideoItem.mDownloadNetType = paramString2;
    }
    localwpj.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    wgx localwgx = new wgx();
    localwgx.a = paramString2;
    a.a(paramString1, localwgx);
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {}
    while ((paramFile.getName().endsWith(".tmp")) || (paramFile.getName().endsWith(".stmp"))) {
      return false;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    paramString = (wgx)a.a(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return null;
  }
  
  public static String b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = a(paramInt);
    if (TextUtils.isEmpty(str)) {}
    for (paramString = a(paramString, false, 0L);; paramString = a(paramString, false, 0L) + str)
    {
      str = paramString;
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          break;
        }
        str = paramString + ".stmp";
      }
      return str;
    }
    return paramString + ".tmp";
  }
  
  public static String b(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = a(paramInt);
    String str1 = a(paramString, true, paramLong);
    paramString = str1;
    if (!TextUtils.isEmpty(str2)) {
      paramString = str1 + str2;
    }
    str1 = paramString;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        str1 = paramString + ".stmp";
      }
    }
    else {
      return str1;
    }
    return paramString + ".tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgw
 * JD-Core Version:    0.7.0.1
 */