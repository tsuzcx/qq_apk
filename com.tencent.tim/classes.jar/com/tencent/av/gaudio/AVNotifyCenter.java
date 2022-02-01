package com.tencent.av.gaudio;

import ajdo;
import alkt;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anfb;
import anot;
import aqmj;
import com.tencent.av.VideoConstants;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnSessionInfo;
import imm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import jjc;
import jkf;
import jkm;
import jll;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x920.oidb_cmd0x920.MeetingInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126.MsgBody;

public class AVNotifyCenter
  extends Observable
{
  private static String OA = "BeautyValue";
  private static String OB = "BeautyConfig";
  private static String OC = "BeautyResetGuide";
  private static String Oy = "QAVPreSetting";
  private static String Oz = "BeautyFeature";
  static boolean SV;
  String Ow = null;
  String Ox = null;
  boolean SS = true;
  private boolean ST;
  boolean SU = false;
  boolean SW = false;
  boolean SX = false;
  boolean SY = true;
  final b jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$b = new b("default", 0L);
  PstnSessionInfo jdField_a_of_type_ComTencentTimCallQcallPstnSessionInfo = new PstnSessionInfo();
  jkf jdField_a_of_type_Jkf;
  ConcurrentHashMap<Long, d> aH = new ConcurrentHashMap();
  ConcurrentHashMap<Long, d> aI = new ConcurrentHashMap();
  ConcurrentHashMap<Long, a> aJ = new ConcurrentHashMap();
  ConcurrentHashMap<String, oidb_cmd0x920.MeetingInfo> aK = new ConcurrentHashMap();
  int anl = 0;
  int aqs = 0;
  int aqt = 0;
  int aqu = 0;
  int aqv = 0;
  b jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$b;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = null;
  Runnable bl = new AVNotifyCenter.2(this);
  HashMap<Long, AVPhoneUserInfo> cD = new HashMap();
  HashMap<Long, String> cE = new HashMap();
  HashMap<String, b> cF = new HashMap();
  HashMap<String, e> cG = new HashMap();
  Map cV = new HashMap();
  Map cW = new HashMap();
  public Map<String, String> cX = new HashMap();
  public Map<String, Integer> cY = new ConcurrentHashMap();
  private Map<String, h> cZ = new HashMap();
  private Map<String, i> da = new HashMap();
  private Map<String, i> db = new HashMap();
  ArrayList<f> iq;
  QQAppInterface mApp = null;
  String mSelfUin = null;
  Runnable mUpdateRunnable;
  long ma = 0L;
  long mb = 0L;
  long mc = 0L;
  
  public AVNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.mApp = paramQQAppInterface;
      this.mSelfUin = paramQQAppInterface.getCurrentAccountUin();
      this.jdField_b_of_type_MqqOsMqqHandler = new c(Looper.getMainLooper(), this);
      this.mApp.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
      this.mApp.runOnUiThread(new AVNotifyCenter.1(this));
      aor();
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("AVNotifyCenter", 1, "setSessionType[" + paramInt1 + "], relationId[" + paramString + "], relaitonType[" + paramInt2 + "], sessionType[" + paramInt3 + "], isDouble[" + paramBoolean + "]");
    }
    if (paramInt3 == 0) {
      cy(paramString);
    }
    b localb;
    do
    {
      return;
      localb = a(paramString, true);
    } while (localb == null);
    localb.SZ = paramBoolean;
    localb.mSessionType = paramInt3;
    try
    {
      localb.md = Long.parseLong(paramString);
      localb.aqx = paramInt2;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("AVNotifyCenter", 1, "setSessionType, relationId[" + paramString + "]", localException);
      }
    }
  }
  
  public static void aW(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(Oy, 0);
    paramString1 = OB + paramString1;
    localSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static void ah(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(Oy, 0);
    paramString = OC + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public static int ak(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(Oy, 0).getInt(OA + paramString, -1);
  }
  
  private void aor()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences != null) {
      this.ST = localSharedPreferences.getBoolean("group_video_push_cfg_txt." + this.mApp.getAccount() + ".mutex", true);
    }
  }
  
  public static int ar(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(Oy, 0).getInt(OC + paramString, 0);
  }
  
  public static boolean cA(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(Oy, 0);
    String str = Oz;
    int j = paramString.getInt(str, -1);
    int i = j;
    if (j == -1) {
      if (!imm.isBeautySupported()) {
        break label67;
      }
    }
    label67:
    for (i = 1;; i = 0)
    {
      paramString.edit().putInt(str, i).commit();
      return i >= 1;
    }
  }
  
  public static String dr(String paramString)
  {
    return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(Oy, 0).getString(OB + paramString, "");
  }
  
  public static boolean ul()
  {
    return SV;
  }
  
  public void C(String paramString1, String paramString2, String paramString3)
  {
    if (this.iq == null) {
      this.iq = new ArrayList();
    }
    this.iq.add(new f(paramString1, paramString2, paramString3));
  }
  
  public void Y(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setDoubleVideoMeetingFlag-->isDoubleVideoMeeting = " + paramBoolean);
    }
    paramString = a(paramString, false);
    if (paramString != null) {
      paramString.Td = paramBoolean;
    }
  }
  
  public b a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.equals(paramString, "0")))
        {
          QLog.i("AVNotifyCenter", 1, "getChatSession, illegal session id with zero.");
          localObject1 = localObject2;
          return localObject1;
        }
        if (this.cF.containsKey(paramString))
        {
          localObject1 = (b)this.cF.get(paramString);
          continue;
        }
        if (paramBoolean)
        {
          long l = AudioHelper.hG();
          localObject1 = new b("normal", l);
          this.cF.put(paramString, localObject1);
          a("getChatSession", (b)localObject1);
          QLog.w("AVNotifyCenter", 1, "getChatSession, create sessionId[" + paramString + "], mAvChatDataMap[" + this.cF.size() + "], data[" + localObject1 + "], mActiveChatData[" + this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b + "], seq[" + l + "]");
          continue;
        }
        localObject1 = localObject2;
      }
      finally {}
      if (AudioHelper.aCz())
      {
        QLog.w("AVNotifyCenter", 1, "getChatSession, not exist, sessionId[" + paramString + "]");
        localObject1 = localObject2;
      }
    }
  }
  
  public g a(int paramInt, long paramLong)
  {
    if ((paramInt == 2) && (this.aH != null) && (this.aH.containsKey(Long.valueOf(paramLong))))
    {
      Vector localVector = ((d)this.aH.get(Long.valueOf(paramLong))).i;
      if ((localVector != null) && (localVector.size() > 0)) {
        return (g)localVector.get(0);
      }
    }
    return null;
  }
  
  public h a(long paramLong)
  {
    Object localObject2 = String.valueOf(paramLong) + String.valueOf(2);
    Object localObject1 = String.valueOf(paramLong) + String.valueOf(10);
    localObject2 = (h)this.cZ.get(localObject2);
    h localh = (h)this.cZ.get(localObject1);
    localObject1 = String.valueOf(paramLong) + String.valueOf(12);
    localObject1 = (h)this.cZ.get(localObject1);
    int i = z(paramLong);
    if ((i != 0) && (this.mApp.a().i(1, paramLong))) {
      if (i != 12) {
        break label311;
      }
    }
    for (;;)
    {
      if (i == 2) {}
      for (;;)
      {
        if (i == 10)
        {
          localObject2 = localh;
          if (AudioHelper.aCz()) {
            QLog.w("AVNotifyCenter", 1, "getChoosedRoom, groupid[" + paramLong + "], avtype[" + i + "], VideoRoomInfo[" + localObject2 + "]");
          }
          return localObject2;
          if ((localObject1 == null) || (((h)localObject1).memberNum <= 0)) {
            break label298;
          }
        }
        for (;;)
        {
          if ((localObject2 != null) && (((h)localObject2).memberNum > 0)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localh != null)
            {
              localObject2 = localh;
              if (localh.memberNum > 0) {
                break;
              }
              localObject2 = localObject1;
            }
            break;
          }
          label298:
          localObject1 = null;
        }
        localObject2 = localObject1;
      }
      label311:
      localObject1 = null;
    }
  }
  
  public h a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong) + String.valueOf(paramInt);
    return (h)this.cZ.get(str);
  }
  
  public i a(long paramLong, int paramInt)
  {
    String str = String.valueOf(paramLong);
    i locali = null;
    if (paramInt == 2) {
      locali = (i)this.da.get(str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AVNotifyCenter", 1, "getTipsRoomInfo, relationId[" + paramLong + "], relationType[" + paramInt + "], infos[" + locali + "]");
      }
      return locali;
      if (paramInt == 1) {
        locali = (i)this.db.get(str);
      }
    }
  }
  
  public PstnSessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentTimCallQcallPstnSessionInfo;
  }
  
  public Vector<g> a(int paramInt, long paramLong)
  {
    if ((paramInt == 2) && (this.aH != null) && (this.aH.containsKey(Long.valueOf(paramLong))))
    {
      Vector localVector = ((d)this.aH.get(Long.valueOf(paramLong))).i;
      if ((localVector != null) && (localVector.size() > 0)) {
        return localVector;
      }
    }
    return null;
  }
  
  public Vector<g> a(long paramLong)
  {
    if ((this.aI != null) && (this.aI.containsKey(Long.valueOf(paramLong))))
    {
      Object localObject = (d)this.aI.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((d)localObject).i;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramInt1, paramInt2, String.valueOf(paramLong), paramInt3, false);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    int j = 0;
    int i = 0;
    QLog.w("AVNotifyCenter", 1, "setMultiRoomMember[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], memberList[" + Arrays.toString(paramArrayOfLong) + "], roomUserNum[" + paramLong2 + "]");
    if (paramInt2 == 2)
    {
      if (this.aH.containsKey(Long.valueOf(paramLong1))) {
        this.aH.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null)) {}
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = new Vector();
        paramInt2 = paramArrayOfLong.length;
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          localObject2 = new g();
          ((g)localObject2).id = paramArrayOfLong[paramInt1];
          ((Vector)localObject1).add(localObject2);
          paramInt1 += 1;
        }
        paramArrayOfLong = new d();
        paramArrayOfLong.me = paramLong2;
        paramArrayOfLong.i = ((Vector)localObject1);
        this.aH.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt2 != 1);
      if (this.aI.containsKey(Long.valueOf(paramLong1))) {
        this.aI.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    Object localObject1 = new d();
    ((d)localObject1).me = paramLong2;
    ((d)localObject1).i = null;
    if (paramArrayOfLong != null)
    {
      localObject2 = new Vector();
      paramInt1 = j;
      while (paramInt1 < paramArrayOfLong.length)
      {
        g localg = new g();
        localg.id = paramArrayOfLong[paramInt1];
        ((Vector)localObject2).add(localg);
        paramInt1 += 1;
      }
      ((d)localObject1).i = ((Vector)localObject2);
    }
    this.aI.put(Long.valueOf(paramLong1), localObject1);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, -1, paramInt5, paramInt6);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (((TroopManager)this.mApp.getManager(52)).kB(String.valueOf(paramLong)))
    {
      cl(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "setVideoRoomInfo, but group is exited, groupid: " + paramLong);
      }
    }
    h localh1;
    h localh2;
    do
    {
      return;
      localh1 = new h();
      localh1.ll = paramLong;
      localh1.aqy = paramInt2;
      localh1.aqA = paramInt6;
      localh1.ang = paramInt3;
      localh1.gameId = paramInt4;
      localh1.aqz = paramInt5;
      localh1.memberNum = paramInt7;
      localh1.time = System.currentTimeMillis();
      String str = String.valueOf(paramLong) + String.valueOf(paramInt2);
      localh2 = (h)this.cZ.get(str);
      this.cZ.put(str, localh1);
    } while (!AudioHelper.aCz());
    QLog.w("AVNotifyCenter", 1, "setVideoRoomInfo[" + paramInt1 + "], \nOld[" + localh2 + "], \nNew[" + localh1 + "]");
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramInt, String.valueOf(paramLong), paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, long paramLong, long[] paramArrayOfLong)
  {
    int j = 0;
    if (paramInt == 2) {}
    Vector localVector;
    int i;
    for (ConcurrentHashMap localConcurrentHashMap = this.aH;; localConcurrentHashMap = this.aI)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AVNotifyCenter", 1, "setMultiRoomMember, relationType[" + paramInt + "], relationId[" + paramLong + "], roomInfos[" + localConcurrentHashMap.size() + "], memberList[" + paramArrayOfLong.length + "]");
      }
      if (localConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        localConcurrentHashMap.remove(Long.valueOf(paramLong));
      }
      localVector = new Vector();
      int k = paramArrayOfLong.length;
      i = 0;
      paramInt = j;
      while (paramInt < k)
      {
        g localg = new g();
        localg.id = paramArrayOfLong[paramInt];
        localVector.add(localg);
        i += 1;
        paramInt += 1;
      }
      if (paramInt != 1) {
        return;
      }
    }
    paramArrayOfLong = new d();
    paramArrayOfLong.me = i;
    paramArrayOfLong.i = localVector;
    localConcurrentHashMap.put(Long.valueOf(paramLong), paramArrayOfLong);
  }
  
  public void a(int paramInt, long paramLong1, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("setMultiRoomMember, relationId[").append(paramLong1).append("], relationType[").append(paramInt).append("], states[").append(paramArrayOfInt).append("], roomUserNum[").append(paramLong2).append("], memberList[");
      if (paramArrayOfLong != null)
      {
        bool = true;
        QLog.w("AVNotifyCenter", 1, bool + "]");
      }
    }
    else
    {
      if (paramInt != 2) {
        break label332;
      }
      if (this.aH.containsKey(Long.valueOf(paramLong1))) {
        this.aH.remove(Long.valueOf(paramLong1));
      }
      if ((paramLong2 != 0L) && (paramArrayOfLong != null) && (paramArrayOfInt != null) && (paramArrayOfLong.length == paramArrayOfInt.length)) {
        break label158;
      }
    }
    label158:
    int i;
    Object localObject2;
    label332:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject1 = new Vector();
        i = paramArrayOfLong.length;
        localObject2 = new ArrayList();
        paramInt = 0;
        if (paramInt < i)
        {
          g localg = new g();
          localg.id = paramArrayOfLong[paramInt];
          if (paramArrayOfInt[paramInt] == 1) {}
          for (bool = true;; bool = false)
          {
            localg.Te = bool;
            if ((localg.Te) && (!this.cD.containsKey(Long.valueOf(localg.id)))) {
              ((ArrayList)localObject2).add(Long.valueOf(localg.id));
            }
            ((Vector)localObject1).add(localg);
            paramInt += 1;
            break;
          }
        }
        bz((ArrayList)localObject2);
        paramArrayOfLong = new d();
        paramArrayOfLong.me = paramLong2;
        paramArrayOfLong.i = ((Vector)localObject1);
        this.aH.put(Long.valueOf(paramLong1), paramArrayOfLong);
        return;
      } while (paramInt != 1);
      if (this.aI.containsKey(Long.valueOf(paramLong1))) {
        this.aI.remove(Long.valueOf(paramLong1));
      }
    } while (paramLong2 == 0L);
    Object localObject1 = new Vector();
    if (paramArrayOfLong != null)
    {
      i = paramArrayOfLong.length;
      paramInt = 0;
      if (paramInt < i)
      {
        localObject2 = new g();
        ((g)localObject2).id = paramArrayOfLong[paramInt];
        if (paramArrayOfInt[paramInt] == 1) {}
        for (bool = true;; bool = false)
        {
          ((g)localObject2).Te = bool;
          ((Vector)localObject1).add(localObject2);
          paramInt += 1;
          break;
        }
      }
    }
    paramArrayOfLong = new d();
    paramArrayOfLong.me = paramLong2;
    paramArrayOfLong.i = ((Vector)localObject1);
    this.aI.put(Long.valueOf(paramLong1), paramArrayOfLong);
  }
  
  public void a(int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (AudioHelper.aCz()) {
      QLog.w("AVNotifyCenter", 1, "setChating, relationType[" + paramInt + "], relationId[" + paramLong + "], isChating[" + paramBoolean + "], mActiveChatData[" + this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b + "]");
    }
    Object localObject = String.valueOf(paramLong);
    if (paramBoolean)
    {
      localObject = a((String)localObject, true);
      ((b)localObject).SZ = false;
      ((b)localObject).md = paramLong.longValue();
      ((b)localObject).aqx = paramInt;
      if (((b)localObject).aqx != 1) {
        break label213;
      }
      ((b)localObject).mUinType = 1;
    }
    for (;;)
    {
      ((b)localObject).Tc = paramBoolean;
      if ((((b)localObject).Tc) && (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b != localObject)) {
        a("setChating.1", (b)localObject);
      }
      if (AudioHelper.aCz()) {
        QLog.w("AVNotifyCenter", 1, "setChating, end, data[" + localObject + "], mActiveChatData[" + this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b + "]");
      }
      return;
      label213:
      if (((b)localObject).aqx == 2) {
        ((b)localObject).mUinType = 3000;
      } else if (((b)localObject).aqx == 3) {
        ((b)localObject).mUinType = 0;
      }
    }
  }
  
  public void a(String paramString, b paramb)
  {
    b localb = this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b;
    Object localObject;
    if (this.cF.size() == 1)
    {
      paramb = null;
      localObject = this.cF.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramb = (String)((Iterator)localObject).next();
        paramb = (b)this.cF.get(paramb);
      }
      if (paramb != null)
      {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = paramb;
        localObject = paramb;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVNotifyCenter", 2, "checkAndUpdateActive, from[" + paramString + "], data[" + localObject + "], last[" + localb + "], active[" + this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b + "]");
      }
      return;
      this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$b;
      break;
      if (this.cF.size() == 0)
      {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$b;
        localObject = paramb;
      }
      else if (paramb == null)
      {
        localObject = this.cF.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramb = (String)((Iterator)localObject).next();
          paramb = (b)this.cF.get(paramb);
        }
        if (paramb != null)
        {
          this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = paramb;
          localObject = paramb;
        }
        else
        {
          this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$b;
          localObject = paramb;
        }
      }
      else if ((paramb.Tc) && (!this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.Tc))
      {
        this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = paramb;
        localObject = paramb;
      }
      else
      {
        localObject = paramb;
        if (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.md == 0L)
        {
          localObject = paramb;
          if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mPeerUin))
          {
            this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = paramb;
            localObject = paramb;
          }
        }
      }
    }
  }
  
  public void a(submsgtype0x126.MsgBody paramMsgBody)
  {
    Object localObject2 = null;
    if (paramMsgBody == null) {
      return;
    }
    int i = paramMsgBody.uint32_msg_type.get();
    if (paramMsgBody.str_msg_info.has()) {}
    for (paramMsgBody = paramMsgBody.str_msg_info.get().toByteArray();; paramMsgBody = null)
    {
      Object localObject1 = "";
      boolean bool;
      if ((paramMsgBody != null) && (paramMsgBody.length > 0))
      {
        localObject1 = localObject2;
        if (this.mApp != null)
        {
          localObject1 = localObject2;
          if (this.mApp.gi != null) {
            localObject1 = (QQServiceForAV)this.mApp.gi.get();
          }
        }
        if (localObject1 != null)
        {
          bool = ((QQServiceForAV)localObject1).a("avChatRoom", i, paramMsgBody);
          if (!bool)
          {
            localObject1 = new Intent("tencent.video.q2v.avReceivePushMsg");
            ((Intent)localObject1).putExtra("key", "avChatRoom");
            ((Intent)localObject1).putExtra("msg_type", i);
            ((Intent)localObject1).putExtra("msg_content", paramMsgBody);
            this.mApp.getApp().sendBroadcast((Intent)localObject1);
            paramMsgBody = "useBroadcast";
          }
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label239;
        }
        QLog.i("AVNotifyCenter", 2, "processAVChatRoomMsgPush ret[" + bool + "], tag[" + paramMsgBody + "]");
        return;
        paramMsgBody = "useQQServiceForAV";
        continue;
        bool = false;
        break;
        bool = false;
        paramMsgBody = (submsgtype0x126.MsgBody)localObject1;
      }
      label239:
      break;
    }
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramContext == null) {
      return false;
    }
    int j = jll.cL(paramInt);
    long l = Long.parseLong(paramString);
    int i = -1;
    if (i(j, l)) {
      i = 0;
    }
    paramString = a(l, 10);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = i;
      if (paramString.memberNum > 0) {
        paramInt = 0;
      }
    }
    if (paramInt < 0) {}
    i = paramInt;
    if (paramInt < 0)
    {
      h localh = a(l, 2);
      paramString = localh;
      if (localh == null) {
        paramString = a(l, 12);
      }
      i = paramInt;
      if (paramString != null)
      {
        i = paramInt;
        if (paramString.memberNum > 0) {
          i = 2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVNotifyCenter", 2, "checkBlockTroopAVChat, relationType[" + j + "], relationId[" + l + "], ret[" + i + "]");
    }
    boolean bool;
    if (i > 0)
    {
      bool = true;
      if (bool)
      {
        if (i != 1) {
          break label284;
        }
        paramString = this.mApp;
        if (!paramBoolean) {
          break label279;
        }
        paramInt = 4;
        label213:
        anot.a(paramString, "CliOper", "", "", "0X800AB81", "0X800AB81", paramInt, 0, "", "", "", "");
        paramInt = 2131698109;
      }
    }
    for (;;)
    {
      QQToast.a(paramContext, paramInt, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return bool;
      bool = false;
      break;
      label279:
      paramInt = 3;
      break label213;
      label284:
      if (i == 2)
      {
        paramString = this.mApp;
        if (paramBoolean) {}
        for (paramInt = 4;; paramInt = 3)
        {
          anot.a(paramString, "CliOper", "", "", "0X800AB83", "0X800AB83", paramInt, 0, "", "", "", "");
          paramInt = 2131698111;
          break;
        }
      }
      paramInt = 2131698109;
    }
  }
  
  public String ai(long paramLong)
  {
    if (this.cD.containsKey(Long.valueOf(paramLong)))
    {
      String str1 = ((AVPhoneUserInfo)this.cD.get(Long.valueOf(paramLong))).telInfo.mobile;
      String str2 = dd(str1);
      if (str2 != null) {
        return str2;
      }
      return jkm.v(str1, 4);
    }
    return null;
  }
  
  public void ai(String paramString, int paramInt)
  {
    this.cY.put(paramString, Integer.valueOf(paramInt));
  }
  
  public String aj(long paramLong)
  {
    synchronized (this.cG)
    {
      Iterator localIterator = this.cG.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((e)this.cG.get(str)).mRoomId == paramLong)
        {
          QLog.d("AVNotifyCenter", 1, "getOtherTerminalPeerUin true, roomId=" + paramLong + ", key=" + str);
          return str;
        }
      }
      return "";
    }
  }
  
  public void aoq()
  {
    if (this.jdField_a_of_type_Jkf != null)
    {
      this.jdField_a_of_type_Jkf.aoq();
      this.jdField_a_of_type_Jkf = null;
    }
  }
  
  void aos()
  {
    QLog.d("AVNotifyCenter", 1, "clearMultiRoomInfos, AvChatData[" + this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b + "]");
    this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.aqx = 0;
    this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.md = 0L;
    this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.Tc = false;
    this.aH.clear();
    this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter$b;
  }
  
  public int ap(String paramString)
  {
    int i = 0;
    paramString = a(paramString, false);
    if (paramString != null) {
      i = paramString.mSessionType;
    }
    return i;
  }
  
  public int aq(String paramString)
  {
    synchronized (this.cG)
    {
      if (this.cG.containsKey(paramString))
      {
        e locale = (e)this.cG.get(paramString);
        QLog.d("AVNotifyCenter", 1, "getOtherTermianlAvChatingType roomInfo.mSessionType=" + locale.mSessionType + ", peerUin=" + paramString);
        int i = locale.mSessionType;
        return i;
      }
      return 0;
    }
  }
  
  public int as(String paramString)
  {
    paramString = (Integer)this.cY.get(paramString);
    if (paramString == null) {
      return 2;
    }
    return paramString.intValue();
  }
  
  @TargetApi(11)
  public boolean as(long paramLong)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
    String str = "ADD_FRIEND_DIALOG" + this.mApp.getCurrentAccountUin();
    Object localObject = localHashSet;
    if (localSharedPreferences.contains(str)) {
      localObject = localSharedPreferences.getStringSet(str, localHashSet);
    }
    if (((Set)localObject).size() >= 3) {
      return false;
    }
    if (((Set)localObject).contains(String.valueOf(paramLong))) {
      return false;
    }
    return this.aJ.containsKey(Long.valueOf(paramLong));
  }
  
  public boolean at(long paramLong)
  {
    Boolean localBoolean = (Boolean)this.cW.get(Long.valueOf(paramLong));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public boolean au(long paramLong)
  {
    boolean bool = true;
    int i = this.mApp.a().z(paramLong);
    if (i == 2) {}
    while (bool)
    {
      h localh = this.mApp.a().a(paramLong, 10);
      if ((localh == null) || (localh.memberNum <= 0)) {
        break;
      }
      return false;
      if (i == 0)
      {
        localh = this.mApp.a().a(paramLong, 2);
        if ((localh != null) && (localh.memberNum > 0)) {}
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public String ay()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mPeerUin;
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    b localb = a(paramString1, false);
    if (localb != null)
    {
      localb.SZ = true;
      localb.mUinType = paramInt;
      localb.mPeerUin = paramString1;
      localb.OD = paramString2;
      localb.Ta = paramBoolean;
      localb.aqx = 0;
      localb.md = jjc.A(paramString1);
    }
    QLog.w("AVNotifyCenter", 1, "setChating, uinType[" + paramInt + "], peerUin[" + paramString1 + "], extraUin[" + paramString2 + "], isReceiver[" + paramBoolean + "], AvChatData[" + localb + "], mActiveChatData[" + this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b + "]");
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = a(paramString, false);
    QLog.w("AVNotifyCenter", 1, "setWaittingState, sessionId[" + paramString + "], relationType[" + paramInt + "], IsWaitting[" + paramBoolean1 + "], isReceiver[" + paramBoolean2 + "], AvChatData[" + localb + "]");
    if (localb != null)
    {
      localb.Tb = paramBoolean1;
      if (!paramBoolean1) {
        break label179;
      }
      if (!paramBoolean2) {
        break label170;
      }
      localb.Tc = false;
    }
    for (;;)
    {
      if ((localb.Tc) && (localb != this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b)) {
        a("setWaittingState", localb);
      }
      QLog.w("AVNotifyCenter", 1, "setWaittingState, end, AvChatData[" + localb + "]");
      return;
      label170:
      localb.Tc = true;
      continue;
      label179:
      localb.Tc = true;
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = null;
    i locali = null;
    Object localObject2 = null;
    if (paramInt1 == 2)
    {
      localObject1 = localObject2;
      if (this.da.containsKey(Long.valueOf(paramLong))) {
        localObject1 = (i)this.da.remove(Long.valueOf(paramLong));
      }
      locali = new i();
      locali.ll = paramLong;
      locali.isOffLine = paramBoolean;
      this.da.put(String.valueOf(paramLong), locali);
      localObject2 = localObject1;
      localObject1 = locali;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w("AVNotifyCenter", 1, "setTipsRoomInfo, relationId[" + paramLong + "], relationType[" + paramInt1 + "], old[" + localObject2 + "], new[" + localObject1 + "]");
        QLog.d("AVNotifyCenter", 2, "setTipsRoomInfo relationId:" + paramLong + "relationType:" + paramInt1);
      }
      return;
      if (paramInt1 == 1)
      {
        localObject1 = locali;
        if (this.db.containsKey(Long.valueOf(paramLong))) {
          localObject1 = (i)this.db.remove(Long.valueOf(paramLong));
        }
        locali = new i();
        locali.ll = paramLong;
        locali.isOffLine = paramBoolean;
        locali.aqB = paramInt2;
        this.db.put(String.valueOf(paramLong), locali);
        localObject2 = localObject1;
        localObject1 = locali;
      }
      else
      {
        localObject2 = null;
      }
    }
  }
  
  public boolean b(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 2) {
      bool1 = i(paramInt1, paramLong);
    }
    b localb;
    do
    {
      do
      {
        do
        {
          return bool1;
          paramInt1 = z(paramLong);
          bool1 = bool2;
        } while (paramInt1 < 0);
        localb = a(String.valueOf(paramLong), false);
        bool1 = bool2;
      } while (localb == null);
      bool1 = bool2;
    } while (paramInt2 != paramInt1);
    return localb.Tc;
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "do qua report error : selfuin = " + paramString1 + " , peeruin =" + paramString2);
      }
      return false;
    }
    String str1 = paramString2;
    Object localObject;
    try
    {
      if (paramString2.startsWith("+")) {
        str1 = paramString2.substring(1);
      }
      if ((this.cF.containsKey(str1)) && (!TextUtils.isEmpty(((b)this.cF.get(str1)).mPeerUin)) && (((b)this.cF.get(str1)).mPeerUin.equals(str1)) && (um()))
      {
        if (!QLog.isColorLevel()) {
          break label478;
        }
        QLog.i("AVNotifyCenter", 2, "Do not report qua, because this chatting is active!");
        break label478;
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AVNotifyCenter", 2, "start do qua report : peer uin = " + str1 + " , timestamp = " + l);
      }
      localObject = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.Ma, 4);
      paramString2 = ((SharedPreferences)localObject).getAll();
      localObject = ((SharedPreferences)localObject).edit();
      if (paramString2.size() <= 0) {
        break label420;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVNotifyCenter", 2, "Qua report map contains report buffer, move to exception map : size = " + paramString2.size());
      }
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.Mb, 4).edit();
      Iterator localIterator = paramString2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localEditor.putString(str2, (String)paramString2.get(str2));
      }
      localEditor.commit();
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "do qua report error : " + paramString1);
      }
      return false;
    }
    ((SharedPreferences.Editor)localObject).clear().commit();
    label420:
    paramString2 = new QuaReportInfo();
    paramString2.uintype = paramInt2;
    paramString2.busytype = paramInt1;
    paramString2.peerUin = str1;
    paramString2.selfUin = paramString1;
    ((SharedPreferences.Editor)localObject).putString(String.valueOf(System.currentTimeMillis()), paramString2.toString());
    ((SharedPreferences.Editor)localObject).commit();
    return true;
    label478:
    return false;
  }
  
  public void bA(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
        long l = localAVPhoneUserInfo.account;
        if (!this.cD.containsKey(Long.valueOf(l))) {
          this.cD.put(Long.valueOf(l), localAVPhoneUserInfo);
        }
      }
    }
  }
  
  public void bC(int paramInt1, int paramInt2)
  {
    this.aqs = paramInt1;
    this.aqt = paramInt2;
    if ((this.aqs == 0) && (this.iq != null))
    {
      this.iq.clear();
      this.iq = null;
    }
  }
  
  public long bF()
  {
    return this.mb;
  }
  
  public long bG()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.md;
  }
  
  public long bH()
  {
    return this.ma;
  }
  
  public long bI()
  {
    return this.mc;
  }
  
  void bz(ArrayList<Long> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), anfb.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    try
    {
      this.mApp.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AVNotifyCenter", 2, "getOpenIdFromTinyId --> StartServlet Error");
    }
  }
  
  public void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    aqmj.n(paramQQAppInterface.getApplication(), paramInt, paramQQAppInterface.getAccount());
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putString("group_video_push_cfg_txt." + paramQQAppInterface.getAccount(), paramString).commit();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("mav");
      if (paramString != null)
      {
        JSONObject localJSONObject = paramString.getJSONObject("relationType1");
        if (localJSONObject != null) {
          if (localJSONObject.getInt("mutex") != 0) {
            break label323;
          }
        }
      }
      for (;;)
      {
        this.ST = bool;
        localEditor.putBoolean("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".mutex", this.ST);
        paramString = paramString.getJSONObject("noiseCtrl");
        if (paramString != null)
        {
          paramInt = paramString.getInt("level");
          int i = paramString.getInt("sendDura");
          int j = paramString.getInt("validDura");
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".level", paramInt);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".sendDura", i);
          localEditor.putInt("group_video_push_cfg_txt." + paramQQAppInterface.getAccount() + ".validDura", j);
        }
        localEditor.commit();
        return;
        label323:
        bool = true;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void cj(long paramLong)
  {
    this.ma = paramLong;
  }
  
  public void ck(long paramLong)
  {
    this.mc = paramLong;
  }
  
  public void cl(long paramLong)
  {
    String str1 = String.valueOf(paramLong) + 10;
    String str2 = String.valueOf(paramLong) + 2;
    if (this.cZ != null)
    {
      this.cZ.remove(str1);
      this.cZ.remove(str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, String.format("removeVideoRoomInfo, groupid: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public boolean cw(String paramString)
  {
    paramString = (String)this.cX.get(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.split(";")[0].equals("1")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean cx(String paramString)
  {
    boolean bool2 = false;
    b localb = a(paramString, false);
    boolean bool1;
    if (localb != null) {
      bool1 = localb.Td;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> isDoubleVideoMeeting = " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> can not get data from uin --> peerUin = " + paramString);
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public boolean cy(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 190	com/tencent/av/gaudio/AVNotifyCenter:cF	Ljava/util/HashMap;
    //   8: aload_1
    //   9: invokevirtual 461	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   12: istore 4
    //   14: invokestatic 505	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   17: ifeq +63 -> 80
    //   20: ldc_w 268
    //   23: iconst_1
    //   24: new 270	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 1189
    //   34: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 1191
    //   44: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload 4
    //   49: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 486
    //   55: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 190	com/tencent/av/gaudio/AVNotifyCenter:cF	Ljava/util/HashMap;
    //   62: invokevirtual 490	java/util/HashMap:size	()I
    //   65: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc_w 293
    //   71: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 300	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iload 4
    //   82: ifne +9 -> 91
    //   85: iconst_0
    //   86: istore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: iload_2
    //   90: ireturn
    //   91: aload_0
    //   92: getfield 190	com/tencent/av/gaudio/AVNotifyCenter:cF	Ljava/util/HashMap;
    //   95: aload_1
    //   96: invokevirtual 1192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: aload_0
    //   101: getfield 199	com/tencent/av/gaudio/AVNotifyCenter:jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b	Lcom/tencent/av/gaudio/AVNotifyCenter$b;
    //   104: astore 5
    //   106: aload_0
    //   107: ldc_w 1194
    //   110: aconst_null
    //   111: invokevirtual 482	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;Lcom/tencent/av/gaudio/AVNotifyCenter$b;)V
    //   114: aload_0
    //   115: getfield 190	com/tencent/av/gaudio/AVNotifyCenter:cF	Ljava/util/HashMap;
    //   118: invokevirtual 1196	java/util/HashMap:isEmpty	()Z
    //   121: ifeq +33 -> 154
    //   124: aload_0
    //   125: lconst_0
    //   126: putfield 218	com/tencent/av/gaudio/AVNotifyCenter:mc	J
    //   129: aload_0
    //   130: getfield 1198	com/tencent/av/gaudio/AVNotifyCenter:mUpdateRunnable	Ljava/lang/Runnable;
    //   133: ifnull +21 -> 154
    //   136: aload_0
    //   137: getfield 156	com/tencent/av/gaudio/AVNotifyCenter:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   140: ifnull +14 -> 154
    //   143: aload_0
    //   144: getfield 156	com/tencent/av/gaudio/AVNotifyCenter:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   147: aload_0
    //   148: getfield 1198	com/tencent/av/gaudio/AVNotifyCenter:mUpdateRunnable	Ljava/lang/Runnable;
    //   151: invokevirtual 1203	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   154: iload_3
    //   155: istore_2
    //   156: invokestatic 505	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   159: ifeq -72 -> 87
    //   162: ldc_w 268
    //   165: iconst_1
    //   166: new 270	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 1205
    //   176: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 1191
    //   186: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 4
    //   191: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: ldc_w 486
    //   197: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 190	com/tencent/av/gaudio/AVNotifyCenter:cF	Ljava/util/HashMap;
    //   204: invokevirtual 490	java/util/HashMap:size	()I
    //   207: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc_w 1207
    //   213: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 5
    //   218: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: ldc_w 497
    //   224: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: getfield 199	com/tencent/av/gaudio/AVNotifyCenter:jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b	Lcom/tencent/av/gaudio/AVNotifyCenter$b;
    //   231: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: ldc_w 293
    //   237: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 300	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: iload_3
    //   247: istore_2
    //   248: goto -161 -> 87
    //   251: astore_1
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_1
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	AVNotifyCenter
    //   0	256	1	paramString	String
    //   86	162	2	bool1	boolean
    //   1	246	3	bool2	boolean
    //   12	178	4	bool3	boolean
    //   104	113	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   4	80	251	finally
    //   91	154	251	finally
    //   156	246	251	finally
  }
  
  public boolean cz(String paramString)
  {
    synchronized (this.cG)
    {
      if (this.cG.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "isOtherTerminalAvChatting contains " + paramString);
        return true;
      }
      return false;
    }
  }
  
  public long d(int paramInt, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == 2)
    {
      localObject1 = localObject2;
      if (this.aH.containsKey(Long.valueOf(paramLong))) {
        localObject1 = (d)this.aH.get(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AVNotifyCenter", 1, "getMultiRoomMemberNum, relationId[" + paramLong + "], " + localObject1);
      }
      if (localObject1 == null) {
        break;
      }
      return ((d)localObject1).me;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.aI.containsKey(Long.valueOf(paramLong))) {
          localObject1 = (d)this.aI.get(Long.valueOf(paramLong));
        }
      }
    }
    return 0L;
  }
  
  public void d(String paramString, long paramLong, int paramInt)
  {
    synchronized (this.cG)
    {
      QLog.d("AVNotifyCenter", 1, "addOtherTerminalAvChating peerUin = " + paramString + ",roomid = " + paramLong + ",sessionType = " + paramInt);
      this.cG.put(paramString, new e(paramLong, paramInt));
      return;
    }
  }
  
  String dd(String paramString)
  {
    ajdo localajdo = (ajdo)this.mApp.getManager(11);
    if (localajdo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localajdo.b(paramString);
    if ((paramString == null) || (paramString.name == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
      }
      return null;
    }
    return paramString.name;
  }
  
  public String dp(String paramString)
  {
    if ((this.iq != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.iq.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (paramString.equals(localf.uin)) {
          return localf.name;
        }
      }
    }
    return "";
  }
  
  public String dq(String paramString)
  {
    if ((this.iq != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.iq.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (paramString.equals(localf.uin)) {
          return localf.headUrl;
        }
      }
    }
    return "";
  }
  
  @TargetApi(11)
  public void e(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    String str1;
    SharedPreferences localSharedPreferences;
    String str2;
    do
    {
      return;
      str1 = String.valueOf(paramLong);
      HashSet localHashSet = new HashSet();
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
      str2 = "ADD_FRIEND_DIALOG" + this.mApp.getCurrentAccountUin();
      localObject = localHashSet;
      if (localSharedPreferences.contains(str2)) {
        localObject = localSharedPreferences.getStringSet(str2, localHashSet);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "setAddFriendNotifyMaps-->uin=" + paramLong + " bNotify=" + paramBoolean + " srcId=" + paramInt + " size=" + ((Set)localObject).size() + " info=" + localObject.toString());
      }
    } while ((((Set)localObject).size() >= 3) || (((Set)localObject).contains(str1)));
    if (this.aJ.containsKey(Long.valueOf(paramLong))) {
      this.aJ.remove(Long.valueOf(paramLong));
    }
    if (!paramBoolean)
    {
      ((Set)localObject).add(str1);
      localSharedPreferences.edit().putStringSet(str2, (Set)localObject).commit();
      return;
    }
    Object localObject = new a();
    ((a)localObject).aqw = paramInt;
    ((a)localObject).uin = paramLong;
    this.aJ.put(Long.valueOf(paramLong), localObject);
  }
  
  public boolean e(long paramLong, String paramString)
  {
    boolean bool = false;
    b localb = a(paramString, false);
    if (AudioHelper.aCz()) {
      QLog.w("AVNotifyCenter", 1, "isChating, discussId[" + paramString + "], AvChatData[" + localb + "], seq[" + paramLong + "]");
    }
    if (localb != null) {
      bool = localb.Tc;
    }
    return bool;
  }
  
  public void f(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, 0, paramString, paramInt2, true);
  }
  
  public String gX()
  {
    return this.Ow;
  }
  
  public String gY()
  {
    return this.Ox;
  }
  
  public String gZ()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.OD;
  }
  
  public int getSessionType()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mSessionType;
  }
  
  public void h(boolean paramBoolean, String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(408), Boolean.valueOf(paramBoolean), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String ha()
  {
    return jll.formatTime(this.mc);
  }
  
  public boolean i(int paramInt, long paramLong)
  {
    return e(AudioHelper.hG(), String.valueOf(paramLong));
  }
  
  public void iv(boolean paramBoolean)
  {
    SV = paramBoolean;
  }
  
  public void iw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "startOrStopGAudioTimer start: " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.Tc) {
        this.mc = 0L;
      }
      if (this.jdField_b_of_type_MqqOsMqqHandler != null)
      {
        if (this.mUpdateRunnable != null) {
          break label94;
        }
        this.mUpdateRunnable = new UpdateChattingTime(this);
        this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.mUpdateRunnable, 2000L);
      }
    }
    label94:
    while ((um()) || (this.mUpdateRunnable == null) || (this.jdField_b_of_type_MqqOsMqqHandler == null)) {
      for (;;)
      {
        return;
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.mUpdateRunnable);
      }
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.mUpdateRunnable);
    this.mUpdateRunnable = null;
  }
  
  public void ix(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) || (this.SS != paramBoolean)) {
      QLog.w("AVNotifyCenter", 1, "setNetworkState, mNetworkDown[" + this.SS + "->" + paramBoolean + "]");
    }
    if ((this.SS != paramBoolean) && (!paramBoolean) && (this.jdField_b_of_type_MqqOsMqqHandler != null))
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.bl);
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.bl, 5000L);
    }
    if ((paramBoolean) && (this.jdField_b_of_type_MqqOsMqqHandler != null)) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.bl);
    }
    this.SS = paramBoolean;
  }
  
  public void iy(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "setNotifyUpdateTime-->bNotify" + paramBoolean);
    }
    this.SY = paramBoolean;
  }
  
  public void iz(boolean paramBoolean)
  {
    this.SW = paramBoolean;
  }
  
  public void j(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.mApp == null) {
      return;
    }
    Object localObject2 = "onSelfLeaveRoom, relationId[" + paramLong + "], relationType[" + paramInt1 + "], avtype[" + paramInt2;
    Object localObject1;
    int i;
    label67:
    String str1;
    long l;
    String str2;
    Vector localVector;
    if (paramInt1 == 2)
    {
      localObject1 = this.aH;
      i = 3000;
      str1 = this.mApp.getCurrentAccountUin();
      l = Long.valueOf(str1).longValue();
      if (!((ConcurrentHashMap)localObject1).containsKey(Long.valueOf(paramLong))) {
        break label448;
      }
      str2 = (String)localObject2 + "], containsKey[true";
      localObject2 = (d)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
      str2 = str2 + "], last[" + localObject2;
      localVector = ((d)localObject2).i;
      ((d)localObject2).me -= 1L;
      if (((d)localObject2).me != 0L) {
        break label357;
      }
      ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong));
      localObject1 = Long.toString(paramLong);
      if (paramInt1 != 2) {
        break label317;
      }
      VideoMsgTools.a(this.mApp, i, 14, false, (String)localObject1, str1, false, null, false, new Object[] { new Integer(paramInt2) });
      label248:
      localObject1 = str2 + "], delete[true";
    }
    for (;;)
    {
      QLog.w("AVNotifyCenter", 1, (String)localObject1 + "]");
      return;
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = this.aI;
      i = 1;
      break label67;
      label317:
      VideoMsgTools.a(this.mApp, i, 14, false, (String)localObject1, str1, false, null, false, paramInt2, new Object[] { new Integer(paramInt2) });
      break label248;
      label357:
      if ((localVector != null) && (localVector.size() > 0))
      {
        paramInt2 = localVector.size();
        paramInt1 = 0;
      }
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          if (l == ((g)localVector.elementAt(paramInt1)).id) {
            localVector.remove(paramInt1);
          }
        }
        else
        {
          localObject1 = str2 + "], cur[" + localObject2;
          break;
        }
        paramInt1 += 1;
      }
      label448:
      localObject1 = localObject2;
    }
  }
  
  public boolean j(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "hasMultiVideo --> RelationType = " + paramInt + " ,RelationId = " + paramLong);
    }
    if (paramInt == 2) {
      if (this.aH.size() != 0) {}
    }
    do
    {
      do
      {
        do
        {
          return false;
        } while (!this.aH.containsKey(Long.valueOf(paramLong)));
        return true;
        if (paramInt != 1) {
          break;
        }
      } while ((this.aI.size() == 0) || (!this.aI.containsKey(Long.valueOf(paramLong))));
      return true;
    } while (!QLog.isColorLevel());
    QLog.e("AVNotifyCenter", 2, "hasMultiVideo --> RelationType is Wrong");
    return false;
  }
  
  public void ji(String paramString)
  {
    this.Ow = paramString;
  }
  
  public void jj(String paramString)
  {
    this.Ox = paramString;
  }
  
  public void jk(String paramString)
  {
    QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating peerUin = " + paramString);
    synchronized (this.cG)
    {
      if (this.cG.containsKey(paramString))
      {
        QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating remove true");
        this.cG.remove(paramString);
      }
      return;
    }
  }
  
  public void jl(String paramString)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(800), paramString });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void k(int paramInt1, long paramLong, int paramInt2)
  {
    long l = AudioHelper.hG();
    if (AudioHelper.aCz()) {
      QLog.w("AVNotifyCenter", 1, "setAvtype[" + paramInt1 + "], groupid[" + paramLong + "], type[" + paramInt2 + "], seq[" + l + "]");
    }
    if (paramInt2 == 0) {
      this.mApp.a().v(l, false);
    }
    this.cV.put(Long.valueOf(paramLong), Integer.valueOf(paramInt2));
  }
  
  public void lf(int paramInt)
  {
    this.aqu = paramInt;
  }
  
  public int lg()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.aqx;
  }
  
  public void lg(int paramInt)
  {
    this.anl = paramInt;
  }
  
  public int lh()
  {
    return this.aqs;
  }
  
  public int li()
  {
    return this.aqt;
  }
  
  public int lj()
  {
    return this.aqu;
  }
  
  public int lk()
  {
    int j = this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mUinType;
    int i = j;
    if (j == 21) {
      i = 1011;
    }
    return i;
  }
  
  public int ll()
  {
    return this.aqv;
  }
  
  public void q(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject2 = (String)this.cX.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "0;0";
    }
    int i;
    if (paramInt2 > 0)
    {
      localObject2 = null;
      i = 0;
      if (paramInt1 == 2)
      {
        localObject2 = a(paramLong, 10);
        i = 1;
        if (localObject2 == null) {
          break label229;
        }
        if (((h)localObject2).memberNum <= 0) {
          break label221;
        }
        localObject1 = "1;" + (((h)localObject2).memberNum + paramInt2);
      }
    }
    for (;;)
    {
      this.cX.put(String.valueOf(paramLong), localObject1);
      if (AudioHelper.aCz()) {
        QLog.w("AVNotifyCenter", 1, "setMultiBarFlagInfo, groupId[" + paramLong + "], avtype[" + paramInt1 + "], memberNum[" + paramInt2 + "], old[" + (String)localObject1 + "], new[" + (String)localObject1 + "]");
      }
      return;
      if (paramInt1 != 10) {
        break;
      }
      localObject2 = a(paramLong, 2);
      i = 1;
      break;
      label221:
      localObject1 = "0;0";
      continue;
      label229:
      if (i != 0)
      {
        localObject1 = "0;0";
        continue;
        localObject1 = "0;0";
      }
    }
  }
  
  public HashMap<Long, String> r()
  {
    return this.cE;
  }
  
  public void s(int paramInt, long paramLong)
  {
    if (this.mApp == null) {
      return;
    }
    Object localObject3 = "onSelfEnterRoom, relationType[" + paramInt + "], relationId[" + paramLong;
    Object localObject1;
    label51:
    long l;
    Object localObject2;
    boolean bool2;
    if (paramInt == 2)
    {
      localObject1 = this.aH;
      l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
      localObject2 = (d)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong));
      if (localObject2 == null) {
        break label366;
      }
      localObject1 = (String)localObject3 + "], containsKey[true";
      boolean bool3 = false;
      boolean bool1 = false;
      localObject3 = ((d)localObject2).i;
      bool2 = bool3;
      if (localObject3 == null) {
        break label203;
      }
      bool2 = bool3;
      if (((Vector)localObject3).size() <= 0) {
        break label203;
      }
      int i = ((Vector)localObject3).size();
      paramInt = 0;
      label151:
      bool2 = bool1;
      if (paramInt >= i) {
        break label203;
      }
      if (l != ((g)((Vector)localObject3).elementAt(paramInt)).id) {
        break label496;
      }
      bool1 = true;
    }
    label203:
    label366:
    label496:
    for (;;)
    {
      paramInt += 1;
      break label151;
      if (paramInt != 1) {
        break;
      }
      localObject1 = this.aI;
      break label51;
      localObject1 = (String)localObject1 + "], exist[" + bool2 + "], last[" + localObject2;
      Object localObject4;
      if ((localObject3 != null) && (!bool2))
      {
        localObject4 = new g();
        ((g)localObject4).id = l;
        ((Vector)localObject3).add(localObject4);
        ((d)localObject2).me += 1L;
        localObject1 = (String)localObject1 + "], cur[" + localObject2;
      }
      for (;;)
      {
        this.mb = System.currentTimeMillis();
        QLog.w("AVNotifyCenter", 1, (String)localObject1 + "], timeRoomCreateTime[" + this.mb + "]");
        return;
        localObject2 = (String)localObject3 + "], containsKey[false";
        localObject3 = new Vector();
        localObject4 = new g();
        ((g)localObject4).id = l;
        ((Vector)localObject3).add(localObject4);
        localObject4 = new d();
        ((d)localObject4).me = 1L;
        ((d)localObject4).i = ((Vector)localObject3);
        localObject2 = (String)localObject2 + "], cur[" + localObject4;
        ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject4);
        localObject1 = localObject2;
      }
    }
  }
  
  public boolean sB()
  {
    return this.SW;
  }
  
  public boolean sM()
  {
    if (this.jdField_a_of_type_Jkf != null) {
      return this.jdField_a_of_type_Jkf.isCalling();
    }
    return false;
  }
  
  public boolean uk()
  {
    return this.SU;
  }
  
  public boolean um()
  {
    return (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mSessionType != 0) && (this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.Tc);
  }
  
  public boolean un()
  {
    return this.mUpdateRunnable != null;
  }
  
  public boolean uo()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.Tb;
  }
  
  public boolean up()
  {
    return this.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.Ta;
  }
  
  public boolean uq()
  {
    return this.ST;
  }
  
  boolean ur()
  {
    if (!imm.isSupportSharpAudio())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVNotifyCenter", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  public boolean us()
  {
    return this.SX;
  }
  
  public Map v()
  {
    return this.cV;
  }
  
  public void v(long paramLong, boolean paramBoolean)
  {
    if ((AudioHelper.aCz()) || (paramBoolean != this.SU)) {
      QLog.w("AVNotifyCenter", 1, "setVideoRequestStatus, isVideoRequest[" + this.SU + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.SU = paramBoolean;
  }
  
  public void w(long paramLong, boolean paramBoolean)
  {
    this.cW.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    if ((!paramBoolean) && (this.mApp != null))
    {
      Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box");
      localIntent.putExtra("groupId", paramLong);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void x(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "removeTipsInfo: " + paramLong + "relationType:" + paramInt);
    }
    String str = String.valueOf(paramLong);
    if (paramInt == 2) {
      this.da.remove(str);
    }
    while (paramInt != 1) {
      return;
    }
    this.db.remove(str);
  }
  
  public int y(long paramLong)
  {
    if (this.aJ.containsKey(Long.valueOf(paramLong))) {
      return ((a)this.aJ.get(Long.valueOf(paramLong))).aqw;
    }
    return 3999;
  }
  
  public long y(String paramString)
  {
    synchronized (this.cG)
    {
      if (this.cG.containsKey(paramString))
      {
        e locale = (e)this.cG.get(paramString);
        QLog.d("AVNotifyCenter", 1, "getOtherTerminalAvChattingRoomId roomInfo.mRoomId=" + locale.mRoomId + ", peerUin=" + paramString);
        long l = locale.mRoomId;
        return l;
      }
      return 0L;
    }
  }
  
  public void y(long paramLong, int paramInt)
  {
    QLog.w("SmallScreen", 1, "setSmallScreenState, smallScreenState[" + this.aqv + "->" + paramInt + "], seq[" + paramLong + "]");
    this.aqv = paramInt;
  }
  
  public boolean y(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    int i = -1;
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {
      l = alkt.getLong(paramString);
    }
    if ((um()) || (this.mApp.bF())) {
      i = 1;
    }
    h localh1;
    if ((i < 0) && (l != 0L))
    {
      h localh2 = a(l, 2);
      localh1 = localh2;
      if (localh2 == null) {
        localh1 = a(l, 12);
      }
      if ((localh1 != null) && (localh1.memberNum > 0)) {
        i = 0;
      }
    }
    label309:
    label311:
    for (;;)
    {
      if (i == 1)
      {
        QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        anot.a(this.mApp, "CliOper", "", "", "0X800AB80", "0X800AB80", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVNotifyCenter", 2, "checkForTroopVideo, ret[" + i + "], groupId[" + paramString + "]");
        }
        if (i <= 0) {
          break label309;
        }
        return true;
        localh1 = a(l, 10);
        if ((localh1 == null) || (localh1.memberNum <= 0)) {
          break label311;
        }
        i = 2;
        break;
        if (i == 2)
        {
          QQToast.a(paramContext, 2131698110, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          anot.a(this.mApp, "CliOper", "", "", "0X800AB82", "0X800AB82", 0, 0, "", "", "", "");
        }
      }
      return false;
    }
  }
  
  public int z(long paramLong)
  {
    Integer localInteger = (Integer)this.cV.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  static class UpdateChattingTime
    implements Runnable
  {
    WeakReference<AVNotifyCenter> bt;
    
    public UpdateChattingTime(AVNotifyCenter paramAVNotifyCenter)
    {
      this.bt = new WeakReference(paramAVNotifyCenter);
    }
    
    public void run()
    {
      AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.bt.get();
      if (localAVNotifyCenter == null) {}
      do
      {
        return;
        if (localAVNotifyCenter.cw(String.valueOf(localAVNotifyCenter.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.md)))
        {
          localAVNotifyCenter.mUpdateRunnable = null;
          return;
        }
        if (localAVNotifyCenter.jdField_b_of_type_MqqOsMqqHandler != null) {
          localAVNotifyCenter.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this, 2000L);
        }
      } while (!localAVNotifyCenter.SY);
      String str = jll.formatTime(localAVNotifyCenter.mc);
      if (localAVNotifyCenter.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mSessionType == 3)
      {
        localAVNotifyCenter.c(29, 0, Long.toString(localAVNotifyCenter.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.md), str);
        return;
      }
      localAVNotifyCenter.c(29, 0, localAVNotifyCenter.jdField_b_of_type_ComTencentAvGaudioAVNotifyCenter$b.mPeerUin, str);
    }
  }
  
  static class a
  {
    public int aqw;
    public long uin;
  }
  
  public class b
  {
    String OD = null;
    boolean SZ = true;
    final String TAG;
    boolean Ta = false;
    boolean Tb = false;
    boolean Tc = false;
    boolean Td = false;
    int aqx = 0;
    String mPeerUin = null;
    int mSessionType = 0;
    int mUinType = 0;
    long md = 0L;
    
    b(String paramString, long paramLong)
    {
      this.TAG = ("AvChatData_" + paramString + "_" + paramLong);
    }
    
    public String toString()
    {
      return this.TAG + ", mRelationId[" + this.md + "], mRelationType[" + this.aqx + "], mUinType[" + this.mUinType + "], mPeerUin[" + this.mPeerUin + "], mIsChating[" + this.Tc + "], mIsWaitting[" + this.Tb + "]";
    }
  }
  
  static class c
    extends MqqHandler
  {
    WeakReference<AVNotifyCenter> bs;
    
    public c(Looper paramLooper, AVNotifyCenter paramAVNotifyCenter)
    {
      super();
      this.bs = new WeakReference(paramAVNotifyCenter);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.bs.get();
      if (localAVNotifyCenter == null) {}
      while (!localAVNotifyCenter.ur()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("AVNotifyCenter", 1, "handleMessage, msg[" + paramMessage.what + "]");
      }
      if ((paramMessage.what >= 10003) && (paramMessage.what <= 10009))
      {
        localIntent = new Intent("tencent.video.q2v.MultiVideo");
        localIntent.putExtra("type", 35);
        localIntent.setPackage(localAVNotifyCenter.mApp.getApp().getPackageName());
        localAVNotifyCenter.mApp.getApp().sendBroadcast(localIntent);
      }
      switch (paramMessage.what)
      {
      case 10006: 
      case 10007: 
      case 10008: 
      case 10009: 
      default: 
        return;
      case 10002: 
        localAVNotifyCenter.aos();
        return;
      case 10003: 
        localIntent = new Intent("tencent.video.q2v.MultiVideo");
        localIntent.putExtra("type", 26);
        localIntent.putExtra("discussId", ((Long)paramMessage.obj).longValue());
        localIntent.putExtra("memberUin", localAVNotifyCenter.mApp.getCurrentAccountUin());
        localIntent.setPackage(localAVNotifyCenter.mApp.getApp().getPackageName());
        localAVNotifyCenter.mApp.getApp().sendBroadcast(localIntent);
        return;
      case 10004: 
        paramMessage = (Object[])paramMessage.obj;
        localIntent = new Intent("tencent.video.q2v.MultiVideo");
        localIntent.putExtra("type", 24);
        localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
        localIntent.putExtra("cmdUin", (String)paramMessage[1]);
        localIntent.putExtra("uins", (String[])paramMessage[2]);
        localIntent.setPackage(localAVNotifyCenter.mApp.getApp().getPackageName());
        localAVNotifyCenter.mApp.getApp().sendBroadcast(localIntent);
        return;
      case 10005: 
        paramMessage = (Object[])paramMessage.obj;
        localIntent = new Intent("tencent.video.q2v.MultiVideo");
        localIntent.putExtra("type", 31);
        localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
        localIntent.putExtra("cmdUin", (String)paramMessage[1]);
        localIntent.putExtra("uins", (String[])paramMessage[2]);
        localIntent.setPackage(localAVNotifyCenter.mApp.getApp().getPackageName());
        localAVNotifyCenter.mApp.getApp().sendBroadcast(localIntent);
        return;
      case 10010: 
        localAVNotifyCenter.ix(((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 34);
      localIntent.putExtra("relationId", ((Long)paramMessage.obj).longValue());
      localIntent.setPackage(localAVNotifyCenter.mApp.getApp().getPackageName());
      localAVNotifyCenter.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  class d
  {
    public Vector<AVNotifyCenter.g> i = null;
    public long me = 0L;
    
    public d() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("roomNum[").append(this.me).append("], list[");
      if (this.i == null) {}
      for (Object localObject = "null";; localObject = Integer.valueOf(this.i.size())) {
        return localObject + "]";
      }
    }
  }
  
  class e
  {
    public long mRoomId;
    public int mSessionType;
    
    e(long paramLong, int paramInt)
    {
      this.mRoomId = paramLong;
      this.mSessionType = paramInt;
    }
    
    public String toString()
    {
      return "OtherTerChatingRoomInfo:mRoomId=" + this.mRoomId + ", mSessionType=" + this.mSessionType;
    }
  }
  
  class f
  {
    public String headUrl;
    public String name;
    public String uin;
    
    public f(String paramString1, String paramString2, String paramString3)
    {
      this.uin = paramString1;
      this.name = paramString2;
      this.headUrl = paramString3;
    }
  }
  
  public class g
  {
    public boolean Te;
    public long id;
    String name = null;
    
    public g() {}
  }
  
  public class h
  {
    public int ang;
    public int aqA;
    public int aqy;
    public int aqz;
    public int gameId;
    public long ll;
    public int memberNum;
    final long seq = AudioHelper.hG();
    public long time;
    
    h() {}
    
    public String toString()
    {
      return "seq[" + this.seq + "], relationId[" + this.ll + "], avtype[" + this.aqy + "], roomMode[" + this.ang + "], gameId[" + this.gameId + "], liveExtraMode[" + this.aqz + "], memberNum[" + this.memberNum + "], event[" + this.aqA + "], time[" + this.time + "]";
    }
    
    public boolean ut()
    {
      return (this.aqy == 2) && (this.ang == 2) && (this.gameId == 4) && (this.aqz == 0);
    }
  }
  
  public class i
  {
    public int aqB;
    public boolean isOffLine;
    public long ll;
    
    public i() {}
    
    public String toString()
    {
      return "relationId[" + this.ll + "], isOffLine[" + this.isOffLine + "], avType[" + this.aqB + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter
 * JD-Core Version:    0.7.0.1
 */