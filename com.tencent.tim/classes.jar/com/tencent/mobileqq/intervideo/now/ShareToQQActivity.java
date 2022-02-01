package com.tencent.mobileqq.intervideo.now;

import acfd;
import aclp;
import ahgq;
import aifj;
import aifk;
import aizg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anxh;
import apzg;
import aqep;
import aqgv;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import plr;
import wja;

public class ShareToQQActivity
  extends BaseActivity
{
  static boolean awx;
  acfd a = new aifj(this);
  String aON;
  aclp b = new aifk(this);
  public String bNE = "";
  private String bNF = "";
  public ProfileActivity.AllInOne e = null;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = getIntent().getStringExtra("storyid");
    String str = getIntent().getStringExtra("sourceFrom");
    if ((TextUtils.equals(this.bNF, "share_from_troop_member_card")) && (paramInt2 == -1))
    {
      paramIntent.putExtra("selfSet_leftViewText", getString(2131720735));
      new Intent(this, SplashActivity.class);
      localObject = wja.a(paramIntent, null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      paramIntent = ForwardUtils.a((Intent)localObject);
      ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
    }
    for (;;)
    {
      awx = false;
      finish();
      return;
      if (TextUtils.equals(str, "OD")) {
        apzg.c(this.app, this, paramInt2, paramIntent);
      } else if ((TextUtils.equals(str, "StudyRoom")) || (TextUtils.equals(str, "now_qqlive")) || (TextUtils.equals(str, "StudyRoomQzone"))) {
        anxh.a(this.app, this, paramInt2, paramIntent, str);
      } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
        apzg.a(this.app, this, paramInt2, paramIntent);
      } else {
        apzg.b(this.app, this, paramInt2, paramIntent);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (awx) {
      finish();
    }
    awx = true;
    Object localObject = paramBundle.getStringExtra("storyid");
    this.bNF = paramBundle.getStringExtra("sourceFrom");
    if (paramBundle.getBooleanExtra("isLandscape", false)) {
      setRequestedOrientation(0);
    }
    boolean bool;
    long l;
    if ("shiel_uin".equals(this.bNF))
    {
      addObserver(this.a);
      bool = paramBundle.getBooleanExtra("isCancelShield", false);
      this.bNE = paramBundle.getStringExtra("uin");
      paramBundle = (FriendListHandler)this.app.getBusinessHandler(1);
      for (;;)
      {
        try
        {
          l = Long.valueOf(this.bNE).longValue();
          if (bool) {
            continue;
          }
          bool = true;
          paramBundle.ai(l, bool);
        }
        catch (NumberFormatException paramBundle)
        {
          QLog.d("qqBaseActivity", 1, "changeFriendShieldFlag, NumberFormatException:shielTagetUin=" + this.bNE);
          continue;
        }
        return false;
        bool = false;
      }
    }
    if ("source_from_operate_shiel_uin_list".equals(this.bNF))
    {
      addObserver(this.b);
      bool = paramBundle.getBooleanExtra("isCancelShield", false);
      this.bNE = paramBundle.getStringExtra("uin");
      this.e = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("allinone"));
      localObject = (aizg)this.app.getManager(16);
      if ((localObject != null) && (this.e != null))
      {
        try
        {
          paramBundle = this.e.uin;
          if (ProfileActivity.AllInOne.i(this.e)) {
            paramBundle = oP();
          }
          l = Long.parseLong(paramBundle);
          paramBundle = new ArrayList();
          paramBundle.add(Long.valueOf(l));
          int i = aqep.b(this.e);
          if (bool) {
            ((aizg)localObject).U(i, paramBundle);
          } else {
            ((aizg)localObject).T(i, paramBundle);
          }
        }
        catch (NumberFormatException paramBundle)
        {
          if (!QLog.isColorLevel()) {
            break label681;
          }
        }
        QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + paramBundle.toString());
      }
      else
      {
        paramBundle = new Intent();
        paramBundle.putExtra("isSuccess", false);
        paramBundle.putExtra("isCancelShield", bool);
        setResult(-1, paramBundle);
      }
    }
    else
    {
      if ("share_from_troop_member_card".equals(this.bNF))
      {
        ahgq.f(this, paramBundle, 21);
        return true;
      }
      if (TextUtils.equals(this.bNF, "OD"))
      {
        apzg.h(this, paramBundle.getExtras(), 1001);
        return true;
      }
      if ((TextUtils.equals(this.bNF, "StudyRoom")) || (TextUtils.equals(this.bNF, "now_qqlive")))
      {
        anxh.d(this, paramBundle.getExtras(), 1001);
        return true;
      }
      if (TextUtils.equals(this.bNF, "StudyRoomQzone"))
      {
        anxh.a(this, this.app.getCurrentAccountUin(), paramBundle.getExtras(), 1001);
        return true;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new MessageForQQStory();
        ((MessageForQQStory)localObject).coverImgUrl = paramBundle.getStringExtra("imageUrl");
        ((MessageForQQStory)localObject).brief = paramBundle.getStringExtra("summary");
        ((MessageForQQStory)localObject).srcName = plr.asY;
        ((MessageForQQStory)localObject).srcAction = "mqqapi://qstory/opendiscovery?src_type=internal&version=1";
        ((MessageForQQStory)localObject).msgAction = String.format("nowmqqapi://now/openroom?src_type=app&version=1&roomid=%s&first=%d&bid=1&contentType=2&unionid=%s", new Object[] { Long.valueOf(paramBundle.getLongExtra("roomid", 0L)), Integer.valueOf(2), paramBundle.getStringExtra("unionid") });
        ((MessageForQQStory)localObject).authorName = paramBundle.getStringExtra("anchorname");
        ((MessageForQQStory)localObject).logoImgUrl = "https://p.qpic.cn/qqstory_pic/hb4ycQ6NORNib7icgbswTvTCmkTyROl41Rcw9UeasFKzLwevbfJVhMRA/";
        ((MessageForQQStory)localObject).briefBgColor = -16395392;
        ((MessageForQQStory)localObject).type = 0;
        apzg.a(this, (MessageForQQStory)localObject, 1001);
      }
      for (;;)
      {
        return true;
        apzg.g(this, paramBundle.getExtras(), 1001);
      }
    }
    label681:
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    awx = false;
    if ("shiel_uin".equals(this.bNF)) {
      removeObserver(this.a);
    }
    while (!"source_from_operate_shiel_uin_list".equals(this.bNF)) {
      return;
    }
    removeObserver(this.b);
  }
  
  public String oP()
  {
    Object localObject = null;
    try
    {
      String str = aqgv.x(this.app, this.aON);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.ShareToQQActivity
 * JD-Core Version:    0.7.0.1
 */