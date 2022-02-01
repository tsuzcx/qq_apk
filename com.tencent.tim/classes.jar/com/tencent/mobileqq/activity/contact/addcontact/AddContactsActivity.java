package com.tencent.mobileqq.activity.contact.addcontact;

import aehn;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anol;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import obg;
import org.json.JSONException;
import org.json.JSONObject;
import ymw;
import ynb;

public class AddContactsActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private AddContactsView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
  public ContactBaseView.a a;
  private ContactBaseView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
  private TroopView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView;
  private PublicView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView;
  Handler bZ = new ynb(this);
  private FrameLayout bg;
  public boolean bnD;
  private boolean bnE;
  public LinearLayout fY;
  private TextView mLeftBackText;
  private ImageView un;
  
  public AddContactsActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a = new ymw(this);
  }
  
  private void a(ContactBaseView paramContactBaseView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != paramContactBaseView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onPause();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onStop();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView = paramContactBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onStart();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onResume();
        }
        this.bg.removeAllViews();
        this.bg.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView);
      }
    }
  }
  
  private void cjM() {}
  
  private void cjN()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView = new AddContactsView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.onCreate();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
  }
  
  private void initData()
  {
    boolean bool = true;
    String str = aehn.aS(this.app.getCurrentAccountUin(), "add_contact_page_public_account_switch");
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.Activity", 2, "public account switch config is: " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        if (new JSONObject(str).optInt("showPublicTab") == 1)
        {
          this.bnE = bool;
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("addContacts.Activity", 2, "public account switch config is: " + QLog.getStackTraceString(localJSONException));
      }
      bool = false;
    }
  }
  
  @TargetApi(14)
  private void initView()
  {
    ((TextView)findViewById(2131369627)).setText(2131721053);
    this.fY = ((LinearLayout)findViewById(2131377546));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.fY.setFitsSystemWindows(true);
      this.fY.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mLeftBackText = ((TextView)findViewById(2131369579));
    this.mLeftBackText.setText("");
    this.mLeftBackText.setOnClickListener(this);
    this.mLeftBackText.setContentDescription(getString(2131698331));
    this.un = ((ImageView)findViewById(2131369639));
    this.un.setOnClickListener(this);
    String str = Build.MODEL.toUpperCase();
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsActivity", 2, "initView  model = " + str);
    }
    this.bg = ((FrameLayout)findViewById(2131365250));
    cjN();
  }
  
  public static void m(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, AddContactsActivity.class);
    localIntent.putExtra("tab_index_key", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putParcelable("android:support:fragments", null);
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131561158);
    getWindow().setBackgroundDrawable(null);
    initData();
    initView();
    cjM();
    anol.a(getApplicationContext()).reportKVEvent("AddContactsActivity", null);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.onDestroy();
    }
    super.doOnDestroy();
    obg.a().bdc();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onResume();
    }
    if (this.bnD) {
      this.bZ.sendEmptyMessage(0);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onStart();
    }
    this.bZ.sendEmptyMessage(1);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.onStop();
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      if (1 == xf())
      {
        Intent localIntent = new Intent(this, SearchContactsActivity.class);
        localIntent.putExtra("from_key", xf());
        localIntent.putExtra("fromType", 13);
        startActivity(localIntent);
        overridePendingTransition(0, 0);
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public int xf()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof AddContactsView)) {
      return 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof TroopView)) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */