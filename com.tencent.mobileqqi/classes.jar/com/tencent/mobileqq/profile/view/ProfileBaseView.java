package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.QZoneCoverView;
import java.util.HashMap;

public class ProfileBaseView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  QZoneCoverView jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.b;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_b_of_type_AndroidViewView = paramView;
    b(paramProfileCardInfo);
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo) {}
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.g(paramProfileCardInfo);
    b(paramProfileCardInfo, false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131233385).getLayoutParams();
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break;
        }
        i = getResources().getDimensionPixelSize(2131427448);
        if ((localObject != null) && (((RelativeLayout.LayoutParams)localObject).topMargin != i)) {
          ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, i, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        }
        localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131233379);
      } while (localObject == null);
      ((View)localObject).setBackgroundResource(0);
      return;
      int i = getResources().getDimensionPixelSize(2131427447);
      if ((localObject != null) && (((RelativeLayout.LayoutParams)localObject).topMargin != i)) {
        ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, i, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      }
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131233379);
    } while (localObject == null);
    ((View)localObject).setBackgroundResource(2130839013);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Context localContext = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(localContext).inflate(2130903680, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView = ((QZoneCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233378));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
    this.jdField_b_of_type_AndroidViewView = null;
    Object localObject = new DataTag(17, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setTag(localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setVisibility(0);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = localContext.getString(2131558438);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setContentDescription((CharSequence)localObject);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label511;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0);
      label149:
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233384));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = new DataTag(1, null);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label589;
      }
    }
    label589:
    for (localObject = localContext.getString(2131558436);; localObject = localContext.getString(2131558435))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_c_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231782));
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_ComTencentImageURLImageView);
      b(paramProfileCardInfo, true);
      b();
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233386));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233388));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_c_of_type_AndroidWidgetTextView);
      super.f(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233381));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233382));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like_image", this.jdField_a_of_type_AndroidWidgetImageView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233380));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      return;
      localObject = localContext.getString(2131558437);
      break;
      label511:
      if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (!paramProfileCardInfo.jdField_a_of_type_Boolean) {}
        for (int i = 1;; i = 3)
        {
          ((QZoneCoverView)localObject).a(localQQAppInterface, str, i);
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 2);
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */