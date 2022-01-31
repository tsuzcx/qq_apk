package com.tencent.mobileqq.profile.view;

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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.qphone.base.util.QLog;
import gjm;
import java.util.HashMap;

public class ProfilePhotoView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QzonePhotoView a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private float jdField_c_of_type_Float;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private float jdField_d_of_type_Float;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private float e;
  private float f;
  
  public ProfilePhotoView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.b;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    a(paramProfileCardInfo);
    b(paramProfileCardInfo);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString);
    }
    ThreadManager.b(new gjm(this, paramInt, paramAllInOne, paramString));
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("faceBackground", "drawable");
    localHashMap.put("editFaceSrc", "drawable");
    localHashMap.put("headerBackground", "drawable");
    localHashMap.put("nickNameColor", "color");
    localHashMap.put("addressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    localHashMap.put("photoMore", "drawable");
    localHashMap.put("photoAddTipsImage", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.h(paramProfileCardInfo);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject).inflate(2130903686, this, true);
    ProfileCardTemplate.a((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233399), "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "headerBackground");
    ProfileCardTemplate.a((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233400), "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "userInfoBackground");
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131427437);
    int j = getResources().getDimensionPixelSize(2131427440);
    this.d = (this.jdField_b_of_type_Float - (i + j * 3));
    this.jdField_c_of_type_Float = (70.0F * this.jdField_a_of_type_Float);
    this.f = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233383));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233401));
    ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "faceBackground");
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject = ((Context)localObject).getString(2131558436);; localObject = ((Context)localObject).getString(2131558435))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233385));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "nickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233387));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "addressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_c_of_type_AndroidWidgetTextView);
      super.f(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233380));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233381));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like_image", this.jdField_a_of_type_AndroidWidgetImageView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView = ((QzonePhotoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233428));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233379));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */