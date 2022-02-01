import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class amvg
  implements amwd<ampt>
{
  private static final Comparator<ampt> X = new amvh();
  private static final Comparator<ampt> Z = new amvi();
  private static final Comparator<RecentUser> aa = new amvj();
  public static boolean cEn;
  private List<ampt> Gg;
  private List<WeakReference<amvg.a>> Gh = new ArrayList();
  private List<ArrayList<DiscussionMemberInfo>> Gl;
  private Queue<amvg.b> I = new ConcurrentLinkedQueue();
  private Queue<amvg.b> J = new ConcurrentLinkedQueue();
  private amvk jdField_a_of_type_Amvk;
  private amwe<ampt> jdField_a_of_type_Amwe;
  private amvg.c[] jdField_a_of_type_ArrayOfAmvg$c = { new amvg.c(1, "friend"), new amvg.c(768, "phone_contact"), new amvg.c(4, "discussion_member"), new amvg.c(8, "discussion"), new amvg.c(16, "troop"), new amvg.c(32, "recent_user"), new amvg.c(64, "tool"), new amvg.c(2048, "circle_buddy"), new amvg.c(131072, "global_troop_member") };
  private long ake = -1L;
  private long akf;
  private long akg;
  private long akh = -1L;
  private long aki = -1L;
  private long akj = -1L;
  private long akk = -1L;
  protected QQAppInterface app;
  private boolean cEo;
  boolean cEp = false;
  private Set<String> cV;
  private String caU;
  private String ccj;
  private int dCH;
  private int dDK;
  private Object eE = new Object();
  private int fromType;
  private ConcurrentHashMap<String, Integer> gV = new ConcurrentHashMap();
  private Map<String, ArrayList<DiscussionMemberInfo>> na;
  private String type;
  
  public amvg(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.app = paramQQAppInterface;
    this.dCH = paramInt2;
    this.fromType = paramInt1;
    this.cV = paramSet;
    this.caU = paramString;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (amxk.lo(paramInt1)) {
        this.cEo = false;
      }
      return;
      this.type = "people";
      continue;
      this.type = "msg";
    }
  }
  
  public amvg(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramQQAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(ampt paramampt)
  {
    int i = -1;
    if ((paramampt instanceof amok)) {
      i = 0;
    }
    do
    {
      return i;
      if ((paramampt instanceof amop)) {
        return 1;
      }
      if ((paramampt instanceof amoj)) {
        return 2;
      }
      if ((paramampt instanceof amoi)) {
        return 3;
      }
      if ((paramampt instanceof amos)) {
        return 4;
      }
    } while (!(paramampt instanceof amoq));
    return 5;
  }
  
  private static int a(ampt paramampt1, ampt paramampt2)
  {
    int j = 0;
    int i = j;
    if (paramampt2.za() != null)
    {
      i = j;
      if (paramampt1.za() != null) {
        i = paramampt2.za().toString().compareTo(paramampt1.za().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramampt2.zb() != null)
      {
        j = i;
        if (paramampt1.zb() != null) {
          j = paramampt2.zb().toString().compareTo(paramampt1.zb().toString());
        }
      }
    }
    return j;
  }
  
  private List<ampt> a(amvg.a parama)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfAmvg$c[i].type))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfAmvg$c[i].akd = -1L;
      }
    }
    String str = this.ccj;
    List localList = h(str, false);
    if (localList != null)
    {
      if (!QLog.isColorLevel()) {
        break label344;
      }
      QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
    }
    label344:
    for (;;)
    {
      if (localList == null)
      {
        return null;
        localList = this.Gg;
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < localList.size())
        {
          if (parama.getValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          ampt localampt = (ampt)localList.get(i);
          long l1 = System.nanoTime();
          try
          {
            localampt.aw(str);
            long l2 = System.nanoTime();
            int j = a(localampt);
            if (j != -1)
            {
              amvg.c localc = this.jdField_a_of_type_ArrayOfAmvg$c[j];
              localc.akd = (l2 - l1 + localc.akd);
            }
            if (localampt.gN() != -9223372036854775808L) {
              localArrayList.add(localampt);
            }
            i += 1;
          }
          finally {}
        }
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
        {
          this.jdField_a_of_type_ArrayOfAmvg$c[i].akd /= 1000000L;
          i += 1;
        }
        e(str, localArrayList, false);
        return localArrayList;
      }
    }
  }
  
  private Map<String, ArrayList<DiscussionMemberInfo>> aw()
  {
    dOy();
    return this.na;
  }
  
  private List<ampt> b(amvg.a parama)
  {
    String str;
    Object localObject1;
    Object localObject3;
    long l1;
    Object localObject4;
    long l2;
    int n;
    int j;
    int k;
    label504:
    label510:
    Object localObject5;
    if (((0x10000 & this.dCH) != 0) || ((0x20000 & this.dCH) != 0) || ((0x200000 & this.dCH) != 0) || ((0x400000 & this.dCH) != 0))
    {
      str = this.ccj;
      localObject1 = h(str, true);
      if ((localObject1 != null) && (((List)localObject1).size() < 100))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchTroopMember use cache, keyword = " + str);
        }
        localObject3 = new ArrayList();
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label1413;
        }
        if (parama.getValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      else
      {
        localObject1 = new ArrayList();
        l1 = System.currentTimeMillis();
        int m = 0;
        if (amxh.awl())
        {
          ??? = (acyd)this.app.a().a(2);
          localObject4 = ((acyd)???).an(str);
          if (parama.getValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          l2 = System.currentTimeMillis() - l1;
          n = ji(131072);
          this.jdField_a_of_type_ArrayOfAmvg$c[n].akd = (1000000L * l2);
          this.akj = l2;
          this.aki = ((acyd)???).Bm();
          if (localObject4 != null)
          {
            j = ((List)localObject4).size();
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.TroopGlobalquery cost time : " + l2 + "; size : " + j + "; keyWord: " + str);
            }
            ??? = (TroopManager)this.app.getManager(52);
            if (((0x10000 & this.dCH) == 0) && ((0x20000 & this.dCH) == 0)) {
              break label504;
            }
          }
          for (k = 1;; k = 0)
          {
            i = m;
            if (localObject4 == null) {
              break label1244;
            }
            i = m;
            if (((List)localObject4).size() <= 0) {
              break label1244;
            }
            localObject3 = new ArrayList();
            i = 0;
            if (i >= ((List)localObject4).size()) {
              break label596;
            }
            if (!parama.getValue()) {
              break label510;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
            j = 0;
            break;
          }
          localObject5 = (TroopIndex)((List)localObject4).get(i);
          if (this.app.cs(String.valueOf(((TroopIndex)localObject5).mTroopUin)) != 3)
          {
            if (k == 0) {
              break label564;
            }
            ((List)localObject3).add(localObject5);
          }
          for (;;)
          {
            i += 1;
            break;
            label564:
            if (((TroopManager)???).c(String.valueOf(((TroopIndex)localObject5).mTroopUin)).isNewTroop()) {
              ((List)localObject3).add(localObject5);
            }
          }
          label596:
          i = m;
          if (((List)localObject3).size() > 0)
          {
            if (((0x20000 & this.dCH) == 0) && ((0x400000 & this.dCH) == 0)) {
              break label1442;
            }
            localObject4 = new ArrayList();
            this.app.getCurrentAccountUin();
            i = 0;
            if (i < ((List)localObject3).size())
            {
              if (parama.getValue())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
                }
                return null;
              }
              localObject5 = (TroopIndex)((List)localObject3).get(i);
              if ("50000000".equals(((TroopIndex)localObject5).mMemberUin)) {}
              for (;;)
              {
                i += 1;
                break;
                if (!((TroopManager)???).c(String.valueOf(((TroopIndex)localObject5).mTroopUin)).isNewTroop()) {
                  ((List)localObject4).add(new amom(this.app, this.fromType, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
                } else {
                  ((List)localObject4).add(new amoo(this.app, this.fromType, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
                }
              }
            }
            ((List)localObject1).addAll((Collection)localObject4);
          }
        }
      }
    }
    label1413:
    label1442:
    for (int i = ((List)localObject4).size() + 0;; i = 0)
    {
      if (((0x10000 & this.dCH) != 0) || ((0x200000 & this.dCH) != 0))
      {
        localObject4 = new ArrayList();
        localObject5 = new HashMap();
        k = 0;
        Object localObject6;
        if (k < ((List)localObject3).size())
        {
          if (parama.getValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          localObject6 = (TroopIndex)((List)localObject3).get(k);
          amol.b localb = new amol.b(((TroopIndex)localObject6).mMemberCard, ((TroopIndex)localObject6).mMemberName, ((TroopIndex)localObject6).mMemberUin, ((TroopIndex)localObject6).mMemberNick);
          ArrayList localArrayList;
          if (!((HashMap)localObject5).containsKey(((TroopIndex)localObject6).mTroopUin))
          {
            localArrayList = new ArrayList();
            localArrayList.add(localb);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
          for (;;)
          {
            k += 1;
            break;
            localArrayList = (ArrayList)((HashMap)localObject5).get(((TroopIndex)localObject6).mTroopUin);
            localArrayList.add(localb);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
        }
        localObject3 = ((HashMap)localObject5).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject6 = (String)((Iterator)localObject3).next();
          if (!((TroopManager)???).c(String.valueOf(localObject6)).isNewTroop()) {
            ((List)localObject4).add(new amol(this.app, this.fromType, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          } else {
            ((List)localObject4).add(new amon(this.app, this.fromType, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          }
        }
        ((List)localObject1).addAll((Collection)localObject4);
        i += ((List)localObject4).size();
      }
      for (;;)
      {
        for (;;)
        {
          label1244:
          l2 = System.currentTimeMillis() - l1 - l2;
          this.jdField_a_of_type_ArrayOfAmvg$c[n].dDH = i;
          this.jdField_a_of_type_ArrayOfAmvg$c[n].initTime = l2;
          this.akk = (System.currentTimeMillis() - l1);
          this.akh = j;
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.troopGlobalDataProcess cost time : " + l2 + "; size : " + i + "; keyWord: " + str);
          }
          break;
          synchronized ((ampt)((List)localObject1).get(i))
          {
            ((ampt)???).aw(str);
            if (((ampt)???).gN() != -9223372036854775808L) {
              ((List)localObject3).add(???);
            }
            i += 1;
          }
        }
        if (((List)localObject3).size() < 100) {
          e(str, (List)localObject3, true);
        }
        return localObject3;
        return null;
      }
    }
  }
  
  private void dOx()
  {
    int k = 0;
    Object localObject2 = this.app.a().a().a(true, true, false);
    Object localObject1 = aizp.a().l(this.app);
    if (localObject2 != null)
    {
      j = ((List)localObject2).size();
      if (localObject1 == null) {
        break label156;
      }
    }
    ArrayList localArrayList;
    label156:
    for (int i = ((List)localObject1).size();; i = 0)
    {
      localArrayList = new ArrayList(j + i);
      localArrayList.addAll((Collection)localObject2);
      j = 0;
      while (j < i)
      {
        localObject2 = new RecentUser();
        ((RecentUser)localObject2).uin = ((TroopAssistantData)((List)localObject1).get(j)).troopUin;
        ((RecentUser)localObject2).lastmsgtime = ((TroopAssistantData)((List)localObject1).get(j)).lastmsgtime;
        localArrayList.add(localObject2);
        j += 1;
      }
      j = 0;
      break;
    }
    Collections.sort(localArrayList, aa);
    int j = localArrayList.size();
    i = k;
    while ((i < j) && (i < 999))
    {
      localObject1 = (RecentUser)localArrayList.get(i);
      this.gV.put(((RecentUser)localObject1).uin, Integer.valueOf(999 - i));
      i += 1;
    }
  }
  
  private void dOy()
  {
    Object localObject4 = null;
    label200:
    label205:
    label208:
    for (;;)
    {
      try
      {
        if (this.na == null)
        {
          Object localObject1 = (acdu)this.app.getManager(53);
          if (localObject1 == null) {
            break label200;
          }
          localObject4 = ((acdu)localObject1).getDiscussList();
          String[] arrayOfString = new String[((List)localObject4).size()];
          localObject4 = ((List)localObject4).iterator();
          int i = 0;
          if (((Iterator)localObject4).hasNext())
          {
            DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject4).next();
            if ((localDiscussionInfo != null) && (localDiscussionInfo.uin != null) && (localDiscussionInfo.uin.length() > 0))
            {
              arrayOfString[i] = localDiscussionInfo.uin;
              i += 1;
              break label205;
            }
          }
          else
          {
            localObject1 = ((acdu)localObject1).a(arrayOfString);
            localObject4 = new ArrayList(arrayOfString.length);
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label208;
            }
            ((List)localObject4).add((ArrayList)((Map)localObject1).get(arrayOfString[i]));
            i += 1;
            continue;
            this.na = ((Map)localObject1);
            this.Gl = ((List)localObject4);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      break label205;
      Object localObject3 = null;
      continue;
    }
  }
  
  private int dY(String paramString)
  {
    paramString = (Integer)this.gV.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private void e(String paramString, List<ampt> paramList, boolean paramBoolean)
  {
    Queue localQueue;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
          return;
        }
        if (paramBoolean)
        {
          localQueue = this.J;
          if (localQueue.size() <= 2) {
            break;
          }
          localQueue.poll();
          continue;
        }
        localQueue = this.I;
      }
      finally {}
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label124;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new amvg.b(paramString, paramList));
      return;
      label124:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        amvg.b localb = (amvg.b)localIterator.next();
        if (localb.Gi.isEmpty()) {
          localQueue.remove(localb);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private List<ampt> f(amwt paramamwt)
  {
    Object localObject2 = new amvg.a(false);
    boolean bool;
    for (;;)
    {
      synchronized (this.eE)
      {
        this.Gh.add(new WeakReference(localObject2));
        this.ccj = paramamwt.keyword;
        if (paramamwt.extra != null)
        {
          bool = paramamwt.extra.getBoolean("searchRequestFromHome", false);
          ??? = this.ccj;
          if (!((amvg.a)localObject2).getValue()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
        }
      }
      bool = false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject3 = new ArrayList();
    Object localObject4 = a((amvg.a)localObject2);
    this.dDK = 0;
    int i;
    HashSet localHashSet;
    long l2;
    long l3;
    long l4;
    Iterator localIterator;
    int j;
    if (((0x10000 & this.dCH) != 0) || ((0x20000 & this.dCH) != 0) || ((0x200000 & this.dCH) != 0) || ((0x400000 & this.dCH) != 0))
    {
      i = 1;
      if ((localObject4 != null) && (i != 0) && (bool))
      {
        localHashSet = new HashSet();
        l2 = amjz.aje;
        l3 = amjz.aji;
        l4 = amjz.ajI;
        localIterator = ((List)localObject4).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ampt localampt = (ampt)localIterator.next();
          if (((amvg.a)localObject2).getValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
            }
            return null;
            i = 0;
            break;
          }
          if (((localampt instanceof amoi)) || ((localampt instanceof amos))) {
            this.dDK += 1;
          }
          if (localampt.gN() > l2 + l3 + l4) {
            localHashSet.add(localampt.S());
          }
          if (localHashSet.size() > 5)
          {
            j = 0;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("ContactSearchEngine", 2, "searchContact no need to search troop member, keyword = " + (String)???);
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (((amvg.a)localObject2).getValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
        }
        return null;
      }
      if ((paramamwt.extra != null) && (paramamwt.extra.containsKey("searchTroopMember"))) {}
      for (bool = paramamwt.extra.getBoolean("searchTroopMember");; bool = true)
      {
        if (i != 0) {
          if (!bool) {}
        }
        for (paramamwt = b((amvg.a)localObject2); ((amvg.a)localObject2).getValue(); paramamwt = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
          paramamwt.extra.putBoolean("searchTroopMember", true);
        }
        if (localObject4 != null) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
        if (paramamwt != null) {
          ((List)localObject3).addAll(paramamwt);
        }
        localObject4 = new ArrayList();
        if (a((List)localObject3, (List)localObject4, (amvg.a)localObject2, (String)???)) {
          return null;
        }
        paramamwt = new ArrayList();
        localObject2 = ((List)localObject4).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ampt)((Iterator)localObject2).next();
          if ((localObject3 instanceof amol))
          {
            j = i + 1;
            i = j;
            if (j > 200) {
              break label715;
            }
            paramamwt.add(localObject3);
            i = j;
          }
          label715:
          for (;;)
          {
            break;
            paramamwt.add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() troopCount:" + i);
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.type + " ; cost time : " + (l2 - l1) + " ; size = " + paramamwt.size() + " ; keyword = " + (String)???);
          if (cEn)
          {
            i = 0;
            while (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
            {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_a_of_type_ArrayOfAmvg$c[i].cck + " ; cost time : " + this.jdField_a_of_type_ArrayOfAmvg$c[i].akd + " ; size = " + this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH + " ; keyword = " + (String)???);
              i += 1;
            }
          }
        }
        this.ake = (l2 - l1);
        this.akf = paramamwt.size();
        ??? = new HashMap();
        ((HashMap)???).put("result_size", String.valueOf(paramamwt.size()));
        i = 0;
        if (i < 5)
        {
          if (i < paramamwt.size()) {
            ((HashMap)???).put("result_top_" + i, String.valueOf(((ampt)paramamwt.get(i)).gN()));
          }
          for (;;)
          {
            i += 1;
            break;
            ((HashMap)???).put("result_top_" + i, "0");
          }
        }
        this.cEp = false;
        localObject2 = paramamwt.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ampt)((Iterator)localObject2).next();
          ((ampt)localObject3).mV = ((HashMap)???);
          if ("9970".equals(((ampt)localObject3).getUin())) {
            this.cEp = true;
          }
        }
        return paramamwt;
      }
    }
  }
  
  private List<ampt> g(amwt paramamwt)
  {
    amvg.a locala = new amvg.a(false);
    synchronized (this.eE)
    {
      this.Gh.add(new WeakReference(locala));
      this.ccj = paramamwt.keyword;
      return b(locala);
    }
  }
  
  private List<ArrayList<DiscussionMemberInfo>> gg()
  {
    dOy();
    return this.Gl;
  }
  
  private List<ampt> h(String paramString, boolean paramBoolean)
  {
    label252:
    label255:
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i = -2147483648;
        Object localObject;
        if (paramBoolean)
        {
          localObject = this.J;
          Iterator localIterator = ((Queue)localObject).iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            amvg.b localb = (amvg.b)localIterator.next();
            if ((!paramString.startsWith(localb.keyword)) || (localb.keyword.length() <= i)) {
              break label252;
            }
            i = localb.keyword.length();
            localObject = localb;
            break label255;
          }
        }
        else
        {
          localObject = this.I;
          continue;
        }
        if ((localObject != null) && (((amvg.b)localObject).Gi != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + ((amvg.b)localObject).keyword + " , cache size = " + ((amvg.b)localObject).Gi.size());
          }
          paramString = ((amvg.b)localObject).Gi;
          return paramString;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  public static int ji(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 768: 
      return 1;
    case 4: 
      return 2;
    case 8: 
      return 3;
    case 16: 
      return 4;
    case 32: 
      return 5;
    case 2048: 
      return 7;
    }
    return 8;
  }
  
  public int Jc()
  {
    return this.dCH;
  }
  
  public List<ampt> a(amwt paramamwt)
  {
    boolean bool3 = false;
    boolean bool1;
    boolean bool2;
    if (paramamwt.extra != null)
    {
      bool1 = paramamwt.extra.getBoolean("searchCreateDiscussion", false);
      bool2 = paramamwt.extra.getBoolean("searchTroopMember", false);
    }
    for (;;)
    {
      if (this.dCH == 64)
      {
        bool1 = false;
        bool2 = bool3;
      }
      for (;;)
      {
        if (bool1)
        {
          if (this.jdField_a_of_type_Amvk != null) {
            return this.jdField_a_of_type_Amvk.a(paramamwt);
          }
        }
        else
        {
          if (bool2) {
            return g(paramamwt);
          }
          return f(paramamwt);
        }
        return new ArrayList();
      }
      bool2 = false;
      bool1 = false;
    }
  }
  
  public void a(amwt paramamwt, amwe<ampt> paramamwe)
  {
    this.jdField_a_of_type_Amwe = paramamwe;
    ThreadManager.postImmediately(new ContactSearchEngine.4(this, paramamwt), null, true);
  }
  
  public boolean a(List<ampt> paramList1, List<ampt> paramList2, amvg.a arg3, String paramString)
  {
    amvg.a locala = ???;
    if (??? == null) {
      locala = new amvg.a(false);
    }
    ampt localampt1;
    for (;;)
    {
      ampt localampt2;
      synchronized (this.eE)
      {
        this.Gh.add(new WeakReference(locala));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localampt1 = (ampt)paramList1.next();
        localampt2 = (ampt)???.get(localampt1.S());
        if (locala.getValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
      }
      if ((localampt2 == null) || (localampt2.gN() < localampt1.gN())) {
        ???.put(localampt1.S(), localampt1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localampt1 = (ampt)???.next();
      if (locala.getValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localampt1 = (ampt)localampt1.clone();
      if (localampt1 != null) {
        paramList1.add(localampt1);
      }
    }
    try
    {
      Collections.sort(paramList1, X);
      label298:
      int i = Math.min(paramList1.size(), 30);
      ??? = paramList1.subList(0, i);
      paramString = f();
      if (paramString == null) {
        Collections.sort(???, Z);
      }
      paramList2.addAll(???);
      paramList2.addAll(paramList1.subList(i, paramList1.size()));
      if (paramString != null) {
        Collections.sort(paramList2, paramString);
      }
      return false;
    }
    catch (Throwable ???)
    {
      break label298;
    }
  }
  
  protected List<ampt> ak(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
    {
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = 0;
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = 0L;
      i += 1;
    }
    dOx();
    Object localObject3 = new ArrayList();
    long l1;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    long l2;
    if ((paramInt & 0x20) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = this.app.a().a().q(false);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((RecentUser)localObject4).uin)) && (!"50000000".equals(((RecentUser)localObject4).uin))) {
            switch (((RecentUser)localObject4).getType())
            {
            case 1001: 
            case 1002: 
            case 1003: 
            default: 
              break;
            case 1000: 
            case 1004: 
            case 1005: 
            case 1006: 
              localObject5 = (acff)this.app.getManager(51);
              if ((localObject5 != null) && (!((acff)localObject5).isFriend(((RecentUser)localObject4).uin))) {
                ((List)localObject1).add(new amoq(this.app, this.fromType, (RecentUser)localObject4, dY(((RecentUser)localObject4).uin)));
              }
              break;
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(32);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    Object localObject6;
    Object localObject7;
    label442:
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject4 = (acff)this.app.getManager(51);
      if (localObject4 != null)
      {
        this.app.getCurrentAccountUin();
        localObject1 = ((acff)localObject4).cp();
        if (localObject1 != null)
        {
          localObject5 = ((List)localObject1).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Groups)((Iterator)localObject5).next();
            localObject1 = ((acff)localObject4).B(String.valueOf(((Groups)localObject6).group_id));
            if (localObject1 != null)
            {
              localObject7 = ((List)localObject1).iterator();
              QQAppInterface localQQAppInterface;
              while (((Iterator)localObject7).hasNext())
              {
                localFriends = (Friends)((Iterator)localObject7).next();
                if (asgx.a(this.app, localFriends, this.fromType))
                {
                  localQQAppInterface = this.app;
                  i = this.fromType;
                  if (localFriends.gathtertype != 1) {
                    break label552;
                  }
                }
              }
              label552:
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131721547);; localObject1 = ((Groups)localObject6).group_name)
              {
                ((List)localObject2).add(new amok(localQQAppInterface, i, localFriends, (String)localObject1, dY(localFriends.uin)));
                break label442;
                break;
              }
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = ji(1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject2).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (ajdo)this.app.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((ajdo)localObject2).cZ();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = (List)((List)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(768);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (ajdo)this.app.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((ajdo)localObject2).cZ();
        if ((localObject2 != null) && (((List)localObject2).size() > 1))
        {
          localObject2 = (List)((List)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(768);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (ajdo)this.app.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((ajdo)localObject2).db();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(768);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (ajdo)this.app.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((ajdo)localObject2).da();
        if ((localObject2 != null) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(768);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (acff)this.app.getManager(51);
      if (localObject2 != null)
      {
        localObject4 = gg();
        localObject5 = new HashSet();
        this.app.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject4).size())
        {
          int j = 0;
          if (j < ((ArrayList)((List)localObject4).get(i)).size())
          {
            localObject6 = (DiscussionMemberInfo)((ArrayList)((List)localObject4).get(i)).get(j);
            localObject7 = ((DiscussionMemberInfo)localObject6).memberUin + ((DiscussionMemberInfo)localObject6).inteRemark + ((DiscussionMemberInfo)localObject6).memberName;
            if (((Set)localObject5).contains(localObject7)) {}
            for (;;)
            {
              j += 1;
              break;
              localFriends = ((acff)localObject2).b(((DiscussionMemberInfo)localObject6).memberUin);
              if ((localFriends == null) || (!localFriends.isFriend()))
              {
                ((Set)localObject5).add(localObject7);
                ((List)localObject1).add(new amoj(this.app, this.fromType, (DiscussionMemberInfo)localObject6));
              }
            }
          }
          i += 1;
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(4);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = ((acdu)this.app.getManager(53)).getDiscussList();
      if (localObject1 != null)
      {
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (DiscussionInfo)((Iterator)localObject4).next();
          localObject1 = null;
          localObject6 = aw();
          if (localObject6 != null) {
            localObject1 = (List)((Map)localObject6).get(((DiscussionInfo)localObject5).uin);
          }
          ((List)localObject2).add(new amoi(this.app, this.fromType, (DiscussionInfo)localObject5, (List)localObject1, dY(((DiscussionInfo)localObject5).uin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = ji(8);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject2).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = (TroopManager)this.app.getManager(52);
      localObject1 = new ArrayList();
      aizp.a().dn(this.app);
      localObject2 = ((TroopManager)localObject2).cE();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject2).next();
          ((List)localObject1).add(new amos(this.app, this.fromType, (TroopInfo)localObject4, dY(((TroopInfo)localObject4).troopuin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(16);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(new amor(this.app, this.fromType, String.valueOf(9993L), 6000, dY(String.valueOf(9993L))));
      ((List)localObject1).add(new amor(this.app, this.fromType, String.valueOf(9980L), 9000, dY(String.valueOf(9980L))));
      ((List)localObject1).add(new amor(this.app, this.fromType, String.valueOf(9994L), 5000, dY(String.valueOf(9994L))));
      ((List)localObject1).add(new amor(this.app, this.fromType, String.valueOf(9992L), 7000, dY(String.valueOf(9992L))));
      ((List)localObject1).add(new amor(this.app, this.fromType, String.valueOf(acbn.bkA), 4000, dY(String.valueOf(acbn.bkA))));
      localObject2 = this.app.a().a().q(true);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          switch (((RecentUser)localObject4).getType())
          {
          default: 
            break;
          case 5000: 
          case 7000: 
          case 9000: 
            if (!TextUtils.isEmpty(((RecentUser)localObject4).uin)) {
              ((List)localObject1).add(new amor(this.app, this.fromType, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), dY(((RecentUser)localObject4).uin)));
            }
            break;
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = new ArrayList();
      localObject1 = aw();
      if (localObject1 == null) {
        break label3061;
      }
    }
    label2646:
    label2792:
    label3061:
    for (Object localObject1 = (List)((Map)localObject1).get(this.caU);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        this.app.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject4 = (DiscussionMemberInfo)((List)localObject1).get(i);
          ((List)localObject2).add(new amoj(this.app, this.fromType, (DiscussionMemberInfo)localObject4));
          i += 1;
        }
        ((List)localObject3).addAll((Collection)localObject2);
      }
      if (((paramInt & 0x2000) != 0) || ((0x40000 & paramInt) != 0) || ((0x100000 & paramInt) != 0))
      {
        localObject4 = new ArrayList();
        localObject1 = this.app.a().createEntityManager();
        this.app.getCurrentAccountUin();
        localObject2 = ((EntityManager)localObject1).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.caU }, null, null, null, null);
        localObject5 = ((TroopManager)this.app.getManager(52)).b(this.caU);
        if (localObject5 == null)
        {
          localObject1 = "";
          if (localObject2 == null) {
            break label2792;
          }
          localObject6 = ((List)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject2 = (TroopMemberInfo)((Iterator)localObject6).next();
          } while ((!aqft.rl(((TroopMemberInfo)localObject2).memberuin)) || (((0x40000 & paramInt) != 0) && (localObject5 != null) && (!((TroopInfo)localObject5).isTroopAdmin(((TroopMemberInfo)localObject2).memberuin)) && (!((TroopInfo)localObject5).isTroopOwner(((TroopMemberInfo)localObject2).memberuin))));
          if ((0x100000 & paramInt) == 0) {
            break label2770;
          }
        }
        for (localObject2 = new amre(this.app, this.fromType, (TroopMemberInfo)localObject2, (String)localObject1);; localObject2 = new amot(this.app, this.fromType, (TroopMemberInfo)localObject2))
        {
          ((List)localObject4).add(localObject2);
          break label2646;
          localObject1 = ((TroopInfo)localObject5).troopcode;
          break;
        }
        ((List)localObject3).addAll((Collection)localObject4);
      }
      if ((0x80000 & paramInt) != 0)
      {
        l1 = System.currentTimeMillis();
        localObject1 = new ArrayList();
        localObject2 = (PhoneContactManagerImp)this.app.getManager(11);
        if (localObject2 != null)
        {
          localObject2 = ((PhoneContactManagerImp)localObject2).cU();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
            }
          }
        }
        ((List)localObject3).addAll((Collection)localObject1);
        l2 = System.currentTimeMillis();
        paramInt = ji(768);
        this.jdField_a_of_type_ArrayOfAmvg$c[paramInt].initTime = (l2 - l1);
        this.jdField_a_of_type_ArrayOfAmvg$c[paramInt].dDH = ((List)localObject1).size();
      }
      if ((this.cV != null) && (!this.cV.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ampt)((Iterator)localObject2).next();
          if (!this.cV.contains(((ampt)localObject3).getUin())) {
            ((List)localObject1).add(localObject3);
          }
        }
        return localObject1;
      }
      return localObject3;
    }
  }
  
  public void cancel()
  {
    synchronized (this.eE)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Gh.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        amvg.a locala = (amvg.a)localWeakReference.get();
        if (locala != null)
        {
          locala.setValue(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.Gh = localObject2;
    if (this.jdField_a_of_type_Amvk != null) {
      this.jdField_a_of_type_Amvk.cancel();
    }
    this.jdField_a_of_type_Amwe = null;
  }
  
  public void destroy()
  {
    if (this.ake != -1L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.type);
      if (this.ccj == null) {}
      for (String str = "";; str = this.ccj)
      {
        localHashMap.put("keyword", str);
        localHashMap.put("totalSize", String.valueOf(this.akg));
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
        {
          localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfAmvg$c[i].cck, String.valueOf(this.jdField_a_of_type_ArrayOfAmvg$c[i].akd));
          localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfAmvg$c[i].cck, String.valueOf(this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH));
          i += 1;
        }
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.akj));
      localHashMap.put("size_global_troop_member", String.valueOf(this.akh));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.akk));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.aki));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.ake, this.akf, localHashMap, "", false);
      if (this.cEp)
      {
        anot.a(this.app, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.cEp = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngineSearch", 2, "troopMemberSearchTime = " + this.akk + " ; troopMemberQueryTime = " + this.akj + " ; troopMemberTotalSize = " + this.aki + " ; troopMemberResultSize = " + this.akh);
      }
    }
    if (this.dDK > 0) {
      new anov(this.app).a("dc00899").b("Grp_listNew").c("search_result").d("exp_grp").a(new String[] { String.valueOf(this.dDK) }).report();
    }
  }
  
  public Comparator<ampt> f()
  {
    return null;
  }
  
  public void init()
  {
    long l1 = System.currentTimeMillis();
    this.Gg = ak(this.dCH);
    if (this.cEo)
    {
      this.jdField_a_of_type_Amvk = new amvk(this.app, this.fromType);
      this.jdField_a_of_type_Amvk.init();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.type + " ; cost time : " + (l2 - l1) + " ; size = " + this.Gg.size());
      if (cEn)
      {
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_a_of_type_ArrayOfAmvg$c[i].cck + " ; cost time : " + this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime + " ; size = " + this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH);
          i += 1;
        }
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.type);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAmvg$c.length)
    {
      localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfAmvg$c[i].cck, String.valueOf(this.jdField_a_of_type_ArrayOfAmvg$c[i].initTime));
      localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfAmvg$c[i].cck, String.valueOf(this.jdField_a_of_type_ArrayOfAmvg$c[i].dDH));
      i += 1;
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "ContactSearchEngineInit", true, l2 - l1, this.Gg.size(), localHashMap, "", false);
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public class a
  {
    boolean value;
    
    public a(boolean paramBoolean)
    {
      this.value = paramBoolean;
    }
    
    public boolean getValue()
    {
      try
      {
        boolean bool = this.value;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setValue(boolean paramBoolean)
    {
      try
      {
        this.value = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  class b
  {
    List<ampt> Gi;
    String keyword;
    
    public b(List<ampt> paramList)
    {
      this.keyword = paramList;
      Object localObject;
      this.Gi = localObject;
    }
  }
  
  public static class c
  {
    long akd;
    String cck;
    int dDH;
    long initTime;
    int type;
    
    public c(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.cck = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvg
 * JD-Core Version:    0.7.0.1
 */