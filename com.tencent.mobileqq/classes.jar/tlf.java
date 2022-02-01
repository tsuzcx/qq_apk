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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class tlf
  extends tln
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeAdDownloadView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView;
  private GameGiftsImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  private TextView c;
  
  public tlf(Context paramContext, int paramInt)
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
    localGradientDrawable.setCornerRadius(agej.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.c.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Tkv != null) && (this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton)) {}
    for (;;)
    {
      return;
      boolean bool2 = false;
      try
      {
        if ((this.jdField_a_of_type_Tkv != null) && (this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Tkv.jdField_a_of_type_Tqt != null) {
            bool1 = bhny.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Tkv.jdField_a_of_type_Tqt.d);
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
    bool2 = this.jdField_a_of_type_Tkv.b();
    if ((!bool1) && (!bool2) && ((c() == 4) || (c() == 3)) && (b() >= 0) && (b() < 100))
    {
      f();
      a(this.jdField_a_of_type_Tkv.jdField_a_of_type_Tqt, c(), b());
      return;
    }
  }
  
  private void j()
  {
    tlb localtlb = new tlb(1);
    localtlb.c = 48;
    localtlb.jdField_e_of_type_Int = 28;
    localtlb.jdField_e_of_type_JavaLangString = "#00cafc";
    localtlb.jdField_a_of_type_JavaLangString = "#4c00cafc";
    localtlb.jdField_b_of_type_Float = 1.0F;
    localtlb.d = "#00cafc";
    localtlb.g = 14;
    localtlb.jdField_a_of_type_Boolean = false;
    localtlb.jdField_b_of_type_JavaLangString = "#ffffff";
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(localtlb);
  }
  
  public int a()
  {
    return 2131559189;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368212));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378936));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView = ((GameGiftsImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367587));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367376));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365709));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365721));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366566));
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
      tlc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, paramAdData.a.k, 12, 48, -1);
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramAdData.a.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Tkv == null) {
        break label310;
      }
      a(this.c, this.jdField_a_of_type_Tkv.b());
      a(this.jdField_b_of_type_AndroidWidgetTextView, paramAdData.a.h);
      if (!tpp.c(paramAdData)) {
        break label328;
      }
      Object localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tls.d)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Tls.d);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tls.jdField_e_of_type_JavaLangString)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Tls.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tls.f)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Tls.f);
      }
      if (((ArrayList)localObject).size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setImages((ArrayList)localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Tls.g)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAdData.a.jdField_a_of_type_Tls.g);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      j();
      if (tpp.e(paramAdData)) {
        i();
      }
      return;
      label310:
      a(this.c, paramAdData.a.l);
      break;
      label328:
      if (tpp.e(paramAdData)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(8);
      }
    }
  }
  
  public void a(tkv paramtkv)
  {
    super.a(paramtkv);
    if ((this.jdField_a_of_type_Tkv != null) && (this.jdField_a_of_type_Tkv.jdField_a_of_type_Nzj != null))
    {
      this.jdField_a_of_type_Tkv.a(new tlh(this));
      this.jdField_a_of_type_Tkv.jdField_a_of_type_Nzj.a(new tli(this));
    }
  }
  
  public void a(tqt paramtqt, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Tkv.a(paramtqt)) {
      return;
    }
    this.jdField_a_of_type_Tkv.a(this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Tkv != null) && (this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
      return this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
    }
    return 0;
  }
  
  public void b()
  {
    a(new View[] { this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, this.jdField_a_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new tlg(this));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Tkv != null) && (this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
      return this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState;
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
    if (tpp.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      l2 = 7L;
    }
    for (;;)
    {
      tkt.a(this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l1, l2, null, "1"));
      super.d();
      return;
      if (tpp.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        l1 = 3010303L;
        l2 = l3;
      }
      else
      {
        l2 = l3;
        if (tpp.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
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
    if (this.jdField_a_of_type_Tkv == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Tkv.b();
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
        if (this.jdField_a_of_type_Tkv != null)
        {
          this.jdField_a_of_type_Tkv.a(4);
          continue;
          if (this.jdField_a_of_type_Tkv != null) {
            this.jdField_a_of_type_Tkv.b(4);
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while ((this.jdField_a_of_type_Tle == null) || (this.jdField_a_of_type_Tkv == null));
    this.jdField_a_of_type_Tle.b();
    if (tpp.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {}
    for (;;)
    {
      tkt.a(this.jdField_a_of_type_Tkv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      break;
      if (tpp.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010308L;
      } else if (tpp.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010408L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlf
 * JD-Core Version:    0.7.0.1
 */