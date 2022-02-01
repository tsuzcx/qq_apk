import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.3;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class sbc
  extends rxq<CertifiedAccountMeta.StFeed>
  implements RelativeAdFeedItemView.a, rwx
{
  private boolean aKR;
  private boolean ayF = true;
  protected RecyclerView.LayoutManager mLayoutManager;
  
  public sbc(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(SubscribeFeedsEvent paramSubscribeFeedsEvent)
  {
    Object localObject = new StringBuilder().append("fakeFeed state:").append(paramSubscribeFeedsEvent.mState).append(",fakeId:").append(paramSubscribeFeedsEvent.mTargetId).append(",fake listSize:");
    int i;
    if (paramSubscribeFeedsEvent.mFakeFeedDataList == null)
    {
      i = 0;
      QLog.d("FakerFeedsAdapter", 2, i);
      if (getShareData("share_key_subscribe_user") != null) {
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
              if (ryz.a() != null)
              {
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.icon.set(ryz.a().icon.get());
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.nick.set(ryz.a().nick.get());
              }
              getMainHandler().post(new FakerFeedsAdapter.1(this, paramSubscribeFeedsEvent));
              return;
            case 2: 
              i = aZ(paramSubscribeFeedsEvent.mTargetId);
            }
          } while (i == -1);
          localObject = rze.a((CertifiedAccountMeta.StFeed)getDataList().get(i));
          ((CertifiedAccountMeta.StFeed)localObject).id.set(paramSubscribeFeedsEvent.mSingleFakeFeed.id.get());
          ((CertifiedAccountMeta.StFeed)localObject).createTime.set(paramSubscribeFeedsEvent.mSingleFakeFeed.createTime.get());
          ((CertifiedAccountMeta.StFeed)localObject).cover.url.set(paramSubscribeFeedsEvent.mSingleFakeFeed.cover.url.get());
          getMainHandler().post(new FakerFeedsAdapter.2(this, (CertifiedAccountMeta.StFeed)localObject, i));
          return;
          i = aZ(paramSubscribeFeedsEvent.mTargetId);
        } while (i == -1);
        getMainHandler().post(new FakerFeedsAdapter.3(this, i));
        return;
      } while (!this.ayF);
      this.ayF = false;
    } while ((paramSubscribeFeedsEvent.mFakeFeedDataList == null) || (paramSubscribeFeedsEvent.mFakeFeedDataList.size() <= 0));
    if (ryz.a() != null)
    {
      localObject = paramSubscribeFeedsEvent.mFakeFeedDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((Iterator)localObject).next();
        if (localStFeed.poster != null)
        {
          localStFeed.poster.icon.set(ryz.a().icon.get());
          localStFeed.poster.nick.set(ryz.a().nick.get());
        }
      }
    }
    getMainHandler().post(new FakerFeedsAdapter.4(this, paramSubscribeFeedsEvent));
  }
  
  private int aZ(String paramString)
  {
    int i = 0;
    for (;;)
    {
      CertifiedAccountMeta.StFeed localStFeed;
      if (i < getDataList().size())
      {
        localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
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
  
  public boolean Mu()
  {
    return this.aKR;
  }
  
  public void bxO()
  {
    if ((this.mLayoutManager instanceof StaggeredGridLayoutManager)) {
      ((StaggeredGridLayoutManager)this.mLayoutManager).invalidateSpanAssignments();
    }
  }
  
  protected void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (getDataList() != null) {
      vd(getDataList().indexOf(paramStFeed));
    }
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
    this.mLayoutManager = paramRecyclerView.getLayoutManager();
    if (this.aKR)
    {
      rwv.a().a(this);
      avre.a().eBJ();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.aKR) {
      rwv.a().b(this);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubscribeFeedsEvent)) {
      a((SubscribeFeedsEvent)paramSimpleBaseEvent);
    }
  }
  
  public void reloadFakeFeeds()
  {
    if (Mu())
    {
      this.ayF = true;
      avre.a().eBJ();
    }
  }
  
  public void uu(boolean paramBoolean)
  {
    this.aKR = paramBoolean;
  }
  
  public void vd(int paramInt)
  {
    if (auqt.b(paramInt, getDataList())) {
      return;
    }
    getDataList().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbc
 * JD-Core Version:    0.7.0.1
 */