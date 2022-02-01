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

public abstract class oso
  implements oqi.a, oqm
{
  public oqi.b a;
  private boolean ayd;
  public boolean aye;
  public int mCurrentPosition;
  public WeakReference<oqi.b> x;
  
  public oso(oqi.b paramb)
  {
    this.x = new WeakReference(paramb);
    this.a = ((oqi.b)this.x.get());
  }
  
  private stSimpleMetaFeed a(oqr paramoqr)
  {
    if ((paramoqr != null) && ((paramoqr.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramoqr.B();
    }
    return null;
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ooz.d("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    if (this.a == null) {}
    do
    {
      return;
      localObject1 = this.a.a();
    } while ((localObject1 == null) || (((oqb)localObject1).be() == null));
    Object localObject1 = ((oqb)localObject1).be();
    int i = 0;
    label48:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (oqr)((List)localObject1).get(i);
      if ((localObject2 != null) && (((oqr)localObject2).B() != null) && (((stSimpleMetaFeed)((oqr)localObject2).B()).poster != null)) {
        break label104;
      }
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label104:
      localObject2 = ((stSimpleMetaFeed)((oqr)localObject2).B()).poster;
      if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
      {
        ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
        updateFollowStatus(paramWSSimpleBaseEvent.getPersonId());
      }
    }
  }
  
  private void g(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ooz.d("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    if (this.a == null) {}
    do
    {
      return;
      localObject = this.a.a();
    } while ((localObject == null) || (((oqb)localObject).be() == null));
    Object localObject = ((oqb)localObject).be();
    int i = 0;
    label48:
    oqr localoqr;
    if (i < ((List)localObject).size())
    {
      localoqr = (oqr)((List)localObject).get(i);
      if ((localoqr != null) && (localoqr.B() != null)) {
        break label90;
      }
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label90:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localoqr.B()).id))
      {
        ooz.w("AbsWSVerticalPagePresenter", "data.getItemInfo().total_comment_num:" + ((stSimpleMetaFeed)localoqr.B()).total_comment_num);
        ooz.w("AbsWSVerticalPagePresenter", "wsAddCommentEvent.getCommentNum():" + paramWSSimpleBaseEvent.getCommentNum());
        ((stSimpleMetaFeed)localoqr.B()).total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
        pT(paramWSSimpleBaseEvent.getFeedId());
        if (ojk.e != null)
        {
          ojk.e.total_comment_num = ((stSimpleMetaFeed)localoqr.B()).total_comment_num;
          ooz.w("AbsWSVerticalPagePresenter", " WSGridCardPresenter.clickFeed.total_comment_num:" + ojk.e.total_comment_num);
        }
      }
    }
  }
  
  private void h(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ooz.d("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    if (this.a == null) {}
    do
    {
      return;
      localObject = this.a.a();
    } while ((localObject == null) || (((oqb)localObject).be() == null));
    Object localObject = ((oqb)localObject).be();
    int i = 0;
    label53:
    oqr localoqr;
    if (i < ((List)localObject).size())
    {
      localoqr = (oqr)((List)localObject).get(i);
      if ((localoqr != null) && (localoqr.B() != null)) {
        break label97;
      }
    }
    label97:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), ((stSimpleMetaFeed)localoqr.B()).id))
    {
      i += 1;
      break label53;
      break;
    }
    int j;
    label153:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != ((stSimpleMetaFeed)localoqr.B()).is_ding)
    {
      if (((stSimpleMetaFeed)localoqr.B()).is_ding != 1) {
        break label205;
      }
      j = 1;
      if (j == 0) {
        break label210;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)localoqr.B();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      ((stSimpleMetaFeed)localoqr.B()).is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      pJ(paramWSSimpleBaseEvent.getFeedId());
      break;
      label205:
      j = 0;
      break label153;
      label210:
      localstSimpleMetaFeed = (stSimpleMetaFeed)localoqr.B();
    }
  }
  
  private void pJ(String paramString)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.a.a();
      int j = localVideoFeedsRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(i));
        if ((localObject instanceof osf))
        {
          localObject = (osf)localObject;
          stSimpleMetaFeed localstSimpleMetaFeed = a((oqr)((osf)localObject).be);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((osf)localObject).a.uE(0);
          }
        }
        i += 1;
      }
    }
  }
  
  private void pT(String paramString)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.a.a();
      int j = localVideoFeedsRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(i));
        if ((localObject instanceof osf))
        {
          localObject = (osf)localObject;
          stSimpleMetaFeed localstSimpleMetaFeed = a((oqr)((osf)localObject).be);
          if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
            ((osf)localObject).a.uE(2);
          }
        }
        i += 1;
      }
    }
  }
  
  private void updateFollowStatus(String paramString)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.a.a();
      int j = localVideoFeedsRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = localVideoFeedsRecyclerView.getChildViewHolder(localVideoFeedsRecyclerView.getChildAt(i));
        if ((localObject instanceof osf))
        {
          localObject = (osf)localObject;
          stSimpleMetaFeed localstSimpleMetaFeed = a((oqr)((osf)localObject).be);
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((osf)localObject).a.uE(1);
            ooz.d("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean Ho()
  {
    return true;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent == null) {}
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        h(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        d(paramWSSimpleBaseEvent);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof WSAddCommentEvent));
    g(paramWSSimpleBaseEvent);
  }
  
  public void a(@NonNull oqi.b paramb) {}
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.mCurrentPosition = paramInt;
  }
  
  public void bgg()
  {
    this.aye = true;
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.ayd) {
      return;
    }
    this.ayd = a(paramBoolean1, paramBoolean2, paramString);
  }
  
  public void dB(List<oqr> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oqr localoqr = (oqr)paramList.next();
      if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
        localArrayList.add((stSimpleMetaFeed)localoqr.B());
      }
    }
    opn.t(localArrayList, false);
  }
  
  public int dJ(int paramInt)
  {
    return paramInt;
  }
  
  public void destroy()
  {
    if ((this.a != null) && (this.a.a() != null)) {
      this.a.a().qR(Ho());
    }
  }
  
  public void detachView() {}
  
  public void doOnPause()
  {
    if ((this.a != null) && (this.a.a() != null)) {
      this.a.a().doOnPause();
    }
  }
  
  public void doOnResume()
  {
    if ((this.a != null) && (this.a.a() != null)) {
      this.a.a().doOnResume();
    }
  }
  
  public void initData() {}
  
  public void onFailed(int paramInt, String paramString)
  {
    this.ayd = false;
    WSPublicAccReport.getInstance().reportEnterVerticalVideo(null, 2, false, paramInt);
  }
  
  public void onSuccess(List<oqr> paramList)
  {
    this.ayd = false;
    if ((this.a != null) && (paramList.size() > 0))
    {
      dB(paramList);
      this.a.hideLoading();
      this.a.setData(paramList);
    }
    WSPublicAccReport.getInstance().reportEnterVerticalVideo(paramList, 2, true, -1);
  }
  
  public int rN()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oso
 * JD-Core Version:    0.7.0.1
 */