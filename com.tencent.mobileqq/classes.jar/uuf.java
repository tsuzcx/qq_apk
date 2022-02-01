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

public abstract class uuf
  implements uqt, ure
{
  public int a;
  private WeakReference<uqu> a;
  public boolean a;
  private boolean b;
  
  public uuf(uqu paramuqu)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramuqu);
  }
  
  private stSimpleMetaFeed a(uru paramuru)
  {
    if ((paramuru != null) && ((paramuru.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramuru.a();
    }
    return null;
  }
  
  private void a(List<uru> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uru localuru = (uru)paramList.next();
      if ((localuru != null) && ((localuru.a() instanceof stSimpleMetaFeed))) {
        localArrayList.add((stSimpleMetaFeed)localuru.a());
      }
    }
    ups.a(localArrayList, false);
  }
  
  private void a(List<uru> paramList, boolean paramBoolean)
  {
    uqu localuqu = a();
    if (localuqu == null) {
      return;
    }
    if (paramBoolean)
    {
      localuqu.a(paramList);
      return;
    }
    localuqu.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    uqu localuqu = a();
    if ((localuqu != null) && (localuqu.a() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localuqu.a().a(1);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    uqu localuqu = a();
    if ((localuqu != null) && (localuqu.a() != null) && (localuqu.a().b())) {
      localuqu.a(paramInt, paramString);
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    upe.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((uqu)localObject).a();
    } while ((localObject == null) || (((uqi)localObject).a() == null));
    localObject = ((uqi)localObject).a();
    int i = 0;
    label47:
    uru localuru;
    if (i < ((List)localObject).size())
    {
      localuru = (uru)((List)localObject).get(i);
      if ((localuru != null) && (localuru.a() != null)) {
        break label89;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label89:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localuru.a()).id))
      {
        upe.c("AbsWSVerticalPagePresenter", "data.getItemInfo().total_comment_num:" + ((stSimpleMetaFeed)localuru.a()).total_comment_num);
        upe.c("AbsWSVerticalPagePresenter", "wsAddCommentEvent.getCommentNum():" + paramWSSimpleBaseEvent.getCommentNum());
        ((stSimpleMetaFeed)localuru.a()).total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
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
      localObject1 = ((uqu)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof utw))
        {
          localObject2 = (utw)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((uru)((utw)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((utw)localObject2).jdField_a_of_type_Uei.c(2);
          }
        }
        i += 1;
      }
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    upe.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((uqu)localObject1).a();
    } while ((localObject1 == null) || (((uqi)localObject1).a() == null));
    localObject1 = ((uqi)localObject1).a();
    int i = 0;
    label47:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (uru)((List)localObject1).get(i);
      if ((localObject2 != null) && (((uru)localObject2).a() != null) && (((stSimpleMetaFeed)((uru)localObject2).a()).poster != null)) {
        break label103;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label103:
      localObject2 = ((stSimpleMetaFeed)((uru)localObject2).a()).poster;
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
      localObject1 = ((uqu)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof utw))
        {
          localObject2 = (utw)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((uru)((utw)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((utw)localObject2).jdField_a_of_type_Uei.c(1);
            upe.b("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    upe.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((uqu)localObject).a();
    } while ((localObject == null) || (((uqi)localObject).a() == null));
    localObject = ((uqi)localObject).a();
    int i = 0;
    label55:
    uru localuru;
    if (i < ((List)localObject).size())
    {
      localuru = (uru)((List)localObject).get(i);
      if ((localuru != null) && (localuru.a() != null)) {
        break label99;
      }
    }
    label99:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localuru.a()).id))
    {
      i += 1;
      break label55;
      break;
    }
    int j;
    label155:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != ((stSimpleMetaFeed)localuru.a()).is_ding)
    {
      if (((stSimpleMetaFeed)localuru.a()).is_ding != 1) {
        break label207;
      }
      j = 1;
      if (j == 0) {
        break label212;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)localuru.a();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      ((stSimpleMetaFeed)localuru.a()).is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      d(paramWSSimpleBaseEvent.getFeedId());
      break;
      label207:
      j = 0;
      break label155;
      label212:
      localstSimpleMetaFeed = (stSimpleMetaFeed)localuru.a();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((uqu)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof utw))
        {
          localObject2 = (utw)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((uru)((utw)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((utw)localObject2).jdField_a_of_type_Uei.c(0);
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
  
  public uqu a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (uqu)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    uqu localuqu = a();
    if (localuqu == null) {
      return;
    }
    this.b = false;
    localuqu.e();
    localuqu.f();
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
  
  public void a(List<uru> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    uqu localuqu = a();
    if (localuqu == null) {
      return;
    }
    this.b = false;
    localuqu.e();
    localuqu.f();
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
  
  public void a(@NonNull uqu paramuqu) {}
  
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
    uqu localuqu = a();
    if ((localuqu != null) && (localuqu.a() != null)) {
      localuqu.a().c(c());
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
    uqu localuqu = a();
    if ((localuqu != null) && (localuqu.a() != null) && (b())) {
      localuqu.a().e();
    }
  }
  
  public void e()
  {
    uqu localuqu = a();
    if ((localuqu != null) && (localuqu.a() != null)) {
      localuqu.a().f();
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuf
 * JD-Core Version:    0.7.0.1
 */