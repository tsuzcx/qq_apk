import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ulv
  extends uls<umj>
{
  private int jdField_a_of_type_Int;
  private stFollowFeedsGlobalConfig jdField_a_of_type_UserGrowthStFollowFeedsGlobalConfig;
  
  private void a(RecyclerView paramRecyclerView, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      stSimpleMetaPerson localstSimpleMetaPerson;
      if ((localObject instanceof unl))
      {
        localObject = (unl)localObject;
        localstSimpleMetaPerson = ((unl)localObject).a();
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
          ((unl)localObject).a();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof unh))
        {
          localObject = (unh)localObject;
          localstSimpleMetaPerson = ((unh)localObject).a();
          if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
            ((unh)localObject).b();
          }
        }
      }
    }
  }
  
  private void a(FollowEvent paramFollowEvent, stFeed paramstFeed)
  {
    if ((paramstFeed.friendFeed != null) && (paramstFeed.friendFeed.friendFeeds != null))
    {
      paramstFeed = paramstFeed.friendFeed.friendFeeds;
      int i = 0;
      while (i < paramstFeed.size())
      {
        stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)paramstFeed.get(i)).poster;
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramFollowEvent.getPersonId())))
        {
          localstSimpleMetaPerson.followStatus = paramFollowEvent.getIsFollow();
          a(localstSimpleMetaPerson.id);
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((a() == null) || (((umj)a()).a() == null)) {}
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter;
    do
    {
      return;
      localRecyclerViewWithHeaderFooter = ((umj)a()).a().a();
    } while (localRecyclerViewWithHeaderFooter == null);
    int j = localRecyclerViewWithHeaderFooter.getChildCount();
    int i = 0;
    label53:
    RecyclerView.ViewHolder localViewHolder;
    if (i < j)
    {
      localViewHolder = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
      if (!(localViewHolder instanceof uik)) {
        break label99;
      }
      a(((uik)localViewHolder).a(), paramString);
    }
    for (;;)
    {
      i += 1;
      break label53;
      break;
      label99:
      if ((localViewHolder instanceof uih)) {
        a(((uih)localViewHolder).a(), paramString);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a() == null) || (((umj)a()).a() == null)) {
      return;
    }
    Iterator localIterator = ((umj)a()).a().a().iterator();
    label42:
    StringBuilder localStringBuilder;
    while (localIterator.hasNext())
    {
      localObject = (blsy)localIterator.next();
      if ((localObject instanceof uhz))
      {
        localObject = (uhz)localObject;
        ((uhz)localObject).a(paramBoolean);
        localStringBuilder = new StringBuilder().append("updateMuteStatus title:");
        if (((uhz)localObject).a == null) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((uhz)localObject).a.d;; localObject = "videoInfo is null!")
    {
      uqf.e("WSFollowPresenter", (String)localObject);
      break label42;
      break;
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    a(((WSPlayerMuteEvent)paramWSSimpleBaseEvent).isPlayerMute());
  }
  
  private void b(String paramString)
  {
    if ((a() == null) || (((umj)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((umj)a()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof uhz))
          {
            localObject = (uhz)localObject;
            stFeed localstFeed = ((uhz)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.poster != null) && (TextUtils.equals(localstFeed.feed.poster.id, paramString))) {
              ((uhz)localObject).f();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSFriendFeedExposureEvent localWSFriendFeedExposureEvent = (WSFriendFeedExposureEvent)paramWSSimpleBaseEvent;
    Object localObject = new StringBuilder().append("handleOnReceiveEventForFriendFeed event: ");
    if (localWSFriendFeedExposureEvent == null)
    {
      paramWSSimpleBaseEvent = "null";
      uqf.b("WSFollowPresenter", paramWSSimpleBaseEvent);
      if ((localWSFriendFeedExposureEvent != null) && (localWSFriendFeedExposureEvent.video != null)) {
        break label68;
      }
    }
    label195:
    for (;;)
    {
      return;
      paramWSSimpleBaseEvent = Integer.valueOf(localWSFriendFeedExposureEvent.currentPosition);
      break;
      label68:
      paramWSSimpleBaseEvent = ((umj)a()).a();
      if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.a() != null))
      {
        paramWSSimpleBaseEvent = ((umj)a()).a();
        if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.a() != null))
        {
          paramWSSimpleBaseEvent = paramWSSimpleBaseEvent.a();
          int j = paramWSSimpleBaseEvent.getChildCount();
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label195;
            }
            localObject = paramWSSimpleBaseEvent.getChildViewHolder(paramWSSimpleBaseEvent.getChildAt(i));
            if ((localObject instanceof uih))
            {
              paramWSSimpleBaseEvent = ((uih)localObject).a();
              paramWSSimpleBaseEvent.smoothScrollToPosition(localWSFriendFeedExposureEvent.currentPosition);
              if (paramWSSimpleBaseEvent.getAdapter() == null) {
                break;
              }
              paramWSSimpleBaseEvent.getAdapter().notifyItemChanged(localWSFriendFeedExposureEvent.currentPosition);
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((a() == null) || (((umj)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((umj)a()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof uhz))
          {
            localObject = (uhz)localObject;
            stFeed localstFeed = ((uhz)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString)))
            {
              uqf.b("WSFollowPresenter", "updateLikeStatus");
              ((uhz)localObject).e();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject1 = (WSItemExposeEvent)paramWSSimpleBaseEvent;
    Object localObject2 = new StringBuilder().append("handleItemExposeEvent event: ");
    if (localObject1 == null)
    {
      paramWSSimpleBaseEvent = "null";
      uqf.b("WSFollowPresenter", paramWSSimpleBaseEvent);
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
      paramWSSimpleBaseEvent = ((umj)a()).a();
      if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.a() != null))
      {
        localObject2 = ((umj)a()).a();
        if ((localObject2 != null) && (((XRecyclerView)localObject2).a() != null))
        {
          localObject1 = ((WSItemExposeEvent)localObject1).video;
          List localList = ugl.a().b;
          if (paramWSSimpleBaseEvent.a().size() < localList.size()) {
            ((umj)a()).a(localList);
          }
          int i = 0;
          while (i < localList.size())
          {
            if (((stFeed)localList.get(i)).feed == localObject1)
            {
              ((XRecyclerView)localObject2).a().scrollToPosition(i);
              this.jdField_a_of_type_Int = i;
              uqf.b("WSFollowPresenter", "receive item expose event, position: " + i + ", feed: " + ((stSimpleMetaFeed)localObject1).feed_desc);
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void d(String paramString)
  {
    if ((a() == null) || (((umj)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((umj)a()).a().a();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof uhz))
          {
            localObject = (uhz)localObject;
            stFeed localstFeed = ((uhz)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString))) {
              ((uhz)localObject).a(localstFeed.feed);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void e(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uqf.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = ((umj)a()).a();
    if ((localObject1 == null) || (((ucr)localObject1).a() == null)) {
      return;
    }
    localObject1 = ((ucr)localObject1).a();
    int i = 0;
    label50:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (stFeed)((List)localObject1).get(i);
      if ((localObject2 != null) && (((stFeed)localObject2).feed != null) && (((stFeed)localObject2).feed.poster != null)) {
        break label105;
      }
    }
    for (;;)
    {
      i += 1;
      break label50;
      break;
      label105:
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
      else if (((stFeed)localObject2).feed_type == 4)
      {
        a(paramWSSimpleBaseEvent, (stFeed)localObject2);
      }
    }
  }
  
  private void f(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (WSVideoPlayEvent)paramWSSimpleBaseEvent;
    uqf.b("WSFollowPresenter", "handleVideoPlayEvent mCurrentPosition: " + paramWSSimpleBaseEvent.mCurrentPosition);
  }
  
  private void g(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    uqf.b("WSFollowPresenter", "handleLikeEvent feedId: " + paramWSSimpleBaseEvent.getFeedId() + " isDing:" + paramWSSimpleBaseEvent.getRspIsDing());
    Object localObject = ((umj)a()).a();
    if ((localObject == null) || (((ucr)localObject).a() == null)) {
      return;
    }
    localObject = ((ucr)localObject).a();
    int i = 0;
    label83:
    stFeed localstFeed;
    if (i < ((List)localObject).size())
    {
      localstFeed = (stFeed)((List)localObject).get(i);
      if ((localstFeed != null) || (localstFeed.feed != null)) {
        break label127;
      }
    }
    label127:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id))
    {
      i += 1;
      break label83;
      break;
    }
    int j;
    label174:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != localstFeed.feed.is_ding)
    {
      if (localstFeed.feed.is_ding != 1) {
        break label220;
      }
      j = 1;
      if (j == 0) {
        break label225;
      }
      localstSimpleMetaFeed = localstFeed.feed;
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      localstFeed.feed.is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      c(paramWSSimpleBaseEvent.getFeedId());
      break;
      label220:
      j = 0;
      break label174;
      label225:
      localstSimpleMetaFeed = localstFeed.feed;
    }
  }
  
  private void h(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    uqf.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = ((umj)a()).a();
    if ((localObject == null) || (((ucr)localObject).a() == null)) {
      return;
    }
    localObject = ((ucr)localObject).a();
    int i = 0;
    label45:
    stFeed localstFeed;
    if (i < ((List)localObject).size())
    {
      localstFeed = (stFeed)((List)localObject).get(i);
      if ((localstFeed != null) && (localstFeed.feed != null)) {
        break label87;
      }
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label87:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id)) {
        d(paramWSSimpleBaseEvent.getFeedId());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public stFollowFeedsGlobalConfig a()
  {
    return this.jdField_a_of_type_UserGrowthStFollowFeedsGlobalConfig;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent)) {
      g(paramWSSimpleBaseEvent);
    }
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof WSVideoPlayEvent))
      {
        f(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSItemExposeEvent))
      {
        d(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        e(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSAddCommentEvent))
      {
        h(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSFriendFeedExposureEvent))
      {
        c(paramWSSimpleBaseEvent);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof WSPlayerMuteEvent));
    b(paramWSSimpleBaseEvent);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a() == null) {
      return;
    }
    if (paramBoolean1) {
      ((umj)a()).c();
    }
    long l = System.currentTimeMillis();
    ugl.a().a(paramBoolean1, paramBoolean2, "", 9, new ulw(this, l, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulv
 * JD-Core Version:    0.7.0.1
 */