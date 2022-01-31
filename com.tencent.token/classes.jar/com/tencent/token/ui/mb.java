package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ImageView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.bean.UtilFucntionItem;
import com.tencent.token.el;
import com.tencent.token.gb;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.utils.t;
import java.util.ArrayList;

final class mb
  extends mu
{
  mb(IndexActivity paramIndexActivity)
  {
    super(paramIndexActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    Object localObject1;
    Object localObject2;
    int j;
    switch (paramMessage.what)
    {
    default: 
    case 3026: 
    case 3030: 
    case 1019: 
    case 3024: 
    case 4097: 
    case 4098: 
      do
      {
        do
        {
          return;
          this.a.dismissDialog();
          if (paramMessage.arg1 == 0)
          {
            if (paramMessage.arg2 == 1) {}
            for (boolean bool = true;; bool = false)
            {
              paramMessage = new Intent(this.a, NoCheckWithAuthActivity.class);
              paramMessage.putExtra("bindTokenSucc", true);
              paramMessage.putExtra("bindMobileSucc", bool);
              this.a.startActivity(paramMessage);
              return;
            }
          }
          paramMessage = (d)paramMessage.obj;
          d.a(this.a.getResources(), paramMessage);
          e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
          this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
          return;
          this.a.dismissDialog();
          if (paramMessage.arg1 == 0)
          {
            paramMessage = (UpgradeDeterminResult)paramMessage.obj;
            IndexActivity.access$100(this.a, paramMessage);
            return;
          }
          paramMessage = (d)paramMessage.obj;
          e.c("err " + paramMessage.a);
          d.a(this.a.getResources(), paramMessage);
          e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
          this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
          return;
          paramMessage = (byte[])paramMessage.obj;
          IndexActivity.access$202(this.a, paramMessage);
        } while (paramMessage == null);
        IndexActivity.access$202(this.a, paramMessage);
        af.a().a(this.a.curruser.mRealUin, IndexActivity.access$200(this.a), IndexActivity.access$300(this.a), 2);
        return;
        if (i == 0)
        {
          af.a().a(this.a.curruser.mRealUin, IndexActivity.access$200(this.a), IndexActivity.access$300(this.a));
          return;
        }
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showToast(paramMessage.c);
        return;
        localObject1 = (byte[])paramMessage.obj;
        if ((i == 0) && (localObject1 != null))
        {
          IndexActivity.access$202(this.a, (byte[])localObject1);
          af.a().a(this.a.curruser.mRealUin, IndexActivity.access$200(this.a), IndexActivity.access$300(this.a), 2);
          return;
        }
        if (i != 2) {
          break;
        }
      } while (this.a.isFinishing());
      new WtloginCaptchaDialog(this.a, IndexActivity.access$300(this.a), Long.toString(this.a.curruser.mRealUin)).show();
      return;
      if (i == -1000)
      {
        this.a.dismissDialog();
        this.a.showToast(2131361943);
        return;
      }
      if (i == 8192)
      {
        this.a.dismissDialog();
        this.a.showToast(2131362089);
        return;
      }
      if ((i == 1) || (i == 15) || (i == 16))
      {
        this.a.dismissDialog();
        this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new mc(this));
        return;
      }
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
        return;
      }
      this.a.showToast(2131362091);
      return;
    case 1006: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        localObject1 = new Intent(this.a, UnbindUinActivity.class);
        localObject2 = new Bundle();
        QQUser localQQUser = ax.a().e();
        ((Bundle)localObject2).putLong("hash_uin", localQQUser.mUin);
        ((Bundle)localObject2).putLong("real_uin", localQQUser.mRealUin);
        ((Intent)localObject1).putExtra("com.tencent.real_uin", (Bundle)localObject2);
        this.a.startActivity((Intent)localObject1);
      }
      break;
    case 3041: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (ConfigResult)paramMessage.obj;
        if (paramMessage != null)
        {
          if ((paramMessage.mStartUpImgUrl != null) && (paramMessage.mStartUpImgUrl.length() > 0))
          {
            long l = ag.c().r() / 1000L;
            if ((paramMessage.mStartUpImgStartTime > 0L) && (paramMessage.mStartUpImgEndTime > 0L) && (l < paramMessage.mStartUpImgEndTime) && ((t.a.mStartUpImgStartTime != paramMessage.mStartUpImgStartTime) || ((t.a.mStartUpImgUrl != null) && (!t.a.mStartUpImgUrl.equals(paramMessage.mStartUpImgUrl))) || (t.a.mStartUpImgEndTime != paramMessage.mStartUpImgEndTime))) {
              af.a().a(paramMessage, IndexActivity.access$300(this.a));
            }
          }
          LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.utils_icon_flag"));
          e.b("IndexActivity--->to UtilsActivity");
          if ((paramMessage.mActivityName != null) && (paramMessage.mActivityUrl != null) && (paramMessage.mActivityUrl.length() > 0) && (this.a.mLocalConfig.mActivityVersion < paramMessage.mActivityVersion))
          {
            if (IndexActivity.access$500(this.a) != 2) {
              IndexActivity.access$600(this.a).setVisibility(0);
            }
            SettingPageActivity.mShowConfigNew = true;
          }
          if ((paramMessage.headlinetip != null) && (paramMessage.headlineurl != null) && (paramMessage.headlineurl.length() > 0) && (this.a.mLocalConfig.headlineVersion < paramMessage.headlineVersion))
          {
            if (IndexActivity.access$500(this.a) != 2) {
              IndexActivity.access$600(this.a).setVisibility(0);
            }
            SettingPageActivity.mShowSafeNew = true;
          }
          if ((paramMessage.fucntionItemlist != null) && (paramMessage.fucntionItemlist.size() > 0))
          {
            i = 0;
            if (i < paramMessage.fucntionItemlist.size())
            {
              localObject1 = (UtilFucntionItem)paramMessage.fucntionItemlist.get(i);
              if ((this.a.mLocalConfig.fucntionItemlist != null) && (this.a.mLocalConfig.fucntionItemlist.size() > 0))
              {
                j = 0;
                label1387:
                if (j >= this.a.mLocalConfig.fucntionItemlist.size()) {
                  break label1804;
                }
                localObject2 = (UtilFucntionItem)this.a.mLocalConfig.fucntionItemlist.get(j);
                if (!((UtilFucntionItem)localObject2).a().equals(((UtilFucntionItem)localObject1).a())) {
                  break label2183;
                }
                if (((UtilFucntionItem)localObject2).b() < ((UtilFucntionItem)localObject1).b())
                {
                  if (!((UtilFucntionItem)localObject1).a().equals("101")) {
                    break label1672;
                  }
                  SettingPageActivity.mShowQRNew = true;
                  label1470:
                  if (IndexActivity.access$500(this.a) != 2) {
                    IndexActivity.access$600(this.a).setVisibility(0);
                  }
                }
              }
            }
          }
        }
      }
      break;
    }
    label2183:
    for (int k = 1;; k = 0)
    {
      for (;;)
      {
        if ((k == 0) && (((UtilFucntionItem)localObject1).b() > 0))
        {
          if (!((UtilFucntionItem)localObject1).a().equals("101")) {
            break label1714;
          }
          SettingPageActivity.mShowQRNew = true;
        }
        for (;;)
        {
          if (IndexActivity.access$500(this.a) != 2) {
            IndexActivity.access$600(this.a).setVisibility(0);
          }
          j += 1;
          break label1387;
          localObject1 = (d)paramMessage.obj;
          e.c("err " + ((d)localObject1).a);
          d.a(this.a.getResources(), (d)localObject1);
          e.c("query up flow failed:" + ((d)localObject1).a + "-" + ((d)localObject1).b + "-" + ((d)localObject1).c);
          this.a.showTipDialog(2131361907, ((d)localObject1).c);
          break;
          label1672:
          if (((UtilFucntionItem)localObject1).a().equals("102"))
          {
            SettingPageActivity.mShowQueryNew = true;
            break label1470;
          }
          if (!((UtilFucntionItem)localObject1).a().equals("103")) {
            break label1470;
          }
          SettingPageActivity.mShowUtilNew = true;
          break label1470;
          label1714:
          if (((UtilFucntionItem)localObject1).a().equals("102")) {
            SettingPageActivity.mShowQueryNew = true;
          } else if (((UtilFucntionItem)localObject1).a().equals("103")) {
            SettingPageActivity.mShowUtilNew = true;
          }
        }
        if (((UtilFucntionItem)localObject1).b() > 0)
        {
          if (!((UtilFucntionItem)localObject1).a().equals("101")) {
            break label1811;
          }
          SettingPageActivity.mShowQRNew = true;
        }
        for (;;)
        {
          if (IndexActivity.access$500(this.a) != 2) {
            IndexActivity.access$600(this.a).setVisibility(0);
          }
          label1804:
          i += 1;
          break;
          label1811:
          if (((UtilFucntionItem)localObject1).a().equals("102")) {
            SettingPageActivity.mShowQueryNew = true;
          } else if (((UtilFucntionItem)localObject1).a().equals("103")) {
            SettingPageActivity.mShowUtilNew = true;
          }
        }
        LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.activity_flag"));
        try
        {
          gb.a();
          if (!gb.f()) {
            break;
          }
          paramMessage = new HandlerThread("loguploader", 1);
          paramMessage.start();
          paramMessage = new Handler(paramMessage.getLooper());
          paramMessage.postDelayed(new md(this, paramMessage), 30000L);
          return;
        }
        catch (Exception paramMessage)
        {
          return;
        }
      }
      if ((this.a.isFinishing()) || (paramMessage.arg1 != 0)) {
        break;
      }
      AccountPageActivity.mNeedRefreshEval = true;
      paramMessage = (el)paramMessage.obj;
      if ((paramMessage.a != 1) || (paramMessage.b == null) || (paramMessage.b.length() <= 0)) {
        break;
      }
      IndexActivity.access$702(this.a, new AlertDialog.Builder(this.a).setTitle(2131362452).setMessage(paramMessage.b).setPositiveButton(2131362453, new mg(this, paramMessage)).setNegativeButton(2131361804, new mf(this)).setOnCancelListener(new me(this)).create());
      IndexActivity.access$700(this.a).show();
      return;
      if (paramMessage.arg1 != 0) {
        break;
      }
      this.a.onResume();
      LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
      return;
      if ((this.a.isFinishing()) || (paramMessage.arg1 != 0)) {
        break;
      }
      paramMessage = (String)paramMessage.obj;
      af.a().d(paramMessage, IndexActivity.access$300(this.a));
      return;
      if (paramMessage.arg1 != 165) {
        break;
      }
      if (!RqdApplication.b)
      {
        IndexActivity.access$800(this.a);
        return;
      }
      IndexActivity.access$902(this.a, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mb
 * JD-Core Version:    0.7.0.1
 */