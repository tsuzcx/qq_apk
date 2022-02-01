import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public abstract class uvh
  implements uru, usf
{
  public int a;
  private WeakReference<urv> a;
  public boolean a;
  private boolean b;
  
  public uvh(urv paramurv)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramurv);
  }
  
  private stSimpleMetaFeed a(usv paramusv)
  {
    if ((paramusv != null) && ((paramusv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramusv.a();
    }
    return null;
  }
  
  private void a(List<usv> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      usv localusv = (usv)paramList.next();
      if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
        localArrayList.add((stSimpleMetaFeed)localusv.a());
      }
    }
    uqt.a(localArrayList, false);
  }
  
  private void a(List<usv> paramList, boolean paramBoolean)
  {
    urv localurv = a();
    if (localurv == null) {
      return;
    }
    if (paramBoolean)
    {
      localurv.a(paramList);
      return;
    }
    localurv.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    urv localurv = a();
    if ((localurv != null) && (localurv.a() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localurv.a().a(1);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    urv localurv = a();
    if ((localurv != null) && (localurv.a() != null) && (localurv.a().b())) {
      localurv.a(paramInt, paramString);
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uqf.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((urv)localObject).a();
    } while ((localObject == null) || (((urj)localObject).a() == null));
    localObject = ((urj)localObject).a();
    int i = 0;
    label47:
    usv localusv;
    if (i < ((List)localObject).size())
    {
      localusv = (usv)((List)localObject).get(i);
      if ((localusv != null) && (localusv.a() != null)) {
        break label89;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label89:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localusv.a()).id))
      {
        uqf.c("AbsWSVerticalPagePresenter", "data.getItemInfo().total_comment_num:" + ((stSimpleMetaFeed)localusv.a()).total_comment_num);
        uqf.c("AbsWSVerticalPagePresenter", "wsAddCommentEvent.getCommentNum():" + paramWSSimpleBaseEvent.getCommentNum());
        ((stSimpleMetaFeed)localusv.a()).total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
        b(paramWSSimpleBaseEvent.getFeedId());
      }
    }
  }
  
  private void b(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((urv)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof uuy))
        {
          localObject2 = (uuy)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((usv)((uuy)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((uuy)localObject2).jdField_a_of_type_Uek.c(2);
          }
        }
        i += 1;
      }
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uqf.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((urv)localObject1).a();
    } while ((localObject1 == null) || (((urj)localObject1).a() == null));
    localObject1 = ((urj)localObject1).a();
    int i = 0;
    label47:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (usv)((List)localObject1).get(i);
      if ((localObject2 != null) && (((usv)localObject2).a() != null) && (((stSimpleMetaFeed)((usv)localObject2).a()).poster != null)) {
        break label103;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label103:
      localObject2 = ((stSimpleMetaFeed)((usv)localObject2).a()).poster;
      if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
      {
        ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
        c(paramWSSimpleBaseEvent.getPersonId());
      }
    }
  }
  
  private void c(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((urv)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof uuy))
        {
          localObject2 = (uuy)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((usv)((uuy)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((uuy)localObject2).jdField_a_of_type_Uek.c(1);
            uqf.b("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uqf.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((urv)localObject).a();
    } while ((localObject == null) || (((urj)localObject).a() == null));
    localObject = ((urj)localObject).a();
    int i = 0;
    label55:
    usv localusv;
    if (i < ((List)localObject).size())
    {
      localusv = (usv)((List)localObject).get(i);
      if ((localusv != null) && (localusv.a() != null)) {
        break label99;
      }
    }
    label99:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localusv.a()).id))
    {
      i += 1;
      break label55;
      break;
    }
    int j;
    label155:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != ((stSimpleMetaFeed)localusv.a()).is_ding)
    {
      if (((stSimpleMetaFeed)localusv.a()).is_ding != 1) {
        break label207;
      }
      j = 1;
      if (j == 0) {
        break label212;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)localusv.a();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      ((stSimpleMetaFeed)localusv.a()).is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      d(paramWSSimpleBaseEvent.getFeedId());
      break;
      label207:
      j = 0;
      break label155;
      label212:
      localstSimpleMetaFeed = (stSimpleMetaFeed)localusv.a();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((urv)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof uuy))
        {
          localObject2 = (uuy)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((usv)((uuy)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((uuy)localObject2).jdField_a_of_type_Uek.c(0);
          }
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public urv a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (urv)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    urv localurv = a();
    if (localurv == null) {
      return;
    }
    this.b = false;
    localurv.e();
    localurv.d();
    b(paramInt, paramString);
    WSPublicAccReport.getInstance().reportEnterVerticalVideo(null, 2, false, paramInt);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent == null) {}
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        d(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        c(paramWSSimpleBaseEvent);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof WSAddCommentEvent));
    b(paramWSSimpleBaseEvent);
  }
  
  public void a(String paramString)
  {
    a(true, false, paramString);
  }
  
  public void a(List<usv> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    urv localurv = a();
    if (localurv == null) {
      return;
    }
    this.b = false;
    localurv.e();
    localurv.d();
    if (paramList.size() > 0)
    {
      a(paramList);
      a(paramBoolean1, paramBoolean2);
      a(paramList, a(paramBoolean1, paramBoolean2, paramObject));
    }
    for (;;)
    {
      WSPublicAccReport.getInstance().reportEnterVerticalVideo(paramList, 2, true, -1);
      return;
      b(-1, "");
    }
  }
  
  public void a(@NonNull urv paramurv) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.b) {
      return;
    }
    this.b = a(paramBoolean1, paramBoolean2, paramString);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    return false;
  }
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public void b()
  {
    urv localurv = a();
    if ((localurv != null) && (localurv.a() != null)) {
      localurv.a().d(c());
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    urv localurv = a();
    if ((localurv != null) && (localurv.a() != null) && (b())) {
      localurv.a().e();
    }
    if (b()) {
      ukq.a().a(true);
    }
  }
  
  public void e()
  {
    urv localurv = a();
    if ((localurv != null) && (localurv.a() != null)) {
      localurv.a().f();
    }
    ukq.a().a(false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvh
 * JD-Core Version:    0.7.0.1
 */