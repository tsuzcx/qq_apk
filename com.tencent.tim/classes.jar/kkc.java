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
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.GameGiftsImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;

public class kkc
  extends kkk
{
  private GameGiftsImageView a;
  private NativeAdDownloadView b;
  private URLImageView g;
  private ImageView ih;
  private TextView oe;
  private TextView of;
  private TextView title;
  
  public kkc(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    kkm.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    kkn.a(this.jdField_a_of_type_Kjt.advertisementInfo, jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.abq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.rowkey, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.ZR, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.aaa, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.packageName, new HashMap()), kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramLong1, paramLong2, paramString1, paramString2));
  }
  
  private void aDS()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#00CAFC"));
    localGradientDrawable.setCornerRadius(wja.dp2px(3.0F, this.context.getResources()));
    this.of.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void aDU()
  {
    if ((this.jdField_a_of_type_Kjt != null) && (this.jdField_a_of_type_Kjt.advertisementInfo != null) && (!this.jdField_a_of_type_Kjt.advertisementInfo.mShowAdButton)) {}
    for (;;)
    {
      return;
      boolean bool2 = false;
      try
      {
        if ((this.jdField_a_of_type_Kjt != null) && (this.jdField_a_of_type_Kjt.advertisementInfo != null))
        {
          this.jdField_a_of_type_Kjt.advertisementInfo.mProgressFromFeeds = true;
          bool1 = bool2;
          if (this.jdField_a_of_type_Kjt.b != null) {
            bool1 = aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Kjt.b.mPackageName);
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
        aDL();
      }
    }
    bool2 = this.jdField_a_of_type_Kjt.zw();
    if ((!bool1) && (!bool2) && ((getDownloadState() == 4) || (getDownloadState() == 3)) && (getProgress() >= 0) && (getProgress() < 100))
    {
      aDK();
      a(this.jdField_a_of_type_Kjt.b, getDownloadState(), getProgress());
      return;
    }
  }
  
  private void aDV()
  {
    kjy localkjy = new kjy(1);
    localkjy.width = 48;
    localkjy.height = 28;
    localkjy.ZH = "#00cafc";
    localkjy.ZE = "#4c00cafc";
    localkjy.iC = 1.0F;
    localkjy.textColor = "#00cafc";
    localkjy.textSize = 14;
    localkjy.afV = false;
    localkjy.ZF = "#ffffff";
    this.b.setStyle1(localkjy);
  }
  
  private void setText(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  public void Nx()
  {
    b(new View[] { this.of, this.b, this.ih });
    this.rootView.setOnClickListener(new kkd(this));
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    if (paramAdData.a != null)
    {
      kjz.a(this.context, this.g, paramAdData.a.gameIcon, 12, 48, -1);
      setText(this.title, paramAdData.a.gameName);
      if (this.jdField_a_of_type_Kjt == null) {
        break label310;
      }
      setText(this.of, this.jdField_a_of_type_Kjt.in());
      setText(this.oe, paramAdData.a.ZO);
      if (!kmx.c(paramAdData)) {
        break label328;
      }
      Object localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramAdData.a.a.aag)) {
        ((ArrayList)localObject).add(paramAdData.a.a.aag);
      }
      if (!TextUtils.isEmpty(paramAdData.a.a.aah)) {
        ((ArrayList)localObject).add(paramAdData.a.a.aah);
      }
      if (!TextUtils.isEmpty(paramAdData.a.a.aai)) {
        ((ArrayList)localObject).add(paramAdData.a.a.aai);
      }
      if (((ArrayList)localObject).size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView.setImages((ArrayList)localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.a.a.giftDesc)) {
        this.oe.setText(paramAdData.a.a.giftDesc);
      }
      localObject = this.oe.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(6.0F, this.context.getResources());
      }
      this.oe.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      aDV();
      if (kmx.e(paramAdData)) {
        aDU();
      }
      return;
      label310:
      setText(this.of, paramAdData.a.buttonDesc);
      break;
      label328:
      if (kmx.e(paramAdData)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView.setVisibility(8);
      }
    }
  }
  
  public void a(kjt paramkjt)
  {
    super.a(paramkjt);
    if ((this.jdField_a_of_type_Kjt != null) && (this.jdField_a_of_type_Kjt.a != null))
    {
      this.jdField_a_of_type_Kjt.a(new kke(this));
      this.jdField_a_of_type_Kjt.a.a(new kkf(this));
    }
  }
  
  public void a(mrm parammrm, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Kjt.d(parammrm)) {
      return;
    }
    this.jdField_a_of_type_Kjt.a(this.of, this.b, paramInt1, paramInt2);
  }
  
  public void aDK()
  {
    this.of.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void aDL()
  {
    this.of.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void aDR()
  {
    if ((this.rootView == null) || (this.context == null)) {
      return;
    }
    this.g = ((URLImageView)this.rootView.findViewById(2131368698));
    this.title = ((TextView)this.rootView.findViewById(2131379769));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView = ((GameGiftsImageView)this.rootView.findViewById(2131368061));
    this.oe = ((TextView)this.rootView.findViewById(2131367862));
    this.of = ((TextView)this.rootView.findViewById(2131366071));
    this.b = ((NativeAdDownloadView)this.rootView.findViewById(2131366091));
    this.ih = ((ImageView)this.rootView.findViewById(2131366979));
    aDS();
  }
  
  public void aDT()
  {
    super.aDT();
    if (this.jdField_a_of_type_Kjt == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Kjt.in();
    } while ((TextUtils.isEmpty(str)) || (this.of == null));
    this.of.setText(str);
  }
  
  public void aaV()
  {
    if (this.afX) {
      return;
    }
    long l1;
    long l2;
    if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      l1 = 7L;
      l2 = 3010203L;
    }
    for (;;)
    {
      kkn.a(this.jdField_a_of_type_Kjt.advertisementInfo, jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.abq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.rowkey, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.ZR, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.aaa, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.packageName, new HashMap()), kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l2, l1, null, "1"));
      super.aaV();
      return;
      if (kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        l1 = 6L;
        l2 = 3010303L;
      }
      else if (kmx.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        l1 = 6L;
        l2 = 3010403L;
      }
      else
      {
        l1 = 6L;
        l2 = 3010203L;
      }
    }
  }
  
  public void close() {}
  
  public int getDownloadState()
  {
    if ((this.jdField_a_of_type_Kjt != null) && (this.jdField_a_of_type_Kjt.advertisementInfo != null)) {
      return this.jdField_a_of_type_Kjt.advertisementInfo.downloadState;
    }
    return 0;
  }
  
  public int getProgress()
  {
    if ((this.jdField_a_of_type_Kjt != null) && (this.jdField_a_of_type_Kjt.advertisementInfo != null)) {
      return this.jdField_a_of_type_Kjt.advertisementInfo.progress;
    }
    return 0;
  }
  
  public int nn()
  {
    return 2131559360;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Kjt != null)
        {
          this.jdField_a_of_type_Kjt.pf(1);
          continue;
          if (this.jdField_a_of_type_Kjt != null) {
            this.jdField_a_of_type_Kjt.pg(1);
          }
        }
      }
      this.afW = true;
    } while ((this.jdField_a_of_type_Kkb == null) || (this.jdField_a_of_type_Kjt == null));
    this.jdField_a_of_type_Kkb.Hj();
    long l;
    if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      l = 3010208L;
    }
    for (;;)
    {
      kkn.a(this.jdField_a_of_type_Kjt.advertisementInfo, jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.abq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.rowkey, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.ZR, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.aaa, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.packageName, new HashMap()), kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      break;
      if (kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010308L;
      } else if (kmx.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010408L;
      } else {
        l = 3010208L;
      }
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.b.setProgress(paramInt);
  }
  
  public boolean zB()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkc
 * JD-Core Version:    0.7.0.1
 */