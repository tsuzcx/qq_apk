package com.tencent.mobileqq.activity.aio.tips;

import abbf;
import anaz;
import anbi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import top;
import yim;
import yjh;

public class VipSpecialCareGrayTips
  implements Runnable, yim
{
  private final long TIME_INTERVAL = 604800000L;
  private yjh a;
  private QQAppInterface app;
  private Time b;
  private final int bZp = 30;
  private final int bZq = 20;
  private final int bZr = 2;
  private boolean init;
  private SessionInfo mSessionInfo;
  private SharedPreferences sp;
  
  public VipSpecialCareGrayTips(QQAppInterface paramQQAppInterface, yjh paramyjh, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.mSessionInfo = paramSessionInfo;
    this.sp = BaseApplication.getContext().getSharedPreferences("free_call", 0);
  }
  
  private boolean TH()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if ((abbf.jb(this.app.getCurrentAccountUin() + this.mSessionInfo.aTl)) || (localSharedPreferences.getBoolean("specialcare_already_set" + this.mSessionInfo.aTl, false))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean TI()
  {
    boolean bool2 = true;
    String str = "key_specialcare_gray_tips_" + this.app.getCurrentAccountUin() + "_" + this.mSessionInfo.aTl;
    str = this.sp.getString(str, "");
    long l1 = anaz.gQ() * 1000L;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      if (this.b == null) {
        this.b = new Time();
      }
      this.b.set(l1);
      int i = this.b.year;
      int j = this.b.month;
      int k = this.b.monthDay;
      int m = this.b.hour;
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "curDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      long l2 = Long.parseLong(str);
      this.b.set(l2);
      i = this.b.year;
      j = this.b.month;
      k = this.b.monthDay;
      m = this.b.hour;
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "lastShowDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      bool1 = bool2;
      if (l1 - l2 <= 604800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "has show in a week, just return;");
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean TJ()
  {
    if ((!TI()) || (TH()) || (ib(this.mSessionInfo.aTl))) {
      return false;
    }
    long l = System.currentTimeMillis() / 1000L;
    Object localObject1 = this.app.b().k(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "no message. shouldShowTips=false ");
      }
      return false;
    }
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    int m = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      int i2 = i;
      int i1 = k;
      int j;
      int n;
      int i4;
      if (((MessageRecord)localObject2).time >= l - 86400L)
      {
        i2 = i;
        i1 = k;
        if (((MessageRecord)localObject2).time <= l)
        {
          j = k;
          if (((MessageRecord)localObject2).isSend())
          {
            j = k;
            if (((MessageRecord)localObject2).msgtype == -1000)
            {
              j = k;
              if (!this.app.a().aR((MessageRecord)localObject2))
              {
                j = k;
                if (((MessageRecord)localObject2).extraflag != 32768) {
                  j = k + 1;
                }
              }
            }
          }
          if (((MessageRecord)localObject2).msgtype == -2002)
          {
            if (((MessageRecord)localObject2).isSend())
            {
              i2 = i;
              i1 = j;
              if (!this.app.a().aR((MessageRecord)localObject2))
              {
                i2 = i;
                i1 = j;
                if (((MessageRecord)localObject2).extraflag == 32768) {}
              }
            }
            else
            {
              m += 1;
              k = j;
              j = m;
              if (k <= 30) {
                break label639;
              }
              if (QLog.isColorLevel()) {
                QLog.d("VipSpecialCareGrayTips", 2, "sendMsgCount>30. shouldShowTips=true , count=" + k);
              }
              return true;
            }
          }
          else
          {
            i2 = i;
            i1 = j;
            if (((MessageRecord)localObject2).msgtype == -2009)
            {
              i2 = i;
              i1 = j;
              if ((localObject2 instanceof MessageForVideo))
              {
                localObject2 = (MessageForVideo)localObject2;
                ((MessageForVideo)localObject2).parse();
                i2 = i;
                i1 = j;
                if (((MessageForVideo)localObject2).text != null)
                {
                  i2 = i;
                  i1 = j;
                  if (((MessageForVideo)localObject2).text.contains(BaseApplicationImpl.getApplication().getResources().getString(2131721734)))
                  {
                    localObject2 = ((MessageForVideo)localObject2).text;
                    localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
                    i1 = 0;
                    n = 0;
                    k = 0;
                    if (localObject2.length != 3) {
                      break label598;
                    }
                    i4 = Integer.valueOf(localObject2[0]).intValue();
                    n = Integer.valueOf(localObject2[1]).intValue();
                    k = Integer.valueOf(localObject2[2]).intValue();
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        int i3;
        if (i4 <= 0)
        {
          i3 = i;
          if (n < 10) {}
        }
        else
        {
          i3 = i + 1;
        }
        i2 = i3;
        i1 = j;
        if (QLog.isColorLevel())
        {
          QLog.d("VipSpecialCareGrayTips", 2, "video msg,hour=" + i4 + ",minute=" + n + ",second=" + k);
          i1 = j;
          i2 = i3;
        }
        i = i2;
        j = m;
        k = i1;
        break;
        label598:
        i4 = i1;
        if (localObject2.length == 2)
        {
          n = Integer.valueOf(localObject2[0]).intValue();
          k = Integer.valueOf(localObject2[1]).intValue();
          i4 = i1;
        }
      }
      label639:
      if (j > 20)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "pttMsgCount>20. shouldShowTips=true , count=" + j);
        }
        return true;
      }
      if (i > 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "longVideoMsgCount>2. shouldShowTips=true , count=" + i);
        }
        return true;
      }
      m = j;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, "shouldShowTips=false , sendMsgCount=" + k + ", pttMsgCount=" + m + ", longVideoMsgCount=" + i);
    }
    return false;
  }
  
  private boolean ib(String paramString)
  {
    boolean bool = false;
    paramString = "key_specialcare_tips_count_" + this.app.getCurrentAccountUin() + "_" + paramString;
    if (this.sp.getInt(paramString, 0) >= 2) {
      bool = true;
    }
    return bool;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = anbi.d(-5005);
    long l = anaz.gQ();
    String str = this.app.getCurrentAccountUin();
    paramVarArgs.init(str, this.mSessionInfo.aTl, str, "", l, -5005, this.mSessionInfo.cZ, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public int getType()
  {
    return 2001;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if ((!top.fv(this.mSessionInfo.cZ)) || (this.mSessionInfo.cZ != 0) || (paramInt != 1001)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, ".....run......");
    }
    if (!this.init) {
      this.init = true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = this.app.b().b(this.mSessionInfo.aTl, this.mSessionInfo.cZ, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, "getAIOList cost:" + (l2 - l1) + " ms");
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "aioMsgList == null");
      }
    }
    while ((!TJ()) || (!this.a.a(this, new Object[0]))) {
      return;
    }
    String str = "key_specialcare_gray_tips_" + this.app.getCurrentAccountUin() + "_" + this.mSessionInfo.aTl;
    localObject = this.sp.edit();
    ((SharedPreferences.Editor)localObject).putString(str, String.valueOf(anaz.gQ() * 1000L));
    str = "key_specialcare_tips_count_" + this.app.getCurrentAccountUin() + "_" + this.mSessionInfo.aTl;
    ((SharedPreferences.Editor)localObject).putInt(str, this.sp.getInt(str, 0) + 1);
    ((SharedPreferences.Editor)localObject).commit();
    VipUtils.a(this.app, "Vip_SpecialRemind", "0X8005056", "0X8005056", 0, 1, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips
 * JD-Core Version:    0.7.0.1
 */