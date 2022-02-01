import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class pdp
  implements rwx
{
  private static pdp jdField_a_of_type_Pdp;
  private WeakReference<pdp.a> G;
  private oyr jdField_a_of_type_Oyr;
  private FeedCloudMeta.StComment jdField_b_of_type_FeedcloudFeedCloudMeta$StComment;
  private oyh jdField_b_of_type_Oyh;
  private FeedCloudMeta.StReply c;
  private Map<String, String> fw = new HashMap();
  private Map<String, List<ovx>> fx = new HashMap();
  private Map<String, WeakReference<pdp.b>> fy = new ConcurrentHashMap();
  private FeedCloudMeta.StFeed h;
  
  private pdp()
  {
    rwv.a().a(this);
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
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
      return q(paramStFeed, paramStComment, paramStReply);
      paramStFeed = "";
      break;
      paramStComment = "";
      break label24;
    }
  }
  
  private oyh a(Context paramContext)
  {
    if (this.jdField_b_of_type_Oyh == null) {
      this.jdField_b_of_type_Oyh = new oyh(paramContext);
    }
    return this.jdField_b_of_type_Oyh;
  }
  
  public static pdp a()
  {
    if (jdField_a_of_type_Pdp == null) {}
    try
    {
      if (jdField_a_of_type_Pdp == null) {
        jdField_a_of_type_Pdp = new pdp();
      }
      return jdField_a_of_type_Pdp;
    }
    finally {}
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator1 = this.fx.keySet().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      Object localObject = (String)localIterator1.next();
      if (((String)localObject).startsWith(str))
      {
        List localList = (List)this.fx.get(localObject);
        if (localList != null)
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            ovx localovx = (ovx)localIterator2.next();
            if (!localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.reply.id.get())) {
              break;
            }
            localList.remove(localovx);
            localObject = (WeakReference)this.fy.get(localObject);
            if (localObject != null)
            {
              localObject = (pdp.b)((WeakReference)localObject).get();
              if (localObject != null) {
                ((pdp.b)localObject).updateList(localList);
              }
            }
            QLog.d("QCircleCommentHelper", 1, "removeTargetReply" + localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
          }
        }
      }
    }
  }
  
  private void b(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator = this.fx.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(str))
      {
        localObject = (List)this.fx.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ovx localovx = (ovx)((Iterator)localObject).next();
            if (!localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleCommentUpdateEvent.mFakeReplyId)) {
              break;
            }
            QLog.d("QCircleCommentHelper", 1, "replaceFakeReply PreFakeReplyId:" + paramQCircleCommentUpdateEvent.mFakeReplyId + " replaceId:" + paramQCircleCommentUpdateEvent.reply.id.get());
            localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.set(paramQCircleCommentUpdateEvent.reply);
          }
        }
      }
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_Oyr.setOnShowListener(new pdr(this, paramStFeed, paramStComment, paramStReply));
    this.jdField_a_of_type_Oyr.a(new pds(this, paramStFeed, paramStComment, paramStReply));
  }
  
  private void ci(String paramString1, String paramString2)
  {
    QLog.d("QCircleCommentHelper", 1, "storeComment storeKey: " + paramString1 + " comment: " + paramString2);
    this.fw.put(paramString1, paramString2);
  }
  
  private String q(String paramString1, String paramString2, String paramString3)
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
  
  public List<ovx> J(String paramString)
  {
    return (List)this.fx.get(paramString);
  }
  
  public List<ovx> a(String paramString, ovx paramovx)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramovx == null))
    {
      QLog.d("QCircleCommentHelper", 1, "addFakeReply param error");
      return null;
    }
    if (this.fx == null) {
      this.fx = new HashMap();
    }
    List localList = (List)this.fx.get(paramString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramovx);
    this.fx.put(paramString, localObject);
    return localObject;
  }
  
  public void a(Activity paramActivity, ovx paramovx, pdp.a parama)
  {
    if ((paramActivity == null) || (paramovx == null))
    {
      QLog.e("QCircleCommentHelper", 1, "showInputPopupWindow param error");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramovx.mFeed;
    FeedCloudMeta.StComment localStComment = paramovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = paramovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    a(this.h, this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment, this.c);
    this.G = new WeakReference(parama);
    this.jdField_a_of_type_Oyr = new oyr(paramActivity);
    this.jdField_a_of_type_Oyr.qG(b(localStComment, localStReply));
    this.jdField_a_of_type_Oyr.a(new pdq(this, paramActivity, localStFeed, localStComment, localStReply, paramovx));
    b(localStFeed, localStComment, localStReply);
    this.jdField_a_of_type_Oyr.show(false);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.h = paramStFeed;
    this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.c = paramStReply;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, String paramString)
  {
    ci(a(paramStFeed, paramStComment, paramStReply), paramString);
  }
  
  public void a(String paramString, pdp.b paramb)
  {
    if (paramb != null)
    {
      paramb = new WeakReference(paramb);
      this.fy.put(paramString, paramb);
    }
  }
  
  public String b(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label110;
      }
      paramStComment = "";
      if ("".length() > 10)
      {
        paramStComment = "".substring(0, 10);
        paramStComment = paramStComment + "...";
      }
    }
    do
    {
      return paramStComment;
      if ((paramStComment == null) || (paramStComment.postUser == null)) {
        break;
      }
      paramStComment = "";
    } while ("".length() <= 10);
    paramStComment = "".substring(0, 10);
    return paramStComment + "...";
    label110:
    return "";
  }
  
  public String b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    paramStFeed = a(paramStFeed, paramStComment, paramStReply);
    if (this.fw.containsKey(paramStFeed))
    {
      QLog.d("QCircleCommentHelper", 1, "getComment storeKey: " + paramStFeed + " preCommentText: " + (String)this.fw.get(paramStFeed));
      return (String)this.fw.get(paramStFeed);
    }
    QLog.d("QCircleCommentHelper", 1, "getComment storeKey: " + paramStFeed + " preCommentText doesn't exit");
    return "";
  }
  
  public void bke()
  {
    this.fx.clear();
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
  
  public static abstract interface a
  {
    public abstract void a(FeedCloudMeta.StComment paramStComment);
    
    public abstract void a(FeedCloudMeta.StReply paramStReply);
  }
  
  public static abstract interface b
  {
    public abstract void updateList(List<ovx> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdp
 * JD-Core Version:    0.7.0.1
 */