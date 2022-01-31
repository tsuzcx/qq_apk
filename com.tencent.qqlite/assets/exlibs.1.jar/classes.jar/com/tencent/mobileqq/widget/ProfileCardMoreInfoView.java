package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
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
  private static final String e = "map_key_qzone_photo";
  private static final String f = "map_key_nick";
  private static final String g = "map_key_recommendname";
  private static final String h = "map_key_circlenick";
  private static final String i = "map_key_troopnick";
  private static final String j = "map_key_remark";
  private static final String k = "map_key_qrcode";
  private static final String l = "map_key_tag";
  private static final String m = "map_key_qqloginday";
  private static final String n = "map_key_third_part_app_entrance";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  public ProfileCardTemplate a;
  public ProfileHeaderView a;
  public RichStatus a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_tag", "map_key_account_info", "map_key_qrcode", "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_sig", "map_key_phone_", "map_key_qzone_feed", "map_key_qzone_photo", "map_key_qqloginday", "map_key_third_part_app_entrance" };
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
    int i2 = 0;
    Object localObject2 = paramTextView.getPaint();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.c;
    }
    int i3 = 0;
    localObject2 = new StringBuffer(paramString);
    float f1;
    int i1;
    if ((paramBoolean1) || (paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      f1 = ((TextPaint)localObject1).measureText(paramString);
      i2 = (int)(f1 % this.jdField_b_of_type_Float);
      if (paramBoolean1) {
        if ((paramCard != null) && (paramCard.iQQVipType == 1))
        {
          i1 = 42;
          f1 = 10 + i1;
          f1 = this.c;
          f1 = i2;
          i1 = (int)((i1 + 10) * this.c + f1);
        }
      }
    }
    for (;;)
    {
      label149:
      label176:
      label199:
      label222:
      SpannableString localSpannableString;
      label296:
      String str;
      label360:
      Drawable localDrawable;
      double d1;
      if (this.jdField_b_of_type_Float - i1 < 0.0F)
      {
        i1 = 2;
        ((StringBuffer)localObject2).append("\n");
        i3 = 1;
        if (!paramBoolean1) {
          break label654;
        }
        i2 = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
        if (i2 >= 1) {
          break label590;
        }
        i2 = 1;
        if ((paramCard == null) || (paramCard.iQQVipType != 1)) {
          break label600;
        }
        if (i3 == 0) {
          break label593;
        }
        paramCard = "S";
        ((StringBuffer)localObject2).append(paramCard);
        paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon/android/year_svip_" + i2 + ".png";
        ((StringBuffer)localObject2).append(" ");
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = getResources();
        localSpannableString = new SpannableString((CharSequence)localObject1);
        i2 = paramString.length();
        if (i2 >= ((String)localObject1).length()) {
          break label1098;
        }
        paramString = null;
        str = ((String)localObject1).substring(i2, i2 + 1);
        if ((!"S".equalsIgnoreCase(str)) || (TextUtils.isEmpty(paramCard))) {
          break label884;
        }
        paramString = getResources();
        if (!str.equals("S")) {
          break label860;
        }
        i3 = 2130838922;
        localDrawable = paramString.getDrawable(i3);
        paramString = URLDrawable.getDrawable(paramCard, localDrawable, localDrawable);
        i3 = localDrawable.getIntrinsicHeight();
        if (!str.equals("S")) {
          break label868;
        }
        d1 = 85.0D * (i3 / 27.0D);
        label410:
        paramString.setBounds(0, 0, (int)d1, i3);
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str)) && (paramString != null)) {
          localSpannableString.setSpan(new ImageSpan(paramString, 1), i2, i2 + 1, 33);
        }
        i2 += 1;
        break label296;
        i1 = 34;
        break;
        if (paramBoolean2)
        {
          if ((paramCard != null) && (paramCard.iQQVipType == 1)) {}
          for (i1 = 38;; i1 = 29)
          {
            f1 = 10 + i1;
            f1 = this.c;
            f1 = i2;
            i1 = (int)((i1 + 10) * this.c + f1);
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1107;
        }
        f1 = 33;
        f1 = this.c;
        i1 = (int)(i2 + 33 * this.c);
        break label149;
        i1 = 1;
        break label176;
        label590:
        break label199;
        label593:
        paramCard = "BS";
        break label222;
        label600:
        if (i3 != 0) {}
        for (paramCard = "s";; paramCard = "Bs")
        {
          ((StringBuffer)localObject2).append(paramCard);
          paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon/android/svip_" + i2 + ".png";
          break;
        }
        label654:
        if (paramBoolean2)
        {
          i2 = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
          if (i2 < 1)
          {
            i2 = 1;
            label677:
            if ((paramCard == null) || (paramCard.iQQVipType != 1)) {
              break label748;
            }
            if (i3 == 0) {
              break label741;
            }
          }
          label741:
          for (paramCard = "V";; paramCard = "BV")
          {
            ((StringBuffer)localObject2).append(paramCard);
            paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon/android/year_vip_" + i2 + ".png";
            break;
            break label677;
          }
          label748:
          if (i3 != 0) {}
          for (paramCard = "v";; paramCard = "Bv")
          {
            ((StringBuffer)localObject2).append(paramCard);
            paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon/android/vip_" + i2 + ".png";
            break;
          }
        }
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          if (i3 == 0) {
            break label852;
          }
        }
        label852:
        for (paramCard = "N";; paramCard = "BN")
        {
          ((StringBuffer)localObject2).append(paramCard);
          i2 = i1;
          paramCard = null;
          i1 = i2;
          break;
        }
        label860:
        i3 = 2130838919;
        break label360;
        label868:
        d1 = 67.0D * (i3 / 27.0D);
        break label410;
        label884:
        if (("V".equalsIgnoreCase(str)) && (!TextUtils.isEmpty(paramCard)))
        {
          paramString = getResources();
          if (str.equals("V"))
          {
            i3 = 2130838923;
            localDrawable = paramString.getDrawable(i3);
            paramString = URLDrawable.getDrawable(paramCard, localDrawable, localDrawable);
            i3 = localDrawable.getIntrinsicHeight();
            if (!str.equals("V")) {
              break label996;
            }
          }
          for (d1 = 76.0D * (i3 / 26.0D);; d1 = 58.0D * (i3 / 26.0D))
          {
            paramString.setBounds(0, 0, (int)d1, i3);
            break;
            i3 = 2130838920;
            break label923;
          }
        }
        label923:
        label996:
        if ("N".equals(str))
        {
          paramString = ((Resources)localObject2).getDrawable(2130838911);
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        }
        else if ("B".equals(str))
        {
          paramString = ((Resources)localObject2).getDrawable(2130838921);
          paramString.setBounds(0, 0, (int)(10.0F * this.c), paramString.getIntrinsicHeight());
        }
      }
      label1098:
      paramTextView.setText(localSpannableString);
      return i1;
      label1107:
      i1 = i2;
    }
  }
  
  private View a(LayoutInflater paramLayoutInflater, View paramView, ProfileActivity.CardContactInfo paramCardContactInfo, String paramString)
  {
    if (paramCardContactInfo == null) {
      return paramView;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = (LinearLayout)paramLayoutInflater.inflate(2130903529, null);
    }
    paramLayoutInflater = (TextView)((View)localObject).findViewById(2131296934);
    paramView = (TextView)((View)localObject).findViewById(2131296953);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131297748);
    if (localImageView.getVisibility() != 0) {
      localImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramLayoutInflater.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString);
      paramView.setText(paramCardContactInfo.c);
      ((View)localObject).setTag(new DataTag(4, paramCardContactInfo));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramCardContactInfo = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label249;
      }
      paramCardContactInfo.append(a(2131361805));
    }
    for (;;)
    {
      paramCardContactInfo.append(":").append(paramView.getText());
      ((View)localObject).setContentDescription(paramCardContactInfo.toString());
      a(paramString, paramLayoutInflater, paramView, localImageView);
      return localObject;
      paramLayoutInflater.setText(2131363876);
      paramView.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString + " " + paramCardContactInfo.c);
      break;
      label249:
      paramCardContactInfo.append(a(2131361804));
    }
  }
  
  private String a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {
      return a(2131363880);
    }
    if ("map_key_circlenick".equals(paramString)) {
      return a(2131363882);
    }
    if ("map_key_remark".equals(paramString)) {
      return a(2131363881);
    }
    if ("map_key_recommendname".equals(paramString)) {
      return a(2131363883);
    }
    if ("map_key_troopnick".equals(paramString)) {
      return a(2131363884);
    }
    return null;
  }
  
  private List a(HashMap paramHashMap, String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    int i2;
    label23:
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        break label195;
      }
      localObject = paramArrayOfString[i2];
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null) || (!"map_key_sig".equals(localObject)) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label95;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label23;
      i1 = paramArrayOfString.length;
      break;
      label95:
      if ("map_key_phone_".equals(localObject))
      {
        int i3 = 0;
        while (i3 < paramInt)
        {
          localObject = (View)paramHashMap.get("map_key_phone_" + String.valueOf(i3));
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          i3 += 1;
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
    label195:
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initCommonWidth");
    }
    paramContext = getResources();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.c = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = paramContext.getDimensionPixelSize(2131492943);
    int i2 = paramContext.getDimensionPixelSize(2131492940);
    int i3 = paramContext.getDimensionPixelSize(2131492937);
    float f1 = this.c;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i2 - 12.0F * f1 - i3 * 2 - i1 * 2);
    this.jdField_a_of_type_Int = 4;
    for (i1 = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.c); (i1 > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_Int >= 1); i1 = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.c)) {
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
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.f));
        ProfileCardTemplate.a(paramTextView1, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
        ProfileCardTemplate.a(paramTextView2, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
        ProfileCardTemplate.a(paramImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemMoreSrc");
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(0));
      if (paramTextView1 != null) {
        paramTextView1.setTextColor(getResources().getColorStateList(2131427497));
      }
      if (paramTextView2 != null) {
        paramTextView2.setTextColor(getResources().getColorStateList(2131427469));
      }
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130837733);
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
    int i2;
    label40:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.size();
      localHashMap = new HashMap();
      i2 = 0;
      if (i2 >= i1) {
        break label227;
      }
      localObject = (MQQName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.get(i2);
      if (localObject != null) {
        break label83;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label40;
      i1 = 0;
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
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_b_of_type_ArrayOfJavaLangString.length)
    {
      localObject = (String)localHashMap.get(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
      if ((a(this.jdField_b_of_type_ArrayOfJavaLangString[i1], (String)localObject)) || (bool)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
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
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903529, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qrcode", localObject1);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131296934);
      ((TextView)localObject2).setText(2131363879);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131296953);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130838823, 0, 0, 0);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131297748);
      localImageView.setVisibility(0);
      ((View)localObject1).setTag(new DataTag(13, null));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setContentDescription(a(2131363879));
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap.get("commonQrCodeSrc");
      bool2 = bool1;
      if (localObject1 == null) {
        break;
      }
      bool2 = bool1;
      if (!(localObject1 instanceof Drawable)) {
        break;
      }
      localObject1 = (Drawable)localObject1;
      localObject2 = getResources().getDrawable(2130838823);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return bool1;
    }
  }
  
  private boolean a(Card paramCard)
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
          break label1100;
        }
        bool2 = bool1;
        bool3 = bool6;
        bool4 = bool5;
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramCard.strShowName)) {
          break label1100;
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
      for (int i1 = 1;; i1 = 0)
      {
        return 0x0 | i1;
        bool1 = false;
        break;
        label255:
        if ((!bool6) && (!bool5))
        {
          bool2 = bool1;
          bool3 = bool6;
          bool4 = bool5;
          localObject1 = localObject2;
          if (paramCard.iQQLevel < 0) {
            break label1100;
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
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903533, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_info", localObject2);
        ((View)localObject2).setClickable(false);
      }
      for (bool2 = true;; bool2 = false)
      {
        Object localObject4 = ((View)localObject2).findViewById(2131298406);
        View localView = ((View)localObject4).findViewById(2131298408);
        localObject3 = (TextView)((View)localObject4).findViewById(2131296934);
        ((TextView)localObject3).setText(2131363875);
        ImageView localImageView = (ImageView)((View)localObject4).findViewById(2131297748);
        localImageView.setVisibility(0);
        TextView localTextView1 = (TextView)((View)localObject4).findViewById(2131296953);
        TextView localTextView2;
        double d1;
        if (paramCard.iQQLevel >= 0)
        {
          localTextView2 = (TextView)localView.findViewById(2131298409);
          localTextView2.setText(ProfileCardUtil.a(getContext(), 8, paramCard.iQQLevel, true));
          localTextView2.setContentDescription(paramCard.iQQLevel + "级");
          localTextView2 = (TextView)localView.findViewById(2131298410);
          d1 = paramCard.uAccelerateMultiple / 10.0D;
          if (d1 < 0.0D)
          {
            if ("".equals(localTextView2.getText()))
            {
              localTextView2.setText("");
              localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            localView.setVisibility(0);
            label578:
            a(localTextView1, bool3, bool4, (String)localObject1, paramCard);
            ((View)localObject4).setContentDescription("帐号:" + (String)localObject1);
            ((View)localObject4).setTag(new DataTag(14, localObject1));
            ((View)localObject4).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((View)localObject4).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            localObject2 = ((View)localObject2).findViewById(2131298411);
            localObject4 = (TextView)((View)localObject2).findViewById(2131298413);
            if ((bool1) || (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (TextUtils.isEmpty(paramCard.strShowName)) || (paramCard.strShowName.equals(localObject1))) {
              break label1084;
            }
            ((TextView)localObject4).setText(paramCard.strShowName);
            ((View)localObject2).setVisibility(0);
            ((View)localObject2).setTag(new DataTag(2, paramCard.strShowName));
            ((View)localObject2).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((View)localObject2).setContentDescription("主显帐号:" + paramCard.strShowName);
          }
        }
        for (;;)
        {
          a("map_key_account_info", (TextView)localObject3, localTextView1, localImageView);
          a("map_key_account_info", null, (TextView)localObject4, null);
          return bool2;
          if ((!bool4) && (!bool3))
          {
            localTextView2.setText("慢速中");
            localTextView2.setTextColor(-5855578);
            localTextView2.setContentDescription("慢速中");
            break;
          }
          if ((bool4) && (!bool3))
          {
            localTextView2.setText(d1 + "倍加速中");
            localTextView2.setTextColor(-28672);
            localTextView2.setContentDescription("加速" + d1 + "倍");
            break;
          }
          if (!bool3) {
            break;
          }
          if (paramCard.getVipType(EVIPSPEC.E_SP_SUPERVIP) == 1)
          {
            localTextView2.setText(d1 + "倍极速中");
            localTextView2.setContentDescription("极速" + d1 + "倍");
          }
          for (;;)
          {
            localTextView2.setTextColor(-28672);
            break;
            localTextView2.setText(d1 + "倍高速中");
            localTextView2.setContentDescription("高速" + d1 + "倍");
          }
          localView.setVisibility(8);
          break label578;
          label1084:
          ((View)localObject2).setVisibility(8);
        }
      }
      label1100:
      bool1 = bool2;
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
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_photo");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903531, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_photo", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      String str1 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      List localList = paramCard.getQZonePhotoList();
      int i1 = 0;
      if (i1 < 3)
      {
        ImageView localImageView = (ImageView)localView.findViewById(2131298403 + i1);
        if ((localList != null) && (localList.size() > i1))
        {
          paramCard = (String)localList.get(i1);
          label172:
          if ((!TextUtils.isEmpty(paramCard)) || (localImageView == null)) {
            break label203;
          }
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          i1 += 1;
          break;
          paramCard = null;
          break label172;
          label203:
          if (localImageView != null)
          {
            String str2 = AppConstants.bp + str1 + "_" + MD5.toMD5(paramCard);
            if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131427373));
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
      localView.setTag(new DataTag(6, null));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setContentDescription(a(2131361803));
      a("map_key_qzone_photo", (TextView)localView.findViewById(2131298400), null, (ImageView)localView.findViewById(2131298401));
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903532, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131296934);
      TextView localTextView2 = (TextView)localView.findViewById(2131296953);
      ImageView localImageView = (ImageView)localView.findViewById(2131297748);
      localTextView1.setText(2131363874);
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      Resources localResources = getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ProfileCardUtil.a(localResources, localView, localStatusManager, paramRichStatus, bool2);
        if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.c))) {
          break label308;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
        label223:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
          break label316;
        }
        localImageView.setVisibility(0);
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        a("map_key_sig", localTextView1, localTextView2, localImageView);
        return bool1;
        bool2 = false;
        break;
        label308:
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        break label223;
        label316:
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903529, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131296934);
      localTextView1.setText(a(paramString1));
      TextView localTextView2 = (TextView)localView.findViewById(2131296953);
      localTextView2.setText(paramString2);
      localView.setTag(new DataTag(11, paramString2));
      localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      ImageView localImageView = (ImageView)localView.findViewById(2131297748);
      if (localImageView.getVisibility() != 4) {
        localImageView.setVisibility(4);
      }
      localView.setContentDescription(a(paramString1) + ":" + paramString2);
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
        i1 = paramArrayList.size();
        i2 = 0;
        bool = false;
        if (i2 >= i1) {
          break label177;
        }
        localObject = "map_key_phone_" + String.valueOf(i2);
        localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        localCardContactInfo = (ProfileActivity.CardContactInfo)paramArrayList.get(i2);
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
        i2 += 1;
        break label40;
        i1 = 0;
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
      int i2 = i1;
      if (i2 < this.jdField_b_of_type_Int)
      {
        paramArrayList = "map_key_phone_" + String.valueOf(i2);
        paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
        if ((bool) || (paramArrayList != null)) {}
        for (bool = true;; bool = false)
        {
          i2 += 1;
          break;
        }
      }
      this.jdField_b_of_type_Int = i1;
      return bool;
    }
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_b_of_type_Int)
    {
      paramArrayList = "map_key_phone_" + String.valueOf(i1);
      paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
      if ((bool) || (paramArrayList != null)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
        break;
      }
    }
    this.jdField_b_of_type_Int = 0;
    return bool;
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903530, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_feed", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131296934);
      TextView localTextView2 = (TextView)localView.findViewById(2131296953);
      ImageView localImageView = (ImageView)localView.findViewById(2131297748);
      localTextView1.setText(a(2131363877));
      if (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)) {
        localTextView2.setText(paramCard.strQzoneFeedsDesc);
      }
      for (;;)
      {
        localView.setTag(new DataTag(5, null));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setContentDescription(a(2131361802));
        a("map_key_qzone_feed", localTextView1, localTextView2, localImageView);
        return paramBoolean;
        if (TextUtils.isEmpty(paramCard.strSpaceName)) {
          break;
        }
        localTextView2.setText(paramCard.strSpaceName);
      }
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      if ((paramCard == null) || (paramCard.length() == 0)) {
        paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
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
        localTextView2.setText((String)localObject + a(2131363903));
        break;
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
    int i1;
    int i2;
    label80:
    View localView;
    int i3;
    label96:
    Object localObject;
    if (localList != null)
    {
      i1 = localList.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileHeaderView)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
        break label172;
      }
      i2 = 1;
      localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_info");
      i3 = 0;
      if (i3 >= i1) {
        return;
      }
      localObject = (View)localList.get(i3);
      if (i2 == 0) {
        break label177;
      }
      ProfileCardTemplate.a((View)localObject, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
      label133:
      if (((View)localObject).getVisibility() != 0) {
        ((View)localObject).setVisibility(0);
      }
      addView((View)localObject);
      if (i3 != i1 - 1) {
        break label195;
      }
    }
    for (;;)
    {
      i3 += 1;
      break label96;
      i1 = 0;
      break;
      label172:
      i2 = 0;
      break label80;
      label177:
      if (localObject == localView) {
        break label133;
      }
      ((View)localObject).setBackgroundResource(2130837914);
      break label133;
      label195:
      localObject = new ImageView(getContext());
      ((ImageView)localObject).setBackgroundResource(2130838010);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
      localLayoutParams.setMargins((int)this.c * 14, 0, (int)this.c * 14, 0);
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      addView((View)localObject);
    }
  }
  
  public void a(Card paramCard)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if ((paramCard == null) || (localObject == null) || (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)) || (!TextUtils.isEmpty(paramCard.strSpaceName))) {
      return;
    }
    TextView localTextView = (TextView)((View)localObject).findViewById(2131296953);
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
    localTextView.setText((String)localObject + a(2131363903));
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
    if (a(paramCard))
    {
      i1 = 1;
      bool1 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      if ((i1 == 0) && (!bool1)) {
        break label187;
      }
      i1 = 1;
      label59:
      bool1 = a();
      if ((i1 == 0) && (!bool1)) {
        break label193;
      }
      i1 = 1;
      label78:
      bool1 = a(paramArrayList);
      if ((i1 == 0) && (!bool1)) {
        break label199;
      }
      i1 = 1;
      label98:
      if (paramCard != null) {
        break label205;
      }
      bool1 = a(null);
      label109:
      if ((i1 == 0) && (!bool1)) {
        break label218;
      }
      i1 = 1;
      label122:
      bool1 = b(paramCard, paramBoolean);
      if ((i1 == 0) && (!bool1)) {
        break label224;
      }
      i1 = 1;
      label143:
      bool1 = a(paramCard, paramBoolean);
      if ((i1 == 0) && (!bool1)) {
        break label230;
      }
    }
    label187:
    label193:
    label199:
    label205:
    label218:
    label224:
    label230:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        paramBoolean = bool2;
        if (!bool1) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
      i1 = 0;
      break;
      i1 = 0;
      break label59;
      i1 = 0;
      break label78;
      i1 = 0;
      break label98;
      bool1 = a(paramCard.getRichStatus());
      break label109;
      i1 = 0;
      break label122;
      i1 = 0;
      break label143;
    }
  }
  
  public boolean a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    for (paramProfileCardTemplate = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramProfileCardTemplate = String.valueOf(paramProfileCardTemplate.f))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */