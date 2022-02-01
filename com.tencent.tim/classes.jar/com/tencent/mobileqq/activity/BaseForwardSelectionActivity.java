package com.tencent.mobileqq.activity;

import ahgg.a;
import ahgq;
import ahix;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import anot;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class BaseForwardSelectionActivity
  extends FragmentActivity
{
  public ahgq a;
  public boolean aTj;
  public boolean aTk;
  protected Bundle extra;
  
  private void bJo()
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    Object localObject = new Bundle(this.extra);
    ((Bundle)localObject).putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Bundle)localObject).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    PhotoUtils.a(this, localIntent, localArrayList, 0, false);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 20001: 
      setResult(-1, paramIntent);
      finish();
      return;
    }
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.aTk = getIntent().getBooleanExtra("call_by_forward", false);
      if (this.aTk)
      {
        this.a = ahix.a(paramBundle, this.app, this);
        this.extra = this.a.getExtras();
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BaseForwardSelectionActivity", 2, "BaseForwardSelectionActivity onNewIntent()");
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {}
    }
    else
    {
      return;
    }
    paramIntent = (String)paramIntent.get(0);
    this.extra.putBoolean("FORWARD_IS_EDITED", true);
    int i = this.extra.getInt("key_forward_ability_type", 0);
    if ((i == ahgg.a.W.intValue()) || (i == ahgg.a.ab.intValue()))
    {
      this.a.Pa(i);
      return;
    }
    this.extra.putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    bJo();
    anot.a(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772000, 2130772001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseForwardSelectionActivity
 * JD-Core Version:    0.7.0.1
 */