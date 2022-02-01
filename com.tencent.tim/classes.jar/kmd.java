import android.app.Activity;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.multiVideo.MultiVideoAdFooterView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kmd
  extends nai
{
  public static final String TAG = kmd.class.getSimpleName();
  private MultiVideoAdFooterView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  public GdtHandler.Params a;
  private ViewGroup aQ;
  private MultiVideoAdFooterView b;
  private MultiVideoAdFooterView jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;
  private ReadInJoyHeadImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ImageView ii;
  private QQAppInterface mApp;
  public long sr = -2147483648L;
  
  public kmd(View paramView, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramView, paramActivity, 1);
    this.mApp = paramQQAppInterface;
    this.aQ = ((ViewGroup)paramView.findViewById(2131368438));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131368439));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131368436));
    this.ii = ((ImageView)paramView.findViewById(2131378181));
    this.b = ((MultiVideoAdFooterView)paramView.findViewById(2131372055));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = ((MultiVideoAdFooterView)paramView.findViewById(2131372056));
    if (this.ii != null) {
      this.ii.setOnClickListener(this);
    }
    if (this.aQ != null) {
      this.aQ.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    }
    aEw();
  }
  
  protected void aEw()
  {
    if (this.bS != null) {
      this.bS.setVisibility(8);
    }
    if (this.bU != null) {
      this.bU.setVisibility(8);
    }
    if (this.bT != null) {
      this.bT.setVisibility(8);
    }
  }
  
  public void aEx()
  {
    super.aEx();
    if (this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.isAD)
    {
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.accountName))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.accountName);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
        VideoFeedsAccessibilityHelper.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.accountName);
        VideoFeedsAccessibilityHelper.h(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.accountName);
      }
      kmg.a(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    }
    this.aQ.setTag(this);
    this.aQ.setOnClickListener(this);
    aEw();
  }
  
  public void aEy()
  {
    super.aEy();
    this.pw.setText("广告");
  }
  
  public void aEz()
  {
    super.aEz();
  }
  
  public void cb(View paramView)
  {
    if (this.jdField_a_of_type_Naq$d.a(this))
    {
      this.jdField_a_of_type_Nba.b().doOnPause();
      paramView = knl.b(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.b);
      knd.a(paramView, 1000, this.jdField_a_of_type_Naq$d.a());
      ods.b(this.mActivity, paramView, null, 3, false, null);
      kmc.a(this.mActivity, jzk.aGl, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    super.d(paramVideoInfo);
    if (paramVideoInfo.isAD)
    {
      paramVideoInfo.b.isMultiyVideo = true;
      this.b.setVisibility(8);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setVisibility(8);
      VideoAdInfo localVideoAdInfo = paramVideoInfo.b;
      if ((localVideoAdInfo != null) && (localVideoAdInfo.mRevisionVideoType != 1)) {
        break label150;
      }
    }
    label150:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.b;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setData(this, paramVideoInfo, this.mActivity, this.jdField_a_of_type_Naq$d);
      if ((this.jdField_a_of_type_Nba instanceof kme))
      {
        ((kme)this.jdField_a_of_type_Nba).a.activity = this.mActivity;
        ((kme)this.jdField_a_of_type_Nba).a.jdField_d_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo;
        ((kme)this.jdField_a_of_type_Nba).a.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;
      }
      return;
    }
  }
  
  public void mq(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.resetStyle();
    super.mq(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Naq$d.a(this)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AdvertisementInfo localAdvertisementInfo = knl.b(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.b);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ods.a(this.mActivity, localAdvertisementInfo, null, 3, false, null);
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        this.sr = l;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131368436: 
        case 2131368437: 
          knd.a(localAdvertisementInfo, 2, this.jdField_a_of_type_Naq$d.a());
          ods.b(this.mActivity, localAdvertisementInfo, null, 3, false, null);
          kmc.a(this.mActivity, jzk.aGd, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
          break;
        }
      }
      this.jdField_a_of_type_Naq$d.Q(this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
      continue;
      knd.a(localAdvertisementInfo, 1000, this.jdField_a_of_type_Naq$d.a());
      ods.b(this.mActivity, localAdvertisementInfo, null, 3, false, null);
      kmc.a(this.mActivity, jzk.aGl, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
      continue;
      knd.a(localAdvertisementInfo, 3, this.jdField_a_of_type_Naq$d.a());
      ods.b(this.mActivity, localAdvertisementInfo, null, 3, false, null);
      kmc.a(this.mActivity, jzk.aGe, this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmd
 * JD-Core Version:    0.7.0.1
 */