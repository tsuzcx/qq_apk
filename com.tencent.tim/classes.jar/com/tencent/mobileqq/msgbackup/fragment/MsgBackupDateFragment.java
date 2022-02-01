package com.tencent.mobileqq.msgbackup.fragment;

import acfp;
import ajff;
import ajfg;
import ajfh;
import ajfi;
import ajfj;
import ajfk;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ausj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class MsgBackupDateFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private TextView UM;
  private TextView UN;
  RadioGroup.OnCheckedChangeListener b = new ajfh(this);
  private int bDR;
  private int bDS;
  private int bDT;
  private String bQZ;
  private String bRa;
  RadioGroup.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new ajfi(this);
  private IphonePickerView jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private boolean cnY;
  private boolean cnZ;
  private boolean coa;
  private int diC;
  private int diD;
  private int diE;
  private int diF;
  private int diG;
  private int diH;
  private int diI;
  private int diJ;
  private int diK;
  private int diL;
  private int diM;
  private int diN;
  private int diO = 1;
  private Calendar e;
  private long endTime;
  private Calendar f;
  View.OnClickListener fq = new ajff(this);
  View.OnClickListener fr = new ajfg(this);
  private int from;
  private LinearLayout jo;
  private RelativeLayout kS;
  private RelativeLayout kT;
  private RadioGroup l;
  private RadioGroup m;
  private ausj mActionSheet;
  private int mCurrentYear;
  private int mFrom;
  private long startTime;
  private int yE;
  private int yF;
  
  private void QG(int paramInt)
  {
    Calendar localCalendar;
    if (paramInt == 1)
    {
      this.bQZ = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.diL), Integer.valueOf(this.diM), Integer.valueOf(this.diN) });
      this.cnZ = true;
      this.UM.setText(this.bQZ);
      q(this.UM, this.bQZ);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.diL, this.diM - 1, this.diN, 0, 0, 0);
      this.startTime = (localCalendar.getTimeInMillis() / 1000L);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 2);
      this.bRa = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.diL), Integer.valueOf(this.diM), Integer.valueOf(this.diN) });
      this.UN.setText(this.bRa);
      q(this.UN, this.bRa);
      this.coa = true;
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.diL, this.diM - 1, this.diN, 23, 59, 59);
      this.endTime = (localCalendar.getTimeInMillis() / 1000L);
    } while ((!this.cnZ) || (!this.coa));
    setRightButtonEnable(true);
  }
  
  private void QH(int paramInt)
  {
    Calendar localCalendar1;
    label115:
    Calendar localCalendar2;
    if (paramInt == 1)
    {
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.bDR + this.diC);
      localCalendar1.set(2, this.diD);
      localCalendar1.set(5, this.diE + 1);
      if (localCalendar1.before(this.f))
      {
        this.diC = 0;
        this.diD = (this.bDS - 1);
        this.diE = (this.bDT - 1);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diC);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diD);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diE);
        break label216;
        if (this.coa)
        {
          localCalendar2 = Calendar.getInstance();
          localCalendar2.setTimeInMillis(this.endTime * 1000L);
          if (localCalendar1.after(localCalendar2))
          {
            this.diC = (localCalendar2.get(1) - this.bDR);
            this.diD = localCalendar2.get(2);
            this.diE = (localCalendar2.get(5) - 1);
            this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diC);
            this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diD);
            this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diE);
          }
        }
      }
    }
    label591:
    for (;;)
    {
      label216:
      return;
      if (!localCalendar1.after(this.e)) {
        break label115;
      }
      this.diC = (this.mCurrentYear - this.bDR);
      this.diD = (this.yE - 1);
      this.diE = (this.yF - 1);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diC);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diD);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diE);
      break label115;
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.bDR + this.diF);
      localCalendar1.set(2, this.diG);
      localCalendar1.set(5, this.diH + 1);
      if (localCalendar1.before(this.f))
      {
        this.diF = 0;
        this.diG = (this.bDS - 1);
        this.diH = (this.bDT - 1);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diF);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diG);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diH);
      }
      for (;;)
      {
        if (paramInt != 2) {
          break label591;
        }
        localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.startTime * 1000L);
        if (!localCalendar1.before(localCalendar2)) {
          break;
        }
        this.diF = (localCalendar2.get(1) - this.bDR);
        this.diG = localCalendar2.get(2);
        this.diH = (localCalendar2.get(5) - 1);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diF);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diG);
        this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diH);
        return;
        if (localCalendar1.after(this.e))
        {
          this.diF = (this.mCurrentYear - this.bDR);
          this.diG = (this.yE - 1);
          this.diH = (this.yF - 1);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diF);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diG);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diH);
        }
      }
    }
  }
  
  private void aZv()
  {
    if ((this.startTime != 0L) && (this.endTime != 0L))
    {
      ((RadioButton)this.l.findViewById(2131365603)).setChecked(true);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.startTime * 1000L);
      this.bQZ = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.UM.setText(this.bQZ);
      q(this.UM, this.bQZ);
      localCalendar.setTimeInMillis(this.endTime * 1000L);
      this.bRa = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.UN.setText(this.bRa);
      q(this.UN, this.bRa);
      setRightButtonEnable(true);
      if (this.diO != 1) {
        break label248;
      }
      this.m.check(2131365380);
    }
    label248:
    while (this.diO != 2)
    {
      return;
      ((RadioButton)this.l.findViewById(2131365602)).setChecked(true);
      break;
    }
    this.m.check(2131365381);
  }
  
  private void bFP()
  {
    if (this.from == 1)
    {
      this.diL = (this.bDR + this.diC);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.diL, this.diD, this.diE + 1);
      this.diL = localCalendar.get(1);
      this.diM = (localCalendar.get(2) + 1);
      this.diN = localCalendar.get(5);
      return;
    }
    this.diL = (this.bDR + this.diF);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.diL, this.diG, this.diH + 1);
    this.diL = localCalendar.get(1);
    this.diM = (localCalendar.get(2) + 1);
    this.diN = localCalendar.get(5);
  }
  
  private void bFQ()
  {
    if (this.mActionSheet != null) {
      this.mActionSheet.dismiss();
    }
    Object localObject;
    if (this.mActionSheet == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getActivity().getLayoutInflater().inflate(2131561390, null));
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new a(null));
      this.mActionSheet = ausj.d(getActivity());
      this.mActionSheet.setCloseAutoRead(true);
      this.mActionSheet.setActionContentView(this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.mActionSheet.findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject).cZW = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.mActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new ajfj(this));
    }
    if (this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
    {
      localObject = (TextView)this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131377935);
      Button localButton = (Button)this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131379692);
      ((Button)this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131379693)).setText(acfp.m(2131708494));
      localButton.setVisibility(0);
      localButton.setOnClickListener(new ajfk(this));
      if (this.from == 1)
      {
        ((TextView)localObject).setText(acfp.m(2131708482));
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
    }
    else if ((!this.mActionSheet.isShowing()) && (this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null))
    {
      if (this.from != 1) {
        break label414;
      }
      if (!this.cnZ) {
        break label375;
      }
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diC);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diD);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diE);
    }
    for (;;)
    {
      label375:
      try
      {
        this.mActionSheet.show();
        return;
      }
      catch (Exception localException) {}
      if (this.from != 2) {
        break;
      }
      ((TextView)localObject).setText(acfp.m(2131708483));
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      break;
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diI);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diJ);
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diK);
      continue;
      label414:
      if (this.from == 2) {
        if (this.coa)
        {
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diF);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diG);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diH);
        }
        else
        {
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.diI);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.diJ);
          this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.diK);
        }
      }
    }
  }
  
  private void dwU()
  {
    setTitle(getActivity().getString(2131690719));
    setRightButton(2131690717, this.fq);
    setLeftButton(2131690716, this.fr);
  }
  
  private void dwV()
  {
    if (this.from == 1)
    {
      this.diC = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.ha(0);
      this.diD = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.ha(1);
      this.diE = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.ha(2);
    }
    while (this.from != 2) {
      return;
    }
    this.diF = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.ha(0);
    this.diG = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.ha(1);
    this.diH = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.ha(2);
  }
  
  private void initData()
  {
    this.startTime = 0L;
    this.endTime = 0L;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject != null)
      {
        this.startTime = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        this.endTime = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        this.diO = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.mFrom = ((Intent)localObject).getIntExtra("backup_select_from", 0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "startTime = " + this.startTime + ", endTime = " + this.endTime + ", mCurContentType = " + this.diO);
    }
    this.e = Calendar.getInstance();
    this.e.setTimeInMillis(System.currentTimeMillis());
    this.mCurrentYear = this.e.get(1);
    this.yE = (this.e.get(2) + 1);
    this.yF = this.e.get(5);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    this.diL = ((Calendar)localObject).get(1);
    this.diM = (((Calendar)localObject).get(2) + 1);
    this.diN = ((Calendar)localObject).get(5);
    this.f = Calendar.getInstance();
    this.f.setTimeInMillis(System.currentTimeMillis());
    this.f.add(1, -30);
    this.f.add(5, 1);
    this.bDR = this.f.get(1);
    this.bDS = (this.f.get(2) + 1);
    this.bDT = this.f.get(5);
    this.diC = (this.mCurrentYear - this.bDR);
    this.diD = (this.yE - 1);
    this.diE = (this.yF - 1);
    this.diI = this.diC;
    this.diJ = this.diD;
    this.diK = this.diE;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, String.format("initData date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.bDR), Integer.valueOf(this.bDS), Integer.valueOf(this.bDT), Integer.valueOf(this.mCurrentYear), Integer.valueOf(this.yE), Integer.valueOf(this.yF) }));
    }
  }
  
  private void initUI()
  {
    this.l = ((RadioGroup)this.mContentView.findViewById(2131363249));
    this.l.setOnCheckedChangeListener(this.b);
    this.m = ((RadioGroup)this.mContentView.findViewById(2131363246));
    this.m.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    this.jo = ((LinearLayout)this.mContentView.findViewById(2131365613));
    this.kS = ((RelativeLayout)this.mContentView.findViewById(2131363247));
    this.kS.setOnClickListener(this);
    this.UM = ((TextView)this.mContentView.findViewById(2131365606));
    this.kT = ((RelativeLayout)this.mContentView.findViewById(2131363248));
    this.kT.setOnClickListener(this);
    this.UN = ((TextView)this.mContentView.findViewById(2131365607));
  }
  
  private void q(View paramView, String paramString)
  {
    if (AppSetting.enableTalkBack) {
      paramView.setContentDescription(paramString);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    dwU();
    initUI();
    initData();
    aZv();
  }
  
  public void finish()
  {
    if (getActivity() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "date fragment finish called! before is correct date time-------> startTime = " + this.startTime + ", endtime = " + this.endTime + ", contentType = " + this.diO);
      }
      if (this.startTime >= this.endTime) {
        this.startTime = this.endTime;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "date fragment finish called! after is correct date time-------> startTime = " + this.startTime + ", endtime = " + this.endTime + ", contentType = " + this.diO);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("session_start_time", this.startTime);
      localIntent.putExtra("session_end_time", this.endTime);
      localIntent.putExtra("session_start_time_str", this.bQZ);
      localIntent.putExtra("session_end_time_str", this.bRa);
      localIntent.putExtra("session_content_type", this.diO);
      getActivity().setResult(0, localIntent);
      getActivity().finish();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561665;
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
      this.from = 1;
      bFQ();
      continue;
      if ((this.cnZ) || ((this.startTime != 0L) && (this.bQZ != null)))
      {
        this.from = 2;
        bFQ();
      }
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
        return MsgBackupDateFragment.d(MsgBackupDateFragment.this) + paramInt2 + acfp.m(2131708498);
      case 1: 
        return paramInt2 + 1 + acfp.m(2131708481);
      }
      return paramInt2 + 1 + acfp.m(2131708497);
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
        return MsgBackupDateFragment.c(MsgBackupDateFragment.this) - MsgBackupDateFragment.d(MsgBackupDateFragment.this) + 1;
      case 1: 
        return 12;
      }
      Calendar localCalendar = Calendar.getInstance();
      if (MsgBackupDateFragment.b(MsgBackupDateFragment.this) == 1)
      {
        localCalendar.set(1, MsgBackupDateFragment.e(MsgBackupDateFragment.this) + MsgBackupDateFragment.d(MsgBackupDateFragment.this));
        localCalendar.set(2, MsgBackupDateFragment.f(MsgBackupDateFragment.this));
        localCalendar.set(5, 1);
      }
      for (;;)
      {
        return localCalendar.getActualMaximum(5);
        localCalendar.set(1, MsgBackupDateFragment.g(MsgBackupDateFragment.this) + MsgBackupDateFragment.d(MsgBackupDateFragment.this));
        localCalendar.set(2, MsgBackupDateFragment.h(MsgBackupDateFragment.this));
        localCalendar.set(5, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment
 * JD-Core Version:    0.7.0.1
 */