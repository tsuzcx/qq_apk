package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileBaseView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    b(paramProfileCardInfo);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131298670).getLayoutParams();
      int i = getResources().getDimensionPixelSize(2131492947);
      if ((localObject != null) && (((RelativeLayout.LayoutParams)localObject).topMargin != i)) {
        ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, i, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      }
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131298665);
    } while (localObject == null);
    ((View)localObject).setBackgroundResource(2130838855);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo) {}
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.c(paramProfileCardInfo);
    super.d(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.g(paramProfileCardInfo);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject).inflate(2130903594, this, true);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298669));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      localObject = ((Context)localObject).getString(2131361818);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      a();
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298672));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.c(paramProfileCardInfo);
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298674));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.c);
      super.d(paramProfileCardInfo);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.allowClick)) {
        break label313;
      }
    }
    for (;;)
    {
      super.f(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298666));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298667));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like_image", this.jdField_a_of_type_AndroidWidgetImageView);
      super.g(paramProfileCardInfo);
      super.b(paramProfileCardInfo);
      return;
      localObject = ((Context)localObject).getString(2131361817);
      break;
      label313:
      if (!QLog.isColorLevel()) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */