package com.tencent.tim.teamworkforgroup;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import aqha;
import aqju;
import auly;
import aulz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class GroupTeamAddLinkDlg
  extends BaseActivity
{
  public long aoW;
  public String cks;
  public int cpk;
  private aqju m;
  public String mTitle;
  public String mTroopName;
  
  private void dUd()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("qqBaseActivity", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  private void e(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    dUd();
    this.m = aqha.a(this, 230);
    this.m.setTitle(getResources().getString(2131689831));
    this.m.setMessage(getResources().getString(2131689828));
    this.m.setNegativeButton(getString(2131689829), new auly(this));
    this.m.setPositiveButton(getString(2131689830), new aulz(this, paramInt, paramString1, paramLong));
    this.m.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.aoW = paramBundle.getLongExtra("key_group_team_work_doc_group_uin", 0L);
    this.cpk = paramBundle.getIntExtra("key_group_team_work_doc_domain_id", 0);
    this.cks = paramBundle.getStringExtra("key_group_team_work_doc_pad_id");
    this.mTitle = paramBundle.getStringExtra("key_team_work_title");
    this.mTroopName = paramBundle.getStringExtra("troop_name");
    e(this.aoW, this.cpk, this.cks, this.mTroopName);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamworkforgroup.GroupTeamAddLinkDlg
 * JD-Core Version:    0.7.0.1
 */