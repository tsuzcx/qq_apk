package com.tencent.mobileqq.transfile;

import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import gnv;
import java.util.ArrayList;
import java.util.Iterator;

public class SosoSrvAddrProvider
{
  public static int a = 0;
  private static SosoSrvAddrProvider jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider;
  public static final String a;
  public static int b = jdField_a_of_type_Int + 1;
  public static final String b = "com.tencent.receiver.soso";
  public static final String c = "com.tencent.receiver.soso.type";
  private FileStoragePushFSSvcList jdField_a_of_type_ConfigPushFileStoragePushFSSvcList;
  Application jdField_a_of_type_AndroidAppApplication;
  gnv jdField_a_of_type_Gnv = new gnv(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = SosoSrvAddrProvider.class.getSimpleName();
    jdField_a_of_type_Int = 0;
  }
  
  private SosoSrvAddrProvider(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  public static SosoSrvAddrProvider a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider == null) {
        jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider = new SosoSrvAddrProvider(BaseApplicationImpl.a());
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider;
    }
    finally {}
  }
  
  private ArrayList a(SosoSrvAddrProvider.SosoSrvAddrType paramSosoSrvAddrType)
  {
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (paramSosoSrvAddrType == SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV)) {
      return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUrlEncodeServiceList;
    }
    return null;
  }
  
  public String a(SosoSrvAddrProvider.SosoSrvAddrType paramSosoSrvAddrType)
  {
    Object localObject = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Gnv.a(paramSosoSrvAddrType);
      paramSosoSrvAddrType = localObject;
      if (localFileStorageServerListInfo != null) {
        paramSosoSrvAddrType = "http://" + localFileStorageServerListInfo.sIP + ":" + localFileStorageServerListInfo.iPort + "/";
      }
      return paramSosoSrvAddrType;
    }
    finally {}
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_AndroidAppApplication;
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((Application)localObject).getSharedPreferences("SosoSrvAddrList", i).getString("SosoSrvAddrList_key", null);
      if (localObject == null) {
        return localArrayList;
      }
      localObject = ((String)localObject).split("\\|");
      i = 0;
      label52:
      if (i >= localObject.length) {
        return localArrayList;
      }
      String[] arrayOfString = localObject[i].split("\\:");
      if (arrayOfString.length != 2) {
        break label127;
      }
      FileStorageServerListInfo localFileStorageServerListInfo = new FileStorageServerListInfo();
      localFileStorageServerListInfo.sIP = arrayOfString[0];
      localFileStorageServerListInfo.iPort = Integer.valueOf(arrayOfString[1]).intValue();
      localArrayList.add(localFileStorageServerListInfo);
    }
    for (;;)
    {
      i += 1;
      break label52;
      i = 0;
      break;
      label127:
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "ip info datais error,please check the push ipList data");
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    try
    {
      a(null);
      this.jdField_a_of_type_Gnv.a();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "FMT SERVER LIST CLEARED!!!");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = paramFileStoragePushFSSvcList;
      this.jdField_a_of_type_Gnv.a(paramFileStoragePushFSSvcList);
      return;
    }
    finally
    {
      paramFileStoragePushFSSvcList = finally;
      throw paramFileStoragePushFSSvcList;
    }
  }
  
  public void a(SosoSrvAddrProvider.SosoSrvAddrType paramSosoSrvAddrType, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Gnv.a(paramSosoSrvAddrType, paramString);
      return;
    }
    finally
    {
      paramSosoSrvAddrType = finally;
      throw paramSosoSrvAddrType;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppApplication;
    if (Build.VERSION.SDK_INT > 10) {}
    StringBuilder localStringBuilder;
    for (int i = 4;; i = 0)
    {
      localObject = ((Application)localObject).getSharedPreferences("SosoSrvAddrList", i);
      if (paramArrayList == null) {
        return;
      }
      localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)paramArrayList.next();
        localStringBuilder.append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append("|");
      }
    }
    ((SharedPreferences)localObject).edit().putString("SosoSrvAddrList_key", localStringBuilder.toString()).commit();
    paramArrayList = new Intent("com.tencent.receiver.soso");
    paramArrayList.putExtra("com.tencent.receiver.soso.type", jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(paramArrayList);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppApplication.getSharedPreferences("SosoSrvAddrList", 0).edit().putString("SosoSrvAddrList_key", null).commit();
    Intent localIntent = new Intent("com.tencent.receiver.soso");
    localIntent.putExtra("com.tencent.receiver.soso.type", b);
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(localIntent);
  }
  
  public void c()
  {
    ArrayList localArrayList = a();
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
    localFileStoragePushFSSvcList.vUrlEncodeServiceList = localArrayList;
    a(localFileStoragePushFSSvcList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SosoSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */