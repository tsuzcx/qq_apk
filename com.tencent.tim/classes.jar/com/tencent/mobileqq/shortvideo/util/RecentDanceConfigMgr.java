package com.tencent.mobileqq.shortvideo.util;

import acbn;
import akrf;
import alwd;
import alwy;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import ankr;
import anku;
import aoll;
import aolm;
import aomi;
import aqec;
import aqhq;
import aqiw;
import aszr;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecentDanceConfigMgr
{
  private static volatile boolean cHN;
  private static boolean cHO;
  private static AtomicReference<RecentDanceConfigMgr> e = new AtomicReference(null);
  public HashMap<String, DItemInfo> nr = new HashMap();
  public boolean showEntrance;
  
  public static String Aa()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_stage_name_cfg", 4).getString("video_dance_stage_name_key", "postureRecognizeStage");
  }
  
  public static int JT()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).getInt("video_dance_version_key", 0);
  }
  
  private static void QE(String paramString)
  {
    ThreadManager.post(new RecentDanceConfigMgr.1(paramString), 5, null, true);
  }
  
  private static void QF(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      e.getAndSet(paramString);
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = JT();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "handleDanceFilterConfig|received remote version: " + m + " | localVersion: " + k);
    }
    if (m != k) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramQQAppInterface != null) {
          if (paramQQAppInterface.compress.get() == 1)
          {
            paramQQAppInterface = akrf.inflateConfigString(paramQQAppInterface.content.get().toByteArray());
            if (paramQQAppInterface == null) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        i = an(paramQQAppInterface, m);
        j = i;
        if (i != 0)
        {
          if (paramConfig.content_list.size() <= 0) {
            break label367;
          }
          i = an((String)paramConfig.content_list.get(0), m);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content_list has data,version: " + m + ",localVersion:" + k);
            j = i;
          }
        }
        return j;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]|Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = "";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]|inflateConfigString error!");
      }
      paramQQAppInterface = "";
      continue;
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content==null");
      }
      int i = -125;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| msg_content_list is empty ,version: " + m + ",localVersion:" + k);
      }
      i = -125;
      continue;
      label367:
      int j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content_list has no data,version: " + m + ",localVersion:" + k);
        return i;
        i = 0;
      }
    }
  }
  
  public static DItemInfo a()
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = a();
    if (localRecentDanceConfigMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "getPlusItemInfo mgr == null");
      }
    }
    while (!localRecentDanceConfigMgr.showEntrance) {
      return null;
    }
    return (DItemInfo)localRecentDanceConfigMgr.nr.get("plus");
  }
  
  private static RecentDanceConfigMgr a()
  {
    Object localObject;
    if (e.get() == null)
    {
      localObject = zY();
      if ((localObject != null) && (!"".equals(localObject))) {
        break label52;
      }
      localObject = new RecentDanceConfigMgr();
      e.getAndSet(localObject);
    }
    for (;;)
    {
      return (RecentDanceConfigMgr)e.get();
      label52:
      QF((String)localObject);
    }
  }
  
  private static RecentDanceConfigMgr a(String paramString)
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = new RecentDanceConfigMgr();
    for (;;)
    {
      int i;
      DItemInfo localDItemInfo;
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        localRecentDanceConfigMgr.showEntrance = paramString.optBoolean("showEntrance", false);
        paramString = paramString.getJSONArray("ItemsInfo");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            localDItemInfo = (DItemInfo)aqec.convertFrom(paramString.getJSONObject(i), DItemInfo.class);
            if (localDItemInfo == null) {
              break label491;
            }
            if ((localDItemInfo.icon_url != null) && (!"".equals(localDItemInfo.icon_url)))
            {
              localObject = a(zZ(), localDItemInfo);
              if (new File((String)localObject).exists()) {
                break label464;
              }
              if (localDItemInfo.isContent) {
                b(localDItemInfo, (String)localObject);
              }
            }
            else
            {
              localDItemInfo.forceRefresh = false;
              localObject = (RecentDanceConfigMgr)e.get();
              if (localObject != null)
              {
                localObject = (DItemInfo)((RecentDanceConfigMgr)localObject).nr.get("" + localDItemInfo.name);
                if (localObject == null) {
                  break label473;
                }
                if ((TextUtils.isEmpty(((DItemInfo)localObject).icon_md5)) && (!TextUtils.isEmpty(localDItemInfo.icon_md5))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((DItemInfo)localObject).icon_md5)) && (TextUtils.isEmpty(localDItemInfo.icon_md5))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((DItemInfo)localObject).icon_md5)) && (!TextUtils.isEmpty(localDItemInfo.icon_md5)) && (!localDItemInfo.icon_md5.equalsIgnoreCase(((DItemInfo)localObject).icon_md5))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((TextUtils.isEmpty(((DItemInfo)localObject).showName)) && (!TextUtils.isEmpty(localDItemInfo.showName))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((DItemInfo)localObject).showName)) && (TextUtils.isEmpty(localDItemInfo.showName))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((DItemInfo)localObject).showName)) && (!TextUtils.isEmpty(localDItemInfo.showName)) && (!localDItemInfo.showName.equalsIgnoreCase(((DItemInfo)localObject).showName))) {
                  localDItemInfo.forceRefresh = true;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr item.forceRefresh=" + localDItemInfo.forceRefresh);
                }
              }
              localRecentDanceConfigMgr.nr.put(localDItemInfo.name, localDItemInfo);
              break label491;
            }
            c(localDItemInfo, (String)localObject);
            continue;
          }
        }
        return localRecentDanceConfigMgr;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr[JSONException]", paramString);
        }
        localRecentDanceConfigMgr.nr.clear();
      }
      label464:
      a(localDItemInfo, (String)localObject);
      continue;
      label473:
      if (QLog.isColorLevel())
      {
        QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr oldItem=null");
        continue;
        label491:
        i += 1;
      }
    }
  }
  
  private static String a(String paramString, DItemInfo paramDItemInfo)
  {
    return paramString + paramDItemInfo.icon_md5 + ".png";
  }
  
  private static void a(DItemInfo paramDItemInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      if (paramString != null) {
        paramDItemInfo.drawable = new BitmapDrawable(paramString);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramString = localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("RecentDanceConfigMgr", 2, "genBitmapDrawable: oomError=", localOutOfMemoryError);
          paramString = localObject;
        }
      }
    }
  }
  
  private static boolean a(AppInterface paramAppInterface, DItemInfo paramDItemInfo)
  {
    boolean bool = alwy.auJ();
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus supportMediaCodec=" + bool);
    }
    if (bool)
    {
      if (paramDItemInfo.categoryID == 10)
      {
        bool = anku.z(paramAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus isSupportDance=" + bool);
        }
        return bool;
      }
      return true;
    }
    return false;
  }
  
  private static boolean al(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).edit();
    localEditor.putString("video_dance_content_key", paramString);
    localEditor.putInt("video_dance_version_key", paramInt);
    return localEditor.commit();
  }
  
  private static int an(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "updateDanceFilterConfigContent|received save version: " + paramInt + ",config_content=" + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("RecentDanceConfigMgr", 2, "updateDanceFilterConfigContent| version=" + paramInt + ",config_content=" + paramString);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        QE(paramString);
      }
      return i;
      boolean bool = al(paramString, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "updateDanceFilterConfigContent| saveContentOK=" + bool);
      }
      if (bool) {
        i = 0;
      } else {
        i = -128;
      }
    }
  }
  
  public static boolean ayf()
  {
    DItemInfo localDItemInfo = a();
    if (localDItemInfo != null)
    {
      boolean bool = localDItemInfo.forceRefresh;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needDoForceRefreshDanceInPlus force=" + bool);
      }
      localDItemInfo.forceRefresh = false;
      return bool;
    }
    return false;
  }
  
  private static boolean ayg()
  {
    return new File(alwd.aH, "ptv_template_new.cfg").exists();
  }
  
  private static void b(DItemInfo paramDItemInfo, String paramString)
  {
    Object localObject = Base64.decode(paramDItemInfo.icon_url, 0);
    if (localObject != null)
    {
      aqhq.writeFile((byte[])localObject, paramString);
      if (new File(paramString).exists())
      {
        localObject = no(paramString);
        if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).equalsIgnoreCase(paramDItemInfo.icon_md5))) {
          break label68;
        }
        aqhq.deleteFile(paramString);
      }
    }
    return;
    label68:
    a(paramDItemInfo, paramString);
  }
  
  private static void c(DItemInfo paramDItemInfo, String paramString)
  {
    aoll localaoll = new aoll();
    localaoll.f = new ankr(paramDItemInfo, paramString);
    localaoll.bZ = paramDItemInfo.icon_url;
    localaoll.mHttpMethod = 0;
    localaoll.atY = (paramString + "_temp");
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    try
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramString))
      {
        ((QQAppInterface)paramString).getNetEngine(0).a(localaoll);
        if (QLog.isColorLevel()) {
          QLog.i("RecentDanceConfigMgr", 2, "processNetWork url: " + paramDItemInfo.icon_url);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork[Exception] url: " + paramDItemInfo.icon_url, paramString);
    }
  }
  
  private static void dRj()
  {
    if (!cHN)
    {
      cHN = true;
      ThreadManager.post(new RecentDanceConfigMgr.3(), 5, null, true);
    }
  }
  
  private static void dRk()
  {
    if (!cHO) {
      cHO = ayg();
    }
  }
  
  private static String no(String paramString)
  {
    try
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      try
      {
        paramString = aszr.getFileMD5String(new File(paramString));
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static boolean po(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_stage_name_cfg", 4).edit();
    localEditor.putString("video_dance_stage_name_key", paramString);
    return localEditor.commit();
  }
  
  public static void printLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "" + paramString);
    }
  }
  
  public static boolean u(AppInterface paramAppInterface)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus mgr == null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus mgr.showEntrance=" + ((RecentDanceConfigMgr)localObject).showEntrance);
    }
    if (((RecentDanceConfigMgr)localObject).showEntrance)
    {
      localObject = (DItemInfo)((RecentDanceConfigMgr)localObject).nr.get("plus");
      if (localObject == null) {
        break label234;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus plus.show=" + ((DItemInfo)localObject).show);
      }
      if (((DItemInfo)localObject).show)
      {
        if (((DItemInfo)localObject).drawable == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus item.drawable=null");
          }
          return false;
        }
        if (TextUtils.isEmpty(((DItemInfo)localObject).showName.trim()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus item.showName=null or space");
          }
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus sTemplateFileOk=" + cHO);
        }
        dRk();
        if (cHO) {
          return a(paramAppInterface, (DItemInfo)localObject);
        }
        dRj();
      }
    }
    for (;;)
    {
      return false;
      label234:
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus PLUS_PANEL=null");
      }
    }
  }
  
  private static String zY()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).getString("video_dance_content_key", "");
  }
  
  private static String zZ()
  {
    Object localObject = new StringBuilder(acbn.SDCARD_PATH);
    ((StringBuilder)localObject).append("sv_config_icon");
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File((String)localObject + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localObject;
    }
    catch (IOException localIOException) {}
    return localObject;
  }
  
  public static class DItemInfo
  {
    public int categoryID;
    public BitmapDrawable drawable;
    public boolean forceRefresh;
    public String icon_md5;
    public String icon_url;
    public boolean isContent = true;
    public String itemID;
    public String name = "";
    public boolean show;
    public String showName;
    public boolean unfold = true;
    
    public DItemInfo()
    {
      this.name = "";
    }
    
    public DItemInfo(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr
 * JD-Core Version:    0.7.0.1
 */