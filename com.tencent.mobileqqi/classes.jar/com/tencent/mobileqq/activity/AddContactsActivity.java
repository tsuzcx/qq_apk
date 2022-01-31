package com.tencent.mobileqq.activity;

import SummaryCard.RespSearch;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import bte;
import bth;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.permission.PermissionManager;

public class AddContactsActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener
{
  private static final String jdField_b_of_type_JavaLangString = AddContactsActivity.class.getSimpleName();
  private static final String c = "http://find.qq.com/m/index.html?_wv=1026&_bid=140";
  private final int jdField_a_of_type_Int = 64;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public FriendListObserver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString = "";
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private final Pattern jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
  
  public AddContactsActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bth(this);
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, AddContactsActivity.class));
  }
  
  public static void b(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountBrowser.class);
    if ((paramActivity instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).a());
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", "http://find.qq.com/m/index.html?_wv=1026&_bid=140");
    paramActivity.startActivity(localIntent);
  }
  
  private void c(String paramString)
  {
    try
    {
      localObject = URLEncoder.encode(paramString, "utf-8");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      label9:
      break label9;
    }
    paramString = "http://find.qq.com/m/search.html?searchText=" + paramString + "&_bid=140&searchType=2";
    localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    startActivity((Intent)localObject);
  }
  
  private void d()
  {
    Object localObject = findViewById(2131231067);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131231069));
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131231068));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131231070);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130838697));
    ((FormSimpleItem)localObject).setLeftText(getString(2131562330));
    ((FormSimpleItem)localObject).setBgType(3);
    if (((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a()) {
      ((FormSimpleItem)localObject).setRightIcon(getResources().getDrawable(2130840212));
    }
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131231071);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837623));
    ((FormSimpleItem)localObject).setLeftText(getString(2131562816));
    ((FormSimpleItem)localObject).setBgType(0);
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131231072);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837620));
    ((FormSimpleItem)localObject).setLeftText(getString(2131562115));
    ((FormSimpleItem)localObject).setBgType(1);
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131231073);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837619));
    ((FormSimpleItem)localObject).setLeftText(getString(2131561887));
    ((FormSimpleItem)localObject).setBgType(2);
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
    ((FormSimpleItem)localObject).setVisibility(8);
    localObject = (FormSimpleItem)findViewById(2131231075);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837618));
    ((FormSimpleItem)localObject).setLeftText(getString(2131562264));
    ((FormSimpleItem)localObject).setContentDescription(getString(2131562264));
    ((FormSimpleItem)localObject).setBgType(3);
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131231074);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837621));
    ((FormSimpleItem)localObject).setLeftText(getString(2131562331));
    ((FormSimpleItem)localObject).setBgType(3);
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131231076);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130838392));
    ((FormSimpleItem)localObject).setLeftText(getString(2131562439));
    ((FormSimpleItem)localObject).setBgType(0);
    ((FormSimpleItem)localObject).a(true);
    ((FormSimpleItem)localObject).setOnClickListener(this);
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetTextView.getEditableText().toString().trim();
    if (this.jdField_a_of_type_JavaLangString.indexOf("@") != -1)
    {
      if (this.jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).matches()) {
        break label120;
      }
      a(getResources().getString(2131559028));
    }
    label120:
    do
    {
      return;
      String str = this.jdField_a_of_type_JavaLangString.replace("+", "").replace("-", "").replace(".", "");
      if (str.length() < 5)
      {
        a(getResources().getString(2131559029));
        return;
      }
      this.jdField_a_of_type_JavaLangString = str;
      if (!NetworkUtil.e(this)) {
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_a_of_type_JavaLangString, PhoneCodeUtils.a(a()));
      b(getString(2131562833));
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetTextView.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131562449, 0).b(d());
  }
  
  public void a(RespSearch paramRespSearch)
  {
    Intent localIntent = new Intent(this, SearchFriendListActivity.class);
    localIntent.putExtra("param_search_resp", paramRespSearch.toByteArray());
    localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
    startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    QQToast.a(this, paramString, 0).b(d());
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903081);
    j(2130837729);
    setTitle(2131561589);
    d();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131231069: 
    default: 
      return;
    case 2131231070: 
      ((FormSimpleItem)findViewById(2131231070)).setRightIcon(null);
      startActivity(new Intent(this, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts"));
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
      return;
    case 2131231071: 
      startActivity(new Intent(this, ScannerActivity.class).putExtra("from", "addcontacts"));
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_scan", 0, 0, "", "", "", "");
      return;
    case 2131231072: 
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "feature_external", "grp_search_in_external", 40, 1, 0);
      startActivity(new Intent(a(), AddFriendActivity.class).putExtra("btroop", true).putExtra("param_return_addr", Leba.class.getName()));
      return;
    case 2131231073: 
      paramView = (TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      if (paramView != null) {
        paramView.a(this, 0);
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "Clk_create", 0, 0, "", "", "", "");
      return;
    case 2131231075: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A8", "0X80041A8", 0, 0, "", "", "", "");
      paramView = new Intent(this, CreateFaceToFaceDiscussionActivity.class);
      paramView.putExtra("param_face_to_face_troop", true);
      startActivity(paramView);
      return;
    case 2131231074: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Clk_lifeservice", 46, 0, "", "", "", "");
      b(this);
      return;
    case 2131231068: 
      a();
      return;
    }
    if (!this.permissionManager.checkPermission("android.permission.ACCESS_FINE_LOCATION"))
    {
      paramView = new PermissionsDialog();
      bte localbte = new bte(this);
      paramView.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, localbte);
      return;
    }
    startActivity(new Intent(this, NearbyTroopsActivity.class));
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */