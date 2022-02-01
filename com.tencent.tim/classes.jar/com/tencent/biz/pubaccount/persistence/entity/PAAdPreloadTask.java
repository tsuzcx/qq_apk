package com.tencent.biz.pubaccount.persistence.entity;

import android.text.TextUtils;
import aqiw;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PAAdPreloadTask
  extends Entity
{
  public static final int NETWORK_TYPE_4G = 2;
  public static final int NETWORK_TYPE_NONE = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  public static final int PRELOAD_STATE_FAILED = 4;
  public static final int PRELOAD_STATE_FINISH = 3;
  public static final int PRELOAD_STATE_LOADING = 2;
  public static final int PRELOAD_STATE_NEW = 1;
  public static final int SOURCE_PRELOAD_CONFIG = 1;
  public static final int SOURCE_PRELOAD_MESSAGE = 2;
  public static final int SOURCE_PRELOAD_PLAY = 3;
  public static final String TABLE_NAME = PAAdPreloadTask.class.getSimpleName();
  public long mExpireTime;
  public String mMsgId;
  public int mNetworkType = 1;
  public int mPreloadState;
  public long mReceiveTime;
  public int mSource;
  public String mTaskId;
  public String mUserUin;
  public String mVideoVid;
  
  public static int checkNetworkType(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 3)) {
      return paramInt;
    }
    return 1;
  }
  
  public static ArrayList<PAAdPreloadTask> parserConfigTask(String paramString1, String paramString2)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = new JSONObject(paramString2);
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = ((JSONObject)localObject).getLong("expire_time");
      if (l2 <= l1) {
        return localArrayList;
      }
      paramString2 = ((JSONObject)localObject).getString("task_id");
      int j = ((JSONObject)localObject).getInt("network_type");
      localObject = ((JSONObject)localObject).getJSONArray("video_list");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
        localPAAdPreloadTask.mUserUin = paramString1;
        localPAAdPreloadTask.mTaskId = paramString2;
        localPAAdPreloadTask.mVideoVid = localJSONObject.getString("vid");
        localPAAdPreloadTask.mSource = 1;
        localPAAdPreloadTask.mReceiveTime = l1;
        localPAAdPreloadTask.mExpireTime = l2;
        localPAAdPreloadTask.mPreloadState = 1;
        localPAAdPreloadTask.mNetworkType = checkNetworkType(j);
        localArrayList.add(localPAAdPreloadTask);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (PAAdPreloadTask)paramObject;
        bool1 = bool2;
      } while (TextUtils.isEmpty(this.mUserUin));
      bool1 = bool2;
    } while (!this.mUserUin.equals(paramObject.mUserUin));
    return this.mVideoVid.equals(paramObject.mVideoVid);
  }
  
  public int hashCode()
  {
    return (this.mUserUin.hashCode() * 31 + this.mVideoVid.hashCode()) * 31 + this.mNetworkType;
  }
  
  public boolean isExpire()
  {
    return this.mExpireTime < NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean isNetworkValid()
  {
    if (((this.mNetworkType & 0x1) != 0) && (aqiw.isWifiConnected(null))) {}
    while (((this.mNetworkType & 0x2) != 0) && (aqiw.getSystemNetwork(BaseApplication.getContext()) == 4)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask
 * JD-Core Version:    0.7.0.1
 */