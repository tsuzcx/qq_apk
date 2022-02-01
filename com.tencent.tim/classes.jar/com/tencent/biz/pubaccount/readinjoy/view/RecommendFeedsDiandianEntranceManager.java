package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import awit;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import kvs;
import kxm;
import lbz;
import lil;
import mqq.os.MqqHandler;
import niz;
import nja;
import nss;
import nst;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendFeedsDiandianEntranceManager
{
  private static EntranceIconInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo;
  private static RecommendFeedsDiandianEntranceManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager;
  private static int aYZ = 600000;
  private static int aZa = awit.Qi();
  private int aZb = -1;
  private List<a> mListeners;
  private long xA;
  
  private RecommendFeedsDiandianEntranceManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(216);
    if (localAladdinConfig != null) {
      aYZ = localAladdinConfig.getIntegerFromString("diandian_icon_refresh_time_interval", 600000);
    }
    this.mListeners = new ArrayList();
    og("init");
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "entrance manager init sRefreshInterval : " + aYZ + "; feedsType : " + aZa + " ; curIconInfo : " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo);
  }
  
  private EntranceIconInfo a()
  {
    Object localObject = awit.o(kxm.a().getCurrentUin());
    if (localObject != null) {
      try
      {
        localObject = ((SharedPreferences)localObject).getString("DianDianEntryIconInfo", "");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = new JSONObject((String)localObject);
        EntranceIconInfo localEntranceIconInfo = new EntranceIconInfo();
        localEntranceIconInfo.als = ((JSONObject)localObject).optString("icon_url", "");
        localEntranceIconInfo.feedsType = ((JSONObject)localObject).optInt("feeds_type", 3);
        localEntranceIconInfo.jumpSchema = ((JSONObject)localObject).optString("jump_schema", "");
        localEntranceIconInfo.alt = ((JSONObject)localObject).optString("small_icon_url", "");
        localEntranceIconInfo.isUseGif = ((JSONObject)localObject).optBoolean("use_gif", false);
        ExtraInfo localExtraInfo = new ExtraInfo();
        localExtraInfo.reportStr = ((JSONObject)localObject).optString("report_str", "");
        localEntranceIconInfo.a = localExtraInfo;
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getIconInfoFromSp entryInfo " + localEntranceIconInfo);
        return localEntranceIconInfo;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getIconInfoFromSp entryInfo is null");
    return null;
  }
  
  public static RecommendFeedsDiandianEntranceManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager = new RecommendFeedsDiandianEntranceManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager;
    }
    finally {}
  }
  
  private String a(nst paramnst, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trigger_src", paramInt2);
      localJSONObject.put("click_area", paramInt1);
      if (paramnst != null)
      {
        localJSONObject.put("column_id", paramnst.columnID);
        localJSONObject.put("rowkey", paramnst.rowkey);
        localJSONObject.put("video_report_info", paramnst.anA);
      }
      localJSONObject.put("diandianfeeds_type", 6);
    }
    catch (Exception paramnst)
    {
      for (;;)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getColumnDiandianR5 error! e=" + paramnst);
      }
    }
    return localJSONObject.toString();
  }
  
  private void aXV()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo != null)
    {
      SharedPreferences localSharedPreferences = awit.o(kxm.a().getCurrentUin());
      if (localSharedPreferences != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feeds_type", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.feedsType);
          localJSONObject.put("icon_url", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.als);
          localJSONObject.put("small_icon_url", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.alt);
          localJSONObject.put("jump_schema", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jumpSchema);
          if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.a != null) {}
          for (String str = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.a.reportStr;; str = "")
          {
            localJSONObject.put("report_str", str);
            localJSONObject.put("use_gif", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.isUseGif);
            QLog.d("RecommendFeedsDiandianEntranceManager", 1, "saveIconInfo2Sp | jsonStr : " + localJSONObject.toString());
            localSharedPreferences.edit().putString("DianDianEntryIconInfo", localJSONObject.toString()).apply();
            return;
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public static String bC(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0";
    }
    return "https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&_wwv=1&_wvSb=0&_nav_txtclr=00000&from=kdybrk&target=hot&_nav_titleclr=000000&_wvNlb=0xffffff";
  }
  
  public static int qF()
  {
    switch ()
    {
    default: 
      return 2130843931;
    case 4: 
      return 2130850265;
    }
    return 2130850236;
  }
  
  public boolean FB()
  {
    int i = awit.Qi();
    return (i == 1) || (i == 2);
  }
  
  public void a(EntranceIconInfo paramEntranceIconInfo)
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleDianDianIconRefresh | updateIconInfo : " + paramEntranceIconInfo);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = paramEntranceIconInfo;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo != null)
    {
      aZa = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.feedsType;
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleDianDianIconRefresh | sFeedsType update : " + aZa);
    }
    aXV();
    if (this.mListeners != null)
    {
      paramEntranceIconInfo = this.mListeners.iterator();
      while (paramEntranceIconInfo.hasNext())
      {
        a locala = (a)paramEntranceIconInfo.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.1(this, locala));
      }
    }
  }
  
  public void a(a parama)
  {
    if ((this.mListeners != null) && (parama != null) && (!this.mListeners.contains(parama))) {
      this.mListeners.add(parama);
    }
  }
  
  public void a(nst paramnst, int paramInt1, int paramInt2)
  {
    kbp.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(paramnst, paramInt1, paramInt2), false);
  }
  
  public void aXU()
  {
    long l = System.currentTimeMillis() - this.xA;
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndReqRefreshDianDianIcon | request refresh icon info ,timeinterval : " + l);
    if (l < aYZ) {}
    while (((aZa != 3) && (aZa != 4)) || (lbz.a().a() == null)) {
      return;
    }
    lbz.a().a().rp(aZa);
  }
  
  public void aXW()
  {
    kbp.a(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", bD(0), false);
  }
  
  public void b(a parama)
  {
    if ((this.mListeners != null) && (parama != null)) {
      this.mListeners.remove(parama);
    }
  }
  
  public String bD(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = aZa;
      String str = "0";
      int j = i;
      if (paramInt == 1)
      {
        if (this.aZb == 3) {
          i = 6;
        }
        str = kvs.getChannelId();
        j = i;
      }
      localJSONObject.put("diandianfeeds_type", j);
      localJSONObject.put("trigger_src", paramInt);
      localJSONObject.put("channel_id", str);
      str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public void eQ(long paramLong)
  {
    this.xA = paramLong;
  }
  
  public void g(Context paramContext, int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo == null) {
      return;
    }
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleEntranceIconClick | entranceInfo " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo + ", feedsType : " + paramInt1);
    if (TextUtils.isEmpty(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jumpSchema)) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jumpSchema = bC(paramInt1);
    }
    kxm.aJ(paramContext, jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jumpSchema);
    aXW();
  }
  
  public void og(String paramString)
  {
    int i = awit.Qi();
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | reason " + paramString + "; configFeedsType : " + i);
    paramString = a();
    if (paramString != null)
    {
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo : " + paramString);
      if (paramString.feedsType != i)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo updated");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = EntranceIconInfo.a(i);
        aZa = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.feedsType;
        aXV();
        return;
      }
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = paramString;
      aZa = i;
      return;
    }
    if (FB())
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = null;
      aZa = i;
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = EntranceIconInfo.a(i);
    aZa = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.feedsType;
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | buildIconInfo with configFeedsType : " + i + " ; curIconInfo : " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo);
  }
  
  public void onAccountChange()
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "onAccountChange");
    og("onAccountChange");
    if ((this.mListeners != null) && (!FB()))
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.3(this, locala));
      }
    }
  }
  
  public int qE()
  {
    return aZa;
  }
  
  public void tH(int paramInt)
  {
    kbp.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", bD(paramInt), false);
  }
  
  public void tI(int paramInt)
  {
    this.aZb = paramInt;
  }
  
  public static class EntranceIconInfo
    implements Parcelable, nss
  {
    public static final Parcelable.Creator<EntranceIconInfo> CREATOR = new niz();
    public RecommendFeedsDiandianEntranceManager.ExtraInfo a;
    public String als = "";
    public String alt = "";
    public int feedsType;
    public boolean isUseGif;
    public String jumpSchema = "";
    
    public EntranceIconInfo() {}
    
    public EntranceIconInfo(Parcel paramParcel)
    {
      this.feedsType = paramParcel.readInt();
      this.als = paramParcel.readString();
      this.alt = paramParcel.readString();
      this.jumpSchema = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isUseGif = bool;
        this.a = ((RecommendFeedsDiandianEntranceManager.ExtraInfo)paramParcel.readParcelable(RecommendFeedsDiandianEntranceManager.ExtraInfo.class.getClassLoader()));
        return;
      }
    }
    
    public static EntranceIconInfo a(int paramInt)
    {
      EntranceIconInfo localEntranceIconInfo = new EntranceIconInfo();
      localEntranceIconInfo.feedsType = paramInt;
      localEntranceIconInfo.jumpSchema = RecommendFeedsDiandianEntranceManager.bC(paramInt);
      return localEntranceIconInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getCoverUrl()
    {
      return this.als;
    }
    
    public String hZ()
    {
      return this.als;
    }
    
    public String ia()
    {
      return this.alt;
    }
    
    public void setCoverUrl(String paramString)
    {
      this.als = paramString;
    }
    
    public String toString()
    {
      return "RecommendFeedsDiandianEntranceManager EntranceIconInfo {feedsType : " + this.feedsType + "\nmsgIconUrl :" + this.als + "\ndefaultIconUrl :" + this.alt + "\njumpSchema :" + this.jumpSchema + "\nextraInfo : " + this.a + "\n}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.feedsType);
      paramParcel.writeString(this.als);
      paramParcel.writeString(this.alt);
      paramParcel.writeString(this.jumpSchema);
      if (this.isUseGif) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeParcelable(this.a, paramInt);
        return;
      }
    }
    
    public boolean yS()
    {
      return this.isUseGif;
    }
    
    public boolean yT()
    {
      return !TextUtils.isEmpty(this.als);
    }
    
    public boolean yU()
    {
      return !TextUtils.isEmpty(this.alt);
    }
  }
  
  public static class ExtraInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ExtraInfo> CREATOR = new nja();
    public String reportStr;
    
    public ExtraInfo() {}
    
    public ExtraInfo(Parcel paramParcel)
    {
      this.reportStr = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "RecommendFeedsDiandianEntranceManager ExtraInfo {reportStr : " + this.reportStr + "\n}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.reportStr);
    }
  }
  
  public static abstract interface a
  {
    public abstract void g(nss paramnss);
    
    public abstract void h(nss paramnss);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */