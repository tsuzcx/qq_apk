import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mxs
  implements mxm.b
{
  public static final String TAG = mxs.class.getSimpleName();
  private int aVL = 2147483647;
  private int aVM;
  private boolean apX;
  private boolean apY = true;
  private VideoInfo c;
  Activity mActivity;
  QQAppInterface mApp;
  
  private boolean EB()
  {
    return (this.apY) && (this.aVM < this.aVL);
  }
  
  public CharSequence a()
  {
    return this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.subTitle;
  }
  
  public void a(VideoInfo paramVideoInfo, mtg.l paraml)
  {
    this.aVM += 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
    if ((TextUtils.isEmpty(awit.sn("sp_key_ad_soft_total_area"))) || ("1".equals(awit.sn("sp_key_ad_soft_total_area")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.apY = bool;
      this.aVL = jzp.o(awit.sn("sp_key_ad_soft_kd_max"), 2147483647);
      this.aVM = muj.b(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onCreate() mConfigIsOpen = " + this.apY + ", mConfigMaxShowCount = " + this.aVL + ", mTodayShowCount = " + this.aVM);
      }
      return;
    }
  }
  
  public void a(mtg.l paraml)
  {
    paraml.sd.setVisibility(0);
    paraml.lT.setVisibility(0);
    this.apX = true;
  }
  
  public void a(mxm.a parama) {}
  
  public boolean a(VideoInfo paramVideoInfo, mtg.l paraml, double paramDouble, long paramLong)
  {
    return (paraml.by != null) && (paraml.by.getVisibility() == 0) && (this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramDouble > this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.aHt);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.c = paramVideoInfo;
    this.apX = false;
  }
  
  public void b(mtg.l paraml) {}
  
  public boolean b(VideoInfo paramVideoInfo)
  {
    return EB();
  }
  
  public void c(mtg.l paraml) {}
  
  public void ck(int paramInt1, int paramInt2) {}
  
  public String getBtnText()
  {
    return "";
  }
  
  public int getStyle()
  {
    return 0;
  }
  
  public String getTitle()
  {
    return this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.title;
  }
  
  public String ir()
  {
    if (this.apX) {
      return this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.Xy;
    }
    return this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.smallIconUrl;
  }
  
  public String is()
  {
    return "";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    muj.a(this.mActivity, this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c);
    paramView = new nce.a("", "", this.c.vid, this.c.Wz).h(this.c.Wz);
    if (this.c.yV()) {}
    for (int i = this.c.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;; i = 0)
    {
      paramView = paramView.t(i).q(this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c.WT);
      kbp.b(null, this.c.hH, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a().toJsonString(), false);
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.aVM != 0) {
      muj.e(this.mApp, this.aVM);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDestroy() mTodayShowCount = " + this.aVM);
    }
  }
  
  public boolean zL()
  {
    return (this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.title)) && (this.c.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c != null);
  }
  
  public boolean zM()
  {
    return false;
  }
  
  public boolean zN()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxs
 * JD-Core Version:    0.7.0.1
 */