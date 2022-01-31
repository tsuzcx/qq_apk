package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.FloatViewManager;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cvr;
import cvs;
import cvt;
import cvu;
import cvv;
import cvw;
import cvx;
import cvy;
import cvz;
import cwa;
import cwb;
import cwc;
import cwd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupManagerActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 9527;
  public static final String a;
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  private static final int d = 456;
  private static final int e = 457;
  private static final int f = 10;
  private static final int g = 500;
  private static final int h = 0;
  private static final int i = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new cvz(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new cvt(this);
  private GroupEditeDragSortAdapter jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cvv(this);
  private Groups jdField_a_of_type_ComTencentMobileqqDataGroups;
  private DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new cwb(this);
  private DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new cwc(this);
  private DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  public List a;
  private boolean jdField_a_of_type_Boolean;
  public byte[] a;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new cwa(this);
  private boolean jdField_b_of_type_Boolean;
  public byte[] b;
  private boolean jdField_c_of_type_Boolean;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_JavaLangString = GroupManagerActivity.class.getSimpleName();
  }
  
  public GroupManagerActivity()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  private void a(byte paramByte)
  {
    c();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131561645);
    localActionSheet.a(2131562752, 3);
    localActionSheet.d(2131561744);
    localActionSheet.setOnDismissListener(new cwd(this));
    localActionSheet.a(new cvs(this, paramByte));
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, GroupManagerActivity.class));
    paramActivity.overridePendingTransition(2130968591, 2130968592);
  }
  
  private void d()
  {
    this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
    c(2131561978, new cvr(this));
    setTitle(2131561778);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager((DragSortListView.FloatViewManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new cvw(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setLeftEventListener(new cvx(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setVerticalScrollBarEnabled(false);
    localObject = getLayoutInflater().inflate(2130903245, null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView((View)localObject);
    ((View)localObject).findViewById(2131231765).setOnClickListener(new cvy(this));
    localObject = new View(a());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(10.0F * getResources().getDisplayMetrics().density)));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addFooterView((View)localObject);
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.setDragHandleId(2131230761);
    paramDragSortListView.setClickRemoveId(2131230762);
    paramDragSortListView.setRemoveEnabled(true);
    paramDragSortListView.setSortEnabled(true);
    paramDragSortListView.setDragInitMode(0);
    paramDragSortListView.setRemoveMode(0);
    return paramDragSortListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "/************************Start Refresh:");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null) {}
    for (localObject = ((FriendManager)localObject).c();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Groups localGroups = (Groups)((Iterator)localObject).next();
          if (localGroups.group_id != -1006) {
            this.jdField_a_of_type_JavaUtilList.add(localGroups);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter = new GroupEditeDragSortAdapter(this, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter);
      }
      while (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "End Refresh************************ size = " + this.jdField_a_of_type_JavaUtilList.size());
        localObject = "[";
        int m = 0;
        for (;;)
        {
          if (m < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject = (String)localObject + (byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(m)).group_id + "   ";
            m += 1;
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter.notifyDataSetChanged();
            break;
          }
        }
        localObject = (String)localObject + "]";
        QLog.d(jdField_a_of_type_JavaLangString, 2, "End Refresh************************ s = " + (String)localObject);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showWaitingDialog");
    }
    a(false);
    Object localObject = new QQProgressDialog(this, this.j);
    ((QQProgressDialog)localObject).b(paramInt);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new cvu(this));
    this.jdField_b_of_type_AndroidAppDialog.show();
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dismissWaitingDialog delayPassed = " + this.c);
    }
    if ((this.c) && (this.jdField_b_of_type_AndroidAppDialog != null))
    {
      if (this.jdField_b_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_b_of_type_AndroidAppDialog = null;
      if (paramBoolean) {
        a();
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "scrollToBottom:" + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.smoothScrollToPosition(this.jdField_a_of_type_JavaUtilList.size());
  }
  
  protected boolean b()
  {
    boolean bool = super.b();
    overridePendingTransition(2130968589, 2130968590);
    return bool;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.j = getResources().getDimensionPixelSize(2131427376);
    setContentView(2130903577);
    d();
    e();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968590);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (456 == paramMessage.what) {
      a();
    }
    for (;;)
    {
      return false;
      if (457 == paramMessage.what) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity
 * JD-Core Version:    0.7.0.1
 */