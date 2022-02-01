package com.tencent.tim.cloudfile;

import anaz;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import atdt;
import atdt.a;
import atia;
import atib;
import atic;
import atid;
import atmj;
import atsn;
import atso;
import atti;
import augx;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;

public class CloudFileWeiYunActvitiy
  extends IphoneTitleBarActivity
  implements View.OnClickListener, augx
{
  private View HI;
  private TabBarView a;
  private atdt.a jdField_b_of_type_Atdt$a = new atic(this);
  private atsn jdField_b_of_type_Atsn = new atid(this);
  private atdt c;
  private int cWx = -1;
  private LinearLayout dA;
  private boolean dhC;
  private FPSSwipListView e;
  private RelativeLayout fD;
  private ImageView fg;
  private ImageView lW;
  private RelativeLayout mRoot;
  private ImageView vq;
  
  private void YM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.app.a().f(paramString, 0, 15, anaz.gQ());
  }
  
  private void aC()
  {
    setLeftViewName(2131691665);
    this.centerView.setText("微云文件");
    if (akK())
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(getString(2131693507));
    }
    for (;;)
    {
      this.rightViewText.setOnClickListener(new atib(this));
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693524);
    }
  }
  
  private void etH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileWeiYunActvitiy", 2, "initSendRecvTabView");
    }
    this.a = new TabBarView(this);
    this.a.setUnselectColor(getResources().getColor(2131165692));
    this.a.a(0, getString(2131693846));
    this.a.a(1, getString(2131693850));
    this.a.a(2, getString(2131693853));
    this.a.a(3, getString(2131693848));
    this.a.a(4, getString(2131693849));
    this.a.setVisibility(0);
  }
  
  private void initBottomBar()
  {
    this.dA = ((LinearLayout)findViewById(2131366191));
    this.fg = ((ImageView)findViewById(2131366195));
    this.lW = ((ImageView)findViewById(2131366197));
    this.vq = ((ImageView)findViewById(2131366194));
    this.fg.setOnClickListener(this);
    this.lW.setOnClickListener(this);
    this.vq.setOnClickListener(this);
  }
  
  private void initContentView()
  {
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.fD = ((RelativeLayout)findViewById(2131377361));
    this.HI = findViewById(2131370942);
    this.HI.setOnClickListener(this);
    this.c = new atmj(this.app, this, this);
    this.c.a(this.jdField_b_of_type_Atdt$a);
    initListView();
    this.c.setMode(3);
    this.e.setAdapter(this.c);
    this.a.setOnTabChangeListener(new atia(this));
    if ((this.cWx >= 0) && (this.cWx <= 4))
    {
      this.a.setSelectedTab(this.cWx, true);
      return;
    }
    this.a.setSelectedTab(0, true);
  }
  
  private void initListView()
  {
    this.e = ((FPSSwipListView)findViewById(2131367047));
    this.e.setDivider(null);
    this.e.setDragEnable(false);
    etH();
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.a);
    this.e.addHeaderView(localLinearLayout);
  }
  
  public void IP(boolean paramBoolean)
  {
    this.dhC = paramBoolean;
    if (!paramBoolean)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693524);
      this.dA.setVisibility(8);
    }
    for (;;)
    {
      etu();
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693507);
      this.dA.setVisibility(0);
      this.fg.setEnabled(false);
      this.lW.setEnabled(false);
      this.vq.setEnabled(false);
    }
  }
  
  public boolean Pp()
  {
    return false;
  }
  
  public boolean akK()
  {
    return this.dhC;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561028);
    this.app.a().addObserver(this.jdField_b_of_type_Atsn);
    aC();
    initContentView();
    initBottomBar();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.a().deleteObserver(this.jdField_b_of_type_Atsn);
    super.doOnDestroy();
  }
  
  public void etu()
  {
    if (akK())
    {
      this.c.Vq(true);
      return;
    }
    this.c.Vq(false);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileWeiYunActvitiy
 * JD-Core Version:    0.7.0.1
 */