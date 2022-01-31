package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cja;
import cjb;
import cjc;
import cjd;
import cje;
import cjf;
import cjg;
import cjh;
import cji;
import cjj;
import cjk;
import cjl;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.List;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1000;
  public static final String a = "isShieldMsgSwitchUnClickable";
  private static final boolean jdField_a_of_type_Boolean = true;
  static final String jdField_b_of_type_JavaLangString = "memberUin";
  static final String jdField_c_of_type_JavaLangString = "memberName";
  static final String jdField_d_of_type_JavaLangString = "faceId";
  static final String jdField_e_of_type_JavaLangString = "pinyin";
  private static final int jdField_f_of_type_Int = 1;
  private static final int jdField_g_of_type_Int = 2;
  private static final int jdField_n_of_type_Int = 33;
  private static final int jdField_o_of_type_Int = 18;
  private static final int jdField_p_of_type_Int = 32;
  private float jdField_a_of_type_Float;
  private Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public QvipSpecialCareManager a;
  public QvipSpecialSoundManager a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new cjl(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cjk(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cjc(this);
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new cje(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new cjb(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new cjd(this);
  public RichStatus a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private XSimpleListAdapter jdField_a_of_type_ComTencentWidgetXSimpleListAdapter;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 1;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 2;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_d_of_type_Boolean = false;
  private final int jdField_e_of_type_Int = 3;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private boolean jdField_f_of_type_Boolean = true;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int = 0;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 4;
  private String jdField_m_of_type_JavaLangString;
  private String jdField_n_of_type_JavaLangString;
  private String jdField_o_of_type_JavaLangString;
  private String jdField_p_of_type_JavaLangString;
  private String q = "";
  
  public ChatSettingActivity()
  {
    this.k = 0;
    this.l = 0;
    this.o = "";
    this.p = "";
    this.jdField_a_of_type_AndroidOsHandler = new cjj(this);
  }
  
  private void C()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_g_of_type_JavaLangString, 46);
    localAllInOne.a = 19;
    localAllInOne.jdField_g_of_type_JavaLangString = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_g_of_type_JavaLangString);
    localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    localAllInOne.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
    localAllInOne.jdField_e_of_type_Int = 5;
    localAllInOne.f = 61;
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      ProfileActivity.a(this, localAllInOne, 3);
      return;
      localAllInOne.a = 22;
      localAllInOne.c = this.p;
      continue;
      localAllInOne.a = 42;
      continue;
      localAllInOne.a = 70;
      continue;
      localAllInOne.a = 47;
      localAllInOne.jdField_d_of_type_JavaLangString = this.p;
      continue;
      localAllInOne.a = 2;
      continue;
      localAllInOne.a = 34;
      continue;
      localAllInOne.a = 57;
      continue;
      localAllInOne.a = 72;
      continue;
      localAllInOne.a = 74;
      continue;
      localAllInOne.a = 27;
    }
  }
  
  private void D()
  {
    int i2 = 3003;
    int i3 = 0;
    int i1;
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    case 1007: 
    case 1008: 
    case 1010: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    case 1020: 
    case 1022: 
    default: 
      i2 = 10004;
      i1 = 0;
      localIntent = new Intent(this, AddFriendLogicActivity.class);
      if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 4000) || (this.jdField_b_of_type_Int == 1006))
      {
        localIntent.putExtra("uin", "");
        localIntent.putExtra("friend_mobile_number", this.q);
        localIntent.putExtra("friend_mobile_name", this.jdField_h_of_type_JavaLangString);
        label208:
        if (this.jdField_b_of_type_Int != 1000) {
          break label374;
        }
        localIntent.putExtra("troop_uin", getIntent().getStringExtra("troop_uin"));
      }
      break;
    }
    for (;;)
    {
      localIntent.putExtra("type", i1);
      localIntent.putExtra("source_id", i2);
      localIntent.putExtra("param_last_activity_name", a_());
      startActivity(localIntent);
      return;
      i2 = 3004;
      i1 = 0;
      break;
      i2 = 3007;
      i1 = 0;
      break;
      i1 = 0;
      break;
      i2 = 3005;
      i1 = 0;
      break;
      i2 = 3008;
      i1 = 0;
      break;
      i2 = 3006;
      i1 = 3;
      break;
      i2 = 3013;
      i1 = 0;
      break;
      i2 = 3008;
      i1 = 0;
      break;
      i1 = 0;
      break;
      localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
      localIntent.putExtra("nick_name", this.jdField_h_of_type_JavaLangString);
      i1 = i3;
      break label208;
      label374:
      if (this.jdField_b_of_type_Int == 1021) {
        localIntent.putExtra("sub_source_id", 2);
      }
    }
  }
  
  private void E()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_g_of_type_JavaLangString, 1);
    localAllInOne.jdField_g_of_type_JavaLangString = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_g_of_type_JavaLangString);
    if (3000 != this.jdField_b_of_type_Int)
    {
      localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localAllInOne.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
    }
    localAllInOne.jdField_e_of_type_Int = 5;
    localAllInOne.f = 61;
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void F()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Special_remind", "Clk_special_remind", 62, 0, "", "", "", "");
    Object localObject = new Intent(this, QvipSpecialCareActivity.class);
    ((Intent)localObject).putExtra("memberUin", this.jdField_g_of_type_JavaLangString);
    ((Intent)localObject).putExtra("memberName", this.jdField_h_of_type_JavaLangString);
    startActivity((Intent)localObject);
    localObject = PreferenceManager.getDefaultSharedPreferences(this);
    ((SharedPreferences)localObject).edit().putBoolean("special_care_chat_setting", false).commit();
    if ((((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false)) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString))) {
      ((SharedPreferences)localObject).edit().putBoolean("special_care_red_point_one", false).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void G()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), d());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void H()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void I()
  {
    QQUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, d(), this.jdField_a_of_type_AndroidOsHandler, 500, "0");
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.a(paramString.toString(), null);
    } while (paramString == null);
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label153;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label153:
      if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
    if (paramString != null) {
      return paramString.getRichStatus();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Friends localFriends = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
    if ((localFriends != null) && (localFriends.remark != null)) {}
    for (paramString = localFriends.remark;; paramString = null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = localFriends.name;
      }
      return str;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).b(d());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(d());
  }
  
  private void a(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_j_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_g_of_type_JavaLangString, paramIntent);
          this.jdField_h_of_type_Int |= 0x1;
          a(paramIntent);
          h(getString(2131562644));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(2131562435, 1);
        return;
      }
      a(2131562516, 0);
      return;
    }
    a(2131562445, 1);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.a(null);
    if (!TextUtils.isEmpty(paramRichStatus.c))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localStatusManager != null) {}
      for (paramRichStatus = localStatusManager.a(paramRichStatus.jdField_b_of_type_Int, 200);; paramRichStatus = BitmapManager.a(getResources(), 2130839653))
      {
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, i1, i1);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
    }
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i3 = (int)(20.0F * f1);
    int i1 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    int i5 = (int)(50.0F * f1);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1) + (i4 - i5) / 2;
    i3 = (int)(f1 * 20.0F);
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = i2;
    this.k = i3;
    this.l = i3;
    this.jdField_m_of_type_Int = i1;
    paramMyGridView.setPadding(this.jdField_i_of_type_Int, this.k, this.jdField_j_of_type_Int, this.l);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (paramString != null) && (paramString.length() != 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, d(), 0, paramInt);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    paramString = localFriendManager.c(paramString);
    if (paramString != null)
    {
      paramString = localFriendManager.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(LocaleString.b(getApplicationContext(), paramString));
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    Intent localIntent = new Intent(a(), EditActivity.class);
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    localIntent.putExtra("title", 2131562433).putExtra("limit", 96).putExtra("current", paramString).putExtra("canPostNull", bool).putExtra("multiLine", false);
    startActivityForResult(localIntent, 1003);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_f_of_type_JavaLangString, 2, "AIO_edit_name");
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_edit_name", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
  }
  
  private void d(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      int i1 = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(String.valueOf(i1));
    } while (paramIntent == null);
    b(paramIntent.group_name);
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Friends localFriends = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
    if (localFriends != null) {
      startActivityForResult(new Intent(a(), MoveToGroupActivity.class).putExtra("friendUin", paramString).putExtra("mgid", (byte)localFriends.groupid), 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_f_of_type_JavaLangString, 2, "AIO_edit_category");
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_edit_category", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatSettingActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    StatusManager localStatusManager = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  private void e(String paramString)
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int, l1);
          }
          paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
          localObject = paramString.obtainMessage(1017);
          ((Message)localObject).obj = this.jdField_g_of_type_JavaLangString;
          ((Message)localObject).arg1 = this.jdField_b_of_type_Int;
          paramString.sendMessage((Message)localObject);
          return;
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private void f()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatSettingActivity.class);
    StatusManager localStatusManager = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localStatusManager != null)
    {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = null;
  }
  
  private void f(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131561924)).setMessage(getString(2131561974)).setPositiveButton(2131562750, new cji(this, paramString)).setNegativeButton(2131561751, new cjh(this)).show();
  }
  
  private void g()
  {
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_h_of_type_JavaLangString == null) {
      this.jdField_h_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_g_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = 1003;
    }
    if ((1 == this.jdField_b_of_type_Int) || (1000 == this.jdField_b_of_type_Int) || (1004 == this.jdField_b_of_type_Int)) {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      j();
    }
    for (;;)
    {
      setTitle(2131561803);
      j(2130837729);
      return;
      i();
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130903940);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131562875));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130903258, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903121, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131231296));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231297));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231298));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231299));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131231300));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231288));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231289));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231304));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131231305));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231302));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231303));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131563185));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131561892));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131562216));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131562886));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131561776));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131558463));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131558462));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131561924));
    this.jdField_j_of_type_JavaLangString = a(this.jdField_g_of_type_JavaLangString);
    if (this.jdField_j_of_type_JavaLangString == null) {
      this.jdField_j_of_type_JavaLangString = "";
    }
    a(this.jdField_j_of_type_JavaLangString);
    if (this.jdField_j_of_type_JavaLangString != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
    }
    if (this.jdField_g_of_type_JavaLangString != null)
    {
      Drawable localDrawable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    a(a(this.jdField_g_of_type_JavaLangString), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_m_of_type_JavaLangString = b(this.jdField_g_of_type_JavaLangString);
    if (this.jdField_m_of_type_JavaLangString == null) {
      this.jdField_m_of_type_JavaLangString = "";
    }
    b(this.jdField_m_of_type_JavaLangString);
    o();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      v();
    }
  }
  
  private void j()
  {
    Object localObject = View.inflate(this, 2130903123, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131231313));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903122, null);
    this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
    setContentView((View)localObject);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131231306));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231310));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231307));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231308));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231309));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131231311));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131231312));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131231314));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131563185));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131561829));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131558463));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131561595));
    this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(getString(2131561559));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((this.jdField_b_of_type_Int == 1006) && (this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false)))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject != null) {
        ((Switch)localObject).setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_b_of_type_Int != 1006)
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_g_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.o = this.jdField_g_of_type_JavaLangString;
        if ((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1004)) {
          this.p = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
        }
      }
      if (this.jdField_b_of_type_Int == 1001) {
        break label734;
      }
      if (this.jdField_b_of_type_Int == 1006)
      {
        this.q = this.jdField_g_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.q)) {
          break label673;
        }
        this.jdField_f_of_type_Boolean = false;
      }
      label513:
      localObject = (ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if ((localObject != null) && (!TextUtils.isEmpty(this.o))) {
        this.jdField_e_of_type_Boolean = ((ShieldMsgManger)localObject).a(this.o);
      }
      label552:
      if (!a(this.jdField_b_of_type_Int)) {
        break label786;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
      this.jdField_h_of_type_Boolean = true;
      u();
      a(a(this.jdField_g_of_type_JavaLangString), this.jdField_f_of_type_AndroidWidgetTextView);
      localObject = this.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        d();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(new String[] { localObject });
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cja(this));
      break;
      label673:
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.q, (byte)3);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = ContactUtils.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.q);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_f_of_type_Boolean = false;
        break label513;
      }
      this.jdField_f_of_type_Boolean = true;
      this.o = ((String)localObject);
      break label513;
      label734:
      localObject = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.o);
      if ((localObject != null) && (((Friends)localObject).groupid == -1002))
      {
        this.jdField_e_of_type_Boolean = true;
        break label552;
      }
      this.jdField_e_of_type_Boolean = false;
      break label552;
      label786:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void k()
  {
    Intent localIntent = new Intent(a(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_g_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 50 - localArrayList.size() - 1);
    startActivityForResult(localIntent, 2);
  }
  
  private void l()
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("FriendNick", this.n);
    startActivityForResult(localIntent, 1000);
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, ChatBackgroundSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    startActivityForResult(localIntent, 1);
  }
  
  private void n()
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_h_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_b_of_type_Boolean);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void o()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString)))
    {
      localObject = getResources().getDrawable(2130840210);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      bool2 = ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while ((!bool1) || (!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString)));
    localObject = getResources().getDrawable(2130840207);
    getResources().getDrawable(2130837803);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
          q();
        }
        String str = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
    boolean bool1 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("special_care_chat_setting", true);
    boolean bool2 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("special_care_red_point_one", false);
    if ((bool1) || (bool2))
    {
      int i1 = (int)getResources().getDimension(2131427538);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void q()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new cjf(this));
  }
  
  private void r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cjg(this, localStringBuilder));
    a(2, getString(2131561800));
  }
  
  private void s()
  {
    boolean bool = true;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131562452, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_d_of_type_Boolean);
    }
    while (this.jdField_b_of_type_Int != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      d();
      return;
    }
    try
    {
      l1 = Long.parseLong(this.jdField_g_of_type_JavaLangString);
      if (l1 > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.jdField_d_of_type_Boolean)
        {
          localFriendListHandler.a(l1, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        bool = false;
      }
      a(1, getResources().getString(2131559043));
    }
  }
  
  private void t()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131562452, 1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    for (;;)
    {
      return;
      ShieldMsgManger localShieldMsgManger;
      if (this.jdField_b_of_type_Int != 1003)
      {
        localShieldMsgManger = (ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
        if (localShieldMsgManger == null) {}
      }
      try
      {
        l1 = Long.parseLong(this.o);
        if (l1 > 0L)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(l1));
          if (this.jdField_e_of_type_Boolean)
          {
            localShieldMsgManger.b(this.jdField_b_of_type_Int, localArrayList);
            this.jdField_g_of_type_Boolean = true;
            if ((this.jdField_b_of_type_Int == 1001) || (this.jdField_b_of_type_Int == 1003))
            {
              if (!this.jdField_e_of_type_Boolean) {
                break label220;
              }
              if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
              {
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_g_of_type_JavaLangString);
                this.jdField_g_of_type_Boolean = true;
              }
            }
            if (!this.jdField_g_of_type_Boolean) {
              continue;
            }
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1 = 0L;
          continue;
          localShieldMsgManger.a(this.jdField_b_of_type_Int, localException);
          continue;
          a(1, getResources().getString(2131559043));
          continue;
          label220:
          if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString);
            this.jdField_g_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131561713));
    }
    if ((this.jdField_b_of_type_Int == 1003) || (!this.jdField_f_of_type_Boolean)) {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void v()
  {
    FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendManager != null) {
      this.jdField_d_of_type_Boolean = localFriendManager.g(this.jdField_g_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131561713));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
  }
  
  private void w()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Handler localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_c_of_type_Boolean = false;
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 0) || (3 != paramInt1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("finchat", false)))
    {
      return;
      n();
      finish();
      return;
      setResult(-1);
      this.jdField_b_of_type_Boolean = true;
      return;
      a(paramIntent);
      return;
      d(paramIntent);
      return;
      switch (paramIntent.getIntExtra("param_subtype", -1))
      {
      default: 
        return;
      case 0: 
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
      }
      Intent localIntent = new Intent(this, ChatActivity.class);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, getApplicationContext(), paramIntent));
      localIntent.putExtra("isBack2Root", true);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    d();
    e();
    g();
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      f();
      this.jdField_h_of_type_Boolean = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void doOnPause()
  {
    this.jdField_c_of_type_Boolean = true;
    w();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(32);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(33);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    p();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean == paramBoolean) {
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
    }
    for (;;)
    {
      s();
      return;
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131231300: 
    case 2131231288: 
    case 2131231289: 
    case 2131231304: 
    case 2131231310: 
    case 2131231314: 
      do
      {
        return;
        k();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
        return;
        l();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
        return;
        m();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
        return;
        I();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
        return;
        r();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      } while (!a(this.jdField_b_of_type_Int));
      ProfileCardUtil.a(this, "", this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
      return;
    case 2131231306: 
      C();
      return;
    case 2131231312: 
      D();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
      return;
    case 2131231296: 
      E();
      return;
    case 2131231305: 
      f(this.jdField_g_of_type_JavaLangString);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
      return;
    }
    F();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */