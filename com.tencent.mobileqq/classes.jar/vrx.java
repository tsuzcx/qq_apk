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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public abstract class vrx
  implements voh, vos
{
  private static final int b;
  public int a;
  private WeakReference<voi> a;
  public boolean a;
  public boolean b;
  private boolean c;
  
  static
  {
    jdField_b_of_type_Int = ScreenUtil.dip2px(40.0F);
  }
  
  public vrx(voi paramvoi)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramvoi);
  }
  
  private stSimpleMetaFeed a(vpj paramvpj)
  {
    if ((paramvpj != null) && ((paramvpj.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramvpj.a();
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      vsj.a(paramString1, paramString2, paramWSPlayerManager.a());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(List<vpj> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vpj localvpj = (vpj)paramList.next();
      if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed))) {
        localArrayList.add((stSimpleMetaFeed)localvpj.a());
      }
    }
    vnd.a(localArrayList, false);
  }
  
  private void a(List<vpj> paramList, boolean paramBoolean)
  {
    voi localvoi = a();
    if (localvoi == null) {
      return;
    }
    if (paramBoolean)
    {
      localvoi.a(paramList);
      return;
    }
    localvoi.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    voi localvoi = a();
    if ((localvoi != null) && (localvoi.a() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localvoi.a().a(1);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    voi localvoi = a();
    if ((localvoi != null) && (localvoi.a() != null) && (localvoi.a().c())) {
      localvoi.a(paramInt, paramString);
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    vmp.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((voi)localObject).a();
    } while ((localObject == null) || (((vnw)localObject).b() == null));
    localObject = ((vnw)localObject).b();
    int i = 0;
    label47:
    vpj localvpj;
    if (i < ((List)localObject).size())
    {
      localvpj = (vpj)((List)localObject).get(i);
      if ((localvpj != null) && (localvpj.a() != null)) {
        break label89;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label89:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localvpj.a()).id))
      {
        vmp.c("AbsWSVerticalPagePresenter", "data.getItemInfo().total_comment_num:" + ((stSimpleMetaFeed)localvpj.a()).total_comment_num);
        vmp.c("AbsWSVerticalPagePresenter", "wsAddCommentEvent.getCommentNum():" + paramWSSimpleBaseEvent.getCommentNum());
        ((stSimpleMetaFeed)localvpj.a()).total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
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
      localObject1 = ((voi)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof vrn))
        {
          localObject2 = (vrn)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((vpj)((vrn)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((vrn)localObject2).jdField_a_of_type_Uyx.c(2);
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
      vsj.a(paramString1, paramString2, paramWSPlayerManager.a(), false);
      paramWSPlayerManager.g();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    vmp.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((voi)localObject1).a();
    } while ((localObject1 == null) || (((vnw)localObject1).b() == null));
    localObject1 = ((vnw)localObject1).b();
    int i = 0;
    label47:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (vpj)((List)localObject1).get(i);
      if ((localObject2 != null) && (((vpj)localObject2).a() != null) && (((stSimpleMetaFeed)((vpj)localObject2).a()).poster != null)) {
        break label103;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label103:
      localObject2 = ((stSimpleMetaFeed)((vpj)localObject2).a()).poster;
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
      localObject1 = ((voi)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof vrn))
        {
          localObject2 = (vrn)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((vpj)((vrn)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((vrn)localObject2).jdField_a_of_type_Uyx.c(1);
            vmp.b("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    vmp.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((voi)localObject).a();
    } while ((localObject == null) || (((vnw)localObject).b() == null));
    localObject = ((vnw)localObject).b();
    int i = 0;
    label55:
    vpj localvpj;
    if (i < ((List)localObject).size())
    {
      localvpj = (vpj)((List)localObject).get(i);
      if ((localvpj != null) && (localvpj.a() != null)) {
        break label99;
      }
    }
    label99:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localvpj.a()).id))
    {
      i += 1;
      break label55;
      break;
    }
    int j;
    label155:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != ((stSimpleMetaFeed)localvpj.a()).is_ding)
    {
      if (((stSimpleMetaFeed)localvpj.a()).is_ding != 1) {
        break label207;
      }
      j = 1;
      if (j == 0) {
        break label212;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)localvpj.a();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      ((stSimpleMetaFeed)localvpj.a()).is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      d(paramWSSimpleBaseEvent.getFeedId());
      break;
      label207:
      j = 0;
      break label155;
      label212:
      localstSimpleMetaFeed = (stSimpleMetaFeed)localvpj.a();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((voi)localObject1).a();
      int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
        if ((localObject2 instanceof vrn))
        {
          localObject2 = (vrn)localObject2;
          stSimpleMetaFeed localstSimpleMetaFeed = a((vpj)((vrn)localObject2).jdField_a_of_type_JavaLangObject);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((vrn)localObject2).jdField_a_of_type_Uyx.c(0);
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
  
  public voi a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (voi)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    voi localvoi = a();
    if (localvoi == null) {
      return;
    }
    this.c = false;
    localvoi.e();
    localvoi.d();
    b(paramInt, paramString);
    vsj.a(null, 2, false, paramInt, localvoi.a(), localvoi.b());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(blij<vpj> paramblij, int paramInt) {}
  
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
  
  public void a(List<vpj> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    voi localvoi = a();
    if (localvoi == null) {
      return;
    }
    this.c = false;
    localvoi.e();
    localvoi.d();
    if (paramList.size() > 0)
    {
      a(paramList);
      a(paramBoolean1, paramBoolean2);
      a(paramList, a(paramBoolean1, paramBoolean2, paramList, paramObject));
    }
    for (;;)
    {
      vsj.a(paramList, 2, true, -1, localvoi.a(), localvoi.b());
      return;
      b(-1, "");
    }
  }
  
  public void a(@NonNull voi paramvoi) {}
  
  public void a(boolean paramBoolean)
  {
    vmp.e("WS_VIDEO_PLAY_TIME", "[AbsWSVerticalPagePresenter.java][reportVideoPlay] isPlay:" + paramBoolean);
    voi localvoi = a();
    if (localvoi != null)
    {
      localObject = localvoi.a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Object localObject = ((vnw)localObject).a();
    if (paramBoolean)
    {
      a(localvoi.a(), localvoi.b(), (WSPlayerManager)localObject);
      return;
    }
    b(localvoi.a(), localvoi.b(), (WSPlayerManager)localObject);
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
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<vpj> paramList, Object paramObject)
  {
    return false;
  }
  
  public int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public void b()
  {
    voi localvoi = a();
    if ((localvoi != null) && (localvoi.a() != null)) {
      localvoi.a().d(c());
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
    voi localvoi = a();
    if ((localvoi != null) && (localvoi.a() != null) && (b()))
    {
      localvoi.a().e();
      a(true);
    }
    if (b()) {
      vft.a().a(true);
    }
  }
  
  public void e()
  {
    voi localvoi = a();
    if ((localvoi != null) && (localvoi.a() != null))
    {
      localvoi.a().f();
      a(false);
    }
    vft.a().a(false);
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrx
 * JD-Core Version:    0.7.0.1
 */