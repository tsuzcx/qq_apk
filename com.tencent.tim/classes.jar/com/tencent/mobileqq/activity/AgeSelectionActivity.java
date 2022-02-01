package com.tencent.mobileqq.activity;

import acfp;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import aqek;
import aqft;
import ausj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import ufl;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView BX;
  private TextView BY;
  private String aKR;
  private int bDR;
  private int bDS;
  private int bDT;
  private IphonePickerView c;
  private Calendar e;
  private Calendar f;
  private ausj mActionSheet;
  private int mAge;
  private int mCurrentYear;
  private int yE;
  private int yF;
  private int yG;
  private int yH;
  private int yI;
  
  public static int bB(String paramString)
  {
    return Arrays.asList(aqek.hK).indexOf(paramString);
  }
  
  private void bFP()
  {
    this.mAge = (this.mCurrentYear - (this.bDR + this.yG));
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, this.yH + 1, this.yI + 1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, this.yE, this.yF);
    if (localCalendar1.after(localCalendar2)) {
      this.mAge -= 1;
    }
    if (this.mAge < 0) {
      this.mAge = 0;
    }
    this.BX.setText(this.mAge + acfp.m(2131702181));
    this.aKR = aqft.U(this.yH + 1, this.yI + 1);
    this.BY.setText(this.aKR);
  }
  
  private void bFQ()
  {
    if (this.mActionSheet == null)
    {
      this.c = ((IphonePickerView)getLayoutInflater().inflate(2131561390, null));
      this.c.a(new a(null));
      this.mActionSheet = ausj.d(this);
      this.mActionSheet.setCloseAutoRead(true);
      this.mActionSheet.setActionContentView(this.c, null);
      Object localObject = (DispatchActionMoveScrollView)this.mActionSheet.findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject).cZW = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.mActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.c.setPickListener(new ufl(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.c.setSelection(0, this.yG);
      this.c.setSelection(1, this.yH);
      this.c.setSelection(2, this.yI);
    }
    try
    {
      this.mActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void bFR()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.bDR + this.yG);
    localCalendar.set(2, this.yH);
    localCalendar.set(5, this.yI + 1);
    if (localCalendar.before(this.f))
    {
      this.yG = 0;
      this.yH = (this.bDS - 1);
      this.yI = (this.bDT - 1);
      this.c.setSelection(0, this.yG);
      this.c.setSelection(1, this.yH);
      this.c.setSelection(2, this.yI);
    }
    while (!localCalendar.after(this.e)) {
      return;
    }
    this.yG = (this.mCurrentYear - this.bDR);
    this.yH = (this.yE - 1);
    this.yI = (this.yF - 1);
    this.c.setSelection(0, this.yG);
    this.c.setSelection(1, this.yH);
    this.c.setSelection(2, this.yI);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561179);
    this.BX = ((TextView)findViewById(2131362333));
    this.BY = ((TextView)findViewById(2131365236));
    findViewById(2131362337).setOnClickListener(this);
    findViewById(2131365237).setOnClickListener(this);
    setTitle(acfp.m(2131702178));
    setLeftViewName(2131690700);
    this.e = Calendar.getInstance();
    this.e.setTimeInMillis(System.currentTimeMillis());
    this.mCurrentYear = this.e.get(1);
    this.yE = (this.e.get(2) + 1);
    this.yF = this.e.get(5);
    this.f = Calendar.getInstance();
    this.f.setTimeInMillis(System.currentTimeMillis());
    this.f.add(1, -120);
    this.f.add(5, 1);
    this.bDR = this.f.get(1);
    this.bDS = (this.f.get(2) + 1);
    this.bDT = this.f.get(5);
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("doOnCreate date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.bDR), Integer.valueOf(this.bDS), Integer.valueOf(this.bDT), Integer.valueOf(this.mCurrentYear), Integer.valueOf(this.yE), Integer.valueOf(this.yF) }));
    }
    int i = getIntent().getIntExtra("param_birthday", 0);
    if (i == 0)
    {
      this.yG = (1990 - this.bDR);
      this.yH = 0;
    }
    for (this.yI = 0;; this.yI = ((i & 0xFF) - 1))
    {
      bFP();
      bFQ();
      return true;
      this.yG = (((0xFFFF0000 & i) >>> 16) - this.bDR);
      this.yH = (((0xFF00 & i) >>> 8) - 1);
    }
  }
  
  public boolean onBackEvent()
  {
    this.yG = this.c.ha(0);
    this.yH = this.c.ha(1);
    this.yI = this.c.ha(2);
    bFP();
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.mAge);
    localIntent.putExtra("param_constellation_id", bB(this.aKR));
    localIntent.putExtra("param_constellation", this.aKR);
    localIntent.putExtra("param_year", (short)(this.yG + this.bDR));
    localIntent.putExtra("param_month", (byte)(this.yH + 1));
    localIntent.putExtra("param_day", (byte)(this.yI + 1));
    setResult(-1, localIntent);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bFQ();
    }
  }
  
  class a
    implements IphonePickerView.d
  {
    private a() {}
    
    public String d(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return "";
      case 0: 
        return AgeSelectionActivity.b(AgeSelectionActivity.this) + paramInt2 + acfp.m(2131702182);
      case 1: 
        return paramInt2 + 1 + acfp.m(2131702179);
      }
      return paramInt2 + 1 + acfp.m(2131702180);
    }
    
    public int getColumnCount()
    {
      return 3;
    }
    
    public int t(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return AgeSelectionActivity.a(AgeSelectionActivity.this) - AgeSelectionActivity.b(AgeSelectionActivity.this) + 1;
      case 1: 
        return 12;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(1, AgeSelectionActivity.c(AgeSelectionActivity.this) + AgeSelectionActivity.b(AgeSelectionActivity.this));
      localCalendar.set(2, AgeSelectionActivity.d(AgeSelectionActivity.this));
      localCalendar.set(5, 1);
      return localCalendar.getActualMaximum(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */