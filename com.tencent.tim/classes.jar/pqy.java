import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class pqy
{
  private static pqy a;
  private static HashSet<String> af;
  private static HashMap<String, Integer> ff;
  
  public static pqy a()
  {
    if (a == null)
    {
      a = new pqy();
      af = new HashSet();
      ff = new HashMap();
      Iterator localIterator = ((psa)psx.a(17)).bJ().iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        if (!af.contains(localCommentEntry.feedId))
        {
          af.add(localCommentEntry.feedId);
          ff.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
        }
      }
    }
    return a;
  }
  
  public int bd(String paramString)
  {
    paramString = (Integer)ff.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void bmw()
  {
    af.clear();
    ff.clear();
    Iterator localIterator = ((psa)psx.a(17)).bJ().iterator();
    while (localIterator.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
      if (!af.contains(localCommentEntry.feedId))
      {
        af.add(localCommentEntry.feedId);
        ff.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
      }
    }
    ram.w("StoryFailCommentCacher", "update failed comments. size = %d.", new Object[] { Integer.valueOf(af.size()) });
  }
  
  public void destory()
  {
    af.clear();
    ff.clear();
    a = null;
  }
  
  public boolean fe(String paramString)
  {
    return ff.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqy
 * JD-Core Version:    0.7.0.1
 */