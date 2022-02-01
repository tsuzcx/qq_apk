package com.tencent.mobileqq.activity.history;

import aghq;
import agkh;
import android.content.Intent;
import anot;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import xtp;
import zfw;

public class ChatHistoryC2CMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private aghq d = new zfw(this);
  
  void cpg()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B5", "0X800A0B5", 1, 0, "", "", "", "");
  }
  
  void cpi()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 1, 0, "", "", "", "");
  }
  
  void cpj()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 1, 0, "", "", "", "");
  }
  
  protected void cpl()
  {
    if ((this.rA != null) && (this.rA.size() > 0) && (this.a != null))
    {
      this.a.bBS();
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 1, 0, "", "", "", "");
    }
  }
  
  void cpm()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 1, 0, "", "", "", "");
  }
  
  void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      xtp.v(this.mActivity, paramIntent);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.d != null) {
      this.mApp.a().deleteObserver(this.d);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.d != null) {
      this.mApp.a().deleteObserver(this.d);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.d != null) {
      this.mApp.a().addObserver(this.d);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment
 * JD-Core Version:    0.7.0.1
 */