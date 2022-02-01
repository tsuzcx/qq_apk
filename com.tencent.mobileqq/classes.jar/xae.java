import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class xae
{
  private static ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  
  @Nullable
  public static xdk a(String paramString, List<xdk> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      xdk localxdk = (xdk)paramList.next();
      if (paramString.equals(localxdk.a)) {
        return localxdk;
      }
    }
    return null;
  }
  
  public static void a(@NonNull List<String> paramList, boolean paramBoolean)
  {
    yuk.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "send request : %s", paramList.toString());
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
          yuk.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "remove same request for feed info:%s", str);
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
    yuk.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "request for feed info:%s", paramList);
    Object localObject = new xdj(paramList);
    wow.a().a((wpa)localObject, new xaf(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xae
 * JD-Core Version:    0.7.0.1
 */