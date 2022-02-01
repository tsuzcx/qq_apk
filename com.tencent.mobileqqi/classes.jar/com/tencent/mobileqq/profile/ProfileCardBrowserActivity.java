package com.tencent.mobileqq.profile;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.profile.util.PhoneUtils;
import com.tencent.mobileqq.profile.view.CircularProgressBar;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import geg;
import geh;
import gei;
import gej;
import gek;
import gel;
import gen;
import geo;
import gep;
import geq;
import ger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class ProfileCardBrowserActivity
  extends IphoneTitleBarActivity
{
  public static final float a = 1.75F;
  public static final int a = 10;
  public static final String a = "ProfileCard.ProfileCardBrowserActivity";
  public static final int b = 25;
  public static final String b = "AllInOne";
  public static final int c = 50;
  public static final int d = 63;
  public static final int e = 1000;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = -1;
  public static final int s = 0;
  public static final int t = 1;
  public static final int u = 2;
  public static final int v = 3;
  public static final int w = 4;
  public int A = -1;
  public int B = -1;
  public int C = -1;
  public int D = -1;
  public int E = 0;
  public int F = 0;
  public Context a;
  public DialogInterface.OnClickListener a;
  @SuppressLint({"HandlerLeak"})
  public Handler a;
  public View a;
  public GridView a;
  public LinearLayout a;
  public TextView a;
  public ProfileActivity.AllInOne a;
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new gei(this);
  public ProfileCardBrowserActivity.ImageGalleryAdapter a;
  public QQCustomDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new geh(this);
  public List a;
  public ConcurrentHashMap a;
  public AtomicBoolean a;
  public AtomicLong a;
  public AtomicReference a;
  public boolean a;
  public DialogInterface.OnClickListener b;
  public View b;
  public TextView b;
  public AtomicReference b;
  public boolean b;
  public TextView c;
  public boolean c;
  public boolean d = false;
  public int x = -1;
  public int y = 1;
  public int z = -1;
  
  public ProfileCardBrowserActivity()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = null;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference = null;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity$ImageGalleryAdapter = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new geg(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new geo(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new gep(this);
  }
  
  private void a(long paramLong, int paramInt)
  {
    ThreadManager.a(new gel(this, paramLong, paramInt));
  }
  
  private void k()
  {
    this.jdField_b_of_type_Boolean = VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Boolean = VipUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a()
  {
    if (this.y == 1) {
      return this.E;
    }
    Card localCard = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (localCard != null)
    {
      if ((localCard.lCurrentTemplateId == 0L) || (localCard.templateRet != 0)) {
        return 0;
      }
      return (int)localCard.lCurrentTemplateId;
    }
    return 0;
  }
  
  public int a(ProfileCardTemplate paramProfileCardTemplate, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    if ((ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardTemplate, false)) || (paramProfileCardTemplate.a == 0L)) {
      return 19;
    }
    String str = String.format("%s_%s", new Object[] { Long.valueOf(paramProfileCardTemplate.a), paramProfileCardTemplate.b });
    File localFile = new File(ProfileCardUtil.a(getApplicationContext(), "temp") + File.separator + str + ".zip");
    paramProfileCardTemplate = new DownloadInfo(paramProfileCardTemplate.e, localFile, 0);
    return HttpDownloadUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardTemplate, paramHttpDownloadListener, ProfileCardUtil.a(getApplicationContext(), str), "param_XGSummaryCardDownloadFlow", "param_WIFISummaryCardDownloadFlow");
  }
  
  public View a(int paramInt)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetGridView.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_AndroidWidgetGridView.getLastVisiblePosition();
    int i3 = paramInt - i1;
    if ((paramInt > i2) || (paramInt < i1) || (i3 < 0)) {
      return null;
    }
    return this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(i3);
  }
  
  public void a(int paramInt)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    Card localCard = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((localCard != null) && (paramInt >= 0))
    {
      localCard.lCurrentTemplateId = paramInt;
      localFriendsManager.a(localCard);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if (localObject != null)
    {
      localObject = (CircularProgressBar)((View)localObject).findViewById(2131233398);
      if ((localObject != null) && (((CircularProgressBar)localObject).getTag() != null) && (((Integer)((CircularProgressBar)localObject).getTag()).intValue() == paramInt1)) {}
    }
    else
    {
      return;
    }
    ((CircularProgressBar)localObject).setProgress(paramInt2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    int i2 = 0;
    if (paramObject == null) {
      return;
    }
    paramObject = (ger)paramObject;
    Object localObject = paramObject.jdField_a_of_type_AndroidWidgetImageView;
    int i1;
    if ((paramInt & 0x4) == 4)
    {
      i1 = 0;
      ((ImageView)localObject).setVisibility(i1);
      localObject = paramObject.jdField_a_of_type_ComTencentMobileqqProfileViewCircularProgressBar;
      if ((paramInt & 0x2) != 2) {
        break label82;
      }
      i1 = 0;
      label49:
      ((CircularProgressBar)localObject).setVisibility(i1);
      paramObject = paramObject.jdField_a_of_type_AndroidWidgetProgressBar;
      if ((paramInt & 0x1) != 1) {
        break label88;
      }
    }
    label82:
    label88:
    for (paramInt = i2;; paramInt = 8)
    {
      paramObject.setVisibility(paramInt);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label49;
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)paramList.get(i1);
        localStringBuilder.append(String.format("%s,%s,%s|", new Object[] { String.valueOf(localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a), localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.b, String.valueOf(localProfileCardTemplateInfo.jdField_a_of_type_Int) }));
        i1 += 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putString("svip_profile_template_status", localStringBuilder.substring(0, localStringBuilder.length() - 1)).commit();
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    int i2 = 0;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    Object localObject;
    int i3;
    do
    {
      return false;
      localObject = ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        i1 = 0;
        while (i1 < paramArrayList.size())
        {
          ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)paramArrayList.get(i1);
          Boolean localBoolean = (Boolean)((HashMap)localObject).get(String.format("%s_%s", new Object[] { Long.valueOf(localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a), localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.b }));
          if ((localBoolean != null) && (localBoolean.booleanValue() == true)) {
            localProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
          }
          i1 += 1;
        }
      }
      i3 = a();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "currentCardId : " + i3);
      }
    } while ((paramArrayList == null) || (paramArrayList.size() <= 0));
    boolean bool = false;
    int i1 = i2;
    if (i1 < paramArrayList.size())
    {
      localObject = (ProfileCardTemplateInfo)paramArrayList.get(i1);
      if (i3 == ((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a)
      {
        ((ProfileCardTemplateInfo)localObject).jdField_a_of_type_Int = 4;
        bool = true;
      }
      for (;;)
      {
        i1 += 1;
        break;
      }
    }
    return bool;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity$ImageGalleryAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity$ImageGalleryAdapter.notifyDataSetChanged();
      }
      return;
      ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).jdField_a_of_type_Int = -1;
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, 2131562065, 0).show();
      continue;
      ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).jdField_a_of_type_Int = -1;
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, 2131562065, 0).show();
      continue;
      i();
      ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).jdField_a_of_type_Int = 4;
      ThreadManager.a(new geq(this));
      continue;
      if (paramInt1 != -1) {
        ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).jdField_a_of_type_Int = 2;
      }
      for (;;)
      {
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, 2131562093, 0).show();
        break;
        paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localProfileCardTemplateInfo != null) && (localProfileCardTemplateInfo.jdField_a_of_type_Int == 3)) {
            localProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
          }
          paramInt1 += 1;
        }
      }
      ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      if ((localProfileCardTemplateInfo.jdField_a_of_type_Int == 3) || (localProfileCardTemplateInfo.jdField_a_of_type_Int == 1)) {
        localProfileCardTemplateInfo.jdField_a_of_type_Int -= 1;
      }
    }
  }
  
  public void d()
  {
    ThreadManager.b(new gen(this));
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903692);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131233078);
    int i1;
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidContentContext = this;
      paramBundle = getIntent();
      if ((paramBundle == null) || (!paramBundle.hasExtra("AllInOne"))) {
        break label675;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))) {
        break label668;
      }
      if (!TextUtils.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) {
        break label663;
      }
      i1 = 1;
      label134:
      this.y = i1;
      label139:
      if ((paramBundle != null) && (paramBundle.hasExtra("CurrentTemplateId"))) {
        this.E = ((int)paramBundle.getLongExtra("CurrentTemplateId", 0L));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "onCreate, mCurrentTemplateId : " + this.E);
      }
      if ((paramBundle != null) && (paramBundle.hasExtra("IsRedPoint"))) {
        this.d = paramBundle.getBooleanExtra("IsRedPoint", false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "onCreate, IsRedPoint : " + this.d);
      }
      if (this.d)
      {
        this.jdField_c_of_type_Boolean = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("is_template_list_loaded", false);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "onCreate, mLoaded : " + this.jdField_c_of_type_Boolean);
        }
        if (!this.jdField_c_of_type_Boolean)
        {
          paramBundle = (ViewStub)findViewById(2131233441);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "onCreate, viewStub inflate start.");
          }
          if (paramBundle != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "onCreate, viewStub inflate success.");
            }
            this.jdField_a_of_type_AndroidViewView = paramBundle.inflate();
          }
        }
      }
      this.D = PhoneUtils.a(this.jdField_a_of_type_AndroidContentContext, 10);
      this.A = Math.round((this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.D * 2) / 2.0F);
      this.B = (Math.round(this.A * 1.75F) + PhoneUtils.a(this.jdField_a_of_type_AndroidContentContext, 50));
      this.C = (this.A / 2);
      e();
      d();
      paramBundle = new LinearLayout.LayoutParams(this.C, -1);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233436));
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233438));
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131233437));
      this.jdField_a_of_type_AndroidWidgetGridView.setFadingEdgeLength(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new gej(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131233439));
      if (this.y == 1) {
        break label682;
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233440));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new gek(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
      a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      k();
      return true;
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      label663:
      i1 = 0;
      break label134;
      label668:
      finish();
      break label139;
      label675:
      finish();
      break label139;
      label682:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    g();
  }
  
  public void e()
  {
    if (this.k != null)
    {
      String str = getIntent().getStringExtra("formActivity");
      if (this.y != 1) {
        break label84;
      }
      if ((TextUtils.isEmpty(str)) || (!str.equals("IndividuationSetActivity"))) {
        break label71;
      }
      this.k.setText(2131561692);
    }
    for (;;)
    {
      if (this.l != null) {
        this.l.setText(2131562594);
      }
      return;
      label71:
      this.k.setText(2131562665);
      continue;
      label84:
      this.k.setText(2131561692);
    }
  }
  
  public void f()
  {
    g();
    String str1;
    if (this.z == 2) {
      str1 = getString(2131562013);
    }
    for (String str2 = getString(2131561699);; str2 = getString(2131561698))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, str1, str2, 2131561755, 2131562228, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      str1 = getString(2131562009);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void h()
  {
    if (this.z == 2)
    {
      VipUtils.b(this, 3, ProfileCardUtil.a(this.F));
      return;
    }
    VipUtils.a(this, 3, ProfileCardUtil.a(this.F));
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_Int == 4) {
          ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_Int = 2;
        }
        i1 += 1;
      }
    }
  }
  
  public void j() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardBrowserActivity
 * JD-Core Version:    0.7.0.1
 */