package com.tencent.mobileqq.utils.pathtracker;

import QQService.EVIPSPEC;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import ewn;
import ewo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import mqq.app.AppRuntime;

public class VipPathTracker
{
  private static final int jdField_a_of_type_Int = 1000;
  private static VipPathTracker jdField_a_of_type_ComTencentMobileqqUtilsPathtrackerVipPathTracker = new VipPathTracker();
  public static final String a = "PathTrack";
  private static final int b = 10;
  public static final String b = "TRaCK";
  private static final int jdField_c_of_type_Int = 64;
  private static final String jdField_c_of_type_JavaLangString = "PATH_TRACK";
  private volatile Boolean jdField_a_of_type_JavaLangBoolean = null;
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private int d = -1;
  private int e = 0;
  
  public static VipPathTracker a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilsPathtrackerVipPathTracker;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    while ((this.jdField_a_of_type_JavaUtilStack.size() > 0) && (((ewo)this.jdField_a_of_type_JavaUtilStack.peek()).d != 0)) {
      c();
    }
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      if (!paramBoolean) {
        break label97;
      }
      i = this.jdField_a_of_type_JavaUtilStack.size() - 1;
      if (i >= 0)
      {
        if (((ewo)this.jdField_a_of_type_JavaUtilStack.get(i)).c != paramInt) {
          break label90;
        }
        this.jdField_a_of_type_JavaUtilStack.remove(i);
      }
    }
    label90:
    label97:
    while (((ewo)this.jdField_a_of_type_JavaUtilStack.peek()).c != paramInt) {
      for (;;)
      {
        int i;
        return;
        i -= 1;
      }
    }
    c();
  }
  
  private void a(AppInterface paramAppInterface)
  {
    int m = 16;
    if (paramAppInterface == null)
    {
      paramAppInterface = BaseApplicationImpl.a();
      if (paramAppInterface != null) {}
    }
    label171:
    label176:
    label182:
    label188:
    label217:
    for (;;)
    {
      return;
      paramAppInterface = (AppInterface)paramAppInterface.a();
      for (;;)
      {
        if (paramAppInterface == null) {
          break label217;
        }
        String str = paramAppInterface.a();
        if (str == null) {
          break;
        }
        paramAppInterface = (FriendsManagerImp)paramAppInterface.getManager(8);
        if (paramAppInterface == null) {
          break;
        }
        paramAppInterface = paramAppInterface.c(str);
        if (paramAppInterface == null) {
          break;
        }
        int i;
        int j;
        label89:
        int k;
        if (paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
        {
          i = 1;
          if (!paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label171;
          }
          j = 2;
          if (paramAppInterface.getServiceType(EVIPSPEC.E_SP_QQVIP) != 1) {
            break label176;
          }
          k = 16;
          label104:
          if (paramAppInterface.getServiceType(EVIPSPEC.E_SP_SUPERVIP) != 1) {
            break label182;
          }
          label115:
          i = k | 0x0 | i | j | m;
          if (-1 == this.d)
          {
            if ((i & 0x2) == 0) {
              break label188;
            }
            this.d = paramAppInterface.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          }
        }
        for (;;)
        {
          this.e = (i | this.d << 8);
          return;
          i = 0;
          break;
          j = 0;
          break label89;
          k = 0;
          break label104;
          m = 0;
          break label115;
          if ((i & 0x1) != 0) {
            this.d = paramAppInterface.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          } else {
            this.d = 0;
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    a(paramQQAppInterface);
    int i = this.e;
    if (paramString2 != null) {}
    for (String str = paramString2;; str = "")
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Vip", "", "TRaCK", "", i, paramInt, "", "", paramString1, str);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("path=").append(paramString1).append("\t\t\tPayResult=").append(paramInt).append("\tAID=").append(paramString2);
      paramQQAppInterface = paramQQAppInterface.toString();
      if (QLog.isDevelopLevel()) {
        QLog.i("PATH_TRACK", 4, paramQQAppInterface);
      }
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
      return false;
    }
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      if ((((ewo)this.jdField_a_of_type_JavaUtilStack.peek()).d == 2) && (2 == paramInt1) && (((ewo)this.jdField_a_of_type_JavaUtilStack.peek()).c == paramInt2)) {
        return true;
      }
      if (this.jdField_a_of_type_JavaUtilStack.size() >= 64) {
        this.jdField_a_of_type_JavaUtilStack.clear();
      }
    }
    this.jdField_a_of_type_JavaUtilStack.push(new ewo(this, paramInt1, paramInt2, paramBoolean));
    return true;
  }
  
  private ewo c()
  {
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
      return (ewo)this.jdField_a_of_type_JavaUtilStack.pop();
    }
    return null;
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_JavaUtilStack.size();
    if (i > 1)
    {
      i -= 2;
      while (i >= 0)
      {
        int j = ((ewo)this.jdField_a_of_type_JavaUtilStack.get(i)).c;
        if (-1 != j) {
          return j;
        }
        i -= 1;
      }
    }
    return 0;
  }
  
  public ewo a()
  {
    return b();
  }
  
  public String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = this.jdField_a_of_type_JavaUtilStack.size() - 1;
    int i = 0;
    int j = 0;
    if ((k >= 0) && (j < 10))
    {
      ewo localewo = (ewo)this.jdField_a_of_type_JavaUtilStack.get(k);
      if (localewo.c == -1) {
        break label167;
      }
      if (localewo.c <= 1000)
      {
        localStringBuilder.insert(0, String.valueOf(localewo.c)).insert(0, ">");
        label90:
        j += 1;
      }
    }
    label167:
    for (;;)
    {
      k -= 1;
      break;
      localStringBuilder.insert(0, String.valueOf(0)).insert(0, ">");
      i += 1;
      break label90;
      if ((paramBoolean) && ((j <= 1) || (i >= j - 1))) {
        return "";
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(0);
      }
      return localStringBuilder.toString();
    }
  }
  
  public void a(int paramInt)
  {
    if (-1 == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, paramInt, bool);
      return;
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      ewo localewo = (ewo)this.jdField_a_of_type_JavaUtilStack.peek();
      if ((paramArrayOfInt != null) && (Arrays.binarySearch(paramArrayOfInt, localewo.c) >= 0) && (paramInt != localewo.c)) {
        localewo.c = paramInt;
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      a(paramBaseActivity.getPathNodeID());
    }
  }
  
  public void a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity != null)
    {
      a(paramBaseActivity.app, null, 0);
      a(paramBaseActivity.getPathNodeID(), paramBoolean);
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return a(2, paramInt, paramBoolean);
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    return a(paramAppRuntime, null, 0);
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangBoolean == null) && ((paramAppRuntime instanceof QQAppInterface))) {
      ThreadManager.a().post(new ewn(this, paramAppRuntime));
    }
    String str;
    if ((!this.jdField_a_of_type_JavaUtilStack.isEmpty()) && (!((ewo)this.jdField_a_of_type_JavaUtilStack.peek()).a))
    {
      str = a(true);
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        break label131;
      }
    }
    label131:
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      a(paramAppRuntime, str, paramString, paramInt);
      paramAppRuntime = this.jdField_a_of_type_JavaUtilStack.iterator();
      while (paramAppRuntime.hasNext()) {
        ((ewo)paramAppRuntime.next()).a = true;
      }
      return true;
      return false;
    }
  }
  
  public ewo b()
  {
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      a(null, null, 0);
      if (((ewo)this.jdField_a_of_type_JavaUtilStack.peek()).d == 2) {
        return c();
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    a(null, null, 0);
    a(paramInt, false);
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      a(paramBaseActivity, false);
    }
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      a(paramBaseActivity, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.pathtracker.VipPathTracker
 * JD-Core Version:    0.7.0.1
 */