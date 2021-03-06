import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class aozf
{
  private final String TAG = "RelationFriendsSearchHelper";
  QQAppInterface mApp;
  
  public aozf(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public ArrayList<Entity> ab(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RelationFriendsSearchHelper", 1, "uin empty");
      return null;
    }
    Object localObject2 = (acyd)this.mApp.a().a(2);
    Object localObject1 = ((acyd)localObject2).an(paramString);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.e("RelationFriendsSearchHelper", 1, "Search ftsEntities empty");
      return null;
    }
    Object localObject3 = new HashMap();
    long l2 = NetConnInfoCenter.getServerTime();
    Object localObject4 = this.mApp.a().a();
    long l1 = 0L;
    int i = 0;
    int j = 0;
    long l3;
    if (j < ((List)localObject1).size())
    {
      localObject5 = (TroopIndex)((List)localObject1).get(j);
      if (!((HashMap)localObject3).containsKey(((TroopIndex)localObject5).mTroopUin))
      {
        localObject6 = ((acxw)localObject4).a(((TroopIndex)localObject5).mTroopUin, 1);
        if ((localObject6 != null) && (((RecentUser)localObject6).lastmsgtime > 0L))
        {
          l3 = 100L + l2 - ((RecentUser)localObject6).lastmsgtime;
          if (l3 < 0L) {}
          ((HashMap)localObject3).put(((TroopIndex)localObject5).mTroopUin, Long.valueOf(l3));
          i += 1;
          l1 += l3;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((HashMap)localObject3).put(((TroopIndex)localObject5).mTroopUin, Long.valueOf(0L));
      }
    }
    long l4 = System.currentTimeMillis();
    localObject1 = (acff)this.mApp.getManager(51);
    Object localObject5 = new HashMap();
    float f3 = 1.0F / ((HashMap)localObject3).size();
    Object localObject6 = this.mApp.getCurrentAccountUin();
    Iterator localIterator = ((HashMap)localObject3).keySet().iterator();
    l2 = 0L;
    Object localObject7;
    float f1;
    if (localIterator.hasNext())
    {
      localObject7 = (String)localIterator.next();
      l3 = ((Long)((HashMap)localObject3).get(localObject7)).longValue();
      if ((l3 <= 0L) || (l1 <= 0L)) {
        break label1119;
      }
      f1 = (0.0F + (float)l3) / (float)l1;
      if ((f1 > 1.0F) || (i <= 0)) {
        break label1114;
      }
      if (i == 1)
      {
        f1 = 1.0F;
        label387:
        f2 = f1;
        if (QLog.isColorLevel()) {
          QLog.i("RelationFriendsSearchHelper", 2, "troopUin:" + (String)localObject7 + ",delta:" + l3 + "troopActiveFator_delta:" + f1);
        }
      }
    }
    label668:
    label1114:
    label1119:
    for (float f2 = f1;; f2 = 0.0F)
    {
      l3 = System.currentTimeMillis();
      localObject7 = ((acyd)localObject2).ao((String)localObject7);
      l3 = l2 + (System.currentTimeMillis() - l3);
      if ((localObject7 == null) || (((List)localObject7).size() == 0))
      {
        QLog.e("RelationFriendsSearchHelper", 1, "Search ftsMembers empty");
        l2 = l3;
        break;
        f1 = (1.0F - f1) / (i - 1);
        break label387;
      }
      j = 0;
      l2 = l3;
      if (j >= ((List)localObject7).size()) {
        break;
      }
      Object localObject8 = (TroopIndex)((List)localObject7).get(j);
      if ((((acff)localObject1).isFriend(((TroopIndex)localObject8).mMemberUin)) && (!((String)localObject6).equals(((TroopIndex)localObject8).mMemberUin)) && (!paramString.equals(((TroopIndex)localObject8).mMemberUin)))
      {
        if (((HashMap)localObject5).containsKey(((TroopIndex)localObject8).mMemberUin)) {
          break label668;
        }
        aozf.a locala = new aozf.a(f3);
        locala.Ag = f2;
        locala.dSj = 1;
        RecentUser localRecentUser = ((acxw)localObject4).a(((TroopIndex)localObject8).mMemberUin, 0);
        if (localRecentUser != null) {
          locala.aqF = localRecentUser.lastmsgtime;
        }
        ((HashMap)localObject5).put(((TroopIndex)localObject8).mMemberUin, locala);
      }
      for (;;)
      {
        j += 1;
        break;
        localObject8 = (aozf.a)((HashMap)localObject5).get(((TroopIndex)localObject8).mMemberUin);
        ((aozf.a)localObject8).dSj += 1;
        ((aozf.a)localObject8).Ag += f2;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsSearchHelper", 2, "timecost:" + (System.currentTimeMillis() - l4) + "querycostmember:" + l2 + ",troopsSize:" + ((HashMap)localObject3).size() + "Members:" + ((HashMap)localObject5).size());
      }
      paramString = new ArrayList(((HashMap)localObject5).entrySet());
      Collections.sort(paramString, new aozg(this));
      i = paramString.size();
      if ((i > 1) && (((aozf.a)((Map.Entry)paramString.get(i - 1)).getValue()).bx() == ((aozf.a)((Map.Entry)paramString.get(0)).getValue()).bx())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RelationFriendsSearchHelper", 2, "isAllMemberScoreEqual");
          }
          Collections.sort(paramString, new aozh(this));
        }
        localObject2 = new ArrayList();
        i = 0;
        if (i < paramString.size())
        {
          localObject3 = (aozf.a)((Map.Entry)paramString.get(i)).getValue();
          localObject4 = ((acff)localObject1).b((String)((Map.Entry)paramString.get(i)).getKey());
          if (localObject4 != null)
          {
            ((ArrayList)localObject2).add(localObject4);
            if ((i < 20) && (QLog.isColorLevel())) {
              QLog.i("RelationFriendsSearchHelper", 2, "top20:uin" + aqmr.getSimpleUinForPrint(((Friends)localObject4).uin) + ",scores:" + ((aozf.a)localObject3).bx() + ",frequency:" + ((aozf.a)localObject3).dSj + ",activefactor:" + ((aozf.a)localObject3).Ag + ",c2clastmsgtime:" + ((aozf.a)localObject3).aqF);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.i("RelationFriendsSearchHelper", 2, "friends null");
            }
          }
        }
        return localObject2;
      }
      f1 = 0.0F;
      break label387;
    }
  }
  
  class a
  {
    final float Af;
    float Ag = 0.0F;
    long aqF = 0L;
    int dSj = 0;
    
    public a(float paramFloat)
    {
      this.Af = paramFloat;
    }
    
    public float bx()
    {
      return this.dSj * this.Af * 0.4F + this.Ag * 0.6F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozf
 * JD-Core Version:    0.7.0.1
 */