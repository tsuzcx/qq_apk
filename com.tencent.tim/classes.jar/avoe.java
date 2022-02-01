import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import java.util.HashMap;
import java.util.Map;

public final class avoe
{
  private static Map<String, String> aI = new HashMap();
  
  static
  {
    aI.put("qqreaderMan", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?isV2=1");
    aI.put("qqreaderWoman", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?isV2=1");
    aI.put("qqreaderPublish", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?isV2=1");
    aI.put("qqreaderBookShelfIndex", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_index.html");
    aI.put("qqreaderBookShelfBookList", "https://cdn.vip.qq.com/club/client/read/6/rel/man.html");
    aI.put("qqreaderBookShelfFm", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_fm.html");
    aI.put("qqreaderBookShelfFollow", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_follow.html");
    aI.put("qqreaderBookShelfDelete", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_delete.html");
    aI.put("qqreaderTribe", "https://cdn.vip.qq.com/club/client/read/6/rel/tribe.html");
    aI.put("qqreaderSearchResult", "https://cdn.vip.qq.com/club/client/read/6/rel/new_search.html");
    aI.put("qqreaderAccount", "https://cdn.vip.qq.com/club/client/read/6/rel/mine_index.html");
    aI.put("qqreaderAppdown", "https://cdn.vip.qq.com/club/client/read/6/rel/appdown.html");
    aI.put("qqreaderInteract", "https://cdn.vip.qq.com/club/client/read/6/rel/interact.html");
    aI.put("qqreaderComment", "https://cdn.vip.qq.com/club/client/read/6/rel/comment.html");
    aI.put("qqreaderReadover", "https://cdn.vip.qq.com/club/client/read/6/rel/readover.html");
    aI.put("qqreaderBookFont", "https://cdn.vip.qq.com/club/client/read/6/rel/bookFont.html");
    aI.put("qqreaderBookDetails", "https://cdn.vip.qq.com/club/client/read/6/rel/bookDetails.html");
    aI.put("qqreaderOffShelf", "https://cdn.vip.qq.com/club/client/read/6/rel/book_offShelf.html");
    aI.put("qqreaderBookOutDetail", "https://cdn.vip.qq.com/club/client/read/6/rel/book_outDetail.html");
    aI.put("qqreaderQQMoreState", "https://cdn.vip.qq.com/club/client/read/6/rel/userstate.html");
  }
  
  public static String au(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        String str = paramString;
        if (QRDebugEnvUrlUtils.isDebugEnv()) {
          str = QRDebugEnvUrlUtils.getTestUrl(paramString);
        }
        return str;
      }
    }
    for (paramString = d(paramString, false);; paramString = d("index.html", false)) {
      return paramString;
    }
  }
  
  public static String av(String paramString)
  {
    return d(paramString, true);
  }
  
  private static String aw(String paramString)
  {
    String str2 = null;
    String str1;
    if ((avmw.pZ != null) && (avmw.pZ.size() > 0)) {
      str1 = (String)avmw.pZ.get(paramString);
    }
    for (;;)
    {
      avoc.i("ReaderUrlHelper", "getUrl = " + str1);
      return str1;
      if (avmw.pZ != null) {
        str2 = (String)avmw.pZ.get(paramString);
      }
      str1 = str2;
      if (str2 == null) {
        str1 = (String)aI.get(paramString);
      }
    }
  }
  
  public static String d(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = aw(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "https://cdn.vip.qq.com/club/client/read/6/rel/index.html";
      }
      localObject = new StringBuilder().append(paramString);
      if (!paramString.contains("?")) {
        break label170;
      }
    }
    label170:
    for (paramString = "&";; paramString = "?")
    {
      paramString = paramString;
      localObject = paramString + "_bid=2036&refer=qqreader";
      paramString = (String)localObject;
      if (!((String)localObject).contains("&ChannelID=")) {
        paramString = (String)localObject + "&ChannelID=" + avoh.getChannelId();
      }
      localObject = paramString;
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        localObject = QRDebugEnvUrlUtils.getTestUrl(paramString);
      }
      avoc.d("ReaderUrlHelper", "getUrlWithBid = " + (String)localObject);
      return localObject;
      paramString = "https://cdn.vip.qq.com/club/client/read/6/rel/" + paramString;
      break;
    }
  }
  
  public static String rI(String paramString)
  {
    String str;
    if (paramString == null) {
      str = d("index.html", false);
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.toLowerCase().startsWith("http://"));
      str = paramString;
    } while (paramString.toLowerCase().startsWith("file://"));
    return au(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avoe
 * JD-Core Version:    0.7.0.1
 */