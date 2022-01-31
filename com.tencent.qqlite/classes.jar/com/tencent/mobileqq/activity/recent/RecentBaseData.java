package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class RecentBaseData
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 15;
  public static final int l = 240;
  public static final int m = 3840;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 16;
  public static final int q = 32;
  public static final int r = 48;
  public static final int s = 256;
  protected int A = 0;
  public volatile long a;
  protected MsgSummary a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  public String b;
  public CharSequence c;
  public String c;
  public String d;
  protected String e;
  public int t;
  protected int u = 1;
  public int v;
  public int w;
  public int x;
  public int y;
  protected int z;
  
  public RecentBaseData()
  {
    this.A |= 0x1;
  }
  
  public abstract int a();
  
  public abstract long a();
  
  public final MsgSummary a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.a();
    }
  }
  
  public abstract String a();
  
  public void a()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = "null";
      String str1 = "null";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        str1 = "lenth=" + this.jdField_a_of_type_JavaLangString.length();
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
        str2 = "lenth=" + this.jdField_b_of_type_JavaLangCharSequence.length();
      }
      localStringBuilder.append("[").append("type:").append(a()).append(", uin:").append(a()).append(", unreadNum:").append(this.v).append(", titleName:").append(str1).append(", mMenuFlag:").append(this.A).append(", status:").append(this.t).append(", authenIcon:").append(this.w).append(", showTime:").append(this.jdField_b_of_type_JavaLangString).append(", lastmsg:").append(str2).append(", extrainfo:").append(this.jdField_a_of_type_JavaLangCharSequence).append(", lastmsgtime:").append(a()).append(", lastdrafttime:").append(b()).append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.t = 0;
    int i1 = a();
    if (this.t == 0)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.c(a(), i1))) {
        this.t = 4;
      }
    }
    else
    {
      return;
    }
    this.t = 0;
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = a();
    }
    if (paramMsgSummary != null)
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramMsgSummary.a(paramContext);
      if (((this.jdField_b_of_type_JavaLangCharSequence instanceof SpannableStringBuilder)) && (DeviceInfoUtil.b())) {
        this.jdField_b_of_type_JavaLangCharSequence = ((SpannableStringBuilder)this.jdField_b_of_type_JavaLangCharSequence).append(" ");
      }
      paramQQAppInterface = this.jdField_b_of_type_JavaLangCharSequence;
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 168)) {}
    }
    try
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramQQAppInterface.subSequence(0, 168);
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
        this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.a = false;
      paramMsgSummary.d = null;
    }
    if (this.jdField_a_of_type_Long > b()) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(a(), a());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramMsgSummary.a = true;
    paramMsgSummary.d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null) {}
    for (String str = paramMessage.nickName;; str = null)
    {
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, str, false, false);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final int b()
  {
    return this.v;
  }
  
  public abstract long b();
  
  public final String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void b()
  {
    this.v = 0;
  }
  
  public final void c()
  {
    this.v = 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof RecentBaseData)); bool = false)
    {
      paramObject = (RecentBaseData)paramObject;
      if ((paramObject.a() != a()) || (!Utils.a(paramObject.a(), a()))) {
        break;
      }
      return true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentBaseData
 * JD-Core Version:    0.7.0.1
 */