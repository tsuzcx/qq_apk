import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.NativeAd.util.VideoFeedsSoftAdDownloadManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

public class jzr
  extends jzg
{
  private VideoFeedsRecyclerView a;
  
  public jzr(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramContext);
    this.a = paramVideoFeedsRecyclerView;
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    super.a(paramDownloadInfo, paramInt);
    try
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.mPackageName != null) && (localmrm.mPackageName.equals(paramDownloadInfo.packageName)))
        {
          localmrm.mState = paramInt;
          localmrm.mState = paramDownloadInfo.progress;
          a(localmrm, paramInt, paramDownloadInfo.progress);
        }
      }
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramDownloadInfo.getMessage());
    }
  }
  
  public void a(WadlResult paramWadlResult, int paramInt)
  {
    super.a(paramWadlResult, paramInt);
    try
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.mPackageName != null) && (localmrm.mAppID.equals(paramWadlResult.a.appId)) && (localmrm.mPackageName.equals(paramWadlResult.a.packageName)))
        {
          localmrm.mState = a(paramWadlResult);
          localmrm.aTP = paramWadlResult.progress;
          if (!TextUtils.isEmpty(paramWadlResult.aJb)) {
            localmrm.ajH = paramWadlResult.aJb;
          }
          a(localmrm, paramInt, paramWadlResult.progress);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(mrm parammrm, int paramInt1, int paramInt2)
  {
    super.a(parammrm, paramInt1, paramInt2);
    if (parammrm == null) {
      return;
    }
    Object localObject = (LinearLayoutManager)this.a.getLayoutManager();
    int j = ((LinearLayoutManager)localObject).findLastVisibleItemPosition();
    int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
    label38:
    if (i < j + 1)
    {
      localObject = this.a.getLayoutManager().findViewByPosition(i);
      if (localObject != null) {
        break label75;
      }
    }
    label75:
    do
    {
      do
      {
        do
        {
          i += 1;
          break label38;
          break;
          localObject = this.a.getChildViewHolder((View)localObject);
        } while (!(localObject instanceof mtg.l));
        localObject = (mtg.l)localObject;
      } while ((((mtg.l)localObject).by == null) || (((mtg.l)localObject).by.getVisibility() != 0));
      localObject = (kkx)((mtg.l)localObject).by.getTag(2131381960);
    } while ((localObject == null) || (!parammrm.mPackageName.equals(((kkx)localObject).aaC)));
    parammrm = ((mtg)((auwz)this.a.getAdapter()).a()).a();
    this.mainHandler.post(new VideoFeedsSoftAdDownloadManager.1(this, parammrm, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzr
 * JD-Core Version:    0.7.0.1
 */