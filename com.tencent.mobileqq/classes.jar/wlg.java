import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.3;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class wlg
  extends wpc<CertifiedAccountMeta.StFeed>
  implements wpy, wvt
{
  private Handler a;
  protected RecyclerView.LayoutManager a;
  private boolean c = true;
  private boolean d;
  
  public wlg(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      CertifiedAccountMeta.StFeed localStFeed;
      if (i < b().size())
      {
        localStFeed = (CertifiedAccountMeta.StFeed)b().get(i);
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
              if (wiq.a() != null)
              {
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.icon.set(wiq.a().icon.get());
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.nick.set(wiq.a().nick.get());
              }
              a().post(new FakerFeedsAdapter.1(this, paramSubscribeFeedsEvent));
              return;
            case 2: 
              i = a(paramSubscribeFeedsEvent.mTargetId);
            }
          } while (i == -1);
          ((CertifiedAccountMeta.StFeed)b().get(i)).id.set(paramSubscribeFeedsEvent.mSingleFakeFeed.id.get());
          ((CertifiedAccountMeta.StFeed)b().get(i)).createTime.set(paramSubscribeFeedsEvent.mSingleFakeFeed.createTime.get());
          a().post(new FakerFeedsAdapter.2(this));
          return;
          i = a(paramSubscribeFeedsEvent.mTargetId);
        } while (i == -1);
        a().post(new FakerFeedsAdapter.3(this, i));
        return;
      } while (!this.c);
      this.c = false;
    } while ((paramSubscribeFeedsEvent.mFakeFeedDataList == null) || (paramSubscribeFeedsEvent.mFakeFeedDataList.size() <= 0));
    if (wiq.a() != null)
    {
      localObject = paramSubscribeFeedsEvent.mFakeFeedDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((Iterator)localObject).next();
        if (localStFeed.poster != null)
        {
          localStFeed.poster.icon.set(wiq.a().icon.get());
          localStFeed.poster.nick.set(wiq.a().nick.get());
        }
      }
    }
    a().post(new FakerFeedsAdapter.4(this, paramSubscribeFeedsEvent));
  }
  
  protected Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribeFeedsEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (bfmh.a(paramInt, b())) {
      return;
    }
    b().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (b() != null) {
      a(b().indexOf(paramStFeed));
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubscribeFeedsEvent)) {
      a((SubscribeFeedsEvent)paramSimpleBaseEvent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof StaggeredGridLayoutManager)) {
      ((StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).invalidateSpanAssignments();
    }
  }
  
  public void c()
  {
    if (c())
    {
      this.c = true;
      bgzq.a().a();
    }
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramRecyclerView.getLayoutManager();
    if (this.d)
    {
      wpw.a().a(this);
      bgzq.a().a();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.d) {
      wpw.a().b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlg
 * JD-Core Version:    0.7.0.1
 */