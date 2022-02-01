import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class vtd
  implements zwr
{
  private static vtd jdField_a_of_type_Vtd;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private WeakReference<vth> jdField_a_of_type_MqqUtilWeakReference;
  private vih jdField_a_of_type_Vih;
  private Map<String, List<uzk>> b = new HashMap();
  private Map<String, WeakReference<vti>> c = new ConcurrentHashMap();
  
  private vtd()
  {
    zwp.a().a(this);
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder.append(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label78;
      }
      localStringBuilder.append("&&").append(paramString2);
      label42:
      if (TextUtils.isEmpty(paramString3)) {
        break label94;
      }
      localStringBuilder.append("&&").append(paramString3);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("0");
      break;
      label78:
      localStringBuilder.append("&&").append("0");
      break label42;
      label94:
      localStringBuilder.append("&&").append("0");
    }
  }
  
  private vhu a()
  {
    return vhu.a();
  }
  
  public static vtd a()
  {
    if (jdField_a_of_type_Vtd == null) {}
    try
    {
      if (jdField_a_of_type_Vtd == null) {
        jdField_a_of_type_Vtd = new vtd();
      }
      return jdField_a_of_type_Vtd;
    }
    finally {}
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator1 = this.b.keySet().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      Object localObject = (String)localIterator1.next();
      if (((String)localObject).startsWith(str))
      {
        List localList = (List)this.b.get(localObject);
        if (localList != null)
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            uzk localuzk = (uzk)localIterator2.next();
            if (!localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.reply.id.get())) {
              break;
            }
            localList.remove(localuzk);
            localObject = (WeakReference)this.c.get(localObject);
            if (localObject != null)
            {
              localObject = (vti)((WeakReference)localObject).get();
              if (localObject != null) {
                ((vti)localObject).a(localList);
              }
            }
            QLog.d("QCircleCommentHelper", 1, "removeTargetReply" + localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
          }
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.d("QCircleCommentHelper", 1, "storeComment storeKey: " + paramString1 + " comment: " + paramString2);
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  private String b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStFeed != null)
    {
      paramStFeed = paramStFeed.id.get();
      if (paramStComment == null) {
        break label50;
      }
      paramStComment = paramStComment.id.get();
      label24:
      if (paramStReply == null) {
        break label56;
      }
    }
    label50:
    label56:
    for (paramStReply = paramStReply.id.get();; paramStReply = "")
    {
      return a(paramStFeed, paramStComment, paramStReply);
      paramStFeed = "";
      break;
      paramStComment = "";
      break label24;
    }
  }
  
  private void b(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator = this.b.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(str))
      {
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            uzk localuzk = (uzk)((Iterator)localObject).next();
            if (!localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.fakeReplyId)) {
              break;
            }
            QLog.d("QCircleCommentHelper", 1, "replaceFakeReply PreFakeReplyId:" + paramQCircleCommentUpdateEvent.fakeReplyId + " replaceId:" + paramQCircleCommentUpdateEvent.reply.id.get());
            localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.set(paramQCircleCommentUpdateEvent.reply);
          }
        }
      }
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_Vih.setOnShowListener(new vtf(this, paramStFeed, paramStComment, paramStReply));
    this.jdField_a_of_type_Vih.a(new vtg(this, paramStFeed, paramStComment, paramStReply));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Vih != null) {
      return this.jdField_a_of_type_Vih.b();
    }
    return 0;
  }
  
  public String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label154;
      }
      paramStReply = String.format(anni.a(2131692041), new Object[] { paramStReply.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStComment = paramStComment + "...";
      }
    }
    do
    {
      return paramStComment;
      if ((paramStComment == null) || (paramStComment.postUser == null)) {
        break;
      }
      paramStReply = String.format(anni.a(2131692041), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label154:
    return anni.a(2131697177);
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    paramStFeed = b(paramStFeed, paramStComment, paramStReply);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramStFeed))
    {
      QLog.d("QCircleCommentHelper", 1, "getComment storeKey: " + paramStFeed + " preCommentText: " + (String)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed));
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed);
    }
    QLog.d("QCircleCommentHelper", 1, "getComment storeKey: " + paramStFeed + " preCommentText doesn't exit");
    return "";
  }
  
  public List<uzk> a(String paramString)
  {
    return (List)this.b.get(paramString);
  }
  
  public List<uzk> a(String paramString, uzk paramuzk)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramuzk == null))
    {
      QLog.d("QCircleCommentHelper", 1, "addFakeReply param error");
      return null;
    }
    if (this.b == null) {
      this.b = new HashMap();
    }
    List localList = (List)this.b.get(paramString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramuzk);
    this.b.put(paramString, localObject);
    return localObject;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(Activity paramActivity, uzk paramuzk, vth paramvth, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramuzk == null))
    {
      QLog.e("QCircleCommentHelper", 1, "showInputPopupWindow param error");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    FeedCloudMeta.StComment localStComment = paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramvth);
    this.jdField_a_of_type_Vih = new vih(paramActivity);
    this.jdField_a_of_type_Vih.b(a(localStComment, localStReply));
    this.jdField_a_of_type_Vih.a(new vte(this, paramActivity, localStFeed, localStComment, localStReply, paramBoolean, paramuzk));
    b(localStFeed, localStComment, localStReply);
    this.jdField_a_of_type_Vih.a(false);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, String paramString)
  {
    a(b(paramStFeed, paramStComment, paramStReply), paramString);
  }
  
  public void a(String paramString, vti paramvti)
  {
    if (paramvti != null)
    {
      paramvti = new WeakReference(paramvti);
      this.c.put(paramString, paramvti);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleAtUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.eventStatus == 6) || (paramSimpleBaseEvent.eventStatus == 10)) {
        a(paramSimpleBaseEvent);
      }
    }
    while ((!(paramSimpleBaseEvent instanceof QCircleAtUpdateEvent)) || (this.jdField_a_of_type_Vih == null))
    {
      do
      {
        return;
      } while (paramSimpleBaseEvent.eventStatus != 5);
      b(paramSimpleBaseEvent);
      return;
    }
    this.jdField_a_of_type_Vih.a((QCircleAtUpdateEvent)paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtd
 * JD-Core Version:    0.7.0.1
 */