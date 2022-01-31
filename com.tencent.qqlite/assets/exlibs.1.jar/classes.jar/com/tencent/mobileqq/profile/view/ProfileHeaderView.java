package com.tencent.mobileqq.profile.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
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
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.qphone.base.util.QLog;
import ebg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements ProfileViewUpdate, BounceScrollView.MotionEventInterceptor
{
  public static String a;
  protected float a;
  public BaseActivity a;
  public QQAppInterface a;
  protected ProfileCardInfo a;
  public HashMap a;
  protected float b;
  protected float c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
  }
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.b = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.c = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString);
      return;
    }
    if (ProfileActivity.AllInOne.f(paramAllInOne))
    {
      if ((paramAllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.p)))
      {
        a(paramAllInOne, 0, paramAllInOne.p);
        return;
      }
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = ProfileCardUtil.a(paramAllInOne);
    if ((str != null) && (str.length() > 0))
    {
      a(paramAllInOne, 1, str);
      return;
    }
    a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString);
    }
    ThreadManager.b(new ebg(this, paramInt, paramAllInOne, paramString));
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo);
  
  public void a(ProfileCardInfo paramProfileCardInfo, long paramLong)
  {
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like_image");
    if (((localObject2 instanceof TextView)) && ((localObject1 instanceof ImageView)))
    {
      localObject2 = (TextView)localObject2;
      localObject1 = (ImageView)localObject1;
      if ((localObject2 != null) && (localObject1 != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
        }
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130839276, 0, 0, 0);
        ((TextView)localObject2).setTag(null);
        ((TextView)localObject2).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((TextView)localObject2).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361806), new Object[] { ((TextView)localObject2).getText() }));
        if (paramLong >= 0L) {
          ((TextView)localObject2).setText(String.valueOf(paramLong));
        }
      }
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, HashMap paramHashMap)
  {
    paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap;
    String str1 = getClass().getName();
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.size() <= 0)) {
      throw new ProfileTemplateException(str1 + " template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label426:
    label429:
    for (;;)
    {
      Object localObject1;
      String str2;
      Object localObject2;
      int i;
      String str3;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramProfileCardInfo.get(str2);
        String[] arrayOfString = ((String)localObject1).split(",");
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label426;
        }
        str3 = arrayOfString[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          if ((str3.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label429;
        }
        throw new ProfileTemplateException(str1 + " template attr " + str2 + " type is not " + (String)localObject1);
        if ((str3.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          i = 1;
        }
        else if ((str3.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          i = 1;
        }
        else
        {
          i += 1;
          break;
          return;
          i = 0;
        }
      }
    }
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    TextView localTextView;
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      if (localTextView != null)
      {
        localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName;
        localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
        localObject = ((MQQProfileName)localObject).a.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + (String)localObject);
        }
        if (localObject != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          if (!ProfileActivity.AllInOne.a(localAllInOne)) {
            break label169;
          }
        }
      }
    }
    label169:
    for (paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
    {
      localTextView.setText(paramProfileCardInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361798) + ":";
      localTextView.setContentDescription((String)localObject + paramProfileCardInfo);
      return;
    }
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (localObject != null)
      {
        str = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + str);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label126;
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364199);
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 10, 0, 0);
        ((TextView)localObject).setText(paramProfileCardInfo);
        ((TextView)localObject).setContentDescription(paramProfileCardInfo);
      }
    }
    label126:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361799) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_level");
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_level_accelerate");
    long l;
    int i;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (localObject != null)
      {
        l = 0L;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break label271;
        }
        i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel;
        l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uAccelerateMultiple;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLevel level=" + i);
      }
      if ((i == 0) || (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        if (((TextView)localObject).getVisibility() != 8) {
          ((TextView)localObject).setVisibility(8);
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        return;
      }
      ((TextView)localObject).setText(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6, i, false));
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361819);
      if (l > 10L)
      {
        localView.setVisibility(0);
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361820);
      }
      for (;;)
      {
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361801) + ":" + Integer.toString(i) + paramProfileCardInfo);
        return;
      }
      label271:
      i = 0;
    }
  }
  
  public void f(ProfileCardInfo paramProfileCardInfo) {}
  
  public void g(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like_image");
    if (((localObject1 instanceof TextView)) && ((localObject2 instanceof ImageView)))
    {
      localObject1 = (TextView)localObject1;
      localObject2 = (ImageView)localObject2;
      if ((localObject1 != null) && (localObject2 != null)) {
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break label568;
        }
      }
    }
    label568:
    for (boolean bool = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan();; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike type isShowVote = " + String.valueOf(bool));
      }
      if (bool)
      {
        if (((TextView)localObject1).getVisibility() != 0) {
          ((TextView)localObject1).setVisibility(0);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike card is null likeView gone");
          }
          if (((ImageView)localObject2).getVisibility() != 8) {
            ((ImageView)localObject2).setVisibility(8);
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130839275, 0, 0, 0);
          ((TextView)localObject1).setTag(null);
          ((TextView)localObject1).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361809));
        }
      }
      do
      {
        return;
        for (;;)
        {
          try
          {
            long l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
            if ((!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement <= 0)) {
              continue;
            }
            ((ImageView)localObject2).setVisibility(0);
            if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (l >= 0L)) {
              ((TextView)localObject1).setText(String.valueOf(l));
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
            if (1 != paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {
              continue;
            }
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130839276, 0, 0, 0);
            ((TextView)localObject1).setTag(null);
            ((TextView)localObject1).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((TextView)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361806), new Object[] { ((TextView)localObject1).getText() }));
            return;
            ((TextView)localObject1).setEnabled(true);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130839275, 0, 0, 0);
            ((TextView)localObject1).setTag(new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
            ((TextView)localObject1).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((TextView)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361807), new Object[] { ((TextView)localObject1).getText() }));
            return;
          }
          if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            continue;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130839275, 0, 0, 0);
          ((TextView)localObject1).setTag(new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
          ((TextView)localObject1).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361808), new Object[] { ((TextView)localObject1).getText() }));
          return;
          ((ImageView)localObject2).setVisibility(8);
        }
        if (((TextView)localObject1).getVisibility() != 8) {
          ((TextView)localObject1).setVisibility(8);
        }
      } while (localException.getVisibility() == 8);
      localException.setVisibility(8);
      return;
    }
  }
  
  public void h(ProfileCardInfo paramProfileCardInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */