package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.QZoneCoverView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import gji;
import gjj;
import gjl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements ProfileViewUpdate, BounceScrollView.MotionEventInterceptor
{
  public static String a;
  public static int b = 0;
  protected static final int d = 1;
  protected static final int e = 2;
  protected float a;
  public int a;
  public long a;
  public Handler a;
  public BaseActivity a;
  public QQAppInterface a;
  protected ProfileCardInfo a;
  public HashMap a;
  protected float b;
  public int c = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
    jdField_b_of_type_Int = 1000;
  }
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.b;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public CoverCacheData a()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getCoverCacheData");
        }
        return ((QZoneCoverView)localObject).a();
      }
    }
    else if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
        }
        return ((QzonePhotoView)localObject).a();
      }
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (localObject != null) {
        ((QZoneCoverView)localObject).b();
      }
    }
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
      if ((paramAllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.o)))
      {
        a(paramAllInOne, 0, paramAllInOne.o);
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
    ThreadManager.b(new gjj(this, paramInt, paramAllInOne, paramString));
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
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130839806, 0, 0, 0);
        ((TextView)localObject2).setTag(null);
        ((TextView)localObject2).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((TextView)localObject2).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558423), new Object[] { ((TextView)localObject2).getText() }));
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
    paramHashMap.put("titleBarBackground", "drawable");
    paramHashMap.put("titleBarTitleColor", "color");
    paramHashMap.put("titleBarLeftView", "drawable");
    paramHashMap.put("titleBarRightView", "drawable");
    paramHashMap.put("bottomBtnBackground", "drawable");
    paramHashMap.put("bottomBtnTextColor", "color");
    paramHashMap.put("guideArrowImage", "drawable");
    paramHashMap.put("background", "drawable");
    paramHashMap.put("itemTitleColor", "color");
    paramHashMap.put("itemContentColor", "color");
    paramHashMap.put("itemContentLinkColor", "color");
    paramHashMap.put("itemTopBorderBackground", "drawable");
    paramHashMap.put("itemBottomBorderBackground", "drawable");
    paramHashMap.put("itemNoneBorderBackground", "drawable");
    paramHashMap.put("itemBorderBackground", "drawable");
    paramHashMap.put("itemMoreSrc", "drawable");
    paramHashMap.put("qrCodeSrc", "drawable");
    paramHashMap = paramHashMap.entrySet().iterator();
    label501:
    label504:
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
          break label501;
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
          break label504;
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
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCoverView");
        }
        ((QZoneCoverView)localObject).a(paramCoverCacheData);
      }
    }
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof QzonePhotoView));
      localObject = (QzonePhotoView)localObject;
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
    }
    ((QzonePhotoView)localObject).a(paramCoverCacheData);
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QZoneCoverView)) {
      ((QZoneCoverView)localView).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QZoneCoverView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
        }
        ((QZoneCoverView)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
      }
    }
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof QzonePhotoView));
      localObject = (QzonePhotoView)localObject;
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    h(paramProfileCardInfo);
    i(paramProfileCardInfo);
    this.jdField_a_of_type_AndroidOsHandler = new gji(this, paramProfileCardInfo);
    paramProfileCardInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramProfileCardInfo != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramProfileCardInfo);
    }
  }
  
  public void c()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (localObject != null) {
        ((QZoneCoverView)localObject).a();
      }
    }
  }
  
  public void d()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (localObject != null) {
        ((QZoneCoverView)localObject).c();
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(jdField_b_of_type_Int);
    }
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
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
            break label176;
          }
        }
      }
    }
    label176:
    for (paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
    {
      localTextView.setText(paramProfileCardInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558414) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558413);
      localTextView.setContentDescription((String)localObject + paramProfileCardInfo);
      return;
    }
  }
  
  public void f(ProfileCardInfo paramProfileCardInfo)
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
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562605);
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
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558417) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558413) + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void g(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like_image");
    if (((localObject2 instanceof TextView)) && ((localObject1 instanceof ImageView)))
    {
      localObject2 = (TextView)localObject2;
      localObject1 = (ImageView)localObject1;
      if ((localObject2 != null) && (localObject1 != null)) {
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break label539;
        }
      }
    }
    label539:
    for (boolean bool = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan();; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike type isShowVote = " + String.valueOf(bool));
      }
      if (bool)
      {
        if (((TextView)localObject2).getVisibility() != 0) {
          ((TextView)localObject2).setVisibility(0);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike card is null likeView gone");
          }
          if (((ImageView)localObject1).getVisibility() != 8) {
            ((ImageView)localObject1).setVisibility(8);
          }
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130839805, 0, 0, 0);
          ((TextView)localObject2).setTag(null);
          ((TextView)localObject2).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558426));
        }
      }
      do
      {
        return;
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement > 0)) {
          ((ImageView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            ((TextView)localObject2).setText(String.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount));
          }
          if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            break;
          }
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130839805, 0, 0, 0);
          ((TextView)localObject2).setTag(new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
          ((TextView)localObject2).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject2).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558425), new Object[] { ((TextView)localObject2).getText() }));
          return;
          ((ImageView)localObject1).setVisibility(8);
        }
        if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted)
        {
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130839806, 0, 0, 0);
          ((TextView)localObject2).setTag(null);
          ((TextView)localObject2).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject2).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558423), new Object[] { ((TextView)localObject2).getText() }));
          return;
        }
        ((TextView)localObject2).setEnabled(true);
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130839805, 0, 0, 0);
        ((TextView)localObject2).setTag(new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
        ((TextView)localObject2).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((TextView)localObject2).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131558424), new Object[] { ((TextView)localObject2).getText() }));
        return;
        if (((TextView)localObject2).getVisibility() != 8) {
          ((TextView)localObject2).setVisibility(8);
        }
      } while (((ImageView)localObject1).getVisibility() == 8);
      ((ImageView)localObject1).setVisibility(8);
      return;
    }
  }
  
  public void h(ProfileCardInfo paramProfileCardInfo)
  {
    this.c &= 0xFFFFFFFE;
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903691, null);
    }
    for (;;)
    {
      Object localObject;
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (ProfileActivity.AllInOne.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (localObject != null)
        {
          localObject = ((FriendManager)localObject).c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if ((2 != i) && (i != 0)) {
            break label171;
          }
          this.c &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip local network: " + i);
          }
        }
      }
      label171:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_net_voice", localView);
          return;
          if ((localObject == null) || ((((Friends)localObject).iTermType != 68104) && (((Friends)localObject).iTermType != 65805))) {
            break;
          }
          this.c &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip friend iTermType=" + ((Friends)localObject).iTermType);
          }
        }
      } while ((localObject == null) || ((((Friends)localObject).abilityBits & 1L) == 0L));
      TextView localTextView = (TextView)localView.findViewById(2131233442);
      switch (((Friends)localObject).getNetWorkType())
      {
      default: 
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563196);
      case 1: 
      case 4: 
      case 3: 
        for (;;)
        {
          localTextView.setText(paramProfileCardInfo);
          this.c |= 0x1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip has ability,show tip.net=" + ((Friends)localObject).getNetWorkType());
          break;
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563054);
          continue;
          paramProfileCardInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563047), new Object[] { "4G" });
          continue;
          paramProfileCardInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563047), new Object[] { "3G" });
        }
      }
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563050);
      Resources localResources = getResources();
      if (((Friends)localObject).iTermType == 67586) {}
      for (int i = 2130839036;; i = 2130839037)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(localResources.getDrawable(i), null, null, null);
        localTextView.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
        break;
      }
    }
  }
  
  public void i(ProfileCardInfo paramProfileCardInfo)
  {
    this.c &= 0xFFFFFFFD;
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903684, null);
    }
    for (;;)
    {
      long l2;
      int i;
      Object localObject1;
      if ((localView != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentTemplateId;
        i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        localObject1 = getResources();
        localObject2 = (TextView)localView.findViewById(2131233421);
        ImageView localImageView = (ImageView)localView.findViewById(2131233422);
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label408;
        }
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        boolean bool = false;
        if (localObject3 != null) {
          bool = ((SharedPreferences)localObject3).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isShowTips" + bool + ",templateRet=" + i + ",myTemplateId=" + l2);
        }
        if ((l2 > 0L) && ((101107 == i) || (101108 == i)) && (!bool) && (localObject3 != null))
        {
          ((SharedPreferences)localObject3).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if (101107 != i) {
            break label395;
          }
          localObject1 = ((Resources)localObject1).getString(2131562685);
          localObject1 = ((BaseActivity)localObject3).getString(2131561522, new Object[] { localObject1 });
          ((TextView)localObject2).setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new DataTag(24, Integer.valueOf(i)));
          localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.c |= 0x2;
        }
      }
      label395:
      label408:
      do
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
        return;
        localObject1 = ((Resources)localObject1).getString(2131562993);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("ProfileCardTips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      } while ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null) || (l2 <= 0L) || (i != 0));
      paramProfileCardInfo = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
      Object localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localObject2 != null) {}
      for (long l1 = ((Card)localObject2).lCurrentTemplateId;; l1 = 0L)
      {
        localObject1 = ((SharedPreferences)localObject1).getString(String.valueOf(l2), "");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar today=" + paramProfileCardInfo + ",userLastAccessDay=" + (String)localObject1 + ",friendTemplateId=" + l1 + ",myTemplateId=" + l2);
        }
        if ((TextUtils.isEmpty(paramProfileCardInfo)) || (paramProfileCardInfo.equals(localObject1)) || (l1 == l2)) {
          break;
        }
        break;
      }
    }
  }
  
  public void j(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips");
    }
    paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips");
    LinearLayout localLinearLayout;
    Object localObject;
    if ((paramProfileCardInfo != null) && ((paramProfileCardInfo instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramProfileCardInfo;
      localLinearLayout.setVisibility(4);
      if (((this.c & 0x1) == 0) || ((this.c & 0x2) == 0)) {
        break label256;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice and setcard");
      }
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
      if ((paramProfileCardInfo != null) && (localObject != null))
      {
        if (localLinearLayout.getChildCount() != 0) {
          break label180;
        }
        localLinearLayout.addView(paramProfileCardInfo);
        localLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int < 4)
        {
          this.jdField_a_of_type_Int += 1;
          paramProfileCardInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramProfileCardInfo, 4000L);
        }
      }
    }
    label180:
    do
    {
      do
      {
        do
        {
          return;
          View localView = localLinearLayout.getChildAt(0);
          if (localView != null)
          {
            if (localView.getId() == 2131233441) {
              paramProfileCardInfo = (ProfileCardInfo)localObject;
            }
            for (;;)
            {
              localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968668);
              ((Animation)localObject).setFillAfter(true);
              ((Animation)localObject).setAnimationListener(new gjl(this, localLinearLayout, paramProfileCardInfo));
              localLinearLayout.setVisibility(0);
              localView.startAnimation((Animation)localObject);
              return;
            }
          }
          localLinearLayout.setVisibility(4);
          return;
          if ((this.c & 0x1) == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice");
          }
          paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
        } while (paramProfileCardInfo == null);
        localLinearLayout.removeAllViews();
        localLinearLayout.addView(paramProfileCardInfo);
        localLinearLayout.setVisibility(0);
        return;
      } while ((this.c & 0x2) == 0);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips setcard");
      }
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    } while (paramProfileCardInfo == null);
    label256:
    localLinearLayout.removeAllViews();
    localLinearLayout.addView(paramProfileCardInfo);
    localLinearLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */