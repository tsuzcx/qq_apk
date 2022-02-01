import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.3;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zsu
  extends zou<CertifiedAccountMeta.StFeed>
  implements aabt, SimpleEventReceiver
{
  protected RecyclerView.LayoutManager a;
  private boolean c = true;
  private boolean d;
  
  public zsu(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      CertifiedAccountMeta.StFeed localStFeed;
      if (i < a().size())
      {
        localStFeed = (CertifiedAccountMeta.StFeed)a().get(i);
        if ((paramString.startsWith("fakeid_")) && (!localStFeed.id.get().startsWith("fakeid_"))) {
          QLog.d("FakerFeedsAdapter", 2, "has none fakeFeeds");
        }
      }
      else
      {
        return -1;
      }
      if (paramString.equals(localStFeed.id.get()))
      {
        QLog.d("FakerFeedsAdapter", 2, "find fakeid:" + paramString);
        return i;
      }
      i += 1;
    }
  }
  
  private void a(SubscribeFeedsEvent paramSubscribeFeedsEvent)
  {
    Object localObject = new StringBuilder().append("fakeFeed state:").append(paramSubscribeFeedsEvent.mState).append(",fakeId:").append(paramSubscribeFeedsEvent.mTargetId).append(",fake listSize:");
    int i;
    if (paramSubscribeFeedsEvent.mFakeFeedDataList == null)
    {
      i = 0;
      QLog.d("FakerFeedsAdapter", 2, i);
      if (a("share_key_subscribe_user") != null) {
        break label83;
      }
    }
    label83:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i = paramSubscribeFeedsEvent.mFakeFeedDataList.size();
            break;
            switch (paramSubscribeFeedsEvent.mState)
            {
            default: 
              return;
            case 1: 
              if (zqh.a() != null)
              {
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.icon.set(zqh.a().icon.get());
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.nick.set(zqh.a().nick.get());
              }
              a().post(new FakerFeedsAdapter.1(this, paramSubscribeFeedsEvent));
              return;
            case 2: 
              i = a(paramSubscribeFeedsEvent.mTargetId);
            }
          } while (i == -1);
          localObject = zqn.a((CertifiedAccountMeta.StFeed)a().get(i));
          ((CertifiedAccountMeta.StFeed)localObject).id.set(paramSubscribeFeedsEvent.mSingleFakeFeed.id.get());
          ((CertifiedAccountMeta.StFeed)localObject).createTime.set(paramSubscribeFeedsEvent.mSingleFakeFeed.createTime.get());
          ((CertifiedAccountMeta.StFeed)localObject).cover.url.set(paramSubscribeFeedsEvent.mSingleFakeFeed.cover.url.get());
          a().post(new FakerFeedsAdapter.2(this, (CertifiedAccountMeta.StFeed)localObject, i));
          return;
          i = a(paramSubscribeFeedsEvent.mTargetId);
        } while (i == -1);
        a().post(new FakerFeedsAdapter.3(this, i));
        return;
      } while (!this.c);
      this.c = false;
    } while ((paramSubscribeFeedsEvent.mFakeFeedDataList == null) || (paramSubscribeFeedsEvent.mFakeFeedDataList.size() <= 0));
    if (zqh.a() != null)
    {
      localObject = paramSubscribeFeedsEvent.mFakeFeedDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((Iterator)localObject).next();
        if (localStFeed.poster != null)
        {
          localStFeed.poster.icon.set(zqh.a().icon.get());
          localStFeed.poster.nick.set(zqh.a().nick.get());
        }
      }
    }
    a().post(new FakerFeedsAdapter.4(this, paramSubscribeFeedsEvent));
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (a() != null) {
      c(a().indexOf(paramStFeed));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c()
  {
    if ((this.a instanceof StaggeredGridLayoutManager)) {
      ((StaggeredGridLayoutManager)this.a).invalidateSpanAssignments();
    }
  }
  
  public void c(int paramInt)
  {
    if (ArrayUtils.isOutOfArrayIndex(paramInt, a())) {
      return;
    }
    a().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  public void d()
  {
    if (e())
    {
      this.c = true;
      QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
    }
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribeFeedsEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.a = paramRecyclerView.getLayoutManager();
    if (this.d)
    {
      SimpleEventBus.getInstance().registerReceiver(this);
      QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.d) {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubscribeFeedsEvent)) {
      a((SubscribeFeedsEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsu
 * JD-Core Version:    0.7.0.1
 */