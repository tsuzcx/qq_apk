import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqqf
{
  ArrayList<aqqf.c> CT;
  public aqqf.d a = new aqqf.d();
  QQAppInterface app;
  long atC;
  public aqqf.a b = new aqqf.a();
  public aqqf.a c = new aqqf.a();
  public boolean cVC;
  public boolean cVD;
  VasQuickUpdateManager.CallBacker callBacker = new aqqg(this);
  public String cuX;
  public String cuY;
  public String cuZ;
  acgn d;
  AtomicBoolean ep = new AtomicBoolean(false);
  public AtomicBoolean eq = new AtomicBoolean(false);
  public Map<String, List<String>> oi = new HashMap();
  public QQLruCache<String, aqqf.e> p;
  
  public aqqf(QQAppInterface paramQQAppInterface, acgn paramacgn)
  {
    this.app = paramQQAppInterface;
    this.c.cva = "";
    this.d = paramacgn;
    this.cVD = paramacgn.t().getBoolean("mall_entrance_switch", false);
    this.cVC = paramacgn.t().getBoolean("redpacket_is_show_switch", false);
    this.p = new QQLruCache(1009, 100, 300);
    this.a.resType = 8;
    this.c.resType = 26;
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.callBacker);
  }
  
  public static boolean a(aqqf.d paramd)
  {
    if ((paramd == null) || (paramd.resType == 0)) {}
    for (;;)
    {
      return false;
      paramd = acgn.b(paramd.id, paramd.name, paramd.resType, paramd.version, 0);
      if (TextUtils.isEmpty(paramd)) {}
      for (paramd = null; (paramd != null) && (paramd.exists()) && (paramd.isFile()); paramd = new File(paramd)) {
        return true;
      }
    }
  }
  
  public static boolean bU(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    File localFile1 = new File(paramString1);
    if ((localFile1 != null) && (localFile1.exists()) && (localFile1.isFile())) {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "uncompressZip zipFile.exists(), zipFile.length()=" + localFile1.length());
      }
    }
    for (;;)
    {
      try
      {
        aqhq.W(paramString1, paramString2, false);
        File localFile2 = new File(paramString2);
        if (localFile2.exists())
        {
          i = ThemeUtil.getFileNumInFile(localFile2);
          if (i > 0)
          {
            i = 1;
            if (i == 0)
            {
              paramString2 = new File(paramString2);
              QLog.d("IndividualRedPacketResDownloader", 1, "uncompressZip DownloaderFactory.unzipResource, themeZipPath:" + paramString1);
              bool1 = aqva.a(localFile1, paramString2, false);
              bool2 = bool1;
              j = i;
              if (i == 0)
              {
                bool2 = bool1;
                j = i;
                if (!bool1)
                {
                  aqhq.deleteFile(paramString1);
                  QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip result false");
                  j = i;
                  bool2 = bool1;
                }
              }
              if (j == 0)
              {
                bool1 = bool3;
                if (!bool2) {}
              }
              else
              {
                bool1 = true;
              }
              return bool1;
            }
          }
          else
          {
            QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip fileNum == 0");
            i = 0;
            continue;
          }
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip FileUtils.uncompressZip IOException:" + localIOException.getMessage());
        int i = 0;
        continue;
        boolean bool1 = false;
        continue;
        i = 0;
        continue;
      }
      boolean bool2 = false;
      int j = 0;
    }
  }
  
  public aqqf.e a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(acgn.b(paramString, null, 0, 0, 0));
    } while (!paramString.exists());
    try
    {
      aqqf.e locale = a(new JSONObject(aqhq.readFileContent(paramString)), true);
      if (locale != null) {
        this.p.put(locale.id, locale);
      }
      return locale;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadPacketJson ,filePath:" + paramString.getAbsolutePath(), localThrowable);
    }
    return null;
  }
  
  public aqqf.e a(String paramString, boolean paramBoolean)
  {
    aqqf.e locale = (aqqf.e)this.p.get(paramString);
    if (!paramBoolean) {}
    while ((locale != null) && (locale.a != null) && (locale.b != null) && (locale.c != null)) {
      return locale;
    }
    return a(paramString);
  }
  
  aqqf.e a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    label1043:
    for (;;)
    {
      Object localObject1;
      aqqf.e locale;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.optString("id");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        locale = new aqqf.e();
        locale.a = new aqqf.b();
        locale.a.resType = 2;
        locale.b = new aqqf.b();
        locale.b.resType = 3;
        locale.c = new aqqf.b();
        locale.c.resType = 14;
        locale.id = ((String)localObject1);
        locale.a.id = ((String)localObject1);
        locale.b.id = ((String)localObject1);
        locale.c.id = ((String)localObject1);
        locale.a.name = paramJSONObject.optString("name");
        locale.b.name = locale.a.name;
        locale.c.name = locale.a.name;
        locale.type = paramJSONObject.optInt("customWord", aqqf.e.ebF);
        locale.fontId = paramJSONObject.optInt("fontTypeId", 1);
        locale.version = paramJSONObject.optInt("version", 0);
        locale.a.version = locale.version;
        locale.b.version = locale.version;
        locale.c.version = locale.version;
        if (locale.type != aqqf.e.ebE) {
          break label876;
        }
        localObject1 = paramJSONObject.optJSONArray("aioChar");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
        {
          locale.a.cJ = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
          locale.a.fontSize = ((JSONArray)localObject1).optInt(2);
          localObject1 = paramJSONObject.optJSONArray("packetChar");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
          {
            locale.b.cJ = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            locale.b.fontSize = ((JSONArray)localObject1).optInt(2);
            localObject1 = paramJSONObject.optJSONArray("sendChar");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() < 4)) {
              break label810;
            }
            locale.c.cJ = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            locale.c.fontSize = ((JSONArray)localObject1).optInt(2);
            localObject2 = locale.a;
            if (locale.a.a != null) {
              break label1043;
            }
            localObject1 = paramJSONObject.optString("aioImgUrl", "");
            ((aqqf.b)localObject2).url = ((String)localObject1);
            locale.b.url = paramJSONObject.optString("redEnvelopeImgUrl", "");
            locale.c.url = paramJSONObject.optString("sendImgUrl", "");
            return locale;
          }
        }
        else
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioChar error,name:" + locale.a.name + ", id:" + locale.id + ", isV710:" + paramBoolean);
          locale.a.cJ = new Rect(1, 1, 1, 1);
          locale.a.fontSize = 1;
          locale.type = aqqf.e.ebF;
          continue;
        }
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson packetChar error,name:" + locale.a.name + ", id:" + locale.id + ", isV710:" + paramBoolean);
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson Err:" + paramJSONObject.toString() + ", isV710:" + paramBoolean);
        return null;
      }
      locale.b.cJ = new Rect(1, 1, 1, 1);
      locale.b.fontSize = 1;
      locale.type = aqqf.e.ebF;
      continue;
      label810:
      if (QLog.isColorLevel())
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + locale.a.name + ", id:" + locale.id + ", isV710:" + paramBoolean);
        continue;
        label876:
        localObject1 = paramJSONObject.optString("aioPngZip", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).indexOf("http") >= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioPngZip ,name=" + locale.a.name + ", id:" + locale.id + ", url:" + (String)localObject1 + ", isV710:" + paramBoolean);
          }
          localObject2 = new CustomizeStrategyFactory.a();
          ((CustomizeStrategyFactory.a)localObject2).delay = paramJSONObject.optInt("interval", 100);
          ((CustomizeStrategyFactory.a)localObject2).size = paramJSONObject.optInt("flameCount", 0);
          locale.a.a = ((CustomizeStrategyFactory.a)localObject2);
          locale.a.cvc = ((String)localObject1);
          locale.a.resType = 19;
          continue;
          localObject1 = locale.a.cvc;
        }
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
  {
    if ((this.app == null) || (this.d == null)) {
      return;
    }
    if ((paramFile != null) && (paramFile.exists())) {}
    File localFile;
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(aqhq.readFileContent(paramFile));
        if (localObject1 != null) {
          break label172;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject1 = new StringBuilder().append("initJsonBySCID null == resJson, scid=").append(paramString).append(", isAfterDownload:").append(paramBoolean1).append(", isInit").append(paramBoolean2).append(", file=");
        if (paramFile == null) {
          break label165;
        }
        paramString = paramFile.getAbsolutePath();
        QLog.e("IndividualRedPacketResDownloader", 2, paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + paramFile.getAbsolutePath(), localThrowable);
      }
      localFile = null;
      continue;
      label165:
      paramString = "null";
    }
    for (;;)
    {
      try
      {
        label172:
        Object localObject2;
        if ("iRedPacket_v3.char300.json".equals(paramString))
        {
          localObject2 = localFile.optJSONArray("data");
          if (localObject2 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localStringBuilder.append(((JSONArray)localObject2).getString(i));
              i += 1;
              continue;
            }
            this.b.cva = localStringBuilder.toString();
            this.b.state = 2;
          }
        }
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          this.a.id = localFile.optString("id", "");
          this.a.name = localFile.optString("name", "");
          this.a.version = localFile.optInt("version");
          this.a.state = 2;
          this.d.Ea(this.a.id);
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          this.c.id = localFile.optString("id", "0");
          this.c.version = localFile.optInt("version");
          this.c.state = 2;
          this.c.cvb = localFile.optString("char", "");
          this.c.cva = ("" + this.c.cvb);
          paramString = this.c.id + this.c.version;
          if ((!TextUtils.isEmpty(this.c.cvb)) && (!paramString.equals(this.d.t().getString("special_unzip_version_key", ""))))
          {
            localFile = new File(acgn.b(null, null, 26, 0, 0));
            localObject2 = acgn.dy(2) + "images";
            if (!bU(localFile.getAbsolutePath(), (String)localObject2)) {
              break label683;
            }
            this.d.t().edit().putString("special_unzip_version_key", paramString).commit();
          }
        }
        if ((this.b.state != 2) || (this.a.state != 2) || (!this.d.aat())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
        }
        this.d.a(this.b);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", paramString);
        aqri.a(this.app, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
        return;
      }
      label683:
      if ((!localFile.exists()) && (paramFile != null)) {
        paramFile.delete();
      }
    }
  }
  
  public void cB(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject7;
    label230:
    Object localObject8;
    label428:
    label484:
    Object localObject9;
    label527:
    label557:
    label635:
    int j;
    int i;
    int m;
    int n;
    label694:
    int i1;
    label778:
    label807:
    String str1;
    for (;;)
    {
      try
      {
        if (this.app != null)
        {
          localObject1 = this.d;
          if (localObject1 != null) {
            continue;
          }
        }
      }
      finally
      {
        try
        {
          Object localObject1 = new JSONObject(aqhq.readFileContent((File)localObject7));
          if (localObject1 != null) {
            break label230;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson null == resJson,isAfterDownload:" + paramBoolean1 + ", isInit" + paramBoolean2);
        }
        catch (Throwable localThrowable)
        {
          boolean bool;
          QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + ((File)localObject7).getAbsolutePath(), localThrowable);
        }
        localObject2 = finally;
      }
      return;
      localObject1 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.json";
      localObject7 = this.app;
      if (!paramBoolean1)
      {
        bool = true;
        localObject7 = VasQuickUpdateManager.getFileFromLocal((AppRuntime)localObject7, 16L, "iRedPacket_v3.json", (String)localObject1, bool, this.callBacker);
        if (localObject7 != null)
        {
          bool = ((File)localObject7).exists();
          if (!bool) {}
        }
      }
      else
      {
        bool = false;
        continue;
      }
      Object localObject3 = null;
      continue;
      try
      {
        long l = localObject3.optLong("timestamp", 1L);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "initAllConfigJson timestamp=" + l + ", mJsonTimestamp:" + this.atC);
        }
        if (l > this.atC)
        {
          this.atC = l;
          localObject7 = localObject3.optJSONObject("data");
          if (localObject7 == null) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson, null == data, timestamp=" + l + ", mJsonTimestamp:" + this.atC);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: ", localJSONException);
        aqri.a(this.app, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
        continue;
        Object localObject4 = ((JSONObject)localObject7).optJSONArray("activityInfo");
        if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
          break label1700;
        }
        localObject4 = ((JSONArray)localObject4).optJSONObject(0);
        paramBoolean1 = false;
        if (localObject4 != null)
        {
          localObject8 = ((JSONObject)localObject4).optString("time");
          if (!TextUtils.isEmpty((CharSequence)localObject8))
          {
            if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject8).getTime() - NetConnInfoCenter.getServerTimeMillis() >= 172800000L) {
              break label1706;
            }
            paramBoolean1 = true;
          }
          localObject8 = this.d.t();
          localObject9 = ((SharedPreferences)localObject8).edit();
          if (((JSONObject)localObject4).has("androidShowSwitch"))
          {
            if (((JSONObject)localObject4).getInt("androidShowSwitch") != 1) {
              break label1711;
            }
            paramBoolean2 = true;
            this.cVC = paramBoolean2;
          }
          if (((JSONObject)localObject4).has("androidEntrySwitch"))
          {
            if (((JSONObject)localObject4).getInt("androidEntrySwitch") != 1) {
              break label1716;
            }
            paramBoolean2 = true;
            this.cVD = paramBoolean2;
          }
          if ((this.cVC == ((SharedPreferences)localObject8).getBoolean("redpacket_is_show_switch", false)) && (this.cVD == ((SharedPreferences)localObject8).getBoolean("mall_entrance_switch", false))) {
            break label1688;
          }
          ((SharedPreferences.Editor)localObject9).putBoolean("redpacket_is_show_switch", this.cVC);
          ((SharedPreferences.Editor)localObject9).putBoolean("mall_entrance_switch", this.cVD);
          ((SharedPreferences.Editor)localObject9).commit();
          break label1688;
          localObject4 = ((JSONObject)localObject7).optJSONArray("isPreload");
          j = 0;
          i = 0;
          if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
            break label1678;
          }
          localObject4 = ((JSONArray)localObject4).optJSONObject(0);
          m = ((JSONObject)localObject4).optInt("isPreload", 5);
          n = ((JSONObject)localObject4).optInt("preloadTotal", 50);
          localObject8 = ((JSONObject)localObject7).optJSONArray("templateIdList");
          if (QLog.isColorLevel())
          {
            localObject9 = new StringBuilder().append("checkAndDownloadBeforeUse ,emergencyDownload:").append(paramBoolean1).append(", templateIdList:");
            if (localObject8 != null) {
              break label841;
            }
          }
        }
        for (localObject4 = "null";; localObject4 = Integer.valueOf(((JSONArray)localObject8).length()))
        {
          QLog.d("IndividualRedPacketResDownloader", 2, localObject4);
          localObject9 = new ArrayList();
          if (localObject8 == null) {
            break label1326;
          }
          i1 = 0;
          j = i;
          if (i1 >= ((JSONArray)localObject8).length()) {
            break label1326;
          }
          if ((i1 >= n) || (i >= m)) {
            break label1721;
          }
          j = 1;
          str1 = ((JSONArray)localObject8).optString(i1);
          if (!TextUtils.isEmpty(str1)) {
            break label854;
          }
          break label1691;
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
          paramBoolean1 = false;
          break;
        }
        localObject4 = (aqqf.e)this.p.get(str1);
        synchronized (this.oi)
        {
          if (!this.oi.containsKey(str1)) {
            break label1672;
          }
          if ((localObject4 != null) && (!a(((aqqf.e)localObject4).a)) && (!a(((aqqf.e)localObject4).b)) && (!a(((aqqf.e)localObject4).c))) {
            break label1669;
          }
          localObject4 = a(str1);
          label937:
          if ((localObject4 == null) || (!a(((aqqf.e)localObject4).a)) || (!a(((aqqf.e)localObject4).b)) || (!a(((aqqf.e)localObject4).c))) {
            break label1282;
          }
          List localList = (List)this.oi.get(str1);
          k = 0;
          if (k >= localList.size()) {
            break;
          }
          String str2 = (String)localList.get(k);
          if (TextUtils.isEmpty(str2)) {
            break label1727;
          }
          this.d.dz(str2, ((aqqf.e)localObject4).a.resType);
          this.d.dz(str2 + "_tp", ((aqqf.e)localObject4).b.resType);
          this.d.dz(str2 + "_send", ((aqqf.e)localObject4).c.resType);
        }
      }
      catch (Exception localException)
      {
        label841:
        label854:
        label994:
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: ", localException);
      }
    }
    this.oi.remove(str1);
    int k = 0;
    label1162:
    label1200:
    Object localObject6;
    if ((j != 0) && (k == 0))
    {
      if (new File(acgn.b(str1, null, 0, 0, 0)).exists()) {
        j = 0;
      }
      for (;;)
      {
        if ((j != 0) && (k == 0))
        {
          i += 1;
          localObject6 = new aqqf.c();
          ((aqqf.c)localObject6).bid = 16L;
          ((aqqf.c)localObject6).scid = ("luckyMoney.item." + str1);
          ((aqqf.c)localObject6).path = acgn.b(str1, null, 0, 0, 0);
          ((ArrayList)localObject9).add(localObject6);
          break label1691;
          label1282:
          v(16L, str1, null);
          k = 1;
          break;
          if (new File(acgn.b(str1, null, 3, 0, 0)).exists()) {
            break label1736;
          }
          j = 1;
          continue;
          label1326:
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse finish! size = " + this.p.size() + ", preloadSize=" + j + ", totalCanPreload=" + m);
          }
          localObject6 = ((JSONObject)localObject7).optJSONArray("vipRedPacketURL");
          if (localObject6 != null) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject6).length())
      {
        localObject8 = ((JSONArray)localObject6).optJSONObject(i);
        localObject7 = ((JSONObject)localObject8).optString("name");
        localObject8 = ((JSONObject)localObject8).optString("url", null);
        if ("aioTail".equals(localObject7)) {
          this.cuY = ((String)localObject8);
        } else if ("personalityMall".equals(localObject7)) {
          this.cuX = ((String)localObject8);
        } else if ("tencentPay".equals(localObject7)) {
          this.cuZ = ((String)localObject8);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse mAioTailURL:" + this.cuY + ", mTencentPayURL:" + this.cuZ + ", mPersonalityMallURL:" + this.cuX);
        }
        label1562:
        i = aqiw.getSystemNetwork(null);
        if (this.CT == null)
        {
          this.CT = ((ArrayList)localObject9);
          label1580:
          if ((this.ep.get()) || ((1 != i) && (!paramBoolean1)) || (!this.d.aat())) {
            break label1655;
          }
          px();
        }
        for (;;)
        {
          this.eq.set(true);
          break;
          if (!QLog.isColorLevel()) {
            break label1562;
          }
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
          break label1562;
          this.CT.addAll((Collection)localObject9);
          break label1580;
          label1655:
          this.CT = null;
        }
        break label1691;
        break label1200;
        label1669:
        break label937;
        label1672:
        k = 0;
        break label1162;
        label1678:
        m = 5;
        n = 50;
        break label694;
        label1688:
        break label635;
        label1691:
        i1 += 1;
        break label778;
        label1700:
        localObject6 = null;
        break label428;
        label1706:
        paramBoolean1 = false;
        break label484;
        label1711:
        paramBoolean2 = false;
        break label527;
        label1716:
        paramBoolean2 = false;
        break label557;
        label1721:
        j = 0;
        break label807;
        label1727:
        k += 1;
        break label994;
        label1736:
        j = 0;
        break label1200;
      }
      i += 1;
    }
  }
  
  public void eeW()
  {
    if ((this.app == null) || (this.d == null)) {}
    File localFile1;
    File localFile2;
    File localFile3;
    int j;
    int i;
    for (;;)
    {
      return;
      if (!this.d.cC.get()) {
        try
        {
          if (!this.d.t().getBoolean("res_version_has_updated", false))
          {
            Object localObject1 = new File(acgn.dy(3) + "10029_0");
            localObject3 = new File(acgn.b(null, null, 8, 0, 0));
            if ((((File)localObject1).exists()) && (!((File)localObject3).exists())) {
              ((File)localObject1).renameTo((File)localObject3);
            }
            localFile1 = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "RedPacket/templateAIO"));
            localFile2 = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "RedPacket/templateTENPAY"));
            localFile3 = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "RedPacket/templateSEND"));
            j = 0;
            i = j;
            if (localFile1.exists())
            {
              i = j;
              if (localFile1.isDirectory())
              {
                i = j;
                if (localFile2.exists())
                {
                  i = j;
                  if (localFile2.isDirectory())
                  {
                    i = j;
                    if (localFile3.exists())
                    {
                      i = j;
                      if (localFile3.isDirectory())
                      {
                        localObject1 = localFile1.list();
                        localObject3 = localFile2.list();
                        localObject4 = localFile3.list();
                        i = j;
                        if (localObject1.length > 0)
                        {
                          i = j;
                          if (localObject3.length > 0)
                          {
                            i = j;
                            if (localObject4.length > 0) {
                              i = 1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            if (i == 0)
            {
              this.d.t().edit().putBoolean("res_version_has_updated", true).commit();
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion TODO v7.10 updateErr:" + localThrowable.toString());
          return;
        }
      }
    }
    Object localObject3 = aqpi.a(this.app, aqpi.g, false);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
      }
      localObject2 = this.app.getApplication().getApplicationContext();
      localObject4 = aqpi.g.cuN;
      localObject2 = new File(((Context)localObject2).getFilesDir(), (String)localObject4);
      localObject2 = new aquz(aqpi.g.cuO, (File)localObject2);
      ((aquz)localObject2).cWw = true;
      if (aqva.a((aquz)localObject2, this.app) != 0) {
        break label516;
      }
    }
    for (localObject2 = aqpi.a(this.app, aqpi.g, false); localObject2 == null; localObject2 = localObject3)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
      return;
      label516:
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + aqpi.g.cuO);
    }
    localObject2 = ((JSONObject)localObject2).optJSONObject("data");
    if (localObject2 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
      return;
    }
    Object localObject4 = ((JSONObject)localObject2).optJSONArray("templateList");
    Object localObject6;
    if (localObject4 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
      return;
      if (i < ((JSONArray)localObject4).length())
      {
        Object localObject5 = a(((JSONArray)localObject4).optJSONObject(i), false);
        if ((localObject5 == null) || (((aqqf.e)localObject5).a == null) || (((aqqf.e)localObject5).b == null) || (((aqqf.e)localObject5).c == null) || (new File(acgn.b(((aqqf.e)localObject5).id, null, 0, 0, 0)).exists())) {
          break label1104;
        }
        localObject6 = ((aqqf.e)localObject5).id + "_" + ((aqqf.e)localObject5).version;
        localObject3 = localFile1.getAbsolutePath() + File.separator + (String)localObject6;
        aqqf.b localb = ((aqqf.e)localObject5).a;
        localObject2 = localObject3;
        if (localb.resType == 19) {
          localObject2 = (String)localObject3 + "_zip";
        }
        if (!new File((String)localObject2).exists()) {
          break label1104;
        }
        localObject3 = new String[3];
        localObject3[0] = localObject2;
        localObject3[1] = (localFile2.getAbsolutePath() + File.separator + (String)localObject6);
        localObject3[2] = (localFile3.getAbsolutePath() + File.separator + (String)localObject6);
        localObject2 = ((aqqf.e)localObject5).b;
        localObject5 = ((aqqf.e)localObject5).c;
        localObject6 = new String[3];
        localObject6[0] = acgn.b(localb.id, localb.name, localb.resType, localb.version, 0);
        localObject6[1] = acgn.b(((aqqf.b)localObject2).id, ((aqqf.b)localObject2).name, ((aqqf.b)localObject2).resType, ((aqqf.b)localObject2).version, 0);
        localObject6[2] = acgn.b(((aqqf.b)localObject5).id, ((aqqf.b)localObject5).name, ((aqqf.b)localObject5).resType, ((aqqf.b)localObject5).version, 0);
        j = 0;
      }
    }
    for (;;)
    {
      if (j < localObject3.length)
      {
        if (aqhq.copyFile(localObject3[j], localObject6[j])) {
          break label1111;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + localObject3[j] + ", newPath:" + localObject6[j]);
          break label1104;
          localObject2 = this.d.t().edit();
          ((SharedPreferences.Editor)localObject2).putBoolean("res_version_has_updated", true);
          ((SharedPreferences.Editor)localObject2).commit();
          VasQuickUpdateEngine.safeDeleteFile(localFile1);
          VasQuickUpdateEngine.safeDeleteFile(localFile2);
          VasQuickUpdateEngine.safeDeleteFile(localFile3);
          return;
          i = 0;
          break;
        }
      }
      label1104:
      i += 1;
      break;
      label1111:
      j += 1;
    }
  }
  
  public void initResource()
  {
    if (this.app == null) {
      return;
    }
    cB(false, true);
    String str = acgn.b(null, null, 8, 0, 0);
    if (VasQuickUpdateManager.getFileFromLocal(this.app, 16L, "iRedPacket_v3.font.zip", str, true, this.callBacker) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(acgn.b(null, null, 21, 0, 0)));
    }
    str = acgn.b(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasQuickUpdateManager.getFileFromLocal(this.app, 16L, "iRedPacket_v3.specialChar.zip", str, true, this.callBacker));
    str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
    a(false, true, "iRedPacket_v3.char300.json", VasQuickUpdateManager.getFileFromLocal(this.app, 16L, "iRedPacket_v3.char300.json", str, true, this.callBacker));
  }
  
  public void onDestroy()
  {
    if (this.app != null) {
      ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.callBacker);
    }
    this.app = null;
    this.p.evictAll();
    this.d = null;
  }
  
  void px()
  {
    for (;;)
    {
      try
      {
        if ((this.app != null) && (this.d != null) && (this.CT != null))
        {
          int i = this.CT.size();
          if (i > 0) {}
        }
        else
        {
          return;
        }
        try
        {
          aqqf.c localc = (aqqf.c)this.CT.remove(0);
          if (localc != null) {
            break label99;
          }
          px();
        }
        catch (Exception localException)
        {
          QLog.d("IndividualRedPacketResDownloader", 2, "preDownload, err=" + localException.getMessage());
        }
        continue;
        if (!new File(localObject.path).exists()) {
          break label123;
        }
      }
      finally {}
      label99:
      px();
      continue;
      label123:
      VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
      localVasQuickUpdateManager.addCallBacker(this.callBacker);
      localVasQuickUpdateManager.downloadItem(localObject.bid, localObject.scid, "silent_download.redbag");
    }
  }
  
  public void v(long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if ((this.app == null) || (0L == paramLong) || (TextUtils.isEmpty(paramString1)))
        {
          QLog.e("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit err filePath, bid=" + paramLong + ",id:" + paramString1);
          return;
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString1))
        {
          paramString2 = acgn.b(null, null, 11, 0, 0);
          VasQuickUpdateManager.getFileFromLocal(this.app, paramLong, paramString1, paramString2, true, this.callBacker);
          continue;
        }
        paramString2 = new File(acgn.b(paramString1, null, 24, 0, 0));
      }
      finally {}
      boolean bool = paramString2.exists();
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit, id: " + paramString1 + " exists: " + bool);
      }
      if (bool) {
        VasQuickUpdateEngine.safeDeleteFile(paramString2);
      }
      paramString2 = acgn.b(paramString1, null, 0, 0, 0);
      paramString1 = "luckyMoney.item." + paramString1;
    }
  }
  
  public static class a
    extends aqqf.d
  {
    public String cva;
    public String cvb = "";
    public int cwe = 100;
    public int ebC;
    public int ebD = 20;
    
    public String Cu()
    {
      if (TextUtils.isEmpty(this.cva)) {
        return "";
      }
      return this.cva;
    }
  }
  
  public static class b
    extends aqqf.d
  {
    public CustomizeStrategyFactory.a a;
    public Rect cJ;
    public String cvc;
    public int fontSize;
  }
  
  public static class c
  {
    public long bid;
    public String path;
    public String scid;
  }
  
  public static class d
  {
    public String id;
    public String name;
    public int resType;
    public int state;
    public String url;
    public int version;
  }
  
  public static class e
  {
    public static int ebE = 2;
    public static int ebF = 1;
    public aqqf.b a;
    public aqqf.b b;
    public aqqf.b c;
    public int fontId;
    public String id;
    public int type;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqf
 * JD-Core Version:    0.7.0.1
 */