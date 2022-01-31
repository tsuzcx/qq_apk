package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bje;
import bjf;
import bjg;
import bjh;
import bji;
import bjj;
import bjk;
import bjl;
import bjn;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SetTroopAdminsActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public static final int a = 1;
  public static final String a = "SetTroopAdminsActivity";
  public static final int b = 2;
  public static final String b = "troop_uin";
  public static final int c = 3;
  public static final String c = "member_uin";
  private static final int d = 0;
  public static final String d = "member_info";
  private static final int e = 0;
  public static final String e = "last_update_time";
  private static final int f = 1;
  public static final String f = "key_last_update_time";
  public Handler a;
  public View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjl jdField_a_of_type_Bjl;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bjh(this);
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public HashSet a;
  public boolean a;
  private TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new bji(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private String jdField_g_of_type_JavaLangString;
  private String h;
  
  public SetTroopAdminsActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bjj(this);
    this.jdField_a_of_type_AndroidOsHandler = new bjk(this);
  }
  
  private void a(int paramInt)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131362790), 0).b(getTitleBarHeight());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendManager)this.app.getManager(8);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.a = 20;
        paramString1.d = this.jdField_g_of_type_JavaLangString;
        paramString1.c = this.h;
        paramString1.jdField_g_of_type_Int = 4;
        ProfileActivity.b(this, paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.a = 21;
    paramString1.d = this.jdField_g_of_type_JavaLangString;
    paramString1.c = this.h;
    paramString1.jdField_g_of_type_Int = 4;
    ProfileActivity.b(this, paramString1);
  }
  
  private void c()
  {
    Object localObject = (FriendsManagerImp)this.app.getManager(8);
    if (localObject != null)
    {
      localObject = ((FriendsManagerImp)localObject).a(this.h);
      if (localObject != null) {
        this.jdField_g_of_type_Int = ((TroopInfo)localObject).maxAdminNum;
      }
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_g_of_type_Int <= 0)
    {
      localObject = getString(2131362844);
      localTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new StringBuilder(getString(2131362844)).append("(");
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      localObject = i + "/" + this.jdField_g_of_type_Int + ")";
      break;
    }
  }
  
  public bjn a(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof bjn)))
      {
        localObject = (bjn)((View)localObject).getTag();
        if ((((bjn)localObject).jdField_a_of_type_JavaLangString != null) && (((bjn)localObject).jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SetTroopAdminsActivity", 2, "findListItemHolderByUin:" + i);
          }
          return localObject;
        }
      }
      i += 1;
    }
    return null;
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
      Object localObject3 = this.app.a().createEntityManager();
      localObject2 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.h }, null, null, null, null);
      ((EntityManager)localObject3).a();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        i = 0;
        label96:
        if (i < ((List)localObject2).size())
        {
          localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
          if ((localObject3 == null) || (((TroopMemberInfo)localObject3).memberuin == null) || (((TroopMemberInfo)localObject3).memberuin.trim().length() == 0) || (((TroopMemberInfo)localObject3).memberuin.trim().equalsIgnoreCase("0")) || (((TroopMemberInfo)localObject3).memberuin.trim().equalsIgnoreCase("10000")) || (((TroopMemberInfo)localObject3).memberuin.trim().equalsIgnoreCase("1000000")) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator)) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(((TroopMemberInfo)localObject3).memberuin))) {
            break label623;
          }
          SetTroopAdminsActivity.TroopAdmin localTroopAdmin = new SetTroopAdminsActivity.TroopAdmin();
          localTroopAdmin.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject3).memberuin;
          localTroopAdmin.jdField_a_of_type_Short = ((TroopMemberInfo)localObject3).faceid;
          localTroopAdmin.b = ContactUtils.a(this.app, (TroopMemberInfo)localObject3);
          localTroopAdmin.c = ChnToSpell.a(localTroopAdmin.b, 2);
          localArrayList.add(localTroopAdmin);
        }
      }
    }
    finally {}
    label318:
    int j;
    if (localObject1.size() > 1)
    {
      i = 0;
      if (i >= localObject1.size()) {
        break label637;
      }
      if (!((SetTroopAdminsActivity.TroopAdmin)localObject1.get(i)).jdField_a_of_type_JavaLangString.equals(this.app.a())) {
        break label630;
      }
      localObject2 = (SetTroopAdminsActivity.TroopAdmin)localObject1.get(0);
      localObject1.set(0, localObject1.get(i));
      localObject1.set(i, localObject2);
      break label630;
      label388:
      if (i < localObject1.size())
      {
        if ((!((SetTroopAdminsActivity.TroopAdmin)localObject1.get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || (i == 0)) {
          break label642;
        }
        if (!((SetTroopAdminsActivity.TroopAdmin)localObject1.get(0)).jdField_a_of_type_JavaLangString.equals(this.app.a())) {
          break label649;
        }
        j = 1;
        label453:
        localObject2 = (SetTroopAdminsActivity.TroopAdmin)localObject1.get(j);
        localObject1.set(j, localObject1.get(i));
        localObject1.set(i, localObject2);
        break label642;
      }
      if (((SetTroopAdminsActivity.TroopAdmin)localObject1.get(0)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin))
      {
        i = 1;
        label516:
        j = localObject1.size() - 1;
        break label654;
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
        break label516;
      }
      j -= 1;
      label623:
      label630:
      label637:
      while (j <= i)
      {
        break;
        i += 1;
        break label96;
        i += 1;
        break label318;
        i = 0;
        break label388;
        i += 1;
        break label388;
        j = 0;
        break label453;
      }
      label642:
      label649:
      label654:
      int k = i;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.jdField_a_of_type_ComTencentWidgetXListView.k();
    SetTroopAdminsActivity.TroopAdmin localTroopAdmin;
    if (paramInt >= 0)
    {
      localTroopAdmin = (SetTroopAdminsActivity.TroopAdmin)this.jdField_a_of_type_Bjl.getItem(paramInt);
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
    if (this.app.a().equals(paramAdapterView))
    {
      paramView = new ProfileActivity.AllInOne(paramAdapterView, 0);
      paramView.h = ContactUtils.g(this.app, paramAdapterView);
      paramView.f = 3;
      paramView.jdField_g_of_type_Int = 4;
      ProfileActivity.b(this, paramView);
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
    a(2131362861);
    ((TroopHandler)this.app.a(17)).a((byte)1, str1, str2);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int j = 0;
    super.doOnCreate(paramBundle);
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("troop_code");
    this.h = getIntent().getStringExtra("troop_uin");
    if (TextUtils.isEmpty(this.h)) {}
    for (int i = 0;; i = 1)
    {
      paramBundle = (FriendManager)this.app.getManager(8);
      if (paramBundle == null) {
        i = 0;
      }
      while (i == 0)
      {
        finish();
        return true;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.h);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          i = 0;
        }
      }
      setContentView(2130903633);
      d();
      setTitle(2131362850);
      this.jdField_a_of_type_Boolean = false;
      this.j.setText(2131363436);
      this.j.setVisibility(0);
      this.j.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298199));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297009));
      this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130903660, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Bjl = new bjl(this, this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bjl);
      this.j.setOnClickListener(new bje(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bjf(this));
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      paramBundle = new bjg(this);
      this.app.a(paramBundle);
      paramBundle = (TroopHandler)this.app.a(17);
      long l1 = getSharedPreferences("last_update_time" + this.app.a(), 0).getLong("key_last_update_time" + this.h, 0L);
      long l2 = System.currentTimeMillis();
      if (((l1 == 0L) || ((l1 > 0L) && (Math.abs(l2 - l1) > 300000L))) && (!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
      {
        paramBundle.a(true, this.h, this.jdField_g_of_type_JavaLangString);
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_g_of_type_Int = getIntent().getIntExtra("maxAdminNum", 0);
      if (this.jdField_g_of_type_Int > 0)
      {
        paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder(getString(2131362844)).append("(");
        i = j;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
        }
        paramBundle.setText(i + "/" + this.jdField_g_of_type_Int + ")");
        return true;
      }
      paramBundle.b(this.h);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_Bjl != null) {
      this.jdField_a_of_type_Bjl.b();
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SetTroopAdminsActivity
 * JD-Core Version:    0.7.0.1
 */