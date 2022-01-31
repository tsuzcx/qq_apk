package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.qphone.base.util.QLog;
import gff;
import java.util.HashMap;

public class ProfileSocialView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public ProfileSocialView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
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
    ThreadManager.b(new gff(this, paramInt, paramAllInOne, paramString));
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("headerBackground", "drawable");
    localHashMap.put("nickNameColor", "color");
    localHashMap.put("addressColor", "color");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.h(paramProfileCardInfo);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject).inflate(2130903691, this, true);
    ProfileCardTemplate.a(this.jdField_a_of_type_AndroidViewView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "headerBackground");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233385));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject = ((Context)localObject).getString(2131558436);; localObject = ((Context)localObject).getString(2131558435))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233387));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "nickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233389));
      ProfileCardTemplate.a(this.c, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "addressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.c);
      super.f(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233382));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233383));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like_image", this.jdField_a_of_type_AndroidWidgetImageView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233381));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileSocialView
 * JD-Core Version:    0.7.0.1
 */