package com.tencent.mobileqq.activity.aio.tips;

import acfp;
import anaz;
import anbi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import anot;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import yim;
import yjg;
import yjh;

public class SougouInputGrayTips
  implements Runnable, yim
{
  private StringBuilder G = new StringBuilder("");
  private Context J;
  private final long TIME_INTERVAL = 604800000L;
  private yjh a;
  private QQAppInterface app;
  private Time b;
  private boolean bmO;
  private boolean init;
  private SessionInfo mSessionInfo;
  
  public SougouInputGrayTips(QQAppInterface paramQQAppInterface, yjh paramyjh, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.J = paramContext;
    this.mSessionInfo = paramSessionInfo;
  }
  
  private boolean aO(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    paramContext = at(paramContext);
    if ((paramContext.contains(acfp.m(2131714645))) || (paramContext.contains("QQ输入法"))) {}
    for (boolean bool = true;; bool = false)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "hasInstallSougouOrQQInput ret = " + bool + ", cost:" + (l2 - l1) + " ms");
      }
      return bool;
    }
  }
  
  private String at(Context paramContext)
  {
    int j = 0;
    this.G.setLength(0);
    Object localObject1 = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject1 = ((InputMethodManager)localObject1).getInputMethodList();
      if (localObject1 == null)
      {
        i = 0;
        while (j < i)
        {
          InputMethodInfo localInputMethodInfo = (InputMethodInfo)((List)localObject1).get(j);
          this.G.append(localInputMethodInfo.loadLabel(paramContext.getPackageManager()));
          this.G.append(" ");
          j += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "TransactionTooLargeException occursed when getInputMethodList");
        }
        Object localObject2 = null;
        continue;
        int i = localObject2.size();
      }
    }
    return this.G.toString();
  }
  
  public int[] E()
  {
    return yjg.iK;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = anbi.d(-1014);
    long l = anaz.gQ();
    String str = this.app.getCurrentAccountUin();
    paramVarArgs.init(str, this.mSessionInfo.aTl, str, "", l, -1043, this.mSessionInfo.cZ, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public int getType()
  {
    return 1002;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1002) {}
    do
    {
      return;
      paramInt = ((String)paramVarArgs[0]).length();
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "sendContent size = " + paramInt);
      }
    } while (paramInt < 10);
    ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SougouInputGrayTips", 2, ".....run......");
    }
    if (!this.init)
    {
      this.bmO = aO(this.J);
      this.init = true;
    }
    if (this.bmO) {
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "installSougouOrQQInput, just return");
      }
    }
    long l1;
    Object localObject1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      localObject1 = this.app.b().f(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "getAIOList cost:" + (l2 - l1) + " ms");
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SougouInputGrayTips", 2, "aioMsgList == null");
    return;
    int j = ((List)localObject1).size();
    int i = j - 1;
    label168:
    boolean bool;
    if (i >= 0) {
      if (i < j - 11) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "findExcludeMsg :" + bool);
      }
      if (bool) {
        break;
      }
      localObject1 = "key_sougou_input_gray_tips_" + this.app.getCurrentAccountUin();
      Object localObject2 = "key_sougou_input_gray_tips_count_" + this.app.getCurrentAccountUin();
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      String str1 = localSharedPreferences.getString((String)localObject1, "");
      String str2 = localSharedPreferences.getString((String)localObject2, "");
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "sougouInputGrayShowCountStr = " + str2);
      }
      if (!TextUtils.isEmpty(str2))
      {
        j = Integer.parseInt(str2);
        i = j;
        if (j < 2) {
          break label484;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SougouInputGrayTips", 2, "showCount >= 2, just return;");
        return;
        localObject2 = (ChatMessage)((List)localObject1).get(i);
        if ((((ChatMessage)localObject2).msgtype == -1014) || (((ChatMessage)localObject2).msgtype == -1017) || (((ChatMessage)localObject2).msgtype == -1016) || (((ChatMessage)localObject2).msgtype == -1041) || (((ChatMessage)localObject2).msgtype == -1043) || ((((ChatMessage)localObject2).msgtype == -1013) && (((ChatMessage)localObject2).istroop == 0)))
        {
          bool = true;
          continue;
        }
        i -= 1;
        break label168;
      }
      i = 0;
      label484:
      l1 = anaz.gQ() * 1000L;
      if (!TextUtils.isEmpty(str1))
      {
        if (this.b == null) {
          this.b = new Time();
        }
        this.b.set(l1);
        j = this.b.year;
        int k = this.b.month;
        int m = this.b.monthDay;
        int n = this.b.hour;
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "curDate :" + j + " - " + k + " - " + m + " - " + n);
        }
        l2 = Long.parseLong(str1);
        this.b.set(l2);
        j = this.b.year;
        k = this.b.month;
        m = this.b.monthDay;
        n = this.b.hour;
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "lastShowDate :" + j + " - " + k + " - " + m + " - " + n);
        }
        if (l1 - l2 > 604800000L) {
          break label783;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SougouInputGrayTips", 2, "has show in a week, just return;");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "has never shown sougouInput Gray Tips");
      }
      label783:
      if (!this.a.a(this, new Object[0])) {
        break;
      }
      localSharedPreferences.edit().putString((String)localObject1, String.valueOf(l1)).putString((String)localObject2, String.valueOf(i + 1)).commit();
      anot.a(this.app, "CliOper", "", "", "0X80047CE", "0X80047CE", 0, 0, "", "", "", "");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips
 * JD-Core Version:    0.7.0.1
 */