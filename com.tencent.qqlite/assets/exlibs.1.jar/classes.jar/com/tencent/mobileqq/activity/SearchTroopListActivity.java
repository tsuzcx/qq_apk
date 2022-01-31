package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import bip;
import biq;
import bir;
import bis;
import bit;
import biu;
import biw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class SearchTroopListActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener
{
  public static final int a = 12;
  static final String jdField_a_of_type_JavaLangString = SearchTroopListActivity.class.getSimpleName();
  private static final String b = "keyword";
  private static final String jdField_c_of_type_JavaLangString = "troop_list";
  private static final String jdField_d_of_type_JavaLangString = "is_finish";
  public Dialog a;
  public View a;
  public LinearLayout a;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  public TextView a;
  public biu a;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bit(this);
  public XListView a;
  public List a;
  public boolean a;
  public int b;
  public TextView b;
  public int c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private String e;
  
  public SearchTroopListActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static int a(SearchGroup.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.bGroupAllow.has()) && (paramGroupInfo.bGroupAllow.get())) {
      return 2;
    }
    return 3;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.d) {}
    while (!a(paramInt, 0)) {
      return;
    }
    this.d = paramInt;
    i();
    this.jdField_b_of_type_Int = 0;
    b(2131363773);
  }
  
  public static void a(Activity paramActivity, String paramString, List paramList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SearchTroopListActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("is_finish", paramBoolean);
    localIntent.putParcelableArrayListExtra("troop_list", SearchTroopListActivity.StrangeTroopWrapper.a(paramList));
    paramActivity.startActivity(localIntent);
  }
  
  private void a(View paramView)
  {
    k();
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {}
    try
    {
      int i = a();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setPadding(0, i, 0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(getWindow().getDecorView(), 48, 0, 0);
      return;
    }
    catch (Exception paramView) {}
  }
  
  private void a(SearchGroup.GroupInfo paramGroupInfo)
  {
    Intent localIntent = new Intent(this, AddFriendVerifyActivity.class);
    localIntent.putExtra("uin", paramGroupInfo.dwGroupUin.get());
    localIntent.putExtra("troop_code", paramGroupInfo.dwGroupCode.get());
    localIntent.putExtra("nick_name", paramGroupInfo.sGroupName.get());
    localIntent.putExtra("friend_setting", 9);
    localIntent.putExtra("group_option", (byte)a(paramGroupInfo));
    startActivity(localIntent);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131362916), 0).b(this.jdField_c_of_type_Int);
      return false;
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    long l = Long.parseLong(this.app.a());
    switch (paramInt1)
    {
    default: 
      return true;
    case 2131298705: 
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 1, 0L);
      return true;
    case 2131298706: 
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 2, 0L);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 4, 0L);
    return true;
  }
  
  private void b(int paramInt)
  {
    c();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, this.jdField_c_of_type_Int);
    localQQProgressDialog.a(getString(paramInt));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new biq(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new bir(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void b(SearchGroup.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null) {
      TroopUtils.a(this, TroopUtils.a(6, paramGroupInfo, 0), 2);
    }
  }
  
  private void f()
  {
    boolean bool = false;
    Intent localIntent = getIntent();
    this.d = 2131298705;
    this.e = localIntent.getStringExtra("keyword");
    this.jdField_a_of_type_JavaUtilList = SearchTroopListActivity.StrangeTroopWrapper.a(localIntent.getParcelableArrayListExtra("troop_list"));
    if (!localIntent.getBooleanExtra("is_finish", false)) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Int = 1;
  }
  
  private void g()
  {
    h();
    j();
  }
  
  private void h()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131296890);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131296897);
    View localView1 = localViewGroup.findViewById(2131297715);
    TextView localTextView2 = (TextView)localView1.findViewById(2131296891);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131297716));
    View localView2 = localViewGroup.findViewById(2131298708);
    IphoneTitleBarActivity.setLayerType(localViewGroup);
    IphoneTitleBarActivity.setLayerType(localTextView2);
    IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.setLayerType(localTextView1);
    IphoneTitleBarActivity.setLayerType(localView2);
    localTextView2.setText(2131363769);
    localView1.setOnClickListener(this);
    i();
    localTextView1.setOnClickListener(this);
    localView2.setOnClickListener(this);
  }
  
  private void i()
  {
    switch (this.d)
    {
    default: 
      return;
    case 2131298705: 
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363770);
      return;
    case 2131298706: 
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363771);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363772);
  }
  
  private void j()
  {
    View localView = findViewById(2131298822);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131298824));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298825));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("没找到适合条件的群");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131298823));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903239, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297311));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363196);
    this.jdField_a_of_type_Biu = new biu(this, this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Biu.a(new bip(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Biu);
  }
  
  private void k()
  {
    View localView1 = getLayoutInflater().inflate(2130903605, null);
    View localView2 = localView1.findViewById(2131298705);
    View localView3 = localView1.findViewById(2131298706);
    View localView4 = localView1.findViewById(2131298707);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView1, -1, -1, true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchInterceptor(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624153);
    localView1.setOnClickListener(new bis(this));
  }
  
  public int a()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    int i = j;
    if (j == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i = getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException) {}
    return j;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      if (this.jdField_a_of_type_Boolean) {
        e();
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0));
      paramAdapterView = (biw)paramView.getTag();
    } while (paramAdapterView == null);
    b(paramAdapterView.a);
  }
  
  protected boolean a()
  {
    finish();
    return false;
  }
  
  protected String b_()
  {
    return getString(2131363769);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(17));
    f();
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131492887);
    setContentView(2130903647);
    d(2130837635);
    g();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131296558).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297310).setVisibility(8);
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297311);
      paramBundle.setVisibility(0);
      paramBundle.setText("没有更多");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_Biu.b();
    super.doOnDestroy();
  }
  
  public void e()
  {
    if (a(this.d, this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363215);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131296558);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297310);
      localProgressBar.setVisibility(0);
      localImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296897: 
      a();
      return;
    case 2131297715: 
    case 2131298708: 
      a(paramView);
      return;
    }
    d();
    a(paramView.getId());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      d();
      return true;
    }
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchTroopListActivity
 * JD-Core Version:    0.7.0.1
 */