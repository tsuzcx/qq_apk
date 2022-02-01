package com.tencent.mobileqq.filemanager.data.search;

import acfp;
import agoa;
import agob;
import ampx;
import amub;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSearchActivity
  extends BaseSearchActivity
{
  static List<ampx> Bs;
  List<ampx> Bt;
  private SearchTypeFragment jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment;
  private BaseSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment;
  private Bundle aZ;
  private String avs;
  private String bIB;
  private boolean ceA;
  private boolean cez = true;
  private int mFromType = -1;
  
  public static void a(Activity paramActivity, String paramString1, List<ampx> paramList, boolean paramBoolean, int paramInt, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, FileSearchActivity.class);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("show_Header", paramBoolean);
    localIntent.putExtra("from_type", paramInt);
    localIntent.putExtra("qfile_search_param_uin", paramString2);
    if (paramBundle != null) {
      localIntent.putExtra("qfile_search_param_ex_params", paramBundle);
    }
    Bs = paramList;
    if (Bs == null) {
      Bs = new ArrayList();
    }
    paramActivity.startActivityForResult(localIntent, 9999);
  }
  
  public static void a(Context paramContext, String paramString, List<ampx> paramList, boolean paramBoolean, int paramInt)
  {
    a(paramContext, paramString, paramList, paramBoolean, paramInt, "", null);
  }
  
  public static void a(Context paramContext, String paramString1, List<ampx> paramList, boolean paramBoolean, int paramInt, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, FileSearchActivity.class);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("show_Header", paramBoolean);
    localIntent.putExtra("from_type", paramInt);
    localIntent.putExtra("qfile_search_param_uin", paramString2);
    if (paramBundle != null) {
      localIntent.putExtra("qfile_search_param_ex_params", paramBundle);
    }
    Bs = paramList;
    if (Bs == null) {
      Bs = new ArrayList();
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void h(Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, null, null, false, paramInt, paramString, null);
  }
  
  public BaseSearchFragment a()
  {
    Object localObject;
    if (this.mFromType == 8)
    {
      localObject = new FileSearchFragment();
      ((FileSearchFragment)localObject).Bt = Bs;
      ((FileSearchFragment)localObject).bIC = this.avs;
      ((FileSearchFragment)localObject).mFromType = this.mFromType;
      ((FileSearchFragment)localObject).Jo(this.cez);
    }
    for (;;)
    {
      amub.a(null, 0, this.mFromType, "0X8009D58", 0, 0, null, null);
      return localObject;
      if (this.mFromType == 2)
      {
        localObject = new ChatFileSearchFragment();
        ((ChatFileSearchFragment)localObject).mUin = this.bIB;
        ((ChatFileSearchFragment)localObject).Bt = Bs;
        ((ChatFileSearchFragment)localObject).bIC = this.avs;
        ((ChatFileSearchFragment)localObject).cYj = 1;
        ((ChatFileSearchFragment)localObject).mFromType = this.mFromType;
        ((ChatFileSearchFragment)localObject).Jo(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
      }
      else if (this.mFromType == 13)
      {
        localObject = new TroopFileSearchFragment();
        ((TroopFileSearchFragment)localObject).mFromType = this.mFromType;
        ((TroopFileSearchFragment)localObject).mTroopUin = Long.parseLong(this.bIB);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
      }
      else if ((this.mFromType == 15) || (this.mFromType == 16) || (this.mFromType == 17) || (this.mFromType == 18) || (this.mFromType == 19))
      {
        localObject = new FileSelectorSearchFragment();
        ((FileSelectorSearchFragment)localObject).Om(this.mFromType);
        ((FileSelectorSearchFragment)localObject).cA(this.aZ);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
      }
      else
      {
        QLog.w("FileSearchActivity<QFile>", 1, "newSearchFragment. can not handle type. type[" + this.mFromType + "]");
        localObject = new FileSearchFragment();
        ((FileSearchFragment)localObject).Bt = Bs;
        ((FileSearchFragment)localObject).bIC = this.avs;
        ((FileSearchFragment)localObject).mFromType = this.mFromType;
        ((FileSearchFragment)localObject).Jo(this.cez);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if ((this.mFromType != 2) && (this.mFromType != 13)) {}
    do
    {
      do
      {
        return;
        paramEditable = this.b.getText().toString();
      } while ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment == null));
      if ((TextUtils.isEmpty(paramEditable)) && (!this.ceA))
      {
        paramEditable = super.getSupportFragmentManager().beginTransaction();
        paramEditable.show(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
        paramEditable.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
        paramEditable.commit();
        this.ceA = true;
        return;
      }
    } while (TextUtils.isEmpty(paramEditable));
    paramEditable = super.getSupportFragmentManager().beginTransaction();
    paramEditable.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
    paramEditable.hide(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
    paramEditable.commit();
    this.ceA = false;
  }
  
  public void diu()
  {
    gR();
    super.diu();
    div();
  }
  
  public void div()
  {
    if ((this.mFromType == 2) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 != 9999) || (paramIntent == null)) {}
    while (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) != -1) {
      return;
    }
    setResult(paramInt2, new Intent(paramIntent));
    finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    div();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.avs = localIntent.getStringExtra("keyword");
    this.cez = localIntent.getBooleanExtra("show_Header", true);
    this.mFromType = localIntent.getIntExtra("from_type", -1);
    this.bIB = localIntent.getStringExtra("qfile_search_param_uin");
    this.aZ = localIntent.getBundleExtra("qfile_search_param_ex_params");
    if (((this.mFromType == 2) || (this.mFromType == 13)) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
    super.doOnCreate(paramBundle);
    if (this.mFromType == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment = new SearchTypeFragment();
      paramBundle = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(11) }));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.mTypes = paramBundle;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.cYk = 4;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.a(new agoa(this.app, this, this.bIB, paramBundle));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.mUin = this.bIB;
        paramBundle = super.getSupportFragmentManager().beginTransaction();
        paramBundle.add(2131377814, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
        paramBundle.commit();
        this.ceA = true;
      }
      this.Bt = new ArrayList();
      if (Bs == null) {
        Bs = new ArrayList();
      }
      this.Bt.addAll(Bs);
      Bs = null;
      this.Dt.setVisibility(8);
      return true;
      if (this.mFromType == 13)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment = new SearchTypeFragment();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.mTypes = Arrays.asList(new Integer[] { Integer.valueOf(13), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(11) });
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.cYk = 4;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.a(new agob(this.app, this, this.bIB));
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public String vm()
  {
    this.b.setFocusable(true);
    if (TextUtils.isEmpty(this.avs)) {
      new Handler().postDelayed(new FileSearchActivity.1(this), 200L);
    }
    String str = acfp.m(2131706289);
    if (this.mFromType == 16) {
      str = getString(2131693574);
    }
    while (this.mFromType != 17) {
      return str;
    }
    return getString(2131693573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchActivity
 * JD-Core Version:    0.7.0.1
 */