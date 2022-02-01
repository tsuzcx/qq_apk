package com.tencent.mobileqq.activity;

import acbu;
import acfd;
import acff;
import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.List;
import vhs;
import vht;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private acfd jdField_a_of_type_Acfd = new vhs(this);
  private arhz jdField_a_of_type_Arhz;
  private a jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$a;
  private byte aO;
  private String aOp;
  byte aP;
  private boolean aYH;
  private XListView q;
  List<Entity> qT = null;
  
  private void finishWithResult()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.aP);
    Groups localGroups = ((acff)this.app.getManager(51)).a(String.valueOf(this.aP));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
      }
      anot.a(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
      finish();
      return;
      localIntent.putExtra("group_name", localGroups.group_name);
    }
  }
  
  private void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()))
    {
      this.jdField_a_of_type_Arhz.dismiss();
      this.jdField_a_of_type_Arhz = null;
    }
  }
  
  private void showProgressDialog()
  {
    arhz localarhz = new arhz(this);
    this.jdField_a_of_type_Arhz = localarhz;
    localarhz.setOffsetY(getTitleBarHeight());
    localarhz.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559674);
    setTitle(getString(2131696000));
    paramBundle = (TextView)findViewById(2131369579);
    paramBundle.setContentDescription(acfp.m(2131708478));
    this.aOp = getIntent().getExtras().getString("friendUin");
    this.aYH = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.aO = getIntent().getExtras().getByte("mgid");
    this.aP = this.aO;
    this.qT = ((acff)this.app.getManager(51)).cr();
    this.q = ((XListView)findViewById(2131371981));
    this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$a = new a(null);
    this.q.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$a);
    paramBundle.setOnClickListener(new vht(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Acfd);
    hideProgressDialog();
    if (this.aYH) {
      acbu.a().cHc();
    }
  }
  
  public boolean onBackEvent()
  {
    finishWithResult();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.aP = ((byte)((Groups)this.qT.get(i)).group_id);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$a.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true)) {
      if ((this.aP >= 0) && (this.aP != this.aO)) {
        if (aqiw.isNetSupport(this))
        {
          FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
          addObserver(this.jdField_a_of_type_Acfd);
          localFriendListHandler.b(this.aOp, this.aP, this.aO);
          showProgressDialog();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.app.getApp(), getString(2131696346), 1).show(getTitleBarHeight());
      finish();
      continue;
      if (this.aP == this.aO) {
        QQToast.a(this, getString(2131695998), 0).show(getTitleBarHeight());
      }
      finishWithResult();
    }
  }
  
  class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (MoveToGroupActivity.this.qT != null) {
        return MoveToGroupActivity.this.qT.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = MoveToGroupActivity.this.getLayoutInflater().inflate(2131559675, null);
        int i = (byte)((Groups)MoveToGroupActivity.this.qT.get(paramInt)).group_id;
        localObject = (ImageView)localView.findViewById(2131364596);
        if (i != MoveToGroupActivity.this.aP) {
          break label163;
        }
        ((ImageView)localObject).setVisibility(0);
      }
      for (;;)
      {
        localObject = (TextView)localView.findViewById(2131368213);
        ((TextView)localObject).setText(((Groups)MoveToGroupActivity.this.qT.get(paramInt)).group_name);
        localView.setContentDescription(((TextView)localObject).getText().toString());
        localView.setTag(Integer.valueOf(paramInt));
        localView.setOnClickListener(MoveToGroupActivity.this);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        localView = paramView;
        break;
        label163:
        ((ImageView)localObject).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */