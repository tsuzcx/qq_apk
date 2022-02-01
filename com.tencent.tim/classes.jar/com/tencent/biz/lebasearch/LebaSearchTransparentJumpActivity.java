package com.tencent.biz.lebasearch;

import amjm;
import ampx;
import amqg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import aqgv;
import avja;
import avpw;
import avpw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import kgw;
import ppf;

public class LebaSearchTransparentJumpActivity
  extends IphoneTitleBarActivity
{
  public View view;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)paramBundle);
    }
    this.view = new View(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    amjm localamjm = (amjm)this.app.getManager(222);
    if (localamjm.b != null) {
      localamjm.b = null;
    }
    if (localamjm.a != null) {
      localamjm.a = null;
    }
  }
  
  public void doOnResume()
  {
    int j = 0;
    super.doOnResume();
    Object localObject1 = getIntent();
    switch (((Intent)localObject1).getIntExtra("key_business", 0))
    {
    }
    for (;;)
    {
      finish();
      return;
      ppf.b(this, 23, ((Intent)localObject1).getLongExtra("uin", 0L));
      continue;
      QWalletHelper.launchQWalletAct(this, this.app, true, false);
      continue;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("newflag", true);
      ((Intent)localObject1).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.x((Intent)localObject1, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject1).addFlags(805306368);
      avpw.b(this, this.app.getCurrentAccountUin(), (Intent)localObject1, -1);
      continue;
      ((Intent)localObject1).putExtra("selfSet_leftViewText", getString(2131691039));
      avja.a(this, this.app.getAccount(), (Intent)localObject1, -1, false);
      continue;
      avpw.d locald = avpw.d.a();
      try
      {
        long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
        locald.cMP = String.valueOf(l);
        String str = this.app.getCurrentNickname();
        localObject1 = str;
        if (TextUtils.isEmpty(str)) {
          localObject1 = aqgv.n(this.app, String.valueOf(l));
        }
        locald.nickname = ((String)localObject1);
        avpw.b(this, locald, Long.valueOf(l), 0, false, -1);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      int i = localException1.getIntExtra("tab_tab_index", 0);
      kgw.b(this.app, this, 1, i);
      continue;
      Object localObject2 = new Intent(this, PhoneUnityBindInfoActivity.class);
      ((Intent)localObject2).putExtra("kSrouce", 18);
      startActivity((Intent)localObject2);
      continue;
      localObject2 = ((Intent)localObject2).getStringExtra("key_click_web_search_fts_key");
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject2 = ((String)localObject2).split("-");
      }
      try
      {
        i = Integer.valueOf(localObject2[1]).intValue();
        localObject2 = ((amjm)this.app.getManager(222)).b;
        if (localObject2 != null)
        {
          this.view.setTag(2131381961, Integer.valueOf(i));
          ((ampx)localObject2).cR(this.view);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("IphoneTitleBarActivity", 2, " local result idStr parse error!");
            i = j;
          }
        }
        QLog.d("kueenie", 2, "result model is null");
      }
      continue;
      ((amjm)this.app.getManager(222)).a.cR(this.view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchTransparentJumpActivity
 * JD-Core Version:    0.7.0.1
 */