import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class awav
  extends awbd
{
  protected Statistic a;
  
  public static String t(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramObject.toString(), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramObject.toString();
  }
  
  public String Z(List<Statistic> paramList)
  {
    int i = paramList.size();
    String str = a(null, this.a);
    if (i == 0) {
      return str;
    }
    if (i == 1) {
      return a(str, (Statistic)paramList.get(0));
    }
    return l(str, paramList);
  }
  
  public String a(String paramString, Statistic paramStatistic)
  {
    Key[] arrayOfKey = paramStatistic.getKeys();
    paramStatistic = paramStatistic.getValues();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null) {
      localStringBuilder.append(paramString);
    }
    int i = 0;
    if (i < arrayOfKey.length)
    {
      if ((paramStatistic[i] != null) && (!paramStatistic[i].equals(""))) {
        if (localStringBuilder.length() != 0) {
          break label106;
        }
      }
      label106:
      for (paramString = "";; paramString = "&")
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append(arrayOfKey[i]).append("=").append(t(paramStatistic[i]));
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(Statistic paramStatistic)
  {
    this.a = paramStatistic;
  }
  
  public String l(String paramString, List<Statistic> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append("&");
        paramString = ((Statistic)paramList.get(0)).getKeys();
        localStringBuilder.append("key=");
        i = 0;
        if (i < paramString.length)
        {
          Object localObject = paramString[i].getName();
          if (i != 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append((String)localObject);
          i += 1;
          continue;
          if (i < paramString.length)
          {
            int j = 0;
            if (j >= paramList.size()) {
              break label232;
            }
            localObject = (Statistic)paramList.get(j);
            localStringBuilder.append("&").append(j + 1).append("_").append(i + 1).append("=").append(t(((Statistic)localObject).getValue(i)));
            j += 1;
            continue;
          }
          localStringBuilder.append("&count=").append(paramList.size());
          return localStringBuilder.toString();
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QZLog.e("HttpAssembler", "", paramString);
        return null;
      }
      int i = 0;
      continue;
      label232:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awav
 * JD-Core Version:    0.7.0.1
 */