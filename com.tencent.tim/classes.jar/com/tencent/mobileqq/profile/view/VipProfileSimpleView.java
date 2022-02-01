package com.tencent.mobileqq.profile.view;

import acfp;
import albb;
import alcn;
import alcs;
import alhj;
import alhk;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqep;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class VipProfileSimpleView
  extends ProfileHeaderView
{
  public ImageView CG;
  public ImageView CI;
  public TextView Xl;
  public TextView Xs;
  public TextView Xt;
  public TextView Xw;
  public HeartLayout a;
  public VipPhotoViewForSimple a;
  public ProfileNameView b;
  public VoteView b;
  private boolean bvA;
  public int cVk = -1;
  public LinearLayout fr;
  public AvatarLayout g;
  View mContentView;
  public int mStatusBarHeight = -1;
  public View nq;
  public ImageView qa;
  private long qj;
  private float yE;
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, alcn paramalcn)
    throws ProfileTemplateException
  {
    super(paramBaseActivity, paramalcn);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    k(paramalcn);
    e(paramalcn);
  }
  
  public void SP(int paramInt)
  {
    super.SP(paramInt);
    Object localObject = (View)this.mt.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(8, 2131369249);
      localLayoutParams.bottomMargin = paramInt;
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    super.i(paramalcn);
    super.j(paramalcn);
    s(paramalcn);
    super.g(paramalcn);
    super.c(paramalcn, false);
    t(paramalcn);
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.qj > 1000L) {}
    for (int i = 1; (i == 0) && (!this.bvA); i = 0) {
      return true;
    }
    return super.d(paramView, paramMotionEvent);
  }
  
  public void dFS()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
    localLayoutParams.height = ((int)this.jG - aqep.v(this.mActivity, 129) - aqep.v(this.mActivity, 18) - this.cVk - this.mStatusBarHeight);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.nq.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(9)
  public void e(alcn paramalcn)
  {
    Object localObject1 = getContext();
    this.mContentView = LayoutInflater.from((Context)localObject1).inflate(2131562232, this, true);
    this.g = ((AvatarLayout)this.mContentView.findViewById(2131369165));
    this.g.setVisibility(0);
    this.CG = ((ImageView)this.mContentView.findViewById(2131369166));
    alcs.a(this.CG, "src", paramalcn.b, "commonFaceBackground");
    Object localObject2 = new albb(1, null);
    this.g.setTag(localObject2);
    this.g.setOnClickListener(paramalcn.mOnClickListener);
    if (paramalcn.e.pa == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131692201);; localObject1 = ((Context)localObject1).getString(2131692200))
    {
      this.g.setContentDescription((CharSequence)localObject1);
      this.g.c(0, this.g.findViewById(2131363324), false);
      this.mt.put("map_key_face", this.g);
      this.mt.put("map_key_face_stoke", this.mContentView.findViewById(2131369166));
      super.a(paramalcn.e);
      this.qa = ((ImageView)this.mContentView.findViewById(2131368987));
      this.qa.setVisibility(4);
      this.qa.setOnClickListener(paramalcn.mOnClickListener);
      this.qa.setTag(localObject2);
      this.mt.put("map_key_avatar_pendant", this.qa);
      super.c(paramalcn, true);
      this.yE = this.jG;
      this.cVk = getResources().getDimensionPixelSize(2131297318);
      this.mStatusBarHeight = aqep.e(getResources());
      this.nq = this.mContentView.findViewById(2131369163);
      localObject1 = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jG - aqep.v(this.mActivity, 129) - aqep.v(this.mActivity, 18) - this.cVk - this.mStatusBarHeight);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject1).height += ImmersiveUtils.getStatusBarHeight(getContext());
      }
      if ((this.mActivity != null) && ((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).aWx)) {
        ((RelativeLayout.LayoutParams)localObject1).height = ((int)(((RelativeLayout.LayoutParams)localObject1).height - this.jG / 2.0F));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject1).height);
      }
      this.nq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.nq.setFocusable(true);
      this.nq.setFocusableInTouchMode(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.mContentView.findViewById(2131369183));
      alcs.a(this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramalcn.b, "simpleNickNameColor");
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.mt.put("map_key_profile_nick_name", this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.j(paramalcn);
      this.Xl = ((TextView)this.mContentView.findViewById(2131369177));
      this.Xt = ((TextView)this.mContentView.findViewById(2131369175));
      this.Xs = ((TextView)this.mContentView.findViewById(2131369176));
      alcs.a(this.Xl, "color", paramalcn.b, "simpleAddressColor");
      alcs.a(this.Xt, "color", paramalcn.b, "simpleAddressColor");
      alcs.a(this.Xs, "color", paramalcn.b, "simpleAddressColor");
      alcs.a(this.Xl, "background", paramalcn.b, "simpleAddressBackground");
      alcs.a(this.Xt, "background", paramalcn.b, "simpleAddressBackground");
      alcs.a(this.Xs, "background", paramalcn.b, "simpleAddressBackground");
      s(paramalcn);
      this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.mContentView.findViewById(2131382077));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368498));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.mt.put("map_key_like", this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramalcn);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.mContentView.findViewById(2131375577));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.mActivity, paramalcn);
      this.mt.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      alcs.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, "background", paramalcn.b, "commonMaskBackground");
      this.fr = ((LinearLayout)this.mContentView.findViewById(2131369231));
      this.mt.put("map_key_tips", this.fr);
      this.CI = ((ImageView)this.mContentView.findViewById(2131373638));
      this.Xw = ((TextView)this.mContentView.findViewById(2131373639));
      this.CI.setTag(new albb(73, this.Xw));
      this.CI.setOnClickListener(paramalcn.mOnClickListener);
      super.e(paramalcn);
      if ((this.mActivity == null) || (!(this.mActivity instanceof FriendProfileCardActivity)) || (!((FriendProfileCardActivity)this.mActivity).aWx)) {
        break;
      }
      this.bvA = true;
      l(paramalcn);
      return;
    }
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setFillAfter(true);
    localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
    ((Animation)localObject2).setDuration(500L);
    ((Animation)localObject2).setAnimationListener(new alhj(this, paramalcn));
    ((Animation)localObject1).setAnimationListener(new alhk(this, (Animation)localObject2));
    startAnimation((Animation)localObject1);
    this.qj = System.currentTimeMillis();
  }
  
  public void k(alcn paramalcn)
    throws ProfileTemplateException
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("simpleQQNumColor", "color");
    localHashMap.put("simpleNickNameColor", "color");
    localHashMap.put("simpleAddressColor", "color");
    localHashMap.put("simpleGridAddBackground", "color");
    localHashMap.put("simpleAddressBackground", "drawable");
    localHashMap.put("simpleAddSrc", "drawable");
    localHashMap.put("simpleGridAddSrc", "drawable");
    super.a(paramalcn, localHashMap);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.yE != this.jG)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.jG - this.yE)));
      this.nq.setLayoutParams(paramConfiguration);
      this.yE = this.jG;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alcn != null) {
      super.c(this.jdField_a_of_type_Alcn, false);
    }
    Object localObject = (View)this.mt.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131368498);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public void s(alcn paramalcn)
  {
    int j = -1;
    if (paramalcn.e.pa == 33)
    {
      paramalcn = this.mActivity.getString(2131701525);
      this.Xt.setVisibility(0);
      this.Xl.setVisibility(8);
      this.Xs.setVisibility(8);
      this.Xt.setPadding(0, 10, 0, 0);
      this.Xt.setText(paramalcn);
      this.Xt.setContentDescription(paramalcn);
      return;
    }
    Object localObject = "";
    Card localCard = paramalcn.d;
    ContactCard localContactCard = paramalcn.a;
    int i;
    if ((paramalcn.e.gender == 0) || (paramalcn.e.gender == 1)) {
      i = paramalcn.e.gender;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramalcn = this.mActivity.getString(2131695654);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramalcn);
        }
        if (TextUtils.isEmpty(paramalcn)) {
          break label685;
        }
        this.Xl.setVisibility(0);
        this.Xl.setText(paramalcn);
        this.Xl.setContentDescription(paramalcn);
        label204:
        localObject = "";
        if (localCard == null) {
          break label697;
        }
        i = localCard.age;
        label220:
        paramalcn = (alcn)localObject;
        if (i > 0)
        {
          paramalcn = (alcn)localObject;
          if (!aqep.aBZ()) {
            paramalcn = i + this.mActivity.getString(2131720665);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramalcn);
        }
        if (TextUtils.isEmpty(paramalcn)) {
          break label713;
        }
        this.Xt.setVisibility(0);
        this.Xt.setText(paramalcn);
        this.Xt.setContentDescription(paramalcn);
        label327:
        localObject = "";
        if (localCard == null) {
          break label725;
        }
        paramalcn = (alcn)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramalcn = (alcn)localObject;
          if (!acfp.m(2131716797).equals(localCard.strCountry)) {
            paramalcn = "" + localCard.strCountry;
          }
        }
        localObject = paramalcn;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramalcn;
          if (!TextUtils.isEmpty(paramalcn)) {
            localObject = paramalcn + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramalcn = (alcn)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramalcn = (alcn)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramalcn = (String)localObject + "，";
          }
          paramalcn = paramalcn + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramalcn);
        }
        if (TextUtils.isEmpty(paramalcn)) {
          break label936;
        }
        this.Xs.setVisibility(0);
        this.Xs.setText(paramalcn);
        this.Xs.setContentDescription(paramalcn);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label946;
        }
        i = localContactCard.bSex;
        break;
        paramalcn = (alcn)localObject;
        if (i != 1) {
          break label141;
        }
        paramalcn = this.mActivity.getString(2131693477);
        break label141;
        label685:
        this.Xl.setVisibility(8);
        break label204;
        label697:
        i = j;
        if (localContactCard == null) {
          break label220;
        }
        i = localContactCard.bAge;
        break label220;
        label713:
        this.Xt.setVisibility(8);
        break label327;
        label725:
        paramalcn = (alcn)localObject;
        if (localContactCard != null)
        {
          paramalcn = (alcn)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramalcn = (alcn)localObject;
            if (!acfp.m(2131716796).equals(localContactCard.strCountry)) {
              paramalcn = "" + localContactCard.strCountry;
            }
          }
          localObject = paramalcn;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramalcn;
            if (!TextUtils.isEmpty(paramalcn)) {
              localObject = paramalcn + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramalcn = (alcn)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramalcn = (alcn)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramalcn = (String)localObject + "，";
            }
            paramalcn = paramalcn + localContactCard.strCity;
          }
        }
      }
      label936:
      this.Xs.setVisibility(8);
      return;
      label946:
      i = -1;
    }
  }
  
  @TargetApi(9)
  void t(alcn paramalcn)
  {
    if (!paramalcn.e.uin.equals(this.app.getCurrentAccountUin())) {
      this.CI.setVisibility(8);
    }
    do
    {
      return;
      if ((paramalcn.d.cardType != 2) && (paramalcn.d.lCurrentBgId != 1600L)) {
        break;
      }
      this.CI.setVisibility(0);
      paramalcn = this.app.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramalcn.getBoolean("vip_diy_card_edit_hint", false));
    this.Xw.setVisibility(0);
    paramalcn.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.CI.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */