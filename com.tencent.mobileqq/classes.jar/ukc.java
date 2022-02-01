import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils.1;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ukc
{
  public static int a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return 1;
      if (ukr.a()) {
        return 3;
      }
    } while (!ukr.c(paramVideoAdInfo));
    return 2;
  }
  
  public static void a(Context paramContext, swi paramswi)
  {
    if ((paramswi != null) && (paramswi.jdField_a_of_type_Skq != null) && (paramswi.jdField_a_of_type_Skq.a != null))
    {
      VideoInfo localVideoInfo = paramswi.jdField_a_of_type_Skq.a;
      if (uks.a(localVideoInfo)) {
        paramswi.m.setText(uks.a(paramContext, localVideoInfo, 1));
      }
      paramswi.m.setTag(paramswi);
    }
  }
  
  public static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 0)) {
      paramView.setVisibility(0);
    }
  }
  
  private static void a(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt)
  {
    paramLayoutParams.width = paramInt;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  private static void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramView == null) || (paramContext == null) || (paramLayoutParams == null)) {
      return;
    }
    paramLayoutParams.leftMargin = AIOUtils.dp2px(paramInt1, paramContext.getResources());
    paramLayoutParams.rightMargin = AIOUtils.dp2px(paramInt2, paramContext.getResources());
    paramLayoutParams.topMargin = AIOUtils.dp2px(paramInt3, paramContext.getResources());
    paramLayoutParams.bottomMargin = AIOUtils.dp2px(paramInt4, paramContext.getResources());
    paramLayoutParams.height = AIOUtils.dp2px(paramInt6, paramContext.getResources());
    if (paramInt5 > 0) {
      paramLayoutParams.width = AIOUtils.dp2px(paramInt5, paramContext.getResources());
    }
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  public static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setAlpha(0.5F);
  }
  
  public static void a(swi paramswi) {}
  
  private static void a(swi paramswi, int paramInt)
  {
    a(false, paramswi, paramInt);
    b(false, paramswi, paramInt);
  }
  
  public static void a(swi paramswi, String paramString)
  {
    if ((paramswi == null) || (paramswi.n == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramswi.n.setText(paramString);
    a(paramswi.n);
    ThreadManager.getUIHandler().postDelayed(new AdVideoButtonUIUtils.1(paramswi), 1000L);
  }
  
  public static void a(boolean paramBoolean, swi paramswi)
  {
    if ((paramswi == null) || (paramswi.jdField_a_of_type_Skq == null) || (paramswi.jdField_a_of_type_Skq.a == null) || (paramswi.jdField_a_of_type_Skq.a.a == null)) {
      return;
    }
    int i = a(paramswi.jdField_a_of_type_Skq.a.a);
    if (!paramBoolean)
    {
      a(paramswi, i);
      return;
    }
    b(paramswi, i);
  }
  
  private static void a(boolean paramBoolean, swi paramswi, int paramInt) {}
  
  public static boolean a()
  {
    return Aladdin.getConfig(343).getIntegerFromString("tiktok_big_style", 0) == 1;
  }
  
  public static void b(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8)) {
      paramView.setVisibility(8);
    }
  }
  
  private static void b(swi paramswi)
  {
    if ((paramswi == null) || (paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    } while ((localContext == null) || (paramswi.jdField_a_of_type_Skq == null) || (paramswi.jdField_a_of_type_Skq.a == null));
    Object localObject = paramswi.jdField_a_of_type_Skq.a;
    int i = localContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.dp2px(77.0F, localContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramswi.j.getLayoutParams();
    a(paramswi.j, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramswi.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    a(paramswi.jdField_c_of_type_AndroidWidgetRelativeLayout, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramswi.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (uks.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = AIOUtils.dp2px(124.0F, localContext.getResources());
      a(paramswi.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams, i);
      paramswi.jdField_c_of_type_AndroidWidgetTextView.setLineSpacing(AIOUtils.dp2px(4.0F, localContext.getResources()), 1.0F);
      localObject = (RelativeLayout.LayoutParams)paramswi.l.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(65.0F, localContext.getResources());
      if (!a()) {
        break label475;
      }
    }
    label475:
    for (((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(62.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(120.0F, localContext.getResources()))
    {
      paramswi.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(65.0F, localContext.getResources());
      paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramswi.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(12.0F, localContext.getResources());
      paramswi.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramswi.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
      paramswi.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramswi.h.setTypeface(Typeface.DEFAULT);
      paramswi.h.setTextSize(12.0F);
      localObject = (LinearLayout.LayoutParams)paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(38.0F, localContext.getResources());
      paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramswi.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(50.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramswi.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = AIOUtils.dp2px(114.0F, localContext.getResources());
      break;
    }
  }
  
  private static void b(swi paramswi, int paramInt)
  {
    a(true, paramswi, paramInt);
    b(true, paramswi, paramInt);
  }
  
  private static void b(boolean paramBoolean, swi paramswi, int paramInt)
  {
    int n = 15;
    int k = 0;
    if (paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) {}
    Context localContext;
    do
    {
      return;
      localContext = paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    } while (localContext == null);
    int i1 = -1;
    int m = 42;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 16;
      j = 13;
      k = 65;
      i1 = 205;
      m = 40;
    }
    for (;;)
    {
      ukq.a("AdVideoButtonUIUtils", "leftMargin = " + i + " rightMargin = " + n + " topMargin = " + j + " bottomMargin = " + k + " height = " + m);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      a(paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, localLayoutParams, localContext, i, n, j, k, i1, m);
      if (paramInt == 3)
      {
        b(paramswi);
        ukd.a(paramswi);
        a(paramswi.p);
        a(paramswi.k);
        return;
        if (paramInt == 2)
        {
          j = 8;
          k = 5;
          m = 31;
          i = 15;
        }
      }
      else
      {
        c(paramswi, paramInt);
        ukd.b(paramswi);
        b(paramswi.p);
        b(paramswi.k);
        return;
      }
      j = 0;
      n = 0;
      i = 0;
    }
  }
  
  public static boolean b()
  {
    return Aladdin.getConfig(343).getIntegerFromString("gray_btn", 0) == 1;
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 4)) {
      paramView.setVisibility(4);
    }
  }
  
  private static void c(swi paramswi, int paramInt)
  {
    if ((paramswi == null) || (paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    } while ((localContext == null) || (paramswi.jdField_a_of_type_Skq == null) || (paramswi.jdField_a_of_type_Skq.a == null));
    Object localObject = paramswi.jdField_a_of_type_Skq.a;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramswi.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (uks.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = AIOUtils.dp2px(51.0F, localContext.getResources());
      paramswi.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      if (paramInt != 2) {
        break label300;
      }
    }
    label300:
    for (((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(5.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(0.0F, localContext.getResources()))
    {
      paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramswi.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(75.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(75.0F, localContext.getResources());
      paramswi.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramswi.h.setTypeface(Typeface.DEFAULT);
      localObject = (LinearLayout.LayoutParams)paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
      paramswi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramswi.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(41.5F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(15.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(15.0F, localContext.getResources());
      paramswi.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = AIOUtils.dp2px(55.0F, localContext.getResources());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukc
 * JD-Core Version:    0.7.0.1
 */