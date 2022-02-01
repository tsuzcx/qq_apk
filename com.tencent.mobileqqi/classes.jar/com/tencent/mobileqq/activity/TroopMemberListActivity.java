package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dqr;
import dqs;
import dqt;
import dqv;
import dqw;
import dqx;
import dqz;
import dra;
import drb;
import drc;
import drd;
import dre;
import drf;
import drh;
import dri;
import drk;
import drm;
import drn;
import dro;
import drp;
import drq;
import drr;
import drs;
import drt;
import dru;
import drw;
import dsc;
import dsh;
import dsi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class TroopMemberListActivity
  extends BaseActivity
  implements IndexView.OnIndexChangedListener, AdapterView.OnItemClickListener
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "TroopMemberListActivity";
  public static final int b = 1;
  public static final String b = "key_discuss_member_manage";
  public static final int c = 2;
  public static final String c = "mode";
  public static final int d = 0;
  public static final String d = "last_update_time";
  public static final int e = 0;
  public static final String e = "key_last_update_time";
  public static final int f = 1;
  public static final String f = "member_uin";
  public static final int g = 2;
  public static final String g = "member_display_name";
  public static final int j = 34;
  public static final int k = 250;
  private static final int l = 1;
  private static final int m = 2;
  public static final String m = "param_from";
  private static final int n = 3;
  private static final int jdField_o_of_type_Int = 4;
  private static final int jdField_p_of_type_Int = 5;
  private static final int jdField_q_of_type_Int = 6;
  private static final int r = 7;
  public float a;
  private long jdField_a_of_type_Long = 0L;
  public Dialog a;
  protected Drawable a;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new drm(this);
  public View a;
  public EditText a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public LinearLayout a;
  protected RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected DiscussionHandler a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new dri(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new drk(this);
  private DiscussionInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  public QQCustomDialog a;
  public IndexView a;
  public PinnedDividerListView a;
  public ActionSheet a;
  public XListView a;
  public drw a;
  public dsc a;
  public List a;
  public boolean a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public View b;
  public LinearLayout b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  public View c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  List jdField_c_of_type_JavaUtilList;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  public boolean d;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private View f;
  public int h;
  String h;
  public int i = 0;
  public String i;
  public String j = "";
  public String k = "";
  public String l = null;
  public String n = "";
  private String jdField_o_of_type_JavaLangString;
  private String jdField_p_of_type_JavaLangString;
  private String jdField_q_of_type_JavaLangString;
  private int s;
  
  public TroopMemberListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Drw = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.q = "";
    this.jdField_a_of_type_AndroidOsHandler = new drf(this);
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null)
    {
      paramView = (View)paramView.getParent();
      if (paramView != null) {
        return paramView.findViewById(2131230987);
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if ("TROOP_MANAGE_ACTIVITY".equals(this.q))
    {
      paramString2 = new Intent(this, TroopMemberCardActivity.class);
      paramString2.putExtra("troopUin", this.jdField_h_of_type_JavaLangString);
      paramString2.putExtra("memberUin", paramString1);
      paramString2.putExtra("fromFlag", 1);
      startActivityForResult(paramString2, 5);
      ReportController.b(null, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 1, 0, this.jdField_h_of_type_JavaLangString, paramString1, "", "");
    }
    while (paramString2 == null) {
      return;
    }
    if (paramString2.b(paramString1))
    {
      paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
      paramString1.a = 20;
      paramString1.c = this.jdField_h_of_type_JavaLangString;
      paramString1.b = this.o;
      paramString1.f = 4;
      ProfileActivity.a(this, paramString1);
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.a = 21;
    paramString1.c = this.jdField_h_of_type_JavaLangString;
    paramString1.b = this.o;
    paramString1.f = 4;
    ProfileActivity.a(this, paramString1);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "onGetAtAllRemianCountInfo:" + paramBoolean1 + ", " + paramString1 + ", " + paramBoolean2 + ", " + paramInt1 + ", " + paramString2 + ", " + paramString3);
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131234401)).setCompoundDrawables(null, null, null, null);
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setEnabled(true);
      if ((paramBoolean1) && (paramString1 != null) && (paramString1.equals(this.o))) {}
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231410)).setTextColor(getResources().getColor(2131362080));
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131234401);
    paramString1 = "@全体成员";
    if (this.jdField_h_of_type_Int == 2)
    {
      this.i = paramInt2;
      if ((paramBoolean2) && (paramInt1 > 0))
      {
        paramBoolean1 = bool;
        this.jdField_d_of_type_Boolean = paramBoolean1;
        if (!this.jdField_d_of_type_Boolean) {
          break label402;
        }
        this.n = ("剩余" + paramInt1 + "次");
        localTextView.setText(this.n);
        paramString1 = "@全体成员" + "," + this.n;
        label339:
        paramString3 = paramString1;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
        {
          paramString2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
          paramString2.rightMargin = AIOUtils.a(20.0F, getResources());
          localTextView.setLayoutParams(paramString2);
          paramString3 = paramString1;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramString3);
      return;
      paramBoolean1 = false;
      break;
      label402:
      if (paramInt1 == 0)
      {
        this.n = "该功能的使用次数已用完";
        paramString1 = "@全体成员" + "," + "剩余0次";
        localTextView.setText("剩余0次");
        break label339;
      }
      this.n = "";
      paramString1 = "@全体成员" + "," + "现在无法发送@All消息";
      localTextView.setText("");
      break label339;
      this.jdField_d_of_type_Boolean = paramBoolean2;
      this.n = paramString3;
      localTextView.setText(paramString2);
      paramString3 = paramString1;
      if (paramString2 != null) {
        paramString3 = "@全体成员" + "," + paramString2;
      }
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131230999);
    }
    return null;
  }
  
  private void f(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i1);
      if ((localObject == null) || (!((View)localObject).isShown())) {}
      for (;;)
      {
        i1 += 1;
        break;
        View localView = ((View)localObject).findViewById(2131234628);
        if (localView != null)
        {
          localObject = ((TroopMemberListActivity.ViewHolder)((View)localObject).getTag()).jdField_a_of_type_JavaLangString;
          if ((localObject != null) && (((String)localObject).equals(paramString))) {
            if (localView.getVisibility() == 0)
            {
              localView.setVisibility(8);
            }
            else
            {
              localView.setVisibility(0);
              localView.setOnClickListener(new drh(this, paramString));
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Drw.a();
  }
  
  private void h()
  {
    Object localObject = (ViewGroup)findViewById(2131231447);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = findViewById(2131232157);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = (TextView)findViewById(2131231455);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
  }
  
  private void h(String paramString)
  {
    boolean bool = true;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131562451), 0).b(d());
      return;
    }
    Dialog localDialog;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903073);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_h_of_type_Int == 1) {
        break label134;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231029)).setText(getString(2131561935));
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_h_of_type_JavaLangString), Long.valueOf(paramString).longValue());
      return;
      label134:
      bool = false;
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131234621));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232157);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231375));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231455));
    if (this.s == 2)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231379));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131234476));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131234430));
  }
  
  private void j()
  {
    if (this.jdField_h_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131561926));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561977));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131561852));
    }
    for (;;)
    {
      getSupportActionBar().setTitle(this.jdField_c_of_type_AndroidWidgetTextView.getText());
      return;
      if (this.jdField_h_of_type_Int == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131560768));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131561746);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new dqr(this));
      }
      else if (this.s == 1)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131562843));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561842);
      }
      else if (this.s == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131560613));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131561746);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new dre(this));
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131562359));
        o();
        if (this.p == null) {
          this.p = getString(2131561692);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.p);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new drn(this));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2130903944, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    EditText localEditText = (EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131233086);
    ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131233085)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131234398));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    int i1;
    int i2;
    label123:
    Object localObject2;
    Object localObject1;
    if ((this.s == 2) && (this.jdField_a_of_type_Boolean))
    {
      i1 = 1;
      if ((this.jdField_h_of_type_Int != 2) || (!this.jdField_a_of_type_Boolean)) {
        break label789;
      }
      i2 = 1;
      if ((i1 != 0) || (i2 != 0))
      {
        localObject2 = getString(2131563403);
        ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231410)).setText((CharSequence)localObject2);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131234401);
        ((TextView)localObject1).setText("");
        ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231567)).setBackgroundDrawable(ImageUtil.b());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new dro(this, (String)localObject2));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        localObject2 = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break label794;
        }
        QQToast.a(this, 2131562451, 0).b(d());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      }
      if ((this.s == 0) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130904038, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        localObject2 = new TroopMemberListActivity.ViewHolder();
        ((TroopMemberListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131231567));
        ((TroopMemberListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131231410));
        ((TroopMemberListActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((TroopMemberListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(ImageUtil.a());
        this.jdField_b_of_type_AndroidViewView.setTag(localObject2);
        ((TroopMemberListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
        localObject2 = ((TroopMemberListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView;
        if ((localObject1 == null) || (((String)localObject1).trim().length() <= 0)) {
          break label891;
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new drp(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_Drw = new drw(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Drw);
      localEditText.setOnTouchListener(new drq(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230734));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131562359)).setPositiveButton(getString(2131562540), new drr(this));
      return;
      i1 = 0;
      break;
      label789:
      i2 = 0;
      break label123;
      label794:
      if ((this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler != null) && (this.jdField_h_of_type_Int == 2)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.o);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject2 != null) {
          ((TroopHandler)localObject2).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.o);
        }
      }
      label891:
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
  }
  
  private void l()
  {
    drs localdrs = new drs(this);
    long l1 = getSharedPreferences("last_update_time" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getLong("key_last_update_time" + this.o, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "troop member last update time: " + l1 + " current time: " + l2 + " time difference: " + l3);
    }
    if (((this.s == 0) || (this.s == 2)) && ((l1 == 0L) || ((l1 > 0L) && (l3 > 300000L)))) {
      e(this.o);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(localdrs);
  }
  
  private void m()
  {
    boolean bool;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!this.jdField_b_of_type_Boolean) {
        break label53;
      }
    }
    label53:
    for (int i1 = 2131561977;; i1 = 2131562339)
    {
      ((TextView)localObject).setText(i1);
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label60;
      }
      return;
      bool = false;
      break;
    }
    label60:
    i1 = 0;
    label62:
    if (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i1);
      if ((localObject != null) && (((View)localObject).isShown())) {
        break label100;
      }
    }
    label100:
    View localView;
    for (;;)
    {
      i1 += 1;
      break label62;
      break;
      localView = ((View)localObject).findViewById(2131234627);
      if (localView != null)
      {
        localObject = ((TroopMemberListActivity.ViewHolder)((View)localObject).getTag()).jdField_a_of_type_JavaLangString;
        if (localObject != null)
        {
          if ((!((String)localObject).equals(this.j)) && ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.j)) || (!this.k.contains((CharSequence)localObject)))) {
            break label178;
          }
          localView.setVisibility(8);
        }
      }
    }
    label178:
    if (this.jdField_b_of_type_Boolean) {
      localView.setVisibility(0);
    }
    for (Object localObject = new AlphaAnimation(0.0F, 1.0F);; localObject = new AlphaAnimation(1.0F, 0.0F))
    {
      ((AlphaAnimation)localObject).setAnimationListener(new dqv(this, localView));
      ((AlphaAnimation)localObject).setDuration(500L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      localView.startAnimation((Animation)localObject);
      break;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount())
    {
      View localView1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i1);
      if ((localView1 == null) || (!localView1.isShown())) {}
      for (;;)
      {
        i1 += 1;
        break;
        View localView2 = localView1.findViewById(2131234628);
        if ((localView2 != null) && (((TroopMemberListActivity.ViewHolder)localView1.getTag()).jdField_a_of_type_JavaLangString != null)) {
          localView2.setVisibility(8);
        }
      }
    }
    this.jdField_a_of_type_Drw.a();
  }
  
  private void o()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void a(Dialog paramDialog, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    if (paramDialog == this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new dru(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt)
  {
    paramAdapterView = (TroopMemberListActivity.ATroopMember)paramAdapterView.a().getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.jdField_a_of_type_JavaLangString == null)) {}
    do
    {
      return;
      if ((this.s == 0) && (this.jdField_h_of_type_Int != 2))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramAdapterView.jdField_a_of_type_JavaLangString))
        {
          paramView = new ProfileActivity.AllInOne(paramAdapterView.jdField_a_of_type_JavaLangString, 0);
          paramView.g = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramAdapterView.jdField_a_of_type_JavaLangString);
          paramView.e = 3;
          paramView.f = 4;
          ProfileActivity.a(this, paramView);
          return;
        }
        a(paramAdapterView.jdField_a_of_type_JavaLangString, paramAdapterView.b);
        return;
      }
      if (this.s == 1)
      {
        paramView = getIntent();
        paramView.putExtra("troop_uin", this.o);
        paramView.putExtra("member_uin", paramAdapterView.jdField_a_of_type_JavaLangString);
        SetTroopAdminsActivity.TroopAdmin localTroopAdmin = new SetTroopAdminsActivity.TroopAdmin();
        localTroopAdmin.jdField_a_of_type_JavaLangString = paramAdapterView.jdField_a_of_type_JavaLangString;
        localTroopAdmin.jdField_a_of_type_Short = paramAdapterView.jdField_a_of_type_Short;
        localTroopAdmin.b = paramAdapterView.b;
        paramView.putExtra("member_info", localTroopAdmin);
        setResult(-1, paramView);
        finish();
        return;
      }
    } while ((this.s != 2) && (this.jdField_h_of_type_Int != 2));
    paramView = getIntent();
    paramView.putExtra("member_uin", paramAdapterView.jdField_a_of_type_JavaLangString);
    paramView.putExtra("member_display_name", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramAdapterView, paramView, paramInt);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_Drw.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i1 + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k());
  }
  
  public Object[] a(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      TroopMemberListActivity.ATroopMember localATroopMember;
      DiscussionMemberInfo localDiscussionMemberInfo;
      try
      {
        localObject = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        this.jdField_c_of_type_JavaUtilList = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramString);
        localArrayList = new ArrayList();
        if (this.jdField_c_of_type_JavaUtilList == null) {
          break label454;
        }
        if (i1 >= this.jdField_c_of_type_JavaUtilList.size()) {
          break label434;
        }
        localATroopMember = new TroopMemberListActivity.ATroopMember();
        localDiscussionMemberInfo = (DiscussionMemberInfo)this.jdField_c_of_type_JavaUtilList.get(i1);
        if ((localDiscussionMemberInfo == null) || (localDiscussionMemberInfo.memberUin == null) || (localDiscussionMemberInfo.memberUin.trim().length() <= 0) || (localDiscussionMemberInfo.memberUin.trim().equalsIgnoreCase("0")) || ((this.s == 1) && (localDiscussionMemberInfo.memberUin.equals(this.j)))) {
          break label522;
        }
        localATroopMember.jdField_a_of_type_JavaLangString = localDiscussionMemberInfo.memberUin.trim();
        paramString = null;
        if (localObject != null) {
          paramString = ((FriendsManagerImp)localObject).a(localDiscussionMemberInfo.memberUin);
        }
        localATroopMember.b = localDiscussionMemberInfo.getDiscussionMemberName();
        localATroopMember.jdField_a_of_type_Short = 0;
        localATroopMember.c = ChnToSpell.a(localATroopMember.b, 2);
        localATroopMember.c(ChnToSpell.a(localATroopMember.b, 1));
        if ((paramString != null) && (paramString.isFriend()) && (paramString.remark != null) && (paramString.remark.length() > 0))
        {
          localATroopMember.g(paramString.remark);
          localATroopMember.i(ChnToSpell.a(localATroopMember.j, 1));
          localATroopMember.h(ChnToSpell.a(localATroopMember.j, 2));
          if ((localDiscussionMemberInfo.memberName != null) && (localDiscussionMemberInfo.memberName.length() > 0))
          {
            localATroopMember.j(localDiscussionMemberInfo.memberName);
            localATroopMember.l(ChnToSpell.a(localDiscussionMemberInfo.memberName, 1));
            localATroopMember.k(ChnToSpell.a(localDiscussionMemberInfo.memberName, 2));
          }
          localArrayList.add(localATroopMember);
        }
      }
      finally {}
      if ((localDiscussionMemberInfo.inteRemark != null) && (localDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localATroopMember.g(localDiscussionMemberInfo.inteRemark);
        localATroopMember.i(ChnToSpell.a(localDiscussionMemberInfo.inteRemark, 1));
        localATroopMember.h(ChnToSpell.a(localDiscussionMemberInfo.inteRemark, 2));
        continue;
        label434:
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
        }
        label454:
        localObject = drw.a(this.jdField_a_of_type_Drw, localArrayList);
        if ((localObject != null) && (localObject.length == 3))
        {
          paramString = new Object[4];
          paramString[0] = localArrayList;
          paramString[1] = localObject[0];
          paramString[2] = localObject[1];
          paramString[3] = localObject[2];
        }
        for (;;)
        {
          return paramString;
          paramString = new Object[1];
          paramString[0] = localArrayList;
        }
        label522:
        i1 += 1;
      }
    }
  }
  
  public void b(String paramString)
  {
    List localList = this.jdField_d_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_d_of_type_JavaUtilList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_d_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            this.jdField_d_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public Object[] b(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      int i1;
      Object localObject2;
      TroopMemberInfo localTroopMemberInfo;
      try
      {
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        this.jdField_b_of_type_JavaUtilList = ((EntityManager)localObject1).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject1).a();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("read troop members from database, troop uin: ").append(paramString).append(" member count: ");
          if (this.jdField_b_of_type_JavaUtilList == null)
          {
            i1 = 0;
            QLog.d("TroopMemberListActivity", 2, i1);
          }
        }
        else
        {
          localObject1 = new ArrayList();
          if (this.jdField_b_of_type_JavaUtilList == null) {
            break label632;
          }
          paramString = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          i1 = 0;
          if (i1 >= this.jdField_b_of_type_JavaUtilList.size()) {
            break label612;
          }
          localObject2 = new TroopMemberListActivity.ATroopMember();
          localTroopMemberInfo = (TroopMemberInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localTroopMemberInfo == null) || (localTroopMemberInfo.memberuin == null) || (localTroopMemberInfo.memberuin.trim().length() <= 0) || (localTroopMemberInfo.memberuin.trim().equalsIgnoreCase("0")) || (localTroopMemberInfo.memberuin.trim().equalsIgnoreCase("10000")) || (localTroopMemberInfo.memberuin.trim().equalsIgnoreCase("1000000"))) {
            break label696;
          }
          if (this.s != 1) {
            continue;
          }
          if (localTroopMemberInfo.memberuin.equals(this.j)) {
            break label696;
          }
          if (!this.k.contains(localTroopMemberInfo.memberuin)) {
            continue;
          }
          break label696;
        }
        i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
        continue;
        ((TroopMemberListActivity.ATroopMember)localObject2).jdField_a_of_type_JavaLangString = localTroopMemberInfo.memberuin.trim();
        String str = paramString.a(localTroopMemberInfo);
        Friends localFriends = paramString.a(localTroopMemberInfo.memberuin);
        ((TroopMemberListActivity.ATroopMember)localObject2).b = str;
        ((TroopMemberListActivity.ATroopMember)localObject2).jdField_a_of_type_Short = localTroopMemberInfo.faceid;
        ((TroopMemberListActivity.ATroopMember)localObject2).c = ChnToSpell.a(((TroopMemberListActivity.ATroopMember)localObject2).b, 2);
        ((TroopMemberListActivity.ATroopMember)localObject2).c(ChnToSpell.a(((TroopMemberListActivity.ATroopMember)localObject2).b, 1));
        if ((localTroopMemberInfo.friendnick != null) && (localTroopMemberInfo.friendnick.length() > 0))
        {
          ((TroopMemberListActivity.ATroopMember)localObject2).d(localTroopMemberInfo.friendnick);
          ((TroopMemberListActivity.ATroopMember)localObject2).f(localTroopMemberInfo.pyAll_friendnick);
          ((TroopMemberListActivity.ATroopMember)localObject2).e(localTroopMemberInfo.pyFirst_friendnick);
        }
        if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
        {
          ((TroopMemberListActivity.ATroopMember)localObject2).g(localFriends.remark);
          ((TroopMemberListActivity.ATroopMember)localObject2).i(ChnToSpell.a(((TroopMemberListActivity.ATroopMember)localObject2).j, 1));
          ((TroopMemberListActivity.ATroopMember)localObject2).h(ChnToSpell.a(((TroopMemberListActivity.ATroopMember)localObject2).j, 2));
          if ((localTroopMemberInfo.troopnick != null) && (localTroopMemberInfo.troopnick.length() > 0))
          {
            ((TroopMemberListActivity.ATroopMember)localObject2).j(localTroopMemberInfo.troopnick);
            ((TroopMemberListActivity.ATroopMember)localObject2).l(localTroopMemberInfo.pyAll_troopnick);
            ((TroopMemberListActivity.ATroopMember)localObject2).k(localTroopMemberInfo.pyFirst_troopnick);
          }
          ((List)localObject1).add(localObject2);
        }
      }
      finally {}
      if ((localTroopMemberInfo.autoremark != null) && (localTroopMemberInfo.autoremark.length() > 0))
      {
        ((TroopMemberListActivity.ATroopMember)localObject2).g(localTroopMemberInfo.autoremark);
        ((TroopMemberListActivity.ATroopMember)localObject2).i(localTroopMemberInfo.pyAll_autoremark);
        ((TroopMemberListActivity.ATroopMember)localObject2).h(localTroopMemberInfo.pyFirst_autoremark);
        continue;
        label612:
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
        }
        label632:
        localObject2 = drw.a(this.jdField_a_of_type_Drw, (List)localObject1);
        if ((localObject2 != null) && (localObject2.length == 3))
        {
          paramString = new Object[4];
          paramString[0] = localObject1;
          paramString[1] = localObject2[0];
          paramString[2] = localObject2[1];
          paramString[3] = localObject2[2];
        }
        for (;;)
        {
          return paramString;
          paramString = new Object[0];
        }
        label696:
        i1 += 1;
      }
    }
  }
  
  public void c(String paramString)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            this.jdField_a_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_h_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561977));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new drt(this));
    }
    String str;
    do
    {
      do
      {
        return;
        if (this.jdField_h_of_type_Int == 2)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        if (this.s == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561842);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new dqs(this));
          return;
        }
        if (this.s == 2)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
      } while (this.s != 0);
      str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (((this.j == null) || (!str.equals(this.j)) || (this.jdField_a_of_type_JavaUtilList.size() <= 1)) && ((this.k == null) || (!this.k.contains(str)) || (this.jdField_a_of_type_Drw.a.length <= 1)));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562339);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new dqt(this, str));
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaUtilList.clear();
    this.f.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Dsc.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    String str1 = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramString = this.jdField_a_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label849;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
        localATroopMember.e = "";
        localATroopMember.f = "";
        if ((str1.equals(localATroopMember.m)) || (str1.equals(localATroopMember.o)) || (str1.equals(localATroopMember.n)))
        {
          localATroopMember.e = localATroopMember.m;
          localArrayList1.add(localATroopMember);
        }
        else if ((str1.equals(localATroopMember.j)) || (str1.equals(localATroopMember.l)) || (str1.equals(localATroopMember.k)))
        {
          localATroopMember.e = localATroopMember.j;
          localArrayList1.add(localATroopMember);
        }
      }
      finally {}
      if ((str2.equals(localATroopMember.g)) || (str2.equals(localATroopMember.i)) || (str2.equals(localATroopMember.jdField_h_of_type_JavaLangString)))
      {
        localATroopMember.e = localATroopMember.g;
        localArrayList1.add(localATroopMember);
      }
      else if (str2.equals(localATroopMember.jdField_a_of_type_JavaLangString))
      {
        localATroopMember.e = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList1.add(localATroopMember);
      }
      else if ((localATroopMember.m.indexOf(str2) == 0) || (localATroopMember.o.indexOf(str2) == 0) || (localATroopMember.n.indexOf(str2) == 0))
      {
        localATroopMember.e = localATroopMember.m;
        localATroopMember.f = localATroopMember.n;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.j.indexOf(str2) == 0) || (localATroopMember.l.indexOf(str2) == 0) || (localATroopMember.k.indexOf(str2) == 0))
      {
        localATroopMember.e = localATroopMember.j;
        localATroopMember.f = localATroopMember.k;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.g.indexOf(str2) == 0) || (localATroopMember.i.indexOf(str2) == 0) || (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(str2) == 0))
      {
        localATroopMember.e = localATroopMember.g;
        localATroopMember.f = localATroopMember.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) == 0)
      {
        localATroopMember.e = localATroopMember.jdField_a_of_type_JavaLangString;
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.m.indexOf(str2) > 0) || (localATroopMember.o.indexOf(str2) > 0) || (localATroopMember.n.indexOf(str2) > 0))
      {
        localATroopMember.e = localATroopMember.m;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.j.indexOf(str2) > 0) || (localATroopMember.l.indexOf(str2) > 0) || (localATroopMember.k.indexOf(str2) > 0))
      {
        localATroopMember.e = localATroopMember.j;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.g.indexOf(str2) > 0) || (localATroopMember.i.indexOf(str2) > 0) || (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(str2) > 0))
      {
        localATroopMember.e = localATroopMember.g;
        localArrayList3.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) > 0)
      {
        localATroopMember.e = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
        break label941;
        label849:
        Collections.sort(localArrayList2, new dsh(this, null));
        this.jdField_d_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_d_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_d_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_d_of_type_JavaUtilList.isEmpty()) {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Dsc.notifyDataSetChanged();
          return;
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
      }
      label941:
      i1 += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    this.q = getIntent().getStringExtra("FROM_ACTIVITY");
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
    this.o = getIntent().getStringExtra("troop_code");
    this.p = getIntent().getStringExtra("leftViewText");
    this.s = getIntent().getIntExtra("mode", 0);
    this.jdField_h_of_type_Int = getIntent().getIntExtra("param_from", 0);
    if ((this.s == 1) || (this.s == 2)) {
      setTheme(2131624539);
    }
    super.doOnCreate(paramBundle);
    setContentView(2130904037);
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
    paramBundle = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    boolean bool1;
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramBundle.a(this.jdField_h_of_type_JavaLangString);
      a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      ChnToSpell.a(this);
      if (this.jdField_h_of_type_Int == 1) {
        break label473;
      }
      if (this.jdField_h_of_type_Int != 2) {
        break label366;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.j = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.j == null) || (!this.j.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          break label361;
        }
        bool1 = true;
        label279:
        this.jdField_a_of_type_Boolean = bool1;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
    }
    label473:
    for (;;)
    {
      j();
      k();
      l();
      h();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.o);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
      break;
      label361:
      bool1 = false;
      break label279;
      label366:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
          this.j = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
          this.k = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin))
        {
          bool1 = bool2;
          if (this.k != null)
          {
            bool1 = bool2;
            if (!this.k.contains(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
          }
        }
        else
        {
          bool1 = true;
        }
        this.jdField_a_of_type_Boolean = bool1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
          this.j = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.j)) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  public void e()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903073);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_h_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231029)).setText(getString(2131562875));
      return;
      label76:
      bool = false;
    }
  }
  
  void e(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null)
      {
        localObject = ((FriendManager)localObject).a(paramString);
        if (localObject == null) {
          break label122;
        }
      }
    }
    label122:
    for (Object localObject = ((TroopInfo)localObject).troopcode;; localObject = null)
    {
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.jdField_c_of_type_Boolean = true;
        ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(true, paramString, (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + (String)localObject);
        }
      }
      return;
    }
  }
  
  public void f()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130903947);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    dqw localdqw = new dqw(this, (TranslateAnimation)localObject1, localDialog);
    ((TranslateAnimation)localObject1).setAnimationListener(localdqw);
    ((TranslateAnimation)localObject2).setAnimationListener(localdqw);
    localDialog.setOnDismissListener(new dqx(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.f = localDialog.findViewById(2131231116);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new dsi(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new dqz(this));
    localObject1 = (Button)localDialog.findViewById(2131233085);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new dra(this, localDialog));
    this.jdField_e_of_type_AndroidViewView = localDialog.findViewById(2131231402);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131231400));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new drb(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131234406));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837729));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Dsc = new dsc(this, this.jdField_d_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dsc);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new drc(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new drd(this, localDialog));
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void finish()
  {
    super.finish();
    if ((this.s == 1) || (this.s == 2)) {
      overridePendingTransition(0, 2130968590);
    }
  }
  
  public void g()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent arg3)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 0: 
      do
      {
        do
        {
          return;
          ??? = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        } while (??? == null);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ???.a(this.o);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null)) {
          this.k = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
      } while (this.jdField_a_of_type_Drw == null);
      this.jdField_a_of_type_Drw.a();
      return;
    }
    Object[] arrayOfObject = b(this.o);
    if ((arrayOfObject != null) && (arrayOfObject.length == 4)) {}
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((List)arrayOfObject[0]);
      drw.a(this.jdField_a_of_type_Drw, (LinkedHashMap)arrayOfObject[1]);
      this.jdField_a_of_type_Drw.a = ((int[])arrayOfObject[2]);
      drw.a(this.jdField_a_of_type_Drw, (String[])arrayOfObject[3]);
      if (this.jdField_a_of_type_Drw != null) {
        this.jdField_a_of_type_Drw.notifyDataSetChanged();
      }
      setResult(-1);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
  }
  
  protected void onDestroy()
  {
    try
    {
      b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      label16:
      if (this.jdField_a_of_type_Dsc != null) {
        this.jdField_a_of_type_Dsc.b();
      }
      super.onDestroy();
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (this.jdField_a_of_type_Drw != null) {
        this.jdField_a_of_type_Drw.b();
      }
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    getWindow().setSoftInputMode(48);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_AndroidViewView.invalidate();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    getWindow().setSoftInputMode(16);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */