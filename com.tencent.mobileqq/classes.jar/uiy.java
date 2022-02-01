import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;

public class uiy
  implements soc
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private HashMap<String, ule> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private sob jdField_a_of_type_Sob;
  private swu jdField_a_of_type_Swu;
  private ugp jdField_a_of_type_Ugp;
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
  
  private JumpMode a()
  {
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject == null)
    {
      QLog.e("VideoFeedsSoftAdBarDelegateForAd", 1, "videoSoftAd jump error, advertisementInfo is null");
      localObject = JumpMode.FAIL;
    }
    JumpMode localJumpMode;
    do
    {
      return localObject;
      localJumpMode = JumpMode.FAIL;
      if (ugj.a((BaseArticleInfo)localObject)) {
        localJumpMode = TKDAdJumpData.SoftAdJumpData.obtainJumpData(((AdvertisementInfo)localObject).mAdvertisementSoftInfo).doJumpAction(this.jdField_a_of_type_AndroidAppActivity);
      }
      localObject = localJumpMode;
    } while (localJumpMode != JumpMode.FAIL);
    return udy.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, JumpMode paramJumpMode, AdClickPos paramAdClickPos)
  {
    a(paramInt1, paramInt2, paramReportAction, paramJumpMode, false, paramAdClickPos);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, JumpMode paramJumpMode, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramReportAction, paramJumpMode, paramBoolean, null);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, JumpMode paramJumpMode, boolean paramBoolean, AdClickPos paramAdClickPos)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt2);
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(paramAdClickPos);
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
    }
    uec.a(paramReportAction, paramJumpMode, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, paramInt1, 5, paramBoolean);
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
          localSpannableStringBuilder.setSpan(new uiz(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        if (b()) {
          break label398;
        }
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        if (!b()) {
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
  
  private void e()
  {
    a(2, 0, ReportAction.EXPOSE, JumpMode.UNKNOWN, true);
    a(2, 0, ReportAction.EXPOSE, JumpMode.UNKNOWN, false);
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
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    c(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, swu paramswu)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Swu = paramswu;
    paramswu.x.setTag(2131381183, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
        this.jdField_a_of_type_Ugp.a();
      }
      olx.a().a(paramswu.getAdapterPosition());
      olx.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
      e();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Ugp = new ugp(paramQQAppInterface);
  }
  
  public void a(sob paramsob)
  {
    this.jdField_a_of_type_Sob = paramsob;
  }
  
  public void a(swu paramswu)
  {
    Object localObject = (LinearLayout.LayoutParams)paramswu.e.getLayoutParams();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
    ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(250.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramswu.e.setBackgroundDrawable(localGradientDrawable);
    paramswu.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramswu.h.setVisibility(0);
    paramswu.v.setVisibility(0);
    if (a() == 0) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k))) {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k)))
        {
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
          paramswu.N.setVisibility(0);
          paramswu.N.setBackgroundDrawable((Drawable)localObject);
          paramswu.c.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      paramswu.N.setVisibility(8);
      break;
      paramswu.N.setVisibility(8);
      break;
      if (a() == 2)
      {
        paramswu.c.setVisibility(8);
        return;
      }
    } while (a() != 1);
    paramswu.c.setVisibility(0);
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
      if (uks.a(this.jdField_a_of_type_Ugp)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, swu paramswu, double paramDouble, long paramLong)
  {
    return false;
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
      return anvx.a(2131715516);
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label135:
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.c != null)) {
      this.jdField_a_of_type_Swu.c.a();
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public boolean b()
  {
    return this.e;
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
  
  public void c()
  {
    if ((this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.c != null)) {
      this.jdField_a_of_type_Swu.c.b();
    }
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
    this.f = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void onClick(View paramView)
  {
    swu localswu = (swu)paramView.getTag();
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Sob != null) {
        this.jdField_a_of_type_Sob.a();
      }
      this.f = true;
      a(1, 3, ReportAction.CLOSE, JumpMode.UNKNOWN, AdClickPos.SoftAdClose);
      return;
      paramView = a();
      a(1, 0, ReportAction.CLICK, paramView, AdClickPos.SoftAdComponent);
      return;
    } while ((a() != 1) || (localswu.c == null));
    localswu.c.a(AdClickPos.SoftAdClickBtn, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uiy
 * JD-Core Version:    0.7.0.1
 */