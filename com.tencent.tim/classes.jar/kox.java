import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class kox
  extends koh
{
  private boolean afT;
  boolean agT;
  private AdData c;
  private boolean isUserClick;
  
  public kox(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private void aFC()
  {
    if (zA())
    {
      this.ox.setClickable(false);
      this.mRootView.setClickable(false);
      this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
    }
    for (;;)
    {
      this.ox.setVisibility(0);
      this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      if (kmx.e(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        aDU();
      }
      return;
      this.ox.setClickable(true);
      this.mRootView.setClickable(true);
      this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
    }
  }
  
  private void aFD()
  {
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.ai != null)) {
      try
      {
        switch (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.bab)
        {
        case 1: 
        case 2: 
          this.ai.put("buttonTextColor", "#00cafc");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  protected boolean Ad()
  {
    boolean bool = false;
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.alK))) {}
    for (int i = knc.r(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.alK, 8);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyNativeArticleAdDownloadView", 2, "isADVideoDownloadProgress->value:" + i);
      }
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
  }
  
  protected boolean Ae()
  {
    return (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.aZW == 1) || (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.aZW == 2));
  }
  
  public void a(boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(ix())))
    {
      this.ox.setText("");
      this.ox.setTextColor(cY(this.aKE));
      this.ox.setClickable(false);
      this.mRootView.setClickable(false);
      paramString = "";
      paramAdvertisementInfo = paramString;
      if (kmx.d(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramAdvertisementInfo = paramString;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Kkp.ZZ)) {
          paramAdvertisementInfo = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Kkp.ZZ;
        }
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 2, paramAdvertisementInfo, 0).show();
    }
  }
  
  protected void aDE()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.aDE();
    }
  }
  
  protected void aDF()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.aDF();
    }
  }
  
  protected void aDG()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.aDG();
    }
  }
  
  protected void aDH()
  {
    if ((this.jdField_b_of_type_Mrm != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mPackageName)) && (kmx.e(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
      knd.D(this.mContext, this.jdField_b_of_type_Mrm.mPackageName);
    }
    while (!zy()) {
      return;
    }
    ods.b(this.mContext, kne.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
  }
  
  public void aDI()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.aDI();
    }
  }
  
  public void aEq()
  {
    super.aEq();
    if ((kmx.d(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (zA()) && (this.ox != null))
    {
      this.ox.setTextColor(cY(this.aKE));
      this.ox.setClickable(false);
      this.mRootView.setClickable(false);
    }
  }
  
  protected void aFm()
  {
    if ((this.ox.getVisibility() == 0) && (this.ox.isClickable())) {
      onClick(this.ox);
    }
    do
    {
      return;
      if ((this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.getVisibility() == 0) && (this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.isClickable()))
      {
        onClick(this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView);
        return;
      }
    } while (!(this.mContext instanceof Activity));
    this.isUserClick = false;
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.isUserClick = false;
    }
    nnb.a(this.mContext, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
  }
  
  protected void aFp() {}
  
  protected int cY(int paramInt)
  {
    int j = 1;
    int i = paramInt;
    GradientDrawable localGradientDrawable;
    float f2;
    float f1;
    if (zA())
    {
      if (!TextUtils.isEmpty(this.ai.optString("clickTextColor"))) {
        paramInt = jzp.l(this.ai.optString("clickTextColor"), "#9D9D9D");
      }
      localGradientDrawable = new GradientDrawable();
      i = 0;
      if (!TextUtils.isEmpty(this.ai.optString("clickBackgroundColor")))
      {
        localGradientDrawable.setColor(jzp.l(this.ai.optString("clickBackgroundColor"), "#12B7F5"));
        i = 1;
      }
      String str1 = this.ai.optString("buttonBorderSize");
      String str2 = this.ai.optString("clickBorderColor");
      if (jzp.b(str1, 0.0F) > 0.0F)
      {
        f2 = jzp.b(str1, 0.0F);
        f1 = f2;
        if (f2 > 2.0F) {
          f1 = 2.0F;
        }
        localGradientDrawable.setStroke(wja.dp2px(f1, this.mContext.getResources()), jzp.l(str2, "#12B7F5"));
        i = 1;
      }
      str1 = this.ai.optString("buttonCornerSize");
      if (TextUtils.isEmpty(str1)) {
        break label269;
      }
      f2 = jzp.b(str1, 0.0F);
      if (f2 >= 0.0F) {
        break label252;
      }
      f1 = 0.0F;
      localGradientDrawable.setCornerRadius(wja.dp2px(f1, this.mContext.getResources()));
    }
    for (;;)
    {
      i = paramInt;
      if (j != 0)
      {
        kvl.setBackground(this.ox, localGradientDrawable);
        i = paramInt;
      }
      return i;
      label252:
      f1 = f2;
      if (f2 <= 10.0F) {
        break;
      }
      f1 = 10.0F;
      break;
      label269:
      j = i;
    }
  }
  
  public void doDownload()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.pf(2);
    }
  }
  
  protected void doPause()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.doPause();
    }
  }
  
  public int getDownloadState()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState;
    }
    return 0;
  }
  
  protected int getProgress()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.progress;
    }
    return 0;
  }
  
  protected String in()
  {
    Object localObject1 = "";
    Object localObject2;
    if (this.jdField_b_of_type_Kjt != null)
    {
      localObject2 = this.jdField_b_of_type_Kjt.in();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    do
    {
      return localObject2;
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return localObject1;
  }
  
  protected String ix()
  {
    if (kmx.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Kkp.packageName;
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.pkgName;
    }
    return "";
  }
  
  protected String iy()
  {
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Kko != null)) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Kko.ZJ;
    }
    return "";
  }
  
  public void mB(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.isUserClick = this.isUserClick;
    }
    this.isUserClick = paramBoolean;
  }
  
  public void mC(boolean paramBoolean)
  {
    this.afT = paramBoolean;
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.afT = this.afT;
    }
  }
  
  public void ma() {}
  
  protected int ns()
  {
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.isUserClick = true;
      if (paramView == this.mRootView) {
        aFm();
      } else {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131362826: 
          if (this.jdField_b_of_type_Kjt != null) {
            this.jdField_b_of_type_Kjt.pf(2);
          }
          break;
        case 2131381902: 
          if (this.jdField_b_of_type_Kjt != null) {
            this.jdField_b_of_type_Kjt.pg(2);
          }
          break;
        }
      }
    }
  }
  
  protected void ph(int paramInt)
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.ph(paramInt);
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 1041: 
      if (paramObject != null) {}
      try
      {
        if ((paramObject instanceof AdData))
        {
          this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = ((AdData)paramObject);
          if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (!this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.mShowAdButton) && (this.mRootView != null))
          {
            this.mRootView.setVisibility(8);
            return true;
          }
          if (((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) || ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) || ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
            this.agT = true;
          }
          this.isUserClick = false;
          this.afT = false;
          this.jdField_b_of_type_Mrm = mrm.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
          if ((this.jdField_b_of_type_Mrm != null) && (this.jdField_b_of_type_Kjt == null) && ((this.mContext instanceof kny)))
          {
            this.jdField_b_of_type_Kjt = ((kny)this.mContext).a(this.jdField_b_of_type_Mrm.mPackageName);
            if ((this.jdField_b_of_type_Kjt != null) && (this.jdField_b_of_type_Kjt.a != null))
            {
              this.jdField_b_of_type_Kjt.a(new koy(this));
              this.jdField_b_of_type_Kjt.a.a(new koz(this));
            }
          }
          aFD();
          c(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = null;
          QLog.d("ReadinjoyNativeArticleAdDownloadView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
      return true;
    case 1053: 
      if ((paramObject != null) && ((paramObject instanceof JSONObject)))
      {
        this.Q = ((JSONObject)paramObject);
        if (this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null)
        {
          this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgressStyle(this.Q);
          if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
            c(null);
          }
        }
      }
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      this.ai = ((JSONObject)paramObject);
      if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_c_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null))
      {
        aFD();
        c(null);
      }
    }
    return true;
  }
  
  public void setModel(lie paramlie, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.mShowAdButton)) {
      c(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    }
  }
  
  protected boolean zA()
  {
    return (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (kmx.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (knp.b(null, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Kkp.packageName));
  }
  
  protected boolean zZ()
  {
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (kmx.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      aFC();
      return true;
    }
    return super.zZ();
  }
  
  protected boolean zy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.productType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kox(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kox
 * JD-Core Version:    0.7.0.1
 */