import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager.2;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager.4;
import com.tencent.mobileqq.gamecenter.message.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ahta
  implements Observer, Manager
{
  private static final String TAG = ahtj.bLH + "GameMsgManager";
  private static boolean mInited;
  private aeka a = new aeka();
  private long aaT;
  private ahtk b = new ahtb(this);
  public boolean cie;
  public boolean cif;
  private int dba;
  private Runnable gB = new GameMsgManager.2(this);
  private EntityManager h;
  private Map<String, GameUserInfo> lc = Collections.synchronizedMap(new HashMap());
  private Map<String, GameBasicInfo> ld = Collections.synchronizedMap(new HashMap());
  private Map<String, GameSwitchConfig> le = Collections.synchronizedMap(new HashMap());
  private Map<String, GameCenterSessionInfo> lf = new ConcurrentHashMap();
  private Map<String, GameCenterSessionInfo> lg = new ConcurrentHashMap();
  private Map<String, GameCenterSessionInfo> lh = new ConcurrentHashMap();
  private QQAppInterface mApp;
  
  public ahta(QQAppInterface paramQQAppInterface)
  {
    QLog.i(TAG, 1, "[GameMsgManager] start");
    this.mApp = paramQQAppInterface;
    this.h = paramQQAppInterface.a().createEntityManager();
    ThreadManager.getSubThreadHandler().post(this.gB);
    QLog.i(TAG, 1, "[GameMsgManager] end");
  }
  
  private void a(GameBasicInfo paramGameBasicInfo)
  {
    if ((paramGameBasicInfo == null) || (TextUtils.isEmpty(paramGameBasicInfo.mAppId))) {
      return;
    }
    QLog.i(TAG, 1, "[updateGameConfigItem], appId:" + paramGameBasicInfo.mAppId);
    this.ld.put(paramGameBasicInfo.mAppId, paramGameBasicInfo);
    a(paramGameBasicInfo);
  }
  
  private void a(GameUserInfo paramGameUserInfo)
  {
    if ((paramGameUserInfo == null) || (TextUtils.isEmpty(paramGameUserInfo.mRoleId))) {
      return;
    }
    QLog.i(TAG, 1, "[updateGameUsrInfoItem], roleId:" + paramGameUserInfo.mRoleId);
    this.lc.put(paramGameUserInfo.mRoleId, paramGameUserInfo);
    a(paramGameUserInfo);
  }
  
  private ArrayList<String> ah(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      GameUserInfo localGameUserInfo = a(str);
      if (localGameUserInfo == null)
      {
        localArrayList.add(str);
        QLog.i(TAG, 2, "case 1: can't find in local, roldId:" + str);
      }
      else
      {
        long l2 = l1 - localGameUserInfo.mSaveTs;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "delta:" + l2);
        }
        if (l2 >= 120000L)
        {
          localArrayList.add(str);
          QLog.i(TAG, 2, "case 2: it's time to update, roldId:" + str);
        }
      }
    }
    return localArrayList;
  }
  
  private void dpU()
  {
    try
    {
      Object localObject1 = (ArrayList)this.h.query(GameUserInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameUserInfo)localObject2;
            if (!TextUtils.isEmpty(((GameUserInfo)localObject2).mRoleId)) {
              this.lc.put(((GameUserInfo)localObject2).mRoleId, localObject2);
            }
          }
        }
        QLog.i(TAG, 1, "ursInfo.size:" + this.lc.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable.getMessage());
      return;
    }
  }
  
  private void dpV()
  {
    try
    {
      Object localObject1 = (ArrayList)this.h.query(GameBasicInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameBasicInfo)localObject2;
            if (!TextUtils.isEmpty(((GameBasicInfo)localObject2).mAppId)) {
              this.ld.put(((GameBasicInfo)localObject2).mAppId, localObject2);
            }
          }
        }
        QLog.i(TAG, 1, "gameConfig.size:" + this.ld.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable.getMessage());
      return;
    }
  }
  
  private void dpW()
  {
    try
    {
      Object localObject1 = (ArrayList)this.h.query(GameSwitchConfig.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameSwitchConfig)localObject2;
            if (!TextUtils.isEmpty(((GameSwitchConfig)localObject2).mAppId)) {
              this.le.put(((GameSwitchConfig)localObject2).mAppId, localObject2);
            }
          }
        }
        QLog.i(TAG, 1, "gameSwitchConfig.size:" + this.le.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable.getMessage());
      return;
    }
  }
  
  public static boolean isInited()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[isInited]" + mInited);
    }
    return mInited;
  }
  
  public int Fj()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getUnshowedUnreadCnt] cnt:" + this.dba);
    }
    if (!anX()) {
      return 0;
    }
    return this.dba;
  }
  
  public void KG(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[setAllReaded] gameId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.lf.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)this.lf.get(str);
        if (paramString.equals(localGameCenterSessionInfo.wx()))
        {
          this.mApp.b().ca(localGameCenterSessionInfo.getSessionId(), 10007);
          localGameCenterSessionInfo.Po(0);
          if (this.lh.get(str) != null) {
            ((GameCenterSessionInfo)this.lh.get(str)).Po(0);
          }
        }
      }
    }
  }
  
  public void KH(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[deleteAllSession] gameId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.lf.entrySet().iterator();
      while (localIterator.hasNext())
      {
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Map.Entry)localIterator.next()).getValue();
        if (paramString.equals(localGameCenterSessionInfo.wx()))
        {
          localIterator.remove();
          if (this.mApp != null) {
            this.mApp.b().N(localGameCenterSessionInfo.getSessionId(), 10007);
          }
        }
      }
      localIterator = this.lh.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((GameCenterSessionInfo)((Map.Entry)localIterator.next()).getValue()).wx())) {
          localIterator.remove();
        }
      }
      localIterator = this.lg.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals((String)((Map.Entry)localIterator.next()).getKey())) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void KI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "[cleanSessionUnread] id:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.mApp == null);
      paramString = a(paramString);
    } while (paramString == null);
    paramString.Po(0);
    Pr(getUnreadCnt());
  }
  
  public void Pr(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[setUnshowedUnreadCnt] cnt:" + this.dba + ",----" + QLog.getStackTraceString(new Throwable()));
    }
    this.dba = paramInt;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    String str = "sp_enter_pub" + this.mApp.getCurrentAccountUin();
    localSharedPreferences.edit().putInt(str, this.dba).commit();
  }
  
  public ahsz a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getSingleGameDetail], roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GameUserInfo localGameUserInfo = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localGameUserInfo == null)
    {
      QLog.w(TAG, 1, "usrInfo is null");
      localArrayList.add(paramString);
      k(true, localArrayList);
      return null;
    }
    GameBasicInfo localGameBasicInfo = a(localGameUserInfo.mAppId);
    if (localGameBasicInfo == null)
    {
      QLog.w(TAG, 1, "basicinfp is null");
      localArrayList.add(paramString);
      k(true, localArrayList);
      return null;
    }
    localArrayList.add(paramString);
    k(false, localArrayList);
    return ahsz.a(localGameBasicInfo, localGameUserInfo);
  }
  
  public GameCenterSessionInfo a()
  {
    if (this.lf.size() == 0) {
      fi();
    }
    Object localObject2 = new ArrayList(this.lg.values());
    Object localObject1 = new ArrayList(this.lh.values());
    Collections.sort((List)localObject2);
    Collections.sort((List)localObject1);
    if ((((List)localObject2).size() > 0) && (((List)localObject1).size() > 0))
    {
      localObject2 = (GameCenterSessionInfo)((List)localObject2).get(0);
      localObject1 = (GameCenterSessionInfo)((List)localObject1).get(0);
      if (((GameCenterSessionInfo)localObject2).eI() > ((GameCenterSessionInfo)localObject1).eI()) {
        return localObject2;
      }
      return localObject1;
    }
    if (((List)localObject2).size() > 0) {
      return (GameCenterSessionInfo)((List)localObject2).get(0);
    }
    if (((List)localObject1).size() > 0) {
      return (GameCenterSessionInfo)((List)localObject1).get(0);
    }
    return null;
  }
  
  public GameCenterSessionInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getSessionInfoByUin] sessionId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.lf.size() == 0) {
      fi();
    }
    return (GameCenterSessionInfo)this.lf.get(paramString);
  }
  
  public GameBasicInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[findGameConfig], appId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameBasicInfo)this.ld.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "got it from cache");
    return localObject;
    QLog.i(TAG, 1, "try to read from db");
    Object localObject = this.h.find(GameBasicInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameBasicInfo)localObject;
      this.ld.put(paramString, localObject);
      return localObject;
    }
    QLog.i(TAG, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameSwitchConfig a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[findGameSwitchConfig], appId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameSwitchConfig)this.le.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "got it from cache");
    return localObject;
    QLog.i(TAG, 1, "try to read from db");
    Object localObject = this.h.find(GameSwitchConfig.class, paramString);
    if (localObject != null)
    {
      localObject = (GameSwitchConfig)localObject;
      this.le.put(paramString, localObject);
      return localObject;
    }
    QLog.i(TAG, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameUserInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[findGameUserInfo], roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameUserInfo)this.lc.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "got it from cache");
    return localObject;
    QLog.i(TAG, 1, "try to read from db");
    Object localObject = this.h.find(GameUserInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameUserInfo)localObject;
      this.lc.put(paramString, localObject);
      return localObject;
    }
    QLog.i(TAG, 1, "fail to find usrinfo from db.");
    return null;
  }
  
  public void a(String paramString, GameCenterSessionInfo paramGameCenterSessionInfo, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(BaseApplicationImpl.getApplication().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_game_msg", paramGameCenterSessionInfo);
    localBundle.putInt("key_msg_change_type", paramInt1);
    localBundle.putInt("key_msg_unread_cnt", paramInt2);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    QLog.i(TAG, 1, "[notifyMessageChange] action:" + paramString + ",type:" + paramInt1 + ",cnt:" + paramInt2);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.h.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.h.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.h.update(paramEntity);
      }
    }
    QLog.e(TAG, 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public void an(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i(TAG, 1, "[onGameSwitchChange] gameId:" + paramString + ",switchType:" + paramInt1 + ",value:" + paramInt2);
    ArrayList localArrayList = new ArrayList();
    GameSwitchConfig localGameSwitchConfig2 = a(paramString);
    GameSwitchConfig localGameSwitchConfig1 = localGameSwitchConfig2;
    if (localGameSwitchConfig2 == null)
    {
      localGameSwitchConfig1 = new GameSwitchConfig();
      localGameSwitchConfig1.mAppId = paramString;
    }
    if (paramInt1 == 0) {
      if ((paramInt2 != 0) && (paramInt2 != 1))
      {
        localGameSwitchConfig1.mBlockSwitch = 0;
        localArrayList.add(localGameSwitchConfig1);
        et(localArrayList);
        if (localGameSwitchConfig1.mBlockSwitch == 1) {
          KH(paramString);
        }
      }
    }
    while (paramInt1 != 1) {
      for (;;)
      {
        return;
        localGameSwitchConfig1.mBlockSwitch = paramInt2;
      }
    }
    if ((paramInt2 != 0) && (paramInt2 != 1)) {}
    for (localGameSwitchConfig1.mSyncSwitch = 1;; localGameSwitchConfig1.mSyncSwitch = paramInt2)
    {
      localArrayList.add(localGameSwitchConfig1);
      et(localArrayList);
      if (localGameSwitchConfig1.mSyncSwitch != 0) {
        break;
      }
      KG(paramString);
      return;
    }
  }
  
  public boolean anX()
  {
    return (this.a != null) && (this.a.cNE == 1);
  }
  
  public GameCenterSessionInfo b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getSessionInfoByRoleId] roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.lf.size() == 0) {
      fi();
    }
    Iterator localIterator = this.lf.keySet().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localObject = (GameCenterSessionInfo)this.lf.get(localObject);
    } while (!paramString.equals(((GameCenterSessionInfo)localObject).ww()));
    for (paramString = (String)localObject;; paramString = null) {
      return paramString;
    }
  }
  
  public GameCenterSessionInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.lg.size() == 0) {
      fi();
    }
    return (GameCenterSessionInfo)this.lg.get(paramString);
  }
  
  public HashMap<String, ahsz> c(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GameUserInfo localGameUserInfo = a(str);
      if (localGameUserInfo == null)
      {
        QLog.w(TAG, 1, "usrInfo is null, roleId:" + str);
        bool = true;
      }
      else
      {
        GameBasicInfo localGameBasicInfo = a(localGameUserInfo.mAppId);
        if (localGameBasicInfo == null)
        {
          QLog.w(TAG, 1, "basicinfp is null, appid:" + localGameUserInfo.mAppId);
          bool = true;
        }
        else
        {
          localHashMap.put(str, ahsz.a(localGameBasicInfo, localGameUserInfo));
        }
      }
    }
    k(bool, paramArrayList);
    return localHashMap;
  }
  
  public void c(aeka paramaeka)
  {
    QLog.i(TAG, 2, "[updateGraySwich]");
    if (paramaeka == null) {}
    do
    {
      return;
      QLog.i(TAG, 1, "graySwitch:" + paramaeka.cNE + ",msgListUrl:" + paramaeka.byL + ",prefix:" + paramaeka.mPrefix);
      if (this.a == null) {
        this.a = new aeka();
      }
      if (!TextUtils.isEmpty(paramaeka.byL)) {
        this.a.byL = paramaeka.byL;
      }
      this.a.cNE = paramaeka.cNE;
    } while (TextUtils.isEmpty(paramaeka.mPrefix));
    this.a.mPrefix = paramaeka.mPrefix;
  }
  
  public void dpX()
  {
    a("action_qgame_messgae_change", null, 3, getUnreadCnt());
  }
  
  public void dpY()
  {
    if (!anX()) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[tryGetGameSwitchFromSvr], not in gray whitelist, return.");
      }
    }
    while (System.currentTimeMillis() - this.aaT <= 300000L) {
      return;
    }
    QLog.i(TAG, 1, "[tryGetGameSwitchFromSvr]");
    ((ahtj)this.mApp.getBusinessHandler(175)).dqb();
    this.aaT = System.currentTimeMillis();
  }
  
  public void dpZ()
  {
    MqqHandler localMqqHandler = this.mApp.getHandler(Conversation.class);
    localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1009));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[updateRecentList] send update list msg.");
    }
  }
  
  public void er(ArrayList<GameUserInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[saveOrUpdateGameUsrInfoArrays], size:" + paramArrayList.size());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameUserInfo localGameUserInfo1 = (GameUserInfo)paramArrayList.next();
        if (localGameUserInfo1 != null)
        {
          GameUserInfo localGameUserInfo2 = (GameUserInfo)this.lc.get(localGameUserInfo1.mRoleId);
          if (localGameUserInfo2 == null)
          {
            localGameUserInfo1.setStatus(1000);
            a(localGameUserInfo1);
          }
          else if (localGameUserInfo1.mUpdateTs != localGameUserInfo2.mUpdateTs)
          {
            a(localGameUserInfo1);
            QLog.i(TAG, 1, "game user info has changed,origTS:" + localGameUserInfo2.mUpdateTs + ",newTS:" + localGameUserInfo1.mUpdateTs);
          }
        }
      }
    }
  }
  
  public void es(ArrayList<GameBasicInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[saveOrUpdateGameBasicConfigs], size:" + paramArrayList.size());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameBasicInfo localGameBasicInfo1 = (GameBasicInfo)paramArrayList.next();
        if (localGameBasicInfo1 != null)
        {
          GameBasicInfo localGameBasicInfo2 = (GameBasicInfo)this.ld.get(localGameBasicInfo1.mAppId);
          if (localGameBasicInfo2 == null)
          {
            localGameBasicInfo1.setStatus(1000);
            a(localGameBasicInfo1);
          }
          else if (localGameBasicInfo2.mUpdateTs != localGameBasicInfo1.mUpdateTs)
          {
            a(localGameBasicInfo1);
            QLog.i(TAG, 1, "game basic config has changed,origTS:" + localGameBasicInfo2.mUpdateTs + ",newTS:" + localGameBasicInfo1.mUpdateTs);
          }
        }
      }
    }
  }
  
  public void et(ArrayList<GameSwitchConfig> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameSwitchConfig localGameSwitchConfig = (GameSwitchConfig)paramArrayList.next();
        if (localGameSwitchConfig != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[saveOrUpdateGameSwitchConfigs] config:" + localGameSwitchConfig.toString());
          }
          this.le.put(localGameSwitchConfig.mAppId, localGameSwitchConfig);
          a(localGameSwitchConfig);
        }
      }
    }
  }
  
  public List<GameCenterSessionInfo> f(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject4;
    Object localObject5;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "[getSessionInfoList] type:" + paramInt + ",gameId:" + paramString + "curSize:" + this.lf.size());
      }
      if (!anX()) {}
      for (localObject1 = new ArrayList();; localObject1 = null)
      {
        return localObject1;
        localObject1 = new ArrayList();
        if (this.lf.size() != 0) {
          break label944;
        }
        localObject3 = fj();
        if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
          break;
        }
        QLog.i(TAG, 1, "[getSessionInfoList] tinyconversion is null.return");
      }
      localObject2 = new HashSet();
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ConversationInfo)((Iterator)localObject4).next();
        if ((((ConversationInfo)localObject5).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject5).tinyInfo.fromRoleId)))
        {
          ((Set)localObject2).add(((ConversationInfo)localObject5).tinyInfo.fromRoleId);
          ((Set)localObject2).add(((ConversationInfo)localObject5).tinyInfo.toRoleId);
        }
      }
      if (!QLog.isColorLevel()) {
        break label295;
      }
    }
    finally {}
    QLog.d(TAG, 2, "[getSessionInfoList] tinycon size:" + ((List)localObject3).size() + " id size:" + ((Set)localObject2).size());
    label295:
    Object localObject2 = c(new ArrayList((Collection)localObject2));
    Object localObject3 = ((List)localObject3).iterator();
    label319:
    Object localObject6;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ConversationInfo)((Iterator)localObject3).next();
        if (localObject4 == null)
        {
          QLog.e(TAG, 1, "[getSessionInfoList] info is null, continue.");
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[getSessionInfoList] info:" + ((ConversationInfo)localObject4).toString());
          }
          localObject5 = new GameCenterSessionInfo();
          localObject6 = this.mApp.b().a(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
          CharSequence localCharSequence;
          if (localObject6 != null)
          {
            localCharSequence = ((QQMessageFacade.Message)localObject6).emoRecentMsg;
            if (!TextUtils.isEmpty(localCharSequence)) {
              ((GameCenterSessionInfo)localObject5).KB(localCharSequence.toString());
            }
            ((GameCenterSessionInfo)localObject5).Ky(((QQMessageFacade.Message)localObject6).isSend());
            ((GameCenterSessionInfo)localObject5).jW(((QQMessageFacade.Message)localObject6).time);
          }
          localObject6 = this.mApp.b().b(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
          if (localObject6 != null)
          {
            localCharSequence = ((QQMessageFacade.Message)localObject6).emoRecentMsg;
            if (!TextUtils.isEmpty(localCharSequence)) {
              ((GameCenterSessionInfo)localObject5).KA(localCharSequence.toString());
            }
            ((GameCenterSessionInfo)localObject5).jV(((QQMessageFacade.Message)localObject6).time);
          }
          ((GameCenterSessionInfo)localObject5).setSessionId(((ConversationInfo)localObject4).uin);
          ((GameCenterSessionInfo)localObject5).Po(((ConversationInfo)localObject4).unreadCount);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[getSessionInfoList] sessionId" + ((ConversationInfo)localObject4).uin + " tinyInfo:" + ((ConversationInfo)localObject4).tinyInfo);
          }
          if ((((ConversationInfo)localObject4).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject4).tinyInfo.fromRoleId)))
          {
            if (mQ(((ConversationInfo)localObject4).tinyInfo.gameAppId + ""))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(TAG, 1, "[getSessionInfoList] msg blocked: " + ((GameCenterSessionInfo)localObject5).getSessionId());
              continue;
            }
            ((GameCenterSessionInfo)localObject5).Kx(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
            ((GameCenterSessionInfo)localObject5).xx(((ConversationInfo)localObject4).tinyInfo.toRoleId);
            if (localObject2 != null)
            {
              localObject6 = (ahsz)((HashMap)localObject2).get(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
              if (!QLog.isColorLevel()) {
                break label1511;
              }
              QLog.d(TAG, 2, "[getSessionInfoList] sessionId:" + ((ConversationInfo)localObject4).uin + ",gameDetailInfo:" + localObject6);
              break label1511;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject6 != null)
      {
        ((GameCenterSessionInfo)localObject5).setNickName(((ahsz)localObject6).mNickInGame);
        ((GameCenterSessionInfo)localObject5).Ky(((ahsz)localObject6).mAppId);
        ((GameCenterSessionInfo)localObject5).Pp(((ahsz)localObject6).mOnlineType);
        ((GameCenterSessionInfo)localObject5).Kz(((ahsz)localObject6).mFaceUrl);
        ((GameCenterSessionInfo)localObject5).setGameName(((ahsz)localObject6).mName);
        ((GameCenterSessionInfo)localObject5).Kw(((ahsz)localObject6).mOnLineDesc);
        ((GameCenterSessionInfo)localObject5).Kv(((ahsz)localObject6).mIconUrl);
      }
      this.lf.put(((GameCenterSessionInfo)localObject5).getSessionId(), localObject5);
      break label319;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[getSessionInfoList] sessionMap:" + this.lf.toString());
      }
      label944:
      this.lh.clear();
      this.lg.clear();
      localObject2 = this.lf.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject3 = (GameCenterSessionInfo)this.lf.get(localObject3);
        ((GameCenterSessionInfo)localObject3).Pn(0);
        if (mP(((GameCenterSessionInfo)localObject3).wx()))
        {
          ((GameCenterSessionInfo)localObject3).setSessionType(1);
          this.lh.put(((GameCenterSessionInfo)localObject3).getSessionId(), localObject3);
        }
        else
        {
          ((GameCenterSessionInfo)localObject3).setSessionType(0);
          if (((GameCenterSessionInfo)localObject3).Fi() > 0)
          {
            if (!this.lg.containsKey(((GameCenterSessionInfo)localObject3).wx()))
            {
              ((GameCenterSessionInfo)localObject3).dpv();
              this.lg.put(((GameCenterSessionInfo)localObject3).wx(), localObject3);
            }
            else
            {
              localObject4 = (GameCenterSessionInfo)this.lg.get(((GameCenterSessionInfo)localObject3).wx());
              if (((GameCenterSessionInfo)localObject3).eI() > ((GameCenterSessionInfo)localObject4).eI())
              {
                ((GameCenterSessionInfo)localObject3).Pn(((GameCenterSessionInfo)localObject4).getRequestCount() + 1);
                this.lg.put(((GameCenterSessionInfo)localObject3).wx(), localObject3);
              }
            }
          }
          else {
            QLog.i(TAG, 1, "[getSessionInfoList] folder session:" + localObject3);
          }
        }
      }
      QLog.i(TAG, 1, "[getSessionInfoList] size:" + this.lf.size() + ",fsize:" + this.lg.size() + "，nsize:" + this.lh.size());
      if (paramInt == 0)
      {
        ((List)localObject1).addAll(this.lh.values());
        ((List)localObject1).addAll(this.lg.values());
        paramString = (String)localObject1;
      }
      for (;;)
      {
        Collections.sort(paramString);
        localObject1 = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(TAG, 2, "[getSessionInfoList] ret:" + paramString.toString());
        localObject1 = paramString;
        break;
        if (paramInt == 1)
        {
          paramString = new ArrayList(this.lg.values());
        }
        else if (paramInt == 2)
        {
          paramString = new ArrayList(this.lh.values());
        }
        else
        {
          if (paramInt == 3)
          {
            localObject2 = this.lf.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              if (TextUtils.equals(paramString, ((GameCenterSessionInfo)this.lf.get(localObject3)).wx())) {
                ((List)localObject1).add(this.lf.get(localObject3));
              }
            }
          }
          paramString = (String)localObject1;
        }
      }
      label1511:
      if (localObject6 != null) {}
    }
  }
  
  public List<GameCenterSessionInfo> fi()
  {
    return f(0, "");
  }
  
  public List<ConversationInfo> fj()
  {
    return ahte.a().i(this.mApp);
  }
  
  public int getUnreadCnt()
  {
    if (this.lh.size() == 0) {
      fi();
    }
    Iterator localIterator = this.lh.keySet().iterator();
    String str;
    for (int i = 0; localIterator.hasNext(); i = ((GameCenterSessionInfo)this.lh.get(str)).Fi() + i) {
      str = (String)localIterator.next();
    }
    QLog.i(TAG, 1, "[getUnreadCnt] cnt:" + i);
    return i;
  }
  
  public int getViewType()
  {
    int i;
    if ((this.a != null) && (this.a.mViewType != 0)) {
      i = this.a.mViewType;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[getViewType] ret = " + i);
      }
      return i;
      try
      {
        l = Long.parseLong(this.mApp.getCurrentAccountUin());
        if (l % 2L == 0L) {
          i = 2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(TAG, 1, "[getViewType] " + localException);
          long l = 0L;
        }
        i = 1;
      }
    }
  }
  
  public void k(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[pullGameUsrInfoFromServer], isForcePull:" + paramBoolean);
    }
    if (!anX())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "not in gray whitelist, return.");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new GameMsgManager.4(this, paramBoolean, paramArrayList));
  }
  
  public boolean mP(String paramString)
  {
    GameSwitchConfig localGameSwitchConfig = a(paramString);
    if (localGameSwitchConfig == null)
    {
      QLog.i(TAG, 1, "[isGameMsgSync] gameId:" + paramString + ", config is null,return true");
      return true;
    }
    if (localGameSwitchConfig.mSyncSwitch == 0) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 1, "[isGameMsgSync] gameId:" + paramString + ", ret:" + bool);
      }
      return bool;
    }
  }
  
  public boolean mQ(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    GameSwitchConfig localGameSwitchConfig = a(paramString);
    if (localGameSwitchConfig == null)
    {
      QLog.i(TAG, 1, "[isGameMsgBlocked] gameId:" + paramString + ", config is null,return false");
      return bool2;
    }
    if (localGameSwitchConfig.mBlockSwitch == 0) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(TAG, 1, "[isGameMsgBlocked] gameId:" + paramString + ", ret:" + bool1);
      return bool1;
      bool1 = true;
    }
  }
  
  public void onDestroy()
  {
    QLog.i(TAG, 1, "[onDestroy]");
    if (this.mApp != null)
    {
      this.mApp.b().deleteObserver(this);
      this.mApp.removeObserver(this.b);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!anX()) {}
    label7:
    MessageRecord localMessageRecord;
    ConversationInfo localConversationInfo;
    do
    {
      do
      {
        break label7;
        break label7;
        do
        {
          return;
        } while (!(paramObject instanceof MessageRecord));
        localMessageRecord = (MessageRecord)paramObject;
      } while (localMessageRecord.istroop != 10007);
      dpY();
      localConversationInfo = ahte.a().a(this.mApp, localMessageRecord.frienduin, localMessageRecord.istroop);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "[update] ##-- new msg:" + localMessageRecord.frienduin + ", conInfo:" + localConversationInfo);
      }
    } while (localConversationInfo == null);
    paramObservable = a(localMessageRecord.frienduin);
    label298:
    label312:
    label483:
    label498:
    int i;
    label502:
    int j;
    int k;
    if (paramObservable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[update] create new sessionInfo.");
      }
      paramObject = new GameCenterSessionInfo();
      paramObject.setSessionId(localMessageRecord.frienduin);
      Object localObject = this.mApp.b().b(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (localObject != null) {
        if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject).emoRecentMsg)) {
          break label298;
        }
      }
      for (paramObservable = "";; paramObservable = ((QQMessageFacade.Message)localObject).emoRecentMsg.toString())
      {
        paramObject.KA(paramObservable);
        paramObject.jV(((QQMessageFacade.Message)localObject).time);
        paramObservable = localConversationInfo.tinyInfo;
        if (paramObservable == null) {
          break label498;
        }
        if (!mQ(paramObservable.gameAppId + "")) {
          break label312;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(TAG, 1, "[update] ##-- new msg:" + localMessageRecord.frienduin + ", blocked.");
        return;
      }
      paramObject.Kx(paramObservable.fromRoleId);
      paramObject.xx(paramObservable.toRoleId);
      paramObject.Ky(paramObservable.gameAppId + "");
      localObject = a(paramObject.ww());
      if (localObject != null)
      {
        paramObject.Ky(((ahsz)localObject).mAppId);
        paramObject.setGameName(((ahsz)localObject).mName);
        paramObject.setNickName(((ahsz)localObject).mNickInGame);
        paramObject.Pp(((ahsz)localObject).mOnlineType);
        paramObject.Kw(((ahsz)localObject).mOnLineDesc);
        paramObject.Kz(((ahsz)localObject).mFaceUrl);
        paramObject.Kv(((ahsz)localObject).mIconUrl);
      }
      if (mP(paramObservable.gameAppId + ""))
      {
        paramObject.setSessionType(1);
        this.lh.put(paramObject.getSessionId(), paramObject);
        this.lf.put(paramObject.getSessionId(), paramObject);
        i = 0;
        paramObservable = paramObject;
        paramObservable.Po(localConversationInfo.unreadCount);
        paramObservable.KB(localMessageRecord.msg);
        paramObservable.jW(localMessageRecord.time);
        paramObservable.Ky(localMessageRecord.isSend());
        j = getUnreadCnt();
        k = paramObservable.Fi();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[update] update info:" + paramObservable.toString());
        }
        if (paramObservable.getSessionType() != 0) {
          break label855;
        }
        paramObservable = c(paramObservable.wx());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[update] notify folder session:" + paramObservable);
        }
        a("action_qgame_messgae_change", paramObservable, 1, j);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[update] oldUnread:" + i + ",newUnread:" + k);
      }
      if ((!ahtc.aS(this.mApp)) || (i == k)) {
        break;
      }
      this.mApp.cLO();
      Pr(j);
      return;
      paramObject.setSessionType(0);
      paramObject.dpv();
      this.lg.put(paramObject.wx(), paramObject);
      break label483;
      i = paramObservable.Fi();
      if (paramObservable.getSessionType() == 0)
      {
        paramObject = c(paramObservable.wx());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[update] folder session:" + paramObject);
        }
        if (paramObject != null)
        {
          paramObservable.Pn(paramObject.getRequestCount() + 1);
          this.lg.put(paramObservable.wx(), paramObservable);
          break label502;
        }
        paramObservable.dpv();
        this.lg.put(paramObservable.wx(), paramObservable);
      }
      break label502;
      label855:
      a("action_qgame_messgae_change", paramObservable, 1, j);
      a("action_qgame_unread_change", paramObservable, 1, j);
    }
  }
  
  public String wD()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.byL))) {
      return this.a.byL;
    }
    return ahtc.bLG;
  }
  
  public String wE()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.mPrefix))) {
      return this.a.mPrefix;
    }
    return ahtc.PREFIX;
  }
  
  public String wF()
  {
    if (this.a != null) {
      return this.a.byM;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahta
 * JD-Core Version:    0.7.0.1
 */