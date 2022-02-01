import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pxn
{
  private static ConcurrentHashMap<String, Long> ca = new ConcurrentHashMap();
  
  public static void B(@NonNull List<String> paramList, boolean paramBoolean)
  {
    ram.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "send request : %s", paramList.toString());
    if (paramBoolean)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)ca.get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 60000L))
        {
          ((Iterator)localObject).remove();
          ram.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "remove same request for feed info:%s", str);
        }
        else
        {
          ca.put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    ram.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "request for feed info:%s", paramList);
    Object localObject = new pzi(paramList);
    ppv.a().a((ppw)localObject, new pxo(paramList));
  }
  
  @Nullable
  public static pzi.a a(String paramString, List<pzi.a> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pzi.a locala = (pzi.a)paramList.next();
      if (paramString.equals(locala.vid)) {
        return locala;
      }
    }
    return null;
  }
  
  public static class a
    extends plt
  {
    public List<String> mS;
    public List<pzi.a> mT;
    
    public String toString()
    {
      return "GetStoryPlayerTagInfoEvent{requestVidList=" + this.mS + ", tagVidList=" + this.mT + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxn
 * JD-Core Version:    0.7.0.1
 */