import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;

public class pre
{
  private static pre a;
  private static LruCache<String, CharSequence> f;
  private static HashMap<String, Integer> fg;
  public String auz = "";
  
  public static pre a()
  {
    if (a == null)
    {
      a = new pre();
      f = new LruCache(150);
      fg = new HashMap();
    }
    return a;
  }
  
  public static void destory()
  {
    if (f != null) {
      f.evictAll();
    }
  }
  
  public CharSequence a(String paramString)
  {
    return (CharSequence)f.get(paramString);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (paramCommentEntry == null) {
      return;
    }
    paramCommentEntry = paramCommentEntry.feedId + paramCommentEntry.replyTime;
    if (fg.get(paramCommentEntry) == null)
    {
      fg.put(paramCommentEntry, Integer.valueOf(1));
      return;
    }
    int i = ((Integer)fg.get(paramCommentEntry)).intValue();
    fg.put(paramCommentEntry, Integer.valueOf(i + 1));
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    if (a(paramString) == null) {
      f.put(paramString, paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pre
 * JD-Core Version:    0.7.0.1
 */