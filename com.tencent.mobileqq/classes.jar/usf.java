import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class usf
  extends utx
{
  public static final String a;
  public static final String b = uqn.a("StorySvc.del_feed_comment");
  public static final String c = uqn.a("StorySvc.get_comment_list");
  protected int a;
  protected ust a;
  protected boolean a;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a("StorySvc.add_feed_comment");
  }
  
  public usf(ust paramust)
  {
    this.jdField_a_of_type_Ust = paramust;
  }
  
  public static void a(CommentEntry paramCommentEntry, uud paramuud)
  {
    paramCommentEntry = new usj(paramCommentEntry, paramuud);
    paramuud = new usk(paramuud);
    utz.a().a(paramCommentEntry, paramuud);
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
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new usg(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, uud paramuud)
  {
    paramString1 = new ush(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramuud);
    paramString2 = new usi(paramuud);
    utz.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, uud paramuud)
  {
    paramCommentEntry = new ush(paramCommentEntry, paramuud);
    paramuud = new usi(paramuud);
    utz.a().a(paramCommentEntry, paramuud);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Ust.a.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new usl(this, paramString, paramInt);
    usm localusm = new usm(this);
    utz.a().a(paramString, localusm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usf
 * JD-Core Version:    0.7.0.1
 */