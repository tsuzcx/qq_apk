import MessageSvcPack.stConfNumInfo;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgcomm.msg_comm.Msg;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anaz
{
  private static String TAG = "Q.msg.MessageCache";
  public static anaz.e a;
  public static boolean cEL;
  public static int dES = 3;
  public static int dET = 259200;
  public static HashMap<String, anaz.b> ne = new HashMap();
  private ArrayList<stConfNumInfo> Aj = new ArrayList();
  private ArrayList<String> Ak = new ArrayList();
  ArrayList<MessageRecord> Al = new ArrayList();
  public List<MessageRecord> Gq = new ArrayList();
  private MessageRecord I;
  private MessageRecord J;
  private anaz.a a;
  public anba a;
  private long aks = -1L;
  private long akt;
  private QQAppInterface app;
  public AtomicInteger bJ = new AtomicInteger(0);
  private boolean cEJ;
  private boolean cEK;
  private boolean cEM;
  private Set<String> cW = Collections.synchronizedSet(new HashSet());
  private int dEP;
  private int dEQ = -1;
  private int dER = -1;
  private byte[] fs;
  private byte[] ft;
  private ConcurrentHashMap<String, Long> gZ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hA = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hB = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hC = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hD = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hE = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hF = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hG = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> hH = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> hI = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> hJ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, HashSet<Long>>> hK = new ConcurrentHashMap();
  private ConcurrentHashMap<String, MessageRecord> hL = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hM = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, Object[]> hN = new ConcurrentHashMap();
  public ConcurrentHashMap<String, String> hO = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> hP = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hQ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hR = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hS = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hT = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hU = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hV = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hW = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> hX = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Set<String>> hY = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> hZ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> ha = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> hb = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> hc = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> hd = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> he = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hf = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> hg = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> hh = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> hi = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> hj = new ConcurrentHashMap();
  public ConcurrentHashMap<String, String> hk = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, anaz.c>> hl = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, anaz.c>> hm = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> hn = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<Integer>> ho = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hp = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hq = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hr = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hs = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ht = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hu = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hv = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hw = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hx = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hy = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> hz = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> ia = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> ib = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> ic = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> id = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> ie = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> jdField_if = new ConcurrentHashMap();
  private ConcurrentHashMap<String, DisMsgReadedNotify> ig = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GroupMsgReadedNotify> ih = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AppShareID> ii = new ConcurrentHashMap();
  private ConcurrentHashMap<String, OpenID> ij = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> ik = new ConcurrentHashMap();
  public HashMap<Long, MessageForPoke> nc = new HashMap();
  private HashMap<Long, ArrayList<String>> nd = new HashMap();
  private SharedPreferences pref;
  
  public anaz(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.pref = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    this.jdField_a_of_type_Anaz$a = new anaz.a();
    cEL = false;
  }
  
  private List<Integer> aM(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString == null) || (paramString.length() == 0)) {
      return localArrayList;
    }
    paramString = paramString.split("\\|");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      try
      {
        localArrayList.add(Integer.valueOf(str));
        label59:
        i += 1;
      }
      catch (Exception localException)
      {
        break label59;
      }
    }
  }
  
  private void aR(String paramString, long paramLong)
  {
    paramString = MD5.toMD5(paramString);
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("deleteFriendMsgTime" + paramString, paramLong);
    }
  }
  
  public static void dOT()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
    {
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences(((QQAppInterface)localObject1).getCurrentAccountUin(), 0);
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).remove("getMsgV4_vSyncCookie");
      ((SharedPreferences.Editor)localObject1).remove("getlastMessageTime");
      ((SharedPreferences.Editor)localObject1).remove("getMsgV4_vPubAccountCookie");
      ((SharedPreferences.Editor)localObject1).remove("getTroopDiscMsgLastTime");
      localObject2 = ((SharedPreferences)localObject2).getAll().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
        if ((!TextUtils.isEmpty(str)) && ((str.startsWith("getTroopLastMessageTime")) || (str.startsWith("getDiscussionLastMessageTime")))) {
          ((SharedPreferences.Editor)localObject1).remove(str);
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
      QLog.e(TAG, 1, "clearAllMsgSyncFlags");
    }
  }
  
  public static long gQ()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private String listToString(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      if (i != paramList.size() - 1) {
        localStringBuilder.append(paramList.get(i) + "|");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramList.get(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public ConcurrentHashMap<String, ConcurrentHashMap<Long, anaz.c>> A()
  {
    return this.hm;
  }
  
  public ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> B()
  {
    return this.hn;
  }
  
  public Set<String> F()
  {
    String str = this.app.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {}
    Set localSet;
    do
    {
      return null;
      if (this.hY.containsKey(str)) {
        break;
      }
      localSet = this.app.getApp().getSharedPreferences(str + "birth", 0).getStringSet(str + "_list", null);
    } while (localSet == null);
    this.hY.put(str, localSet);
    return (Set)this.hY.get(str);
  }
  
  public void F(String paramString, int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      paramLong = Math.max(paramLong, aA(paramString));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "addMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + paramLong);
      }
      this.hE.put(top.u(paramString, paramInt), Long.valueOf(Math.max(paramLong, j(paramString, paramInt))));
      if (this.app.getCurrentAccountUin() != null) {
        this.jdField_a_of_type_Anaz$a.putLong("getDelMsgLastSeq" + top.u(paramString, paramInt), paramLong).commit();
      }
      return;
      if (paramInt == 3000)
      {
        paramLong = Math.max(paramLong, aG(paramString));
      }
      else
      {
        List localList = this.app.b().k(paramString, paramInt);
        long l = paramLong;
        if (localList != null)
        {
          l = paramLong;
          if (!localList.isEmpty()) {
            l = Math.max(paramLong, ((MessageRecord)localList.get(localList.size() - 1)).time);
          }
        }
        r(paramString, 0L, 0L);
        paramLong = l;
        if (paramInt == 0)
        {
          aR(paramString, NetConnInfoCenter.getServerTimeMillis());
          paramLong = l;
        }
      }
    }
  }
  
  public void G(String paramString, int paramInt, long paramLong)
  {
    this.hI.put(new Pair(paramString, Integer.valueOf(paramInt)), Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getAIOLastSeq" + paramString + "_" + paramInt, paramLong);
    }
  }
  
  public void H(String paramString, int paramInt, long paramLong)
  {
    this.hH.put(new Pair(paramString, Integer.valueOf(paramInt)), Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getBreakPointSeq" + paramString + "_" + paramInt, paramLong);
    }
  }
  
  public byte[] H(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.hu.containsKey(paramString)) {
        break;
      }
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "pub", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = aqoj.ag((String)localObject);
    this.hu.put(paramString, localObject);
    return (byte[])this.hu.get(paramString);
  }
  
  public void I(String paramString, int paramInt, long paramLong)
  {
    String str = top.u(paramString, paramInt);
    paramString = new anaz.c(paramString, paramInt, paramLong, 0L);
    ConcurrentHashMap localConcurrentHashMap;
    if (this.hm.containsKey(str))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.hm.get(str);
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "msgSending:addSendingCacheTemp,msgSendingTemp:" + this.hm + " msgCache:" + hashCode());
      }
      return;
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.hm.put(str, localConcurrentHashMap);
      continue;
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.hm.put(str, localConcurrentHashMap);
    }
  }
  
  public byte[] I(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getWpaMsgKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.hp.containsKey(paramString)) {
        break label150;
      }
      localObject = this.pref.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "getWpaMsgKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = aqhs.hexStr2Bytes((String)localObject);
    this.hp.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getWpaMsgKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr((byte[])this.hp.get(paramString)));
    }
    return (byte[])this.hp.get(paramString);
  }
  
  public byte[] J(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "pcQQSearchKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.hq.containsKey(paramString)) {
        break label150;
      }
      localObject = this.pref.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "pcQQSearchKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = aqhs.hexStr2Bytes((String)localObject);
    this.hq.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "pcQQSearchKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr((byte[])this.hq.get(paramString)));
    }
    return (byte[])this.hq.get(paramString);
  }
  
  public int Jg()
  {
    if ((this.dEP <= 0) && (this.app.getCurrentAccountUin() != null)) {
      this.dEP = this.pref.getInt("getlastMessageTime", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "--->>getBuddyMsgLastSeq: " + this.dEP);
    }
    return this.dEP;
  }
  
  public int Jh()
  {
    if (this.dER < 0) {
      if (!this.pref.contains("msgsignal_switch")) {
        break label44;
      }
    }
    label44:
    for (this.dER = this.pref.getInt("msgsignal_switch", 0);; this.dER = 0) {
      return this.dER;
    }
  }
  
  public byte[] K(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getBusinessCrmKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.hr.containsKey(paramString)) {
        break label183;
      }
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "crm", 0).getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "businessCrmKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = aqoj.ag((String)localObject);
    this.hr.put(paramString, localObject);
    label183:
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "businessCrmKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr((byte[])this.hr.get(paramString)));
    }
    return (byte[])this.hr.get(paramString);
  }
  
  public byte[] L(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "businessCrmSigt uin:null peerUin:" + paramString + " key:null");
      }
    }
    while (!this.hs.containsKey(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "businessCrmSigt uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr((byte[])this.hs.get(paramString)));
    }
    return (byte[])this.hs.get(paramString);
  }
  
  public byte[] M(String paramString)
  {
    return null;
  }
  
  public byte[] N(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.hB.containsKey(paramString)) {
        break;
      }
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "circle_group", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = aqoj.ag((String)localObject);
    this.hB.put(paramString, localObject);
    return (byte[])this.hB.get(paramString);
  }
  
  public byte[] O(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.hC.containsKey(paramString)) {
        break;
      }
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "circle_group_av", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = aqoj.ag((String)localObject);
    this.hC.put(paramString, localObject);
    return (byte[])this.hC.get(paramString);
  }
  
  public byte[] P(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.hD.containsKey(paramString)) {
        break;
      }
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "friend_validation", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = aqoj.ag((String)localObject);
    this.hD.put(paramString, localObject);
    return (byte[])this.hD.get(paramString);
  }
  
  public void PD(boolean paramBoolean)
  {
    this.cEK = paramBoolean;
  }
  
  public void PE(boolean paramBoolean)
  {
    this.cEJ = paramBoolean;
  }
  
  public void PF(boolean paramBoolean)
  {
    this.cEM = paramBoolean;
    if (this.app.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Anaz$a.putBoolean("getRegPrxyFailFlag", paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>setRegPrxyFailFlag = " + paramBoolean);
      }
    }
  }
  
  public byte[] Q(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.hv.containsKey(paramString)) {
        break;
      }
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "same_state", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = aqoj.ag((String)localObject);
    this.hv.put(paramString, localObject);
    return (byte[])this.hv.get(paramString);
  }
  
  public void Qf(String paramString)
  {
    this.Ak.add(paramString);
  }
  
  public void Qg(String paramString)
  {
    this.ib.remove(paramString);
  }
  
  public void Qh(String paramString)
  {
    if (paramString != null) {
      this.hg.put(paramString, Boolean.valueOf(true));
    }
  }
  
  public void Qi(String paramString)
  {
    this.jdField_if.remove(paramString);
  }
  
  public void Qj(String paramString)
  {
    this.hc.put(paramString, Boolean.valueOf(true));
  }
  
  public void Qk(String paramString)
  {
    if (this.hc.containsKey(paramString)) {
      this.hc.remove(paramString);
    }
  }
  
  public void Ql(String paramString)
  {
    this.hd.put(paramString, Boolean.valueOf(true));
  }
  
  public void Qm(String paramString)
  {
    if (this.hd.containsKey(paramString)) {
      this.hd.remove(paramString);
    }
  }
  
  public void Qn(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "removeHotChatSeq groupUin:" + paramString);
    }
    this.gZ.put(paramString, Long.valueOf(0L));
    this.ha.put(paramString, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    this.he.put(paramString, Long.valueOf(0L));
    if (this.app.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Anaz$a.remove("getTroopLastMessageTime" + paramString);
      this.jdField_a_of_type_Anaz$a.remove("getTroopMemberSeq" + paramString);
      this.jdField_a_of_type_Anaz$a.remove("getTroopConfigSeq" + paramString);
      this.jdField_a_of_type_Anaz$a.remove("getTroopExpiredSeq" + paramString);
    }
  }
  
  public void Qo(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.remove("deleteFriendMsgTime" + paramString);
    }
  }
  
  public byte[] R(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.hz.containsKey(paramString))
    {
      Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "tribe_bytes_chat_sig", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = aqoj.ag((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hz.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.hz.get(paramString);
    }
    return null;
  }
  
  public byte[] S(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.hA.containsKey(paramString))
    {
      Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "movie_ticket_bytes_chat_sig", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = aqoj.ag((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hA.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.hA.get(paramString);
    }
    return null;
  }
  
  public byte[] T(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.hw.containsKey(paramString))
    {
      Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "accost", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = aqoj.ag((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hw.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.hw.get(paramString);
    }
    return null;
  }
  
  public ArrayList<Object[]> U(String paramString)
  {
    return (ArrayList)this.ib.get(paramString);
  }
  
  public byte[] U(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.hQ.containsKey(paramString))
    {
      Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "approval_assistant", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = aqoj.ag((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hQ.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.hQ.get(paramString);
    }
    return null;
  }
  
  public void UG(int paramInt)
  {
    this.dEP = paramInt;
    if (this.app.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Anaz$a.putInt("getlastMessageTime", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>setBuddyMsgLastSeq lastseq = " + paramInt);
      }
    }
  }
  
  public void UH(int paramInt)
  {
    if (Jh() != paramInt)
    {
      this.dER = paramInt;
      this.jdField_a_of_type_Anaz$a.putInt("msgsignal_switch", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>setMsgSignalSwitch = " + paramInt);
      }
    }
  }
  
  public ArrayList<Object[]> V(String paramString)
  {
    return (ArrayList)this.jdField_if.get(paramString);
  }
  
  public byte[] V(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.hx.containsKey(paramString))
    {
      Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "nearby_assistant", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = aqoj.ag((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hx.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.hx.get(paramString);
    }
    return null;
  }
  
  public byte[] W(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.hy.containsKey(paramString))
    {
      Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "dating", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = aqoj.ag((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hy.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.hy.get(paramString);
    }
    return null;
  }
  
  public void Y(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.hJ)
    {
      paramString1 = a(paramString1, paramInt);
      if (paramString1 == null) {
        return;
      }
      if (paramString1.containsKey(paramString2)) {
        paramString1.remove(paramString2);
      }
      return;
    }
  }
  
  public void Y(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("removeDiscPullSeqCache, uinArray: ");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        localStringBuilder.append(str).append(",");
        if (this.hg.containsKey(str)) {
          this.hg.remove(str);
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, localStringBuilder.toString());
  }
  
  public DisMsgReadedNotify a(String paramString)
  {
    return (DisMsgReadedNotify)this.ig.remove(paramString);
  }
  
  public GroupMsgReadedNotify a(String paramString)
  {
    return (GroupMsgReadedNotify)this.ih.remove(paramString);
  }
  
  public anba a()
  {
    if (this.jdField_a_of_type_Anba == null) {
      this.jdField_a_of_type_Anba = new anba(this.app, 1026, "hctopic", this.pref, this.jdField_a_of_type_Anaz$a);
    }
    return this.jdField_a_of_type_Anba;
  }
  
  public AppShareID a(String paramString)
  {
    if (!this.ii.containsKey(paramString))
    {
      EntityManager localEntityManager = this.app.a().createEntityManager();
      AppShareID localAppShareID = (AppShareID)localEntityManager.find(AppShareID.class, "strPkgName=?", new String[] { paramString });
      if (localAppShareID != null)
      {
        a(paramString, localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Add cache from db appid = " + paramString);
        }
        localEntityManager.close();
      }
    }
    for (;;)
    {
      if (this.ii.get(paramString) != aqgb.a) {
        break label187;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Not exist in db appid = " + paramString);
      }
      a(paramString, aqgb.a);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Already in cache appid = " + paramString);
      }
    }
    label187:
    return (AppShareID)this.ii.get(paramString);
  }
  
  public MessageRecord a(int paramInt, String paramString, long paramLong)
  {
    paramString = String.valueOf(paramInt) + "_" + paramString + "_" + paramLong;
    MessageRecord localMessageRecord = (MessageRecord)this.hL.get(paramString);
    this.hL.remove(paramString);
    return localMessageRecord;
  }
  
  public OpenID a(String paramString)
  {
    if (!this.ij.containsKey(paramString))
    {
      EntityManager localEntityManager = this.app.a().createEntityManager();
      OpenID localOpenID = (OpenID)localEntityManager.find(OpenID.class, paramString);
      if (localOpenID != null)
      {
        a(paramString, localOpenID);
        if (QLog.isColorLevel()) {
          QLog.d("openid", 2, "Add cache from db appid = " + paramString);
        }
      }
      localEntityManager.close();
    }
    for (;;)
    {
      return (OpenID)this.ij.get(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("openid", 2, "Already in cache appid = " + paramString + ",openid=" + ((OpenID)this.ij.get(paramString)).openID);
      }
    }
  }
  
  public Map<String, Set<Integer>> a(String paramString, int paramInt)
  {
    synchronized (this.hJ)
    {
      paramString = top.u(paramString, paramInt);
      if ((this.hJ.containsKey(paramString)) && (this.hJ.get(paramString) != null))
      {
        Map localMap = (Map)this.hJ.get(paramString);
        if ((localMap != null) && (localMap.isEmpty()))
        {
          this.hJ.remove(paramString);
          return null;
        }
        return localMap;
      }
    }
    return null;
  }
  
  public void a(String paramString, DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    this.ig.put(paramString, paramDisMsgReadedNotify);
  }
  
  public void a(String paramString, GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    this.ih.put(paramString, paramGroupMsgReadedNotify);
  }
  
  public void a(String paramString, AppShareID paramAppShareID)
  {
    this.ii.put(paramString, paramAppShareID);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "add share appid to cache = " + paramString);
    }
  }
  
  public void a(String paramString, OpenID paramOpenID)
  {
    this.ij.put(paramString, paramOpenID);
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "add openid to cache = " + paramOpenID);
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap;
    if (paramBoolean)
    {
      localConcurrentHashMap = this.hT;
      label26:
      paramString2 = paramString1 + "_" + paramString2;
    }
    for (;;)
    {
      try
      {
        paramString1 = (byte[])localConcurrentHashMap.get(paramString2);
        if (((paramString1 != null) && (Arrays.equals(paramString1, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          break;
        }
        BaseApplication localBaseApplication = this.app.getApp();
        StringBuilder localStringBuilder = new StringBuilder().append(this.app.getCurrentAccountUin()).append("MatchChat");
        if (!paramBoolean) {
          break label190;
        }
        paramString1 = "";
        paramString1 = localBaseApplication.getSharedPreferences(paramString1, 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
          break label197;
        }
        localConcurrentHashMap.remove(paramString2);
        paramString1.remove(paramString2);
        paramString1.commit();
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      localConcurrentHashMap = this.hU;
      break label26;
      label190:
      paramString1 = "_campus";
      continue;
      label197:
      localConcurrentHashMap.put(paramString2, paramArrayOfByte);
      paramString1.putString(paramString2, aqoj.C(paramArrayOfByte));
    }
  }
  
  public byte[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.app.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    ConcurrentHashMap localConcurrentHashMap;
    BaseApplication localBaseApplication;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localConcurrentHashMap = this.hT;
      paramString2 = paramString1 + "_" + paramString2;
      if (localConcurrentHashMap.containsKey(paramString2)) {
        break label182;
      }
      localBaseApplication = this.app.getApp();
      localStringBuilder = new StringBuilder().append(this.app.getCurrentAccountUin()).append("MatchChat");
      if (!paramBoolean) {
        break label175;
      }
    }
    label175:
    for (paramString1 = "";; paramString1 = "_campus")
    {
      paramString1 = localBaseApplication.getSharedPreferences(paramString1, 0).getString(paramString2, null);
      if (TextUtils.isEmpty(paramString1)) {
        break label192;
      }
      paramString1 = aqoj.ag(paramString1);
      if ((paramString1 == null) || (paramString1.length <= 0)) {
        break label192;
      }
      localConcurrentHashMap.put(paramString2, paramString1);
      return paramString1;
      localConcurrentHashMap = this.hU;
      break;
    }
    label182:
    return (byte[])localConcurrentHashMap.get(paramString2);
    label192:
    return null;
  }
  
  public long aA(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.gZ.containsKey(paramString))
    {
      l = this.pref.getLong("getTroopLastMessageTime" + paramString, 0L);
      this.gZ.put(paramString, Long.valueOf(l));
    }
    paramString = (Long)this.gZ.get(paramString);
    if (paramString == null) {}
    for (long l = 0L;; l = paramString.longValue()) {
      return l;
    }
  }
  
  public void aA(MessageRecord paramMessageRecord)
  {
    this.I = paramMessageRecord;
  }
  
  public long aB(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.he.containsKey(paramString))
    {
      long l = this.pref.getLong("getTroopExpiredSeq" + paramString, 0L);
      this.he.put(paramString, Long.valueOf(l));
    }
    return ((Long)this.he.get(paramString)).longValue();
  }
  
  public void aB(MessageRecord paramMessageRecord)
  {
    this.J = paramMessageRecord;
  }
  
  public long aC(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.hf.containsKey(paramString))
    {
      long l = this.pref.getLong("getDiscussionExpiredSeq" + paramString, 0L);
      this.hf.put(paramString, Long.valueOf(l));
    }
    return ((Long)this.hf.get(paramString)).longValue();
  }
  
  public long aD(String paramString)
  {
    String str = this.app.getCurrentAccountUin();
    if (str == null) {
      return 0L;
    }
    if (!this.hG.containsKey(paramString))
    {
      long l = this.pref.getLong(paramString + str, 0L);
      this.hG.put(paramString, Long.valueOf(l));
    }
    return ((Long)this.hG.get(paramString)).longValue();
  }
  
  public void aD(String paramString, int paramInt1, int paramInt2)
  {
    w(paramString, paramInt1).add(Integer.valueOf(paramInt2));
    if (w(paramString, paramInt1).size() > 50)
    {
      paramInt2 = 0;
      while (paramInt2 < 10)
      {
        w(paramString, paramInt1).remove(0);
        paramInt2 += 1;
      }
    }
    this.jdField_a_of_type_Anaz$a.putString("getLongMsgIdArray" + top.u(paramString, paramInt1), listToString(w(paramString, paramInt1))).commit();
  }
  
  public long aE(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    Long localLong2 = (Long)this.hF.get(paramString);
    Long localLong1 = localLong2;
    if (localLong2 == null)
    {
      long l = this.pref.getLong("getFriendFeedLastTime" + paramString, -1L);
      localLong1 = Long.valueOf(l);
      this.hF.put(paramString, Long.valueOf(l));
    }
    return localLong1.longValue();
  }
  
  public long aF(String paramString)
  {
    paramString = (Long)this.hM.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public long aG(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.hh.containsKey(paramString))
    {
      long l = this.pref.getLong("getDiscussionLastMessageTime" + paramString, 0L);
      this.hh.put(paramString, Long.valueOf(l));
    }
    return ((Long)this.hh.get(paramString)).longValue();
  }
  
  public long aH(String paramString)
  {
    long l1 = aG(paramString);
    long l2 = aC(paramString);
    long l3 = j(paramString, 3000);
    return Math.max(Math.max(l1, l2), l3);
  }
  
  public long aI(String paramString)
  {
    long l1 = j(paramString, 1);
    long l2 = aA(paramString);
    long l3 = aB(paramString);
    return Math.max(Math.max(l2, l1), l3);
  }
  
  public void aJ(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, aA(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addGroupMsgLastSeq " + paramLong);
    }
    this.gZ.put(paramString, Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getTroopLastMessageTime" + paramString, paramLong);
    }
  }
  
  public void aK(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, aB(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addGroupExpiredSeq " + paramLong);
    }
    this.he.put(paramString, Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getTroopExpiredSeq" + paramString, paramLong);
    }
  }
  
  public void aL(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, aC(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addDiscExpiredSeq " + paramLong);
    }
    this.hf.put(paramString, Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getDiscussionExpiredSeq" + paramString, paramLong);
    }
  }
  
  public void aM(String paramString, long paramLong)
  {
    Object localObject = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      paramString = (String)localObject + "_noticetime_" + paramString;
      this.hZ.put(paramString, Long.valueOf(paramLong));
      localObject = this.app.getApp().getSharedPreferences((String)localObject + "birth", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public void aN(String paramString, long paramLong)
  {
    this.hG.put(paramString, Long.valueOf(paramLong));
    String str = this.app.getCurrentAccountUin();
    if (str != null) {
      this.jdField_a_of_type_Anaz$a.putLong(paramString + str, paramLong).commit();
    }
  }
  
  public void aO(String paramString, long paramLong)
  {
    this.hF.put(paramString, Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getFriendFeedLastTime" + paramString, paramLong);
    }
  }
  
  public void aP(String paramString, long paramLong)
  {
    this.hM.put(paramString, Long.valueOf(paramLong));
  }
  
  public void aQ(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, aG(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addDiscussionMsgLastSeq " + paramLong);
    }
    this.hh.put(paramString, Long.valueOf(paramLong));
    if (this.app.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Anaz$a.putLong("getDiscussionLastMessageTime" + paramString, paramLong);
    }
  }
  
  public boolean aQ(MessageRecord paramMessageRecord)
  {
    return m(paramMessageRecord.frienduin, paramMessageRecord.istroop, top.f(paramMessageRecord));
  }
  
  public boolean aR(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (paramMessageRecord.isLongMsg())
        {
          if ((this.hK.containsKey(localObject)) && (((ConcurrentHashMap)this.hK.get(localObject)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId)))) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      } while (!this.hl.containsKey(localObject));
      localObject = (ConcurrentHashMap)this.hl.get(localObject);
    } while ((localObject == null) || (!((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramMessageRecord.uniseq))));
    return true;
  }
  
  public boolean aS(MessageRecord paramMessageRecord)
  {
    boolean bool = this.app.a().aR(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -1051) || (paramMessageRecord.msgtype == -1035)) {}
    do
    {
      return bool;
      if ((!bool) || (paramMessageRecord.isLongMsg()) || ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))) {
        break;
      }
      Object localObject = top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      localObject = (ConcurrentHashMap)this.hl.get(localObject);
      if (localObject == null) {
        break;
      }
      paramMessageRecord = (anaz.c)((ConcurrentHashMap)localObject).get(Long.valueOf(paramMessageRecord.uniseq));
      if (paramMessageRecord == null) {
        break;
      }
      long l = System.currentTimeMillis() - paramMessageRecord.akv;
      if ((l >= paramMessageRecord.delayTime) || (l <= 0L)) {
        break;
      }
      bool = false;
    } while (!QLog.isDevelopLevel());
    QLog.d("MsgSend", 4, "isStartSendingUI, " + false);
    return false;
    return bool;
  }
  
  public boolean aT(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.isLongMsg()) && ((paramMessageRecord instanceof MessageForLongMsg))) {
      paramMessageRecord = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
    }
    while (paramMessageRecord.hasNext()) {
      if (((MessageRecord)paramMessageRecord.next()).extraflag != 0)
      {
        return true;
        if (paramMessageRecord.extraflag != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean aU(MessageRecord paramMessageRecord)
  {
    if (this.I == null) {}
    boolean bool;
    label44:
    MessageRecord localMessageRecord;
    do
    {
      return false;
      if ((!paramMessageRecord.isLongMsg()) || (!(this.I instanceof MessageForLongMsg))) {
        break label119;
      }
      Iterator localIterator = ((MessageForLongMsg)this.I).longMsgFragmentList.iterator();
      bool = false;
      if (!localIterator.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)localIterator.next();
    } while (localMessageRecord.extraflag != 0);
    if ((localMessageRecord.frienduin.equals(paramMessageRecord.frienduin)) && (localMessageRecord.istroop == paramMessageRecord.istroop) && (localMessageRecord.uniseq == paramMessageRecord.uniseq)) {
      bool = true;
    }
    for (;;)
    {
      break label44;
      return bool;
      label119:
      if ((this.I != paramMessageRecord) || (this.I.extraflag != 0)) {
        break;
      }
      return true;
    }
  }
  
  public boolean aV(MessageRecord paramMessageRecord)
  {
    if (this.hn.isEmpty()) {
      return false;
    }
    if (paramMessageRecord.isLongMsg()) {}
    for (String str = String.format("%s&%d&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.longMsgId), Integer.valueOf(paramMessageRecord.longMsgCount) }); this.hn.containsKey(str); str = String.format("%s&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Long.valueOf(paramMessageRecord.shmsgseq) }))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "RevokeNotifyCache, msgFilter true, " + paramMessageRecord.toString());
      }
      return true;
    }
    return false;
  }
  
  public int al(String paramString, int paramInt)
  {
    paramString = w(paramString, paramInt).iterator();
    for (paramInt = 0; paramString.hasNext(); paramInt = Math.max(((Integer)paramString.next()).intValue(), paramInt)) {}
    return paramInt + 1;
  }
  
  public byte[] am()
  {
    String str;
    if (((this.fs == null) || (this.fs.length == 0)) && (this.app.getCurrentAccountUin() != null))
    {
      str = this.pref.getString("getMsgV4_vSyncCookie", "");
      if (str.length() != 0) {
        break label97;
      }
    }
    label97:
    for (this.fs = null;; this.fs = aqhs.hexStr2Bytes(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>getLastSyncCookie lastSyncCookie:" + aqhs.bytes2HexStr(this.fs));
      }
      return this.fs;
    }
  }
  
  public byte[] an()
  {
    if ((this.ft == null) && (this.app.getCurrentAccountUin() != null)) {
      this.ft = aqhs.hexStr2Bytes(this.pref.getString("getMsgV4_vPubAccountCookie", ""));
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "--->>getLastPubAccountCookie lastPACookie:" + aqhs.bytes2HexStr(this.ft));
    }
    return this.ft;
  }
  
  public void aw(MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      String str;
      synchronized (this.hJ)
      {
        if (!paramMessageRecord.isLongMsg()) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "addOnlineLongMsgFragment longid=" + paramMessageRecord.getLongMsgInfoString());
        }
        localObject = top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        str = top.f(paramMessageRecord);
        if ((this.hJ.containsKey(localObject)) && (this.hJ.get(localObject) != null))
        {
          localConcurrentHashMap1 = (ConcurrentHashMap)this.hJ.get(localObject);
          if (!localConcurrentHashMap1.containsKey(str)) {
            break label195;
          }
          localObject = (Set)localConcurrentHashMap1.get(str);
          ((Set)localObject).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
          if (paramMessageRecord.longMsgCount <= ((Set)localObject).size()) {
            localConcurrentHashMap1.remove(str);
          }
          return;
        }
      }
      ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
      this.hJ.put(localObject, localConcurrentHashMap1);
      continue;
      label195:
      Object localObject = new HashSet();
      ((Set)localObject).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
      localConcurrentHashMap1.put(str, localObject);
    }
  }
  
  public boolean awt()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isDiscPullSeqFinish size = " + this.hg.size());
    }
    return this.hg.isEmpty();
  }
  
  public boolean awu()
  {
    return this.hc.isEmpty();
  }
  
  public boolean awv()
  {
    return this.hd.isEmpty();
  }
  
  public boolean aww()
  {
    return (this.hm == null) || (this.hm.isEmpty());
  }
  
  public boolean awx()
  {
    return this.cEJ;
  }
  
  public void ax(MessageRecord paramMessageRecord)
  {
    String str = String.valueOf(paramMessageRecord.istroop) + "_" + paramMessageRecord.frienduin + "_" + paramMessageRecord.uniseq;
    this.hL.put(str, paramMessageRecord);
  }
  
  public void ay(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.frienduin + "_" + paramMessageRecord.msgUid + "_" + paramMessageRecord.shmsgseq;
    this.cW.add(paramMessageRecord);
  }
  
  public long az(String paramString)
  {
    String str = this.app.getCurrentAccountUin();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {}
    long l;
    do
    {
      return -1L;
      paramString = str + "_noticetime_" + paramString;
      if (this.hZ.containsKey(paramString)) {
        break;
      }
      l = this.app.getApp().getSharedPreferences(str + "birth", 0).getLong(paramString, -1L);
    } while (l == -1L);
    this.hZ.put(paramString, Long.valueOf(l));
    return ((Long)this.hZ.get(paramString)).longValue();
  }
  
  public void az(MessageRecord paramMessageRecord)
  {
    f(paramMessageRecord, MessageHandler.cwL);
  }
  
  public boolean b(String paramString, long paramLong1, long paramLong2)
  {
    if (this.cW.size() == 0) {
      return false;
    }
    paramString = paramString + "_" + paramLong1 + "_" + paramLong2;
    return this.cW.contains(paramString);
  }
  
  public boolean bl(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.cEM = this.pref.getBoolean("getRegPrxyFailFlag", false);
    }
    return this.cEM;
  }
  
  public void bv(byte[] paramArrayOfByte)
  {
    this.fs = paramArrayOfByte;
    if (this.app.getCurrentAccountUin() != null)
    {
      String str = aqhs.bytes2HexStr(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>setLastSyncCookie lastSyncCookie:" + str);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>setBuddyMsgLastSeq cookie = " + aqhs.bytes2HexStr(paramArrayOfByte));
      }
      this.jdField_a_of_type_Anaz$a.putString("getMsgV4_vSyncCookie", str);
    }
  }
  
  public void bw(byte[] paramArrayOfByte)
  {
    this.ft = paramArrayOfByte;
    if (this.app.getCurrentAccountUin() != null)
    {
      paramArrayOfByte = aqhs.bytes2HexStr(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "--->>setLastPubAccountCookie lastPACookie:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_Anaz$a.putString("getMsgV4_vPubAccountCookie", paramArrayOfByte);
    }
  }
  
  public boolean c(int paramInt, String paramString, long paramLong)
  {
    paramString = String.valueOf(paramInt) + "_" + paramString + "_" + paramLong;
    return this.hL.containsKey(paramString);
  }
  
  public byte[] c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.app.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.hR.containsKey(paramString1))
    {
      paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "confess_sig", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = aqoj.ag(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.hR.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.hR.get(paramString1);
    }
    return null;
  }
  
  public void cmT()
  {
    if (!this.hl.isEmpty())
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.hl.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if ((((Map.Entry)localObject).getValue() != null) && (!((ConcurrentHashMap)((Map.Entry)localObject).getValue()).isEmpty()))
        {
          localObject = ((ConcurrentHashMap)((Map.Entry)localObject).getValue()).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("uin", ((anaz.c)localEntry.getValue()).frienduin);
              localJSONObject.put("type", ((anaz.c)localEntry.getValue()).istroop);
              localJSONObject.put("uniseq", ((anaz.c)localEntry.getValue()).uniseq);
              localJSONArray.put(localJSONObject);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      if (this.app.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_Anaz$a.putString("msgSending", localJSONArray.toString());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "msgSending:write msgSending file before exit," + localJSONArray.toString());
        }
      }
    }
    commit();
    this.dEP = -1;
    this.gZ.clear();
    this.ib.clear();
    this.hh.clear();
    this.jdField_if.clear();
    this.ig.clear();
    this.ih.clear();
    this.hj.clear();
    this.akt = 0L;
    this.ii.clear();
    this.ij.clear();
    this.Ak.clear();
    this.hl.clear();
    this.hm.clear();
    this.ha.clear();
    this.hb.clear();
    this.hd.clear();
    this.hc.clear();
    this.hF.clear();
    if (this.jdField_a_of_type_Anba != null) {
      this.jdField_a_of_type_Anba.clearCache();
    }
  }
  
  public void commit()
  {
    if (this.jdField_a_of_type_Anaz$a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "msgCache commit.");
      }
      this.jdField_a_of_type_Anaz$a.commit();
    }
  }
  
  public byte[] d(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.app.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.hS.containsKey(paramString1))
    {
      paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "LimitChat", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = aqoj.ag(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.hS.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.hS.get(paramString1);
    }
    return null;
  }
  
  public Object[] d(String paramString)
  {
    if (this.hb.containsKey(paramString)) {
      return (Object[])this.hb.get(paramString);
    }
    if (this.app.getCurrentAccountUin() != null)
    {
      long l1 = this.pref.getLong("getDiscussionMemberSeq" + paramString, -1L);
      long l2 = this.pref.getLong("getDiscussionConfigSeq" + paramString, -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public ArrayList<String> dD()
  {
    return this.Ak;
  }
  
  public ArrayList<stConfNumInfo> dE()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "cloneDiscNumInfoCache size = " + this.Aj.size());
      }
      ArrayList localArrayList = (ArrayList)this.Aj.clone();
      return localArrayList;
    }
    finally {}
  }
  
  public void dOM()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "clearDiscNumInfoCache");
      }
      this.Aj.clear();
      return;
    }
    finally {}
  }
  
  public void dON()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "clearDiscPullSeqCache");
    }
    this.hg.clear();
  }
  
  public void dOO()
  {
    this.hM.clear();
  }
  
  public void dOP()
  {
    synchronized (this.hJ)
    {
      this.hJ.clear();
      return;
    }
  }
  
  public void dOQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "dumpGroupMsgJob size = " + this.hc.size());
    }
  }
  
  public void dOR()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "dumpDiscMsgJob size = " + this.hd.size());
    }
  }
  
  public void dOS()
  {
    this.cW.clear();
  }
  
  public void e(long paramLong1, String paramString, long paramLong2)
  {
    Object localObject2 = (ArrayList)this.nd.get(Long.valueOf(paramLong1));
    Object localObject1 = localObject2;
    long l1;
    long l2;
    long l3;
    if (localObject2 == null) {
      if (this.nd.size() >= 20)
      {
        localObject1 = this.nd.keySet().iterator();
        l1 = 0L;
        if (!((Iterator)localObject1).hasNext()) {
          break label232;
        }
        l2 = ((Long)((Iterator)localObject1).next()).longValue();
        l3 = Long.parseLong((String)((ArrayList)this.nd.get(Long.valueOf(l2))).get(0));
        if (paramLong2 - l3 <= 300L) {
          break label202;
        }
      }
    }
    for (;;)
    {
      this.nd.remove(Long.valueOf(l2));
      localObject1 = new ArrayList();
      if (((ArrayList)localObject1).size() >= 20) {
        ((ArrayList)localObject1).remove(0);
      }
      localObject2 = Long.toString(paramLong2);
      if (((ArrayList)localObject1).size() == 0)
      {
        ((ArrayList)localObject1).add(localObject2);
        label180:
        ((ArrayList)localObject1).add(paramString);
        this.nd.put(Long.valueOf(paramLong1), localObject1);
        return;
        label202:
        if (l3 >= paramLong2) {
          break label229;
        }
        l1 = l2;
      }
      label229:
      for (;;)
      {
        break;
        ((ArrayList)localObject1).set(0, localObject2);
        break label180;
      }
      label232:
      l2 = l1;
    }
  }
  
  public boolean e(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgSend", 2, String.format("removeSendingCache key = %d %s %d", new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) }));
    }
    paramString = top.u(paramString, paramInt);
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (this.hl.containsKey(paramString))
    {
      localObject1 = (ConcurrentHashMap)this.hl.get(paramString);
      if (localObject1 != null)
      {
        localObject2 = (anaz.c)((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong));
        if ((localObject2 != null) && (((anaz.c)localObject2).akv > 0L))
        {
          long l = System.currentTimeMillis() - ((anaz.c)localObject2).akv;
          if ((l < MessageHandler.cwL) && (l > 0L))
          {
            bool1 = false;
            bool2 = bool1;
            if (localObject1 != null)
            {
              bool2 = bool1;
              if (((ConcurrentHashMap)localObject1).isEmpty()) {
                this.hl.remove(paramString);
              }
            }
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((!aww()) && (this.hm.containsKey(paramString)))
      {
        localObject1 = (ConcurrentHashMap)this.hm.get(paramString);
        if (localObject1 != null) {
          ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong));
        }
        if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).isEmpty())) {
          this.hm.remove(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "msgSending:delete result in messageSendingTemp " + this.hm);
        }
      }
      int i;
      if (this.hK.containsKey(paramString))
      {
        int j = 0;
        localObject1 = ((ConcurrentHashMap)this.hK.get(paramString)).keySet().iterator();
        do
        {
          paramInt = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          localObject2 = (Set)((ConcurrentHashMap)this.hK.get(paramString)).get(Integer.valueOf(i));
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("removeSendingCache  longMsgFragmentSet = %s", new Object[] { localObject2 }));
          }
        } while (!((Set)localObject2).contains(Long.valueOf(paramLong)));
        ((Set)localObject2).remove(Long.valueOf(paramLong));
        if (!((Set)localObject2).isEmpty()) {
          break label501;
        }
      }
      label501:
      for (paramInt = i;; paramInt = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "removeSendingCache uniseq=" + paramLong + "longid=" + i);
        }
        for (;;)
        {
          if (paramInt != 0) {
            ((ConcurrentHashMap)this.hK.get(paramString)).remove(Integer.valueOf(paramInt));
          }
          return bool2;
        }
      }
      bool1 = true;
      break;
    }
  }
  
  public byte[] e(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }
  
  public Object[] e(String paramString)
  {
    if (this.ha.containsKey(paramString)) {
      return (Object[])this.ha.get(paramString);
    }
    if (this.app.getCurrentAccountUin() != null)
    {
      long l1 = this.pref.getLong("getTroopMemberSeq" + paramString, -1L);
      long l2 = this.pref.getLong("getTroopConfigSeq" + paramString, -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public void eQ(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject1 = (RevokeMsgInfo)paramArrayList.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "RevokeNotifyCache, add cache, " + ((RevokeMsgInfo)localObject1).toString());
    }
    int j = ((RevokeMsgInfo)localObject1).istroop;
    Object localObject2 = ((RevokeMsgInfo)localObject1).frienduin;
    int i;
    if (((RevokeMsgInfo)localObject1).dyj > 1)
    {
      i = 1;
      if (i == 0) {
        break label254;
      }
      localObject1 = String.format("%s&%d&%d&%d", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(((RevokeMsgInfo)localObject1).dyi), Integer.valueOf(((RevokeMsgInfo)localObject1).dyj) });
    }
    for (;;)
    {
      label121:
      if (this.hn.containsKey(localObject1))
      {
        localObject1 = (ArrayList)this.hn.get(localObject1);
        localObject2 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            RevokeMsgInfo localRevokeMsgInfo1 = (RevokeMsgInfo)paramArrayList.next();
            Iterator localIterator = ((ArrayList)localObject1).iterator();
            RevokeMsgInfo localRevokeMsgInfo2;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localRevokeMsgInfo2 = (RevokeMsgInfo)localIterator.next();
            } while ((localRevokeMsgInfo1.shmsgseq != localRevokeMsgInfo2.shmsgseq) || (localRevokeMsgInfo1.msguid != localRevokeMsgInfo2.msguid));
            ((ArrayList)localObject2).add(localRevokeMsgInfo1);
            continue;
            i = 0;
            break;
            label254:
            localObject1 = String.format("%s&%d&%d", new Object[] { localObject2, Integer.valueOf(j), Long.valueOf(((RevokeMsgInfo)localObject1).shmsgseq) });
            break label121;
          }
        }
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        return;
      }
    }
    this.hn.put(localObject1, paramArrayList);
  }
  
  public int eb(String paramString)
  {
    if (!this.ia.containsKey(paramString)) {
      this.ia.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.ia.get(paramString)).intValue();
  }
  
  public int ec(String paramString)
  {
    if (!this.ie.containsKey(paramString)) {
      this.ie.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.ie.get(paramString)).intValue();
  }
  
  public void f(MessageRecord paramMessageRecord, int paramInt)
  {
    String str = top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    Object localObject1 = new anaz.c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, System.currentTimeMillis());
    ((anaz.c)localObject1).delayTime = paramInt;
    if (this.hl.containsKey(str))
    {
      localObject2 = (ConcurrentHashMap)this.hl.get(str);
      if (localObject2 != null) {
        ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      }
    }
    for (;;)
    {
      if (paramMessageRecord.isLongMsg())
      {
        if (!this.hK.containsKey(str)) {
          break label288;
        }
        if (!((ConcurrentHashMap)this.hK.get(str)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId))) {
          break;
        }
        ((HashSet)((ConcurrentHashMap)this.hK.get(str)).get(Integer.valueOf(paramMessageRecord.longMsgId))).add(Long.valueOf(paramMessageRecord.uniseq));
      }
      return;
      localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      this.hl.put(str, localObject2);
      continue;
      localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      this.hl.put(str, localObject2);
    }
    localObject1 = new HashSet();
    ((HashSet)localObject1).add(Long.valueOf(paramMessageRecord.uniseq));
    ((ConcurrentHashMap)this.hK.get(str)).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject1);
    return;
    label288:
    localObject1 = new ConcurrentHashMap();
    Object localObject2 = new HashSet();
    ((HashSet)localObject2).add(Long.valueOf(paramMessageRecord.uniseq));
    ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject2);
    this.hK.put(str, localObject1);
  }
  
  public void f(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      paramString1 = paramString1 + "_" + paramString2;
      try
      {
        paramString2 = (byte[])this.hR.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "confess_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hR.remove(paramString1);
          paramString2.remove(paramString1);
        }
        for (;;)
        {
          paramString2.commit();
          return;
          this.hR.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public boolean f(String paramString, int paramInt, long paramLong)
  {
    if (this.J == null) {}
    while ((!this.J.frienduin.equals(paramString)) || (this.J.istroop != paramInt) || (this.J.uniseq != paramLong)) {
      return false;
    }
    return true;
  }
  
  public byte[] f(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.app.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.hV.containsKey(paramString1))
    {
      paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "tiny_session_sig", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = aqoj.ag(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.hV.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.hV.get(paramString1);
    }
    return null;
  }
  
  public void fR(String paramString, int paramInt)
  {
    this.ia.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "setTroopMsgResponseState state: " + paramString + " state: " + paramInt);
      }
      if (paramInt == 2) {
        Qk(paramString);
      }
    }
  }
  
  public void fS(String paramString, int paramInt)
  {
    this.ie.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setDiscussionMsgState discussionUin: ").append(paramString).append(" state: ").append(paramInt);
        QLog.d(TAG, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        Qm(paramString);
      }
    }
  }
  
  public Pair<Long, Long> g(String paramString)
  {
    if (this.app.getCurrentAccountUin() == null) {
      localObject = null;
    }
    Pair localPair;
    do
    {
      return localObject;
      localPair = (Pair)this.hi.get(paramString);
      localObject = localPair;
    } while (localPair != null);
    Object localObject = new Pair(Long.valueOf(this.pref.getLong("getDisscussionInfoSeq" + paramString, 0L)), Long.valueOf(this.pref.getLong("getDisscussionInfoLastTime" + paramString, 0L)));
    this.hi.put(paramString, localObject);
    return localObject;
  }
  
  public void g(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.ic.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.ic.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      paramString1 = paramString1 + "_" + paramString2;
      try
      {
        paramString2 = (byte[])this.hS.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "LimitChat", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hS.remove(paramString1);
          paramString2.remove(paramString1);
        }
        for (;;)
        {
          paramString2.commit();
          return;
          this.hS.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public byte[] g(String paramString1, String paramString2)
  {
    if ((this.app.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.hW.containsKey(paramString1))
    {
      paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "qq_circle", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = aqoj.ag(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.hW.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.hW.get(paramString1);
    }
    return null;
  }
  
  public long gR()
  {
    String str = this.app.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {}
    long l;
    do
    {
      return -1L;
      if (this.hX.containsKey(str)) {
        break;
      }
      l = this.app.getApp().getSharedPreferences(str + "birth", 0).getLong(str + "_time", -1L);
    } while (l == -1L);
    this.hX.put(str, Long.valueOf(l));
    return ((Long)this.hX.get(str)).longValue();
  }
  
  public long gS()
  {
    if ((this.aks == -1L) && (this.app.getCurrentAccountUin() != null)) {
      this.aks = this.pref.getLong("getTroopDiscMsgLastTime", 0L);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "--->>getTroopAndDiscMsgLastTime lastTime: " + this.aks);
    }
    return this.aks;
  }
  
  public Pair<Long, Long> h(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.app.getCurrentAccountUin() == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.hj.containsKey(paramString))
    {
      long l1 = this.pref.getLong("getC2CLastMessageTime" + paramString, 0L);
      long l2 = this.pref.getLong("getC2CLastMessageTimeRand" + paramString, 0L);
      this.hj.put(paramString, new Pair(Long.valueOf(l1), Long.valueOf(l2)));
    }
    return (Pair)this.hj.get(paramString);
  }
  
  public void h(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.id.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.id.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void h(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    a(paramString1, paramString2, paramArrayOfByte, true);
  }
  
  public void i(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      paramString1 = paramString1 + "_" + paramString2;
      try
      {
        paramString2 = (byte[])this.hV.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "tiny_session_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hV.remove(paramString1);
          paramString2.remove(paramString1);
        }
        for (;;)
        {
          paramString2.commit();
          return;
          this.hV.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public boolean i(long paramLong, String paramString)
  {
    Object localObject = (ArrayList)this.nd.get(Long.valueOf(paramLong));
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    ((Iterator)localObject).next();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals((String)((Iterator)localObject).next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean i(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = w(paramString, paramInt1).iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() == paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "long msg id is exist! uin=" + paramString + ",istroop=" + paramInt1 + ",longMsgID=" + paramInt2);
        }
        return true;
      }
    }
    return false;
  }
  
  public long j(String paramString, int paramInt)
  {
    String str = top.u(paramString, paramInt);
    if (this.app.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + 0);
      }
      return 0L;
    }
    if (!this.hE.containsKey(str))
    {
      long l = this.pref.getLong("getDelMsgLastSeq" + str, 0L);
      this.hE.put(str, Long.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l);
      }
    }
    return ((Long)this.hE.get(str)).longValue();
  }
  
  public void j(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramString1 = paramString1 + "_" + paramString2;
    for (;;)
    {
      try
      {
        paramString2 = (byte[])this.hW.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          break;
        }
        paramString2 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "qq_circle", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hW.remove(paramString1);
          paramString2.remove(paramString1);
          paramString2.apply();
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.d(TAG + "QQCircle", 2, "addQQCircleChatSessionKey throw e, e = ", paramString1);
        return;
      }
      this.hW.put(paramString1, paramArrayOfByte);
      paramString2.putString(paramString1, aqoj.C(paramArrayOfByte));
    }
  }
  
  public long k(String paramString, int paramInt)
  {
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (this.app.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getBreakPointSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + 0);
      }
      return 0L;
    }
    if (!this.hH.containsKey(localPair))
    {
      long l = this.pref.getLong("getBreakPointSeq" + paramString + "_" + paramInt, 0L);
      this.hH.put(localPair, Long.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getBreakPointSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l);
      }
    }
    return ((Long)this.hH.get(localPair)).longValue();
  }
  
  public long l(String paramString, int paramInt)
  {
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.hI.containsKey(localPair))
    {
      long l = this.pref.getLong("getAIOLastSeq" + paramString + "_" + paramInt, 0L);
      this.hI.put(localPair, Long.valueOf(l));
    }
    return ((Long)this.hI.get(localPair)).longValue();
  }
  
  public void l(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addWpaMsgKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.hp.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.hp.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = aqhs.bytes2HexStr(paramArrayOfByte);
        this.jdField_a_of_type_Anaz$a.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void li(long paramLong)
  {
    this.ic.remove(Long.valueOf(paramLong));
  }
  
  public void lj(long paramLong)
  {
    this.id.remove(Long.valueOf(paramLong));
  }
  
  public void lk(long paramLong)
  {
    String str = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramLong > 0L))
    {
      this.hX.put(str, Long.valueOf(paramLong));
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(str + "birth", 0).edit();
      localEditor.putLong(str + "_time", paramLong);
      localEditor.apply();
    }
  }
  
  public void ll(long paramLong)
  {
    if (this.aks < paramLong)
    {
      this.aks = paramLong;
      if (this.app.getCurrentAccountUin() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "--->>setTroopAndDiscMsgLastTime lastTime: " + paramLong);
        }
        this.jdField_a_of_type_Anaz$a.putLong("getTroopDiscMsgLastTime", this.aks);
      }
    }
  }
  
  public void m(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addPCQQSearchMsgKey uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.hq.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.hq.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = aqhs.bytes2HexStr(paramArrayOfByte);
        this.jdField_a_of_type_Anaz$a.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public boolean m(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.hJ)
    {
      paramString1 = a(paramString1, paramInt);
      if (paramString1 == null) {
        return false;
      }
      if (paramString1.containsKey(paramString2))
      {
        if (((Set)paramString1.get(paramString2)).isEmpty())
        {
          paramString1.remove(paramString2);
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public void mo(List<stConfNumInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 584	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +42 -> 47
    //   8: getstatic 162	anaz:TAG	Ljava/lang/String;
    //   11: astore_3
    //   12: new 418	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1399
    //   22: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: astore 4
    //   27: aload_1
    //   28: ifnonnull +31 -> 59
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_3
    //   34: iconst_2
    //   35: aload 4
    //   37: iload_2
    //   38: invokevirtual 591	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 598	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: getfield 201	anaz:Aj	Ljava/util/ArrayList;
    //   51: aload_1
    //   52: invokevirtual 1311	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   55: pop
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_1
    //   60: invokeinterface 535 1 0
    //   65: istore_2
    //   66: goto -33 -> 33
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	anaz
    //   0	74	1	paramList	List<stConfNumInfo>
    //   32	34	2	i	int
    //   11	23	3	str	String
    //   25	11	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	27	69	finally
    //   33	47	69	finally
    //   47	56	69	finally
    //   59	66	69	finally
  }
  
  public void mp(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        aw((MessageRecord)paramList.next());
      }
    }
  }
  
  public ArrayList<msg_comm.Msg> n(long paramLong)
  {
    return (ArrayList)this.ic.get(Long.valueOf(paramLong));
  }
  
  public void n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    label769:
    label779:
    label794:
    label800:
    for (;;)
    {
      long l1;
      HashMap localHashMap;
      Object localObject;
      int i1;
      int n;
      try
      {
        l1 = System.nanoTime();
        localHashMap = new HashMap();
        localHashMap.put("isFirstOpen", String.valueOf(paramInt3));
        localObject = top.u(paramString, paramInt1);
        if ((ne != null) && (ne.containsKey(localObject)))
        {
          localObject = (anaz.b)ne.get(localObject);
          localHashMap.put("isInited", String.valueOf(((anaz.b)localObject).isInited));
          localHashMap.put("isMsgExisted", String.valueOf(((anaz.b)localObject).cEO));
          localHashMap.put("msgCostTime", String.valueOf(((anaz.b)localObject).aku));
          if (paramInt1 != 1) {
            break label794;
          }
          i = this.app.cs(paramString);
          paramString = this.app.a().a().a(paramString, paramInt1);
          if (paramString == null) {
            break label779;
          }
          k = paramString.dEU;
          j = paramString.dEV;
          m = paramString.convCount;
          paramString = this.app.a(0).a().b();
          i1 = 0;
          paramInt3 = 0;
          localObject = paramString.keySet();
          if ((localObject == null) || (((Set)localObject).size() <= 0)) {
            break label769;
          }
          n = ((Set)localObject).size();
          localObject = ((Set)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (paramString.get(str) == null) {
              break label766;
            }
            paramInt3 = ((List)paramString.get(str)).size() + paramInt3;
            break label800;
          }
        }
        else
        {
          localHashMap.put("isInited", "true");
          localHashMap.put("isMsgExisted", "true");
          localHashMap.put("msgCostTime", "0");
          continue;
        }
        localHashMap.put("uintype", String.valueOf(paramInt1));
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      for (;;)
      {
        localHashMap.put("recentLoc", String.valueOf(k));
        localHashMap.put("activeConvLoc", String.valueOf(j));
        localHashMap.put("convCount", String.valueOf(m));
        localHashMap.put("msgFrom", String.valueOf(paramInt2));
        localHashMap.put("troopSpeType", String.valueOf(i));
        localHashMap.put("msgCacheSize", String.valueOf(paramInt3));
        localHashMap.put("cacheSize", String.valueOf(n));
        localHashMap.put("isCacheExpired", String.valueOf(cEL));
        long l2 = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
        long l3 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
        long l4 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
        localHashMap.put("freeMemory", String.valueOf(l2));
        localHashMap.put("totalMemory", String.valueOf(l3));
        localHashMap.put("maxMemory", String.valueOf(l4));
        localHashMap.put("cacheType", String.valueOf(MsgLruCache.cacheConfig));
        localHashMap.put("cacheVersion", "2");
        localObject = (MsgLruCache)paramString;
        paramString = ((MsgLruCache)localObject).getCacheTypeInfo(acss.czV);
        localObject = ((MsgLruCache)localObject).getCacheTypeInfo(acss.czW);
        localHashMap.put("msgCountA", String.valueOf(paramString.second));
        localHashMap.put("msgCountB", String.valueOf(((Pair)localObject).second));
        localHashMap.put("convCountA", String.valueOf(paramString.first));
        localHashMap.put("convCountB", String.valueOf(((Pair)localObject).first));
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msg_cache_strategy_tag", true, aqmq.atn, 0L, localHashMap, "");
        if (QLog.isColorLevel())
        {
          l2 = System.nanoTime();
          QLog.d(TAG, 2, new Object[] { "AIOTime reportMsgCacheStrategy cost:%d ", Long.valueOf((l2 - l1) / 1000000L), " param: ", localHashMap });
        }
        if ((m - 5 <= n) || (n >= 40)) {
          break;
        }
        return;
        label766:
        break label800;
        n = 0;
        paramInt3 = i1;
      }
      int m = -2;
      int j = -2;
      int k = -2;
      continue;
      int i = 1;
    }
  }
  
  public void n(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addBusinessCrmMsgKey----> sig:" + aqhs.bytes2HexStr(paramArrayOfByte) + ",length:" + paramArrayOfByte.length);
    }
    Object localObject = (byte[])this.hr.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.hr.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "crm", 0);
        paramArrayOfByte = aqoj.C(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void n(Set<String> paramSet)
  {
    String str = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramSet != null))
    {
      this.hY.put(str, paramSet);
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(str + "birth", 0).edit();
      localEditor.putStringSet(str + "_list", paramSet);
      localEditor.apply();
    }
  }
  
  public ArrayList<msg_comm.Msg> o(long paramLong)
  {
    return (ArrayList)this.id.get(Long.valueOf(paramLong));
  }
  
  public void o(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addBusinessCrmSigt uin:" + this.app.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + aqhs.bytes2HexStr(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.hs.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte))) {
      this.hs.put(paramString, paramArrayOfByte);
    }
  }
  
  public boolean oR(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.app.getCurrentAccountUin() != null) {
      return this.pref.contains("deleteFriendMsgTime" + paramString);
    }
    return false;
  }
  
  public void p(String paramString, byte[] paramArrayOfByte) {}
  
  public void q(String paramString, long paramLong1, long paramLong2)
  {
    this.hi.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.app.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Anaz$a.putLong("getDisscussionInfoSeq" + paramString, paramLong1);
      this.jdField_a_of_type_Anaz$a.putLong("getDisscussionInfoLastTime" + paramString, paramLong2);
    }
  }
  
  public void q(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.hu.get(paramString);
    if ((localObject == null) || (!localObject.equals(paramArrayOfByte)))
    {
      this.hu.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "pub", 0);
        paramArrayOfByte = aqoj.C(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void q(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.ib.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.ib.put(paramString, localArrayList1);
  }
  
  public void r(String paramString, long paramLong1, long paramLong2)
  {
    paramString = MD5.toMD5(paramString);
    this.hj.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.app.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Anaz$a.putLong("getC2CLastMessageTime" + paramString, paramLong1);
      this.jdField_a_of_type_Anaz$a.putLong("getC2CLastMessageTimeRand" + paramString, paramLong2);
    }
  }
  
  public void r(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.hv.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.hv.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "same_state", 0);
        paramArrayOfByte = aqoj.C(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void r(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.hb.put(paramString, paramArrayOfObject);
      if (this.app.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_Anaz$a.putLong("getDiscussionMemberSeq" + paramString, ((Long)paramArrayOfObject[0]).longValue());
        this.jdField_a_of_type_Anaz$a.putLong("getDiscussionConfigSeq" + paramString, ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public void s(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.hw.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "accost", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hw.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.hw.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void s(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.ha.put(paramString, paramArrayOfObject);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "addGroupMsgMemberSeq: groupUin=", paramString, "lastSeqId=", paramArrayOfObject[0] });
      }
      if (this.app.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_Anaz$a.putLong("getTroopMemberSeq" + paramString, ((Long)paramArrayOfObject[0]).longValue());
        this.jdField_a_of_type_Anaz$a.putLong("getTroopConfigSeq" + paramString, ((Long)paramArrayOfObject[1]).longValue());
        anod.t(paramString, ((Long)paramArrayOfObject[1]).longValue(), ((Long)paramArrayOfObject[0]).longValue());
      }
    }
  }
  
  public void t(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.hz.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "tribe_bytes_chat_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hz.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.hz.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void t(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_if.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.jdField_if.put(paramString, localArrayList1);
  }
  
  public void u(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.hA.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "movie_ticket_bytes_chat_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hA.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.hA.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void v(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.hQ.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "approval_assistant", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hQ.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.hQ.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public List<Integer> w(String paramString, int paramInt)
  {
    String str = top.u(paramString, paramInt);
    if (!this.ho.containsKey(str))
    {
      paramString = this.pref.getString("getLongMsgIdArray" + top.u(paramString, paramInt), "");
      this.ho.put(str, aM(paramString));
    }
    return (List)this.ho.get(str);
  }
  
  public ConcurrentHashMap<String, Integer> w()
  {
    return this.ia;
  }
  
  public void w(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.hy.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.app.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "dating", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.hy.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.hy.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, aqoj.C(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> x()
  {
    return this.ib;
  }
  
  public void x(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.hB.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.hB.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "circle_group", 0);
        paramArrayOfByte = aqoj.C(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public ConcurrentHashMap<String, Integer> y()
  {
    return this.ie;
  }
  
  public void y(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.hC.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.hC.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "circle_group_av", 0);
        paramArrayOfByte = aqoj.C(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> z()
  {
    return this.jdField_if;
  }
  
  public void z(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.hD.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.hD.put(paramString, paramArrayOfByte);
      if (this.app.getCurrentAccountUin() != null)
      {
        localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "friend_validation", 0);
        paramArrayOfByte = aqoj.C(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public class a
    implements SharedPreferences.Editor
  {
    private boolean cEN;
    private SharedPreferences.Editor editor;
    
    public a() {}
    
    private void dOU()
    {
      this.editor = anaz.a(anaz.this).edit();
      if ((anaz.a(anaz.this) != null) && (anaz.a(anaz.this).size() > 0))
      {
        Iterator localIterator = anaz.a(anaz.this).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = anaz.a(anaz.this).get(str);
          if ((localObject instanceof Long)) {
            this.editor.putLong(str, ((Long)localObject).longValue());
          } else if ((localObject instanceof String)) {
            this.editor.putString(str, (String)localObject);
          } else if ((localObject instanceof Boolean)) {
            this.editor.putBoolean(str, ((Boolean)localObject).booleanValue());
          } else if ((localObject instanceof Integer)) {
            this.editor.putInt(str, ((Integer)localObject).intValue());
          } else if ((localObject instanceof Float)) {
            this.editor.putFloat(str, ((Float)localObject).floatValue());
          }
        }
      }
    }
    
    @TargetApi(9)
    public void apply()
    {
      if (this.cEN)
      {
        this.cEN = false;
        if (Build.VERSION.SDK_INT < 9) {
          try
          {
            dOU();
            if (this.editor.commit())
            {
              anaz.a(anaz.this).clear();
              return;
            }
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d(anaz.TAG, 2, "AsyncEditor commit fail!");
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.w(anaz.TAG, 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
            }
            this.cEN = true;
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.w(anaz.TAG, 2, "commit Exception ! ", localException);
            }
            this.cEN = true;
            return;
          }
        } else {
          this.editor.apply();
        }
      }
    }
    
    public SharedPreferences.Editor clear()
    {
      this.cEN = true;
      anaz.a(anaz.this).clear();
      return this;
    }
    
    public boolean commit()
    {
      boolean bool1;
      if (this.cEN)
      {
        this.cEN = false;
        try
        {
          dOU();
          boolean bool2 = this.editor.commit();
          if (bool2)
          {
            anaz.a(anaz.this).clear();
            return bool2;
          }
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.d(anaz.TAG, 2, "AsyncEditor commit fail!");
          return bool2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.w(anaz.TAG, 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
          }
          this.cEN = true;
          return false;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.w(anaz.TAG, 2, "commit Exception ! ", localException);
          }
          this.cEN = true;
          return false;
        }
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    
    public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      this.cEN = true;
      anaz.a(anaz.this).put(paramString, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      this.cEN = true;
      anaz.a(anaz.this).put(paramString, Float.valueOf(paramFloat));
      return this;
    }
    
    public SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      this.cEN = true;
      anaz.a(anaz.this).put(paramString, Integer.valueOf(paramInt));
      return this;
    }
    
    public SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      this.cEN = true;
      anaz.a(anaz.this).put(paramString, Long.valueOf(paramLong));
      return this;
    }
    
    public SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      this.cEN = true;
      anaz.a(anaz.this).put(paramString1, paramString2);
      return this;
    }
    
    @Deprecated
    public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return this;
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      this.cEN = true;
      anaz.a(anaz.this).remove(paramString);
      return this;
    }
  }
  
  public static class b
  {
    public long aku;
    public boolean cEO = true;
    public String friendUin;
    public boolean isInited = true;
  }
  
  public class c
  {
    public long akv;
    public int delayTime;
    public String frienduin;
    public int istroop;
    public long uniseq;
    
    public c(String paramString, int paramInt, long paramLong1, long paramLong2)
    {
      this.frienduin = paramString;
      this.istroop = paramInt;
      this.uniseq = paramLong1;
      this.akv = paramLong2;
      this.delayTime = MessageHandler.cwL;
    }
  }
  
  public static class d
  {
    public int convCount;
    public int dEU;
    public int dEV;
  }
  
  public static class e
  {
    public List<register_proxy.GroupList> Gr;
    public List<register_proxy.DiscussList> Gs;
    public ConcurrentHashMap<String, ArrayList<String>> il;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anaz
 * JD-Core Version:    0.7.0.1
 */