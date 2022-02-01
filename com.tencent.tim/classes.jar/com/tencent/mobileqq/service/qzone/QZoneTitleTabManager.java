package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.st_report_info;
import acfp;
import andr;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jqc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneTitleTabManager
{
  private static final CopyOnWriteArrayList<TabInfo> ap = new CopyOnWriteArrayList();
  private static volatile int state = 0;
  
  public static void Qp(String paramString)
  {
    if (state > 1) {}
    for (;;)
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + paramString, 0).getString("qzone_tab_key", "");
      if (QLog.isColorLevel()) {
        QLog.i("QZoneTitleTabManager", 2, "loadTabInfo:" + paramString);
      }
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONArray(paramString);
          if ((paramString == null) || (paramString.length() <= 0)) {
            continue;
          }
          int j = paramString.length();
          ArrayList localArrayList = new ArrayList(2);
          int i = 0;
          while (i < j)
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            TabInfo localTabInfo = new TabInfo();
            localTabInfo.fromJson(localJSONObject);
            localArrayList.add(localTabInfo);
            i += 1;
          }
          an(localArrayList);
          if (state > 1) {
            continue;
          }
          ap.clear();
          ap.addAll(localArrayList);
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneTitleTabManager", 2, paramString, new Object[0]);
        return;
      }
    }
    QLog.i("QZoneTitleTabManager", 2, "本地没有title上发现tab的配置");
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (parammobile_count_rsp_new == null)
      {
        QLog.e("QZoneTitleTabManager", 2, "handleTabInfo rsp=null,使用本地配置");
        return;
      }
      if (parammobile_count_rsp_new.mapEntranceCfg == null)
      {
        QLog.e("QZoneTitleTabManager", 2, "handleTabInfo rsp.mapEntranceCfg==null,使用本地配置");
        return;
      }
      if (!parammobile_count_rsp_new.mapEntranceCfg.containsKey(Integer.valueOf(10)))
      {
        QLog.i("QZoneTitleTabManager", 2, "没有下发标题栏上tab的配置,使用本地配置");
        return;
      }
      Object localObject = (ArrayList)parammobile_count_rsp_new.mapEntranceCfg.get(Integer.valueOf(10));
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        QLog.i("QZoneTitleTabManager", 2, "下发的标题栏的配置是空的,使用本地配置");
        return;
      }
      parammobile_count_rsp_new = new ArrayList(2);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        entrance_cfg localentrance_cfg = (entrance_cfg)((Iterator)localObject).next();
        if (localentrance_cfg != null)
        {
          TabInfo localTabInfo = new TabInfo(localentrance_cfg.iEntranceId, localentrance_cfg.sEntranceName);
          localTabInfo.url = localentrance_cfg.sEntranceAction;
          if (localentrance_cfg.isAnchor != 0) {}
          for (boolean bool = true;; bool = false)
          {
            localTabInfo.cES = bool;
            if (localentrance_cfg.stReportInfo != null)
            {
              localTabInfo.actionType = localentrance_cfg.stReportInfo.report_first_page;
              localTabInfo.dFa = localentrance_cfg.stReportInfo.report_second_page;
            }
            parammobile_count_rsp_new.add(localTabInfo);
            break;
          }
        }
      }
      parammobile_count_rsp_new = an(parammobile_count_rsp_new);
    } while ((parammobile_count_rsp_new == null) || (parammobile_count_rsp_new.size() <= 0));
    ap.clear();
    ap.addAll(parammobile_count_rsp_new);
    k(paramQQAppInterface, ap);
    state = 3;
  }
  
  static boolean a(TabInfo paramTabInfo)
  {
    if (paramTabInfo == null) {}
    do
    {
      do
      {
        return false;
        if ((jqc.isValidUrl(paramTabInfo.url)) && (!TextUtils.isEmpty(paramTabInfo.name))) {
          return true;
        }
        if (paramTabInfo.id != 51) {
          break;
        }
      } while (TextUtils.isEmpty(paramTabInfo.name));
      return true;
      if (paramTabInfo.id == 15)
      {
        if (!jqc.isValidUrl(paramTabInfo.url)) {
          paramTabInfo.url = "https://h5.qzone.qq.com/secret/list/{uin}/secret?_proxy=1&_wv=3&source=tab";
        }
        return true;
      }
    } while (paramTabInfo.id != 51);
    return true;
  }
  
  private static ArrayList<TabInfo> an(ArrayList<TabInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      QLog.i("QZoneTitleTabManager", 2, "processConfig:" + paramArrayList);
    }
    do
    {
      return null;
      if (paramArrayList.size() == 1)
      {
        localObject2 = new ArrayList(1);
        TabInfo localTabInfo = (TabInfo)paramArrayList.get(0);
        if ((localTabInfo != null) && (localTabInfo.id == 50))
        {
          localObject1 = localTabInfo.name;
          paramArrayList = (ArrayList<TabInfo>)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramArrayList = acfp.m(2131720732);
          }
          ((ArrayList)localObject2).add(new TabInfo(localTabInfo.id, paramArrayList));
        }
        return localObject2;
      }
    } while (paramArrayList.size() < 2);
    Object localObject1 = new ArrayList(2);
    Object localObject2 = (TabInfo)paramArrayList.get(0);
    paramArrayList = (TabInfo)paramArrayList.get(1);
    if (((TabInfo)localObject2).id == 50) {
      if (!TextUtils.isEmpty(((TabInfo)localObject2).name)) {}
    }
    for (((TabInfo)localObject2).name = acfp.m(2131713410);; ((TabInfo)localObject2).name = acfp.m(2131713411))
    {
      ((ArrayList)localObject1).add(localObject2);
      if (!a(paramArrayList)) {
        break;
      }
      ((ArrayList)localObject1).add(paramArrayList);
      return localObject1;
      ((TabInfo)localObject2).id = 50;
    }
    QLog.e("QZoneTitleTabManager", 1, "procesConfig not support secondTab:" + paramArrayList);
    return localObject1;
  }
  
  public static ArrayList<TabInfo> bm()
  {
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.addAll(ap);
    QLog.i("QZoneTitleTabManager", 1, "getTabInfos:" + localArrayList);
    return localArrayList;
  }
  
  public static ArrayList<TabInfo> c(Intent paramIntent)
  {
    if (paramIntent != null) {
      return paramIntent.getParcelableArrayListExtra("key_tab_intent");
    }
    return null;
  }
  
  private static void cH(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneTitleTabManager", 2, "clearConfig");
    }
    state = 2;
    ap.clear();
    BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + paramQQAppInterface.getAccount(), 0).edit().remove("qzone_tab_key").apply();
  }
  
  public static void dJ(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.putParcelableArrayListExtra("key_tab_intent", bm());
    }
  }
  
  private static void k(QQAppInterface paramQQAppInterface, List<TabInfo> paramList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((TabInfo)paramList.next()).toJson());
      }
      return;
    }
    catch (JSONException paramList)
    {
      QLog.e("QZoneTitleTabManager", 2, paramList, new Object[0]);
      for (paramList = null; TextUtils.isEmpty(paramList); paramList = localJSONArray.toString())
      {
        cH(paramQQAppInterface);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneTitleTabManager", 2, "save config:" + paramList);
      }
      BaseApplicationImpl.getApplication().getSharedPreferences("qzone_tab_info_" + paramQQAppInterface.getAccount(), 0).edit().putString("qzone_tab_key", paramList).apply();
    }
  }
  
  public static class TabInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TabInfo> CREATOR = new andr();
    public int actionType;
    public boolean cES = true;
    public int dFa;
    public int id;
    public String name;
    public String url;
    
    public TabInfo() {}
    
    public TabInfo(int paramInt, String paramString)
    {
      this.id = paramInt;
      this.name = paramString;
    }
    
    public TabInfo(Parcel paramParcel)
    {
      this.id = paramParcel.readInt();
      this.name = paramParcel.readString();
      this.actionType = paramParcel.readInt();
      this.dFa = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.cES = bool;
        this.url = paramParcel.readString();
        return;
        bool = false;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void fromJson(JSONObject paramJSONObject)
    {
      this.id = paramJSONObject.optInt("id");
      this.name = paramJSONObject.optString("name");
      this.actionType = paramJSONObject.optInt("actionType", -1);
      this.dFa = paramJSONObject.optInt("subActionType", -1);
      this.cES = paramJSONObject.optBoolean("rememberAnchor", false);
      this.url = paramJSONObject.optString("url");
    }
    
    public JSONObject toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.id);
      localJSONObject.put("name", this.name);
      localJSONObject.put("actionType", this.actionType);
      localJSONObject.put("subActionType", this.dFa);
      localJSONObject.put("rememberAnchor", this.cES);
      localJSONObject.put("url", this.url);
      return localJSONObject;
    }
    
    public String toString()
    {
      try
      {
        String str = toJson().toString();
        return str;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneTitleTabManager", 2, "", localJSONException);
        }
      }
      return "";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.id);
      paramParcel.writeString(this.name);
      paramParcel.writeInt(this.actionType);
      paramParcel.writeInt(this.dFa);
      if (this.cES) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.url);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneTitleTabManager
 * JD-Core Version:    0.7.0.1
 */