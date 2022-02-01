package com.tencent.mobileqq.profile.view;

import SummaryCardTaf.summaryCardWzryInfo;
import acbn;
import albb;
import alcn;
import alcs;
import aldw;
import aldw.a;
import aldw.b;
import aldx;
import alhl;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqep;
import aurf;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jqc;

public class VipProfileWZRYView
  extends ProfileHeaderView
{
  public static final String bWo = acbn.bnh + File.separator + "wzryTemplate";
  public ImageView CJ;
  public TextView Xx;
  public HeartLayout a;
  public ShimmerLinearLayout a;
  public ProfileNameView b;
  public VoteView b;
  int dtP;
  public HorizontalScrollView g;
  public AvatarLayout g;
  public ImageView gm;
  private LayoutInflater inflater;
  View mContentView;
  public View nq;
  public ImageView qa;
  private float yE;
  public ImageView yu;
  
  public VipProfileWZRYView(BaseActivity paramBaseActivity, alcn paramalcn)
    throws ProfileTemplateException
  {
    super(paramBaseActivity, paramalcn);
    k(paramalcn);
    e(paramalcn);
  }
  
  int a(TextView paramTextView, int paramInt, String paramString, String[] paramArrayOfString)
  {
    int m = 0;
    TextPaint localTextPaint = new TextPaint(paramTextView.getPaint());
    int k = m;
    float f2;
    if (!TextUtils.isEmpty(paramString))
    {
      k = m;
      if (paramArrayOfString != null)
      {
        k = m;
        if (paramArrayOfString.length > 0)
        {
          paramTextView = paramString;
          if (paramString.endsWith("[num]")) {
            paramTextView = paramString + "\r\n";
          }
          int i = paramTextView.split("\\[num\\]").length - 1;
          if (i > paramArrayOfString.length) {
            i = paramArrayOfString.length;
          }
          int j;
          for (;;)
          {
            k = m;
            if (i <= 0) {
              break label293;
            }
            paramString = "";
            j = 0;
            k = 0;
            while (k < i)
            {
              j += paramArrayOfString[k].length();
              paramString = paramString + paramArrayOfString[k];
              k += 1;
            }
          }
          k = m;
          if (j > 0)
          {
            paramTextView = paramTextView.replace("[num]", "");
            i = 0;
            while (i < j - 1)
            {
              paramTextView = paramTextView + " ";
              i += 1;
            }
            f2 = paramInt - localTextPaint.measureText(paramTextView);
          }
        }
      }
    }
    for (float f1 = f2;; f1 -= 1.0F)
    {
      k = m;
      if (f1 > 0.0F)
      {
        localTextPaint.setTextSize(f1);
        if (localTextPaint.measureText(paramString) >= f2) {
          continue;
        }
        if (f1 > paramInt / 2) {
          k = paramInt / 2;
        }
      }
      else
      {
        label293:
        return k;
      }
      return (int)f1;
    }
  }
  
  public SpannableStringBuilder a(String paramString, String[] paramArrayOfString, int paramInt, float paramFloat, ColorStateList paramColorStateList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (TextUtils.isEmpty(paramString)) {
      return localSpannableStringBuilder;
    }
    if (paramString.contains("[num]"))
    {
      String str;
      int i;
      label69:
      int k;
      int j;
      if (paramString.equals("[num]"))
      {
        str = paramString + " ";
        paramString = str.split("\\[num\\]");
        i = 0;
        if (i >= paramString.length) {
          break label328;
        }
        str = paramString[i];
        if ((i != 0) && (!"\r\n".equals(str))) {
          localSpannableStringBuilder.append(" ");
        }
        if (!"\r\n".equals(str)) {
          localSpannableStringBuilder.append(str);
        }
        if (i < paramString.length - 1)
        {
          k = localSpannableStringBuilder.length();
          if ((paramArrayOfString == null) || (i >= paramArrayOfString.length)) {
            break label296;
          }
          j = paramArrayOfString[i].length();
          localSpannableStringBuilder.append(paramArrayOfString[i]);
          j += k;
        }
      }
      for (;;)
      {
        if (alcs.m != null) {
          localSpannableStringBuilder.setSpan(new CustomTypefaceSpan("", alcs.m), k, j, 17);
        }
        localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), k, j, 17);
        localSpannableStringBuilder.setSpan(new a(paramInt, -2.0F), k, j, 17);
        i += 1;
        break label69;
        str = paramString;
        if (!paramString.endsWith("[num]")) {
          break;
        }
        str = paramString + "\r\n";
        break;
        label296:
        j = "[num]".length();
        localSpannableStringBuilder.append("[num]");
        j += k;
      }
    }
    else
    {
      localSpannableStringBuilder.append(paramString);
    }
    label328:
    return localSpannableStringBuilder;
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    super.i(paramalcn);
    super.j(paramalcn);
    super.f(paramalcn);
    super.g(paramalcn);
    super.c(paramalcn, false);
    u(paramalcn);
  }
  
  void dFT()
  {
    this.i.postDelayed(new VipProfileWZRYView.2(this), 1000L);
  }
  
  public void e(alcn paramalcn)
  {
    this.inflater = LayoutInflater.from(getContext());
    this.mContentView = this.inflater.inflate(2131562240, this, true);
    this.gm = ((ImageView)this.mContentView.findViewById(2131382377));
    alcs.a(this.gm, "apngDrawable", paramalcn.b, "wzryLogo");
    ApngImage.playByTag(7);
    this.CJ = ((ImageView)this.mContentView.findViewById(2131382378));
    alcs.a(this.CJ, "background", paramalcn.b, "wzryLogoBg");
    this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.mContentView.findViewById(2131382383));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131382368));
    this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.mContentView.findViewById(2131382372));
    this.qa = ((ImageView)this.mContentView.findViewById(2131382370));
    this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.mContentView.findViewById(2131382374));
    this.Xx = ((TextView)this.mContentView.findViewById(2131382376));
    this.nq = this.mContentView.findViewById(2131382371);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout = ((ShimmerLinearLayout)this.mContentView.findViewById(2131382366));
    this.yu = ((ImageView)this.mContentView.findViewById(2131382363));
    this.jdField_g_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.mContentView.findViewById(2131382367));
    alcs.a(this.jdField_g_of_type_AndroidWidgetHorizontalScrollView, "background", paramalcn.b, "wzryGameInfoBackground");
    this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    albb localalbb = new albb(1, null);
    this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localalbb);
    this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramalcn.mOnClickListener);
    if (paramalcn.e.pa == 0)
    {
      localObject = getContext().getString(2131692201);
      this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout.c(0, this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363324), false);
      this.mt.put("map_key_face", this.jdField_g_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      super.a(paramalcn.e);
      this.qa.setVisibility(4);
      this.qa.setOnClickListener(paramalcn.mOnClickListener);
      this.qa.setTag(localalbb);
      this.mt.put("map_key_avatar_pendant", this.qa);
      super.c(paramalcn, true);
      this.yE = this.jG;
      int i = getResources().getDimensionPixelSize(2131297318);
      int j = aqep.e(getResources());
      localObject = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)this.jG - aqep.v(this.mActivity, 160) - i - j);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject).height += ImmersiveUtils.getStatusBarHeight(getContext());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject).height);
      }
      this.dtP = ((RelativeLayout.LayoutParams)localObject).height;
      this.nq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.nq.setFocusable(true);
      this.nq.setFocusableInTouchMode(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.mt.put("map_key_profile_nick_name", this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.j(paramalcn);
      this.mt.put("map_key_sex_age_area", this.Xx);
      super.f(paramalcn);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.mt.put("map_key_like", this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramalcn);
      u(paramalcn);
      super.e(paramalcn);
      super.l(paramalcn);
      dFT();
      if (!this.app.getCurrentAccountUin().equals(paramalcn.e.uin)) {
        break label798;
      }
    }
    label798:
    for (Object localObject = "PV_owner";; localObject = "PV_visitor")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", (String)localObject, "0", 1, 0, 0, jqc.hS(), String.valueOf(paramalcn.d.lCurrentBgId), String.valueOf(paramalcn.d.lCurrentStyleId));
      return;
      localObject = getContext().getString(2131692200);
      break;
    }
  }
  
  public void k(alcn paramalcn)
    throws ProfileTemplateException
  {}
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = (int)this.jG;
    if (this.yE != this.jG)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.jG - this.yE)));
      this.nq.setLayoutParams(paramConfiguration);
      this.dtP = ((int)(this.dtP + (this.jG - this.yE)));
      this.yE = this.jG;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i(TAG, 1, "VipProfileWZRYView.onDestroy");
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.dFQ();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(7);
  }
  
  public void u(alcn paramalcn)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.dFQ();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.removeAllViews();
    Object localObject1 = paramalcn.d.getWzryHonorInfo();
    Object localObject2 = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
    if (((List)localObject1).isEmpty())
    {
      this.jdField_g_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).height = (this.dtP - aqep.v(this.mActivity, 67));
      return;
    }
    this.jdField_g_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject2).height = (this.dtP - aqep.v(this.mActivity, 132));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, aqcx.dip2px(getContext(), 5.0F), 0);
    aldw localaldw = aldw.a;
    int j = getResources().getDimensionPixelSize(2131299764);
    int k = getResources().getDimensionPixelSize(2131299766);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131167689);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131167691);
    if (localaldw != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (summaryCardWzryInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 4, "honor data: id=" + ((summaryCardWzryInfo)localObject2).honorId + ", record=" + ((summaryCardWzryInfo)localObject2).strRecord);
        }
        localObject1 = null;
        if (!TextUtils.isEmpty(((summaryCardWzryInfo)localObject2).strRecord)) {
          localObject1 = ((summaryCardWzryInfo)localObject2).strRecord.split("_");
        }
        aldw.a locala = (aldw.a)localaldw.dh.get(((summaryCardWzryInfo)localObject2).honorId);
        if (locala != null)
        {
          View localView = this.inflater.inflate(2131562241, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131382379);
          TextView localTextView1 = (TextView)localView.findViewById(2131382381);
          TextView localTextView2 = (TextView)localView.findViewById(2131382380);
          if (alcs.l != null)
          {
            localTextView1.setTypeface(alcs.l);
            localTextView2.setTypeface(alcs.l);
          }
          int i;
          label407:
          label418:
          String str;
          if (locala.positionType == 2)
          {
            i = 1;
            if (i == 0) {
              break label532;
            }
            localObject2 = locala.format;
            if (i == 0) {
              break label542;
            }
            str = locala.name;
            label429:
            localTextView1.setText(a((String)localObject2, (String[])localObject1, a(localTextView1, k, (String)localObject2, (String[])localObject1), 0.0F, localColorStateList2));
            localTextView2.setText(a(str, (String[])localObject1, j, localTextView2.getTextSize(), localColorStateList1));
            if ((locala.a != null) && (!TextUtils.isEmpty(locala.a.src))) {
              break label552;
            }
            localImageView.setVisibility(8);
            localTextView1.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.addView(localView, localLayoutParams);
            break;
            i = 0;
            break label407;
            label532:
            localObject2 = locala.name;
            break label418;
            label542:
            str = locala.format;
            break label429;
            label552:
            localImageView.setVisibility(0);
            localTextView1.setVisibility(8);
            localObject2 = locala.a.src;
            localObject1 = localObject2;
            if (((String)localObject2).contains("/")) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/"));
            }
            localObject1 = aldx.aE(this.app.getApp()) + (String)localObject1;
            if (paramalcn.b != null) {
              localImageView.setImageDrawable(paramalcn.b.a(this.app, (String)localObject1, true, true));
            }
          }
        }
      }
    }
    if ((paramalcn.e.pa == 0) || (paramalcn.e.uin.equals(this.app.getCurrentAccountUin())))
    {
      this.yu.setVisibility(0);
      alcs.a(this.yu, "background", paramalcn.b, "addIcon");
      this.yu.setOnClickListener(new alhl(this, paramalcn));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.mMaskBitmap == null) {
      alcs.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout, "shimmer_mask", paramalcn.b, "wzryShimmer");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.dFP();
  }
  
  public static class CustomTypefaceSpan
    extends TypefaceSpan
  {
    Typeface mTypeface;
    
    public CustomTypefaceSpan(String paramString, Typeface paramTypeface)
    {
      super();
      this.mTypeface = paramTypeface;
    }
    
    private void a(Paint paramPaint, Typeface paramTypeface)
    {
      Typeface localTypeface = paramPaint.getTypeface();
      if (localTypeface == null) {}
      for (int i = 0;; i = localTypeface.getStyle())
      {
        i &= (paramTypeface.getStyle() ^ 0xFFFFFFFF);
        if ((i & 0x1) != 0) {
          paramPaint.setFakeBoldText(true);
        }
        if ((i & 0x2) != 0) {
          paramPaint.setTextSkewX(-0.25F);
        }
        paramPaint.setTypeface(paramTypeface);
        return;
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      if (this.mTypeface != null)
      {
        a(paramTextPaint, this.mTypeface);
        return;
      }
      super.updateDrawState(paramTextPaint);
    }
    
    public void updateMeasureState(TextPaint paramTextPaint)
    {
      if (this.mTypeface != null)
      {
        a(paramTextPaint, this.mTypeface);
        return;
      }
      super.updateMeasureState(paramTextPaint);
    }
  }
  
  public static class a
    extends ReplacementSpan
  {
    private float fontSize;
    private float offset = -1.0F;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.fontSize = paramFloat1;
      this.offset = paramFloat2;
    }
    
    private TextPaint a(Paint paramPaint)
    {
      paramPaint = new TextPaint(paramPaint);
      paramPaint.setTextSize(this.fontSize);
      return paramPaint;
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
      paramPaint = a(paramPaint);
      Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
      paramInt1 = localFontMetricsInt.top;
      float f = (localFontMetricsInt.bottom + (paramInt1 + paramInt4 + paramInt4)) / 2 - (paramInt5 + paramInt3) / 2;
      if (this.offset != 0.0F) {
        f = this.offset;
      }
      paramCanvas.drawText(paramCharSequence.toString(), paramFloat, paramInt4 - f, paramPaint);
    }
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
      return (int)a(paramPaint).measureText(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileWZRYView
 * JD-Core Version:    0.7.0.1
 */