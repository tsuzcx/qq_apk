package com.tencent.mobileqq.filemanager.fileviewer;

import aghq;
import agkh;
import agqi;
import agsa;
import agsh;
import agsi;
import ahav;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements agsa
{
  public ForwardFileInfo b;
  protected aghq c = new agsh(this);
  
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
      this.app.a().addObserver(this.c);
    }
    agsi localagsi = new agsi(this.app);
    if (!localagsi.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_Agqi == null)
      {
        this.jdField_a_of_type_Agqi = new agqi(this, this, localagsi.a(this));
        this.jdField_a_of_type_Agqi.a(this.jdField_a_of_type_Agsb);
      }
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Agqi.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (localagsi.getType() == 1) {
      anot.a(super.getApp(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.getFriendUin() + "", this.bPd + "", getNetworkType(getApplicationContext()) + "", ahav.el(ahav.getFileType(this.b.getFileName())));
    }
    for (;;)
    {
      return true;
      anot.a(super.getApp(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.getFriendUin() + "", this.bPd + "", getNetworkType(getApplicationContext()) + "", ahav.el(ahav.getFileType(this.b.getFileName())));
    }
  }
  
  public boolean bY()
  {
    if ((getIntent() != null) && (getIntent().getIntExtra("from_type_troop", -1) == 3)) {
      return true;
    }
    return super.bY();
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
    this.app.a().deleteObserver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */