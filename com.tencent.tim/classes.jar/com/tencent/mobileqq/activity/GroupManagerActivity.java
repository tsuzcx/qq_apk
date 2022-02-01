package com.tencent.mobileqq.activity;

import abeo;
import acfd;
import acff;
import afif;
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
import android.widget.TextView;
import aqiw;
import aqky;
import arhz;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.f;
import com.tencent.mobileqq.emosm.view.DragSortListView.g;
import com.tencent.mobileqq.emosm.view.DragSortListView.j;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vcz;
import vda;
import vdb;
import vdc;
import vdd;
import vde;
import vdf;
import vdg;
import vdh;
import vdi;
import vdj;
import vdk;
import vdl;

public class GroupManagerActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private Dialog Q;
  private abeo<Groups> jdField_a_of_type_Abeo;
  private acfd jdField_a_of_type_Acfd = new vdd(this);
  private aqky jdField_a_of_type_Aqky;
  private DragSortListView.f jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$f = new vdj(this);
  private DragSortListView.j jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$j = new vdk(this);
  private boolean aXp;
  private boolean aXq;
  private boolean aXr;
  private Groups jdField_b_of_type_ComTencentMobileqqDataGroups;
  private DragSortListView jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  private int bHI;
  @SuppressLint({"HandlerLeak"})
  private Handler bM = new vdb(this);
  public byte[] cb = null;
  public byte[] cc = null;
  private Dialog j;
  private int mTitleBarHeight;
  public List<Groups> oW;
  private DialogInterface.OnClickListener x = new vdh(this);
  private DialogInterface.OnClickListener y = new vdi(this);
  
  private void aC()
  {
    this.leftView.setVisibility(8);
    setRightButton(2131694543, new vcz(this));
    setTitle(2131694542);
  }
  
  public static void bu(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, GroupManagerActivity.class));
    paramActivity.overridePendingTransition(2130771991, 2130771992);
  }
  
  private void d(byte paramByte)
  {
    bPI();
    ausj localausj = (ausj)auss.a(this, null);
    localausj.setMainTitle(2131694546);
    localausj.addButton(2131694539, 3);
    localausj.addCancelButton(2131694541);
    localausj.setOnDismissListener(new vdl(this));
    localausj.a(new vda(this, paramByte));
    this.Q = localausj;
    this.Q.show();
  }
  
  private void initUI()
  {
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager((DragSortListView.g)localObject);
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$f);
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$j);
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new vde(this));
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setLeftEventListener(new vdf(this));
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setVerticalScrollBarEnabled(false);
    localObject = getLayoutInflater().inflate(2131559414, null);
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView((View)localObject);
    ((View)localObject).findViewById(2131368183).setOnClickListener(new vdg(this));
    localObject = new View(getActivity());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(10.0F * getResources().getDisplayMetrics().density)));
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.addFooterView((View)localObject);
  }
  
  public void Ba(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "showWaitingDialog");
    }
    xt(false);
    if ((this.j != null) && (this.j.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "WatingDialog is showing already!");
      }
      return;
    }
    Object localObject = new arhz(this, this.mTitleBarHeight);
    ((arhz)localObject).setMessage(paramInt);
    this.j = ((Dialog)localObject);
    this.j.setOnDismissListener(new vdc(this));
    this.j.show();
    this.aXq = false;
    this.aXr = false;
    localObject = this.bM.obtainMessage(0);
    this.bM.sendMessageDelayed((Message)localObject, 500L);
  }
  
  public afif a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new afif(paramDragSortListView);
    paramDragSortListView.setDragHandleId(2131366134);
    paramDragSortListView.setClickRemoveId(2131364671);
    paramDragSortListView.setRemoveEnabled(true);
    paramDragSortListView.setSortEnabled(true);
    paramDragSortListView.setDragInitMode(0);
    paramDragSortListView.setRemoveMode(0);
    return paramDragSortListView;
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    if (!aqiw.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(byte paramByte, String paramString)
  {
    if (!aqiw.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.b(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!aqiw.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.b(paramArrayOfByte1, paramArrayOfByte2);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void bPI()
  {
    if (this.Q != null)
    {
      if (this.Q.isShowing()) {
        this.Q.dismiss();
      }
      this.Q = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  void bqh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "scrollToBottom:" + this.oW.size());
    }
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.smoothScrollToPosition(this.oW.size());
  }
  
  public boolean c(byte paramByte)
  {
    if (!aqiw.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.f(paramByte);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.mTitleBarHeight = getResources().getDimensionPixelSize(2131299627);
    super.setContentView(2131561369);
    aC();
    initUI();
    this.app.addObserver(this.jdField_a_of_type_Acfd);
    this.oW = new ArrayList();
    refresh();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onDestroy");
    }
    super.doOnDestroy();
    this.bM.removeMessages(0);
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771989, 2130771990);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (456 == paramMessage.what) {
      refresh();
    }
    for (;;)
    {
      return false;
      if (457 == paramMessage.what) {
        bqh();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    overridePendingTransition(2130771989, 2130771990);
    return bool;
  }
  
  public void refresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "/************************Start Refresh:");
    }
    this.oW.clear();
    Object localObject = (acff)this.app.getManager(51);
    if (localObject != null) {}
    for (localObject = ((acff)localObject).cr();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Groups localGroups = (Groups)((Iterator)localObject).next();
          this.oW.add(localGroups);
        }
      }
      if (this.jdField_a_of_type_Abeo == null)
      {
        this.jdField_a_of_type_Abeo = new abeo(this, this.oW, this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView);
        this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Abeo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("GroupManagerActivity", 2, "End Refresh************************ size = " + this.oW.size());
        localObject = "[";
        int i = 0;
        for (;;)
        {
          if (i < this.oW.size())
          {
            localObject = (String)localObject + (byte)((Groups)this.oW.get(i)).group_id + "   ";
            i += 1;
            continue;
            this.jdField_a_of_type_Abeo.notifyDataSetChanged();
            break;
          }
        }
        localObject = (String)localObject + "]";
        QLog.d("GroupManagerActivity", 2, "End Refresh************************ s = " + (String)localObject);
      }
      return;
    }
  }
  
  public void xt(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "dismissWaitingDialog delayPassed = " + this.aXr);
    }
    if ((this.aXr) && (this.j != null))
    {
      if (this.j.isShowing()) {
        this.j.dismiss();
      }
      this.j = null;
      if (paramBoolean) {
        refresh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity
 * JD-Core Version:    0.7.0.1
 */