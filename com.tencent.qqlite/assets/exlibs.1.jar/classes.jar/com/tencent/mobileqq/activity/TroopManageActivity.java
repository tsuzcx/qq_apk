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
import bnh;
import bni;
import bnk;
import bnl;
import bnm;
import com.tencent.biz.common.util.CommUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.List;

public class TroopManageActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final long jdField_a_of_type_Long = 1073741824L;
  public static final String a = "Q.troopmanage";
  public static final int b = 2;
  public static final int c = 4;
  public static final String c = "key_is_need_update_Group_info";
  protected static final int d = 0;
  protected static final int e = 1;
  protected static final int f = 2;
  protected static final int g = 3;
  protected static final int h = 4;
  protected static final int i = 5;
  protected static final int j = 6;
  protected static final int k = 7;
  protected static final int l = 8;
  protected static final int m = 9;
  private View jdField_a_of_type_AndroidViewView;
  protected LinearLayout a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new bnk(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bni(this);
  public TroopInfo a;
  public TroopInfoData a;
  public QQProgressNotifier a;
  public List a;
  public boolean a;
  public View[] a;
  private View b;
  public String b;
  private View c;
  private final String d;
  private final String e;
  private final String f = "GoupStatisticsTitle";
  public int n = 0;
  public int o = 0;
  
  public TroopManageActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/admin/group/menu/admin_grp_stat_menu";
    this.jdField_e_of_type_JavaLangString = "GoupStatisticsUrl";
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131363090);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131363091);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131363092);
    }
  }
  
  private void a(int paramInt, View paramView, String paramString, CharSequence paramCharSequence)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131296932);
      localTextView.setTextColor(getResources().getColorStateList(2131427489));
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setText(str);
      paramView.findViewById(2131297744).setVisibility(0);
      paramString = (TextView)paramView.findViewById(2131296953);
      paramView = paramCharSequence;
      if (paramCharSequence == null) {
        paramView = "";
      }
      paramString.setText(paramView);
      return;
      paramView.setBackgroundResource(2130837924);
      continue;
      paramView.setBackgroundResource(2130837927);
      continue;
      paramView.setBackgroundResource(2130837927);
      continue;
      paramView.setBackgroundResource(2130837926);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131296953);
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903554, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView.setTag(paramString2);
    a(3, this.jdField_a_of_type_AndroidViewView, paramString1, "");
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bnm(this));
    if (this.c == null)
    {
      this.c = View.inflate(this, 2130903562, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(17);
      if (localTroopHandler != null)
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, paramInt);
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
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = getString(2131363090);
    arrayOfString[1] = getString(2131363091);
    arrayOfString[2] = getString(2131363092);
    localActionSheet.a(arrayOfString[0], false);
    localActionSheet.a(arrayOfString[1], false);
    localActionSheet.a(arrayOfString[2], false);
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short)
    {
    }
    for (;;)
    {
      localActionSheet.a(new bnh(this, localActionSheet));
      localActionSheet.d(2131362794);
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
    }
  }
  
  private void e()
  {
    CommUtils.a("http://pub.idqqimg.com/pc/misc/admin/group/menu/admin_grp_stat_menu", new bnl(this));
  }
  
  private void f()
  {
    String str1 = SharePreferenceUtils.a(this, this.app.a() + "_" + "GoupStatisticsTitle");
    String str2 = SharePreferenceUtils.a(this, this.app.a() + "_" + "GoupStatisticsUrl");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      a(str1, str2);
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.c != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.c);
      this.c = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence)
  {
    paramView.setTag(Integer.valueOf(paramInt1));
    paramView.setOnClickListener(this);
    a(paramInt2, paramView, paramString, paramCharSequence);
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
      localTextView = (TextView)((View)localObject).findViewById(2131296953);
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  protected void c()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(17);
    if (localTroopHandler == null) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
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
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    i1 = 1;
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
    localObject = getIntent().getStringExtra("forward_location");
    i2 = getIntent().getIntExtra("forward_latitude", 0);
    i3 = getIntent().getIntExtra("forward_longitude", 0);
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
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.app.a());
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = i2;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = i3;
          continue;
          paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903217, null);
          localObject = (XListView)paramBundle.findViewById(2131296779);
          ((XListView)localObject).setVerticalScrollBarEnabled(false);
          ((XListView)localObject).setDivider(null);
          ((XListView)localObject).setFocusable(false);
          this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
          this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
          AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
          ((XListView)localObject).setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout));
          ((XListView)localObject).setBackgroundResource(2130837635);
          setContentView(paramBundle);
          setTitle(getString(2131363718));
          paramBundle = View.inflate(this, 2130903562, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
          paramBundle = View.inflate(this, 2130903554, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
          a(5, 0, paramBundle, getString(2131363107), "");
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
          {
            paramBundle = View.inflate(this, 2130903554, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            a(1, 1, paramBundle, getString(2131363719), "" + a());
          }
          paramBundle = View.inflate(this, 2130903554, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[3] = paramBundle;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
          {
            a(3, 2, paramBundle, getString(2131363721), "");
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean))
            {
              paramBundle = View.inflate(this, 2130903554, null);
              this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
              a(2, 1, paramBundle, getString(2131363720), "");
            }
            paramBundle = View.inflate(this, 2130903554, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[4] = paramBundle;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            a(4, 3, paramBundle, getString(2131363722), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n);
            paramBundle = View.inflate(this, 2130903558, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[7] = paramBundle;
            localObject = (FormSwitchItem)paramBundle.findViewById(2131298524);
            ((FormSwitchItem)localObject).setText(getResources().getString(2131362563));
            ((FormSwitchItem)localObject).setContentDescription(getResources().getString(2131362564));
            localObject = ((FormSwitchItem)localObject).a();
            ((Switch)localObject).setTag(Integer.valueOf(7));
            ((Switch)localObject).setOnCheckedChangeListener(null);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x40000000) == 0L) {
              break label885;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((Switch)localObject).setChecked(bool);
            ((Switch)localObject).setOnCheckedChangeListener(this);
            localObject = (TextView)paramBundle.findViewById(2131298526);
            ((TextView)localObject).setText(getResources().getString(2131362564));
            ((TextView)localObject).setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
            addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
            paramBundle = (TroopHandler)this.app.a(17);
            if (paramBundle != null) {
              paramBundle.b(this.jdField_b_of_type_JavaLangString);
            }
            if (getIntent().getBooleanExtra("key_is_need_update_Group_info", false)) {
              c();
            }
            f();
            e();
            return true;
            a(3, 1, paramBundle, getString(2131363721), "");
            break;
          }
        }
      }
    }
    if (l1 <= 0L)
    {
      i1 = 0;
      paramBundle = null;
      if (this.app != null) {
        paramBundle = (FriendManager)this.app.getManager(8);
      }
      if (paramBundle == null)
      {
        i1 = 0;
        if (i1 != 0) {
          break label236;
        }
        finish();
        return true;
      }
    }
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      do
      {
        FriendManager localFriendManager;
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
              if ((paramIntent != null) && (paramIntent.getExtras() != null))
              {
                if (paramIntent.getExtras().getBoolean("isNeedFinish"))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("isNeedFinish", true);
                  setResult(-1, paramIntent);
                  finish();
                  return;
                }
                if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("finish_chat_setting", true);
                  setResult(-1, paramIntent);
                  finish();
                  return;
                }
              }
              paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
            }
          } while (paramIntent == null);
          localFriendManager = (FriendManager)this.app.getManager(8);
        } while (localFriendManager == null);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localFriendManager.a(this.jdField_b_of_type_JavaLangString);
      } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
      ((TextView)paramIntent.findViewById(2131296953)).setText(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
      return;
      paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
    } while (paramIntent == null);
    ((TextView)paramIntent.findViewById(2131296953)).setText(a() + "/" + this.n);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    }
    ((BizTroopHandler)this.app.a(19)).b(this.jdField_b_of_type_JavaLangString, paramBoolean);
    if (paramBoolean)
    {
      ReportController.a(null, "P_CliOper", "Grp_anon", "", "manage_grp", "Clk_open", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.a(null, "P_CliOper", "Grp_anon", "", "manage_grp", "Clk_close", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 6: 
    case 7: 
    default: 
      return;
    case 0: 
      paramView = new Intent(this, PublicAccountBrowser.class);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("isScreenOrientationPortrait", true);
      paramView.putExtra("hideRightButton", true);
      paramView.putExtra("url", "http://web.p.qq.com/qqmpmobile/group/groupmembers/index.html?_bid=153&guin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + "&gcode=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString + "&admin=1" + "&num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int);
      startActivityForResult(paramView, 1);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrpmber", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 1: 
      paramView = new Intent(this, SetTroopAdminsActivity.class);
      paramView.putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
      paramView.putExtra("maxAdminNum", this.n);
      startActivityForResult(paramView, 2);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "Grp", "Clk_setting_admin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 2: 
      ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_mberlevel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      paramView = new Intent(this, PublicAccountBrowser.class);
      paramView.putExtra("reqType", 5);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("url", "http://qinfo.clt.qq.com/qlevel/setting.html?_bid=125#gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      startActivity(paramView);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_setmberlevel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 3: 
      paramView = (TroopGagMgr)this.app.getManager(42);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), "", "");
      paramView = new Intent(this, TroopGagActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      startActivity(paramView);
      return;
    case 4: 
      d();
      return;
    case 5: 
      paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
      TroopInfoActivity.a(getActivity(), paramView, 4);
      return;
    }
    paramView = new Intent(this, TroopPrivilegeActivity.class);
    paramView.putExtra("uin", this.app.a());
    paramView.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopManageActivity
 * JD-Core Version:    0.7.0.1
 */