import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.GameGiftsImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class uen
  extends uer
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GameGiftsImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView;
  private RIJDownloadView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public uen(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  public int a()
  {
    return 2131559228;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368381));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379001));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView = ((GameGiftsImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367749));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367531));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365859));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366702));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setInFloatingBar(true);
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    if (paramAdData.a != null)
    {
      uek.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, paramAdData.a.k, 12, 48, -1);
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramAdData.a.jdField_a_of_type_JavaLangString);
      a(this.jdField_b_of_type_AndroidWidgetTextView, paramAdData.a.h);
      if (!uki.c(paramAdData)) {
        break label287;
      }
      Object localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Uft.d)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Uft.d);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Uft.e)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Uft.e);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Uft.f)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Uft.f);
      }
      if (((ArrayList)localObject).size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setImages((ArrayList)localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Uft.g)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAdData.a.jdField_a_of_type_Uft.g);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ukt.a(paramAdData);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        break;
      }
      return;
      label287:
      if (uki.e(paramAdData)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle(HorizontalProgressStyle.FastWebGameStyle);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.l == 1);
  }
  
  public void b()
  {
    a(new View[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_a_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new ueo(this));
  }
  
  public void c() {}
  
  public void d()
  {
    long l1 = 3010203L;
    long l3 = 6L;
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    long l2;
    if (uki.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      l2 = 7L;
    }
    for (;;)
    {
      ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(), ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l1, l2, null, "1"), ReportAction.EXPOSE, ActionEntity.ArticleFloat, JumpMode.UNKNOWN);
      super.d();
      return;
      if (uki.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        l1 = 3010303L;
        l2 = l3;
      }
      else
      {
        l2 = l3;
        if (uki.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          l1 = 3010403L;
          l2 = l3;
        }
      }
    }
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
    long l = 3010208L;
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
          if ((ufc.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (ufc.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (ufc.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(AdClickPos.SoftAdClickBtn, 8);
          }
          else
          {
            localObject = JumpMode.UNKNOWN;
            if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
              localObject = udy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
            ueb.a((JumpMode)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3010405L, 9L, "", "1"));
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Uem == null);
    this.jdField_a_of_type_Uem.b();
    if (uki.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {}
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
      if (localObject != null) {
        ((AdvertisementInfo)localObject).adClickPos = AdClickPos.SoftAdClose;
      }
      ueb.b(JumpMode.UNKNOWN, (AdvertisementInfo)localObject, ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      break;
      if (uki.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010308L;
      } else if (uki.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010408L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uen
 * JD-Core Version:    0.7.0.1
 */