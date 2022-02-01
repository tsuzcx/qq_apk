package com.tencent.androidqqmail.tim;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import moai.oss.KvHelper;
import mqq.app.AppRuntime;

public class MainActivity
  extends AppCompatActivity
{
  private static final String TAG = "MainActivity";
  private static final boolean debug = false;
  
  private boolean debug()
  {
    return false;
  }
  
  private static void debugResources(Context paramContext)
  {
    int i = 0;
    paramContext.getResources().getConfiguration();
    paramContext = paramContext.getAssets();
    try
    {
      Method localMethod = AssetManager.class.getDeclaredMethod("getGlobalAssetCount", new Class[0]);
      localMethod.setAccessible(true);
      int j = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      Log.i("MainActivity", "getGlobalAssetCount: " + j);
      localMethod = AssetManager.class.getDeclaredMethod("getGlobalAssetManagerCount", new Class[0]);
      localMethod.setAccessible(true);
      j = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      Log.i("MainActivity", "getGlobalAssetManagerCount: " + j);
      for (;;)
      {
        if (i < 10) {
          try
          {
            localMethod = AssetManager.class.getDeclaredMethod("getCookieName", new Class[] { Integer.TYPE });
            localMethod.setAccessible(true);
            Log.i("MainActivity", String.format("getCookieName[%d]: %s", new Object[] { Integer.valueOf(i), (String)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i) }) }));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.i("MainActivity", String.format("getCookieName[%d] failed", new Object[] { Integer.valueOf(i) }));
            }
          }
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException("debugResources", paramContext);
    }
  }
  
  private void firstLoginAccount()
  {
    Threads.runInBackground(new MainActivity.2(this));
  }
  
  private void login()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    QMLog.log(4, "MainActivity", "MainActivity_from_tim start accountList.isEmpty " + localAccountList.isEmpty());
    if (localAccountList.isEmpty())
    {
      if (QMSettingManager.sharedInstance().isFirstTimeFromTim())
      {
        QMLog.log(4, "MainActivity", "MainActivity_from_tim start first login ");
        firstLoginAccount();
        return;
      }
      startActivity(AccountTypeListActivity.createIntent(true));
      overridePendingTransition(17432576, 17432577);
      finish();
      return;
    }
    updateA2InAllQQMail(localAccountList, 0);
  }
  
  private void syncAccountlist()
  {
    Object localObject1 = TimMailLoginManager.syncAccountList;
    if ((localObject1 == null) || (((Set)localObject1).isEmpty())) {
      localObject1 = SharedPreferenceUtil.getSyncAccountList();
    }
    for (;;)
    {
      Log.i("MainActivity", "syncAccountlist  " + localObject1);
      AccountList localAccountList = AccountManager.shareInstance().getAccountList();
      if (localAccountList.size() == 0) {}
      for (;;)
      {
        return;
        Object localObject2 = localAccountList.iterator();
        Account localAccount;
        while (((Iterator)localObject2).hasNext())
        {
          localAccount = (Account)((Iterator)localObject2).next();
          if (!((Set)localObject1).contains(localAccount.getEmail()))
          {
            Log.i("MainActivity", "delete local account " + localAccount.getEmail());
            AccountManager.shareInstance().deleteAccount(localAccount.getId(), true);
          }
        }
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (localAccountList.getAccountByEmail((String)localObject2) == null)
          {
            Log.i("MainActivity", "local add account " + (String)localObject2);
            localAccount = new Account();
            localAccount.setEmail((String)localObject2);
            localAccount.setId(((String)localObject2).hashCode());
            localAccount.setPwd("-1");
            localAccount.setAccountState(-1);
            AccountManager.shareInstance().saveAccount(localAccount);
          }
        }
      }
    }
  }
  
  private void updateA2InAllQQMail(AccountList paramAccountList, int paramInt)
  {
    if ((paramAccountList == null) || (paramAccountList.size() == 0)) {
      throw new IllegalArgumentException("accountList no empty");
    }
    Object localObject;
    if (paramInt == paramAccountList.size()) {
      if (paramAccountList.size() == 1)
      {
        localObject = paramAccountList.get(0);
        paramAccountList = MailFragmentActivity.createIntentToFolderList(((Account)localObject).getId());
        AccountManager.shareInstance().setDefaultMailAccount(((Account)localObject).getId());
      }
    }
    for (;;)
    {
      startActivity(paramAccountList);
      finish();
      QMLog.log(4, "MainActivity", "MainActivity_from_tim finish");
      return;
      if (paramAccountList.size() > 1)
      {
        paramAccountList = MailFragmentActivity.createIntentToAccountList();
        continue;
        localObject = paramAccountList.get(paramInt);
        if (((Account)localObject).isQQMail())
        {
          localObject = (QQMailAccount)localObject;
          String str = ((QQMailAccount)localObject).getUin();
          if (str == null) {
            throw new IllegalStateException("uin null:" + localObject);
          }
          if (QMWtLoginManager.getInstance().getA2(str) != null)
          {
            updateA2InAllQQMail(paramAccountList, paramInt + 1);
            return;
          }
          if (str.equals(QMAppInterface.getRuntime().getAccount()))
          {
            TimMailLoginManager.requestA2AndSkey(str, null, new MainActivity.3(this, paramAccountList, paramInt));
            return;
          }
          updateA2InAllQQMail(paramAccountList, paramInt + 1);
          return;
        }
        updateA2InAllQQMail(paramAccountList, paramInt + 1);
      }
      else
      {
        paramAccountList = null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (BrandUtil.isHuawei()) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      KvHelper.timLaunchQqmailPlugin(new double[0]);
      Log.i("MainActivity", "onCreate");
      if (!debug()) {
        break;
      }
      return;
      overridePendingTransition(2130772422, 2130772419);
    }
    setContentView(2131558518);
    StatusBarUtil.immerseWhite(this);
    paramBundle = (TextView)findViewById(2131363222);
    paramBundle.setOnClickListener(new MainActivity.1(this));
    Drawable localDrawable = getResources().getDrawable(2130850526);
    localDrawable.setBounds(0, 0, QMUIKit.dpToPx(10), QMUIKit.dpToPx(21));
    paramBundle.setCompoundDrawables(localDrawable, null, null, null);
    paramBundle.setCompoundDrawablePadding(QMUIKit.dpToPx(7));
    if (TimMailLoginManager.firstLaunchMailProccess)
    {
      syncAccountlist();
      TimMailLoginManager.firstLaunchMailProccess = false;
    }
    login();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity
 * JD-Core Version:    0.7.0.1
 */