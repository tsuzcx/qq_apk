import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class tjw
{
  private static ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  
  @Nullable
  public static tnc a(String paramString, List<tnc> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tnc localtnc = (tnc)paramList.next();
      if (paramString.equals(localtnc.a)) {
        return localtnc;
      }
    }
    return null;
  }
  
  public static void a(@NonNull List<String> paramList, boolean paramBoolean)
  {
    ved.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "send request : %s", paramList.toString());
    if (paramBoolean)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)a.get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 60000L))
        {
          ((Iterator)localObject).remove();
          ved.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "remove same request for feed info:%s", str);
        }
        else
        {
          a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    ved.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "request for feed info:%s", paramList);
    Object localObject = new tnb(paramList);
    syo.a().a((sys)localObject, new tjx(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjw
 * JD-Core Version:    0.7.0.1
 */