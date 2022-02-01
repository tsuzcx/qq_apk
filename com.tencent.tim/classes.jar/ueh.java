import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity.StartRecommendPageTask;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ueh
  extends acnd
{
  public ueh(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramBoolean)
    {
      int i = this.this$0.getIntent().getExtras().getShort("group_option", (short)2);
      if (i == 4) {
        if (paramTroopInfo != null)
        {
          paramString = wja.a(new Intent(this.this$0, SplashActivity.class), null);
          paramString.putExtra("uin", paramTroopInfo.troopuin);
          paramString.putExtra("uintype", 1);
          paramString.putExtra("uinname", paramTroopInfo.getTroopName());
          this.this$0.startActivity(paramString);
        }
      }
      while ((TextUtils.isEmpty(this.this$0.mTroopUin)) || (TextUtils.isEmpty(this.this$0.app.getAccount())) || (i != 1)) {
        return;
      }
      paramString = this.this$0.app.a();
      RecentUser localRecentUser = paramString.a().a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.troopname;
      localRecentUser.msgData = null;
      localRecentUser.msg = null;
      localRecentUser.msgType = 0;
      long l = NetConnInfoCenter.getServerTime();
      if (localRecentUser.lastmsgtime < l) {
        localRecentUser.lastmsgtime = l;
      }
      paramString.a().e(localRecentUser);
      this.this$0.setResult(-1);
      this.this$0.finish();
      return;
    }
    this.this$0.setResult(-1);
    if ((this.this$0.d != null) && (AddFriendVerifyActivity.a(this.this$0) != null))
    {
      this.this$0.getWindow().setSoftInputMode(2);
      this.this$0.d.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.this$0).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.this$0).clearFocus();
    }
    this.this$0.finish();
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((this.this$0.mTroopUin == null) || (!this.this$0.mTroopUin.equals(paramString))) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.this$0, this.this$0.getString(2131698424), 0).show(this.this$0.getTitleBarHeight());
      AddFriendVerifyActivity.b(this.this$0);
    }
    paramString = this.this$0;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.aRk = paramBoolean;
      return;
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (!aqft.equalsWithNullCheck(String.valueOf(paramLong), this.this$0.mTroopUin)) {}
    label256:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label256;
          }
          long l = paramTroopInfo.dwGroupClassExt;
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", dwGroupClassExt = " + l + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
          }
          if ((l != 10009L) && (l != 10010L) && (l != 10011L) && (l != 10012L) && (!paramTroopInfo.isHomeworkTroop())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret: 不需要显示城市、星座、性别这一交友信息~");
        return;
        paramTroopInfo = AddFriendVerifyActivity.b(this.this$0);
      } while (TextUtils.isEmpty(paramTroopInfo));
      paramTroopInfo = this.this$0.getString(2131699760, new Object[] { this.this$0.app.getCurrentNickname() }) + paramTroopInfo;
      this.this$0.uW(paramTroopInfo);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
  }
  
  protected void b(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void eE(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.this$0.u.dismiss();
      apuh.t(this.this$0, paramInt2);
      AddFriendVerifyActivity.b(this.this$0, 1002);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {}
    switch (paramInt2)
    {
    case -1: 
    default: 
      AddFriendVerifyActivity.b(this.this$0, 1002);
      this.this$0.u.dismiss();
      QQToast.a(this.this$0, 1, 2131718832, 1).show(this.this$0.getTitleBarHeight());
    case -2: 
      do
      {
        return;
        this.this$0.u.dismiss();
        AddFriendVerifyActivity.b(this.this$0, 1004);
      } while ((this.this$0.getIntent() == null) || (this.this$0.getIntent().getExtras() == null));
      if (this.this$0.getIntent().getExtras().getShort("group_option", (short)2) == 4)
      {
        if (AddFriendVerifyActivity.c(this.this$0) != null) {
          AddFriendVerifyActivity.c(this.this$0).setVisibility(0);
        }
        AddFriendVerifyActivity.b(this.this$0, 1002);
        return;
      }
      ((acms)this.this$0.app.getBusinessHandler(20)).ad(Long.parseLong(this.this$0.mTroopUin), Long.parseLong(this.this$0.app.getAccount()));
      AddFriendVerifyActivity.a(this.this$0, true);
      return;
    case 0: 
    case 1: 
      this.this$0.u.dismiss();
      Object localObject = this.this$0.getIntent().getStringExtra("param_return_addr");
      AddFriendVerifyActivity.b(this.this$0, 1003);
      if (localObject != null) {
        QQToast.a(this.this$0, 2, 2131718833, 1).show(this.this$0.getTitleBarHeight());
      }
      for (;;)
      {
        try
        {
          paramString = Class.forName((String)localObject);
          localObject = new Intent();
          ((Intent)localObject).setComponent(new ComponentName("com.tencent.tim", paramString.getName()));
          ((Intent)localObject).setFlags(67108864);
          this.this$0.startActivity((Intent)localObject);
          if (TextUtils.isEmpty(this.this$0.aKK)) {
            break;
          }
          paramString = new ArrayList(1);
          paramString.add("admin.qun.qq.com");
          aija.a("closeJoinWebView", null, paramString, null);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.this$0.setResult(-1);
          this.this$0.finish();
          continue;
        }
        if (this.this$0.getIntent().getBooleanExtra("from_newer_guide", false))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.this$0.setResult(-1, (Intent)localObject);
          this.this$0.finish();
        }
        else if (this.this$0.getIntent().getBooleanExtra("from_babyq", false))
        {
          this.this$0.app.b().uz("babyq_add_troop");
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.this$0.setResult(-1, (Intent)localObject);
          this.this$0.finish();
        }
        else
        {
          paramInt1 = this.this$0.getIntent().getExtras().getShort("group_option", (short)2);
          paramString = (acms)this.this$0.app.getBusinessHandler(20);
          if ((paramInt1 == 1) || (paramInt1 == 4)) {
            paramString.bJ(this.this$0.mTroopUin, false);
          } else {
            paramString.ad(Long.parseLong(this.this$0.mTroopUin), Long.parseLong(this.this$0.app.getAccount()));
          }
        }
      }
    }
    AddFriendVerifyActivity.b(this.this$0, 1002);
    this.this$0.u.dismiss();
    QQToast.a(this.this$0, 1, 2131721390, 1).show(this.this$0.getTitleBarHeight());
  }
  
  protected void uX(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.this$0, 2, 2131718833, 1).show(this.this$0.getTitleBarHeight());
      this.this$0.setResult(-1);
      if ((this.this$0.d != null) && (AddFriendVerifyActivity.a(this.this$0) != null))
      {
        this.this$0.getWindow().setSoftInputMode(2);
        this.this$0.d.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.this$0).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.this$0).clearFocus();
      }
      AddFriendVerifyActivity.a(this.this$0, false);
      this.this$0.finish();
    }
    for (;;)
    {
      AddFriendVerifyActivity.b(this.this$0, 1004);
      return;
      paramString = new AddFriendVerifyActivity.StartRecommendPageTask(this.this$0, paramString);
      this.this$0.mHandler.post(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ueh
 * JD-Core Version:    0.7.0.1
 */