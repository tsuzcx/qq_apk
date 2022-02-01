package com.tencent.mobileqq.app;

import acfs;
import acfv;
import acfx;
import acgh;
import acie;
import ahyk;
import ajpj;
import ajrk;
import anaz;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import apdd;
import aqhq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatInfo.ExitedHotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;

public class HotChatManager
  implements Manager
{
  public static boolean bHJ = true;
  static boolean bHK;
  static boolean bHL;
  private long PN;
  public long PO = 20000L;
  public long PP = 20000L;
  ahyk jdField_a_of_type_Ahyk;
  a jdField_a_of_type_ComTencentMobileqqAppHotChatManager$a = null;
  Boolean am = null;
  QQAppInterface app;
  boolean bHM = false;
  boolean bHN = false;
  volatile boolean bHO = false;
  SparseArray<String> ch = new SparseArray();
  int cvR = 0;
  ConcurrentHashMap<String, String> dZ = null;
  final Map<String, HotChatInfo> jm = new ConcurrentHashMap();
  private final Object lock = new Object();
  List<String> xx = null;
  
  @Deprecated
  public HotChatManager() {}
  
  public HotChatManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    qh();
    ThreadManager.getFileThreadHandler().post(new HotChatManager.1(this));
  }
  
  public static int A(QQAppInterface paramQQAppInterface)
  {
    return b(paramQQAppInterface).getInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", 3);
  }
  
  public static void N(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramQQAppInterface = b(paramQQAppInterface).edit();
    paramQQAppInterface.putInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", i);
    paramQQAppInterface.commit();
  }
  
  public static boolean Y(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("identify_flag")));
  }
  
  public static String a(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      paramWifiInfo = "";
    }
    String str;
    do
    {
      do
      {
        return paramWifiInfo;
        str = paramWifiInfo.getSSID();
        if (str == null) {
          break;
        }
        paramWifiInfo = str;
      } while (!str.startsWith("\""));
      paramWifiInfo = str;
    } while (!str.endsWith("\""));
    return str.substring(1, str.length() - 1);
    return "";
  }
  
  public static Map<String, HotChatInfo.ExitedHotChatInfo> a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = b(paramQQAppInterface).getString("PREF_KEY_EXITED_HOTCHATINFO", "");
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label76;
        }
        paramQQAppInterface = (Map)new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramQQAppInterface.getBytes(), 0))).readObject();
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("HotChatManager", 2, "", paramQQAppInterface);
      return null;
      label76:
      paramQQAppInterface = null;
    }
  }
  
  public static im_msg_body.Elem a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (!a(paramAppInterface, false)) {
      return null;
    }
    paramAppInterface = new im_msg_body.NearByMessageType();
    paramAppInterface.uint32_identify_type.set(1);
    paramMessageRecord = new im_msg_body.Elem();
    paramMessageRecord.near_by_msg.set(paramAppInterface);
    return paramMessageRecord;
  }
  
  private void a(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      return;
    }
    HashMap localHashMap = (HashMap)a(this.app);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      if (localHashMap.containsKey(paramHotChatInfo.troopUin)) {
        ((HotChatInfo.ExitedHotChatInfo)localHashMap.get(paramHotChatInfo.troopUin)).leftTime = paramHotChatInfo.leftTime;
      }
      for (;;)
      {
        b(this.app, localHashMap);
        return;
        HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo = new HotChatInfo.ExitedHotChatInfo();
        localExitedHotChatInfo.leftTime = paramHotChatInfo.leftTime;
        localExitedHotChatInfo.troopUin = paramHotChatInfo.troopUin;
        localHashMap.put(localExitedHotChatInfo.troopUin, localExitedHotChatInfo);
      }
    }
  }
  
  private void a(List<HotChatInfo> paramList, boolean paramBoolean, ArrayList<HotChatInfo> paramArrayList)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
        if (!localHotChatInfo.isWifiHotChat) {
          if (localHotChatInfo.userCreate == 0)
          {
            paramArrayList.add(localHotChatInfo);
            if (QLog.isColorLevel()) {
              QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newPOIHotChat = " + localHotChatInfo);
            }
          }
          else
          {
            paramArrayList.add(localHotChatInfo);
            if (QLog.isColorLevel()) {
              QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newUserCreateHotChat = " + localHotChatInfo);
            }
          }
        }
      }
      if (!paramBoolean) {
        acie.a(this.app).ja(paramList);
      }
    }
  }
  
  private void a(boolean paramBoolean1, HashSet<String> paramHashSet, ArrayList<HotChatInfo> paramArrayList1, boolean paramBoolean2, ArrayList<HotChatInfo> paramArrayList2)
  {
    Iterator localIterator1 = paramArrayList1.iterator();
    Object localObject2;
    Object localObject1;
    if (localIterator1.hasNext())
    {
      localObject2 = (HotChatInfo)localIterator1.next();
      Iterator localIterator2 = paramArrayList2.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject1 = (HotChatInfo)localIterator2.next();
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "onGetJoinedHotChatList old.trooUin=:" + ((HotChatInfo)localObject1).troopUin + ",hc.troopUin=:" + ((HotChatInfo)localObject2).troopUin);
        }
      } while (!((HotChatInfo)localObject1).troopUin.equals(((HotChatInfo)localObject2).troopUin));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList exist=:" + bool);
      }
      if (bool)
      {
        ((HotChatInfo)localObject1).updateHotChatInfo((HotChatInfo)localObject2);
        localObject2 = this.app.a().createEntityManager();
        ((EntityManager)localObject2).update((Entity)localObject1);
        ((EntityManager)localObject2).close();
        if (!paramBoolean2) {
          break;
        }
        DX(((HotChatInfo)localObject1).troopUin);
        break;
      }
      a((HotChatInfo)localObject2, 4);
      paramHashSet.add(((HotChatInfo)localObject2).troopUin);
      break;
      paramHashSet = paramArrayList2.iterator();
      label340:
      for (;;)
      {
        if (paramHashSet.hasNext())
        {
          paramArrayList2 = (HotChatInfo)paramHashSet.next();
          if (paramArrayList2.isGameRoom == paramBoolean1)
          {
            localObject1 = paramArrayList1.iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
            } while (!((HotChatInfo)((Iterator)localObject1).next()).troopUin.equals(paramArrayList2.troopUin));
          }
        }
        else
        {
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label340;
            }
            b(paramArrayList2, HotChatStateWrapper.wrap(4));
            a(paramArrayList2);
            break;
            return;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (!bHL) {
      bHL = paramAppInterface.getPreferences().getBoolean("hotchat_auth_flag", paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "get authFlag:" + bHL);
    }
    return bHL;
  }
  
  public static boolean ae(QQAppInterface paramQQAppInterface)
  {
    bHK = true;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "doesSupportHotChat:" + bHK);
    }
    return bHK;
  }
  
  public static boolean af(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_SHELL", false);
  }
  
  public static int au(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if (paramInt1 == 2) {
        return 2130843388;
      }
      break;
    case 1: 
      return 2130843399;
    }
    if (paramInt1 == 3) {
      return 2130843398;
    }
    return 2130843396;
  }
  
  public static SharedPreferences b(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("Config_Before_load_RU" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void b(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "update authFlag:" + paramBoolean + " old:" + bHL);
    }
    if (bHL == paramBoolean) {
      return;
    }
    paramAppInterface.getPreferences().edit().putBoolean("hotchat_auth_flag", paramBoolean).commit();
    bHL = paramBoolean;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Map<String, HotChatInfo.ExitedHotChatInfo> paramMap)
  {
    if ((paramQQAppInterface == null) || (paramMap == null)) {}
    do
    {
      return;
      try
      {
        paramQQAppInterface = b(paramQQAppInterface);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramMap);
        paramMap = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
        paramQQAppInterface = paramQQAppInterface.edit();
        paramQQAppInterface.putString("PREF_KEY_EXITED_HOTCHATINFO", paramMap);
        paramQQAppInterface.commit();
        return;
      }
      catch (Exception paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("HotChatManager", 2, "", paramQQAppInterface);
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    if (this.bHM)
    {
      this.bHM = false;
      Object localObject2 = dY();
      if (QLog.isColorLevel())
      {
        Iterator localIterator = ((List)localObject2).iterator();
        HotChatInfo localHotChatInfo;
        for (localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + " " + localHotChatInfo.troopUin) {
          localHotChatInfo = (HotChatInfo)localIterator.next();
        }
        QLog.d("HotChatManager", 2, "troopUin:" + (String)localObject1);
      }
      Object localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotChatInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!paramHashSet.contains(((HotChatInfo)localObject2).troopUin))) {
          b((HotChatInfo)localObject2, 0);
        }
      }
    }
  }
  
  private void cJl()
  {
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Object localObject2 = new File(BaseApplicationImpl.getApplication().getFilesDir() + "/hotchatclassify");
      if (!((File)localObject2).exists()) {
        return;
      }
      localObject1 = ((DocumentBuilder)localObject1).parse((File)localObject2).getElementsByTagName("data");
      localObject2 = new SparseArray();
      int i = 0;
      while (i < ((NodeList)localObject1).getLength())
      {
        Object localObject3 = (Element)((NodeList)localObject1).item(i);
        String str = ((Element)localObject3).getElementsByTagName("key").item(0).getFirstChild().getNodeValue();
        localObject3 = ((Element)localObject3).getElementsByTagName("value").item(0).getFirstChild().getNodeValue();
        if (QLog.isColorLevel()) {
          QLog.i("HotChatManager", 2, "buildClassifyInfos, key = " + str + ",value=" + (String)localObject3);
        }
        ((SparseArray)localObject2).put(Integer.valueOf(str).intValue(), localObject3);
        i += 1;
      }
      this.ch = ((SparseArray)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("HotChatManager", 1, "buildClassifyInfos exception happen:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public static int d(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = 2130843400;
    HotChatManager localHotChatManager = paramQQAppInterface.a(false);
    paramQQAppInterface = null;
    if (localHotChatManager != null) {
      paramQQAppInterface = localHotChatManager.a(paramString);
    }
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (!paramQQAppInterface.isWifiHotChat) {
        i = au(paramQQAppInterface.hotThemeGroupFlag, 2130843400);
      }
    }
    return i;
  }
  
  private void qh()
  {
    boolean bool = getSp().getBoolean("HAS_USING_HOTCHAT", false);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "hasJoinedHotChat = " + bool);
    }
    if ((bool) || (ae(this.app)))
    {
      Object localObject = (ArrayList)this.app.a().createEntityManager().query(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if ((localHotChatInfo.state != 5) && (!localHotChatInfo.isWifiHotChat)) {
            this.jm.put(localHotChatInfo.troopUin, localHotChatInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.d("HotChatManager", 2, "initCache  HotChatInfo = " + localHotChatInfo);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "initCache  size = " + this.jm.size());
      }
    }
  }
  
  public static void v(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatManager", new Object[] { "saveSupportHotChatFlag", Boolean.valueOf(paramBoolean), Boolean.valueOf(bHK) });
    }
    Object localObject = paramQQAppInterface.getPreferences().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("DOES_SUPPORT_HOT_CHAT", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if ((!bHK) && (paramBoolean))
    {
      bHK = true;
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      ((HotChatManager)localObject).bHM = true;
      if (QLog.isColorLevel()) {
        ajrk.m("HotChatManager", new Object[] { "saveSupportHotChatFlag", "needGetMessage", Boolean.valueOf(((HotChatManager)localObject).bHM) });
      }
      ((acfv)paramQQAppInterface.getBusinessHandler(35)).cJk();
    }
  }
  
  public static void w(Context paramContext, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null) {
      return;
    }
    paramContext = new Intent((Context)localObject, NearbyActivity.class);
    paramContext.putExtra("ENTER_TIME", System.currentTimeMillis());
    paramContext.putExtra("TAB_TYPE", 3);
    paramContext.setFlags(67108864);
    if (paramBoolean) {
      paramContext.putExtra("abp_flag", paramBoolean);
    }
    ((Context)localObject).startActivity(paramContext);
  }
  
  public void DW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    EntityManager localEntityManager = this.app.a().createEntityManager();
    paramString.ruState = 1;
    localEntityManager.update(paramString);
    localEntityManager.close();
  }
  
  public void DX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.app.b().a(paramString, 1, true, false);
      this.app.a().Qn(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "clear hotChat msgCache done");
  }
  
  public void DY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      String str;
      do
      {
        SQLiteDatabase localSQLiteDatabase;
        do
        {
          return;
          localSQLiteDatabase = this.app.getWritableDatabase();
        } while (localSQLiteDatabase == null);
        str = MessageRecord.getTableName(paramString, 1);
        i = localSQLiteDatabase.getCount(str);
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "clearLimitCountHotChatMsgCache, totalcount=" + i);
        }
      } while ((i <= 250) || (str == null));
      int j = Math.max(i - 200, 50);
      ((apdd)this.app.b().a(1)).a(paramString, 1, true, false, str, j);
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "clearLimitCountHotChatMsgCache, count=" + i);
  }
  
  public void DZ(String paramString)
  {
    aqhq.writeFile(BaseApplicationImpl.getApplication().getFilesDir() + "/hotchatclassify", paramString);
    cJl();
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "updateClassifyInfo, xmldata = " + paramString);
    }
  }
  
  public void EX(boolean paramBoolean)
  {
    this.bHN = paramBoolean;
  }
  
  public void Jf(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "setMyUinCharmLevel, charmLevel = " + paramInt);
    }
    this.cvR = paramInt;
  }
  
  public ahyk a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ahyk == null) && (paramBoolean)) {
      this.jdField_a_of_type_Ahyk = new ahyk(this.app);
    }
    return this.jdField_a_of_type_Ahyk;
  }
  
  public HotChatInfo a()
  {
    Iterator localIterator = this.jm.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.userCreate == 0) && (localHotChatInfo.state == 0)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public HotChatInfo a(int paramInt)
  {
    Iterator localIterator = this.jm.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 0) && (localHotChatInfo.apolloGameId == paramInt)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public HotChatInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "getHotCatInfo troopUin isEmpty," + paramString);
      }
      return null;
    }
    return (HotChatInfo)this.jm.get(paramString);
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onJoinedHotChat hc = " + paramHotChatInfo + ", preState:" + paramInt);
    }
    if (paramHotChatInfo.adminLevel == 0)
    {
      paramHotChatInfo.state = 0;
      paramHotChatInfo.ruState = 0;
      this.jm.put(paramHotChatInfo.troopUin, paramHotChatInfo);
      EntityManager localEntityManager = this.app.a().createEntityManager();
      localEntityManager.persistOrReplace(paramHotChatInfo);
      localEntityManager.close();
      acie.a(this.app).Er(paramHotChatInfo.troopUin);
      b(paramHotChatInfo, paramInt);
      acgh.cr(this.app);
      paramHotChatInfo = getSp().edit();
      if (this.jm.isEmpty()) {
        break label197;
      }
    }
    label197:
    for (boolean bool = true;; bool = false)
    {
      paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatInfo.commit();
      return;
      if (paramHotChatInfo.adminLevel != 1) {
        break;
      }
      ((ajpj)this.app.getManager(106)).MG(paramHotChatInfo.ownerUin);
      break;
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    paramPbGetGroupMsgResp = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onPullRecentGroupMsg troopUin = " + paramString + ", doSome:" + paramInt + ", hotChat = " + paramPbGetGroupMsgResp);
    }
    if (paramPbGetGroupMsgResp != null)
    {
      if (paramInt != 1) {
        break label90;
      }
      acfx.a(this.app, paramPbGetGroupMsgResp, this.app.getApp().getString(2131694658), true);
    }
    for (;;)
    {
      return;
      label90:
      if (paramInt == 4)
      {
        if (paramPbGetGroupMsgResp.isWifiHotChat)
        {
          acfx.a(this.app, paramPbGetGroupMsgResp, this.app.getApp().getString(2131694655, new Object[] { paramPbGetGroupMsgResp.name }), true);
          return;
        }
        if (1 == paramPbGetGroupMsgResp.adminLevel) {
          break;
        }
        paramString = this.app.getApp().getString(2131694654, new Object[] { paramPbGetGroupMsgResp.name });
        Object localObject = this.app.b().i(paramPbGetGroupMsgResp.troopUin, 1, 10);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (((localMessageRecord instanceof MessageForNewGrayTips)) && (localMessageRecord.msg.equals(paramString))) {
              ajrk.m("HotChatManager", new Object[] { "onPullRecentGroupMsg", "grayTips exist in last 10 msgs" });
            }
          }
        }
        for (paramInt = 0; paramInt != 0; paramInt = 1)
        {
          acfx.a(this.app, paramPbGetGroupMsgResp, paramString, true);
          return;
        }
      }
    }
  }
  
  public boolean aao()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "needReqGlobleAdminFlag, svrTime:" + l + "|mNextReqGlobleAdminFlagTime:" + this.PN);
    }
    return NetConnInfoCenter.getServerTime() > this.PN;
  }
  
  public boolean aap()
  {
    return this.bHN;
  }
  
  public boolean aaq()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_wifi_shell_setting", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_wifi_shell_setting", false).commit();
    }
    return bool;
  }
  
  public boolean aar()
  {
    int i = A(this.app);
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "isAllowedToSendSplashpic, myUinCharmLevel = " + this.cvR + ", splashpicCharmRequirement = " + i);
    }
    return this.cvR >= i;
  }
  
  public final void aj(List<HotChatInfo> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList,hotchat list = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatManager", new Object[] { "onGetJoinedHotChatList", Integer.valueOf(paramList.size()), Boolean.valueOf(this.bHM) });
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    a(paramList, paramBoolean, localArrayList);
    paramList = getSp();
    boolean bool = paramList.getBoolean("qq_update_5.9", true);
    a(paramBoolean, localHashSet, localArrayList, bool, ct());
    acgh.cr(this.app);
    paramList = paramList.edit();
    if (!this.jm.isEmpty()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramList.putBoolean("HAS_USING_HOTCHAT", paramBoolean);
      if (bool) {
        paramList.putBoolean("qq_update_5.9", false);
      }
      paramList.commit();
      c(localHashSet);
      return;
    }
  }
  
  public HotChatInfo b(String paramString)
  {
    Iterator localIterator = this.jm.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if (localHotChatInfo.uuid.equals(paramString)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void b(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatManager", new Object[] { "pullRecentGroupMsg", Integer.valueOf(paramInt), paramHotChatInfo.troopUin, paramHotChatInfo.name });
    }
    this.app.b().A(paramHotChatInfo.troopUin, paramInt);
  }
  
  public void b(HotChatInfo paramHotChatInfo, HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "onExitHotChat hc = " + paramHotChatInfo + ", ts = " + paramHotChatStateWrapper);
    }
    if ((paramHotChatInfo == null) || (paramHotChatStateWrapper == null)) {
      return;
    }
    ((ajpj)this.app.getManager(106)).MG(paramHotChatInfo.ownerUin);
    acgh.cr(this.app);
    int i = paramHotChatStateWrapper.targetState;
    paramHotChatInfo.onExit(i);
    paramHotChatStateWrapper = this.app.a().createEntityManager();
    if ((i == 4) || (i == 1))
    {
      this.jm.remove(paramHotChatInfo.troopUin);
      paramHotChatStateWrapper.remove(paramHotChatInfo);
      paramHotChatStateWrapper.close();
      if ((i != 6) && (i != 7)) {
        break label249;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("HotChatManager", 2, "onExitHotChat no need to clear message");
      }
      label159:
      paramHotChatStateWrapper = getSp().edit();
      if (this.jm.isEmpty()) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      paramHotChatStateWrapper.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatStateWrapper.commit();
      acie.a(this.app).Es(paramHotChatInfo.troopUin);
      ((acfs)this.app.getManager(255)).O(paramHotChatInfo.troopUin, i);
      return;
      paramHotChatStateWrapper.update(paramHotChatInfo);
      break;
      label249:
      DY(paramHotChatInfo.troopUin);
      a(paramHotChatInfo);
      break label159;
    }
  }
  
  public HotChatInfo c(String paramString)
  {
    Iterator localIterator = this.jm.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (TextUtils.equals(localHotChatInfo.troopCode, paramString))) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void cJm()
  {
    if (this.cvR <= 0) {
      ThreadManager.post(new HotChatManager.2(this), 10, null, false);
    }
  }
  
  public void cJn()
  {
    for (;;)
    {
      Iterator localIterator;
      HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo;
      try
      {
        Map localMap1 = a(this.app);
        if (localMap1 == null) {
          return;
        }
        if (this.app.getWritableDatabase() == null) {
          continue;
        }
        long l = System.currentTimeMillis();
        localIterator = localMap1.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label215;
        }
        localExitedHotChatInfo = (HotChatInfo.ExitedHotChatInfo)((Map.Entry)localIterator.next()).getValue();
        if (localExitedHotChatInfo == null) {
          continue;
        }
        HotChatInfo localHotChatInfo = a(localExitedHotChatInfo.troopUin);
        if ((localHotChatInfo != null) && (localHotChatInfo.state == 0))
        {
          localIterator.remove();
          continue;
        }
        if (Math.abs(l - localExitedHotChatInfo.leftTime) < 604800000L) {
          continue;
        }
      }
      finally {}
      if ((localExitedHotChatInfo.troopUin != null) && (localExitedHotChatInfo.troopUin.length() > 2)) {
        this.app.b().N(localExitedHotChatInfo.troopUin, 1);
      }
      for (;;)
      {
        localIterator.remove();
        break;
        QLog.d("HotChatManager", 1, "clearUnUsableHotChatTable exitedInfo.troopUin isEmpty:" + localExitedHotChatInfo.troopUin);
      }
      label215:
      b(this.app, localMap2);
    }
  }
  
  public ArrayList<HotChatInfo> ct()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jm.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public List<HotChatInfo> dX()
  {
    ArrayList localArrayList1 = new ArrayList(this.jm.values());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  public List<HotChatInfo> dY()
  {
    Object localObject = new ArrayList(this.jm.values());
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public void eM(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "handleGetHotchatVList, json:" + paramString2);
    }
    aqhq.writeFile(BaseApplicationImpl.getContext().getFilesDir() + File.separator + paramString1 + "_nearby_hotchat_v_list", paramString2);
    ArrayList localArrayList;
    if (this.xx != null)
    {
      localArrayList = new ArrayList();
      paramString1 = null;
      try
      {
        paramString2 = new JSONObject(paramString2).getJSONArray("vusers");
        paramString1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          int i;
          paramString2.printStackTrace();
        }
        this.xx.clear();
        this.xx.addAll(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$a == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$a.cJo();
      }
      if (paramString1 != null)
      {
        i = 0;
        while (i < paramString1.length())
        {
          paramString2 = paramString1.optString(i);
          if (!TextUtils.isEmpty(paramString2)) {
            localArrayList.add(paramString2);
          }
          i += 1;
        }
      }
    }
  }
  
  public SharedPreferences getSp()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("Config_Before_load_RU" + this.app.getCurrentAccountUin(), 0);
  }
  
  public void hv(long paramLong)
  {
    this.PN = paramLong;
  }
  
  public void hw(long paramLong)
  {
    if (this.jm.get(String.valueOf(paramLong)) != null)
    {
      if (QLog.isColorLevel()) {
        ajrk.m("HotChatManager", new Object[] { "checkHotChatInfo", Long.valueOf(paramLong) });
      }
      return;
    }
    Object localObject = new HotChatInfo();
    ((HotChatInfo)localObject).troopUin = String.valueOf(paramLong);
    ((HotChatInfo)localObject).name = ((HotChatInfo)localObject).troopUin;
    ((HotChatInfo)localObject).hotThemeGroupFlag = 1;
    ((HotChatInfo)localObject).userCreate = 0;
    ((HotChatInfo)localObject).supportFlashPic = true;
    ((HotChatInfo)localObject).isWifiHotChat = false;
    ((HotChatInfo)localObject).adminLevel = 2;
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatManager", new Object[] { "checkHotChatInfo", "need AddHotChatInfoRunnable", Long.valueOf(paramLong) });
    }
    localObject = new AddHotChatInfoRunnable((HotChatInfo)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public String jk(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.dZ == null) {
      this.dZ = new ConcurrentHashMap();
    }
    if (this.dZ.containsKey(paramString)) {
      return (String)this.dZ.get(paramString);
    }
    if (this.dZ != null)
    {
      Iterator localIterator = this.jm.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (HotChatInfo)localIterator.next();
        if ((localObject != null) && (((HotChatInfo)localObject).troopCode != null) && (((HotChatInfo)localObject).troopCode.equals(paramString)))
        {
          localObject = ((HotChatInfo)localObject).troopUin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.dZ.put(paramString, localObject);
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public boolean ki(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (HotChatInfo)this.jm.get(paramString);
    if ((paramString != null) && (paramString.state == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean kj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jm.containsKey(paramString);
  }
  
  public void onDestroy()
  {
    bHK = false;
    bHL = false;
  }
  
  public void updateHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localEntityManager.update(paramHotChatInfo);
    localEntityManager.close();
  }
  
  class AddHotChatInfoRunnable
    implements Runnable
  {
    HotChatInfo d = null;
    
    AddHotChatInfoRunnable(HotChatInfo paramHotChatInfo)
    {
      this.d = paramHotChatInfo;
    }
    
    public void run()
    {
      if (this.d != null)
      {
        if (HotChatManager.this.jm.get(String.valueOf(this.d.troopUin)) == null) {
          break label63;
        }
        if (QLog.isColorLevel()) {
          ajrk.m("HotChatManager", new Object[] { "AddHotChatInfoRunnable already exist", this.d.troopUin });
        }
      }
      return;
      label63:
      if (QLog.isColorLevel()) {
        ajrk.m("HotChatManager", new Object[] { "AddHotChatInfoRunnable", this.d.troopUin });
      }
      HotChatManager.this.a(this.d, 4);
      ((acfv)HotChatManager.this.app.getBusinessHandler(35)).cJk();
    }
  }
  
  public static class HotChatStateWrapper
    implements Serializable
  {
    public static final int ACTION_DELETE_SHELL = 3;
    public static final int ACTION_KEEP_RECENT_USER = 2;
    public static final int ACTION_NO = -1;
    public static final int ACTION_PULL_SHELL = 1;
    public static final HotChatStateWrapper STATE_HOT_CHAT_IS_DISBANDED = wrap(7, -1);
    public static final HotChatStateWrapper STATE_HOT_CHAT_LEFT_OVERCOUNT = wrap(9, 3);
    public static final HotChatStateWrapper STATE_KICK_OUT;
    public static final HotChatStateWrapper STATE_LEFT_NORMAL = wrap(4, -1);
    public static final HotChatStateWrapper STATE_LEFT_NORMAL__ACTION_DELETE_SHELL = wrap(4, 3);
    public static final HotChatStateWrapper STATE_LEFT__LONG_TIME_NOT_SAY = wrap(1, -1);
    public int action = -1;
    public int targetState;
    
    static
    {
      STATE_KICK_OUT = wrap(6, -1);
    }
    
    public static HotChatStateWrapper wrap(int paramInt)
    {
      HotChatStateWrapper localHotChatStateWrapper = new HotChatStateWrapper();
      localHotChatStateWrapper.targetState = paramInt;
      return localHotChatStateWrapper;
    }
    
    public static HotChatStateWrapper wrap(int paramInt1, int paramInt2)
    {
      HotChatStateWrapper localHotChatStateWrapper = new HotChatStateWrapper();
      localHotChatStateWrapper.targetState = paramInt1;
      localHotChatStateWrapper.action = paramInt2;
      return localHotChatStateWrapper;
    }
    
    public boolean hasAction()
    {
      return this.action != -1;
    }
    
    public String toString()
    {
      return "HotChatStateWrapper{targetState=" + this.targetState + ", action=" + this.action + '}';
    }
  }
  
  public static abstract interface a
  {
    public abstract void cJo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager
 * JD-Core Version:    0.7.0.1
 */