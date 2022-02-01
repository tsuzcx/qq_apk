import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.NativeAd.util.ADVideoFeedsVideoAppDownlodManager.1;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

public class jzj
  extends jzg
{
  private VideoFeedsRecyclerView a;
  
  public jzj(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
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
        if ((localmrm.mPackageName != null) && (localmrm.mPackageName.equals(paramDownloadInfo.packageName)) && (localmrm.gameAdComData != null))
        {
          localmrm.gameAdComData.downloadState = paramInt;
          localmrm.gameAdComData.progress = paramDownloadInfo.progress;
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
        if ((localmrm.mPackageName != null) && (localmrm.mAppID.equals(paramWadlResult.a.appId)) && (localmrm.mPackageName.equals(paramWadlResult.a.packageName)) && (localmrm.gameAdComData != null))
        {
          localmrm.gameAdComData.downloadState = a(paramWadlResult);
          localmrm.gameAdComData.progress = paramWadlResult.progress;
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
    if ((parammrm == null) || (parammrm.gameAdComData == null)) {
      return;
    }
    Object localObject = (LinearLayoutManager)this.a.getLayoutManager();
    int j = ((LinearLayoutManager)localObject).findLastVisibleItemPosition();
    int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
    label45:
    if (i < j + 1)
    {
      localObject = this.a.getLayoutManager().findViewByPosition(i);
      if (localObject != null) {
        break label82;
      }
    }
    label82:
    do
    {
      do
      {
        do
        {
          i += 1;
          break label45;
          break;
          localObject = this.a.getChildViewHolder((View)localObject);
        } while (!(localObject instanceof mtg.l));
        localObject = (mtg.l)localObject;
      } while ((((mtg.l)localObject).bv == null) || (((mtg.l)localObject).bv.getVisibility() != 0));
      localObject = (VideoInfo.GameAdComData)((mtg.l)localObject).bv.getTag(2131381960);
    } while ((localObject == null) || (!"2".equals(((VideoInfo.GameAdComData)localObject).Xk)) || (!parammrm.mPackageName.equals(((VideoInfo.GameAdComData)localObject).WX)));
    ((VideoInfo.GameAdComData)localObject).progress = parammrm.gameAdComData.progress;
    ((VideoInfo.GameAdComData)localObject).downloadState = parammrm.gameAdComData.downloadState;
    parammrm = ((mtg)((auwz)this.a.getAdapter()).a()).a();
    this.mainHandler.post(new ADVideoFeedsVideoAppDownlodManager.1(this, parammrm, paramInt1, paramInt2));
  }
  
  protected void aBs()
  {
    super.aBs();
    Object localObject = awok.a().hD();
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        awoe localawoe = (awoe)((Iterator)localObject).next();
        if ((localawoe instanceof jzj)) {
          awok.a().b(localawoe);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzj
 * JD-Core Version:    0.7.0.1
 */