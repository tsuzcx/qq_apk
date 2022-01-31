import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class tih
  extends tie<tit>
{
  private int a;
  
  private void a(RecyclerView paramRecyclerView, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((localObject instanceof tjo))
      {
        localObject = (tjo)localObject;
        stSimpleMetaPerson localstSimpleMetaPerson = ((tjo)localObject).a();
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
          ((tjo)localObject).a();
        }
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    if ((a() == null) || (((tit)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((tit)a()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          RecyclerView.ViewHolder localViewHolder = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localViewHolder instanceof tfr)) {
            a(((tfr)localViewHolder).a(), paramString);
          }
          i += 1;
        }
      }
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject1 = (WSItemExposeEvent)paramWSSimpleBaseEvent;
    Object localObject2 = new StringBuilder().append("handleItemExposeEvent event: ");
    if (localObject1 == null)
    {
      paramWSSimpleBaseEvent = "null";
      tlo.b("WSFollowPresenter", paramWSSimpleBaseEvent);
      if ((localObject1 != null) && (((WSItemExposeEvent)localObject1).video != null)) {
        break label60;
      }
    }
    for (;;)
    {
      return;
      paramWSSimpleBaseEvent = ((WSItemExposeEvent)localObject1).video;
      break;
      label60:
      paramWSSimpleBaseEvent = ((tit)a()).a();
      if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.a() != null))
      {
        localObject2 = ((tit)a()).a();
        if ((localObject2 != null) && (((XRecyclerView)localObject2).a() != null))
        {
          localObject1 = ((WSItemExposeEvent)localObject1).video;
          List localList = tel.a().b;
          if (paramWSSimpleBaseEvent.a().size() < localList.size()) {
            ((tit)a()).a(localList);
          }
          int i = 0;
          while (i < localList.size())
          {
            if (((stFeed)localList.get(i)).feed == localObject1)
            {
              ((XRecyclerView)localObject2).a().scrollToPosition(i);
              this.a = i;
              tlo.b("WSFollowPresenter", "receive item expose event, position: " + i + ", feed: " + ((stSimpleMetaFeed)localObject1).feed_desc);
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    if ((a() == null) || (((tit)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((tit)a()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof tfk))
          {
            localObject = (tfk)localObject;
            stFeed localstFeed = ((tfk)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.poster != null) && (TextUtils.equals(localstFeed.feed.poster.id, paramString))) {
              ((tfk)localObject).b();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    tlo.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = ((tit)a()).a();
    if ((localObject1 == null) || (((tbb)localObject1).a() == null)) {
      return;
    }
    localObject1 = ((tbb)localObject1).a();
    int i = 0;
    label49:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (stFeed)((List)localObject1).get(i);
      if ((localObject2 != null) && (((stFeed)localObject2).feed != null) && (((stFeed)localObject2).feed.poster != null)) {
        break label104;
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label104:
      if ((((stFeed)localObject2).feed_type == 1) && (((stFeed)localObject2).person_meta != null))
      {
        localObject2 = ((stFeed)localObject2).person_meta;
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)((ArrayList)localObject2).get(j);
          if (TextUtils.equals(localstSimpleMetaPerson.id, paramWSSimpleBaseEvent.getPersonId()))
          {
            localstSimpleMetaPerson.followStatus = paramWSSimpleBaseEvent.getIsFollow();
            a(localstSimpleMetaPerson.id);
          }
          j += 1;
        }
      }
      else if ((((stFeed)localObject2).feed_type == 2) && (((stFeed)localObject2).feed != null))
      {
        localObject2 = ((stFeed)localObject2).feed.poster;
        if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
        {
          ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
          b(paramWSSimpleBaseEvent.getPersonId());
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((a() == null) || (((tit)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((tit)a()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof tfk))
          {
            localObject = (tfk)localObject;
            stFeed localstFeed = ((tfk)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString)))
            {
              tlo.b("WSFollowPresenter", "updateLikeStatus");
              ((tfk)localObject).a();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (WSVideoPlayEvent)paramWSSimpleBaseEvent;
    tlo.b("WSFollowPresenter", "handleVideoPlayEvent mCurrentPosition: " + paramWSSimpleBaseEvent.mCurrentPosition);
  }
  
  private void e(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    tlo.b("WSFollowPresenter", "handleLikeEvent feedId: " + paramWSSimpleBaseEvent.getFeedId() + " isDing:" + paramWSSimpleBaseEvent.getRspIsDing());
    Object localObject = ((tit)a()).a();
    if ((localObject == null) || (((tbb)localObject).a() == null)) {
      return;
    }
    localObject = ((tbb)localObject).a();
    int i = 0;
    label81:
    stFeed localstFeed;
    if (i < ((List)localObject).size())
    {
      localstFeed = (stFeed)((List)localObject).get(i);
      if ((localstFeed != null) || (localstFeed.feed != null)) {
        break label125;
      }
    }
    label125:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id))
    {
      i += 1;
      break label81;
      break;
    }
    int j;
    label172:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != localstFeed.feed.is_ding)
    {
      if (localstFeed.feed.is_ding != 1) {
        break label218;
      }
      j = 1;
      if (j == 0) {
        break label223;
      }
      localstSimpleMetaFeed = localstFeed.feed;
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      localstFeed.feed.is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      c(paramWSSimpleBaseEvent.getFeedId());
      break;
      label218:
      j = 0;
      break label172;
      label223:
      localstSimpleMetaFeed = localstFeed.feed;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent)) {
      e(paramWSSimpleBaseEvent);
    }
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof WSVideoPlayEvent))
      {
        d(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSItemExposeEvent))
      {
        b(paramWSSimpleBaseEvent);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof FollowEvent));
    c(paramWSSimpleBaseEvent);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((tit)a()).a(false);
    tel.a().a(paramBoolean1, paramBoolean2, "", 9, new tii(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tih
 * JD-Core Version:    0.7.0.1
 */