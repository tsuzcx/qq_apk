import KQQ.PluginInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.GameCenterManagerImp.1;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

public class anec
  implements awos, Manager
{
  public static ConcurrentHashMap<String, Boolean> io = new ConcurrentHashMap();
  protected static byte[] mBuffer;
  private ArrayList<Long> Ap;
  private SharedPreferences X;
  private ahrx jdField_a_of_type_Ahrx;
  private GameNoticeCenter jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  private QQAppInterface app;
  private HashMap<Long, anec.a> nj;
  private HashMap<String, Integer> nk;
  
  public anec(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.X = paramQQAppInterface.getApp().getSharedPreferences("gamecenter_prefername", 0);
    dOV();
    dOW();
    this.jdField_a_of_type_Ahrx = new ahrx(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = new GameNoticeCenter(paramQQAppInterface);
    awot.a().a(this);
  }
  
  private void dOV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterManagerImp", 2, "loadGameCenterUnread.");
    }
    this.Ap = new ArrayList();
    this.nj = new HashMap();
    this.nk = new HashMap();
    String str1 = this.app.getAccount();
    if (!TextUtils.isEmpty(str1))
    {
      Object localObject = this.X.getString("gc_pluginid" + str1, null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              return;
            }
            String str2 = localObject[i];
            try
            {
              long l = Long.parseLong(str2);
              if (l > 0L)
              {
                anec.a locala = new anec.a();
                locala.akD = this.X.getLong("gc_unread" + str1 + "_" + str2, 0L);
                locala.cET = this.X.getBoolean("gc_newmsg" + str1 + "_" + str2, false);
                locala.cEU = this.X.getBoolean("gc_redpoint" + str1 + "_" + str2, false);
                locala.cEV = this.X.getBoolean("gc_tab" + str1 + "_" + str2, false);
                locala.mText = this.X.getString("gc_text" + str1 + "_" + str2, "");
                locala.cdp = this.X.getString("gc_icon" + str1 + "_" + str2, "");
                locala.mType = this.X.getInt("gc_type" + str1 + "_" + str2, -1);
                this.Ap.add(Long.valueOf(l));
                this.nj.put(Long.valueOf(l), locala);
              }
            }
            catch (Exception localException)
            {
              label501:
              break label501;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void dOX()
  {
    if ((this.Ap != null) && (this.nj != null))
    {
      String str2 = this.app.getAccount();
      SharedPreferences.Editor localEditor = this.X.edit();
      String str1 = "";
      Iterator localIterator = this.Ap.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        if (this.nj.containsKey(Long.valueOf(l)))
        {
          if (str1.length() > 0) {}
          for (str1 = str1 + "&" + l;; str1 = str1 + l)
          {
            anec.a locala = (anec.a)this.nj.get(Long.valueOf(l));
            localEditor.putLong("gc_unread" + str2 + "_" + l, locala.akD);
            localEditor.putBoolean("gc_newmsg" + str2 + "_" + l, locala.cET);
            localEditor.putBoolean("gc_redpoint" + str2 + "_" + l, locala.cEU);
            localEditor.putBoolean("gc_tab" + str2 + "_" + l, locala.cEV);
            localEditor.putString("gc_text" + str2 + "_" + l, locala.mText);
            localEditor.putString("gc_icon" + str2 + "_" + l, locala.cdp);
            localEditor.putInt("gc_type" + str2 + "_" + l, locala.mType);
            break;
          }
        }
      }
      localEditor.putString("gc_pluginid" + str2, str1);
      localEditor.commit();
    }
  }
  
  public void Qr(String paramString)
  {
    if (this.nk.containsKey(paramString)) {
      this.nk.remove(paramString);
    }
  }
  
  public ahrx a()
  {
    return this.jdField_a_of_type_Ahrx;
  }
  
  public GameNoticeCenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter;
  }
  
  public void a(MsgBody paramMsgBody)
  {
    long l1 = -1L;
    if (paramMsgBody == null) {}
    int i;
    do
    {
      return;
      i = paramMsgBody.uint32_cmd.get();
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "onReceivePushMsg cmd=" + i);
      }
      switch (i)
      {
      default: 
        return;
      case 1: 
        dOZ();
        tbb.a(this.app, "426", "205581", "", "42601", "1", "116");
        return;
      case 2: 
        try
        {
          long l2 = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8()).optLong("version", -1L);
          l1 = l2;
        }
        catch (JSONException paramMsgBody)
        {
          for (;;)
          {
            paramMsgBody.printStackTrace();
          }
        }
        awot.a().S(true, l1);
        return;
      }
      try
      {
        i = new JSONObject(paramMsgBody.bytes_data.get().toStringUtf8()).optInt("subCmd");
        paramMsgBody = new aned(this, i);
        if (i == 1)
        {
          tbl.a().a(paramMsgBody);
          return;
        }
      }
      catch (JSONException paramMsgBody)
      {
        QLog.e("GameCenterManagerImp", 1, "onReceivePushMsg screenshot push e=" + paramMsgBody.toString());
        return;
      }
      if (i == 2)
      {
        tbl.a().b(paramMsgBody);
        return;
      }
    } while (i != 3);
    tbl.a().c(paramMsgBody);
  }
  
  public boolean at(List<PluginInfo> paramList)
  {
    boolean bool1;
    int i;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = false;
      i = -1;
      int m = 0;
      if (m < paramList.size())
      {
        PluginInfo localPluginInfo = (PluginInfo)paramList.get(m);
        boolean bool3 = bool1;
        int k = i;
        if (localPluginInfo != null) {
          if (this.nj.get(Long.valueOf(localPluginInfo.Id)) != null) {}
        }
        anec.a locala;
        boolean bool2;
        label296:
        do
        {
          m += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",plugin:" + localPluginInfo.toString());
          }
          locala = (anec.a)this.nj.get(Long.valueOf(localPluginInfo.Id));
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",before unreaddata:" + locala.toString());
          }
          if (localPluginInfo.Count > 0L)
          {
            j = i;
            if (locala.akD != localPluginInfo.Count)
            {
              bool2 = true;
              bool1 = bool2;
              j = i;
              if (localPluginInfo.Tab)
              {
                j = 0;
                bool1 = bool2;
              }
            }
            locala.akD = localPluginInfo.Count;
            locala.mText = localPluginInfo.Text;
            locala.cET = false;
            locala.cEU = false;
            if (TextUtils.isEmpty(locala.mText))
            {
              locala.mType = 1;
              locala.cEV = localPluginInfo.Tab;
              bool2 = bool1;
            }
          }
          do
          {
            bool3 = bool2;
            k = j;
            if (QLog.isColorLevel())
            {
              QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",unreaddata:" + locala.toString());
              k = j;
              bool3 = bool2;
            }
            bool1 = bool3;
            i = k;
            break;
            locala.mType = 4;
            break label296;
            if (localPluginInfo.Flag)
            {
              if (locala.akD > 0L) {
                break;
              }
              j = i;
              if (!locala.cET)
              {
                bool2 = true;
                bool1 = bool2;
                j = i;
                if (localPluginInfo.Tab) {
                  if (i != -1)
                  {
                    bool1 = bool2;
                    j = i;
                    if (i != 4) {}
                  }
                  else
                  {
                    j = 1;
                    bool1 = bool2;
                  }
                }
              }
              locala.cET = localPluginInfo.Flag;
              locala.cEU = false;
              locala.akD = 0L;
              locala.mText = localPluginInfo.Text;
              if (TextUtils.isEmpty(locala.mText)) {}
              for (locala.mType = 3;; locala.mType = 6)
              {
                locala.cEV = localPluginInfo.Tab;
                bool2 = bool1;
                break;
              }
            }
            bool2 = bool1;
            j = i;
          } while (!localPluginInfo.RedPoint);
        } while ((locala.akD > 0L) || ((localPluginInfo.Id == 769L) && (locala.cET)));
        j = i;
        if (!locala.cEU)
        {
          bool2 = true;
          bool1 = bool2;
          j = i;
          if (i == -1)
          {
            bool1 = bool2;
            j = i;
            if (localPluginInfo.Tab)
            {
              j = 4;
              bool1 = bool2;
            }
          }
        }
        locala.cEU = localPluginInfo.RedPoint;
        locala.cET = false;
        locala.akD = 0L;
        locala.mText = localPluginInfo.Text;
        locala.cdp = localPluginInfo.PicUrl;
        if (TextUtils.isEmpty(locala.mText)) {
          if (TextUtils.isEmpty(locala.cdp)) {
            locala.mType = 2;
          }
        }
        for (;;)
        {
          locala.cEV = localPluginInfo.Tab;
          bool2 = bool1;
          break;
          locala.mType = 7;
          continue;
          locala.mType = 5;
        }
      }
      dOX();
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "setNewUnread.changeType=" + i + ",ischange:" + bool1);
      }
      if (i != -1)
      {
        paramList = new NewIntent(this.app.getApplication(), anee.class);
        paramList.setAction("gc_refresh_ui");
        paramList.putExtra("gc_notify_type", i);
        this.app.startServlet(paramList);
        j = i;
      }
    }
    for (;;)
    {
      if (j != -1)
      {
        return true;
        j = i;
        if (bool1)
        {
          paramList = new NewIntent(this.app.getApplication(), anee.class);
          paramList.setAction("gc_refresh_ui");
          paramList.putExtra("gc_notify_type", 3);
          this.app.startServlet(paramList);
          j = i;
        }
      }
      else
      {
        return false;
        j = -1;
      }
    }
  }
  
  public void b(String paramString, JSONArray paramJSONArray)
  {
    int j = 0;
    int i;
    if (paramJSONArray != null)
    {
      i = paramJSONArray.length();
      if (i >= 1) {
        break label23;
      }
    }
    label23:
    JSONArray localJSONArray;
    do
    {
      return;
      i = 0;
      break;
      localJSONArray = paramJSONArray;
      if ("APPOINTMENT_TGPA_LIST".equals(paramString))
      {
        localJSONArray = new JSONArray();
        while (j < i)
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(j);
          if ((localJSONObject != null) && (localJSONObject.optInt("package_type") == 1)) {
            localJSONArray.put(localJSONObject);
          }
          j += 1;
        }
      }
    } while (localJSONArray.length() <= 0);
    tbb.V(paramString, localJSONArray.toString());
  }
  
  public void c(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    Object localObject;
    if (this.nj.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (anec.a)this.nj.get(Long.valueOf(paramLong1));
      ((anec.a)localObject).cET = paramBoolean;
      ((anec.a)localObject).akD = paramLong2;
      this.nj.put(Long.valueOf(paramLong1), localObject);
      dOX();
      localObject = new NewIntent(this.app.getApplication(), anee.class);
      ((NewIntent)localObject).setAction("gc_refresh_ui");
      if ((paramLong2 <= 0L) && (!paramBoolean)) {
        break label140;
      }
      if (paramLong2 <= 0L) {
        break label127;
      }
      ((NewIntent)localObject).putExtra("gc_notify_type", 0);
    }
    for (;;)
    {
      this.app.startServlet((NewIntent)localObject);
      return;
      label127:
      ((NewIntent)localObject).putExtra("gc_notify_type", 1);
      continue;
      label140:
      ((NewIntent)localObject).putExtra("gc_notify_type", 3);
    }
  }
  
  public boolean cI(long paramLong)
  {
    if (this.nj.containsKey(Long.valueOf(paramLong))) {
      return ((anec.a)this.nj.get(Long.valueOf(paramLong))).cET;
    }
    return false;
  }
  
  public void dOW()
  {
    Object localObject1 = this.app.getCurrentAccountUin();
    Object localObject2 = new File(this.app.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + (String)localObject1);
    if ((!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterManagerImp", 2, "BusinessInfoCheckUpdateItem pb file does not exist,uin=" + (String)localObject1);
      }
    }
    for (;;)
    {
      return;
      Boolean localBoolean = (Boolean)io.get(localObject1);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        mBuffer = null;
        io.clear();
        mBuffer = aqhq.fileToBytes((File)localObject2);
        io.put(localObject1, Boolean.valueOf(true));
      }
      localObject2 = mBuffer;
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GameCenterManagerImp", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
        return;
      }
      this.nk.clear();
      try
      {
        localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom((byte[])localObject2);
        int i = 0;
        while (i < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size())
        {
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) {
            this.nk.put(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get(), Integer.valueOf(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get()));
          }
          i += 1;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public void dOY()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.app.getCurrentAccountUin(), 600);
    int j = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), 0);
    int k = (int)(System.currentTimeMillis() / 1000L);
    if ((k - j > i) || (k < j)) {
      ((FriendListHandler)this.app.getBusinessHandler(1)).aW(true, 2);
    }
  }
  
  public void dOZ()
  {
    ThreadManager.excute(new GameCenterManagerImp.1(this), 192, null, false);
  }
  
  public int ee(String paramString)
  {
    if (this.nk.containsKey(paramString)) {
      return ((Integer)this.nk.get(paramString)).intValue();
    }
    return -1;
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13625");
    localHashSet.add("12942");
    localHashSet.add("13629");
    return null;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterManagerImp", 2, "onCmdRsp cmd=" + paramString + ",ret=" + paramLong + ",dataJson=" + paramJSONObject);
    }
    if ("13625".equals(paramString)) {
      if ((paramLong != 0L) || (paramJSONObject == null)) {}
    }
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterManagerImp", 2, "onGetAutoDownloadApk data=" + paramJSONObject.toString());
        }
        tbb.j("APPOINTMENT_LASTGET_TIME", NetConnInfoCenter.getServerTime());
        tbb.j("APPOINTMENT_LOAD_GAP", paramJSONObject.optLong("load_gap"));
        tbb.br(paramJSONObject.optLong("res_valid") * 1000L);
        t(paramJSONObject.optJSONArray("pre_download_list"));
        b("APPOINTMENT_UPDATE_LIST", paramJSONObject.optJSONArray("pre_update_list"));
        b("APPOINTMENT_TGPA_LIST", paramJSONObject.optJSONArray("tgpa_apk_list"));
        if (GameCenterCheck.ND()) {
          tax.registerReceiver();
        }
        GameCenterCheck.bCq();
        GameCenterCheck.bCp();
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("GameCenterManagerImp", 1, "onGetAutoDownloadApk error=" + paramIntent.toString());
        return;
      }
      if (!"12942".equals(paramString)) {
        break;
      }
    } while ((paramLong != 0L) || (paramJSONObject == null));
    for (;;)
    {
      try
      {
        paramIntent = paramJSONObject.optJSONArray("pkg_list");
        if (paramIntent == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterManagerImp", 2, "onGetAutoDownloadRes data=" + paramIntent.toString());
        }
        paramString = new JSONArray();
        if (i < paramIntent.length())
        {
          paramJSONObject = paramIntent.getJSONObject(i);
          if (tbb.c(0, paramJSONObject.optString("appid"), paramJSONObject.optString("resName"))) {
            break label537;
          }
          tbb.startDownload(paramJSONObject.toString(), false, 1);
          paramString.put(paramJSONObject.optString("resName"));
          break label537;
        }
        if (paramString.length() <= 0) {
          break;
        }
        awot.a().b(null, paramString);
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("GameCenterManagerImp", 1, "onGetAutoDownloadRes error =" + paramIntent.toString());
        return;
      }
      if ((!"13629".equals(paramString)) || (paramLong != 0L) || (paramJSONObject == null)) {
        break;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterManagerImp", 2, "onGetUnpackApk data=" + paramJSONObject.toString());
        }
        b("UNPACK_APK_LIST", paramJSONObject.optJSONArray("tgpa_unpack_list"));
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("GameCenterManagerImp", 1, "onGetUnpackApk error=" + paramIntent.toString());
        return;
      }
      label537:
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    awot.a().b(this);
    GameCenterReceiver.unRegisterReceiver();
  }
  
  public void t(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1)) {
      return;
    }
    for (;;)
    {
      String[] arrayOfString;
      int i;
      String str1;
      try
      {
        arrayOfString = tbb.gQ("APPOINTMENT_HAS_DOWNLOAD_LIST").split("\\|");
        i = 0;
        if (i >= paramJSONArray.length()) {
          break;
        }
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject == null) {
          break label282;
        }
        str1 = localJSONObject.optString("appid");
        String str2 = localJSONObject.optString("packageName");
        boolean bool = localJSONObject.optBoolean("isRes");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
          break label282;
        }
        tbb.V("APPID_PKGNAME_" + str1, str2);
        if (bool)
        {
          tbb.X(str1, "APPOINTMENT_RES_LIST");
          tbb.a(this.app, "426", "202238", str1, "42601", "1", "116");
        }
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = 0;
      if (j < arrayOfString.length) {
        if ((TextUtils.isEmpty(arrayOfString[j])) || (TextUtils.isEmpty(str1)) || (!arrayOfString[j].equals(str1))) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label282;
        }
        tbb.X(str1, "APPOINTMENT_LIST");
        tbb.h(str1, paramJSONArray.get(i).toString(), "APPOINT_APPID_DETAIL_");
        tbb.a(this.app, "426", "202238", str1, "42601", "1", "116");
        break label282;
        j += 1;
        break;
      }
      label282:
      i += 1;
    }
  }
  
  public class a
  {
    public long akD;
    public boolean cET;
    public boolean cEU;
    public boolean cEV;
    public String cdp = "";
    public String mText = "";
    public int mType;
    
    public a() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("mUnread=" + this.akD);
      localStringBuilder.append(",mNewMsg=" + this.cET);
      localStringBuilder.append("mText=" + this.mText);
      localStringBuilder.append(",mIconPath=" + this.cdp);
      localStringBuilder.append("mRedPoint=" + this.cEU);
      localStringBuilder.append(",mTab=" + this.cEV);
      localStringBuilder.append(",mType=" + this.mType);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anec
 * JD-Core Version:    0.7.0.1
 */