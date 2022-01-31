package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.apkupdate.logic.protocol.jce.ApkDownUrl;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateRequest;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.apkupdate.logic.protocol.a
{
  private static String a = "CheckAppUpdateHttpRequest";
  private final List b;
  
  public a(List paramList)
  {
    this.b = paramList;
  }
  
  private static ApkUpdateDetail a(AppUpdateInfo paramAppUpdateInfo)
  {
    Object localObject3 = null;
    if (paramAppUpdateInfo != null)
    {
      ApkUpdateDetail localApkUpdateDetail = new ApkUpdateDetail();
      localApkUpdateDetail.packageName = paramAppUpdateInfo.packageName;
      localApkUpdateDetail.versionname = paramAppUpdateInfo.versionName;
      localApkUpdateDetail.versioncode = paramAppUpdateInfo.versionCode;
      Object localObject4 = paramAppUpdateInfo.apkDownUrl;
      Object localObject1;
      Object localObject2;
      int i;
      if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
      {
        localObject1 = ((ArrayList)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ApkDownUrl)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((ApkDownUrl)localObject2).type == 2)) {
              if (((ApkDownUrl)localObject2).urlList != null)
              {
                localObject1 = (String)((ApkDownUrl)localObject2).urlList.get(0);
                i = 1;
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject3;
        if (i == 0)
        {
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            if (((ArrayList)localObject4).size() > 0)
            {
              localObject4 = ((ArrayList)localObject4).iterator();
              do
              {
                localObject1 = localObject3;
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject1 = (ApkDownUrl)((Iterator)localObject4).next();
              } while ((localObject1 == null) || (((ApkDownUrl)localObject1).type != 1));
              if (((ApkDownUrl)localObject1).urlList == null) {
                break label282;
              }
              localObject1 = (String)((ApkDownUrl)localObject1).urlList.get(0);
            }
          }
        }
        label210:
        if (i != 0) {
          localApkUpdateDetail.updatemethod = 4;
        }
        for (localApkUpdateDetail.url = ((String)localObject2);; localApkUpdateDetail.url = ((String)localObject1))
        {
          localApkUpdateDetail.newapksize = ((int)paramAppUpdateInfo.fileSize);
          localApkUpdateDetail.patchsize = ((int)paramAppUpdateInfo.diffFileSize);
          localApkUpdateDetail.fileMd5 = paramAppUpdateInfo.diffApkMd5;
          localApkUpdateDetail.sigMd5 = paramAppUpdateInfo.signatureMd5;
          localApkUpdateDetail.newFeature = paramAppUpdateInfo.newFeature;
          return localApkUpdateDetail;
          localObject1 = "";
          break;
          label282:
          localObject1 = "";
          break label210;
          localApkUpdateDetail.updatemethod = 2;
        }
        localObject2 = null;
        i = 0;
      }
    }
    return null;
  }
  
  protected final void a()
  {
    super.a();
    GetAppUpdateRequest localGetAppUpdateRequest = new GetAppUpdateRequest();
    localGetAppUpdateRequest.appInfoForUpdateList = ((ArrayList)this.b);
    localGetAppUpdateRequest.flag = 0;
    a(localGetAppUpdateRequest);
  }
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    ArrayList localArrayList;
    Object localObject1;
    label151:
    Object localObject2;
    label186:
    String str1;
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof GetAppUpdateResponse)))
    {
      paramJceStruct1 = (GetAppUpdateResponse)paramJceStruct2;
      Log.i(a, "CheckAppUpdateHttpRequest:checkupdate from server; response= " + paramJceStruct1.toString());
      if (paramJceStruct1.ret != 0) {
        break label631;
      }
      localArrayList = new ArrayList();
      paramJceStruct2 = new ArrayList();
      paramJceStruct1 = paramJceStruct1.appUpdateInfoGroup;
      if ((paramJceStruct1 != null) && (paramJceStruct1.size() > 0))
      {
        paramJceStruct1 = paramJceStruct1.values();
        if ((paramJceStruct1 != null) && (paramJceStruct1.size() > 0))
        {
          paramJceStruct1 = paramJceStruct1.iterator();
          while (paramJceStruct1.hasNext())
          {
            localObject1 = (ArrayList)paramJceStruct1.next();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (AppUpdateInfo)((Iterator)localObject1).next();
                if ((((AppUpdateInfo)localObject2).flag & 0x1) != 1) {
                  break label397;
                }
                i = 1;
                if (i != 0) {
                  paramJceStruct2.add(localObject2);
                }
                localObject2 = a((AppUpdateInfo)localObject2);
                if (localObject2 != null)
                {
                  str1 = com.tencent.apkupdate.logic.protocol.b.a().b(((ApkUpdateDetail)localObject2).packageName);
                  if ((com.tencent.apkupdate.c.b.a().b() == null) || (com.tencent.apkupdate.c.b.a(com.tencent.apkupdate.c.b.a().b(), ((ApkUpdateDetail)localObject2).packageName) != ((ApkUpdateDetail)localObject2).versioncode)) {
                    break label655;
                  }
                }
              }
            }
          }
        }
      }
    }
    label397:
    label655:
    for (int i = 1;; i = 0)
    {
      if ((str1.compareToIgnoreCase(((ApkUpdateDetail)localObject2).sigMd5) != 0) || (i != 0)) {
        ((ApkUpdateDetail)localObject2).updatemethod = 1;
      }
      Log.i(a, "packageName: " + ((ApkUpdateDetail)localObject2).packageName);
      Log.i(a, "updatemethod: " + ((ApkUpdateDetail)localObject2).updatemethod);
      Log.i(a, "newapksize: " + ((ApkUpdateDetail)localObject2).newapksize);
      Log.i(a, "patchsize: " + ((ApkUpdateDetail)localObject2).patchsize);
      localArrayList.add(localObject2);
      break label151;
      break;
      i = 0;
      break label186;
      localObject1 = new ArrayList();
      int j;
      String str2;
      if (this.b != null)
      {
        localObject2 = this.b.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramJceStruct1 = (AppInfoForUpdate)((Iterator)localObject2).next();
          str1 = paramJceStruct1.packageName;
          j = paramJceStruct1.versionCode;
          str2 = paramJceStruct1.versionName;
          Iterator localIterator = localArrayList.iterator();
          String str3;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            paramJceStruct1 = (ApkUpdateDetail)localIterator.next();
            str3 = paramJceStruct1.packageName;
          } while ((str1 == null) || (str3 == null) || (!str1.equals(str3)));
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          ((ArrayList)localObject1).add(paramJceStruct1);
          break;
        }
        paramJceStruct1 = new ApkUpdateDetail();
        paramJceStruct1.packageName = str1;
        paramJceStruct1.versionname = str2;
        paramJceStruct1.versioncode = j;
        paramJceStruct1.updatemethod = 1;
        ((ArrayList)localObject1).add(paramJceStruct1);
        break;
        paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
        paramJceStruct1.what = 1;
        paramJceStruct1.obj = localObject1;
        paramJceStruct1.sendToTarget();
        if (paramJceStruct2.size() > 0)
        {
          paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
          paramJceStruct1.what = 7;
          paramJceStruct1.obj = paramJceStruct2;
          paramJceStruct1.sendToTarget();
        }
        return;
        label631:
        paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
        paramJceStruct1.what = 2;
        paramJceStruct1.sendToTarget();
        return;
        paramJceStruct1 = null;
      }
    }
  }
  
  protected final void b()
  {
    Message localMessage = com.tencent.apkupdate.logic.a.a().obtainMessage();
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.a
 * JD-Core Version:    0.7.0.1
 */