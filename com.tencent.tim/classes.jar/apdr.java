import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.1;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.2;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class apdr
  implements Manager
{
  public long arc;
  private long ard;
  public apdh b;
  protected SparseArray<String> dC = new SparseArray();
  public int dTE;
  public int dTF;
  public int dTG;
  public int dTH;
  private AtomicBoolean ed = new AtomicBoolean(false);
  public int effectId;
  protected ConcurrentHashMap<String, List<apdj.a>> iL = new ConcurrentHashMap();
  public QQAppInterface mApp;
  public Handler mHandler = new Handler(Looper.getMainLooper());
  protected HashMap<String, Object> og = new HashMap();
  private HashMap<String, Long> oh = new HashMap();
  
  public apdr(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = new apdh();
    dYN();
  }
  
  private apdh.a b()
  {
    Object localObject = aqhq.fileToBytes(BaseApplication.getContext().getFileStreamPath("troop_enter_effect_config_" + this.mApp.getCurrentAccountUin()));
    if (localObject != null)
    {
      group_effect_commu.TGetMyEffectRsp0x2 localTGetMyEffectRsp0x2 = new group_effect_commu.TGetMyEffectRsp0x2();
      try
      {
        localTGetMyEffectRsp0x2.mergeFrom((byte[])localObject);
        localObject = new apdh.a();
        ((apdh.a)localObject).a(localTGetMyEffectRsp0x2);
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("TroopEnterEffect", 1, "readEffectInfo error: " + localException.getMessage());
      }
    }
    return null;
  }
  
  public static void b(String paramString1, String paramString2, String... paramVarArgs)
  {
    String str1;
    String str2;
    label20:
    String str3;
    if (paramVarArgs.length > 0)
    {
      str1 = paramVarArgs[0];
      if (paramVarArgs.length <= 1) {
        break label68;
      }
      str2 = paramVarArgs[1];
      if (paramVarArgs.length <= 2) {
        break label75;
      }
      str3 = paramVarArgs[2];
      label31:
      if (paramVarArgs.length <= 3) {
        break label82;
      }
    }
    label68:
    label75:
    label82:
    for (paramVarArgs = paramVarArgs[3];; paramVarArgs = "")
    {
      anot.a(null, "dc00899", "Grp_action", "", paramString1, paramString2, 0, 0, str1, str2, str3, paramVarArgs);
      return;
      str1 = "";
      break;
      str2 = "";
      break label20;
      str3 = "";
      break label31;
    }
  }
  
  public void Rz(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "readEffectConfigData start");
    }
    Object localObject = this.mApp.getApplication().getFilesDir() + File.separator + "groupeffect_config.json";
    localObject = VasQuickUpdateManager.getFileFromLocal(this.mApp, 1000L, "groupeffect_config.json", (String)localObject, paramBoolean, null);
    if (localObject != null)
    {
      localObject = aqhq.b((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.b.SJ((String)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "readEffectConfigData success");
      }
      this.b.ec.set(true);
    }
    a(b());
    this.ed.set(true);
  }
  
  public void SK(String paramString)
  {
    getSharedPreferences().edit().putBoolean("gray_tips_no_longer_" + paramString, true).commit();
  }
  
  public void SL(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (List)this.iL.get(paramString);
      if (paramString != null) {
        paramString.clear();
      }
    }
  }
  
  public void SM(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "notifyEnterTroop troopUin: " + paramString);
    }
    if (!this.ed.get()) {
      ThreadManager.post(new TroopEnterEffectManager.1(this, paramString), 8, null, true);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.b.cPX) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopEnterEffect", 2, "notifyEnterTroop function not enable");
          return;
        } while (!qq(paramString));
        if (!jof.a().dd(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopEnterEffect", 2, "notifyEnterTroop is Anonymous");
      return;
      long l = 0L;
      if (this.oh.containsKey(paramString)) {
        l = ((Long)this.oh.get(paramString)).longValue();
      }
      if (l + this.arc < System.currentTimeMillis())
      {
        l = Long.parseLong(paramString);
        ((aqrb)this.mApp.getBusinessHandler(71)).aM(8192L, l);
        this.oh.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopEnterEffect", 2, "notifyEnterTroop in time interval");
  }
  
  public apdh.a a()
  {
    return this.b.a;
  }
  
  public apdh.b a(String paramString)
  {
    if (this.b.a != null) {
      return (apdh.b)this.b.a.iK.get(paramString);
    }
    return null;
  }
  
  public apdh a()
  {
    try
    {
      if (!this.ed.get()) {
        Rz(true);
      }
      apdh localapdh = this.b;
      return localapdh;
    }
    finally {}
  }
  
  public void a(apdh.a parama)
  {
    this.b.a = parama;
  }
  
  public void a(apdh.c paramc, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "addGrayTips uin = " + paramString + " wording = " + paramc.wording);
    }
    paramString = new ahwa(paramString, this.mApp.getCurrentAccountUin(), paramc.wording, 1, -5020, 131078, anaz.gQ());
    int i = 0;
    Object localObject;
    if (i < paramc.BU.size())
    {
      localObject = (apdh.c.a)paramc.BU.get(i);
      Bundle localBundle = new Bundle();
      if (paramc.linkType == 1)
      {
        localBundle.putInt("key_action", 1);
        localBundle.putString("key_action_DATA", ((apdh.c.a)localObject).url);
      }
      for (;;)
      {
        paramString.addHightlightItem(((apdh.c.a)localObject).start, ((apdh.c.a)localObject).end, localBundle);
        i += 1;
        break;
        if (paramc.linkType == 2)
        {
          localBundle.putInt("key_action", 30);
          localBundle.putString("key_action_DATA", aqrf.a(paramc.serviceCode, paramc.dTB, paramc.openMonth, paramc.dTC, paramc.aid));
        }
      }
    }
    if (paramc.cPZ)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_action", 29);
      ((Bundle)localObject).putString("key_action_DATA", paramc.id + "");
      paramString.addHightlightItem(paramc.wording.length() - 4, paramc.wording.length(), (Bundle)localObject);
    }
    paramc = new MessageForUniteGrayTip();
    paramc.initGrayTipMsg(this.mApp, paramString);
    ahwb.a(this.mApp, paramc);
    getSharedPreferences().edit().putLong("show_gray_tips_time", System.currentTimeMillis()).commit();
    VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentUin(), "style", "0X8009132", "", 1, 0, 0, "", "", "");
  }
  
  public boolean aAR()
  {
    long l1 = getSharedPreferences().getLong("show_gray_tips_time", 0L);
    if (l1 == 0L) {}
    do
    {
      return false;
      if (this.ard == 0L)
      {
        long l2 = System.currentTimeMillis();
        this.ard = (l2 - l2 % 86400000L);
      }
    } while (l1 - l1 % 86400000L != this.ard);
    return true;
  }
  
  public boolean aAS()
  {
    return a().cPX;
  }
  
  public void b(group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2)
  {
    paramTGetMyEffectRsp0x2 = new TroopEnterEffectManager.2(this, paramTGetMyEffectRsp0x2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramTGetMyEffectRsp0x2, 5, null, true);
      return;
    }
    paramTGetMyEffectRsp0x2.run();
  }
  
  public void d(apdj.a parama)
  {
    List localList1;
    if ((parama != null) && (!TextUtils.isEmpty(parama.troopUin)))
    {
      List localList2 = (List)this.iL.get(parama.troopUin);
      localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = Collections.synchronizedList(new LinkedList());
        this.iL.put(parama.troopUin, localList1);
      }
      if (parama.uin.equals(this.mApp.getCurrentAccountUin())) {
        localList1.add(0, parama);
      }
    }
    else
    {
      return;
    }
    localList1.add(parama);
  }
  
  protected void dYN()
  {
    Object localObject = this.mApp.getApplication().getApplicationContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l <= i * 60) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateVipInfo");
    }
    localObject = this.mApp.getCurrentAccountUin();
    String str = ((TicketManager)this.mApp.getManager(2)).getSkey((String)localObject);
    ((acny)this.mApp.getBusinessHandler(27)).fg(str, (String)localObject);
  }
  
  public void e(apdj.a parama)
  {
    if ((parama != null) && (!TextUtils.isEmpty(parama.troopUin)))
    {
      List localList = (List)this.iL.get(parama.troopUin);
      if (localList != null) {
        localList.remove(parama);
      }
    }
  }
  
  public int eM(String paramString)
  {
    if (this.b.a != null)
    {
      paramString = (apdh.b)this.b.a.iK.get(paramString);
      if (paramString != null) {
        return paramString.effectId;
      }
    }
    return 0;
  }
  
  public void eY(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateEffectStatus size = " + paramArrayList.size());
    }
    if ((this.b != null) && (this.b.a != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = ((String)localIterator.next()).split(",");
        if (paramArrayList.length == 2)
        {
          Object localObject1 = paramArrayList[0];
          Object localObject2 = paramArrayList[1];
          apdh.b localb = (apdh.b)this.b.a.iK.get(localObject1);
          paramArrayList = localb;
          if (localb == null) {
            paramArrayList = new apdh.b();
          }
          if (localObject2.equals("1"))
          {
            paramArrayList.cPY = false;
            this.b.a.iK.put(localObject1, paramArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("TroopEnterEffect", 2, "updateEffectStatus off group uin = " + localObject1);
            }
          }
          else if (localObject2.equals("0"))
          {
            if (this.b.a.dTA > 0)
            {
              this.b.a.iK.remove(localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "updateEffectStatus on group uin = " + localObject1 + " has globaleffect remove infodata");
              }
            }
            else
            {
              paramArrayList.cPY = true;
              this.b.a.iK.put(localObject1, paramArrayList);
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "updateEffectStatus on group uin = " + localObject1 + " not has globaleffect update infoData");
              }
            }
          }
        }
      }
      b(this.b.a.a());
    }
  }
  
  public SharedPreferences getSharedPreferences()
  {
    return this.mApp.getApplication().getSharedPreferences("troop_enter_effect_" + this.mApp.getCurrentAccountUin(), 0);
  }
  
  public void i(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateGlobalEffectInfo: effectId = " + paramInt1 + " effectName = " + paramString + " svipLevel = " + paramInt2 + " svipType = " + paramInt3);
    }
    this.dTG = 8;
    this.dTE = paramInt2;
    this.dTF = paramInt3;
    this.effectId = paramInt1;
    if ((this.b != null) && (this.b.a != null))
    {
      this.b.a.dTA = paramInt1;
      this.b.a.cos = paramString;
      if (this.b.a.iK.size() > 0)
      {
        paramString = new ArrayList();
        Object localObject = this.b.a.iK.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (((apdh.b)localEntry.getValue()).cPY) {
            paramString.add(localEntry.getKey());
          }
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          this.b.a.iK.remove(localObject);
        }
      }
      b(this.b.a.a());
    }
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.og.clear();
  }
  
  public boolean qq(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.b.a != null) && (this.b.a.iK != null))
      {
        apdh.b localb = (apdh.b)this.b.a.iK.get(paramString);
        if (localb == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect", 2, "isEffectOn troopUin = " + paramString + " globalEffectId = " + this.b.a.dTA);
          }
          return this.b.a.dTA > 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect", 2, "isEffectOn troopUin = " + paramString + " isOn = " + localb.cPY);
        }
        return localb.cPY;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "isEffectOn troopUin = " + paramString + " effectInfo is Empty");
      }
    }
    return false;
  }
  
  public boolean qr(String paramString)
  {
    if (this.b.a != null)
    {
      paramString = (apdh.b)this.b.a.iK.get(paramString);
      return (this.b.a.dTA > 0) || ((paramString != null) && (paramString.effectId > 0));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdr
 * JD-Core Version:    0.7.0.1
 */