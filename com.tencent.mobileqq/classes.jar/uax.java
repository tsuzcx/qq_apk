import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
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

public class uax
  implements yiy
{
  private static uax jdField_a_of_type_Uax;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private WeakReference<ubb> jdField_a_of_type_MqqUtilWeakReference;
  private tuk jdField_a_of_type_Tuk;
  private tuv jdField_a_of_type_Tuv;
  private Map<String, List<trx>> b = new HashMap();
  private Map<String, WeakReference<ubc>> c = new ConcurrentHashMap();
  
  private uax()
  {
    yiw.a().a(this);
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
  
  private tuk a(Context paramContext)
  {
    if (this.jdField_a_of_type_Tuk == null) {
      this.jdField_a_of_type_Tuk = new tuk(paramContext);
    }
    return this.jdField_a_of_type_Tuk;
  }
  
  public static uax a()
  {
    if (jdField_a_of_type_Uax == null) {}
    try
    {
      if (jdField_a_of_type_Uax == null) {
        jdField_a_of_type_Uax = new uax();
      }
      return jdField_a_of_type_Uax;
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
            trx localtrx = (trx)localIterator2.next();
            if (!localtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.reply.id.get())) {
              break;
            }
            localList.remove(localtrx);
            localObject = (WeakReference)this.c.get(localObject);
            if (localObject != null)
            {
              localObject = (ubc)((WeakReference)localObject).get();
              if (localObject != null) {
                ((ubc)localObject).a(localList);
              }
            }
            QLog.d("QCircleCommentHelper", 1, "removeTargetReply" + localtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
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
            trx localtrx = (trx)((Iterator)localObject).next();
            if (!localtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.mFakeReplyId)) {
              break;
            }
            QLog.d("QCircleCommentHelper", 1, "replaceFakeReply PreFakeReplyId:" + paramQCircleCommentUpdateEvent.mFakeReplyId + " replaceId:" + paramQCircleCommentUpdateEvent.reply.id.get());
            localtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.set(paramQCircleCommentUpdateEvent.reply);
          }
        }
      }
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_Tuv.setOnShowListener(new uaz(this, paramStFeed, paramStComment, paramStReply));
    this.jdField_a_of_type_Tuv.a(new uba(this, paramStFeed, paramStComment, paramStReply));
  }
  
  public String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label156;
      }
      paramStReply = String.format(alud.a(2131692456), new Object[] { paramStReply.postUser.nick.get() });
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
      paramStReply = String.format(alud.a(2131692456), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label156:
    return alud.a(2131692451);
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
  
  public List<trx> a(String paramString)
  {
    return (List)this.b.get(paramString);
  }
  
  public List<trx> a(String paramString, trx paramtrx)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramtrx == null))
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
    ((List)localObject).add(paramtrx);
    this.b.put(paramString, localObject);
    return localObject;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(Activity paramActivity, trx paramtrx, ubb paramubb)
  {
    if ((paramActivity == null) || (paramtrx == null))
    {
      QLog.e("QCircleCommentHelper", 1, "showInputPopupWindow param error");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    FeedCloudMeta.StComment localStComment = paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramubb);
    this.jdField_a_of_type_Tuv = new tuv(paramActivity);
    this.jdField_a_of_type_Tuv.b(a(localStComment, localStReply));
    this.jdField_a_of_type_Tuv.a(new uay(this, paramActivity, localStFeed, localStComment, localStReply, paramtrx));
    b(localStFeed, localStComment, localStReply);
    this.jdField_a_of_type_Tuv.a(false);
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
  
  public void a(String paramString, ubc paramubc)
  {
    if (paramubc != null)
    {
      paramubc = new WeakReference(paramubc);
      this.c.put(paramString, paramubc);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.eventStatus != 4) {
        break label26;
      }
      a(paramSimpleBaseEvent);
    }
    label26:
    while (paramSimpleBaseEvent.eventStatus != 3) {
      return;
    }
    b(paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uax
 * JD-Core Version:    0.7.0.1
 */