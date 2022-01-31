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
import android.os.Handler.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cmf;
import cmg;
import cmh;
import cmj;
import cmk;
import cml;
import cmm;
import cmn;
import cmo;
import cmp;
import cmq;
import cmt;
import cmu;
import cmv;
import cmw;
import cmz;
import cna;
import cnb;
import cnc;
import cnd;
import cnf;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectMemberActivity
  extends BaseActivity
{
  public static final String A = "param_exit_animation";
  public static final String B = "param_back_button_side";
  private static final int C = 3;
  public static final String C = "friend_team_id";
  public static final String D = "group_uin";
  public static final String E = "group_name";
  private static final String J = "not_admin_invite_member_count";
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
  public static final String v = "param_only_discussion_member";
  static final int w = 0;
  public static final String w = "param_title";
  static final int x = 1;
  public static final String x = "param_done_button_wording";
  static final int y = 2;
  public static final String y = "param_done_button_highlight_wording";
  private static final int z = 1000;
  public static final String z = "param_add_passed_members_to_result_set";
  private int A;
  private int B;
  public String F;
  String G;
  String H;
  String I;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 0L;
  public Dialog a;
  public Intent a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new cmz(this);
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
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  private cnd jdField_a_of_type_Cnd;
  public InnerFrameManager a;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public FaceDecoder a;
  public QQProgressDialog a;
  public XListView a;
  public ArrayList a;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public Bitmap b;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public ArrayList c;
  boolean jdField_c_of_type_Boolean;
  boolean d;
  boolean jdField_e_of_type_Boolean;
  boolean jdField_f_of_type_Boolean;
  boolean jdField_g_of_type_Boolean;
  boolean jdField_h_of_type_Boolean;
  boolean jdField_i_of_type_Boolean;
  boolean jdField_j_of_type_Boolean;
  boolean jdField_k_of_type_Boolean;
  private boolean jdField_l_of_type_Boolean;
  public int p;
  public int q;
  int r;
  public int s;
  int t;
  int u;
  int v;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public SelectMemberActivity()
  {
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_AndroidOsHandler = new cmq(this);
  }
  
  private String a(String paramString)
  {
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
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
      str = this.H;
      if (!paramBoolean) {
        break label107;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.H + ",已选择" + i1 + "人");
      return;
      str = MessageFormat.format(this.I, new Object[] { Integer.valueOf(i1) });
      break;
      label107:
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
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
    if (!this.l)
    {
      bool1 = bool2;
      if (a() >= 3) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.A = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.B = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.p = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.F = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.l = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.u = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", 2147483647);
    this.v = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.j = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.d = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.f = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.g = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.h = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.G = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.G == null) {
      this.G = getString(2131363968);
    }
    this.H = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.H == null) {
      this.H = getString(2131363972);
    }
    this.I = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.I == null) {
      this.I = (this.H + "({0})");
    }
    this.i = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.s = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
    this.t = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_back_button_side", 1);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297507);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296891));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296897));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296902));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298745));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131297512));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131298746));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131297514));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131297516));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297519));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131297518));
  }
  
  private void l()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838043);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("搜索");
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new cmf(this));
    if (this.t == 0) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.G);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.G);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.G);
      localTextView.setContentDescription(getString(2131362794));
      localTextView.setOnClickListener(new cmt(this));
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void m()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Cnd = new cnd(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Cnd);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setText(this.H);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetButton.setText(this.I);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new cmv(this));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new cmw(this));
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624119);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903599);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296470));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363381));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296469));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298695));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new cnb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new cnc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cmg(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public int a()
  {
    int i2 = 0;
    long l1 = Utils.a();
    Object localObject = this.app.a().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
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
    SharedPreferences.Editor localEditor = this.app.a().getSharedPreferences(this.app.getAccount(), 0).edit();
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
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_c_of_type_JavaUtilArrayList.size() * 36 + this.jdField_c_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
    }
    this.jdField_a_of_type_Cnd.notifyDataSetChanged();
  }
  
  void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new cmu(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      if ((paramString2 != null) && ((paramString2.equals("群")) || (paramString2.equals("讨论组")))) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      l();
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      g();
      return true;
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    case 7: 
    default: 
      return super.a();
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      i();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
    case 8: 
      if (this.f)
      {
        finish();
        return true;
      }
      i();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      return true;
    }
    if (this.g)
    {
      finish();
      return true;
    }
    i();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
    return true;
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
      c();
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
    if (paramString.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.c();
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
  
  public void c()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.v)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public void d()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i2;
    switch (this.A)
    {
    default: 
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_c_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.i)
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
      localObject1 = (FriendManager)this.app.getManager(8);
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
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        if ((this.B != 0) || (i2 != 1) || (this.q == 10)) {
          break label534;
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
            break label519;
          }
          ((Intent)localObject2).putExtra("uintype", 0);
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          ((Intent)localObject2).putExtra("cSpecialFlag", ((Friends)localObject3).cSpecialFlag);
          if (((Friends)localObject3).cSpecialFlag == 1)
          {
            ((Intent)localObject2).setClass(this, ChatActivity.class);
            ((Intent)localObject2).putExtra("chat_subType", 1);
          }
        }
        ((Intent)localObject2).putExtra("uinname", ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).b);
        startActivity((Intent)localObject2);
        this.s = 2;
        finish();
        return;
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break;
        label519:
        ((Intent)localObject2).putExtra("uintype", 1000);
      }
      label534:
      if (this.B == 0) {}
      for (i1 = 2131363217;; i1 = 2131363218)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492887));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(i1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        localObject1 = new cna(this, (FriendManager)localObject1);
        ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
        ((Thread)localObject1).start();
        return;
      }
      localObject1 = new ArrayList();
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(((SelectMemberActivity.ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
      }
      if ((((ArrayList)localObject1).size() > 0) && (this.F.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.F + " member count: " + ((ArrayList)localObject1).size());
        }
        if (!e())
        {
          QQToast.a(this, 2131363678, 0).b(getTitleBarHeight());
          return;
        }
        ((TroopHandler)this.app.a(17)).a(this.F, (ArrayList)localObject1, "");
        n();
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      finish();
      return;
    }
  }
  
  public boolean d()
  {
    if (this.A == 3000)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
      {
        b(2131363228);
        return true;
      }
    }
    else if (this.A == 1)
    {
      if (this.B == 0)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
        {
          b(2131363795);
          return true;
        }
      }
      else if ((this.B == 1) && (!this.l) && (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u))
      {
        b(2131363795);
        return true;
      }
    }
    else if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
    {
      c(String.format(getString(2131363985), new Object[] { Integer.valueOf(this.u) }));
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
    j();
    setTheme(2131624275);
    super.doOnCreate(paramBundle);
    setContentView(2130903621);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false) == true) {
      super.getWindow().addFlags(524288);
    }
    k();
    l();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    if (this.f) {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, this.jdField_a_of_type_AndroidContentIntent.getExtras());
    }
    for (;;)
    {
      m();
      o();
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      ChnToSpell.a(this);
      this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
      return true;
      if (this.g) {
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
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.e();
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
  
  public void e()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(300L);
    localTranslateAnimation.setAnimationListener(new cmh(this, localTranslateAnimation, (AlphaAnimation)localObject, l1));
    localObject = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.toggleSoftInput(0, 0);
    this.k = true;
    ReportController.b(this.app, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "6", "", "", "");
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297957));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297950));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298408));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296865);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296866));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296867);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cnf(this, null));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new cmj(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cmk(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837635));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, null, null, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(new cml(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new cmm(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new cmn(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new cmo(this));
  }
  
  public void finish()
  {
    super.finish();
    switch (this.s)
    {
    default: 
      overridePendingTransition(0, 2130968584);
    case 2: 
      return;
    }
    overridePendingTransition(2130968587, 2130968588);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight(), 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new cmp(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.k = false;
  }
  
  public void h()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837910);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_c_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void i()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */