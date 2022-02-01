package com.tencent.mobileqq.nearby.interestTag;

import acfp;
import ajrs;
import ajrw;
import ajui;
import ajuj;
import ajuk;
import ajul;
import ajum;
import ajun;
import ajuo;
import ajup;
import ajuq;
import ajur;
import ajus;
import ajut;
import ajuv;
import ajuy.a;
import akby;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aomc;
import aqbn;
import aqho;
import arib;
import aurd;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class ChooseInterestTagActivity
  extends IphoneTitleBarActivity
{
  private static final String[] fC = { "#77C6F4", "#FFA366", "#333333", "#5DC2A2" };
  private List<InterestTagInfo> DD = new ArrayList();
  private List<InterestTagInfo> DE = new ArrayList();
  private View EQ;
  private View ER;
  private View ES;
  private View ET;
  private TextView Va;
  private TextView Vb;
  private TextView Vc;
  private TextView Vd;
  private TextView Ve;
  private ajrs jdField_a_of_type_Ajrs;
  private ajuv jdField_a_of_type_Ajuv;
  private ajuy.a jdField_a_of_type_Ajuy$a = new ajuk(this);
  private arib jdField_a_of_type_Arib;
  private InterestTagItemView.a jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$a = new ajum(this);
  private MonitorSizeChangeHSV.a jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV$a = new ajut(this);
  private MonitorSizeChangeHSV jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV;
  private ajrw b = new ajuq(this);
  private String bSw = "";
  private EditText bk;
  private AbsListView.OnScrollListener c = new ajur(this);
  private boolean cqm;
  private boolean cqn;
  private boolean cqo;
  private boolean cqp;
  private boolean cqq;
  private boolean cqr;
  private int dlb;
  private int dlc;
  private int dld;
  private int dle;
  private int dlf;
  private View.OnKeyListener e = new ajus(this);
  private View.OnClickListener ft = new ajuj(this);
  private LinearLayout jr;
  private LinearLayout js;
  private RelativeLayout kX;
  private RelativeLayout kY;
  private LayoutInflater mLayoutInflater;
  private View.OnClickListener mOnClickListener = new ajui(this);
  private int mTagType = -1;
  private TextWatcher mTextWatcher = new ajul(this);
  private Handler mUIHandler = new ajup(this);
  private ListView q;
  private float sG;
  private ArrayList<InterestTagInfo> ye = new ArrayList();
  
  private void Mq(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (this.cqo)
    {
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label48;
      }
    }
    label48:
    for (String str = "add_tag";; str = "del_tag")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", str, 0, 0, "", "", "", String.valueOf(this.mTagType));
      return;
    }
  }
  
  @TargetApi(11)
  private void Rs(int paramInt)
  {
    Object localObject;
    if ((this.dld == 1) && (paramInt == 0))
    {
      if (this.jr.getChildCount() > 0)
      {
        localObject = this.jr.getChildAt(this.jr.getChildCount() - 1);
        if (Build.VERSION.SDK_INT >= 11) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
      this.dld = 0;
    }
    do
    {
      return;
      if ((this.dld == 0) && (paramInt == 1))
      {
        if (this.jr.getChildCount() > 0)
        {
          localObject = this.jr.getChildAt(this.jr.getChildCount() - 1);
          if (Build.VERSION.SDK_INT >= 11) {
            ((View)localObject).setAlpha(0.5F);
          }
        }
        this.dld = 1;
        return;
      }
    } while (paramInt != 2);
    if ((this.jr.getChildCount() > 0) && (!this.ye.isEmpty()))
    {
      localObject = (InterestTagInfo)this.ye.remove(this.ye.size() - 1);
      b((InterestTagInfo)localObject);
      c((InterestTagInfo)localObject);
    }
    this.dld = 0;
  }
  
  private void U(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_Arib != null) && (!isFinishing())) {
      this.jdField_a_of_type_Arib.aa(paramInt1, paramString, paramInt2);
    }
  }
  
  private View a(InterestTagInfo paramInterestTagInfo, boolean paramBoolean)
  {
    Object localObject4;
    TextView localTextView;
    Object localObject1;
    Object localObject3;
    int i;
    if ((this.cqo) || (this.mTagType == 3) || (this.mTagType == 2) || (this.mTagType == 1) || (this.mTagType == 4))
    {
      localObject4 = this.mLayoutInflater.inflate(2131561489, null);
      localTextView = (TextView)((View)localObject4).findViewById(2131381048);
      if (localTextView != null)
      {
        if (paramInterestTagInfo.tagName != null) {
          break label305;
        }
        localObject1 = "";
        localObject3 = localObject1;
        if (((String)localObject1).length() > 6) {
          localObject3 = ((String)localObject1).substring(0, 6) + "...";
        }
        localTextView.setSingleLine(true);
        localTextView.setText((CharSequence)localObject3);
        if (!this.cqo) {
          break label317;
        }
        i = akby.iq(this.mTagType);
        if (i == -1) {
          break label809;
        }
        i = Color.parseColor(akby.fE[i]);
      }
    }
    for (;;)
    {
      label166:
      localTextView.setTextColor(i);
      if (this.cqo)
      {
        i = akby.iq(this.mTagType);
        if (i == -1) {
          break label804;
        }
        i = Color.parseColor(akby.fD[i]);
      }
      for (;;)
      {
        label201:
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(i);
        ((GradientDrawable)localObject1).setCornerRadius(getResources().getDimensionPixelSize(2131299325));
        ((View)localObject4).setBackgroundDrawable((Drawable)localObject1);
        ((View)localObject4).setTag(paramInterestTagInfo);
        paramInterestTagInfo = new LinearLayout.LayoutParams(-2, (int)aqho.convertDpToPixel(this, 17.0F));
        if (paramBoolean) {}
        label305:
        label317:
        int j;
        for (i = 10;; i = 5)
        {
          for (;;)
          {
            for (;;)
            {
              paramInterestTagInfo.leftMargin = ((int)(i * this.sG + 0.5D));
              ((View)localObject4).setLayoutParams(paramInterestTagInfo);
              ((View)localObject4).setOnClickListener(this.ft);
              return localObject4;
              localObject1 = paramInterestTagInfo.tagName.trim();
              break;
              try
              {
                i = Color.parseColor(paramInterestTagInfo.tagTextColor);
              }
              catch (Exception localException1)
              {
                if (QLog.isDevelopLevel()) {
                  localException1.printStackTrace();
                }
                i = -1;
              }
            }
            break label166;
            j = Color.parseColor(fC[(this.mTagType - 1)]);
            try
            {
              i = Color.parseColor(paramInterestTagInfo.tagBgColor);
            }
            catch (Exception localException2)
            {
              i = j;
            }
          }
          if (!QLog.isDevelopLevel()) {
            break label201;
          }
          QLog.d("choose_interest_tag", 4, "parse tagBgClor: " + localException2.getMessage());
          i = j;
          break label201;
        }
        localObject4 = new URLImageView(this);
        Object localObject2 = new LinearLayout.LayoutParams((int)(this.sG * 40.0F + 0.5D), this.dlf);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)(this.sG * 10.0F + 0.5D));
        ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject4).setTag(paramInterestTagInfo);
        ((ImageView)localObject4).setOnClickListener(this.ft);
        ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.mTagType == 7)
        {
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(getResources().getColor(2131166111));
          ((GradientDrawable)localObject2).setCornerRadius(this.sG * 10.0F);
          ((GradientDrawable)localObject2).setShape(0);
          i = getResources().getDimensionPixelSize(2131297787);
          ((GradientDrawable)localObject2).setSize(i, i);
          if (TextUtils.isEmpty(paramInterestTagInfo.tagIconUrl)) {
            break label799;
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            if (this.mTagType == 5)
            {
              i = getResources().getDimensionPixelSize(2131297789);
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
              j = getResources().getDimensionPixelSize(2131297788);
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
              paramInterestTagInfo = URLDrawable.getDrawable(aomc.l(paramInterestTagInfo.tagIconUrl), (URLDrawable.URLDrawableOptions)localObject3);
            }
          }
          catch (Exception localException3)
          {
            paramInterestTagInfo = null;
          }
          try
          {
            if (this.mTagType == 7)
            {
              paramInterestTagInfo.setTag(aqbn.d(j, i, (int)(this.sG * 10.0F)));
              paramInterestTagInfo.setDecodeHandler(aqbn.d);
            }
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
            if (paramInterestTagInfo != null) {
              break label788;
            }
            ((ImageView)localObject4).setImageDrawable((Drawable)localObject2);
            return localObject4;
          }
          catch (Exception localException4)
          {
            break label767;
          }
          localObject2 = getResources().getDrawable(2131166111);
          break;
          i = getResources().getDimensionPixelSize(2131297787);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          continue;
          label767:
          if (QLog.isColorLevel()) {
            QLog.i("choose_interest_tag", 2, localException3.toString());
          }
          continue;
          label788:
          localObject2 = paramInterestTagInfo;
          continue;
          label799:
          paramInterestTagInfo = null;
        }
        label804:
        i = 0;
      }
      label809:
      i = -1;
    }
  }
  
  private void a(InterestTagInfo paramInterestTagInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(0);
      if (this.cqm)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.dlf;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.kY.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.dlf;
        int i = (int)(this.sG * 10.0F + 0.5D);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        this.kY.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    boolean bool;
    if (this.ye.size() == 1)
    {
      bool = true;
      paramInterestTagInfo = a(paramInterestTagInfo, bool);
      this.jr.addView(paramInterestTagInfo);
      localObject = new AlphaAnimation(0.1F, 1.0F);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setDuration(70L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new ajun(this));
      paramInterestTagInfo.startAnimation(localAnimationSet);
      if (!this.ye.isEmpty()) {
        break label297;
      }
      this.rightViewText.setEnabled(false);
      if (!this.cqm) {
        this.bk.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130843173), null, null, null);
      }
    }
    for (;;)
    {
      Mq(true);
      return;
      bool = false;
      break;
      label297:
      this.rightViewText.setEnabled(true);
      if (!this.cqm) {
        this.bk.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
  }
  
  private boolean a(InterestTagInfo paramInterestTagInfo)
  {
    return this.ye.contains(paramInterestTagInfo);
  }
  
  private void b(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {
      return;
    }
    int j = this.jr.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.jr.getChildAt(i);
      if (((InterestTagInfo)localView.getTag()).equals(paramInterestTagInfo))
      {
        paramInterestTagInfo = new AlphaAnimation(1.0F, 0.1F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(paramInterestTagInfo);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setDuration(70L);
        localAnimationSet.setInterpolator(new AccelerateInterpolator());
        localAnimationSet.setAnimationListener(new ajuo(this, localView));
        localView.startAnimation(localAnimationSet);
      }
    }
    else
    {
      if (!this.ye.isEmpty()) {
        break label205;
      }
      this.rightViewText.setEnabled(false);
      if (!this.cqm) {
        this.bk.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130843173), null, null, null);
      }
    }
    for (;;)
    {
      Mq(false);
      return;
      i += 1;
      break;
      label205:
      this.rightViewText.setEnabled(true);
      if (!this.cqm) {
        this.bk.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
  }
  
  private void c(InterestTagInfo paramInterestTagInfo)
  {
    int j = this.q.getFirstVisiblePosition();
    int k = this.q.getLastVisiblePosition();
    int i = j;
    while (i <= k)
    {
      View localView = this.q.getChildAt(i - j);
      if ((localView != null) && ((localView instanceof InterestTagItemView)) && (paramInterestTagInfo.equals(localView.getTag()))) {
        ((InterestTagItemView)localView).dzw();
      }
      i += 1;
    }
  }
  
  private void ck(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.js == null) {
      return;
    }
    if ((!paramBoolean2) && (this.cqr)) {
      this.q.removeFooterView(this.js);
    }
    TextView localTextView;
    ProgressBar localProgressBar;
    for (this.cqr = false;; this.cqr = true)
    {
      do
      {
        localTextView = (TextView)this.js.findViewById(2131371975);
        localProgressBar = (ProgressBar)this.js.findViewById(2131377037);
        ImageView localImageView = (ImageView)this.js.findViewById(2131370781);
        if (localImageView.getVisibility() != 8) {
          localImageView.setVisibility(8);
        }
        if (!paramBoolean1) {
          break;
        }
        localTextView.setTextColor(getResources().getColor(2131167379));
        localTextView.setText(acfp.m(2131703825));
        localProgressBar.setVisibility(0);
        this.js.setOnClickListener(this.mOnClickListener);
        return;
      } while ((!paramBoolean2) || (this.cqr));
      this.q.addFooterView(this.js);
    }
    if (paramBoolean2)
    {
      localTextView.setTextColor(getResources().getColor(2131167442));
      localTextView.setText(acfp.m(2131703811));
      localProgressBar.setVisibility(8);
      this.js.setOnClickListener(this.mOnClickListener);
      return;
    }
    localTextView.setTextColor(getResources().getColor(2131167379));
    localTextView.setText(acfp.m(2131703833));
    localProgressBar.setVisibility(8);
    this.js.setOnClickListener(null);
  }
  
  private void dzu()
  {
    if ((this.ye == null) || (this.ye.isEmpty()))
    {
      this.jr.removeAllViews();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(8);
      }
      this.rightViewText.setEnabled(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(0);
      if (this.cqm)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams();
        localLayoutParams.height = this.dlf;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setLayoutParams(localLayoutParams);
        localLayoutParams = (RelativeLayout.LayoutParams)this.kY.getLayoutParams();
        localLayoutParams.height = this.dlf;
        int i = (int)(this.sG * 10.0F + 0.5D);
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.kY.setLayoutParams(localLayoutParams);
      }
    }
    lB(this.ye);
  }
  
  private void dzv()
  {
    if (this.jdField_a_of_type_Arib != null) {
      this.jdField_a_of_type_Arib.dismiss();
    }
  }
  
  private void initData()
  {
    int j = 0;
    Intent localIntent = getIntent();
    int i;
    boolean bool;
    label106:
    Object localObject;
    if (getIntent() == null)
    {
      i = -1;
      this.mTagType = i;
      if ((this.mTagType < 1) || (this.mTagType > 7))
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.i("choose_interest_tag", 2, "tagType is wrong. " + this.mTagType);
        }
      }
      if (localIntent != null) {
        this.cqo = localIntent.getBooleanExtra("is_from_nearby", false);
      }
      if (getIntent() != null) {
        break label452;
      }
      bool = false;
      this.cqn = bool;
      if (this.cqn)
      {
        this.kX.setVisibility(0);
        localObject = "";
        if (this.mTagType != 3) {
          break label467;
        }
        localObject = acfp.m(2131703836);
        label146:
        this.Vd.setText((CharSequence)localObject);
      }
      if ((this.mTagType != 2) && (this.mTagType != 4)) {
        break label583;
      }
      bool = true;
      label173:
      this.cqm = bool;
      if (!this.cqm) {
        break label588;
      }
      i = 10;
      label188:
      this.dle = i;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams()).rightMargin = ((int)(this.sG * this.dle + 0.5D));
      if (this.mTagType != 5) {
        break label594;
      }
      this.dlf = ((int)(this.sG * 50.0F + 0.5D));
      label248:
      if (!this.cqm) {
        break label668;
      }
      this.kY.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.kY.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 1;
      ((RelativeLayout.LayoutParams)localObject).width = 1;
      i = j;
      if (this.cqn) {
        i = (int)(this.sG * 7.0F + 0.5D);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
    }
    for (;;)
    {
      this.jr.getLayoutParams().height = this.dlf;
      this.jr.setGravity(16);
      if (localIntent != null)
      {
        localObject = localIntent.getParcelableArrayListExtra("choosed_interest_tags");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          Collections.reverse((List)localObject);
          this.ye.addAll((Collection)localObject);
        }
        dzu();
      }
      this.jdField_a_of_type_Arib = new arib(this);
      this.jdField_a_of_type_Ajrs = ((ajrs)this.app.getBusinessHandler(60));
      ThreadManager.getFileThreadHandler().post(new ChooseInterestTagActivity.1(this));
      return;
      i = getIntent().getIntExtra("interest_tag_type", -1);
      break;
      label452:
      bool = getIntent().getBooleanExtra("is_from_judge", false);
      break label106;
      label467:
      if (this.mTagType == 5)
      {
        localObject = acfp.m(2131703814);
        break label146;
      }
      if (this.mTagType == 6)
      {
        localObject = acfp.m(2131703800);
        break label146;
      }
      if (this.mTagType == 2)
      {
        localObject = acfp.m(2131703819);
        break label146;
      }
      if (this.mTagType == 7)
      {
        localObject = acfp.m(2131703817);
        break label146;
      }
      if (this.mTagType == 4)
      {
        localObject = acfp.m(2131703795);
        break label146;
      }
      if (this.mTagType != 1) {
        break label146;
      }
      localObject = acfp.m(2131703799);
      break label146;
      label583:
      bool = false;
      break label173;
      label588:
      i = 100;
      break label188;
      label594:
      if ((this.mTagType == 1) || (this.mTagType == 2) || (this.mTagType == 3) || (this.mTagType == 4))
      {
        this.dlf = ((int)(this.sG * 26.0F + 0.5D));
        break label248;
      }
      this.dlf = ((int)(this.sG * 40.0F + 0.5D));
      break label248;
      label668:
      localObject = (RelativeLayout.LayoutParams)this.kY.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = this.dlf;
      i = (int)(this.sG * 10.0F + 0.5D);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    }
  }
  
  private void initTitle()
  {
    String str2 = "";
    String str1 = "";
    String str3 = acfp.m(2131703796);
    if (this.mTagType == 3)
    {
      str2 = acfp.m(2131703806);
      str1 = acfp.m(2131703834);
      this.Ve.setVisibility(8);
      this.ET.setVisibility(8);
      this.bk.setHint(str3);
      if (!this.cqn) {
        break label399;
      }
    }
    for (;;)
    {
      setTitle(str1);
      if (!this.cqn) {
        break label404;
      }
      setLeftViewName(2131721058);
      this.leftView.setOnClickListener(this.mOnClickListener);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(acfp.m(2131703818));
      this.rightViewText.setOnClickListener(this.mOnClickListener);
      return;
      if (this.mTagType == 5)
      {
        str2 = acfp.m(2131703797);
        str1 = acfp.m(2131703805);
        this.Ve.setVisibility(0);
        this.ET.setVisibility(0);
        break;
      }
      if (this.mTagType == 6)
      {
        str2 = acfp.m(2131703829);
        str1 = acfp.m(2131703823);
        this.Ve.setVisibility(0);
        this.ET.setVisibility(0);
        break;
      }
      if (this.mTagType == 2)
      {
        str2 = acfp.m(2131703802);
        str1 = acfp.m(2131703826);
        this.Ve.setVisibility(8);
        this.ET.setVisibility(8);
        break;
      }
      if (this.mTagType == 7)
      {
        str2 = acfp.m(2131703801);
        str1 = acfp.m(2131703827);
        this.Ve.setVisibility(0);
        this.ET.setVisibility(0);
        break;
      }
      if (this.mTagType == 4)
      {
        str1 = acfp.m(2131703835);
        str2 = acfp.m(2131703807);
        this.Ve.setVisibility(8);
        this.ET.setVisibility(8);
        break;
      }
      if (this.mTagType != 1) {
        break;
      }
      str2 = acfp.m(2131703804);
      str1 = acfp.m(2131703813);
      this.Ve.setVisibility(0);
      this.ET.setVisibility(0);
      str3 = acfp.m(2131703798);
      break;
      label399:
      str1 = str2;
    }
    label404:
    setLeftViewName(2131690700);
    this.leftView.setOnClickListener(this.mOnClickListener);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(8);
  }
  
  @TargetApi(9)
  private void initViews()
  {
    this.mLayoutInflater = LayoutInflater.from(this);
    this.bk = ((EditText)findViewById(2131366532));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV = ((MonitorSizeChangeHSV)findViewById(2131368682));
    this.jr = ((LinearLayout)findViewById(2131370711));
    this.q = ((ListView)findViewById(2131370937));
    this.kY = ((RelativeLayout)findViewById(2131377435));
    this.EQ = findViewById(2131377434);
    this.ER = findViewById(2131377478);
    this.Vb = ((TextView)findViewById(2131381142));
    this.Vc = ((TextView)findViewById(2131381151));
    this.kX = ((RelativeLayout)findViewById(2131377493));
    this.Vd = ((TextView)findViewById(2131381162));
    this.ES = findViewById(2131381451);
    this.Ve = ((TextView)findViewById(2131381150));
    this.ET = findViewById(2131381462);
    this.Va = ((TextView)findViewById(2131381152));
    this.EQ.setVisibility(0);
    int i = getResources().getColor(2131166619);
    this.ES.setBackgroundColor(i);
    this.ET.setBackgroundColor(i);
    this.js = ((LinearLayout)LayoutInflater.from(this).inflate(2131559672, null));
    ck(false, true);
    if (!this.cqm)
    {
      this.bk.addTextChangedListener(this.mTextWatcher);
      this.bk.setOnKeyListener(this.e);
      this.bk.setOnClickListener(this.mOnClickListener);
      if (AppSetting.enableTalkBack) {
        this.bk.setContentDescription(acfp.m(2131703828));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setOnSizeChangeCallback(this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV$a);
    this.q.setOnScrollListener(this.c);
    this.bk.clearFocus();
    if (Build.VERSION.SDK_INT >= 9) {
      this.q.setOverScrollMode(2);
    }
    this.sG = getResources().getDisplayMetrics().density;
  }
  
  private void lB(List<InterestTagInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        int i = 0;
        if (i < paramList.size())
        {
          Object localObject = (InterestTagInfo)paramList.get(i);
          if (i == 0) {}
          for (boolean bool = true;; bool = false)
          {
            localObject = a((InterestTagInfo)localObject, bool);
            int j = this.jr.getChildCount();
            this.jr.addView((View)localObject, j);
            i += 1;
            break;
          }
        }
        this.mUIHandler.postDelayed(new ChooseInterestTagActivity.2(this), 100L);
        if (!this.ye.isEmpty()) {
          break;
        }
        this.rightViewText.setEnabled(false);
      } while (this.cqm);
      this.bk.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130843173), null, null, null);
      return;
      this.rightViewText.setEnabled(true);
    } while (this.cqm);
    this.bk.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void toast(String paramString)
  {
    QQToast.a(this, paramString, 0).show(getTitleBarHeight());
  }
  
  public void doOnBackPressed()
  {
    if (!this.cqn)
    {
      Intent localIntent2 = getIntent();
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      Collections.reverse(this.ye);
      localIntent1.putParcelableArrayListExtra("choosed_interest_tags", this.ye);
      localIntent1.putExtra("interest_tag_type", this.mTagType);
      setResult(-1, localIntent1);
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561436);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130845959));
    initViews();
    addObserver(this.b);
    initData();
    initTitle();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.b);
    if (this.jdField_a_of_type_Arib != null) {
      this.jdField_a_of_type_Arib.dismiss();
    }
  }
  
  public void finish()
  {
    aurd.hide(this.bk);
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity
 * JD-Core Version:    0.7.0.1
 */