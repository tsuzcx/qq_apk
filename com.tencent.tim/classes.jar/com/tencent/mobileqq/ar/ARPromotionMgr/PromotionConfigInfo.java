package com.tencent.mobileqq.ar.ARPromotionMgr;

import adbj;
import adbm;
import adbx;
import adca;
import adhg;
import adiz;
import aduq.b;
import android.text.TextUtils;
import aqny;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class PromotionConfigInfo
  extends ConfigInfo
{
  static final String TAG = adca.TAG;
  public static final int zipIndex_0 = 0;
  public static final int zipIndex_1 = 1;
  public static final int zipIndex_2 = 2;
  public static final int zipIndex_3 = 3;
  public String activityid = "-1";
  public long config364Version;
  ArCloudConfigInfo mArCloudConfigInfo = null;
  public boolean mainswitch = false;
  public TreeMap<String, a> operationInfos = new TreeMap();
  public boolean showInTopView;
  public boolean showOnce;
  String version = "-1";
  
  static boolean set364ZipItem(ArCloudConfigInfo paramArCloudConfigInfo, a parama)
  {
    int k = 0;
    int j = 0;
    if (paramArCloudConfigInfo == null)
    {
      QLog.w(TAG, 1, "setZipItem，没有364信息");
      return false;
    }
    a.a(parama, paramArCloudConfigInfo);
    int i = k;
    b localb;
    if (paramArCloudConfigInfo.jdField_a_of_type_Adbm != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brD))
      {
        i = k;
        if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE))
        {
          i = j;
          if (paramArCloudConfigInfo.jdField_a_of_type_Adbm.cBF == 1) {
            i = 1;
          }
          localb = new b(parama.id, 1);
          localb.cCa = i;
          localb.url = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brD;
          localb.md5 = paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE;
          localb.zipFilePath = (adbj.se() + localb.md5 + ".zip");
          localb.brM = (adbj.se() + localb.md5 + File.separator);
          a.a(parama).put(Integer.valueOf(localb.index), localb);
        }
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun)) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum)))
    {
      localb = new b(parama.id, 2);
      localb.cCa = i;
      localb.url = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bun;
      localb.md5 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
      localb.zipFilePath = (adbj.sd() + localb.md5 + adbj.brB);
      localb.brM = (adbj.sd() + localb.md5 + File.separator);
      a.a(parama).put(Integer.valueOf(localb.index), localb);
    }
    return true;
  }
  
  public a getActivityItem()
  {
    a locala = getItem(this.activityid);
    if ((locala != null) && (adca.isActivity(locala.begin, locala.end))) {
      return locala;
    }
    return null;
  }
  
  public a getItem(String paramString)
  {
    return (a)this.operationInfos.get(paramString);
  }
  
  int loadResConfig()
  {
    int i = -1;
    if (this.mArCloudConfigInfo != null) {
      i = 0;
    }
    int j;
    do
    {
      String str;
      do
      {
        return i;
        j = aqny.fn(this.mUin);
        str = aqny.pI(this.mUin);
        if (str != null) {
          break;
        }
      } while (!AudioHelper.aCz());
      QLog.w(TAG, 1, "loadResConfig, 没有json");
      return -1;
      this.mArCloudConfigInfo = adhg.a(str);
      if (this.mArCloudConfigInfo != null) {
        break;
      }
    } while (!AudioHelper.aCz());
    QLog.w(TAG, 1, "loadResConfig, 没有arCloudConfigInfo");
    return -1;
    if (this.mArCloudConfigInfo.picId == null) {
      this.mArCloudConfigInfo.picId = this.activityid;
    }
    this.mArCloudConfigInfo.bsN = "2.0";
    this.mArCloudConfigInfo.type = 8;
    this.mArCloudConfigInfo.cCF = 2;
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = new ArFeatureInfo();
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf = (adiz.sl() + "ar_cloud_marker_model/" + this.mArCloudConfigInfo.type + File.separator);
    if (this.mArCloudConfigInfo.jdField_a_of_type_Adbm != null) {
      this.mArCloudConfigInfo.jdField_a_of_type_Adbm.bLc = true;
    }
    this.config364Version = j;
    return j;
  }
  
  public boolean parse(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    ConfigHandler.checkUin(TAG, this.mUin);
    try
    {
      this.operationInfos.clear();
      this.mainswitch = paramJSONObject.getBoolean("mainswitch");
      this.activityid = paramJSONObject.getString("activityid");
      this.version = paramJSONObject.optString("version");
      if (paramJSONObject.has("showInTopView")) {
        this.showInTopView = paramJSONObject.getBoolean("showInTopView");
      }
      if (paramJSONObject.has("showOnce")) {
        this.showOnce = paramJSONObject.getBoolean("showOnce");
      }
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      paramJSONObject = paramJSONObject.optJSONArray("operationInfos");
      boolean bool1 = bool2;
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (paramJSONObject.length() > 0)
        {
          int i = 0;
          bool1 = bool2;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            a locala = new a();
            locala.begin = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
            locala.end = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
            locala.RV = Integer.valueOf(localJSONObject.getString("recoglizeMask")).intValue();
            locala.id = localJSONObject.getString("id");
            locala.title = localJSONObject.optString("title");
            locala.bLh = localJSONObject.optBoolean("need364");
            int j = 1;
            for (;;)
            {
              Object localObject;
              if (j <= 100)
              {
                localObject = localJSONObject.optString("tips" + j);
                if (!TextUtils.isEmpty((CharSequence)localObject)) {}
              }
              else
              {
                localObject = new b(locala.id, 0);
                ((b)localObject).url = localJSONObject.getString("urlEntry");
                ((b)localObject).md5 = localJSONObject.getString("md5Entry");
                ((b)localObject).zipFilePath = adbx.f(((b)localObject).id, 0, ((b)localObject).md5);
                ((b)localObject).brM = adbx.g(((b)localObject).id, 0, ((b)localObject).md5);
                a.a(locala).put(Integer.valueOf(((b)localObject).index), localObject);
                if (locala.bLh)
                {
                  loadResConfig();
                  set364ZipItem(this.mArCloudConfigInfo, locala);
                }
                this.operationInfos.put(locala.id, locala);
                i += 1;
                break;
              }
              locala.js.put(Integer.valueOf(j), localObject);
              j += 1;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w(TAG, 1, "parseJson, Exception", paramJSONObject);
      this.operationInfos.clear();
      bool1 = false;
    }
  }
  
  public String toString()
  {
    Iterator localIterator = this.operationInfos.values().iterator();
    a locala;
    for (String str = ""; localIterator.hasNext(); str = str + "\n" + locala) {
      locala = (a)localIterator.next();
    }
    return "task_id[" + this.task_id + "], _parseRet[" + this._parseRet + "], mUin[" + this.mUin + "], version[" + this.version + "], enable[" + this.mainswitch + "], activityid[" + this.activityid + "], config364Version[" + this.config364Version + "], Items[" + str + "\n]";
  }
  
  public static class a
  {
    public long RV = 0L;
    public boolean bLh;
    long begin;
    private final TreeMap<Integer, PromotionConfigInfo.b> d = new TreeMap();
    public long end;
    public String id;
    HashMap<Integer, String> js = new HashMap();
    private ArCloudConfigInfo mArCloudConfigInfo;
    public String title;
    
    public ArCloudConfigInfo a()
    {
      return this.mArCloudConfigInfo;
    }
    
    public TreeMap<Integer, PromotionConfigInfo.b> b()
    {
      return this.d;
    }
    
    public String dE(int paramInt)
    {
      return (String)this.js.get(Integer.valueOf(paramInt));
    }
    
    public String toString()
    {
      String str = "id[" + this.id + "], recoglizeMask[" + this.RV + "]";
      Object localObject = str;
      if (QLog.isDevelopLevel())
      {
        localObject = this.d.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          PromotionConfigInfo.b localb = (PromotionConfigInfo.b)((Iterator)localObject).next();
          str = str + "\n" + localb;
        }
        localObject = str + ", begin[" + this.begin + "], end[" + this.end + "], title[" + this.title + "], tips[" + this.js.size() + "]";
      }
      return localObject;
    }
  }
  
  public static class b
  {
    public long RW = 0L;
    public long RX = 0L;
    public long RY = 0L;
    public aduq.b a = null;
    public boolean bLi = true;
    public String brM = null;
    public int cCa = 1;
    public int cCb = -1;
    public Object cM = new Object();
    public int downloadType = 0;
    public final String id;
    public final int index;
    public String md5;
    public String url;
    public String zipFilePath = null;
    
    public b(String paramString, int paramInt)
    {
      this.id = paramString;
      this.index = paramInt;
    }
    
    public void cPU()
    {
      synchronized (this.cM)
      {
        if (this.downloadType == 1) {
          return;
        }
        if (this.downloadType == -1) {
          QLog.w(PromotionConfigInfo.TAG, 1, "clearDownladFlag, ZipItem[" + this + "]");
        }
        setDownloadType(0);
        this.RW = 0L;
        this.RX = 0L;
        this.RY = 0L;
        return;
      }
    }
    
    public void setDownloadType(int paramInt)
    {
      synchronized (this.cM)
      {
        this.downloadType = paramInt;
        return;
      }
    }
    
    public String toString()
    {
      return this.index + ", id[" + this.id + "], index[" + this.index + "], net_type[" + this.cCa + "], url[" + this.url + "], md5[" + this.md5 + "], zipFilePath[" + this.zipFilePath + "], unzipDirPath[" + this.brM + "], callByPreDownload[" + this.bLi + "], downloadType[" + this.downloadType + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */