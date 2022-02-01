import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.d;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class apsw
  implements Manager
{
  Queue<Integer> F = new LinkedList();
  public QQAppInterface app;
  acnd s = new apsx(this);
  SharedPreferences sp = null;
  
  public apsw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.sp = BaseApplicationImpl.getApplication().getSharedPreferences("troop_gag_seqlist", 32768);
    paramQQAppInterface = this.sp.getString("seqs", null);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      int j = paramQQAppInterface.length;
      int i = 0;
      while (i < j)
      {
        String str = paramQQAppInterface[i];
        try
        {
          this.F.offer(Integer.valueOf(str));
          i += 1;
        }
        finally {}
      }
    }
  }
  
  private void TS(String paramString)
  {
    ((accc)this.app.getBusinessHandler(22)).aT(new apsw.b(paramString, a(paramString)));
  }
  
  private void g(String paramString, boolean paramBoolean, long paramLong)
  {
    ((accc)this.app.getBusinessHandler(22)).aT(new apsw.b(paramString, new apsw.d(paramBoolean, paramLong)));
  }
  
  private void h(String paramString, boolean paramBoolean, long paramLong)
  {
    accc localaccc = (accc)this.app.getBusinessHandler(22);
    paramString = new apsw.b(paramString, new apsw.c(paramBoolean, paramLong));
    paramString.from = 3;
    localaccc.aT(paramString);
  }
  
  public boolean H(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroop: sUin=%s", new Object[] { paramString }));
    }
    bj(paramString, paramLong);
    return true;
  }
  
  public void TT(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    paramString = localTroopManager.jq(paramString);
    TroopInfo localTroopInfo = localTroopManager.b(paramString);
    if (localTroopInfo != null)
    {
      localTroopInfo.dwGagTimeStamp = 0L;
      localTroopInfo.dwGagTimeStamp_me = 0L;
      localTroopManager.i(localTroopInfo);
      if (localTroopManager.b(paramString, this.app.getCurrentAccountUin()) != null) {
        localTroopManager.a(paramString, this.app.getCurrentAccountUin(), null, -100, null, null, -100, -100, -100, -100L, 0L);
      }
    }
    ((acms)this.app.getBusinessHandler(20)).EY(paramString);
  }
  
  public apsw.e a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, String.format("fightgag.getSelfGagInfo240:sUin=%s,", new Object[] { paramString }));
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null) {
      return new apsw.e(paramString, false, "", 0L);
    }
    localObject = ((TroopManager)localObject).c(paramString);
    if (localObject == null) {
      return new apsw.e(paramString, false, "", 0L);
    }
    long l = NetConnInfoCenter.getServerTime();
    boolean bool = hs(paramString);
    if ((((TroopInfo)localObject).dwGagTimeStamp != 0L) && (!bool))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, Troop Gag", new Object[] { paramString }));
      }
      return new apsw.e(paramString, true, this.app.getApplication().getApplicationContext().getString(2131699447), 60L);
    }
    if ((((TroopInfo)localObject).dwGagTimeStamp_me != 0L) && (l < ((TroopInfo)localObject).dwGagTimeStamp_me + 3L))
    {
      QLog.d("TroopGagMgr", 1, "fightgag.getSelfGagInfo:sUin= " + paramString + ",dwGagTimeStamp_me = " + ((TroopInfo)localObject).dwGagTimeStamp_me + ",lCutTimeStamp  = " + l);
      Context localContext = this.app.getApplication().getApplicationContext();
      String str = localContext.getString(2131699959);
      l = ((TroopInfo)localObject).dwGagTimeStamp_me + 3L;
      if (paramBoolean) {
        l = ((TroopInfo)localObject).dwGagTimeStamp_me - 30L;
      }
      return new apsw.e(paramString, true, String.format(str, new Object[] { k(localContext, l) }), 60L);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, not Gag", new Object[] { paramString }));
    }
    return new apsw.e(paramString, false, "", 0L);
  }
  
  public apsw.f a(String paramString)
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null) {
      return new apsw.f(paramString, 0L);
    }
    localObject = ((TroopManager)localObject).c(paramString);
    if (localObject == null) {
      return new apsw.f(paramString, 0L);
    }
    return new apsw.f(paramString, ((TroopInfo)localObject).dwGagTimeStamp);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = this.F.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          if (paramInt1 != ((Integer)((Iterator)localObject1).next()).intValue()) {
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
          }
          return;
        }
        if (this.F.size() > 30) {
          this.F.poll();
        }
        this.F.offer(Integer.valueOf(paramInt1));
        localObject2 = this.app.getApplication().getApplicationContext();
        localObject1 = String.valueOf(paramLong1);
        if (!TextUtils.isEmpty(paramString)) {
          break label244;
        }
        if (paramLong3 == 0L)
        {
          paramString = ((Context)localObject2).getResources().getString(2131698290);
          localObject2 = (MessageForGrayTips)anbi.d(-2030);
          ((MessageForGrayTips)localObject2).frienduin = ((String)localObject1);
          ((MessageForGrayTips)localObject2).init(this.app.getCurrentAccountUin(), (String)localObject1, (String)localObject1, paramString, paramLong2, -2030, 1, paramInt1);
          ((MessageForGrayTips)localObject2).isread = true;
          this.app.b().b((MessageRecord)localObject2, this.app.getCurrentAccountUin());
          return;
        }
      }
      finally {}
      paramString = ((Context)localObject2).getResources().getString(2131698280);
      continue;
      label244:
      if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131698282, new Object[] { paramString });
      } else {
        paramString = ((Context)localObject2).getResources().getString(2131698283, new Object[] { paramString, d((Context)localObject2, paramLong3) });
      }
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList<acrk> paramArrayList)
  {
    int i = 0;
    label528:
    label563:
    for (;;)
    {
      String str1;
      String str2;
      TroopManager localTroopManager;
      String str3;
      boolean bool;
      acrk localacrk;
      String str4;
      try
      {
        Object localObject = this.F.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (paramInt != ((Integer)((Iterator)localObject).next()).intValue()) {
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
          }
          return;
        }
        if (this.F.size() > 30) {
          this.F.poll();
        }
        this.F.offer(Integer.valueOf(paramInt));
        str1 = String.valueOf(paramLong1);
        str2 = this.app.getCurrentAccountUin();
        localTroopManager = (TroopManager)this.app.getManager(52);
        localObject = localTroopManager.b(String.valueOf(paramLong1));
        if (localObject != null) {
          break label563;
        }
        localObject = new TroopInfo();
        ((TroopInfo)localObject).troopuin = String.valueOf(paramLong1);
        if (TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) {
          ((acms)this.app.getBusinessHandler(20)).bJ(((TroopInfo)localObject).troopuin, false);
        }
        str3 = String.valueOf(paramLong2);
        bool = str3.equalsIgnoreCase(((TroopInfo)localObject).troopowneruin);
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break label528;
        }
        localacrk = (acrk)paramArrayList.next();
        str4 = localacrk.uin;
        if ((localacrk.Ro == 0L) || (localacrk.Ro == 4294967295L))
        {
          paramLong2 = localacrk.Ro;
          if (str4.equals(str2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopGagMgr", 2, " fightgag.onPushGagMsg ltroopUin = " + str1 + ",lGagTimeStamp = " + paramLong2);
            }
            ((TroopInfo)localObject).dwGagTimeStamp_me = paramLong2;
            localTroopManager.i((TroopInfo)localObject);
            dh(str1, true);
            a(str1, str3, paramLong3, localacrk.Ro, paramInt, false, bool);
            i = 1;
          }
          if (!str4.equals("0")) {
            break label467;
          }
          ((TroopInfo)localObject).dwGagTimeStamp = paramLong2;
          localTroopManager.i((TroopInfo)localObject);
          TS(str1);
          dh(str1, true);
          a(str1, str3, paramLong3, localacrk.Ro, paramInt, true, bool);
          i = 1;
          continue;
        }
        paramLong2 = localacrk.Ro + paramLong3;
      }
      finally {}
      continue;
      label467:
      if (!str4.equals(str2)) {
        a(str1, paramLong3, localacrk.Ro, paramInt, str3, str4, bool);
      }
      localTroopManager.j(paramLong1 + "", str4, paramLong2);
      continue;
      if (i == 0) {
        break;
      }
      paramArrayList = (acms)this.app.getBusinessHandler(20);
      try
      {
        paramArrayList.EY(str1);
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = hs(paramString1);
    Context localContext = this.app.getApplication().getApplicationContext();
    int i;
    Object localObject1;
    label87:
    Object localObject3;
    String str1;
    String str2;
    int j;
    Object localObject2;
    if ((paramBoolean) && (bool))
    {
      i = 2131699975;
      localObject1 = localContext.getString(i);
      if (paramLong2 == 0L) {
        break label545;
      }
      i = 2131699613;
      localObject3 = localContext.getString(i);
      str1 = aqgv.h(this.app, paramString1, paramString2);
      str2 = aqgv.h(this.app, paramString1, paramString3);
      j = 0;
      i = 0;
      localObject2 = this.app.getCurrentAccountUin();
      if (((String)localObject2).equalsIgnoreCase(paramString2))
      {
        localObject1 = acfp.m(2131715741);
        str1 = "";
        i = 1;
      }
      if (!((String)localObject2).equalsIgnoreCase(paramString3)) {
        break label622;
      }
      localObject1 = acfp.m(2131715742) + (String)localObject1;
      str2 = "";
      j = 1;
    }
    label545:
    label602:
    label622:
    for (;;)
    {
      localObject2 = localObject1;
      if (j == 0) {
        localObject2 = " " + (String)localObject1;
      }
      if ((!bool) || (i != 0))
      {
        str1 = "";
        localObject1 = localObject2;
      }
      for (localObject2 = localObject3;; localObject2 = " " + (String)localObject3)
      {
        localObject3 = str2 + (String)localObject1 + str1 + (String)localObject2;
        localObject2 = localObject3;
        if (paramLong2 != 0L) {
          localObject2 = (String)localObject3 + d(localContext, paramLong2);
        }
        localObject3 = (MessageForGrayTips)anbi.d(-2030);
        ((MessageForGrayTips)localObject3).frienduin = paramString1;
        ((MessageForGrayTips)localObject3).init(this.app.getCurrentAccountUin(), paramString1, paramString1, (String)localObject2, paramLong1, -2030, 1, paramInt);
        if (!aqmr.isEmpty(str2))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString3);
          paramString1.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject3).addHightlightItem(0, str2.length(), paramString1);
        }
        paramString1 = str2 + (String)localObject1;
        if (!aqmr.isEmpty(str1))
        {
          paramString3 = new Bundle();
          paramString3.putInt("key_action", 5);
          paramString3.putString("troop_mem_uin", paramString2);
          paramString3.putBoolean("need_update_nick", true);
          paramInt = paramString1.length();
          i = paramString1.length();
          ((MessageForGrayTips)localObject3).addHightlightItem(paramInt, str1.length() + i, paramString3);
        }
        ((MessageForGrayTips)localObject3).isread = true;
        if (!achp.a(this.app, (MessageRecord)localObject3, false)) {
          break label602;
        }
        return;
        i = 2131699974;
        break;
        i = 2131699529;
        break label87;
        localObject1 = (String)localObject2 + " ";
      }
      this.app.b().b((MessageRecord)localObject3, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = hs(paramString1);
    Object localObject3 = this.app.getApplication().getApplicationContext();
    Object localObject1;
    String str;
    label126:
    Object localObject2;
    if (!paramBoolean1)
    {
      localObject1 = ((Context)localObject3).getString(2131699622);
      if ((paramBoolean2) && (bool))
      {
        str = (String)localObject1 + ((Context)localObject3).getString(2131699975);
        if (!paramBoolean1) {
          break label422;
        }
        if (paramLong2 == 0L) {
          break label409;
        }
        localObject1 = ((Context)localObject3).getString(2131699616);
        localObject2 = aqgv.h(this.app, paramString1, paramString2);
        if (!this.app.getCurrentAccountUin().equalsIgnoreCase(paramString2)) {
          break label570;
        }
        str = acfp.m(2131715744);
      }
    }
    label409:
    label422:
    label550:
    label570:
    for (int i = 1;; i = 0)
    {
      if ((!bool) || (i != 0))
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = str + (String)localObject1 + (String)localObject2;
        localObject2 = (MessageForGrayTips)anbi.d(-2030);
        ((MessageForGrayTips)localObject2).frienduin = paramString1;
        ((MessageForGrayTips)localObject2).init(this.app.getCurrentAccountUin(), paramString1, paramString1, (String)localObject3, paramLong1, -2030, 1, paramInt);
        if (!aqmr.isEmpty((String)localObject1))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString2);
          paramString1.putBoolean("need_update_nick", true);
          paramInt = str.length();
          i = str.length();
          ((MessageForGrayTips)localObject2).addHightlightItem(paramInt, ((String)localObject1).length() + i, paramString1);
        }
        ((MessageForGrayTips)localObject2).isread = true;
        if (!achp.a(this.app, (MessageRecord)localObject2, false)) {
          break label550;
        }
        return;
        str = (String)localObject1 + ((Context)localObject3).getString(2131699974);
        break;
        if ((paramBoolean2) && (bool))
        {
          str = ((Context)localObject3).getString(2131699621);
          break;
        }
        str = ((Context)localObject3).getString(2131699614);
        break;
        localObject1 = ((Context)localObject3).getString(2131699530);
        break label126;
        if (paramLong2 != 0L) {}
        for (i = 2131699613;; i = 2131699529)
        {
          localObject2 = ((Context)localObject3).getString(i);
          localObject1 = localObject2;
          if (paramLong2 == 0L) {
            break;
          }
          localObject1 = (String)localObject2 + d((Context)localObject3, paramLong2);
          break;
        }
        str = str + " ";
        localObject3 = " " + (String)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      this.app.b().b((MessageRecord)localObject2, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  public void bD(int paramInt, boolean paramBoolean)
  {
    cv(this.app.getApplication().getApplicationContext().getString(paramInt), paramBoolean);
  }
  
  public boolean bQ(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("fetchGagTroopList:sUin=%s", new Object[] { paramString1 }));
    }
    if (this.app == null) {
      return false;
    }
    if (this.app != null) {
      this.app.addObserver(this.s);
    }
    acms localacms = (acms)this.app.getBusinessHandler(20);
    if (localacms != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          localacms.a(Long.parseLong(paramString1), 0L, 6, null, 0, 0);
        }
        else
        {
          long l1 = Long.parseLong(paramString1);
          long l2 = Long.parseLong(paramString2);
          paramString1 = new ArrayList();
          paramString1.add(Long.valueOf(l2));
          localacms.a(l1, 0L, 3, paramString1, 0, 0);
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopGagMgr", 2, paramString1.toString());
        }
        if (this.app == null) {
          break label198;
        }
      }
      this.app.removeObserver(this.s);
    }
    else if (this.app != null)
    {
      this.app.removeObserver(this.s);
    }
    label198:
    return true;
  }
  
  public boolean bg(String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager == null) {
      return false;
    }
    paramString1 = localTroopManager.a(paramString1, paramString2);
    NetConnInfoCenter.getServerTime();
    if ((paramString1.QU != 0L) && (paramString1.QU > NetConnInfoCenter.getServerTime())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void bj(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroop : sUin = %s", new Object[] { paramString }));
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    Object localObject2 = new oidb_0x89a.groupinfo();
    ((oidb_0x89a.groupinfo)localObject2).uint32_shutup_time.set((int)paramLong);
    ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("troopUin", paramString);
    ((Bundle)localObject1).putLong("timpStamp", paramLong);
    ((Bundle)localObject1).putInt("key_subcmd", 2);
    ((accc)this.app.getBusinessHandler(22)).a("OidbSvc.0x89a_0", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray(), (Bundle)localObject1);
  }
  
  public String c(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = this.app.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131699626);
    String str1 = ((Context)localObject).getString(2131699625);
    localObject = ((Context)localObject).getString(2131699624);
    String str2 = acfp.m(2131715746);
    if (paramLong1 < 60L) {
      return String.format(str2, new Object[] { Integer.valueOf(1), paramContext });
    }
    if (paramLong1 <= 3540L) {
      return String.format(str2, new Object[] { Long.valueOf((57L + paramLong1) / 60L), paramContext });
    }
    if (paramLong1 <= 84600L) {
      return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 3600.0F)), str1 });
    }
    return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 86400.0F)), localObject });
  }
  
  public final boolean c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 2131699531;
    if (!"OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (accc)this.app.getBusinessHandler(22);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      g(str, false, l);
      if (l == 0L) {}
      for (i = 2131699531;; i = 2131699617)
      {
        bD(i, false);
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, failed", new Object[] { str }));
        }
        return true;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        g(str, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      g(str, false, l);
      if (l == 0L) {}
      for (;;)
      {
        bD(i, false);
        return true;
        i = 2131699617;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (l == 0L) {}
        for (;;)
        {
          bD(i, false);
          g(str, false, l);
          return true;
          i = 2131699617;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, succeeded", new Object[] { str }));
      }
      g(str, true, l);
    }
    return true;
  }
  
  public boolean c(String paramString, ArrayList<apsw.a> paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroopMember:sUin=%s ", new Object[] { paramString }));
    }
    w(paramString, paramArrayList);
    return true;
  }
  
  public void cv(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = this.app.getApplication().getApplicationContext();
    int i = localContext.getResources().getDimensionPixelSize(2131299627);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopGagMgr.2(this, paramBoolean, localContext, paramString, i));
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(localContext, 2, paramString, 0).show(i);
      return;
    }
    QQToast.a(localContext, 2130840117, paramString, 0).show(i);
  }
  
  public String d(Context paramContext, long paramLong)
  {
    paramContext = this.app.getApplication().getApplicationContext();
    String str1 = paramContext.getString(2131699626);
    String str2 = paramContext.getString(2131699625);
    Object localObject = paramContext.getString(2131699624);
    if (paramLong < 60L) {
      paramContext = 1 + str1;
    }
    long l2;
    do
    {
      return paramContext;
      l2 = 59L + paramLong;
      paramLong = l2 / 86400L;
      long l1 = (l2 - 86400L * paramLong) / 3600L;
      l2 = (l2 - 86400L * paramLong - 3600L * l1) / 60L;
      paramContext = "";
      if (paramLong > 0L) {
        paramContext = "" + paramLong + (String)localObject;
      }
      localObject = paramContext;
      if (l1 > 0L) {
        localObject = paramContext + l1 + str2;
      }
      paramContext = (Context)localObject;
    } while (l2 <= 0L);
    return (String)localObject + l2 + str1;
  }
  
  public ArrayList<TroopManager.d> d(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = ((TroopManager)localObject).E(paramString);
      localObject = localArrayList;
    } while (!paramBoolean);
    bQ(paramString, null);
    return localArrayList;
  }
  
  public final boolean d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (accc)this.app.getBusinessHandler(22);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("onRspTroopMember:sUin %s sMemberUin=%s, failed", new Object[] { str1, str2 }));
      }
      if (paramFromServiceMsg.getResultCode() == 10)
      {
        if (l == 0L) {}
        for (i = 2131699532;; i = 2131699618)
        {
          bD(i, false);
          h(str1, false, l);
          return true;
        }
      }
      if (l == 0L) {}
      for (i = 2131699532;; i = 2131699619)
      {
        bD(i, false);
        break;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        h(str1, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      h(str1, false, l);
      if (l == 0L) {}
      for (i = 2131699532;; i = 2131699619)
      {
        bD(i, false);
        return true;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (paramToServiceMsg.uint32_result.get() == 10)
        {
          if (l == 0L) {}
          for (i = 2131699532;; i = 2131699618)
          {
            bD(i, false);
            h(str1, false, l);
            return true;
          }
        }
        if (l == 0L) {}
        for (i = 2131699532;; i = 2131699619)
        {
          bD(i, false);
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspTroopMember:sUin=%s sMemberUin=%s, succeeded", new Object[] { str1, str2 }));
      }
      h(str1, true, l);
      if (l != 0L) {}
    }
    for (int i = 2131699533;; i = 2131699620)
    {
      bD(i, true);
      return true;
    }
  }
  
  public void dh(String paramString, boolean paramBoolean)
  {
    ((accc)this.app.getBusinessHandler(22)).aT(new apsw.b(paramString, a(paramString, paramBoolean)));
  }
  
  public boolean eL(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager == null) {
      return false;
    }
    paramString = localTroopManager.b(paramString);
    if (paramString == null) {
      return false;
    }
    return this.app.getCurrentAccountUin().equals(paramString.troopowneruin);
  }
  
  public boolean f(String paramString1, String paramString2, long paramLong)
  {
    int i = 2131699532;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("0")))
    {
      if (paramLong == 0L) {}
      for (;;)
      {
        bD(i, false);
        return false;
        i = 2131699619;
      }
    }
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.equals("0")))
    {
      if (paramLong == 0L) {}
      for (;;)
      {
        bD(i, false);
        return false;
        i = 2131699619;
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new apsw.a(paramString2, paramLong));
    c(paramString1, localArrayList);
    return true;
  }
  
  public boolean f(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = aqoj.getLongData(paramArrayOfByte, 0);
    int i = paramArrayOfByte[4];
    long l2;
    long l3;
    if (i == 12)
    {
      i = paramArrayOfByte[5];
      l2 = aqoj.getLongData(paramArrayOfByte, 6);
      aqoj.getLongData(paramArrayOfByte, 10);
      l3 = NetConnInfoCenter.getServerTime();
      int k = aqoj.b(paramArrayOfByte, 14);
      int j = 16;
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < k)
      {
        long l4 = aqoj.getLongData(paramArrayOfByte, j);
        j += 4;
        long l5 = aqoj.getLongData(paramArrayOfByte, j);
        j += 4;
        localArrayList.add(new acrk(String.valueOf(l4), l5));
        i += 1;
      }
      a(paramInt, l1, l2, l3, localArrayList);
      return true;
    }
    if (i == 14)
    {
      i = paramArrayOfByte[5];
      aqoj.getLongData(paramArrayOfByte, 6);
      l2 = NetConnInfoCenter.getServerTime();
      l3 = aqoj.getLongData(paramArrayOfByte, 10);
      i = paramArrayOfByte[14];
      a(paramInt, l1, l2, l3, aqoj.a(paramArrayOfByte, 15, i), paramArrayOfByte[(i + 15)]);
    }
    return false;
  }
  
  public boolean hs(String paramString)
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((TroopManager)localObject).b(paramString);
    } while (localObject == null);
    paramString = this.app.getCurrentAccountUin();
    boolean bool;
    if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (paramString.equals(((TroopInfo)localObject).troopowneruin))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
      {
        localObject = ((TroopInfo)localObject).Administrator.split("\\|");
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label135;
            }
            if (localObject[i].equalsIgnoreCase(paramString))
            {
              bool = true;
              break;
            }
            i += 1;
          }
        }
      }
      label135:
      bool = false;
    }
  }
  
  public String j(Context paramContext, long paramLong)
  {
    return String.format(this.app.getApplication().getApplicationContext().getString(2131699814), new Object[] { k(paramContext, paramLong) });
  }
  
  public void jW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!c(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!d(paramToServiceMsg, paramFromServiceMsg, paramObject))) {}
    for (int i = 0;; i = 1)
    {
      if ((i == 0) && (QLog.isDevelopLevel())) {
        QLog.i("TroopGagMgr", 4, "bad subcmd" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
  }
  
  public String k(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return c(paramContext, paramLong - l, paramLong);
  }
  
  public String lO(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager == null) {
      return "";
    }
    paramString = localTroopManager.b(paramString);
    if (paramString == null) {
      return "";
    }
    if (paramString.isTroopOwner(this.app.getCurrentAccountUin())) {
      return "1";
    }
    return "2";
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.F.size() != 0)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        while (this.F.size() != 0)
        {
          localStringBuffer.append(((Integer)this.F.poll()).intValue());
          if (this.F.size() != 0) {
            localStringBuffer.append(";");
          }
        }
        this.sp.edit().putString("seqs", localObject.toString()).commit();
      }
    }
    finally {}
  }
  
  public final void w(String paramString, ArrayList<apsw.a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s, empty arList error", new Object[] { paramString }));
      }
      return;
    }
    int i = 0;
    String str = "";
    while (i < paramArrayList.size())
    {
      localObject = (apsw.a)paramArrayList.get(i);
      str = str + ((apsw.a)localObject).sUin + ((apsw.a)localObject).asa + "|";
      i += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s sMemberUins=%s", new Object[] { paramString, str }));
    }
    Object localObject = ByteBuffer.allocate(paramArrayList.size() * 8 + 7);
    ((ByteBuffer)localObject).putInt((int)Long.valueOf(paramString).longValue());
    ((ByteBuffer)localObject).put((byte)32);
    ((ByteBuffer)localObject).putShort((short)paramArrayList.size());
    long l = 0L;
    i = 0;
    str = null;
    while (i < paramArrayList.size())
    {
      apsw.a locala = (apsw.a)paramArrayList.get(i);
      ((ByteBuffer)localObject).putInt((int)Long.valueOf(locala.sUin).longValue());
      ((ByteBuffer)localObject).putInt((int)locala.asa);
      str = locala.sUin;
      l = locala.asa;
      i += 1;
    }
    localObject = ((ByteBuffer)localObject).array();
    paramArrayList = new oidb_sso.OIDBSSOPkg();
    paramArrayList.uint32_command.set(1392);
    paramArrayList.uint32_result.set(0);
    paramArrayList.uint32_service_type.set(8);
    paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
    localObject = new Bundle();
    ((Bundle)localObject).putString("troopUin", paramString);
    ((Bundle)localObject).putString("memberUin", str);
    ((Bundle)localObject).putLong("timpStamp", l);
    ((Bundle)localObject).putInt("key_subcmd", 2);
    ((accc)this.app.getBusinessHandler(22)).a("OidbSvc.0x570_8", paramArrayList.toByteArray(), (Bundle)localObject);
  }
  
  public static class a
  {
    public long asa;
    public String sUin;
    
    public a(String paramString, long paramLong)
    {
      this.sUin = paramString;
      this.asa = paramLong;
    }
  }
  
  public static class b
  {
    public ArrayList<TroopManager.d> Cn;
    public apsw.c a;
    public apsw.d a;
    public apsw.e a;
    public apsw.f a;
    public int dVM;
    public int from = -1;
    public String uin;
    
    public b(String paramString, apsw.c paramc)
    {
      this.uin = paramString;
      this.jdField_a_of_type_Apsw$c = paramc;
      this.dVM = 5;
    }
    
    public b(String paramString, apsw.d paramd)
    {
      this.uin = paramString;
      this.jdField_a_of_type_Apsw$d = paramd;
      this.dVM = 4;
    }
    
    public b(String paramString, apsw.e parame)
    {
      this.uin = paramString;
      this.jdField_a_of_type_Apsw$e = parame;
      this.dVM = 2;
    }
    
    public b(String paramString, apsw.f paramf)
    {
      this.uin = paramString;
      this.jdField_a_of_type_Apsw$f = paramf;
      this.dVM = 1;
    }
    
    public b(String paramString, ArrayList<TroopManager.d> paramArrayList)
    {
      this.uin = paramString;
      this.Cn = paramArrayList;
      this.dVM = 3;
    }
  }
  
  public static class c
  {
    public boolean cSj;
    public long timeStamp;
    
    public c(boolean paramBoolean, long paramLong)
    {
      this.cSj = paramBoolean;
      this.timeStamp = paramLong;
    }
  }
  
  public static class d
  {
    public boolean cSj;
    public long timeStamp;
    
    public d(boolean paramBoolean, long paramLong)
    {
      this.cSj = paramBoolean;
      this.timeStamp = paramLong;
    }
  }
  
  public class e
  {
    public String buttonText;
    public boolean cSk;
    public long refreshTime;
    public String uin;
    
    public e(String paramString1, boolean paramBoolean, String paramString2, long paramLong)
    {
      this.uin = paramString1;
      this.cSk = paramBoolean;
      this.buttonText = paramString2;
      this.refreshTime = paramLong;
    }
  }
  
  public class f
  {
    public long gagTimeStamp;
    public String uin;
    
    public f(String paramString, long paramLong)
    {
      this.uin = paramString;
      this.gagTimeStamp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsw
 * JD-Core Version:    0.7.0.1
 */