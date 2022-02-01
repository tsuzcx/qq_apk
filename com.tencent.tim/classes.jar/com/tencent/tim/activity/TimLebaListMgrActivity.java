package com.tencent.tim.activity;

import ackr;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import atav;
import ataw;
import atcn;
import atcn.a;
import aunq;
import aunr;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Iterator;
import java.util.List;
import zjq;

public class TimLebaListMgrActivity
  extends IphoneTitleBarActivity
  implements atcn.a
{
  private TextView DZ;
  protected ackr a;
  private atcn a;
  private boolean aXV = true;
  private XListView m;
  private DataSetObserver mDataSetObserver = new atav(this);
  
  public TimLebaListMgrActivity()
  {
    this.jdField_a_of_type_Ackr = new ataw(this);
  }
  
  private List<aunr> he()
  {
    List localList = aunq.a().dp();
    aunr localaunr;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localaunr = (aunr)localIterator.next();
      } while (!"PKG_PHONE".equals(localaunr.c.strPkgName));
    }
    for (;;)
    {
      if (localaunr != null) {
        localList.remove(localaunr);
      }
      return localList;
      localaunr = null;
    }
  }
  
  private void initUI()
  {
    if (this.m == null)
    {
      this.m = ((XListView)View.inflate(this, 2131561404, null));
      this.m.setDivider(null);
      this.m.setVerticalScrollBarEnabled(false);
      View localView = View.inflate(this, 2131561402, null);
      this.DZ = ((TextView)localView.findViewById(2131379769));
      this.DZ.setText(2131695247);
      this.m.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Atcn == null)
    {
      this.jdField_a_of_type_Atcn = new atcn(this.app, this, aunq.a().dp(), this);
      this.jdField_a_of_type_Atcn.registerDataSetObserver(this.mDataSetObserver);
      this.mDataSetObserver.onChanged();
    }
    super.setContentView(this.m);
    this.m.setAdapter(this.jdField_a_of_type_Atcn);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131701653);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + aunq.a().brs);
    }
    this.app.cLv();
    if (!aunq.a().brs) {
      ThreadManager.excute(new TimLebaListMgrActivity.1(this), 16, null, true);
    }
  }
  
  public void a(aunr paramaunr)
  {
    aunq.cdv |= 0x1;
    aunq localaunq = aunq.a();
    QQAppInterface localQQAppInterface = this.app;
    long l = paramaunr.c.uiResId;
    if (paramaunr.bo == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaunq.a(localQQAppInterface, l, bool, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    zjq.cdv |= 0x1;
    initUI();
    this.app.addObserver(this.jdField_a_of_type_Ackr, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.m = null;
    if (this.jdField_a_of_type_Atcn != null)
    {
      this.jdField_a_of_type_Atcn.unregisterDataSetObserver(this.mDataSetObserver);
      this.jdField_a_of_type_Atcn = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Ackr);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Atcn.cS(he());
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Atcn != null) {
      this.jdField_a_of_type_Atcn.onPostThemeChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.TimLebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */