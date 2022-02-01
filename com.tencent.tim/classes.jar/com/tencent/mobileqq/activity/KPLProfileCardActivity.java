package com.tencent.mobileqq.activity;

import accn;
import acff;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqbn;
import aqgz;
import aqiw;
import auvv;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.KPLScoreView;
import com.tencent.mobileqq.widget.ProfileCardFavorItemView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.os.MqqHandler;
import vem;
import ven;
import wja;

public class KPLProfileCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  TextView DQ;
  TextView DR;
  public KplCard a;
  AvatarLayout a;
  public boolean aXK = false;
  URLImageView ah;
  KplRoleInfo.WZRYUIinfo jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
  PullToZoomHeaderListView jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView;
  accn cardObserver = new ven(this);
  Button dj;
  ImmersiveTitleBar2 h;
  LayoutInflater inflater;
  View kE;
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    View localView = null;
    Object localObject = localView;
    if (paramViewGroup != null)
    {
      localObject = localView;
      if (paramInt > 0)
      {
        localObject = localView;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = (ViewGroup)this.inflater.inflate(2131561570, null);
          localView = ((ViewGroup)localObject).findViewById(2131368698);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131369154);
          localView.setBackgroundResource(paramInt);
          localTextView.setText(paramString.trim());
          paramViewGroup.addView((View)localObject);
        }
      }
    }
    return localObject;
  }
  
  private void a(KplCard paramKplCard)
  {
    b(paramKplCard);
    c(paramKplCard);
  }
  
  private void a(HorizontalScrollLayout paramHorizontalScrollLayout, KplCard paramKplCard)
  {
    paramHorizontalScrollLayout.removeAllViews();
    int k = paramKplCard.roleList.size();
    int i = (int)aqgz.hK();
    Object localObject1;
    int m;
    int j;
    label76:
    Object localObject3;
    if (k <= 4)
    {
      i /= 4;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramHorizontalScrollLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = null;
      m = i - wja.dp2px(20.0F, getResources());
      j = 0;
      if (j >= k) {
        return;
      }
      localObject3 = (KplRoleInfo)paramKplCard.roleList.get(j);
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      j += 1;
      break label76;
      i = i * 146 / 640;
      break;
      label126:
      View localView = this.inflater.inflate(2131561561, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131368724);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getResources().getDrawable(2130846698);
      }
      Object localObject4 = ((KplRoleInfo)localObject3).roleUrl;
      localObject1 = ((KplRoleInfo)localObject3).roleName;
      localObject3 = ((KplRoleInfo)localObject3).roleScore;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mRequestHeight = m;
        localURLDrawableOptions.mRequestWidth = m;
        localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
        ((URLDrawable)localObject4).setTag(aqbn.d(m, m, (int)(16.0F * aqgz.getDesity())));
        ((URLDrawable)localObject4).setDecodeHandler(aqbn.a);
        localImageView.setImageDrawable((Drawable)localObject4);
        ((TextView)localView.findViewById(2131379870)).setText((CharSequence)localObject1);
        ((TextView)localView.findViewById(2131365744)).setText((CharSequence)localObject3);
        localView.setContentDescription((String)localObject1 + (String)localObject3);
        paramHorizontalScrollLayout.addView(localView, new LinearLayout.LayoutParams(i, -2));
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void b(KplCard paramKplCard)
  {
    if (paramKplCard == null) {
      return;
    }
    try
    {
      localDrawable = getResources().getDrawable(2130846645);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          Drawable localDrawable;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          int i = getResources().getDimensionPixelSize(2131297973);
          int j = getResources().getDisplayMetrics().widthPixels;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = j;
          paramKplCard = URLDrawable.getDrawable(paramKplCard.bgUrl, localURLDrawableOptions);
          paramKplCard.setTag(aqbn.d(j, i, (int)(10.0F * aqgz.getDesity())));
          this.ah.setImageDrawable(paramKplCard);
          this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, 200, true, true, true, false, 3);
          return;
          localOutOfMemoryError = localOutOfMemoryError;
          localOutOfMemoryError.printStackTrace();
          ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131165381));
        }
      }
      catch (Exception paramKplCard)
      {
        for (;;)
        {
          paramKplCard.printStackTrace();
        }
      }
    }
  }
  
  private void bGM()
  {
    if (!aqiw.isNetworkAvailable(this)) {}
    do
    {
      QQToast.a(this, getResources().getString(2131696349), 0).show(getTitleBarHeight());
      do
      {
        return;
      } while ((this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataKplCard == null));
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg)) {
        this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg = KplRoleInfo.getKplVerifyMsg(this.app);
      }
    } while (((acff)this.app.getManager(51)).isFriend(this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin));
    Object localObject = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqDataKplCard.qqNick, this.jdField_a_of_type_ComTencentMobileqqDataKplCard.gameNick);
    int i;
    if (this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId == 0)
    {
      i = 3045;
      if (this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.subSourceId != 0) {
        break label238;
      }
    }
    label238:
    for (int j = 23;; j = this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.subSourceId)
    {
      localObject = AddFriendLogicActivity.a(this, 1, this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, null, i, j, (String)localObject, null, null, getString(2131721053), null);
      ((Intent)localObject).putExtra("param_wzry_data", this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo);
      startActivityForResult((Intent)localObject, 228);
      anot.a(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      return;
      i = this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId;
      break;
    }
  }
  
  public static Intent c(Context paramContext)
  {
    return new Intent(paramContext, KPLProfileCardActivity.class);
  }
  
  private void c(KplCard paramKplCard)
  {
    if (paramKplCard == null) {
      return;
    }
    Object localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName(paramKplCard.qqNick, paramKplCard.gameNick);
    this.DQ.setText((CharSequence)localObject1);
    this.dj.setEnabled(true);
    localObject1 = this.kE.findViewById(2131361885);
    ((View)localObject1).setVisibility(0);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131361884);
    ((LinearLayout)localObject2).removeAllViews();
    localObject1 = "";
    if (paramKplCard.gender == 0) {
      localObject1 = acfp.m(2131707594);
    }
    for (;;)
    {
      a((ViewGroup)localObject2, 2130846680, (String)localObject1 + paramKplCard.gameLevel);
      a((ViewGroup)localObject2, 2130846224, paramKplCard.commonInfo);
      localObject1 = (ProfileCardFavorShowView)this.kE.findViewById(2131370102);
      ((ProfileCardFavorShowView)localObject1).setVisibility(0);
      ((ProfileCardFavorShowView)localObject1).setTitle(acfp.m(2131707595));
      ((ProfileCardFavorShowView)localObject1).removeAllViews();
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(acfp.m(2131707598));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      ((ProfileCardFavorItemView)localObject2).He.setVisibility(8);
      Object localObject3 = new KPLScoreView(this);
      ((KPLScoreView)localObject3).setKplValue(paramKplCard.mvpLevel + acfp.m(2131707600), paramKplCard.superLevel + acfp.m(2131707599), paramKplCard.score + "%", paramKplCard.round + acfp.m(2131707600));
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).FK.setImageDrawable(new ColorDrawable(getResources().getColor(2131167654)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      if ((paramKplCard.roleList == null) || (paramKplCard.roleList.size() <= 0)) {
        break;
      }
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(acfp.m(2131707601));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      localObject3 = this.inflater.inflate(2131561580, null);
      HorizontalScrollLayout localHorizontalScrollLayout = (HorizontalScrollLayout)((View)localObject3).findViewById(2131377763);
      localHorizontalScrollLayout.setOnTouchListener(new vem(this));
      a(localHorizontalScrollLayout, paramKplCard);
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).FK.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131167654)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      return;
      if (paramKplCard.gender == 1) {
        localObject1 = acfp.m(2131707596);
      }
    }
  }
  
  private void ie()
  {
    acff localacff = (acff)this.app.getManager(51);
    CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
    if (this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataKplCard = localacff.a(this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
      if (aqiw.isNetworkAvailable(this)) {
        break label85;
      }
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.2(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.3(this));
      return;
      label85:
      localCardHandler.Dv(this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
    }
  }
  
  private void initContentView()
  {
    setContentView(2131561388);
    this.inflater = ((LayoutInflater)getSystemService("layout_inflater"));
    this.kE = View.inflate(this, 2131561387, null);
    this.aXK = false;
    Object localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130846670);
    }
    this.ah = ((URLImageView)this.kE.findViewById(2131369188));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.kE.findViewById(2131369165));
    this.DQ = ((TextView)this.kE.findViewById(2131369183));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.c(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363324), false);
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)findViewById(2131365101));
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.ah);
    this.DR = ((TextView)findViewById(2131369579));
    this.DR.setText(getString(2131691039));
    this.DR.setBackgroundResource(2130850013);
    this.DR.setTextColor(getResources().getColor(2131166970));
    this.DR.setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131364045);
    View localView = View.inflate(this, 2131561551, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.dj = ((Button)localView.findViewById(2131381048));
    this.dj.setText(2131692151);
    this.dj.setTag("addFriend");
    this.dj.setOnClickListener(this);
    ((LinearLayout)localObject).addView(localView, localLayoutParams);
    this.dj.setEnabled(false);
    this.h = ((ImmersiveTitleBar2)findViewById(2131379866));
    this.h.setVisibility(4);
    this.jdField_b_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new auvv(this.kE));
  }
  
  private void initData()
  {
    ThreadManager.postImmediately(new KPLProfileCardActivity.1(this), null, true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)getIntent().getSerializableExtra("param_wzry_data"));
    initContentView();
    initData();
    this.app.addObserver(this.cardObserver);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.cardObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if ("addFriend".equals(paramView.getTag()))
      {
        bGM();
        anot.a(this.app, "dc00898", "", "", "0X8008436", "0X8008436", 0, 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */