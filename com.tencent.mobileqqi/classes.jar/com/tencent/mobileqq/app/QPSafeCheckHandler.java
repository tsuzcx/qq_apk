package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.ims.safecheckPB.ReportItem;
import com.tencent.ims.safecheckPB.ReqMQScanRequest;
import com.tencent.ims.safecheckPB.RspMQScanReport;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ffa;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public class QPSafeCheckHandler
  extends BusinessHandler
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "QPSafeCheck";
  private static final int b = 1001;
  private static final int c = 1002;
  private static final int d = 1003;
  private static final int e = 1004;
  private static final int f = 1005;
  private static final int g = 1006;
  private static final int h = 1007;
  private Context jdField_a_of_type_AndroidContentContext;
  
  QPSafeCheckHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = BaseApplication.getContext();
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    int i;
    switch (NetworkCenter.a().a())
    {
    default: 
      i = 0;
    }
    while ((i & paramInt) == 0)
    {
      return false;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 8;
      continue;
      i = 16;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramString1.length() == 0) || (paramString2.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = Pattern.compile(paramString1, 2).matcher(paramString2).find();
      return bool;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject1 = this.a.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(this.a.getPackageName(), 1);
      Object localObject2 = SecUtil.a(BaseApplication.getContext());
      new String();
      localObject2 = SecUtil.b((byte[])localObject2);
      new String();
      if (paramReqMQScanRequest.string_check_target.get().equalsIgnoreCase((String)localObject2)) {
        return;
      }
      paramReqMQScanRequest = new safecheckPB.ReportItem();
      paramReqMQScanRequest.string_target_packname.set(((PackageInfo)localObject1).packageName);
      paramReqMQScanRequest.string_target_md5.set(SecUtil.a(((PackageInfo)localObject1).applicationInfo.sourceDir));
      paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
      paramRspMQScanReport.uint32_check_count.set(1);
      return;
    }
    catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = SafeCenterPushHandler.a();
    if (QLog.isColorLevel()) {
      QLog.d("QPSafeCheck", 2, "thread num = " + i);
    }
    if (i >= 1) {
      return;
    }
    new ffa(this, paramArrayOfByte).start();
  }
  
  public void b(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    paramReqMQScanRequest = this.a.getPackageManager();
    List localList = paramReqMQScanRequest.getInstalledApplications(8192);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j >= localList.size()) {
        break label129;
      }
      try
      {
        safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
        PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ApplicationInfo)localList.get(j)).packageName, 1);
        localReportItem.string_target_packname.set(localPackageInfo.packageName);
        localReportItem.string_target_md5.set(SecUtil.a(localPackageInfo.applicationInfo.sourceDir));
        paramRspMQScanReport.rpt_check_item.add(localReportItem);
        i += 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
      j += 1;
    }
    label129:
    paramRspMQScanReport.uint32_check_count.set(i);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    localObject = new safecheckPB.ReqMQScanRequest();
    localRspMQScanReport = new safecheckPB.RspMQScanReport();
    try
    {
      ((safecheckPB.ReqMQScanRequest)localObject).mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("QPSafeCheck", 2, "Check Item" + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_uid.get() + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.get() + ((safecheckPB.ReqMQScanRequest)localObject).string_check_target.get() + ((safecheckPB.ReqMQScanRequest)localObject).string_check_parameters.get() + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get());
      }
      if (!a(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get()))
      {
        SafeCenterPushHandler.b();
        return;
      }
      if (!((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.has()) {
        break label581;
      }
      i = ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.get();
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QPSafeCheck", 2, "RspBody parseFrom byte InvalidProtocolBufferMicroException");
        }
        paramArrayOfByte.printStackTrace();
        continue;
        b((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
        continue;
        c((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
        continue;
        e((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
        continue;
        f((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
        continue;
        d((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
        continue;
        int i = 0;
        paramArrayOfByte = new safecheckPB.RspMQScanReport();
        if (localRspMQScanReport.uint32_check_count.get() > 48)
        {
          paramArrayOfByte.uint32_check_count.set(48);
          paramArrayOfByte.uint32_check_uid.set(localRspMQScanReport.uint32_check_uid.get());
          localObject = new ArrayList();
          j = 0;
          while (j < 48)
          {
            ((List)localObject).add(localRspMQScanReport.rpt_check_item.get(0));
            localRspMQScanReport.rpt_check_item.remove(0);
            j += 1;
          }
          paramArrayOfByte.rpt_check_item.set((List)localObject);
          j = localRspMQScanReport.uint32_check_count.get();
          localRspMQScanReport.uint32_check_count.set(j - 48);
          localObject = a("SecSafeChkSvc.MainCmd");
          ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
          b((ToServiceMsg)localObject);
        }
        for (int j = i;; j = 1)
        {
          i = j;
          if (j == 0) {
            break;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("QPSafeCheck", 2, "check uid = " + localRspMQScanReport.uint32_check_uid.get());
            QLog.d("QPSafeCheck", 2, "check count = " + localRspMQScanReport.uint32_check_count.get());
          }
          SafeCenterPushHandler.b();
          return;
          paramArrayOfByte = a("SecSafeChkSvc.MainCmd");
          paramArrayOfByte.putWupBuffer(localRspMQScanReport.toByteArray());
          b(paramArrayOfByte);
        }
        i = 0;
      }
    }
    localRspMQScanReport.uint32_check_uid.set(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_uid.get());
    localRspMQScanReport.uint32_check_count.set(0);
    switch (i)
    {
    case 1003: 
    default: 
    case 1001: 
      while (!a(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get()))
      {
        SafeCenterPushHandler.b();
        return;
        a((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
      }
    }
  }
  
  public void c(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    List localList = this.a.getPackageManager().getInstalledApplications(8192);
    int i = 0;
    if (i < localList.size())
    {
      if ((ApplicationInfo)localList.get(i) == null) {}
      String str;
      do
      {
        i += 1;
        break;
        str = ((ApplicationInfo)localList.get(i)).processName;
      } while ((str == null) || (!a(paramReqMQScanRequest.string_check_target.get(), str)));
      paramReqMQScanRequest = new safecheckPB.ReportItem();
      paramReqMQScanRequest.string_target_packname.set(((ApplicationInfo)localList.get(i)).packageName);
      paramReqMQScanRequest.string_target_md5.set(SecUtil.a(((ApplicationInfo)localList.get(i)).sourceDir));
      paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
      paramRspMQScanReport.uint32_check_count.set(1);
    }
    SafeCenterPushHandler.b();
  }
  
  public void d(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject1 = this.a.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(this.a.getPackageName(), 1);
      Object localObject2 = new ZipFile(((PackageInfo)localObject1).applicationInfo.sourceDir);
      localObject2 = ((ZipFile)localObject2).getInputStream(((ZipFile)localObject2).getEntry("AndroidManifest.xml"));
      byte[] arrayOfByte = new byte[8192];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = ((InputStream)localObject2).read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
      do
      {
        return;
        localObject2 = SecUtil.a(localMessageDigest.digest());
        new String();
      } while (paramReqMQScanRequest.string_check_target.get().equalsIgnoreCase((String)localObject2));
      paramRspMQScanReport.uint32_check_uid.set(paramReqMQScanRequest.uint32_check_uid.get());
      paramRspMQScanReport.uint32_check_count.set(1);
      paramReqMQScanRequest = new safecheckPB.ReportItem();
      paramReqMQScanRequest.string_target_packname.set(((PackageInfo)localObject1).packageName);
      paramReqMQScanRequest.string_target_md5.set((String)localObject2);
      paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
      return;
    }
    catch (NoSuchAlgorithmException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
      return;
    }
    catch (IOException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
    }
  }
  
  public void e(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    Object localObject2 = (ActivityManager)this.a.getSystemService("activity");
    Object localObject1 = this.a.getPackageManager();
    localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
    for (;;)
    {
      if ((i >= ((List)localObject2).size()) || (a(paramReqMQScanRequest.string_check_target.get(), ((ActivityManager.RunningAppProcessInfo)((List)localObject2).get(i)).processName))) {
        try
        {
          paramReqMQScanRequest = ((PackageManager)localObject1).getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject2.get(i)).pkgList[0], 1);
          localObject1 = new safecheckPB.ReportItem();
          ((safecheckPB.ReportItem)localObject1).string_target_packname.set(paramReqMQScanRequest.packageName);
          ((safecheckPB.ReportItem)localObject1).string_target_md5.set(SecUtil.a(paramReqMQScanRequest.applicationInfo.sourceDir));
          paramRspMQScanReport.rpt_check_item.add((MessageMicro)localObject1);
          paramRspMQScanReport.uint32_check_count.set(1);
          return;
        }
        catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
        {
          paramReqMQScanRequest.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void f(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    Object localObject = (ActivityManager)this.a.getSystemService("activity");
    paramReqMQScanRequest = this.a.getPackageManager();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    int j = 0;
    for (;;)
    {
      if (j >= ((List)localObject).size()) {
        break label144;
      }
      try
      {
        safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
        PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject.get(j)).pkgList[0], 1);
        localReportItem.string_target_packname.set(localPackageInfo.packageName);
        localReportItem.string_target_md5.set(SecUtil.a(localPackageInfo.applicationInfo.sourceDir));
        paramRspMQScanReport.rpt_check_item.add(localReportItem);
        i += 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
      j += 1;
    }
    label144:
    paramRspMQScanReport.uint32_check_count.set(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QPSafeCheckHandler
 * JD-Core Version:    0.7.0.1
 */