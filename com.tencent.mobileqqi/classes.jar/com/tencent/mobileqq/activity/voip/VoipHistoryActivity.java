package com.tencent.mobileqq.activity.voip;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.AdapterContextMenuInfo;
import fbc;
import fbd;
import fbe;
import fbf;
import fbg;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VoipHistoryActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnCreateContextMenuListener, Observer
{
  public static int a = 0;
  public static final String a = "VoipHistoryActivity";
  public static int b = 0;
  public static final String b = "VoipHistoryActivity_qqvoice";
  public static final String c = "dialData";
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private VoipHistoryInterface jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = null;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private fbg jdField_a_of_type_Fbg;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private View c;
  public String d = "";
  public String e = "";
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 0;
  }
  
  public static int a(Context paramContext)
  {
    switch (HwNetworkUtil.getSystemNetwork(paramContext))
    {
    default: 
      return 7;
    case 1: 
      return 1;
    case 4: 
      return 2;
    case 3: 
      return 3;
    case 2: 
      return 4;
    }
    return 5;
  }
  
  private void d()
  {
    super.onBackPressed();
  }
  
  private void e()
  {
    Object localObject = (QCallFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject != null) {
      ((QCallFacade)localObject).addObserver(this);
    }
    setTitle(getString(2131559900));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234692);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131234691));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Fbg = new fbg(this, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Fbg);
    registerForContextMenu(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnCreateContextMenuListener(this);
    localObject = getSharedPreferences("VOIP_share", 0);
    if ((localObject != null) && (((SharedPreferences)localObject).getInt("voip_firstuse", 0) == 0))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("voip_firstuse", 1);
      ((SharedPreferences.Editor)localObject).commit();
      this.c = findViewById(2131234695);
      this.c.setVisibility(0);
      ((TextView)findViewById(2131232040)).setVisibility(8);
      ((TextView)findViewById(2131232041)).setVisibility(8);
      ((TextView)findViewById(2131232042)).setText(2131559867);
      localObject = (Button)findViewById(2131232039);
      ((Button)localObject).setText(2131559868);
      ((Button)localObject).setOnClickListener(this);
    }
  }
  
  public void a(View paramView)
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_else", 0, 1, 0, "", "", "1", "");
    paramView = new Intent();
    paramView.setClass(this, VoipDialInterfaceActivity.class);
    startActivity(paramView);
  }
  
  public void b(View paramView)
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_else", 0, 1, 0, "", "1", "", "");
    paramView = (fbf)((ViewGroup)paramView.getParent()).getTag();
    Intent localIntent = new Intent();
    if (paramView.a.type == jdField_b_of_type_Int)
    {
      localIntent.setClass(this, VoipDetailActivity.class);
      localIntent.putExtra("source", "VoipHistoryActivity");
      localIntent.putExtra("object", paramView.a);
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      localIntent.setClass(this, VoipDetailActivity.class);
      localIntent.putExtra("source", "VoipHistoryActivity_qqvoice");
      localIntent.putExtra("uin", ((QCallRecent)paramView.a.obj).uin);
      localIntent.putExtra("troop_uin", ((QCallRecent)paramView.a.obj).troopUin);
      localIntent.putExtra("uintype", ((QCallRecent)paramView.a.obj).type);
      localIntent.putExtra("uinname", ((QCallRecent)paramView.a.obj).displayName);
    }
  }
  
  public void c(View paramView)
  {
    paramView = (fbf)((ViewGroup)paramView.getParent()).getTag();
    Intent localIntent = new Intent();
    int i;
    Object localObject;
    if (paramView.a.type == jdField_b_of_type_Int)
    {
      localIntent.setClass(this, VoipDialInterfaceActivity.class);
      localIntent.putExtra("dialData", new VoipDialData(((VoipHistoryData)paramView.a.obj).countryCode, ((VoipHistoryData)paramView.a.obj).phoneNumberWithoutCountry));
      localIntent.putExtra("callNow", 1);
      i = a(getApplicationContext());
      localObject = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "qq_outing", 1, 1, 0, String.valueOf(i), ((RespondQueryQQBindingStat)localObject).nationCode, ((VoipHistoryData)paramView.a.obj).countryCode, "");
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      QCallRecent localQCallRecent = (QCallRecent)paramView.a.obj;
      if (localQCallRecent != null)
      {
        i = localQCallRecent.type;
        label214:
        String str1;
        String str2;
        if (i == 1006)
        {
          paramView = localQCallRecent.uin;
          localObject = null;
          str1 = localQCallRecent.troopUin;
          str2 = localQCallRecent.displayName;
          if (!localQCallRecent.isVideo()) {
            break label310;
          }
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_else", 0, 1, 0, "2", "", "", "");
        }
        for (boolean bool = false;; bool = true)
        {
          if (localQCallRecent.type != 3000) {
            break label343;
          }
          ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject, true, true, null);
          break;
          localObject = localQCallRecent.uin;
          paramView = null;
          break label214;
          label310:
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_else", 0, 1, 0, "1", "", "", "");
        }
        label343:
        ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, a(), i, (String)localObject, str2, paramView, bool, str1, true, true, null, "from_internal");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null) {
      unregisterForContextMenu(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.deleteObserver(this);
    }
    QCallFacade localQCallFacade = (QCallFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localQCallFacade != null) {
      localQCallFacade.deleteObserver(this);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968593, 2130968594);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if ((this.jdField_a_of_type_Fbg != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(this);
      this.jdField_a_of_type_Fbg.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(paramView);
      return;
      d();
      return;
      c(paramView);
      return;
      b(paramView);
      return;
    } while (this.c == null);
    this.c.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("VoipHistoryActivity", 2, "OnCreate OK.");
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      setContentView(2130904057);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface = VoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.addObserver(this);
      this.d = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.e = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(this);
      QLog.d("VoipHistoryActivity", 2, "DataBase OK.");
      e();
      QLog.d("VoipHistoryActivity", 2, "InitailViews OK.");
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234694));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = findViewById(2131234686);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView != null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234689));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, getString(2131559901));
    paramContextMenu.add(0, 2, 0, getString(2131559902));
    paramView = (VoipHistoryAllType)this.jdField_a_of_type_JavaUtilArrayList.get(((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).jdField_a_of_type_Int);
    if (paramView.type == jdField_b_of_type_Int)
    {
      paramView = (VoipHistoryData)paramView.obj;
      if (paramView.contactLookupId != null)
      {
        paramContextMenu.setHeaderTitle(paramView.strContactName);
        paramContextMenu.getItem(0).setOnMenuItemClickListener(new fbc(this));
      }
    }
    for (;;)
    {
      paramContextMenu.getItem(1).setOnMenuItemClickListener(new fbe(this));
      return;
      if (!TextUtils.isEmpty(paramView.nickName))
      {
        paramContextMenu.setHeaderTitle(paramView.nickName);
        break;
      }
      if (TextUtils.isEmpty(paramView.countryCode)) {}
      for (paramView = paramView.phoneNumberWithoutCountry;; paramView = paramView.countryCode + paramView.phoneNumberWithoutCountry)
      {
        paramContextMenu.setHeaderTitle(paramView);
        break;
      }
      paramContextMenu.setHeaderTitle(((QCallRecent)paramView.obj).displayName);
      paramContextMenu.getItem(0).setOnMenuItemClickListener(new fbd(this));
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.add(0, 2131234690, 0, "");
    localMenuItem.setIcon(2130840480);
    localMenuItem.setTitle(getString(2131559881));
    MenuItemCompat.setShowAsAction(localMenuItem, 1);
    localMenuItem = paramMenu.add(0, 2131234689, 0, "");
    localMenuItem.setTitle(getString(2131559874));
    MenuItemCompat.setShowAsAction(localMenuItem, 0);
    localMenuItem = paramMenu.add(0, 2131234689, 1, "");
    localMenuItem.setTitle(getString(2131559875));
    MenuItemCompat.setShowAsAction(localMenuItem, 0);
    localMenuItem = paramMenu.add(0, 2131234689, 2, "");
    localMenuItem.setTitle(getString(2131559876));
    MenuItemCompat.setShowAsAction(localMenuItem, 0);
    localMenuItem = paramMenu.add(0, 2131234689, 3, "");
    localMenuItem.setTitle(getString(2131559877));
    MenuItemCompat.setShowAsAction(localMenuItem, 0);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_Actionbar", 0, 1, 0, "1", "", "", "");
      Object localObject = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject != null)
      {
        startActivity(new Intent(this, VoipAddressBookActivity.class));
        ((PhoneContactManager)localObject).k();
        continue;
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_Actionbar", 0, 1, 0, "", "1", "", "");
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        switch (paramMenuItem.getOrder())
        {
        default: 
          break;
        case 0: 
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Recharge", 1, 1, 0, "", "", "", "");
          startActivity(((Intent)localObject).putExtra("url", "http://mp.imqq.com/user/charge"));
          break;
        case 1: 
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_Actionbar", 0, 1, 0, "", "", "1", "");
          startActivity(((Intent)localObject).putExtra("url", "http://mp.imqq.com/user/querybalance"));
          break;
        case 2: 
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_Actionbar", 0, 1, 0, "", "", "2", "");
          startActivity(((Intent)localObject).putExtra("url", "http://mp.imqq.com/rate"));
          break;
        case 3: 
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call History_Actionbar", 0, 1, 0, "", "", "3", "");
          startActivity(((Intent)localObject).putExtra("url", "http://mp.imqq.com/user/querybill"));
        }
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObservable instanceof VoipHistoryInterface)) || ((paramObservable instanceof QCallFacade)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(this);
      this.jdField_a_of_type_Fbg.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipHistoryActivity
 * JD-Core Version:    0.7.0.1
 */