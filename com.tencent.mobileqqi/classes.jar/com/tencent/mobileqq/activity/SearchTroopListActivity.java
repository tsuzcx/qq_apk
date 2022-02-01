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
import dhd;
import dhe;
import dhf;
import dhg;
import dhh;
import dhi;
import dhk;
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
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dhh(this);
  public XListView a;
  public dhi a;
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
    b(2131562832);
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
    localIntent.putExtra("uin", paramGroupInfo.dwGroupCode.get());
    localIntent.putExtra("nick_name", paramGroupInfo.sGroupName.get());
    localIntent.putExtra("friend_setting", 9);
    localIntent.putExtra("group_option", (byte)a(paramGroupInfo));
    startActivity(localIntent);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131562451), 0).b(this.jdField_c_of_type_Int);
      return false;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    switch (paramInt1)
    {
    default: 
      return true;
    case 2131234407: 
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 1, 0L);
      return true;
    case 2131234408: 
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
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new dhe(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new dhf(this));
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
    this.d = 2131234407;
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
    Object localObject1 = (ViewGroup)findViewById(2131231447);
    TextView localTextView1 = (TextView)((ViewGroup)localObject1).findViewById(2131231455);
    Object localObject2 = ((ViewGroup)localObject1).findViewById(2131234410);
    TextView localTextView2 = (TextView)((View)localObject2).findViewById(2131231375);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131234411));
    View localView = ((ViewGroup)localObject1).findViewById(2131234412);
    IphoneTitleBarActivity.b((View)localObject1);
    IphoneTitleBarActivity.b(localTextView2);
    IphoneTitleBarActivity.b(this.jdField_c_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.b(localTextView1);
    IphoneTitleBarActivity.b(localView);
    localTextView2.setText(2131562828);
    ((View)localObject2).setOnClickListener(this);
    g(localTextView2.getText().toString());
    i();
    localObject2 = getIntent().getStringExtra("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131561692);
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView1.setOnClickListener(this);
    localView.setOnClickListener(this);
  }
  
  private void i()
  {
    switch (this.d)
    {
    default: 
      return;
    case 2131234407: 
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131562745);
      return;
    case 2131234408: 
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131562360);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131562653);
  }
  
  private void j()
  {
    View localView = findViewById(2131234536);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131234538));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131234539));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131559112));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131234537));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903283, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231868));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562926);
    this.jdField_a_of_type_Dhi = new dhi(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Dhi.a(new dhd(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dhi);
  }
  
  private void k()
  {
    View localView1 = getLayoutInflater().inflate(2130903948, null);
    View localView2 = localView1.findViewById(2131234407);
    View localView3 = localView1.findViewById(2131234408);
    View localView4 = localView1.findViewById(2131234409);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView1, -1, -1, true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchInterceptor(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624440);
    localView1.setOnClickListener(new dhg(this));
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
      paramAdapterView = (dhk)paramView.getTag();
    } while (paramAdapterView == null);
    b(paramAdapterView.a);
  }
  
  protected String a_()
  {
    return getString(2131562828);
  }
  
  protected boolean b()
  {
    finish();
    return false;
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
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    f();
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131427376);
    setContentView(2130903992);
    j(2130837729);
    g();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131231066).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131231867).setVisibility(8);
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231868);
      paramBundle.setVisibility(0);
      paramBundle.setText(getResources().getString(2131559111));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_Dhi.b();
    super.doOnDestroy();
  }
  
  public void e()
  {
    if (a(this.d, this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562411);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131231066);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231867);
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
    case 2131231455: 
      b();
      return;
    case 2131234410: 
    case 2131234412: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchTroopListActivity
 * JD-Core Version:    0.7.0.1
 */