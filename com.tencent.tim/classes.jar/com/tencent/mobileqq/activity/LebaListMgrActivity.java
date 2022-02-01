package com.tencent.mobileqq.activity;

import abes;
import abes.a;
import abes.b;
import acgu;
import ackr;
import aevs;
import aklk;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import anot;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import jsp;
import vfr;
import vfs;
import vft;
import zjq;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements abes.a, abes.b, AdapterView.c
{
  private TextView DZ;
  private abes a;
  protected ackr a;
  private boolean aXV = true;
  char b;
  private aklk d = new vfs(this);
  private XListView m;
  private DataSetObserver mDataSetObserver = new vfr(this);
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_Ackr = new vft(this);
  }
  
  private void Ad()
  {
    if (this.m == null)
    {
      this.m = ((XListView)View.inflate(this, 2131561404, null));
      this.m.setDivider(null);
      this.m.setVerticalScrollBarEnabled(false);
      this.m.setOnItemClickListener(this);
      View localView = View.inflate(this, 2131561402, null);
      this.DZ = ((TextView)localView.findViewById(2131379769));
      this.DZ.setText(2131695247);
      this.m.addHeaderView(localView, null, false);
    }
    if (this.jdField_a_of_type_Abes == null)
    {
      this.jdField_a_of_type_Abes = new abes(this.app, this, zjq.a().dp(), this, this);
      this.jdField_a_of_type_Abes.registerDataSetObserver(this.mDataSetObserver);
      this.mDataSetObserver.onChanged();
    }
    super.setContentView(this.m);
    this.m.setAdapter(this.jdField_a_of_type_Abes);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131695246);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + zjq.a().brs);
    }
    this.app.cLv();
    this.jdField_a_of_type_Abes.Dx(this.app.a().aav());
    if (!zjq.a().brs) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public boolean a(aevs paramaevs)
  {
    return (paramaevs != null) && (paramaevs.a != null);
  }
  
  public void c(aevs paramaevs) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    zjq.cdv |= 0x1;
    this.b = this.app.a().hT().charAt(2);
    Ad();
    this.app.registObserver(this.d);
    this.app.addObserver(this.jdField_a_of_type_Ackr, true);
    anot.a(this.app, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.m = null;
    if (this.jdField_a_of_type_Abes != null)
    {
      this.jdField_a_of_type_Abes.unregisterDataSetObserver(this.mDataSetObserver);
      this.jdField_a_of_type_Abes = null;
    }
    this.app.unRegistObserver(this.d);
    this.app.removeObserver(this.jdField_a_of_type_Ackr);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
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
    this.jdField_a_of_type_Abes.cS(zjq.a().dp());
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_Abes != null) {
      this.jdField_a_of_type_Abes.onPostThemeChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */