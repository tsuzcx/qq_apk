package com.tencent.mobileqq.redtouch;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchManager
  extends Observable
  implements Manager
{
  public static final int a = 0;
  public static final String a = "RedTouchSvc.ClientReport";
  public static final int b = 1;
  public static final String b = "RedTouchSvc.EntranceSetting";
  public static final int c = 2;
  private static final String c = "RedPointManage";
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  private AppInterface a;
  
  public RedTouchManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      a("input path is empty");
    }
    do
    {
      return -1;
      if (!paramString.contains(".")) {
        break;
      }
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    int i;
    try
    {
      i = Integer.parseInt(paramString[(paramString.length - 1)]);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private BusinessInfoCheckUpdate.TimeRspBody a()
  {
    Object localObject = new File(this.a.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.a.a());
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      a("BusinessInfoCheckUpdateItem pb file does not exist");
      return null;
    }
    try
    {
      localObject = FileUtils.a((File)localObject);
      if (localObject == null)
      {
        a("Can not translate BusinessInfoCheckUpdateItem pb file to byte");
        return null;
      }
    }
    finally {}
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    try
    {
      localTimeRspBody.mergeFrom(arrayOfByte);
      return localTimeRspBody;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.a.a(), paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
      localReportReqBody.uin.set(Long.parseLong(this.a.a()));
      localReportReqBody.clientver.set("6.0.0.6500");
      localReportReqBody.platid.set(109);
      localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
      localReportReqBody.buffer.set(paramJSONObject.toString());
      if (paramAppInfo != null)
      {
        localReportReqBody.appid.set(a(paramAppInfo.path.get()));
        if (paramAppInfo.missions.has()) {
          localReportReqBody.missionid.set(paramAppInfo.missions.get());
        }
      }
      paramAppInfo = a("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      a(paramAppInfo);
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!(this.a instanceof QQAppInterface))) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    ((QQAppInterface)this.a).a(paramToServiceMsg);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointManage", 2, paramString);
    }
  }
  
  private boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    try
    {
      boolean bool = FileUtils.a(new File(this.a.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.a.a()).getAbsolutePath(), paramTimeRspBody.toByteArray(), false);
      return bool;
    }
    finally
    {
      paramTimeRspBody = finally;
      throw paramTimeRspBody;
    }
  }
  
  private BusinessInfoCheckUpdate.AppInfo b(String paramString)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    return localAppInfo;
  }
  
  public int a(int paramInt, boolean paramBoolean, long paramLong)
  {
    BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
    localAppSetting.appid.set(paramInt);
    localAppSetting.setting.set(paramBoolean);
    localAppSetting.modify_ts.set(paramLong);
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
    if ((localTimeRspBody != null) && (localTimeRspBody.has()) && (localTimeRspBody.rptSetting.has()))
    {
      List localList = localTimeRspBody.rptSetting.get();
      int j = localList.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          if (paramInt == ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)localList.get(i)).get()).appid.get()) {
            localList.set(i, localAppSetting);
          }
        }
        else
        {
          if (i == j) {
            localList.add(localAppSetting);
          }
          if (a(localTimeRspBody)) {
            break;
          }
          return -4;
        }
        i += 1;
      }
    }
    localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    localTimeRspBody.rptSetting.add(localAppSetting);
    if (!a(localTimeRspBody)) {
      return -4;
    }
    return 0;
  }
  
  public int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.path.has()))
    {
      a("updateAppInfo failed , appInfo is empty or appInfo path is null");
      return -3;
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
    if ((!localTimeRspBody.has()) || (!localTimeRspBody.rptMsgAppInfo.has()))
    {
      a("updateAppInfo failed,TimeRspBody is Empty");
      return -3;
    }
    List localList = localTimeRspBody.rptMsgAppInfo.get();
    int j = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (paramAppInfo.path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localList.get(i)).path.get()))
        {
          a("path is same = " + paramAppInfo.path);
          localList.set(i, paramAppInfo);
        }
      }
      else
      {
        if (i != j) {
          break;
        }
        return -3;
      }
      i += 1;
    }
    if (!a(localTimeRspBody)) {
      return -4;
    }
    return 0;
  }
  
  public RedTouchInfo a()
  {
    return a(0);
  }
  
  public RedTouchInfo a(int paramInt)
  {
    List localList1 = a(paramInt);
    if ((localList1 == null) || (localList1.size() == 0)) {
      return RedTouchInfo.a();
    }
    List localList2 = c();
    RedTouchInfo localRedTouchInfo = new RedTouchInfo();
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    paramInt = 0;
    if (m < localList1.size())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList1.get(m);
      int n;
      int i1;
      if (999999 != localAppInfo.uiAppId.get()) {
        if (localAppInfo.path.get().contains("."))
        {
          n = k;
          i1 = j;
          k = paramInt;
          j = i;
          i = i1;
          paramInt = n;
        }
      }
      for (;;)
      {
        m += 1;
        n = k;
        i1 = j;
        k = paramInt;
        j = i;
        i = i1;
        paramInt = n;
        break;
        if (localAppInfo.iNewFlag.get() != 1)
        {
          n = i;
          i1 = paramInt;
          paramInt = k;
          i = j;
          j = n;
          k = i1;
        }
        else
        {
          n = 0;
          for (;;)
          {
            if ((n >= localList2.size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(n)).appid.get()))
            {
              if ((n >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(n)).setting.get())) {
                break label294;
              }
              n = i;
              i1 = paramInt;
              paramInt = k;
              i = j;
              j = n;
              k = i1;
              break;
            }
            n += 1;
          }
          label294:
          switch (localAppInfo.type.get())
          {
          default: 
            n = i;
            i1 = paramInt;
            paramInt = k;
            i = j;
            j = n;
            k = i1;
            break;
          case 1: 
            n = i;
            i1 = paramInt + 1;
            paramInt = k;
            i = j;
            j = n;
            k = i1;
            break;
          case 0: 
            i1 = i + 1;
            n = paramInt;
            paramInt = k;
            i = j;
            j = i1;
            k = n;
            break;
          case 3: 
            i1 = k + 1;
            k = i;
            n = paramInt;
            paramInt = i1;
            i = j;
            j = k;
            k = n;
            break;
          case 2: 
            n = localAppInfo.num.get();
            i1 = j + n;
            j = i;
            n = paramInt;
            paramInt = k;
            i = i1;
            k = n;
          }
        }
      }
    }
    localRedTouchInfo.g = paramInt;
    localRedTouchInfo.f = i;
    localRedTouchInfo.h = j;
    localRedTouchInfo.i = k;
    return localRedTouchInfo;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    Object localObject = a();
    if ((localObject == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptMsgAppInfo.has()))
    {
      a("TimeRspBody is Empty or msgAppInfo is Empty");
      return b(paramString);
    }
    localObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptMsgAppInfo.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
      if (localAppInfo.path.get().equals(paramString)) {
        return localAppInfo;
      }
    }
    return b(paramString);
  }
  
  public String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInfo == null))
    {
      a("url is empty or appInfo is Empty");
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    paramString.append("&status=").append(paramAppInfo.type.get()).append("&number=").append(paramAppInfo.num.get()).append("&path=").append(paramAppInfo.path.get());
    return paramString.toString();
  }
  
  public List a()
  {
    a("getLebaAppInfoList");
    return a(0);
  }
  
  public List a(int paramInt)
  {
    Object localObject1 = a();
    if ((localObject1 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())) {
      return new ArrayList();
    }
    Object localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
      if (localAppInfo.appset.get() == paramInt) {
        ((List)localObject1).add(localAppInfo);
      }
    }
    return localObject1;
  }
  
  public List a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = a(paramAppInfo);
    ArrayList localArrayList;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localArrayList = new ArrayList();
      try
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (JSONObject)((Map.Entry)localObject2).getValue();
          if ((str != null) && (localObject2 != null) && (((JSONObject)localObject2).has("blue_bar_stat")))
          {
            VipBannerInfo localVipBannerInfo = new VipBannerInfo();
            localVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
            localVipBannerInfo.f = ((JSONObject)localObject2).getInt("blue_bar_stat");
            localVipBannerInfo.b = ((JSONObject)localObject2).getString("blue_content");
            localVipBannerInfo.e = ((JSONObject)localObject2).getInt("blue_type");
            localVipBannerInfo.jdField_a_of_type_JavaLangString = str;
            localVipBannerInfo.jdField_a_of_type_Long = (((JSONObject)localObject2).getLong("duration") * 1000L);
            localVipBannerInfo.c = ((JSONObject)localObject2).getString("blue_aid");
            localArrayList.add(localVipBannerInfo);
            continue;
            return null;
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public Map a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      Object localObject = paramAppInfo.buffer.get();
      if (!StringUtil.b((String)localObject)) {
        try
        {
          paramAppInfo = new HashMap();
          localObject = new JSONObject((String)localObject).getJSONObject("msg");
          Iterator localIterator = ((JSONObject)localObject).keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!StringUtil.b(str))
            {
              JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject(str);
              if (localJSONObject != null)
              {
                paramAppInfo.put(str, localJSONObject);
                continue;
                return null;
              }
            }
          }
        }
        catch (JSONException paramAppInfo)
        {
          paramAppInfo.printStackTrace();
        }
      }
    }
    return paramAppInfo;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      a("onReportRedPointExposure Failed:tabIndex's value is wrong");
      return;
    }
    a("onReportRedPointExposure");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", 1);
      localJSONObject.put("appset", paramInt);
      a(null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.path.has()))
    {
      a("onReportRedTouchFailed:appInfo or path is null");
      return;
    }
    a("onReportRedTouch");
    setChanged();
    notifyObservers(paramAppInfo);
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.a.a()));
    localReportReqBody.clientver.set("6.0.0.6500");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(a(paramAppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    if (paramAppInfo.missions.has()) {
      localReportReqBody.missionid.set(paramAppInfo.missions.get());
    }
    paramAppInfo = a("RedTouchSvc.ClientReport");
    paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
    a(paramAppInfo);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (StringUtil.b((String)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("msg").getJSONObject(paramString);
      if (localJSONObject != null)
      {
        localJSONObject.put("blue_bar_stat", 2);
        paramAppInfo.buffer.set(((JSONObject)localObject).toString());
        a(paramAppInfo);
        a(paramAppInfo, paramString, 2);
      }
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, int paramInt)
  {
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointManage", 2, "onReportRenewBannerExposure");
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      a(paramAppInfo, localJSONObject);
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    BusinessInfoCheckUpdateItem.a(this.a, paramString, paramBoolean);
  }
  
  public void a(int[] paramArrayOfInt, RedTouchManager.BannerInfoHandler paramBannerInfoHandler)
  {
    if ((paramArrayOfInt == null) || (paramBannerInfoHandler == null)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = a(paramArrayOfInt[i]);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          Object localObject2;
          do
          {
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = a((BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject1).next());
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
          } while (!paramBannerInfoHandler.a((VipBannerInfo)((Iterator)localObject2).next()));
          return;
        }
        i += 1;
      }
    }
  }
  
  public RedTouchInfo b()
  {
    return a(1);
  }
  
  public List b()
  {
    a("getSettingAppInfoList");
    return a(1);
  }
  
  public void b(int paramInt)
  {
    RedTouchInfo localRedTouchInfo = null;
    if (paramInt == 34) {
      localRedTouchInfo = a();
    }
    int i;
    int j;
    int k;
    do
    {
      while (localRedTouchInfo == null)
      {
        return;
        if (paramInt == 35) {
          localRedTouchInfo = b();
        }
      }
      i = localRedTouchInfo.g;
      j = localRedTouchInfo.f;
      k = localRedTouchInfo.i;
    } while (localRedTouchInfo.h + (i + j + k) <= 0);
    switch (paramInt)
    {
    default: 
      return;
    case 34: 
      a(0);
      return;
    }
    a(1);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    a(paramString, false);
    a(a(paramString));
  }
  
  public List c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a();
    if ((localObject == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptSetting.has())) {}
    do
    {
      return localArrayList;
      localObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptSetting.get();
    } while (localObject == null);
    localArrayList.addAll((Collection)localObject);
    return localArrayList;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager
 * JD-Core Version:    0.7.0.1
 */