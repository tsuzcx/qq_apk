package com.tencent.tim.filemanager.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import aqha;
import aqju;
import atph;
import atpi;
import atpj;
import atpk;
import atpl;
import atpm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppActivity;

public class WpsFileEditSaveDlgActivity
  extends AppActivity
{
  private aqju bc;
  private aqju bd;
  private int busType;
  private boolean diA;
  private long sessionid;
  
  private void eo(int paramInt, String paramString)
  {
    if (this.bd != null) {
      return;
    }
    this.bd = aqha.a(this, 230, getResources().getString(2131693884), paramString, 2131693887, 2131693904, new atpk(this, paramInt), new atpl(this, paramInt));
    this.bd.setOnDismissListener(new atpm(this));
    this.bd.setCancelable(false);
    this.bd.show();
  }
  
  private void eus()
  {
    if (this.bc != null) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      this.bc = aqha.a(this, 230, getString(2131693902), getString(2131693894), 2131693891, 2131693890, new atph(this, (QQAppInterface)localObject), new atpi(this, (QQAppInterface)localObject));
      this.bc.setOnDismissListener(new atpj(this));
      this.bc.setCancelable(false);
      this.bc.show();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setTitle(null);
    paramBundle = getIntent();
    this.sessionid = paramBundle.getLongExtra("sessionid", 0L);
    this.diA = paramBundle.getBooleanExtra("fileChanged", false);
    this.busType = paramBundle.getIntExtra("busType", 0);
    eus();
    return true;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity
 * JD-Core Version:    0.7.0.1
 */