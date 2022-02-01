import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvAppBtnView;
import com.tencent.gdtad.api.motivevideo.GdtMvButtonHighLight;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager;
import com.tencent.gdtad.jsbridge.GdtCanvasFragment4CmGame;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class tjc
  implements View.OnClickListener, View.OnHoverListener
{
  private TextView Bl;
  private TextView Bm;
  private TextView Bn;
  private TextView Bo;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private GdtMvButtonHighLight jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight;
  private tii jdField_a_of_type_Tii;
  private tir jdField_a_of_type_Tir;
  private tix jdField_a_of_type_Tix;
  private tiy jdField_a_of_type_Tiy;
  private tiz jdField_a_of_type_Tiz;
  private String aJu;
  private String aJv;
  private GdtMvDownloadBtnManager jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager;
  private tje jdField_b_of_type_Tje;
  private GdtMvAppBtnView c;
  private Button cK;
  private GdtMvAppBtnView d;
  private LinearLayout fE;
  private LinearLayout fF;
  private RelativeLayout gf;
  private RelativeLayout gg;
  private Context mContext;
  private View mRootView;
  private ImageView oV;
  private ImageView oW;
  private TextView pP;
  private View qR;
  private View qY;
  private View qZ;
  
  public tjc(tje paramtje, View paramView, tir paramtir)
  {
    tkw.d("GdtMvElementsController", "GdtMvElementsController: ");
    this.jdField_b_of_type_Tje = paramtje;
    this.mRootView = paramView;
    this.mContext = paramView.getContext();
    this.mContext = c(this.mContext);
    this.jdField_a_of_type_Tir = paramtir;
    this.jdField_a_of_type_Tii = new tii();
  }
  
  private boolean Of()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    return (localGdtMotiveVideoPageData.productType == 12) || (localGdtMotiveVideoPageData.productType == 19);
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.mRootView.getContext());
    if (2 == paramInt) {
      localImageView.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838594));
    }
    do
    {
      return localImageView;
      if (1 == paramInt)
      {
        localImageView.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838588));
        return localImageView;
      }
    } while (3 != paramInt);
    localImageView.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838589));
    return localImageView;
  }
  
  private URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = this.mRootView.getResources();
    localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130846397);
    localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130846397);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = tls.i(140, 750, tls.af(this.mContext));
    paramString.setTag(aqbn.d(i, i, tls.i(21, 750, tls.af(this.mContext))));
    paramString.setDecodeHandler(aqbn.d);
    return paramString;
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
        m = wja.dp2px(15.0F, this.mRootView.getResources());
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
      for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = wja.dp2px(3.0F, this.mRootView.getResources()))
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
  
  private void av(int paramInt, boolean paramBoolean)
  {
    if (this.qR != null) {
      if (Build.VERSION.SDK_INT < 16) {}
    }
    for (;;)
    {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qR.getLayoutParams();
        if (!paramBoolean) {
          break label182;
        }
        i = 1334;
        if (paramBoolean)
        {
          j = tls.ae(this.mContext);
          localLayoutParams.height = tls.i(paramInt, i, j);
          this.qR.setBackground(tls.a(this.mContext.getResources().getColor(2131165836), 8, 80));
          this.qR.setVisibility(0);
          this.qR.setLayoutParams(localLayoutParams);
          tkw.i("GdtMvElementsController", "initDesMaskPositions " + paramInt + "|" + paramBoolean);
          return;
        }
        int j = tls.af(this.mContext);
        continue;
        this.qR.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        this.qR.setVisibility(8);
        tkw.e("GdtMvElementsController", "initDesMaskPositions error! ", localThrowable);
        return;
      }
      return;
      label182:
      int i = 750;
    }
  }
  
  private void bDk()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        bDl();
        return;
      }
      bDn();
      return;
    }
    bDm();
  }
  
  private void bDl()
  {
    av(700, true);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oV.getLayoutParams();
    localLayoutParams.width = tls.i(140, 750, tls.af(this.mContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = tls.i(1054, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(30, 750, tls.af(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.Bl.getLayoutParams();
    localLayoutParams.topMargin = tls.i(1063, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(196, 750, tls.af(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.pP.getLayoutParams();
    localLayoutParams.topMargin = tls.i(1111, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(196, 750, tls.af(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.fF.getLayoutParams();
    localLayoutParams.topMargin = tls.i(1160, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(196, 750, tls.af(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    localLayoutParams.height = tls.i(80, 1334, tls.ae(this.mContext));
    localLayoutParams.topMargin = tls.i(1224, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(30, 750, tls.af(this.mContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.cK.getLayoutParams();
    localLayoutParams.height = tls.i(129, 1334, tls.ae(this.mContext));
    localLayoutParams.topMargin = tls.i(1199, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(5, 750, tls.af(this.mContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    tkw.d("GdtMvElementsController", "inti585Vpositions() urlBtnLp2.topMargin = " + localLayoutParams.topMargin + ", urlBtnLp2.height = " + localLayoutParams.height);
    ((RelativeLayout.LayoutParams)this.qY.getLayoutParams()).height = tls.i(315, 1334, tls.ae(this.mContext));
  }
  
  private void bDm()
  {
    av(400, false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oV.getLayoutParams();
    localLayoutParams.width = tls.i(140, 750, tls.af(this.mContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = tls.i(580, 750, tls.af(this.mContext));
    localLayoutParams.leftMargin = tls.i(30, 1334, tls.ae(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.Bl.getLayoutParams();
    localLayoutParams.topMargin = tls.i(589, 750, tls.af(this.mContext));
    localLayoutParams.leftMargin = tls.i(196, 1334, tls.ae(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.pP.getLayoutParams();
    localLayoutParams.topMargin = tls.i(637, 750, tls.af(this.mContext));
    localLayoutParams.leftMargin = tls.i(196, 1334, tls.ae(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.fF.getLayoutParams();
    localLayoutParams.topMargin = tls.i(685, 750, tls.af(this.mContext));
    localLayoutParams.leftMargin = tls.i(196, 1334, tls.ae(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    localLayoutParams.height = tls.i(80, 1334, tls.ae(this.mContext));
    localLayoutParams.topMargin = tls.i(611, 750, tls.af(this.mContext));
    localLayoutParams.leftMargin = tls.i(1034, 1334, tls.ae(this.mContext));
    localLayoutParams.rightMargin = tls.i(30, 1334, tls.ae(this.mContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.cK.getLayoutParams();
    localLayoutParams.height = tls.i(129, 1334, tls.ae(this.mContext));
    localLayoutParams.topMargin = tls.i(586, 750, tls.af(this.mContext));
    localLayoutParams.leftMargin = tls.i(1009, 1334, tls.ae(this.mContext));
    localLayoutParams.rightMargin = tls.i(5, 1334, tls.ae(this.mContext));
    ((RelativeLayout.LayoutParams)this.qY.getLayoutParams()).height = tls.i(200, 750, tls.af(this.mContext));
  }
  
  private void bDn()
  {
    if (this.gf != null) {
      ((RelativeLayout.LayoutParams)this.gf.getLayoutParams()).topMargin = tls.i(742, 1334, tls.ae(this.mContext));
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setHeight(tls.i(80, 1334, tls.ae(this.mContext)));
    localLayoutParams.topMargin = tls.i(1224, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(30, 750, tls.af(this.mContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.cK.getLayoutParams();
    this.cK.setHeight(tls.i(129, 1334, tls.ae(this.mContext)));
    localLayoutParams.topMargin = tls.i(1199, 1334, tls.ae(this.mContext));
    localLayoutParams.leftMargin = tls.i(5, 750, tls.af(this.mContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
  }
  
  private void bDp()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_Tir.b();
    Activity localActivity = this.jdField_b_of_type_Tje.a().getActivity();
    if (localActivity != null)
    {
      tkw.i("GdtMvElementsController", "doHandleClick");
      GdtHandler.a(a(localAdInfo, localGdtMotiveVideoPageData, localActivity));
    }
  }
  
  private void bindData()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    if (this.oV != null)
    {
      if (TextUtils.isEmpty(localGdtMotiveVideoPageData.bannerLogo)) {
        break label111;
      }
      this.oV.setImageDrawable(a(localGdtMotiveVideoPageData.bannerLogo));
      if (this.oW != null) {
        this.oW.setImageDrawable(a(localGdtMotiveVideoPageData.bannerLogo));
      }
    }
    for (;;)
    {
      if (this.Bl != null)
      {
        this.Bl.setText(localGdtMotiveVideoPageData.bannerImgName);
        if (this.Bn != null) {
          this.Bn.setText(localGdtMotiveVideoPageData.bannerImgName);
        }
      }
      us(oo());
      bDo();
      return;
      label111:
      this.oV.setImageResource(2130846397);
      if (this.oW != null) {
        this.oW.setImageResource(2130846397);
      }
    }
  }
  
  private static Context c(Context paramContext)
  {
    if ((paramContext == null) || ((paramContext instanceof Activity)) || (!(paramContext instanceof ContextThemeWrapper))) {
      return paramContext;
    }
    return c(((ContextThemeWrapper)paramContext).getBaseContext());
  }
  
  private void eN(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_Tir.a();
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      localObject2 = new Rect();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getGlobalVisibleRect((Rect)localObject2);
      if ((this.qY == null) || (!((Rect)localObject2).contains(paramInt1, paramInt2))) {
        break label63;
      }
      this.qY.setContentDescription(op());
    }
    label63:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.Bl == null);
        this.Bl.getGlobalVisibleRect((Rect)localObject2);
        if ((this.qY != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
        {
          this.qY.setContentDescription(((GdtMotiveVideoPageData)localObject1).bannerImgName);
          return;
        }
      } while (this.pP == null);
      this.pP.getGlobalVisibleRect((Rect)localObject2);
    } while ((this.qY == null) || (!((Rect)localObject2).contains(paramInt1, paramInt2)));
    Object localObject2 = this.qY;
    if (TextUtils.isEmpty(this.aJu)) {}
    for (localObject1 = ((GdtMotiveVideoPageData)localObject1).bannerBaseInfoText;; localObject1 = this.aJu)
    {
      ((View)localObject2).setContentDescription((CharSequence)localObject1);
      return;
    }
  }
  
  private void initData()
  {
    int i = this.jdField_a_of_type_Tir.b().exp_info.video_volume.get();
    tkw.d("GdtMvElementsController", "[initData] videoVolume = " + i);
    tje localtje = this.jdField_b_of_type_Tje;
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localtje.mIsMute = bool;
      return;
    }
  }
  
  private String oo()
  {
    Object localObject = this.jdField_a_of_type_Tir.a();
    TextView localTextView;
    if (this.pP != null)
    {
      localObject = ((GdtMotiveVideoPageData)localObject).bannerBaseInfoText;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = ((String)localObject).length();
        if (i > 16)
        {
          this.aJu = ((String)localObject).substring(0, 16);
          this.aJv = ((String)localObject).substring(16, i);
        }
      }
      localTextView = this.pP;
      if (!TextUtils.isEmpty(this.aJu)) {
        break label85;
      }
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return this.aJv;
      label85:
      localObject = this.aJu;
    }
  }
  
  private String op()
  {
    String str2 = acfp.m(2131706903);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    Object localObject = this.jdField_a_of_type_Tir.b();
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (!((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get().isEmpty())
      {
        str2 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get(0)).txt.get();
        localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).app_info.app_package_name.get();
        tkw.i("GdtMvElementsController", "getContentStrByStyle pushName " + str2);
        if (TextUtils.isEmpty(str2)) {
          break label165;
        }
        str1 = str2;
        if (Of())
        {
          str1 = str2;
          if (jzk.C(this.mContext, (String)localObject))
          {
            if (!localGdtMotiveVideoPageData.isStyleC()) {
              break label158;
            }
            str1 = acfp.m(2131706898);
          }
        }
      }
    }
    return str1;
    label158:
    return acfp.m(2131706899);
    label165:
    if (Of())
    {
      if (jzk.C(this.mContext, (String)localObject)) {
        return acfp.m(2131706900);
      }
      return acfp.m(2131706902);
    }
    return acfp.m(2131706904);
  }
  
  private void us(String paramString)
  {
    double d1 = 10.0D;
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    if (this.Bm != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        tkw.d("GdtMvElementsController", "updateScoreAndStar " + paramString);
        if (this.fE != null) {
          this.fE.setVisibility(8);
        }
        this.Bm.setText(paramString);
        this.Bm.setTextSize(14.0F);
        this.Bm.setTextColor(this.mContext.getResources().getColor(2131165687));
        float f = 0.0F;
        if (this.pP.getText() != null) {
          f = this.pP.getPaint().measureText(this.pP.getText().toString());
        }
        tkw.d("GdtMvElementsController", "updateScoreAndStar " + this.pP.getWidth() + " mw " + f);
        int i = Math.max((int)f, this.pP.getWidth());
        this.Bm.setWidth(i);
      }
    }
    else {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(500);
    if (localGdtMotiveVideoPageData.appScore < 7.0D) {
      if (Double.compare(localGdtMotiveVideoPageData.appScore, 0.0D) == 0) {
        if (Of())
        {
          paramString = "精品推荐 ";
          localStringBuilder.append(paramString);
          label264:
          if (this.fE != null) {
            this.fE.setVisibility(8);
          }
          label280:
          if (localGdtMotiveVideoPageData.downloadNum >= 100000L) {
            break label451;
          }
          if (0L != localGdtMotiveVideoPageData.downloadNum) {
            break label439;
          }
          if (!Of()) {
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
      this.Bm.setText(localStringBuilder.toString());
      return;
      paramString = "精品内容 ";
      break;
      localStringBuilder.append("精品推荐 ");
      break label264;
      if (this.fE == null) {
        break label280;
      }
      this.fE.setVisibility(0);
      a(localGdtMotiveVideoPageData.appScore, this.fE);
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
        if (!Of()) {
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
  
  public GdtHandler.Params a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = paramGdtMotiveVideoPageData.processId;
    localParams.activity = new WeakReference(paramActivity);
    if (paramAdInfo != null) {
      localParams.ad = new GdtAd(paramAdInfo);
    }
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.mContext);
    }
    localParams.reportForClick = true;
    localParams.aOV = true;
    localParams.appReceiver = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    localParams.n = null;
    localParams.p = GdtCanvasFragment4CmGame.class;
    localParams.extra = new Bundle();
    paramGdtMotiveVideoPageData = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramAdInfo = paramGdtMotiveVideoPageData;
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtMvElementsController", 1, "getClickParam refId is empty");
      paramAdInfo = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if (!TextUtils.isEmpty(paramAdInfo)) {
      localParams.extra.putString("big_brother_ref_source_key", paramAdInfo);
    }
    return localParams;
  }
  
  public void bDi()
  {
    Object localObject = this.jdField_a_of_type_Tir.a();
    this.qR = this.mRootView.findViewById(2131362257);
    this.oV = ((ImageView)this.mRootView.findViewById(2131362129));
    this.oW = ((ImageView)this.mRootView.findViewById(2131362131));
    this.Bl = ((TextView)this.mRootView.findViewById(2131362148));
    this.Bn = ((TextView)this.mRootView.findViewById(2131362150));
    this.pP = ((TextView)this.mRootView.findViewById(2131362068));
    this.Bo = ((TextView)this.mRootView.findViewById(2131362071));
    this.Bm = ((TextView)this.mRootView.findViewById(2131362140));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight = ((GdtMvButtonHighLight)this.mRootView.findViewById(2131362156));
    this.c = ((GdtMvAppBtnView)this.mRootView.findViewById(2131362161));
    this.d = ((GdtMvAppBtnView)this.mRootView.findViewById(2131362160));
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setOnClickListener(this);
      this.jdField_a_of_type_Tii.ek(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight);
    }
    if (this.c != null)
    {
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_Tii.ek(this.c);
    }
    if (this.d != null)
    {
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_Tii.ek(this.d);
    }
    this.cK = ((Button)this.mRootView.findViewById(2131362157));
    if (this.cK != null) {
      this.cK.setVisibility(4);
    }
    this.fE = ((LinearLayout)this.mRootView.findViewById(2131362142));
    this.gg = ((RelativeLayout)this.mRootView.findViewById(2131381712));
    this.qY = this.mRootView.findViewById(2131367921);
    if (this.qY != null)
    {
      this.jdField_a_of_type_Tii.ek(this.qY);
      this.qY.setOnClickListener(this);
      this.qY.setOnHoverListener(this);
    }
    this.qZ = this.mRootView.findViewById(2131367922);
    if (this.qZ != null)
    {
      this.jdField_a_of_type_Tii.ek(this.qZ);
      this.qZ.setOnClickListener(this);
    }
    if ((((GdtMotiveVideoPageData)localObject).vSize != 585) && (((GdtMotiveVideoPageData)localObject).screenOrientation == 1)) {
      this.gf = ((RelativeLayout)this.mRootView.findViewById(2131363630));
    }
    this.fF = ((LinearLayout)this.mRootView.findViewById(2131362127));
    bDk();
    initData();
    bindData();
    localObject = op();
    if (this.d != null) {
      this.d.init((String)localObject);
    }
    if (this.c != null) {
      this.c.init((String)localObject);
    }
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = new GdtMvDownloadBtnManager(this.mContext, this.jdField_a_of_type_Tir.a(), (String)localObject, this.d, this.c);
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.onCreate();
  }
  
  public void bDj()
  {
    tkw.i("GdtMvElementsController", "enableMvBtnUrlStyleDefault");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setBackgroundDrawable(this.mRootView.getResources().getDrawable(2130840594));
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setTextColor(this.mContext.getResources().getColor(2131167654));
    }
  }
  
  public void bDo()
  {
    String str = op();
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null) && (this.cK != null))
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setText(str);
      this.cK.setText(str);
    }
    if (this.d != null) {
      this.d.setText(str);
    }
    if (this.c != null) {
      this.c.setText(str);
    }
  }
  
  public void bDq()
  {
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null) {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.onActivityResume();
    }
  }
  
  public void initStyle()
  {
    Drawable localDrawable = this.mRootView.getResources().getDrawable(2130840600);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setBackgroundDrawable(localDrawable);
    int i = this.mContext.getResources().getColor(2131167507);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setTextColor(i);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_Tir.b();
    long l = this.jdField_b_of_type_Tje.eg();
    String str2 = "";
    String str1;
    switch (i)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str1)) && (localAdInfo != null)) {
        localAdInfo.report_info.click_url.set(str1);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      tkw.d("GdtMvElementsController", "[click ad btn] " + localAdInfo);
      Activity localActivity = this.jdField_b_of_type_Tje.a().getActivity();
      str1 = str2;
      if (localAdInfo != null)
      {
        str1 = str2;
        if (localActivity != null)
        {
          str1 = localAdInfo.report_info.click_url.get();
          str2 = this.jdField_a_of_type_Tii.a(str1, l, this.jdField_b_of_type_Tje.Og(), this.jdField_b_of_type_Tje.Oh());
          localAdInfo.report_info.click_url.set(str2);
          GdtHandler.a(a(localAdInfo, localGdtMotiveVideoPageData, localActivity));
          continue;
          tkw.d("GdtMvElementsController", "[click ad download btn] ");
          str1 = str2;
          if (localAdInfo != null)
          {
            str1 = localAdInfo.report_info.click_url.get();
            str2 = this.jdField_a_of_type_Tii.a(str1, l, this.jdField_b_of_type_Tje.Og(), this.jdField_b_of_type_Tje.Oh());
            localAdInfo.report_info.click_url.set(str2);
            if ((localAdInfo.exp_info.reward_video_download_type.get() == 1) && (localAdInfo.product_type.get() == 12) && (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null))
            {
              str2 = localAdInfo.app_info.app_package_name.get();
              if (jzk.C(this.mContext, str2)) {
                bDp();
              } else {
                this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.click();
              }
            }
            else
            {
              bDp();
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(this.mContext);
    }
    if (this.oV != null)
    {
      this.oV.clearAnimation();
      this.oV = null;
    }
    if (this.Bl != null)
    {
      this.Bl.clearAnimation();
      this.Bl = null;
    }
    if (this.pP != null)
    {
      this.pP.clearAnimation();
      this.pP = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.onDestroy();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight = null;
    }
    if (this.gg != null)
    {
      this.gg.clearAnimation();
      this.gg = null;
    }
    if (this.gf != null)
    {
      this.gf.clearAnimation();
      this.gf = null;
    }
    if (this.fF != null)
    {
      this.fF.clearAnimation();
      this.fF = null;
    }
    if (this.jdField_a_of_type_Tiz != null)
    {
      this.jdField_a_of_type_Tiz.onDestroy();
      this.jdField_a_of_type_Tiz = null;
    }
    if (this.jdField_a_of_type_Tiy != null)
    {
      this.jdField_a_of_type_Tiy.onDestroy();
      this.jdField_a_of_type_Tiy = null;
    }
    if (this.jdField_a_of_type_Tix != null)
    {
      this.jdField_a_of_type_Tix.onDestroy();
      this.jdField_a_of_type_Tix = null;
    }
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null)
    {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.onDestroy();
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = null;
    }
    if (this.jdField_a_of_type_Tii != null) {
      this.jdField_a_of_type_Tii.onDestroy();
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
      tkw.e("GdtMvElementsController", "onHover " + paramMotionEvent.getAction());
      eN((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    }
  }
  
  public void onResume()
  {
    tkw.d("GdtMvElementsController", "onResume: ");
    bDo();
    bDq();
  }
  
  public void zv(int paramInt)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    tkw.i("GdtMvElementsController", "adjustViewsPosition " + paramInt + " style " + localGdtMotiveVideoPageData.style);
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.onDestroy();
    }
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        if (this.jdField_a_of_type_Tiz == null)
        {
          this.jdField_a_of_type_Tiz = new tiz(this.mContext);
          this.jdField_a_of_type_Tiz.a(this.qR, this.gg, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.oV, this.Bl, this.pP, this.fF, this.qY);
        }
        this.jdField_a_of_type_Tiz.zu(paramInt);
      }
      while (this.gf == null) {
        return;
      }
      if (this.jdField_a_of_type_Tiy == null)
      {
        this.jdField_a_of_type_Tiy = new tiy(this.mContext);
        this.jdField_a_of_type_Tiy.a(this.gf, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.gg, this.qY);
      }
      this.jdField_a_of_type_Tiy.zu(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Tix == null)
    {
      this.jdField_a_of_type_Tix = new tix(this.mContext);
      this.jdField_a_of_type_Tix.a(this.qR, this.gg, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.oV, this.Bl, this.pP, this.fF, this.qY);
    }
    this.jdField_a_of_type_Tix.zu(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjc
 * JD-Core Version:    0.7.0.1
 */