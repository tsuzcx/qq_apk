package com.tencent.tim.cloudfile;

import aaja;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atdt;
import atdt.a;
import atip;
import atiq;
import atir;
import atis;
import atit;
import ativ;
import atiz;
import atjx;
import atmg;
import auhk.g;
import auhq;
import auin;
import auin.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.widget.PullRefreshHeader;
import java.util.List;

public class FileShowListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, auhk.g
{
  private View HI;
  private ativ jdField_a_of_type_Ativ;
  private auhq jdField_a_of_type_Auhq;
  private auin jdField_a_of_type_Auin;
  private aaja jdField_b_of_type_Aaja;
  private atdt.a jdField_b_of_type_Atdt$a = new atit(this);
  private atjx jdField_b_of_type_Atjx;
  private PullRefreshHeader jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader;
  protected atdt d;
  private SimpleSlidingIndicator d;
  private boolean dfB = true;
  private boolean dhR;
  private boolean dhS = true;
  private boolean dhv;
  private FPSSwipListView e;
  private int epN;
  private int epO;
  private RelativeLayout fD;
  private View.OnLongClickListener j = new atis(this);
  private ImageView lW;
  private RelativeLayout mRoot;
  private ImageView vq;
  private View xR;
  
  private void IP(boolean paramBoolean)
  {
    if (!aJh())
    {
      this.rightViewText.setVisibility(8);
      this.xR.setVisibility(8);
      aC();
    }
    for (;;)
    {
      etP();
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693507);
      this.xR.setVisibility(0);
      this.lW.setEnabled(false);
      this.vq.setEnabled(false);
    }
  }
  
  private void aC()
  {
    this.centerView.setText(2131691653);
    this.rightViewText.setOnClickListener(new atip(this));
  }
  
  private boolean aJh()
  {
    return (this.dfB) && (this.jdField_a_of_type_Auin.aJs());
  }
  
  private void ckE()
  {
    List localList = this.jdField_a_of_type_Auin.hk();
    QLog.e("waterchen", 1, "thread id:" + Thread.currentThread().getId() + " list size:" + localList.size());
    this.jdField_d_of_type_Atdt.setMode(0);
    this.jdField_d_of_type_Atdt.mx(localList);
    if (this.jdField_a_of_type_Ativ != null)
    {
      if ((localList == null) || (localList.size() == 0)) {
        this.jdField_a_of_type_Ativ.setVisible(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ativ.setVisible(true);
  }
  
  private void etN()
  {
    List localList = this.jdField_a_of_type_Auin.hl();
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this).inflate(2131561005, null);
    this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)localLinearLayout.findViewById(2131378499));
    this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setBackgroundResource(2130851105);
    if ((localList != null) && (localList.size() > 0))
    {
      String[] arrayOfString = new String[localList.size()];
      int[] arrayOfInt = new int[localList.size()];
      int i = 0;
      while (i < localList.size())
      {
        arrayOfString[i] = getString(((auin.a)localList.get(i)).erE);
        arrayOfInt[i] = ((auin.a)localList.get(i)).tabIndex;
        i += 1;
      }
      this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(arrayOfString, arrayOfInt);
      this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(0);
    }
    for (;;)
    {
      this.e.addHeaderView(localLinearLayout);
      return;
      this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
    }
  }
  
  private void etP()
  {
    boolean bool = true;
    if (aJh())
    {
      this.e.setDragEnable(false);
      this.jdField_d_of_type_Atdt.Vq(true);
      if (aJh()) {
        break label60;
      }
    }
    for (;;)
    {
      this.dfB = bool;
      return;
      this.e.setDragEnable(true);
      this.jdField_d_of_type_Atdt.Vq(false);
      atiz.clearSelected();
      break;
      label60:
      bool = false;
    }
  }
  
  private void initBottomBar()
  {
    this.xR = LayoutInflater.from(this).inflate(2131560998, this.mRoot, false);
    this.mRoot.addView(this.xR);
    ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).addRule(2, 2131366191);
    this.xR.setVisibility(8);
    this.lW = ((ImageView)findViewById(2131366197));
    this.vq = ((ImageView)findViewById(2131366194));
    this.lW.setOnClickListener(this);
    this.vq.setOnClickListener(this);
  }
  
  private void initListView()
  {
    this.e = ((FPSSwipListView)findViewById(2131367047));
    this.e.setDivider(null);
    this.e.setDragEnable(true);
    this.e.setOverscrollHeader(getResources().getDrawable(2130851105));
    if (this.jdField_a_of_type_Auin.aJq())
    {
      this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131563195, this.e, false));
      this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.setBackgroundDrawable(getResources().getDrawable(2130851105));
      this.e.setOverScrollHeader(this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader);
    }
    this.jdField_a_of_type_Ativ = new ativ(this, "", this.e, this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader, new atir(this));
    if (this.jdField_a_of_type_Auin.aJr()) {
      this.e.setOnScrollListener(this.jdField_a_of_type_Ativ);
    }
    this.jdField_b_of_type_Aaja = new aaja(this.e, this.mRoot, this.fD, this, null, 50);
    etN();
  }
  
  public boolean Pp()
  {
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Auin.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561047);
    this.epN = getIntent().getIntExtra("", 0);
    aC();
    initContentView();
    initBottomBar();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Auin != null) {
      this.jdField_a_of_type_Auin.destroy();
    }
    if (this.jdField_b_of_type_Atjx != null) {
      this.jdField_b_of_type_Atjx.onDestroy();
    }
    if (this.jdField_d_of_type_Atdt != null) {
      this.jdField_d_of_type_Atdt.onDestroy();
    }
  }
  
  public void etO()
  {
    setTitle(String.format("已选 %d 项", new Object[] { Integer.valueOf(atiz.Ou()) }));
  }
  
  public void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    QLog.e("waterchen", 1, "isSuccess:" + paramBoolean1 + " operationType:" + paramInt + " isComplete:" + paramBoolean2);
    if (paramInt == 3)
    {
      this.jdField_d_of_type_Atdt.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.cG(paramBoolean1, paramBoolean2);
    }
    if (paramInt == 1) {
      this.e.springBackOverScrollHeaderView();
    }
    if (paramInt == 2) {
      this.dhR = false;
    }
    if (!paramBoolean2) {
      this.jdField_d_of_type_Atdt.setMode(0);
    }
    ckE();
  }
  
  public void initContentView()
  {
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.fD = ((RelativeLayout)findViewById(2131377361));
    this.HI = findViewById(2131370942);
    this.HI.setOnClickListener(this);
    this.jdField_b_of_type_Atjx = new atjx(this.app, this, this);
    this.jdField_a_of_type_Auin = this.jdField_b_of_type_Atjx.a(this, this.epN, this);
    this.jdField_a_of_type_Auhq = ((auhq)this.jdField_b_of_type_Atjx.a(4));
    this.dhv = true;
    this.jdField_d_of_type_Atdt = new atmg(this.app, this, this, this.epN);
    initListView();
    this.jdField_d_of_type_Atdt.setMode(3);
    this.jdField_d_of_type_Atdt.setOnClickListener(this.jdField_a_of_type_Auin.x());
    this.jdField_d_of_type_Atdt.setOnLongClickListener(this.j);
    this.jdField_d_of_type_Atdt.a(this.jdField_b_of_type_Atdt$a);
    this.e.setAdapter(this.jdField_d_of_type_Atdt);
    this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(new atiq(this));
    this.jdField_a_of_type_Auin.aaK(0);
  }
  
  public void onClick(View paramView) {}
  
  public void qw(String paramString)
  {
    QQToast.a(this.app.getApp(), 1, paramString, 0).show(getTitleBarHeight());
  }
  
  public void showSuccessToast(String paramString)
  {
    QQToast.a(this.app.getApp(), 2, paramString, 0).show(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.FileShowListActivity
 * JD-Core Version:    0.7.0.1
 */