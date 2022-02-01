import android.text.TextUtils;
import com.tencent.mobileqq.fts.FTSDatabase;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ahqo
{
  public static ArrayList<String> K(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String lp(String paramString)
  {
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder(64);
        ahqj localahqj = new ahqj(new StringReader(paramString), paramString.length());
        paramString = null;
        try
        {
          localahqg = localahqj.a();
          if (localahqg != null) {
            continue;
          }
          if ((paramString != null) && (TextUtils.equals(paramString.type(), "double")) && (!TextUtils.isEmpty(paramString.wu())))
          {
            localStringBuilder.append(paramString.wu().charAt(paramString.wu().length() - 1));
            localStringBuilder.append("*");
          }
        }
        catch (IOException paramString)
        {
          ahqg localahqg;
          paramString.printStackTrace();
          FTSDatabase.a().b("SegmentUtils", "e", "tokenSegment: failure", paramString);
          continue;
        }
        paramString = localStringBuilder.toString();
        return paramString;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        paramString.printStackTrace();
        FTSDatabase.a().b("SegmentUtils", "e", "tokenSegment: failure", paramString);
      }
      if ((paramString != null) && (TextUtils.equals(paramString.type(), "double")) && ((!TextUtils.equals(localahqg.type(), "double")) || (paramString.Fg() < localahqg.Ff())) && (!TextUtils.isEmpty(paramString.wu())))
      {
        localStringBuilder.append(paramString.wu().charAt(paramString.wu().length() - 1));
        localStringBuilder.append("*");
        localStringBuilder.append(' ');
      }
      if ((!TextUtils.isEmpty(localahqg.wu())) && ((!TextUtils.equals(localahqg.type(), "double")) || (localahqg.wu().length() != 1)))
      {
        localStringBuilder.append(localahqg.wu());
        localStringBuilder.append(' ');
      }
      paramString = localahqg;
    }
    return null;
  }
  
  public static String[] o(String paramString)
  {
    int j = 0;
    Object localObject = K(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = lp((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public static String[] p(String paramString)
  {
    Object localObject2 = o(paramString);
    FTSDatabase.a().log("SegmentUtils", "i", "query segments = " + Arrays.toString((Object[])localObject2));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label223;
      }
      localObject1 = new String[1];
      localObject1[0] = paramString;
    }
    paramString = new String[localObject1.length];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2 = new StringBuilder(64);
      String[] arrayOfString = localObject1[i].split(" ");
      int j = 0;
      if (j < arrayOfString.length)
      {
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(" ");
        }
        if ((arrayOfString[j].length() == 1) || ((arrayOfString[j].charAt(0) >= '0') && (arrayOfString[j].charAt(0) <= '9')) || ((arrayOfString[j].charAt(0) >= 'a') && (arrayOfString[j].charAt(0) <= 'z')))
        {
          ((StringBuilder)localObject2).append(arrayOfString[j]);
          ((StringBuilder)localObject2).append("*");
        }
        for (;;)
        {
          j += 1;
          break;
          label223:
          return null;
          ((StringBuilder)localObject2).append(arrayOfString[j]);
        }
      }
      paramString[i] = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqo
 * JD-Core Version:    0.7.0.1
 */