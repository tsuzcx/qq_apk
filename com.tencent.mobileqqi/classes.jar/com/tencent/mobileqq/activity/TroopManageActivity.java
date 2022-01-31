package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import dpy;
import dpz;
import java.util.ArrayList;
import java.util.List;

public class TroopManageActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  public static final String a = "Q.troopmanage";
  public static final int b = 2;
  public static final int c = 4;
  public static final String c = "key_is_need_update_Group_info";
  public static final int d = 256;
  protected static final int e = 0;
  protected static final int f = 1;
  protected static final int g = 2;
  protected static final int h = 3;
  protected static final int i = 4;
  protected static final int j = 5;
  protected static final int k = 6;
  protected static final int l = 7;
  protected static final int m = 8;
  protected LinearLayout a;
  TroopObserver a;
  public TroopInfo a;
  public TroopInfoData a;
  public QQProgressNotifier a;
  public List a;
  public boolean a;
  public View[] a;
  public String b;
  private String d;
  private String e;
  public int n = 0;
  public int o = 0;
  
  public TroopManageActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaLangString = "199";
    this.jdField_e_of_type_JavaLangString = ("http://imgcache.qq.com/club/client/group/release/index.html?_bid=" + this.jdField_d_of_type_JavaLangString + "&pvsrc=troopManage&sid=%1$s&groupId=%2$s&_wv=5123");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dpz(this);
  }
  
  private int a()
  {
    int i1 = 0;
    int i3 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator)) {
      return i3;
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.split("\\|");
    int i4 = arrayOfString.length;
    int i2 = 0;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      i3 = i1;
      if (!TextUtils.isEmpty(arrayOfString[i2])) {
        i3 = i1 + 1;
      }
      i2 += 1;
      i1 = i3;
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131561648);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131562788);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131561965);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131231507);
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (localTroopHandler != null)
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, paramInt);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopmanage", 2, localException.toString());
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = getString(2131561648);
    arrayOfString[1] = getString(2131562788);
    arrayOfString[2] = getString(2131561965);
    localActionSheet.a(arrayOfString[0], false);
    localActionSheet.a(arrayOfString[1], false);
    localActionSheet.a(arrayOfString[2], false);
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short)
    {
    }
    for (;;)
    {
      localActionSheet.a(new dpy(this, localActionSheet));
      localActionSheet.d(2131561746);
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence)
  {
    paramView.setTag(Integer.valueOf(paramInt1));
    paramView.setOnClickListener(this);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131230941);
      localTextView.setTextColor(getResources().getColorStateList(2131362104));
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setText(str);
      paramString = paramView.findViewById(2131232623);
      paramString.setVisibility(0);
      paramString.setVisibility(8);
      paramString = (TextView)paramView.findViewById(2131231507);
      paramView = paramCharSequence;
      if (paramCharSequence == null) {
        paramView = "";
      }
      paramString.setText(paramView);
      return;
      paramView.setBackgroundResource(2130837877);
      continue;
      paramView.setBackgroundResource(2130837882);
      continue;
      paramView.setBackgroundResource(2130837881);
      continue;
      paramView.setBackgroundResource(2130837879);
    }
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    TextView localTextView = null;
    Object localObject = localTextView;
    if (paramInt >= 0)
    {
      localObject = localTextView;
      if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
      }
    }
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      localTextView = (TextView)((View)localObject).findViewById(2131231507);
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(d());
    }
  }
  
  protected void d()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (localTroopHandler == null) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, (byte)1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwTimeStamp, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("Q.troopmanage", 2, localException.toString());
    return;
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    label329:
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            do
            {
              return;
              switch (paramInt1)
              {
              default: 
                return;
              case 1: 
                if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
                  break label329;
                }
                if (!paramIntent.getExtras().getBoolean("isNeedFinish")) {
                  break;
                }
                paramIntent = new Intent();
                paramIntent.putExtra("isNeedFinish", true);
                setResult(-1, paramIntent);
                finish();
                return;
              case 256: 
                localObject = getIntent().getStringExtra("forward_location");
                paramInt1 = getIntent().getIntExtra("forward_latitude", 0);
                paramInt2 = getIntent().getIntExtra("forward_longitude", 0);
                paramIntent = null;
                if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                  paramIntent = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                }
                break;
              }
            } while (paramIntent == null);
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramIntent.a(this.jdField_b_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c = this.jdField_b_of_type_JavaLangString;
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((String)localObject);
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = paramInt1;
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = paramInt2;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
            setResult(-1);
            return;
            if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("finish_chat_setting", true);
              setResult(-1, paramIntent);
              finish();
              return;
            }
            paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
          } while (paramIntent == null);
          localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        } while (localObject == null);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)localObject).a(this.jdField_b_of_type_JavaLangString);
      } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
      ((TextView)paramIntent.findViewById(2131231507)).setText(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
      return;
      paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
    } while (paramIntent == null);
    ((TextView)paramIntent.findViewById(2131231507)).setText(a() + "/" + this.n);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    ((Integer)paramCompoundButton).intValue();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 6: 
    default: 
      return;
    case 0: 
      paramView = new Intent(this, TroopMemberListActivity.class);
      paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      paramView.putExtra("FROM_ACTIVITY", "TROOP_MANAGE_ACTIVITY");
      startActivityForResult(paramView, 256);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrpmber", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 1: 
      paramView = new Intent(this, SetTroopAdminsActivity.class);
      paramView.putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
      paramView.putExtra("maxAdminNum", this.n);
      startActivityForResult(paramView, 2);
      overridePendingTransition(2130968591, 2130968589);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "Grp", "Clk_setting_admin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 2: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_mberlevel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
      paramView = new Intent(this, PublicAccountBrowser.class);
      paramView.putExtra("reqType", 5);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.putExtra("url", "http://qinfo.clt.qq.com/qlevel/setting.html?_bid=125#gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      startActivity(paramView);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_setmberlevel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 3: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
      paramView = new Intent(this, TroopGagActivity.class);
      paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      startActivity(paramView);
      return;
    case 7: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_up", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      String str1 = this.jdField_e_of_type_JavaLangString;
      String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {}
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c;; paramView = Integer.valueOf(0))
      {
        this.jdField_e_of_type_JavaLangString = String.format(str1, new Object[] { str2, paramView });
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
        paramView.putExtra("business", 2147614720L);
        startActivity(paramView);
        return;
      }
    case 4: 
      e();
      return;
    }
    paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
    TroopInfoActivity.a(a(), paramView, 4);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i1 = 1;
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
    Object localObject = getIntent().getStringExtra("forward_location");
    int i2 = getIntent().getIntExtra("forward_latitude", 0);
    int i3 = getIntent().getIntExtra("forward_longitude", 0);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      i1 = 0;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException paramBundle)
    {
      label234:
      do
      {
        for (;;)
        {
          i1 = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.jdField_b_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
          {
            i1 = 0;
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c = this.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = i2;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = i3;
          }
        }
        paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903260, null);
        localObject = (XListView)paramBundle.findViewById(2131231313);
        ((XListView)localObject).setVerticalScrollBarEnabled(false);
        ((XListView)localObject).setDivider(null);
        ((XListView)localObject).setFocusable(false);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[8];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        ((XListView)localObject).setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout));
        ((XListView)localObject).setBackgroundResource(2130837729);
        setContentView(paramBundle);
        setTitle(getString(2131562346));
        paramBundle = View.inflate(this, 2130903648, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        paramBundle = View.inflate(this, 2130903641, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        a(5, 1, paramBundle, getString(2131562004), "");
        paramBundle = View.inflate(this, 2130903641, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[0] = paramBundle;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        a(0, 3, paramBundle, getString(2131562344), this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
        paramBundle = View.inflate(this, 2130903648, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
        {
          paramBundle = View.inflate(this, 2130903641, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
          a(1, 1, paramBundle, getString(2131562343), "" + a());
        }
        paramBundle = View.inflate(this, 2130903641, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[3] = paramBundle;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        a(3, 3, paramBundle, getString(2131562887), "");
        paramBundle = View.inflate(this, 2130903648, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        paramBundle = View.inflate(this, 2130903641, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[4] = paramBundle;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        a(4, 3, paramBundle, getString(2131562781), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n);
        paramBundle = View.inflate(this, 2130903648, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
        a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        paramBundle = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
        if (paramBundle != null) {
          paramBundle.a(this.jdField_b_of_type_JavaLangString);
        }
      } while (!getIntent().getBooleanExtra("key_is_need_update_Group_info", false));
      d();
      return;
    }
    if (l1 <= 0L) {
      i1 = 0;
    }
    for (;;)
    {
      paramBundle = null;
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        paramBundle = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      }
      if (paramBundle == null)
      {
        i1 = 0;
        if (i1 != 0) {
          break label234;
        }
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopManageActivity
 * JD-Core Version:    0.7.0.1
 */