package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import cky;
import ckz;
import cla;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import java.util.List;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  public static final int a = 3;
  public static final int b = 1;
  private static final int d = 1;
  private static final int e = 2;
  private ckz jdField_a_of_type_Ckz;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public List a;
  public int c = -1;
  
  public ContactsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131298716));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298717));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = ((List)this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b().get(0));
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_Ckz == null)
    {
      this.jdField_a_of_type_Ckz = new ckz(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ckz);
    }
    this.jdField_a_of_type_Ckz.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new cky(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.c();
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, PhoneFrameActivity.class);
    localIntent.putExtra("call_by_select_member", true);
    localIntent.putExtra("key_req_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.startActivityForResult(localIntent, 1);
  }
  
  public String a()
  {
    return "-1";
  }
  
  public List a()
  {
    return SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 30064771072L);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label21;
      }
      this.c = 7;
      h();
    }
    label21:
    while (paramInt2 != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0, false);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903608);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    g();
    this.jdField_a_of_type_Ckz = new ckz(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ckz);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Ckz.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Ckz.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363983), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363976));
    switch (this.c)
    {
    case 5: 
    case 6: 
    default: 
      i();
      return;
    case 0: 
    case 4: 
    case 7: 
      this.jdField_a_of_type_Ckz.notifyDataSetChanged();
      return;
    case 1: 
    case 2: 
      j();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a().lastUsedFlag == 2L)
    {
      this.jdField_a_of_type_Ckz.notifyDataSetChanged();
      return;
    }
    j();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactsInnerFrame.class);
    if (this.jdField_a_of_type_Ckz != null) {
      this.jdField_a_of_type_Ckz.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Ckz.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    cla localcla = (cla)paramView.getTag();
    PhoneContact localPhoneContact;
    if ((localcla != null) && (localcla.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localcla.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      localPhoneContact = localcla.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (localcla.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        if (!localcla.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localcla.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1");; bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localcla.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1"))
    {
      localcla.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!localcla.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break;
      }
      paramView.setContentDescription(localcla.c.getText().toString() + "已选中");
      return;
    }
    paramView.setContentDescription(localcla.c.getText().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */