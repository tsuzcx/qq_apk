import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class wfy
  extends whq
{
  public static final String a;
  public static final String b = weg.a("StorySvc.del_feed_comment");
  public static final String c = weg.a("StorySvc.get_comment_list");
  protected int a;
  protected wgm a;
  protected boolean a;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StorySvc.add_feed_comment");
  }
  
  public wfy(wgm paramwgm)
  {
    this.jdField_a_of_type_Wgm = paramwgm;
  }
  
  public static void a(CommentEntry paramCommentEntry, whw paramwhw)
  {
    paramCommentEntry = new wgc(paramCommentEntry, paramwhw);
    paramwhw = new wgd(paramwhw);
    whs.a().a(paramCommentEntry, paramwhw);
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
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new wfz(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, whw paramwhw)
  {
    paramString1 = new wga(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramwhw);
    paramString2 = new wgb(paramwhw);
    whs.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, whw paramwhw)
  {
    paramCommentEntry = new wga(paramCommentEntry, paramwhw);
    paramwhw = new wgb(paramwhw);
    whs.a().a(paramCommentEntry, paramwhw);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Wgm.a.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new wge(this, paramString, paramInt);
    wgf localwgf = new wgf(this);
    whs.a().a(paramString, localwgf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfy
 * JD-Core Version:    0.7.0.1
 */