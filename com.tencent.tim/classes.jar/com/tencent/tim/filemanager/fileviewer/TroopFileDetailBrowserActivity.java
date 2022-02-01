package com.tencent.tim.filemanager.fileviewer;

import agsa;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import apsd;
import apsd.c;
import aqiw;
import atsn;
import atti;
import atxf;
import atyw;
import atyx;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements agsa
{
  public ForwardFileInfo b;
  public apsd.c c;
  protected atsn e = new atyw(this);
  public long troopUin;
  
  private int getNetworkType(Context paramContext)
  {
    if (!aqiw.isNetworkAvailable(paramContext)) {
      return 2;
    }
    if (aqiw.isWifiConnected(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean U(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.e);
    }
    atyx localatyx = new atyx(this.app);
    if (!localatyx.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_Atxf == null)
      {
        this.jdField_a_of_type_Atxf = new atxf(this, this, localatyx.a(this));
        this.jdField_a_of_type_Atxf.a(this.jdField_a_of_type_Atyr);
      }
      if (this.jdField_a_of_type_Atxf.b(a(), new RelativeLayout.LayoutParams(-1, -1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (this.b != null)
    {
      if (localatyx.getType() != 1) {
        break label275;
      }
      anot.a(super.getApp(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.getFriendUin() + "", this.bPd + "", getNetworkType(getApplicationContext()) + "", audx.el(audx.fM(this.b.getFileName())));
    }
    for (;;)
    {
      if (this.b != null) {
        this.troopUin = this.b.getFriendUin();
      }
      return true;
      label275:
      anot.a(super.getApp(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.getFriendUin() + "", this.bPd + "", getNetworkType(getApplicationContext()) + "", audx.el(audx.fM(this.b.getFileName())));
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10099) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false)))
    {
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().deleteObserver(this.e);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.c = new apsd.c(this, this.troopUin, this.app);
    apsd.a(this.app, this.c);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    apsd.b(this.app, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */