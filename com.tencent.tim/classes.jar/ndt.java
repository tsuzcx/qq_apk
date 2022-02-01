import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.22.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import mqq.os.MqqHandler;

public class ndt
  implements AbsListView.e
{
  int aYg = 0;
  boolean arD;
  boolean arE = false;
  double ba = 0.0D;
  final double bb = 200.0D;
  private View kU;
  private int lastFirstVisibleItem;
  private View lastView;
  private int lastVisibleItem;
  long mLastTime = 0L;
  long xo = 0L;
  long xp = 0L;
  
  ndt(ndi paramndi) {}
  
  private boolean b(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ba > 0.0D)
    {
      bool1 = bool2;
      if (this.ba < 200.0D)
      {
        bool1 = bool2;
        if (!ndi.b(this.this$0))
        {
          bool1 = bool2;
          if (!kxm.AQ())
          {
            bool1 = bool2;
            if (paramAbsListView.getVisibility() == 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private String kG()
  {
    if (lvy.a().CN()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.lastFirstVisibleItem < paramInt1) {
      lft.cr(this.kU);
    }
    label38:
    label354:
    label496:
    label503:
    do
    {
      klu localklu;
      long l1;
      long l2;
      long l3;
      do
      {
        break label38;
        while ((this.this$0.jdField_a_of_type_Mye != null) && (this.this$0.jdField_a_of_type_Mye.isFullScreen()))
        {
          return;
          if (paramInt1 + paramInt2 - 1 < this.lastVisibleItem) {
            lft.cr(this.lastView);
          }
        }
        View localView = paramAbsListView.getChildAt(0);
        localklu = (klu)ndi.getApp().getManager(307);
        if ((localklu.a(this.this$0, this.this$0.mContext)) && (ndi.a(this.this$0) != null)) {
          ndi.a(this.this$0).a(this.this$0, this.this$0.mContext);
        }
        if (knd.dh(this.this$0.mChannelID))
        {
          Pair localPair = lbz.a().b(this.this$0.mChannelID, paramInt1 + paramInt2 - 1);
          if (localPair != null)
          {
            lbz.a().M(this.this$0.mChannelID, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
            ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.22.1(this, localPair));
          }
        }
        if (localView == null) {
          break;
        }
        if (this.mLastTime == 0L)
        {
          this.mLastTime = System.currentTimeMillis();
          return;
        }
        this.xo = (localView.getHeight() * paramInt1 - localView.getTop());
        l1 = this.xo;
        l2 = this.xp;
        l3 = System.currentTimeMillis();
      } while (l3 == this.mLastTime);
      this.ba = ((l1 - l2) * 1000L / (l3 - this.mLastTime));
      this.mLastTime = l3;
      this.xp = this.xo;
      if (b(paramAbsListView))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
        }
        this.this$0.j(paramAbsListView, ndi.aYb);
      }
      if (paramInt1 > this.lastFirstVisibleItem) {
        this.arD = true;
      }
      for (;;)
      {
        localklu.a(this.this$0, this.this$0.mContext, this.arD, this.ba);
        this.lastFirstVisibleItem = paramInt1;
        this.lastVisibleItem = (paramInt1 + paramInt2 - 1);
        this.kU = paramAbsListView.getChildAt(0);
        this.lastView = paramAbsListView.getChildAt(paramInt2 - 1);
        if (this.this$0.mScrollState != 2) {
          break label503;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          break;
        }
        if (!ndi.a(this.this$0, paramAbsListView)) {
          break label496;
        }
        noy.a().pauseDownload();
        return;
        this.mLastTime = 0L;
        this.xo = 0L;
        this.xp = 0L;
        break label354;
        if (paramInt1 < this.lastFirstVisibleItem) {
          this.arD = false;
        }
      }
      noy.a().resume();
      return;
    } while (this.this$0.mScrollState != -1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.this$0.mScrollState = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    label174:
    lgf.c localc;
    int i;
    if (paramInt == 0)
    {
      if (kxm.AI()) {}
      switch (this.this$0.mChannelID)
      {
      default: 
        if (kys.dv(this.this$0.mChannelID))
        {
          txn.a().stopMonitorScene(kG(), false);
          this.this$0.jdField_a_of_type_Njk.aYo();
          noy.a().resume();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
          }
          if (!this.arD) {
            break label485;
          }
          ndi.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition(), ndi.access$900());
          if (this.this$0.getCount() - this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() < ndi.access$1100()) {
            ndi.b(this.this$0);
          }
          ndi.b(this.this$0, this.arD);
          localc = ndi.a(this.this$0, paramAbsListView);
          if (localc != null) {
            break label512;
          }
          i = paramAbsListView.getFirstVisiblePosition();
          label237:
          if (this.this$0.mChannelID != 40677) {
            break label523;
          }
          if ((i == 0) && (this.this$0.mVideoPreDownloadMgr != null)) {
            this.this$0.mVideoPreDownloadMgr.ad(i, ndi.a(this.this$0));
          }
          label282:
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + i + " when scroll state idle");
          }
          ndi.a(this.this$0).postDelayed(ndi.a(this.this$0), 1000L);
          if ((paramInt != 2) || (!ndi.b(this.this$0))) {
            break label724;
          }
          this.arE = true;
          label361:
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      ndi.a(this.this$0).removeMessages(1001);
      for (;;)
      {
        this.this$0.jdField_a_of_type_Oaw.n(paramAbsListView, paramInt);
        return;
        txn.a().stopMonitorScene("list_video_kandian", false);
        break;
        txn.a().stopMonitorScene("list_new_kandian", false);
        break;
        txn.a().stopMonitorScene("list_subscript", false);
        break;
        txn.a().stopMonitorScene("list_kandian_channel_" + this.this$0.mChannelID, false);
        break;
        label485:
        ndi.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - ndi.access$900(), ndi.access$900());
        break label174;
        label512:
        i = localc.getPosition();
        break label237;
        label523:
        if (this.this$0.mVideoPreDownloadMgr == null) {
          break label282;
        }
        this.this$0.mVideoPreDownloadMgr.ad(i, ndi.a(this.this$0));
        break label282;
        if (kxm.AI()) {
          switch (this.this$0.mChannelID)
          {
          default: 
            if (kys.dv(this.this$0.mChannelID)) {
              txn.a().startMonitorScene(kG());
            }
            break;
          }
        }
        for (;;)
        {
          this.this$0.jdField_a_of_type_Njk.aYn();
          ndi.a(this.this$0).removeCallbacks(ndi.a(this.this$0));
          break;
          txn.a().startMonitorScene("list_video_kandian");
          continue;
          txn.a().startMonitorScene("list_new_kandian");
          continue;
          txn.a().startMonitorScene("list_subscript");
          continue;
          txn.a().startMonitorScene("list_kandian_channel_" + this.this$0.mChannelID);
        }
        label724:
        if ((paramInt == 2) || (!this.arE)) {
          break label361;
        }
        this.arE = false;
        ndi.c(this.this$0, false);
        break label361;
        this.this$0.j(paramAbsListView, ndi.aYc);
        QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
        if (!this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz()) {
          lft.g(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
      }
      if (ndi.a(this.this$0) != null) {
        ndi.a(this.this$0).oc(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndt
 * JD-Core Version:    0.7.0.1
 */