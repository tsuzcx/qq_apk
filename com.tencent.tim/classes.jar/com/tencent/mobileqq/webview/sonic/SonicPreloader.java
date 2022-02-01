package com.tencent.mobileqq.webview.sonic;

import android.text.TextUtils;
import android.util.SparseArray;
import aqiw;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SonicPreloader
{
  public static final int SONIC_PRELOAD_ID_GAME_CENTER = 1002;
  public static final int SONIC_PRELOAD_ID_GXH = 1001;
  public static final int SONIC_PRELOAD_ID_VIP = 1000;
  public static final int SONIC_PRELOAD_ID_VIRTUAL = 0;
  public static final String TAG = "SonicPreload";
  public static final List<Integer> preloadIdList = new ArrayList();
  
  static
  {
    preloadIdList.add(Integer.valueOf(0));
    preloadIdList.add(Integer.valueOf(1002));
    preloadIdList.add(Integer.valueOf(1001));
    preloadIdList.add(Integer.valueOf(1000));
  }
  
  public static SparseArray<SonicPreloadData> getSonicPreloadDataList(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if ((paramAppInfo == null) || (paramAppInfo.iNewFlag.get() == 0) || (!preloadIdList.contains(Integer.valueOf(paramInt)))) {
      return null;
    }
    Object localObject1 = paramAppInfo.buffer.get();
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("null".equals(localObject1))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SonicPreload", 2, "getSonicPreloadDataList : preloadBusinessId = " + paramInt);
    }
    long l1 = paramAppInfo.preload_ts.get();
    if (paramInt == 0) {
      l1 = 0L;
    }
    for (;;)
    {
      SparseArray localSparseArray;
      int i;
      int j;
      JSONObject localJSONObject;
      int m;
      long l2;
      try
      {
        paramAppInfo = new JSONObject((String)localObject1).optJSONObject("msg");
        if (paramAppInfo == null) {
          return null;
        }
        localObject1 = paramAppInfo.names();
        int k = ((JSONArray)localObject1).length();
        localSparseArray = new SparseArray();
        i = 0;
        if (i >= k) {
          break label398;
        }
        Object localObject2 = paramAppInfo.getJSONObject(((JSONArray)localObject1).getString(i)).getString("extinfo");
        if (QLog.isColorLevel()) {
          QLog.d("SonicPreload", 2, "getSonicPreloadDataList : extInfo = " + (String)localObject2);
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label404;
        }
        localObject2 = new JSONObject((String)localObject2).optJSONArray("preload");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label404;
        }
        j = 0;
        if (j >= ((JSONArray)localObject2).length()) {
          break label404;
        }
        localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
        m = localJSONObject.optInt("id");
        l2 = localJSONObject.optLong("templateChangeTime", -1L);
        if (l2 >= l1) {
          break label418;
        }
      }
      catch (Exception paramAppInfo)
      {
        label298:
        SonicPreloadData localSonicPreloadData;
        QLog.e("SonicPreload", 1, "preloadSonicSession exception", paramAppInfo);
        return null;
      }
      if (localSparseArray.indexOfKey(m) > 0)
      {
        localSonicPreloadData = (SonicPreloadData)localSparseArray.get(m);
        if (localSonicPreloadData.templateChangeTime < l2)
        {
          localSonicPreloadData.templateChangeTime = l2;
          localSonicPreloadData.noCacheFilePreloadType = localJSONObject.optInt("preloadType", 0);
        }
      }
      else
      {
        localSparseArray.put(m, new SonicPreloadData(m, "", true, l2, localJSONObject.optInt("preloadType", 0)));
        break label411;
        label398:
        return localSparseArray;
        continue;
        label404:
        i += 1;
        continue;
      }
      label411:
      label418:
      do
      {
        j += 1;
        break;
        if (paramInt == 0) {
          break label298;
        }
      } while (m != paramInt);
    }
  }
  
  public static boolean isWifiOrG3OrG4()
  {
    int i = aqiw.getSystemNetwork(BaseApplication.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("SonicPreload", 2, "isWifiOrG3OrG4 netType = " + i);
    }
    return (i == 1) || (i == 3) || (i == 4);
  }
  
  public static boolean preload(List<SonicPreloadData> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return false;
    }
    if (!isWifiOrG3OrG4())
    {
      QLog.e("SonicPreload", 1, "preload net type not wifi or 3g or 4g ");
      return false;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      SonicPreloadData localSonicPreloadData = (SonicPreloadData)localIterator.next();
      boolean bool2 = bool1;
      if (localSonicPreloadData != null)
      {
        paramList = localSonicPreloadData.url;
        if (TextUtils.isEmpty(paramList)) {
          continue;
        }
        if (!paramList.contains("?")) {
          break label211;
        }
      }
      label211:
      for (paramList = paramList + "&_sonic_rp=1";; paramList = paramList + "?_sonic_rp=1")
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
        if (localSonicEngine != null) {
          bool1 = localSonicEngine.preCreateSession(paramList, localBuilder.build(), localSonicPreloadData.templateChangeTime, localSonicPreloadData.noCacheFilePreloadType);
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("SonicPreload", 2, "preload: url = " + paramList + ",result = " + bool1);
          bool2 = bool1;
        }
        bool1 = bool2;
        break;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicPreloader
 * JD-Core Version:    0.7.0.1
 */