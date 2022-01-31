package com.tencent.mobileqq.subaccount.datamanager;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gpv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SubAccountAssistantCache
{
  private static final int jdField_a_of_type_Int = 20;
  public static String a;
  private static String jdField_b_of_type_JavaLangString = "Q.subaccount.SubAccountAssistantCache";
  private long jdField_a_of_type_Long = 0L;
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private gpv jdField_a_of_type_Gpv = new gpv(this, null);
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte = { 0 };
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private byte[] jdField_b_of_type_ArrayOfByte = { 1 };
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  private String f = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  }
  
  private void e()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      if ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 20))
      {
        SubAccountMessageData localSubAccountMessageData = (SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        SubAccountMessage localSubAccountMessage;
        if (localSubAccountMessageData != null)
        {
          localSubAccountMessage = localSubAccountMessageData.a();
          if (localSubAccountMessage != null) {
            break label83;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label83:
          if (!localSubAccountMessage.isread)
          {
            if (localSubAccountMessageData.jdField_a_of_type_Boolean) {
              this.jdField_d_of_type_Int += 1;
            }
            this.jdField_b_of_type_Int += 1;
            this.jdField_c_of_type_Int += localSubAccountMessage.unreadNum;
          }
        }
      }
    }
  }
  
  public int a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorType;
        return i;
      }
      return 0;
    }
  }
  
  public int a(QQAppInterface arg1, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        return 0;
      }
    }
    paramString = a(paramString);
    if (paramString == null) {
      return 0;
    }
    int i = paramString.a().unreadNum;
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
      if (((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a() != null) {
        this.e = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a().sendername;
      }
    }
    for (this.jdField_d_of_type_JavaLangString = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a().senderuin;; this.jdField_d_of_type_JavaLangString = "")
    {
      e();
      return 0 - i;
      this.e = "";
      this.jdField_a_of_type_JavaLangCharSequence = "";
    }
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    SubAccountMessageData localSubAccountMessageData = a(paramString);
    if (localSubAccountMessageData != null)
    {
      SubAccountMessage localSubAccountMessage = localSubAccountMessageData.a();
      if (localSubAccountMessage != null)
      {
        paramString = this.jdField_a_of_type_ArrayOfByte;
        int i = j;
        try
        {
          if (localSubAccountMessage.isread)
          {
            i = j;
            if (!paramBoolean)
            {
              this.jdField_b_of_type_Int += 1;
              this.jdField_c_of_type_Int += localSubAccountMessage.unreadNum;
              i = localSubAccountMessage.unreadNum;
            }
          }
          j = i;
          if (!localSubAccountMessage.isread)
          {
            j = i;
            if (paramBoolean)
            {
              this.jdField_b_of_type_Int -= 1;
              this.jdField_c_of_type_Int -= localSubAccountMessage.unreadNum;
              j = -localSubAccountMessage.unreadNum;
            }
          }
          localSubAccountMessageData.a(paramBoolean);
          return j;
        }
        finally {}
      }
    }
    return 0;
  }
  
  public long a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      long l = this.jdField_a_of_type_Long;
      return l;
    }
  }
  
  public SubAccountInfo a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      SubAccountInfo localSubAccountInfo = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
      return localSubAccountInfo;
    }
  }
  
  public SubAccountMessageData a(String paramString)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramString != null) {}
    try
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          SubAccountMessageData localSubAccountMessageData = (SubAccountMessageData)localIterator.next();
          if ((localSubAccountMessageData != null) && (localSubAccountMessageData.a() != null) && (!TextUtils.isEmpty(localSubAccountMessageData.a().senderuin)) && (localSubAccountMessageData.a().senderuin.equals(paramString))) {
            return localSubAccountMessageData;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  public CharSequence a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
      return localCharSequence;
    }
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorMsg;
        return str;
      }
      return null;
    }
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 20)
      {
        ArrayList localArrayList1 = this.jdField_a_of_type_JavaUtilArrayList;
        return localArrayList1;
      }
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList.subList(0, 20));
    return localArrayList2;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangCharSequence = "";
      this.e = "";
      this.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_Long = 0L;
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorType = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorMsg = paramString;
      }
      return;
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_b_of_type_Long = paramLong;
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "date_format");
      if (!TextUtils.isEmpty(paramContext)) {
        jdField_a_of_type_JavaLangString = paramContext;
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String arg3, long paramLong1, boolean paramBoolean, String paramString3, int paramInt1, long paramLong2, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        ??? = a(paramString1);
        if ((??? == null) || (((SubAccountMessageData)???).a() == null)) {
          break;
        }
        paramString1 = new SubAccountMessage();
        paramString1.init(((SubAccountMessageData)???).a());
        paramString1.istroop = paramInt1;
        paramString1.msgseq = paramLong2;
        paramString1.msgtype = paramInt2;
        float f1 = paramQQAppInterface.a().getResources().getDisplayMetrics().density;
        paramString1 = new SubAccountMessageData(paramString1);
        if (paramLong1 > 0L)
        {
          paramString1.a().time = paramLong1;
          paramString1.jdField_a_of_type_JavaLangString = TimeFormatterUtils.a(1000L * paramLong1, true, jdField_a_of_type_JavaLangString);
          if (??? == null) {
            break label521;
          }
          paramString1.a().msg = ???;
          paramString1.jdField_a_of_type_JavaLangCharSequence = new QQText(???, 1, 16);
          paramString1.a(paramBoolean);
          if (!TextUtils.isEmpty(paramString3)) {
            paramString1.a().sendername = paramString3;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "updateSunAccountMessage:middle msg=" + paramString1);
          }
          synchronized (this.jdField_a_of_type_ArrayOfByte)
          {
            if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
              break label577;
            }
            if (??? == null) {
              break label583;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(???);
            break label583;
            if (paramInt1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
              break label577;
            }
            paramString3 = (SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
            if ((paramString3 == null) || (paramString3.a() == null) || (paramString3.a().time > paramString1.a().time)) {
              break label533;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, paramString1);
            paramInt1 = 1;
            if (paramInt1 == 0) {
              this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
            }
            if (paramString1.a().time > this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_Long = paramString1.a().time;
              paramString3 = paramQQAppInterface.a();
              if (!SubAccountAssistantImpl.a().b(paramQQAppInterface)) {
                break label542;
              }
              SubAccountAssistantManager.a().a(paramString3, 9223372036854775804L);
              this.jdField_b_of_type_Long = 9223372036854775804L;
              if (paramString1 != null)
              {
                this.jdField_a_of_type_JavaLangCharSequence = paramString1.jdField_a_of_type_JavaLangCharSequence;
                this.jdField_d_of_type_JavaLangString = paramString1.a().senderuin;
                this.e = paramString1.a().sendername;
                this.f = paramString1.jdField_a_of_type_JavaLangString;
              }
            }
            e();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString, 2, "updateSunAccountMessage:finish msg=" + this.jdField_a_of_type_JavaUtilArrayList);
            }
            return;
          }
        }
      }
      paramString1.jdField_a_of_type_JavaLangString = ((SubAccountMessageData)???).jdField_a_of_type_JavaLangString;
      continue;
      label521:
      paramString1.jdField_a_of_type_JavaLangCharSequence = ((SubAccountMessageData)???).jdField_a_of_type_JavaLangCharSequence;
      continue;
      label533:
      paramInt1 += 1;
      continue;
      label542:
      if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)
      {
        SubAccountAssistantManager.a().a(paramString3, this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        continue;
        label577:
        paramInt1 = 0;
        continue;
        label583:
        paramInt1 = 0;
      }
    }
  }
  
  public void a(SubAccountInfo paramSubAccountInfo)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = new SubAccountInfo();
      }
      if (paramSubAccountInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin = paramSubAccountInfo.subuin;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname = paramSubAccountInfo.subname;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.trunkuin = paramSubAccountInfo.trunkuin;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.isbind = paramSubAccountInfo.isbind;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.lasttime = paramSubAccountInfo.lasttime;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorMsg = paramSubAccountInfo.serverErrorMsg;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorType = paramSubAccountInfo.serverErrorType;
        if (paramSubAccountInfo.cookie != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.cookie = ((byte[])paramSubAccountInfo.cookie.clone());
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
    }
  }
  
  public void a(SubAccountMessage paramSubAccountMessage, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addMessage:begin msg=" + paramSubAccountMessage + " app.isBG_Pause=" + paramQQAppInterface.isBackground_Pause);
    }
    if (paramSubAccountMessage == null) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        SubAccountMessageData localSubAccountMessageData1 = new SubAccountMessageData(paramSubAccountMessage);
        localSubAccountMessageData1.jdField_a_of_type_Boolean = paramQQAppInterface.isBackground_Pause;
        localSubAccountMessageData1.jdField_a_of_type_JavaLangString = TimeFormatterUtils.a(paramSubAccountMessage.time * 1000L, true, jdField_a_of_type_JavaLangString);
        localSubAccountMessageData1.jdField_a_of_type_JavaLangCharSequence = new QQText(paramSubAccountMessage.msg, 3, 16);
        SubAccountMessageData localSubAccountMessageData2 = a(paramSubAccountMessage.senderuin);
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label461;
          }
          if (localSubAccountMessageData2 == null) {
            break label466;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(localSubAccountMessageData2);
          break label466;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label461;
          }
          localSubAccountMessageData2 = (SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localSubAccountMessageData2 != null) && (localSubAccountMessageData2.a() != null) && (localSubAccountMessageData2.a().time <= paramSubAccountMessage.time))
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(i, localSubAccountMessageData1);
            i = 1;
            if (i == 0) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localSubAccountMessageData1);
            }
            if (paramSubAccountMessage.time > this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_Long = paramSubAccountMessage.time;
              paramSubAccountMessage = paramQQAppInterface.a();
              if (!SubAccountAssistantImpl.a().b(paramQQAppInterface)) {
                break label427;
              }
              SubAccountAssistantManager.a().a(paramSubAccountMessage, 9223372036854775804L);
              this.jdField_b_of_type_Long = 9223372036854775804L;
              if (localSubAccountMessageData1 != null)
              {
                this.jdField_a_of_type_JavaLangCharSequence = localSubAccountMessageData1.jdField_a_of_type_JavaLangCharSequence;
                this.jdField_d_of_type_JavaLangString = localSubAccountMessageData1.a().senderuin;
                this.e = localSubAccountMessageData1.a().sendername;
                this.f = localSubAccountMessageData1.jdField_a_of_type_JavaLangString;
              }
            }
            e();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString, 2, "addMessage:finish allmsg=" + this.jdField_a_of_type_JavaUtilArrayList);
            }
            return;
          }
        }
      }
      i += 1;
      continue;
      label427:
      if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)
      {
        SubAccountAssistantManager.a().a(paramSubAccountMessage, this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        continue;
        label461:
        i = 0;
        continue;
        label466:
        i = 0;
      }
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (!TextUtils.isEmpty(paramString)) {
        jdField_a_of_type_JavaLangString = paramString;
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label150;
      }
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext())
      {
        SubAccountMessageData localSubAccountMessageData = (SubAccountMessageData)paramString.next();
        if ((localSubAccountMessageData != null) && (localSubAccountMessageData.a() != null)) {
          localSubAccountMessageData.jdField_a_of_type_JavaLangString = TimeFormatterUtils.a(localSubAccountMessageData.a().time * 1000L, true, jdField_a_of_type_JavaLangString);
        }
      }
    }
    if ((this.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Long != 9223372036854775804L)) {
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
    this.f = TimeFormatterUtils.a(this.jdField_a_of_type_Long * 1000L, true, jdField_a_of_type_JavaLangString);
    label150:
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramString != null) {}
    try
    {
      if ((paramString.length() == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin == null)) {
        return;
      }
      if (!paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.cookie = paramArrayOfByte;
  }
  
  public void a(List paramList, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      SubAccountMessage localSubAccountMessage;
      SubAccountMessageData localSubAccountMessageData;
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label327;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label160;
        }
        localSubAccountMessage = (SubAccountMessage)paramList.next();
        if (localSubAccountMessage == null) {
          continue;
        }
        localSubAccountMessageData = new SubAccountMessageData(localSubAccountMessage);
        localSubAccountMessageData.jdField_a_of_type_JavaLangString = "";
      }
      try
      {
        localSubAccountMessageData.jdField_a_of_type_JavaLangString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, jdField_a_of_type_JavaLangString);
        localSubAccountMessageData.jdField_a_of_type_JavaLangCharSequence = new QQText(localSubAccountMessage.msg, 3, 16);
        this.jdField_a_of_type_JavaUtilArrayList.add(localSubAccountMessageData);
        continue;
        paramList = finally;
        throw paramList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    label160:
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Gpv);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      long l = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a().time;
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        paramList = paramQQAppInterface.a();
        if (!SubAccountAssistantImpl.a().b(paramQQAppInterface)) {
          break label331;
        }
        SubAccountAssistantManager.a().a(paramList, 9223372036854775804L);
        this.jdField_b_of_type_Long = 9223372036854775804L;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
      this.jdField_d_of_type_JavaLangString = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a().senderuin;
      this.e = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a().sendername;
      this.f = ((SubAccountMessageData)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
      e();
      label327:
      return;
      label331:
      if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)
      {
        SubAccountAssistantManager.a().a(paramList, this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "changeAllMsgState:start. read = " + paramBoolean);
    }
    label271:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            Object localObject2 = (SubAccountMessageData)localIterator.next();
            if ((localObject2 == null) || (((SubAccountMessageData)localObject2).a() == null)) {
              break label271;
            }
            localObject2 = ((SubAccountMessageData)localObject2).a();
            ((SubAccountMessage)localObject2).isread = paramBoolean;
            if (paramBoolean)
            {
              ((SubAccountMessage)localObject2).unreadNum = 0;
              break label271;
            }
            i = ((SubAccountMessage)localObject2).unreadNum + i;
            break label271;
          }
          if (!paramBoolean) {
            continue;
          }
          this.jdField_b_of_type_Int = 0;
          this.jdField_c_of_type_Int = 0;
          this.jdField_d_of_type_Int = 0;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "changeAllMsgState:finish read = " + paramBoolean);
            QLog.d(jdField_b_of_type_JavaLangString, 2, "changeAllMsgState:finish msg=" + this.jdField_a_of_type_JavaUtilArrayList);
          }
        }
        return;
        int k = this.jdField_a_of_type_JavaUtilArrayList.size();
        int j = k;
        if (k > 20) {
          j = 20;
        }
        this.jdField_b_of_type_Int = j;
        this.jdField_c_of_type_Int = i;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin.equals(paramString))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
  }
  
  public long b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      long l = this.jdField_b_of_type_Long;
      return l;
    }
  }
  
  public String b()
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      String str = this.jdField_c_of_type_JavaLangString;
      return str;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = new SubAccountInfo();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin = "";
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname = "";
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.trunkuin = "";
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.isbind = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.lasttime = 0L;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.cookie = null;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorMsg = null;
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorType = 0;
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      return;
    }
  }
  
  public int c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
  }
  
  public String c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      String str = this.jdField_d_of_type_JavaLangString;
      return str;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      return;
    }
  }
  
  public void c(String paramString)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.f = paramString;
      return;
    }
  }
  
  public int d()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      int i = this.jdField_d_of_type_Int;
      return i;
    }
  }
  
  public String d()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      String str = this.e;
      return str;
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext()) {
          ((SubAccountMessageData)localIterator.next()).jdField_a_of_type_Boolean = false;
        }
      }
    }
    this.jdField_d_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "clearUnNotificationSenderNum done.");
    }
  }
  
  public String e()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      String str = this.f;
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.datamanager.SubAccountAssistantCache
 * JD-Core Version:    0.7.0.1
 */