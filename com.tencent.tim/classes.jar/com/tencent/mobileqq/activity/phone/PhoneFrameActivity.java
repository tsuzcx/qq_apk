package com.tencent.mobileqq.activity.phone;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import wja;
import zqw;
import zqx;

public class PhoneFrameActivity
  extends IphoneTitleBarActivity
{
  public TextView MY;
  public PhoneFrame a = null;
  Bundle extra;
  private int reqType = 0;
  public View rootView;
  public ImageView vA;
  public View yg;
  
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
    localIntent.putExtra("uin", getIntent().getStringExtra("uin"));
    localIntent.putExtra("uinname", getIntent().getStringExtra("uinname"));
    localIntent.putExtra("uintype", getIntent().getIntExtra("uintype", 0));
    localIntent.putExtra("troop_uin", getIntent().getStringExtra("uin"));
    localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    PhotoUtils.a(this, localIntent, localArrayList, 0, false);
  }
  
  private void initViews()
  {
    this.yg = findViewById(2131377361);
    this.rootView = ((View)this.yg.getParent());
    this.MY = ((TextView)this.yg.findViewById(2131369579));
    this.leftView = ((TextView)this.yg.findViewById(2131369581));
    this.rightViewText = ((TextView)this.yg.findViewById(2131369612));
    this.rightViewText.setText(2131696840);
    this.rightViewText.setOnClickListener(new zqw(this));
    this.vA = ((ImageView)this.yg.findViewById(2131369594));
    if (AppSetting.enableTalkBack) {
      this.vA.setContentDescription(acfp.m(2131709504));
    }
    IphoneTitleBarActivity.setLayerType(this.yg);
    IphoneTitleBarActivity.setLayerType(this.MY);
    IphoneTitleBarActivity.setLayerType(this.leftView);
    IphoneTitleBarActivity.setLayerType(this.rightViewText);
    IphoneTitleBarActivity.setLayerType(this.vA);
    this.a = ((PhoneFrame)findViewById(2131373047));
    this.a.setActivity(this);
    this.a.setPhoneContext(new zqx(this));
    this.a.onCreate(null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req_type", this.reqType);
    this.a.be(localBundle);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20001)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
      return;
    }
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2131559747);
    this.reqType = getIntent().getIntExtra("key_req_type", 0);
    initViews();
    this.extra = getIntent().getExtras();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.a.onStop();
    this.a.onDestroy();
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
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
    this.extra.putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    this.extra.putBoolean("FORWARD_IS_EDITED", true);
    bJo();
    anot.a(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  public void doOnPause()
  {
    this.a.onPause();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.onResume();
  }
  
  public void finish()
  {
    if ((this.app.isLogin()) && (this.reqType == 0))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.bIm);
      startActivity(localIntent);
    }
    super.finish();
    overridePendingTransition(2130772000, 2130772001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity
 * JD-Core Version:    0.7.0.1
 */