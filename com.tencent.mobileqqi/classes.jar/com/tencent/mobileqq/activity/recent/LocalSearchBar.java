package com.tencent.mobileqq.activity.recent;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.widget.XListView;
import ete;
import etf;
import etg;
import eth;

public class LocalSearchBar
{
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private View b;
  
  public LocalSearchBar(XListView paramXListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, OnRecentUserOpsListener paramOnRecentUserOpsListener)
  {
    this.jdField_a_of_type_Long = 0L;
    paramXListView = paramBaseActivity.getLayoutInflater().inflate(2130903942, paramXListView, false);
    paramXListView.findViewById(2131233084).setVisibility(8);
    IphoneTitleBarActivity.b(paramXListView);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.b = paramView2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    paramXListView = (EditText)paramXListView.findViewById(2131233085);
    paramXListView.setFocusableInTouchMode(false);
    paramXListView.setCursorVisible(false);
    paramXListView.setOnClickListener(new ete(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    System.currentTimeMillis();
    this.b.getHeight();
    etf localetf = new etf(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new etg(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, 4, localetf);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new eth(this));
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   4: ifnull +19 -> 23
    //   7: iconst_1
    //   8: invokestatic 123	com/tencent/mobileqq/activity/Conversation:d	(Z)V
    //   11: aload_0
    //   12: getfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   15: invokevirtual 126	com/tencent/mobileqq/activity/contact/SearchResultDialog:dismiss	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	LocalSearchBar
    //   0	39	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   7	18	24	java/lang/Exception
    //   7	18	31	finally
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   4: ifnull +19 -> 23
    //   7: iconst_1
    //   8: invokestatic 123	com/tencent/mobileqq/activity/Conversation:d	(Z)V
    //   11: aload_0
    //   12: getfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   15: invokevirtual 126	com/tencent/mobileqq/activity/contact/SearchResultDialog:dismiss	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 20	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	LocalSearchBar
    //   24	1	1	localException	java.lang.Exception
    //   31	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	24	java/lang/Exception
    //   7	18	31	finally
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null)
    {
      Conversation.d(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.LocalSearchBar
 * JD-Core Version:    0.7.0.1
 */