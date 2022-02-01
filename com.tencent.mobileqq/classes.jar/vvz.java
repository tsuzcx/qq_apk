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

public class vvz
  implements aaam
{
  private static vvz jdField_a_of_type_Vvz;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private WeakReference<vkl> jdField_a_of_type_MqqUtilWeakReference;
  private Map<String, List<vba>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private WeakReference<vwd> jdField_b_of_type_MqqUtilWeakReference;
  private Map<String, WeakReference<vwe>> c = new ConcurrentHashMap();
  
  private vvz()
  {
    aaak.a().a(this);
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
  
  private vjy a()
  {
    return vjy.a();
  }
  
  public static vvz a()
  {
    if (jdField_a_of_type_Vvz == null) {}
    try
    {
      if (jdField_a_of_type_Vvz == null) {
        jdField_a_of_type_Vvz = new vvz();
      }
      return jdField_a_of_type_Vvz;
    }
    finally {}
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      Object localObject = (String)localIterator1.next();
      if (((String)localObject).startsWith(str))
      {
        List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localList != null)
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            vba localvba = (vba)localIterator2.next();
            if (!localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.reply.id.get())) {
              break;
            }
            localList.remove(localvba);
            localObject = (WeakReference)this.c.get(localObject);
            if (localObject != null)
            {
              localObject = (vwe)((WeakReference)localObject).get();
              if (localObject != null) {
                ((vwe)localObject).a(localList);
              }
            }
            QLog.d("QCircleCommentHelper", 1, "removeTargetReply" + localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
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
  
  private void a(vkl paramvkl, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramvkl == null) {
      return;
    }
    paramvkl.setOnShowListener(new vwb(this, paramStFeed, paramStComment, paramStReply, paramvkl));
    paramvkl.a(new vwc(this, paramvkl, paramStFeed, paramStComment, paramStReply));
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
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(str))
      {
        localObject = (List)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            vba localvba = (vba)((Iterator)localObject).next();
            if (!localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.fakeReplyId)) {
              break;
            }
            QLog.d("QCircleCommentHelper", 1, "replaceFakeReply PreFakeReplyId:" + paramQCircleCommentUpdateEvent.fakeReplyId + " replaceId:" + paramQCircleCommentUpdateEvent.reply.id.get());
            localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.set(paramQCircleCommentUpdateEvent.reply);
          }
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      vkl localvkl = (vkl)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localvkl != null) {
        return localvkl.b();
      }
    }
    return 0;
  }
  
  public String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label156;
      }
      paramStReply = String.format(anzj.a(2131692046), new Object[] { paramStReply.postUser.nick.get() });
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
      paramStReply = String.format(anzj.a(2131692046), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label156:
    return anzj.a(2131697242);
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
  
  public List<vba> a(String paramString)
  {
    return (List)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<vba> a(String paramString, vba paramvba)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramvba == null))
    {
      QLog.d("QCircleCommentHelper", 1, "addFakeReply param error");
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramvba);
    this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject);
    return localObject;
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void a(Activity paramActivity, vba paramvba, vwd paramvwd, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramvba == null))
    {
      QLog.e("QCircleCommentHelper", 1, "showInputPopupWindow param error");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    FeedCloudMeta.StComment localStComment = paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramvwd);
    paramvwd = new vkl(paramActivity);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramvwd);
    paramvwd.b(a(localStComment, localStReply));
    paramvwd.a(new vwa(this, paramActivity, paramvwd, localStFeed, localStComment, localStReply, paramBoolean, paramvba));
    a(paramvwd, localStFeed, localStComment, localStReply);
    paramvwd.a(false);
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
  
  public void a(String paramString, vwe paramvwe)
  {
    if (paramvwe != null)
    {
      paramvwe = new WeakReference(paramvwe);
      this.c.put(paramString, paramvwe);
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
    vkl localvkl;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramSimpleBaseEvent.eventStatus != 5);
        b(paramSimpleBaseEvent);
        return;
      } while ((!(paramSimpleBaseEvent instanceof QCircleAtUpdateEvent)) || (this.jdField_a_of_type_MqqUtilWeakReference == null));
      localvkl = (vkl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (localvkl == null);
    localvkl.a((QCircleAtUpdateEvent)paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvz
 * JD-Core Version:    0.7.0.1
 */