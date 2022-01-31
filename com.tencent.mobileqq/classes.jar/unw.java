import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class unw
  extends upo
{
  public static final String a;
  public static final String b = ume.a("StorySvc.del_feed_comment");
  public static final String c = ume.a("StorySvc.get_comment_list");
  protected int a;
  protected uok a;
  protected boolean a;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.add_feed_comment");
  }
  
  public unw(uok paramuok)
  {
    this.jdField_a_of_type_Uok = paramuok;
  }
  
  public static void a(CommentEntry paramCommentEntry, upu paramupu)
  {
    paramCommentEntry = new uoa(paramCommentEntry, paramupu);
    paramupu = new uob(paramupu);
    upq.a().a(paramCommentEntry, paramupu);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).putOpt("vid", paramString3);
      ((JSONObject)localObject2).putOpt("feedid", paramString4);
      ((JSONObject)localObject2).putOpt("pvid", paramString5);
      ((JSONObject)localObject2).putOpt("styles", new JSONArray(paramString6));
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.qqstory:FeedCommentDataProvider", 2, "addGamePKComment jsonException " + localJSONException);
      }
    }
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new unx(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, upu paramupu)
  {
    paramString1 = new uny(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramupu);
    paramString2 = new unz(paramupu);
    upq.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, upu paramupu)
  {
    paramCommentEntry = new uny(paramCommentEntry, paramupu);
    paramupu = new unz(paramupu);
    upq.a().a(paramCommentEntry, paramupu);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Uok.a.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new uoc(this, paramString, paramInt);
    uod localuod = new uod(this);
    upq.a().a(paramString, localuod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unw
 * JD-Core Version:    0.7.0.1
 */