import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;

public class tut
  implements sca
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private HashMap<String, txh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private oau jdField_a_of_type_Oau;
  private rvv jdField_a_of_type_Rvv;
  private sbz jdField_a_of_type_Sbz;
  private tse jdField_a_of_type_Tse;
  private txh jdField_a_of_type_Txh;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private boolean jdField_b_of_type_Boolean;
  private Set<String> jdField_c_of_type_JavaUtilSet;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 1;
    case 3: 
      return 1;
    case 4: 
      return 4;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt2);
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
    }
    tqk.a(e(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, obb.an, paramInt1, 5);
  }
  
  private CharSequence b()
  {
    float f1 = 13.0F;
    if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k = "";
    }
    String str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l + " " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
    if (!TextUtils.isEmpty(str1.trim()))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      int i;
      int j;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
      {
        str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l;
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          j = str2.length() + i;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i, j, 33);
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(AIOUtils.dp2px(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new tuv(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        if (c()) {
          break label398;
        }
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        if (!c()) {
          break label422;
        }
      }
      for (;;)
      {
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
        return localSpannableStringBuilder;
        label398:
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i, j, 33);
        break;
        label422:
        f1 = 11.0F;
      }
    }
    return "";
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
        this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt);
      }
      return;
      paramInt = 41;
      continue;
      paramInt = 42;
      continue;
      paramInt = 8;
      continue;
      paramInt = 40;
    }
  }
  
  private void c(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_Int;
      this.e = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.y.equals("1");
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Boolean = this.e;
      this.f = false;
    }
  }
  
  private String e()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  private boolean e()
  {
    return (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0);
  }
  
  private void i()
  {
    if (bfwv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Txh.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Rvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_Rvv.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717433));
    }
    while (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_Rvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_Rvv.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717426));
  }
  
  private void j()
  {
    c(obb.jdField_b_of_type_Int);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      String str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null) {
        str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + "_B";
      }
      if ((this.jdField_c_of_type_JavaUtilSet != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(str)))
      {
        this.jdField_c_of_type_JavaUtilSet.add(str);
        j();
      }
    }
  }
  
  private void l()
  {
    tqg.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void m()
  {
    if (this.e) {}
    for (ReadInjoyHeaderAdDownloadView localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Rvv.b;; localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Rvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView)
    {
      localReadInjoyHeaderAdDownloadView.a(this.jdField_a_of_type_Txh.jdField_b_of_type_Int);
      return;
    }
  }
  
  public int a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
      return 1;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      Object localObject2;
      Object localObject1;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12))
      {
        localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "不容错过的热门应用";
        }
      }
      do
      {
        return localObject1;
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 0) {
          break;
        }
        localObject2 = b();
        localObject1 = localObject2;
      } while (!TextUtils.isEmpty((CharSequence)localObject2));
      return "不容错过的热门商品";
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {}
        for (localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;; localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          return "点击查看详情";
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) {
          return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo;
        }
        return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImg;
      }
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  protected void a(int paramInt) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    c(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, rvv paramrvv)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Rvv = paramrvv;
    String str;
    txh localtxh2;
    txh localtxh1;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localtxh2 = (txh)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localtxh1 = localtxh2;
        if (localtxh2 == null)
        {
          localtxh1 = txh.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localtxh1);
        }
        if (localtxh1 != null)
        {
          this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.o = localtxh1.jdField_d_of_type_JavaLangString;
          if ((oau.a(BaseApplicationImpl.getApplication(), localtxh1)) || (bfwv.a(BaseApplicationImpl.getContext(), localtxh1.jdField_d_of_type_JavaLangString))) {
            localtxh1.jdField_a_of_type_Int = 5;
          }
          this.jdField_a_of_type_Txh = localtxh1;
          if (!this.e) {
            break label291;
          }
          i();
          paramrvv.b.a(a(localtxh1.jdField_a_of_type_Int), localtxh1.jdField_b_of_type_Int);
        }
      }
    }
    label291:
    label502:
    for (;;)
    {
      paramrvv.y.setTag(2131380831, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
          this.jdField_a_of_type_Tse.a();
        }
        oeg.a().a(paramrvv.getAdapterPosition());
        oeg.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
        j();
      }
      return;
      paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a(a(localtxh1.jdField_a_of_type_Int), localtxh1.jdField_b_of_type_Int);
      continue;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localtxh2 = (txh)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        int i = twr.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        localtxh1 = localtxh2;
        if (localtxh2 == null)
        {
          localtxh1 = txh.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo, i);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localtxh1);
        }
        if ((oau.a(BaseApplicationImpl.getApplication(), localtxh1)) || (bfwv.a(BaseApplicationImpl.getContext(), localtxh1.jdField_d_of_type_JavaLangString))) {
          localtxh1.jdField_a_of_type_Int = 5;
        }
        this.jdField_a_of_type_Txh = localtxh1;
        if (this.e)
        {
          i();
          paramrvv.b.a(a(localtxh1.jdField_a_of_type_Int), localtxh1.jdField_b_of_type_Int);
        }
        for (;;)
        {
          if (i == 0) {
            break label502;
          }
          e();
          break;
          paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a(a(localtxh1.jdField_a_of_type_Int), localtxh1.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Oau = new oau(paramActivity);
    this.jdField_a_of_type_Oau.a(new tuu(this));
    this.jdField_a_of_type_Tse = new tse(paramQQAppInterface);
  }
  
  public void a(rvv paramrvv)
  {
    LinearLayout.LayoutParams localLayoutParams1;
    if (!this.e)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)paramrvv.w.getLayoutParams();
      if (TextUtils.isEmpty(paramrvv.N.getText().toString().trim()))
      {
        paramrvv.N.setVisibility(8);
        localLayoutParams1.gravity = 16;
        paramrvv.w.setLayoutParams(localLayoutParams1);
        if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
          break label209;
        }
        paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
        paramrvv.w.setVisibility(0);
        label111:
        if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString))) {
          paramrvv.M.setText(e());
        }
      }
    }
    for (;;)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)paramrvv.N.getLayoutParams();
      localLayoutParams2.topMargin = AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrvv.N.setLayoutParams(localLayoutParams2);
      paramrvv.N.setVisibility(0);
      localLayoutParams1.gravity = 16;
      break;
      label209:
      paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(0);
      paramrvv.w.setVisibility(8);
      break label111;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1))
      {
        paramrvv.b.setVisibility(8);
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString)))
      {
        paramrvv.Q.setText(e());
        return;
        paramrvv.b.setVisibility(0);
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
  }
  
  public void a(rvv paramrvv, int paramInt1, int paramInt2)
  {
    if ((paramrvv == null) || (this.jdField_a_of_type_Txh == null)) {
      return;
    }
    this.jdField_a_of_type_Txh.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 != 8) {
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = paramInt1;
    }
    this.jdField_d_of_type_Boolean = false;
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
      return;
    case 1: 
      if (this.e)
      {
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717433));
        paramrvv.b.a(2, 100);
      }
    case 3: 
    case 5: 
      for (;;)
      {
        this.jdField_d_of_type_Boolean = true;
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        if (!this.e) {
          break label296;
        }
        paramrvv.b.setVisibility(0);
        return;
        m();
        if (!this.e) {
          break;
        }
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
        if (this.e)
        {
          paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramrvv.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717426));
          paramrvv.b.a(2, 100);
          this.jdField_d_of_type_Boolean = true;
          if (this.jdField_c_of_type_Boolean)
          {
            if (!this.e) {
              break label272;
            }
            paramrvv.b.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt1);
          return;
          paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
          break;
          paramrvv.x.setVisibility(0);
        }
        paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
      }
      paramrvv.x.setVisibility(0);
      return;
    case 4: 
      if (this.e)
      {
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramrvv.b.a(4, paramInt2);
        return;
      }
      paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a(4, paramInt2);
      return;
    case 6: 
      label272:
      label296:
      if (this.e) {
        paramrvv.b.a(0, 0);
      }
      for (;;)
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, amtj.a(2131715253), 0).a();
        return;
        paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a(0, 0);
      }
    }
    d();
  }
  
  public void a(sbz paramsbz)
  {
    this.jdField_a_of_type_Sbz = paramsbz;
  }
  
  public boolean a()
  {
    boolean bool;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 2)) {
      bool = true;
    }
    while ((bool) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2))
    {
      String str1 = b();
      String str2 = a();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {}
    do
    {
      do
      {
        return true;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      if (twr.a(this.jdField_a_of_type_Tse)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, rvv paramrvv, double paramDouble, long paramLong)
  {
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_Txh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Txh.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {
          break label135;
        }
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) {
          break label74;
        }
        str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName;
      }
    }
    return str1;
    label74:
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)) {
        return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc;
      }
      return amtj.a(2131715168);
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label135:
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.f = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Oau != null) {
      this.jdField_a_of_type_Oau.a();
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void b(rvv paramrvv)
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public String c()
  {
    String str2 = "详情";
    String str1 = str2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        str1 = str2;
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.D)) {
            str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.D;
          }
        }
      }
    }
    return str1;
  }
  
  protected void c()
  {
    if ((d()) && (this.jdField_a_of_type_Txh != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.jdField_d_of_type_JavaLangString)) {
        twr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh.jdField_d_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  public void c(rvv paramrvv)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_d_of_type_Boolean)
    {
      if (!this.e) {
        break label39;
      }
      paramrvv.b.setVisibility(0);
    }
    for (;;)
    {
      if (this.e) {
        k();
      }
      return;
      label39:
      paramrvv.x.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        str1 = str2;
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.E)) {
            str1 = "来自" + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.E;
          }
        }
      }
    }
    return str1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Txh == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int == 4)
        {
          a(this.jdField_a_of_type_Rvv, 4, b());
          return;
        }
        if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int == 5)
        {
          String str = this.jdField_a_of_type_Txh.jdField_d_of_type_JavaLangString;
          if (bfwv.a(BaseApplicationImpl.getContext(), str))
          {
            this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 1;
            a(this.jdField_a_of_type_Rvv, 1, b());
            return;
          }
          a(this.jdField_a_of_type_Rvv, 5, b());
          return;
        }
      } while (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 3);
      a(this.jdField_a_of_type_Rvv, 3, b());
    } while ((this.jdField_a_of_type_Txh == null) || (this.jdField_a_of_type_Oau == null));
    this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
    return;
    int i = obb.jdField_a_of_type_Int;
    if (oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh))
    {
      g();
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 5;
      c(i);
      return;
    }
    f();
    c(i);
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Oau != null) && (this.jdField_a_of_type_Txh != null)) {
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Oau != null) && (this.jdField_a_of_type_Txh != null)) {
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
    }
    if ((this.jdField_a_of_type_Rvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView != null) || ((this.jdField_a_of_type_Rvv.b != null) && (this.jdField_a_of_type_Txh != null))) {
      m();
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Txh != null) && (this.jdField_a_of_type_Oau != null)) {
      this.jdField_a_of_type_Oau.d(this.jdField_a_of_type_Txh);
    }
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_Txh != null) && (this.jdField_a_of_type_Oau != null)) {
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    rvv localrvv = (rvv)paramView.getTag();
    int j = obb.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    default: 
    case 2131362019: 
    case 2131362113: 
    case 2131362018: 
    case 2131362021: 
    case 2131368039: 
    case 2131380548: 
    case 2131380549: 
      do
      {
        return;
        if (this.jdField_a_of_type_Sbz != null) {
          this.jdField_a_of_type_Sbz.a();
        }
        this.f = true;
        b(paramView.getId());
        a(j, 3);
        return;
        b(paramView.getId());
        if (!this.e) {
          break label296;
        }
        if ((a() != 1) || (paramView.getId() != 2131362018) || (localrvv == null)) {
          break;
        }
        localrvv.b.callOnClick();
      } while (localrvv.b.a() == 2);
      localrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramView.getId() == 2131362018) {}
      for (i = 1;; i = 0)
      {
        a(j, i);
        if ((paramView.getId() != 2131362018) || (TextUtils.isEmpty(uhs.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo)))) {
          break;
        }
        uhs.a(this.jdField_a_of_type_AndroidAppActivity, uhs.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo), this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdRl, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId);
        return;
      }
      label296:
      if (paramView.getId() == 2131368039) {}
      for (;;)
      {
        a(j, i);
        break;
        i = 0;
      }
      l();
      return;
    }
    if (this.e)
    {
      i = localrvv.b.a();
      if (i != 2) {
        break label525;
      }
      if (!bfwv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Txh.jdField_d_of_type_JavaLangString)) {
        break label404;
      }
      c();
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 1;
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 1;
    }
    label525:
    for (;;)
    {
      a(j, 1);
      return;
      i = localrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.a();
      break;
      label404:
      if (oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh))
      {
        paramView = bhyo.a().c(this.jdField_a_of_type_Txh.jdField_d_of_type_JavaLangString);
        bhyo.a().a(paramView);
        this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
        this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 5;
      }
      else if (oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh))
      {
        g();
        this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
        this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 5;
      }
      else if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
      {
        f();
      }
      else
      {
        l();
        continue;
        if ((i == 0) || (i == 4))
        {
          if (i == 4)
          {
            this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 3;
            this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 3;
          }
          if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
          {
            if (i == 0)
            {
              if (this.jdField_a_of_type_Txh.jdField_a_of_type_Boolean)
              {
                e();
                return;
              }
              f();
            }
            else
            {
              f();
            }
          }
          else {
            l();
          }
        }
        else if (i == 1)
        {
          this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 4;
          this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 4;
          h();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tut
 * JD-Core Version:    0.7.0.1
 */