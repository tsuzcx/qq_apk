package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.a;
import java.util.Iterator;
import java.util.List;
import vcq;
import vcr;

public class GesturePWDCreateActivity
  extends IphoneTitleBarActivity
{
  public LockPatternView a;
  public String aNs = "";
  public int bHE = 0;
  public TextView jg;
  int[] mData = new int[9];
  public Handler mHandler = new Handler();
  private View tb;
  private View tc;
  private View td;
  private View te;
  private View tf;
  private View tg;
  private View th;
  private View ti;
  private View tj;
  
  private void bPE()
  {
    if (this.mData == null) {
      this.mData = new int[9];
    }
    int i = 0;
    while (i < this.mData.length)
    {
      this.mData[i] = 0;
      i += 1;
    }
  }
  
  private void bPF()
  {
    if ((this.mData != null) && (this.mData.length == 9))
    {
      if (this.mData[0] != 1) {
        break label192;
      }
      this.tb.setBackgroundResource(2130846149);
      if (this.mData[1] != 1) {
        break label204;
      }
      this.tc.setBackgroundResource(2130846149);
      label55:
      if (this.mData[2] != 1) {
        break label216;
      }
      this.td.setBackgroundResource(2130846149);
      label74:
      if (this.mData[3] != 1) {
        break label228;
      }
      this.te.setBackgroundResource(2130846149);
      label93:
      if (this.mData[4] != 1) {
        break label240;
      }
      this.tf.setBackgroundResource(2130846149);
      label112:
      if (this.mData[5] != 1) {
        break label252;
      }
      this.tg.setBackgroundResource(2130846149);
      label131:
      if (this.mData[6] != 1) {
        break label264;
      }
      this.th.setBackgroundResource(2130846149);
      label151:
      if (this.mData[7] != 1) {
        break label276;
      }
      this.ti.setBackgroundResource(2130846149);
    }
    for (;;)
    {
      if (this.mData[8] != 1) {
        break label288;
      }
      this.tj.setBackgroundResource(2130846149);
      return;
      label192:
      this.tb.setBackgroundResource(2130846148);
      break;
      label204:
      this.tc.setBackgroundResource(2130846148);
      break label55;
      label216:
      this.td.setBackgroundResource(2130846148);
      break label74;
      label228:
      this.te.setBackgroundResource(2130846148);
      break label93;
      label240:
      this.tf.setBackgroundResource(2130846148);
      break label112;
      label252:
      this.tg.setBackgroundResource(2130846148);
      break label131;
      label264:
      this.th.setBackgroundResource(2130846148);
      break label151;
      label276:
      this.ti.setBackgroundResource(2130846148);
    }
    label288:
    this.tj.setBackgroundResource(2130846148);
  }
  
  private void initData()
  {
    this.bHE = 0;
    bPE();
  }
  
  private void initUI()
  {
    setTitle(2131694294);
    setLeftButton(2131721058, new vcq(this));
    this.jg = ((TextView)findViewById(2131367973));
    this.a = ((LockPatternView)findViewById(2131367972));
    this.a.setFillInGapCell(false);
    this.a.setTactileFeedbackEnabled(true);
    this.a.setOnPatternListener(new vcr(this));
    if (this.mDensity <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      localLayoutParams.height = ((int)(this.mDensity * 240.0F));
      localLayoutParams.width = ((int)(this.mDensity * 240.0F));
      this.a.setLayoutParams(localLayoutParams);
    }
    this.tb = findViewById(2131367986);
    this.tc = findViewById(2131367987);
    this.td = findViewById(2131367988);
    this.te = findViewById(2131367989);
    this.tf = findViewById(2131367990);
    this.tg = findViewById(2131367991);
    this.th = findViewById(2131367992);
    this.ti = findViewById(2131367993);
    this.tj = findViewById(2131367994);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559404);
    initData();
    initUI();
    return true;
  }
  
  public void fR(List<LockPatternView.a> paramList)
  {
    bPE();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LockPatternView.a locala = (LockPatternView.a)paramList.next();
        if (locala != null)
        {
          int i = locala.getRow();
          i = locala.getColumn() + i * 3;
          if ((i >= 0) && (i < this.mData.length)) {
            this.mData[i] = 1;
          }
        }
      }
    }
    bPF();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 2130772013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */