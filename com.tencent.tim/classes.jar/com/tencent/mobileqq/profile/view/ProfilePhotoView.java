package com.tencent.mobileqq.profile.view;

import albb;
import alcn;
import alcs;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfilePhotoView
  extends ProfileHeaderView
{
  private ImageView CG;
  private TextView Xl;
  private HeartLayout a;
  public QzonePhotoView a;
  private ProfileNameView jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteView jdField_b_of_type_ComTencentMobileqqWidgetVoteView;
  private LinearLayout fr;
  private AvatarLayout g;
  View mContentView;
  public ImageView qa;
  private float yx;
  private float yy;
  private float yz;
  
  public ProfilePhotoView(BaseActivity paramBaseActivity, alcn paramalcn)
    throws ProfileTemplateException
  {
    super(paramBaseActivity, paramalcn);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    k(paramalcn);
    e(paramalcn);
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    super.i(paramalcn);
    super.j(paramalcn);
    super.f(paramalcn);
    super.g(paramalcn);
    super.c(paramalcn, false);
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.d(paramView, paramMotionEvent);
  }
  
  public void e(alcn paramalcn)
  {
    Object localObject1 = getContext();
    this.mContentView = LayoutInflater.from((Context)localObject1).inflate(2131562226, this, true);
    Object localObject2 = (RelativeLayout)this.mContentView.findViewById(2131368475);
    localObject2 = (LinearLayout)this.mContentView.findViewById(2131369173);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131297488);
    int j = getResources().getDimensionPixelSize(2131297492);
    this.yy = (this.of - (i + j * 3));
    this.yx = (70.0F * this.mDensity);
    this.yz = (this.of - 103.0F * this.mDensity - j * 2);
    this.g = ((AvatarLayout)this.mContentView.findViewById(2131369165));
    this.g.setVisibility(0);
    this.CG = ((ImageView)this.mContentView.findViewById(2131369166));
    alcs.a(this.CG, "src", paramalcn.b, "commonFaceBackground");
    localObject2 = new albb(1, null);
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.mContentView.findViewById(2131369183));
      alcs.a(this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramalcn.b, "photoNickNameColor");
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.mt.put("map_key_profile_nick_name", this.jdField_b_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.j(paramalcn);
      this.Xl = ((TextView)this.mContentView.findViewById(2131369174));
      alcs.a(this.Xl, "color", paramalcn.b, "photoAddressColor");
      this.mt.put("map_key_sex_age_area", this.Xl);
      super.f(paramalcn);
      this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131382077));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368498));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.mt.put("map_key_like", this.jdField_b_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramalcn);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView = ((QzonePhotoView)this.mContentView.findViewById(2131375577));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(this.mActivity, paramalcn);
      this.mt.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView);
      alcs.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, "background", paramalcn.b, "commonMaskBackground");
      this.fr = ((LinearLayout)this.mContentView.findViewById(2131369231));
      this.mt.put("map_key_tips", this.fr);
      super.e(paramalcn);
      super.l(paramalcn);
      return;
    }
  }
  
  public void k(alcn paramalcn)
    throws ProfileTemplateException
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    super.a(paramalcn, localHashMap);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alcn != null) {
      super.c(this.jdField_a_of_type_Alcn, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */