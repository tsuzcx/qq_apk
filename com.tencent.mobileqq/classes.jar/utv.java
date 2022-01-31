import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;

public class utv
{
  private static LruCache<String, CharSequence> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static utv jdField_a_of_type_Utv;
  public String a;
  
  public utv()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static utv a()
  {
    if (jdField_a_of_type_Utv == null)
    {
      jdField_a_of_type_Utv = new utv();
      jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(150);
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    return jdField_a_of_type_Utv;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    }
  }
  
  public CharSequence a(String paramString)
  {
    return (CharSequence)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (paramCommentEntry == null) {
      return;
    }
    paramCommentEntry = paramCommentEntry.feedId + paramCommentEntry.replyTime;
    if (jdField_a_of_type_JavaUtilHashMap.get(paramCommentEntry) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramCommentEntry, Integer.valueOf(1));
      return;
    }
    int i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramCommentEntry)).intValue();
    jdField_a_of_type_JavaUtilHashMap.put(paramCommentEntry, Integer.valueOf(i + 1));
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    if (a(paramString) == null) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */