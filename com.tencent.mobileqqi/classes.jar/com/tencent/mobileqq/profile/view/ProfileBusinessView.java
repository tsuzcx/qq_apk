package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import geu;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileBusinessView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private float jdField_c_of_type_Float;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private float jdField_d_of_type_Float;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private float jdField_e_of_type_Float;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  
  public ProfileBusinessView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
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
    ThreadManager.b(new geu(this, paramInt, paramAllInOne, paramString));
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("faceBackground", "drawable");
    localHashMap.put("headerBackground", "drawable");
    localHashMap.put("nickNameColor", "color");
    localHashMap.put("telColor", "color");
    localHashMap.put("emailAddressColor", "color");
    localHashMap.put("emailBackground", "drawable");
    localHashMap.put("addressBackground", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    c(paramProfileCardInfo);
    d(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.h(paramProfileCardInfo);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject).inflate(2130903682, this, true);
    ProfileCardTemplate.a(this.jdField_a_of_type_AndroidViewView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "headerBackground");
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131427440);
    int j = getResources().getDimensionPixelSize(2131427443);
    this.jdField_d_of_type_Float = (this.jdField_b_of_type_Float - (i + j * 3));
    this.jdField_c_of_type_Float = (70.0F * this.jdField_a_of_type_Float);
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233384));
    ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetImageView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "faceBackground");
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject = ((Context)localObject).getString(2131558436);; localObject = ((Context)localObject).getString(2131558435))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233386));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "nickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233391));
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "telColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tel", this.jdField_d_of_type_AndroidWidgetTextView);
      c(paramProfileCardInfo);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233393));
      ProfileCardTemplate.a(this.jdField_e_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "emailAddressColor");
      ProfileCardTemplate.a(this.jdField_e_of_type_AndroidWidgetTextView, "drawableleft", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "emailBackground");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tel", this.jdField_e_of_type_AndroidWidgetTextView);
      d(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233388));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "emailAddressColor");
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "drawableleft", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "addressBackground");
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
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 == null) {
        break label133;
      }
      i = ((ArrayList)localObject2).size();
      localObject1 = null;
      j = 0;
    }
    for (;;)
    {
      if (j < i)
      {
        localObject1 = (ProfileActivity.CardContactInfo)((ArrayList)localObject2).get(j);
        if ((localObject1 == null) || (TextUtils.isEmpty(((ProfileActivity.CardContactInfo)localObject1).c))) {}
      }
      else
      {
        if ((localObject1 == null) || (this.jdField_d_of_type_AndroidWidgetTextView == null)) {
          break label145;
        }
        localObject2 = ((ProfileActivity.CardContactInfo)localObject1).c;
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = new DataTag(4, localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setTag(localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
        label133:
        i = 0;
        break;
      }
      j += 1;
    }
    label145:
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strShowName;
      if ((!TextUtils.isEmpty(paramProfileCardInfo)) && (StringUtil.a(paramProfileCardInfo)))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBusinessView
 * JD-Core Version:    0.7.0.1
 */