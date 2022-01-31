package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dhv;
import dhw;
import dhx;
import dhy;
import dhz;
import dia;
import dib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SetTroopAdminsActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public static final int a = 1;
  public static final String a = "troop_uin";
  public static final int b = 2;
  public static final String b = "member_uin";
  public static final int c = 3;
  public static final String c = "member_info";
  private static final int d = 0;
  public static final String d = "last_update_time";
  private static final int e = 0;
  public static final String e = "key_last_update_time";
  private static final int jdField_f_of_type_Int = 1;
  public Handler a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dhy(this);
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dib jdField_a_of_type_Dib;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private TroopObserver b;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int = 0;
  private String jdField_g_of_type_JavaLangString;
  
  public SetTroopAdminsActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new dhz(this);
    this.jdField_a_of_type_AndroidOsHandler = new dia(this);
  }
  
  private void a(int paramInt)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131562452), 0).b(d());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.a = 20;
        paramString1.c = this.f;
        paramString1.b = this.jdField_g_of_type_JavaLangString;
        paramString1.f = 4;
        ProfileActivity.a(this, paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.a = 21;
    paramString1.c = this.f;
    paramString1.b = this.jdField_g_of_type_JavaLangString;
    paramString1.f = 4;
    ProfileActivity.a(this, paramString1);
  }
  
  private void d()
  {
    Object localObject = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null)
    {
      localObject = ((FriendsManagerImp)localObject).a(this.jdField_g_of_type_JavaLangString);
      if (localObject != null) {
        this.jdField_g_of_type_Int = ((TroopInfo)localObject).maxAdminNum;
      }
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_g_of_type_Int <= 0)
    {
      localObject = getString(2131561620);
      localTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new StringBuilder(getString(2131561620)).append("[");
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;; i = 0)
    {
      localObject = i + "/" + this.jdField_g_of_type_Int + "]";
      break;
    }
  }
  
  public ArrayList a()
  {
    Object localObject2;
    int i;
    try
    {
      ArrayList localArrayList = new ArrayList();
      boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin);
      if (bool) {
        return localArrayList;
      }
      Object localObject3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_g_of_type_JavaLangString }, null, null, null, null);
      ((EntityManager)localObject3).a();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        i = 0;
        label94:
        if (i < ((List)localObject2).size())
        {
          localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
          if ((localObject3 == null) || (((TroopMemberInfo)localObject3).memberuin == null) || (((TroopMemberInfo)localObject3).memberuin.trim().length() == 0) || (((TroopMemberInfo)localObject3).memberuin.trim().equalsIgnoreCase("0")) || (((TroopMemberInfo)localObject3).memberuin.trim().equalsIgnoreCase("10000")) || (((TroopMemberInfo)localObject3).memberuin.trim().equalsIgnoreCase("1000000")) || (((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator)) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(((TroopMemberInfo)localObject3).memberuin))) && (!((TroopMemberInfo)localObject3).memberuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)))) {
            break label639;
          }
          SetTroopAdminsActivity.TroopAdmin localTroopAdmin = new SetTroopAdminsActivity.TroopAdmin();
          localTroopAdmin.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject3).memberuin;
          localTroopAdmin.jdField_a_of_type_Short = ((TroopMemberInfo)localObject3).faceid;
          localTroopAdmin.b = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (TroopMemberInfo)localObject3);
          localTroopAdmin.c = ChnToSpell.a(localTroopAdmin.b, 2);
          localArrayList.add(localTroopAdmin);
        }
      }
    }
    finally {}
    label334:
    int j;
    if (localObject1.size() > 1)
    {
      i = 0;
      if (i >= localObject1.size()) {
        break label653;
      }
      if (!((SetTroopAdminsActivity.TroopAdmin)localObject1.get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label646;
      }
      localObject2 = (SetTroopAdminsActivity.TroopAdmin)localObject1.get(0);
      localObject1.set(0, localObject1.get(i));
      localObject1.set(i, localObject2);
      break label646;
      label404:
      if (i < localObject1.size())
      {
        if ((!((SetTroopAdminsActivity.TroopAdmin)localObject1.get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || (i == 0)) {
          break label658;
        }
        if (!((SetTroopAdminsActivity.TroopAdmin)localObject1.get(0)).jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          break label665;
        }
        j = 1;
        label469:
        localObject2 = (SetTroopAdminsActivity.TroopAdmin)localObject1.get(j);
        localObject1.set(j, localObject1.get(i));
        localObject1.set(i, localObject2);
        break label658;
      }
      if (((SetTroopAdminsActivity.TroopAdmin)localObject1.get(0)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin))
      {
        i = 1;
        label532:
        j = localObject1.size() - 1;
        break label670;
      }
    }
    for (;;)
    {
      if (k < j)
      {
        if (((SetTroopAdminsActivity.TroopAdmin)localObject1.get(k)).c.compareToIgnoreCase(((SetTroopAdminsActivity.TroopAdmin)localObject1.get(k + 1)).c) > 0)
        {
          localObject2 = (SetTroopAdminsActivity.TroopAdmin)localObject1.get(k);
          localObject1.set(k, localObject1.get(k + 1));
          localObject1.set(k + 1, localObject2);
        }
        k += 1;
        continue;
        i = 2;
        break label532;
      }
      j -= 1;
      label639:
      while (j <= i)
      {
        break;
        i += 1;
        break label94;
        i += 1;
        break label334;
        i = 0;
        break label404;
        i += 1;
        break label404;
        j = 0;
        break label469;
      }
      label646:
      label653:
      label658:
      label665:
      label670:
      int k = i;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.jdField_a_of_type_ComTencentWidgetXListView.k();
    SetTroopAdminsActivity.TroopAdmin localTroopAdmin;
    if (paramInt >= 0)
    {
      localTroopAdmin = (SetTroopAdminsActivity.TroopAdmin)this.jdField_a_of_type_Dib.getItem(paramInt);
      paramView = null;
      paramAdapterView = paramView;
      if (localTroopAdmin != null)
      {
        paramAdapterView = paramView;
        if (localTroopAdmin.jdField_a_of_type_JavaLangString != null)
        {
          paramAdapterView = paramView;
          if (localTroopAdmin.jdField_a_of_type_JavaLangString.length() > 0) {
            paramAdapterView = localTroopAdmin.jdField_a_of_type_JavaLangString;
          }
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.length() != 0)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramAdapterView))
    {
      paramView = new ProfileActivity.AllInOne(paramAdapterView, 0);
      paramView.jdField_g_of_type_JavaLangString = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramAdapterView);
      paramView.e = 3;
      paramView.f = 4;
      ProfileActivity.a(this, paramView);
      return;
    }
    a(paramAdapterView, localTroopAdmin.b);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    String str1 = paramIntent.getStringExtra("troop_uin");
    String str2 = paramIntent.getStringExtra("member_uin");
    paramIntent = (SetTroopAdminsActivity.TroopAdmin)paramIntent.getParcelableExtra("member_info");
    this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramIntent);
    a(2131561616);
    ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a((byte)1, str1, str2);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int j = 0;
    super.doOnCreate(paramBundle);
    this.f = getIntent().getStringExtra("troop_code");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {}
    for (int i = 0;; i = 1)
    {
      paramBundle = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (paramBundle == null) {
        i = 0;
      }
      while (i == 0)
      {
        finish();
        return true;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.jdField_g_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          i = 0;
        }
      }
      setContentView(2130903977);
      d();
      ((TextView)findViewById(2131231456)).setVisibility(4);
      setTitle(2131562342);
      c(2131561977, new dhv(this));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131234482));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getLayoutInflater().inflate(2130903270, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Dib = new dib(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dib);
      ((Button)findViewById(2131234379)).setOnClickListener(new dhw(this));
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      a(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      paramBundle = new dhx(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle);
      paramBundle = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      long l1 = getSharedPreferences("last_update_time" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getLong("key_last_update_time" + this.jdField_g_of_type_JavaLangString, 0L);
      long l2 = System.currentTimeMillis();
      if (((l1 == 0L) || ((l1 > 0L) && (Math.abs(l2 - l1) > 300000L))) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.f)))
      {
        paramBundle.a(true, this.jdField_g_of_type_JavaLangString, this.f);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_g_of_type_Int = getIntent().getIntExtra("maxAdminNum", 0);
      if (this.jdField_g_of_type_Int > 0)
      {
        paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder(getString(2131561620)).append("[");
        i = j;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        }
        paramBundle.setText(i + "/" + this.jdField_g_of_type_Int + "]");
        return true;
      }
      paramBundle.a(this.jdField_g_of_type_JavaLangString);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_Dib != null) {
      this.jdField_a_of_type_Dib.b();
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130968590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SetTroopAdminsActivity
 * JD-Core Version:    0.7.0.1
 */