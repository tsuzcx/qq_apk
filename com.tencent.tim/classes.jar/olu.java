import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class olu
  extends olr<omg>
{
  private int mLastPosition;
  
  private void a(RecyclerView paramRecyclerView, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((localObject instanceof ona))
      {
        localObject = (ona)localObject;
        stSimpleMetaPerson localstSimpleMetaPerson = ((ona)localObject).b();
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
          ((ona)localObject).bfi();
        }
      }
      i += 1;
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject1 = (WSItemExposeEvent)paramWSSimpleBaseEvent;
    Object localObject2 = new StringBuilder().append("handleItemExposeEvent event: ");
    if (localObject1 == null)
    {
      paramWSSimpleBaseEvent = "null";
      ooz.d("WSFollowPresenter", paramWSSimpleBaseEvent);
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
      paramWSSimpleBaseEvent = ((omg)b()).a();
      if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.be() != null))
      {
        localObject2 = ((omg)b()).a();
        if ((localObject2 != null) && (((XRecyclerView)localObject2).a() != null))
        {
          localObject1 = ((WSItemExposeEvent)localObject1).video;
          List localList = oie.a().lb;
          if (paramWSSimpleBaseEvent.be().size() < localList.size()) {
            ((omg)b()).setData(localList);
          }
          int i = 0;
          while (i < localList.size())
          {
            if (((stFeed)localList.get(i)).feed == localObject1)
            {
              ((XRecyclerView)localObject2).a().scrollToPosition(i);
              this.mLastPosition = i;
              ooz.d("WSFollowPresenter", "receive item expose event, position: " + i + ", feed: " + ((stSimpleMetaFeed)localObject1).feed_desc);
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ooz.d("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = ((omg)b()).a();
    if ((localObject1 == null) || (((oey)localObject1).be() == null)) {
      return;
    }
    localObject1 = ((oey)localObject1).be();
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
            pI(localstSimpleMetaPerson.id);
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
          updateFollowStatus(paramWSSimpleBaseEvent.getPersonId());
        }
      }
    }
  }
  
  private void e(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (WSVideoPlayEvent)paramWSSimpleBaseEvent;
    ooz.d("WSFollowPresenter", "handleVideoPlayEvent mCurrentPosition: " + paramWSSimpleBaseEvent.mCurrentPosition);
  }
  
  private void f(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    ooz.d("WSFollowPresenter", "handleLikeEvent feedId: " + paramWSSimpleBaseEvent.getFeedId() + " isDing:" + paramWSSimpleBaseEvent.getRspIsDing());
    Object localObject = ((omg)b()).a();
    if ((localObject == null) || (((oey)localObject).be() == null)) {
      return;
    }
    localObject = ((oey)localObject).be();
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
      pJ(paramWSSimpleBaseEvent.getFeedId());
      break;
      label218:
      j = 0;
      break label172;
      label223:
      localstSimpleMetaFeed = localstFeed.feed;
    }
  }
  
  private void g(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ooz.d("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = ((omg)b()).a();
    if ((localObject == null) || (((oey)localObject).be() == null)) {
      return;
    }
    localObject = ((oey)localObject).be();
    int i = 0;
    label44:
    stFeed localstFeed;
    if (i < ((List)localObject).size())
    {
      localstFeed = (stFeed)((List)localObject).get(i);
      if ((localstFeed != null) && (localstFeed.feed != null)) {
        break label86;
      }
    }
    for (;;)
    {
      i += 1;
      break label44;
      break;
      label86:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id)) {
        pK(paramWSSimpleBaseEvent.getFeedId());
      }
    }
  }
  
  private void pI(String paramString)
  {
    if ((b() == null) || (((omg)b()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((omg)b()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          RecyclerView.ViewHolder localViewHolder = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localViewHolder instanceof ojg)) {
            a(((ojg)localViewHolder).a(), paramString);
          }
          i += 1;
        }
      }
    }
  }
  
  private void pJ(String paramString)
  {
    if ((b() == null) || (((omg)b()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((omg)b()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof oiy))
          {
            localObject = (oiy)localObject;
            stFeed localstFeed = ((oiy)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString)))
            {
              ooz.d("WSFollowPresenter", "updateLikeStatus");
              ((oiy)localObject).bfh();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void pK(String paramString)
  {
    if ((b() == null) || (((omg)b()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((omg)b()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof oiy))
          {
            localObject = (oiy)localObject;
            stFeed localstFeed = ((oiy)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString))) {
              ((oiy)localObject).c(localstFeed.feed);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void updateFollowStatus(String paramString)
  {
    if ((b() == null) || (((omg)b()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((omg)b()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof oiy))
          {
            localObject = (oiy)localObject;
            stFeed localstFeed = ((oiy)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.poster != null) && (TextUtils.equals(localstFeed.feed.poster.id, paramString))) {
              ((oiy)localObject).bfi();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent)) {
      f(paramWSSimpleBaseEvent);
    }
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof WSVideoPlayEvent))
      {
        e(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSItemExposeEvent))
      {
        c(paramWSSimpleBaseEvent);
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
  
  public void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b() == null) {
      return;
    }
    if (paramBoolean1) {
      ((omg)b()).showLoading(false);
    }
    long l = System.currentTimeMillis();
    oie.a().a(paramBoolean1, paramBoolean2, "", 9, new olv(this, l, paramBoolean1));
  }
  
  public int rE()
  {
    return this.mLastPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olu
 * JD-Core Version:    0.7.0.1
 */