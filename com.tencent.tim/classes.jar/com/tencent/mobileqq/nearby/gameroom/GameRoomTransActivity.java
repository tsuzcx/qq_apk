package com.tencent.mobileqq.nearby.gameroom;

import ajtd;
import ajte;
import ajtf;
import ajti;
import ajtj;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import aqju;
import ardq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class GameRoomTransActivity
  extends BaseActivity
{
  public aqju dialog = null;
  public DialogInterface.OnDismissListener j = new ajti(this);
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setImmersiveStatus(0);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
      {
        requestPermissions(new ajtd(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
        return true;
      }
      doWork();
      return true;
    }
    doWork();
    return true;
  }
  
  public void doWork()
  {
    int i = getIntent().getIntExtra("action", 1);
    if (i == 1)
    {
      dzh();
      return;
    }
    if (i == 2)
    {
      dzi();
      return;
    }
    if (i == 3)
    {
      dzj();
      return;
    }
    finish();
  }
  
  public void dzh()
  {
    try
    {
      i = getIntent().getIntExtra("roomNum", 10);
      int k = getIntent().getIntExtra("zoneId", 0);
      ((ardq)this.app.getBusinessHandler(107)).b(i, k, new ajte(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 10;
      }
    }
  }
  
  public void dzi()
  {
    String str = getIntent().getStringExtra("inviteId");
    int i = getIntent().getIntExtra("roomNum", 10);
    ((ardq)this.app.getBusinessHandler(107)).a(str, true, new ajtf(this, str, i));
  }
  
  protected void dzj()
  {
    int i = getIntent().getIntExtra("roomNum", 10);
    int k = getIntent().getIntExtra("zoneId", 0);
    long l = getIntent().getLongExtra("gc", -1L);
    ((ardq)this.app.getBusinessHandler(107)).a(new ajtj(this, l, i, k));
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity
 * JD-Core Version:    0.7.0.1
 */