import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.GameGiftsImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class tqv
  extends trd
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeAdDownloadView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView;
  private GameGiftsImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  private TextView c;
  
  public tqv(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  private void h()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#00CAFC"));
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.c.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Tql != null) && (this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton)) {}
    for (;;)
    {
      return;
      boolean bool2 = false;
      try
      {
        if ((this.jdField_a_of_type_Tql != null) && (this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Tql.jdField_a_of_type_Txh != null) {
            bool1 = bfwv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Tql.jdField_a_of_type_Txh.d);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localException.printStackTrace();
            bool1 = bool2;
          }
        }
        g();
      }
    }
    bool2 = this.jdField_a_of_type_Tql.b();
    if ((!bool1) && (!bool2) && ((c() == 4) || (c() == 3)) && (b() >= 0) && (b() < 100))
    {
      f();
      a(this.jdField_a_of_type_Tql.jdField_a_of_type_Txh, c(), b());
      return;
    }
  }
  
  private void j()
  {
    tqr localtqr = new tqr(1);
    localtqr.c = 48;
    localtqr.jdField_e_of_type_Int = 28;
    localtqr.jdField_e_of_type_JavaLangString = "#00cafc";
    localtqr.jdField_a_of_type_JavaLangString = "#4c00cafc";
    localtqr.jdField_b_of_type_Float = 1.0F;
    localtqr.d = "#00cafc";
    localtqr.g = 14;
    localtqr.jdField_a_of_type_Boolean = false;
    localtqr.jdField_b_of_type_JavaLangString = "#ffffff";
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(localtqr);
  }
  
  public int a()
  {
    return 2131559196;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368236));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378707));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView = ((GameGiftsImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367616));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367403));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365742));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365754));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366593));
    h();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgress(paramInt);
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    if (paramAdData.a != null)
    {
      tqs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, paramAdData.a.k, 12, 48, -1);
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramAdData.a.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Tql == null) {
        break label310;
      }
      a(this.c, this.jdField_a_of_type_Tql.b());
      a(this.jdField_b_of_type_AndroidWidgetTextView, paramAdData.a.h);
      if (!twh.c(paramAdData)) {
        break label328;
      }
      Object localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tri.d)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Tri.d);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tri.jdField_e_of_type_JavaLangString)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Tri.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tri.f)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Tri.f);
      }
      if (((ArrayList)localObject).size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setImages((ArrayList)localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tri.g)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAdData.a.jdField_a_of_type_Tri.g);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      j();
      if (twh.e(paramAdData)) {
        i();
      }
      return;
      label310:
      a(this.c, paramAdData.a.l);
      break;
      label328:
      if (twh.e(paramAdData)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(8);
      }
    }
  }
  
  public void a(tql paramtql)
  {
    super.a(paramtql);
    if ((this.jdField_a_of_type_Tql != null) && (this.jdField_a_of_type_Tql.jdField_a_of_type_Oau != null))
    {
      this.jdField_a_of_type_Tql.a(new tqx(this));
      this.jdField_a_of_type_Tql.jdField_a_of_type_Oau.a(new tqy(this));
    }
  }
  
  public void a(txh paramtxh, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Tql.a(paramtxh)) {
      return;
    }
    this.jdField_a_of_type_Tql.a(this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Tql != null) && (this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
      return this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
    }
    return 0;
  }
  
  public void b()
  {
    a(new View[] { this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, this.jdField_a_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new tqw(this));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Tql != null) && (this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
      return this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState;
    }
    return 0;
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
    if (twh.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      l2 = 7L;
    }
    for (;;)
    {
      tqj.a(this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l1, l2, null, "1"));
      super.d();
      return;
      if (twh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        l1 = 3010303L;
        l2 = l3;
      }
      else
      {
        l2 = l3;
        if (twh.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
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
    if (this.jdField_a_of_type_Tql == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Tql.b();
    } while ((TextUtils.isEmpty(str)) || (this.c == null));
    this.c.setText(str);
  }
  
  public void f()
  {
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(0);
  }
  
  public void g()
  {
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    long l = 3010208L;
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Tql != null)
        {
          this.jdField_a_of_type_Tql.a(4);
          continue;
          if (this.jdField_a_of_type_Tql != null) {
            this.jdField_a_of_type_Tql.b(4);
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while ((this.jdField_a_of_type_Tqu == null) || (this.jdField_a_of_type_Tql == null));
    this.jdField_a_of_type_Tqu.b();
    if (twh.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {}
    for (;;)
    {
      tqj.a(this.jdField_a_of_type_Tql.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      break;
      if (twh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010308L;
      } else if (twh.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010408L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqv
 * JD-Core Version:    0.7.0.1
 */