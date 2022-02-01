import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class ajpj
  implements Manager
{
  QQAppInterface app;
  public boolean cpL;
  int dkj = -2147483648;
  int dkk = -2147483648;
  ConcurrentHashMap<String, Long> gl = new ConcurrentHashMap();
  ConcurrentHashMap<String, Long> gm = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Integer> gn = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Integer> go = new ConcurrentHashMap();
  
  public ajpj(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    ajrk.f("Q.nearby", "updateNearbyPeopleCard", new Object[] { paramString, paramCharmEvent, paramNearbyCharmNotify });
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || ((paramCharmEvent == null) && (paramNearbyCharmNotify == null))) {}
    EntityManager localEntityManager;
    do
    {
      return;
      Object localObject = null;
      localEntityManager = paramQQAppInterface.a().createEntityManager();
      paramQQAppInterface = localObject;
      if (!aqmr.isEmpty(paramString)) {
        paramQQAppInterface = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
      }
    } while (paramQQAppInterface == null);
    if ((paramCharmEvent != null) && (paramCharmEvent.uint32_new_charm.get() > 0) && (paramCharmEvent.uint32_cur_level_threshold.get() > paramCharmEvent.uint32_next_level_threshold.get()))
    {
      paramQQAppInterface.charm = paramCharmEvent.uint32_new_charm.get();
      paramQQAppInterface.charmLevel = paramCharmEvent.uint32_new_charm_level.get();
      paramQQAppInterface.curThreshold = paramCharmEvent.uint32_cur_level_threshold.get();
      paramQQAppInterface.nextThreshold = paramCharmEvent.uint32_next_level_threshold.get();
    }
    for (;;)
    {
      localEntityManager.update(paramQQAppInterface);
      localEntityManager.close();
      return;
      if (paramNearbyCharmNotify != null)
      {
        paramQQAppInterface.charm = paramNearbyCharmNotify.uint32_new_charm.get();
        paramQQAppInterface.charmLevel = paramNearbyCharmNotify.uint32_new_charm_level.get();
        paramQQAppInterface.curThreshold = paramNearbyCharmNotify.uint32_cur_level_threshold.get();
        paramQQAppInterface.nextThreshold = paramNearbyCharmNotify.uint32_next_level_threshold.get();
        paramQQAppInterface.profPercent = paramNearbyCharmNotify.uint32_new_prof_percent.get();
      }
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if (paramInt == 1) {
      anot.a(null, "dc00899", "grp_lbs", "", "app_down", "exp_msg", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      aqha.a(paramActivity, 230).setMessage(paramString1).setNegativeButton(acfp.m(2131708663), new ajpl()).setPositiveButton(acfp.m(2131708666), new ajpk(paramString2, paramInt, paramActivity)).show();
      return true;
      if (paramInt == 2) {
        anot.a(null, "dc00899", "grp_lbs", "", "app_down", "exp_pic", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void dv(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_people_card.", 4, "updateNearbyProfileCardHead");
    }
    paramQQAppInterface.dE(paramQQAppInterface.getCurrentAccountUin(), 200);
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory(paramQQAppInterface.getAccount()).createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramQQAppInterface.getCurrentAccountUin() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        paramQQAppInterface.dE(String.valueOf(localNearbyPeopleCard.tinyId), 202);
      }
      localEntityManager.close();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new NearbyCardManager.1(paramQQAppInterface), 2000L);
  }
  
  public int GA()
  {
    Object localObject;
    int i;
    if (this.dkj == -2147483648)
    {
      localObject = ((acff)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if (localObject == null) {
        break label51;
      }
      i = ((Card)localObject).shGender;
    }
    for (;;)
    {
      Rk(i);
      return this.dkj;
      label51:
      localObject = (NearbyPeopleCard)this.app.getEntityManagerFactory(this.app.getCurrentAccountUin()).createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { this.app.getCurrentAccountUin() });
      if (localObject != null) {
        i = ((NearbyPeopleCard)localObject).gender;
      } else {
        i = -1;
      }
    }
  }
  
  public int Gz()
  {
    Card localCard;
    if (this.dkk == -2147483648)
    {
      localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if ((localCard != null) && ((localCard.age != 0) || (!TextUtils.isEmpty(localCard.strNick)))) {}
    }
    else
    {
      return this.dkk;
    }
    if (-2147483648 != localCard.age) {}
    for (int i = localCard.age;; i = -2147483648)
    {
      Rj(i);
      break;
    }
  }
  
  /* Error */
  public void MG(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	ajpj:gl	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 35	ajpj:gl	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 299	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +7 -> 25
    //   21: aload_1
    //   22: ifnonnull +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 35	ajpj:gl	Ljava/util/concurrent/ConcurrentHashMap;
    //   32: aload_1
    //   33: invokevirtual 303	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: getfield 35	ajpj:gl	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: aload_1
    //   44: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: goto -23 -> 25
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ajpj
    //   0	56	1	paramString	String
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	51	finally
    //   28	48	51	finally
  }
  
  public void Rj(int paramInt)
  {
    if (paramInt != this.dkk)
    {
      this.dkk = paramInt;
      ajrb.c(this.app.getAccount(), "self_age", Integer.valueOf(this.dkk));
    }
  }
  
  public void Rk(int paramInt)
  {
    int i = this.dkj;
    switch (paramInt)
    {
    default: 
      this.dkj = 0;
    }
    for (;;)
    {
      if (i != this.dkj)
      {
        Object localObject = this.app.a(false);
        if (localObject != null)
        {
          localObject = ((HotChatManager)localObject).a(false);
          if (localObject != null) {
            ((ahyk)localObject).a(this.app.getCurrentAccountUin(), null, paramInt, NetConnInfoCenter.getServerTime());
          }
        }
        ajrb.c(this.app.getAccount(), "self_gender", Integer.valueOf(this.dkj));
      }
      return;
      this.dkj = 1;
      continue;
      this.dkj = 2;
    }
  }
  
  public boolean a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (paramNearbyPeopleCard != null)
    {
      bool2 = bool3;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        if (this.go.containsKey(paramNearbyPeopleCard.uin))
        {
          this.go.remove(paramNearbyPeopleCard.uin);
          bool1 = true;
        }
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (this.go.containsKey(String.valueOf(paramNearbyPeopleCard.tinyId)))
          {
            this.go.remove(String.valueOf(paramNearbyPeopleCard.tinyId));
            return true;
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean a(NearbyPeopleCard paramNearbyPeopleCard, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    boolean bool1 = this.cpL;
    this.cpL = false;
    if (paramNearbyPeopleCard == null) {
      return true;
    }
    boolean bool2 = b(paramNearbyPeopleCard);
    int k = 0;
    int j = 0;
    int i = k;
    if (paramNearbyPeopleCard != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        i = j;
        if (this.go.containsKey(paramNearbyPeopleCard.uin))
        {
          this.go.remove(paramNearbyPeopleCard.uin);
          i = 1;
        }
        if (this.go.containsKey(String.valueOf(paramNearbyPeopleCard.tinyId)))
        {
          this.go.remove(String.valueOf(paramNearbyPeopleCard.tinyId));
          i = 1;
        }
      }
    }
    if (i != 0) {
      return true;
    }
    if (bool2) {
      return true;
    }
    if (TextUtils.isEmpty(paramNearbyPeopleCard.uin)) {
      return true;
    }
    if ((bool1) && (paramString.equals(paramNearbyPeopleCard.uin))) {
      return true;
    }
    if (!paramBoolean3) {
      return true;
    }
    if ((paramBoolean1) || (paramBoolean2)) {
      return true;
    }
    if (51 == paramInt) {
      try
      {
        if (!this.gm.containsKey(paramNearbyPeopleCard.uin)) {
          return true;
        }
      }
      finally {}
    }
    for (long l = ((Long)this.gm.get(paramNearbyPeopleCard.uin)).longValue();; l = ((Long)this.gl.get(paramNearbyPeopleCard.uin)).longValue())
    {
      l = SystemClock.elapsedRealtime() - l;
      if (!aqft.equalsWithNullCheck(paramString, paramNearbyPeopleCard.uin)) {
        break;
      }
      if (l < 300000L) {
        break label316;
      }
      return true;
      if (!this.gl.containsKey(paramNearbyPeopleCard.uin)) {
        return true;
      }
    }
    if (l >= 300000L) {
      return true;
    }
    label316:
    return (!TextUtils.isEmpty(paramNearbyPeopleCard.uin)) && (((ajqh)this.app.getManager(207)).nz(paramNearbyPeopleCard.uin));
  }
  
  public void ap(String paramString, long paramLong)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
        this.gl.put(paramString, Long.valueOf(paramLong));
      }
      return;
    }
    finally {}
  }
  
  public void aq(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
      this.gm.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public boolean arq()
  {
    return ((Boolean)ajrb.c(this.app.getCurrentAccountUin(), "self_god_flag", Boolean.valueOf(false))).booleanValue();
  }
  
  public void b(oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    if (paramSelfInfo == null) {
      return;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory(this.app.getCurrentAccountUin()).createEntityManager();
    Object localObject2;
    Object localObject1;
    if (localEntityManager != null)
    {
      localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.app.getCurrentAccountUin() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramSelfInfo.uint64_tinyid.get() > 0L) {
          localObject1 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(paramSelfInfo.uint64_tinyid.get()) });
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new NearbyPeopleCard();
      }
      if (paramSelfInfo.uint64_tinyid.get() > 0L)
      {
        ((NearbyPeopleCard)localObject2).tinyId = paramSelfInfo.uint64_tinyid.get();
        ((NearbyPeopleCard)localObject2).uin = this.app.getCurrentAccountUin();
      }
      i = paramSelfInfo.uint32_vote_num.get();
      if ((paramSelfInfo.uint32_vote_num.has()) && (i > 0)) {
        ((NearbyPeopleCard)localObject2).likeCount = i;
      }
      i = paramSelfInfo.uint32_vote_increment.get();
      if ((paramSelfInfo.uint32_vote_increment.has()) && (i > 0)) {
        ((NearbyPeopleCard)localObject2).likeCountInc = i;
      }
      ((NearbyPeopleCard)localObject2).gender = ((byte)paramSelfInfo.uint32_gender.get());
      ((NearbyPeopleCard)localObject2).nickname = paramSelfInfo.bytes_nick.get().toStringUtf8();
      ((NearbyPeopleCard)localObject2).age = paramSelfInfo.uint32_age.get();
      if (((NearbyPeopleCard)localObject2).getStatus() != 1000) {
        break label482;
      }
      localEntityManager.persistOrReplace((Entity)localObject2);
      localObject1 = ((acff)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if (localObject1 != null)
      {
        i = paramSelfInfo.uint32_vote_num.get();
        if ((!paramSelfInfo.uint32_vote_num.has()) || (i <= 0)) {
          break label515;
        }
        ((Card)localObject1).lVoteCount = i;
      }
    }
    label515:
    for (int i = 1;; i = 0)
    {
      int k = paramSelfInfo.uint32_vote_increment.get();
      int j = i;
      if (paramSelfInfo.uint32_vote_increment.has())
      {
        j = i;
        if (k > 0)
        {
          ((Card)localObject1).iVoteIncrement = k;
          j = 1;
        }
      }
      if (j != 0)
      {
        ajrb.b(this.app.getAccount(), ((Card)localObject1).lVoteCount, ((Card)localObject1).iVoteIncrement);
        localEntityManager.update((Entity)localObject1);
      }
      localEntityManager.close();
      Rk(paramSelfInfo.uint32_gender.get());
      Rj(paramSelfInfo.uint32_age.get());
      ajrb.c(this.app.getAccount(), "self_third_line_info", paramSelfInfo.str_third_line_info.get());
      ajrb.c(this.app.getAccount(), "self_third_line_icon", paramSelfInfo.str_third_line_icon.get());
      return;
      label482:
      if ((((NearbyPeopleCard)localObject2).getStatus() != 1001) && (((NearbyPeopleCard)localObject2).getStatus() != 1002)) {
        break;
      }
      localEntityManager.update((Entity)localObject2);
      break;
    }
  }
  
  public boolean b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramNearbyPeopleCard != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        bool1 = bool2;
        if (this.gn.containsKey(paramNearbyPeopleCard.uin))
        {
          this.gn.remove(paramNearbyPeopleCard.uin);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void dyE()
  {
    try
    {
      if (this.gl != null) {
        this.gl.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int ip(int paramInt)
  {
    int k = 0;
    int i = -1;
    int j;
    if (paramInt != 0)
    {
      j = k;
      if (paramInt != 1) {}
    }
    else
    {
      j = GA();
      if (j != 1) {
        break label55;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        j = k;
        if (i != 1) {}
      }
      else
      {
        if (i != 1) {
          break label67;
        }
        if (paramInt != 1) {
          break;
        }
        j = 3;
      }
      return j;
      label55:
      if (j == 2) {
        i = 1;
      }
    }
    return 2;
    label67:
    if (paramInt == 1) {
      return 1;
    }
    return 4;
  }
  
  public void onDestroy()
  {
    try
    {
      this.gl.clear();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpj
 * JD-Core Version:    0.7.0.1
 */