package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import wja;
import zer;
import zfy;
import zgh;
import zgp;
import zgq;
import zix;

public class ChatHistoryActivity
  extends FragmentActivity
{
  zer a;
  boolean bqU;
  boolean bqV;
  public boolean bqW;
  int mFromType;
  
  private zer a()
  {
    if ((this.bqU) || (this.bqW)) {
      return new zgp(this);
    }
    if (this.mFromType == 3011) {
      return new zfy(this);
    }
    if (this.mFromType == 3012) {
      return new zix(this);
    }
    if (this.mFromType == 3013) {
      return new zgq(this);
    }
    if (this.mFromType == 3014) {
      return new zgh(this);
    }
    return null;
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3011);
    localIntent.putExtra("SissionUin", paramString1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("FromType", 3014);
    localIntent.putExtra("msg_revoke_uniseq", paramLong);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3013);
    localIntent.putExtra("SissionUin", paramString1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("need_jump_to_msg", true);
    localIntent.putExtra("searched_time", paramLong1);
    localIntent.putExtra("target_shmsgseq", paramLong2);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle)
  {
    paramBundle.putInt("FromChatHistoryTab", ai(paramContext));
    return ai(paramContext) != 0;
  }
  
  private void aDZ()
  {
    this.mFromType = getIntent().getIntExtra("FromType", 3011);
    this.bqU = getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.bqV = getIntent().getBooleanExtra("need_jump_to_msg", false);
    this.bqW = getIntent().getBooleanExtra("FromTroopAlbum", false);
  }
  
  public static int ai(Context paramContext)
  {
    int j = 0;
    int i;
    if ((paramContext instanceof ChatHistoryActivity))
    {
      i = ((ChatHistoryActivity)paramContext).ye();
      if (((ChatHistoryActivity)paramContext).mFromType == 3013) {
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.ChatHistoryActivity", 2, "getTagType, result = " + i);
      }
      return i;
      if ((i == 2131364486) || (i == 2131364479))
      {
        i = 1;
      }
      else if ((i == 2131364484) || (i == 2131364491))
      {
        i = 2;
      }
      else if ((i == 2131364488) || (i == 2131364481))
      {
        i = 4;
        continue;
        i = j;
        if ((paramContext instanceof PublicFragmentActivity))
        {
          i = j;
          if ((((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment)) {
            i = 6;
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static boolean b(Context paramContext, Intent paramIntent)
  {
    paramIntent.putExtra("FromChatHistoryTab", ai(paramContext));
    return ai(paramContext) != 0;
  }
  
  public static void g(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3012);
    localIntent.putExtra("SissionUin", paramString1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("FromTroopAlbum", true);
    localIntent.setFlags(402653184);
    localIntent.putExtra("UploadPhoto.key_album_id", paramString2);
    localIntent.putExtra("UploadPhoto.key_album_name", paramString3);
    paramActivity.startActivity(localIntent);
  }
  
  public static void k(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3012);
    localIntent.putExtra("SissionUin", paramString);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ChatHistoryActivity", 2, "doOnActivityResult, requestCode = " + paramInt1);
    }
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this, SendPhotoActivity.class);
    paramIntent = new Bundle(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = wja.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.tim");
    paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
    paramIntent.putBoolean("send_in_background", false);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558944);
    aDZ();
    paramBundle = (TextView)findViewById(2131369627);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131378500);
    if ((this.bqU) || (this.bqW))
    {
      if (paramBundle != null) {
        paramBundle.setText(2131691431);
      }
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      this.a = a();
      this.a.onCreate();
      paramBundle = super.findViewById(2131377546);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramBundle.setFitsSystemWindows(true);
        paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      return true;
      if (this.mFromType == 3013)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131695712);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
      else if (this.mFromType == 3014)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131691428);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.onDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.a.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.onResume();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public int ye()
  {
    if (this.a != null) {
      return this.a.yh();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryActivity
 * JD-Core Version:    0.7.0.1
 */