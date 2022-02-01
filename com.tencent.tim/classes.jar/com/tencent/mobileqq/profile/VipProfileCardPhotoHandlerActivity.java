package com.tencent.mobileqq.profile;

import aldr;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import aqep;
import aqhu;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;

public class VipProfileCardPhotoHandlerActivity
  extends BaseActivity
{
  public static boolean cwm;
  private Uri L;
  private boolean cwn;
  private boolean cwo;
  
  private void Wv()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.a(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), aqep.aJ(this), aqep.aI(this), aqep.aJ(this), aqep.aI(this), aqep.BT());
  }
  
  private void dFl()
  {
    if (Build.VERSION.SDK_INT > 23)
    {
      if (checkSelfPermission("android.permission.CAMERA") != 0)
      {
        requestPermissions(new aldr(this), 1, new String[] { "android.permission.CAMERA" });
        return;
      }
      this.L = ProfileActivity.a(this, 5);
      return;
    }
    this.L = ProfileActivity.a(this, 5);
  }
  
  protected void NZ(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (cwm)
      {
        localIntent = new Intent(this, VipProfileCardDiyActivity.class);
        localIntent.putExtra("extra_from", 3);
        localIntent.putExtra("extra_card_id", 0L);
        localIntent.putExtra("extra_card_path", paramString);
        startActivity(localIntent);
      }
    }
    else {
      return;
    }
    Intent localIntent = new Intent(this, VipProfileCardPreviewActivity.class);
    localIntent.putExtra("custom_card_background", paramString);
    startActivity(localIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 5) && (paramInt2 == -1))
    {
      this.cwo = true;
      h(this.L);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getStringExtra("action"))))
    {
      if (!paramBundle.getStringExtra("action").equals("select_photo")) {
        break label47;
      }
      Wv();
    }
    for (;;)
    {
      return true;
      label47:
      if (paramBundle.getStringExtra("action").equals("take_photo")) {
        dFl();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    NZ(paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
    finish();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.cwn = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.cwn)
    {
      if (!this.cwo) {
        finish();
      }
    }
    else {
      return;
    }
    this.cwo = false;
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.cwn = true;
  }
  
  protected void h(Uri paramUri)
  {
    paramUri = aqhu.getRealPathFromContentURI(this, paramUri);
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.a(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), aqep.aJ(this), aqep.aI(this), aqep.aJ(this), aqep.aI(this), paramUri, aqep.BT());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity
 * JD-Core Version:    0.7.0.1
 */