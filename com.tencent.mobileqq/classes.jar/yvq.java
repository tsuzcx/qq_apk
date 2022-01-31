import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvAppBtnView;
import com.tencent.gdtad.api.motivevideo.GdtMvButtonHighLight;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class yvq
  implements View.OnClickListener, View.OnHoverListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtMvAppBtnView jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private GdtMvButtonHighLight jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight;
  private GdtMvDownloadBtnManager jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager;
  private String jdField_a_of_type_JavaLangString;
  private yuu jdField_a_of_type_Yuu;
  private yve jdField_a_of_type_Yve;
  private yvk jdField_a_of_type_Yvk;
  private yvl jdField_a_of_type_Yvl;
  private yvm jdField_a_of_type_Yvm;
  private yvs jdField_a_of_type_Yvs;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private GdtMvAppBtnView jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  
  public yvq(yvs paramyvs, View paramView, yve paramyve)
  {
    yxp.a("GdtMvElementsController", "GdtMvElementsController: ");
    this.jdField_a_of_type_Yvs = paramyvs;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidContentContext = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Yve = paramyve;
    this.jdField_a_of_type_Yuu = new yuu();
  }
  
  private static Context a(Context paramContext)
  {
    if ((paramContext == null) || ((paramContext instanceof Activity)) || (!(paramContext instanceof ContextThemeWrapper))) {
      return paramContext;
    }
    return a(((ContextThemeWrapper)paramContext).getBaseContext());
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidViewView.getContext());
    if (2 == paramInt) {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838333));
    }
    do
    {
      return localImageView;
      if (1 == paramInt)
      {
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838327));
        return localImageView;
      }
    } while (3 != paramInt);
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838328));
    return localImageView;
  }
  
  private URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130844649);
    localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130844649);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = yzb.a(140, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    paramString.setTag(bavw.b(i, i, yzb.a(21, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext))));
    paramString.setDecodeHandler(bavw.c);
    return paramString;
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_Yve.a();
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localObject = ((GdtMotiveVideoPageData)localObject).bannerBaseInfoText;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = ((String)localObject).length();
        if (i > 16)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localObject).substring(0, 16);
          this.jdField_b_of_type_JavaLangString = ((String)localObject).substring(16, i);
        }
      }
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label85;
      }
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return this.jdField_b_of_type_JavaLangString;
      label85:
      localObject = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout)
  {
    int n = 0;
    if ((paramLinearLayout == null) || (paramDouble < 7.0D)) {}
    for (;;)
    {
      return;
      int j;
      int i;
      int m;
      LinearLayout.LayoutParams localLayoutParams;
      if (paramDouble < 8.0D)
      {
        j = 0;
        k = 4;
        i = 1;
        m = actj.a(15.0F, this.jdField_a_of_type_AndroidViewView.getResources());
        localLayoutParams = new LinearLayout.LayoutParams(m, m);
        m = 0;
        label63:
        if (m >= k) {
          break label153;
        }
        if (m != 0) {
          break label133;
        }
      }
      label133:
      for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = actj.a(3.0F, this.jdField_a_of_type_AndroidViewView.getResources()))
      {
        paramLinearLayout.addView(a(1), localLayoutParams);
        m += 1;
        break label63;
        if (paramDouble < 9.0D)
        {
          j = 1;
          k = 4;
          i = 0;
          break;
        }
        j = 0;
        k = 5;
        i = 0;
        break;
      }
      label153:
      int k = 0;
      for (;;)
      {
        m = n;
        if (k >= j) {
          break;
        }
        paramLinearLayout.addView(a(2), localLayoutParams);
        k += 1;
      }
      while (m < i)
      {
        paramLinearLayout.addView(a(3), localLayoutParams);
        m += 1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_Yve.a();
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      localObject2 = new Rect();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getGlobalVisibleRect((Rect)localObject2);
      if ((this.jdField_c_of_type_AndroidViewView == null) || (!((Rect)localObject2).contains(paramInt1, paramInt2))) {
        break label63;
      }
      this.jdField_c_of_type_AndroidViewView.setContentDescription(b());
    }
    label63:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
        this.jdField_a_of_type_AndroidWidgetTextView.getGlobalVisibleRect((Rect)localObject2);
        if ((this.jdField_c_of_type_AndroidViewView != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
        {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(((GdtMotiveVideoPageData)localObject1).bannerImgName);
          return;
        }
      } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
      this.jdField_b_of_type_AndroidWidgetTextView.getGlobalVisibleRect((Rect)localObject2);
    } while ((this.jdField_c_of_type_AndroidViewView == null) || (!((Rect)localObject2).contains(paramInt1, paramInt2)));
    Object localObject2 = this.jdField_c_of_type_AndroidViewView;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (localObject1 = ((GdtMotiveVideoPageData)localObject1).bannerBaseInfoText;; localObject1 = this.jdField_a_of_type_JavaLangString)
    {
      ((View)localObject2).setContentDescription((CharSequence)localObject1);
      return;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      if (Build.VERSION.SDK_INT < 16) {}
    }
    for (;;)
    {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if (!paramBoolean) {
          break label184;
        }
        i = 1334;
        if (paramBoolean)
        {
          j = yzb.e(this.jdField_a_of_type_AndroidContentContext);
          localLayoutParams.height = yzb.a(paramInt, i, j);
          this.jdField_b_of_type_AndroidViewView.setBackground(yzb.a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165592), 8, 80));
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          yxp.b("GdtMvElementsController", "initDesMaskPositions " + paramInt + "|" + paramBoolean);
          return;
        }
        int j = yzb.f(this.jdField_a_of_type_AndroidContentContext);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        yxp.d("GdtMvElementsController", "initDesMaskPositions error! ", localThrowable);
        return;
      }
      return;
      label184:
      int i = 750;
    }
  }
  
  private void a(String paramString)
  {
    double d1 = 10.0D;
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        yxp.a("GdtMvElementsController", "updateScoreAndStar " + paramString);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165475));
        float f = 0.0F;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null) {
          f = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
        }
        yxp.a("GdtMvElementsController", "updateScoreAndStar " + this.jdField_b_of_type_AndroidWidgetTextView.getWidth() + " mw " + f);
        int i = Math.max((int)f, this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
        this.jdField_c_of_type_AndroidWidgetTextView.setWidth(i);
      }
    }
    else {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(500);
    if (localGdtMotiveVideoPageData.appScore < 7.0D) {
      if (Double.compare(localGdtMotiveVideoPageData.appScore, 0.0D) == 0) {
        if (a())
        {
          paramString = "精品推荐 ";
          localStringBuilder.append(paramString);
          label264:
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          label280:
          if (localGdtMotiveVideoPageData.downloadNum >= 100000L) {
            break label451;
          }
          if (0L != localGdtMotiveVideoPageData.downloadNum) {
            break label439;
          }
          if (!a()) {
            break label432;
          }
          paramString = "热门下载";
          label313:
          localStringBuilder.append(paramString);
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      return;
      paramString = "精品内容 ";
      break;
      localStringBuilder.append("精品推荐 ");
      break label264;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label280;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      a(localGdtMotiveVideoPageData.appScore, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      paramString = new DecimalFormat("0.0");
      if (localGdtMotiveVideoPageData.appScore > 10.0D) {}
      for (;;)
      {
        localStringBuilder.append(paramString.format(d1)).append("分 ");
        break;
        d1 = localGdtMotiveVideoPageData.appScore;
      }
      label432:
      paramString = "热门推荐";
      break label313;
      label439:
      localStringBuilder.append("热门下载 ");
      continue;
      label451:
      if (localGdtMotiveVideoPageData.downloadNum < 100000000L) {
        localStringBuilder.append(new BigDecimal(localGdtMotiveVideoPageData.downloadNum / 10000.0D).setScale(0, 4)).append("万");
      }
      for (;;)
      {
        if (!a()) {
          break label553;
        }
        localStringBuilder.append("次下载");
        break;
        localStringBuilder.append(new BigDecimal(localGdtMotiveVideoPageData.downloadNum / 100000000.0D).setScale(1, 4)).append("亿");
      }
      label553:
      localStringBuilder.append("次浏览");
    }
  }
  
  private boolean a()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    return (localGdtMotiveVideoPageData.productType == 12) || (localGdtMotiveVideoPageData.productType == 19);
  }
  
  private String b()
  {
    String str2 = ajya.a(2131705213);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    Object localObject = this.jdField_a_of_type_Yve.a();
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (!((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get().isEmpty())
      {
        str2 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get(0)).txt.get();
        localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).app_info.app_package_name.get();
        yxp.b("GdtMvElementsController", "getContentStrByStyle pushName " + str2);
        if (TextUtils.isEmpty(str2)) {
          break label165;
        }
        str1 = str2;
        if (a())
        {
          str1 = str2;
          if (nmc.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject))
          {
            if (!localGdtMotiveVideoPageData.isStyleC()) {
              break label158;
            }
            str1 = ajya.a(2131705208);
          }
        }
      }
    }
    return str1;
    label158:
    return ajya.a(2131705209);
    label165:
    if (a())
    {
      if (nmc.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject)) {
        return ajya.a(2131705210);
      }
      return ajya.a(2131705212);
    }
    return ajya.a(2131705214);
  }
  
  private void h()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        i();
        return;
      }
      k();
      return;
    }
    j();
  }
  
  private void i()
  {
    a(700, true);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = yzb.a(140, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = yzb.a(1054, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(30, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = yzb.a(1063, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(196, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = yzb.a(1111, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(196, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin = yzb.a(1160, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(196, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    localLayoutParams.height = yzb.a(80, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = yzb.a(1224, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(30, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    localLayoutParams.height = yzb.a(129, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = yzb.a(1199, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(5, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    yxp.a("GdtMvElementsController", "inti585Vpositions() urlBtnLp2.topMargin = " + localLayoutParams.topMargin + ", urlBtnLp2.height = " + localLayoutParams.height);
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height = yzb.a(315, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void j()
  {
    a(400, false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = yzb.a(140, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = yzb.a(580, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(30, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = yzb.a(589, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(196, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = yzb.a(637, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(196, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin = yzb.a(685, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(196, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    localLayoutParams.height = yzb.a(80, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = yzb.a(611, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(1034, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = yzb.a(30, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    localLayoutParams.height = yzb.a(129, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = yzb.a(586, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(1009, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = yzb.a(5, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height = yzb.a(200, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).topMargin = yzb.a(742, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setHeight(yzb.a(80, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext)));
    localLayoutParams.topMargin = yzb.a(1224, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(30, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    this.jdField_a_of_type_AndroidWidgetButton.setHeight(yzb.a(129, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext)));
    localLayoutParams.topMargin = yzb.a(1199, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = yzb.a(5, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
  }
  
  private void l()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (TextUtils.isEmpty(localGdtMotiveVideoPageData.bannerLogo)) {
        break label111;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(localGdtMotiveVideoPageData.bannerLogo));
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a(localGdtMotiveVideoPageData.bannerLogo));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localGdtMotiveVideoPageData.bannerImgName);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localGdtMotiveVideoPageData.bannerImgName);
        }
      }
      a(a());
      d();
      return;
      label111:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844649);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844649);
      }
    }
  }
  
  private void m()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_Yve.a();
    Activity localActivity = this.jdField_a_of_type_Yvs.a().a();
    if (localActivity != null)
    {
      yxp.b("GdtMvElementsController", "doHandleClick");
      GdtHandler.a(GdtDemoMvFragment.a(localAdInfo, localGdtMotiveVideoPageData, localActivity));
    }
  }
  
  private void n()
  {
    int i = this.jdField_a_of_type_Yve.a().exp_info.video_volume.get();
    yxp.a("GdtMvElementsController", "[initData] videoVolume = " + i);
    yvs localyvs = this.jdField_a_of_type_Yvs;
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localyvs.a = bool;
      return;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Yve.a();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362135);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362029));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362031));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362047));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362049));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361969));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361972));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362039));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight = ((GdtMvButtonHighLight)this.jdField_a_of_type_AndroidViewView.findViewById(2131362055));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = ((GdtMvAppBtnView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362060));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = ((GdtMvAppBtnView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362059));
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setOnClickListener(this);
      this.jdField_a_of_type_Yuu.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setOnClickListener(this);
      this.jdField_a_of_type_Yuu.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView);
    }
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
    {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setOnClickListener(this);
      this.jdField_a_of_type_Yuu.a(this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362056));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362041));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379004));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366962);
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Yuu.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnHoverListener(this);
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366963);
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Yuu.a(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    }
    if ((((GdtMotiveVideoPageData)localObject).vSize != 585) && (((GdtMotiveVideoPageData)localObject).screenOrientation == 1)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363340));
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362027));
    h();
    n();
    l();
    localObject = b();
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a((String)localObject);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a((String)localObject);
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = new GdtMvDownloadBtnManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Yve.a(), (String)localObject, this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.f();
  }
  
  public void a(int paramInt)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    yxp.b("GdtMvElementsController", "adjustViewsPosition " + paramInt + " style " + localGdtMotiveVideoPageData.style);
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.a();
    }
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        if (this.jdField_a_of_type_Yvm == null)
        {
          this.jdField_a_of_type_Yvm = new yvm(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_Yvm.a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_Yvm.a(paramInt);
      }
      while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      if (this.jdField_a_of_type_Yvl == null)
      {
        this.jdField_a_of_type_Yvl = new yvl(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Yvl.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_Yvl.a(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Yvk == null)
    {
      this.jdField_a_of_type_Yvk = new yvk(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Yvk.a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_Yvk.a(paramInt);
  }
  
  public void b()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130839697);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setBackgroundDrawable(localDrawable);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167034);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setTextColor(i);
  }
  
  public void c()
  {
    yxp.b("GdtMvElementsController", "enableMvBtnUrlStyleDefault");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setBackgroundDrawable(this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130839691));
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
    }
  }
  
  public void d()
  {
    String str = b();
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null) && (this.jdField_a_of_type_AndroidWidgetButton != null))
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(str);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(str);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.a();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    }
    if (this.jdField_a_of_type_Yvm != null)
    {
      this.jdField_a_of_type_Yvm.b();
      this.jdField_a_of_type_Yvm = null;
    }
    if (this.jdField_a_of_type_Yvl != null)
    {
      this.jdField_a_of_type_Yvl.b();
      this.jdField_a_of_type_Yvl = null;
    }
    if (this.jdField_a_of_type_Yvk != null)
    {
      this.jdField_a_of_type_Yvk.b();
      this.jdField_a_of_type_Yvk = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.b();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = null;
    }
    if (this.jdField_a_of_type_Yuu != null) {
      this.jdField_a_of_type_Yuu.a();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.c();
    }
  }
  
  public void g()
  {
    yxp.a("GdtMvElementsController", "onResume: ");
    d();
    f();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yve.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_Yve.a();
    long l = this.jdField_a_of_type_Yvs.a();
    String str = "";
    switch (i)
    {
    default: 
      paramView = str;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramView)) && (localAdInfo != null)) {
        localAdInfo.report_info.click_url.set(paramView);
      }
      return;
      yxp.a("GdtMvElementsController", "[click ad btn] " + localAdInfo);
      Activity localActivity = this.jdField_a_of_type_Yvs.a().a();
      paramView = str;
      if (localAdInfo != null)
      {
        paramView = str;
        if (localActivity != null)
        {
          paramView = localAdInfo.report_info.click_url.get();
          str = this.jdField_a_of_type_Yuu.a(paramView, l, this.jdField_a_of_type_Yvs.a(), this.jdField_a_of_type_Yvs.b());
          localAdInfo.report_info.click_url.set(str);
          GdtHandler.a(GdtDemoMvFragment.a(localAdInfo, localGdtMotiveVideoPageData, localActivity));
          continue;
          yxp.a("GdtMvElementsController", "[click ad download btn] ");
          paramView = str;
          if (localAdInfo != null)
          {
            paramView = localAdInfo.report_info.click_url.get();
            str = this.jdField_a_of_type_Yuu.a(paramView, l, this.jdField_a_of_type_Yvs.a(), this.jdField_a_of_type_Yvs.b());
            localAdInfo.report_info.click_url.set(str);
            if ((localAdInfo.exp_info.reward_video_download_type.get() == 1) && (localAdInfo.product_type.get() == 12) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null))
            {
              str = localAdInfo.app_info.app_package_name.get();
              if (nmc.a(this.jdField_a_of_type_AndroidContentContext, str)) {
                m();
              } else {
                this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a();
              }
            }
            else
            {
              m();
            }
          }
        }
      }
    }
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      yxp.d("GdtMvElementsController", "onHover " + paramMotionEvent.getAction());
      a((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvq
 * JD-Core Version:    0.7.0.1
 */