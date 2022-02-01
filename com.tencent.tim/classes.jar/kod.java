import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class kod
  extends ViewBase
  implements View.OnClickListener
{
  private Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private kod.a jdField_a_of_type_Kod$a;
  private lie jdField_a_of_type_Lie;
  private int aKn;
  private int aKo;
  private int aKp;
  private int aKq;
  private int aKr;
  private int aKs;
  private int aKt;
  private int aKu;
  private int aKv;
  private int aKw;
  private int aKx;
  private boolean agJ;
  private boolean agK;
  private ValueAnimator animator;
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private kod.a jdField_b_of_type_Kod$a;
  private NativeReadInjoyImageView c;
  private NativeReadInjoyImageView d;
  private LinearLayout dw;
  private NativeReadInjoyImageView jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private AdvertisementInfo jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private RelativeLayout eG;
  private RelativeLayout eH;
  private RelativeLayout eI;
  private NativeReadInjoyImageView f;
  private URLImageView h;
  private URLImageView i;
  private boolean isShowing;
  private URLImageView j;
  private URLImageView k;
  private URLImageView l;
  private URLImageView m;
  private Context mContext;
  private View mRootView;
  private URLImageView n;
  private URLImageView o;
  private TextView ok;
  private TextView os;
  private TextView ot;
  private TextView ou;
  private TextView ov;
  private TextView ow;
  
  public kod(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mContext = paramVafContext.getContext();
    initView(this.mContext);
    initConfig();
  }
  
  private void S(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("img_start_position");
    String str = paramJSONObject.optString("img_end_position");
    int i1 = paramJSONObject.optInt("img_start_size", 100);
    int i2 = paramJSONObject.optInt("img_end_size", 100);
    int i3 = paramJSONObject.optInt("img_start_angle", 0);
    int i4 = paramJSONObject.optInt("img_end_angle", 360);
    paramJSONObject = new int[2];
    JSONObject tmp59_58 = paramJSONObject;
    tmp59_58[0] = 0;
    JSONObject tmp63_59 = tmp59_58;
    tmp63_59[1] = 0;
    tmp63_59;
    c(paramJSONObject, (String)localObject);
    int i5 = paramJSONObject[0];
    int i6 = paramJSONObject[1];
    c(paramJSONObject, str);
    int i7 = paramJSONObject[0];
    int i8 = paramJSONObject[1];
    paramJSONObject = new kod.a();
    paramJSONObject.scale = (i1 / 100.0F);
    paramJSONObject.angle = i3;
    paramJSONObject.aKB = wja.dp2px(i5 / 2, this.mContext.getResources());
    paramJSONObject.aKC = wja.dp2px(i6 / 2, this.mContext.getResources());
    localObject = new kod.a();
    ((kod.a)localObject).scale = (i2 / 100.0F);
    ((kod.a)localObject).angle = i4;
    ((kod.a)localObject).aKB = wja.dp2px(i7 / 2, this.mContext.getResources());
    ((kod.a)localObject).aKC = wja.dp2px(i8 / 2, this.mContext.getResources());
    this.jdField_a_of_type_Kod$a = paramJSONObject;
    this.jdField_b_of_type_Kod$a = ((kod.a)localObject);
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if (paramFloat1 < paramFloat2) {
      return;
    }
    paramFloat2 = (paramFloat1 - paramFloat2) * paramFloat3;
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 1.0F) {
      paramFloat1 = 1.0F;
    }
    paramView.setTranslationY((paramFloat1 - 1.0F) * paramInt);
    paramView.setAlpha(paramFloat1);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat, int paramInt)
  {
    float f1 = 1.0F;
    if (paramFloat >= 0.33F)
    {
      paramLayoutParams.height = paramInt;
      return;
    }
    paramFloat = 3.0F * paramFloat;
    if (paramFloat > 1.0F) {
      paramFloat = f1;
    }
    for (;;)
    {
      paramLayoutParams.height = ((int)(paramFloat * paramInt));
      return;
    }
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat2)
  {
    paramLayoutParams.leftMargin = ((int)(paramInt3 * paramFloat1) + paramInt1);
    paramLayoutParams.topMargin = ((int)(paramInt4 * paramFloat1) + paramInt2);
    float f1 = this.jdField_a_of_type_Kod$a.angle - paramInt5 * paramFloat1;
    QLog.d("ANGLE_DEV", 4, "angle = " + f1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setRotation(f1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Kod$a.scale + paramFloat2 * paramFloat1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Kod$a.scale + paramFloat2 * paramFloat1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(paramLayoutParams);
  }
  
  private void aFa()
  {
    this.h.setVisibility(0);
    this.i.setVisibility(0);
    this.j.setVisibility(0);
    this.k.setVisibility(0);
    this.l.setVisibility(0);
    this.m.setVisibility(0);
    this.n.setVisibility(0);
    this.o.setVisibility(0);
  }
  
  private void aFb()
  {
    this.eG.getLayoutParams().height = wja.dp2px(128.0F, this.mContext.getResources());
    this.aKo = wja.dp2px(128.0F, this.mContext.getResources());
    this.ou.setTextColor(Color.parseColor("#40A0FF"));
    int i1 = wja.dp2px(4.0F, this.mContext.getResources());
    this.f.setCorner(i1, i1, i1, i1);
  }
  
  private void aFc()
  {
    this.agJ = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getLayoutParams();
    localLayoutParams.leftMargin = g(this.aKv, this.jdField_a_of_type_Kod$a.aKB, this.aKq);
    localLayoutParams.topMargin = g(this.aKu, this.jdField_a_of_type_Kod$a.aKC, this.aKr);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(localLayoutParams);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setRotation(this.jdField_a_of_type_Kod$a.angle);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Kod$a.scale);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Kod$a.scale);
    this.eH.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.eH.getLayoutParams()).height = 0;
  }
  
  private void c(int[] paramArrayOfInt, String paramString)
  {
    if (paramString.contains(","))
    {
      paramString = paramString.split(",");
      if (paramString.length < 2) {}
    }
    try
    {
      paramArrayOfInt[0] = Integer.parseInt(paramString[0]);
      paramArrayOfInt[1] = Integer.parseInt(paramString[1]);
      return;
    }
    catch (Exception paramArrayOfInt) {}
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 + paramInt2 - paramInt3 / 2;
  }
  
  private void initConfig()
  {
    this.aKp = wja.dp2px(84.0F, this.mContext.getResources());
    this.aKr = wja.dp2px(60.0F, this.mContext.getResources());
    this.aKs = wja.dp2px(60.0F, this.mContext.getResources());
    this.aKq = wja.dp2px(60.0F, this.mContext.getResources());
    this.aKn = wja.dp2px(52.0F, this.mContext.getResources());
    this.aKo = wja.dp2px(135.0F, this.mContext.getResources());
  }
  
  private void initView(Context paramContext)
  {
    this.mRootView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131562910, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131381405));
    this.eG = ((RelativeLayout)this.mRootView.findViewById(2131368918));
    this.dw = ((LinearLayout)this.mRootView.findViewById(2131368917));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369036));
    this.c = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369037));
    this.d = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369038));
    this.ok = ((TextView)this.mRootView.findViewById(2131362079));
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131368087));
    this.eH = ((RelativeLayout)this.mRootView.findViewById(2131368084));
    this.eI = ((RelativeLayout)this.mRootView.findViewById(2131381392));
    this.ok = ((TextView)this.mRootView.findViewById(2131362079));
    this.f = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131368082));
    this.os = ((TextView)this.mRootView.findViewById(2131368085));
    this.ot = ((TextView)this.mRootView.findViewById(2131368091));
    this.ou = ((TextView)this.mRootView.findViewById(2131368083));
    this.ov = ((TextView)this.mRootView.findViewById(2131362148));
    this.ow = ((TextView)this.mRootView.findViewById(2131362145));
    this.h = ((URLImageView)this.mRootView.findViewById(2131370390));
    this.i = ((URLImageView)this.mRootView.findViewById(2131377330));
    this.j = ((URLImageView)this.mRootView.findViewById(2131370354));
    this.k = ((URLImageView)this.mRootView.findViewById(2131377287));
    this.l = ((URLImageView)this.mRootView.findViewById(2131368089));
    this.m = ((URLImageView)this.mRootView.findViewById(2131368093));
    this.n = ((URLImageView)this.mRootView.findViewById(2131368088));
    this.o = ((URLImageView)this.mRootView.findViewById(2131368092));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.ov.setOnClickListener(this);
    this.ow.setOnClickListener(this);
    this.ok.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.os.setOnClickListener(this);
    this.ot.setOnClickListener(this);
    this.ou.setOnClickListener(this);
    this.mRootView.setOnClickListener(new koe(this));
  }
  
  private void my(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Kod$a == null) || (this.jdField_b_of_type_Kod$a == null) || (this.isShowing)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.eH.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getLayoutParams();
    int i1 = localLayoutParams2.leftMargin;
    int i2 = localLayoutParams2.topMargin;
    int i3 = g(this.aKx, this.jdField_b_of_type_Kod$a.aKB, this.aKq);
    int i4 = g(this.aKw, this.jdField_b_of_type_Kod$a.aKC, this.aKr);
    i3 -= i1;
    i4 -= i2;
    int i5 = -this.jdField_b_of_type_Kod$a.angle + this.jdField_a_of_type_Kod$a.angle;
    float f1 = this.jdField_b_of_type_Kod$a.scale - this.jdField_a_of_type_Kod$a.scale;
    if (paramBoolean)
    {
      a(localLayoutParams2, 1.0F, i1, i2, i3, i4, i5, f1);
      a(localLayoutParams1, 1.0F, this.aKp);
      a(this.os, 1.0F, 0.2F, 1.7F, wja.dp2px(34.0F, this.mContext.getResources()));
      a(this.ot, 1.0F, 0.2F, 2.0F, wja.dp2px(34.0F, this.mContext.getResources()));
      a(this.ou, 1.0F, 0.2F, 2.0F, wja.dp2px(34.0F, this.mContext.getResources()));
      return;
    }
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.addUpdateListener(new kof(this, localLayoutParams2, i1, i2, i3, i4, i5, f1, localLayoutParams1));
    this.animator.addListener(new kog(this));
    this.animator.setDuration(412L);
    this.animator.start();
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrandOptimizationView", 2, "loadImage: path is " + paramString);
    }
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label83;
      }
      if (paramDrawable != null) {
        paramNativeReadInjoyImageView.setImagePlaceHolder(paramDrawable);
      }
      paramNativeReadInjoyImageView.setImageSrc(paramString);
    }
    label83:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("BrandOptimizationView", 2, "loadImage: cant find in offline dir, try to load from resources");
    }
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      QLog.d("BrandOptimizationView", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
  
  public void aFd()
  {
    if (this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate) {
      return;
    }
    my(false);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate = true;
  }
  
  protected void bindData()
  {
    if ((this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList == null) || (this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.size() < 3)) {}
    for (;;)
    {
      return;
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = wja.dp2px(28.0F, this.mRootView.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = wja.dp2px(28.0F, this.mRootView.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "brand_user_icon";
      Object localObject3 = URLDrawable.getDrawable(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject3).setTag(aqbn.d(((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight, wja.dp2px(25.0F, this.mRootView.getResources())));
      ((URLDrawable)localObject3).setDecodeHandler(aqbn.a);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable((Drawable)localObject3);
      this.ov.setText(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSubscribeName);
      this.ow.setText(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleSubscriptText);
      this.ok.setText(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.get(0), this.GRAY_PLACEHOLDER);
      a(this.c, (String)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.get(1), this.GRAY_PLACEHOLDER);
      a(this.d, (String)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.get(2), this.GRAY_PLACEHOLDER);
      localObject1 = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BrandOptimizationView", 2, "brand extJson is empty ");
        return;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((JSONObject)localObject1).optString("goods_small_img");
        String str1 = ((JSONObject)localObject1).optString("goods_bottom_img");
        String str2 = ((JSONObject)localObject1).optString("goods_price");
        String str3 = ((JSONObject)localObject1).optString("goods_title");
        a(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)localObject3, this.GRAY_PLACEHOLDER);
        a(this.f, str1, this.GRAY_PLACEHOLDER);
        S((JSONObject)localObject1);
        this.ou.setText(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt);
        this.os.setText(str3);
        this.ot.setText(str2);
        this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate = false;
        if (!this.agJ) {
          continue;
        }
        aFc();
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BrandOptimizationView", 2, localJSONException.getMessage());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.mRootView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mRootView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mRootView;
  }
  
  public void mx(boolean paramBoolean)
  {
    this.agK = paramBoolean;
    if (paramBoolean)
    {
      aFa();
      aFb();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
    }
    for (;;)
    {
      kks localkks = new kks();
      if (i1 == 8) {
        localkks.afZ = true;
      }
      knd.a(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, i1, null);
      ods.a((Activity)this.mContext, this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Lie.b(), this.jdField_a_of_type_Lie.nh(), false, knc.b(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), localkks);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i1 = 2;
      continue;
      i1 = 3;
      continue;
      i1 = 1;
      continue;
      i1 = 4;
      continue;
      i1 = 5;
      continue;
      i1 = 8;
      continue;
      i1 = 2001;
      continue;
      i1 = 2002;
      continue;
      i1 = 2003;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRootView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mRootView.measure(paramInt1, paramInt2);
    if ((!this.agJ) && (!this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate) && (this.jdField_a_of_type_Kod$a != null) && (this.jdField_b_of_type_Kod$a != null))
    {
      this.aKt = this.ok.getMeasuredHeight();
      this.aKu = (this.aKn + this.aKt + wja.dp2px(8.0F, this.mContext.getResources()));
      this.aKv = 0;
      this.aKw = (this.aKn + this.aKt + this.aKo + wja.dp2px(12.0F, this.mContext.getResources()));
      this.aKx = wja.dp2px(12.0F, this.mContext.getResources());
      aFc();
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    bindData();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate = false;
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        try
        {
          if ((paramObject instanceof AdvertisementInfo))
          {
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
          QLog.d("BrandOptimizationView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
  
  public void setModel(lie paramlie)
  {
    this.jdField_a_of_type_Lie = paramlie;
  }
  
  public static class a
  {
    public int aKB;
    public int aKC;
    public int angle;
    public float scale = 1.0F;
  }
  
  public static class b
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kod(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kod
 * JD-Core Version:    0.7.0.1
 */