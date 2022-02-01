import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class uep
  extends uer
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJDownloadView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public uep(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(AdClickPos paramAdClickPos)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(paramAdClickPos);
      udq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext, 35, 1, 4, null);
    }
  }
  
  public int a()
  {
    return 2131562876;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368381));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379001));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365513));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366702));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365859));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setInFloatingBar(true);
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramAdData == null) || (paramAdData.b == null)) {}
    do
    {
      return;
      String str1 = paramAdData.b.optString("adImg", "");
      String str2 = paramAdData.b.optString("goodsName", "");
      String str3 = paramAdData.b.optString("buttonTxt", "");
      uek.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetImageView, str1, 8, 30, -1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str3);
      paramAdData = ukt.a(paramAdData);
    } while (paramAdData == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(paramAdData);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle(RoundProgressStyle.FastWebSoftAd);
  }
  
  public void b()
  {
    a(new View[] { this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_b_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new ueq(this));
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    uec.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, 1, 4);
    super.d();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(AdClickPos.SoftAdComponent);
      continue;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
        if (AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(AdClickPos.SoftAdClickBtn, 8);
        }
        else
        {
          a(AdClickPos.SoftAdClickBtn);
          continue;
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_Uem != null) {
            this.jdField_a_of_type_Uem.b();
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(3);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adClickPos = AdClickPos.SoftAdClose;
            uec.a(ReportAction.CLICK, JumpMode.UNKNOWN, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, 1, 4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uep
 * JD-Core Version:    0.7.0.1
 */