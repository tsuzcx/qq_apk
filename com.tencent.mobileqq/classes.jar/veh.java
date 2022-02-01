import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class veh
  extends uzu
  implements zwr
{
  public static String a;
  private static uzc a;
  
  private QCircleInitBean a()
  {
    return (QCircleInitBean)((Activity)a()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  public static FeedCloudMeta.StFeed a()
  {
    if ((jdField_a_of_type_Uzc == null) || (jdField_a_of_type_Uzc.a == null)) {
      return new FeedCloudMeta.StFeed();
    }
    return jdField_a_of_type_Uzc.a;
  }
  
  private String c()
  {
    String str2 = a().id.get();
    String str1 = str2;
    if (a() != null) {
      str1 = str2 + a().comment.id.get() + a().reply.id.get();
    }
    return str1;
  }
  
  public String a()
  {
    return null;
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = a();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException) {}
    return null;
  }
  
  protected void a(View paramView)
  {
    zwp.a().a(this);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("danmaku_show"))
    {
      if ((paramObject instanceof uzc)) {
        jdField_a_of_type_Uzc = (uzc)paramObject;
      }
      jdField_a_of_type_JavaLangString = c();
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    }
    while (!paramString.equals("danmaku_dismiss"))
    {
      return;
      paramString = vhu.a().a(jdField_a_of_type_JavaLangString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        zwp.a().a(new QCircleDanmakuEvent(1));
        return;
      }
      zwp.a().a(new QCircleDanmakuEvent(2));
      vhu.a().a(a().hashCode(), a(), false);
      return;
    }
    zwp.a().a(new QCircleDanmakuEvent(2));
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veh
 * JD-Core Version:    0.7.0.1
 */