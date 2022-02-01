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

public abstract class vdc
  implements uzp, vaa
{
  public int a;
  private WeakReference<uzq> a;
  public boolean a;
  public boolean b;
  private boolean c;
  
  public vdc(uzq paramuzq)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramuzq);
  }
  
  private stSimpleMetaFeed a(vaq paramvaq)
  {
    if ((paramvaq != null) && ((paramvaq.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramvaq.a();
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      vdq.a(paramString1, paramString2, paramWSPlayerManager.a());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(List<vaq> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vaq localvaq = (vaq)paramList.next();
      if ((localvaq != null) && ((localvaq.a() instanceof stSimpleMetaFeed))) {
        localArrayList.add((stSimpleMetaFeed)localvaq.a());
      }
    }
    uyo.a(localArrayList, false);
  }
  
  private void a(List<vaq> paramList, boolean paramBoolean)
  {
    uzq localuzq = a();
    if (localuzq == null) {
      return;
    }
    if (paramBoolean)
    {
      localuzq.a(paramList);
      return;
    }
    localuzq.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    uzq localuzq = a();
    if ((localuzq != null) && (localuzq.a() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localuzq.a().a(1);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    uzq localuzq = a();
    if ((localuzq != null) && (localuzq.a() != null) && (localuzq.a().c())) {
      localuzq.a(paramInt, paramString);
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uya.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((uzq)localObject).a();
    } while ((localObject == null) || (((uze)localObject).a() == null));
    localObject = ((uze)localObject).a();
    int i = 0;
    label47:
    vaq localvaq;
    if (i < ((List)localObject).size())
    {
      localvaq = (vaq)((List)localObject).get(i);
      if ((localvaq != null) && (localvaq.a() != null)) {
        break label89;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label89:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localvaq.a()).id))
      {
        uya.c("AbsWSVerticalPagePresenter", "data.getItemInfo().total_comment_num:" + ((stSimpleMetaFeed)localvaq.a()).total_comment_num);
        uya.c("AbsWSVerticalPagePresenter", "wsAddCommentEvent.getCommentNum():" + paramWSSimpleBaseEvent.getCommentNum());
        ((stSimpleMetaFeed)localvaq.a()).total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
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
      localObject1 = ((uzq)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof vct))
        {
          localObject2 = (vct)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((vaq)((vct)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((vct)localObject2).jdField_a_of_type_Ula.c(2);
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      vdq.a(paramString1, paramString2, paramWSPlayerManager.a(), false);
      paramWSPlayerManager.g();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uya.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((uzq)localObject1).a();
    } while ((localObject1 == null) || (((uze)localObject1).a() == null));
    localObject1 = ((uze)localObject1).a();
    int i = 0;
    label47:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (vaq)((List)localObject1).get(i);
      if ((localObject2 != null) && (((vaq)localObject2).a() != null) && (((stSimpleMetaFeed)((vaq)localObject2).a()).poster != null)) {
        break label103;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label103:
      localObject2 = ((stSimpleMetaFeed)((vaq)localObject2).a()).poster;
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
      localObject1 = ((uzq)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof vct))
        {
          localObject2 = (vct)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((vaq)((vct)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((vct)localObject2).jdField_a_of_type_Ula.c(1);
            uya.b("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uya.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((uzq)localObject).a();
    } while ((localObject == null) || (((uze)localObject).a() == null));
    localObject = ((uze)localObject).a();
    int i = 0;
    label55:
    vaq localvaq;
    if (i < ((List)localObject).size())
    {
      localvaq = (vaq)((List)localObject).get(i);
      if ((localvaq != null) && (localvaq.a() != null)) {
        break label99;
      }
    }
    label99:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localvaq.a()).id))
    {
      i += 1;
      break label55;
      break;
    }
    int j;
    label155:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != ((stSimpleMetaFeed)localvaq.a()).is_ding)
    {
      if (((stSimpleMetaFeed)localvaq.a()).is_ding != 1) {
        break label207;
      }
      j = 1;
      if (j == 0) {
        break label212;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)localvaq.a();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      ((stSimpleMetaFeed)localvaq.a()).is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      d(paramWSSimpleBaseEvent.getFeedId());
      break;
      label207:
      j = 0;
      break label155;
      label212:
      localstSimpleMetaFeed = (stSimpleMetaFeed)localvaq.a();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((uzq)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof vct))
        {
          localObject2 = (vct)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((vaq)((vct)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((vct)localObject2).jdField_a_of_type_Ula.c(0);
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
  
  public uzq a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (uzq)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    uzq localuzq = a();
    if (localuzq == null) {
      return;
    }
    this.c = false;
    localuzq.e();
    localuzq.d();
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
  
  public void a(List<vaq> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    uzq localuzq = a();
    if (localuzq == null) {
      return;
    }
    this.c = false;
    localuzq.e();
    localuzq.d();
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
  
  public void a(@NonNull uzq paramuzq) {}
  
  public void a(boolean paramBoolean)
  {
    uya.e("WS_VIDEO_PLAY_TIME", "[AbsWSVerticalPagePresenter.java][reportVideoPlay] isPlay:" + paramBoolean);
    uzq localuzq = a();
    if (localuzq != null)
    {
      localObject = localuzq.a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Object localObject = ((uze)localObject).a();
    if (paramBoolean)
    {
      a(localuzq.a(), localuzq.b(), (WSPlayerManager)localObject);
      return;
    }
    b(localuzq.a(), localuzq.b(), (WSPlayerManager)localObject);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.c) {
      return;
    }
    this.c = a(paramBoolean1, paramBoolean2, paramString);
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
    uzq localuzq = a();
    if ((localuzq != null) && (localuzq.a() != null)) {
      localuzq.a().d(c());
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
    uzq localuzq = a();
    if ((localuzq != null) && (localuzq.a() != null) && (b()))
    {
      localuzq.a().e();
      a(true);
    }
    if (b()) {
      url.a().a(true);
    }
  }
  
  public void e()
  {
    uzq localuzq = a();
    if ((localuzq != null) && (localuzq.a() != null))
    {
      localuzq.a().f();
      a(false);
    }
    url.a().a(false);
  }
  
  public void f()
  {
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */