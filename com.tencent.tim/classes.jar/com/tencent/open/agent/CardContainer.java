package com.tencent.open.agent;

import acfp;
import afei;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import arqf;
import arqg;
import arqh;
import arqi;
import arqj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainer
  extends RelativeLayout
{
  protected ImageView Gf;
  protected ImageView Gg;
  private ImageView Gh;
  public AuthorityAccountView a;
  protected TextView acI;
  protected TextView acJ;
  protected TextView acK;
  protected TextView acL;
  protected TextView acM;
  protected FixedBounceScrollView b;
  public boolean dcP;
  private boolean dcQ;
  public AnyScaleTypeImageView f;
  private LinearLayout lG;
  protected Context mContext;
  protected RelativeLayout mD;
  public Drawable mDrawable;
  protected RelativeLayout mE;
  protected RelativeLayout mF;
  protected RelativeLayout mG;
  protected Handler mHandler = new arqf(this, Looper.getMainLooper());
  protected LayoutInflater mInflater;
  protected int mMode = -1;
  protected TextView mNickView;
  protected final int mScreenHeight;
  protected final int mScreenWidth;
  protected URLDrawableDownListener.Adapter mUrlAdapter = new arqg(this);
  protected List<a> qf;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.mScreenWidth = paramAttributeSet.widthPixels;
    this.mScreenHeight = paramAttributeSet.heightPixels;
    this.qf = new ArrayList();
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void c(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CardContainer", 2, "performAnim height =" + paramInt1 + ", topMargin =" + paramInt2);
    }
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 0, paramInt2 });
    localValueAnimator1.addUpdateListener(new arqh(this, paramImageView));
    localValueAnimator1.addListener(new arqi(this, paramImageView));
    localValueAnimator2.addUpdateListener(new arqj(this));
    localValueAnimator1.setDuration(300L);
    localValueAnimator2.setDuration(300L);
    paramImageView = new AnimatorSet();
    paramImageView.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    paramImageView.setDuration(300L);
    paramImageView.start();
  }
  
  private void eld()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CardContainer", 2, "displayCoverContainer ");
    }
    if (!this.dcQ)
    {
      this.dcQ = true;
      this.Gh.setVisibility(0);
      if ((this.mContext instanceof BaseActivity)) {
        ImmersiveUtils.setStatusTextColor(false, ((BaseActivity)this.mContext).getWindow());
      }
      if (!(this.mContext instanceof AuthorityActivity)) {
        break label110;
      }
      ((AuthorityActivity)this.mContext).ekU();
    }
    for (;;)
    {
      int i = (int)(this.mScreenWidth / 1.307692F);
      int j = this.lG.getHeight();
      c(this.f, i, i - j);
      return;
      label110:
      if ((this.mContext instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)this.mContext).ekU();
      }
    }
  }
  
  private URLDrawable f(String paramString)
  {
    localObject3 = null;
    try
    {
      Object localObject1 = new afei(0, this.mScreenWidth, 100);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      try
      {
        localObject1 = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString = (String)localObject1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("CardContainer", 1, new Object[] { "genGameUrlImg exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
          paramString = localObject3;
        }
      }
      if ((paramString != null) && (paramString.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardContainer", 2, "-->-->genGameUrlImg: failed");
        }
        paramString.restartDownload();
      }
      if (((paramString == null) || (paramString.getStatus() != 1)) && (this.f != null))
      {
        this.f.setURLDrawableDownListener(this.mUrlAdapter);
        this.mHandler.post(new CardContainer.7(this, paramString));
      }
      return paramString;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CardContainer", 2, "-->create empty drawable oom.", localOutOfMemoryError);
        }
        localObject2 = null;
      }
    }
  }
  
  protected String Dc()
  {
    String str = AuthorityActivity.cBq;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    int j = str.length();
    if (j >= 8) {}
    StringBuilder localStringBuilder;
    for (Object localObject = str.substring(j - 8);; localObject = str)
    {
      localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
      int i = 2;
      j = 0;
      while (j < 8)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(((String)localObject).substring(j, i));
        j += 2;
        i += 2;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < 8 - j)
      {
        ((StringBuilder)localObject).append("0");
        i += 1;
      }
    }
    localStringBuilder.append("/").append(str).append("_").append("android").append("_").append("ad").append("_").append("0.jpg");
    localStringBuilder.replace(0, 4, "gamead");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public void F(String paramString, Bitmap paramBitmap)
  {
    QLog.i("showAppInfo", 1, "showAppInfo appName = " + paramString, new RuntimeException("ShowAppInfoStack"));
    setVisibility(0);
    if ((!TextUtils.isEmpty(paramString)) && (getTag() != null)) {
      ((TextView)findViewById(2131362342)).setText(acfp.m(2131703499) + paramString + acfp.m(2131703498));
    }
    if (this.a != null) {
      this.a.setAppInfo(paramString, paramBitmap);
    }
  }
  
  public void WR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "showAdsInfo adsTxt = " + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      j = 0;
      i = 0;
      if (j >= paramString2.length()) {
        break label276;
      }
      if (String.valueOf(paramString2.charAt(j)).getBytes().length <= 1) {
        break label258;
      }
      i += 2;
      label45:
      if (i <= 10) {
        break label267;
      }
    }
    label258:
    label267:
    label276:
    for (int i = 1;; i = 0)
    {
      String str2 = paramString2.substring(0, j);
      String str1 = str2;
      if (i != 0) {
        str1 = str2 + "...";
      }
      QLog.i("CardContainer", 1, "-->showUserInfo() set nickname ellipsis=" + str1 + ",nick=" + paramString2);
      this.mNickView.setText(str1);
      this.acI.setText(str1);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = String.format(super.getContext().getString(2131690080), new Object[] { paramString1 });
        this.acJ.setText(paramString2);
        this.acK.setText(paramString2);
        if (this.acL.getVisibility() == 0) {
          this.acL.setVisibility(8);
        }
      }
      if (paramBitmap != null)
      {
        this.Gf.setImageBitmap(paramBitmap);
        this.Gg.setImageBitmap(paramBitmap);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (this.a != null)) {
        this.a.WK(paramString1);
      }
      return;
      i += 1;
      break label45;
      j += 1;
      break;
    }
  }
  
  public void ak(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "showAdsInfo adsPic = " + paramBitmap);
    }
  }
  
  public boolean b(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    int i = 0;
    this.qf.clear();
    Object localObject = paramGetAuthApiListResponse.authorized_form_list.get();
    paramGetAuthApiListResponse = new StringBuilder(((List)localObject).size() * 128);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)((Iterator)localObject).next();
      if (localAuthItem.is_new.get() != 0)
      {
        a locala = new a();
        locala.api = localAuthItem.api_list.get();
        locala.flag = localAuthItem.default_flag.get();
        locala.id = localAuthItem.id.get();
        if (localAuthItem.is_new.get() == 0) {}
        for (bool = false;; bool = true)
        {
          locala.isNew = bool;
          locala.title = localAuthItem.title.get();
          if (QLog.isColorLevel()) {
            paramGetAuthApiListResponse.append("--> Permission p, api: ").append(locala.api).append(" | flag: ").append(locala.flag).append(" | id: ").append(locala.id).append(" | isNew: ").append(locala.isNew).append(" | title: ").append(locala.title).append("\n");
          }
          this.qf.add(locala);
          break;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, paramGetAuthApiListResponse.toString());
    }
    if (this.qf.size() == 0) {}
    for (boolean bool = true; bool; bool = false)
    {
      paramGetAuthApiListResponse = this.f;
      xU(1);
      this.acL.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("CardContainer", 2, "--> has been authority.");
      }
      setAdImageByURL(paramGetAuthApiListResponse, Dc());
      return bool;
    }
    xU(0);
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> has not been authority.");
    }
    paramGetAuthApiListResponse = "";
    if (i < this.qf.size())
    {
      localObject = (a)this.qf.get(i);
      if (getTag() != null) {}
      for (paramGetAuthApiListResponse = paramGetAuthApiListResponse + "· 获得你与QQ通讯录绑定的电话号码";; paramGetAuthApiListResponse = paramGetAuthApiListResponse + "· " + ((a)localObject).title)
      {
        paramGetAuthApiListResponse = paramGetAuthApiListResponse + "\n";
        i += 1;
        break;
      }
    }
    this.acM.setText(paramGetAuthApiListResponse);
    return bool;
  }
  
  public void ekI()
  {
    this.a.ekI();
  }
  
  public void ekJ()
  {
    if (this.a != null) {
      this.a.ekJ();
    }
  }
  
  public List<a> gN()
  {
    return this.qf;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mD = ((RelativeLayout)super.findViewById(2131362348));
    this.mE = ((RelativeLayout)super.findViewById(2131362349));
    this.Gf = ((ImageView)super.findViewById(2131362340));
    this.mNickView = ((TextView)super.findViewById(2131362344));
    this.acJ = ((TextView)super.findViewById(2131362346));
    this.Gg = ((ImageView)super.findViewById(2131362341));
    this.acI = ((TextView)super.findViewById(2131362345));
    this.acK = ((TextView)super.findViewById(2131362347));
    this.acL = ((TextView)super.findViewById(2131362343));
    this.acL.setVisibility(8);
    this.acM = ((TextView)super.findViewById(2131372664));
    this.a = ((AuthorityAccountView)super.findViewById(2131361948));
    this.mG = ((RelativeLayout)super.findViewById(2131363103));
    this.b = ((FixedBounceScrollView)super.findViewById(2131363114));
    this.b.setMaxHeight(aqcx.dip2px(this.mContext, 102.0F));
    this.b.setNeedDisallowIntercept(true);
    this.mF = ((RelativeLayout)super.findViewById(2131362351));
    this.f = ((AnyScaleTypeImageView)super.findViewById(2131367860));
    this.lG = ((LinearLayout)super.findViewById(2131379854));
    this.Gh = ((ImageView)super.findViewById(2131379855));
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    Object localObject = null;
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.f;
    }
    try
    {
      paramAnyScaleTypeImageView = new afei(0, this.mScreenWidth, 100);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramAnyScaleTypeImageView;
      localURLDrawableOptions.mFailedDrawable = paramAnyScaleTypeImageView;
    }
    catch (OutOfMemoryError paramAnyScaleTypeImageView)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if ((paramAnyScaleTypeImageView != null) && (paramAnyScaleTypeImageView.getStatus() == 2)) {
          paramAnyScaleTypeImageView.restartDownload();
        }
        if ((paramAnyScaleTypeImageView != null) && (paramAnyScaleTypeImageView.getStatus() == 1))
        {
          eld();
          if (QLog.isColorLevel()) {
            QLog.d("CardContainer", 2, "getStatus SUCCESSED: ");
          }
          localAnyScaleTypeImageView.setVisibility(0);
          localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
          return;
          paramAnyScaleTypeImageView = paramAnyScaleTypeImageView;
          if (QLog.isColorLevel()) {
            QLog.e("CardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
          }
          paramAnyScaleTypeImageView = null;
        }
      }
      catch (IllegalArgumentException paramAnyScaleTypeImageView)
      {
        for (;;)
        {
          QLog.e("CardContainer", 1, new Object[] { "setAdImageByURL exception url=", paramString, ",excption=", paramAnyScaleTypeImageView.toString() });
          paramAnyScaleTypeImageView = localObject;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CardContainer", 2, "getStatus OTHERS: ");
          }
          localAnyScaleTypeImageView.setURLDrawableDownListener(this.mUrlAdapter);
        }
      }
    }
  }
  
  public void setAppType(String paramString)
  {
    if (this.a != null) {
      this.a.setAppType(paramString);
    }
  }
  
  public void setChangeAccountListener(AuthorityAccountView.a parama)
  {
    if (this.a != null) {
      this.a.setChangeAccountListener(parama);
    }
  }
  
  public void xU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "switchToMode -->mode: " + paramInt + ", mMode=" + this.mMode);
    }
    ThreadManager.executeOnSubThread(new CardContainer.3(this));
    if (paramInt == this.mMode) {
      return;
    }
    if (paramInt == 0) {
      this.mG.setVisibility(0);
    }
    for (;;)
    {
      this.mMode = paramInt;
      return;
      if (paramInt == 1) {
        this.mG.setVisibility(8);
      }
    }
  }
  
  public static class a
  {
    public String api;
    public int flag;
    public int id;
    public boolean isChecked;
    public boolean isNew;
    public String title;
    
    public String toString()
    {
      return "[flag=" + this.flag + ", title=" + this.title + ", isNew=" + this.isNew + ", api=" + this.api + ", id=" + this.id + ", isChecked=" + this.isChecked + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer
 * JD-Core Version:    0.7.0.1
 */