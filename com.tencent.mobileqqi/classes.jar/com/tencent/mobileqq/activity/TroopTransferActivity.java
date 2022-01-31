package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dyo;
import dyp;
import dyq;
import dyr;
import dys;
import dyt;
import dyu;
import dyv;
import dyw;
import dyx;
import dyz;
import dza;
import dzb;
import dzc;
import dzd;
import dze;
import dzf;
import dzg;
import dzj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TroopTransferActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener
{
  public static final int a = 0;
  protected static final String a = "Q.troopdisband.transfer";
  public static final int b = 1;
  protected static final int c = 2;
  private static final int d = 0;
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public TroopTransferActivity.TroopMemberListAdapter a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dyw(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dyx(this);
  public QQProgressNotifier a;
  protected XListView a;
  protected dze a;
  protected Integer a;
  protected List a;
  public boolean a;
  protected View b;
  protected TextView b;
  public XListView b;
  public String b;
  protected View c;
  protected TextView c;
  public String c;
  protected TextView d;
  protected String d;
  
  public TroopTransferActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
  }
  
  private void f()
  {
    Object localObject = (ViewGroup)findViewById(2131231448);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = findViewById(2131232155);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = (TextView)findViewById(2131231456);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
  }
  
  protected void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem)
  {
    Object localObject = String.format(getString(2131561530), new Object[] { paramTroopMemberItem.jdField_b_of_type_JavaLangString });
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    String str = paramTroopMemberItem.jdField_a_of_type_JavaLangString;
    localQQCustomDialog.setTitle(2131563099);
    localQQCustomDialog.setMessage((String)localObject);
    localQQCustomDialog.setPositiveButton(getString(2131562539), new dyq(this, str, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131558433));
    localQQCustomDialog.setNegativeButton(getString(2131561746), new dyr(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131558434));
    localQQCustomDialog.show();
    localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramTroopMemberItem.jdField_b_of_type_Int == 1) {}
    for (paramTroopMemberItem = "1";; paramTroopMemberItem = "0")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramTroopMemberItem, "", "", "");
      return;
    }
  }
  
  public void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem, Friends paramFriends)
  {
    if (!c()) {
      return;
    }
    new dyu(this, paramFriends, paramTroopMemberItem).start();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (dzj)paramView.getTag();
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.a; (paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_Int == 1); paramAdapterView = null)
      {
        a(paramAdapterView);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Dze.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)localList.get(i);
      localTroopMemberItem.e = "";
      localTroopMemberItem.f = "";
      if ((localTroopMemberItem.m.equals(paramString)) || (localTroopMemberItem.o.equals(paramString)) || (localTroopMemberItem.n.equals(paramString)))
      {
        localTroopMemberItem.e = localTroopMemberItem.m;
        localArrayList1.add(localTroopMemberItem);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localTroopMemberItem.j.equals(paramString)) || (localTroopMemberItem.l.equals(paramString)) || (localTroopMemberItem.k.equals(paramString)))
        {
          localTroopMemberItem.e = localTroopMemberItem.j;
          localArrayList1.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.g.equals(paramString)) || (localTroopMemberItem.i.equals(paramString)) || (localTroopMemberItem.h.equals(paramString)))
        {
          localTroopMemberItem.e = localTroopMemberItem.g;
          localArrayList1.add(localTroopMemberItem);
        }
        else if (localTroopMemberItem.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.m.indexOf(paramString) == 0) || (localTroopMemberItem.o.indexOf(paramString) == 0) || (localTroopMemberItem.n.indexOf(paramString) == 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.m;
          localTroopMemberItem.f = localTroopMemberItem.n;
          localArrayList2.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.j.indexOf(paramString) == 0) || (localTroopMemberItem.l.indexOf(paramString) == 0) || (localTroopMemberItem.k.indexOf(paramString) == 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.j;
          localTroopMemberItem.f = localTroopMemberItem.k;
          localArrayList2.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.g.indexOf(paramString) == 0) || (localTroopMemberItem.i.indexOf(paramString) == 0) || (localTroopMemberItem.h.indexOf(paramString) == 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.g;
          localTroopMemberItem.f = localTroopMemberItem.h;
          localArrayList2.add(localTroopMemberItem);
        }
        else if (localTroopMemberItem.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localTroopMemberItem.f = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.m.indexOf(paramString) > 0) || (localTroopMemberItem.o.indexOf(paramString) > 0) || (localTroopMemberItem.n.indexOf(paramString) > 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.m;
          localArrayList3.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.j.indexOf(paramString) > 0) || (localTroopMemberItem.l.indexOf(paramString) > 0) || (localTroopMemberItem.k.indexOf(paramString) > 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.j;
          localArrayList3.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.g.indexOf(paramString) > 0) || (localTroopMemberItem.i.indexOf(paramString) > 0) || (localTroopMemberItem.h.indexOf(paramString) > 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.g;
          localArrayList3.add(localTroopMemberItem);
        }
        else if (localTroopMemberItem.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localTroopMemberItem);
        }
      }
    }
    Collections.sort(localArrayList2, new dzf(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Dze.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    ChnToSpell.a(BaseApplication.getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131233212));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232155);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231457));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231380));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231313));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131563099));
    setTitle(2131563099);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131561692);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new dyo(this));
    localObject = (LinearLayout)getLayoutInflater().inflate(2130903942, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((LinearLayout)localObject).setPadding(0, 0, 40, 0);
    ((Button)((LinearLayout)localObject).findViewById(2131233084)).setVisibility(8);
    ((EditText)((LinearLayout)localObject).findViewById(2131233085)).setOnTouchListener(new dyv(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter = new TroopTransferActivity.TroopMemberListAdapter(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      runOnUiThread(new dys(this));
    }
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      Integer localInteger2 = this.jdField_a_of_type_JavaLangInteger;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() - 1);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "finUpdateThread|[" + this.jdField_a_of_type_JavaLangInteger + ", needUpdateUI = " + paramBoolean + "]");
      }
      return;
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!Utils.a(localTroopMemberCardInfo.troopuin, this.jdField_b_of_type_JavaLangString))) {}
    while (!c()) {
      return;
    }
    new dyt(this, paramArrayList).start();
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_JavaLangInteger.intValue() >= 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "too many update thread|total = " + this.jdField_a_of_type_JavaLangInteger);
      }
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      Integer localInteger2 = this.jdField_a_of_type_JavaLangInteger;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() + 1);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "add update thread |nTotalThreadCount = " + this.jdField_a_of_type_JavaLangInteger);
      }
      return true;
    }
  }
  
  protected void d()
  {
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, "troopuin = " + l + " is illegal");
        }
        finish();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, localException.toString());
      }
      finish();
    }
  }
  
  public void e()
  {
    int i = d();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    Object localObject2 = new dyz(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
    localTranslateAnimation.setFillAfter(true);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setAnimationListener((Animation.AnimationListener)localObject2);
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903945);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new dza(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231116);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131233085));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new dzg(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131233086));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new dzb(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131233084);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new dzc(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231403);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231401));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new dzd(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131234405));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837729);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Dze = new dze(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dze);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new dyp(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("troop_code");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("uinname");
    paramBundle = paramBundle.getStringArrayList("troopVipMembers");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate").append("| mTroopUin = ").append(this.jdField_b_of_type_JavaLangString).append("| mTroopCode = ").append(this.jdField_c_of_type_JavaLangString).append("| mTroopName = ").append(this.jdField_d_of_type_JavaLangString).append("| mVipMemberList").append(paramBundle);
      QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
    }
    d();
    setContentView(2130903635);
    a(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    f();
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      e();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    MenuItem localMenuItem = paramMenu.add(0, 0, 0, getString(2131562830));
    localMenuItem.setIcon(2130839696);
    MenuItemCompat.setShowAsAction(localMenuItem, 1);
    return super.onPrepareOptionsMenu(paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */