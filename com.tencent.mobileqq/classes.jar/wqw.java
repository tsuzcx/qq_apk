import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class wqw
{
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private static wqw jdField_a_of_type_Wqw;
  
  public static wqw a()
  {
    if (jdField_a_of_type_Wqw == null)
    {
      jdField_a_of_type_Wqw = new wqw();
      jdField_a_of_type_JavaUtilHashSet = new HashSet();
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      Iterator localIterator = ((wse)wth.a(17)).a().iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        if (!jdField_a_of_type_JavaUtilHashSet.contains(localCommentEntry.feedId))
        {
          jdField_a_of_type_JavaUtilHashSet.add(localCommentEntry.feedId);
          jdField_a_of_type_JavaUtilHashMap.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
        }
      }
    }
    return jdField_a_of_type_Wqw;
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    Iterator localIterator = ((wse)wth.a(17)).a().iterator();
    while (localIterator.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
      if (!jdField_a_of_type_JavaUtilHashSet.contains(localCommentEntry.feedId))
      {
        jdField_a_of_type_JavaUtilHashSet.add(localCommentEntry.feedId);
        jdField_a_of_type_JavaUtilHashMap.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
      }
    }
    yuk.d("StoryFailCommentCacher", "update failed comments. size = %d.", new Object[] { Integer.valueOf(jdField_a_of_type_JavaUtilHashSet.size()) });
  }
  
  public boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_Wqw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqw
 * JD-Core Version:    0.7.0.1
 */