import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.2;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ImgInfo;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ReqBody;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.RspBody;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class alur
  implements aehn.b, Handler.Callback, Manager
{
  public static final String bYz = acfp.m(2131707350);
  public static boolean czx;
  private acnd a = new alut(this);
  QQAppInterface app;
  private String bYA = bYz;
  private String bYB = bYz;
  private volatile String bYC;
  acfd c = new alus(this);
  private Set<String> cN = new HashSet();
  private Set<String> cO = new HashSet();
  private Set<String> cP = new HashSet();
  private boolean czA = false;
  private boolean czy = false;
  private boolean czz = false;
  private int dyb = 100;
  private int dyc = 50;
  private aurf e = new aurf(ThreadManager.getFileThreadLooper(), this);
  private WeakReference<aluv> eC;
  private final ConcurrentHashMap<String, Integer> gH = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> gI = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> gJ = new ConcurrentHashMap();
  private WeakReference<aluq> hG;
  private volatile boolean mInited;
  private final Object mLock = new Object();
  public int showDuration = 60;
  private float yV = 7.0F;
  
  public alur(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.app.a().a("breaking_ice_config", this);
    this.e.sendEmptyMessage(0);
    paramQQAppInterface.addObserver(this.c, true);
    paramQQAppInterface.addObserver(this.a, true);
  }
  
  private void Pi(String paramString)
  {
    Object localObject1 = (TroopManager)this.app.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).c(paramString);
    if (localTroopInfo == null)
    {
      QLog.i("IceBreak.HotPic", 1, "troop info is null.");
      return;
    }
    int i;
    int j;
    if (localTroopInfo.wMemberNum < this.dyb)
    {
      Object localObject2 = ((TroopManager)localObject1).al(paramString);
      if ((localObject2 == null) || (((List)localObject2).size() <= 1))
      {
        if (localObject2 == null) {}
        for (i = 0;; i = ((List)localObject2).size())
        {
          QLog.i("IceBreak.HotPic", 1, "troop member size: " + i);
          this.bYC = paramString;
          ((acms)this.app.getBusinessHandler(20)).Ff(paramString);
          return;
        }
      }
      j = ((List)localObject2).size();
      localObject1 = (acff)this.app.getManager(51);
      String str1 = this.app.getCurrentAccountUin();
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      label179:
      if (((Iterator)localObject2).hasNext())
      {
        String str2 = ((TroopMemberInfo)((Iterator)localObject2).next()).memberuin;
        if ((TextUtils.isEmpty(str2)) || (str2.equals(str1)) || (((acff)localObject1).isFriend(str2))) {
          break label313;
        }
        i += 1;
      }
    }
    label313:
    for (;;)
    {
      break label179;
      QLog.i("IceBreak.HotPic", 1, "noFriendCount: " + i + " total count: " + localTroopInfo.wMemberNum);
      if (1.0F * i / (j - 1) <= this.dyc / 100.0F) {
        break;
      }
      Pd(paramString);
      return;
      Pd(paramString);
      return;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramBoolean1)
    {
      bool1 = bool2;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(0)))
      {
        Iterator localIterator = paramConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() == 0) {
            localIterator.remove();
          }
        }
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (!paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(1)))
      {
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        while (paramConcurrentHashMap.hasNext()) {
          if (((Integer)((Map.Entry)paramConcurrentHashMap.next()).getValue()).intValue() == 0) {
            paramConcurrentHashMap.remove();
          }
        }
        paramBoolean1 = true;
      }
    }
    return paramBoolean1;
  }
  
  private Object[] a(boolean paramBoolean, String paramString)
  {
    boolean bool8 = false;
    bool5 = false;
    boolean bool7 = false;
    bool4 = false;
    String str5 = bYz;
    String str4 = bYz;
    float f3 = 7.0F;
    boolean bool6 = false;
    bool3 = false;
    int i1 = 100;
    int n = 50;
    i3 = 60;
    Object localObject2 = paramString;
    if (!paramBoolean) {
      localObject2 = aqmj.k(this.app.getApp(), this.app.getCurrentUin(), "breaking_ice_config");
    }
    i2 = i3;
    m = n;
    k = i1;
    f2 = f3;
    str3 = str4;
    String str2 = str5;
    i = n;
    j = i1;
    paramBoolean = bool6;
    f1 = f3;
    paramString = str4;
    str1 = str5;
    bool1 = bool7;
    bool2 = bool8;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool7;
        bool2 = bool8;
        localObject2 = new JSONObject((String)localObject2);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool7;
        bool2 = bool8;
        bool5 = ((JSONObject)localObject2).optBoolean("switchNewFrd", false);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool7;
        bool2 = bool5;
        bool4 = ((JSONObject)localObject2).optBoolean("switchOldFrd", false);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool4;
        bool2 = bool5;
        str2 = ((JSONObject)localObject2).optString("tipNewFrd", bYz);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        str3 = ((JSONObject)localObject2).optString("tipOldFrd", bYz);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        f2 = (float)((JSONObject)localObject2).optDouble("daysOldFrd", 7.0D);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        bool3 = ((JSONObject)localObject2).optBoolean("switchTroop", false);
        i = n;
        j = i1;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        k = ((JSONObject)localObject2).optInt("troopNumberCount", 100);
        i = n;
        j = k;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        m = ((JSONObject)localObject2).optInt("troopNumberNotFirendRate", 50);
        i = m;
        j = k;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        i2 = ((JSONObject)localObject2).optInt("showDuration", 60);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i2 = i3;
        m = i;
        k = j;
        bool3 = paramBoolean;
        f2 = f1;
        str3 = paramString;
        Object localObject1 = str1;
        bool4 = bool1;
        bool5 = bool2;
      }
    }
    return new Object[] { Boolean.valueOf(bool5), Boolean.valueOf(bool4), str2, str3, Float.valueOf(f2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2) };
  }
  
  private void dcZ()
  {
    if (!this.mInited) {
      init();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.gH);
    aqhq.y(String.format("%s_%s", new Object[] { "break_ice_map", this.app.getCurrentAccountUin() }), localConcurrentHashMap);
  }
  
  private void init()
  {
    Object[] arrayOfObject = a(false, null);
    Object localObject1 = aqhq.o(String.format("%s_%s", new Object[] { "break_ice_map", this.app.getCurrentAccountUin() }));
    ??? = aqhq.o(String.format("%s_%s", new Object[] { "entered_c2c", this.app.getCurrentAccountUin() }));
    ??? = aqhq.o(String.format("%s_%s", new Object[] { "entered_troop", this.app.getCurrentAccountUin() }));
    ??? = aqhq.o(String.format("%s_%s", new Object[] { "entered_match_chat", this.app.getCurrentAccountUin() }));
    if (this.mInited) {
      return;
    }
    if ((localObject1 != null) && ((localObject1 instanceof ConcurrentHashMap))) {}
    Object localObject6;
    for (localObject1 = (ConcurrentHashMap)localObject1;; localObject6 = null)
    {
      if (localObject1 == null) {
        localObject1 = new ConcurrentHashMap();
      }
      for (;;)
      {
        for (;;)
        {
          if (??? != null) {}
          synchronized (this.cN)
          {
            this.cN.addAll((Set)???);
            if (??? != null) {}
            synchronized (this.cO)
            {
              this.cO.addAll((Set)???);
              if (??? != null) {}
              synchronized (this.cP)
              {
                this.cP.addAll((Set)???);
                a(((Boolean)arrayOfObject[0]).booleanValue(), ((Boolean)arrayOfObject[1]).booleanValue(), (ConcurrentHashMap)localObject1);
              }
            }
          }
          synchronized (this.mLock)
          {
            if (!this.mInited)
            {
              if (localObject1 != null) {
                this.gH.putAll((Map)localObject1);
              }
              this.czy = ((Boolean)arrayOfObject[0]).booleanValue();
              this.czz = ((Boolean)arrayOfObject[1]).booleanValue();
              this.bYA = ((String)arrayOfObject[2]);
              this.bYB = ((String)arrayOfObject[3]);
              this.yV = ((Float)arrayOfObject[4]).floatValue();
              this.czA = ((Boolean)arrayOfObject[5]).booleanValue();
              this.dyb = ((Integer)arrayOfObject[6]).intValue();
              this.dyc = ((Integer)arrayOfObject[7]).intValue();
              this.showDuration = ((Integer)arrayOfObject[8]).intValue();
              this.mInited = true;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("init IceBreak Config: mSwitchNewFrd: ").append(this.czy).append(",mSwitchOldFrd: ").append(this.czz).append(",mTipNewFrd: ").append(this.bYA).append(",mTipOldFrd: ").append(this.bYB).append(",mDaysOldFrd: ").append(this.yV).append(",switchTroop: ").append(this.czA).append(",troopMemberMinCount: ").append(this.dyb).append(",troopMemberNotFriendRate: ").append(this.dyc).append(",showDuration: ").append(this.showDuration);
            QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject1).toString());
            return;
            localObject2 = finally;
            throw localObject2;
            localObject3 = finally;
            throw localObject3;
            localObject4 = finally;
            throw localObject4;
          }
        }
      }
    }
  }
  
  public void OZ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeEnteredMatchChat " + paramString);
    }
    if (!this.mInited) {
      init();
    }
    if (this.cP.contains(paramString))
    {
      this.cP.remove(paramString);
      dJR();
    }
  }
  
  public void Pa(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    if (!this.cP.contains(paramString)) {
      synchronized (this.cP)
      {
        this.cP.add(paramString);
        return;
      }
    }
  }
  
  public void Pb(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    if (!this.cN.contains(paramString)) {
      synchronized (this.cN)
      {
        this.cN.add(paramString);
        return;
      }
    }
  }
  
  public void Pc(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    if (!this.cO.contains(paramString)) {
      synchronized (this.cO)
      {
        this.cO.add(paramString);
        return;
      }
    }
  }
  
  public void Pd(String paramString)
  {
    QLog.i("IceBreak.Mng", 1, "insertTroopToBreakingIceMap troopUin: " + paramString);
    this.gI.put(paramString, Integer.valueOf(0));
    if (this.eC != null)
    {
      aluv localaluv = (aluv)this.eC.get();
      if (localaluv != null) {
        localaluv.aW(paramString, true);
      }
    }
  }
  
  public void Pe(String paramString)
  {
    QLog.i("IceBreak.Mng", 1, "removeTroopFromBreakingIceMap troopUin: " + paramString);
    this.gI.remove(paramString);
    if (this.eC != null)
    {
      aluv localaluv = (aluv)this.eC.get();
      if (localaluv != null) {
        localaluv.aX(paramString, true);
      }
    }
  }
  
  public void Pf(String paramString)
  {
    this.gJ.remove(paramString);
    if (this.eC != null)
    {
      aluv localaluv = (aluv)this.eC.get();
      if (localaluv != null) {
        localaluv.aX(paramString, false);
      }
    }
  }
  
  public void Pg(String paramString)
  {
    if (ou(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat enter " + paramString);
      }
    }
    aluv localaluv;
    do
    {
      do
      {
        do
        {
          return;
          if (((afsi)this.app.getManager(264)).ajZ()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat switch is off");
        return;
        this.gJ.put(paramString, Integer.valueOf(0));
      } while (this.eC == null);
      localaluv = (aluv)this.eC.get();
    } while (localaluv == null);
    localaluv.aW(paramString, false);
  }
  
  public void Ph(String paramString)
  {
    if (!yhf.a(this.app).TC()) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "checkNeedShowIceBreakForTroop emotionRec switch is off");
      }
    }
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      return;
      if (ot(paramString))
      {
        QLog.i("IceBreak.HotPic", 1, "entered toop.");
        return;
      }
      if (!this.czA)
      {
        QLog.i("IceBreak.HotPic", 1, "troop switch is off.");
        return;
      }
      localTroopMemberInfo = ((TroopManager)this.app.getManager(52)).b(paramString, this.app.getCurrentAccountUin());
      if ((localTroopMemberInfo == null) || (localTroopMemberInfo.last_active_time == localTroopMemberInfo.join_time))
      {
        QLog.i("IceBreak.HotPic", 1, "troop member info is null.");
        this.bYC = paramString;
        ((acms)this.app.getBusinessHandler(20)).i(Long.valueOf(paramString).longValue(), Long.valueOf(this.app.getCurrentAccountUin()).longValue(), true);
        return;
      }
      QLog.i("IceBreak.HotPic", 1, "last_active_time: " + localTroopMemberInfo.last_active_time + " join_time: " + localTroopMemberInfo.join_time);
    } while (localTroopMemberInfo.last_active_time > localTroopMemberInfo.join_time);
    Pi(paramString);
  }
  
  public void a(aluq paramaluq)
  {
    this.hG = new WeakReference(paramaluq);
  }
  
  public void a(aluv paramaluv)
  {
    this.eC = new WeakReference(paramaluv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aehn.a parama)
  {
    if ((parama != null) && ("breaking_ice_config".equals(paramString)))
    {
      if (!this.mInited) {
        init();
      }
      paramQQAppInterface = a(true, parama.strContent);
      boolean bool1 = ((Boolean)paramQQAppInterface[0]).booleanValue();
      boolean bool2 = ((Boolean)paramQQAppInterface[1]).booleanValue();
      this.bYA = ((String)paramQQAppInterface[2]);
      this.bYB = ((String)paramQQAppInterface[3]);
      this.yV = ((Float)paramQQAppInterface[4]).floatValue();
      this.czA = ((Boolean)paramQQAppInterface[5]).booleanValue();
      this.dyb = ((Integer)paramQQAppInterface[6]).intValue();
      this.dyc = ((Integer)paramQQAppInterface[7]).intValue();
      this.showDuration = ((Integer)paramQQAppInterface[8]).intValue();
      if ((bool1 != this.czy) || (bool2 != this.czz))
      {
        this.czy = ((Boolean)paramQQAppInterface[0]).booleanValue();
        this.czz = ((Boolean)paramQQAppInterface[1]).booleanValue();
        paramQQAppInterface = new ConcurrentHashMap(this.gH.size());
        paramQQAppInterface.putAll(this.gH);
        if (a(this.czy, this.czz, paramQQAppInterface))
        {
          this.gH.clear();
          this.gH.putAll(paramQQAppInterface);
          if (this.e.hasMessages(1)) {
            this.e.removeMessages(1);
          }
          this.e.sendEmptyMessage(1);
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onGetConfig: mSwitchNewFrd: ").append(this.czy).append(",mSwitchOldFrd: ").append(this.czz).append(",mTipNewFrd: ").append(this.bYA).append(",mTipOldFrd: ").append(this.bYB).append(",mDaysOldFrd: ").append(this.yV).append(",switchTroop: ").append(this.czA).append(",troopMemberMinCount: ").append(this.dyb).append(",troopMemberNotFriendRate: ").append(this.dyc).append(",showDuration: ").append(this.showDuration);
        QLog.d("IceBreak.Mng", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public int ai(String paramString, int paramInt)
  {
    int i = -1;
    if (!this.mInited) {
      init();
    }
    if (paramInt == 1)
    {
      paramString = (Integer)this.gI.get(paramString);
      if (paramString == null) {
        paramInt = -1;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return paramInt;
          paramInt = paramString.intValue();
        }
        if (!aluu.kX(paramInt)) {
          break;
        }
        paramString = (Integer)this.gJ.get(paramString);
        paramInt = i;
      } while (paramString == null);
      return paramString.intValue();
      paramString = (Integer)this.gH.get(paramString);
      paramInt = i;
    } while (paramString == null);
    return paramString.intValue();
  }
  
  public void b(aluv paramaluv)
  {
    if ((this.eC != null) && (this.eC.get() == paramaluv)) {
      this.eC = null;
    }
  }
  
  public boolean bh(boolean paramBoolean)
  {
    if (!this.mInited) {
      init();
    }
    if (czx)
    {
      this.czy = true;
      this.czz = true;
    }
    if (paramBoolean) {
      return this.czy;
    }
    return this.czz;
  }
  
  public void bq(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new IcebreakHotPic.RspBody();
      ((IcebreakHotPic.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((IcebreakHotPic.RspBody)localObject).int32_result.get() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse response code error,result:" + ((IcebreakHotPic.RspBody)localObject).int32_result.get() + " message : " + ((IcebreakHotPic.RspBody)localObject).bytes_fail_msg.get());
        }
      }
      else
      {
        paramArrayOfByte = ((IcebreakHotPic.RspBody)localObject).rpt_msg_img_info.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse imgInfos is null or empty");
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("IceBreak.HotPic", 2, aurp.getStackTraceAsString(paramArrayOfByte));
        return;
        localObject = new ArrayList();
        int i = 0;
        while (i < paramArrayOfByte.size())
        {
          IcebreakHotPic.ImgInfo localImgInfo = (IcebreakHotPic.ImgInfo)paramArrayOfByte.get(i);
          ygz localygz = new ygz();
          localygz.setIndex(i);
          localygz.gi(localImgInfo.uint64_img_size.get());
          localygz.DW(localImgInfo.uint32_img_width.get());
          localygz.DX(localImgInfo.uint32_img_height.get());
          localygz.yE(localImgInfo.bytes_img_md5.get().toStringUtf8());
          localygz.setImgUrl(localImgInfo.bytes_img_down_url.get().toStringUtf8());
          localygz.setKeyWord(localImgInfo.bytes_img_word.get().toStringUtf8());
          localygz.gj(localImgInfo.uint64_thumb_size.get());
          localygz.DZ(localImgInfo.uint32_thumb_img_height.get());
          localygz.DY(localImgInfo.uint32_thumb_img_width.get());
          localygz.setThumbUrl(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
          localygz.yF(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
          ((List)localObject).add(localygz);
          i += 1;
        }
        ThreadManager.getUIHandler().post(new IceBreakingMng.2(this, (List)localObject));
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse dateList size is: " + ((List)localObject).size());
        }
      }
    }
  }
  
  public float bu()
  {
    if (!this.mInited) {
      init();
    }
    return this.yV;
  }
  
  public void cN(String paramString, boolean paramBoolean)
  {
    if (!bh(paramBoolean)) {}
    label54:
    label185:
    for (;;)
    {
      return;
      Object localObject = ((acff)this.app.getManager(51)).e(paramString);
      boolean bool;
      int i;
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        bool = true;
        if (!bool) {
          break label178;
        }
        if (!paramBoolean) {
          break label173;
        }
        i = 0;
        this.gH.put(paramString, Integer.valueOf(i));
        if (this.eC != null)
        {
          localObject = (aluv)this.eC.get();
          if (localObject != null) {
            ((aluv)localObject).aW(paramString, false);
          }
        }
        if (this.e.hasMessages(1)) {
          this.e.removeMessages(1);
        }
        this.e.sendEmptyMessage(1);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label185;
        }
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addToBreakingIceList uin: %s, ret: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        return;
        bool = false;
        break;
        i = 1;
        break label54;
        ov(paramString);
      }
    }
  }
  
  public void dJO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeAllEnteredMatchChat ");
    }
    if (!this.mInited) {
      init();
    }
    if (!this.cP.isEmpty())
    {
      this.cP.clear();
      dJR();
    }
  }
  
  public void dJP()
  {
    if (!this.mInited) {
      init();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.cN);
    aqhq.y(String.format("%s_%s", new Object[] { "entered_c2c", this.app.getCurrentAccountUin() }), localHashSet);
  }
  
  public void dJQ()
  {
    if (!this.mInited) {
      init();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.cO);
    aqhq.y(String.format("%s_%s", new Object[] { "entered_troop", this.app.getCurrentAccountUin() }), localHashSet);
  }
  
  public void dJR()
  {
    if (!this.mInited) {
      init();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.cP);
    aqhq.y(String.format("%s_%s", new Object[] { "entered_match_chat", this.app.getCurrentAccountUin() }), localHashSet);
  }
  
  public void dJS()
  {
    this.hG = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      dcZ();
      continue;
      init();
    }
  }
  
  public void m(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.Mng", 2, String.format("request HotPicList fromUin: %s, termType: %s, aioType: %s, toUin: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    try
    {
      IcebreakHotPic.ReqBody localReqBody = new IcebreakHotPic.ReqBody();
      localReqBody.setHasFlag(true);
      String str = paramString1 + SystemClock.uptimeMillis();
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString2));
      paramString1 = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (paramString1 != null) {
        localReqBody.uint32_age.set(paramString1.age);
      }
      for (;;)
      {
        paramString1 = localReqBody.toByteArray();
        paramString2 = ByteBuffer.allocate(paramString1.length + 4);
        paramString2.putInt(paramString1.length + 4).put(paramString1);
        paramString1 = paramString2.array();
        paramString2 = new NewIntent(this.app.getApp(), yhk.class);
        paramString2.putExtra("key_body", paramString1);
        paramString2.putExtra("key_cmd", "BreakIceSvr.Pull");
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.Mng", 2, "request HotPicList, sessionId = " + str);
        }
        this.app.startServlet(paramString2);
        return;
        localReqBody.uint32_age.set(0);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("IceBreak.Mng", 1, "request HotPicList exception", paramString1);
    }
  }
  
  public void onDestroy()
  {
    this.e.removeCallbacksAndMessages(null);
    this.app.a().a(this);
    this.app.removeObserver(this.c);
    this.app.removeObserver(this.a);
  }
  
  public boolean os(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    return this.cN.contains(paramString);
  }
  
  public boolean ot(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    return this.cO.contains(paramString);
  }
  
  public boolean ou(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    return this.cP.contains(paramString);
  }
  
  public boolean ov(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    Object localObject = this.gH.remove(paramString);
    if (localObject != null)
    {
      if (this.eC != null)
      {
        aluv localaluv = (aluv)this.eC.get();
        if (localaluv != null) {
          localaluv.aX(paramString, false);
        }
      }
      if (this.e.hasMessages(1)) {
        this.e.removeMessages(1);
      }
      this.e.sendEmptyMessage(1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "removeFromBreakingIceList uin: %s , ret:%s", new Object[] { paramString, localObject }));
    }
    return localObject != null;
  }
  
  public boolean ow(String paramString)
  {
    if (!this.mInited) {
      init();
    }
    boolean bool2 = this.gH.containsKey(paramString);
    boolean bool1 = bool2;
    if (bool2)
    {
      paramString = ((acff)this.app.getManager(51)).e(paramString);
      if ((paramString != null) && (paramString.isFriend())) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alur
 * JD-Core Version:    0.7.0.1
 */