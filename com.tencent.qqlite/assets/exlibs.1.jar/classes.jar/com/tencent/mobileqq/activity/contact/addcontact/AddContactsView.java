package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import cbo;
import cbp;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = AddContactsView.class.getSimpleName();
  private static final String b = "、";
  private static final String c = "条件：";
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new cbo(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new cbp(this);
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  boolean jdField_a_of_type_Boolean = false;
  public String[] a;
  public boolean b = false;
  
  public AddContactsView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n()) || (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))) {
        break label80;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      return;
      label80:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131296509));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131493083), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130839347);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription("搜索栏、QQ号、手机号、邮箱、群");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)findViewById(2131296510));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130838651));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidContentContext.getString(2131363769));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
    if (((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).b()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(getResources().getDrawable(2130839373));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131296511);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130838623));
    ((FormSimpleItem)localObject).setLeftText(getResources().getString(2131363775));
    ((FormSimpleItem)localObject).setOnClickListener(this);
    ((FormSimpleItem)localObject).setContentDescription("添加手机联系人");
    localObject = (FormSimpleItem)findViewById(2131296512);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837521));
    ((FormSimpleItem)localObject).setLeftText(getContext().getString(2131363770));
    ((FormSimpleItem)localObject).setOnClickListener(this);
    localObject = (FormSimpleItem)findViewById(2131296513);
    ((FormSimpleItem)localObject).setLeftIcon(getResources().getDrawable(2130837520));
    ((FormSimpleItem)localObject).setLeftText(getContext().getString(2131363772));
    ((FormSimpleItem)localObject).setContentDescription(getContext().getString(2131363772));
    ((FormSimpleItem)localObject).setOnClickListener(this);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131493138);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49));
    a(2130903055);
    setBackgroundResource(2130837633);
    i();
    h();
  }
  
  protected void b()
  {
    super.b();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().c(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  public void d()
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("fillSearchConditions | autoReqLocation = ").append(this.jdField_a_of_type_Boolean).append(" | code one = ");
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length == 4))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
        QLog.d((String)localObject2, 2, localObject1);
      }
    }
    else
    {
      localObject1 = new StringBuilder("条件：");
      int i = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      if (i != 0) {
        ((StringBuilder)localObject1).append(ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString[i]).append("、");
      }
      i = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
      if (i != 0) {
        ((StringBuilder)localObject1).append(ConditionSearchManager.b[i]).append("、");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label465;
      }
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.b)) {
        if ("-1".equals(this.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject2 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (localObject2 == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = ((Card)localObject2).strLocationCodes.split("-");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "card.strLocationCodes = " + ((Card)localObject2).strLocationCodes);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, (String)localObject2);
          if (!"0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject2)).append("、");
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
          if (!((String)localObject2).startsWith("不限")) {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject2));
          }
          localObject2 = ((StringBuilder)localObject1).toString();
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("、")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          if (((String)localObject1).equals("条件：")) {
            break label505;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText((CharSequence)localObject1);
          return;
          localObject1 = Integer.valueOf(-1000);
          break;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "spliteLocationString | exception: ", localException1);
          continue;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseLocationDesc", localException2);
          continue;
        }
      }
      label465:
      String str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
      if (!str.startsWith("不限")) {
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(str)).append("、");
      }
    }
    label505:
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296509: 
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      return;
    case 2131296510: 
      ((FormSimpleItem)findViewById(2131296510)).setRightIcon(null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts"));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
      return;
    case 2131296512: 
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class).putExtra("from", "addcontacts"));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_scan", 0, 0, "", "", "", "");
      return;
    case 2131296513: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A8", "0X80041A8", 0, 0, "", "", "", "");
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, CreateFaceToFaceDiscussionActivity.class);
      paramView.putExtra("param_face_to_face_troop", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PhoneFrameActivity.class);
    paramView.putExtra("key_req_type", 3);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */