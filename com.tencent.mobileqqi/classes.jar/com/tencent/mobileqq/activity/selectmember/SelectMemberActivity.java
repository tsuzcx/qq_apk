package com.tencent.mobileqq.activity.selectmember;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import eqp;
import eqq;
import eqr;
import eqs;
import eqt;
import equ;
import eqv;
import eqw;
import eqx;
import eqy;
import eqz;
import erc;
import erd;
import ere;
import erf;
import erg;
import erh;
import erk;
import erl;
import erm;
import ero;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectMemberActivity
  extends BaseActivity
{
  public static final String A = "param_exit_animation";
  private static final int B = 3;
  public static final String B = "friend_team_id";
  public static final String C = "group_uin";
  public static final String D = "group_name";
  private static final String I = "not_admin_invite_member_count";
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "SelectMemberActivity";
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "param_type";
  public static final int c = 2;
  public static final String c = "param_subtype";
  public static final int d = 10;
  public static final String d = "param_is_troop_admin";
  static final int jdField_e_of_type_Int = 0;
  public static final String e = "param_from";
  static final int jdField_f_of_type_Int = 1;
  public static final String f = "param_entrance";
  static final int jdField_g_of_type_Int = 2;
  public static final String g = "param_groupcode";
  static final int jdField_h_of_type_Int = 3;
  public static final String h = "param_face_to_face_troop";
  static final int jdField_i_of_type_Int = 4;
  public static final String i = "param_uins_selected_default";
  static final int jdField_j_of_type_Int = 5;
  public static final String j = "param_uins_hide";
  static final int jdField_k_of_type_Int = 6;
  public static final String k = "param_max";
  static final int jdField_l_of_type_Int = 7;
  public static final String l = "multi_chat";
  public static final int m = 8;
  public static final String m = "param_min";
  public static final int n = 9;
  public static final String n = "param_show_myself";
  public static final int o = 10;
  public static final String o = "result_set";
  public static final String p = "param_donot_need_circle";
  public static final String q = "param_donot_need_contacts";
  public static final String r = "param_donot_need_troop";
  public static final String s = "param_donot_need_discussion";
  public static final String t = "param_only_friends";
  public static final String u = "param_only_troop_member";
  static final int v = 0;
  public static final String v = "param_only_discussion_member";
  static final int w = 1;
  public static final String w = "param_title";
  static final int x = 2;
  public static final String x = "param_done_button_wording";
  private static final int y = 1000;
  public static final String y = "param_done_button_highlight_wording";
  public static final String z = "param_add_passed_members_to_result_set";
  private int A;
  public String E;
  String F;
  String G;
  String H;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 0L;
  public Dialog a;
  public Intent a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public final Handler a;
  public View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public InputMethodManager a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public GridView a;
  public HorizontalScrollView a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ImageView a;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public InnerFrameManager a;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public FaceDecoder a;
  public QQProgressDialog a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private erm jdField_a_of_type_Erm;
  public ArrayList a;
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public ArrayList c;
  boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public ArrayList d;
  boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean;
  boolean jdField_f_of_type_Boolean;
  boolean jdField_g_of_type_Boolean;
  boolean jdField_h_of_type_Boolean;
  boolean jdField_i_of_type_Boolean;
  boolean jdField_j_of_type_Boolean;
  boolean jdField_k_of_type_Boolean;
  boolean jdField_l_of_type_Boolean;
  private boolean m;
  public int p;
  public int q;
  int r;
  int s;
  int t;
  int u;
  private int z;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public SelectMemberActivity()
  {
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_AndroidOsHandler = new eqz(this);
    this.jdField_d_of_type_JavaUtilArrayList = null;
  }
  
  private String a(String paramString)
  {
    FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendManager != null)
    {
      paramString = localFriendManager.a(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    c(getString(paramInt));
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
    String str;
    if (i1 <= 1)
    {
      str = this.G;
      if (!paramBoolean) {
        break label161;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setText(str);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.G + ",已选择" + i1 + "人");
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.G + ",已选择" + i1 + "人");
      return;
      str = MessageFormat.format(this.H, new Object[] { Integer.valueOf(i1) });
      break;
      label161:
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
  }
  
  private void c(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000)
    {
      QQToast.a(this, paramString, 2000).b(this.jdField_a_of_type_AndroidViewView.getHeight());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!this.m)
    {
      bool1 = bool2;
      if (a() >= 3) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.z = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.A = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.p = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.E = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.m = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.t = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", 2147483647);
    this.u = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.k = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_circle", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.f = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.g = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.h = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.i = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.F = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.F == null) {
      this.F = getString(2131562844);
    }
    this.G = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.G == null) {
      this.G = getString(2131561981);
    }
    this.H = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.H == null) {
      this.H = (this.G + "({0})");
    }
    this.j = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.s = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232157);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231375));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231455));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231379));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231116));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestFocus();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131232162));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131234460));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131232164));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131232166));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131232169));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131232168));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131234457));
    this.jdField_b_of_type_AndroidWidgetEditText.setOnKeyListener(new eqp(this));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new ero(this, null));
    this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(new erc(this));
  }
  
  private void n()
  {
    this.G = getString(2131562539);
    this.H = getString(2131562550);
    if (this.g) {
      this.F = getString(2131562252);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.F);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131562539);
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.F);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131561746));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new erd(this));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new ere(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231459));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new erf(this));
      return;
      if (this.h) {
        this.F = getString(2131562456);
      } else {
        this.F = getString(2131562844);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void o()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Erm = new erm(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Erm);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setText(this.G);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetButton.setText(this.H);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new erg(this));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new erh(this));
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903942);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231029));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562875));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231028));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131234122));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new erl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new eqq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new eqr(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public int a()
  {
    int i2 = 0;
    long l1 = Utils.a();
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i1 = i2;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i1 = i2;
      if (Long.parseLong(localObject[0]) == l1) {
        i1 = Integer.parseInt(localObject[1]);
      }
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public SelectMemberActivity.ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    SelectMemberActivity.ResultRecord localResultRecord = new SelectMemberActivity.ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.c = paramString3;
    return localResultRecord;
  }
  
  public void a(int paramInt)
  {
    long l1 = Utils.a();
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l1 + ":" + paramInt);
    localEditor.commit();
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_c_of_type_JavaUtilArrayList.size());
    e();
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
    }
    this.jdField_a_of_type_Erm.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendResultBroadcastToVideo");
    }
  }
  
  void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131562250));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      IphoneTitleBarActivity.b(this.jdField_c_of_type_AndroidWidgetTextView);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131562250));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      IphoneTitleBarActivity.b(this.jdField_c_of_type_AndroidWidgetTextView);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = false;
    if (a(paramString1)) {
      a(paramString1);
    }
    for (;;)
    {
      a(bool);
      d();
      return bool;
      if (!d())
      {
        bool = true;
        this.jdField_c_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageButton == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter == null)) {
      return;
    }
    if (paramString.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.b();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    String str = paramString.trim();
    if ("".equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(paramString, paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(str, paramString);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      i();
      return true;
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return super.b();
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      k();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
    case 7: 
      k();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      return true;
    case 8: 
      if (this.g)
      {
        finish();
        return true;
      }
      k();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      return true;
    case 9: 
      if (this.h)
      {
        finish();
        return true;
      }
      k();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
      return true;
    }
    finish();
    return true;
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  public boolean d()
  {
    if (this.z == 3000)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.t)
      {
        b(2131561569);
        return true;
      }
    }
    else if (this.z == 1)
    {
      if (this.A == 0)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.t)
        {
          b(2131563088);
          return true;
        }
      }
      else if ((this.A == 1) && (!this.m) && (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.t))
      {
        b(2131563088);
        return true;
      }
    }
    else if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.t)
    {
      c(String.format(getString(2131562354), new Object[] { Integer.valueOf(this.t) }));
      return true;
    }
    return false;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    l();
    setTheme(2131624539);
    super.doOnCreate(paramBundle);
    setContentView(2130903965);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false) == true) {
      super.getWindow().addFlags(524288);
    }
    m();
    n();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.g) {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, this.jdField_a_of_type_AndroidContentIntent.getExtras());
    }
    for (;;)
    {
      o();
      q();
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      ChnToSpell.a(this);
      this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      return true;
      if (this.h) {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      } else {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.d();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
    e();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestFocus();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
  
  void e()
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    Object localObject = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)((this.jdField_c_of_type_JavaUtilArrayList.size() * 50 + this.jdField_c_of_type_JavaUtilArrayList.size() * 5) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidWidgetEditText.getLayoutParams();
    localLayoutParams.width = (i1 - ((ViewGroup.LayoutParams)localObject).width - (int)(this.jdField_a_of_type_Float * 20.0F));
    if (localLayoutParams.width > (int)(this.jdField_a_of_type_Float * 65.0F)) {}
    for (i1 = localLayoutParams.width;; i1 = (int)(this.jdField_a_of_type_Float * 65.0F))
    {
      localLayoutParams.width = i1;
      this.jdField_b_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetEditText.setMaxWidth(localLayoutParams.width);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinimumWidth((int)(this.jdField_a_of_type_Float * 65.0F));
      localObject = getResources().getDrawable(2130840174);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      if (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setCompoundDrawables(null, null, null, null);
  }
  
  public void f()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i2;
    switch (this.z)
    {
    default: 
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_c_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.j)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = new SelectMemberActivity.ResultRecord();
          ((SelectMemberActivity.ResultRecord)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((SelectMemberActivity.ResultRecord)localObject3).jdField_a_of_type_Int = 0;
          ((SelectMemberActivity.ResultRecord)localObject3).c = "-1";
          this.jdField_c_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      localObject1 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((SelectMemberActivity.ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_Int != 3);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        if ((this.A != 0) || (i2 != 1) || (this.q == 10)) {
          break label524;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C conversation");
        }
        localObject2 = new Intent(this, ChatActivity.class);
        ((Intent)localObject2).putExtra("uin", ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject3 = ((FriendManager)localObject1).c(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
          if (!((FriendManager)localObject1).b(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString)) {
            break label509;
          }
          ((Intent)localObject2).putExtra("uintype", 0);
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          ((Intent)localObject2).putExtra("cSpecialFlag", ((Friends)localObject3).cSpecialFlag);
          if (((Friends)localObject3).cSpecialFlag == 1) {
            ((Intent)localObject2).setClass(this, ChatForEnterpriseActivity.class);
          }
        }
        ((Intent)localObject2).putExtra("uinname", ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).b);
        startActivity((Intent)localObject2);
        this.s = 2;
        finish();
        return;
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break;
        label509:
        ((Intent)localObject2).putExtra("uintype", 1000);
      }
      label524:
      if ((this.A == 0) && (i2 == 1) && (this.q == 10))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C audio");
        }
        if ((((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 0) && (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != 1)) {
          break label1089;
        }
        localObject1 = a(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).c);
        i1 = 1000;
      }
      for (;;)
      {
        if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 2)
        {
          i1 = 1004;
          localObject1 = ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).c;
        }
        for (;;)
        {
          if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 3) {
            i1 = 1021;
          }
          for (;;)
          {
            localObject2 = null;
            localObject3 = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).d(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
            if (localObject3 != null) {
              localObject2 = ((PhoneContact)localObject3).nationCode + ((PhoneContact)localObject3).mobileCode;
            }
            ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, a(), i1, ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).b, (String)localObject2, true, (String)localObject1, true, true, null, "");
            this.s = 2;
            finish();
            return;
            if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 4) {
              i1 = 1006;
            }
          }
          if (this.A == 0) {}
          for (i1 = 2131562717;; i1 = 2131561619)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131427376));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(i1);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            localObject1 = new erk(this, (FriendManager)localObject1);
            ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
            ((Thread)localObject1).start();
            return;
          }
          localObject1 = new ArrayList();
          localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add(((SelectMemberActivity.ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
          }
          if ((((ArrayList)localObject1).size() > 0) && (this.E.length() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.E + " member count: " + ((ArrayList)localObject1).size());
            }
            if (!e())
            {
              QQToast.a(this, 2131563257, 0).b(d());
              return;
            }
            ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(this.E, (ArrayList)localObject1, "");
            p();
            this.jdField_a_of_type_AndroidAppDialog.show();
            return;
          }
          finish();
          return;
        }
        label1089:
        i1 = 0;
        localObject1 = null;
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    switch (this.s)
    {
    default: 
      overridePendingTransition(0, 2130968590);
    case 2: 
      return;
    }
    overridePendingTransition(2130968593, 2130968594);
  }
  
  public void g()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      h();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    new Thread(new eqs(this)).start();
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, "selectmember search up anim time: " + (System.currentTimeMillis() - l1));
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.toggleSoftInput(0, 0);
    this.l = true;
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "6", "", "", "");
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233085));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231400);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231401));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231402);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new eqt(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new equ(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837729));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentWidgetXListView, null, null, false, null);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(new eqv(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new eqw(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new eqx(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new eqy(this));
  }
  
  public void i()
  {
    this.jdField_b_of_type_AndroidWidgetEditText.setText("");
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.l = false;
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void k()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "onOptionsItemSelected");
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131231379: 
      this.jdField_e_of_type_AndroidWidgetTextView.performClick();
      return true;
    }
    b();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "onPrepareOptionsMenu");
    }
    MenuItem localMenuItem;
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_e_of_type_AndroidWidgetTextView.getText() != null))
    {
      localMenuItem = paramMenu.findItem(this.jdField_e_of_type_AndroidWidgetTextView.getId());
      if (localMenuItem == null) {
        break label142;
      }
      localMenuItem.setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
    }
    for (;;)
    {
      localMenuItem.setEnabled(this.jdField_e_of_type_AndroidWidgetTextView.isEnabled());
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null) && (getSupportActionBar() != null)) {
        getSupportActionBar().setTitle(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      return super.onPrepareOptionsMenu(paramMenu);
      label142:
      localMenuItem = paramMenu.add(0, this.jdField_e_of_type_AndroidWidgetTextView.getId(), 0, this.jdField_e_of_type_AndroidWidgetTextView.getText());
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */