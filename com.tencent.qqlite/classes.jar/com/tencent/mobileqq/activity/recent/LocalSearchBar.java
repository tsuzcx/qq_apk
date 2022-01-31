package com.tencent.mobileqq.activity.recent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.EditText;
import clq;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

public class LocalSearchBar
  implements DialogInterface.OnDismissListener, View.OnClickListener, Animation.AnimationListener, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  
  public LocalSearchBar(XListView paramXListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, OnRecentUserOpsListener paramOnRecentUserOpsListener)
  {
    View localView = paramBaseActivity.getLayoutInflater().inflate(2130903610, paramXListView, false);
    paramXListView.a(localView);
    IphoneTitleBarActivity.setLayerType(localView);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297286);
    paramXListView = (EditText)localView.findViewById(2131297962);
    paramXListView.setFocusableInTouchMode(false);
    paramXListView.setCursorVisible(false);
    paramXListView.setOnClickListener(this);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "showSearchDialog() mLoaLocalSearchDialog = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new clq(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 4, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(this);
    }
    if ((this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) || (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null))
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewView.getHeight();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_Int, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837660);
    }
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    ThreadPriorityManager.a(true);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   11: invokevirtual 189	com/tencent/mobileqq/activity/contact/SearchResultDialog:dismiss	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	LocalSearchBar
    //   20	1	1	localException	java.lang.Exception
    //   27	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	20	java/lang/Exception
    //   7	14	27	finally
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   11: invokevirtual 189	com/tencent/mobileqq/activity/contact/SearchResultDialog:dismiss	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 29	com/tencent/mobileqq/activity/recent/LocalSearchBar:jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog	Lcom/tencent/mobileqq/activity/contact/SearchResultDialog;
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	LocalSearchBar
    //   0	35	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   7	14	20	java/lang/Exception
    //   7	14	27	finally
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    long l = Math.abs(paramLong - this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onItemClick() gap = " + l);
    }
    if (l < 250L) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() 点击太快了吧， pos = " + paramInt);
      }
    }
    label183:
    for (;;)
    {
      return;
      this.jdField_b_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() pos = " + paramInt);
      }
      paramAdapterView = paramAdapterView.a();
      if (paramAdapterView == null) {}
      for (paramAdapterView = null;; paramAdapterView = paramAdapterView.getItem(paramInt))
      {
        if (!(paramAdapterView instanceof ContactsSearchableRecentUser)) {
          break label183;
        }
        paramAdapterView = (ContactsSearchableRecentUser)paramAdapterView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, paramAdapterView, paramAdapterView.a(), false);
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.dismiss();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(0);
      }
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, "conversationTab search up anim time: " + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
    }
    ThreadPriorityManager.a(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onClick() time stamp = " + (l - this.jdField_a_of_type_Long));
    }
    if (l - this.jdField_a_of_type_Long > 1000L)
    {
      this.jdField_a_of_type_Long = l;
      c();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837660);
    }
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.LocalSearchBar
 * JD-Core Version:    0.7.0.1
 */