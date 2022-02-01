package com.tencent.qqmail.account.helper;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.log.AddAccountFailLogUtil;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateEmail.EmailException;
import java.util.List;
import moai.oss.OssHelper;

public final class Helper
{
  private static final String ADD_ACCOUNT_PROTOCOL_ACTIVESYNC = "3";
  private static final String ADD_ACCOUNT_PROTOCOL_EXCHANGE = "2";
  private static final String ADD_ACCOUNT_PROTOCOL_IMAP = "1";
  private static final String ADD_ACCOUNT_PROTOCOL_POP = "0";
  private static final String ADD_ACCOUNT_PROTOCOL_QQMAIL = "4";
  private static final String TAG = "Helpder";
  
  public static AccountType checkAccountType(MailServiceProvider paramMailServiceProvider, AccountType paramAccountType, String paramString)
    throws ValidateEmail.EmailException
  {
    AccountType localAccountType = AccountType.analyse(paramString, paramAccountType);
    paramAccountType = localAccountType;
    if (paramMailServiceProvider != null)
    {
      paramAccountType = localAccountType;
      if (paramMailServiceProvider.getProviderCompanyEntrys() != null)
      {
        List localList = paramMailServiceProvider.getProviderCompanyEntrys();
        if (!localList.contains("1"))
        {
          paramAccountType = localAccountType;
          if (!localList.contains("2")) {}
        }
        else
        {
          if (!((String)localList.get(0)).equals("2")) {
            break label102;
          }
          paramAccountType = AccountType.exmail;
        }
      }
    }
    for (;;)
    {
      paramString = paramAccountType;
      if (paramMailServiceProvider != null)
      {
        paramString = paramAccountType;
        if (paramMailServiceProvider.getDefaultRecvProtocol().equals("ActiveSync")) {
          paramString = AccountType.exchange;
        }
      }
      return paramString;
      label102:
      if ((paramString.endsWith("@qq.com")) || (paramString.endsWith("@vip.qq.com")) || (paramString.endsWith("@foxmail.com")) || ("qq.com".equals(paramMailServiceProvider.getProviderName()))) {
        paramAccountType = AccountType.qqmail;
      } else {
        paramAccountType = AccountType.exmail;
      }
    }
  }
  
  public static boolean checkEditTextEmpty(EditText paramEditText, int paramInt)
  {
    boolean bool = false;
    if (paramEditText.getText().toString().trim().length() == 0)
    {
      if (paramInt > 0) {
        Toast.makeText(QMApplicationContext.sharedInstance(), 2131695532, 0).show();
      }
      paramEditText.requestFocus();
      bool = true;
    }
    return bool;
  }
  
  public static boolean ignoreQueryDomain(AccountType paramAccountType, String paramString)
  {
    return (paramAccountType == AccountType.qqmail) && ((paramString.endsWith("@qq.com")) || (paramString.endsWith("@vip.qq.com")) || (paramString.endsWith("@foxmail.com")));
  }
  
  public static void initEditTextAndClearButton(EditText paramEditText, View paramView)
  {
    initEditTextAndClearButton(paramEditText, paramView, null, null);
  }
  
  public static void initEditTextAndClearButton(EditText paramEditText, View paramView, HelperFocusChange paramHelperFocusChange, HelperTextChange paramHelperTextChange)
  {
    paramEditText.setOnFocusChangeListener(new Helper.1(paramEditText, paramView, paramHelperFocusChange));
    paramEditText.addTextChangedListener(new Helper.2(paramHelperTextChange, paramEditText, paramView));
    paramView.setOnClickListener(new Helper.3(paramView, paramEditText));
  }
  
  public static void initEditTextAndPasswordStateButton(EditText paramEditText, ImageButton paramImageButton)
  {
    paramEditText.setOnFocusChangeListener(new Helper.4(paramImageButton));
    paramImageButton.setOnClickListener(new Helper.5(paramEditText, paramImageButton));
  }
  
  public static boolean isServerError(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 10) || (paramInt == 15);
  }
  
  public static void logAfterLoginSuccess(Account paramAccount, boolean paramBoolean, long paramLong)
  {
    String str1 = "4";
    switch (paramAccount.getProtocol())
    {
    }
    for (;;)
    {
      DataCollector.logPerformanceEnd("Performance_Login" + paramLong, "");
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "addAccount success:" + paramAccount.getEmail() + ", id:" + paramAccount.getId() + ", protocol:" + paramAccount.getProtocol());
      if (str1.equals("4")) {
        break;
      }
      QMLog.log(4, "Helpder", "report protocol login success:" + paramAccount.getEmail());
      DataCollector.logDetailEvent("DetailEvent_WY_AddAccount", paramAccount.getId(), 0L, str1);
      DataCollector.submit();
      return;
      str1 = "3";
      continue;
      str1 = "2";
      continue;
      str1 = "0";
      continue;
      str1 = "1";
    }
    QMLog.log(4, "Helpder", "report qq login success:" + paramAccount.getEmail());
    int j = 0;
    int i = j;
    if (SharedPreferenceUtil.isWtlogin())
    {
      i = j;
      if (paramAccount.isQQMail())
      {
        i = j;
        if (!paramAccount.isBizMail())
        {
          i = 1;
          DataCollector.logDetailEvent("DetailEvent_WT_AddAccount", paramAccount.getId(), 0L, str1);
          if (!paramBoolean) {
            break label320;
          }
        }
      }
    }
    label320:
    for (String str2 = "DetailEvent_QuickLogin_AddAccount";; str2 = "DetailEvent_NormalLogin_AddAccount")
    {
      DataCollector.logDetailEvent(str2, paramAccount.getId(), 0L, str1);
      if (i != 0) {
        break;
      }
      DataCollector.logDetailEvent("DetailEvent_AddAccount", paramAccount.getId(), 0L, str1);
      return;
    }
  }
  
  public static void logClickToLogin(String paramString)
  {
    paramString = "clickLogin. email:" + paramString;
    DataCollector.logDetailEvent("DetailEvent_User_Behavior", 0L, 0L, paramString);
    QMLogStream.logWithoutUmaNow(-40025, paramString, "Event_Error");
    QMLogStream.submitLog(false, true);
  }
  
  public static void logWtLoginError(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = Long.parseLong(AddAccountFailLogUtil.genAddAccountErrorCode(2, false, 0, paramInt, 0));
    paramString = AddAccountLocalLogUtil.genAddAccountFailLog(paramString, l) + " ret:" + paramInt;
    DataCollector.logDetailEvent("DetailEvent_WT_AddAccount", 0L, l, paramString);
    if (paramBoolean)
    {
      DataCollector.logDetailEvent("DetailEvent_QuickLogin_AddAccount", 0L, l, paramString);
      OssHelper.realTimeReport(new Object[] { Long.valueOf(40263L), "", Integer.valueOf(1) });
      return;
    }
    DataCollector.logDetailEvent("DetailEvent_NormalLogin_AddAccount", 0L, l, paramString);
    OssHelper.realTimeReport(new Object[] { Long.valueOf(40262L), "", Integer.valueOf(1) });
  }
  
  public static String trimString(EditText paramEditText)
  {
    return paramEditText.getText().toString().trim().replace(" ", "");
  }
  
  public static boolean warn(EditText paramEditText, String paramString)
  {
    if (paramEditText.getText().toString().trim().length() == 0)
    {
      Helper.6 local6 = new Helper.6(paramEditText);
      ((InputMethodManager)QMApplicationContext.sharedInstance().getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
      Threads.runOnMainThread(new Helper.7(paramEditText, paramString, local6), 250L);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper
 * JD-Core Version:    0.7.0.1
 */