package com.tencent.mobileqq.troop.createNewTroop;

import acbn;
import acfd;
import acfp;
import amoj;
import amok;
import amoo;
import amop;
import ampt;
import amsf.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoyo;
import aoys;
import aoyt;
import aoyu;
import aoyv;
import aoyw;
import aoyx;
import aoyy;
import aoyz;
import aoza;
import aozi;
import apbc;
import apbc.c;
import apbc.e;
import apuh;
import aqcl;
import aqdf;
import aqdf.a;
import aqgv;
import aqhu;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class NewTroopContactView
  extends AbsNewTroopBaseView
  implements amsf.a, View.OnClickListener, apbc.c
{
  protected ImageView Ek;
  protected View Id;
  protected long MP;
  public EditText T;
  protected acfd a;
  public aoyo a;
  protected aqdf a;
  public a a;
  protected QQBlurView a;
  public ArrayList<ResultRecord> aQ = new ArrayList();
  public FrameLayout aS;
  protected boolean aT;
  long aqD = 0L;
  public CustomHorizontalScrollView b;
  InputMethodRelativeLayout b;
  public PinnedFooterExpandableListView b;
  protected boolean bBe;
  public boolean bal = true;
  public aozi c;
  public ContactSearchFragment c;
  private boolean cPp = true;
  private boolean cPq = true;
  protected int cms;
  protected int cmt;
  protected InputMethodManager d;
  protected Dialog dialog;
  protected Bitmap dk;
  protected Button fq;
  protected Button fr;
  protected Button fs;
  protected Button ft;
  protected Button fw;
  protected Button fx;
  protected RelativeLayout iU;
  public GridView m;
  protected float mDensity;
  protected int mFrom = 0;
  private final Handler mHandler = new aoys(this);
  public ArrayList<String> so;
  public ArrayList<String> sr;
  
  public NewTroopContactView(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super(paramNewTroopCreateActivity);
  }
  
  private void Bd(String paramString)
  {
    int i = 0;
    while (i < this.aQ.size())
    {
      if (((ResultRecord)this.aQ.get(i)).uin.equals(paramString)) {
        this.aQ.remove(i);
      }
      i += 1;
    }
    cAh();
  }
  
  private void Be(String paramString)
  {
    if (System.currentTimeMillis() - this.MP > 2000)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, paramString, 2000).show(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getTitleBarHeight());
      this.MP = System.currentTimeMillis();
    }
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.QD = paramString3;
    return localResultRecord;
  }
  
  private boolean aAG()
  {
    boolean bool = false;
    if (this.aQ.size() >= this.cms) {
      if (this.so == null) {
        break label67;
      }
    }
    label67:
    for (int i = this.so.size();; i = 0)
    {
      Be(String.format(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131696700), new Object[] { Integer.valueOf(i + this.cms) }));
      bool = true;
      return bool;
    }
  }
  
  @TargetApi(19)
  private void aH()
  {
    this.aT = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.aT)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      if ("1103".equals(ThemeUtil.curThemeId)) {
        this.Id.setBackgroundColor(-15921907);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iD(this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YJ(-1);
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (Build.VERSION.SDK_INT >= 24) {}
    for (boolean bool = true;; bool = false)
    {
      localQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YI(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.bg(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YK(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130851099);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new aoyv(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
      this.Id.setBackgroundColor(0);
      return;
    }
  }
  
  private void bNU()
  {
    this.d.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.T.setText("");
    this.T.clearFocus();
    this.aS.setVisibility(8);
    this.bBe = false;
  }
  
  private ArrayList<String> dQ()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.aQ.size())
    {
      localArrayList.add(((ResultRecord)this.aQ.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
  
  private void dXU()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getIntent().getBooleanExtra("isExpandFirst", true);
    this.jdField_a_of_type_Aoyo = new aoyo(this, this.app, this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView, bool);
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Aoyo);
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167595);
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources().getDrawable(2130839740));
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Aoyo);
    this.jdField_a_of_type_Acfd = new aoyt(this);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
    this.jdField_c_of_type_Aozi = new aozi(this.app, this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView, new aoyu(this));
    this.jdField_a_of_type_Aoyo.a(this.jdField_c_of_type_Aozi);
  }
  
  private void dXW()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_troop_or_discussion_member", true);
    localIntent.putExtra("param_entrance", 27);
    localIntent.putExtra("param_selected_records_for_create_discussion", this.aQ);
    localIntent.putExtra("param_overload_tips_include_default_count", true);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131692294));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131719437));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131719438));
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_min", 0);
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_exit_animation", 2);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.overridePendingTransition(2130772345, 0);
    anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_chose", 0, 0, "", "" + this.mFrom, "", "");
  }
  
  private void dXX()
  {
    ResultRecord localResultRecord = null;
    if (this.aQ.size() > 0) {
      localResultRecord = (ResultRecord)this.aQ.get(this.aQ.size() - 1);
    }
    this.jdField_c_of_type_Aozi.b(localResultRecord);
  }
  
  public static void setCreateTroopButtonEnable(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramButton.getContext();
      paramButton.setBackgroundResource(2130839524);
      paramButton.setTextColor(localContext.getResources().getColor(2131167335));
      paramButton.setAlpha(1.0F);
    }
    for (;;)
    {
      paramButton.setEnabled(paramBoolean);
      return;
      paramButton.setTextColor(Color.parseColor("#ffffff"));
      paramButton.setBackgroundResource(2130851043);
      paramButton.setAlpha(0.5F);
    }
  }
  
  public void Bb(String paramString)
  {
    apuh.f(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, paramString, true);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.finish();
  }
  
  public void Bf(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("createNewTroop.NewTroopContactView", 2, "onRelationTroopItemClick: empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("createNewTroop.NewTroopContactView", 2, "onRelationTroopItemClick: troopUin:" + paramString);
    }
    Bb(paramString);
    this.jdField_c_of_type_Aozi.dYe();
  }
  
  protected void Rs(boolean paramBoolean)
  {
    if (!paramBoolean) {
      dXW();
    }
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 4194309, null, this.sr, this);
  }
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super.a(paramNewTroopCreateActivity);
    cAb();
    this.mDensity = getResources().getDisplayMetrics().density;
    initViews();
    cAd();
    initSearchBar();
    dXU();
    this.dk = aqhu.G();
    this.jdField_a_of_type_Aqdf = new aqdf(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, this.app);
    this.jdField_a_of_type_Aqdf.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView$a);
    anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_person", 0, 0, "", "" + this.mFrom, "", "");
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = false;
    if (iX(paramString1)) {
      Bd(paramString1);
    }
    for (;;)
    {
      cz(bool);
      cAh();
      return bool;
      if (!aAG())
      {
        bool = true;
        this.aQ.add(a(paramString1, paramString2, paramInt, paramString3));
      }
    }
  }
  
  public void bE(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.finish();
    }
    do
    {
      return;
      paramInt = apbc.e.jG(paramInt);
    } while (paramInt == 0);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, 1, paramInt, 0).show(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getTitleBarHeight());
  }
  
  public void bF(int paramInt, String paramString) {}
  
  protected void bLX()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.mDensity * 40.0F));
    int i = (int)(this.mDensity * 40.0F);
    int j = (int)(this.mDensity * 10.0F);
    if (this.aQ.size() > 0) {
      if (this.aQ.size() < 5)
      {
        i = (int)((this.aQ.size() * 40 + this.aQ.size() * 10) * this.mDensity) + (int)(this.mDensity * 10.0F);
        this.Ek.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i, 0, j, 0);
      this.T.setLayoutParams(localLayoutParams);
      return;
      i = (int)(230.0F * this.mDensity);
      break;
      this.Ek.setVisibility(0);
    }
  }
  
  protected void cAb()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getIntent();
    this.so = localIntent.getStringArrayListExtra("param_uins_selected_default");
    this.sr = localIntent.getStringArrayListExtra("param_uins_hide");
    if (this.sr == null) {
      this.sr = new ArrayList();
    }
    this.sr.add(acbn.blz);
    this.cms = localIntent.getIntExtra("param_max", 2147483647);
    this.cmt = localIntent.getIntExtra("param_min", 1);
    this.mFrom = localIntent.getIntExtra("create_source", 0);
  }
  
  @SuppressLint({"NewApi"})
  protected void cAd()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.m.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView$a = new a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity);
    this.m.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView$a);
    this.m.setSmoothScrollbarEnabled(false);
    this.m.setOnItemClickListener(new aoyw(this));
  }
  
  protected void cAh()
  {
    String str = null;
    Iterator localIterator = this.aQ.iterator();
    int i = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type != 5) {
        break label231;
      }
      if (i >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_c_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_c_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.N(dQ(), this.so);
      }
      i = this.aQ.size();
      if (i <= 0) {
        break label196;
      }
      str = MessageFormat.format(acfp.m(2131709116), new Object[] { Integer.valueOf(i) });
      this.fx.setText(str);
      this.fx.setContentDescription(str);
      setCreateTroopButtonEnable(this.fx, true);
      return;
    }
    if (str == null)
    {
      str = localResultRecord.name;
      label157:
      i += 1;
    }
    label196:
    label231:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.name;
      break label157;
      this.fx.setText(acfp.m(2131709117));
      this.fx.setContentDescription(acfp.m(2131709113));
      setCreateTroopButtonEnable(this.fx, false);
      return;
    }
  }
  
  public void cR(View paramView)
  {
    ampt localampt = (ampt)paramView.getTag(2131381960);
    if (localampt == null) {
      return;
    }
    String str1 = localampt.getUin();
    String str2 = localampt.getTitle().toString();
    paramView = "-1";
    label52:
    int i;
    if ((localampt instanceof amoj))
    {
      paramView = ((amoj)localampt).zc();
      if (((this.so != null) && (this.so.contains(str1))) || (iX(str1)) || (aAG())) {
        break label165;
      }
      if (!(localampt instanceof amoj)) {
        break label167;
      }
      i = 2;
    }
    for (;;)
    {
      if (i != -1) {
        this.aQ.add(a(str1, str2, i, paramView));
      }
      cAh();
      this.jdField_a_of_type_Aoyo.notifyDataSetChanged();
      cz(true);
      this.T.setText("");
      dXX();
      return;
      if (!(localampt instanceof amoo)) {
        break label52;
      }
      paramView = ((amoo)localampt).mTroopUin;
      break label52;
      label165:
      break;
      label167:
      if ((localampt instanceof amoo)) {
        i = 1;
      } else if ((localampt instanceof amok)) {
        i = 0;
      } else if ((localampt instanceof amop))
      {
        if (str1.startsWith("+")) {
          i = 4;
        } else {
          i = 0;
        }
      }
      else {
        i = -1;
      }
    }
  }
  
  public void cz(boolean paramBoolean)
  {
    this.m.setNumColumns(this.aQ.size());
    ViewGroup.LayoutParams localLayoutParams = this.m.getLayoutParams();
    localLayoutParams.width = ((int)((this.aQ.size() * 40 + this.aQ.size() * 10) * this.mDensity));
    this.m.setLayoutParams(localLayoutParams);
    bLX();
    if (paramBoolean) {
      this.mHandler.sendEmptyMessageDelayed(2, 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView$a.notifyDataSetChanged();
  }
  
  public void dXT()
  {
    if (this.aQ.size() < 1) {}
    apbc localapbc;
    do
    {
      do
      {
        return;
      } while (System.currentTimeMillis() - this.aqD < 1500L);
      this.aqD = System.currentTimeMillis();
      localapbc = (apbc)this.app.getManager(32);
    } while (localapbc == null);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("group_type", 1);
      ((JSONObject)localObject).put("name", aqgv.n(this.app, this.app.getCurrentAccountUin()) + acfp.m(2131709115));
      ((JSONObject)localObject).put("classify", 10010);
      ((JSONObject)localObject).put("isJumpAio", 1);
      ((JSONObject)localObject).put("create_source", this.mFrom);
      localapbc.gi(((JSONObject)localObject).toString(), 5);
      localObject = new ArrayList(this.aQ.size());
      ((ArrayList)localObject).addAll(this.aQ);
      localapbc.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, (ArrayList)localObject);
      anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + this.mFrom, "", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected void dXV()
  {
    this.T.setOnFocusChangeListener(new aoyx(this));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.T == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int[] arrayOfInt = new int[2];
    this.T.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if ((paramMotionEvent.getX() >= i) && (paramMotionEvent.getX() <= i + this.T.getWidth()) && (paramMotionEvent.getY() >= j) && (paramMotionEvent.getY() > j + this.T.getHeight())) {}
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean e(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.aQ.clear();
    }
    HashSet localHashSet = new HashSet(this.aQ.size());
    Object localObject = this.aQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    if (this.so != null)
    {
      localObject = this.so.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ResultRecord)paramList.next();
      if (!localHashSet.contains(((ResultRecord)localObject).uin))
      {
        if (aAG()) {
          break;
        }
        this.aQ.add(localObject);
      }
    }
    cz(true);
    cAh();
    dXX();
    return true;
  }
  
  public void gR()
  {
    if (this.T != null)
    {
      this.T.clearFocus();
      ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.T.getWindowToken(), 0);
    }
  }
  
  public boolean iX(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.aQ.size())
      {
        if (((ResultRecord)this.aQ.get(i)).uin.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void initSearchBar()
  {
    if (this.d == null) {
      this.d = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getSystemService("input_method"));
    }
    dXV();
    this.T.setOnKeyListener(new aoyy(this));
    this.T.addTextChangedListener(new aoyz(this));
    this.aS.setOnTouchListener(new aoza(this));
  }
  
  @TargetApi(14)
  protected void initViews()
  {
    setContentView(2131560784);
    this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131372324));
    this.Id = findViewById(2131365523);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)findViewById(2131377766));
    this.m = ((GridView)findViewById(2131377967));
    aqcl.Q(this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    this.Ek = ((ImageView)findViewById(2131377780));
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)findViewById(2131366559));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getLayoutInflater().inflate(2131560610, null);
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localLinearLayout);
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity);
    localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(68.0F, getResources())));
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.addFooterView(localTextView);
    this.aS = ((FrameLayout)findViewById(2131377207));
    this.aS.setVisibility(8);
    this.T = ((EditText)findViewById(2131377838));
    this.iU = ((RelativeLayout)localLinearLayout.findViewById(2131363831));
    this.iU.setVisibility(8);
    this.fr = ((Button)localLinearLayout.findViewById(2131363879));
    this.fr.setVisibility(8);
    this.fw = ((Button)localLinearLayout.findViewById(2131363874));
    this.fw.setVisibility(8);
    this.ft = ((Button)localLinearLayout.findViewById(2131363833));
    this.ft.setVisibility(8);
    this.fq = ((Button)localLinearLayout.findViewById(2131363875));
    this.fq.setOnClickListener(this);
    this.fs = ((Button)localLinearLayout.findViewById(2131363834));
    this.fs.setOnClickListener(this);
    this.fs.setText(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131689891));
    this.fs.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131689891));
    this.fx = ((Button)findViewById(2131365522));
    this.fx.setOnClickListener(this);
    setCreateTroopButtonEnable(this.fx, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363636));
    if (Build.VERSION.SDK_INT >= 19) {
      aH();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        e(paramIntent, true);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.T.getText()))
    {
      bNU();
      return true;
    }
    if (this.T.hasFocus()) {
      bNU();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, CreateFaceToFaceDiscussionActivity.class);
      localIntent.putExtra("create_source", this.mFrom);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(localIntent);
      anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_face", 0, 0, "", "" + this.mFrom, "", "");
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.Rt(false);
      continue;
      dXT();
    }
  }
  
  protected void onDestroy()
  {
    if (this.T.hasFocus()) {
      bNU();
    }
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if (this.jdField_a_of_type_Aoyo != null) {
      this.jdField_a_of_type_Aoyo.destroy();
    }
    apbc localapbc = (apbc)this.app.getManager(32);
    if (localapbc != null) {
      localapbc.a(this);
    }
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.cPq)
    {
      this.cPq = false;
      anot.a(this.app, "dc00899", "Grp_create", "", "grptab", "select_exp", 0, 0, "", "" + this.mFrom, "", "");
      if (this.cPp) {
        this.cPp = false;
      }
    }
    else
    {
      return;
    }
    anot.a(this.app, "dc00899", "Grp_create", "", "grptab", "select_clk", 0, 0, "", "" + this.mFrom, "", "");
  }
  
  protected void onStop()
  {
    super.onStop();
    this.cPq = true;
  }
  
  public class a
    extends BaseAdapter
    implements aqdf.a
  {
    private boolean aUL;
    private Context context;
    private final Drawable dy;
    
    public a(Context paramContext)
    {
      this.dy = paramContext.getResources().getDrawable(2130845851);
      this.context = paramContext;
    }
    
    public void bLZ()
    {
      if (this.aUL)
      {
        if ((NewTroopContactView.this.aQ != null) && (NewTroopContactView.this.aQ.size() > 0))
        {
          String str = ((ResultRecord)NewTroopContactView.this.aQ.get(NewTroopContactView.this.aQ.size() - 1)).uin;
          if (NewTroopContactView.this.iX(str))
          {
            NewTroopContactView.a(NewTroopContactView.this, str);
            NewTroopContactView.this.jdField_a_of_type_Aoyo.notifyDataSetChanged();
            NewTroopContactView.this.cz(false);
            NewTroopContactView.a(NewTroopContactView.this);
          }
        }
        this.aUL = false;
        return;
      }
      this.aUL = true;
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return NewTroopContactView.this.aQ.size();
    }
    
    public Object getItem(int paramInt)
    {
      return NewTroopContactView.this.aQ.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
      if (paramView == null) {
        paramView = NewTroopContactView.this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getLayoutInflater().inflate(2131559454, null);
      }
      for (;;)
      {
        paramView.setTag(localResultRecord);
        ImageView localImageView = (ImageView)paramView.findViewById(2131366624);
        if (paramInt == getCount() - 1) {
          if (this.aUL)
          {
            localObject = this.dy;
            localImageView.setImageDrawable((Drawable)localObject);
            label78:
            localImageView.setBackgroundDrawable(null);
            if (localResultRecord.type != 4) {
              break label190;
            }
          }
        }
        TextView localTextView;
        label190:
        for (int i = 11;; i = 1)
        {
          localTextView = (TextView)paramView.findViewById(2131380753);
          if (localResultRecord.type != 5) {
            break label196;
          }
          localImageView.setImageResource(2130842937);
          localTextView.setVisibility(0);
          localTextView.setText(aqgv.ps(localResultRecord.name));
          if (AppSetting.enableTalkBack) {
            localImageView.setContentDescription(localResultRecord.name);
          }
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localObject = null;
          break;
          localImageView.setImageDrawable(null);
          break label78;
        }
        label196:
        String str = localResultRecord.uin;
        Object localObject = NewTroopContactView.this.jdField_a_of_type_Aqdf.b(i, str);
        if (localObject == null)
        {
          NewTroopContactView.this.jdField_a_of_type_Aqdf.i(str, i, true);
          localObject = NewTroopContactView.this.dk;
        }
        for (;;)
        {
          localImageView.setBackgroundDrawable(new BitmapDrawable(NewTroopContactView.this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources(), (Bitmap)localObject));
          localTextView.setVisibility(8);
          break;
        }
      }
    }
    
    public void notifyDataSetChanged()
    {
      this.aUL = false;
      super.notifyDataSetChanged();
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      if (NewTroopContactView.this.m == null) {}
      for (;;)
      {
        return;
        paramInt1 = 0;
        while (paramInt1 < NewTroopContactView.this.m.getChildCount())
        {
          View localView = NewTroopContactView.this.m.getChildAt(paramInt1);
          Object localObject = localView.getTag();
          if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).uin))) {
            ((ImageView)localView.findViewById(2131366624)).setBackgroundDrawable(new BitmapDrawable(NewTroopContactView.this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources(), paramBitmap));
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView
 * JD-Core Version:    0.7.0.1
 */