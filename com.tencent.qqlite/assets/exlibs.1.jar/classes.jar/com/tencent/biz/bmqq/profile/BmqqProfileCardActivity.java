package com.tencent.biz.bmqq.profile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kq;
import kr;
import ks;
import kt;
import ku;
import kv;
import kx;
import ky;
import la;
import lc;
import ld;

public class BmqqProfileCardActivity
  extends ProfileActivity
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "message/rfc822";
  private static final int jdField_b_of_type_Int = 1;
  private static final int bE = 29;
  private static final int bF = 30;
  private static final int bG = 32;
  private static final int bH = 1;
  private static final int bI = 4;
  private static final int bJ = 6;
  private static final int bK = 0;
  private static final int bL = 1;
  private static final int bM = 2;
  private static final int bN = 2;
  private static final int bO = 3;
  private static final int bP = 4;
  private static final int bQ = 0;
  private static final int bR = 1;
  private static final int bS = 2;
  private static final int bT = 3;
  private static final int bU = 4;
  private static final int bV = 5;
  private static final int bW = 6;
  private static final int bX = 7;
  private static final int bY = 8;
  private static final int bZ = 0;
  private static final int jdField_c_of_type_Int = 2;
  private static final int ca = 1;
  private static final int cb = 2;
  private static final int cc = 3;
  private static final int cd = 4;
  private static final int jdField_d_of_type_Int = 7;
  private static final int jdField_e_of_type_Int = 8;
  private static final int jdField_f_of_type_Int = 13;
  private static final int jdField_g_of_type_Int = 16;
  private long jdField_a_of_type_Long = 0L;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new lc(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  public TextView a;
  private BmqqBusinessObserver jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver = new kq(this);
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kt(this);
  public BmqqUserSimpleInfo a;
  private MQQProfileName jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new ld(this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean = true;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[7];
  public RelativeLayout b;
  public TextView b;
  private ActionSheet.OnButtonClickListener jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new kr(this);
  private boolean jdField_b_of_type_Boolean = false;
  public RelativeLayout c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_h_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_i_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_j_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  
  public BmqqProfileCardActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ks(this);
  }
  
  private ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Friends localFriends = ((FriendManager)this.app.getManager(8)).c(paramString);
    if ((localFriends != null) && (localFriends.remark != null)) {}
    for (paramString = localFriends.remark;; paramString = null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (localFriends != null) {
          str = localFriends.name;
        }
      }
      return str;
    }
  }
  
  private void a(int paramInt)
  {
    int k = 0;
    int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramInt == 0) {
        k = 8;
      }
      ((LinearLayout)localObject).setVisibility(k);
      while (paramInt < m)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        paramInt += 1;
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 29, 2131363885, 2130838756, 2131361812);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131363884, 2130838753, 2131361810);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 32, 2131363080, 2130838759, 2131361811);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131363884, 2130838753, 2131361810);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 32, 2131363080, 2130838759, 2131361811);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 32, 2131363080, 2130838759, 2131361811);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131363884, 2130838753, 2131361810);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131363884, 2130838753, 2131361810);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 32, 2131363080, 2130838759, 2131361811);
      paramInt = 1;
      continue;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TextView localTextView;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      localTextView = (TextView)paramView.findViewById(2131298339);
      localTextView.setText(paramInt2);
      localTextView.setContentDescription(getString(paramInt4));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      if ((!a(paramInt1)) || (this.jdField_a_of_type_Boolean)) {
        break label135;
      }
      localTextView.setTextColor(getResources().getColor(2131427493));
    }
    for (;;)
    {
      localTextView.setEnabled(this.jdField_a_of_type_Boolean);
      try
      {
        paramView.setBackgroundResource(2130838750);
        localTextView.setTextColor(getResources().getColorStateList(2131427491));
        return;
      }
      catch (Exception paramView)
      {
        label135:
        paramView.printStackTrace();
      }
      localTextView.setTextColor(getResources().getColor(2131427491));
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    int k = getResources().getColor(2131427446);
    View localView = View.inflate(this, 2130903517, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this);
    localView.setBackgroundColor(k);
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
    localView = View.inflate(this, 2130903517, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this);
    localView.setBackgroundColor(k);
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
    localView = View.inflate(this, 2130903517, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(localView, localLayoutParams);
  }
  
  private void a(Card paramCard, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
    k();
    m();
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ky(this));
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", BmqqProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("cSpecialFlag", getIntent().getExtras().getInt("cSpecialFlag"));
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 0) {
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString[4];
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
    }
    String str = this.jdField_a_of_type_ArrayOfJavaLangString[1];
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      localIntent.putExtra("uinname", paramString);
      localIntent.addFlags(67108864);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
        break label559;
      }
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      }
      if (paramInt == 1001)
      {
        localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "accost_sig = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
      }
      paramString = (FriendManager)this.app.getManager(8);
      if (paramString != null)
      {
        paramString = paramString.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (paramString.cSpecialFlag == 1))
        {
          localIntent.setClass(getActivity(), ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 101)) {
        break label591;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      startActivityForResult(localIntent, 1010);
      return;
      if (((paramInt == 1000) || (paramInt == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      paramString = this.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramString = this.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
      }
      localIntent.putExtra("uinname", (String)localObject);
      break;
      label559:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
      }
    }
    label591:
    startActivity(localIntent);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 31: 
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt > 6)) {
      return false;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getStringArray(2131230735)[0], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getStringArray(2131230735)[1], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getResources().getStringArray(2131230735)[2]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getStringArray(2131230736)[0], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getResources().getStringArray(2131230736)[1]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    }
  }
  
  private String c()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.app, d());
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.app.getAccount())) {
      finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if (!c()) {
      finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.endsWith("0"))) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      if (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, "qq_error|" + localException.toString());
      }
      finish();
    }
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
    }
  }
  
  private boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int + ", entry = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g);
        }
      }
      for (;;)
      {
        return true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  private String d()
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).c;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  private void d()
  {
    o();
    e();
    f();
  }
  
  private void d(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    if ((paramString != null) && (paramString.length() > 0))
    {
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString });
      localIntent.setType("message/rfc822");
      Intent.createChooser(localIntent, getResources().getString(2131361792));
    }
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(getActivity(), 2131361793, 0).show();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296604));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e(String paramString)
  {
    int k = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(4, paramString);
    q();
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      if (k == 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName);
      }
      else
      {
        k = 0;
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131296601));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.jdField_f_of_type_Int = 1;
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296605));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296606));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296607));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131296609));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131296621));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(8));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296610));
    this.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131296612));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131296621));
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(7));
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296613));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296615));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_i_of_type_AndroidWidgetRelativeLayout.findViewById(2131296621));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(13));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296616));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131296618));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131296621));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(16));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296619));
    this.jdField_j_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidWidgetRelativeLayout.findViewById(2131296620));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidWidgetRelativeLayout.findViewById(2131296624));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296602));
  }
  
  private void g()
  {
    j();
    m();
  }
  
  private void h()
  {
    addObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void i()
  {
    removeObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void j()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    if (localEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  private void k()
  {
    ((BmqqBusinessHandler)this.app.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  private void l()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void m()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    n();
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean == true) || (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundColor(5731309);
      this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      return;
    }
    int k;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString);
      k = 1;
    }
    for (;;)
    {
      if (k == 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle))
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundResource(2130837643);
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle);
      }
      int[] arrayOfInt;
      for (;;)
      {
        arrayOfInt = new int[4];
        k = 0;
        while (k < 4)
        {
          arrayOfInt[k] = 0;
          k += 1;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName)) {
          break label817;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName);
        k = 1;
        break;
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundColor(5731309);
        this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum))
      {
        arrayOfInt[0] = 1;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum);
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone))
        {
          arrayOfInt[1] = 1;
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone);
        }
        for (int i2 = 1;; i2 = 0)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail))
          {
            arrayOfInt[2] = 1;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnPreDrawListener(new ku(this));
          }
          for (int i3 = 1;; i3 = 0)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany))
            {
              arrayOfInt[3] = 1;
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany);
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnPreDrawListener(new kv(this));
            }
            for (int i4 = 1;; i4 = 0)
            {
              int m = -1;
              int i5 = -1;
              k = 0;
              while (k < 4)
              {
                int i7 = i5;
                int i6 = m;
                if (arrayOfInt[k] == 1)
                {
                  int n = m;
                  if (m < 0) {
                    n = k;
                  }
                  i7 = i5;
                  i6 = n;
                  if (i5 < k)
                  {
                    i7 = k;
                    i6 = n;
                  }
                }
                k += 1;
                i5 = i7;
                m = i6;
              }
              if (i5 == 0)
              {
                this.jdField_g_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837650);
                if (i5 != 1) {
                  break label754;
                }
                this.jdField_h_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837650);
                label666:
                if (i5 != 2) {
                  break label767;
                }
                this.jdField_i_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837650);
                label682:
                if (i5 != 3) {
                  break label780;
                }
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837650);
              }
              for (;;)
              {
                if ((i1 != 0) || (i2 != 0) || (i3 != 0) || (i4 != 0)) {
                  break label791;
                }
                this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                return;
                this.jdField_g_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837651);
                break;
                label754:
                this.jdField_h_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837651);
                break label666;
                label767:
                this.jdField_i_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837651);
                break label682;
                label780:
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837651);
              }
              label791:
              break;
            }
          }
        }
      }
      label817:
      k = 0;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      a(1);
      return;
    }
    boolean bool1 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool2 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((bool1) && (bool2) && (bool3))
    {
      a(2);
      return;
    }
    if ((bool1) && (bool2))
    {
      a(3);
      return;
    }
    if ((bool2) && (bool3))
    {
      a(4);
      return;
    }
    if ((bool1) && (bool3))
    {
      a(5);
      return;
    }
    if (bool1)
    {
      a(6);
      return;
    }
    if (bool2)
    {
      a(7);
      return;
    }
    if (bool3)
    {
      a(5);
      return;
    }
    a(0);
  }
  
  private void o()
  {
    int m = 1;
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296598));
    label75:
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131363862);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296599));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 6) {
        break label175;
      }
      a();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new kx(this));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296600));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label192;
      }
      k = 0;
    }
    for (;;)
    {
      if (k == 0) {
        break label513;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(0));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(this.jdField_a_of_type_Boolean);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131363861);
      break;
      label175:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131363113));
      break label75;
      label192:
      k = m;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70)
      {
        k = m;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          k = m;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 21)
          {
            k = m;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 58)
            {
              k = m;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22)
              {
                k = m;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 46)
                {
                  k = m;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 47)
                  {
                    k = m;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41)
                    {
                      k = m;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 42)
                      {
                        k = m;
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
                        {
                          k = m;
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)
                          {
                            if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
                            {
                              if (TextUtils.isEmpty(c())) {}
                              for (k = 0;; k = 1) {
                                break;
                              }
                            }
                            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
                            {
                              k = 0;
                            }
                            else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
                            {
                              k = m;
                              if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int == 0) {
                                k = 0;
                              }
                            }
                            else
                            {
                              k = m;
                              if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 2)
                              {
                                k = m;
                                if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 74)
                                {
                                  k = m;
                                  if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
                                    k = 0;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label513:
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  /* Error */
  private void p()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 10
    //   6: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +13 -> 22
    //   12: ldc_w 341
    //   15: iconst_2
    //   16: ldc_w 884
    //   19: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   26: getfield 507	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:h	Ljava/lang/String;
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   35: getfield 440	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   43: getfield 442	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   46: astore 4
    //   48: aload_0
    //   49: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   52: getfield 886	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	Ljava/lang/String;
    //   55: astore 11
    //   57: aload_0
    //   58: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   61: getfield 888	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   64: astore 12
    //   66: aload_0
    //   67: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   70: getfield 890	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:k	Ljava/lang/String;
    //   73: astore 9
    //   75: aload_0
    //   76: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   79: getfield 892	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   82: astore 13
    //   84: aload 5
    //   86: astore 6
    //   88: aload 5
    //   90: astore 7
    //   92: aload_0
    //   93: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   96: invokestatic 873	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   99: ifeq +453 -> 552
    //   102: aload 5
    //   104: astore 6
    //   106: aload 5
    //   108: astore 7
    //   110: aload_0
    //   111: getfield 167	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: bipush 8
    //   116: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   119: checkcast 175	com/tencent/mobileqq/model/FriendManager
    //   122: astore_3
    //   123: aload_3
    //   124: ifnonnull +402 -> 526
    //   127: aload 5
    //   129: astore 8
    //   131: aload 10
    //   133: ifnull +740 -> 873
    //   136: aload 5
    //   138: astore_3
    //   139: aload 5
    //   141: astore 6
    //   143: aload 5
    //   145: astore 7
    //   147: aload 10
    //   149: getfield 186	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   152: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +17 -> 172
    //   158: aload 5
    //   160: astore 6
    //   162: aload 5
    //   164: astore 7
    //   166: aload 10
    //   168: getfield 186	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   171: astore_3
    //   172: aload_3
    //   173: astore 6
    //   175: aload_3
    //   176: astore 7
    //   178: aload_3
    //   179: astore 8
    //   181: aload 10
    //   183: getfield 183	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   186: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +684 -> 873
    //   192: aload_3
    //   193: astore 6
    //   195: aload_3
    //   196: astore 7
    //   198: aload 10
    //   200: getfield 183	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   203: astore 5
    //   205: aload_3
    //   206: astore_2
    //   207: aload 5
    //   209: astore_3
    //   210: aload_0
    //   211: getfield 167	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: bipush 8
    //   216: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   219: checkcast 894	com/tencent/mobileqq/app/FriendsManagerImp
    //   222: astore 7
    //   224: aload_0
    //   225: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   228: getfield 455	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:c	Ljava/lang/String;
    //   231: astore 6
    //   233: aload 6
    //   235: astore 5
    //   237: aload 6
    //   239: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifeq +43 -> 285
    //   245: aload 6
    //   247: astore 5
    //   249: aload_0
    //   250: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   253: getfield 451	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   256: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   259: ifne +26 -> 285
    //   262: aload 6
    //   264: astore 5
    //   266: aload 7
    //   268: ifnull +17 -> 285
    //   271: aload 7
    //   273: aload_0
    //   274: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   277: getfield 451	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   280: invokevirtual 896	com/tencent/mobileqq/app/FriendsManagerImp:f	(Ljava/lang/String;)Ljava/lang/String;
    //   283: astore 5
    //   285: aload 5
    //   287: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifne +569 -> 859
    //   293: aload 7
    //   295: ifnull +564 -> 859
    //   298: aload 7
    //   300: aload 5
    //   302: aload_0
    //   303: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   306: getfield 365	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   309: invokevirtual 899	com/tencent/mobileqq/app/FriendsManagerImp:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   312: astore 5
    //   314: aload 5
    //   316: astore 4
    //   318: aload 9
    //   320: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +529 -> 852
    //   326: aload_0
    //   327: invokespecial 631	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:a	()Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   330: astore 5
    //   332: aload 5
    //   334: ifnull +518 -> 852
    //   337: aload 5
    //   339: getfield 900	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   342: astore 5
    //   344: aload 4
    //   346: astore 8
    //   348: aload 5
    //   350: astore 10
    //   352: aload_2
    //   353: astore 4
    //   355: aload_3
    //   356: astore 5
    //   358: aload_0
    //   359: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   362: iconst_0
    //   363: aload 4
    //   365: aastore
    //   366: aload_0
    //   367: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   370: iconst_4
    //   371: aload 5
    //   373: aastore
    //   374: aload_0
    //   375: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   378: iconst_3
    //   379: aload 10
    //   381: aastore
    //   382: aload_0
    //   383: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   386: iconst_2
    //   387: aload 12
    //   389: aastore
    //   390: aload_0
    //   391: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   394: iconst_5
    //   395: aload 11
    //   397: aastore
    //   398: aload_0
    //   399: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   402: iconst_1
    //   403: aload 8
    //   405: aastore
    //   406: aload_0
    //   407: getfield 86	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   410: bipush 6
    //   412: aload 13
    //   414: aastore
    //   415: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +107 -> 525
    //   421: new 343	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   428: astore_2
    //   429: aload_2
    //   430: ldc_w 902
    //   433: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 904
    //   439: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 4
    //   444: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 906
    //   450: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 5
    //   455: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 908
    //   461: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 10
    //   466: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc_w 910
    //   472: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 12
    //   477: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc_w 912
    //   483: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 11
    //   488: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 914
    //   494: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 8
    //   499: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 916
    //   505: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 11
    //   510: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc_w 341
    //   517: iconst_2
    //   518: aload_2
    //   519: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 361	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: return
    //   526: aload 5
    //   528: astore 6
    //   530: aload 5
    //   532: astore 7
    //   534: aload_3
    //   535: aload_0
    //   536: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   539: getfield 365	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   542: invokeinterface 178 2 0
    //   547: astore 10
    //   549: goto -422 -> 127
    //   552: aload 5
    //   554: astore 6
    //   556: aload 5
    //   558: astore 7
    //   560: aload_0
    //   561: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   564: getfield 363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   567: ifne +35 -> 602
    //   570: aload 5
    //   572: astore 6
    //   574: aload 5
    //   576: astore 7
    //   578: aload_0
    //   579: getfield 167	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   582: aload_0
    //   583: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   586: getfield 365	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   589: invokestatic 918	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   592: astore 5
    //   594: aload_2
    //   595: astore_3
    //   596: aload 5
    //   598: astore_2
    //   599: goto -389 -> 210
    //   602: aload 5
    //   604: astore 6
    //   606: aload 5
    //   608: astore 7
    //   610: aload 5
    //   612: astore_3
    //   613: aload 5
    //   615: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   618: ifeq +244 -> 862
    //   621: aload 5
    //   623: astore 6
    //   625: aload 5
    //   627: astore 7
    //   629: aload 5
    //   631: astore_3
    //   632: aload_0
    //   633: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   636: invokestatic 610	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   639: ifeq +223 -> 862
    //   642: aload 5
    //   644: astore 6
    //   646: aload 5
    //   648: astore 7
    //   650: aload_0
    //   651: getfield 167	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   654: aload_0
    //   655: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   658: getfield 365	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   661: iconst_0
    //   662: invokestatic 921	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   665: astore_3
    //   666: aload_3
    //   667: astore 6
    //   669: aload_3
    //   670: astore 7
    //   672: aload_3
    //   673: aload_0
    //   674: getfield 131	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   677: getfield 365	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   680: invokestatic 926	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   683: istore_1
    //   684: iload_1
    //   685: ifeq +177 -> 862
    //   688: aload_2
    //   689: astore_3
    //   690: aload 8
    //   692: astore_2
    //   693: goto -483 -> 210
    //   696: astore 7
    //   698: aload_2
    //   699: astore_3
    //   700: aload 4
    //   702: astore_2
    //   703: aload_2
    //   704: astore 8
    //   706: aload_3
    //   707: astore 5
    //   709: aload 6
    //   711: astore 4
    //   713: aload 9
    //   715: astore 10
    //   717: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   720: ifeq -362 -> 358
    //   723: ldc_w 341
    //   726: iconst_2
    //   727: aload 7
    //   729: invokevirtual 563	java/lang/Exception:toString	()Ljava/lang/String;
    //   732: invokestatic 361	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: aload_2
    //   736: astore 8
    //   738: aload_3
    //   739: astore 5
    //   741: aload 6
    //   743: astore 4
    //   745: aload 9
    //   747: astore 10
    //   749: goto -391 -> 358
    //   752: astore 6
    //   754: aload_2
    //   755: astore_3
    //   756: aload 4
    //   758: astore_2
    //   759: aload_2
    //   760: astore 8
    //   762: aload_3
    //   763: astore 5
    //   765: aload 7
    //   767: astore 4
    //   769: aload 9
    //   771: astore 10
    //   773: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq -418 -> 358
    //   779: ldc_w 341
    //   782: iconst_2
    //   783: aload 6
    //   785: invokevirtual 927	java/lang/Error:toString	()Ljava/lang/String;
    //   788: invokestatic 361	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: aload_2
    //   792: astore 8
    //   794: aload_3
    //   795: astore 5
    //   797: aload 7
    //   799: astore 4
    //   801: aload 9
    //   803: astore 10
    //   805: goto -447 -> 358
    //   808: astore 6
    //   810: aload_2
    //   811: astore 7
    //   813: aload 4
    //   815: astore_2
    //   816: goto -57 -> 759
    //   819: astore 6
    //   821: aload_2
    //   822: astore 7
    //   824: aload 4
    //   826: astore_2
    //   827: goto -68 -> 759
    //   830: astore 7
    //   832: aload_2
    //   833: astore 6
    //   835: aload 4
    //   837: astore_2
    //   838: goto -135 -> 703
    //   841: astore 7
    //   843: aload_2
    //   844: astore 6
    //   846: aload 4
    //   848: astore_2
    //   849: goto -146 -> 703
    //   852: aload 9
    //   854: astore 5
    //   856: goto -512 -> 344
    //   859: goto -541 -> 318
    //   862: aload_3
    //   863: astore 5
    //   865: aload_2
    //   866: astore_3
    //   867: aload 5
    //   869: astore_2
    //   870: goto -660 -> 210
    //   873: aload_2
    //   874: astore_3
    //   875: aload 8
    //   877: astore_2
    //   878: goto -668 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	881	0	this	BmqqProfileCardActivity
    //   683	2	1	bool	boolean
    //   38	840	2	localObject1	Object
    //   122	753	3	localObject2	Object
    //   46	801	4	localObject3	Object
    //   29	839	5	localObject4	Object
    //   86	656	6	localObject5	Object
    //   752	32	6	localError1	java.lang.Error
    //   808	1	6	localError2	java.lang.Error
    //   819	1	6	localError3	java.lang.Error
    //   833	12	6	localObject6	Object
    //   90	581	7	localObject7	Object
    //   696	102	7	localException1	Exception
    //   811	12	7	localObject8	Object
    //   830	1	7	localException2	Exception
    //   841	1	7	localException3	Exception
    //   1	875	8	localObject9	Object
    //   73	780	9	str1	String
    //   4	800	10	localObject10	Object
    //   55	454	11	str2	String
    //   64	412	12	str3	String
    //   82	331	13	str4	String
    // Exception table:
    //   from	to	target	type
    //   92	102	696	java/lang/Exception
    //   110	123	696	java/lang/Exception
    //   147	158	696	java/lang/Exception
    //   166	172	696	java/lang/Exception
    //   181	192	696	java/lang/Exception
    //   198	205	696	java/lang/Exception
    //   534	549	696	java/lang/Exception
    //   560	570	696	java/lang/Exception
    //   578	594	696	java/lang/Exception
    //   613	621	696	java/lang/Exception
    //   632	642	696	java/lang/Exception
    //   650	666	696	java/lang/Exception
    //   672	684	696	java/lang/Exception
    //   92	102	752	java/lang/Error
    //   110	123	752	java/lang/Error
    //   147	158	752	java/lang/Error
    //   166	172	752	java/lang/Error
    //   181	192	752	java/lang/Error
    //   198	205	752	java/lang/Error
    //   534	549	752	java/lang/Error
    //   560	570	752	java/lang/Error
    //   578	594	752	java/lang/Error
    //   613	621	752	java/lang/Error
    //   632	642	752	java/lang/Error
    //   650	666	752	java/lang/Error
    //   672	684	752	java/lang/Error
    //   210	233	808	java/lang/Error
    //   237	245	808	java/lang/Error
    //   249	262	808	java/lang/Error
    //   271	285	808	java/lang/Error
    //   285	293	808	java/lang/Error
    //   298	314	808	java/lang/Error
    //   318	332	819	java/lang/Error
    //   337	344	819	java/lang/Error
    //   210	233	830	java/lang/Exception
    //   237	245	830	java/lang/Exception
    //   249	262	830	java/lang/Exception
    //   271	285	830	java/lang/Exception
    //   285	293	830	java/lang/Exception
    //   298	314	830	java/lang/Exception
    //   318	332	841	java/lang/Exception
    //   337	344	841	java/lang/Exception
  }
  
  private void q()
  {
    int i1 = 3;
    int n = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    int m = n;
    int k = i1;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 23: 
    case 24: 
    case 28: 
    case 29: 
    case 35: 
    case 37: 
    case 38: 
    case 39: 
    case 43: 
    case 44: 
    case 45: 
    case 48: 
    case 49: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 59: 
    default: 
      k = 0;
      m = n;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(k, m, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateProfileName profileName=" + this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString());
      }
      return;
      k = 1;
      m = 2;
      continue;
      m = 2;
      k = 2;
      continue;
      m = 2;
      k = i1;
      continue;
      k = 4;
      m = n;
      continue;
      m = 2;
      k = 6;
      continue;
      k = 6;
      m = n;
      continue;
      m = 2;
      k = 7;
      continue;
      k = 7;
      m = n;
      continue;
      k = 8;
      m = n;
      continue;
      k = 9;
      m = n;
      continue;
      k = 11;
      m = n;
      continue;
      k = 10;
      m = n;
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      if (ProfileCardUtil.a()) {
        a(2131363439, 1);
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33);
        if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        str = d();
      } while ((str == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      ProfileCardUtil.a(this, this.jdField_a_of_type_AndroidWidgetImageView, str);
      return;
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    if (ProfileCardUtil.a())
    {
      a(2131363439, 1);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      ProfileCardUtil.a(this, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p);
      return;
    }
    ProfileCardUtil.a(this, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  private void s()
  {
    int k = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      setResult(0, (Intent)localObject);
      finish();
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      localObject = d();
    }
    for (;;)
    {
      a((String)localObject, k);
      return;
      localObject = str;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 3)
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 102)
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 103) {
            localObject = str;
          }
        }
      }
    }
  }
  
  private void t()
  {
    int i1 = 10004;
    int n = 0;
    int k = i1;
    int m = n;
    String str3;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      m = n;
      k = i1;
    case 19: 
    case 25: 
    case 26: 
    case 27: 
    case 70: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
        break label677;
      }
      ProfileActivity.CardContactInfo localCardContactInfo = a();
      if ((localCardContactInfo != null) && (localCardContactInfo.c != null) && (localCardContactInfo.c.length() > 0))
      {
        str3 = localCardContactInfo.b + localCardContactInfo.c;
        str2 = localCardContactInfo.jdField_a_of_type_JavaLangString;
        str1 = str2;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label619;
          }
          str1 = this.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
      }
      break;
    }
    for (;;)
    {
      startActivity(AddFriendLogicActivity.a(this, 2, str3, null, k, m, str1, null, FriendProfileCardActivity.class.getName(), b_()));
      return;
      k = 3004;
      m = n;
      break;
      k = 3007;
      m = n;
      break;
      k = 3001;
      m = n;
      break;
      k = 3020;
      m = n;
      break;
      k = 3017;
      m = n;
      break;
      k = 3002;
      m = n;
      break;
      k = 3005;
      m = n;
      break;
      k = 3007;
      m = n;
      break;
      k = 3003;
      m = n;
      break;
      k = 3008;
      m = n;
      break;
      k = 3008;
      m = n;
      break;
      k = 3009;
      m = n;
      break;
      k = 3006;
      m = n;
      break;
      k = 3009;
      m = 1;
      break;
      k = 3006;
      m = 1;
      break;
      k = 3013;
      m = n;
      break;
      k = 3003;
      m = 1;
      break;
      k = 3014;
      m = n;
      break;
      label619:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        str1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      else
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
        }
      }
    }
    label677:
    String str2 = null;
    String str1 = str2;
    if (3004 == k)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString.length() != 0) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        }
      }
    }
    str2 = null;
    if (TextUtils.isEmpty(null)) {
      str2 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, k, m, str2, null, AddContactsActivity.class.getName(), b_()));
      return;
    }
    startActivityForResult(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, k, m, str2, null, BmqqProfileCardActivity.class.getName(), b_()), 1000);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363381);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(43);
    paramString2 = localFriendsManager.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  void a()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    int k;
    if (localQQMessageFacade != null)
    {
      k = localQQMessageFacade.e();
      if (k <= 0) {
        break label117;
      }
      if (k > 99) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131362950) + "(" + "99+" + ")");
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131362950) + "(" + k + ")");
    return;
    label117:
    getIntent().putExtra("leftViewText", getString(2131362950));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131362950));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString);
    }
    ThreadManager.b(new la(this, paramInt, paramAllInOne, paramString));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 101) && (paramInt2 == -1)) {
      finish();
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1012: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          finish();
          return;
        }
        paramIntent = paramIntent.getStringExtra("remark");
      } while (Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, paramIntent));
      e(paramIntent);
      return;
    }
    setResult(-1);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    super.doOnCreate(paramBundle);
    c();
    if (CrmUtils.c(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      paramBundle = new Intent(this, EnterpriseDetailActivity.class);
      paramBundle.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      paramBundle.putExtra("need_finish", true);
      paramBundle.addFlags(536870912);
      startActivity(paramBundle);
      finish();
    }
    setContentView(2130903073);
    p();
    q();
    d();
    h();
    l();
    k();
    g();
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if ((QLog.isColorLevel()) && (l > 100L)) {
      QLog.i("Q.PerfTrace", 2, "BmqqProfileCardActivity onCreate used:" + l);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null) {
      this.app.a(getClass());
    }
    i();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.bmqq.profile.BmqqProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */