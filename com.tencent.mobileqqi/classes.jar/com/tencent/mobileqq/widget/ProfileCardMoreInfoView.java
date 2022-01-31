package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfileCardMoreInfoView
  extends LinearLayout
{
  private static final String jdField_a_of_type_JavaLangString = "map_key_account_info";
  private static final String jdField_b_of_type_JavaLangString = "map_key_sig";
  private static final String jdField_c_of_type_JavaLangString = "map_key_phone_";
  private static final String d = "map_key_qzone_feed";
  private static final String e = "map_key_diamond";
  private static final String f = "map_key_qzone_photo";
  private static final String g = "map_key_nick";
  private static final String h = "map_key_recommendname";
  private static final String i = "map_key_circlenick";
  private static final String j = "map_key_troopnick";
  private static final String k = "map_key_remark";
  private static final String l = "map_key_qrcode";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  public ProfileCardTemplate a;
  public ProfileHeaderView a;
  public RichStatus a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_account_info", "map_key_qrcode", "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_sig", "map_key_phone_", "map_key_qzone_feed", "map_key_qzone_photo", "map_key_diamond" };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_phone_" };
  private float jdField_c_of_type_Float;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
    a(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
    a(paramContext);
  }
  
  private int a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, String paramString, Card paramCard)
  {
    if (paramTextView.getPaint() == null) {
      new TextPaint(1).density = this.c;
    }
    paramString = new StringBuffer(paramString);
    paramString.append(" ");
    paramString = paramString.toString();
    getResources();
    paramTextView.setText(new SpannableString(paramString));
    return 0;
  }
  
  private View a(LayoutInflater paramLayoutInflater, View paramView, ProfileActivity.CardContactInfo paramCardContactInfo, String paramString)
  {
    if (paramCardContactInfo == null) {
      return paramView;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = (LinearLayout)paramLayoutInflater.inflate(2130903607, null);
    }
    paramLayoutInflater = (TextView)((View)localObject).findViewById(2131230941);
    paramView = (TextView)((View)localObject).findViewById(2131231507);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131232623);
    if (localImageView.getVisibility() != 0) {
      localImageView.setVisibility(0);
    }
    localImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramLayoutInflater.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString);
      paramView.setText(paramCardContactInfo.c);
      ((View)localObject).setTag(new DataTag(4, paramCardContactInfo));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramCardContactInfo = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label253;
      }
      paramCardContactInfo.append(a(2131558422));
    }
    for (;;)
    {
      paramCardContactInfo.append(a(2131558413)).append(paramView.getText());
      ((View)localObject).setContentDescription(paramCardContactInfo.toString());
      a(paramString, paramLayoutInflater, paramView, localImageView);
      return localObject;
      paramLayoutInflater.setText(2131562599);
      paramView.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString + " " + paramCardContactInfo.c);
      break;
      label253:
      paramCardContactInfo.append(a(2131558421));
    }
  }
  
  private String a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {
      return a(2131562467);
    }
    if ("map_key_circlenick".equals(paramString)) {
      return a(2131561817);
    }
    if ("map_key_remark".equals(paramString)) {
      return a(2131562747);
    }
    if ("map_key_recommendname".equals(paramString)) {
      return a(2131562729);
    }
    if ("map_key_troopnick".equals(paramString)) {
      return a(2131562194);
    }
    return null;
  }
  
  private List a(HashMap paramHashMap, String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m;
    int n;
    label23:
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      m = 0;
      n = 0;
      if (n >= m) {
        break label194;
      }
      localObject = paramArrayOfString[n];
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null) || (!"map_key_sig".equals(localObject)) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label94;
      }
    }
    for (;;)
    {
      n += 1;
      break label23;
      m = paramArrayOfString.length;
      break;
      label94:
      if ("map_key_phone_".equals(localObject))
      {
        int i1 = 0;
        while (i1 < paramInt)
        {
          localObject = (View)paramHashMap.get("map_key_phone_" + String.valueOf(i1));
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          i1 += 1;
        }
      }
      else
      {
        localObject = (View)paramHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    label194:
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initCommonWidth");
    }
    paramContext = getResources();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.c = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int m = paramContext.getDimensionPixelSize(2131427443);
    int n = paramContext.getDimensionPixelSize(2131427439);
    int i1 = paramContext.getDimensionPixelSize(2131427436);
    float f1 = this.c;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - n - 12.0F * f1 - i1 * 2 - m * 2);
    this.jdField_a_of_type_Int = 4;
    for (m = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.c); (m > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_Int >= 1); m = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.c)) {
      this.jdField_a_of_type_Int -= 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout|mMaxGameLogoNum = " + this.jdField_a_of_type_Int);
    }
  }
  
  private void a(String paramString, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_Long));
        ProfileCardTemplate.a(paramTextView1, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemTitleColor");
        ProfileCardTemplate.a(paramTextView2, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemContentColor");
        ProfileCardTemplate.a(paramImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemMoreSrc");
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(0));
      if (paramTextView1 != null) {
        paramTextView1.setTextColor(getResources().getColorStateList(2131362107));
      }
      if (paramTextView2 != null) {
        paramTextView2.setTextColor(getResources().getColorStateList(2131362080));
      }
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130837804);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateItemTheme exception msg=" + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  private boolean a()
  {
    HashMap localHashMap;
    int n;
    label40:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a != null)
    {
      m = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.size();
      localHashMap = new HashMap();
      n = 0;
      if (n >= m) {
        break label227;
      }
      localObject = (MQQName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.get(n);
      if (localObject != null) {
        break label83;
      }
    }
    for (;;)
    {
      n += 1;
      break label40;
      m = 0;
      break;
      label83:
      switch (((MQQName)localObject).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
        localHashMap.put("map_key_nick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 2: 
        localHashMap.put("map_key_circlenick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 1: 
        localHashMap.put("map_key_troopnick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 5: 
        localHashMap.put("map_key_recommendname", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 4: 
        localHashMap.put("map_key_remark", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 3: 
        localHashMap.put("map_key_phone_", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    label227:
    int m = 0;
    boolean bool = false;
    if (m < this.jdField_b_of_type_ArrayOfJavaLangString.length)
    {
      localObject = (String)localHashMap.get(this.jdField_b_of_type_ArrayOfJavaLangString[m]);
      if ((a(this.jdField_b_of_type_ArrayOfJavaLangString[m], (String)localObject)) || (bool)) {}
      for (bool = true;; bool = false)
      {
        m += 1;
        break;
      }
    }
    return bool;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2;
    if (paramInt != 0)
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qrcode") != null) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        return bool2;
      }
    }
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qrcode");
    if (localObject1 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903607, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qrcode", localObject1);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131230941);
      ((TextView)localObject2).setText(2131562693);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131231507);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130839004, 0, 0, 0);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131232623);
      localImageView.setVisibility(0);
      localImageView.setVisibility(8);
      ((View)localObject1).setTag(new DataTag(13, null));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setContentDescription(a(2131562693));
      a("map_key_qrcode", (TextView)localObject2, null, localImageView);
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
        break;
      }
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap == null) {
        break;
      }
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap.size() <= 0) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap.get("qrCodeSrc");
      bool2 = bool1;
      if (localObject1 == null) {
        break;
      }
      bool2 = bool1;
      if (!(localObject1 instanceof Drawable)) {
        break;
      }
      localObject1 = (Drawable)localObject1;
      localObject2 = getResources().getDrawable(2130839004);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return bool1;
    }
  }
  
  private boolean a(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_diamond") != null) {}
    for (int m = 1;; m = 0) {
      return 0x0 | m;
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.isShowPhoto()) || (!paramCard.hasGotPhotoUrl()))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone_photo") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_photo");
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903609, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_photo", localObject);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      String str1 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      List localList = paramCard.getQZonePhotoList();
      int m = 0;
      if (m < 3)
      {
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131233055 + m);
        if ((localList != null) && (localList.size() > m))
        {
          paramCard = (String)localList.get(m);
          label172:
          if ((!TextUtils.isEmpty(paramCard)) || (localImageView == null)) {
            break label203;
          }
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          m += 1;
          break;
          paramCard = null;
          break label172;
          label203:
          if (localImageView != null)
          {
            String str2 = AppConstants.bk + str1 + "_" + MD5.toMD5(paramCard);
            if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131361847));
            }
            try
            {
              paramCard = URLDrawable.getDrawable(new URL("profile_img_icon", paramCard, str2), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
              localImageView.setVisibility(0);
              localImageView.setImageDrawable(paramCard);
            }
            catch (MalformedURLException paramCard)
            {
              localImageView.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
              QLog.e("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
            }
          }
        }
      }
      ((View)localObject).setTag(new DataTag(6, null));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setContentDescription(a(2131558420));
      paramCard = (TextView)((View)localObject).findViewById(2131233052);
      localObject = (ImageView)((View)localObject).findViewById(2131233053);
      a("map_key_qzone_photo", paramCard, null, (ImageView)localObject);
      ((ImageView)localObject).setVisibility(8);
      return paramBoolean;
    }
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.a(), RichStatus.a().a())))) {
      return (View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sig");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903610, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131230941);
      TextView localTextView2 = (TextView)localView.findViewById(2131231507);
      ImageView localImageView = (ImageView)localView.findViewById(2131232623);
      localTextView1.setText(2131561478);
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      Resources localResources = getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ProfileCardUtil.a(localResources, localView, localStatusManager, paramRichStatus, bool2);
        if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.c))) {
          break label312;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
        label220:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
          break label320;
        }
        localImageView.setVisibility(0);
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localImageView.setVisibility(8);
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        a("map_key_sig", localTextView1, localTextView2, localImageView);
        return bool1;
        bool2 = false;
        break;
        label312:
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        break label220;
        label320:
        localImageView.setVisibility(8);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {}
    while (("map_key_circlenick".equals(paramString)) || ("map_key_remark".equals(paramString)) || ("map_key_recommendname".equals(paramString)) || ("map_key_troopnick".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!a(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1) != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903607, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131230941);
      localTextView1.setText(a(paramString1));
      TextView localTextView2 = (TextView)localView.findViewById(2131231507);
      localTextView2.setText(paramString2);
      localView.setTag(new DataTag(11, paramString2));
      localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      ImageView localImageView = (ImageView)localView.findViewById(2131232623);
      if (localImageView.getVisibility() != 4) {
        localImageView.setVisibility(4);
      }
      localImageView.setVisibility(8);
      localView.setContentDescription(a(paramString1) + a(2131558413) + paramString2);
      a(paramString1, localTextView1, localTextView2, localImageView);
      return bool;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if ((ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      label40:
      Object localObject;
      View localView;
      ProfileActivity.CardContactInfo localCardContactInfo;
      if (paramArrayList != null)
      {
        m = paramArrayList.size();
        n = 0;
        bool = false;
        if (n >= m) {
          break label177;
        }
        localObject = "map_key_phone_" + String.valueOf(n);
        localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        localCardContactInfo = (ProfileActivity.CardContactInfo)paramArrayList.get(n);
        if (localCardContactInfo != null) {
          break label143;
        }
        localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        if ((!bool) && (localObject == null)) {
          break label137;
        }
        bool = true;
      }
      for (;;)
      {
        n += 1;
        break label40;
        m = 0;
        break;
        label137:
        bool = false;
        continue;
        label143:
        localView = a(this.jdField_a_of_type_AndroidViewLayoutInflater, localView, localCardContactInfo, (String)localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localView);
        bool = true;
      }
      label177:
      int n = m;
      if (n < this.jdField_b_of_type_Int)
      {
        paramArrayList = "map_key_phone_" + String.valueOf(n);
        paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
        if ((bool) || (paramArrayList != null)) {}
        for (bool = true;; bool = false)
        {
          n += 1;
          break;
        }
      }
      this.jdField_b_of_type_Int = m;
      return bool;
    }
    int m = 0;
    boolean bool = false;
    if (m < this.jdField_b_of_type_Int)
    {
      paramArrayList = "map_key_phone_" + String.valueOf(m);
      paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
      if ((bool) || (paramArrayList != null)) {}
      for (bool = true;; bool = false)
      {
        m += 1;
        break;
      }
    }
    this.jdField_b_of_type_Int = 0;
    return bool;
  }
  
  private boolean b(Card paramCard)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if (paramCard != null)
    {
      bool5 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool6 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      if ((paramCard.lUserFlag & 1L) == 1L)
      {
        bool1 = true;
        if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label255;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        bool2 = bool1;
        bool3 = bool6;
        bool4 = bool5;
        localObject1 = localObject2;
        if (!bool1) {
          break label1068;
        }
        bool2 = bool1;
        bool3 = bool6;
        bool4 = bool5;
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramCard.strShowName)) {
          break label1068;
        }
        localObject1 = paramCard.strShowName;
        bool4 = bool5;
        bool3 = bool6;
      }
    }
    for (;;)
    {
      label138:
      Object localObject3;
      long l1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        localObject3 = ((StringBuilder)localObject2).append("makeOrFrefreshAccountInfoView").append(", strShowName = ").append((String)localObject1).append(", bEnterprise = ").append(bool1).append(", lUserFlag = ");
        if (paramCard == null)
        {
          l1 = 0L;
          label198:
          ((StringBuilder)localObject3).append(l1);
          QLog.i("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label319;
        }
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_info") == null) {
          break label313;
        }
      }
      label313:
      for (int m = 1;; m = 0)
      {
        return 0x0 | m;
        bool1 = false;
        break;
        label255:
        if ((!bool6) && (!bool5))
        {
          bool2 = bool1;
          bool3 = bool6;
          bool4 = bool5;
          localObject1 = localObject2;
          if (paramCard.iQQLevel <= 0) {
            break label1068;
          }
        }
        localObject1 = "********";
        bool3 = bool6;
        bool4 = bool5;
        break label138;
        l1 = paramCard.lUserFlag;
        break label198;
      }
      label319:
      localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_info");
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903611, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_info", localObject2);
        ((View)localObject2).setClickable(false);
      }
      for (bool2 = true;; bool2 = false)
      {
        localObject3 = ((View)localObject2).findViewById(2131233058);
        View localView = ((View)localObject3).findViewById(2131233060);
        TextView localTextView1 = (TextView)((View)localObject3).findViewById(2131230941);
        localTextView1.setText(2131561581);
        ImageView localImageView = (ImageView)((View)localObject3).findViewById(2131232623);
        localImageView.setVisibility(0);
        localImageView.setVisibility(8);
        TextView localTextView2 = (TextView)((View)localObject3).findViewById(2131231507);
        TextView localTextView3;
        double d1;
        if (paramCard.iQQLevel > 0)
        {
          ((TextView)localView.findViewById(2131233061)).setText(ProfileCardUtil.a(getContext(), 10, paramCard.iQQLevel, true));
          localTextView3 = (TextView)localView.findViewById(2131233062);
          d1 = paramCard.uAccelerateMultiple / 10.0D;
          if (d1 < 0.0D)
          {
            if ("".equals(localTextView3.getText()))
            {
              localTextView3.setText("");
              localTextView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            localView.setVisibility(0);
            label550:
            localView.setVisibility(8);
            a(localTextView2, bool3, bool4, (String)localObject1, paramCard);
            ((View)localObject3).setContentDescription("帐号是" + (String)localObject1);
            ((View)localObject3).setTag(new DataTag(14, localObject1));
            ((View)localObject3).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView = ((View)localObject2).findViewById(2131233063);
            localObject2 = ((View)localObject2).findViewById(2131233064);
            localTextView3 = (TextView)localView.findViewById(2131233065);
            if ((bool1) || (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (TextUtils.isEmpty(paramCard.strShowName)) || (paramCard.strShowName.equals(localObject1))) {
              break label1019;
            }
            localTextView3.setText(paramCard.strShowName);
            localView.setVisibility(0);
            localView.setTag(new DataTag(2, paramCard.strShowName));
            localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView.setContentDescription("主显帐号是" + paramCard.strShowName);
            label770:
            a("map_key_account_info", localTextView1, localTextView2, localImageView);
            a("map_key_account_info", null, localTextView3, null);
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileHeaderView)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
              break label1029;
            }
          }
        }
        label1029:
        for (m = 1;; m = 0)
        {
          if (m == 0) {
            break label1035;
          }
          ProfileCardTemplate.a((View)localObject3, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemTopBorderBackground");
          ProfileCardTemplate.a(localView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemNoneBorderBackground");
          ProfileCardTemplate.a((View)localObject2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemBorderBackground");
          return bool2;
          if (d1 <= 1.0D)
          {
            localTextView3.setText(a(2131559339));
            localTextView3.setContentDescription("未加速");
            localTextView3.setTextColor(-5855578);
            localTextView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            break;
          }
          localTextView3.setText(d1 + a(2131559340));
          localTextView3.setContentDescription("加速" + d1 + "倍");
          localTextView3.setTextColor(-28672);
          localTextView3.setCompoundDrawablePadding(5);
          localTextView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837745, 0);
          break;
          localView.setVisibility(8);
          break label550;
          label1019:
          localView.setVisibility(8);
          break label770;
        }
        label1035:
        ((View)localObject3).setBackgroundResource(2130837882);
        localView.setBackgroundResource(2130837880);
        ((View)localObject2).setBackgroundResource(2130840184);
        return bool2;
      }
      label1068:
      bool1 = bool2;
    }
  }
  
  private boolean b(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.isShowFeeds()))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone_feed") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903608, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_feed", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131230941);
      TextView localTextView2 = (TextView)localView.findViewById(2131231507);
      ImageView localImageView = (ImageView)localView.findViewById(2131232623);
      localTextView1.setText(a(2131562714));
      if (TextUtils.isEmpty(paramCard.strQzoneFeedsDesc))
      {
        paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
        if ((paramCard != null) && (paramCard.length() != 0)) {
          break label300;
        }
        paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      label300:
      for (;;)
      {
        Object localObject;
        if (paramCard != null)
        {
          localObject = paramCard;
          if (paramCard.length() != 0) {}
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        }
        localTextView2.setText((String)localObject + a(2131561458));
        for (;;)
        {
          localView.setTag(new DataTag(5, null));
          localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setContentDescription(a(2131558419));
          a("map_key_qzone_feed", localTextView1, localTextView2, localImageView);
          return paramBoolean;
          localTextView2.setText(LocaleString.r(getContext(), paramCard.strQzoneFeedsDesc));
        }
      }
    }
  }
  
  protected String a(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList = a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_Int);
    int m;
    int n;
    label80:
    View localView1;
    int i1;
    label96:
    View localView2;
    if (localList != null)
    {
      m = localList.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileHeaderView)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
        break label165;
      }
      n = 1;
      localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_info");
      i1 = 0;
      if (i1 >= m) {
        return;
      }
      localView2 = (View)localList.get(i1);
      if (n == 0) {
        break label170;
      }
      ProfileCardTemplate.a(localView2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "itemTopBorderBackground");
    }
    for (;;)
    {
      if (localView2.getVisibility() != 0) {
        localView2.setVisibility(0);
      }
      addView(localView2);
      i1 += 1;
      break label96;
      m = 0;
      break;
      label165:
      n = 0;
      break label80;
      label170:
      if (localView2 != localView1) {
        if ((i1 == 0) && (m == 1)) {
          localView2.setBackgroundResource(2130837877);
        } else if (i1 == 0) {
          localView2.setBackgroundResource(2130837882);
        } else if ((i1 > 0) && (i1 < m - 1)) {
          localView2.setBackgroundResource(2130837881);
        } else if ((i1 > 0) && (i1 == m - 1)) {
          localView2.setBackgroundResource(2130837879);
        }
      }
    }
  }
  
  public void a(Card paramCard)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if ((paramCard == null) || (localObject == null) || (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc))) {
      return;
    }
    TextView localTextView = (TextView)((View)localObject).findViewById(2131231507);
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    if (localObject != null)
    {
      paramCard = (Card)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    if (paramCard != null)
    {
      localObject = paramCard;
      if (paramCard.length() != 0) {}
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    localTextView.setText((String)localObject + a(2131561458));
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (a(paramCard, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList)) {
      a();
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(RichStatus paramRichStatus)
  {
    if (a(paramRichStatus)) {
      a();
    }
  }
  
  public void a(MQQProfileName paramMQQProfileName)
  {
    if (a()) {
      a();
    }
  }
  
  public boolean a(Card paramCard, boolean paramBoolean, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "build more info map");
    }
    boolean bool1;
    if (b(paramCard))
    {
      m = 1;
      bool1 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      if ((m == 0) && (!bool1)) {
        break label194;
      }
      m = 1;
      label59:
      bool1 = a();
      if ((m == 0) && (!bool1)) {
        break label200;
      }
      m = 1;
      label78:
      bool1 = a(paramArrayList);
      if ((m == 0) && (!bool1)) {
        break label206;
      }
      m = 1;
      label98:
      if (paramCard != null) {
        break label212;
      }
      bool1 = a(null);
      label109:
      if ((m == 0) && (!bool1)) {
        break label225;
      }
      m = 1;
      label122:
      bool1 = b(paramCard, paramBoolean);
      if ((m == 0) && (!bool1)) {
        break label231;
      }
      m = 1;
      label143:
      bool1 = a(paramCard);
      if ((m == 0) && (!bool1)) {
        break label237;
      }
    }
    label194:
    label200:
    label206:
    label212:
    label225:
    label231:
    label237:
    for (int m = 1;; m = 0)
    {
      bool1 = a(paramCard, paramBoolean);
      if (m == 0)
      {
        paramBoolean = bool2;
        if (!bool1) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
      m = 0;
      break;
      m = 0;
      break label59;
      m = 0;
      break label78;
      m = 0;
      break label98;
      bool1 = a(paramCard.getRichStatus());
      break label109;
      m = 0;
      break label122;
      m = 0;
      break label143;
    }
  }
  
  public boolean a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    for (paramProfileCardTemplate = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramProfileCardTemplate = String.valueOf(paramProfileCardTemplate.jdField_a_of_type_Long))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.jdField_b_of_type_JavaUtilHashMap.get(str)).equals(paramProfileCardTemplate));
      return false;
    }
    return true;
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    EntityManager localEntityManager;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label105;
      }
      localObject = null;
      if (localObject != null) {
        break label127;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
    for (;;)
    {
      a(((Card)localObject).getRichStatus());
      return;
      label105:
      localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label127:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */