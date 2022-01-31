package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import gjg;
import java.util.HashMap;

public class ProfileGameView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private float jdField_c_of_type_Float;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private float jdField_d_of_type_Float;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private float jdField_e_of_type_Float;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private float jdField_f_of_type_Float;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  
  public ProfileGameView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
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
    ThreadManager.b(new gjg(this, paramInt, paramAllInOne, paramString));
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
    localHashMap.put("signColor", "color");
    localHashMap.put("playGameNowColor", "color");
    localHashMap.put("showMoreGameColor", "color");
    localHashMap.put("showMoreGameDrawableRight", "drawable");
    localHashMap.put("playGameTitleColor", "color");
    localHashMap.put("playGameBackground", "drawable");
    localHashMap.put("playGameIconBorder", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.h(paramProfileCardInfo);
    c(paramProfileCardInfo);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2130903682, this, true);
    ProfileCardTemplate.a((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233399), "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "headerBackground");
    Object localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233400);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131427437);
    int j = getResources().getDimensionPixelSize(2131427440);
    this.jdField_d_of_type_Float = (this.jdField_b_of_type_Float - (i + j * 3));
    this.jdField_c_of_type_Float = (70.0F * this.jdField_a_of_type_Float);
    this.jdField_f_of_type_Float = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233383));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233401));
    ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "faceBackground");
    localObject2 = new DataTag(1, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131558436);; localObject1 = ((Context)localObject1).getString(2131558435))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233385));
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "nickNameColor");
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_d_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233387));
      ProfileCardTemplate.a(this.e, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "addressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.e);
      super.f(paramProfileCardInfo);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233403));
      ProfileCardTemplate.a(this.jdField_f_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "signColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_f_of_type_AndroidWidgetTextView);
      c(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233380));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_c_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233381));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like_image", this.jdField_a_of_type_AndroidWidgetImageView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233404));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "playGameBackground");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_play_game", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233405));
      ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "playGameNowColor");
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233406));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "showMoreGameColor");
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "drawableRight", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "showMoreGameDrawableRight");
      localObject1 = new DataTag(19, new Object[] { Boolean.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isOpenRecentPlayingGamesByNative()), paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strProfileUrl });
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233407));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233379));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_c_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      return;
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    TextView localTextView;
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      if (localTextView != null)
      {
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break label46;
        }
        localTextView.setVisibility(4);
      }
    }
    return;
    label46:
    localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
    if ((!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject == null))
    {
      localTextView.setVisibility(4);
      return;
    }
    SpannableString localSpannableString = ((RichStatus)localObject).a(null);
    if (!TextUtils.isEmpty(((RichStatus)localObject).c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
      localSpannableStringBuilder.insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localStatusManager != null)
      {
        localObject = localStatusManager.a(((RichStatus)localObject).b, 200);
        localObject = new StatableBitmapDrawable(getResources(), (Bitmap)localObject, false, false);
        int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject).setBounds(0, 0, i, i);
        localObject = new OffsetableImageSpan((Drawable)localObject, 0);
        ((OffsetableImageSpan)localObject).a(-0.1F);
        localSpannableStringBuilder.setSpan(localObject, 0, "[S]".length(), 17);
        localTextView.setText(localSpannableStringBuilder);
        localTextView.setVisibility(0);
        label229:
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
          localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (localSpannableString == null) {
          break label388;
        }
        localObject = localSpannableString.toString();
        label276:
        localTextView.setTag(new DataTag(3, localObject));
        localTextView.setOnLongClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558418)).append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558413));
        if (localSpannableString == null) {
          break label395;
        }
      }
    }
    label388:
    label395:
    for (paramProfileCardInfo = localSpannableString.toString();; paramProfileCardInfo = "")
    {
      localTextView.setContentDescription(paramProfileCardInfo);
      return;
      localObject = BitmapFactory.decodeResource(getResources(), 2130839653);
      break;
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label229;
      localObject = "";
      break label276;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileGameView
 * JD-Core Version:    0.7.0.1
 */